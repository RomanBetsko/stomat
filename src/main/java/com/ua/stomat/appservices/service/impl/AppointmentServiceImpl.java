package com.ua.stomat.appservices.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ua.stomat.appservices.dao.AppointmentRepository;
import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.dao.DoctorRepository;
import com.ua.stomat.appservices.dao.ProcedureRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.entity.Doctor;
import com.ua.stomat.appservices.entity.Procedure;
import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.service.UtilsService;
import com.ua.stomat.appservices.utils.AdminInfo;
import com.ua.stomat.appservices.utils.CalendarEvent;
import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import com.ua.stomat.appservices.validator.ClientCriteria;
import com.ua.stomat.appservices.validator.ProcedureCriteria;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private ClientRepository clientRepository;
    private DoctorRepository doctorRepository;
    private ProcedureRepository procedureRepository;
    private AdminInfo adminInfo;
    private UtilsService utilsService;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ClientRepository clientRepository,
                                  DoctorRepository doctorRepository, ProcedureRepository procedureRepository,
                                  AdminInfo adminInfo, UtilsService utilsService) {
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
        this.doctorRepository = doctorRepository;
        this.procedureRepository = procedureRepository;
        this.adminInfo = adminInfo;
        this.utilsService = utilsService;
    }

    @Override
    @Transactional
    public ResponseEntity<?> addAppointment(AddAppointmentCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        Doctor doc = getDoctor();
        Appointment appointment = null;
        if(doc.getId() != null) {
            appointment = prepareAppointment(request, doc);
            appointmentRepository.save(appointment);
        }
        //adminInfo.addToCurrentAppointmentsList(appointment);
        result.setMsg(appointment.getAppointmentId().toString());
        return ResponseEntity.ok(result);
    }

    private Appointment prepareAppointment(AddAppointmentCriteria request, Doctor doc) {
        Appointment appointment = new Appointment();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom = simpleDateFormat.parse(request.getDateFrom());
            dateTo = simpleDateFormat.parse(request.getDateTo());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Client client = clientRepository.findByClientId(request.getClientId());
        appointment.setClient(client);
        appointment.setName(request.getName());
        appointment.setPrice(getTotalPrice(request.getProcedureCriteria()));
        if (dateFrom != null && dateTo != null) {
            appointment.setDateFrom(new Timestamp(dateFrom.getTime()));
            appointment.setDateTo(new Timestamp(dateTo.getTime()));
        }
        appointment.setDescription(request.getDescription());
        appointment.setClinic(request.getClinic());
        appointment.setDoctor(doc);
        appointment.setProcedures(prepareProcedures(request.getProcedureCriteria(), appointment));
        return appointment;
    }

    private Doctor getDoctor() {
        return doctorRepository.findById(1);
    }

    private List<Procedure> prepareProcedures(List<ProcedureCriteria> procedureCriteria, Appointment appointment) {
        List<Procedure> procedures = new ArrayList<>();
        for (ProcedureCriteria temp : procedureCriteria) {
            Procedure procedure = new Procedure();
            if (!procedureRepository.findAllByName(temp.getName()).isEmpty()) {
                for (Procedure prc : procedureRepository.findAllByName(temp.getName())) {
                    if (prc.getPrice().equals(temp.getPrice())) {
                        procedures.add(prc);
                    } else {
                        procedure.setName(temp.getName());
                        procedure.setPrice(temp.getPrice());
                        procedure.setDoctor(appointment.getDoctor());
                        procedures.add(procedure);
                    }
                }
            } else {
                procedure.setName(temp.getName());
                procedure.setPrice(temp.getPrice());
                procedure.setDoctor(appointment.getDoctor());
                procedures.add(procedure);
            }
        }
        return procedures;
    }


    private Integer getTotalPrice(List<ProcedureCriteria> procedures) {
        Integer totalPrice = 0;
        for (ProcedureCriteria procedure : procedures) {
            totalPrice = totalPrice + procedure.getPrice();
        }
        return totalPrice;
    }

    @Override
    public ModelAndView appointmentViewWithParams(Integer clientId) {
        Map<String, Object> params = new HashMap<>();
        Client client = clientRepository.findByClientId(clientId);
        params.put("client", client);
        return new ModelAndView("createappointment", params);
    }

    @Override
    public ModelAndView appointmentView() {
        Map<String, Object> params = new HashMap<>();
        params.put("clients", clientToClientCriteria(clientRepository.findAll()));
        return new ModelAndView("createappointment", params);
    }

    private List<ClientCriteria> clientToClientCriteria(List<Client> clientList) {
        return clientList.stream().map(client -> new ClientCriteria(client.getClientId(), client.getFirstName(), client.getSecondName())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteAppointment(Integer appointmentId, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId);
        adminInfo.deleteFromCurrentAppointmentsList(appointment);
        for (Procedure procedure : appointment.getProcedures()) {
            if (procedure.getAppointments().size() == 1) {
                procedureRepository.delete(procedure);
            } else {
                procedure.getAppointments().remove(appointment);
            }
        }
        appointmentRepository.delete(appointment);
        result.setMsg("Зустріч було видалено!");
        return ResponseEntity.ok(result);
    }

    @Override
    //todo refactor all of this
    public String getCalendarAppointments(HttpServletRequest request) {
        String jsonMsg = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy HH:mm");
        List<CalendarEvent> events = new ArrayList<>();
        for (Appointment appointment : adminInfo.getCurrentAppointments()) {
            CalendarEvent event = new CalendarEvent();
            event.setTitle(appointment.getName() + " / " + appointment.getDescription());
            event.setStart(simpleDateFormat.format(new Date(appointment.getDateFrom().getTime())));
            event.setEnd(simpleDateFormat.format(new Date(appointment.getDateTo().getTime())));
            event.setDescription(getDescription(appointment));
            event.setUrl(utilsService.getCurrentUrl(request) + "/admin/getAppointmentById?id=" + appointment.getAppointmentId());
            events.add(event);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonMsg;
    }

    private String getDescription(Appointment appointment) {
        List<Procedure> procedures = appointment.getProcedures();
        String htmlBr = "<br>";
        String proc = "";
        for (Procedure procedure : procedures) {
            proc = proc + procedure.getName() + ": " + procedure.getPrice() + htmlBr;
        }
        return appointment.getClient().getSecondName() + " " + appointment.getClient().getFirstName() + " " + appointment.getClient().getThirdName() + htmlBr +
                appointment.getClient().getPhone() + htmlBr +
                appointment.getClient().getEmail() + htmlBr + proc;
    }

    @Override
    public ModelAndView getAppointmentById(Integer appointmentId) {
        Map<String, Object> params = new HashMap<>();
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId);
        params.put("appointment", appointment);
        return new ModelAndView("singleappointment", params);
    }

}

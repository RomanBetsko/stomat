package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.AppointmentRepository;
import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.dao.ProcedureRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.entity.Procedure;
import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import com.ua.stomat.appservices.validator.ClientCriteria;
import com.ua.stomat.appservices.validator.ProcedureCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public ResponseEntity<?> addAppointment(AddAppointmentCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        Appointment appointment = appointmentRepository.save(prepareAppointment(request));
        result.setMsg(appointment.getAppointmentId().toString());
        return ResponseEntity.ok(result);
    }

    private Appointment prepareAppointment(AddAppointmentCriteria request) {
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
        //todo check this;
        appointment.setProcedures(prepareProcedures(request.getProcedureCriteria()));
        return appointment;
    }

    private List<Procedure> prepareProcedures(List<ProcedureCriteria> procedureCriteria) {
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
                        procedures.add(procedure);
                    }
                }
            } else {
                procedure.setName(temp.getName());
                procedure.setPrice(temp.getPrice());
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
    public ModelAndView appointmentViewWithParams(Integer clientId, String firstName, String secondName, String thirdName) {
        Map<String, Object> params = new HashMap<>();
        Client client = new Client();
        client.setClientId(clientId);
        client.setFirstName(firstName);
        client.setSecondName(secondName);
        client.setThirdName(thirdName);
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
}

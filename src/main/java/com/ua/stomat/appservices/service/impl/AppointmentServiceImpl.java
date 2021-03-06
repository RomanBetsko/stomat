package com.ua.stomat.appservices.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ua.stomat.appservices.dao.AppointmentRepository;
import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.dao.DoctorRepository;
import com.ua.stomat.appservices.dao.ProcedureRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.entity.Doctor;
import com.ua.stomat.appservices.entity.Procedure;
import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.service.EmailService;
import com.ua.stomat.appservices.service.UtilsService;
import com.ua.stomat.appservices.utils.CalendarEvent;
import com.ua.stomat.appservices.validator.*;
import lombok.AllArgsConstructor;
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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;
    private final DoctorRepository doctorRepository;
    private final ProcedureRepository procedureRepository;
    private final UtilsService utilsService;
    private final EmailService emailService;

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
        Doctor doctor = getDoctor();
        Appointment appointment = prepareAppointment(request, doctor);
        appointmentRepository.save(appointment);

        List<Appointment> appointments = doctor.getAppointments();
        appointments.add(appointment);
        doctor.setAppointments(appointments);
        doctor.setTotalAppointments(doctor.getTotalAppointments() + 1);

        doctorRepository.save(doctor);
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
        List<Procedure> proc = prepareProcedures(request.getProcedureCriteria(), appointment);
        appointment.setProcedures(proc);
        doc.setTotalProcedures(doc.getTotalProcedures() + proc.size());
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
                        procedure.setDescription(temp.getDescription());
                        procedure.setDoctor(appointment.getDoctor());
                        procedures.add(procedure);
                    }
                }
            } else {
                procedure.setName(temp.getName());
                procedure.setPrice(temp.getPrice());
                procedure.setDescription(temp.getDescription());
                procedure.setDoctor(appointment.getDoctor());
                procedures.add(procedure);
                procedureRepository.save(procedure);
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
    public ResponseEntity<?> updateAppointment(UpdateAppointmentCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        Appointment appointment = appointmentRepository.findByAppointmentId(request.getId());
        Doctor doctor = appointment.getDoctor();
        List<Procedure> proc = prepareProcedures(request.getProcedureCriteria(), appointment);
        appointment.setProcedures(proc);
        appointmentRepository.save(appointment);

        List<Appointment> appointments = doctor.getAppointments();
        appointments.add(appointment);
        doctor.setAppointments(appointments);
        doctor.setTotalAppointments(doctor.getTotalAppointments() + 1);

        doctorRepository.save(doctor);

        result.setMsg(appointment.getClient().getClientId().toString());
        return ResponseEntity.ok(result);
    }

    @Override
    public ModelAndView appointmentViewWithParams(Integer clientId) {
        Map<String, Object> params = new HashMap<>();
        Client client = clientRepository.findByClientId(clientId);
        List<Procedure> list = procedureRepository.findAll();

        Map<String, Integer> resultMap = new HashMap<>();
        list.forEach(procedure -> {
            if (resultMap.size() > 0 && resultMap.containsKey(procedure.getName())) {
                resultMap.put(procedure.getName(), procedure.getPrice());
            } else {
                resultMap.put(procedure.getName(), procedure.getPrice());
            }
        });
        List<ProcedureObj> procedures = resultMap.entrySet().stream()
                .map(entry -> new ProcedureObj(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        //з даного моменту на 3 місяці вперед
        List<Appointment> appointments = appointmentRepository.findByDateFromGreaterThanEqual(new Timestamp(new Date().getTime()));

        List<DateTimeIntervals> timeIntervals = new ArrayList<>();
        for (Appointment appointment : appointments) {
            DateTimeIntervals temp = new DateTimeIntervals();
            temp.setDateFrom(appointment.getDateFrom().toString());
            temp.setDateTo(appointment.getDateTo().toString());
            timeIntervals.add(temp);
        }
        Gson gson = new Gson();
        String json = gson.toJson(timeIntervals);
        params.put("client", client);
        params.put("procedures", procedures);
        params.put("disabledDates", json);
        return new ModelAndView("createappointment", params);
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
        Doctor doc = doctorRepository.findById(1);
        List<Appointment> appList = doc.getAppointments();
        List<Appointment> newAppList = appList.stream()
                .filter(app -> !app.getAppointmentId().equals(appointmentId))
                .collect(Collectors.toList());
        doc.setAppointments(newAppList);


        for (Procedure procedure : appointment.getProcedures()) {
            if (procedure.getAppointments().size() == 1) {
                procedureRepository.delete(procedure);
                doc.setTotalProcedures(doc.getTotalProcedures() - 1);
            } else {
                procedure.getAppointments().remove(appointment);
            }
        }
        appointmentRepository.delete(appointment);
        doc.setTotalAppointments(doc.getTotalAppointments() - 1);
        doctorRepository.save(doc);
        result.setMsg("Зустріч було видалено!");
        return ResponseEntity.ok(result);
    }

    @Override
    public String getCalendarAppointments(HttpServletRequest request) {
        String jsonMsg = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy HH:mm");
        List<CalendarEvent> events = new ArrayList<>();

        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.minusMonths(2);
        Date currentDateMinusTwoMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        List<Appointment> appointments = appointmentRepository.findByDateFromGreaterThanEqual(new Timestamp(currentDateMinusTwoMonths.getTime()));

        for (Appointment appointment : appointments) {
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

    @Override
    public List<StatisticData> getAppointmentsStatistic() {
        List<StatisticData> response = IntStream.range(0, 12)
                .mapToObj(i -> new StatisticData(0, 0))
                .collect(Collectors.toList());

        Date year2019start = new GregorianCalendar(2019, Calendar.FEBRUARY, 1).getTime();
        Date year2019end = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime();

        List<Appointment> appointmentsData2019 = appointmentRepository.findByDateFromGreaterThanEqualAndDateFromLessThanEqual
                (new Timestamp(year2019start.getTime()), new Timestamp(year2019end.getTime()));

        Date year2020start = new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime();
        Date year2020end = new GregorianCalendar(2020, Calendar.DECEMBER, 31).getTime();

        List<Appointment> appointmentsData2020 = appointmentRepository.findByDateFromGreaterThanEqualAndDateFromLessThanEqual
                (new Timestamp(year2020start.getTime()), new Timestamp(year2020end.getTime()));

        appointmentsData2019.forEach(data -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data.getDateFrom());
            int m = calendar.get(Calendar.MONTH);
            StatisticData temp = response.get(m);
            temp.setA(temp.getA() + 1);
            response.set(m, temp);
        });
        appointmentsData2020.forEach(data -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data.getDateFrom());
            int m = calendar.get(Calendar.MONTH);
            StatisticData temp = response.get(m);
            temp.setB(temp.getB() + 1);
            response.set(m, temp);
        });
        return response;
    }

    @Override
    public List<EarnGraph> getEarnStatistic() {
        List<EarnGraph> response = new ArrayList<>();
        IntStream.range(0, 58).forEachOrdered(i -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.WEEK_OF_YEAR, i + 46);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            String weekStart = sdf.format(cal.getTime());
            response.add(new EarnGraph(weekStart, 0));
        });

        Date year2019 = new GregorianCalendar(2019, Calendar.NOVEMBER, 1).getTime();
        Date year2019end = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime();

        Date year2020start = new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime();
        Date year2020end = new GregorianCalendar(2020, Calendar.DECEMBER, 31).getTime();

        List<Appointment> sortedAppointments2019 = appointmentRepository.findByDateFromGreaterThanEqualAndDateFromLessThanEqual
                (new Timestamp(year2019.getTime()), new Timestamp(year2019end.getTime())).stream()
                .sorted(Comparator.comparing(Appointment::getDateFrom))
                .collect(Collectors.toList());

        List<Appointment> sortedAppointments2020 = appointmentRepository.findByDateFromGreaterThanEqualAndDateFromLessThanEqual
                (new Timestamp(year2020start.getTime()), new Timestamp(year2020end.getTime())).stream()
                .sorted(Comparator.comparing(Appointment::getDateFrom))
                .collect(Collectors.toList());

        for (Appointment appointment : sortedAppointments2019) {
            Calendar c = Calendar.getInstance();
            c.setTime(appointment.getDateFrom());
            response.set(c.get(Calendar.WEEK_OF_YEAR) - 46, new EarnGraph(response.get(c.get(Calendar.WEEK_OF_YEAR) - 46).getY(),
                    response.get(c.get(Calendar.WEEK_OF_YEAR) - 46).getItem1() + appointment.getPrice()));
        }

        for (Appointment appointment : sortedAppointments2020) {
            Calendar c = Calendar.getInstance();
            c.setTime(appointment.getDateFrom());

            response.set(c.get(Calendar.WEEK_OF_YEAR) + 6, new EarnGraph(response.get(c.get(Calendar.WEEK_OF_YEAR) + 6).getY(),
                    response.get(c.get(Calendar.WEEK_OF_YEAR) + 6).getItem1() + appointment.getPrice()));
        }
        return response;
    }

    @Override
    public List<ProcedureGraph> getProcedureStatistic() {
        List<Procedure> procedures = procedureRepository.findAll();
        Map<String, Integer> resultMap = new HashMap<>();
//        for (Procedure procedure : procedures) {
//            if (resultMap.size() > 0 && resultMap.containsKey(procedure.getName() + " | " + procedure.getPrice())) {
//                Integer number = resultMap.get(procedure.getName() + " | " + procedure.getPrice());
//                number = number + 1;
//                resultMap.put(procedure.getName() + " | " + procedure.getPrice(), number);
//            } else {
//                resultMap.put(procedure.getName() + " | " + procedure.getPrice(), procedure.getAppointments().size());
//            }
//        }
        for(Procedure procedure : procedures){
            resultMap.put(procedure.getName() + " | " + procedure.getPrice(), procedure.getAppointments().size());
        }
        List<ProcedureGraph> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            ProcedureGraph procedureGraph = new ProcedureGraph(entry.getKey(), entry.getValue());
            list.add(procedureGraph);
        }
        return list;
    }

    @Override
    public List<NewClientsGraph> getNewClientsStatistic() {
        List<Client> clients = clientRepository.findAll();
        Map<String, Integer> resultMap = new HashMap<>();
        for (Client cln : clients) {
            if (resultMap.size() > 0 && resultMap.containsKey(cln.getResource())) {
                Integer number = resultMap.get(cln.getResource());
                number = number + 1;
                resultMap.put(cln.getResource(), number);
            } else {
                resultMap.put(cln.getResource(), 1);
            }
        }
        return resultMap.entrySet().stream()
                .map(entry -> new NewClientsGraph(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public ModelAndView newAppointment(NewAppointmentCriteria request) {
        AjaxResponseBody result = new AjaxResponseBody();

        emailService.newAppointmentMessage(request.getFirstName(), request.getLastName(), request.getDate(), request.getTime(), request.getPhone());

        result.setMsg("Ваша запись отриимана. З вами звяжуться у найближчий час. Дякуємо!");
        return new ModelAndView("clientsToInform", new HashMap<>());
    }

}

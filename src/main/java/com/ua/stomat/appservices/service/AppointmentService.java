package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.validator.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Service
public interface AppointmentService {

    ResponseEntity<?> addAppointment(AddAppointmentCriteria request, Errors errors);

    ModelAndView appointmentViewWithParams(Integer clientId);

    ResponseEntity<?> deleteAppointment(Integer id, Errors errors);

    String getCalendarAppointments(HttpServletRequest httpServletRequest);

    ModelAndView getAppointmentById(Integer id);

    List<StatisticData> getAppointmentsStatistic();

    List<EarnGraph> getEarnStatistic();

    List<ProcedureGraph> getProcedureStatistic();

    List<NewClientsGraph> getNewClientsStatistic();
}

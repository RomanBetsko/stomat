package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import com.ua.stomat.appservices.validator.ClientCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Service
public interface AppointmentService {

    ResponseEntity<?> addAppointment(AddAppointmentCriteria request, Errors errors);

    ModelAndView appointmentViewWithParams(Integer clientId);

    ModelAndView appointmentView();

    ResponseEntity<?> deleteAppointment(Integer id, Errors errors);

    String getCalendarAppointments(HttpServletRequest httpServletRequest);

    ModelAndView getAppointmentById(Integer id);
}

package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import com.ua.stomat.appservices.validator.ClientCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Service
public interface AppointmentService {

    ResponseEntity<?> addAppointment(AddAppointmentCriteria request, Errors errors);

    ModelAndView appointmentViewWithParams(Integer clientId, String firstName, String secondName, String thirdName);

    ModelAndView appointmentView();
}

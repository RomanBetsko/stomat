package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.validation.Valid;

@Service
public interface AppointmentService {

    ResponseEntity<?> addAppointment(AddAppointmentCriteria request, Errors errors);
}

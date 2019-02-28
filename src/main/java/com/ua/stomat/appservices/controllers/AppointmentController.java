package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AppointmentController {

    private static final String ADMIN_PATH = "/admin";

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(ADMIN_PATH + "/addNewAppointment")
    public ResponseEntity<?> addNewAppointment(@RequestBody @Valid AddAppointmentCriteria request, Errors errors) {
        return appointmentService.addAppointment(request, errors);
    }
}

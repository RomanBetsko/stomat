package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class RestWebController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = "/all")
    public String getEvents() {
        return appointmentService.getCalendarAppointments();
    }

}

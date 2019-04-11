package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import com.ua.stomat.appservices.validator.DeleteAppointmentCriteria;
import com.ua.stomat.appservices.validator.DeleteClientCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AppointmentController {

    private static final String ADMIN_PATH = "/admin";

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(ADMIN_PATH + "/appointmentViewByClient")
    public ModelAndView appointmentViewWithParams(@RequestParam(name = "id") Integer id) {
        return appointmentService.appointmentViewWithParams(id);
    }

    @GetMapping(ADMIN_PATH + "/appointment")
    public ModelAndView appointmentView() {
        return appointmentService.appointmentView();
    }

    @PostMapping(ADMIN_PATH + "/appointment/create")
    public ResponseEntity<?> addNewAppointment(@RequestBody @Valid AddAppointmentCriteria request, Errors errors) {
        return appointmentService.addAppointment(request, errors);
    }

    @PostMapping(ADMIN_PATH + "/delete/appointment")
    public ResponseEntity<?> deleteAppointment(@RequestBody @Valid DeleteAppointmentCriteria request, Errors errors) {
        return appointmentService.deleteAppointment(request.getId(), errors);
    }

    @GetMapping(ADMIN_PATH + "/getAppointmentById")
    public ModelAndView getAppointmentById(@RequestParam(name = "id") Integer id){
        return appointmentService.getAppointmentById(id);
    }
}

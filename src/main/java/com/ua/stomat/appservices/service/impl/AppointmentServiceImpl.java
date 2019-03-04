package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.AppointmentRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.validator.AddAppointmentCriteria;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

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
        return null;
    }
}

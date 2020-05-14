package com.ua.stomat.appservices.service;

public interface EmailService {

    void newAppointmentMessage(String firstName, String lastName, String date, String time, String phone);

}

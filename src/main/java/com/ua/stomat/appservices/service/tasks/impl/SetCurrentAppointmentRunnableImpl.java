package com.ua.stomat.appservices.service.tasks.impl;

import com.ua.stomat.appservices.service.TaskService;
import com.ua.stomat.appservices.service.tasks.SetCurrentAppointmentsRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SetCurrentAppointmentRunnableImpl implements TaskService {

    @Autowired
    private SetCurrentAppointmentsRunnable setCurrentAppointmentsRunnable;


    @Override
    @Scheduled(fixedRate = 200000) //will run every 200 sec

    //todo фікс зис
    public void checkAppointments() {
        new Thread(setCurrentAppointmentsRunnable).start();
    }
}

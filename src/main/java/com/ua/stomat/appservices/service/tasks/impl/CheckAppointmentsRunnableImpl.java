package com.ua.stomat.appservices.service.tasks.impl;

import com.ua.stomat.appservices.service.tasks.CheckAppointmentsRunnable;
import com.ua.stomat.appservices.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class CheckAppointmentsRunnableImpl implements TaskService {

    @Autowired
    private CheckAppointmentsRunnable checkAppointmentsRunnable;


    @Override
//    @Scheduled(cron = "0 0 1 * * ?") //will run at 1 a.m every day
    @Scheduled(fixedRate=20000) //will run every 20 sec

    //todo not forget about it
    public void checkAppointments() {
        new Thread(checkAppointmentsRunnable).start();
    }
}

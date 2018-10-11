package com.ua.book.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServiceImpl {

    @Autowired
    private CheckYearOfPublicationRunnable checkYearOfPublicationRunnable;

    @Scheduled(cron = "0 0 1 * * ?") //will run at 1 a.m every day
    public void checkSubscription() {
        new Thread(checkYearOfPublicationRunnable).start();
    }

}

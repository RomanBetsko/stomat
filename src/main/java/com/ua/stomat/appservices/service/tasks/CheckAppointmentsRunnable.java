package com.ua.stomat.appservices.service.tasks;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class CheckAppointmentsRunnable implements Runnable {

    @Autowired
    private ClientRepository clientRepository;

    public void run() {

        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            Appointment lastAppointment = client.getAppointments().get(0);

            Date currentDate = new Date();
            LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            localDateTime = localDateTime.minusMonths(6);
            Date currentDateMinusSixMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

            if (currentDateMinusSixMonths.after(new Date(lastAppointment.getDateTo().getTime()))) {
                //todo send email
                //todo set admin status
            }

        }
    }
}

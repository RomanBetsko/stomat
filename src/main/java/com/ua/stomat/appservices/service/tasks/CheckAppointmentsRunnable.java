package com.ua.stomat.appservices.service.tasks;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.utils.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CheckAppointmentsRunnable implements Runnable {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdminInfo adminInfo;

    @Override
    public void run() {

        List<Client> clients = clientRepository.findAll();
        List<Client> temp = new ArrayList<>();
        if (!adminInfo.getClientsToInform().isEmpty()) {
            // refreshed ClientsToInform data with new appointments
            adminInfo.refreshData();
            temp = adminInfo.getClientsToInform();
        }

        Date currentDate = new Date();
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.minusDays(1);
        Date currentDateMinusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        localDateTime = localDateTime.minusMonths(6).plusDays(1);
        Date currentDateMinusSixMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        for (Client client : clients) {
            //todo fix this
            if (!client.getAppointments().isEmpty()) {
                Appointment lastAppointment = client.getAppointments().get(0);


                if (currentDateMinusSixMonths.after(new Date(lastAppointment.getDateTo().getTime()))) {
                    for (Client cln : temp) {
                        if (cln.equals(client)) {
                            temp.add(client);
                            System.out.println("Client added to clients1ToInform list");
                        }
                    }
                    if (temp.isEmpty()) {
                        temp.add(client);
                        System.out.println("Client added to clients1ToInform list");
                    }
                }
            }
        }

        // for avoid ConcurrentModificationException
        List<Client> listToRemove = new ArrayList<>();
        for (Client clientToInform : temp) {
            Appointment lastAppointment = clientToInform.getAppointments().get(0);
            if (currentDateMinusOneDay.before(new Date(lastAppointment.getDateFrom().getTime()))) {
                listToRemove.add(clientToInform);
                System.out.println("Client was deleted from clients1ToInform list");
            }
        }
        temp.removeAll(listToRemove);
        //todo send email
        adminInfo.setClientsToInform(temp);
    }
}

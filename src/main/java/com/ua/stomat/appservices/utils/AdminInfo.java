package com.ua.stomat.appservices.utils;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminInfo implements Serializable {

    private final ClientRepository clientRepository;

    private List<Client> clientsToInform;
    private List<Appointment> currentAppointments;
    private List<String> history;

    public AdminInfo(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClientsToInform() {
        if (clientsToInform == null) {
            return new ArrayList<>();
        } else {
            return clientsToInform;
        }
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public void setClientsToInform(List<Client> clientsToInform) {
        this.clientsToInform = clientsToInform;
    }

    public List<Appointment> getCurrentAppointments() {
        return currentAppointments;
    }

    public void setCurrentAppointments(List<Appointment> currentAppointments) {
        this.currentAppointments = currentAppointments;
    }

    public void addToCurrentAppointmentsList(Appointment appointment) {
        if (currentAppointments == null) {
            currentAppointments = new ArrayList<>();
        }
        currentAppointments.add(appointment);
    }

    public void deleteFromCurrentAppointmentsList(Appointment appointment) {
        //todo подумати як оптимізувати це разом з CheckAppointmentsRunnable for avoid ConcurrentModificationException line
        List<Appointment> listToRemove = this.currentAppointments.stream()
                .filter(app -> appointment.getAppointmentId().equals(app.getAppointmentId())).collect(Collectors.toList());

        this.currentAppointments.removeAll(listToRemove);
    }

    public void refreshData() {
        List<Client> clientList = new ArrayList<>();
        for (Client client : clientsToInform) {
            Client refreshedClient = clientRepository.findByClientId(client.getClientId());
            clientList.add(refreshedClient);
        }
        clientsToInform = clientList;
    }
}

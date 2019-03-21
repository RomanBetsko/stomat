package com.ua.stomat.appservices.utils;

import com.ua.stomat.appservices.entity.Client;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


@Service
public class AdminInfo implements Serializable {

    private List<Client> clientsToInform;

    public List<Client> getClientsToInform() {
        return clientsToInform;
    }

    public void setClientsToInform(List<Client> clientsToInform) {
        this.clientsToInform = clientsToInform;
    }
}

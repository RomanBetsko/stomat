package com.ua.stomat.appservices.utils;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminInfo implements Serializable {

    @Autowired
    private ClientRepository clientRepository;

    private List<Client> clientsToInform;

    public List<Client> getClientsToInform() {
        if (clientsToInform == null) {
            return new ArrayList<>();
        } else {
            return clientsToInform;
        }
    }

    public void setClientsToInform(List<Client> clientsToInform) {
        this.clientsToInform = clientsToInform;
    }

    public void refreshData() {
        List<Client> clientList = new ArrayList<>();
        for (Client client : clientsToInform) {
            Client refreshedClient = clientRepository.findByClientId(client.getClientId());
            clientList.add(refreshedClient);
        }
        clientsToInform = clientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminInfo)) return false;

        AdminInfo adminInfo = (AdminInfo) o;

        return getClientsToInform() != null ? getClientsToInform().equals(adminInfo.getClientsToInform()) : adminInfo.getClientsToInform() == null;

    }

    @Override
    public int hashCode() {
        return getClientsToInform() != null ? getClientsToInform().hashCode() : 0;
    }
}

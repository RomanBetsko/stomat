package com.ua.stomat.appservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "client_appointments")
public class ClientAppointments implements Serializable{

    private static final long serialVersionUID = 44L;

    @Id
    @Column(name = "clientId", nullable = false)
    private int clientId;
    @Id
    @Column(name = "appointmentId", nullable = false)
    private int appointmentId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
}

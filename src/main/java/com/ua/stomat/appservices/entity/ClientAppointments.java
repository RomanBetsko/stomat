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

    public ClientAppointments() {
    }

    public ClientAppointments(int clientId, int appointmentId) {
        this.clientId = clientId;
        this.appointmentId = appointmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientAppointments)) return false;

        ClientAppointments that = (ClientAppointments) o;

        if (getClientId() != that.getClientId()) return false;
        return getAppointmentId() == that.getAppointmentId();

    }

    @Override
    public int hashCode() {
        int result = getClientId();
        result = 31 * result + getAppointmentId();
        return result;
    }
}

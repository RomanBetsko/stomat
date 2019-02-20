package com.ua.stomat.appservices.validator;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;


public class AddAppointmentCriteria implements Serializable {


    private String clientId;
    private @NotEmpty(message = "Не вказано дата!") Date date;
    @NotEmpty(message = "Не вказаний час")
    private String time;

    public AddAppointmentCriteria() {
    }

    public AddAppointmentCriteria(String clientId, @NotEmpty(message = "Не вказано дата!") Date date, @NotEmpty(message = "Не вказаний час") String time) {
        this.clientId = clientId;
        this.date = date;
        this.time = time;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddAppointmentCriteria)) return false;

        AddAppointmentCriteria that = (AddAppointmentCriteria) o;

        return getClientId().equals(that.getClientId()) && getDate().equals(that.getDate()) && getTime().equals(that.getTime());

    }

    @Override
    public int hashCode() {
        int result = getClientId().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getTime().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AddAppointmentCriteria{" +
                "clientId='" + clientId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

package com.ua.stomat.appservices.validator;


public class ClientProcedureCriteria {

    private Integer clientId;
    private Integer appointmentId;

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getCustomerId() {
        return clientId;
    }

    public void setCustomerId(Integer customerId) {
        this.clientId = customerId;
    }

    public ClientProcedureCriteria(Integer customerId, Integer appointmentId) {
        this.clientId = customerId;
        this.appointmentId = appointmentId;
    }

    public ClientProcedureCriteria() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientProcedureCriteria)) return false;

        ClientProcedureCriteria that = (ClientProcedureCriteria) o;

        if (getCustomerId() != null ? !getCustomerId().equals(that.getCustomerId()) : that.getCustomerId() != null)
            return false;
        return getAppointmentId() != null ? getAppointmentId().equals(that.getAppointmentId()) : that.getAppointmentId() == null;

    }

    @Override
    public int hashCode() {
        int result = getCustomerId() != null ? getCustomerId().hashCode() : 0;
        result = 31 * result + (getAppointmentId() != null ? getAppointmentId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientProcedureCriteria{" +
                "customerId=" + clientId +
                ", appointmentId=" + appointmentId +
                '}';
    }
}

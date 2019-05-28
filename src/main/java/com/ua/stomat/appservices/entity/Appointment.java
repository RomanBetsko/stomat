package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "date_from")
    private Timestamp dateFrom;
    @Column(name = "date_to")
    private Timestamp dateTo;
    @Column(name = "description")
    private String description;
    @Column(name = "clinic", nullable = false)
    private String clinic;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "appointment_procedure",
            joinColumns = {@JoinColumn(name = "appointment_id")},
            inverseJoinColumns = {@JoinColumn(name = "procedure_id")}
    )
    private List<Procedure> procedures;

    public Appointment() {
    }

    public Appointment(String name, Integer price, Timestamp dateFrom, Timestamp dateTo, String description, String clinic, Client client, List<Procedure> procedures) {
        this.name = name;
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.clinic = clinic;
        this.client = client;
        this.procedures = procedures;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;

        Appointment that = (Appointment) o;

        if (getAppointmentId() != null ? !getAppointmentId().equals(that.getAppointmentId()) : that.getAppointmentId() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getPrice() != null ? !getPrice().equals(that.getPrice()) : that.getPrice() != null) return false;
        if (getDateFrom() != null ? !getDateFrom().equals(that.getDateFrom()) : that.getDateFrom() != null)
            return false;
        if (getDateTo() != null ? !getDateTo().equals(that.getDateTo()) : that.getDateTo() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getClinic() != null ? !getClinic().equals(that.getClinic()) : that.getClinic() != null) return false;
        if (getClient() != null ? !getClient().equals(that.getClient()) : that.getClient() != null) return false;
        return getProcedures() != null ? getProcedures().equals(that.getProcedures()) : that.getProcedures() == null;

    }

    @Override
    public int hashCode() {
        int result = getAppointmentId() != null ? getAppointmentId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getDateFrom() != null ? getDateFrom().hashCode() : 0);
        result = 31 * result + (getDateTo() != null ? getDateTo().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getClinic() != null ? getClinic().hashCode() : 0);
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        result = 31 * result + (getProcedures() != null ? getProcedures().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", description='" + description + '\'' +
                ", clinic='" + clinic + '\'' +
                ", client=" + client +
                ", procedures=" + procedures +
                '}';
    }
}

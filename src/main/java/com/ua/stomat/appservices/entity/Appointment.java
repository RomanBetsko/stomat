package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
//    @ManyToMany(mappedBy = "appointments", fetch = FetchType.EAGER)
//    private Set<Client> client = new HashSet<>();

//    @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "procedure_id",
//            joinColumns = { @JoinColumn(name = "appointment_id") },
//            inverseJoinColumns = { @JoinColumn(name = "procedure_id") }
//    )
//    private Set<Procedure> procedures = new HashSet<>();

    public Appointment() {
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

    public Date getDateFrom() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date temp = null;
//        try {
//            String asdasdasd = simpleDateFormat.format(date);
//            DatesimpleDateFormat.parse(asdasdasd);
//
//
//            temp = simpleDateFormat.parse(simpleDateFormat.format(date));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return dateFrom;
    }

    public Date getDateTo() {
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

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Appointment(String name, Integer price, Timestamp dateFrom, Timestamp dateTo, String description, Client client) {
        this.name = name;
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    //
//    public Set<Procedure> getProcedures() {
//        return procedures;
//    }
//
//    public void setProcedures(Set<Procedure> procedures) {
//        this.procedures = procedures;
//    }
}

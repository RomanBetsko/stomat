package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name="clientId", nullable=false)
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

    public Appointment(){}



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

    public Appointment(String name, Integer price, Client client) {
        this.name = name;
        this.price = price;
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

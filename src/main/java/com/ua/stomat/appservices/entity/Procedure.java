package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "proc")
public class Procedure implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer procedureId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToMany(mappedBy = "procedures", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Appointment> appointments;


    public Procedure(String name, Integer price, Doctor doctor, List<Appointment> appointments) {
        this.name = name;
        this.price = price;
        this.doctor = doctor;
        this.appointments = appointments;
    }

    public Procedure() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return procedureId;
    }

    public void setId(Integer id) {
        this.procedureId = id;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureId=" + procedureId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", doctor='" + doctor + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}

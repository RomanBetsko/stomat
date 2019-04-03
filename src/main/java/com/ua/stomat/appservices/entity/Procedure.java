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
    private Integer procedure_id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToMany(mappedBy = "procedures", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Appointment> appointments;


    public Procedure(String name, Integer price, List<Appointment> appointments) {
        this.name = name;
        this.price = price;
        this.appointments = appointments;
    }

    public Procedure() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return procedure_id;
    }

    public void setId(Integer id) {
        this.procedure_id = id;
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

    @Override
    public String toString() {
        return "ProcedureCriteria{" +
                "id=" + procedure_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", appointments=" + appointments +
                '}';
    }
}

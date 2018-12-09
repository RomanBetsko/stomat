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
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToMany(mappedBy = "appointments", fetch = FetchType.EAGER)
    private Set<Client> clients = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "procedure_id",
            joinColumns = { @JoinColumn(name = "appointment_id") },
            inverseJoinColumns = { @JoinColumn(name = "procedure_id") }
    )
    private Set<Procedure> procedures = new HashSet<>();

    public Appointment(String name, Integer price, Set<Client> clients, Set<Procedure> procedures) {
        this.name = name;
        this.price = price;
        this.clients = clients;
        this.procedures = procedures;
    }

    public Appointment(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "procedures=" + procedures +
                ", clients=" + clients +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

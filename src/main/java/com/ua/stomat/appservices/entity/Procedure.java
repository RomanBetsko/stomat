package com.ua.stomat.appservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "proc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedure implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer procedureId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "description", nullable = false)
    private String description;


    @ManyToOne
    @JoinColumn(name = "doctor", nullable = false)
    private Doctor doctor;

    @ManyToMany(mappedBy = "procedures", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Appointment> appointments;

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureId=" + procedureId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", doctor=" + doctor +
                ", appointments=" + appointments +
                '}';
    }
}

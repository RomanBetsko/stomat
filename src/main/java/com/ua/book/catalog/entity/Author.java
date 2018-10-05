package com.ua.book.catalog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    private static final long serialVersionUID = 2L;

    public Author(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "secondName", nullable = false)
    private String secondName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "country", nullable = false)
    private String country;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Author(String firstName, String secondName, String email, String country, Set<Book> books) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.country = country;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

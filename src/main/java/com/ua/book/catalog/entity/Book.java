package com.ua.book.catalog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "yearOfPublication", nullable = false)
    private Timestamp  yearOfPublication;
    @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_books",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "orderbooks",
            joinColumns = { @JoinColumn(name = "bookid") },
            inverseJoinColumns = { @JoinColumn(name = "readerid") }
    )
    private Set<Reader> readers = new HashSet<>();

    public Book(){}

    public Book(String name, int price, String description, Timestamp yearOfPublication, Set<Author> authors, Set<Reader> readers) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.yearOfPublication = yearOfPublication;
        this.authors = authors;
        this.readers = readers;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Timestamp yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

}

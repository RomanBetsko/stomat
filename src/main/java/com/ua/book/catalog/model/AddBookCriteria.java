package com.ua.book.catalog.model;

import org.hibernate.validator.constraints.NotBlank;

import java.sql.Date;


public class AddBookCriteria {

    @NotBlank(message = "name can't empty!")
    private String name;
    @NotBlank(message = "name can't empty!")
    private int price;
    @NotBlank(message = "name can't empty!")
    private String description;
    @NotBlank(message = "name can't empty!")
    private Date yearOfPublication;
    @NotBlank(message = "name can't empty!")
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
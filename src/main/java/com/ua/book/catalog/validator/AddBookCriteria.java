package com.ua.book.catalog.validator;

import org.hibernate.validator.constraints.NotBlank;

import java.sql.Date;
import java.util.List;


public class AddBookCriteria {

    @NotBlank(message = "name can't empty!")
    private String name;
    private int price;
    @NotBlank(message = "description can't empty!")
    private String description;
    private Date yearOfPublication;
    private List<String> authors;

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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
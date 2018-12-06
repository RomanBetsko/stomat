package com.ua.stomat.appservices.validator;

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
    private int addedBy;
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

    public String getDescription() {
        return description;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public int getAddedBy() {
        return addedBy;
    }
}
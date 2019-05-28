package com.ua.stomat.appservices.validator;

public class ProcedureCriteria {
    private Integer id;
    private String name;
    private Integer price;
    private String doctor;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public ProcedureCriteria(Integer id, String name, Integer price, String doctor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.doctor = doctor;
    }

    public ProcedureCriteria() {
    }
}
package com.ua.stomat.appservices.validator;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.sql.Date;


public class AddClientCriteria implements Serializable{

    @NotBlank(message = "name can't empty!")
    private String firstName;
    private String secondName;
    private String thirdName;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String sex;

    public AddClientCriteria() {
    }

    public AddClientCriteria(@NotBlank(message = "name can't empty!") String firstName, String secondName, String thirdName, String email, String phone, Date dateOfBirth, String sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
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

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
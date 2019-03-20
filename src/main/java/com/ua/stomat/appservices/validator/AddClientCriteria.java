package com.ua.stomat.appservices.validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

public class AddClientCriteria implements Serializable {

    @NotEmpty(message = "Не вказано ім'я!")
    private String firstName;
    @NotEmpty(message = "Не вказано прізвище!")
    private String secondName;
    @NotEmpty(message = "Не вказано по-батькові!")
    private String thirdName;
    @Email(message = "Не вірний email!")
    private String email;
    @NotEmpty(message = "Не вказаний телефон!")
    private String phone;
    private String dateOfBirth;
    private String sex;

    public AddClientCriteria() {
    }

    public AddClientCriteria(@NotEmpty(message = "Не вказано ім'я!") String firstName, @NotEmpty(message = "Не вказано прізвище!") String secondName,
                             @NotEmpty(message = "Не вказано по-батькові!") String thirdName, String email, @NotEmpty(message = "Не вказаний телефон!") String phone,
                             String dateOfBirth, String sex) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddClientCriteria)) return false;

        AddClientCriteria that = (AddClientCriteria) o;

        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(that.getSecondName()) : that.getSecondName() != null)
            return false;
        if (getThirdName() != null ? !getThirdName().equals(that.getThirdName()) : that.getThirdName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) return false;
        return getDateOfBirth() != null ? getDateOfBirth().equals(that.getDateOfBirth()) : that.getDateOfBirth() == null
                && (getSex() != null ? getSex().equals(that.getSex()) : that.getSex() == null);

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getThirdName() != null ? getThirdName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddClientCriteria{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                '}';
    }
}
package com.ua.stomat.appservices.validator;

import java.io.Serializable;
import java.util.Date;


public class ClientCriteria implements Serializable {

    private Integer clientId;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String email;
    private String phone;
    private String sex;
    private Date dateOfBirth;
    private Integer totalEarn;

    public ClientCriteria() {
    }

    public ClientCriteria(Integer clientId, String firstName, String secondName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public ClientCriteria(Integer clientId, String firstName, String secondName, String thirdName, String email, String phone, String sex, Date dateOfBirth, Integer totalEarn) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.totalEarn = totalEarn;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getTotalEarn() {
        return totalEarn;
    }

    public void setTotalEarn(Integer totalEarn) {
        this.totalEarn = totalEarn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientCriteria)) return false;

        ClientCriteria that = (ClientCriteria) o;

        if (getClientId() != null ? !getClientId().equals(that.getClientId()) : that.getClientId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(that.getSecondName()) : that.getSecondName() != null)
            return false;
        if (getThirdName() != null ? !getThirdName().equals(that.getThirdName()) : that.getThirdName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) return false;
        if (getSex() != null ? !getSex().equals(that.getSex()) : that.getSex() != null) return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(that.getDateOfBirth()) : that.getDateOfBirth() != null)
            return false;
        return getTotalEarn() != null ? getTotalEarn().equals(that.getTotalEarn()) : that.getTotalEarn() == null;

    }

    @Override
    public int hashCode() {
        int result = getClientId() != null ? getClientId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getThirdName() != null ? getThirdName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getTotalEarn() != null ? getTotalEarn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientCriteria{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", totalEarn=" + totalEarn +
                '}';
    }
}

package com.ua.stomat.appservices.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

import static java.time.LocalDate.now;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(name = "third_name", nullable = false)
    private String thirdName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "sex", nullable = false)
    private String sex;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "total_earn", nullable = false)
    private Integer totalEarn;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Appointment> appointments;

    public Client() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public List<Appointment> getAppointments() {
        Collections.sort(appointments, (p1, p2) -> Long.valueOf(p2.getDateFrom().getTime()).compareTo(p1.getDateFrom().getTime()));
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Integer getTotalEarn() {
        if (totalEarn == null){
            return 0;
        }
        return totalEarn;
    }

    public void setTotalEarn(Integer totalEarn) {
        this.totalEarn = totalEarn;
    }

    public Integer clientAge() {
        LocalDate currentDate = now();
        LocalDate birthDate = getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }


    public Date getDateOfBirth() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");
        dateformat.format(dateOfBirth);
        return dateOfBirth;
    }

    public Integer rank() {
        List<Appointment> appointments = getAppointments();
        if(appointments.isEmpty()){
            return 0;
        }
        Integer totalEarn = 0;
        for(Appointment appointment : appointments){
            totalEarn = totalEarn + appointment.getPrice();
        }
        return totalEarn / getAppointments().size();
    }

    public Integer appointmentsSize() {
        if (getAppointments().isEmpty()) {
            return 0;
        } else {
            return getAppointments().size();
        }
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

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
    //    @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "client_appointments",
//            joinColumns = { @JoinColumn(name = "clientId") },
//            inverseJoinColumns = { @JoinColumn(name = "appoinmentId") }
//    )

//    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = {CascadeType.ALL})
    private Set<Appointment> appointments;

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

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
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
        return dateOfBirth;
    }

    public Integer rank() {
        if (getTotalEarn().equals(0) || getAppointments().isEmpty()) {
            return 0;
        }
        return getTotalEarn() / getAppointments().size();
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

    public Client(String firstName, String secondName, String thirdName, String email, String phone, String sex, Date dateOfBirth, Set<Appointment> appointments) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.appointments = appointments;
    }
}

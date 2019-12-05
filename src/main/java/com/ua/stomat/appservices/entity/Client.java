package com.ua.stomat.appservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.now;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

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
    @Column(name = "disable_notification")
    private boolean disableNotification = false;
    @Column(name = "disable_notification_date")
    private Timestamp disableNotificationDate;
    @Column(name = "resource")
    private String resource;

    private Integer totalEarn;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<UploadFile> files;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Appointment> appointments;


    public List<Appointment> getAppointments() {
        if (appointments.isEmpty()) {
            appointments = new ArrayList<>();
        }
        appointments.sort((p1, p2) -> Long.compare(p2.getDateFrom().getTime(), p1.getDateFrom().getTime()));
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        dateFormat.format(dateOfBirth);
        return dateOfBirth;
    }

    public Integer rank() {
        List<Appointment> appointments = getAppointments();
        if (appointments.isEmpty()) {
            return 0;
        }
        Integer totalEarn = 0;
        for (Appointment appointment : appointments) {
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
}

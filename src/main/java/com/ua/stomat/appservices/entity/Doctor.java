package com.ua.stomat.appservices.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 6L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
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

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Procedure> procedures;

    public Doctor() {
    }


    public Doctor(String firstName, String secondName, String thirdName, String email, String phone, List<Appointment> appointments, List<Procedure> procedures) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.phone = phone;
        this.appointments = appointments;
        this.procedures = procedures;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        if (getDoctorId() != null ? !getDoctorId().equals(doctor.getDoctorId()) : doctor.getDoctorId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(doctor.getFirstName()) : doctor.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(doctor.getSecondName()) : doctor.getSecondName() != null)
            return false;
        if (getThirdName() != null ? !getThirdName().equals(doctor.getThirdName()) : doctor.getThirdName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(doctor.getEmail()) : doctor.getEmail() != null) return false;
        if (getPhone() != null ? !getPhone().equals(doctor.getPhone()) : doctor.getPhone() != null) return false;
        if (getAppointments() != null ? !getAppointments().equals(doctor.getAppointments()) : doctor.getAppointments() != null)
            return false;
        return getProcedures() != null ? getProcedures().equals(doctor.getProcedures()) : doctor.getProcedures() == null;

    }

    @Override
    public int hashCode() {
        int result = getDoctorId() != null ? getDoctorId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getThirdName() != null ? getThirdName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getAppointments() != null ? getAppointments().hashCode() : 0);
        result = 31 * result + (getProcedures() != null ? getProcedures().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", appointments=" + appointments +
                ", procedures=" + procedures +
                '}';
    }
}

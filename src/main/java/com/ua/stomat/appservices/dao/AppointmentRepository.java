package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();

    void deleteByAppointmentId(Integer id);

    Appointment findByAppointmentId(Integer appointmentId);

    List<Appointment> findByDateFromGreaterThanEqual(Timestamp dateFrom);

    List<Appointment> findByDateFromAfter(Timestamp dateFrom);
}

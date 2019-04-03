package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();

    void deleteByAppointmentId(Integer id);

    Appointment findByAppointmentId(Integer appointmentId);
}

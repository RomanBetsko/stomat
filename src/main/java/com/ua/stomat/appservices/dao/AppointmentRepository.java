package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "appointment", path = "appointment")
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    void deleteByAppointmentId(Integer id);
}

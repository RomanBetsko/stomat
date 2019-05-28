package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Doctor findDoctorByFirstName(String firstName);

    Doctor findDoctorByDoctorId(Integer doctorId);
}

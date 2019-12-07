package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, Long> {

    List<Procedure> findAll();

    List<Procedure> findAllByName(String name);

    Procedure findByProcedureId(Integer procedureId);
}

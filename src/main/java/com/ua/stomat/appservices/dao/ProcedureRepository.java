package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, Long> {

}

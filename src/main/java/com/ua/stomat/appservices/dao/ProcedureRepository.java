package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "procedure", path = "procedure")
@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, Integer> {
}

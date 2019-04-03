package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAll();

    Client findByClientId(Integer id);

    void deleteByClientId(Integer id);
}

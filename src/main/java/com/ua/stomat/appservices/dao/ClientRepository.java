package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}

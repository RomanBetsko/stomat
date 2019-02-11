package com.ua.stomat.appservices.dao;


import com.ua.stomat.appservices.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ClientDao extends CrudRepository<Client, Long> {

    List<Client> findAll();

    Client save(Client client);
}

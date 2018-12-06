package com.ua.stomat.appservices.dao;


import com.ua.stomat.appservices.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AuthorDao {

    List<Author> findAll();

    int addAuthor(Author author);

    Author getAuthorByName(String name);
}

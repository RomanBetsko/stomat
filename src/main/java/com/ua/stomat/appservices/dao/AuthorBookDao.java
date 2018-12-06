package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.AuthorBook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorBookDao {

    void addAuthorBook(AuthorBook authorBook);
}

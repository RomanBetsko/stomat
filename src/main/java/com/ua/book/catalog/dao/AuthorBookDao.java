package com.ua.book.catalog.dao;

import com.ua.book.catalog.entity.AuthorBook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorBookDao {

    void addAuthorBook(AuthorBook authorBook);
}

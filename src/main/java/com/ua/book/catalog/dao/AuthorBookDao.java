package com.ua.book.catalog.dao;

import com.ua.book.catalog.entity.AuthorBook;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorBookDao {

    void addAuthorBook(AuthorBook authorBook);
}

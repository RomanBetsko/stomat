package com.ua.book.catalog.dao;


import com.ua.book.catalog.entity.Author;
import com.ua.book.catalog.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao {


    List<Author> findAll();

    void addAuthor(Author author);
}

package com.ua.book.catalog.dao;


import com.ua.book.catalog.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao{

    List<Book> findAll();

    void addBook(Book book);

    Book getById(int id);

    void deleteBook(int bookId);

    List<Book> getByAddedBy(int customerId);
}

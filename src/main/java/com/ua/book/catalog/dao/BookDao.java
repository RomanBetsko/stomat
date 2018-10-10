package com.ua.book.catalog.dao;


import com.ua.book.catalog.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookDao{

    List<Book> findAll();

    void addBook(Book book);

    Book getById(int id);

    void deleteBook(int bookId);

    List getByAddedBy(int customerId);

    int addBookWithId(Book book);

    List<Book> getBooksByIds(List<Integer> integers);
}

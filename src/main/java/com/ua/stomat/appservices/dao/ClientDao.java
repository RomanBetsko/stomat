package com.ua.stomat.appservices.dao;


import com.ua.stomat.appservices.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ClientDao {

    List<Book> findAll();

    void addBook(Book book);

    Book getById(Integer id);

    void deleteBook(Integer bookId);

    List<Book> getByAddedBy(Integer customerId);

    int addBookWithId(Book book);

    List<Book> getBooksByIds(List<Integer> integers);
}

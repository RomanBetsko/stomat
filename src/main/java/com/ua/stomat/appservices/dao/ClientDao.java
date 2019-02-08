package com.ua.stomat.appservices.dao;


import com.ua.stomat.appservices.entity.Book;
import com.ua.stomat.appservices.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ClientDao {

    List<Book> findAll();

    void addClient(Client client);

    Book getById(Integer id);

    void deleteBook(Integer bookId);

    List<Book> getByAddedBy(Integer customerId);

    int addBookWithId(Book book);

    List<Book> getBooksByIds(List<Integer> integers);
}

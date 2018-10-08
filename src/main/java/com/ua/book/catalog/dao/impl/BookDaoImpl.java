package com.ua.book.catalog.dao.impl;


import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book").list();
        return books;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Override
    public Book getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, getById(id));

        //todo refactor this
        return book;
    }


}

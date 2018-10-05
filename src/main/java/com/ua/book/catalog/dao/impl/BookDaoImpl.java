package com.ua.book.catalog.dao.impl;


import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

@Repository
public class BookDaoImpl implements BookDao {


    @Override
    public List<Book> findAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Book> books = session.createQuery("from Book").list();
        session.getTransaction().commit();
        return books;
    }

    @Override
    public void addBook(Book book) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

    }

    @Override
    public Book getById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = (Book) session.get(Book.class, getById(id));
        session.getTransaction().commit();
        return book;
    }


}

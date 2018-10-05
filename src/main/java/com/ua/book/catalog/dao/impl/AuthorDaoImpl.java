package com.ua.book.catalog.dao.impl;


import com.ua.book.catalog.dao.AuthorDao;
import com.ua.book.catalog.entity.Author;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {


    @Override
    public List<Author> findAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Author> authors = session.createQuery("from Author").list();
        return authors;
    }

    @Override
    public void addAuthor(Author author) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(author);
    }
}

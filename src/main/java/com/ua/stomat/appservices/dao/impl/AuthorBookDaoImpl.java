package com.ua.stomat.appservices.dao.impl;

import com.ua.stomat.appservices.dao.AuthorBookDao;
import com.ua.stomat.appservices.entity.AuthorBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorBookDaoImpl implements AuthorBookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAuthorBook(AuthorBook authorBook) {
        Session session = sessionFactory.getCurrentSession();
        session.save(authorBook);
    }
}

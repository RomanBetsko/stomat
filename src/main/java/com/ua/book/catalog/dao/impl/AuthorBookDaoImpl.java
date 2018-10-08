package com.ua.book.catalog.dao.impl;

import com.ua.book.catalog.dao.AuthorBookDao;
import com.ua.book.catalog.entity.AuthorBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

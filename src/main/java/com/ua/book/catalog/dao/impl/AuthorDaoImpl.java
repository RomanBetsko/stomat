package com.ua.book.catalog.dao.impl;


import com.ua.book.catalog.dao.AuthorDao;
import com.ua.book.catalog.entity.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Author> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Author> authors = session.createQuery("from Author").list();
        return authors;
    }

    @Override
    public int addAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(author);
    }

    @Override
    public Author getAuthorByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Author.class);
        return (Author) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }


}

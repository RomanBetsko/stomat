package com.ua.stomat.appservices.dao.impl;


import com.ua.stomat.appservices.dao.ClientDao;
import com.ua.stomat.appservices.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book").list();
    }

    @Override
    public void addBook(Book book) {
        //todo check this
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Override
    public Book getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public void deleteBook(Integer bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Book where id = :id ");
        q.setParameter("id", bookId);
        Book book1 = (Book)q.list().get(0);
        session.delete(book1);
    }

    @Override
    public List<Book> getByAddedBy(Integer customerId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Book.class);
        return criteria.add(Restrictions.eq("addedBy", customerId)).list();
    }

    @Override
    public int addBookWithId(Book book) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(book);
    }

    @Override
    public List<Book> getBooksByIds(List<Integer> integers) {
        Session session = sessionFactory.getCurrentSession();
        MultiIdentifierLoadAccess<Book> multiLoadAccess = session.byMultipleIds(Book.class);
        return multiLoadAccess.multiLoad(integers);
    }


}

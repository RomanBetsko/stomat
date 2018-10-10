package com.ua.book.catalog.dao.impl;


import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        Query<Book> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void addBook(Book book) {
        //todo check this
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Override
    public Book getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public void deleteBook(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Book where id = :id ");
        q.setParameter("id", bookId);
        Book book1 = (Book)q.list().get(0);
        session.delete(book1);
    }

    @Override
    public List<Book> getByAddedBy(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root.get("addedBy")).where(criteriaBuilder.equal(root.get("addedBy"), customerId));
        Query<Book> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public int addBookWithId(Book book) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(book);
    }


}

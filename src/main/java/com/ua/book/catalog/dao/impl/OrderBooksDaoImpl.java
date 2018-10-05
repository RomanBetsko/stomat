package com.ua.book.catalog.dao.impl;

import com.ua.book.catalog.dao.OrderBooksDao;
import com.ua.book.catalog.entity.OrderBooks;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class OrderBooksDaoImpl implements OrderBooksDao{
    @Override
    public void addOrderBook(int bookId, int readerId) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        OrderBooks ob = new OrderBooks();
        ob.setBookId(bookId);
        ob.setReaderId(readerId);
        session.save(ob);
        session.getTransaction().commit();


    }

    @Override
    public List<OrderBooks> getOrderCard(Integer readerId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(OrderBooks.class);
        List<OrderBooks> orderBooks = criteria.add(Restrictions.eq("readerId", readerId)).list();
        session.getTransaction().commit();
        return orderBooks;
    }
}

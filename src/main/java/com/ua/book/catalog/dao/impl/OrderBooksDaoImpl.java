package com.ua.book.catalog.dao.impl;

import com.ua.book.catalog.dao.OrderBooksDao;
import com.ua.book.catalog.entity.OrderBooks;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class OrderBooksDaoImpl implements OrderBooksDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addOrderBook(int bookId, int readerId) {
        Session session = sessionFactory.getCurrentSession();
        OrderBooks ob = new OrderBooks();
        ob.setBookId(bookId);
        ob.setReaderId(readerId);
        session.save(ob);
    }

    @Override
    public List<OrderBooks> getOrderCard(Integer readerId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(OrderBooks.class);
        List<OrderBooks> orderBooks = criteria.add(Restrictions.eq("readerId", readerId)).list();
        return orderBooks;
    }
}

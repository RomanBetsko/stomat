package com.ua.book.catalog.service.impl;

import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.dao.OrderBooksDao;
import com.ua.book.catalog.entity.OrderBooks;
import com.ua.book.catalog.objects.OrderCard;
import com.ua.book.catalog.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCardServiceImpl implements OrderCardService{

    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderBooksDao orderBooksDao;

    @Override
    public void addBookToCard(Integer bookId, Integer readerId) {
        orderBooksDao.addOrderBook(bookId, readerId);
    }

    @Override
    public OrderCard getCard(Integer readerId) {
        OrderCard oc = new OrderCard();
        List<OrderBooks> orderBooks = orderBooksDao.getOrderCard(readerId);
        oc.setBooks(orderBooks);
        oc.setNumberOfItems(orderBooks.size());
        return oc;
    }
}

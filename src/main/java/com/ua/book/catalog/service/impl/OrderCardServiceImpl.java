package com.ua.book.catalog.service.impl;

import com.ua.book.catalog.dao.OrderBooksDao;
import com.ua.book.catalog.entity.OrderBooks;
import com.ua.book.catalog.service.OrderCardService;
import com.ua.book.catalog.validator.OrderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderCardServiceImpl implements OrderCardService{

    @Autowired
    private OrderBooksDao orderBooksDao;

    @Override
    @Transactional
    public void addBookToCard(Integer bookId, Integer readerId) {
        OrderBooks orderBook = new OrderBooks();
        orderBook.setBookId(bookId);
        orderBook.setReaderId(readerId);
        orderBooksDao.addOrderBook(orderBook);
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

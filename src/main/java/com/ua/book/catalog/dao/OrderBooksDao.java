package com.ua.book.catalog.dao;

import com.ua.book.catalog.entity.OrderBooks;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface OrderBooksDao {
    
    void addOrderBook(int bookId, int readerId);

    List<OrderBooks> getOrderCard(Integer readerId);
}

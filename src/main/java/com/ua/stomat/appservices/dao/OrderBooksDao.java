package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.OrderBooks;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface OrderBooksDao {
    
    void addOrderBook(OrderBooks orderBook);

    List<OrderBooks> getOrderCard(Integer readerId);
}

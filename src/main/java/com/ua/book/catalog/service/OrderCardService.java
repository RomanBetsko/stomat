package com.ua.book.catalog.service;


import com.ua.book.catalog.validator.OrderCard;

public interface OrderCardService {

    void addBookToCard(Integer bookId, Integer readerId);

    OrderCard getCard(Integer readerId);
}

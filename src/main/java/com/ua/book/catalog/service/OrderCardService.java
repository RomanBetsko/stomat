package com.ua.book.catalog.service;


import com.ua.book.catalog.validator.OrderCard;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public interface OrderCardService {

    void addBookToCard(Integer bookId, Integer readerId);

    OrderCard getCard(Integer readerId);

    ModelAndView getOrderCard(Integer readerId);

    ResponseEntity<?> addBookToCard(Integer bookId, Integer readerId, Errors errors);
}

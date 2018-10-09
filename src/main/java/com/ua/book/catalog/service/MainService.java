package com.ua.book.catalog.service;

import com.ua.book.catalog.validator.AddBookCriteria;
import com.ua.book.catalog.validator.OrderCard;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface MainService {

    ModelAndView getUnloginZoneData();

    ModelAndView readerView();

    OrderCard getOrderCard(Integer readerId);

    ResponseEntity<?> addBook(AddBookCriteria request, Errors errors);

    ResponseEntity<?> addBookToCard(Integer bookId, Integer readerId, Errors errors);

    ResponseEntity<?> deleteBook(Integer bookId, Integer customerId, Errors errors);

    ModelAndView getDeleteBookPage(int customerId);
}

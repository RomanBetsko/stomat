package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.validator.AddBookCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface BooksService {

    ResponseEntity<?> addBook(AddBookCriteria request, Errors errors);

    ResponseEntity<?> deleteBook(Integer bookId, Integer customerId, Errors errors);

    ModelAndView getBookPage(Integer bookId);

    ModelAndView getDeleteBookPage(Integer customerId);
}

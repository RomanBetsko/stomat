package com.ua.book.catalog.controllers;

import com.ua.book.catalog.service.BooksService;
import com.ua.book.catalog.validator.AddBookCriteria;
import com.ua.book.catalog.validator.CustomersBookCriteria;
import com.ua.book.catalog.validator.DeleteBookCriteria;
import com.ua.book.catalog.validator.GetBookCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewBook(@RequestBody @Valid AddBookCriteria request, Errors errors) {
        return booksService.addBook(request, errors);
    }

    @PostMapping("/deleteBook")
    public ResponseEntity<?> deleteBook (@RequestBody DeleteBookCriteria request, Errors errors){
        return booksService.deleteBook(request.getBookId(), request.getCustomerId(), errors);
    }

    @PostMapping("/getBook")
    public ModelAndView getBook (@RequestBody GetBookCriteria request){
        return booksService.getBookPage(request.getBookId());
    }

    @PostMapping("/customer/delete")
    public ModelAndView deleteView(@RequestBody CustomersBookCriteria request) {
        return booksService.getDeleteBookPage(request.getCustomerId());
    }
}

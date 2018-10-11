package com.ua.book.catalog.controllers;

import com.ua.book.catalog.service.MainService;
import com.ua.book.catalog.service.OrderCardService;
import com.ua.book.catalog.validator.AddBookToCardCriteria;
import com.ua.book.catalog.validator.CustomersBookCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderCardController {

    @Autowired
    private OrderCardService orderCardService;

    @PostMapping("/addBookToCard")
    public ResponseEntity<?> addBookToCard (@RequestBody AddBookToCardCriteria request, Errors errors){
        return orderCardService.addBookToCard(request.getBookId(), request.getReaderId(), errors);
    }

    @PostMapping("/getOrderCard")
    public ModelAndView getOrderCardView (@RequestBody CustomersBookCriteria request){
        return orderCardService.getOrderCard(request.getCustomerId());
    }
}

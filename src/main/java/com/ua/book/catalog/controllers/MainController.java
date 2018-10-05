package com.ua.book.catalog.controllers;


import com.ua.book.catalog.entity.Book;
import com.ua.book.catalog.model.AddBookCriteria;
import com.ua.book.catalog.model.AddBookToCardCriteria;
import com.ua.book.catalog.objects.OrderCard;
import com.ua.book.catalog.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/customer")
    public String addNewBook() {
        return "/customer";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

    @GetMapping("/reader")
    public ModelAndView reader() {
        return mainService.readerView();
    }

    @GetMapping("/unloginzone")
    public ModelAndView unLoginZone() {
        return mainService.unloginZone();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewBookFromAjax(@RequestBody @Valid AddBookCriteria request, Errors errors) {
        return mainService.addBook(request, errors);
    }

    @PostMapping("/addBookToCard")
    public ResponseEntity<?> addBookToCard (@RequestBody AddBookToCardCriteria request, Errors errors){
        return mainService.addBookToCard(request.getBookId(), request.getReaderId(), errors);
    }

}

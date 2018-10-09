package com.ua.book.catalog.controllers;


import com.ua.book.catalog.validator.AddBookCriteria;
import com.ua.book.catalog.validator.AddBookToCardCriteria;
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
    public String home() {
        return "/home";
    }

    @GetMapping("/home")
    public String homeView() {
        return "/home";
    }

    @GetMapping("/customer")
    public String customerView() {
        return "/customer";
    }

    @GetMapping("/login")
    public String loginView() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "security/403";
    }

    @GetMapping("/reader")
    public ModelAndView readerView() {
        return mainService.readerView();
    }

    @GetMapping("/unloginzone")
    public ModelAndView getUnLoginZoneView() {
        return mainService.getUnloginZoneData();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewBook(@RequestBody @Valid AddBookCriteria request, Errors errors) {
        return mainService.addBook(request, errors);
    }

    @PostMapping("/addBookToCard")
    public ResponseEntity<?> addBookToCard (@RequestBody AddBookToCardCriteria request, Errors errors){
        return mainService.addBookToCard(request.getBookId(), request.getReaderId(), errors);
    }

}

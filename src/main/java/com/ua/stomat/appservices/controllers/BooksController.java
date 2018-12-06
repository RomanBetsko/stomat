package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.BooksService;
import com.ua.stomat.appservices.validator.AddBookCriteria;
import com.ua.stomat.appservices.validator.CustomersBookCriteria;
import com.ua.stomat.appservices.validator.DeleteBookCriteria;
import com.ua.stomat.appservices.validator.GetBookCriteria;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Api(value = "/", tags = "Books", description = "Operations with Books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/add")
    @ApiOperation(value = "Add a new book to the catalog")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    public ResponseEntity<?> addNewBook(@RequestBody @Valid AddBookCriteria request, Errors errors) {
        return booksService.addBook(request, errors);
    }

    @PostMapping("/deleteBook")
    public ResponseEntity<?> deleteBook (@RequestBody DeleteBookCriteria request, Errors errors){
        return booksService.deleteBook(request.getBookId(), request.getCustomerId(), errors);
    }

    @PostMapping("/getBook")
    @ApiOperation(
            value = "Find book by ID", notes = "Returns a book"+
            "error conditions",
            response = ModelAndView.class,
            authorizations = {
                    @Authorization(value = "api_key")})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Book not found")}
    )
    public ModelAndView getBook (@RequestBody GetBookCriteria request){
        return booksService.getBookPage(request.getBookId());
    }

    @PostMapping("/customer/delete")
    public ModelAndView deleteView(@RequestBody CustomersBookCriteria request) {
        return booksService.getDeleteBookPage(request.getCustomerId());
    }
}

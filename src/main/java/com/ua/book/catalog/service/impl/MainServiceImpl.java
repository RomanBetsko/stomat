package com.ua.book.catalog.service.impl;

import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.entity.Author;
import com.ua.book.catalog.entity.Book;
import com.ua.book.catalog.model.AddBookCriteria;
import com.ua.book.catalog.model.AjaxResponseBody;
import com.ua.book.catalog.objects.OrderCard;
import com.ua.book.catalog.service.MainService;
import com.ua.book.catalog.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderCardService orderCardService;


    @Override
    public ModelAndView unloginZone() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", bookDao.findAll());
        return new ModelAndView("unloginzone", params);
    }

    @Override
    public ModelAndView readerView() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", bookDao.findAll());
        params.put("orderCard", orderCardService.getCard(1));
        return new ModelAndView("reader", params);
    }

    @Override
    public OrderCard getOrderCard(Integer readerId) {
        return orderCardService.getCard(readerId);
    }

    @Override
    public ResponseEntity<?> addBook(AddBookCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        //todo має бути можливість добавляти декількох авторів, з усіми їх полями (забрати з таблиці author усіх not null true!!!!!!!!)
        bookDao.addBook(prepareBook(request));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result");
        return ResponseEntity.ok(result);
    }

    private Book prepareBook(AddBookCriteria request) {
        //todo refactor this
        Book book = new Book();
        book.setName(request.getName());
        book.setPrice(request.getPrice());
        book.setDescription(request.getDescription());
        book.setYearOfPublication(new Timestamp(request.getYearOfPublication().getTime()));
        Set<Author> authors = new HashSet<>();
        Author auth = new Author();
        auth.setFirstName(request.getAuthor());
        authors.add(auth);
        book.setAuthors(authors);
        return book;
    }

    @Override
    public ResponseEntity<?> addBookToCard(Integer bookId, Integer readerId, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        orderCardService.addBookToCard(bookId, readerId);
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result, book was added to your orderCard");
        return ResponseEntity.ok(result);
    }
}

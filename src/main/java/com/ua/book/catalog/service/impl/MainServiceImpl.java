package com.ua.book.catalog.service.impl;

import com.google.common.base.Strings;
import com.ua.book.catalog.dao.AuthorDao;
import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.dao.impl.AuthorDaoImpl;
import com.ua.book.catalog.entity.Author;
import com.ua.book.catalog.entity.Book;
import com.ua.book.catalog.validator.AddBookCriteria;
import com.ua.book.catalog.validator.AjaxResponseBody;
import com.ua.book.catalog.objects.OrderCard;
import com.ua.book.catalog.service.MainService;
import com.ua.book.catalog.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderCardService orderCardService;
    @Autowired
    private AuthorDao authorDao;


    @Override
    public ModelAndView getUnloginZoneData() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", bookDao.findAll());
        return new ModelAndView("unloginzone", params);
    }

    @Override
    public ModelAndView readerView() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", bookDao.findAll());
        //todo refactor when will added multiusers
        params.put("orderCard", orderCardService.getCard(1));
        return new ModelAndView("reader", params);
    }

    @Override
    public OrderCard getOrderCard(Integer readerId) {
        return orderCardService.getCard(readerId);
    }

    @Override
    @Transactional
    public ResponseEntity<?> addBook(AddBookCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        //todo має бути можливість добавляти декількох авторів (забрати з таблиці author усіх not null true!!!!!!!!)
        bookDao.addBook(prepareBook(request));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
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
        for(String authName : request.getAuthors()){
            Author author = new Author();
            author.setName(authName);
            authors.add(author);
            // якщо автор з таким іменем уже існує взяти його id, якщо ні, добавити нового автора і взяти його айді
            Author old = authorDao.getAuthorByName(authName);
            if(StringUtils.isEmpty(old)){
                author.setId(authorDao.addAuthor(author));
            } else {
                author.setId(old.getId());
            }
        }
        book.setAuthors(authors);
        return book;
    }

    @Override
    public ResponseEntity<?> addBookToCard(Integer bookId, Integer readerId, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        orderCardService.addBookToCard(bookId, readerId);
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result, book was added to your orderCard");
        return ResponseEntity.ok(result);
    }
}

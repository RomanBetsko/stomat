package com.ua.book.catalog.service.impl;

import com.ua.book.catalog.dao.AuthorBookDao;
import com.ua.book.catalog.dao.AuthorDao;
import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.entity.Author;
import com.ua.book.catalog.entity.AuthorBook;
import com.ua.book.catalog.entity.Book;
import com.ua.book.catalog.validator.AddBookCriteria;
import com.ua.book.catalog.validator.AjaxResponseBody;
import com.ua.book.catalog.validator.OrderCard;
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
@Transactional(readOnly = true)
public class MainServiceImpl implements MainService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderCardService orderCardService;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private AuthorBookDao authorBookDao;


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
        bookDao.addBook(prepareBook(request));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result, book was added");
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
        AuthorBook authorBook = new AuthorBook();
        for(String authName : request.getAuthors()){
            Author author = new Author();
            author.setName(authName);
            authors.add(author);
            // if an author with such a name already exists, take his id, if not, add a new author and take his id
            Author old = authorDao.getAuthorByName(authName);
            if(StringUtils.isEmpty(old)){
                int authorId = authorDao.addAuthor(author);
                author.setId(authorId);
                authorBook.setAuthorId(authorId);
            } else {
                author.setId(old.getId());
                authorBook.setAuthorId(old.getId());
            }
        }
        book.setAuthors(authors);
        authorBookDao.addAuthorBook(authorBook);
        return book;
    }

    @Override
    @Transactional
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

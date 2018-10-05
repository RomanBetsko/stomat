package com.ua.book.catalog.service;

import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.entity.Author;
import com.ua.book.catalog.entity.Book;
import com.ua.book.catalog.model.AddBookCriteria;
import com.ua.book.catalog.model.AjaxResponseBody;
import com.ua.book.catalog.objects.OrderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public interface MainService {

    public ModelAndView unloginZone();

    public ModelAndView readerView();


    public OrderCard getOrderCard (Integer readerId);

    public ResponseEntity<?> addBook(AddBookCriteria request, Errors errors);


    public ResponseEntity<?> addBookToCard(Integer bookId, Integer readerId, Errors errors);
}

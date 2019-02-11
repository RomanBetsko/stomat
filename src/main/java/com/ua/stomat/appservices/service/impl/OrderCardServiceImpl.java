package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientDao;
import com.ua.stomat.appservices.dao.OrderBooksDao;
import com.ua.stomat.appservices.entity.OrderBooks;
import com.ua.stomat.appservices.service.OrderCardService;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import com.ua.stomat.appservices.validator.OrderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderCardServiceImpl implements OrderCardService {

    @Autowired
    private OrderBooksDao orderBooksDao;
    @Autowired
    private ClientDao clientDao;

    @Override
    @Transactional
    public void addBookToCard(Integer bookId, Integer readerId) {
        orderBooksDao.addOrderBook(new OrderBooks(readerId, bookId));
    }

    @Override
    @Transactional
    public OrderCard getCard(Integer readerId) {
        List<OrderBooks> orderBooks = orderBooksDao.getOrderCard(readerId);
        return new OrderCard(orderBooks.size(), orderBooks);
    }

    @Override
    @Transactional
    public ModelAndView getOrderCard(Integer readerId) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderCard", getCard(readerId));
        //params.put("books", clientDao.getBooksByIds(getBookIds(readerId)));
        return new ModelAndView("orderCard", params);
    }

    private List<Integer> getBookIds(Integer readerId) {
        OrderCard orderCard = getCard(readerId);
        return orderCard.getBooks().stream().map(OrderBooks::getBookId).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResponseEntity<?> addBookToCard(Integer bookId, Integer readerId, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        OrderCard orderCard = getCard(readerId);
        OrderBooks orderBook = new OrderBooks(readerId, bookId);
        if(!orderCard.getBooks().contains(orderBook)){
            addBookToCard(bookId, readerId);
        }
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

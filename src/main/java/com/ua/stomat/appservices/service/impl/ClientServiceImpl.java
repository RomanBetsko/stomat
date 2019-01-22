package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.AuthorBookDao;
import com.ua.stomat.appservices.dao.AuthorDao;
import com.ua.stomat.appservices.dao.ClientDao;
import com.ua.stomat.appservices.entity.Author;
import com.ua.stomat.appservices.entity.AuthorBook;
import com.ua.stomat.appservices.entity.Book;
import com.ua.stomat.appservices.entity.Reader;
import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private AuthorBookDao authorBookDao;
    @Autowired
    private ClientDao clientDao;

    @Override
    @Transactional
    public ResponseEntity<?> addClient(AddClientCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        clientDao.addClient(prepareClient(request));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result, book was added");
        return ResponseEntity.ok(result);
    }


    private Book prepareClient(AddClientCriteria request) {
        //todo refactor this
        Set<Author> authors = new HashSet<>();
        Set<Reader> readers = new HashSet<>();
        AuthorBook authorBook = new AuthorBook();
        for (String authName : request.getAuthors()) {
            Author author = new Author();
            author.setName(authName);
            authors.add(author);
            Author old = authorDao.getAuthorByName(authName);
            if (StringUtils.isEmpty(old)) {
                int authorId = authorDao.addAuthor(author);
                author.setId(authorId);
                authorBook.setAuthorId(authorId);
            } else {
                author.setId(old.getId());
                authorBook.setAuthorId(old.getId());
            }
        }
        authorBookDao.addAuthorBook(authorBook);
        return new Book(request.getName(), request.getPrice(),
                request.getDescription(), new Timestamp(request.getYearOfPublication().getTime()),
                request.getAddedBy(), authors, readers);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteBook(Integer bookId, Integer customerId, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        clientDao.getByAddedBy(customerId).stream().filter(book -> book.getId() == bookId).forEach(book -> clientDao.deleteBook(bookId));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result, book was deleted");
        return ResponseEntity.ok(result);
    }

    @Override
    @Transactional
    public ModelAndView getBookPage(Integer bookId) {
        Map<String, Object> params = new HashMap<>();
        params.put("book", clientDao.getById(bookId));
        return new ModelAndView("singlebook", params);
    }

    @Override
    @Transactional
    public ModelAndView getDeleteBookPage(Integer customerId) {
        Map<String, Object> params = new HashMap<>();
        params.put("books", clientDao.getByAddedBy(customerId));
        return new ModelAndView("delete", params);
    }
}

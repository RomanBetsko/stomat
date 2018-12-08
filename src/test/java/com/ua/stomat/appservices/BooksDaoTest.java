package com.ua.stomat.appservices;

import com.ua.stomat.appservices.dao.ClientDao;
import com.ua.stomat.appservices.entity.Author;
import com.ua.stomat.appservices.entity.Book;
import com.ua.stomat.appservices.entity.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BooksDaoTest {

    @Autowired
    private ClientDao clientDao;

    @Test
    public void testFindAll() {
        int booksCountBefore = clientDao.findAll().size();

        Timestamp now = new Timestamp(System.currentTimeMillis());
        Set<Author> authors = new HashSet<>();
        Set<Reader> readers = new HashSet<>();
        clientDao.addBook(new Book("test book", 123, "test description", now, 100, authors, readers));

        int booksCountAfter = clientDao.findAll().size();

        Assert.assertEquals(booksCountBefore + 1, booksCountAfter);
    }

    @Test
    public void testGetById(){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Set<Author> authors = new HashSet<>();
        Set<Reader> readers = new HashSet<>();
        int bookAddedId = clientDao.addBookWithId(new Book("test book", 123, "test description", now, 100,authors, readers));
        Book bookTest = clientDao.getById(bookAddedId);
        Assert.assertEquals(bookTest.getId(), bookAddedId);
    }

    @Test
    public void testDeleteBook(){
        int booksCountBefore = clientDao.findAll().size();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Set<Author> authors = new HashSet<>();
        Set<Reader> readers = new HashSet<>();
        int bookId = clientDao.addBookWithId(new Book("test book", 123, "test description", now, 100,authors, readers));
        int booksCountAfterAdding = clientDao.findAll().size();
        Assert.assertEquals(booksCountBefore + 1, booksCountAfterAdding);
        clientDao.deleteBook(bookId);
        int booksCountAfaterDelete = clientDao.findAll().size();
        Assert.assertEquals(booksCountBefore, booksCountAfaterDelete);
    }


    @Test
    public void testGetByAddedBy(){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Set<Author> authors = new HashSet<>();
        Set<Reader> readers = new HashSet<>();
        int bookId = clientDao.addBookWithId(new Book("test book", 123, "test description", now, 99,authors, readers));
        List<Book> books = clientDao.getByAddedBy(99);
        Assert.assertEquals(books.size(), 1);
    }
}

package com.ua.book.catalog;

import com.ua.book.catalog.dao.AuthorDao;
import com.ua.book.catalog.entity.Author;
import com.ua.book.catalog.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void addAuthorTest(){
        int authorsCountBefore = authorDao.findAll().size();
        Set<Book> books = new HashSet<>();
        authorDao.addAuthor(new Author("test author", "test@gmail.com", "Ukraine", books));
        int authorsCountAfter = authorDao.findAll().size();
        Assert.assertEquals(authorsCountBefore + 1, authorsCountAfter);
    }


    @Test
    public void getAuthorByNameTest(){
        Set<Book> books = new HashSet<>();
        String specialName = "special";
        authorDao.addAuthor(new Author(specialName, "test@gmail.com", "Ukraine", books));
        Author daoAuthor = authorDao.getAuthorByName(specialName);
        Assert.assertEquals(daoAuthor.getName(), specialName);
    }
}

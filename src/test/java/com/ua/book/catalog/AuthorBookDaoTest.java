package com.ua.book.catalog;

import com.ua.book.catalog.dao.AuthorBookDao;
import com.ua.book.catalog.entity.AuthorBook;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorBookDaoTest {

    @Autowired
    private AuthorBookDao authorBookDao;

    @Test
    @Ignore
    public void testFindAll() {
        authorBookDao.addAuthorBook(new AuthorBook(5, 50));
    }
}

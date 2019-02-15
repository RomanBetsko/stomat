package com.ua.stomat.appservices;

import com.ua.stomat.appservices.dao.AuthorBookDao;
import com.ua.stomat.appservices.entity.AuthorBook;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorClientRepositoryTest {

    @Autowired
    private AuthorBookDao authorBookDao;

    @Test
    @Ignore
    public void testFindAll() {
        authorBookDao.addAuthorBook(new AuthorBook(5, 50));
    }
}

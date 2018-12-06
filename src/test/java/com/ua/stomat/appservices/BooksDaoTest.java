package com.ua.stomat.appservices;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BooksDaoTest {

//    @Autowired
//    private BookDao bookDao;
//
//    @Test
//    public void testFindAll() {
//        int booksCountBefore = bookDao.findAll().size();
//
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        Set<Author> authors = new HashSet<>();
//        Set<Reader> readers = new HashSet<>();
//        bookDao.addBook(new Book("test book", 123, "test description", now, 100, authors, readers));
//
//        int booksCountAfter = bookDao.findAll().size();
//
//        Assert.assertEquals(booksCountBefore + 1, booksCountAfter);
//    }
//
//    @Test
//    public void testGetById(){
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        Set<Author> authors = new HashSet<>();
//        Set<Reader> readers = new HashSet<>();
//        int bookAddedId = bookDao.addBookWithId(new Book("test book", 123, "test description", now, 100,authors, readers));
//        Book bookTest = bookDao.getById(bookAddedId);
//        Assert.assertEquals(bookTest.getId(), bookAddedId);
//    }
//
//    @Test
//    public void testDeleteBook(){
//        int booksCountBefore = bookDao.findAll().size();
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        Set<Author> authors = new HashSet<>();
//        Set<Reader> readers = new HashSet<>();
//        int bookId = bookDao.addBookWithId(new Book("test book", 123, "test description", now, 100,authors, readers));
//        int booksCountAfterAdding = bookDao.findAll().size();
//        Assert.assertEquals(booksCountBefore + 1, booksCountAfterAdding);
//        bookDao.deleteBook(bookId);
//        int booksCountAfaterDelete = bookDao.findAll().size();
//        Assert.assertEquals(booksCountBefore, booksCountAfaterDelete);
//    }
//
//
//    @Test
//    public void testGetByAddedBy(){
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        Set<Author> authors = new HashSet<>();
//        Set<Reader> readers = new HashSet<>();
//        int bookId = bookDao.addBookWithId(new Book("test book", 123, "test description", now, 99,authors, readers));
//        List<Book> books = bookDao.getByAddedBy(99);
//        Assert.assertEquals(books.size(), 1);
//    }
}

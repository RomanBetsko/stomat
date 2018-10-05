package com.ua.book.catalog.service;

import com.ua.book.catalog.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CheckYearOfPublicationRunnable implements Runnable{

    public void run() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Timestamp timeNow = getTimeForCheck();
        List<Book> books = session.createQuery("from Book").list();
        System.out.println("start checking");
        books.stream().filter(book -> book.getYearOfPublication().before(timeNow)).forEach(session::delete);
        System.out.println("record deleted");
        session.getTransaction().commit();

    }

    private Timestamp getTimeForCheck(){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.YEAR, -2);
        return new Timestamp(cal.getTime().getTime());
    }
}

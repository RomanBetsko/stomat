package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

@Component
public class CheckYearOfPublicationRunnable implements Runnable{

    @Autowired
    private SessionFactory sessionFactory;

    public void run() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book").list();
        System.out.println("start checking");
        books.stream().filter(book -> book.getYearOfPublication().before(getTimeForCheck())).forEach(session::delete);
        System.out.println("finish checking");
    }

    private Timestamp getTimeForCheck(){
        Calendar cal = getInstance();
        cal.setTimeInMillis(new Timestamp(System.currentTimeMillis()).getTime());
        cal.add(YEAR, -2);
        return new Timestamp(cal.getTime().getTime());
    }
}

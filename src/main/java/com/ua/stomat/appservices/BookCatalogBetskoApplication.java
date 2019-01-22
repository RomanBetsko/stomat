package com.ua.stomat.appservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BookCatalogBetskoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCatalogBetskoApplication.class, args);
    }
}

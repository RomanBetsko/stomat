package com.ua.stomat.appservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
@EnableJpaAuditing
public class BookCatalogBetskoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCatalogBetskoApplication.class, args);
    }
}

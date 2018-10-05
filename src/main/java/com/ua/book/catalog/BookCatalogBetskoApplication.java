package com.ua.book.catalog;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class BookCatalogBetskoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogBetskoApplication.class, args);
	}
}

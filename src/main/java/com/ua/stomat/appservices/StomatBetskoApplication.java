package com.ua.stomat.appservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
//@EnableJpaAuditing
public class StomatBetskoApplication extends SpringBootServletInitializer {
//public class StomatBetskoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StomatBetskoApplication.class, args);
    }
}

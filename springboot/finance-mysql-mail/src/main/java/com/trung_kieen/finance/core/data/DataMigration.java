package com.trung_kieen.finance.core.data;


import java.util.Collections;
import java.util.List;

import com.trung_kieen.finance.app.book.Book;
import com.trung_kieen.finance.app.book.BookRepository;
import com.trung_kieen.finance.app.user.model.AppUser;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

/**
 * DataMigration
 */
@Component

public class DataMigration {
    private static final Logger logger = LoggerFactory.getLogger(DataMigration.class);

    @Autowired
    private BookRepository bookRepository;

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            feedData();
            //findByPaginate();
        };
    }

    public void findByPaginate() {
        System.out.println("========================================" );
        System.out.println("Search for page of users sample value" );
        System.out.println("========================================" );
    }

    public void feedData() {

        System.out.println("========================================");
        System.out.println("FEEDDING DATA...");
        for (int i = 0; i < 10; i++) {
            try {
                Faker f = new Faker();

//                var user = AppUser.builder()
//                        .username(f.name().firstName())
//                        .email(f.address().streetName())
//                        .password(f.animal().name())
//                        .build();
                AppUser user  = AppUser.builder()
                        .username(f.name().firstName())
                        .password(f.address().streetName())
                        .email(f.animal().name())
                                .build();
                System.out.println(user);
            } catch (Exception ex) {
                logger.error("Could not add sample data", ex.getCause());
            }
        }

        System.out.println("========================================");
    }

}

package com.samara.mentoring.bookcms.config;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.dao.BookDaoImpl;
import com.samara.mentoring.bookcms.service.BookService;
import com.samara.mentoring.bookcms.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring beans configuration
 * Cosmetic commit
 */
@Configuration
public class CoreConfig {
    @Bean
    public BookDao bookDao() {
        return new BookDaoImpl();
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }
}

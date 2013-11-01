package com.samara.mentoring.bookcms.config;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.Collection;

/**
 * Spring beans configuration for test purpose
 */
@Configuration
public class TestConfig {
    public static final String MOCK_BOOK_TITLE = "The Shining";
    public static final String MOCK_BOOK_AUTHOR_FNAME = "Stephen";
    public static final String MOCK_BOOK_AUTHOR_LNAME = "King";

    @Bean @Primary
    public BookDao mockDao() {
        return new BookDao() {
            @Override
            public Collection<Book> getBooksByAuthor(Author author) {
                return getBooks();
            }

            @Override
            public Collection<Book> getBooksByTitle(String title) {
                return getBooks();
            }

            private Collection<Book> getBooks() {
                Book book = new Book();
                book.setTitle(MOCK_BOOK_TITLE);
                Author author1 = new Author();
                author1.setFirstName(MOCK_BOOK_AUTHOR_FNAME);
                author1.setLastName(MOCK_BOOK_AUTHOR_LNAME);
                book.addAuthor(author1);
                return Arrays.asList(book);
            }
        };
    }
}

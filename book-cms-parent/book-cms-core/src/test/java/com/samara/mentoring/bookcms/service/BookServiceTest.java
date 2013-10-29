package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.config.CoreConfig;
import com.samara.mentoring.bookcms.config.TestConfig;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Try overriding beans in test context
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class, TestConfig.class } )
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testBeanWiring() {
        Collection<Book> books = bookService.getBooksByAuthor(null);
        assertEquals(1, books.size());
        Book book = books.iterator().next();
        assertEquals(TestConfig.MOCK_BOOK_TITLE, book.getTitle());
        assertEquals(1, book.getAuthors().size());
        Author author = book.getAuthors().iterator().next();
        assertEquals(TestConfig.MOCK_BOOK_AUTHOR_FNAME, author.getFirstName());
        assertEquals(TestConfig.MOCK_BOOK_AUTHOR_LNAME, author.getLastName());
        assertNull(author.getMiddleName());
    }
}

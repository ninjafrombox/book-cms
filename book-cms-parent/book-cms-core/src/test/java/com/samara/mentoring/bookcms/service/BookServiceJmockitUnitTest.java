package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import mockit.*;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class BookServiceJmockitUnitTest {
    @Tested BookServiceImpl bookService;
    @Mocked BookDao bookDao;

    @Test
    public void bookServiceCallsGetBooksByAuthorDao() {
        Deencapsulation.setField(bookService, bookDao);

        final Author author = new Author();
        bookService.getBooksByAuthor(author);
        new Verifications() {
            {
                bookDao.getBooksByAuthor(author);
            }
        };
    }

    @Test
    public void bookServiceReturnsGetBooksByAuthorDaoResult_EmptyCollection() {
        Deencapsulation.setField(bookService, bookDao);

        new Expectations(){
            {
                bookDao.getBooksByAuthor((Author)any);
                returns(Collections.<Book>emptyList());
            }
        };

        assertTrue(bookService.getBooksByAuthor(new Author()).isEmpty());
    }
}

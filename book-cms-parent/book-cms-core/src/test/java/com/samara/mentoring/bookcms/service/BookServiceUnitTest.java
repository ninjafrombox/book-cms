package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookServiceUnitTest {
    @Mock private BookDao bookDao;
    @InjectMocks private BookService bookService = new BookServiceImpl();

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBooksByAuthor_EmptyCollection() {
        when(bookDao.getBooksByAuthor(any(Author.class))).thenReturn(Collections.<Book>emptyList());
        Collection<Book> books = bookService.getBooksByAuthor(null);
        assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByAuthor_NonEmptyCollection() {
        when(bookDao.getBooksByAuthor(any(Author.class))).thenReturn(Arrays.asList(new Book()));
        Collection<Book> books = bookService.getBooksByAuthor(null);
        assertEquals(1, books.size());
        Book book = books.iterator().next();
        assertNull(book.getTitle());
    }
}

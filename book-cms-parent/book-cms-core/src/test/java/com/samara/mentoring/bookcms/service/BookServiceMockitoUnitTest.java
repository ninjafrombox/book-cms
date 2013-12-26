package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceMockitoUnitTest {
    @Mock private BookDao bookDao;
    @InjectMocks private BookService bookService = new BookServiceImpl();

    @Test
    public void bookServiceCallsGetBooksByAuthorDao() {
        bookService.getBooksByAuthor(null);
        verify(bookDao).getBooksByAuthor(Mockito.any(Author.class));
    }

    @Test
    public void bookServiceCallsGetBooksByAuthorDaoWithPassedAuthor() {
        ArgumentCaptor<Author> author =  ArgumentCaptor.forClass(Author.class);
        Author king = new Author();
        king.setLastName("King");
        bookService.getBooksByAuthor(king);
        verify(bookDao).getBooksByAuthor(author.capture());
        assertThat("King", is(author.getValue().getLastName()));
    }

    @Test
    public void bookServiceReturnsGetBooksByAuthorDaoResult_EmptyCollection() {
        when(bookDao.getBooksByAuthor(Mockito.any(Author.class))).thenReturn(Collections.<Book>emptyList());
        Collection<Book> books = bookService.getBooksByAuthor(null);
        assertTrue(books.isEmpty());
    }

    @Test
    public void bookServiceReturnsGetBooksByAuthorDaoResult_NonEmptyCollection() {
        Book book = new Book();
        book.setTitle("Some book");
        when(bookDao.getBooksByAuthor(Mockito.any(Author.class))).thenReturn(asList(book));
        Collection<Book> books = bookService.getBooksByAuthor(null);
        assertThat(1, is(books.size()));
        assertThat("Some book", is(books.iterator().next().getTitle()));
    }
}

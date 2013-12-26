package com.samara.mentoring.bookcms.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookUnitTest {
    private Book book = new Book();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void defaultAuthorsIsEmptyCollection() {
        Collection<Author> authors = book.getAuthors();
        assertThat(authors, notNullValue());
        assertTrue(authors.isEmpty());
    }

    @Test
    public void authorsIsImmutable() {
        Collection<Author> authors = book.getAuthors();
        exception.expect(UnsupportedOperationException.class);
        authors.add(new Author());
    }
}

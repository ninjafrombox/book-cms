package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;

import java.util.Collection;

/**
 * Operations with books
 */
public interface BookService {
    /**
     * Get all books by its author
     */
    Collection<Book> getBooksByAuthor(Author author);

    /**
     * Get all books by its title
     */
    Collection<Book> getBooksByTitle(String title);
}

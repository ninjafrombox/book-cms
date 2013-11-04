package com.samara.mentoring.bookcms.dao;

import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;

import java.util.Collection;

/**
 * Access to book storage
 *
 * @author ninjafrombox@users.noreply.github.com
 */
public interface BookDao {
    /**
     * Get all books by its author
     */
    Collection<Book> getBooksByAuthor(Author author);

    /**
     * Get all books by its title
     */
    Collection<Book> getBooksByTitle(String title);
}

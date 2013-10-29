package com.samara.mentoring.bookcms.dao;

import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;

import java.util.Collection;

public class BookDaoImpl implements BookDao {
    @Override
    public Collection<Book> getBooksByAuthor(Author author) {
        throw new UnsupportedOperationException();
    }
}

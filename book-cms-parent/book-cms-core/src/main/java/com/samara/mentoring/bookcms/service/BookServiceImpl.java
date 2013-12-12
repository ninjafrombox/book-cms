package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import java.util.Collection;
import javax.inject.Inject;

public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Collection<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Collection<Book> getBooksByAuthor(Author author) {
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public Collection<Book> getBooksByTitle(String title) {
        return bookDao.getBooksByTitle(title);
    }
}

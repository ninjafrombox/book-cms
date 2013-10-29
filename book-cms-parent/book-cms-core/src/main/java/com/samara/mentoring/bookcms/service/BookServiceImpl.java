package com.samara.mentoring.bookcms.service;

import com.samara.mentoring.bookcms.dao.BookDao;
import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Collection<Book> getBooksByAuthor(Author author) {
        return bookDao.getBooksByAuthor(author);
    }
}

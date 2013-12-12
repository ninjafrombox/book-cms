package com.samara.mentoring.bookcms.dao;

import com.samara.mentoring.bookcms.domain.Author;
import com.samara.mentoring.bookcms.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class BookDaoImpl implements BookDao {
    @Resource(lookup="java:jboss/datasources/ExampleDS")
    private DataSource dataSource;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    @Override
    public Collection<Book> getAllBooks() {
        Collection<Book> result;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select id, title, genre from book");
            Map<Long, Book> allBooks = new HashMap<Long, Book>();
            while(rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setGenre(rs.getString("genre"));
                allBooks.put(rs.getLong("id"), book);
            }
            rs.close();
            rs = st.executeQuery("select id, first_name, last_name,"
                    + " middle_name, birth_date from author");
            Map<Long, Author> allAuthors = new HashMap<Long, Author>();
            while(rs.next()) {
                Author author = new Author();
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));
                author.setMiddleName(rs.getString("middle_name"));
                String birthDate = rs.getString("birth_date");
                try {
                    author.setBirthDate(birthDate == null ? null : sdf.parse(birthDate));
                } catch (ParseException e) {
                    author.setBirthDate(null);
                }
                allAuthors.put(rs.getLong("id"), author);
            }
            rs.close();
            rs = st.executeQuery("select id_book, id_author from book_authors");
            while(rs.next()) {
                Long idBook = rs.getLong("id_book");
                Long idAuthor = rs.getLong("id_author");
                allBooks.get(idBook).addAuthor(allAuthors.get(idAuthor));
            }
            rs.close();
            result = allBooks.values();
        } catch (SQLException e) {
            result = null;
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { }
            }
        }
        
        return result;
    }

    @Override
    public Collection<Book> getBooksByAuthor(Author author) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Book> getBooksByTitle(String title) {
        throw new UnsupportedOperationException();
    }
}

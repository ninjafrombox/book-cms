package com.samara.mentoring.bookcms.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains info about book
 *
 * @author ninjafrombox@users.noreply.github.com
 */
public class Book {
    private String title;
    private String genre;
    private Set<Author> authors = new HashSet<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Collection<Author> getAuthors() {
        return Collections.unmodifiableCollection(authors);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }
}

package com.samara.mentoring.bookcms.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains info about book
 */
public class Book {
    private String title;
    private Set<Author> authors = new HashSet<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
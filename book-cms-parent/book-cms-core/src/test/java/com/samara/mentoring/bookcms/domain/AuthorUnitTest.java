package com.samara.mentoring.bookcms.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AuthorUnitTest {
    private Author emptyAuthor  = new Author();
    private Author sameAuthorA  = new Author();
    private Author sameAuthorB  = new Author();
    private Author differentAuthor  = new Author();

    @Before
    public void setUp() {
        Date current = new Date();
        sameAuthorA.setFirstName("Andy");
        sameAuthorB.setFirstName("Andy");
        sameAuthorA.setBirthDate(current);
        sameAuthorB.setBirthDate(current);
        differentAuthor.setFirstName("Andy");
        sameAuthorB.setBirthDate(new Date());
    }

    @Test
    public void emptyAuthorHasNullHashCode() {
        assertThat(emptyAuthor.hashCode(), is(0));
    }

    @Test
    public void emptyAuthorNotEqualOthers() {
        assertFalse(emptyAuthor.equals(sameAuthorA));
        assertFalse(emptyAuthor.equals(sameAuthorB));
        assertFalse(emptyAuthor.equals(differentAuthor));
    }

    @Test
    public void equalAuthorsHasEqualHashCode() {
        assertTrue(sameAuthorA.equals(sameAuthorB));
        assertThat(sameAuthorA.hashCode(), is(sameAuthorB.hashCode()));
    }

    @Test
    public void differentAuthorsNotEqual() {
        assertFalse(sameAuthorA.equals(differentAuthor));
        assertFalse(sameAuthorB.equals(differentAuthor));
    }
}

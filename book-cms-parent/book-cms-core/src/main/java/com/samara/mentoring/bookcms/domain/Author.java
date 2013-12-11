package com.samara.mentoring.bookcms.domain;

import java.util.Date;

/**
 * Contains info about book author
 *
 * @author ninjafrombox@users.noreply.github.com
 */
public class Author {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Author)) return false;
        Author author = (Author)obj;
        return (firstName == null ? author.firstName == null : firstName.equals(author.firstName))
            && (lastName == null ? author.lastName == null : lastName.equals(author.lastName))
            && (middleName == null ? author.middleName == null : middleName.equals(author.middleName))
            && (birthDate == null ? author.birthDate == null : birthDate.equals(author.birthDate));
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}

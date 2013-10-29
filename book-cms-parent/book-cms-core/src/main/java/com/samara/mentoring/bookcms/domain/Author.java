package com.samara.mentoring.bookcms.domain;

/**
 * Contains info about book author
 */
public class Author {
    private String firstName;
    private String lastName;
    private String middleName;

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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Author &&
            (firstName == null ? ((Author) obj).getFirstName() == null :
                firstName.equals(((Author) obj).getFirstName()))
            && (lastName == null ? ((Author) obj).getLastName()== null :
                lastName.equals(((Author) obj).getLastName()))
            && (middleName == null ? ((Author) obj).getMiddleName()== null :
                middleName.equals(((Author) obj).getMiddleName()));
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}

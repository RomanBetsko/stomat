package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "author_books")
public class AuthorBook implements Serializable{

    private static final long serialVersionUID = 6L;

    @Id
    @Column(name = "author_id", nullable = false)
    private int authorId;
    @Id
    @Column(name = "book_id", nullable = false)
    private int bookId;

    public AuthorBook (){}

    public AuthorBook(int authorId, int bookId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "bookId=" + bookId +
                ", authorId=" + authorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorBook)) return false;

        AuthorBook that = (AuthorBook) o;
        return getAuthorId() == that.getAuthorId() && getBookId() == that.getBookId();
    }

    @Override
    public int hashCode() {
        int result = getAuthorId();
        result = 31 * result + getBookId();
        return result;
    }
}

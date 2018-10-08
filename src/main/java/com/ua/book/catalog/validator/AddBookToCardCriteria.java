package com.ua.book.catalog.validator;

import org.hibernate.validator.constraints.NotBlank;


public class AddBookToCardCriteria {

    @NotBlank(message = "name can't empty!")
    private Integer bookId;
    @NotBlank(message = "name can't empty!")
    private Integer readerId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public AddBookToCardCriteria(){}

    public AddBookToCardCriteria(@NotBlank(message = "name can't empty!") Integer bookId, @NotBlank(message = "name can't empty!") Integer readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "AddBookToCardCriteria{" +
                "bookId=" + bookId +
                ", readerId=" + readerId +
                '}';
    }
}

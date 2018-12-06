package com.ua.stomat.appservices.validator;

public class DeleteBookCriteria {

    private Integer bookId;
    private Integer customerId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public DeleteBookCriteria(){}

    public DeleteBookCriteria(Integer bookId, Integer customerId) {
        this.bookId = bookId;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "DeleteBookCriteria{" +
                "bookId=" + bookId +
                ", customerId=" + customerId +
                '}';
    }
}

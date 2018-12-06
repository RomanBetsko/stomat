package com.ua.stomat.appservices.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//@Entity
//@Table(name = "orderbooks")
public class OrderBooks implements Serializable{

    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "readerid", nullable = false)
    private int readerId;
    @Id
    @Column(name = "bookid", nullable = false)
    private int bookId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public OrderBooks(){}

    public OrderBooks(Integer readerId, Integer bookId) {
        this.readerId = readerId;
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "OrderBooks{" +
                "readerId=" + readerId +
                ", bookId=" + bookId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderBooks)) return false;
        OrderBooks that = (OrderBooks) o;
        if (getReaderId() != that.getReaderId()) return false;
        return getBookId() == that.getBookId();

    }

    @Override
    public int hashCode() {
        int result = getReaderId();
        result = 31 * result + getBookId();
        return result;
    }
}

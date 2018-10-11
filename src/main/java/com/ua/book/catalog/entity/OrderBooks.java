package com.ua.book.catalog.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orderbooks")
public class OrderBooks implements Serializable{

    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "readerid", nullable = false)
    private Integer readerId;
    @Id
    @Column(name = "bookid", nullable = false)
    private Integer bookId;

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
}

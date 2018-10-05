package com.ua.book.catalog.objects;


import com.ua.book.catalog.entity.OrderBooks;

import java.util.List;

public class OrderCard {

    private int numberOfItems;
    private List<OrderBooks> books;

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<OrderBooks> getBooks() {
        return books;
    }

    public void setBooks(List<OrderBooks> books) {
        this.books = books;
    }

    public OrderCard() {}

    public OrderCard(int numberOfItems, List<OrderBooks> books) {
        this.numberOfItems = numberOfItems;
        this.books = books;
    }

    @Override
    public String toString() {
        return "OrderCard{" +
                "numberOfItems=" + numberOfItems +
                ", books=" + books +
                '}';
    }
}

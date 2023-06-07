package com.codecool.old_book_auction.model;

import java.util.ArrayList;

public class Book {
    private final int id;
    private final Topic topic;
    private final String title;
    private final int price;

    public Book(int id, String title, Topic topic, int price) {
        this.id = id;
        this.topic = topic;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", topic=" + topic +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}


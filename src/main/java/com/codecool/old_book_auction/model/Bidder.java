package com.codecool.old_book_auction.model;

import java.util.ArrayList;
import java.util.List;

public class Bidder {
    private final String name;
    private double capital;
    private final Topic favourite;
    private final Topic[] interested;
    private final List<Book> books;

    public Bidder(int id, double capital, Topic favourite, Topic[] interested) {
        this.name = "Bidder #" + id;
        this.capital = capital;
        this.favourite = favourite;
        this.interested = interested;
        this.books = new ArrayList<>();
    }

    public boolean isInterested(Book book) {
        Topic bookTopic = book.getTopic();
        int bookPrice = book.getPrice();
        Topic interest1 = this.interested[0];
        Topic interest2 = this.interested[1];
        boolean canAfford = this.capital > bookPrice;

        return ((this.favourite == bookTopic || interest1 == bookTopic || interest2 == bookTopic) && canAfford);
    }

    public void purchaseBook(Book book) {
        books.add(book);
        capital -= book.getPrice();
    }

    public double getThreshold() {
        if (favourite == null) {
            return capital;
        } else if (favourite.equals(interested[0])) {
            return capital * 0.25;
        } else {
            return capital * 0.5;
        }
    }

    public String getName() {
        return name;
    }

    // Getters and setters
}

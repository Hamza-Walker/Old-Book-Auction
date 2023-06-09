package com.codecool.old_book_auction.model;

import java.util.ArrayList;
import java.util.List;

public class Bidder {
    private int id;
    private String name;
    private double capital;
    private Topic favourite;
    private Topic[] interested;
    private List<Book> books;

    public Bidder(int id, double capital, Topic favourite, Topic[] interested) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Topic getFavourite() {
        return favourite;
    }

    public void setFavourite(Topic favourite) {
        this.favourite = favourite;
    }

    public Topic[] getInterested() {
        return interested;
    }

    public void setInterested(Topic[] interested) {
        this.interested = interested;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Getters and setters
}

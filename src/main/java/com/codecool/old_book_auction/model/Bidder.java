package com.codecool.old_book_auction.model;

import java.util.*;
import java.util.stream.Collectors;

public class Bidder {
    private final ArrayList<Book> books = new ArrayList<Book>();
    private final Topic favourite;
    private final Topic[] interested;
    private int id;
    private String name;
    private double capital;

    public Bidder(int id, double capital, Topic favourite, Topic[] interested) {
        this.id = id;
        this.name = "Bidder #" + id;
        this.capital = capital;
        this.favourite = favourite;
        this.interested = interested;
    }

    private static int getBidPrice(int currentPrice, int threshold) {
        return 0;
        //TODO
    }

    public boolean interested(Book book) {
        return false;
        //TODO
    }

    public boolean canBid(Book book, int currentPrice) {
        return false;
        //TODO
    }

    public Bid getBid(Book book, Bid currentBid) {
        return null;
        //TODO
    }

    private int getThresholdPrice(Topic topic) {
        return 0;
        //TODO
    }

    public void buyBook(Book book) {
        //TODO
    }

    @Override
    public String toString() {
        return "Bidder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", favourite=" + favourite +
                ", interested=" + Arrays.toString(interested) +
                ", capital=" + capital +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bidder bidder = (Bidder) o;
        return Double.compare(bidder.capital, capital) == 0 && id == bidder.id && Objects.equals(books, bidder.books) && favourite == bidder.favourite && Arrays.equals(interested, bidder.interested) && Objects.equals(name, bidder.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(books, favourite, capital, id, name);
        result = 31 * result + Arrays.hashCode(interested);
        return result;
    }
}

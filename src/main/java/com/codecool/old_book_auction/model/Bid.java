package com.codecool.old_book_auction.model;

public class Bid {
    private static int nextId = 1;
    private int id;
    private Bidder bidder;
    private int bidPrice;

    public Bid(Bidder bidder, int bidPrice) {
        this.id = nextId++;
        this.bidder = bidder;
        this.bidPrice = bidPrice;
    }

    public int getId() {
        return id;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public int getBidPrice() {
        return bidPrice;
    }
}

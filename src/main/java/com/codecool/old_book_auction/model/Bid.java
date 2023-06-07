package com.codecool.old_book_auction.model;

public class Bid {
    private final int id;
    private final Bidder bidder;
    private final int bidPrice;

    public int getId() {
        return id;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public Bid(int id, Bidder bidder, int bidPrice) {
        this.id = id;
        this.bidder = bidder;
        this.bidPrice = bidPrice;
    }
}

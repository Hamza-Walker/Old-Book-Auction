package com.codecool.old_book_auction.controller;

import com.codecool.old_book_auction.model.Bid;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Auction {
    private List<Bidder> bidders;
    private List<Book> books;
    private Random random;

    public Auction(Random random, List<Book> books, List<Bidder> bidders) {
        this.bidders = bidders;
        this.books = books;
        this.random = random;
    }

    /*public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }*/

    public void addBidder(Bidder... bidder) {
        bidders.addAll(List.of(bidder));
    }
    public void addBidder(List<Bidder> bidders) {
        bidders.addAll(bidders);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void startAuction() {
        for (Book book : books) {
            List<Bidder> interestedBidders = getInterestedBidders(book);
            if (interestedBidders.isEmpty()) {
                System.out.println("No bidders for the book: " + book.getTitle());
                continue;
            }

            int currentPrice = book.getPrice();
            Bidder winner = null;
            while (interestedBidders.size() > 1) {
                Bidder bidder = getRandomBidder(interestedBidders);
                int nextBidPrice = calculateNextBidPrice(bidder, currentPrice);
                Bid newBid = new Bid(bidder, nextBidPrice);
                if (newBid.getBidPrice() > currentPrice) {
                    System.out.println(newBid.getBidder().getName() + " placed a bid of $" + newBid.getBidPrice()
                            + " for the book: " + book.getTitle());
                    currentPrice = newBid.getBidPrice();
                } else {
                    System.out.println(newBid.getBidder().getName() + " cannot place a bid higher than the current price.");
                    interestedBidders.remove(bidder); // Remove the bidder who cannot place a higher bid
                }
            }

            winner = interestedBidders.get(0);
            System.out.println("The winner of the book " + book.getTitle() + " is " + winner.getName());
            winner.purchaseBook(book);
        }
    }


    private List<Bidder> getInterestedBidders(Book book) {
        return bidders.stream()
                .filter(bidder -> bidder.isInterested(book))
                .collect(Collectors.toList());
    }

    private Bidder getRandomBidder(List<Bidder> bidders) {
        int randomIndex = random.nextInt(bidders.size());
        return bidders.get(randomIndex);
    }

    private int calculateNextBidPrice(Bidder bidder, int currentPrice) {
        double threshold = bidder.getThreshold();
        int range = (int) Math.ceil((threshold - currentPrice) / 2);
        return currentPrice + range;
    }
}

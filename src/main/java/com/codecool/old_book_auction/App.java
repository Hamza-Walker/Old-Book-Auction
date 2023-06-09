package com.codecool.old_book_auction;


import com.codecool.old_book_auction.controller.Auction;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topic;


public class App {
    public static void main(String[] args) {
        Auction auction = new Auction();

        Bidder bidder1 = new Bidder(1, 1000, Topic.ARCHEOLOGY, new Topic[]{Topic.ASTRONOMY, Topic.HISTORY});
        Bidder bidder2 = new Bidder(2, 800, Topic.ASTRONOMY, new Topic[]{Topic.ARCHEOLOGY, Topic.MEDICINE});
        Bidder bidder3 = new Bidder(3, 1500, Topic.MEDICINE, new Topic[]{Topic.CHEMISTRY, Topic.PHYSICS});

        auction.addBidder(bidder1);
        auction.addBidder(bidder2);
        auction.addBidder(bidder3);

        Book book1 = new Book(1, "Book 1", Topic.ARCHEOLOGY, 300);
        Book book2 = new Book(2, "Book 2", Topic.ASTRONOMY, 400);
        Book book3 = new Book(3, "Book 3", Topic.CHEMISTRY, 500);

        auction.addBook(book1);
        auction.addBook(book2);
        auction.addBook(book3);

        auction.startAuction();
    }
}

package com.codecool.old_book_auction;

import com.codecool.old_book_auction.data.BidderGenerator;
import com.codecool.old_book_auction.controller.Auction;
import com.codecool.old_book_auction.data.BookGenerator;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topic;


public class App {
    public static void main(String[] args) {
        BidderGenerator bidderGenerator = new BidderGenerator(5, 500, 1500);
        Auction auction = new Auction();

        bidderGenerator.getBidders().forEach(auction::addBidder);

        BookGenerator bookGenerator = new BookGenerator();
        for (int i = 0; i < 10; i++) {
            Book book = bookGenerator.generateBook(100, 500);
            auction.addBook(book);
        }

        auction.startAuction();
    }
}

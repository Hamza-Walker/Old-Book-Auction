package com.codecool.old_book_auction;

import com.codecool.old_book_auction.controller.Auction;
import com.codecool.old_book_auction.data.BidderGenerator;
import com.codecool.old_book_auction.data.BookGenerator;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topic;

public class App {
    public static void main(String[] args) {
        final int bookCount = 20;
        final int minPrice = 100;
        final int maxPrice = 300;


        final int bidderCount = 10;
        final int minimumCapital = 100;
        final int maximumCapital = 1000;

        BookGenerator bookGenerator = new BookGenerator();
        Book oneBook = bookGenerator.genarateBook(minPrice,maxPrice);
        BidderGenerator bidders =  new BidderGenerator(bidderCount,minimumCapital,maximumCapital);

        printMessage(oneBook);

        for (int i = 0; i < bidders.getBidders().size(); i++) {
            Bidder currentBidder = bidders.getBidders().get(i);
            printMessage(currentBidder);
            printMessage(currentBidder.isInterested(oneBook));
        }
    }

    public static <T> void printMessage (T message) {
        System.out.println(message);
    }
}

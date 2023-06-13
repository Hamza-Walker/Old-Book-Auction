package com.codecool.old_book_auction;

import com.codecool.old_book_auction.data.BidderGenerator;
import com.codecool.old_book_auction.controller.Auction;
import com.codecool.old_book_auction.data.BookGenerator;
import com.codecool.old_book_auction.model.Book;


public class App {
    public static void main(String[] args) {
        Random random = new Random();
        List<Book> books = new ArrayList<>();
        List<Book> bidders = new ArrayList<>();

        Auction auction = new Auction(random, books, bidders);
        BidderGenerator bidderGenerator = new BidderGenerator(random, bidders, 5, 500, 1500);
        bidderGenerator.generateBidders();
        //bidderGenerator.getBidders().forEach(auction::addBidder);
        auction.addBidder(bidderGenerator.getBidders());
        BookGenerator bookGenerator = new BookGenerator(auction, random);
        bookGenerator.initBookNames();
        bookGenerator.generateRandomBooks();
        auction.startAuction();
    }
}

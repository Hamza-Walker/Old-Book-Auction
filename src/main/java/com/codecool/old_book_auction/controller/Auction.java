package com.codecool.old_book_auction.controller;

import com.codecool.old_book_auction.data.BidderGenerator;
import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Book;

import java.util.ArrayList;

public class Auction {
    private Book chosenBook;

    public Auction(Book book) {
        this.chosenBook = book;
    }

   // public ArrayList<Bidder> filter(BidderGenerator bidderGenerator) {
      //  for (int i = 0; i < bidderGenerator; i++) {

      //  }
    //}


    @Override
    public String toString() {
        return "Auction{" +
                ", chosenBook=" + chosenBook +
                '}';
    }
}

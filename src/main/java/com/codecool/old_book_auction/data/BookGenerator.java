package com.codecool.old_book_auction.data;

import com.codecool.old_book_auction.controller.Auction;
import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BookGenerator {
    private final String[] bookNames;
    private int currentId = 0;

    private Auction auction;
    private Random random;

    public BookGenerator(Auction auction, Random random) {
        this.auction = auction;
        this.random = random;
    }

    public void initBookNames() {
        bookNames.getNames();
    }

    public void generateRandomBooks() {
        //TODO: magic numbers
        for (int i = 0; i < 10; i++) {
            Book book = generateBook(100, 500);
            auction.addBook(book);
        }
    }

    public Book generateBook ( int min, int max) {
        int id = currentId++;
        Topic randomTopic =
                Topic.values()[random.nextInt(Topic.values().length)];
        int price = random.nextInt(min, max);
        return new Book(id, bookNames[id], randomTopic, price);
    }
    private String[] getNames() {
        String[] bookNames = new String[20];

        bookNames[0] = "To Kill a Mockingbird";
        bookNames[1] = "1984";
        bookNames[2] = "The Great Gatsby";
        bookNames[3] = "Pride and Prejudice";
        bookNames[4] = "The Catcher in the Rye";
        bookNames[5] = "The Hobbit";
        bookNames[6] = "The Lord of the Rings";
        bookNames[7] = "Moby Dick";
        bookNames[8] = "Jane Eyre";
        bookNames[9] = "The Chronicles of Narnia";
        bookNames[10] = "Brave New World";
        bookNames[11] = "Gone with the Wind";
        bookNames[12] = "The Grapes of Wrath";
        bookNames[13] = "The Picture of Dorian Gray";
        bookNames[14] = "Wuthering Heights";
        bookNames[15] = "The Odyssey";
        bookNames[16] = "Hamlet";
        bookNames[17] = "Don Quixote";
        bookNames[18] = "The Adventures of Huckleberry Finn";
        bookNames[19] = "The Scarlet Letter";

        return bookNames;
    }


}

package com.codecool.old_book_auction.data;

import com.codecool.old_book_auction.model.Book;
import com.codecool.old_book_auction.model.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BookGenerator {

    private static final Random RANDOM = new Random();
    public final String[] bookNames = getNames();
    private int currentId = 0;
    public Book genarateBook ( int min, int max) {
        int id = currentId++;

        Topic randomTopic = Topic.values()[RANDOM.nextInt(Topic.values().length)];
        int price = RANDOM.nextInt(min, max);
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

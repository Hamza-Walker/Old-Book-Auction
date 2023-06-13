package com.codecool.old_book_auction.data;

import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BidderGenerator {
    private static final Random RANDOM = new Random();
    private final List<Bidder> bidders = new ArrayList<>();


    public BidderGenerator (int amount, int minCapital, int maxCapital){

        for (int i = 0; i < amount; i++) {
            Topic[] shuffledTopics = shuffleTopics();

            Topic favourite = shuffledTopics[0];
            Topic[] interested = new Topic[]{shuffledTopics[1], shuffledTopics[2]};
            int capital = RANDOM.nextInt(minCapital, maxCapital);

            Bidder bidder = new Bidder(i + 1, capital, favourite, interested);
            bidders.add(bidder);
        }

    }

    private Topic[] shuffleTopics() {
        Topic[] shuffledTopics = Topic.values();

        for (int i = shuffledTopics.length - 1; i > 0; i--) {
            Topic lastTopic = shuffledTopics[i];
            int randomInt = RANDOM.nextInt(i);
            Topic temp = shuffledTopics[randomInt];

            shuffledTopics[randomInt] = lastTopic;
            shuffledTopics[i] = temp;
        }

        return shuffledTopics;
    }
    public List<Bidder> getBidders() {
        return bidders;
    }

    @Override
    public String toString() {
        return "BidderGenerator{" +
                "bidders=" + bidders +
                '}';
    }
}

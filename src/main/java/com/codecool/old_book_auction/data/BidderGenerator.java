package com.codecool.old_book_auction.data;

import com.codecool.old_book_auction.model.Bidder;
import com.codecool.old_book_auction.model.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BidderGenerator {
    private final List<Bidder> bidders;
    private int amount;
    private int minCapital;
    private int maxCapital;

    private Random random;

    public BidderGenerator(Random random, List<Bidder> bidders, int amount, int minCapital, int maxCapital) {
        this.bidders = bidders;
        this.amount = amount;
        this.minCapital = minCapital;
        this.maxCapital = maxCapital;
    }

    public void generateBidders() {
        for (int i = 0; i < amount; i++) {
            Topic[] shuffledTopics = shuffleTopics();

            Topic favourite = shuffledTopics[0];
            Topic[] interested = new Topic[]{shuffledTopics[1], shuffledTopics[2]};
            int capital = random.nextInt(minCapital, maxCapital);

            Bidder bidder = new Bidder(i + 1, capital, favourite, interested);
            bidders.add(bidder);
        }
    }

    private Topic[] shuffleTopics() {
        //List<Topic> topics = Arrays.asList(Topic.values());
        //Collection.shuffle(topics).toArray();
        //return topics.toArray();
        Topic[] shuffledTopics = Topic.values();

        for (int i = shuffledTopics.length - 1; i > 0; i--) {
            Topic lastTopic = shuffledTopics[i];
            int randomInt = random.nextInt(i);
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

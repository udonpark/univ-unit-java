package Week4Bootcamp.edu.monash.fit2099.bids;

import Week4Bootcamp.edu.monash.fit2099.AutoShowroom;
import Week4Bootcamp.edu.monash.fit2099.bids.Bid;
import Week4Bootcamp.edu.monash.fit2099.buyers.Buyer;

import java.util.HashMap;
import java.util.Random;

public class BidsManager {
    private final HashMap<Integer, Bid> bidMap = new HashMap<>();

    public void addBid(int buyerId, double bidPrice, String bidDate){
        Bid newBid = new Bid(nextID(), new Buyer(buyerId), bidPrice, bidDate);
        this.bidMap.put(buyerId, newBid);
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}

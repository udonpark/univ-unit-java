package Week4Bootcamp.edu.monash.fit2099.bids;

import Week4Bootcamp.edu.monash.fit2099.bids.Bid;
import Week4Bootcamp.edu.monash.fit2099.buyers.Buyer;

import java.util.HashMap;
import java.util.Random;

public class BidsManager {
    public HashMap<Integer, Bid> bidMap = new HashMap<Integer, Bid>();

    public void addBid(int buyerId, double bidPrice, String bidDate){
        Bid newBid = new Bid(nextID(), new Buyer(buyerId), bidPrice, bidDate);
        this.bidMap.put(buyerId, newBid);
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}

package Week5Bootcamp.edu.monash.fit2099.bids;

import Week5Bootcamp.edu.monash.fit2099.buyers.Buyer;
import Week5Bootcamp.edu.monash.fit2099.exceptions.BidException;

import java.util.HashMap;
import java.util.Random;

public class BidsManager {
    private final HashMap<Integer, Bid> bidMap;
    public BidsManager(){
        bidMap = new HashMap<>();
    }

//    public void addBid(int buyerId, double bidPrice, String bidDate){
//        System.out.println(AutoShowroom.getBuyer(buyerId));
//        Bid newBid = new Bid(nextID(), AutoShowroom.getBuyer(buyerId), bidPrice, bidDate);
//        this.bidMap.put(buyerId, newBid);
//    }

    public void addBidBuyer(Buyer buyer, double bidPrice, String bidDate){
        try {
            Bid newBid = new Bid(nextID(), buyer, bidPrice, bidDate);
            this.bidMap.put(buyer.getBuyerId(), newBid);
            System.out.println("Bid added!");
        }catch (BidException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeBidBuyer(int buyerId){
        this.bidMap.remove(buyerId);
    }

    public Bid getBid(int buyerId){
        return bidMap.get(buyerId);
    }
    public int getSize(){
        return bidMap.size();
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}

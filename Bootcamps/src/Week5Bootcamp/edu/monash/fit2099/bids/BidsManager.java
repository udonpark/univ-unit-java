package Week5Bootcamp.edu.monash.fit2099.bids;

import Week5Bootcamp.edu.monash.fit2099.buyers.Buyer;
import Week5Bootcamp.edu.monash.fit2099.exceptions.BidException;
import Week5Bootcamp.edu.monash.fit2099.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Random;
/**
 * This is a BidManager class
 * @see Vehicle
 * @author Yo Kogure
 * @version 1.1
 * @since 29/08/2021
 */
public class BidsManager {
    /**
     *  bidMap is a hashmap storing BidManager data
     */
    private final HashMap<Integer, Bid> bidMap;

    /**
     * empty parameter constructor that initializes bidMap
     */
    public BidsManager(){
        bidMap = new HashMap<>();
    }

//    public void addBid(int buyerId, double bidPrice, String bidDate){
//        System.out.println(AutoShowroom.getBuyer(buyerId));
//        Bid newBid = new Bid(nextID(), AutoShowroom.getBuyer(buyerId), bidPrice, bidDate);
//        this.bidMap.put(buyerId, newBid);
//    }

    /**
     * method that adds object to a HashMap
     * @param buyer buyer object
     * @param bidPrice double showing the bid price, has to be >= 0
     * @param bidDate string showing date, has to be dd/mm/yyyy format
     */
    public void addBidBuyer(Buyer buyer, double bidPrice, String bidDate) throws BidException{
        Bid newBid = new Bid(nextID(), buyer, bidPrice, bidDate);
        this.bidMap.put(buyer.getBuyerId(), newBid);
        System.out.println("Bid added!");
    }

    /**
     * removes an object from the hashmap
     * @param buyerId integer ID representing buyer
     */
    public void removeBidBuyer(int buyerId){
        this.bidMap.remove(buyerId);
    }

    /**
     * getter for getting Bid object from the buyer id
     * @param buyerId buyer id to look up in hashmap
     * @return Bid object that corresponds to buyerId
     */
    public Bid getBid(int buyerId){
        return bidMap.get(buyerId);
    }

    /**
     *
     * @return gets the number of bids stored in bidMap
     */
    public int getSize(){
        return bidMap.size();
    }

    /**
     * helper code that generates random integer
     * @return random integer with 5 digits
     */
    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}

package Week4Bootcamp.edu.monash.fit2099.vehicles;
import Week4Bootcamp.edu.monash.fit2099.bids.Bid;
import Week4Bootcamp.edu.monash.fit2099.bids.BidsManager;
import Week4Bootcamp.edu.monash.fit2099.buyers.Buyer;

import java.util.Random;

abstract public class Vehicle {
    private final String maker;
    private final String model;
    private final int vId;
    private final BidsManager bids = new BidsManager();

//    public void addBid(int newBuyer, double price, String date){
//        this.bids.addBid(newBuyer, price, date);
//    }
    public void addBidBuyer(Buyer newBuyer, double price, String date){
        this.bids.addBidBuyer(newBuyer, price, date);
    }


    public int getBidNum(){
        return bids.getSize();
    }

    public Bid getBid(int key){
        return bids.getBid(key);
    }

    public Vehicle(String maker, String model){
        this.maker = maker;
        this.model = model;
        this.vId = nextID();
    }

    public Vehicle(String maker, String model, int vId){
        this.maker = maker;
        this.model = model;
        this.vId = vId;
    }

    public int getvId(){
        return this.vId;
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public String description(){
        return "Maker:" + this.maker + " and" + " Model:" + this.model;
    }

}
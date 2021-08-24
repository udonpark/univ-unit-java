package Week4Bootcamp.edu.monash.fit2099.vehicles;
import Week4Bootcamp.edu.monash.fit2099.bids.Bid;
import Week4Bootcamp.edu.monash.fit2099.bids.BidsManager;

import java.util.Random;

abstract public class Vehicle {
    private final String maker;
    private final String model;
    private int vId;
    private BidsManager bids = new BidsManager();

    public void addBid(int newBuyer, int price, String date){
        this.bids.addBid(newBuyer, price, date);
    }

    public Bid getBid(int i){
        return this.bids.bidMap.get(i); // use i to obtain n-th element of the bid
    }

    public int getBidNum(){
        return this.bids.bidMap.size();
    }

    public Vehicle(String maker, String model){
        this.maker = maker;
        this.model = model;
    }

    public Vehicle(String maker, String model, int vId){
        this.maker = maker;
        this.model = model;
        this.vId = vId;
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

// code from task 3:
// public String getCarDescription(){
// return make + model;
// }
}
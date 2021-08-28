package Week5Bootcamp.edu.monash.fit2099.vehicles;
import Week5Bootcamp.edu.monash.fit2099.bids.Bid;
import Week5Bootcamp.edu.monash.fit2099.bids.BidsManager;
import Week5Bootcamp.edu.monash.fit2099.buyers.Buyer;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;

import java.util.Random;

abstract public class Vehicle {
    private String maker;
    private String model;
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

    public Vehicle(String maker, String model) throws VehicleException {
        if (setMaker(maker) && setModel(model)) {
            vId = nextID();
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }
    }
// I am commenting below out for this bootcamp, since we have only been using the former method
//    public Vehicle(String maker, String model, int vId){
//        this.maker = maker;
//        this.model = model;
//        this.vId = vId;
//    }

    public boolean setMaker(String maker) {
        boolean isValid=false;
        if(maker.length()>=3 && maker.length()<=15){
            isValid=true;
            this.maker = maker;
        }
        return isValid;
    }

    public boolean setModel(String model) {
        boolean isValid=false;
        if(model.length()>=3 && model.length()<=15){
            isValid=true;
            this.model = maker;
        }
        return isValid;
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
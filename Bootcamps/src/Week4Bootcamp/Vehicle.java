package Week4Bootcamp;
import java.util.ArrayList;
import java.util.Random;

abstract public class Vehicle {
    private final String maker;
    private final String model;
    private int vId;
    private final ArrayList<Bid> bids = new ArrayList<>();

    public void addBid(Buyer newBuyer, int price, String date){
        this.bids.add(new Bid(nextID(), newBuyer, price, date));
    }

    public Bid getBid(int i){
        return this.bids.get(i); // use i to obtain n-th element of the bid
    }

    public int getBidNum(){
        return this.bids.size();
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
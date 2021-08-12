package Week3Bootcampp;
import java.util.ArrayList;
import java.util.Random;

public class Car {
    private final String make;
    private final String model;
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

    public Car(String make, String model){
        this.make = make;
        this.model = model;
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public String description(){
        return "Maker:" + this.make + " and" + " Model:" + this.model;
    }

// code from task 3:
// public String getCarDescription(){
// return make + model;
// }
}
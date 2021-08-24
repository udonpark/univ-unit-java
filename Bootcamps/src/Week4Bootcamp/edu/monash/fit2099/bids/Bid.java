package Week4Bootcamp.edu.monash.fit2099.bids;

import Week4Bootcamp.edu.monash.fit2099.buyers.Buyer;

public class Bid {
    private int bidId;
    private Buyer buyer;
    private double bidPrice;
    private String bidDate;

    public Bid(int newBidId, Buyer newBuyer, double newBidPrice, String newBidDate){
        this.bidId = newBidId;
        this.buyer = newBuyer;
        this.bidPrice = newBidPrice;
        this.bidDate = newBidDate;
    }
    // I have made sure that these constuctors and mutator/acceesors do work as intended.
    // They are also shown in the AutoShowroom in Task 5.
    public void setBidId(int newBidId){
        this.bidId = newBidId;
    }

    public void setBuyer(Buyer newBuyer){
        this.buyer = newBuyer;
    }

    public void setBidPrice(int newBidPrice){
        this.bidPrice = newBidPrice;
    }

    public void setBidDate(String newBidDate){
        this.bidDate = newBidDate;
    }

    public int getBidId(){
        return bidId;
    }

    public Buyer getBuyer(){
        return buyer;
    }

    public double getBidPrice(){
        return bidPrice;
    }

    public String getBidDate(){
        return bidDate;
    }

}

package Week4Bootcamp;

public class Bid {
    private int bidId;
    private Buyer buyer;
    private int bidPrice;
    private String bidDate;

    public Bid(int newBidId, Buyer newBuyer, int newBidPrice, String newBidDate){
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

    public int getBidPrice(){
        return bidPrice;
    }

    public String getBidDate(){
        return bidDate;
    }

}

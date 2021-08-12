package Week3Bootcampp;

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

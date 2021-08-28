package Week5Bootcamp.edu.monash.fit2099.bids;

import Week5Bootcamp.edu.monash.fit2099.buyers.Buyer;


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

    public boolean setBidPrice(int price) {
        boolean isValid = false;
        if(price >= 0){
            isValid=true;
            this.bidPrice = price;
        }
        return isValid;
    }
    public boolean setDate(String date) {
        // I am using Calender since there was a post on Ed that I could discover any option using existing JDK library.
        boolean isValid = false;
        boolean dd = false;
        boolean mm = false;
        boolean yyyy = false;
        int temp;

        // check for dd first, in dd/mm/yyyy format
        // when converting string integer, I have referred to:
        // https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
        try {
            temp = Integer.parseInt(date.substring(0, 2));
        }
        catch (NumberFormatException e)
        {
            temp = -1;
        }
        if (temp >= 1 && temp <= 31){
            dd = true;
        }
        // check mm
        try {
            temp = Integer.parseInt(date.substring(3, 2));
        }
        catch (NumberFormatException e)
        {
            temp = -1;
        }
        if (temp >= 1 && temp <= 12){
            mm = true;
        }
        // check yyyy
        try {
            temp = Integer.parseInt(date.substring(6, 4));
        }
        catch (NumberFormatException e)
        {
            temp = -1;
        }
        if (temp >= 1 && temp <= 31){
            yyyy = true;
        }


        if(dd && mm && yyyy && (date.substring(2, 1) == "/") && (date.substring(5, 1) == "/")){
            isValid=true;
            this.bidDate= date;
        }
        return isValid;
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

package Week3Bootcampp;

public class Buyer {
    int buyerId;
    String givenName;
    String familyName;
    // Comments are in Justifications.txt

    public Buyer(int newBuyerId){
        this.buyerId = newBuyerId;
    }

    public Buyer(int newBuyerId, String newGivenName, String newFamilyName){
        this.buyerId = newBuyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public void setGivenName(String newGivenName){
        this.givenName = newGivenName;
    }

}

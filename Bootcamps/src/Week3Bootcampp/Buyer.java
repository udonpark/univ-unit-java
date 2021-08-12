package Week3Bootcampp;

public class Buyer {
    private int buyerId;
    private String givenName;
    private String familyName;
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

    public void setFamilyName(String newFamilyName){
        this.familyName = newFamilyName;
    }

    public String description(){
        return Integer.toString(this.buyerId) + " " + this.givenName + " " + this.familyName;
    }
}

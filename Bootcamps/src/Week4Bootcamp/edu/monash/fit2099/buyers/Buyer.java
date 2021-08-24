package Week4Bootcamp.edu.monash.fit2099.buyers;

public class Buyer {
    private final int buyerId;
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
    // these setters are tested. It is also used in the AutoShoroom.
    public int getBuyerId(){ return this.buyerId; }

    public String description(){
        return this.buyerId + " " + this.givenName + " " + this.familyName;
    }
}

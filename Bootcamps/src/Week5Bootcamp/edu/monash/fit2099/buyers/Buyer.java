package Week5Bootcamp.edu.monash.fit2099.buyers;

import java.util.Random;

public class Buyer {
    private final int buyerId;
    private String givenName;
    private String familyName;
    // Comments are in Justifications.txt

    private Buyer(){
        this.buyerId = nextID();
    }

    private Buyer(int newBuyerId, String newGivenName, String newFamilyName){
        this.buyerId = newBuyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public static Buyer getInstance(String givenName, String familyName){
        Buyer newBuyer = new Buyer();
        if (newBuyer.setGivenName(givenName) && newBuyer.setFamilyName(familyName)){
            return newBuyer;
        }else{
            return null;
        }
    }

    public boolean setGivenName(String givenName) {
        boolean isValid = false;
        if(givenName.length()>=2 && givenName.length()<=15){
            isValid=true;
            this.givenName = givenName;
        }
        return isValid;
    }

    public boolean setFamilyName(String familyName) {
        boolean isValid = false;
        if(familyName.length()>=2 && familyName.length()<=15){
            isValid=true;
            this.familyName = familyName;
        }
        return isValid;
    }
    // these setters are tested. It is also used in the AutoShoroom.
    public int getBuyerId(){ return this.buyerId; }

    public String description(){
        return this.buyerId + " " + this.givenName + " " + this.familyName;
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}

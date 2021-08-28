package Week5Bootcamp.edu.monash.fit2099.buyers;

import Week5Bootcamp.edu.monash.fit2099.vehicles.Vehicle;

import java.util.Random;

/**
 * This is a Buyer class, it stores buyer information and is accessed by many other classes
 * @author Yo Kogure
 * @version 1.1
 * @since 29/08/2021
 */
public class Buyer {
    /**
     * buyerId stores an integer showing the ID of the buyer, generated randoomly usually
     * givenName stores a string of the given name of the buyer
     * familyName stores a string of the family name of the buyer
     */
    private final int buyerId;
    private String givenName;
    private String familyName;
    // Comments are in Justifications.txt

    /**
     * private constructor, it just sets up buyerId to random integer. This constructor is
     * to be used in static factory method
     */
    private Buyer(){
        this.buyerId = nextID();
    }

//    private Buyer(int newBuyerId, String newGivenName, String newFamilyName){
//        this.buyerId = newBuyerId;
//        this.givenName = newGivenName;
//        this.familyName = newFamilyName;
//    }

    /**
     * Assigns attributes and acts as validity check. This is used instead of usualy Constructor,
     * to be able to cope with the Exception as well
     * @param givenName string of the given name
     * @param familyName string of the family name
     * @return returns object of Buyer if within range, null otherwise
     */
    public static Buyer getInstance(String givenName, String familyName){
        Buyer newBuyer = new Buyer();
        if (newBuyer.setGivenName(givenName) && newBuyer.setFamilyName(familyName)){
            return newBuyer;
        }else{
            return null;
        }
    }

    /**
     * setter for given name, which checks its validity
     * @param givenName string of the given name
     * @return true if givenName within range, false otherwise
     */
    public boolean setGivenName(String givenName) {
        boolean isValid = false;
        if(givenName.length()>=2 && givenName.length()<=15){
            isValid=true;
            this.givenName = givenName;
        }
        return isValid;
    }

    /**
     * setter for family name, which also checks its validity
     * @param familyName string of the family name
     * @return true if family name iwthin range, false otherwise
     */
    public boolean setFamilyName(String familyName) {
        boolean isValid = false;
        if(familyName.length()>=2 && familyName.length()<=15){
            isValid=true;
            this.familyName = familyName;
        }
        return isValid;
    }
    // these setters are tested. It is also used in the AutoShoroom.

    /**
     * getter for bueyr Id
     * @return integer, representing a buyer ID
     */
    public int getBuyerId(){ return this.buyerId; }

    /**
     * Shows a string concatenated which helps with visualizing description
     * @return a string showing the description of the Buyer, ID, givenName adn familyName
     */
    public String description(){
        return this.buyerId + " " + this.givenName + " " + this.familyName;
    }

    /**
     * A helper funciton to generate
     * @return A random integer 5 digits
     */
    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}

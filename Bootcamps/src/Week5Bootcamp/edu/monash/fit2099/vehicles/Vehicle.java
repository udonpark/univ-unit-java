package Week5Bootcamp.edu.monash.fit2099.vehicles;
import Week5Bootcamp.edu.monash.fit2099.bids.Bid;
import Week5Bootcamp.edu.monash.fit2099.bids.BidsManager;
import Week5Bootcamp.edu.monash.fit2099.buyers.Buyer;
import Week5Bootcamp.edu.monash.fit2099.exceptions.BidException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;

import java.util.Random;

/**
 * This is a Vehicle, abstract class
 * @author Yo Kogure
 * @version 1.1
 * @since 29/08/2021
 */


abstract public class Vehicle {
    /**
     * maker: String storing maker
     * model: String storing model
     * vId: Integer storing Vehicle ID
     * bids: an instance of BidsManager, a Hashmap connecting Buyer ID and Bid
     * @see BidsManager
     */
    private String maker;
    private String model;
    private final int vId;
    private final BidsManager bids = new BidsManager();

//    public void addBid(int newBuyer, double price, String date){
//        this.bids.addBid(newBuyer, price, date);
//    }

    /**
     * A main method I will be using to add Buyer and Bid object to HashMap
     * @param newBuyer Buyer object to be added to the BidManager
     * @param price Price of the bid, double
     * @param date Date of the bid, in specified dd/mm/yyyy format
     */
    public void addBidBuyer(Buyer newBuyer, double price, String date) throws BidException {
        this.bids.addBidBuyer(newBuyer, price, date);
    }

    /**
     * It takes in Buyer ID and removes the Bid from the HashMap in BidsManager
     * @param buyerId Buyer ID of the Buyer object to remove, in Integer
     */
    public void removeBidBuyer(int buyerId){
        this.bids.removeBidBuyer(buyerId);
    }

    /**
     * Accessor for the size of BidManager
     * @return Integer, number of bids stored
     */
    public int getBidNum(){
        return bids.getSize();
    }

    /**
     * Obtains Bid object from Buyer ID as key
     * @param key Integer representing Buyer ID
     * @return Bid object corresponding to the key
     */
    public Bid getBid(int key){
        return bids.getBid(key);
    }

    /**
     * Constructor for abstract vehicle class, sets up attributes accordingly
     * @param maker String of maker
     * @param model String of model
     * @throws VehicleException when conditions are not satisfied for maker and model
     */
    public Vehicle(String maker, String model) throws VehicleException {
        if (setMaker(maker) && setModel(model)) {
            vId = nextID();
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }
    }
// I am commenting below out for this bootcamp, since we have only been using the former method
//    public Vehicle(String maker, String model, int vId){
//        this.maker = maker;
//        this.model = model;
//        this.vId = vId;
//    }

    /**
     * Setter for maker that returns true when completed successfully
     * @param maker A string containing the maker of the vehicle
     * @return true if maker is inside the character range, false otherwise
     */

    public boolean setMaker(String maker) {
        boolean isValid=false;
        if(maker.length()>=3 && maker.length()<=15){
            isValid=true;
            this.maker = maker;
        }
        return isValid;
    }

    /**
     * Setter for model that returns true when completed successfully
     * @param model A string showing the model of the vehicle
     * @return true if model is inside the character range, false otherwise
     */
    public boolean setModel(String model) {
        boolean isValid=false;
        if(model.length()>=3 && model.length()<=15){
            isValid=true;
            this.model = maker;
        }
        return isValid;
    }

    /**
     * getter for vehicle ID
     * @return the integer ID of the vehicle
     */
    public int getvId(){
        return this.vId;
    }

    /**
     * A helper code from instruction sheet, that generates random integer of digit 5
     * @return an integer of 5 digit, randomly generated to be assigned accordingly
     */
    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    /**
     * This helps getting the characteristics of the vehicle
     * @return string showing the main description of the vehicle as a text
     */
    public String description(){
        return "Maker:" + this.maker + " and" + " Model:" + this.model;
    }

}
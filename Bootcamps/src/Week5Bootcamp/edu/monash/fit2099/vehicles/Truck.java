package Week5Bootcamp.edu.monash.fit2099.vehicles;

import Week5Bootcamp.edu.monash.fit2099.exceptions.TruckException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;

/**
 * This is a Sedan, a class inherited from Vehicle class
 * @see Vehicle
 * @author Yo Kogure
 * @version 1.1
 * @since 29/08/2021
 */

public class Truck extends Vehicle {
    /**
     * capacity and wheels are private integer attributes, unique characteristics for Truck
     */
    private int capacity;
    private int wheels;

    /**
     * Constructor for truck, which checks validity of all 4 arguments and throws exception when in neeed
     * @param maker string showing maker of the truck
     * @param model string showing model of the truck
     * @param capacity integer showing the capacity of the truck
     * @param wheels integer showing the wheels of the track
     * @throws VehicleException when model and maker are outside the range
     * @throws TruckException when capacity and wheels are invalid
     */
    public Truck(String maker, String model, int capacity, int wheels) throws VehicleException, TruckException {
        super(maker, model);
        if(setCapacity(capacity) && setWheels(wheels)) {
            this.capacity = capacity;
            this.wheels = wheels;
        }
        else{
            throw new TruckException("Incorrect Capacity OR Wheels");
        }
    }

    /**
     * setter for capacity, checks for exception as well
     * @param capacity integer showing capacity of the truck
     * @return true if capacity is within the range 1-15, and false otherwise
     */
    public boolean setCapacity(int capacity) {
        boolean isValid = false;
        if(capacity >= 1 && capacity <= 15){
            isValid=true;
            this.capacity = capacity;
        }
        return isValid;
    }

    /**
     * setter for wheels, checks for exception as well
     * @param wheels integer showing number of wheels of the truck
     * @return true if wheels is within the erange 4-15, and false otherwise
     */
    public boolean setWheels(int wheels) {
        boolean isValid = false;
        if(wheels >= 4 && wheels <= 16){
            isValid=true;
            this.wheels = wheels;
        }
        return isValid;
    }
}

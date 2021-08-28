package Week5Bootcamp.edu.monash.fit2099.vehicles;

import Week5Bootcamp.edu.monash.fit2099.exceptions.TruckException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;

public class Truck extends Vehicle {
    private int capacity;
    private int wheels;
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

    public boolean setCapacity(int capacity) {
        boolean isValid = false;
        if(capacity >= 1 && capacity <= 15){
            isValid=true;
            this.capacity = capacity;
        }
        return isValid;
    }

    public boolean setWheels(int wheels) {
        boolean isValid = false;
        if(wheels >= 4 && wheels <= 16){
            isValid=true;
            this.wheels = wheels;
        }
        return isValid;
    }
}

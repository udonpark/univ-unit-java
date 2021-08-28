package Week5Bootcamp.edu.monash.fit2099.vehicles;

import Week5Bootcamp.edu.monash.fit2099.exceptions.SedanException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;

public class Sedan extends Vehicle {
    private int seats;
    public Sedan(String maker, String model, int seats) throws VehicleException, SedanException {
        super(maker, model);
        if (setSeats(seats));
        else{
            throw new SedanException("Incorrect Seat");
        }
    }

    public boolean setSeats(int seats) {
        boolean isValid = false;
        if(seats >= 4 && seats <= 5){
            isValid=true;
            this.seats = seats;
        }
        return isValid;
    }
}

package Week5Bootcamp.edu.monash.fit2099.vehicles;

import Week5Bootcamp.edu.monash.fit2099.exceptions.SedanException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;

/**
 * This is a Sedan, a class inherited from Vehicle class
 * @see Vehicle
 * @author Yo Kogure
 * @version 1.1
 * @since 29/08/2021
 */

public class Sedan extends Vehicle {
    /**
     * sheet stores integer number of sheets in the Sedan
     */
    private int seats;

    /**
     * Constructor that checks the maker, model, seats validity and assigns them accordingly
     * @param maker string showing maker of the sedan
     * @param model string showing model of the sedan
     * @param seats integer showing the seats fo sedan, either 4 or 5
     * @throws VehicleException when maker and model are invalid
     * @throws SedanException when seats is invalid
     */
    public Sedan(String maker, String model, int seats) throws VehicleException, SedanException {
        super(maker, model);
        if (setSeats(seats));
        else{
            throw new SedanException("Incorrect Seat");
        }
    }

    /**
     * setter for seats, which returns true if valid
     * @param seats integer seat, only accept 4 or 5
     * @return true if within range, false otherwise
     */
    public boolean setSeats(int seats) {
        boolean isValid = false;
        if(seats >= 4 && seats <= 5){
            isValid=true;
            this.seats = seats;
        }
        return isValid;
    }
}

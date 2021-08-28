package Week5Bootcamp.edu.monash.fit2099.vehicles;

public class Sedan extends Vehicle {
    private int seats;
    public Sedan(String maker, String model, int seats){
        super(maker, model);
        this.seats = seats;
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

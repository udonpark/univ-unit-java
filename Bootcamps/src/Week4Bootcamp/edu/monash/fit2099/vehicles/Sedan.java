package Week4Bootcamp.edu.monash.fit2099.vehicles;

public class Sedan extends Vehicle {
    private int seats;
    public Sedan(String maker, String model, int seats){
        super(maker, model);
        this.seats = seats;
    }
}

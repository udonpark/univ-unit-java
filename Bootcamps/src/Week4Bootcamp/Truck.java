package Week4Bootcamp;

public class Truck extends Vehicle {
    int capacity;
    int wheels;
    public Truck(String maker, String model, int capacity, int wheels){
        super(maker, model);
        this.capacity = capacity;
        this.wheels = wheels;
    }
}

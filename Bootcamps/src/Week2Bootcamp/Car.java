package Week2Bootcamp;

public class Car {
    String make;
    String model;

    public Car(String make, String model){
        this.make = make;
        this.model = model;
    }

    public String getCarDescription(){
        return "Maker:" + make + " and" + " Model:" + model;
    }
// code from task 3:
// public String getCarDescription(){
// return make + model;
// }
}
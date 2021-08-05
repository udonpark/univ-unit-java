package Week2Bootcamp;

public class Car {
    private String make;
    private String model;
    public String getCarDescription(){
        return "Maker:" + make + " and" + " Model:" + model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

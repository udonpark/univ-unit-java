package Week3Bootcampp;

public class AutoShowroom {
    Car[] carArray = new Car[3];

    public void createCars(){
        carArray[0] = new Car("BMW", "XY");
        carArray[1] = new Car("Audi", "A8");
        carArray[2] = new Car("Mercedes", "GLS");
    }

    public void printStatus(){
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
        // The code below is from Task 3
        // Car newCar = new Car("BMW", "X7");
        // System.out.println(newCar.description());
    }

    public void displayCars(){
        for (int i = 0; i<carArray.length; i++){
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + carArray[i].description());
        }
    }
}

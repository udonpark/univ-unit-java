package Week2Bootcamp;

import Week3Bootcampp.Car;

public class AutoShowroom {
    Week3Bootcampp.Car[] carArray = new Week3Bootcampp.Car[3];

    public void createCars(){
        carArray[0] = new Week3Bootcampp.Car("BMW", "XY");
        carArray[1] = new Week3Bootcampp.Car("Audi", "A8");
        carArray[2] = new Car("Mercedes", "GLS");
    }

    public void printStatus(){
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
        // The code below is from Task 3
        // Car newCar = new Car("BMW", "X7");
        // System.out.println(newCar.getCarDescription());
    }

    public void displayCars(){
        for (int i = 0; i<carArray.length; i++){
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + carArray[i].description());
        }
    }
}

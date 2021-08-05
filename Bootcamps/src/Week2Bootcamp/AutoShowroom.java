package Week2Bootcamp;

public class AutoShowroom {
    Car[] carArray = new Car[3];
    public void createCars(){
        carArray[0] = new Car();
        carArray[0].setMake("BMW");
        carArray[0].setModel("X7");

        carArray[1] = new Car();
        carArray[1].setMake("Audi");
        carArray[1].setModel("A8");

        carArray[2] = new Car();
        carArray[2].setMake("Mercedes");
        carArray[2].setModel("GLS");
    }
    public void printStatus(){
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
        // Car newCar = new Car();
        // System.out.println(newCar.getCarDescription());
    }

    public void displayCars(){
        for (int i = 0; i<carArray.length; i++){
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + carArray[i].getCarDescription());
        }
    }
}

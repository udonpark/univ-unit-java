package Week4Bootcamp.edu.monash.fit2099;
import Week4Bootcamp.edu.monash.fit2099.bids.Bid;
import Week4Bootcamp.edu.monash.fit2099.buyers.Buyer;
import Week4Bootcamp.edu.monash.fit2099.vehicles.Sedan;
import Week4Bootcamp.edu.monash.fit2099.vehicles.Truck;
import Week4Bootcamp.edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

// I am re-using some of my functions/codes from last week for efficiency
public class AutoShowroom {
    private final ArrayList<Vehicle> vehicleArray = new ArrayList<>();
    private static HashMap<Integer, Buyer> buyerMap = new HashMap<>();

    public static Buyer getBuyer(int buyerId){
        for (int key: buyerMap.keySet()){
            if (key == buyerId) {
                return buyerMap.get(key);
            }
        }
        return null;
    }

    public void addBuyer(Buyer buyer){
        buyerMap.put(buyer.getBuyerId(), buyer);
    }

    public void createSedan(){
        Scanner scan = new Scanner(System.in);
        System.out.println("<STRING> Enter Maker: ");
        String newMaker = scan.nextLine();
        System.out.println("<STRING> Enter Mode: ");
        String newModel = scan.nextLine();
        System.out.println("<INTEGER> Enter Seat: ");
        int newSeat = Integer.parseInt(scan.nextLine());
        this.vehicleArray.add(new Sedan(newMaker, newModel, newSeat));
    }

    public void createTruck(){
        Scanner scan = new Scanner(System.in);
        System.out.println("<STRING> Enter Maker: ");
        String newMaker = scan.nextLine();
        System.out.println("<STRING> Enter Mode: ");
        String newModel = scan.nextLine();
        System.out.println("<INTEGER> Enter Wheels: ");
        int newWheels = Integer.parseInt(scan.nextLine());
        System.out.println("<INTEGER> Enter Capacity: ");
        int newCapacity = Integer.parseInt((scan.nextLine()));
        this.vehicleArray.add(new Truck(newMaker, newModel, newWheels, newCapacity));
    }

    public void createBuyer(){
        String newGivenName = askFirstName();
        String newFamilyName = askLastName();
        Buyer newBuyer = new Buyer(nextID(), newGivenName, newFamilyName);
        addBuyer(newBuyer);
    }

    public void createBid(){
        int newVehicleId = askVehicleId();
        int newBuyerId = askBuyerId();
        double newPrice = askBidPrice();
        String newDate = askBidDate();
        for (int i = 0; i<this.vehicleArray.size(); i++){
            Vehicle thisVehicle = this.vehicleArray.get(i);
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + thisVehicle.description());
            if (thisVehicle.getBidNum() == 0){
                System.out.println("No Bids");
            }
    }

    public void displayFleet(){

    }

    public void displayBuyers(){

    }

    public void createCars(){
        // this.vehicleArray.add(new Vehicle("BMW", "XY"));
        addBuyerAndBid(0);
        addBuyerAndBid(0);
        // Let this first car have 2 bids

        //this.vehicleArray.add(new Vehicle("Audi", "A8"));
        // Let this second car have no bidders

        // this.vehicleArray.add(new Vehicle("Mercedes", "GLS"));
        addBuyerAndBid(2);
        // Everything is complete!


        // Here is my Answer up to Task 6.
/*        this.carArray.add(new Car("BMW", "XY"));
        Buyer buyer1 = new Buyer(12345, "Herman", "Jin");
        Buyer buyer2 = new Buyer(23677, "Rick", "Johnson");
        this.carArray.get(0).addBid(buyer1, 3200, "13/08/2021");
        // with this, I have tested constructors for both Buyer and Bid

        this.carArray.add(new Car("Audi", "A8"));
        Buyer buyer3 = new Buyer(34521);
        buyer3.setGivenName("Nick");
        buyer3.setFamilyName("Richard");
        this.carArray.get(1).addBid(buyer1, 2400, "21/07/2021");
        this.carArray.get(1).addBid(buyer2, 2300, "22/07/2021");
        this.carArray.get(1).addBid(buyer3, 2000, "28/07/2021");

        // the second car has 2 Bids on it by different Buyer
        // the testing for mutator is complete

        this.carArray.add(new Car("Mercedes", "GLS"));
        // let third car have no bidders*/
    }

    public void addBuyerAndBid(int index){ // this index represents the index of the car in carArray
        System.out.println("Please input details for Car ("+(index+1)+") :");
        String newFirstName = askFirstName();
        String newLastName = askLastName();
        int newBuyerId = askBuyerId();
        double newBidPrice = askBidPrice();
        String newBidDate = askBidDate();

        Buyer newBuyer = new Buyer(newBuyerId, newFirstName, newLastName);
        // this.vehicleArray.get(index).addBid(newBuyer, newBidPrice, newBidDate);
        // new Bid and Buyer are created and inserted accordingly

        System.out.println("Thank you for inputs! \n");
    }
    public String askFirstName(){
        // I could use GivenName instead of FirstName, but I have followed specification for this Task only
        Scanner scan1 = new Scanner(System.in);
        System.out.print("<STRING> Enter Buyer's Given Name: ");
        return scan1.nextLine();
    }
    public String askLastName(){
        Scanner scan2 = new Scanner(System.in);
        System.out.print("<STRING> Enter Buyer's Family Name: ");
        return scan2.nextLine();
    }

    public int askVehicleId(){
        Scanner scan = new Scanner(System.in);
        System.out.print("<INTEGER> Enter Vehicle's ID: ");
        return scan.nextInt();
    }

    public int askBuyerId(){
        Scanner scan3 = new Scanner(System.in);
        System.out.print("<INTEGER> Enter Buyer's ID: ");
        return scan3.nextInt();
    }
    public double askBidPrice(){
        Scanner scan4 = new Scanner(System.in);
        System.out.print("<DOUBLE> Enter Bid Price: ");
        return scan4.nextInt();
    }
    public String askBidDate(){
        Scanner scan1 = new Scanner(System.in);
        System.out.print("<dd/mm/yyyy> Enter Bid Date: ");
        return scan1.nextLine();
    }

    public void printStatus(){
        System.out.println("Welcome to FIT2099 Showroom\n\n");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
        // The code below is from Task 3
        // Car newCar = new Car("BMW", "X7");
        // System.out.println(newCar.description());
    }

    public void showroom(){

    }

    public void displayCars(){
//        for (int i = 0; i<this.vehicleArray.size(); i++){
//            Vehicle thisVehicle = this.vehicleArray.get(i);
//            System.out.println("Car" + " (" + ( i + 1 ) + ") " + thisVehicle.description());
//            if (thisVehicle.getBidNum() == 0){
//                System.out.println("No Bids");
//            }
//            else{
//                for (int j = 0; j< thisVehicle.getBidNum(); j++) {
//                    Bid thisBid = thisVehicle.getBid(j);
//                    System.out.println("  Bid ID: " + thisBid.getBidId() + " Price: " + thisBid.getBidPrice() + " Date: " + thisBid.getBidDate());
//                    System.out.println("    Buyer Information: " + thisBid.getBuyer().description());
//                }
//            }
//            System.out.println("\n");
//        }
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
    
}

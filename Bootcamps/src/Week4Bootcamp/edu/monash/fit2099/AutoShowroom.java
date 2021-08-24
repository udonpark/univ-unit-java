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
    private ArrayList<Vehicle> vehicleArray = new ArrayList<>();
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


    public void createSedan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("<STRING> Enter Maker: ");
        String newMaker = scan.nextLine();
        System.out.println("<STRING> Enter Mode: ");
        String newModel = scan.nextLine();
        System.out.println("<INTEGER> Enter Seat: ");
        int newSeat = Integer.parseInt(scan.nextLine());
        this.vehicleArray.add(new Sedan(newMaker, newModel, newSeat));
    }

    public void createTruck() {
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

    public void displayFleet() {
        for (int i = 0; i<this.vehicleArray.size(); i++){
            Vehicle thisVehicle = this.vehicleArray.get(i);
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + thisVehicle.description());
            if (thisVehicle.getBidNum() == 0){
                System.out.println("No Bids");
            }
            else{
                for (int key: buyerMap.keySet()){
                    Bid thisBid = thisVehicle.getBid(key);
                    System.out.println("  Bid ID: " + thisBid.getBidId() + " Price: " + thisBid.getBidPrice() + " Date: " + thisBid.getBidDate());
                    System.out.println("    Buyer Information: " + thisBid.getBuyer().description());
        }
    }
    System.out.println("\n");
}
    }

    public void displayBuyers() {
        System.out.println("Buyers List: ");
        for (int key: buyerMap.keySet()){
            System.out.println(buyerMap.get(key).description());
            System.out.println("\n");
        }
    }

    public String askFirstName() {
        // I could use GivenName instead of FirstName, but I have followed specification for this Task only
        Scanner scan1 = new Scanner(System.in);
        System.out.print("<STRING> Enter Buyer's Given Name: ");
        return scan1.nextLine();
    }

    public String askLastName() {
        Scanner scan2 = new Scanner(System.in);
        System.out.print("<STRING> Enter Buyer's Family Name: ");
        return scan2.nextLine();
    }

    public int askVehicleId() {
        Scanner scan = new Scanner(System.in);
        System.out.print("<INTEGER> Enter Vehicle's ID: ");
        return scan.nextInt();
    }

    public int askBuyerId() {
        Scanner scan3 = new Scanner(System.in);
        System.out.print("<INTEGER> Enter Buyer's ID: ");
        return scan3.nextInt();
    }

    public double askBidPrice() {
        Scanner scan4 = new Scanner(System.in);
        System.out.print("<DOUBLE> Enter Bid Price: ");
        return scan4.nextInt();
    }

    public String askBidDate() {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("<dd/mm/yyyy> Enter Bid Date: ");
        return scan1.nextLine();
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public void createBuyer() {
        String newGivenName = askFirstName();
        String newFamilyName = askLastName();
        Buyer newBuyer = new Buyer(nextID(), newGivenName, newFamilyName);
        addBuyer(newBuyer);
    }

    public void createBid() {
        int newVehicleId = askVehicleId();
        int newBuyerId = askBuyerId();
        double newPrice = askBidPrice();
        String newDate = askBidDate();
        for (int i = 0; i < this.vehicleArray.size(); i++) {
            Vehicle thisVehicle = this.vehicleArray.get(i);
            if (thisVehicle.getvId() == newVehicleId){
                thisVehicle.addBid(newBuyerId, newPrice, newDate);
                System.out.println("Bid added!");
                break;
            }
        }
        System.out.println("Error has occured!");
    }

    public void printStatus(){
        System.out.println("----------------------------------------");
        System.out.println("Welcome to FIT2099 Showroom\n");
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void showroom(){
        int command;
        do{
            command = selectMenu();
            switch(command) {
                case 1:
                    createSedan();
                    break;
                case 2:
                    createTruck();
                    break;
                case 3:
                    displayFleet();
                    break;
                case 4:
                    createBuyer();
                    break;
                case 5:
                    displayBuyers();
                    break;
                case 6:
                    createBid();
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        } while (command != 7);
    }

    public int selectMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) New Sedan");
        System.out.println("2) New Truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add Bid");
        System.out.println("7) Exit");
        int command = scanner.nextInt();
        return command;
    }
}
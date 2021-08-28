package Week5Bootcamp.edu.monash.fit2099;
import Week5Bootcamp.edu.monash.fit2099.bids.Bid;
import Week5Bootcamp.edu.monash.fit2099.buyers.Buyer;
import Week5Bootcamp.edu.monash.fit2099.exceptions.SedanException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.TruckException;
import Week5Bootcamp.edu.monash.fit2099.exceptions.VehicleException;
import Week5Bootcamp.edu.monash.fit2099.vehicles.Sedan;
import Week5Bootcamp.edu.monash.fit2099.vehicles.Truck;
import Week5Bootcamp.edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// I am re-using some of my functions/codes from last week for efficiency
public class AutoShowroom {
    private final ArrayList<Vehicle> vehicleArray = new ArrayList<>();
    private final HashMap<Integer, Buyer> buyerMap = new HashMap<>();

    public Buyer getBuyer(int buyerId){
        return this.buyerMap.get(buyerId);
//        for (int key: buyerMap.keySet()){
//            if (key == buyerId) {
//                return buyerMap.get(key);
//            }
//        }
//        return null;
    }

    public void addBuyer(Buyer buyer){
        buyerMap.put(buyer.getBuyerId(), buyer);
    }

    public void createSedan() {
        int newSeat = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("<STRING> Enter Maker: ");
        String newMaker = scan.nextLine();
        System.out.println("<STRING> Enter Mode: ");
        String newModel = scan.nextLine();
        System.out.println("<INTEGER> Enter Seat: ");
        try {
            newSeat = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in an integer for Seat!");
            return;
        }
        try {
            Sedan newSedan = new Sedan(newMaker, newModel, newSeat);
            this.vehicleArray.add(newSedan);
            System.out.println(newSedan.description());
            System.out.println("ID: " + newSedan.getvId());
        }
        catch (SedanException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }
    }

    public void createTruck() {
        int newWheels, newCapacity;
        Scanner scan = new Scanner(System.in);
        System.out.println("<STRING> Enter Maker: ");
        String newMaker = scan.nextLine();
        System.out.println("<STRING> Enter Mode: ");
        String newModel = scan.nextLine();
        System.out.println("<INTEGER> Enter Wheels: ");
        try {
            newWheels = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in an Integer for Wheels!");
            return;
        }
        System.out.println("<INTEGER> Enter Capacity: ");
        try {
            newCapacity = Integer.parseInt((scan.nextLine()));
        } catch (NumberFormatException e){
            System.out.println("Please type in an Integer for Capacity!");
            return;
        }
        try {
            Truck newTruck = new Truck(newMaker, newModel, newCapacity, newWheels);
            this.vehicleArray.add(newTruck);
            System.out.println(newTruck.description());
            System.out.println("ID: " + newTruck.getvId());
        }
        catch (TruckException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }
    }

    public void displayFleet() {
        for (int i = 0; i<this.vehicleArray.size(); i++){
            Vehicle thisVehicle = this.vehicleArray.get(i);
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + thisVehicle.description() + " ID: " + thisVehicle.getvId());
            if (thisVehicle.getBidNum() == 0){
                System.out.println("No Bids");
            }
            else{
                for (int key: buyerMap.keySet()){
                    Bid thisBid = thisVehicle.getBid(key);
                    if (thisBid != null) {
                        System.out.println("  Bid ID: " + thisBid.getBidId() + " Price: " + thisBid.getBidPrice() + " Date: " + thisBid.getBidDate());
                        System.out.println("    Buyer Information: " + thisBid.getBuyer().description());
                    }
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
        if (buyerMap.size() == 0){
            System.out.println("Empty!");
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
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in an Integer for Vehicle ID!");
            return 0;
        }
    }

    public int askBuyerId() {
        Scanner scan3 = new Scanner(System.in);
        System.out.print("<INTEGER> Enter Buyer's ID: ");
        try {
            return Integer.parseInt(scan3.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in an Integer for Buyer ID!");
            return 0;
        }
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

    public void createBuyer() {
        String newGivenName = askFirstName();
        String newFamilyName = askLastName();
        Buyer buyer = Buyer.getInstance(newGivenName, newFamilyName);
        if (buyer != null) {
            addBuyer(buyer);
            System.out.println(buyer.description());
        } else
            System.out.println("Something wrong with the buyer's values!!!");
    }

    public void createBid() {
        int newVehicleId = askVehicleId();
        int newBuyerId = askBuyerId();
        if (newVehicleId == 0 || newBuyerId == 0){
            return;
        }
        double newPrice = askBidPrice();
        String newDate = askBidDate();
        for (Vehicle thisVehicle : this.vehicleArray) {
            System.out.println(thisVehicle.getvId());
            if (thisVehicle.getvId() == newVehicleId) {
                thisVehicle.addBidBuyer(getBuyer(newBuyerId), newPrice, newDate);
                break;
            }
        }
    }

    public void printStatus(){
        System.out.println("----------------------------------------");
        System.out.println("Welcome to FIT2099 Showroom\n");
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public Vehicle getVehicle(int vehicleId) {
        for (Vehicle thisVehicle : this.vehicleArray) {
            if (thisVehicle.getvId() == vehicleId) {
                return thisVehicle;
            }
        }
        return null;
    }

    public void getSmallestBid(int vehicleId){
        if (getVehicle(vehicleId) == null){
            System.out.println("Wrong Vehicle ID!");
        }
        else{
            double minBidValue = Double.POSITIVE_INFINITY;
            Bid minBid = null;
            Vehicle thisVehicle = getVehicle(vehicleId);
            for (int key: buyerMap.keySet()) {
                Bid thisBid = thisVehicle.getBid(key);
                if (thisBid == null){
                    continue;
                }
                if (thisBid.getBidPrice() <= minBidValue){
                    minBid = thisBid;
                    minBidValue = thisBid.getBidPrice();
                }
            }
            if (minBid == null){
                System.out.println("No bid for this Vehicle!");
            }
            else{
                System.out.println("*Smallest Bid*!:\n");
                System.out.println("  Bid ID: " + minBid.getBidId() + " Price: " + minBid.getBidPrice() + " Date: " + minBid.getBidDate());
                System.out.println("    Buyer Information: " + minBid.getBuyer().description());
            }
        }
    }

    public void getLargestBid(int vehicleId) {
        if (getVehicle(vehicleId) == null) {
            System.out.println("Wrong Vehicle ID!");
        } else {
            double maxBidValue = Double.NEGATIVE_INFINITY;
            Bid maxBid = null;
            Vehicle thisVehicle = getVehicle(vehicleId);
            for (int key : buyerMap.keySet()) {
                Bid thisBid = thisVehicle.getBid(key);
                if (thisBid == null){
                    continue;
                }
                if (thisBid.getBidPrice() >= maxBidValue) {
                    maxBid = thisBid;
                    maxBidValue = thisBid.getBidPrice();
                }
            }
            if (maxBid == null) {
                System.out.println("No bid for this Vehicle!");
            } else {
                System.out.println("*Largest Bid*!:\n");
                System.out.println("  Bid ID: " + maxBid.getBidId() + " Price: " + maxBid.getBidPrice() + " Date: " + maxBid.getBidDate());
                System.out.println("    Buyer Information: " + maxBid.getBuyer().description());
            }
        }
    }

    public void deleteBid(int bidId) {
        for (Vehicle thisVehicle : vehicleArray) {
            for (int key : buyerMap.keySet()) {
                Bid thisBid = thisVehicle.getBid(key);
                if (thisBid == null){
                    continue;
                }
                if (thisBid.getBidId() == bidId){
                    System.out.println("Item found!\n");
                    thisVehicle.removeBidBuyer(key);
                    System.out.println(("Successfully deleted!\n"));
                    return;
                }
            }
        }
        System.out.println("Item not found!\n");
    }

    public void askSmallest(){
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("<INTEGER> Type in Vehicle ID");
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in Integer!");
            return;
        }
        getSmallestBid(input);
    }

    public void askLargest(){
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("<INTEGER> Type in Vehicle ID");
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in Integer!");
            return;
        }
        getLargestBid(input);
    }

    public void askDelete(){
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("<INTEGER> Type in Bid ID to delete!");
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please type in Integer!");
            return;
        }
        deleteBid(input);
    }

    public void showroom(){
        printStatus();
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
                case 7:
                    askLargest();
                    break;
                case 8:
                    askSmallest();
                    break;
                case 9:
                    askDelete();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        } while (command != 10);
    }

    public int selectMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) New Sedan");
        System.out.println("2) New Truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add Bid");
        System.out.println("7) Show the Best Bid");
        System.out.println("8) Show the Worst Bid");
        System.out.println("9) Delete Bid");
        System.out.println("10) Exit");
        return scanner.nextInt();
    }
}
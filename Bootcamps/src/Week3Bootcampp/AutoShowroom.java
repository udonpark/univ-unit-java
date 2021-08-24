package Week3Bootcampp;
import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {
    private final ArrayList<Car> carArray = new ArrayList<>();

    public void createCars(){
        this.carArray.add(new Car("BMW", "XY"));
        addBuyerAndBid(0);
        addBuyerAndBid(0);
        // Let this first car have 2 bids

        this.carArray.add(new Car("Audi", "A8"));
        // Let this second car have no bidders

        this.carArray.add(new Car("Mercedes", "GLS"));
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
        int newBidPrice = askBidPrice();
        String newBidDate = askBidDate();

        Buyer newBuyer = new Buyer(newBuyerId, newFirstName, newLastName);
        this.carArray.get(index).addBid(newBuyer, newBidPrice, newBidDate);
        // new Bid and Buyer are created and inserted accordingly

        System.out.println("Thank you for inputs! \n");
    }
    public String askFirstName(){
        // I could use GivenName instead of FirstName, but I have followed specification for this Task only
        Scanner scan1 = new Scanner(System.in);
        System.out.print("<STRING> Please Type in Buyer's Given Name: ");
        return scan1.nextLine();
    }
    public String askLastName(){
        Scanner scan2 = new Scanner(System.in);
        System.out.print("<STRING> Please Type in Buyer's Family Name: ");
        return scan2.nextLine();
    }

    public int askBuyerId(){
        Scanner scan3 = new Scanner(System.in);
        System.out.print("<INTEGER> Please Type in Buyer's ID: ");
        return scan3.nextInt();
    }
    public int askBidPrice(){
        Scanner scan4 = new Scanner(System.in);
        System.out.print("<INTEGER> Please Type in Bid Price: ");
        return scan4.nextInt();
    }
    public String askBidDate(){
        Scanner scan1 = new Scanner(System.in);
        System.out.print("<dd/mm/yyyy> Please Type in Bid Date: ");
        return scan1.nextLine();
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
        for (int i = 0; i<this.carArray.size(); i++){
            Car thisCar = this.carArray.get(i);
            System.out.println("Car" + " (" + ( i + 1 ) + ") " + thisCar.description());
            if (thisCar.getBidNum() == 0){
                System.out.println("No Bids");
            }
            else{
                for (int j = 0; j<thisCar.getBidNum(); j++) {
                    Bid thisBid = thisCar.getBid(j);
                    System.out.println("  Bid ID: " + thisBid.getBidId() + " Price: " + thisBid.getBidPrice() + " Date: " + thisBid.getBidDate());
                    System.out.println("    Buyer Information: " + thisBid.getBuyer().description());
                }
            }
            System.out.println("\n");
        }
    }
    
}

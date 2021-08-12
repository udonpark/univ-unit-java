public class FIT2099Class {
    /**
     * @param i first positive number
     * @param j second positive number
     * @return the sum of i+j
     */
    int addTwoPositiveNumbers(int i, int j) {
        return (i + j);
    }

    /**
     * @param i integer number
     * @return returns true if i is positive; false otherwise
     */

    boolean isPositive(int i) {
        return (i >= 0);
    }

    public static void main(String[] args) {
        //first integer
        int no1 = -2;
        //second integer
        int no2 = 4;
        // a little container for the sum
        int result;
        // create a new instance of this class to be able to access the two methods
        FIT2099Class w1 = new FIT2099Class();
        if (w1.isPositive(no1) && w1.isPositive(no2)) {
            result = w1.addTwoPositiveNumbers(no1, no2);
            System.out.println("Both numbers are positive and the sum is " + result);
        } else
            System.out.println("no1 or/and no2 is not positive");
    }
}

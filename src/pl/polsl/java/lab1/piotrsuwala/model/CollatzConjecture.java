package pl.polsl.java.lab1.piotrsuwala.model;

import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;

/**
 * Class responsible for computing Collatz conjecture
 * @version 1.0
 * @author Piotr
 */
public class CollatzConjecture {
    int numberOfSteps;
    
    /**
     * Constructor. Initializes the number of steps
     */
    
    public CollatzConjecture () {
        numberOfSteps = 0;
    }
    
    /**
     * Main method of this class. Computes the number of steps for Collatz conjecture
     * @param number the number we will go down to 1 
     */
    
    public void computeCollatzConjencture(int number) {
        if (number < 0) {System.out.println("aa");
            throw new NegativeSize("Error. The value is negative. Should have caught an exception");
        }
        numberOfSteps = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = 3*number + 1;
            }
            numberOfSteps++;
        }
    }
    
    /**
     * Returns number of steps 
     * @return number of steps for Collatz conjecture 
     */
    
    public int getNumberOfSteps() {
        return numberOfSteps;
    }
}

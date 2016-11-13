package pl.polsl.java.lab1.piotrsuwala.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for computing Fibonacci sequence values
 * @version 1.0
 * @author Piotr
 */
public class FibonacciSequence {
    List fibonacciSequence = new ArrayList();
    int numberOfElements;
    
    /**
     * Constructor. Throws an exception if the parameter is invalid
     * @param number designates up to which point we compute Fibonacci Sequence 
     */
    
    public FibonacciSequence(int number) {
        if (number < 1) {
                throw new IllegalArgumentException("Argument cannot be less than 1");
            }
        numberOfElements = number;
    }
    
    /**
     * Main method of this class. Computes Fibonacci sequence values
     */
    
    public void computeFibonacciSequence() {
        if (numberOfElements == 1 || numberOfElements == 2) {
            fibonacciSequence.add(1);
            if (numberOfElements == 2) {
                fibonacciSequence.add(1);
            }
            return;
        }
        fibonacciSequence.add(1);
        fibonacciSequence.add(1);
        int n2 = 0;
        int n1 = 1;
        int tmp;
        for (int i = 2; i <= numberOfElements; i++) {
            tmp = n2;
            n2 = n1;
            n1 = n1 + tmp;
            fibonacciSequence.add(n1 + n2);
        }
    }
    
    /**
     * Method which return Fibonacci sequence values
     * @return array of Fibonacci values 
     */
    
    public List getArrayOfFibonacciSequence() {
        return fibonacciSequence;
    }
}

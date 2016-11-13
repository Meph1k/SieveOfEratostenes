package pl.polsl.java.lab1.piotrsuwala.tests;

import java.util.ArrayList;
import java.util.List;
import pl.polsl.java.lab1.piotrsuwala.model.FibonacciSequence;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 * Tests a successful and a fail case of Fibonacci sequence method
 * @version 1.0
 * @author Piotr
 */
public class FibonacciSequenceTest {
    FibonacciSequence fibonacciSequence;
    
    @Test(expected=IllegalArgumentException.class)
    public void testFibonacciSequenceFail() {
        fibonacciSequence = new FibonacciSequence(0);
    }
    
    @Test
    public void testFibonacciSequenceSuccess() {
        fibonacciSequence = new FibonacciSequence(6);
        fibonacciSequence.computeFibonacciSequence();
        List fibonacciValues = new ArrayList();
        fibonacciValues.add(1);
        fibonacciValues.add(1);
        fibonacciValues.add(2);
        fibonacciValues.add(3);
        fibonacciValues.add(5);
        fibonacciValues.add(8);
        fibonacciValues.add(13);
        int i = 0;
        for (Object temp : fibonacciValues) {
            int tmpFib = (int)fibonacciSequence.getArrayOfFibonacciSequence().get(i++);
            assertEquals("Fibonacci sequence", temp, tmpFib);
        }
    }
}

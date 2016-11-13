package pl.polsl.java.lab1.piotrsuwala.tests;

import pl.polsl.java.lab1.piotrsuwala.model.CollatzConjecture;
import org.junit.*;
import static org.junit.Assert.*;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;

/**
 * Tests a successful and a fail case of Collatz conjecture method
 * @version 1.0
 * @author Piotr
 */
public class CollatzConjectureTest {
    CollatzConjecture collatzConjecture;
    
    @Test(expected=NegativeSize.class)
    public void testComputeCollatzConjectureFail() {
        collatzConjecture = new CollatzConjecture();
        collatzConjecture.computeCollatzConjencture(-30);
    }
    
    @Test
    public void testComputeCollatzConjectureSuccess() {
        collatzConjecture = new CollatzConjecture();
        collatzConjecture.computeCollatzConjencture(11);
        assertEquals("Should be equal", collatzConjecture.getNumberOfSteps(), 14);
    }
}

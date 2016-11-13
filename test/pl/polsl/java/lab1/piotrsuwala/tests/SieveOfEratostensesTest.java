package pl.polsl.java.lab1.piotrsuwala.tests;

import pl.polsl.java.lab1.piotrsuwala.model.SieveOfEratostenes;
import org.junit.*;

/**
 * Tests a successful and a fail case of Eratostenes method
 * @version 1.0
 * @author Piotr
 */
public class SieveOfEratostensesTest {
    SieveOfEratostenes sieveOfEratostenes;
    
    @Test(expected=NegativeArraySizeException.class)
    public void testRunSieveOfEratostenesFail() {
        sieveOfEratostenes = new SieveOfEratostenes();
        sieveOfEratostenes.runEratostenesSieve(-20);
    }
    @Test
    public void testRunSieveOfEratostenesSuccess() {
        sieveOfEratostenes = new SieveOfEratostenes();
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19};
        sieveOfEratostenes.runEratostenesSieve(20);
        Assert.assertArrayEquals("Prime numbers up to 20", primeNumbers, sieveOfEratostenes.getPrimes());
    }
}

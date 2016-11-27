package pl.polsl.java.lab1.piotrsuwala.tests;

import pl.polsl.java.lab1.piotrsuwala.model.SieveOfEratostenes;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 * Tests a successful and a fail case of Eratostenes method
 * @version 1.0
 * @author Piotr
 */
public class SieveOfEratostensesTest {
    SieveOfEratostenes sieveOfEratostenes;
    
    @Test(expected=NegativeArraySizeException.class)
    public void testRunSieveOfEratostenesFail() {
        //given
        sieveOfEratostenes = new SieveOfEratostenes();
        //when
        sieveOfEratostenes.runEratostenesSieve(-20);
    }
    @Test
    public void testRunSieveOfEratostenesSuccess() {
        //given
        sieveOfEratostenes = new SieveOfEratostenes();
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19};
        //when
        sieveOfEratostenes.runEratostenesSieve(20);
        //then
        Assert.assertArrayEquals("Prime numbers up to 20", primeNumbers, sieveOfEratostenes.getPrimes());
    }
    @Test
    public void testIsNotPrime() {
        //given
        sieveOfEratostenes = new SieveOfEratostenes();
        //when
        Boolean isOrIsnt = sieveOfEratostenes.isPrime(10);
        //then
        assertEquals("shoud not be prime", isOrIsnt, false);
    }
     @Test
     public void testIsPrime() {
        //given
        sieveOfEratostenes = new SieveOfEratostenes();
        //when
        Boolean isOrIsnt = sieveOfEratostenes.isPrime(19);
        //then
        assertEquals("shoud not be prime", isOrIsnt, true);
    }
}

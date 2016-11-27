package pl.polsl.java.lab1.piotrsuwala.tests;

import pl.polsl.java.lab1.piotrsuwala.model.Helpers;
import org.junit.*;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;
import pl.polsl.java.lab1.piotrsuwala.exceptions.ParamsOutOfBound;

/**
 * Tests Helpers methods
 * @version 1.0
 * @author Piotr
 */
public class HelpersTest {
    Helpers helpers;
    
    @Test(expected=NegativeSize.class)
    public void testCheckIfArgsNegaticeFail() {
        helpers = new Helpers();
        int[] testTable = {1, 2, -4};
        helpers.checkIfArgsNegative(testTable);
    }
    
    
    @Test
    public void testCheckIfArgsNegaticeSuccess() {
        helpers = new Helpers();
        int[] testTable = {1, 2, 4};
        helpers.checkIfArgsNegative(testTable);
    }
    
    @Test
    public void testReturnInteger() {
        helpers = new Helpers();
        String[] args = {"1", "2", "3", "4", "5"};
        int[] argsAsIntegers = new int[5];
        int i = 0;
        for (String value : args) {
            argsAsIntegers[i++] = Integer.parseInt(value);
        }
        Assert.assertArrayEquals("Values should be the same", helpers.returnInteger(args), argsAsIntegers);
    }
}

package pl.polsl.java.lab1.piotrsuwala.model;
import java.util.InputMismatchException;
import java.util.Scanner;
import pl.polsl.java.lab1.piotrsuwala.exceptions.ParamsOutOfBound;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;

/**
 * A class created to be used as helpers throughout the application
 * @author Piotr Suwała
 * 
 */
public class Helpers {
    /**
     * Method used to get a correct parameter if it was not passed at first
     * @return a correct parameter 
     */
    public static int getAParameter() {
        while(true) {
            System.out.println("Sorry but your data is invalid. Please pass one number");
            Scanner input = new Scanner(System.in);
            try {
                while(true) {
                    int number = input.nextInt();
                    if (number > 0) {
                        return number;
                    } else {
                        System.out.println("Your data was negative again. Please put a correct value");
                    }
                }
            }
            catch(InputMismatchException | NegativeSize err) {
                System.out.println(err.getMessage());
            }
        }
    }
    /**
     * Method used to check we passed the correct number of parameters
     * @param args commad line arguments
     */
    public static void checkIfArgsOutOfBounds(String[] args) {
        if (args.length != 1) {
            throw new ParamsOutOfBound("Number of parameters should equal to 1");
        }
    }
    /**
     * Method used to parse a string into an integer
     * @return the same value but converted from string to int
     * @exception if the given parameter was not a number
     * @param command line arguments
     */
    public static int returnInteger(String[] args) {
        return Integer.parseInt(args[0]);
    }
    /**
     * Method used to check if the parameter passed is negative or not
     * @exception throws exception if the number was negative 
     * @param param parameter which should be passed from the command line
     */
    public static void checkIfArgIsNegative(int param) {
        if (param <= 0) {
            throw new NegativeSize("The size you put was negative");
        }
    }
}

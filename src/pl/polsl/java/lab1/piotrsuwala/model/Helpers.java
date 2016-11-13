package pl.polsl.java.lab1.piotrsuwala.model;
import java.util.InputMismatchException;
import java.util.Scanner;
import pl.polsl.java.lab1.piotrsuwala.exceptions.ParamsOutOfBound;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;
import pl.polsl.java.lab1.piotrsuwala.view.UserInterface;

/**
 * A class created to be used as helpers throughout the application
 * @author Piotr Suwała
 * @version 1.0
 */
public class Helpers {
    /**
     * Method used to get a correct parameter if it was not passed at first
     * @return a correct parameter 
     */
    public int[] getParameters() {
        while(true) {
            System.out.println("Sorry but your data is invalid. Please pass three numbers");
            UserInterface userInterface = new UserInterface();
            Scanner input = new Scanner(System.in);
            try {
                int[] valuesToReturn = new int[3];
                valuesToReturn = userInterface.viewOptionsAndPassValues();
                return valuesToReturn;
            }
            catch(InputMismatchException | NegativeSize err) {
                System.out.println(err.getMessage());
            }
        }
    }
    /**
     * Method used to check we passed the correct number of parameters
     * @param args command line arguments
     */
    public void checkIfArgsOutOfBounds(String[] args) {
        if (args.length != 3) {
            throw new ParamsOutOfBound("Number of parameters should equal to 3");
        }
    }
    /**
     * Method used to parse a string into an integer
     * @return the same value but converted from string to int
     * @param args command line arguments
     */
    public int[] returnInteger(String[] args) {
        int[] argsAsIntegers = new int[args.length];
        int i = 0;
        for (String value : args) {
            argsAsIntegers[i++] = Integer.parseInt(value);
        }
        return argsAsIntegers;
    }
    /**
     * Method used to check if the parameter passed is negative or not
     * @param param parameter which should be passed from the command line
     */
    public void checkIfArgsNegative(int[] params) {
        for (int param : params) {
            if (param <= 0) {
            throw new NegativeSize("The size you put was negative");
            }
        }
    }
}

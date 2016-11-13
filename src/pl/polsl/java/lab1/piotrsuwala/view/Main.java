package pl.polsl.java.lab1.piotrsuwala.view;
import static java.lang.System.exit;
import java.util.Arrays;
import pl.polsl.java.lab1.piotrsuwala.model.Helpers;
import pl.polsl.java.lab1.piotrsuwala.exceptions.ParamsOutOfBound;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;
import pl.polsl.java.lab1.piotrsuwala.model.CollatzConjecture;
import pl.polsl.java.lab1.piotrsuwala.model.FibonacciSequence;
import pl.polsl.java.lab1.piotrsuwala.model.SieveOfEratostenes;

/**
 * The main class. Everything is launched here.
 * @author Piotr Suwała
 */
public class Main {
    /**
     * The main method. Executes everything.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        int[] inputParameters =  new int[args.length];
        try {
            helpers.checkIfArgsOutOfBounds(args);
            inputParameters = helpers.returnInteger(args);
            helpers.checkIfArgsNegative(inputParameters);
        }
        catch(ParamsOutOfBound | NumberFormatException | NegativeSize err) {
            System.out.println(err.getMessage());
            inputParameters = helpers.getParameters();
        }
        SieveOfEratostenes sieveOfEratostenes = new SieveOfEratostenes();
        FibonacciSequence fibonacciSequence = new FibonacciSequence(inputParameters[1]);
        CollatzConjecture collatzConjecture = new CollatzConjecture();
        
        try {
            sieveOfEratostenes.runEratostenesSieve(inputParameters[0]);
            fibonacciSequence.computeFibonacciSequence();
            collatzConjecture.computeCollatzConjencture(inputParameters[2]);
        }
        catch(NegativeSize err) {
            System.out.println(err.getMessage());
            exit(1);
        }
        System.out.println(Arrays.toString(sieveOfEratostenes.getPrimes()));
        System.out.println(fibonacciSequence.getArrayOfFibonacciSequence());
        System.out.println(collatzConjecture.getNumberOfSteps());
    }
}

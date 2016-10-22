package pl.polsl.java.lab1.piotrsuwala.view;
import java.util.InputMismatchException;
import pl.polsl.java.lab1.piotrsuwala.model.Helpers;
import pl.polsl.java.lab1.piotrsuwala.exceptions.ParamsOutOfBound;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;
import static pl.polsl.java.lab1.piotrsuwala.model.SieveOfEratostenes.runEratostenesSieve;

/**
 * The main class. Everything is launched here.
 * @author Piotr Suwała
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int inputParameter = 0;
        try {
            Helpers.checkIfArgsOutOfBounds(args);
            inputParameter = Helpers.returnInteger(args);
            Helpers.checkIfArgIsNegative(inputParameter);
        }
        catch(ParamsOutOfBound | NumberFormatException | NegativeSize err) {
            System.out.println(err.getMessage());
            inputParameter = Helpers.getAParameter();
        }
        
        runEratostenesSieve(inputParameter);
    }
    
}
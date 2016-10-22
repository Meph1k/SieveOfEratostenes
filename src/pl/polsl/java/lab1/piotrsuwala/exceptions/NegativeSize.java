package pl.polsl.java.lab1.piotrsuwala.exceptions;

/**
 * The class which extends a proper exception and is used when the size was negative
 * @author Piotr Suwała
 */
public class NegativeSize extends NegativeArraySizeException {
    /**
     * Constructor. The object is used when proper exception was thrown
     */
    public NegativeSize() {}
    /**
     * Constructor. Gets thrown when the size was negative
     * @param err error message
     */
    public NegativeSize(String err) {
        super(err);
    }
}

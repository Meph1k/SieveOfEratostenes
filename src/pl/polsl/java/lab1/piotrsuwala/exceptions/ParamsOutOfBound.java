package pl.polsl.java.lab1.piotrsuwala.exceptions;

/**
 * Class which extends from the proper exception class and is used when parameters passed were out of bound.
 * @author Piotr Suwała
 */
public class ParamsOutOfBound extends ArrayIndexOutOfBoundsException {
    /**
     * Constructor. The object is used when proper exception was thrown
     */
    public ParamsOutOfBound() {}
    /**
     * Constructor. The object is used when proper exception was thrown.
     * @param errorMessage error message 
     */
    public ParamsOutOfBound(String errorMessage) {
        super(errorMessage);
    }
}

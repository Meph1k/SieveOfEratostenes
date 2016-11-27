package pl.polsl.java.lab1.piotrsuwala.model;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;

/**
 * A class created to be used as helpers throughout the application
 * @author Piotr Suwała
 * @version 1.0
 */
public class Helpers {
    /**
     * concatenates two integers
     * @param num1 number to be concatenated
     * @param num2 number to be concatenates
     * @return concatenated integers
     */
    public int concatenateIntegers(int num1, int num2) {
        int number = 0;
        String numberAsString = Integer.toString(num1) +
                (1 == num2 ? "0" + Integer.toString(num2) : Integer.toString(num2));
        if (0 == num2) {
            numberAsString += "0";
        }
        number = Integer.parseInt(numberAsString);
        return number;
    }
    
    /**
     * Returns object with Karnaugh Map
     * @param karnaughMap 2d array to be changed into object
     * @return object with Karnaugh Map
     */
    
    public RowsAndColumns array2DToObject(int[][] karnaughMap) {
        Object rowData[][] = { { karnaughMap[1][0], karnaughMap[1][1],
        karnaughMap[1][2], karnaughMap[1][3], karnaughMap[1][4] },
        {  karnaughMap[2][0], karnaughMap[2][1],
        karnaughMap[2][2], karnaughMap[2][3], karnaughMap[2][4] },
        {  karnaughMap[3][0], karnaughMap[3][1],
        karnaughMap[3][2], karnaughMap[3][3], karnaughMap[3][4] },
        {  karnaughMap[4][0], karnaughMap[4][1],
        karnaughMap[4][2], karnaughMap[4][3], karnaughMap[4][4] }};
        Object columnNames[] = { "ab/cd", karnaughMap[0][1], karnaughMap[0][2],
        karnaughMap[0][3], karnaughMap[0][4]};
        RowsAndColumns rowsAndColumns = new RowsAndColumns(rowData, columnNames);
        return rowsAndColumns;
    }
    /**
     * converts number from decimal to binary
     * @param number converts to binary
     * @return number converted to binary
     */
    public int convertDecimalToBinary(int number) {
        switch (number) {
            case 0:
                number = 0;
                break;
            case 1:
                number = 1;
                break;
            case 10:
                number = 2;
                break;
            case 11:
                number = 3;
                break;
            case 100:
                number = 4;
                break;
            case 101:
                number = 5;
                break;
            case 110:
                number = 6;
                break;
            case 111:
                number = 7;
                break;
            case 1000:
                number = 8;
                break;
            case 1001:
                number = 9;
                break;
            case 1010:
                number = 10;
                break;
            case 1011:
                number = 11;
                break;
            case 1100:
                number = 12;
                break;
            case 1101:
                number = 13;
                break;
            case 1110:
                number = 14;
                break;
            case 1111:
                number = 15;
                break;
            default:
                number = 0;
        }
        return number;
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
     * @param params parameter which should be passed from the command line
     */
    public void checkIfArgsNegative(int[] params) {
        for (int param : params) {
            if (param <= 0) {
            throw new NegativeSize("The size you put was negative");
            }
        }
    }
}

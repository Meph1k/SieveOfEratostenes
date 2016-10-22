package pl.polsl.java.lab1.piotrsuwala.model;

/**
 * The class which contains Eratostenses's algorithm
 * @author Piotr Suwała
 * 
 */
public class SieveOfEratostenes {
    /**
    * The method which runs Eratostenes's algorithm. Prints out values on the screen.
    * @param upperBound upper bound of prime numbers we want to print
    */
    public static void runEratostenesSieve(int upperBound) {
      int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
      boolean[] isComposite = new boolean[upperBound + 1];
      for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                  System.out.print(m + " ");
                  for (int k = m * m; k <= upperBound; k += m)
                        isComposite[k] = true;
            }
      }
      for (int m = upperBoundSquareRoot + 1; m <= upperBound; m++)
            if (!isComposite[m]) {
                System.out.print(m + " ");
            }
    } 
}

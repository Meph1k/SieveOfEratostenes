package pl.polsl.java.lab1.piotrsuwala.model;

/**
 * The class which contains Eratostenses's algorithm
 * @author Piotr Suwała
 * @version 1.0
 */
public class SieveOfEratostenes {
    int[] primes;
    /**
    * The method which runs Eratostenes's algorithm. Prints out values on the screen.
    * @param max upper bound of prime numbers we want to print
    */
    
    public void runEratostenesSieve(int max) {
        boolean[] isComposite = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        this.primes = primes;
    }
    
    /**
     * Method which return prime numbers
     * @return prime numbers of computed algorithm 
     */
    
    public int[] getPrimes() {
        return primes;
    }
    
    /**
     * checks whether a single value is prime
     * @param number number to be checked if its prime
     * @return true if prime, false if not prime
     */
    
    public Boolean isPrime(int number) {
        if (0 == number || 1 == number) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0 && i != number) return false;
        }
        return true;
    }
}

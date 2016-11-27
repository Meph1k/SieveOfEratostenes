package pl.polsl.java.lab1.piotrsuwala.model;

/**
 * Sets Karnaugh Map with primes
 * @version 1.0
 * @author Piotr
 */
public class KarnaughMapPrimes {
    int[][] karnaughMap4x4WithPrimes;
    
    /**
     * sets primes
     */
    
    public KarnaughMapPrimes() {
        karnaughMap4x4WithPrimes = new int[5][5];
        setPrimes();
    }
    
    /**
     * return 2D array with primes
     * @return 2D array with primes 
     */
    
    public int[][] getKarnaughMap4x4WithPrimes() {
        return karnaughMap4x4WithPrimes;
    }
    
    /**
     * sets primes
     */
    
    private void setPrimes() {
        int[][] karnaughMap4x4Array = new KarnaughMap4x4().getKarnaughMap4x4();
        karnaughMap4x4WithPrimes = karnaughMap4x4Array;
        SieveOfEratostenes sieveOfEratostenes = new SieveOfEratostenes();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                Helpers helpers = new Helpers();
                int number = helpers.
                        concatenateIntegers(karnaughMap4x4Array[i][0],
                        karnaughMap4x4Array[0][j]);
                number = helpers.convertDecimalToBinary(number);
                if (sieveOfEratostenes.isPrime(number)) {
                    karnaughMap4x4WithPrimes[i][j] = 1;
                } else {
                    karnaughMap4x4WithPrimes[i][j] = 0;
                }
            }
        }
    }
}

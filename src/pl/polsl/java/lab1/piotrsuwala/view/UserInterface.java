package pl.polsl.java.lab1.piotrsuwala.view;

import java.util.Scanner;
import pl.polsl.java.lab1.piotrsuwala.exceptions.NegativeSize;

/**
 *
 * @author Piotr
 */
public class UserInterface {
    public int[] viewOptionsAndPassValues() {
        System.out.println("1. Computes a list of prime numbers");
        System.out.println("2. Computes a sequence of Fibonacci");
        System.out.println("3. Computes Collatz Conjecture");
        System.out.println("Please, pass zero if you don't want to compute ceertain problem");
        int[] values = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            values[i] = scanner.nextInt();
            if (values[i] < 0) {
                throw new NegativeSize("Error. The value you put was negative");
            }
        }
        return values;
    }
}

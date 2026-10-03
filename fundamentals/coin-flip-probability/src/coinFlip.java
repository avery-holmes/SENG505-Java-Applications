/**
 * @author Avery Holmes
 * SENG 505 – Coin Flip Odds Assignment
 * Purpose: This program asks for the number of coin flips (n) and the number
 *          of heads (k), then calculates the probability of getting exactly k
 *          heads in n fair coin flips using the binomial formula.
 *
 * Pseudocode:
 * 1) Print header
 * 2) Prompt for n (flips) and k (heads), read input
 * 3) Compute odds = C(n, k) * (0.5^k) * (0.5^(n - k))
 *    - C(n, k) = n! / (k! * (n - k)!)
 *    - Use a factorial(int) helper
 * 4) Print the formatted result
 * 5) Close the Scanner
 */

import java.util.Scanner;

public class coinFlip {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        printHeader();

        System.out.print("Enter desired number of flips: ");
        int n = keyboard.nextInt();

        System.out.print("Enter desired number of heads: ");
        int k = keyboard.nextInt();

        double odds = binomial(n, k);

        printResults(n, k, odds);

        keyboard.close();
    }

    public static void printHeader() {
        System.out.println("Probability Simulator");
        System.out.println("Simulates the odds of getting exactly k heads on n coin flips");
        System.out.println();
    }

    public static double binomial(int n, int k) {
        if (k < 0 || n < 0 || k > n) {
            return 0.0;
        }

        double nFact = factorial(n);
        double kFact = factorial(k);
        double nMinusKFact = factorial(n - k);

        double coefficient = nFact / (kFact * nMinusKFact);
        double probability = Math.pow(0.5, k) * Math.pow(0.5, n - k);

        return coefficient * probability;
    }

    public static double factorial(int num) {
        double result = 1.0;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void printResults(int n, int k, double odds) {
        System.out.println("The odds of getting exactly " + k + " heads in " + n + " coin flips is: " + odds);
    }
}

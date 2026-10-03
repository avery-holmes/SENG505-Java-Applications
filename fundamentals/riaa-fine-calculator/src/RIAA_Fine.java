/**
 * @author Avery Holmes
 * SENG 505 – RIAA Fine Assignment
 * Purpose: This program calculates the final amount owed to the RIAA
 *          for illegally uploaded songs. It prompts the user for the
 *          number of songs, applies a per-song fine plus fixed court
 *          costs, and then applies a 10% discount. The final amount
 *          owed is displayed to the user formatted as currency.
 */

import java.util.Scanner;

public class RIAA_Fine {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the total number of songs uploaded: ");
        int numSongs = keyboard.nextInt();

        double costPreDiscount = (numSongs * 22000.0);
        double courtCosts = 80000.0;

        double finalCost = ((costPreDiscount + courtCosts) * 0.9);

        System.out.printf("The final amount that you owe and need to write a check for is $%,.2f%n", finalCost);

        keyboard.close();
    }
}

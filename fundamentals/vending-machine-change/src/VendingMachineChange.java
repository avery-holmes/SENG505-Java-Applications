/**
 * @author Avery Holmes
 * SENG 505 – Vending Machine Change Assignment
 * Purpose: This program calculates the change to be dispensed from a vending
 *          machine. The user inputs the cost of an item between 25 cents and
 *          100 cents (in 5 cent increments). The machine assumes payment with
 *          a single dollar bill and determines the number of quarters, dimes,
 *          and nickels to return as change.
 */

import java.util.Scanner;

public class VendingMachineChange {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the price of the item (from 25 cents to a dollar, in 5-cent increments): ");
        int cost = keyboard.nextInt();

        int change = 100 - cost;

        int quarters = change / 25;
        change = change % 25;

        int dimes = change / 10;
        change = change % 10;

        int nickels = change / 5;

        System.out.println("You bought an item for " + cost + " cents and you gave me a dollar, so your change is:");
        System.out.println("  " + quarters + " quarter(s),");
        System.out.println("  " + dimes + " dime(s), and");
        System.out.println("  " + nickels + " nickel(s).");
    }
}

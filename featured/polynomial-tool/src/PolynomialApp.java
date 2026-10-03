/*
 * Author: Avery Holmes
 * Course: SENG 505 – Programming Applications with Java
 * Assignment: Program Set 2 – Part A (Working with Polynomials)
 * File: PolynomialApp.java
 */

import java.util.Scanner;

public class PolynomialApp {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Polynomial Tool Assignment");
        System.out.println("You will enter TWO polynomials, P1(x) and P2(x).");
        System.out.println("For each polynomial, enter terms as:");
        System.out.println("    degree  then  coefficient");
        System.out.println("Use degree -1 when you are finished entering terms "
                + "for that polynomial.\n");

        System.out.println("~~~~~~~~ Enter Polynomial P1(x) ~~~~~~~~");
        Polynomial p1 = readPolynomial(keyboard);
        System.out.println("\nP1(x) = " + p1);

        System.out.println("\n~~~~~~~~ Enter Polynomial P2(x) ~~~~~~~~");
        Polynomial p2 = readPolynomial(keyboard);
        System.out.println("\nP2(x) = " + p2);

        Polynomial p3 = p1.add(p2);
        System.out.println("\nP3(x) = P1(x) + P2(x)");
        System.out.println("P3(x) = " + p3);

        System.out.print("\nEnter a value for x to evaluate P1, P2, and P3: ");
        double x = keyboard.nextDouble();

        System.out.println("\nP1(" + x + ") = " + p1.evaluate(x));
        System.out.println("P2(" + x + ") = " + p2.evaluate(x));
        System.out.println("P3(" + x + ") = " + p3.evaluate(x));

        System.out.println("\nDone. Thank you for using the Polynomial Tool.");
        keyboard.close();
    }

    private static Polynomial readPolynomial(Scanner keyboard) {
        Polynomial poly = new Polynomial();

        while (true) {
            System.out.print("Enter coefficient (or -1 to finish this polynomial): ");
            double coefficient = keyboard.nextDouble();

            if (coefficient == -1) {
                break;
            }

            System.out.print("Enter degree for this term: ");
            int degree = keyboard.nextInt();

            poly.addTerm(coefficient, degree);
        }
        return poly;
    }
}

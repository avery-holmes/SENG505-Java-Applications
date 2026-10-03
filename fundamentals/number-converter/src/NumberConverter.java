/**
 * @author Avery Holmes
 * SENG 505 – Number Converter Assignment
 * Purpose: This program takes input in the format "num1 times num2 plus num3"
 *          as a String, extracts the numbers, converts them into doubles,
 *          and performs the calculation (num1 * num2 + num3). The program
 *          uses index positions, substring operations, and the Double class
 *          to complete the task.
 */

import java.util.Scanner;

public class NumberConverter {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a string in the format “num1 times num2 plus num3”: ");
        String entry = keyboard.nextLine();

        int toTimes = entry.indexOf(" times ");
        int toPlus = entry.indexOf(" plus ");

        String times = " times ";
        String plus = " plus ";

        String num1 = entry.substring(0,toTimes).trim();
        String num2 = entry.substring(toTimes + times.length(),toPlus).trim();
        String num3 = entry.substring(toPlus + plus.length()).trim();

        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        double number3 = Double.parseDouble(num3);

        double result = ((number1 * number2) + number3);

        System.out.println("Result of " + number1 + " * " + number2 + " + " + number3 + " = " + result);

        keyboard.close();
    }
}

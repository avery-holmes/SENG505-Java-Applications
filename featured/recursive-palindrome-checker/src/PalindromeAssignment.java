/**
 * @author Avery Holmes
 * SENG 505 – Palindrome Determination Program
 *
 * Purpose:
 *   Prompt the user to enter any string and determine whether it is a palindrome.
 *   A recursive method evaluates a cleaned version of the string.
 */

import java.util.Scanner;

public class PalindromeAssignment {

    public static boolean isPalindrome(String userInput) {
        String cleanedUserInput = clean(userInput);
        return isPalindromeRec(cleanedUserInput);
    }

    private static boolean isPalindromeRec(String cleanedUserInput) {
        if (cleanedUserInput.length() <= 1) return true;

        if (cleanedUserInput.charAt(0) != cleanedUserInput.charAt(cleanedUserInput.length() - 1)) {
            return false;
        }

        return isPalindromeRec(cleanedUserInput.substring(1, cleanedUserInput.length() - 1));
    }

    private static String clean(String userInput) {
        String cleanedUserInput = "";
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleanedUserInput = cleanedUserInput + Character.toLowerCase(c);
            }
        }
        return cleanedUserInput;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userInput;

        System.out.println("Purpose: Enter any string of text and this program will let you know if it " +
                "is a palindrome. The answer will either be 'True' or 'False'. ");
        System.out.println();

        while (true) {
            System.out.println("Program will keep prompting for input until you select 'Q' to quit.");
            System.out.println("Enter text for review: ");
            userInput = keyboard.nextLine();

            if (userInput.equalsIgnoreCase("Q")) break;

            String cleanedUserInput = clean(userInput);
            if (cleanedUserInput.length() == 0) {
                System.out.println("Please enter at least one letter or digit.");
                continue;
            }

            boolean palindrome = isPalindrome(userInput);
            System.out.println("The String: " + userInput + " is a palindrome: ");
            System.out.println("Result: " + palindrome);
        }

        keyboard.close();
        System.out.println("Thank you for using this palindrome determination program.");
    }
}

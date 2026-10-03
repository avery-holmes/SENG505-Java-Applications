/**
 * @author Avery Holmes
 * SENG 505, Program Set 2 Part C
 * Palindrome Checker with Stacks
 *
 * Purpose:
 *   Read strings from the user, normalize the text (lowercase, letters only),
 *   and use a two stack algorithm to decide if the string reads the same forwards and backwards.
 */

import java.util.Scanner;
import java.util.Stack;

public class PalindromeStack {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a string to check (or Q to quit): ");
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                System.out.println("You entered: " + input);
                String cleaned = normalize(input);
                System.out.println("Normalized: " + cleaned);

                boolean palindrome = isPalindrome(input);

                if (palindrome) {
                    System.out.println("\"" + input + "\" IS a palindrome. \n");
                } else {
                    System.out.println("\"" + input + "\" IS NOT a palindrome. \n");
                }
            }
        }

        System.out.println("Thank you! Goodbye!");
        keyboard.close();
    }

    private static String normalize(String original) {
        String lower = original.toLowerCase();
        String cleanedInput = lower.replaceAll("[^a-z]", "");
        return cleanedInput;
    }

    private static boolean isPalindrome(String line) {
        String cleaned = normalize(line);
        if (cleaned.length() == 0) {
            return false;
        }

        Stack<Character> first = new Stack<>();
        Stack<Character> second = new Stack<>();

        for (int i = 0; i < cleaned.length(); i++) {
            first.push(cleaned.charAt(i));
        }

        int length = cleaned.length();
        int half = length / 2;

        for (int i = 0; i < half; i++) {
            char character = first.pop();
            second.push(character);
        }

        if (length % 2 == 1) {
            first.pop();
        }

        while (!first.empty() && !second.empty()) {
            char c1 = first.pop();
            char c2 = second.pop();

            if (c1 != c2) {
                return false;
            }
        }

        return true;
    }
}

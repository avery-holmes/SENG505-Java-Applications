/**
 * @author Avery Holmes
 * SENG 505 – Airplane Seating Assignments
 *
 * Purpose:
 *   Provide user-driven simulation of seat assignment for a 13-row airplane
 *   divided into First Class (Rows 1–2), Business Class (Rows 3–7), and Economy Class
 *   (Rows 8–13). The program accepts a ticket class and desired seat (e.g., 2B, 5F, 12C),
 *   validates inputs, assigns seats when valid, and displays the updated seating chart
 *   after each assignment all while handling invalid inputs. The session continues until the user enters 'Q' to quit.
 */

import java.util.Scanner;

public class AirplaneSeats {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] seats = new char[13][6];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) seats[i][j] = '*';
        }

        System.out.println("Seating Chart as of Now - All Seats Available");
        System.out.println();
        printSeatChart(seats);

        while (true) {
            System.out.println("Enter Ticket Type (First Class, Business Class or Economy Class) or 'Q' to quit:");
            String ticketType = keyboard.nextLine();
            ticketType = ticketType.trim().toLowerCase();
            if (ticketType.equalsIgnoreCase("Q")) break;

            System.out.println("Enter Desired Seat (e.g., 2B, 5F, 12C): ");
            String seatDesired = keyboard.nextLine();
            System.out.println("You chose: " + ticketType + " - " + seatDesired);

            seatValidator(ticketType, seatDesired, seats);
            printSeatChart(seats);
        }

        System.out.println("Thank you for using the Airplane Seat Assignment System!");
    }

    public static void seatValidator(String ticketType, String seatDesired, char[][] seats) {
        String seatCode = seatDesired.trim().toUpperCase();

        try {
            String seatNum = seatCode.substring(0, seatCode.length() - 1);
            int rowNumber = Integer.parseInt(seatNum);
            char seatCol = seatCode.charAt(seatCode.length() - 1);
            int colIndex = seatCol - 'A';

            if (colIndex < 0 || colIndex > 5) {
                System.out.println("Invalid Seat: Please select a seat column A-F. Thank You!");
                return;
            }

            if (!ticketType.equals("first class") &&
                    !ticketType.equals("business class") &&
                    !ticketType.equals("economy class")) {
                System.out.println("Invalid ticket type. Please enter 'First Class', 'Business Class', or 'Economy Class'.");
                return;
            }

            if (ticketType.equals("first class") && (rowNumber < 1 || rowNumber > 2)) {
                System.out.println("Invalid row for First Class. Please choose Rows 1-2.");
                return;
            }

            if (ticketType.equals("business class") && (rowNumber < 3 || rowNumber > 7)) {
                System.out.println("Invalid row for Business Class. Please choose Rows 3-7.");
                return;
            }

            if (ticketType.equals("economy class") && (rowNumber < 8 || rowNumber > 13)) {
                System.out.println("Invalid row for Economy Class. Please choose Rows 8-13.");
                return;
            }

            int rowIndex = rowNumber - 1;
            if (seats[rowIndex][colIndex] == 'X') {
                System.out.println("Seat already taken. Please choose another.");
                return;
            }

            seats[rowIndex][colIndex] = 'X';
            System.out.println("Seat " + seatCode + " successfully assigned.");
        } catch (Exception e) {
            System.out.println("Invalid seat format. Please enter a valid seat number. (e.g., 2B, 5F, 12C)");
        }
    }

    public static void printSeatChart(char[][] seats) {
        System.out.println("        A B C D E F");
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("Row %-3d ", (i + 1));
            for (int j = 0; j < 6; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}

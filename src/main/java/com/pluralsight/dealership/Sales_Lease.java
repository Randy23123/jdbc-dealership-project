package com.pluralsight.dealership;

import java.util.Scanner;

public class Sales_Lease {
    public static Scanner scanner = new Scanner(System.in);

    public static void salesLeaseScreen() {
        String input;
        while (true) {
            System.out.println("""
                    \nLog Screen
                     1) Car Sale
                     2) Car Lease
                     0) Exit
                    Select an option:""");

            input = scanner.nextLine().trim();

            switch (input) {
                case "1":

                    break;
                case "2":

                    break;
                case "0":
                    System.out.println("Exiting. Thank you for using D & B Used Cars.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
            System.out.println("Do you want to perform another Sale or Lease? (Y/N)");
            String continueOption = scanner.nextLine().trim();
            if (!continueOption.equalsIgnoreCase("Y")) {
                System.out.println("Exiting. Thank you for using D & B Used Cars.");
                System.exit(0);
            }
        }
    }
}

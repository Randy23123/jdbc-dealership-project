package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static Scanner scanner = new Scanner(System.in);
    public static DataManager dataManager;

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Please provide username and password as command-line arguments.");
            return;
        }

        String username = args[0];
        String password = args[1];
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/car_dealership");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataManager = new DataManager(dataSource);

        String input;
        while (true) {
            System.out.println("""
                    \nWelcome to D & B Used Cars
                     111 Old Benbrook Rd
                     817-555-5555
                    
                     Search Bar:
                     1) Price Range
                     2) Make and Model
                     3) Year Range
                     4) Vehicle Color
                     5) Mileage Range
                     6) Vehicle Type
                     0) Exit
                    Select an option:""");

            input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    dataManager.priceRange();
                    break;
                case "2":
                    dataManager.makeModel();
                    break;
                case "3":
                    dataManager.yearRange();
                    break;
                case "4":
                    dataManager.carColor();
                    break;
                case "5":
                    dataManager.mileageRange();
                    break;
                case "6":
                    dataManager.carType();
                    break;
                case "0":
                    System.out.println("Exiting. Thank you for using D & B Used Cars.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }

            System.out.println("Do you want to perform another search? (Y/N)");
            String continueOption = scanner.nextLine().trim();
            if (!continueOption.equalsIgnoreCase("Y")) {
                System.out.println("Exiting. Thank you for using D & B Used Cars.");
                System.exit(0);
            }
        }
    }
}
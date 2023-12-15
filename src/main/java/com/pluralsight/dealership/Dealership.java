package com.pluralsight.dealership;

import java.io.*;
import java.util.*;

public class Dealership {
    public static Scanner myScanner = new Scanner(System.in);
    public static HashMap<String, Vehicle> Cars = new HashMap<>();
    public static ArrayList<Vehicle> inventory = new ArrayList<>(Cars.values());

    public static void dealership() throws IOException {
        String dealershipScreen;
        do {
            System.out.println("\nWelcome to D & B Used Cars");
            System.out.println("111 Old Benbrook Rd");
            System.out.println("817-555-5555\n");
            System.out.println("Search Bar");
            System.out.println("(1) Price Range");
            System.out.println("(2) Make and Model");
            System.out.println("(3) Vehicle Year");
            System.out.println("(4) Vehicle Color");
            System.out.println("(5) Vehicle Mileage");
            System.out.println("(6) Vehicle Type");
            System.out.println("(7) All Vehicles");
            System.out.println("(8) Add Vehicle");
            System.out.println("(9) Remove Vehicle");
            System.out.println("(0) Quit");
            dealershipScreen = myScanner.next();
            myScanner.nextLine();

            switch (dealershipScreen) {
                case "1":
                    getVehiclesByPrice();
                    break;
                case "2":
                    getMakeAndModel();
                    break;
                case "3":
                    getYearRange();
                    break;
                case "4":
                    colorOfVehicle();
                    break;
                case "5":
                    mileageRange();
                    break;
                case "6":
                    vehicleType();
                    break;
                case "7":
                    allVehicles();
                    break;
                case "8":
                    addVehicles();
                    break;
                case "9":
                    removeVehicles();
                    break;
                case "0":
                    System.out.println("You have exited");
                    break;
                default:
                    System.out.println("Not an option, pick 1-9 or 0");
            }
        }
        while (!dealershipScreen.equals("4"));
    }


    public static void getVehiclesByPrice() {
        System.out.println("What's your minimum price? ");
        String userInput = myScanner.nextLine();
        double min = Double.parseDouble(userInput);

        System.out.println("What's your maximum price? ");
        String userInput2 = myScanner.nextLine();
        double max = Double.parseDouble(userInput2);

        for (Vehicle v : inventory){
            if (v.getPrice() >= min && v.getPrice() <= max){
                v.format();
            }
        }
    }

    public static void getMakeAndModel(){
        System.out.println("What make are you looking for? ");
        String makeInput = myScanner.nextLine();

        System.out.println("What model are you looking for? ");
        String modelInput = myScanner.nextLine();

        for (Vehicle v : inventory){
            if (makeInput.equalsIgnoreCase(v.getMake()) && modelInput.equalsIgnoreCase(v.getModel())){
                v.format();
            }
        }
    }

    public static void getYearRange(){
        System.out.println("What's your minimum year? ");
        String minYear = myScanner.nextLine();
        double min = Double.parseDouble(minYear);

        System.out.println("What's your max year? ");
        String maxYear = myScanner.nextLine();
        double max = Double.parseDouble(maxYear);

        for (Vehicle v : inventory){
            if (v.getYear() >= min && v.getYear() <= max){
                v.format();
            }
        }
    }

    public static void colorOfVehicle(){
        System.out.println("What color are you looking for? ");
        String colorInput = myScanner.nextLine();

        for (Vehicle v : inventory){
            if (colorInput.equalsIgnoreCase(v.getColor())){
                v.format();
            }
        }
    }

    public static void mileageRange(){
        System.out.println("What's your minimum mileage? ");
        String minMileage = myScanner.nextLine();
        double min = Double.parseDouble(minMileage);

        System.out.println("What's your max mileage? ");
        String maxMileage = myScanner.nextLine();
        double max = Double.parseDouble(maxMileage);

        for (Vehicle v : inventory){
            if (v.getOdometer() >= min && v.getOdometer() <= max){
                v.format();
            }
        }
    }

    public static void vehicleType(){
        System.out.println("What type of vehicle are you looking for? ");
        String typeInput = myScanner.nextLine();

        for (Vehicle v : inventory){
            if (typeInput.equalsIgnoreCase(v.getType())){
                v.format();
            }
        }
    }

    public static void  allVehicles(){
        for (Vehicle v : inventory){
            v.format();
        }
    }

    public static void  addVehicles() throws IOException {
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv", true));

        int vin;
        int year;
        String make;
        String model;
        String type;
        String color;
        int mileage;
        double price;
        String another;

        do {
            System.out.println("What is the vin?");
            vin = Integer.parseInt(myScanner.nextLine().trim());
            System.out.println("What is the year?");
            year = Integer.parseInt(myScanner.nextLine().trim());
            System.out.println("What is the make?");
            make = myScanner.nextLine().toLowerCase().trim();
            System.out.println("What is the model?");
            model = myScanner.nextLine().toLowerCase().trim();
            System.out.println("What is the type?");
            type = myScanner.nextLine().toLowerCase().trim();
            System.out.println("What is the color?");
            color = myScanner.nextLine().toLowerCase().trim();
            System.out.println("What is the mileage?");
            mileage = Integer.parseInt(myScanner.nextLine().trim());
            System.out.println("What is the price?");
            price = Integer.parseInt(myScanner.nextLine().trim());


            bufferedWriter.newLine();
            bufferedWriter.write((vin + "|" + year + "|" + make + "|" + model + "|" + type + "|" + color + "|" + mileage + "|" + price));
            System.out.println("Its been Stored do you want to Enter another? (Y/N)");
            another = myScanner.next().toUpperCase().trim();
        } while (another.equals("Y"));
        bufferedWriter.close();
    }

    public static void  removeVehicles(){

    }
}
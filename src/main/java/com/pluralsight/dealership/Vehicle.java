package com.pluralsight.dealership;


public class Vehicle {
    private int vin;
    private final int year;
    private final String make;
    private final String model;
    private final String type;
    private final String color;
    private int odometer;
    private final double price;

    public Vehicle(int vin, int year, String make, String model,String type, String color,int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }


    public double getPrice() {
        return this.price;
    }

    public int getVin() {
        return this.vin;
    }

    public int getYear() {
        return this.year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public int getOdometer() {
        return this.odometer;
    }

    //method
    public void format(){
        System.out.printf("Vin: %d | Date: %d | Make: %s | Model: %s | Type: %s | Color: %s | Mileage: %d | Price: $%.2f\n",
                this.getVin(), this.getYear(), this.getMake(), this.getModel(), this.getType(), this.getColor(), this.getOdometer(), this.getPrice());
    }
}

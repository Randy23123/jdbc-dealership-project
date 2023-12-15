package com.pluralsight.dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.dealership.Vehicle.getVehicle;

public class DataManager {
    public static Scanner scanner = new Scanner(System.in);

    static DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static List<Vehicle> priceRange() {
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter lowest and highest price");

        System.out.println("Lowest price: ");
        String lowest = scanner.nextLine().trim();

        System.out.println("\nHighest price: ");
        String highest = scanner.nextLine().trim();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE Price BETWEEN ? AND ?");
        ) {
            preparedStatement.setString(1, lowest);
            preparedStatement.setString(2, highest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = getVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            System.out.printf("Cars retrieved: %d\n", vehicles.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> makeModel() {
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter Make and Model");

        System.out.println("Make: ");
        String Make = scanner.nextLine().trim();

        System.out.println("\nModel: ");
        String Model = scanner.nextLine().trim();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE Make = ? AND Model = ?");
        ) {
            preparedStatement.setString(1, Make);
            preparedStatement.setString(2, Model);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = getVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            System.out.printf("Cars retrieved: %d\n", vehicles.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> yearRange() {
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter lowest and highest year");

        System.out.println("Lowest year: ");
        int lowest = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("\nHighest year: ");
        int highest = Integer.parseInt(scanner.nextLine().trim());

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE Year BETWEEN ? AND ?");
        ) {
            preparedStatement.setInt(1, lowest);
            preparedStatement.setInt(2, highest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = getVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            System.out.printf("Cars retrieved: %d\n", vehicles.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> carColor() {
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter a car color");

        System.out.println("Car Color: ");
        String carColor = scanner.nextLine().trim();


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE Color = ?");
        ) {
            preparedStatement.setString(1, carColor);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = getVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            System.out.printf("Cars retrieved: %d\n", vehicles.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> mileageRange() {
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter lowest and highest mileage");

        System.out.println("Lowest mileage: ");
        String lowest = scanner.nextLine().trim();

        System.out.println("\nHighest mileage: ");
        String highest = scanner.nextLine().trim();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE Mileage BETWEEN ? AND ?");
        ) {
            preparedStatement.setString(1, lowest);
            preparedStatement.setString(2, highest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = getVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            System.out.printf("Cars retrieved: %d\n", vehicles.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> carType() {
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter a car type");

        System.out.println("Car type: ");
        String carType = scanner.nextLine().trim();


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE Type = ?");
        ) {
            preparedStatement.setString(1, carType);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = getVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            System.out.printf("Cars retrieved: %d\n", vehicles.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
}

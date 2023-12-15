package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;


public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }
        String username = args[0];
        String password = args[1];
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/car_dealership");
        dataSource.setUsername(username);
        dataSource.setPassword(password);




        Dealership.dealership();
    }
}
package com.example.teidereservas;

import com.example.teidereservas.db.DatabaseConnection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.sql.*;

public class FlightGenerator {

    private static Connection conn = DatabaseConnection.getConnection();

    public static void main(String[] args) {
        generateRandomFlightsThatMakeSense();
    }

    private static LocalDate generateRandomDate() {
        Random random = new Random();
        LocalDate today = LocalDate.now();
        int daysToAdd = random.nextInt(365); // Random day within the next year
        return today.plusDays(daysToAdd);
    }

    // Generates a random return date after the departure date, within a month
    private static LocalDate generateRandomDateAfter(LocalDate startDate) {
        Random random = new Random();
        int daysToAdd = random.nextInt(30) + 1; // Return date within a month after departure
        return startDate.plusDays(daysToAdd);
    }

    // Generates a random time for departure or return
    private static LocalTime generateRandomTime() {
        Random random = new Random();
        int hour = random.nextInt(24); // Hours between 0 and 23
        int minute = random.nextInt(60); // Minutes between 0 and 59
        return LocalTime.of(hour, minute);
    }

    public static void generateRandomFlightsThatMakeSense() {
        String query = "INSERT INTO flights (origin, destination, departure_date, departure_time, return_date, return_time, passengers, class, price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String[] destinies = getDestiniesArray();
        String[] classes = {"Economy", "Business", "First"};

        try {
            PreparedStatement ps;

            for (int i = 0; i < 25000; i++) {

                String origin = destinies[(int) Math.floor(Math.random() * destinies.length)];
                String destination = destinies[(int) Math.floor(Math.random() * destinies.length)];

                while (origin.equals(destination)) {
                    destination = destinies[(int) Math.floor(Math.random() * destinies.length)];
                }

                String departureDate = generateRandomDate().toString();
                String returnDate = generateRandomDateAfter(Date.valueOf(departureDate).toLocalDate()).toString();
                String departureTime = generateRandomTime().toString();
                String returnTime = generateRandomTime().toString();

                int passengers = (int) (Math.random() * 15);

                String flightClass = classes[(int) (Math.random() * classes.length)];

                ps = conn.prepareStatement(query);

                ps.setString(1, origin);
                ps.setString(2, destination);
                ps.setString(3, departureDate);
                ps.setString(4, departureTime);
                ps.setString(5, returnDate);
                ps.setString(6, returnTime);
                ps.setInt(7, passengers);
                ps.setString(8, flightClass);
                ps.setDouble(9, Math.random() * 2000);

                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] getDestiniesArray() {
        return new String[]{
                "Madrid", "Paris", "Barcelona", "Londres", "Roma", "Amsterdam", "Praga", "Brasilia", "Sao Paulo", "Lisbona", "Copenhague", "Amsterdam", "Praga", "Brasilia", "Sao Paulo", "Lisbona", "Copenhague"
        };

    }
}

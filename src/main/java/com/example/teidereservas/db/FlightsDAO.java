package com.example.teidereservas.db;

import com.example.teidereservas.flights.Flight;
import com.example.teidereservas.flights.FlightManager;

import java.sql.*;
import java.util.ArrayList;

public class FlightsDAO {

    private static Connection conn = DatabaseConnection.getConnection();

    public static ArrayList<Flight> getFlights(String origin, String destination, String departureDate, String returnDate, int passengers, String flightClass) {
        String query = "SELECT * FROM flights " +
                "WHERE origin LIKE ? " +
                "AND destination LIKE ? " +
                "AND departure_date LIKE ? " +
                "AND return_date LIKE ? " +
                "AND passengers = ? " +
                "AND class LIKE ? " +
                "ORDER BY price DESC";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, origin);
            ps.setString(2, destination);
            ps.setDate(3, Date.valueOf(departureDate));
            ps.setDate(4, Date.valueOf(returnDate));
            ps.setInt(5, passengers);
            ps.setString(6, flightClass);

            ResultSet rs = ps.executeQuery();

            createFlightObjects(rs);

            return new ArrayList<>(FlightManager.getFlightMap().values());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Flight> getAlternativeFlights(String origin, String destination) {
        String query = "SELECT * FROM flights " +
                "WHERE origin LIKE ? " +
                "AND destination LIKE ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, origin);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            createFlightObjects(rs);

            return new ArrayList<>(FlightManager.getFlightMap().values());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Flight> getFlightsByIds(ArrayList<Integer> ids) {
        String idsStr = String.join(",", ids.stream().map(Object::toString).toArray(String[]::new));
        String query = "SELECT * FROM flights WHERE id IN (" + idsStr + ")";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            createFlightCacheObjects(rs);

            return new ArrayList<>(FlightManager.getFlightCache());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void createFlightObjects(ResultSet rs) throws SQLException {
        while (rs.next()) {
            FlightManager.addFlight(new Flight(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4).toString(),
                    rs.getTime(5).toString(),
                    rs.getDate(6).toString(),
                    rs.getTime(7).toString(),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getDouble(10)
            ));
        }
    }

    private static void createFlightCacheObjects(ResultSet rs) throws SQLException {
        FlightManager.clearCache();

        while (rs.next()) {
            FlightManager.addFlightToCache(new Flight(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4).toString(),
                    rs.getTime(5).toString(),
                    rs.getDate(6).toString(),
                    rs.getTime(7).toString(),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getDouble(10)
            ));
        }
    }
}

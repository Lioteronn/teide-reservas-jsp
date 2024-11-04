package com.example.teidereservas;

import java.util.ArrayList;

public class FlightManager {

    private static ArrayList<Flight> flightList = new ArrayList<>();

    public static void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public static void clearFlightList() {
        flightList.clear();
    }

    public static ArrayList<Flight> getFlightList() {
        return flightList;
    }

}

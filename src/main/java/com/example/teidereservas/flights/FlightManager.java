package com.example.teidereservas;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightManager {

    private static HashMap<Integer, Flight> flightMap = new HashMap<>();

    public static void addFlight(Flight flight) {
        flightMap.put(flight.getId(), flight);
    }

    public static void clearFlightMap() {
        flightMap.clear();
    }

    public static HashMap<Integer, Flight> getFlightMap() {
        return flightMap;
    }

}

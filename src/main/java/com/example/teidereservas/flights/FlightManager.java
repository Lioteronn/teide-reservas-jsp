package com.example.teidereservas.flights;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightManager {

    private static HashMap<Integer, Flight> flightMap = new HashMap<>();
    private static ArrayList<Flight> flightCache = new ArrayList<>();


    public static void clearCache() {
        flightCache.clear();
    }

    public static void addFlightToCache(Flight flight) {
        flightCache.add(flight);
    }

    public static ArrayList<Flight> getFlightCache() {
        return flightCache;
    }

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

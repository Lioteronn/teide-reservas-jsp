package com.example.teidereservas.reservations;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationManager {

    private static HashMap<String, ArrayList<Integer>> reservationsMap = new HashMap<>();

    public static void addReservationToUser(String username, int id) {
        reservationsMap.putIfAbsent(username, new ArrayList<>());
        reservationsMap.get(username).add(id);
    }

    public static HashMap<String, ArrayList<Integer>> getReservationsMap() {
        return reservationsMap;
    }

}

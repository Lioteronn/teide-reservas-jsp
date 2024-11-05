package com.example.teidereservas;

public class Flight {

    private int id;
    private String from;
    private String to;
    private String departureDate;
    private String departureTime;
    private String returnDate;
    private String returnTime;
    private int passengers;
    private String flightClass;
    private double price;

    public Flight(int id, String from, String to, String departureDate, String departureTime, String returnDate, String returnTime, int passengers, String flightClass, double price) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.passengers = passengers;
        this.flightClass = flightClass;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public int getPassengers() {
        return passengers;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public int getPrice() {
        return (int) Math.floor(price);
    }
}

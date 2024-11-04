<%@ page import="com.example.teidereservas.Flight" %>
<%@ page import="com.example.teidereservas.db.FlightsDAO" %><%--
  Created by IntelliJ IDEA.
  User: alex3
  Date: 28/10/2024
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList, com.example.teidereservas.db.FlightsDAO" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados de Búsqueda de Vuelos</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
<main>
    <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String from = request.getParameter("from");
        String to = request.getParameter("to");

        // Handle empty or null departureDate
        String departureDate = request.getParameter("departure-date");
        if (departureDate == null || departureDate.isEmpty()) {
            departureDate = "";
        }

        // Handle empty or null returnDate
        String returnDate = request.getParameter("return-date");
        if (returnDate == null || returnDate.isEmpty()) {
            returnDate = "";
        }

        // Handle empty or null passengers, default to 0 if empty
        String passengersParam = request.getParameter("passengers");
        int passengers = 0; // default value
        if (passengersParam != null && !passengersParam.isEmpty()) {
            passengers = Integer.parseInt(passengersParam);
        }

        String flightClass = request.getParameter("class");

        ArrayList<Flight> flights;

        if (departureDate.isEmpty() && returnDate.isEmpty()) {
            flights =  FlightsDAO.getFlightsWithoutDatesAndPassengers(from, to, flightClass);
        } else {
            flights =  FlightsDAO.getFlights(from, to, departureDate, returnDate, passengers, flightClass);
        }

        request.setAttribute("flights", flights);
    %>

    <section class="search-results">
        <h2>Los vuelos mas baratos</h2>
        <div class="flight-list">
            <c:forEach var="flight" items="${flights}">
                <div class="flight-card">
                    <div class="flight-class">
                        <p class="flight-p-class">${flight.flightClass}</p>
                    </div>
                    <div class="flight-info">
                        <p class="flight-date">${flight.departureDate} a ${flight.returnDate}</p>
                        <p class="flight-to-passengers">${flight.to} | ${flight.passengers} pasajeros</p>
                    </div>
                    <div class="flight-price">
                        <p class="flight-p">Desde</p>
                        <p class="flight-p-price">${flight.price} €</p>
                        <p class="flight-p">Ida y vuelta</p>
                    </div>
                    <button type="button">Reservar</button>
                </div>
            </c:forEach>
        </div>
    </section>
</main>
</body>
</html>

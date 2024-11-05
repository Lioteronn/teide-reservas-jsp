<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.teidereservas.reservations.ReservationManager" %>
<%@ page import="com.example.teidereservas.db.FlightsDAO" %>
<%@ page import="com.example.teidereservas.flights.Flight" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex3
  Date: 05/11/2024
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservations</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
<%
    String username = (String) request.getSession().getAttribute("username");
    ArrayList<Flight> reservations;

    if (!ReservationManager.getReservationsMap().isEmpty() && username != null) {
        reservations = new ArrayList<>(FlightsDAO.getFlightsByIds(ReservationManager.getReservationsMap().get(username)));
        System.out.println(reservations);
        request.setAttribute("reservations", reservations);
    } else {
        request.setAttribute("reservations", new ArrayList<>());
    }
%>

<div class="shopping-cart">
    <div class="shopping-cart-header">
        <h2>Checkout</h2>
        <img class="cart-close-button" src="./css/assets/close-button.png" alt="close-button">
    </div>
    <table class="cart-table">
        <tr class="cart-row">
            <th class="cart-header">Vuelo</th>
            <th class="cart-header">Origen</th>
            <th class="cart-header">Destino</th>
            <th class="cart-header">Fecha de ida</th>
            <th class="cart-header">Fecha de vuelta</th>
            <th class="cart-header">Clase</th>
            <th class="cart-header">Precio</th>
        </tr>
        <c:forEach var="reservation" items="${reservations}">
            <tr class="cart-row">
                <td class="cart-cell">${reservation.id}</td>
                <td class="cart-cell">${reservation.from}</td>
                <td class="cart-cell">${reservation.to}</td>
                <td class="cart-cell">${reservation.departureDate}</td>
                <td class="cart-cell">${reservation.returnDate}</td>
                <td class="cart-cell">${reservation.flightClass}</td>
                <td class="cart-cell">${reservation.price} €</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

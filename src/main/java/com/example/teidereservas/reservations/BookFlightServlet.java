package com.example.teidereservas.reservations;

import com.example.teidereservas.flights.FlightManager;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/BookFlightServlet")
public class BookFlightServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        int flightId = Integer.parseInt(req.getParameter("flightId"));

        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
            ReservationManager.addReservationToUser(username, flightId);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            FlightManager.clearCache();
        } else {
            System.out.println("Not logged in.");
        }

    }

}

package com.example.teidereservas;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class BookFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flightId = Integer.parseInt(req.getParameter("flightId"));

        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            
        }

    }

}

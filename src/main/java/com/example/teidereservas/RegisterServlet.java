package com.example.teidereservas;

import com.example.teidereservas.db.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDAO.insertUser(
                    req.getParameter("username"),
                    req.getParameter("email"),
                    BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt()),
                    req.getParameter("name"),
                    req.getParameter("surnameOne"),
                    req.getParameter("surnameTwo")
            );
            resp.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("registerError", "El usuario ya existe, por favor inicie sesión.");
        }
    }
}

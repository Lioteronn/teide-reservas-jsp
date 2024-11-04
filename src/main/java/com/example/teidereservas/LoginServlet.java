package com.example.teidereservas;

import com.example.teidereservas.db.DatabaseConnection;
import com.example.teidereservas.db.User;
import com.example.teidereservas.db.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        try {
            User user = UserDAO.getUser(username);

            if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
                HttpSession session = req.getSession();
                session.setAttribute("username", user.getUsername());
                session.setAttribute("name", user.getName());
                session.setAttribute("surnameOne", user.getSurnameOne());
                session.setAttribute("surnameTwo", user.getSurnameTwo());
                session.setAttribute("email", user.getEmail());
                resp.sendRedirect("index.jsp");
            } else {
                req.setAttribute("loginError", "Inválido, verifique sus credenciales.");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

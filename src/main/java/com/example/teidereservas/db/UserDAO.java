package com.example.teidereservas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static Connection conn;

    public static User getUser(String username) throws SQLException {
        conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String email = rs.getString("email");
            String passwordHash = rs.getString("password_hash");
            String name = rs.getString("real_name");
            String surnameOne = rs.getString("apellido_uno");
            String surnameTwo = rs.getString("apellido_dos");

            return new User(username, email, passwordHash, name, surnameOne, surnameTwo);
        }

        return null;
    }

    public static void insertUser(String username, String email, String passwordHash, String realName, String apellidoUno, String apellidoDos) throws SQLException {
        conn = DatabaseConnection.getConnection();

        String query = "INSERT INTO users (username, email, password_hash, real_name, apellido_uno, apellido_dos) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, passwordHash);
            ps.setString(4, realName);
            ps.setString(5, apellidoUno);
            ps.setString(6, apellidoDos);

            ps.executeUpdate();
        }
    }

}

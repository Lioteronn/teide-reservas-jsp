package com.example.teidereservas.db;

public class User {

    private String username;
    private String email;
    private String passwordHash;
    private String name;
    private String surnameOne;
    private String surnameTwo;

    public User(String username, String email, String passwordHash, String name, String surnameOne, String surnameTwo) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
        this.surnameOne = surnameOne;
        this.surnameTwo = surnameTwo;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getName() {
        return name;
    }

    public String getSurnameOne() {
        return surnameOne;
    }

    public String getSurnameTwo() {
        return surnameTwo;
    }
}
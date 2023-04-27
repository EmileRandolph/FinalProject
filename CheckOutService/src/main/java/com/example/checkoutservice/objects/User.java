package com.example.checkoutservice.objects;

import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class User {
    @Id
    private UUID userID;
    @Nonnull
    private String username;
    private String name;
    private String email;
    @Nonnull
    private String password;
    private String address;

    public User(String username, String name, String email, String password, String address) {
        userID = UUID.randomUUID();
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(String username, String name, String email, String password) {
        userID = UUID.randomUUID();
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


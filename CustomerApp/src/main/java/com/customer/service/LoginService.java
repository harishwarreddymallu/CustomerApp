package com.customer.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    /**
     * Validates the provided username and password.
     * 
     * @param username The provided username.
     * @param password The provided password.
     * @return true if the provided credentials match the actual ones, false otherwise.
     */
    public boolean valid(String username, String password) {
        // Actual username and password stored in the system
        String actualUsername = "XXXX";
        String actualPassword = "XXXX";

        // Check if the provided credentials match the actual ones
        if (username.equals(actualUsername) && password.equals(actualPassword)) {
            return true;
        }
        return false;
    }
}

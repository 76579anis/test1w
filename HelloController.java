package com.example.test1b;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField usernameField;
    public TextField passwordField;
    public Label welcomeText;
    private int failedAttempts = 0; // Initialize failed attempts counter
    private final int MAX_ATTEMPTS = 5; // Maximum allowed failed attempts

    public void Login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if the account is locked
        if (failedAttempts >= MAX_ATTEMPTS) {

            welcomeText.setText("Sorry, Your Account is Locked!!!");
            return;
        }

        // Check if either field is empty
        if (username.isEmpty() || password.isEmpty()) {
            welcomeText.setText("Please Provide Username or Password");
            return;
        }

        // Check username and password
        if (username.equals("YOUR_FIRST_NAME") && password.equals("456")) {

            welcomeText.setText("Success!!!");
            failedAttempts = 0; // Reset failed attempts after successful login
        } else {
            failedAttempts++;
            int remainingAttempts = MAX_ATTEMPTS - failedAttempts; // Calculate remaining attempts
            if (remainingAttempts > 0) {

                welcomeText.setText("Sorry, Invalid Username or Password. You have " + remainingAttempts + " attempt(s) left.");
            } else {

                welcomeText.setText("Sorry, Invalid Username or Password. No attempts left. Your account is locked.");
            }
        }
    }

}



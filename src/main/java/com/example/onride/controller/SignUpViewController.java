package com.example.onride.controller;

import com.example.onride.dao.UserDAO;
import com.example.onride.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpViewController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    private UserDAO userDAO = new UserDAO();

    @FXML
    void handleSignUpButtonAction(ActionEvent event) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill all the fields");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Passwords do not match");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        if (userDAO.signUp(user, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful!", "You can now sign in");
            // Navigate to the login view
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/LoginView.fxml"));
                Stage stage = (Stage) nameField.getScene().getWindow();
                stage.setScene(new Scene(root, 1000, 600));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed!", "Email already exists");
        }
    }

    @FXML
    void handleSignInLinkAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/LoginView.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

package com.example.onride.controller;

import com.example.onride.model.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private VBox contentArea;

    @FXML
    private void initialize() {
        // Load the initial content (e.g., Home page)
        handleHomeButtonAction(null);
    }

    @FXML
    void handleHomeButtonAction(ActionEvent event) {
        loadPage("HomeView.fxml");
    }

    @FXML
    void handleVehiclesButtonAction(ActionEvent event) {
        loadPage("VehiclesView.fxml");
    }

    @FXML
    void handleAdminButtonAction(ActionEvent event) {
        loadPage("AdminView.fxml");
    }

    @FXML
    void handleMyBookingsButtonAction(ActionEvent event) {
        loadPage("MyBookingsView.fxml");
    }

    @FXML
    void handleLogoutButtonAction(ActionEvent event) {
        SessionManager.getInstance().clearSession();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/LoginView.fxml"));
            Stage stage = (Stage) contentArea.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPage(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/" + fxmlFile));
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

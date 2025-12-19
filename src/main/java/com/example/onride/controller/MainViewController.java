package com.example.onride.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

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

    private void loadPage(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/" + fxmlFile));
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

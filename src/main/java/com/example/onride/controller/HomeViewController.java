package com.example.onride.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeViewController {

    // These should match the fx:id in your new FXML
    @FXML private TextField locationField;
    @FXML private DatePicker pickUpDate;

    @FXML
    public void initialize() {
        // Since we removed the ComboBox in the new design, 
        // we no longer need to initialize it.
        // You can initialize date pickers or other logic here.
    }

    @FXML
    void handleSearchButtonAction(ActionEvent event) {
        // Example logic for the new search bar
        String location = (locationField != null) ? locationField.getText() : "";
        
        if (location.trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Search Warning", "Please enter a location.");
            return;
        }
        
        loadVehiclesView("All", location);
    }

    // Helper method to handle navigation
    private void loadVehiclesView(String type, String location) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onride/VehiclesView.fxml"));
            Parent root = loader.load();
            
            // VehiclesViewController controller = loader.getController();
            // controller.setSearchParameters(type, location);
            
            Stage stage = (Stage) locationField.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 600));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "View not found.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
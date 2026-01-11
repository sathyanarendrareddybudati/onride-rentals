package com.onriderentals.controller;

import com.onriderentals.dao.VehicleDAO;
import com.onriderentals.factory.SceneManager;
import com.onriderentals.model.SessionManager;
import com.onriderentals.model.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRentalController {

    @FXML
    private FlowPane vehicleGrid;
    @FXML
    private ComboBox<String> locationCombo;
    @FXML
    private ComboBox<String> sortCombo;
    @FXML
    private Slider priceSlider;
    @FXML
    private Label priceValueLabel;
    @FXML
    private DatePicker pickupDatePicker;
    @FXML
    private DatePicker returnDatePicker;
    @FXML
    private Label resultsCountLabel;
    @FXML
    private Button filterAllBtn;
    @FXML
    private Button filterBikeBtn;
    @FXML
    private Button filterCarBtn;

    private VehicleDAO vehicleDAO;
    private ObservableList<Vehicle> allVehicles;
    private String currentTypeFilter = "All";

    public void initialize() {
        vehicleDAO = new VehicleDAO();
        allVehicles = FXCollections.observableArrayList();

        setupFilters();
        loadVehicles();
    }

    private void setupFilters() {
        // Initialize Filter Controls
        locationCombo.setItems(FXCollections.observableArrayList("All Locations", "New York", "Los Angeles", "Chicago", "Miami"));
        locationCombo.setValue("All Locations");

        sortCombo.setItems(FXCollections.observableArrayList("Recommended", "Price: Low to High", "Price: High to Low", "Rating"));
        sortCombo.setValue("Recommended");

        // Slider Listener
        priceSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            priceValueLabel.setText("$" + String.format("%.0f", newVal));
            filterVehicles();
        });
        
        // Combo Listeners
        locationCombo.valueProperty().addListener((obs, oldVal, newVal) -> filterVehicles());
        sortCombo.valueProperty().addListener((obs, oldVal, newVal) -> sortVehicles());
    }

    private void loadVehicles() {
        try {
            List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
            if (vehicles != null) {
                // Filter only available vehicles initially
                 List<Vehicle> available = vehicles.stream()
                    .filter(v -> "Available".equalsIgnoreCase(v.getStatus()))
                    .collect(Collectors.toList());
                allVehicles.setAll(available);
                renderVehicles(allVehicles);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Show error alert
        }
    }

    private void renderVehicles(List<Vehicle> vehicles) {
        vehicleGrid.getChildren().clear();
        resultsCountLabel.setText("Showing " + vehicles.size() + " vehicles");

        for (Vehicle vehicle : vehicles) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/onriderentals/view/VehicleCard.fxml"));
                Parent card = loader.load();
                
                VehicleCardController controller = loader.getController();
                controller.setVehicle(vehicle);
                
                vehicleGrid.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void filterByType(javafx.event.ActionEvent event) {
        Button clickedBtn = (Button) event.getSource();
        
        // Reset styles
        filterAllBtn.getStyleClass().remove("selected");
        filterBikeBtn.getStyleClass().remove("selected");
        filterCarBtn.getStyleClass().remove("selected");
        
        // Set selected
        clickedBtn.getStyleClass().add("selected");
        
        if (clickedBtn == filterAllBtn) currentTypeFilter = "All";
        else if (clickedBtn == filterBikeBtn) currentTypeFilter = "Bike";
        else if (clickedBtn == filterCarBtn) currentTypeFilter = "Car";
        
        filterVehicles();
    }

    private void filterVehicles() {
        double maxPrice = priceSlider.getValue();
        String location = locationCombo.getValue();
        
        List<Vehicle> filtered = allVehicles.stream()
                .filter(v -> v.getPricePerDay() <= maxPrice)
                .filter(v -> {
                    if (currentTypeFilter.equals("All")) return true;
                    return v.getType().equalsIgnoreCase(currentTypeFilter);
                })
                // Add location filter logic here if Vehicle model has location
                .collect(Collectors.toList());
        
        renderVehicles(filtered);
    }
    
    private void sortVehicles() {
        // Implement sorting logic based on sortCombo.getValue()
        // For now just re-rendering
        filterVehicles();
    }

    // Navigation Methods
    @FXML
    public void handleHome() {
        // Already on home/browse
    }

    @FXML
    public void handleBookings() {
         try {
            SceneManager.switchScene("MyBookings"); // Assuming MyBookings view exists or will be created
        } catch (Exception e) {
            System.err.println("Navigation error: " + e.getMessage());
        }
    }

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().clearSession();
        try {
            SceneManager.switchScene("Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



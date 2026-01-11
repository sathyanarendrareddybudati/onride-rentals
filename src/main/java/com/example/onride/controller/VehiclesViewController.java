package com.example.onride.controller;

import com.example.onride.dao.VehicleDAO;
import com.example.onride.model.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class VehiclesViewController implements Initializable {

    @FXML
    private TextField searchField;

    @FXML
    private FlowPane vehicleGrid;

    @FXML
    private ComboBox<String> filterCombo;

    @FXML
    private ComboBox<String> sortCombo;

    @FXML
    private ComboBox<String> locationCombo;

    @FXML
    private ToggleButton allToggle;

    @FXML
    private ToggleButton bikesToggle;

    @FXML
    private ToggleButton carsToggle;

    @FXML
    private Slider priceSlider;

    private ToggleGroup vehicleTypeGroup;

    private VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize filter combo
        filterCombo.getItems().addAll("All", "BIKE", "CAR");
        filterCombo.setValue("All");

        // Initialize sort combo
        sortCombo.getItems().addAll("Price: Low to High", "Price: High to Low");
        sortCombo.setValue("Price: Low to High");

        // Initialize location combo
        locationCombo.getItems().addAll("All Locations", "New York", "Los Angeles", "Chicago", "Houston");
        locationCombo.setValue("All Locations");

        // Setup toggle group for vehicle type
        vehicleTypeGroup = new ToggleGroup();
        allToggle.setToggleGroup(vehicleTypeGroup);
        bikesToggle.setToggleGroup(vehicleTypeGroup);
        carsToggle.setToggleGroup(vehicleTypeGroup);
        allToggle.setSelected(true);

        // Load vehicles
        loadVehicles();

        // Add listeners
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterAndSortVehicles());
        filterCombo.valueProperty().addListener((observable, oldValue, newValue) -> filterAndSortVehicles());
        sortCombo.valueProperty().addListener((observable, oldValue, newValue) -> filterAndSortVehicles());
        locationCombo.valueProperty().addListener((observable, oldValue, newValue) -> filterAndSortVehicles());
        vehicleTypeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> filterAndSortVehicles());
        priceSlider.valueProperty().addListener((observable, oldValue, newValue) -> filterAndSortVehicles());
    }

    private void loadVehicles() {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void filterAndSortVehicles() {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();

        // Filter by search text
        String searchText = searchField.getText().toLowerCase();
        if (!searchText.isEmpty()) {
            vehicles = vehicles.stream()
                    .filter(v -> v.getBrand().toLowerCase().contains(searchText) || 
                                 v.getModel().toLowerCase().contains(searchText))
                    .collect(Collectors.toList());
        }

        // Filter by type
        ToggleButton selectedToggle = (ToggleButton) vehicleTypeGroup.getSelectedToggle();
        if (selectedToggle != null) {
            String selectedType = selectedToggle.getText();
            if ("Bikes".equals(selectedType)) {
                vehicles = vehicles.stream()
                        .filter(v -> "BIKE".equals(v.getType()))
                        .collect(Collectors.toList());
            } else if ("Cars".equals(selectedType)) {
                vehicles = vehicles.stream()
                        .filter(v -> "CAR".equals(v.getType()))
                        .collect(Collectors.toList());
            }
        }

        // Filter by price
        double maxPrice = priceSlider.getValue();
        vehicles = vehicles.stream()
                .filter(v -> v.getPricePerDay() <= maxPrice)
                .collect(Collectors.toList());

        // Sort by price
        String sortType = sortCombo.getValue();
        if ("Price: Low to High".equals(sortType)) {
            vehicles.sort(Comparator.comparing(Vehicle::getPricePerDay));
        } else if ("Price: High to Low".equals(sortType)) {
            vehicles.sort(Comparator.comparing(Vehicle::getPricePerDay).reversed());
        }

        displayVehicles(vehicles);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        vehicleGrid.getChildren().clear();

        for (Vehicle vehicle : vehicles) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onride/VehicleCard.fxml"));
                VBox vehicleCard = loader.load();
                VehicleCardController controller = loader.getController();
                controller.setVehicle(vehicle);

                vehicleGrid.getChildren().add(vehicleCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleHostVehicleAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/HostVehicleView.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Host a New Vehicle");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            loadVehicles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

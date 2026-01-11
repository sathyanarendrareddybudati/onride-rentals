package com.onriderentals.controller;

import com.onriderentals.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VehicleCardController {

    @FXML private ImageView vehicleImage;
    @FXML private Label vehicleName;
    @FXML private Label vehicleModel;
    @FXML private Label locationLabel;
    @FXML private Label typeBadge;
    @FXML private Label ratingLabel;
    @FXML private Label reviewCountLabel;
    @FXML private Label priceLabel;
    @FXML private Button bookButton;
    @FXML private Button favoriteButton;

    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        
        vehicleName.setText(vehicle.getMake()); // Using make as title for now
        vehicleModel.setText(vehicle.getModel() + " - " + vehicle.getYear());
        typeBadge.setText(vehicle.getType());
        priceLabel.setText("$" + String.format("%.0f", vehicle.getPricePerDay()));
        
        // Mock data for missing fields
        locationLabel.setText("New York"); 
        ratingLabel.setText("4.5");
        reviewCountLabel.setText("(120 reviews)");

        // Basic image placeholder logic
        try {
            // In a real app, load image from URL or path
            // vehicleImage.setImage(new Image(vehicle.getImageUrl()));
             String imagePath = "/com/onriderentals/view/images/" + vehicle.getType().toLowerCase() + "_placeholder.png"; 
             // For now just leave empty or set a color if needed, or rely on FXML placeholder
        } catch (Exception e) {
            System.err.println("Could not load image for vehicle: " + vehicle.getMake());
        }
    }
    
    @FXML
    private void handleBook() {
        System.out.println("Book clicked for: " + vehicle.getMake());
        // Logic to trigger booking dialog
    }
}

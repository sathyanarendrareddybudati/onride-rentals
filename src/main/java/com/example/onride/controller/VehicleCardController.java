package com.example.onride.controller;

import com.example.onride.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VehicleCardController {

    @FXML
    private ImageView vehicleImage;

    @FXML
    private Label title;

    @FXML
    private Label subtitle;

    @FXML
    private Label location;

    @FXML
    private Label price;

    @FXML
    private Label typeBadge;

    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        updateView();
    }

    private void updateView() {
        if (vehicle != null) {
            title.setText(vehicle.getBrand() + " " + vehicle.getModel());
            subtitle.setText("Year: " + vehicle.getYear());
            location.setText("📍 " + vehicle.getLocation());
            price.setText(String.format("$%.2f/day", vehicle.getPricePerDay()));
            typeBadge.setText(vehicle.getType());

            if (vehicle.getImageUrl() != null && !vehicle.getImageUrl().isEmpty()) {
                try {
                    Image image = new Image(vehicle.getImageUrl());
                    vehicleImage.setImage(image);
                } catch (Exception e) {
                    // Use a default image if the URL is invalid
                    loadDefaultImage();
                }
            } else {
                // Use a default image if no URL is provided
                loadDefaultImage();
            }
        }
    }

    private void loadDefaultImage() {
        try {
            Image defaultImage = new Image(getClass().getResourceAsStream("/images/default_vehicle.png"));
            if (defaultImage != null) {
                vehicleImage.setImage(defaultImage);
            }
        } catch (Exception e) {
            System.out.println("Default image not found");
        }
    }

    @FXML
    private void handleBookAction() {
        System.out.println("Book now for vehicle: " + vehicle.getVehicleId());
    }
}

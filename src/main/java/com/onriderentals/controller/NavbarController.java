package com.onriderentals.controller;

import com.onriderentals.factory.SceneManager;
import com.onriderentals.model.SessionManager;
import javafx.fxml.FXML;

public class NavbarController {

    @FXML
    public void handleHome() {
        try {
            SceneManager.switchScene("Home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBrowseVehicles() {
        try {
            SceneManager.switchScene("VehicleRental");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLogin() {
        try {
            SceneManager.switchScene("Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleRegister() {
        try {
            SceneManager.switchScene("Register");
        } catch (Exception e) {
            e.printStackTrace();
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

package com.example.onride.controller;

import com.example.onride.dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminViewController {

    @FXML
    private Label totalUsersLabel;

    @FXML
    private Label totalRidesLabel;

    private UserDAO userDAO = new UserDAO();

    @FXML
    public void initialize() {
        // For now, we'll just set some dummy data
        totalUsersLabel.setText("150");
        totalRidesLabel.setText("300");
    }
}

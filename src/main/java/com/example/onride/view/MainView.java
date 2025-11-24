// MainView.java
package com.example.onride.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
    public MainView() {
        initializeUI();
    }

    private void initializeUI() {
        // Add your UI components here
        Label welcomeLabel = new Label("Welcome to OnRide");
        setCenter(welcomeLabel);
    }
}
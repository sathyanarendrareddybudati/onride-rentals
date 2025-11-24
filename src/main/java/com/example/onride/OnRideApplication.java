package com.example.onride;

import com.example.onride.view.LoginView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OnRideApplication extends Application {
    
    @Override
    public void init() {
        // Initialize any resources here if needed
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Initialize the root layout
            LoginView loginView = new LoginView();
            Scene scene = new Scene(loginView, 800, 600);
            
            // Load CSS
            try {
                String css = getClass().getResource("/styles.css").toExternalForm();
                scene.getStylesheets().add(css);
            } catch (Exception e) {
                System.err.println("Warning: Could not load CSS file: " + e.getMessage());
            }
            
            // Configure the stage
            primaryStage.setTitle("OnRide - Sign In");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(600);
            
            // Set up proper close handling
            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });
            
            // Show the stage
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to start application: " + e.getMessage());
            Platform.exit();
        }
    }

    @Override
    public void stop() {
        // Clean up resources if needed
    }

    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}
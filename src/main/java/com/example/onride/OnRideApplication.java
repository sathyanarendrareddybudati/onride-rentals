package com.example.onride;

import java.io.IOException;
import java.sql.SQLException;

import com.example.onride.database.Database;
import com.example.onride.model.User;
import com.example.onride.util.DatabaseInitializer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OnRideApplication extends Application {

    private static User currentUser;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Database.getConnection();
            // Initialize demo users
            DatabaseInitializer.createDemoUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to database. Please check your database configuration.");
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/onride/LoginView.fxml"));
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setTitle("OnRide - Vehicle Rental");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
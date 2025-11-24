package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the main layout
        BorderPane root = new BorderPane();
        
        // Create menu bar
        MenuBar menuBar = createMenuBar();
        
        // Create header
        VBox header = createHeader();
        
        // Create content area
        GridPane content = createContent();
        
        // Create footer
        HBox footer = createFooter();
        
        // Add components to the root layout
        VBox topContainer = new VBox(menuBar, header);
        root.setTop(topContainer);
        
        // Set content with margins
        VBox contentContainer = new VBox(content);
        contentContainer.setPadding(new Insets(20));
        root.setCenter(contentContainer);
        
        root.setBottom(footer);
        
        // Create scene and set it on the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bike & Car Booking Platform");
        primaryStage.show();
    }
    
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        
        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exitItem);
        
        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> showAboutDialog());
        helpMenu.getItems().add(aboutItem);
        
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }
    
    private VBox createHeader() {
        VBox header = new VBox();
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: #2c3e50;");
        
        Label titleLabel = new Label("Bike & Car Booking Platform");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
        
        header.getChildren().add(titleLabel);
        return header;
    }
    
    private GridPane createContent() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        
        // Add some sample content
        Label welcomeLabel = new Label("Welcome to Bikes & Cars Booking Platform");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        Button bookButton = new Button("Book Now");
        bookButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        bookButton.setPrefWidth(200);
        
        grid.add(welcomeLabel, 0, 0);
        grid.add(bookButton, 0, 1);
        
        return grid;
    }
    
    private HBox createFooter() {
        HBox footer = new HBox();
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #ecf0f1;");
        
        Label footerLabel = new Label("© 2025 Bike & Car Booking Platform. All rights reserved.");
        footer.getChildren().add(footerLabel);
        
        return footer;
    }
    
    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Bike & Car Booking Platform");
        alert.setContentText("Version 1.0\nA platform for booking bikes and cars.");
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

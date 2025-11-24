package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
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
        BorderPane.setMargin(content, new Insets(20));
        root.setCenter(content);
        
        // Set footer
        root.setBottom(footer);
        
        // Set up the scene
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        
        // Configure the stage
        primaryStage.setTitle("JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        
        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(newItem, openItem, new SeparatorMenuItem(), exitItem);
        
        // Edit menu
        Menu editMenu = new Menu("Edit");
        // Add more menu items as needed
        
        menuBar.getMenus().addAll(fileMenu, editMenu);
        return menuBar;
    }
    
    private VBox createHeader() {
        VBox header = new VBox();
        header.getStyleClass().add("header");
        
        Label title = new Label("Welcome to JavaFX Application");
        title.getStyleClass().add("title");
        
        Label subtitle = new Label("A modern JavaFX layout");
        subtitle.getStyleClass().add("subtitle");
        
        Button actionButton = new Button("Get Started");
        actionButton.getStyleClass().add("action-button");
        
        header.getChildren().addAll(title, subtitle, actionButton);
        header.setSpacing(10);
        header.setPadding(new Insets(20));
        
        return header;
    }
    
    private GridPane createContent() {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(20));
        
        // Create feature cards
        for (int i = 0; i < 3; i++) {
            VBox card = createFeatureCard("Feature " + (i + 1), 
                "Description for feature " + (i + 1));
            grid.add(card, i, 0);
        }
        
        return grid;
    }
    
    private VBox createFeatureCard(String title, String description) {
        VBox card = new VBox();
        card.getStyleClass().add("card");
        card.setSpacing(10);
        card.setPadding(new Insets(15));
        
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("card-title");
        
        Label descLabel = new Label(description);
        descLabel.setWrapText(true);
        
        card.getChildren().addAll(titleLabel, descLabel);
        return card;
    }
    
    private HBox createFooter() {
        HBox footer = new HBox();
        footer.getStyleClass().add("footer");
        footer.setPadding(new Insets(10));
        
        Label copyright = new Label("© 2025 JavaFX Application");
        footer.getChildren().add(copyright);
        
        return footer;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

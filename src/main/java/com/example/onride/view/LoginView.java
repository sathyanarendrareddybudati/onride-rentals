package com.example.onride.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginView extends VBox {
    private TextField emailField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;
    
    public LoginView() {
        initializeUI();
    }
    
    private void initializeUI() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40, 60, 40, 60));
        setStyle("-fx-background-color: #f5f7fa;");

        // Title
        Text title = new Text("Welcome to OnRide");
        title.setFont(Font.font("System", FontWeight.BOLD, 28));
        title.setFill(Color.web("#2c3e50"));

        // Form
        VBox form = new VBox(15);
        form.setAlignment(Pos.CENTER);
        form.setMaxWidth(350);
        form.setStyle("-fx-background-color: white; -fx-padding: 40px; -fx-background-radius: 10px;");

        // Email field
        Label emailLabel = new Label("Email");
        emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setPrefHeight(45);

        // Password field
        Label passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setPrefHeight(45);

        // Login button
        loginButton = new Button("Sign In");
        loginButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        loginButton.setPrefWidth(Double.MAX_VALUE);
        loginButton.setPrefHeight(45);

        // Message label
        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: #e74c3c;");

        // Add components to form
        form.getChildren().addAll(
            emailLabel, emailField,
            new VBox(5), // Spacer
            passwordLabel, passwordField,
            new VBox(20, loginButton, messageLabel)
        );

        // Add all to main container
        getChildren().addAll(title, form);
    }
    
    // Getters for the form fields
    public TextField getEmailField() { return emailField; }
    public PasswordField getPasswordField() { return passwordField; }
    public Button getLoginButton() { return loginButton; }
    public Label getMessageLabel() { return messageLabel; }
}
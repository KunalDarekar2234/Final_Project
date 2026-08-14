package com.visionx.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Sign_Up {

    // Color Palette
    private final String BG_COLOR = "#111415";
    private final String CARD_BG = "rgba(31, 41, 55, 0.65)";
    private final String PRIMARY_GREEN = "#00e676";
    private final String TEXT_LIGHT = "#e1e2e4";
    private final String TEXT_MUTED = "#859585";

    private Scene signUpScene;

    public Scene getSignUpScene(Runnable callRunnable){

        // --- Root & Background ---
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: " + BG_COLOR + ";");

        // Background Glowing Blobs
        Circle topBlob = new Circle(200, Color.web(PRIMARY_GREEN, 0.15));
        topBlob.setEffect(new GaussianBlur(100));
        topBlob.setTranslateX(300);
        topBlob.setTranslateY(-200);

        Circle bottomBlob = new Circle(200, Color.web("#dbe5f8", 0.05));
        bottomBlob.setEffect(new GaussianBlur(100));
        bottomBlob.setTranslateX(-300);
        bottomBlob.setTranslateY(300);

        root.getChildren().addAll(bottomBlob, topBlob);

        // --- Main Layout ---
        BorderPane mainLayout = new BorderPane();
        
        // --- Form Card ---
        AnchorPane card = new AnchorPane();
        card.setPrefWidth(540);
        card.setPrefHeight(800);
        card.setMinWidth(540);
        card.setMinHeight(800);
        card.setMaxWidth(540);
        card.setMaxHeight(800);
        card.setStyle("-fx-background-color: " + CARD_BG + ";" +
                      "-fx-background-radius: 14;" +
                      "-fx-border-color: rgba(255,255,255,0.1);" +
                      "-fx-border-radius: 14;");

        Label cardTitle = new Label("Create Account");
        cardTitle.setFont(Font.font("System", FontWeight.BOLD, 28));
        cardTitle.setTextFill(Color.web(TEXT_LIGHT));
        
        Label cardSubtitle = new Label("Join the future of AI-driven athletic progress.");
        cardSubtitle.setFont(Font.font("System", 14));
        cardSubtitle.setTextFill(Color.web(TEXT_LIGHT, 0.7));
        cardSubtitle.setPadding(new Insets(0, 0, 10, 0));

        // Input Fields (Matching Image: White inputs)
        VBox nameField = createInputField("Full Name", "\uD83D\uDC64", "Enter your name", false);
        VBox emailField = createInputField("Email Address", "\u2709", "email@example.com", false);
        VBox passField = createInputField("Password", "\uD83D\uDD12", "••••••••", true);
        VBox confirmPassField = createInputField("Confirm Password", "\u2714", "••••••••", true);
        VBox roleField = createComboBoxField("Select Role", "\uD83D\uDCBC", "Choose your role", "User", "Trainer", "Gym Owner", "Supplement Store");

        // Terms of Service Checkbox
        CheckBox tosCheck = new CheckBox();
        TextFlow tosText = new TextFlow(
                createText("I agree to the ", TEXT_LIGHT),
                createText("Terms of Service", PRIMARY_GREEN),
                createText(" and\n", TEXT_LIGHT),
                createText("Privacy Policy.", PRIMARY_GREEN)
        );
        tosText.setPrefWidth(350);
        tosCheck.setGraphic(tosText);
        tosCheck.setStyle("-fx-cursor: hand;");

        // Register Button
        Button registerBtn = new Button("Register \u2192");
        registerBtn.setMaxWidth(Double.MAX_VALUE);
        registerBtn.setStyle("-fx-background-color: " + PRIMARY_GREEN + ";" +
                             "-fx-text-fill: #003918;" +
                             "-fx-font-weight: bold;" +
                             "-fx-font-size: 16px;" +
                             "-fx-background-radius: 30;" +
                             "-fx-padding: 12 0;" +
                             "-fx-cursor: hand;");

        registerBtn.setOnAction(e->{
            try {
                String name = ((TextField) ((HBox) nameField.getChildren().get(1)).getChildren().get(1)).getText();
                String email = ((TextField) ((HBox) emailField.getChildren().get(1)).getChildren().get(1)).getText();
                String pass = ((PasswordField) ((HBox) passField.getChildren().get(1)).getChildren().get(1)).getText();
                String confirmPass = ((PasswordField) ((HBox) confirmPassField.getChildren().get(1)).getChildren().get(1)).getText();
                
                @SuppressWarnings("unchecked")
                String role = ((ComboBox<String>) ((HBox) roleField.getChildren().get(1)).getChildren().get(1)).getValue();

                if (!pass.equals(confirmPass)) {
                    System.out.println("Passwords do not match!");
                    return;
                }

                com.visionx.service.AuthController authController = new com.visionx.service.AuthController();
                boolean success = authController.signUp(email, pass, role != null ? role : "User", name);
                
                if (success) {
                    System.out.println("Registration successful. Navigating to login...");
                    callRunnable.run(); 
                } else {
                    System.out.println("Registration failed. Check logs.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // OR Separator
        HBox separatorBox = new HBox(15);
        separatorBox.setAlignment(Pos.CENTER);
        Separator sep1 = new Separator(); HBox.setHgrow(sep1, Priority.ALWAYS);
        Label orLabel = new Label("OR JOIN WITH");
        orLabel.setTextFill(Color.web(TEXT_MUTED));
        orLabel.setFont(Font.font("System", 10));
        Separator sep2 = new Separator(); HBox.setHgrow(sep2, Priority.ALWAYS);
        separatorBox.getChildren().addAll(sep1, orLabel, sep2);

        // Social Buttons
        HBox socialBox = new HBox(15);
        Button btnGoogle = createSocialButton("G  Google");
        Button btnApple = createSocialButton("  Apple");
        socialBox.getChildren().addAll(btnGoogle, btnApple);

        // Login Link
        TextFlow loginLink = new TextFlow(
                createText("Already have an account? ", TEXT_LIGHT),
                createText("Login", PRIMARY_GREEN, true)
        );
        loginLink.setTextAlignment(TextAlignment.CENTER);
        HBox loginBox = new HBox(loginLink);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(10, 0, 0, 0));

        // Assemble Card
        card.getChildren().addAll(
                cardTitle, cardSubtitle, nameField, emailField, passField,
                confirmPassField, roleField, tosCheck, registerBtn, separatorBox,
                socialBox, loginBox
        );

        AnchorPane.setTopAnchor(cardTitle, 48.0);
        AnchorPane.setLeftAnchor(cardTitle, 48.0);
        AnchorPane.setTopAnchor(cardSubtitle, 88.0);
        AnchorPane.setLeftAnchor(cardSubtitle, 48.0);

        positionFormRow(nameField, 138.0);
        positionFormRow(emailField, 218.0);
        positionFormRow(passField, 298.0);
        positionFormRow(confirmPassField, 378.0);
        positionFormRow(roleField, 458.0);

        AnchorPane.setTopAnchor(tosCheck, 545.0);
        AnchorPane.setLeftAnchor(tosCheck, 48.0);
        AnchorPane.setTopAnchor(registerBtn, 600.0);
        AnchorPane.setLeftAnchor(registerBtn, 48.0);
        AnchorPane.setRightAnchor(registerBtn, 48.0);
        AnchorPane.setTopAnchor(separatorBox, 670.0);
        AnchorPane.setLeftAnchor(separatorBox, 48.0);
        AnchorPane.setRightAnchor(separatorBox, 48.0);
        AnchorPane.setTopAnchor(socialBox, 700.0);
        AnchorPane.setLeftAnchor(socialBox, 48.0);
        AnchorPane.setRightAnchor(socialBox, 48.0);
        AnchorPane.setTopAnchor(loginBox, 762.0);
        AnchorPane.setLeftAnchor(loginBox, 48.0);
        AnchorPane.setRightAnchor(loginBox, 48.0);

        // --- Main Container Assembly ---
        StackPane formArea = new StackPane(card);
        formArea.setAlignment(Pos.CENTER);
        formArea.setPadding(new Insets(30, 0, 30, 0));
        mainLayout.setCenter(formArea);

        // --- Footer Section ---
        HBox footer = new HBox();
        footer.setStyle("-fx-background-color: #0c0f10; -fx-padding: 28 50;");
        footer.setAlignment(Pos.CENTER);
        
        Label footerLogo = new Label("FitVerse");
        footerLogo.setFont(Font.font("System", FontWeight.BOLD, 20));
        footerLogo.setTextFill(Color.web(PRIMARY_GREEN));

        HBox footerLinks = new HBox(20);
        footerLinks.setAlignment(Pos.CENTER);
        footerLinks.getChildren().addAll(
                createFooterLink("Privacy Policy"),
                createFooterLink("Terms of Service"),
                createFooterLink("Contact"),
                createFooterLink("About")
        );
        
        Label copyright = new Label("© 2024 FitVerse AI. All rights reserved.");
        copyright.setTextFill(Color.web(TEXT_MUTED));

        Region spacer1 = new Region(); HBox.setHgrow(spacer1, Priority.ALWAYS);
        Region spacer2 = new Region(); HBox.setHgrow(spacer2, Priority.ALWAYS);

        footer.getChildren().addAll(footerLogo, spacer1, footerLinks, spacer2, copyright);
        mainLayout.setBottom(footer);

        root.getChildren().add(mainLayout);

        // --- Scene & Stage ---
        signUpScene = new Scene(root,LoginPage.primaryStage.getWidth(),LoginPage.primaryStage.getHeight());
        LoginPage.primaryStage.setMaximized(true);
        
        // Suppress default focus highlight outline on fields
        signUpScene.getStylesheets().add("data:text/css," +
                ".text-field:focused, .password-field:focused { -fx-background-color: transparent; }");

        // primaryStage.setTitle("FitVerse AI - Register");
        // primaryStage.setScene(scene);
        // primaryStage.show();

        return signUpScene;
    }

    // --- Helper Methods ---

    private void positionFormRow(VBox field, double top) {
        AnchorPane.setTopAnchor(field, top);
        AnchorPane.setLeftAnchor(field, 48.0);
        AnchorPane.setRightAnchor(field, 48.0);
    }

    private VBox createComboBoxField(String labelText, String iconUnicode, String prompt, String... options) {
        VBox container = new VBox(8);
        container.setMaxHeight(Region.USE_PREF_SIZE);
        
        Label label = new Label(labelText);
        label.setTextFill(Color.web(PRIMARY_GREEN));
        label.setFont(Font.font("System", FontWeight.BOLD, 12));

        HBox inputWrapper = new HBox(10);
        inputWrapper.setAlignment(Pos.CENTER_LEFT);
        inputWrapper.setMinHeight(50);
        inputWrapper.setStyle("-fx-background-color: white; -fx-background-radius: 4; -fx-padding: 8 12;");

        Label icon = new Label(iconUnicode);
        icon.setTextFill(Color.web("#a0a0a0"));
        icon.setFont(Font.font("System", 16));

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(options);
        comboBox.setPromptText(prompt);
        comboBox.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-family: System; -fx-font-size: 14px;");
        comboBox.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(comboBox, Priority.ALWAYS);

        inputWrapper.getChildren().addAll(icon, comboBox);
        container.getChildren().addAll(label, inputWrapper);
        
        return container;
    }

    private VBox createInputField(String labelText, String iconUnicode, String prompt, boolean isPassword) {
        VBox container = new VBox(8);
        container.setMaxHeight(Region.USE_PREF_SIZE);
        
        Label label = new Label(labelText);
        label.setTextFill(Color.web(PRIMARY_GREEN));
        label.setFont(Font.font("System", FontWeight.BOLD, 12));

        HBox inputWrapper = new HBox(10);
        inputWrapper.setAlignment(Pos.CENTER_LEFT);
        inputWrapper.setMinHeight(50);
        inputWrapper.setStyle("-fx-background-color: white; -fx-background-radius: 4; -fx-padding: 8 12;");

        Label icon = new Label(iconUnicode);
        icon.setTextFill(Color.web("#a0a0a0"));
        icon.setFont(Font.font("System", 16));

        TextField field = isPassword ? new PasswordField() : new TextField();
        field.setPromptText(prompt);
        field.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-prompt-text-fill: #b0b0b0;");
        HBox.setHgrow(field, Priority.ALWAYS);

        inputWrapper.getChildren().addAll(icon, field);
        container.getChildren().addAll(label, inputWrapper);
        
        return container;
    }

    private Button createSocialButton(String text) {
        Button btn = new Button(text);
        HBox.setHgrow(btn, Priority.ALWAYS);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setStyle("-fx-background-color: transparent;" +
                     "-fx-border-color: rgba(255,255,255,0.1);" +
                     "-fx-border-radius: 30;" +
                     "-fx-text-fill: white;" +
                     "-fx-padding: 10 0;" +
                     "-fx-cursor: hand;");
        return btn;
    }

    private Text createText(String content, String colorHex) {
        return createText(content, colorHex, false);
    }

    private Text createText(String content, String colorHex, boolean bold) {
        Text text = new Text(content);
        text.setFill(Color.web(colorHex));
        text.setFont(Font.font("System", bold ? FontWeight.BOLD : FontWeight.NORMAL, 13));
        if (bold) {
            text.setFont(Font.font("System", FontWeight.BOLD, 13));
        }
        return text;
    }

    private Label createFooterLink(String text) {
        Label link = new Label(text);
        link.setTextFill(Color.web(TEXT_MUTED));
        link.setFont(Font.font("System", FontWeight.BOLD, 12));
        link.setStyle("-fx-cursor: hand;");
        link.setOnMouseEntered(e -> link.setTextFill(Color.web(PRIMARY_GREEN)));
        link.setOnMouseExited(e -> link.setTextFill(Color.web(TEXT_MUTED)));
        return link;
    }


        // signUpScene = new Scene(root, 1200, 800);
        // return signUpScene;
}

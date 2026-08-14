package com.visionx.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class LoginPage  {

    public static Stage primaryStage;

    private Scene loginScene;   
    // =========================================================
    // COLORS
    // =========================================================
    private static final String BG_COLOR = "#0F1115";        // Main Background
    private static final String CARD_COLOR = "#1C2128";      // Login Card Background
    private static final String ACCENT_GREEN = "#00E676";    // Main Brand Color
    private static final String TEXT_PRIMARY = "#FFFFFF";    // White Text
    private static final String TEXT_SECONDARY = "#8B949E";  // Gray Text
    private static final String INPUT_BG = "#15191E";        // Input Field Background
    private static final String INPUT_BORDER = "#30363D";    // Input Field Border

    public Scene getLoginScene(Runnable onBack) {

                // this.primaryStage = stage;

        // =====================================================
        // ROOT LAYOUT
        // =====================================================
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: " + BG_COLOR + ";");
        root.setPadding(new Insets(50));

        VBox mainContainer = new VBox(40);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setMaxWidth(450);

        // =====================================================
        // LOGO AREA
        // =====================================================
        VBox logoArea = new VBox(5);
        logoArea.setAlignment(Pos.CENTER);

        Text fitText = new Text("Fit");
        fitText.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        fitText.setFill(Color.web(TEXT_PRIMARY));

        Text verseText = new Text("Verse");
        verseText.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        verseText.setFill(Color.web(ACCENT_GREEN));

        TextFlow brandName = new TextFlow(fitText, verseText);
        brandName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Label subtitle = new Label("AI POWERED PERFORMANCE");
        subtitle.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        subtitle.setTextFill(Color.web(TEXT_SECONDARY));
        subtitle.setStyle("-fx-letter-spacing: 2px;");

        logoArea.getChildren().addAll(brandName, subtitle);

        // =====================================================
        // LOGIN CARD
        // =====================================================
        VBox loginCard = new VBox(25);
        loginCard.setPadding(new Insets(40));
        loginCard.setStyle(
                "-fx-background-color: " + CARD_COLOR + ";" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: #2D333B;" +
                "-fx-border-radius: 12;"
        );

        // Header Texts
        VBox headerBox = new VBox(8);
        Label welcomeLabel = new Label("Welcome Back");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.web(TEXT_PRIMARY));

        Label descLabel = new Label("Enter your credentials to continue your journey.");
        descLabel.setFont(Font.font("Arial", 14));
        descLabel.setTextFill(Color.web(TEXT_SECONDARY));
        
        headerBox.getChildren().addAll(welcomeLabel, descLabel);

        // Email Field
        VBox emailBox = createInputField("Email Address", "✉", "alex@performance.com", false);

        // Password Field
        VBox passwordBox = createPasswordFieldBox();

        // Role Field
        VBox roleBox = createComboBoxField("Select Role", "\uD83D\uDCBC", "Choose your role", "User", "Trainer", "Gym Owner", "Supplement Store");

        // Remember Me
        HBox rememberBox = new HBox(10);
        rememberBox.setAlignment(Pos.CENTER_LEFT);
        CheckBox rememberCheck = new CheckBox("Remember this device");
        rememberCheck.setTextFill(Color.web(TEXT_SECONDARY));
        rememberCheck.setFont(Font.font("Arial", 13));
        rememberCheck.setStyle("-fx-mark-color: " + ACCENT_GREEN + "; -fx-box-border: " + TEXT_SECONDARY + ";");
        rememberBox.getChildren().add(rememberCheck);

        // Login Button
        Button loginBtn = new Button("Login");
        loginBtn.setMaxWidth(Double.MAX_VALUE);
        loginBtn.setPrefHeight(50);
        loginBtn.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        loginBtn.setStyle(
                "-fx-background-color: " + ACCENT_GREEN + ";" +
                "-fx-text-fill: #000000;" +
                "-fx-background-radius: 25;" +
                "-fx-cursor: hand;"
        );


        
        loginBtn.setOnAction(e -> {
            try {
                String email = ((TextField) ((HBox) emailBox.getChildren().get(1)).getChildren().get(1)).getText();
                String pass = ((PasswordField) ((HBox) passwordBox.getChildren().get(1)).getChildren().get(1)).getText();
                
                @SuppressWarnings("unchecked")
                String role = ((ComboBox<String>) ((HBox) roleBox.getChildren().get(1)).getChildren().get(1)).getValue();
                String selectedRole = role != null ? role : "User";
                
                com.visionx.service.AuthController authController = new com.visionx.service.AuthController();
                boolean success = authController.signIn(email, pass, selectedRole);
                if (success) {
                    System.out.println("Login Successful! You can now transition to the Dashboard.");
                    if ("User".equals(selectedRole)) {
                        com.visionx.view.user_login.AthleteDashboardUI dashboard = new com.visionx.view.user_login.AthleteDashboardUI();
                        com.visionx.view.user_login.AthleteDashboardUI.primaryStage = primaryStage;
                        Runnable callRunnable = new Runnable() {
                            @Override
                            public void run() {
                                primaryStage.setScene(loginScene);
                            }
                        };
                        primaryStage.setScene(dashboard.getAthleteDashboardScene(callRunnable));
                    }
                    else if("Supplement Store".equals(selectedRole)){
                        com.visionx.view.suppliment_login.Dashboard dashboard = new com.visionx.view.suppliment_login.Dashboard();
                        com.visionx.view.suppliment_login.Dashboard.primaryStage = primaryStage;
                        Runnable callRunnable = new Runnable() {
                            @Override
                            public void run() {
                                primaryStage.setScene(loginScene);
                            }
                        };
                        primaryStage.setScene(dashboard.getSupplimentDashboardScene(callRunnable));
                    }
                } else {
                    System.out.println("Login failed. Check console logs.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Divider (OR CONTINUE WITH)
        HBox divider = createDivider("OR CONTINUE WITH");

        // Google Button
        Button googleBtn = createGoogleButton();

        // Footer
        HBox footerBox = new HBox(5);
        footerBox.setAlignment(Pos.CENTER);
        footerBox.setPadding(new Insets(10, 0, 0, 0));
        
        Label noAccount = new Label("Don't have an account?");
        noAccount.setTextFill(Color.web(TEXT_SECONDARY));
        noAccount.setFont(Font.font("Arial", 13));

        Label signUpLabel = new Label("Sign Up Now");
        signUpLabel.setTextFill(Color.web(ACCENT_GREEN));
        signUpLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        signUpLabel.setStyle("-fx-cursor: hand;");
        signUpLabel.setOnMouseClicked(e -> {
            Sign_Up sign_Up = new Sign_Up();
            Runnable callRunnable = new Runnable() {
                @Override
                public void run() {
                    primaryStage.setScene(loginScene);
                }
            };
            primaryStage.setScene(sign_Up.getSignUpScene(callRunnable));
        });

        footerBox.getChildren().addAll(noAccount, signUpLabel);

        // Add all to Card
        loginCard.getChildren().addAll(
                headerBox,
                emailBox,
                passwordBox,
                roleBox,
                rememberBox,
                loginBtn,
                divider,
                googleBtn,
                footerBox
        );

        mainContainer.getChildren().addAll(logoArea, loginCard);
        root.getChildren().add(mainContainer);

        // =====================================================
        // SCENE SETUP
        // =====================================================
        loginScene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setMaximized(true);
        return loginScene;
    }

    // =========================================================
    // HELPER METHODS
    // =========================================================
    
    private VBox createComboBoxField(String labelText, String icon, String placeholder, String... options) {
        VBox box = new VBox(8);
        
        Label label = new Label(labelText);
        label.setTextFill(Color.web(TEXT_PRIMARY));
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        HBox inputBox = new HBox(12);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setPadding(new Insets(0, 15, 0, 15));
        inputBox.setPrefHeight(45);
        inputBox.setStyle(
                "-fx-background-color: " + INPUT_BG + ";" +
                "-fx-border-color: " + INPUT_BORDER + ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;"
        );

        Label iconLabel = new Label(icon);
        iconLabel.setTextFill(Color.web(TEXT_SECONDARY));
        iconLabel.setFont(Font.font("Arial", 16));

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(options);
        comboBox.setPromptText(placeholder);
        comboBox.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-size: 14px;");
        comboBox.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(comboBox, Priority.ALWAYS);

        inputBox.getChildren().addAll(iconLabel, comboBox);
        box.getChildren().addAll(label, inputBox);
        
        return box;
    }
    private VBox createInputField(String labelText, String icon, String placeholder, boolean isPassword) {
        VBox box = new VBox(8);
        
        Label label = new Label(labelText);
        label.setTextFill(Color.web(TEXT_PRIMARY));
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        HBox inputBox = new HBox(12);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setPadding(new Insets(0, 15, 0, 15));
        inputBox.setPrefHeight(45);
        inputBox.setStyle(
                "-fx-background-color: " + INPUT_BG + ";" +
                "-fx-border-color: " + INPUT_BORDER + ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;"
        );

        Label iconLabel = new Label(icon);
        iconLabel.setTextFill(Color.web(TEXT_SECONDARY));
        iconLabel.setFont(Font.font("Arial", 16));

        TextField field = new TextField();
        field.setPromptText(placeholder);
        field.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-prompt-text-fill: #5C636A;");
        field.setFont(Font.font("Arial", 14));
        HBox.setHgrow(field, Priority.ALWAYS);

        inputBox.getChildren().addAll(iconLabel, field);
        box.getChildren().addAll(label, inputBox);
        
        return box;
    }

    private VBox createPasswordFieldBox() {
        VBox box = new VBox(8);
        
        // Label Row with "Forgot Password"
        HBox labelRow = new HBox();
        Label label = new Label("Password");
        label.setTextFill(Color.web(TEXT_PRIMARY));
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label forgotLabel = new Label("Forgot Password?");
        forgotLabel.setTextFill(Color.web(ACCENT_GREEN));
        forgotLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        forgotLabel.setStyle("-fx-cursor: hand;");

        labelRow.getChildren().addAll(label, spacer, forgotLabel);

        // Input Row
        HBox inputBox = new HBox(12);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setPadding(new Insets(0, 15, 0, 15));
        inputBox.setPrefHeight(45);
        inputBox.setStyle(
                "-fx-background-color: " + INPUT_BG + ";" +
                "-fx-border-color: " + INPUT_BORDER + ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;"
        );

        Label iconLabel = new Label("🔒"); // Lock icon
        iconLabel.setTextFill(Color.web(TEXT_SECONDARY));
        iconLabel.setFont(Font.font("Arial", 16));

        PasswordField field = new PasswordField();
        field.setPromptText("........");
        field.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-prompt-text-fill: #5C636A;");
        field.setFont(Font.font("Arial", 14));
        HBox.setHgrow(field, Priority.ALWAYS);

        Label eyeIcon = new Label("👁"); // Eye icon
        eyeIcon.setTextFill(Color.web(TEXT_SECONDARY));
        eyeIcon.setFont(Font.font("Arial", 16));
        eyeIcon.setStyle("-fx-cursor: hand;");

        inputBox.getChildren().addAll(iconLabel, field, eyeIcon);
        box.getChildren().addAll(labelRow, inputBox);
        
        return box;
    }

    private HBox createDivider(String text) {
        HBox dividerBox = new HBox(15);
        dividerBox.setAlignment(Pos.CENTER);

        Line line1 = new Line(0, 0, 100, 0);
        line1.setStroke(Color.web(INPUT_BORDER));

        Label divLabel = new Label(text);
        divLabel.setTextFill(Color.web(TEXT_SECONDARY));
        divLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Line line2 = new Line(0, 0, 100, 0);
        line2.setStroke(Color.web(INPUT_BORDER));

        dividerBox.getChildren().addAll(line1, divLabel, line2);
        return dividerBox;
    }

    private Button createGoogleButton() {
        Button btn = new Button("   Google Account");
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPrefHeight(45);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        btn.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: " + INPUT_BORDER + ";" +
                "-fx-border-radius: 25;" +
                "-fx-text-fill: " + TEXT_PRIMARY + ";" +
                "-fx-cursor: hand;"
        );
        
        // Simple text-based Google icon simulation
        Label gIcon = new Label("G");
        gIcon.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gIcon.setTextFill(Color.web("#4285F4")); // Google Blue
        
        btn.setGraphic(gIcon);
        return btn;
    }


        
}
    
    
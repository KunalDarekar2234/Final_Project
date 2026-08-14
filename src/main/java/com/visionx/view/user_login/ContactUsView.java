package com.visionx.view.user_login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContactUsView extends Application {

    private Scene contactScene;

    public Scene getContactUsScene(Runnable callBackAction) {

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #111415;");

        // ==========================================
        // 1. TOP NAVIGATION BAR
        // ==========================================
        HBox topNav = new HBox();
        topNav.setStyle("-fx-background-color: rgba(17, 20, 21, 0.95); -fx-padding: 20px 50px; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 0 0 1px 0;");
        topNav.setAlignment(Pos.CENTER_LEFT);

        Text logoTxt = new Text("FitVerse");
        logoTxt.setStyle("-fx-font-size:24px; -fx-font-weight:bold; -fx-fill: #62ff96;");
        
        HBox navLinks = new HBox(35);
        navLinks.setAlignment(Pos.CENTER);
        navLinks.getChildren().addAll(
            createTopNavLink("Dashboard", false),
            createTopNavLink("Workouts", false),
            createTopNavLink("Diet", false),
            createTopNavLink("Marketplace", true) // Highlighted as per image context or preference
        );

        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        HBox rightIcons = new HBox(20);
        rightIcons.setAlignment(Pos.CENTER_RIGHT);
        Button notifBtn = new Button("🔔");
        notifBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");
        Button settingsBtn = new Button("⚙");
        settingsBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");
        Circle avatar = new Circle(16, Color.web("#2a2d31"));
        avatar.setStroke(Color.web("rgba(98,255,150,0.4)"));
        rightIcons.getChildren().addAll(notifBtn, settingsBtn, avatar);

        topNav.getChildren().addAll(logoTxt, leftSpacer, navLinks, rightSpacer, rightIcons);
        borderPane.setTop(topNav);

        // ==========================================
        // 2. MAIN CONTENT AREA
        // ==========================================
        VBox mainContent = new VBox(50);
        mainContent.setStyle("-fx-padding: 50px 80px; -fx-background-color: #111415;");
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setMaxWidth(1200);

        // --- Split Section: Info (Left) & Form (Right) ---
        HBox splitSection = new HBox(60);
        splitSection.setAlignment(Pos.TOP_CENTER);

        // A. Left Column (Contact Info)
        VBox leftCol = new VBox(25);
        leftCol.setPrefWidth(450);

        VBox titleBox = new VBox(15);
        Text title = new Text("Get in Touch");
        title.setStyle("-fx-font-size:42px; -fx-font-weight:bold; -fx-fill: #62ff96;");
        Text subtitle = new Text("Have questions about our AI coaching? Our team\nof engineers and athletes are here to help you\nreach your peak performance.");
        subtitle.setStyle("-fx-font-size:15px; -fx-fill: #8a8d91; -fx-line-spacing: 5px;");
        titleBox.getChildren().addAll(title, subtitle);

        VBox emailCard = createInfoCard("✉", "EMAIL US", "support@fitverse.ai", "");
        VBox hqCard = createInfoCard("📍", "HQ LOCATION", "Silicon Valley, CA", "442 Meta Way, Innovation District");

        HBox socials = new HBox(15);
        socials.getChildren().addAll(
            createSocialBtn("🔗"),
            createSocialBtn("💬"),
            createSocialBtn("📹")
        );

        leftCol.getChildren().addAll(titleBox, emailCard, hqCard, socials);

        // B. Right Column (Form Card)
        VBox rightCol = new VBox(30);
        HBox.setHgrow(rightCol, Priority.ALWAYS);
        rightCol.setStyle("-fx-background-color: #1a1e22; -fx-padding: 40px; -fx-background-radius: 16px; -fx-border-color: rgba(98,255,150,0.1); -fx-border-radius: 16px;");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(30);
        formGrid.setVgap(25);

        VBox nameBox = createInputGroup("FULL NAME", "John Doe", false);
        VBox emailBox = createInputGroup("EMAIL ADDRESS", "john@example.com", false);
        GridPane.setHgrow(nameBox, Priority.ALWAYS);
        GridPane.setHgrow(emailBox, Priority.ALWAYS);
        formGrid.add(nameBox, 0, 0);
        formGrid.add(emailBox, 1, 0);

        VBox subjectBox = new VBox(8);
        Text subjLbl = new Text("SUBJECT");
        subjLbl.setStyle("-fx-fill: #ffffff; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        ComboBox<String> subjCombo = new ComboBox<>();
        subjCombo.getItems().addAll("Technical Support", "Billing", "Partnership", "General");
        subjCombo.getSelectionModel().selectFirst();
        subjCombo.setMaxWidth(Double.MAX_VALUE);
        subjCombo.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #2a2d31 transparent; -fx-border-width: 0 0 1px 0; -fx-text-fill: #8a8d91; -fx-padding: 5px 0; -fx-font-size: 14px;");
        subjectBox.getChildren().addAll(subjLbl, subjCombo);

        VBox msgBox = new VBox(8);
        Text msgLbl = new Text("MESSAGE");
        msgLbl.setStyle("-fx-fill: #ffffff; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        TextArea msgArea = new TextArea();
        msgArea.setPromptText("How can we help you achieve your goals?");
        msgArea.setPrefRowCount(4);
        msgArea.setStyle("-fx-control-inner-background: #1a1e22; -fx-background-color: transparent; -fx-border-color: transparent transparent #2a2d31 transparent; -fx-border-width: 0 0 1px 0; -fx-text-fill: #ffffff; -fx-prompt-text-fill: #8a8d91; -fx-font-size: 14px;");
        msgBox.getChildren().addAll(msgLbl, msgArea);

        Button submitBtn = new Button("Send Transmission ➢");
        submitBtn.setStyle("-fx-background-color: #00e676; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 30px; -fx-padding: 15px;");
        submitBtn.setMaxWidth(Double.MAX_VALUE);
        
        // Navigation Hook Example
        submitBtn.setOnAction(e -> {
            System.out.println("Message Sent!");
            callBackAction.run(); 
        });

        rightCol.getChildren().addAll(formGrid, subjectBox, msgBox, submitBtn);

        splitSection.getChildren().addAll(leftCol, rightCol);

        // --- Map Section ---
        StackPane mapSection = new StackPane();
        mapSection.setPrefHeight(250);
        mapSection.setStyle("-fx-background-color: #0c0e0f; -fx-border-color: #2a2d31; -fx-border-radius: 16px; -fx-background-radius: 16px;");
        
        // Map Marker
        VBox markerBox = new VBox(10);
        markerBox.setAlignment(Pos.CENTER);
        Circle pinBg = new Circle(20, Color.web("#00e676"));
        Text pinIcon = new Text("📍");
        pinIcon.setStyle("-fx-fill: #000000; -fx-font-size: 16px;");
        StackPane pin = new StackPane(pinBg, pinIcon);
        
        Text badge = new Text("FITVERSE GLOBAL HQ");
        badge.setStyle("-fx-fill: #62ff96; -fx-font-size: 10px; -fx-font-weight: bold;");
        StackPane badgePane = new StackPane(badge);
        badgePane.setStyle("-fx-background-color: #1a1e22; -fx-padding: 8px 15px; -fx-border-color: rgba(98,255,150,0.3); -fx-border-radius: 20px; -fx-background-radius: 20px;");
        
        markerBox.getChildren().addAll(pin, badgePane);
        mapSection.getChildren().add(markerBox);

        mainContent.getChildren().addAll(splitSection, mapSection);

        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setStyle("-fx-background: #111415; -fx-border-color: transparent;");
        scrollPane.setFitToWidth(true);
        borderPane.setCenter(scrollPane);

        // ==========================================
        // 3. FOOTER
        // ==========================================
        HBox footer = new HBox();
        footer.setStyle("-fx-padding: 30px 50px; -fx-background-color: #0c0e0f; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 1px 0 0 0;");
        footer.setAlignment(Pos.CENTER_LEFT);
        
        VBox fLogoBox = new VBox(5);
        Text fLogo = new Text("FitVerse");
        fLogo.setStyle("-fx-fill: #62ff96; -fx-font-size: 18px; -fx-font-weight:bold;");
        Text fCopy = new Text("© 2024 FitVerse AI. All rights reserved.");
        fCopy.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px;");
        fLogoBox.getChildren().addAll(fLogo, fCopy);
        
        Region fSpacer = new Region();
        HBox.setHgrow(fSpacer, Priority.ALWAYS);
        
        HBox fLinks = new HBox(30);
        fLinks.setAlignment(Pos.CENTER);
        String[] links = {"Privacy Policy", "Terms of Service", "Contact", "About"};
        for(String l : links) {
            Text t = new Text(l);
            t.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
            fLinks.getChildren().add(t);
        }

        Region fSpacer2 = new Region();
        HBox.setHgrow(fSpacer2, Priority.ALWAYS);

        Button langBtn = new Button("🌐");
        langBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-border-color: #2a2d31; -fx-border-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px;");

        footer.getChildren().addAll(fLogoBox, fSpacer, fLinks, fSpacer2, langBtn);
        borderPane.setBottom(footer);

        contactScene = new Scene(borderPane, 1300, 900);
        return contactScene;
    }

    // --- Helper Methods ---

    private Text createTopNavLink(String text, boolean isActive) {
        Text link = new Text(text);
        if (isActive) {
            link.setStyle("-fx-fill: #ffffff; -fx-font-size: 14px; -fx-font-weight: bold;");
        } else {
            link.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        }
        return link;
    }

    private VBox createInfoCard(String iconStr, String label, String value, String subValue) {
        VBox card = new VBox();
        card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 20px; -fx-background-radius: 12px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");
        
        HBox content = new HBox(20);
        content.setAlignment(Pos.CENTER_LEFT);
        
        StackPane iconBg = new StackPane();
        Rectangle bgRect = new Rectangle(45, 45, Color.web("rgba(98,255,150,0.1)"));
        bgRect.setArcWidth(10); bgRect.setArcHeight(10);
        Text icon = new Text(iconStr);
        icon.setStyle("-fx-fill: #62ff96; -fx-font-size: 20px;");
        iconBg.getChildren().addAll(bgRect, icon);

        VBox texts = new VBox(3);
        Text lbl = new Text(label);
        lbl.setStyle("-fx-fill: #62ff96; -fx-font-size: 10px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        Text val = new Text(value);
        val.setStyle("-fx-fill: #ffffff; -fx-font-size: 18px; -fx-font-weight: bold;");
        texts.getChildren().addAll(lbl, val);
        
        if (!subValue.isEmpty()) {
            Text sub = new Text(subValue);
            sub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
            texts.getChildren().add(sub);
        }

        content.getChildren().addAll(iconBg, texts);
        card.getChildren().add(content);
        return card;
    }

    private Button createSocialBtn(String iconStr) {
        Button btn = new Button(iconStr);
        btn.setStyle("-fx-background-color: #1a1e22; -fx-text-fill: #8a8d91; -fx-border-color: #2a2d31; -fx-border-radius: 50%; -fx-background-radius: 50%; -fx-min-width: 50px; -fx-min-height: 50px; -fx-font-size: 16px;");
        return btn;
    }

    private VBox createInputGroup(String label, String placeholder, boolean isTextArea) {
        VBox box = new VBox(8);
        Text lbl = new Text(label);
        lbl.setStyle("-fx-fill: #ffffff; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        
        if (isTextArea) {
            TextArea area = new TextArea();
            area.setPromptText(placeholder);
            area.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #2a2d31 transparent; -fx-text-fill: #ffffff; -fx-prompt-text-fill: #8a8d91; -fx-font-size: 14px;");
            box.getChildren().addAll(lbl, area);
        } else {
            TextField field = new TextField();
            field.setPromptText(placeholder);
            field.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #2a2d31 transparent; -fx-border-width: 0 0 1px 0; -fx-text-fill: #ffffff; -fx-prompt-text-fill: #8a8d91; -fx-padding: 10px 0; -fx-font-size: 14px;");
            box.getChildren().addAll(lbl, field);
        }
        
        return box;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Runnable dummyCallback = () -> {
            System.out.println("Processing Callback Action...");
        };
        
        stage.setScene(getContactUsScene(dummyCallback));
        stage.setTitle("FitVerse AI - Contact Us");
        stage.show();
    }
}
package com.visionx.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PageNotFoundView extends Application {

    private Scene notFoundScene;

    public Scene getPageNotFoundScene(Runnable callBackAction) {

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
            createTopNavLink("Dashboard"),
            createTopNavLink("Workouts"),
            createTopNavLink("Diet"),
            createTopNavLink("Marketplace")
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
        StackPane centerPane = new StackPane();
        centerPane.setStyle("-fx-background-color: #111415;");

        // Decorative background elements (floating cards/glows)
        Rectangle decoCard = new Rectangle(180, 180, Color.web("rgba(255,255,255,0.02)"));
        decoCard.setArcWidth(25); 
        decoCard.setArcHeight(25);
        decoCard.setRotate(-15);
        StackPane.setAlignment(decoCard, Pos.CENTER_LEFT);
        StackPane.setMargin(decoCard, new Insets(0, 0, 100, 100));

        Circle decoGlow = new Circle(150, Color.web("rgba(255,255,255,0.01)"));
        StackPane.setAlignment(decoGlow, Pos.CENTER_RIGHT);
        StackPane.setMargin(decoGlow, new Insets(150, 50, 0, 0));

        // 404 Content
        VBox contentBox = new VBox(25);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setMaxWidth(600);

        Text errorTitle = new Text("404");
        errorTitle.setStyle("-fx-fill: #62ff96; -fx-font-size: 120px; -fx-font-weight: bold;");

        Text errorSub = new Text("PAGE NOT FOUND");
        errorSub.setStyle("-fx-fill: #ffffff; -fx-font-size: 24px; -fx-font-weight: bold; -fx-letter-spacing: 2px;");

        Label errorDesc = new Label("The dimension you are looking for has shifted. Your\nfitness metrics are safe, but this specific path has\nencountered a system anomaly.");
        errorDesc.setStyle("-fx-text-fill: #e1e2e4; -fx-font-size: 16px; -fx-line-spacing: 6px;");
        errorDesc.setTextAlignment(TextAlignment.CENTER);
        errorDesc.setAlignment(Pos.CENTER);

        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 0, 0));

        Button goHomeBtn = new Button("⌂ Go Home");
        goHomeBtn.setStyle("-fx-background-color: #00e676; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 30px; -fx-padding: 15px 35px;");
        goHomeBtn.setOnAction(e -> {
            System.out.println("Returning to Home...");
            callBackAction.run();
        });

        Button prevBtn = new Button("← Previous Session");
        prevBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-color: rgba(255,255,255,0.2); -fx-border-radius: 30px; -fx-padding: 14px 35px;");

        buttonBox.getChildren().addAll(goHomeBtn, prevBtn);
        contentBox.getChildren().addAll(errorTitle, errorSub, errorDesc, buttonBox);

        centerPane.getChildren().addAll(decoCard, decoGlow, contentBox);
        borderPane.setCenter(centerPane);

        // ==========================================
        // 3. FOOTER
        // ==========================================
        HBox footer = new HBox();
        footer.setStyle("-fx-padding: 30px 50px; -fx-background-color: #0c0e0f; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 1px 0 0 0;");
        footer.setAlignment(Pos.CENTER_LEFT);
        
        VBox fLogoBox = new VBox(5);
        Text fLogo = new Text("FitVerse AI");
        fLogo.setStyle("-fx-fill: #62ff96; -fx-font-size: 18px; -fx-font-weight:bold;");
        Text fCopy = new Text("© 2024 FitVerse AI. All rights reserved.");
        fCopy.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        fLogoBox.getChildren().addAll(fLogo, fCopy);
        
        Region fSpacer1 = new Region();
        HBox.setHgrow(fSpacer1, Priority.ALWAYS);
        
        HBox fLinks = new HBox(30);
        fLinks.setAlignment(Pos.CENTER);
        String[] links = {"Privacy Policy", "Terms of Service", "Contact", "About"};
        for(String l : links) {
            Text t = new Text(l);
            t.setStyle("-fx-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold;");
            fLinks.getChildren().add(t);
        }

        Region fSpacer2 = new Region();
        HBox.setHgrow(fSpacer2, Priority.ALWAYS);

        Button langBtn = new Button("🌐");
        langBtn.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-text-fill: #8a8d91; -fx-background-radius: 50%; -fx-min-width: 45px; -fx-min-height: 45px;");
        Button shareBtn = new Button("🔗");
        shareBtn.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-text-fill: #8a8d91; -fx-background-radius: 50%; -fx-min-width: 45px; -fx-min-height: 45px;");
        HBox fIcons = new HBox(15, langBtn, shareBtn);

        footer.getChildren().addAll(fLogoBox, fSpacer1, fLinks, fSpacer2, fIcons);
        borderPane.setBottom(footer);

        notFoundScene = new Scene(borderPane, 1300, 900);
        return notFoundScene;
    }

    // --- Helper Methods ---

    private Text createTopNavLink(String text) {
        Text link = new Text(text);
        link.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        return link;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Runnable navCallback = () -> {
            System.out.println("Navigating to Dashboard...");
        };
        
        stage.setScene(getPageNotFoundScene(navCallback));
        stage.setTitle("FitVerse AI - 404 Page Not Found");
        stage.show();
    }
}
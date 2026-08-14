package com.visionx.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WeeklyPlannerUI extends Application {

    private Scene plannerScene;

    public Scene getPlannerScene(Runnable callBackAction) {

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color : #111415;");

        // ==========================================
        // 1. LEFT SIDEBAR
        // ==========================================
        VBox sidebar = new VBox(25);
        sidebar.setPrefWidth(250);
        sidebar.setStyle("-fx-background-color : #15181a; -fx-padding: 30px 20px 20px 20px; -fx-border-color: #2a2d31; -fx-border-width: 0 1 0 0;");

        // Logo
        VBox logoBox = new VBox(2);
        Text logoTxt = new Text("FitVerse AI");
        logoTxt.setStyle("-fx-font-size:24px; -fx-font-weight:bold; -fx-fill: #62ff96;");
        Text subLogoTxt = new Text("Pro Athlete Account");
        subLogoTxt.setStyle("-fx-font-size:12px; -fx-fill: #8a8d91;");
        logoBox.getChildren().addAll(logoTxt, subLogoTxt);

        // Navigation Menu
        VBox navMenu = new VBox(5);
        navMenu.getChildren().addAll(
            createNavButton("Dashboard", false),
            createNavButton("Analytics", false),
            createNavButton("AI Mentor", false),
            createNavButton("Planner", true), // Planner is Active
            createNavButton("Find Gym", false),
            createNavButton("Settings", false)
        );

        Region sideSpacer = new Region();
        VBox.setVgrow(sideSpacer, Priority.ALWAYS);

        // Upgrade Button
        Button upgradeBtn = new Button("Upgrade to Pro");
        upgradeBtn.setStyle("-fx-background-color: #00e676; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 25px; -fx-padding: 12px;");
        upgradeBtn.setMaxWidth(Double.MAX_VALUE);

        sidebar.getChildren().addAll(logoBox, navMenu, sideSpacer, upgradeBtn);
        borderPane.setLeft(sidebar);

        // ==========================================
        // 2. MAIN CONTENT AREA
        // ==========================================
        VBox mainContent = new VBox(35);
        mainContent.setStyle("-fx-padding: 40px 50px;");
        mainContent.setMaxWidth(1200);

        // --- Header Section ---
        HBox header = new HBox();
        header.setAlignment(Pos.BOTTOM_LEFT);

        VBox titleBox = new VBox(5);
        Text title = new Text("Weekly Planner");
        title.setStyle("-fx-font-size:36px; -fx-font-weight:bold; -fx-fill: #ffffff;");
        Text subtitle = new Text("Precision planning for peak human performance.");
        subtitle.setStyle("-fx-font-size:14px; -fx-fill: #8a8d91;");
        titleBox.getChildren().addAll(title, subtitle);

        Region headerSpacer = new Region();
        HBox.setHgrow(headerSpacer, Priority.ALWAYS);

        HBox actionsBox = new HBox(15);
        actionsBox.setAlignment(Pos.CENTER);
        
        Button calBtn = new Button("📅"); 
        calBtn.setStyle("-fx-background-color: #212428; -fx-text-fill: #8a8d91; -fx-background-radius: 50%; -fx-min-width: 48px; -fx-min-height: 48px; -fx-font-size: 16px; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 50%;");
        
        Button generateBtn = new Button("Generate AI Workout");
        generateBtn.setStyle("-fx-background-color: #00e676; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-background-radius: 25px; -fx-padding: 14px 24px; -fx-font-size: 13px;");
        
        actionsBox.getChildren().addAll(calBtn, generateBtn);
        header.getChildren().addAll(titleBox, headerSpacer, actionsBox);

        // --- Calendar Strip ---
        HBox calendarStrip = new HBox();
        calendarStrip.setStyle("-fx-background-color: #1a1e22; -fx-background-radius: 16px; -fx-padding: 10px; -fx-border-color: rgba(255,255,255,0.05); -fx-border-radius: 16px;");
        calendarStrip.setAlignment(Pos.CENTER);
        
        calendarStrip.getChildren().addAll(
            createDayBox("MON", "12", false),
            createDayBox("TUE", "13", true), // Active Target Day
            createDayBox("WED", "14", false),
            createDayBox("THU", "15", false),
            createDayBox("FRI", "16", false),
            createDayBox("SAT", "17", false),
            createDayBox("SUN", "18", false)
        );

        // --- Exercise Grid (FlowPane for wrapping) ---
        FlowPane exerciseGrid = new FlowPane();
        exerciseGrid.setHgap(25);
        exerciseGrid.setVgap(25);
        exerciseGrid.setPrefWrapLength(1000); 

        exerciseGrid.getChildren().addAll(
            createExerciseCard(
                "Advanced", "Explosive Power Cleans", 
                "Compound movement targeting posterior chain and explosive recruitment.", 
                "Duration", "45m", "Calories", "380", "Sets", "5x5"
            ),
            createExerciseCard(
                "Intermediate", "Metabolic Kettlebell Flow", 
                "High-intensity interval training focusing on functional core stability.", 
                "Duration", "30m", "Calories", "420", "Rounds", "8"
            ),
            createExerciseCard(
                "Beginner", "Mobility & Restoration", 
                "Guided dynamic flexibility session for recovery and injury prevention.", 
                "Duration", "20m", "Calories", "110", "Focus", "Flex"
            ),
            createExerciseCard(
                "Pro", "Anaerobic Sprint Intervals", 
                "Lactic acid threshold training via high-velocity sprint intervals.", 
                "Duration", "40m", "Calories", "650", "Reps", "12"
            )
        );

        mainContent.getChildren().addAll(header, calendarStrip, exerciseGrid);

        // --- 3. FOOTER ---
        HBox footer = new HBox();
        footer.setStyle("-fx-padding: 20px 50px; -fx-background-color: #0c0f10; -fx-border-color: rgba(255,255,255,0.05) transparent transparent transparent; -fx-border-width: 1px 0 0 0;");
        footer.setAlignment(Pos.CENTER_LEFT);
        
        Text fCopy = new Text("© 2024 FitVerse AI. All rights reserved.");
        fCopy.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        
        Region fSpacer = new Region();
        HBox.setHgrow(fSpacer, Priority.ALWAYS);
        
        HBox fLinks = new HBox(25);
        String[] links = {"Privacy Policy", "Terms of Service", "Contact", "About"};
        for(String l : links) {
            Text t = new Text(l);
            t.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
            fLinks.getChildren().add(t);
        }
        footer.getChildren().addAll(fCopy, fSpacer, fLinks);

        // --- Wrap Main Content in ScrollPane ---
        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setStyle("-fx-background: #111415; -fx-border-color: transparent;");
        scrollPane.setFitToWidth(true);
        
        BorderPane contentWrapper = new BorderPane();
        contentWrapper.setCenter(scrollPane);
        contentWrapper.setBottom(footer);

        borderPane.setCenter(contentWrapper);

        plannerScene = new Scene(borderPane, 1400, 900);
        return plannerScene;
    }

    // --- High-Fidelity UI Components ---

    private Button createNavButton(String text, boolean isActive) {
        Button btn = new Button("   " + text);
        btn.setPrefWidth(Double.MAX_VALUE);
        btn.setAlignment(Pos.CENTER_LEFT);
        if (isActive) {
            btn.setStyle("-fx-background-color: rgba(98,255,150,0.1); -fx-text-fill: #62ff96; -fx-font-size: 14px; -fx-font-weight:bold; -fx-padding: 14px 15px; -fx-background-radius: 12px; -fx-border-color: #62ff96; -fx-border-width: 0 0 0 3px;");
        } else {
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 14px; -fx-padding: 14px 15px;");
        }
        return btn;
    }

    private VBox createDayBox(String dayStr, String dateStr, boolean isActive) {
        VBox box = new VBox(8);
        box.setAlignment(Pos.CENTER);
        HBox.setHgrow(box, Priority.ALWAYS);
        box.setMaxWidth(Double.MAX_VALUE);
        
        if (isActive) {
            box.setStyle("-fx-background-color: #00e676; -fx-background-radius: 12px; -fx-padding: 12px 0;");
        } else {
            box.setStyle("-fx-background-color: transparent; -fx-padding: 12px 0;");
        }

        Text day = new Text(dayStr);
        day.setStyle("-fx-font-size:12px; -fx-fill: " + (isActive ? "#000000" : "#8a8d91") + ";");
        Text date = new Text(dateStr);
        date.setStyle("-fx-font-size:20px; -fx-font-weight:bold; -fx-fill: " + (isActive ? "#000000" : "#ffffff") + ";");
        
        box.getChildren().addAll(day, date);
        return box;
    }

    private VBox createExerciseCard(String level, String title, String desc, 
                                    String s1Lbl, String s1Val, 
                                    String s2Lbl, String s2Val, 
                                    String s3Lbl, String s3Val) {
        
        VBox card = new VBox();
        card.setStyle("-fx-background-color: #1a1e22; -fx-background-radius: 20px; -fx-border-color: rgba(255,255,255,0.05); -fx-border-radius: 20px;");
        card.setPrefWidth(340); 

        // Image Container
        StackPane imageArea = new StackPane();
        imageArea.setPrefHeight(200);
        
        Rectangle imgBg = new Rectangle(340, 200);
        imgBg.setArcWidth(24);
        imgBg.setArcHeight(24);
        imgBg.setFill(Color.web("#0e1512")); // Simulated image background tint
        
        // Block to remove bottom radius so it sits flush with the text VBox below
        Rectangle flatBottom = new Rectangle(340, 100);
        flatBottom.setFill(Color.web("#0e1512"));
        StackPane.setAlignment(flatBottom, Pos.BOTTOM_CENTER);
        
        // Difficulty Badge
        Text badgeTxt = new Text(level);
        badgeTxt.setStyle("-fx-fill: #62ff96; -fx-font-size: 12px;");
        HBox badgeBox = new HBox(badgeTxt);
        badgeBox.setStyle("-fx-background-color: rgba(98,255,150,0.15); -fx-padding: 6px 14px; -fx-background-radius: 20px;");
        badgeBox.setMaxWidth(Region.USE_PREF_SIZE);
        badgeBox.setMaxHeight(Region.USE_PREF_SIZE);
        StackPane.setAlignment(badgeBox, Pos.TOP_LEFT);
        StackPane.setMargin(badgeBox, new Insets(15));
        
        imageArea.getChildren().addAll(imgBg, flatBottom, badgeBox);

        // Content Area
        VBox contentArea = new VBox(20);
        contentArea.setStyle("-fx-padding: 25px;");
        
        VBox textData = new VBox(8);
        Text titleTxt = new Text(title);
        titleTxt.setStyle("-fx-font-size:18px; -fx-font-weight:bold; -fx-fill: #ffffff;");
        
        Label descTxt = new Label(desc);
        descTxt.setWrapText(true);
        descTxt.setStyle("-fx-font-size:14px; -fx-text-fill: #8a8d91; -fx-line-spacing: 4px;");
        descTxt.setMinHeight(60);
        descTxt.setAlignment(Pos.TOP_LEFT);
        textData.getChildren().addAll(titleTxt, descTxt);

        // Statistics Row
        HBox statsRow = new HBox(30);
        statsRow.getChildren().addAll(
            createStatBlock(s1Lbl, s1Val),
            createStatBlock(s2Lbl, s2Val),
            createStatBlock(s3Lbl, s3Val)
        );

        // Action Buttons Row
        HBox actionsRow = new HBox(15);
        Button videoBtn = new Button("⊙ Video");
        videoBtn.setMaxWidth(Double.MAX_VALUE); 
        HBox.setHgrow(videoBtn, Priority.ALWAYS);
        videoBtn.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-text-fill: #ffffff; -fx-background-radius: 25px; -fx-padding: 12px; -fx-font-size: 13px; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 25px;");
        
        Button pdfBtn = new Button("↓ PDF");
        pdfBtn.setMaxWidth(Double.MAX_VALUE); 
        HBox.setHgrow(pdfBtn, Priority.ALWAYS);
        pdfBtn.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-text-fill: #ffffff; -fx-background-radius: 25px; -fx-padding: 12px; -fx-font-size: 13px; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 25px;");
        
        actionsRow.getChildren().addAll(videoBtn, pdfBtn);

        contentArea.getChildren().addAll(textData, statsRow, actionsRow);
        card.getChildren().addAll(imageArea, contentArea);
        
        return card;
    }

    private VBox createStatBlock(String label, String value) {
        VBox block = new VBox(2);
        Text l = new Text(label);
        l.setStyle("-fx-font-size:12px; -fx-fill: #8a8d91;");
        Text v = new Text(value);
        v.setStyle("-fx-font-size:16px; -fx-font-weight:bold; -fx-fill: #62ff96;");
        block.getChildren().addAll(l, v);
        return block;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Runnable navCallback = () -> {
            System.out.println("Executing Callback Navigation...");
        };
        
        stage.setScene(getPlannerScene(navCallback));
        stage.setTitle("FitVerse AI - Weekly Planner");
        stage.show();
    }
}
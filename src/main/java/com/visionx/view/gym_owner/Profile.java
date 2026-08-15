package com.visionx.view.gym_owner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class Profile {

    private Scene ProfileScene;

    // Theme Colors directly from your Tailwind Config
    private final String BG_COLOR = "#0d150e";
    private final String SURFACE_COLOR = "#151e16";
    private final String SURFACE_LIGHT = "#19221a";
    private final String PRIMARY = "#75ff9e";
    private final String TEXT_MAIN = "#dbe5d9";
    private final String TEXT_MUTED = "#859585";
    private final String BORDER_COLOR = "#2e372e";

    public Scene getProfileScene(Runnable callBackAction) {
        VBox mainArea = new VBox();
        mainArea.setStyle("-fx-background-color: " + BG_COLOR + ";");

        HBox header = createHeader();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: " + BG_COLOR + "; -fx-border-color: " + BG_COLOR + ";");
        scrollPane.getStylesheets().add(createScrollbarStyle());

        VBox contentBody = createContentBody();
        scrollPane.setContent(contentBody);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        mainArea.getChildren().addAll(header, scrollPane);

        Scene scene = new Scene(mainArea, 1160, 900);

        ProfileScene = scene;
        return ProfileScene;
    }





    // ==========================================
    // HEADER
    // ==========================================
    private HBox createHeader() {
        HBox header = new HBox(20);
        header.setMinHeight(72);
        header.setPadding(new Insets(0, 32, 0, 32));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: " + SURFACE_COLOR + "; -fx-border-color: " + BORDER_COLOR + "; -fx-border-width: 0 0 1 0;");

        // Search Bar
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search facilities, memberships...");
        searchBar.setPrefWidth(400);
        searchBar.setStyle("-fx-background-color: " + SURFACE_LIGHT + "; -fx-text-fill: " + TEXT_MAIN + "; -fx-prompt-text-fill: " + TEXT_MUTED + "; -fx-background-radius: 20px; -fx-padding: 8px 16px;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Icons & HQ text
        Label notifications = new Label("[N]");
        notifications.setStyle("-fx-text-fill: " + TEXT_MUTED + "; -fx-font-size: 18px;");
        Label settings = new Label("[S]");
        settings.setStyle("-fx-text-fill: " + TEXT_MUTED + "; -fx-font-size: 18px;");

        VBox hqBox = new VBox(2);
        hqBox.setAlignment(Pos.CENTER_RIGHT);
        Text hqTitle = new Text("FitVerse HQ");
        hqTitle.setStyle("-fx-fill: " + PRIMARY + "; -fx-font-size: 12px; -fx-font-weight: bold;");
        Text hqRole = new Text("Facility Manager");
        hqRole.setStyle("-fx-fill: " + TEXT_MUTED + "; -fx-font-size: 10px;");
        hqBox.getChildren().addAll(hqTitle, hqRole);

        header.getChildren().addAll(searchBar, spacer, notifications, settings, hqBox);
        return header;
    }

    // ==========================================
    // MAIN CONTENT BODY
    // ==========================================
    private VBox createContentBody() {
        VBox content = new VBox(32);
        content.setPadding(new Insets(32));
        content.setMaxWidth(1100); // Limit width for large screens

        // Top Heading Area
        HBox headingBox = new HBox();
        headingBox.setAlignment(Pos.BOTTOM_LEFT);
        
        VBox texts = new VBox(5);
        Text title = new Text("Gym Registration");
        title.setStyle("-fx-fill: " + TEXT_MAIN + "; -fx-font-size: 32px; -fx-font-weight: bold;");
        Text subTitle = new Text("Configure your facility's public profile and operational details.");
        subTitle.setStyle("-fx-fill: " + TEXT_MUTED + "; -fx-font-size: 14px;");
        texts.getChildren().addAll(title, subTitle);

        Region hSpacer = new Region();
        HBox.setHgrow(hSpacer, Priority.ALWAYS);

        Button previewBtn = new Button("Preview Profile");
        previewBtn.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-text-fill: " + TEXT_MAIN + "; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 8px; -fx-background-radius: 8px; -fx-padding: 8px 16px;");
        
        Button saveBtn = new Button("Save Changes");
        saveBtn.setStyle("-fx-background-color: #004d13; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10px; -fx-padding: 8px 16px; -fx-cursor: hand;");

        HBox btnBox = new HBox(12, previewBtn, saveBtn);
        headingBox.getChildren().addAll(texts, hSpacer, btnBox);

        // ================= GRID LAYOUT =================
        HBox columns = new HBox(32); // Gap between columns
        
        // --- Left Column (Takes 2/3 space) ---
        VBox leftCol = new VBox(32);
        HBox.setHgrow(leftCol, Priority.ALWAYS);
        
        VBox generalInfoCard = createGeneralInfoCard();
        VBox galleryCard = createGalleryCard();
        VBox amenitiesCard = createAmenitiesCard();
        
        leftCol.getChildren().addAll(generalInfoCard, galleryCard, amenitiesCard);

        // --- Right Column (Takes 1/3 space) ---
        VBox rightCol = new VBox(32);
        rightCol.setMinWidth(350);
        rightCol.setMaxWidth(350);

        VBox hoursCard = createHoursCard();
        VBox socialCard = createSocialCard();
        VBox strengthCard = createProfileStrengthCard();

        rightCol.getChildren().addAll(hoursCard, socialCard, strengthCard);

        columns.getChildren().addAll(leftCol, rightCol);
        content.getChildren().addAll(headingBox, columns);

        return content;
    }

    // ==========================================
    // CARDS GENERATION (Helper Methods)
    // ==========================================
    
    private VBox createCard(String titleIcon, String titleText, Node content) {
        VBox card = new VBox(24);
        card.setStyle("-fx-background-color: rgba(13, 21, 14, 0.6); -fx-border-color: rgba(255,255,255,0.05); -fx-border-radius: 16px; -fx-background-radius: 16px; -fx-padding: 32px;");
        
        HBox titleBox = new HBox(12);
        titleBox.setAlignment(Pos.CENTER_LEFT);
        Text icon = new Text(titleIcon);
        icon.setStyle("-fx-fill: " + PRIMARY + "; -fx-font-size: 20px;");
        Text title = new Text(titleText);
        title.setStyle("-fx-fill: " + TEXT_MAIN + "; -fx-font-size: 20px; -fx-font-weight: bold;");
        titleBox.getChildren().addAll(icon, title);

        card.getChildren().addAll(titleBox, content);
        return card;
    }

    private VBox createGeneralInfoCard() {
        GridPane grid = new GridPane();
        grid.setHgap(24);
        grid.setVgap(16);

        VBox gymName = createInputGroup("Gym Name", "Enter facility name", "Apex Performance Center");
        VBox ownerName = createInputGroup("Owner Name", "Legal owner name", "Marcus Sterling");
        VBox email = createInputGroup("Business Email", "Email for inquiries", "contact@apexperformance.com");
        VBox phone = createInputGroup("Phone Number", "+1 (000) 000-0000", "+1 (555) 982-3000");
        VBox address = createInputGroup("Physical Address", "Full address", "742 Evolution Way, Suite 10, Silicon Valley, CA 94025");
        
        // TextArea for Description
        VBox descBox = new VBox(8);
        Label descLabel = new Label("Gym Description");
        descLabel.setStyle("-fx-text-fill: " + TEXT_MUTED + "; -fx-font-size: 12px;");
        TextArea descInput = new TextArea("Apex Performance Center is a state-of-the-art facility focused on elite-level training. We specialize in high-performance conditioning, strength training, and recovery protocols.");
        descInput.setPrefRowCount(4);
        descInput.setWrapText(true);
        descInput.setStyle("-fx-control-inner-background: #080d09; -fx-text-fill: " + TEXT_MAIN + "; -fx-background-radius: 10px; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 10px;");
        descBox.getChildren().addAll(descLabel, descInput);

        grid.add(gymName, 0, 0);
        grid.add(ownerName, 1, 0);
        grid.add(email, 0, 1);
        grid.add(phone, 1, 1);
        grid.add(address, 0, 2, 2, 1);
        grid.add(descBox, 0, 3, 2, 1);

        // Make columns equal width
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(50);
        grid.getColumnConstraints().addAll(cc, cc);

        return createCard("[I]", "General Information", grid);
    }

    private VBox createGalleryCard() {
        HBox galleryBox = new HBox(16);
        // Using colored rectangles to simulate images
        for (int i = 0; i < 3; i++) {
            Region imgSlot = new Region();
            imgSlot.setPrefSize(120, 120);
            imgSlot.setStyle("-fx-background-color: #1a2920; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 12px; -fx-background-radius: 12px;");
            galleryBox.getChildren().add(imgSlot);
        }
        
        // Add Photo Button
        VBox addBtn = new VBox(5);
        addBtn.setAlignment(Pos.CENTER);
        addBtn.setPrefSize(120, 120);
        addBtn.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 12px; -fx-background-radius: 12px; -fx-border-style: dashed;");
        Text plus = new Text("+");
        plus.setStyle("-fx-fill: " + TEXT_MUTED + ";");
        Text addTxt = new Text("Add Photo");
        addTxt.setStyle("-fx-fill: " + TEXT_MUTED + "; -fx-font-size: 12px;");
        addBtn.getChildren().addAll(plus, addTxt);
        galleryBox.getChildren().add(addBtn);

        return createCard("[G]", "Facility Gallery", galleryBox);
    }

    private VBox createAmenitiesCard() {
        GridPane grid = new GridPane();
        grid.setHgap(32);
        grid.setVgap(16);

        String[] amenities = {"24/7 Access", "Showers & Lockers", "Personal Training", "Sauna/Steam Room", "Free WiFi", "Juice Bar", "Group Classes", "Parking On-site", "Pool"};
        boolean[] isChecked = {true, true, true, false, true, true, false, true, false};

        int col = 0, row = 0;
        for (int i = 0; i < amenities.length; i++) {
            CheckBox cb = new CheckBox(amenities[i]);
            cb.setSelected(isChecked[i]);
            cb.setStyle("-fx-text-fill: " + TEXT_MAIN + ";");
            grid.add(cb, col, row);
            
            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }
        return createCard("[A]", "Amenities & Features", grid);
    }

    private VBox createHoursCard() {
        VBox content = new VBox(16);
        content.getChildren().addAll(
            createTimeRow("Mon - Fri", "05:00 AM", "11:00 PM"),
            createTimeRow("Saturday", "07:00 AM", "09:00 PM"),
            createTimeRow("Sunday", "08:00 AM", "06:00 PM")
        );
        return createCard("[H]", "Opening Hours", content);
    }

    private VBox createSocialCard() {
        VBox content = new VBox(16);
        content.getChildren().addAll(
            createInputGroup("Instagram", "", "@apex_performance"),
            createInputGroup("X (Twitter)", "", "@apexfit_official"),
            createInputGroup("YouTube", "", "ApexTrainingChannel")
        );
        return createCard("[S]", "Social Media", content);
    }

    private VBox createProfileStrengthCard() {
        VBox content = new VBox(8);
        
        HBox topBox = new HBox();
        Text percent = new Text("85% Complete");
        percent.setStyle("-fx-fill: " + TEXT_MAIN + "; -fx-font-size: 14px;");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Text check = new Text("OK");
        check.setStyle("-fx-fill: " + PRIMARY + ";");
        topBox.getChildren().addAll(percent, spacer, check);

        // Progress Bar simulation
        Region progressBg = new Region();
        progressBg.setPrefHeight(6);
        progressBg.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-background-radius: 5px;");
        
        Region progressFill = new Region();
        progressFill.setPrefHeight(6);
        progressFill.setPrefWidth(250); // Hardcoded width for 85% visually
        progressFill.setStyle("-fx-background-color: " + PRIMARY + "; -fx-background-radius: 5px;");

        StackPane progressBar = new StackPane(progressBg, progressFill);
        StackPane.setAlignment(progressFill, Pos.CENTER_LEFT);

        Text tip = new Text("Add a gym walkthrough video to reach 100% and get a \"Verified\" badge on the explorer page.");
        tip.setStyle("-fx-fill: " + TEXT_MUTED + "; -fx-font-size: 12px;");
        tip.setWrappingWidth(300);

        content.getChildren().addAll(topBox, progressBar, tip);
        return createCard("[P]", "Profile Integrity", content);
    }

    // ==========================================
    // SMALL UTILITY HELPERS
    // ==========================================
    
    private VBox createInputGroup(String labelStr, String prompt, String value) {
        VBox box = new VBox(8);
        Label label = new Label(labelStr);
        label.setStyle("-fx-text-fill: " + TEXT_MUTED + "; -fx-font-size: 12px;");
        
        TextField field = new TextField(value);
        field.setPromptText(prompt);
        field.setStyle("-fx-background-color: #080d09; -fx-text-fill: " + TEXT_MAIN + "; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px 14px;");
        
        box.getChildren().addAll(label, field);
        return box;
    }

    private HBox createTimeRow(String day, String start, String end) {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER_LEFT);
        
        Label dayLbl = new Label(day);
        dayLbl.setPrefWidth(80);
        dayLbl.setStyle("-fx-text-fill: " + TEXT_MUTED + "; -fx-font-size: 12px;");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        TextField startF = new TextField(start);
        startF.setPrefWidth(80);
        startF.setStyle("-fx-background-color: #080d09; -fx-text-fill: " + TEXT_MAIN + "; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 6px; -fx-background-radius: 6px; -fx-padding: 5px; -fx-alignment: center;");
        
        Label dash = new Label(" - ");
        dash.setStyle("-fx-text-fill: " + TEXT_MUTED + ";");

        TextField endF = new TextField(end);
        endF.setPrefWidth(80);
        endF.setStyle(startF.getStyle());

        box.getChildren().addAll(dayLbl, spacer, startF, dash, endF);
        return box;
    }

    // CSS to hide the ugly default scrollbar of JavaFX
    private String createScrollbarStyle() {
        return "data:text/css," +
               ".scroll-pane > .viewport { -fx-background-color: transparent; } " +
               ".scroll-bar:horizontal, .scroll-bar:vertical { -fx-background-color: transparent; } " +
               ".scroll-bar:horizontal .thumb, .scroll-bar:vertical .thumb { -fx-background-color: #2e372e; -fx-background-radius: 5em; }";
    }






}
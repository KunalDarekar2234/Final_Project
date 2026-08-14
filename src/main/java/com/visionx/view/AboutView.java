package com.visionx.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import javafx.stage.Stage;

public class AboutView extends Application {

    private Scene aboutScene;

    public Scene getAboutScene(Runnable callBackAction) {

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #111415;");

        // ==========================================
        // 1. TOP NAVIGATION BAR
        // ==========================================
        HBox topNav = new HBox();
        topNav.setStyle("-fx-background-color: rgba(17, 20, 21, 0.95); -fx-padding: 20px 50px; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 0 0 1px 0;");
        topNav.setAlignment(Pos.CENTER_LEFT);

        Text logoTxt = new Text("FitVerse");
        logoTxt.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: #62ff96;");
        
        HBox navLinks = new HBox(35);
        navLinks.setAlignment(Pos.CENTER);
        navLinks.getChildren().addAll(
            createTopNavLink("Dashboard", false),
            createTopNavLink("Workouts", false),
            createTopNavLink("Diet", false),
            createTopNavLink("Marketplace", false) 
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
        // 2. MAIN CONTENT AREA (Scrollable)
        // ==========================================
        VBox mainContent = new VBox(70);
        mainContent.setStyle("-fx-padding: 60px 40px; -fx-background-color: #111415;");
        mainContent.setAlignment(Pos.TOP_CENTER);
        
        // Container to restrict max width for widescreen monitors
        VBox contentWrapper = new VBox(70);
        contentWrapper.setMaxWidth(1100);
        contentWrapper.setAlignment(Pos.TOP_CENTER);

        // --- A. HERO SECTION ---
        VBox heroSection = new VBox(15);
        heroSection.setAlignment(Pos.TOP_LEFT);
        
        Text preTitle = new Text("ABOUT THE VERSE");
        preTitle.setStyle("-fx-fill: #62ff96; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 2px;");
        
        VBox titleBox = new VBox(-5);
        Text title1 = new Text("Engineering the ");
        title1.setStyle("-fx-fill: #ffffff; -fx-font-size: 56px; -fx-font-weight: bold;");
        Text title2 = new Text("Athlete\nof Tomorrow.");
        title2.setStyle("-fx-fill: #62ff96; -fx-font-size: 56px; -fx-font-weight: bold;");
        titleBox.getChildren().addAll(title1, title2);

        Label subHero = new Label("We don't just track workouts; we decode human performance through neural\nsynchronization and predictive AI biometrics.");
        subHero.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 16px; -fx-line-spacing: 5px;");
        
        heroSection.getChildren().addAll(preTitle, titleBox, subHero);

        // --- B. MISSION & VISION BENTO GRID ---
        VBox bentoGrid = new VBox(20);
        
        // Row 1
        HBox bentoRow1 = new HBox(20);
        
        VBox missionCard = new VBox(20);
        missionCard.setStyle("-fx-background-color: #1a1e22; -fx-padding: 40px; -fx-background-radius: 16px; -fx-border-color: #2a2d31; -fx-border-radius: 16px;");
        HBox.setHgrow(missionCard, Priority.ALWAYS);
        missionCard.setPrefWidth(600);
        Text mTitle = new Text("Our Mission");
        mTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 28px; -fx-font-weight: bold;");
        Label mDesc = new Label("To democratize elite-level sports science by placing an AI-powered personal coach in every pocket. We believe fitness isn't just about repetition; it's about precision. By leveraging high-frequency data, FitVerse empowers individuals to transcend their perceived limits with safety and scientific certainty.");
        mDesc.setWrapText(true);
        mDesc.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 14px; -fx-line-spacing: 4px;");
        
        HBox statsBox = new HBox(40);
        statsBox.setPadding(new Insets(20, 0, 0, 0));
        VBox stat1 = new VBox(5);
        Text s1Val = new Text("2.4M"); s1Val.setStyle("-fx-fill: #62ff96; -fx-font-size: 24px; -fx-font-weight: bold;");
        Text s1Lbl = new Text("Athletes Trained"); s1Lbl.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        stat1.getChildren().addAll(s1Val, s1Lbl);
        
        Rectangle divider = new Rectangle(1, 40, Color.web("#2a2d31"));
        
        VBox stat2 = new VBox(5);
        Text s2Val = new Text("98%"); s2Val.setStyle("-fx-fill: #62ff96; -fx-font-size: 24px; -fx-font-weight: bold;");
        Text s2Lbl = new Text("Goal Achievement"); s2Lbl.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        stat2.getChildren().addAll(s2Val, s2Lbl);
        
        statsBox.getChildren().addAll(stat1, divider, stat2);
        missionCard.getChildren().addAll(mTitle, mDesc, statsBox);

        StackPane imageCard = new StackPane();
        imageCard.setStyle("-fx-background-color: #0e1215; -fx-background-radius: 16px; -fx-border-color: #2a2d31; -fx-border-radius: 16px;");
        HBox.setHgrow(imageCard, Priority.ALWAYS);
        imageCard.setPrefWidth(400);
        Text imgMockText = new Text("Lab Visualization");
        imgMockText.setStyle("-fx-fill: #3a3d41;");
        imageCard.getChildren().add(imgMockText);
        
        bentoRow1.getChildren().addAll(missionCard, imageCard);

        // Row 2
        HBox bentoRow2 = new HBox(20);
        
        VBox visionCard = new VBox(15);
        visionCard.setStyle("-fx-background-color: #1a1e22; -fx-padding: 30px 40px; -fx-background-radius: 16px; -fx-border-color: #2a2d31; -fx-border-radius: 16px;");
        HBox.setHgrow(visionCard, Priority.ALWAYS);
        Text vTitle = new Text("Our Vision");
        vTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 28px; -fx-font-weight: bold;");
        Label vDesc = new Label("Creating a world where physical potential is no longer a mystery, but a data-driven journey of continuous evolution.");
        vDesc.setWrapText(true);
        vDesc.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 14px; -fx-line-spacing: 4px;");
        visionCard.getChildren().addAll(vTitle, vDesc);

        HBox neuralCard = new HBox(20);
        neuralCard.setAlignment(Pos.CENTER_LEFT);
        neuralCard.setStyle("-fx-background-color: #1a1e22; -fx-padding: 30px 40px; -fx-background-radius: 16px; -fx-border-color: #2a2d31; -fx-border-radius: 16px;");
        HBox.setHgrow(neuralCard, Priority.ALWAYS);
        
        StackPane iconBg = new StackPane();
        Rectangle bgRect = new Rectangle(60, 60, Color.web("rgba(98,255,150,0.1)"));
        bgRect.setArcWidth(30); bgRect.setArcHeight(30);
        Text brainIcon = new Text("🧠");
        brainIcon.setStyle("-fx-font-size: 28px;");
        iconBg.getChildren().addAll(bgRect, brainIcon);

        VBox nTexts = new VBox(5);
        Text nTitle = new Text("Neural Integration");
        nTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 18px; -fx-font-weight: bold;");
        Label nDesc = new Label("Coming 2025: Direct sync with wearable EEG for mental flow-state optimization during peak performance.");
        nDesc.setWrapText(true);
        nDesc.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 13px; -fx-line-spacing: 4px;");
        nTexts.getChildren().addAll(nTitle, nDesc);
        
        neuralCard.getChildren().addAll(iconBg, nTexts);
        
        bentoRow2.getChildren().addAll(visionCard, neuralCard);
        bentoGrid.getChildren().addAll(bentoRow1, bentoRow2);

        // --- C. THE JOURNEY (Timeline) ---
        VBox journeySection = new VBox(40);
        journeySection.setAlignment(Pos.CENTER);
        journeySection.setStyle("-fx-padding: 40px 0;");
        
        VBox jHeader = new VBox(5);
        jHeader.setAlignment(Pos.CENTER);
        Text jTitle = new Text("The Journey");
        jTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");
        Text jSub = new Text("From a garage algorithm to a global movement.");
        jSub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        jHeader.getChildren().addAll(jTitle, jSub);

        HBox timelineBox = new HBox(20);
        timelineBox.getChildren().addAll(
            createTimelineStep("2020", "Inception", "The first neural-net for movement tracking was born in a basement in Zurich.", true),
            createTimelineStep("2021", "Seed Phase", "Beta testing with 500 professional CrossFit athletes yielded 40% performance gains.", false),
            createTimelineStep("2022", "FitVerse 1.0", "Global launch. The AI Mentor feature becomes the #1 rated fitness tool on the App Store.", false),
            createTimelineStep("2024", "The Verse expansion", "Acquisition of BioSync labs and launch of personalized diet algorithms.", false)
        );

        journeySection.getChildren().addAll(jHeader, timelineBox);

        // --- D. ARCHITECTS OF CHANGE (Team) ---
        VBox teamSection = new VBox(40);
        teamSection.setAlignment(Pos.CENTER);

        VBox tHeader = new VBox(5);
        tHeader.setAlignment(Pos.CENTER);
        Text tTitle = new Text("Architects of Change");
        tTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");
        Text tSub = new Text("The minds behind the code and the muscle.");
        tSub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        tHeader.getChildren().addAll(tTitle, tSub);

        HBox teamGrid = new HBox(30);
        teamGrid.getChildren().addAll(
            createTeamMember("Eara Voss", "CEO & CO-FOUNDER", "Former MIT Neural Engineering lead with a passion for ultramarathons."),
            createTeamMember("Marcus Thorne", "CTO & CO-FOUNDER", "Pioneer in real-time biometric processing and ex-Olympic conditioning coach."),
            createTeamMember("Dr. Lena Chen", "CHIEF SCIENCE OFFICER", "Leading researcher in epigenetics and personalized performance nutrition.")
        );

        teamSection.getChildren().addAll(tHeader, teamGrid);

        // --- E. CALL TO ACTION ---
        VBox ctaSection = new VBox(25);
        ctaSection.setAlignment(Pos.CENTER);
        ctaSection.setStyle("-fx-background-color: #1a1e22; -fx-padding: 60px; -fx-background-radius: 16px; -fx-border-color: #2a2d31; -fx-border-radius: 16px;");

        Text ctaTitle = new Text("Ready to rewrite your limits?");
        ctaTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");
        Text ctaSub = new Text("Join the 2 million athletes who have already stepped into the future of fitness.");
        ctaSub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 15px;");
        
        Button ctaBtn = new Button("GET STARTED NOW");
        ctaBtn.setStyle("-fx-background-color: #62ff96; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 30px; -fx-padding: 15px 35px;");
        ctaBtn.setOnAction(e -> {
            System.out.println("Navigating...");
            callBackAction.run();
        });

        ctaSection.getChildren().addAll(ctaTitle, ctaSub, ctaBtn);

        // Assemble Content Wrapper
        contentWrapper.getChildren().addAll(heroSection, bentoGrid, journeySection, teamSection, ctaSection);
        mainContent.getChildren().add(contentWrapper);

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
        
        Region fSpacer1 = new Region();
        HBox.setHgrow(fSpacer1, Priority.ALWAYS);
        
        HBox fLinks = new HBox(30);
        fLinks.setAlignment(Pos.CENTER);
        fLinks.getChildren().addAll(
            createFooterLink("Privacy Policy"),
            createFooterLink("Terms of Service"),
            createFooterLink("Contact"),
            createFooterLink("About", true) // Active state for 'About'
        );

        Region fSpacer2 = new Region();
        HBox.setHgrow(fSpacer2, Priority.ALWAYS);

        Button langBtn = new Button("🌐");
        langBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-border-color: transparent; -fx-font-size: 16px;");
        Button shareBtn = new Button("🔗");
        shareBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-border-color: transparent; -fx-font-size: 16px;");
        HBox fIcons = new HBox(10, langBtn, shareBtn);

        footer.getChildren().addAll(fLogoBox, fSpacer1, fLinks, fSpacer2, fIcons);
        borderPane.setBottom(footer);

        aboutScene = new Scene(borderPane, 1300, 900);
        return aboutScene;
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

    private Text createFooterLink(String text) {
        return createFooterLink(text, false);
    }

    private Text createFooterLink(String text, boolean isActive) {
        Text link = new Text(text);
        if(isActive) {
            link.setStyle("-fx-fill: #62ff96; -fx-font-size: 12px; -fx-font-weight: bold;");
        } else {
            link.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px; -fx-font-weight: bold;");
        }
        return link;
    }

    private VBox createTimelineStep(String year, String title, String desc, boolean isActive) {
        VBox step = new VBox(10);
        HBox.setHgrow(step, Priority.ALWAYS);

        // Line and dot
        HBox lineContainer = new HBox();
        lineContainer.setAlignment(Pos.CENTER_LEFT);
        Circle dot = new Circle(4, isActive ? Color.web("#62ff96") : Color.web("#8a8d91"));
        Region line = new Region();
        HBox.setHgrow(line, Priority.ALWAYS);
        line.setStyle("-fx-background-color: " + (isActive ? "#62ff96" : "#2a2d31") + "; -fx-min-height: 2px; -fx-max-height: 2px;");
        lineContainer.getChildren().addAll(dot, line);

        Text yearTxt = new Text(year);
        yearTxt.setStyle("-fx-fill: " + (isActive ? "#62ff96" : "#8a8d91") + "; -fx-font-size: 11px; -fx-font-weight: bold;");
        Text titleTxt = new Text(title);
        titleTxt.setStyle("-fx-fill: #ffffff; -fx-font-size: 18px; -fx-font-weight: bold;");
        Label descLbl = new Label(desc);
        descLbl.setWrapText(true);
        descLbl.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 13px; -fx-line-spacing: 4px;");

        step.getChildren().addAll(lineContainer, yearTxt, titleTxt, descLbl);
        return step;
    }

    private VBox createTeamMember(String name, String role, String desc) {
        VBox card = new VBox(12);
        HBox.setHgrow(card, Priority.ALWAYS);

        Rectangle imgMock = new Rectangle(0, 0, Color.web("#1a1e22"));
        imgMock.widthProperty().bind(card.widthProperty());
        imgMock.setHeight(320); // Keep height fixed, let width respond
        imgMock.setArcWidth(16); 
        imgMock.setArcHeight(16);

        Text nTxt = new Text(name);
        nTxt.setStyle("-fx-fill: #ffffff; -fx-font-size: 18px; -fx-font-weight: bold;");
        Text rTxt = new Text(role);
        rTxt.setStyle("-fx-fill: #62ff96; -fx-font-size: 10px; -fx-font-weight: bold;");
        Label dLbl = new Label(desc);
        dLbl.setWrapText(true);
        dLbl.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 13px; -fx-line-spacing: 4px;");

        card.getChildren().addAll(imgMock, nTxt, rTxt, dLbl);
        return card;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Runnable navCallback = () -> {
            System.out.println("Processing CTA...");
        };
        
        stage.setScene(getAboutScene(navCallback));
        stage.setTitle("FitVerse AI - About Us");
        stage.show();
    }
}
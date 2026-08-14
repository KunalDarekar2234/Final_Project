package com.visionx.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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

public class LandingPageView extends Application {

    private Scene landingScene;

    public Scene getLandingScene(Runnable callBackAction) {

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #111415;");

        // ==========================================
        // 1. TOP NAVIGATION BAR
        // ==========================================
        HBox topNav = new HBox();
        topNav.setStyle("-fx-background-color: rgba(17, 20, 21, 0.95); -fx-padding: 15px 50px; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 0 0 1px 0;");
        topNav.setAlignment(Pos.CENTER_LEFT);

        Text logoTxt = new Text("FitVerse");
        logoTxt.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: #62ff96;");
        
        HBox navLinks = new HBox(35);
        navLinks.setAlignment(Pos.CENTER);
        navLinks.setPadding(new Insets(0, 0, 0, 60));
        navLinks.getChildren().addAll(
            createTopNavLink("Dashboard", true), // Active
            createTopNavLink("Workouts", false),
            createTopNavLink("Diet", false),
            createTopNavLink("Marketplace", false)
        );

        Region navSpacer = new Region();
        HBox.setHgrow(navSpacer, Priority.ALWAYS);

        HBox rightControls = new HBox(15);
        rightControls.setAlignment(Pos.CENTER_RIGHT);

        TextField searchField = new TextField();
        searchField.setPromptText("Search insights...");
        searchField.setStyle("-fx-background-color: #1a1e22; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-padding: 8px 15px; -fx-background-radius: 20px; -fx-pref-width: 200px; -fx-border-color: transparent;");

        Button notifBtn = new Button("🔔");
        notifBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");
        Button settingsBtn = new Button("⚙");
        settingsBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");
        
        Circle avatar = new Circle(16, Color.web("#2a2d31"));
        avatar.setStroke(Color.web("rgba(98,255,150,0.4)"));

        rightControls.getChildren().addAll(searchField, notifBtn, settingsBtn, avatar);
        topNav.getChildren().addAll(logoTxt, navLinks, navSpacer, rightControls);
        borderPane.setTop(topNav);

        // ==========================================
        // 2. MAIN CONTENT AREA (Scrollable)
        // ==========================================
        VBox mainContent = new VBox(100);
        mainContent.setStyle("-fx-padding: 60px 0; -fx-background-color: #111415;");
        mainContent.setAlignment(Pos.TOP_CENTER);

        VBox contentWrapper = new VBox(100);
        contentWrapper.setMaxWidth(1200);
        contentWrapper.setAlignment(Pos.TOP_CENTER);
        contentWrapper.setPadding(new Insets(0, 40, 0, 40));

        // --- A. HERO SECTION ---
        HBox heroSection = new HBox(40);
        heroSection.setAlignment(Pos.CENTER_LEFT);
        
        VBox heroLeft = new VBox(25);
        HBox.setHgrow(heroLeft, Priority.ALWAYS);
        heroLeft.setPrefWidth(600);

        HBox badgeBox = new HBox(8);
        badgeBox.setAlignment(Pos.CENTER_LEFT);
        badgeBox.setStyle("-fx-background-color: rgba(98,255,150,0.1); -fx-border-color: rgba(98,255,150,0.2); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-padding: 5px 12px;");
        badgeBox.setMaxWidth(Region.USE_PREF_SIZE);
        Circle badgeDot = new Circle(4, Color.web("#62ff96"));
        Text badgeTxt = new Text("AI ADAPTIVE TRAINING NOW LIVE");
        badgeTxt.setStyle("-fx-fill: #62ff96; -fx-font-size: 10px; -fx-font-weight: bold;");
        badgeBox.getChildren().addAll(badgeDot, badgeTxt);

        VBox titleBox = new VBox(-5);
        Text title1 = new Text("Forge Your ");
        title1.setStyle("-fx-fill: #ffffff; -fx-font-size: 56px; -fx-font-weight: bold;");
        Text title2 = new Text("Elite");
        title2.setStyle("-fx-fill: #62ff96; -fx-font-size: 56px; -fx-font-weight: bold; -fx-font-style: italic;");
        HBox titleRow = new HBox(title1, title2);
        Text title3 = new Text("Physicality.");
        title3.setStyle("-fx-fill: #ffffff; -fx-font-size: 56px; -fx-font-weight: bold;");
        titleBox.getChildren().addAll(titleRow, title3);

        Label subHero = new Label("Experience the future of fitness. FitVerse uses biometric synchronization and real-time AI mentoring to craft a training regimen that evolves with every heartbeat.");
        subHero.setWrapText(true);
        subHero.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 16px; -fx-line-spacing: 5px;");

        HBox heroBtns = new HBox(20);
        Button getStartedBtn = new Button("GET STARTED");
        getStartedBtn.setStyle("-fx-background-color: #62ff96; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 30px; -fx-padding: 15px 35px; -fx-effect: dropshadow(three-pass-box, rgba(98,255,150,0.4), 20, 0, 0, 0);");
        getStartedBtn.setOnAction(e -> callBackAction.run());

        Button aiMentorBtn = new Button("🧠 AI MENTOR CTA");
        aiMentorBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-color: rgba(255,255,255,0.2); -fx-border-radius: 30px; -fx-padding: 14px 30px;");
        heroBtns.getChildren().addAll(getStartedBtn, aiMentorBtn);

        heroLeft.getChildren().addAll(badgeBox, titleBox, subHero, heroBtns);

        // Hero Right (Graphic Simulation)
        StackPane heroRight = new StackPane();
        heroRight.setPrefSize(450, 450);
        Rectangle graphicsBg = new Rectangle(450, 450, Color.web("#161a1d"));
        graphicsBg.setArcWidth(30); graphicsBg.setArcHeight(30);
        
        VBox floatCard = new VBox(5);
        floatCard.setStyle("-fx-background-color: rgba(0,0,0,0.6); -fx-background-radius: 12px; -fx-padding: 15px 20px; -fx-border-color: rgba(255,255,255,0.05); -fx-border-radius: 12px;");
        floatCard.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        Text fcTitle = new Text("REAL-TIME BIOMETRICS");
        fcTitle.setStyle("-fx-fill: #62ff96; -fx-font-size: 10px; -fx-font-weight: bold;");
        HBox fcValBox = new HBox(5);
        fcValBox.setAlignment(Pos.BASELINE_LEFT);
        Text fcVal = new Text("142"); fcVal.setStyle("-fx-fill: #ffffff; -fx-font-size: 28px; -fx-font-weight: bold;");
        Text fcUnit = new Text("BPM"); fcUnit.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        fcValBox.getChildren().addAll(fcVal, fcUnit);
        floatCard.getChildren().addAll(fcTitle, fcValBox);
        
        StackPane.setAlignment(floatCard, Pos.BOTTOM_LEFT);
        StackPane.setMargin(floatCard, new Insets(0, 0, 30, 30));
        heroRight.getChildren().addAll(graphicsBg, floatCard);

        heroSection.getChildren().addAll(heroLeft, heroRight);

        // --- B. STATS SECTION ---
        HBox statsSection = new HBox();
        statsSection.setAlignment(Pos.CENTER);
        statsSection.setStyle("-fx-padding: 40px 0;");
        
        Region sSp1 = new Region(); HBox.setHgrow(sSp1, Priority.ALWAYS);
        Region sSp2 = new Region(); HBox.setHgrow(sSp2, Priority.ALWAYS);
        Region sSp3 = new Region(); HBox.setHgrow(sSp3, Priority.ALWAYS);

        statsSection.getChildren().addAll(
            createStatItem("240", "GLOBAL GYMS"), sSp1,
            createStatItem("1.2", "ACTIVE ATHLETES (M)"), sSp2,
            createStatItem("98", "SUCCESS RATE (%)"), sSp3,
            createStatItem("50", "AI EXPERTS")
        );

        // --- C. FEATURES BENTO GRID ---
        VBox featuresSection = new VBox(40);
        featuresSection.setAlignment(Pos.CENTER);

        VBox fHeader = new VBox(10);
        fHeader.setAlignment(Pos.CENTER);
        Text fTitle = new Text("Precision Engineered Features");
        fTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");
        Text fSub = new Text("Designed for those who demand more from their tech. FitVerse bridges the gap\nbetween raw effort and data-driven results.");
        fSub.setTextAlignment(TextAlignment.CENTER);
        fSub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px; -fx-line-spacing: 4px;");
        fHeader.getChildren().addAll(fTitle, fSub);

        // Grid Rows
        HBox fRow1 = new HBox(20);
        VBox feat1 = createFeatureCard("📈", "Neural Workout Tracking", "Our proprietary AI analyzes your form via smartphone\ncamera, providing instant haptic feedback to prevent\ninjury and maximize gains.");
        HBox.setHgrow(feat1, Priority.ALWAYS);
        feat1.setPrefWidth(650);

        VBox feat2 = createFeatureCard("🧠", "AI Mentor", "24/7 access to your personal digital\ncoach. Nutrition, recovery, and\npsychological prep.");
        HBox.setHgrow(feat2, Priority.ALWAYS);
        
        // Add specific link to feat2
        Text f2Link = new Text("MEET YOUR MENTOR ➔");
        f2Link.setStyle("-fx-fill: #62ff96; -fx-font-size: 11px; -fx-font-weight: bold;");
        feat2.getChildren().add(f2Link);
        
        fRow1.getChildren().addAll(feat1, feat2);

        HBox fRow2 = new HBox(20);
        VBox feat3 = createFeatureCard("📅", "Smart Planner", "Schedules that adapt to your sleep\nquality and stress levels\nautomatically.");
        HBox.setHgrow(feat3, Priority.ALWAYS);
        
        VBox feat4 = createFeatureCard("", "Community Ecosystem", "Join exclusive leagues, compete in global challenges, and earn\nFitVerse tokens for hitting your personal bests.");
        HBox.setHgrow(feat4, Priority.ALWAYS);
        feat4.setPrefWidth(650);
        
        // Add fake avatars to feat4
        HBox avatars = new HBox(-10);
        avatars.setPadding(new Insets(10, 0, 0, 0));
        Circle av1 = new Circle(15, Color.web("#2a2d31")); av1.setStroke(Color.web("#1a1e22")); av1.setStrokeWidth(2);
        Circle av2 = new Circle(15, Color.web("#3a3d41")); av2.setStroke(Color.web("#1a1e22")); av2.setStrokeWidth(2);
        Circle av3 = new Circle(15, Color.web("#4a4d51")); av3.setStroke(Color.web("#1a1e22")); av3.setStrokeWidth(2);
        StackPane av4 = new StackPane();
        Circle av4Bg = new Circle(15, Color.web("#62ff96")); av4Bg.setStroke(Color.web("#1a1e22")); av4Bg.setStrokeWidth(2);
        Text av4Txt = new Text("+10k"); av4Txt.setStyle("-fx-fill: #000; -fx-font-size: 9px; -fx-font-weight: bold;");
        av4.getChildren().addAll(av4Bg, av4Txt);
        avatars.getChildren().addAll(av1, av2, av3, av4);
        feat4.getChildren().add(avatars);

        fRow2.getChildren().addAll(feat3, feat4);
        
        featuresSection.getChildren().addAll(fHeader, fRow1, fRow2);

        // --- D. TESTIMONIALS ---
        VBox testimonialsSection = new VBox(40);
        testimonialsSection.setAlignment(Pos.CENTER);

        Text tTitle = new Text("The Athlete's Word");
        tTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");

        HBox tRow = new HBox(20);
        tRow.getChildren().addAll(
            createTestimonialCard("\"FitVerse completely changed how I approach my marathon\nprep. The AI mentor's pacing suggestions were 99% accurate\nto my race day needs.\"", "Sarah Jenkins", "Ironman Competitor"),
            createTestimonialCard("\"The form-tracking camera is like having a personal trainer\n24/7. My squat depth has improved more in 2 months than in\nthe last 2 years.\"", "Marcus Thorne", "Elite Bodybuilder")
        );

        testimonialsSection.getChildren().addAll(tTitle, tRow);

        // --- E. PRICING ---
        VBox pricingSection = new VBox(40);
        pricingSection.setAlignment(Pos.CENTER);

        VBox pHeader = new VBox(10);
        pHeader.setAlignment(Pos.CENTER);
        Text pTitle = new Text("Choose Your Level");
        pTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");
        Text pSub = new Text("Precision coaching for every stage of your journey.");
        pSub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        pHeader.getChildren().addAll(pTitle, pSub);

        HBox pRow = new HBox(20);
        pRow.setAlignment(Pos.CENTER);
        
        VBox plan1 = createPricingCard("STARTER", "19", false, "Unlimited Workout Logging", "Basic Biometric Analysis", "✕ AI Real-time Form Tracking", "START FREE TRIAL");
        VBox plan2 = createPricingCard("PROFESSIONAL", "49", true, "Neural Workout Form Tracking", "Advanced AI Mentor Access", "Adaptive Recovery Planning", "GET PRO ACCESS");
        VBox plan3 = createPricingCard("ELITE", "99", false, "1-on-1 Pro Human Consultation", "Custom Bio-Sensor Integration", "Exclusive Global Gym Access", "JOIN ELITE");
        
        pRow.getChildren().addAll(plan1, plan2, plan3);
        pricingSection.getChildren().addAll(pHeader, pRow);

        // --- F. FAQ ---
        VBox faqSection = new VBox(40);
        faqSection.setAlignment(Pos.CENTER);
        faqSection.setMaxWidth(800);

        Text faqTitle = new Text("Questions?");
        faqTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 32px; -fx-font-weight: bold;");

        VBox faqList = new VBox(15);
        faqList.getChildren().addAll(
            createFaqItem("How does the camera-tracking work?"),
            createFaqItem("Can I sync my existing wearables?"),
            createFaqItem("What makes the AI mentor \"Mentor-grade\"?")
        );

        faqSection.getChildren().addAll(faqTitle, faqList);

        // Assembly
        contentWrapper.getChildren().addAll(heroSection, statsSection, featuresSection, testimonialsSection, pricingSection, faqSection);
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
        Text fLogo = new Text("FitVerse AI");
        fLogo.setStyle("-fx-fill: #62ff96; -fx-font-size: 18px; -fx-font-weight:bold;");
        Text fCopy = new Text("© 2024 FitVerse AI. All rights reserved.");
        fCopy.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px;");
        fLogoBox.getChildren().addAll(fLogo, fCopy);
        
        Region fSpacer1 = new Region();
        HBox.setHgrow(fSpacer1, Priority.ALWAYS);
        
        HBox fLinks = new HBox(30);
        fLinks.setAlignment(Pos.CENTER);
        String[] links = {"Privacy Policy", "Terms of Service", "Contact", "About"};
        for(String l : links) {
            Text t = new Text(l);
            t.setStyle("-fx-fill: #ffffff; -fx-font-size: 11px; -fx-font-weight: bold;");
            fLinks.getChildren().add(t);
        }

        Region fSpacer2 = new Region();
        HBox.setHgrow(fSpacer2, Priority.ALWAYS);

        Button langBtn = new Button("🌐");
        langBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-border-color: #2a2d31; -fx-border-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px;");
        Button shareBtn = new Button("🔗");
        shareBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-border-color: #2a2d31; -fx-border-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px;");
        HBox fIcons = new HBox(15, langBtn, shareBtn);

        footer.getChildren().addAll(fLogoBox, fSpacer1, fLinks, fSpacer2, fIcons);
        borderPane.setBottom(footer);

        landingScene = new Scene(borderPane, 1400, 900);
        return landingScene;
    }

    // --- Helper Methods ---

    private Text createTopNavLink(String text, boolean isActive) {
        Text link = new Text(text);
        if (isActive) {
            link.setStyle("-fx-fill: #62ff96; -fx-font-size: 13px; -fx-font-weight: bold; -fx-underline: true;");
        } else {
            link.setStyle("-fx-fill: #e1e2e4; -fx-font-size: 13px;");
        }
        return link;
    }

    private VBox createStatItem(String val, String label) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        Text vTxt = new Text(val);
        vTxt.setStyle("-fx-fill: #62ff96; -fx-font-size: 36px; -fx-font-weight: bold;");
        Text lTxt = new Text(label);
        lTxt.setStyle("-fx-fill: #8a8d91; -fx-font-size: 10px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        box.getChildren().addAll(vTxt, lTxt);
        return box;
    }

    private VBox createFeatureCard(String iconStr, String title, String desc) {
        VBox card = new VBox(15);
        card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 30px; -fx-background-radius: 20px; -fx-border-color: #2a2d31; -fx-border-radius: 20px;");
        
        if (!iconStr.isEmpty()) {
            Text icon = new Text(iconStr);
            icon.setStyle("-fx-font-size: 24px; -fx-fill: #62ff96;");
            card.getChildren().add(icon);
        }

        Text tNode = new Text(title);
        tNode.setStyle("-fx-fill: #ffffff; -fx-font-size: 20px; -fx-font-weight: bold;");
        Label dNode = new Label(desc);
        dNode.setWrapText(true);
        dNode.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 13px; -fx-line-spacing: 4px;");

        card.getChildren().addAll(tNode, dNode);
        return card;
    }

    private VBox createTestimonialCard(String quote, String name, String role) {
        VBox card = new VBox(20);
        HBox.setHgrow(card, Priority.ALWAYS);
        card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 30px; -fx-background-radius: 20px; -fx-border-color: #2a2d31; -fx-border-radius: 20px;");
        
        Text stars = new Text("★★★★★");
        stars.setStyle("-fx-fill: #62ff96; -fx-font-size: 16px;");

        Label qLbl = new Label(quote);
        qLbl.setWrapText(true);
        qLbl.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 14px; -fx-font-style: italic; -fx-line-spacing: 5px;");

        HBox userBox = new HBox(15);
        userBox.setAlignment(Pos.CENTER_LEFT);
        Circle avatar = new Circle(20, Color.web("#2a2d31"));
        VBox userTexts = new VBox(2);
        Text nTxt = new Text(name); nTxt.setStyle("-fx-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold;");
        Text rTxt = new Text(role); rTxt.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px;");
        userTexts.getChildren().addAll(nTxt, rTxt);
        userBox.getChildren().addAll(avatar, userTexts);

        card.getChildren().addAll(stars, qLbl, userBox);
        return card;
    }

    private VBox createPricingCard(String plan, String price, boolean isPro, String f1, String f2, String f3, String btnTxt) {
        VBox card = new VBox(25);
        HBox.setHgrow(card, Priority.ALWAYS);
        
        if (isPro) {
            card.setStyle("-fx-background-color: #161a1d; -fx-padding: 40px 30px; -fx-background-radius: 20px; -fx-border-color: #00e676; -fx-border-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,230,118,0.1), 30, 0, 0, 0);");
        } else {
            card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 40px 30px; -fx-background-radius: 20px; -fx-border-color: #2a2d31; -fx-border-radius: 20px;");
        }

        StackPane topArea = new StackPane();
        topArea.setAlignment(Pos.TOP_LEFT);
        
        VBox headers = new VBox(5);
        Text pTxt = new Text(plan);
        pTxt.setStyle("-fx-fill: " + (isPro ? "#62ff96" : "#8a8d91") + "; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        
        HBox priceBox = new HBox(5);
        priceBox.setAlignment(Pos.BASELINE_LEFT);
        Text dollar = new Text("$" + price);
        dollar.setStyle("-fx-fill: #ffffff; -fx-font-size: 42px; -fx-font-weight: bold;");
        Text mo = new Text("/month");
        mo.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        priceBox.getChildren().addAll(dollar, mo);
        
        headers.getChildren().addAll(pTxt, priceBox);
        topArea.getChildren().add(headers);

        if (isPro) {
            Text badge = new Text("MOST POPULAR");
            badge.setStyle("-fx-fill: #000; -fx-font-size: 8px; -fx-font-weight: bold;");
            StackPane badgePane = new StackPane(badge);
            badgePane.setStyle("-fx-background-color: #00e676; -fx-padding: 3px 10px; -fx-background-radius: 10px;");
            badgePane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
            StackPane.setAlignment(badgePane, Pos.TOP_CENTER);
            StackPane.setMargin(badgePane, new Insets(-50, 0, 0, 0));
            topArea.getChildren().add(badgePane);
        }

        VBox features = new VBox(15);
        features.getChildren().addAll(
            createPriceFeature(f1, isPro, false),
            createPriceFeature(f2, isPro, false),
            createPriceFeature(f3, isPro, f3.startsWith("✕"))
        );

        Region pSpacer = new Region();
        VBox.setVgrow(pSpacer, Priority.ALWAYS);

        Button actBtn = new Button(btnTxt);
        actBtn.setMaxWidth(Double.MAX_VALUE);
        if (isPro) {
            actBtn.setStyle("-fx-background-color: #62ff96; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 12px; -fx-background-radius: 30px; -fx-padding: 15px;");
        } else {
            actBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-border-color: rgba(255,255,255,0.2); -fx-border-radius: 30px; -fx-padding: 15px;");
        }

        card.getChildren().addAll(topArea, features, pSpacer, actBtn);
        return card;
    }

    private HBox createPriceFeature(String text, boolean isPro, boolean disabled) {
        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER_LEFT);
        Text icon = new Text(disabled ? "" : "✔");
        icon.setStyle("-fx-fill: #62ff96; -fx-font-size: 14px;");
        Text txt = new Text(text.replace("✕ ", ""));
        txt.setStyle("-fx-fill: " + (disabled ? "#5a5d61" : "#ffffff") + "; -fx-font-size: 13px;");
        box.getChildren().addAll(icon, txt);
        return box;
    }

    private VBox createFaqItem(String question) {
        VBox box = new VBox(15);
        box.setStyle("-fx-border-color: transparent transparent rgba(255,255,255,0.1) transparent; -fx-border-width: 0 0 1px 0; -fx-padding: 0 0 20px 0;");
        
        HBox qRow = new HBox();
        qRow.setAlignment(Pos.CENTER_LEFT);
        Text qTxt = new Text(question);
        qTxt.setStyle("-fx-fill: #ffffff; -fx-font-size: 16px;");
        Region qSp = new Region();
        HBox.setHgrow(qSp, Priority.ALWAYS);
        Text plus = new Text("+");
        plus.setStyle("-fx-fill: #ffffff; -fx-font-size: 24px;");
        qRow.getChildren().addAll(qTxt, qSp, plus);

        box.getChildren().add(qRow);
        return box;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Runnable dummyCallback = () -> {
            System.out.println("Navigation triggered...");
        };
        
        stage.setScene(getLandingScene(dummyCallback));
        stage.setTitle("FitVerse AI - Engineering the Athlete of Tomorrow");
        stage.show();
    }
}
package com.visionx.view.user_login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlatformOverviewView extends Application {

    private Scene overviewScene;

    public Scene getPlatformOverviewScene(Runnable callBackAction) {

        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color : #111415;");

        // ==========================================
        // 1. LEFT SIDEBAR
        // ==========================================
        VBox sidebar = new VBox(25);
        sidebar.setPrefWidth(250);
        sidebar.setStyle("-fx-background-color : #15181a; -fx-padding: 30px 20px 20px 20px; -fx-border-color: #2a2d31; -fx-border-width: 0 1 0 0;");

        Text logoTxt = new Text("FitVerse AI");
        logoTxt.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-fill: #62ff96;");
        
        VBox navMenu = new VBox(5);
        navMenu.getChildren().addAll(
            createNavButton("Dashboard", true), // Active
            createNavButton("Analytics", false),
            createNavButton("AI Mentor", false),
            createNavButton("Planner", false),
            createNavButton("Find Gym", false),
            createNavButton("Settings", false)
        );

        Region sideSpacer = new Region();
        VBox.setVgrow(sideSpacer, Priority.ALWAYS);

        // Upgrade Card
        VBox upgradeCard = new VBox(10);
        upgradeCard.setStyle("-fx-background-color: #1a1e22; -fx-padding: 20px; -fx-background-radius: 12px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");
        Text upgSub = new Text("FitVerse AI");
        upgSub.setStyle("-fx-fill: #8a8d91; -fx-font-size: 10px;");
        Text upgTitle = new Text("Pro Athlete Account");
        upgTitle.setStyle("-fx-fill: #62ff96; -fx-font-size: 12px; -fx-font-weight: bold;");
        Button upgBtn = new Button("Upgrade to Pro");
        upgBtn.setStyle("-fx-background-color: #62ff96; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 11px; -fx-background-radius: 20px; -fx-padding: 8px;");
        upgBtn.setMaxWidth(Double.MAX_VALUE);
        upgradeCard.getChildren().addAll(upgSub, upgTitle, upgBtn);

        // Profile Box
        HBox profileBox = new HBox(12);
        profileBox.setAlignment(Pos.CENTER_LEFT);
        profileBox.setStyle("-fx-padding: 10px 0 0 0;");
        Circle avatar = new Circle(16, Color.web("#2a2d31"));
        VBox pTexts = new VBox(2);
        Text pName = new Text("Admin User");
        pName.setStyle("-fx-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold;");
        Text pRole = new Text("System Manager");
        pRole.setStyle("-fx-fill: #8a8d91; -fx-font-size: 10px;");
        pTexts.getChildren().addAll(pName, pRole);
        profileBox.getChildren().addAll(avatar, pTexts);

        sidebar.getChildren().addAll(logoTxt, navMenu, sideSpacer, upgradeCard, profileBox);
        mainLayout.setLeft(sidebar);

        // ==========================================
        // 2. RIGHT CONTENT AREA (Header + Scrollable Dashboard)
        // ==========================================
        BorderPane contentArea = new BorderPane();

        // --- Header ---
        HBox header = new HBox(30);
        header.setStyle("-fx-padding: 25px 40px; -fx-border-color: #2a2d31 transparent #2a2d31 transparent; -fx-border-width: 0 0 1px 0; -fx-background-color: #111415;");
        header.setAlignment(Pos.CENTER_LEFT);

        Text headerTitle = new Text("Platform Overview");
        headerTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: #ffffff;");

        Region hSpacer = new Region();
        HBox.setHgrow(hSpacer, Priority.ALWAYS);

        TextField searchField = new TextField();
        searchField.setPromptText("🔍 Search systems...");
        searchField.setStyle("-fx-background-color: #212428; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-padding: 10px 15px; -fx-background-radius: 20px; -fx-pref-width: 250px;");

        Button notifBtn = new Button("🔔");
        notifBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");
        Button settingsBtn = new Button("⚙");
        settingsBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");

        header.getChildren().addAll(headerTitle, hSpacer, searchField, notifBtn, settingsBtn);
        contentArea.setTop(header);

        // --- Dashboard Content (Scrollable) ---
        VBox dashboard = new VBox(25);
        dashboard.setStyle("-fx-padding: 40px; -fx-background-color: #111415;");
        dashboard.setMaxWidth(1200);

        // 1. KPI Row
        HBox kpiRow = new HBox(25);
        kpiRow.getChildren().addAll(
            createKpiCard("👥", "+12.4% ↑", "Total Users", "1,284,930", false),
            createKpiCard("💵", "+24.8% ↑", "Total Revenue", "$12,490,200", false),
            createKpiCard("⚡", "● Live", "Active Sessions", "42,105", true)
        );

        // 2. Charts Row
        HBox chartsRow = new HBox(25);
        chartsRow.getChildren().addAll(
            createUserGrowthChart(),
            createRevenueChart()
        );

        // 3. Managed Products Table
        VBox productsTable = createTableCard("Managed Products", "Oversee marketplace inventory and AI training packs.", "+ Add Product", true);
        
        // 4. Affiliated Gyms Table
        VBox gymsTable = createTableCard("Affiliated Gyms", "Global network tracking and partnership status.", "+ Register Gym", false);

        dashboard.getChildren().addAll(kpiRow, chartsRow, productsTable, gymsTable);

        ScrollPane scrollPane = new ScrollPane(dashboard);
        scrollPane.setStyle("-fx-background: #111415; -fx-border-color: transparent;");
        scrollPane.setFitToWidth(true);
        contentArea.setCenter(scrollPane);

        mainLayout.setCenter(contentArea);

        // ==========================================
        // 3. FOOTER
        // ==========================================
        HBox footer = new HBox();
        footer.setStyle("-fx-padding: 25px 40px; -fx-background-color: #0c0e0f; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 1px 0 0 0;");
        footer.setAlignment(Pos.CENTER_LEFT);
        
        VBox fLogoBox = new VBox(5);
        Text fLogo = new Text("FitVerse");
        fLogo.setStyle("-fx-fill: #62ff96; -fx-font-size: 18px; -fx-font-weight:bold;");
        Text fCopy = new Text("© 2024 FitVerse AI. All rights reserved.");
        fCopy.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px;");
        fLogoBox.getChildren().addAll(fLogo, fCopy);
        
        Region fSpacer = new Region();
        HBox.setHgrow(fSpacer, Priority.ALWAYS);
        
        HBox fLinks = new HBox(25);
        fLinks.setAlignment(Pos.CENTER);
        String[] links = {"Privacy Policy", "Terms of Service", "Contact", "About"};
        for(String l : links) {
            Text t = new Text(l);
            t.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px; -fx-font-weight: bold;");
            fLinks.getChildren().add(t);
        }
        footer.getChildren().addAll(fLogoBox, fSpacer, fLinks);
        
        mainLayout.setBottom(footer);

        overviewScene = new Scene(mainLayout, 1400, 900);
        return overviewScene;
    }

    // --- High-Fidelity UI Components ---

    private Button createNavButton(String text, boolean isActive) {
        Button btn = new Button("   " + text);
        btn.setPrefWidth(Double.MAX_VALUE);
        btn.setAlignment(Pos.CENTER_LEFT);
        if (isActive) {
            btn.setStyle("-fx-background-color: rgba(98,255,150,0.1); -fx-text-fill: #62ff96; -fx-font-size: 14px; -fx-font-weight:bold; -fx-padding: 12px 15px; -fx-border-color: #62ff96; -fx-border-width: 0 4px 0 0;");
        } else {
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 14px; -fx-padding: 12px 15px;");
        }
        return btn;
    }

    private VBox createKpiCard(String iconStr, String trendStr, String title, String value, boolean isLive) {
        VBox card = new VBox(20);
        HBox.setHgrow(card, Priority.ALWAYS);
        card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 25px; -fx-background-radius: 12px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");

        HBox topRow = new HBox();
        StackPane iconBg = new StackPane();
        Rectangle bgRect = new Rectangle(40, 40, Color.web("rgba(98,255,150,0.1)"));
        bgRect.setArcWidth(10); bgRect.setArcHeight(10);
        Text icon = new Text(iconStr);
        icon.setStyle("-fx-font-size: 18px;");
        iconBg.getChildren().addAll(bgRect, icon);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Text trend = new Text(trendStr);
        trend.setStyle("-fx-fill: #62ff96; -fx-font-size: 11px; -fx-font-weight: bold;");
        if (isLive) {
            trend.setStyle("-fx-fill: #62ff96; -fx-font-size: 12px; -fx-font-weight: bold;");
        }

        topRow.getChildren().addAll(iconBg, spacer, trend);

        VBox bottomRow = new VBox(5);
        Text tNode = new Text(title);
        tNode.setStyle("-fx-fill: #8a8d91; -fx-font-size: 13px;");
        Text vNode = new Text(value);
        vNode.setStyle("-fx-fill: #ffffff; -fx-font-size: 26px; -fx-font-weight: bold;");
        bottomRow.getChildren().addAll(tNode, vNode);

        card.getChildren().addAll(topRow, bottomRow);
        return card;
    }

    private VBox createUserGrowthChart() {
        VBox card = new VBox(15);
        HBox.setHgrow(card, Priority.ALWAYS);
        card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 25px; -fx-background-radius: 12px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");

        HBox header = new HBox();
        Text title = new Text("User Growth (Last 30 Days)");
        title.setStyle("-fx-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold;");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Text legend = new Text("● Active Users");
        legend.setStyle("-fx-fill: #62ff96; -fx-font-size: 11px;");
        header.getChildren().addAll(title, spacer, legend);

        // Simulated Chart Area
        StackPane chartArea = new StackPane();
        chartArea.setPrefHeight(120);
        chartArea.setAlignment(Pos.BOTTOM_CENTER);

        // Chart Fill Gradient
        Polygon fillPoly = new Polygon();
        fillPoly.getPoints().addAll(new Double[]{
            0.0, 100.0,
            100.0, 80.0,
            200.0, 100.0,
            300.0, 20.0,
            400.0, 40.0,
            400.0, 120.0,
            0.0, 120.0
        });
        LinearGradient fillGrad = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, 
            new Stop(0, Color.web("rgba(98,255,150,0.5)")), 
            new Stop(1, Color.web("rgba(98,255,150,0.0)")));
        fillPoly.setFill(fillGrad);

        // Chart Line
        QuadCurve line1 = new QuadCurve(0, 100, 50, 90, 100, 80);
        QuadCurve line2 = new QuadCurve(100, 80, 150, 70, 200, 100);
        QuadCurve line3 = new QuadCurve(200, 100, 250, 130, 300, 20);
        QuadCurve line4 = new QuadCurve(300, 20, 350, -40, 400, 40);
        HBox lines = new HBox(line1, line2, line3, line4); // Simplified representation
        lines.setStyle("-fx-stroke: #62ff96; -fx-stroke-width: 2px; -fx-fill: transparent;");

        chartArea.getChildren().addAll(fillPoly);
        card.getChildren().addAll(header, chartArea);
        return card;
    }

    private VBox createRevenueChart() {
        VBox card = new VBox(15);
        HBox.setHgrow(card, Priority.ALWAYS);
        card.setStyle("-fx-background-color: #1a1e22; -fx-padding: 25px; -fx-background-radius: 12px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");

        HBox header = new HBox();
        Text title = new Text("Revenue streams");
        title.setStyle("-fx-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold;");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        ComboBox<String> filter = new ComboBox<>();
        filter.getItems().addAll("Subscriptions", "Marketplace");
        filter.getSelectionModel().selectFirst();
        filter.setStyle("-fx-background-color: #111415; -fx-text-fill: #ffffff; -fx-font-size: 11px; -fx-border-color: #2a2d31; -fx-border-radius: 6px; -fx-background-radius: 6px;");
        header.getChildren().addAll(title, spacer, filter);

        // Simulated Bar Chart
        HBox bars = new HBox(15);
        bars.setAlignment(Pos.BOTTOM_CENTER);
        bars.setPrefHeight(120);
        
        int[] heights = {40, 60, 90, 50, 80, 55};
        for (int h : heights) {
            Rectangle bar = new Rectangle(35, h);
            bar.setArcWidth(8); bar.setArcHeight(8);
            bar.setFill(Color.web("rgba(98,255,150,0.3)"));
            if (h == 90) { // Active/Highlight bar
                bar.setFill(Color.web("#62ff96"));
            }
            bars.getChildren().add(bar);
        }

        card.getChildren().addAll(header, bars);
        return card;
    }

    private VBox createTableCard(String title, String subtitle, String btnText, boolean isProductTable) {
        VBox card = new VBox();
        card.setStyle("-fx-background-color: #1a1e22; -fx-background-radius: 12px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");

        // Header
        HBox header = new HBox();
        header.setStyle("-fx-padding: 20px 25px; -fx-border-color: #2a2d31 transparent #2a2d31 transparent; -fx-border-width: 0 0 1px 0;");
        header.setAlignment(Pos.CENTER_LEFT);
        
        VBox texts = new VBox(3);
        Text tNode = new Text(title);
        tNode.setStyle("-fx-fill: #ffffff; -fx-font-size: 14px; -fx-font-weight: bold;");
        Text sNode = new Text(subtitle);
        sNode.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px;");
        texts.getChildren().addAll(tNode, sNode);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button actBtn = new Button(btnText);
        actBtn.setStyle("-fx-background-color: rgba(98,255,150,0.1); -fx-text-fill: #62ff96; -fx-border-color: rgba(98,255,150,0.3); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-padding: 8px 15px; -fx-font-size: 11px;");
        header.getChildren().addAll(texts, spacer, actBtn);

        // Table
        VBox tableContent = new VBox();
        
        if (isProductTable) {
            tableContent.getChildren().addAll(
                createTableHeader("Product Name", "Category", "Price", "Stock", "Status", "Action"),
                createProductRow("🏋", "Hyper-Growth Pack", "Training Program", "$49.99", "∞", "ACTIVE", true),
                createProductRow("📱", "AI Diet Optimizer", "SaaS Tool", "$12.00/mo", "Digital", "ACTIVE", true)
            );
        } else {
            tableContent.getChildren().addAll(
                createTableHeader("Gym Facility", "Location", "Active Members", "Revenue Share", "Compliance", "Action"),
                createGymRow("🏢", "Nexus Performance Center", "Tokyo, JP", "4,500", "15%", "VERIFIED", true),
                createGymRow("🏢", "Vertex Elite Fitness", "New York, US", "2,920", "12%", "PENDING REVIEW", false)
            );
        }

        card.getChildren().addAll(header, tableContent);
        return card;
    }

    private HBox createTableHeader(String... headers) {
        HBox row = new HBox();
        row.setStyle("-fx-padding: 15px 25px; -fx-background-color: rgba(255,255,255,0.02);");
        for (int i = 0; i < headers.length; i++) {
            Text th = new Text(headers[i]);
            th.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px; -fx-font-weight: bold;");
            HBox cell = new HBox(th);
            cell.setAlignment(i == headers.length - 1 ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);
            HBox.setHgrow(cell, Priority.ALWAYS);
            cell.setPrefWidth(120);
            row.getChildren().add(cell);
        }
        return row;
    }

    private HBox createProductRow(String icon, String name, String category, String price, String stock, String status, boolean isStatusGreen) {
        HBox row = new HBox();
        row.setStyle("-fx-padding: 15px 25px; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 1px 0 0 0;");
        row.setAlignment(Pos.CENTER_LEFT);

        // Name Col
        HBox nameCol = new HBox(10);
        nameCol.setAlignment(Pos.CENTER_LEFT);
        nameCol.setPrefWidth(120); HBox.setHgrow(nameCol, Priority.ALWAYS);
        StackPane iconBg = new StackPane();
        Rectangle bgRect = new Rectangle(28, 28, Color.web("#212428"));
        bgRect.setArcWidth(6); bgRect.setArcHeight(6);
        Text iconTxt = new Text(icon); iconTxt.setStyle("-fx-fill: #8a8d91; -fx-font-size: 14px;");
        iconBg.getChildren().addAll(bgRect, iconTxt);
        Text nameTxt = new Text(name); nameTxt.setStyle("-fx-fill: #ffffff; -fx-font-size: 12px;");
        nameCol.getChildren().addAll(iconBg, nameTxt);

        row.getChildren().add(nameCol);
        row.getChildren().add(createCell(category, 120));
        row.getChildren().add(createCell(price, 120));
        row.getChildren().add(createCell(stock, 120));

        // Status Col
        HBox statusCol = new HBox();
        statusCol.setAlignment(Pos.CENTER_LEFT);
        statusCol.setPrefWidth(120); HBox.setHgrow(statusCol, Priority.ALWAYS);
        Text statusTxt = new Text(status);
        if (isStatusGreen) {
            statusTxt.setStyle("-fx-fill: #62ff96; -fx-background-color: rgba(98,255,150,0.1); -fx-padding: 4px 8px; -fx-background-radius: 12px; -fx-font-size: 9px; -fx-font-weight: bold;");
        } else {
            statusTxt.setStyle("-fx-fill: #ffb74d; -fx-background-color: rgba(255,183,77,0.1); -fx-padding: 4px 8px; -fx-background-radius: 12px; -fx-font-size: 9px; -fx-font-weight: bold;");
        }
        statusCol.getChildren().add(statusTxt);
        row.getChildren().add(statusCol);

        // Action Col
        HBox actionCol = new HBox();
        actionCol.setAlignment(Pos.CENTER_RIGHT);
        actionCol.setPrefWidth(120); HBox.setHgrow(actionCol, Priority.ALWAYS);
        Button dotsBtn = new Button("⋮");
        dotsBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px; -fx-font-weight: bold;");
        actionCol.getChildren().add(dotsBtn);
        row.getChildren().add(actionCol);

        return row;
    }

    private HBox createGymRow(String icon, String name, String loc, String members, String revShare, String status, boolean isStatusGreen) {
        // Reuse product row structure since they align perfectly
        return createProductRow(icon, name, loc, members, revShare, status, isStatusGreen);
    }

    private HBox createCell(String text, double prefWidth) {
        HBox cell = new HBox();
        cell.setAlignment(Pos.CENTER_LEFT);
        cell.setPrefWidth(prefWidth);
        HBox.setHgrow(cell, Priority.ALWAYS);
        Text txt = new Text(text);
        txt.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        cell.getChildren().add(txt);
        return cell;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Runnable navCallback = () -> {
            System.out.println("Navigation triggered...");
        };
        
        stage.setScene(getPlatformOverviewScene(navCallback));
        stage.setTitle("FitVerse AI - Platform Overview");
        stage.show();
    }
}
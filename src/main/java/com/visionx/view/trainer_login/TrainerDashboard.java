package com.visionx.view.trainer_login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import com.visionx.view.SplashScreen;

public class TrainerDashboard {

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String CARD_BG = "#07110d";
    private final String SURFACE = "#020914";
    private final String SURFACE_BORDER = "#24332a";

    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DARK = "#163b2a";

    private final String TEXT_MAIN = "#f1f6f1";
    private final String TEXT_MUTED = "#9caf9f";
    private final String ERROR = "#ffb4ab";

    private final String BORDER =
            "rgba(255,255,255,0.09)";

    private final DropShadow primaryGlow =
            new DropShadow(
                    18,
                    Color.web(PRIMARY, 0.18)
            );

    // =========================================================
    // MAIN
    // =========================================================

//     private Stage primaryStage;
    private Scene trainerDashboardScene;

    private BorderPane mainLayout;

    private BorderPane contentShell;

    private String activePage = "Dashboard";

    private final Map<String, HBox> navItems =
            new HashMap<>();

    private final Map<String, Node> pageCache =
            new HashMap<>();

    // =========================================================
    // START
    // =========================================================

    public Scene getTrainerDashboardScene(Runnable callRunnable) {



        // primaryStage = stage;

        mainLayout = new BorderPane();

        mainLayout.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = createSidebar();

        // =====================================================
        // HEADER
        // =====================================================

        HBox header = createHeader();

        // =====================================================
        // CENTER
        // =====================================================

        contentShell = new BorderPane();

        contentShell.setTop(header);

        contentShell.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";"
        );

        mainLayout.setLeft(sidebar);
        mainLayout.setCenter(contentShell);

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene =
                new Scene(
                        mainLayout,
                        SplashScreen.primaryStage.getWidth(),
                        SplashScreen.primaryStage.getHeight()
                );

        // primaryStage.setTitle(
        //         "FITNEESFREAK - Trainer Dashboard"
        // );

        // primaryStage.setScene(scene);

        SplashScreen.primaryStage.setMaximized(true);

        // primaryStage.show();

        showDashboard();

        return scene;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createHeader() {

        HBox header = new HBox();

        header.setPadding(
                new Insets(
                        0,
                        32,
                        0,
                        36
                )
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setPrefHeight(76);

        header.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-width: 0 0 1 0;"
        );

        Label search =
                new Label(
                        "Search clients, plans, sessions..."
                );

        search.setPrefWidth(330);

        search.setPadding(
                new Insets(
                        11,
                        16,
                        11,
                        16
                )
        );

        search.setStyle(
                "-fx-background-color: rgba(255,255,255,0.035);" +
                "-fx-border-color: rgba(255,255,255,0.10);" +
                "-fx-border-radius: 11;" +
                "-fx-background-radius: 11;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button notification =
                createHeaderButton("🔔");

        notification.setOnAction(
                e -> setCenter(
                        extractCenterContent(
                                new Notifications().getNotificationsScene(
                                        this::showDashboard,
                                        this::showMyClients,
                                        this::showClientRequests,
                                        this::showWorkoutPlans,
                                        this::showChatbox,
                                        this::showSchedule,
                                        this::showEarnings,
                                        this::showReviews,
                                        this::showProfile,
                                        this::logout
                                )
                        )
                )
        );

        Button settings =
                createHeaderButton("⚙");

        settings.setOnAction(
                e -> setCenter(
                        extractCenterContent(
                                new Settings().getSettingsScene(
                                        this::showDashboard
                                )
                        )
                )
        );

        Label profile =
                new Label("Alex Trainer");

        String profileNormal =
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 9 12 9 12;" +
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 9;" +
                "-fx-cursor: hand;";

        String profileHover =
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 9 12 9 12;" +
                "-fx-background-color: rgba(117,255,158,0.10);" +
                "-fx-border-color: rgba(117,255,158,0.28);" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-cursor: hand;";

        profile.setStyle(profileNormal);

        profile.setOnMouseEntered(
                e -> profile.setStyle(profileHover)
        );

        profile.setOnMouseExited(
                e -> profile.setStyle(profileNormal)
        );

        profile.setOnMouseClicked(
                e -> showProfile()
        );

        header.getChildren().addAll(
                search,
                spacer,
                notification,
                settings,
                profile
        );

        return header;
    }

    // =========================================================
    // HEADER BUTTON
    // =========================================================

    private Button createHeaderButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setPrefSize(
                42,
                42
        );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 17px;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private VBox createSidebar() {

        VBox sidebar =
                new VBox();

        sidebar.setPrefWidth(307);
        sidebar.setMinWidth(307);

        sidebar.setStyle(
                "-fx-background-color: " +
                SURFACE +
                ";" +
                "-fx-border-color: transparent " +
                SURFACE_BORDER +
                " transparent transparent;"
        );

        sidebar.setPadding(
                new Insets(
                        24,
                        0,
                        0,
                        0
                )
        );

        // =====================================================
        // LOGO
        // =====================================================

        HBox logoBox =
                new HBox(12);

        logoBox.setAlignment(
                Pos.CENTER_LEFT
        );

        logoBox.setPadding(
                new Insets(
                        0,
                        16,
                        40,
                        16
                )
        );

        Label icon =
                new Label("🏋");

        icon.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 8;" +
                "-fx-background-radius: 8;"
        );

        icon.setEffect(primaryGlow);

        VBox logoText =
                new VBox();

        Label title =
                new Label("FitneesFreak");

        title.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label sub =
                new Label("PERSONAL TRAINER");

        sub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        logoText.getChildren().addAll(
                title,
                sub
        );

        logoBox.getChildren().addAll(
                icon,
                logoText
        );

        // =====================================================
        // NAVIGATION
        // =====================================================

        VBox nav =
                new VBox(4);

        nav.setPadding(
                new Insets(
                        0,
                        16,
                        0,
                        16
                )
        );

        nav.getChildren().addAll(

                createNavItem(
                        "📊",
                        "Dashboard",
                        true
                ),

                createNavItem(
                        "👥",
                        "My Clients",
                        false
                ),

                createNavItem(
                        "📩",
                        "Client Requests",
                        false
                ),

                createNavItem(
                        "🏋",
                        "Workout Plans",
                        false
                ),

                createNavItem(
                        "💬",
                        "Chatbox",
                        false
                ),

                createNavItem(
                        "📅",
                        "Schedule Manager",
                        false
                ),

                createNavItem(
                        "💰",
                        "Earnings",
                        false
                ),

                createNavItem(
                        "⭐",
                        "Reviews & Ratings",
                        false
                )
        );

        ScrollPane navScroll =
                new ScrollPane(nav);

        navScroll.setFitToWidth(true);

        navScroll.setStyle(
                "-fx-background: " +
                SURFACE +
                ";" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        navScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        navScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        VBox.setVgrow(
                navScroll,
                Priority.ALWAYS
        );

        // =====================================================
        // BOTTOM USER
        // =====================================================

        VBox bottom =
                new VBox(15);

        bottom.setPadding(
                new Insets(
                        24,
                        16,
                        24,
                        16
                )
        );

        bottom.setStyle(
                "-fx-border-color: " +
                SURFACE_BORDER +
                " transparent transparent transparent;"
        );

        HBox userBox =
                new HBox(12);

        userBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Label avatar =
                new Label("A");

        avatar.setAlignment(
                Pos.CENTER
        );

        avatar.setPrefSize(
                40,
                40
        );

        avatar.setStyle(
                "-fx-background-color: #163B2A;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 20;"
        );

        VBox userText =
                new VBox(2);

        Label userName =
                new Label("Alex Trainer");

        userName.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );

        Label userRole =
                new Label("TRAINER");

        userRole.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        userText.getChildren().addAll(
                userName,
                userRole
        );

        userBox.getChildren().addAll(
                avatar,
                userText
        );

        String userNormal =
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 7;" +
                "-fx-cursor: hand;";

        String userHover =
                "-fx-background-color: rgba(117,255,158,0.08);" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 7;" +
                "-fx-cursor: hand;";

        userBox.setStyle(userNormal);

        userBox.setOnMouseEntered(
                e -> userBox.setStyle(userHover)
        );

        userBox.setOnMouseExited(
                e -> userBox.setStyle(userNormal)
        );

        userBox.setOnMouseClicked(
                e -> showProfile()
        );

        Button logout =
                new Button("🚪 LOGOUT");

        logout.setMaxWidth(
                Double.MAX_VALUE
        );

        String logoutNormal =
                "-fx-background-color: rgba(255,180,171,0.05);" +
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 10;" +
                "-fx-cursor: hand;";

        String logoutHover =
                "-fx-background-color: rgba(255,180,171,0.10);" +
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 10;" +
                "-fx-cursor: hand;";

        addHoverEffect(
                logout,
                logoutNormal,
                logoutHover
        );

        logout.setOnAction(
                e -> logout()
        );

        bottom.getChildren().addAll(
                userBox,
                logout
        );

        sidebar.getChildren().addAll(
                logoBox,
                navScroll,
                bottom
        );

        return sidebar;
    }

    // =========================================================
    // NAV ITEM
    // =========================================================

    private HBox createNavItem(
            String icon,
            String title,
            boolean active
    ) {

        HBox box =
                new HBox(12);

        box.setAlignment(
                Pos.CENTER_LEFT
        );

        box.setPadding(
                new Insets(
                        10,
                        16,
                        10,
                        16
                )
        );

        box.setMaxWidth(
                Double.MAX_VALUE
        );

        String normalStyle =
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        String hoverStyle =
                "-fx-background-color: #132A20;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: #163B2A;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-font-size: 16px;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 13px;"
        );

        box.getChildren().addAll(
                iconLabel,
                titleLabel
        );

        navItems.put(
                title,
                box
        );

        if (active) {

            box.setStyle(activeStyle);

            titleLabel.setStyle(
                    "-fx-text-fill: " +
                    PRIMARY +
                    ";" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;"
            );

            activePage = title;

        } else {

            box.setStyle(normalStyle);
        }

        box.setOnMouseEntered(
                e -> {

                    if (!title.equals(activePage)) {
                        box.setStyle(hoverStyle);
                    }
                }
        );

        box.setOnMouseExited(
                e -> {

                    if (!title.equals(activePage)) {
                        box.setStyle(normalStyle);
                    }
                }
        );

        switch (title) {

            case "Dashboard":
                box.setOnMouseClicked(
                        e -> showDashboard()
                );
                break;

            case "My Clients":
                box.setOnMouseClicked(
                        e -> showMyClients()
                );
                break;

            case "Client Requests":
                box.setOnMouseClicked(
                        e -> showClientRequests()
                );
                break;

            case "Workout Plans":
                box.setOnMouseClicked(
                        e -> showWorkoutPlans()
                );
                break;

            case "Chatbox":
                box.setOnMouseClicked(
                        e -> showChatbox()
                );
                break;

            case "Schedule Manager":
                box.setOnMouseClicked(
                        e -> showSchedule()
                );
                break;

            case "Earnings":
                box.setOnMouseClicked(
                        e -> showEarnings()
                );
                break;

            case "Reviews & Ratings":
                box.setOnMouseClicked(
                        e -> showReviews()
                );
                break;
        }

        return box;
    }

    // =========================================================
    // ACTIVE NAV
    // =========================================================

    private void setActiveNavItem(
            String pageTitle
    ) {

        activePage = pageTitle;

        String normalStyle =
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: #163B2A;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        for (
                Map.Entry<String, HBox> entry :
                navItems.entrySet()
        ) {

            String title =
                    entry.getKey();

            HBox item =
                    entry.getValue();

            if (
                    item.getChildren().size() > 1 &&
                    item.getChildren().get(1) instanceof Label
            ) {

                Label titleLabel =
                        (Label) item.getChildren().get(1);

                if (title.equals(pageTitle)) {

                    item.setStyle(
                            activeStyle
                    );

                    titleLabel.setStyle(
                            "-fx-text-fill: " +
                            PRIMARY +
                            ";" +
                            "-fx-font-size: 13px;" +
                            "-fx-font-weight: bold;"
                    );

                } else {

                    item.setStyle(
                            normalStyle
                    );

                    titleLabel.setStyle(
                            "-fx-text-fill: " +
                            TEXT_MUTED +
                            ";" +
                            "-fx-font-size: 13px;"
                    );
                }
            }
        }
    }

    // =========================================================
    // HOVER
    // =========================================================

    private void addHoverEffect(
            Button button,
            String normalStyle,
            String hoverStyle
    ) {

        button.setStyle(
                normalStyle
        );

        button.setOnMouseEntered(
                e -> button.setStyle(hoverStyle)
        );

        button.setOnMouseExited(
                e -> button.setStyle(normalStyle)
        );
    }

    // =========================================================
    // CENTER
    // =========================================================

    private void setCenter(
            Node node
    ) {

        if (node == null) {
            return;
        }

        contentShell.setCenter(node);
    }

    // =========================================================
    // EXTRACT CENTER
    // =========================================================

    private Node extractCenterContent(
            Scene scene
    ) {

        if (
                scene == null ||
                scene.getRoot() == null
        ) {
            return null;
        }

        Node current =
                scene.getRoot();

        while (
                current instanceof BorderPane &&
                ((BorderPane) current).getCenter() != null
        ) {

            current =
                    ((BorderPane) current).getCenter();
        }

        return current;
    }

    // =========================================================
    // 🔥 UPDATED DASHBOARD
    // =========================================================

    private void showDashboard() {

        setActiveNavItem(
                "Dashboard"
        );

        Node cached =
                pageCache.get("Dashboard");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        // =====================================================
        // MAIN SCROLL
        // =====================================================

        VBox content =
                new VBox(20);

        content.setPadding(
                new Insets(
                        28,
                        34,
                        35,
                        34
                )
        );

        content.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";"
        );

        ScrollPane dashboardScroll =
                new ScrollPane(content);

        dashboardScroll.setFitToWidth(true);

        dashboardScroll.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-background: " +
                BG_COLOR +
                ";" +
                "-fx-border-color: transparent;"
        );

        dashboardScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        // =====================================================
        // WELCOME HEADER
        // =====================================================

        HBox welcomeRow =
                new HBox();

        welcomeRow.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox welcome =
                new VBox(5);

        Label welcomeTitle =
                new Label(
                        "Good Morning, Alex! 👋"
                );

        welcomeTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        Label welcomeSub =
                new Label(
                        "Here's what's happening with your training business today."
                );

        welcomeSub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 13px;"
        );

        welcome.getChildren().addAll(
                welcomeTitle,
                welcomeSub
        );

        Region welcomeSpacer =
                new Region();

        HBox.setHgrow(
                welcomeSpacer,
                Priority.ALWAYS
        );

        VBox dateBox =
                new VBox(2);

        dateBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label today =
                new Label("TODAY");

        today.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label date =
                new Label("Tuesday, 14 August");

        date.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;"
        );

        dateBox.getChildren().addAll(
                today,
                date
        );

        welcomeRow.getChildren().addAll(
                welcome,
                welcomeSpacer,
                dateBox
        );

        // =====================================================
        // STAT CARDS
        // =====================================================

        HBox statsRow =
                new HBox(14);

        VBox totalClients =
                createDashboardStatCard(
                        "TOTAL CLIENTS",
                        "28",
                        "↗ +4",
                        "this week",
                        "👥"
                );

        VBox todaysSessions =
                createDashboardStatCard(
                        "TODAY'S SESSIONS",
                        "05",
                        "↗ +2",
                        "this week",
                        "📅"
                );

        VBox upcoming =
                createDashboardStatCard(
                        "UPCOMING SESSIONS",
                        "03",
                        "Today",
                        "next sessions",
                        "⏱"
                );

        VBox earnings =
                createDashboardStatCard(
                        "MONTHLY EARNINGS",
                        "₹48,750",
                        "↗ +12.4%",
                        "vs last month",
                        "💰"
                );

        HBox.setHgrow(
                totalClients,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                todaysSessions,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                upcoming,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                earnings,
                Priority.ALWAYS
        );

        statsRow.getChildren().addAll(
                totalClients,
                todaysSessions,
                upcoming,
                earnings
        );

        // =====================================================
        // MAIN GRAPH CARD
        // =====================================================

        VBox graphCard =
                createLargeCard();

        HBox graphHeader =
                new HBox();

        VBox graphTitleBox =
                new VBox(3);

        Label graphTitle =
                new Label(
                        "Business Performance"
                );

        graphTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        Label graphSub =
                new Label(
                        "Monthly earnings overview"
                );

        graphSub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        graphTitleBox.getChildren().addAll(
                graphTitle,
                graphSub
        );

        Region graphSpacer =
                new Region();

        HBox.setHgrow(
                graphSpacer,
                Priority.ALWAYS
        );

        VBox graphAmount =
                new VBox(2);

        graphAmount.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label amount =
                new Label("₹48,750");

        amount.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        Label growth =
                new Label("↑ 12.4% growth");

        growth.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        graphAmount.getChildren().addAll(
                amount,
                growth
        );

        graphHeader.getChildren().addAll(
                graphTitleBox,
                graphSpacer,
                graphAmount
        );

        // =====================================================
        // LINE GRAPH
        // =====================================================

        CategoryAxis xAxis =
                new CategoryAxis();

        NumberAxis yAxis =
                new NumberAxis();

        xAxis.setLabel("");

        yAxis.setLabel("");

        xAxis.setTickLabelFill(
                Color.web(TEXT_MUTED)
        );

        yAxis.setTickLabelFill(
                Color.web(TEXT_MUTED)
        );

        xAxis.setTickMarkVisible(false);

        yAxis.setTickMarkVisible(false);

        yAxis.setMinorTickVisible(false);

        yAxis.setAutoRanging(false);

        yAxis.setLowerBound(0);

        yAxis.setUpperBound(7000);

        yAxis.setTickUnit(1000);

        LineChart<String, Number> chart =
                new LineChart<>(
                        xAxis,
                        yAxis
                );

        chart.setAnimated(false);

        chart.setCreateSymbols(true);

        chart.setLegendVisible(false);

        chart.setHorizontalGridLinesVisible(true);

        chart.setVerticalGridLinesVisible(false);

        chart.setAlternativeRowFillVisible(false);

        chart.setPrefHeight(270);

        chart.setMinHeight(250);

        chart.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-padding: 10 0 0 0;"
        );

        XYChart.Series<String, Number> series =
                new XYChart.Series<>();

        series.setName(
                "Earnings"
        );

        series.getData().add(
                new XYChart.Data<>(
                        "Jan",
                        2600
                )
        );

        series.getData().add(
                new XYChart.Data<>(
                        "Feb",
                        3400
                )
        );

        series.getData().add(
                new XYChart.Data<>(
                        "Mar",
                        3100
                )
        );

        series.getData().add(
                new XYChart.Data<>(
                        "Apr",
                        4700
                )
        );

        series.getData().add(
                new XYChart.Data<>(
                        "May",
                        5200
                )
        );

        series.getData().add(
                new XYChart.Data<>(
                        "Jun",
                        6420
                )
        );

        chart.getData().add(series);

        // Make graph visually green after it is rendered.
        chart.applyCss();

        graphCard.getChildren().addAll(
                graphHeader,
                chart
        );

        // =====================================================
        // SECOND ROW
        // =====================================================

        HBox secondRow =
                new HBox(16);

        secondRow.setAlignment(Pos.TOP_LEFT);

        VBox scheduleCard =
                createLargeCard();

        VBox scheduleTitleBox =
                new VBox(3);

        Label scheduleTitle =
                new Label(
                        "Today's Schedule"
                );

        scheduleTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label scheduleSub =
                new Label(
                        "Your training sessions for today"
                );

        scheduleSub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        scheduleTitleBox.getChildren().addAll(
                scheduleTitle,
                scheduleSub
        );

        scheduleCard.getChildren().add(
                scheduleTitleBox
        );

        scheduleCard.getChildren().addAll(

                createScheduleRow(
                        "09:00 AM",
                        "Rahul Mehta",
                        "Personal Training"
                ),

                createScheduleRow(
                        "11:00 AM",
                        "Priya Sharma",
                        "Weight Loss"
                ),

                createScheduleRow(
                        "01:00 PM",
                        "Aman Verma",
                        "Muscle Gain"
                ),

                createScheduleRow(
                        "04:00 PM",
                        "Neha Patil",
                        "Strength Training"
                )
        );

        Button fullSchedule =
                new Button(
                        "View Full Schedule →"
                );

        fullSchedule.setMaxWidth(
                Double.MAX_VALUE
        );

        fullSchedule.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        fullSchedule.setOnAction(
                e -> showSchedule()
        );

        scheduleCard.getChildren().add(
                fullSchedule
        );

        // =====================================================
        // CLIENT PROGRESS
        // =====================================================

        VBox progressCard =
                createLargeCard();

        // Keep the progress section visually balanced with the
        // schedule and activity cards without changing any
        // existing functionality.
        progressCard.setPrefHeight(280);
        progressCard.setMinHeight(280);

        Label progressTitle =
                new Label(
                        "Client Progress"
                );

        progressTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label progressSub =
                new Label(
                        "Your business goals this month"
                );

        progressSub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        progressCard.getChildren().addAll(
                progressTitle,
                progressSub
        );

        progressCard.getChildren().add(
                createProgressItem(
                        "Monthly Client Goal",
                        "28 / 35",
                        0.80
                )
        );

        progressCard.getChildren().add(
                createProgressItem(
                        "Completed Sessions",
                        "86 / 100",
                        0.86
                )
        );

        progressCard.getChildren().add(
                createProgressItem(
                        "Monthly Revenue",
                        "₹48.7K / ₹60K",
                        0.81
                )
        );

        // =====================================================
        // RECENT ACTIVITY
        // =====================================================

        VBox activityCard =
                createLargeCard();

        Label activityTitle =
                new Label(
                        "Recent Activity"
                );

        activityTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label activitySub =
                new Label(
                        "Latest updates from your clients"
                );

        activitySub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        activityCard.getChildren().addAll(
                activityTitle,
                activitySub
        );

        activityCard.getChildren().addAll(

                createActivityRow(
                        "Rahul completed Chest Day",
                        "30m ago"
                ),

                createActivityRow(
                        "New diet plan assigned to Priya",
                        "1h ago"
                ),

                createActivityRow(
                        "Aman's progress updated",
                        "2h ago"
                ),

                createActivityRow(
                        "Neha booked a new session",
                        "3h ago"
                )
        );

        Button allActivity =
                new Button(
                        "View All Activity →"
                );

        allActivity.setMaxWidth(
                Double.MAX_VALUE
        );

        allActivity.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        allActivity.setOnAction(
                e -> showSimpleContent(
                        "Recent Activity",
                        "All trainer activity will appear here."
                )
        );

        activityCard.getChildren().add(
                allActivity
        );

        HBox.setHgrow(
                scheduleCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                progressCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                activityCard,
                Priority.ALWAYS
        );

        secondRow.getChildren().addAll(
                scheduleCard,
                progressCard,
                activityCard
        );

        // =====================================================
        // QUICK ACTIONS
        // =====================================================

        VBox quickActions =
                createLargeCard();

        Label quickTitle =
                new Label(
                        "Quick Actions"
                );

        quickTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label quickSub =
                new Label(
                        "Frequently used trainer tools"
                );

        quickSub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        HBox actionRow =
                new HBox(12);

        Button addClient =
                createQuickAction(
                        "👤",
                        "Add Client"
                );

        addClient.setOnAction(
                e -> showMyClients()
        );

        Button workout =
                createQuickAction(
                        "🏋",
                        "Workout Plans"
                );

        workout.setOnAction(
                e -> showWorkoutPlans()
        );

        Button schedule =
                createQuickAction(
                        "📅",
                        "Schedule"
                );

        schedule.setOnAction(
                e -> showSchedule()
        );

        Button messages =
                createQuickAction(
                        "💬",
                        "Messages"
                );

        messages.setOnAction(
                e -> showChatbox()
        );

        HBox.setHgrow(
                addClient,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                workout,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                schedule,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                messages,
                Priority.ALWAYS
        );

        actionRow.getChildren().addAll(
                addClient,
                workout,
                schedule,
                messages
        );

        quickActions.getChildren().addAll(
                quickTitle,
                quickSub,
                actionRow
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        content.getChildren().addAll(
                welcomeRow,
                statsRow,
                graphCard,
                secondRow,
                quickActions
        );

        // =====================================================
        // CACHE
        // =====================================================

        pageCache.put(
                "Dashboard",
                dashboardScroll
        );

        setCenter(
                dashboardScroll
        );
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createDashboardStatCard(
            String title,
            String value,
            String change,
            String suffix,
            String icon
    ) {

        VBox card =
                new VBox(6);

        card.setPadding(
                new Insets(17)
        );

        card.setMinHeight(105);

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 12;"
        );

        HBox top =
                new HBox();

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-background-color: rgba(117,255,158,0.09);" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 6;" +
                "-fx-font-size: 13px;"
        );

        top.getChildren().addAll(
                titleLabel,
                spacer,
                iconLabel
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;"
        );

        HBox bottom =
                new HBox(6);

        Label changeLabel =
                new Label(change);

        changeLabel.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label suffixLabel =
                new Label(suffix);

        suffixLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;"
        );

        bottom.getChildren().addAll(
                changeLabel,
                suffixLabel
        );

        card.getChildren().addAll(
                top,
                valueLabel,
                bottom
        );

        return card;
    }

    // =========================================================
    // LARGE CARD
    // =========================================================

    private VBox createLargeCard() {

        VBox card =
                new VBox(12);

        card.setPadding(
                new Insets(18)
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 14;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 14;"
        );

        return card;
    }

    // =========================================================
    // PROGRESS ITEM
    // =========================================================

    private VBox createProgressItem(
            String title,
            String value,
            double progress
    ) {

        VBox box =
                new VBox(9);

        box.setPrefHeight(54);
        box.setMinHeight(54);
        box.setFillWidth(true);

        HBox header =
                new HBox();

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 10px;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        header.getChildren().addAll(
                titleLabel,
                spacer,
                valueLabel
        );

        Region track =
                new Region();

        track.setPrefHeight(9);
        track.setMinHeight(9);

        track.setMaxWidth(
                Double.MAX_VALUE
        );

        track.setStyle(
                "-fx-background-color: #18241d;" +
                "-fx-background-radius: 5;"
        );

        Region fill =
                new Region();

        fill.setPrefHeight(9);
        fill.setMinHeight(9);

        fill.maxWidthProperty().bind(
                track.widthProperty().multiply(progress)
        );

        fill.prefWidthProperty().bind(
                track.widthProperty().multiply(progress)
        );

        fill.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-background-radius: 5;"
        );

        StackPaneLike stack =
                new StackPaneLike(
                        track,
                        fill
                );

        box.getChildren().addAll(
                header,
                stack
        );

        return box;
    }

    // =========================================================
    // SIMPLE STACKPANE-LIKE HELPER
    // =========================================================

    private static class StackPaneLike
            extends javafx.scene.layout.StackPane {

        StackPaneLike(
                Node back,
                Node front
        ) {

            getChildren().addAll(
                    back,
                    front
            );

            javafx.scene.layout.StackPane.setAlignment(
                    back,
                    Pos.CENTER_LEFT
            );

            javafx.scene.layout.StackPane.setAlignment(
                    front,
                    Pos.CENTER_LEFT
            );
        }
    }

    // =========================================================
    // QUICK ACTION
    // =========================================================

    private Button createQuickAction(
            String icon,
            String text
    ) {

        Button button =
                new Button(
                        icon + "   " + text
                );

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setPrefHeight(
                45
        );

        String normal =
                "-fx-background-color: #0d1b14;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(117,255,158,0.10);" +
                "-fx-border-radius: 10;" +
                "-fx-font-size: 11px;" +
                "-fx-cursor: hand;";

        String hover =
                "-fx-background-color: #163B2A;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-font-size: 11px;" +
                "-fx-cursor: hand;";

        addHoverEffect(
                button,
                normal,
                hover
        );

        return button;
    }

    // =========================================================
    // SCHEDULE ROW
    // =========================================================

    private HBox createScheduleRow(
            String time,
            String client,
            String type
    ) {

        HBox row =
                new HBox(10);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(
                        7,
                        5,
                        7,
                        5
                )
        );

        Label timeLabel =
                new Label(time);

        timeLabel.setPrefWidth(65);

        timeLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;"
        );

        VBox clientInfo =
                new VBox(2);

        Label clientLabel =
                new Label(client);

        clientLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label typeLabel =
                new Label(type);

        typeLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 8px;"
        );

        clientInfo.getChildren().addAll(
                clientLabel,
                typeLabel
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button joinButton =
                new Button("Join");

        joinButton.setPrefWidth(45);

        joinButton.setStyle(
                "-fx-background-color: rgba(117,255,158,0.10);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;" +
                "-fx-cursor: hand;"
        );

        joinButton.setOnAction(
                e -> showSimpleContent(
                        "Training Session",
                        "Joining session with " +
                        client +
                        "."
                )
        );

        row.getChildren().addAll(
                timeLabel,
                clientInfo,
                spacer,
                joinButton
        );

        return row;
    }

    // =========================================================
    // ACTIVITY ROW
    // =========================================================

    private HBox createActivityRow(
            String activity,
            String time
    ) {

        HBox row =
                new HBox(9);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label dot =
                new Label("●");

        dot.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 9px;"
        );

        Label activityLabel =
                new Label(activity);

        activityLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 10px;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;"
        );

        row.getChildren().addAll(
                dot,
                activityLabel,
                spacer,
                timeLabel
        );

        return row;
    }

    // =========================================================
    // MY CLIENTS
    // =========================================================

    private void showMyClients() {

        setActiveNavItem(
                "My Clients"
        );

        Node cached =
                pageCache.get("My Clients");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        TrainerMyClients page =
                new TrainerMyClients(

                        this::showDashboard,
                        this::showMyClients,
                        this::showClientRequests,
                        this::showWorkoutPlans,
                        this::showChatbox,
                        this::showSchedule,
                        this::showEarnings,
                        this::showReviews,
                        this::showProfile,
                        this::logout
                );

        Node center =
                extractCenterContent(
                        page.getMyClientsScene()
                );

        if (center != null) {

            pageCache.put(
                    "My Clients",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // CLIENT REQUESTS
    // =========================================================

    private void showClientRequests() {

        setActiveNavItem(
                "Client Requests"
        );

        Node cached =
                pageCache.get("Client Requests");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        ClientRequest page =
                new ClientRequest();

        Node center =
                extractCenterContent(
                        page.getTrainerMyClientsScene(
                                this::showDashboard
                        )
                );

        if (center != null) {

            pageCache.put(
                    "Client Requests",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // WORKOUT PLANS
    // =========================================================

    private void showWorkoutPlans() {

        setActiveNavItem(
                "Workout Plans"
        );

        Node cached =
                pageCache.get("Workout Plans");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        WorkoutPlans page =
                new WorkoutPlans();

        Node center =
                extractCenterContent(
                        page.getWorkoutPlansScene(

                                this::showDashboard,
                                this::showMyClients,
                                this::showClientRequests,
                                this::showChatbox,
                                this::showSchedule,
                                this::showEarnings,
                                this::showReviews,
                                this::showProfile,
                                this::logout
                        )
                );

        if (center != null) {

            pageCache.put(
                    "Workout Plans",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // CHATBOX
    // =========================================================

    private void showChatbox() {

        setActiveNavItem(
                "Chatbox"
        );

        Node cached =
                pageCache.get("Chatbox");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        Chatbox page =
                new Chatbox();

        Node center =
                extractCenterContent(
                        page.getChatboxScene(
                                this::showDashboard
                        )
                );

        if (center != null) {

            pageCache.put(
                    "Chatbox",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // SCHEDULE
    // =========================================================

    private void showSchedule() {

        setActiveNavItem(
                "Schedule Manager"
        );

        Node cached =
                pageCache.get("Schedule Manager");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        ScheduleManager page =
                new ScheduleManager();

        Node center =
                extractCenterContent(
                        page.getScheduleManagerScene(
                                this::showDashboard
                        )
                );

        if (center != null) {

            pageCache.put(
                    "Schedule Manager",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // EARNINGS
    // =========================================================

    private void showEarnings() {

        setActiveNavItem(
                "Earnings"
        );

        Node cached =
                pageCache.get("Earnings");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        Earnings page =
                new Earnings();

        Node center =
                extractCenterContent(
                        page.getEarningsScene(

                                this::showDashboard,
                                this::showMyClients,
                                this::showClientRequests,
                                this::showWorkoutPlans,
                                this::showChatbox,
                                this::showSchedule,
                                this::showReviews,
                                this::showProfile,
                                this::logout
                        )
                );

        if (center != null) {

            pageCache.put(
                    "Earnings",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // REVIEWS
    // =========================================================

    private void showReviews() {

        setActiveNavItem(
                "Reviews & Ratings"
        );

        Node cached =
                pageCache.get("Reviews & Ratings");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        TrainerReviews page =
                new TrainerReviews();

        Node center =
                extractCenterContent(
                        page.getTrainerReviewsScene(
                                this::showDashboard
                        )
                );

        if (center != null) {

            pageCache.put(
                    "Reviews & Ratings",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // PROFILE
    // =========================================================

    private void showProfile() {

        Node cached =
                pageCache.get("My Profile");

        if (cached != null) {

            setCenter(cached);

            return;
        }

        TrainerProfile page =
                new TrainerProfile();

        Node center =
                extractCenterContent(
                        page.getTrainerProfileScene(
                                this::showDashboard
                        )
                );

        if (center != null) {

            pageCache.put(
                    "My Profile",
                    center
            );
        }

        setCenter(center);
    }

    // =========================================================
    // SIMPLE CONTENT
    // =========================================================

    private void showSimpleContent(
            String titleText,
            String subtitleText
    ) {

        VBox content =
                new VBox(10);

        content.setPadding(
                new Insets(30)
        );

        content.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";"
        );

        content.getChildren().addAll(
                createTitle(titleText),
                createSubtitle(subtitleText)
        );

        setCenter(content);
    }

    // =========================================================
    // LOGOUT
    // =========================================================

    private void logout() {

        System.out.println(
                "Trainer Logout"
        );
    }

    // =========================================================
    // TITLE
    // =========================================================

    private Label createTitle(
            String text
    ) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // SUBTITLE
    // =========================================================

    private Label createSubtitle(
            String text
    ) {

        Label label =
                new Label(text);

        label.setPadding(
                new Insets(
                        5,
                        0,
                        25,
                        0
                )
        );

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 14px;"
        );

        return label;
    }

    // =========================================================
    // GET DASHBOARD SCENE
    // =========================================================

//     public Scene getDashboardScene() {

//         return primaryStage == null
//                 ? null
//                 : primaryStage.getScene();
//     }

//     // =========================================================
//     // GET PRIMARY STAGE
//     // =========================================================

//     public Stage getPrimaryStage() {

//         return primaryStage;
//     }        
//         return trainerDashboardScene;
}

   


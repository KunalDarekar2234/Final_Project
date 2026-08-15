package com.visionx.view.trainer_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class Earnings {

    private Scene earningsScene;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String CARD_BG = "#050D18";
    private final String CARD_BG_2 = "##050D18";

    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_BRIGHT = "#8affad";
    private final String PRIMARY_DIM = "rgba(117,255,158,0.10)";
    private final String PRIMARY_DARK = "rgba(117,255,158,0.04)";

    private final String TEXT_MAIN = "#f1f7f1";
    private final String TEXT_MUTED = "#9caf9d";
    private final String TEXT_SOFT = "#718174";

    private final String BORDER =
            "rgba(255,255,255,0.09)";

    private final String GRID =
            "rgba(255,255,255,0.045)";

    // =========================================================
    // SHADOW
    // =========================================================

    private final DropShadow cardShadow =
            new DropShadow(
                    22,
                    0,
                    8,
                    Color.color(0, 0, 0, 0.30)
            );

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getEarningsScene(
            Runnable dashboardAction,
            Runnable clientsAction,
            Runnable requestsAction,
            Runnable workoutAction,
            Runnable chatAction,
            Runnable scheduleAction,
            Runnable reviewsAction,
            Runnable profileAction,
            Runnable logoutAction
    ) {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-font-family: 'Segoe UI';"
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar =
                createSidebar(
                        dashboardAction,
                        clientsAction,
                        requestsAction,
                        workoutAction,
                        chatAction,
                        scheduleAction,
                        reviewsAction,
                        profileAction,
                        logoutAction
                );

        root.setLeft(sidebar);

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                createHeader();

        root.setTop(header);

        // =====================================================
        // CENTER
        // =====================================================

        ScrollPane content =
                createEarningsContent();

        root.setCenter(content);

        // =====================================================
        // SCENE
        // =====================================================

        earningsScene =
                new Scene(
                        root,
                        1160,
                        900
                );

        return earningsScene;
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private VBox createSidebar(
            Runnable dashboardAction,
            Runnable clientsAction,
            Runnable requestsAction,
            Runnable workoutAction,
            Runnable chatAction,
            Runnable scheduleAction,
            Runnable reviewsAction,
            Runnable profileAction,
            Runnable logoutAction
    ) {

        VBox sidebar =
                new VBox();

        sidebar.setPrefWidth(230);

        sidebar.setMinWidth(230);

        sidebar.setPadding(
                new Insets(
                        22,
                        14,
                        20,
                        14
                )
        );

        sidebar.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-width: 0 1 0 0;"
        );

        // =====================================================
        // LOGO
        // =====================================================

        Label logo =
                new Label("FITNEESFREAK");

        logo.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        sidebar.getChildren().add(logo);

        sidebar.getChildren().add(
                createSeparator()
        );

        // =====================================================
        // NAVIGATION
        // =====================================================

        VBox navigation =
                new VBox(6);

        Button dashboard =
                createSidebarButton(
                        "⌂   Dashboard",
                        false
                );

        Button clients =
                createSidebarButton(
                        "♙   My Clients",
                        false
                );

        Button requests =
                createSidebarButton(
                        "✉   Client Requests",
                        false
                );

        Button workout =
                createSidebarButton(
                        "♜   Workout Plans",
                        false
                );

        Button chat =
                createSidebarButton(
                        "✉   Chatbox",
                        false
                );

        Button schedule =
                createSidebarButton(
                        "▣   Schedule Manager",
                        false
                );

        Button earnings =
                createSidebarButton(
                        "₹   Earnings",
                        true
                );

        Button reviews =
                createSidebarButton(
                        "★   Reviews & Ratings",
                        false
                );

        Button profile =
                createSidebarButton(
                        "♙   My Profile",
                        false
                );

        dashboard.setOnAction(
                e -> {
                    if (dashboardAction != null)
                        dashboardAction.run();
                }
        );

        clients.setOnAction(
                e -> {
                    if (clientsAction != null)
                        clientsAction.run();
                }
        );

        requests.setOnAction(
                e -> {
                    if (requestsAction != null)
                        requestsAction.run();
                }
        );

        workout.setOnAction(
                e -> {
                    if (workoutAction != null)
                        workoutAction.run();
                }
        );

        chat.setOnAction(
                e -> {
                    if (chatAction != null)
                        chatAction.run();
                }
        );

        schedule.setOnAction(
                e -> {
                    if (scheduleAction != null)
                        scheduleAction.run();
                }
        );

        reviews.setOnAction(
                e -> {
                    if (reviewsAction != null)
                        reviewsAction.run();
                }
        );

        profile.setOnAction(
                e -> {
                    if (profileAction != null)
                        profileAction.run();
                }
        );

        navigation.getChildren().addAll(
                dashboard,
                clients,
                requests,
                workout,
                chat,
                schedule,
                earnings,
                reviews,
                profile
        );

        sidebar.getChildren().add(
                navigation
        );

        // =====================================================
        // SPACER
        // =====================================================

        Region spacer =
                new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS
        );

        sidebar.getChildren().add(
                spacer
        );

        // =====================================================
        // LOGOUT
        // =====================================================

        Button logout =
                createSidebarButton(
                        "⇥   Logout",
                        false
                );

        logout.setOnAction(
                e -> {
                    if (logoutAction != null)
                        logoutAction.run();
                }
        );

        sidebar.getChildren().add(
                logout
        );

        return sidebar;
    }

    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private Button createSidebarButton(
            String text,
            boolean active
    ) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setPadding(
                new Insets(
                        12,
                        14,
                        12,
                        14
                )
        );

        String normalStyle =
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " +
                PRIMARY +
                ";" +
                "-fx-border-width: 0 0 0 3;" +
                "-fx-cursor: hand;";

        button.setStyle(
                active
                        ? activeStyle
                        : normalStyle
        );

        if (!active) {

            button.setOnMouseEntered(
                    e -> button.setStyle(
                            "-fx-background-color: rgba(117,255,158,0.06);" +
                            "-fx-text-fill: " +
                            PRIMARY +
                            ";" +
                            "-fx-font-size: 13px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 10;" +
                            "-fx-cursor: hand;"
                    )
            );

            button.setOnMouseExited(
                    e -> button.setStyle(
                            normalStyle
                    )
            );
        }

        return button;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createHeader() {

        HBox header =
                new HBox(16);

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setPadding(
                new Insets(
                        16,
                        24,
                        16,
                        24
                )
        );

        header.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-width: 0 0 1 0;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        Label search =
                new Label(
                        "Search clients, plans, sessions..."
                );

        search.setMaxWidth(
                Double.MAX_VALUE
        );

        search.setPadding(
                new Insets(
                        10,
                        16,
                        10,
                        16
                )
        );

        search.setStyle(
                "-fx-background-color: rgba(255,255,255,0.035);" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 10;" +
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        HBox.setHgrow(
                search,
                Priority.ALWAYS
        );

        // =====================================================
        // NOTIFICATION
        // =====================================================

        Button notification =
                createHeaderButton(
                        "🔔"
                );

        // =====================================================
        // SETTINGS
        // =====================================================

        Button settings =
                createHeaderButton(
                        "⚙"
                );

        // =====================================================
        // PROFILE
        // =====================================================

        Label profile =
                new Label(
                        "Alex Trainer"
                );

        profile.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        header.getChildren().addAll(
                search,
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
                38,
                38
        );

        button.setStyle(
                "-fx-background-color: rgba(255,255,255,0.045);" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 10;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // MAIN EARNINGS CONTENT
    // =========================================================

    private ScrollPane createEarningsContent() {

        VBox content =
                new VBox(22);

        content.setPadding(
                new Insets(
                        28,
                        34,
                        45,
                        34
                )
        );

        content.setFillWidth(
                true
        );

        content.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label breadcrumb =
                new Label(
                        "Trainer Portal  ›  Earnings"
                );

        breadcrumb.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        Label title =
                new Label(
                        "Earnings"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Track your income, payouts and financial performance."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 14px;"
        );

        VBox titleBox =
                new VBox(5);

        titleBox.getChildren().addAll(
                breadcrumb,
                title,
                subtitle
        );

        // =====================================================
        // KPI CARDS
        // =====================================================

        GridPane stats =
                new GridPane();

        stats.setHgap(14);
        stats.setVgap(14);

        stats.setMaxWidth(
                Double.MAX_VALUE
        );

        for (int i = 0; i < 4; i++) {

            ColumnConstraints column =
                    new ColumnConstraints();

            column.setPercentWidth(25);

            column.setHgrow(
                    Priority.ALWAYS
            );

            stats.getColumnConstraints()
                    .add(column);
        }

        VBox total =
                createStatCard(
                        "TOTAL EARNINGS",
                        "$24,850",
                        "+18.4%",
                        "vs last month"
                );

        VBox monthly =
                createStatCard(
                        "THIS MONTH",
                        "$6,420",
                        "+12.7%",
                        "current month"
                );

        VBox pending =
                createStatCard(
                        "PENDING PAYOUT",
                        "$1,240",
                        "Pending",
                        "next payout"
                );

        VBox clients =
                createStatCard(
                        "CLIENT REVENUE",
                        "$18,930",
                        "+15.2%",
                        "from active clients"
                );

        GridPane.setHgrow(total, Priority.ALWAYS);
        GridPane.setHgrow(monthly, Priority.ALWAYS);
        GridPane.setHgrow(pending, Priority.ALWAYS);
        GridPane.setHgrow(clients, Priority.ALWAYS);

        stats.add(total, 0, 0);
        stats.add(monthly, 1, 0);
        stats.add(pending, 2, 0);
        stats.add(clients, 3, 0);

        // =====================================================
        // EARNINGS OVERVIEW
        // =====================================================

        VBox chartCard =
                createEarningsChart();

        // =====================================================
        // PAYOUT
        // =====================================================

        VBox payoutCard =
                createPayoutSummary();

        // =====================================================
        // TRANSACTIONS
        // =====================================================

        VBox transactions =
                createTransactions();

        content.getChildren().addAll(
                titleBox,
                stats,
                chartCard,
                payoutCard,
                transactions
        );

        // =====================================================
        // SCROLL
        // =====================================================

        StackPane wrapper =
                new StackPane(content);

        wrapper.setAlignment(
                Pos.TOP_LEFT
        );

        wrapper.setStyle(
                "-fx-background-color: transparent;"
        );

        ScrollPane scroll =
                new ScrollPane(wrapper);

        scroll.setFitToWidth(true);

        scroll.setFitToHeight(false);

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        return scroll;
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String value,
            String change,
            String subtitle
    ) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(19)
        );

        card.setMinHeight(
                125
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 16;"
        );

        card.setEffect(
                cardShadow
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        Label changeLabel =
                new Label(
                        change +
                        "   " +
                        subtitle
                );

        changeLabel.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                titleLabel,
                valueLabel,
                changeLabel
        );

        return card;
    }

    // =========================================================
    // EARNINGS CHART
    // =========================================================

    private VBox createEarningsChart() {

        VBox card =
                new VBox(16);

        card.setPadding(
                new Insets(
                        22,
                        24,
                        22,
                        24
                )
        );

        card.setMinHeight(
                310
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        card.setEffect(
                cardShadow
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox headerLeft =
                new VBox(4);

        Label title =
                new Label(
                        "Earnings Overview"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Monthly earnings performance"
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        headerLeft.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        VBox amountBox =
                new VBox(2);

        amountBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label amount =
                new Label(
                        "$6,420"
                );

        amount.setStyle(
                "-fx-text-fill: " +
                PRIMARY_BRIGHT +
                ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label growth =
                new Label(
                        "↗ 12.7%"
                );

        growth.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        amountBox.getChildren().addAll(
                amount,
                growth
        );

        header.getChildren().addAll(
                headerLeft,
                spacer,
                amountBox
        );

        // =====================================================
        // CHART AREA
        // =====================================================

        VBox chart =
                new VBox(12);

        chart.setPadding(
                new Insets(
                        10,
                        0,
                        0,
                        0
                )
        );

        String[] months = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun"
        };

        double[] values = {
                2600,
                3400,
                3100,
                4700,
                5200,
                6420
        };

        double maxValue = 7000;

        for (int i = 0; i < months.length; i++) {

            HBox row =
                    createChartRow(
                            months[i],
                            values[i],
                            maxValue
                    );

            chart.getChildren().add(
                    row
            );
        }

        // =====================================================
        // SCALE
        // =====================================================

        HBox scale =
                new HBox();

        scale.setPadding(
                new Insets(
                        2,
                        78,
                        0,
                        48
                )
        );

        scale.setAlignment(
                Pos.CENTER_LEFT
        );

        String[] scaleValues = {
                "$0",
                "$2K",
                "$4K",
                "$6K",
                "$7K"
        };

        for (String text : scaleValues) {

            Label scaleLabel =
                    new Label(text);

            scaleLabel.setStyle(
                    "-fx-text-fill: " +
                    TEXT_SOFT +
                    ";" +
                    "-fx-font-size: 9px;"
            );

            HBox.setHgrow(
                    scaleLabel,
                    Priority.ALWAYS
            );

            scale.getChildren().add(
                    scaleLabel
            );
        }

        card.getChildren().addAll(
                header,
                chart,
                scale
        );

        return card;
    }

    // =========================================================
    // CHART ROW
    // =========================================================

    private HBox createChartRow(
            String month,
            double value,
            double maxValue
    ) {

        HBox row =
                new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPrefHeight(
                28
        );

        // =====================================================
        // MONTH
        // =====================================================

        Label monthLabel =
                new Label(month);

        monthLabel.setPrefWidth(
                35
        );

        monthLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // BAR BACKGROUND
        // =====================================================

        StackPane barContainer =
                new StackPane();

        barContainer.setPrefHeight(
                12
        );

        barContainer.setMaxHeight(
                12
        );

        HBox.setHgrow(
                barContainer,
                Priority.ALWAYS
        );

        barContainer.setStyle(
                "-fx-background-color: " +
                GRID +
                ";" +
                "-fx-background-radius: 8;"
        );

        // =====================================================
        // ACTUAL BAR
        // =====================================================

        double ratio =
                value / maxValue;

        Rectangle bar =
                new Rectangle();

        bar.setHeight(
                12
        );

        bar.setArcWidth(
                8
        );

        bar.setArcHeight(
                8
        );

        bar.setFill(
                Color.web(
                        PRIMARY
                )
        );

        bar.setEffect(
                new DropShadow(
                        8,
                        Color.web(
                                PRIMARY,
                                0.18
                        )
                )
        );

        // Bind bar width to container width
        bar.widthProperty().bind(
                barContainer.widthProperty()
                        .multiply(ratio)
        );

        StackPane.setAlignment(
                bar,
                Pos.CENTER_LEFT
        );

        barContainer.getChildren().add(
                bar
        );

        // =====================================================
        // VALUE
        // =====================================================

        Label valueLabel =
                new Label(
                        "$" +
                        String.format(
                                "%,.0f",
                                value
                        )
                );

        valueLabel.setPrefWidth(
                58
        );

        valueLabel.setAlignment(
                Pos.CENTER_RIGHT
        );

        valueLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        row.getChildren().addAll(
                monthLabel,
                barContainer,
                valueLabel
        );

        return row;
    }

    // =========================================================
    // PAYOUT SUMMARY
    // =========================================================

    private VBox createPayoutSummary() {

        VBox card =
                new VBox(16);

        card.setPadding(
                new Insets(21, 24, 21, 24)
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        card.setEffect(
                cardShadow
        );

        Label title =
                new Label(
                        "Payout Summary"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox left =
                new VBox(4);

        Label amount =
                new Label(
                        "$1,240"
                );

        amount.setStyle(
                "-fx-text-fill: " +
                PRIMARY_BRIGHT +
                ";" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        Label next =
                new Label(
                        "Next payout • 30 Nov 2023"
                );

        next.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        left.getChildren().addAll(
                amount,
                next
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button payout =
                new Button(
                        "View Payout History"
                );

        payout.setStyle(
                "-fx-background-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-border-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 16;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 11px;" +
                "-fx-cursor: hand;"
        );

        payout.setOnMouseEntered(
                e -> payout.setStyle(
                        "-fx-background-color: " +
                        PRIMARY +
                        ";" +
                        "-fx-border-color: " +
                        PRIMARY +
                        ";" +
                        "-fx-text-fill: #003918;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 10 16;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 11px;" +
                        "-fx-cursor: hand;"
                )
        );

        payout.setOnMouseExited(
                e -> payout.setStyle(
                        "-fx-background-color: " +
                        PRIMARY_DIM +
                        ";" +
                        "-fx-border-color: " +
                        PRIMARY +
                        ";" +
                        "-fx-text-fill: " +
                        PRIMARY +
                        ";" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 10 16;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 11px;" +
                        "-fx-cursor: hand;"
                )
        );

        row.getChildren().addAll(
                left,
                spacer,
                payout
        );

        card.getChildren().addAll(
                title,
                row
        );

        return card;
    }

    // =========================================================
    // TRANSACTIONS
    // =========================================================

    private VBox createTransactions() {

        VBox card =
                new VBox();

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        card.setEffect(
                cardShadow
        );

        Label title =
                new Label(
                        "Recent Transactions"
                );

        title.setPadding(
                new Insets(
                        19,
                        22,
                        15,
                        22
                )
        );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().add(
                title
        );

        addTransaction(
                card,
                "Elite Performance Package",
                "Alex Vance",
                "$450",
                "Completed"
        );

        addTransaction(
                card,
                "Personal Training",
                "Sarah Mitchell",
                "$280",
                "Completed"
        );

        addTransaction(
                card,
                "Workout Plan",
                "James Carter",
                "$150",
                "Pending"
        );

        addTransaction(
                card,
                "Monthly Coaching",
                "Daniel Brooks",
                "$320",
                "Completed"
        );

        return card;
    }

    // =========================================================
    // TRANSACTION ROW
    // =========================================================

    private void addTransaction(
            VBox parent,
            String service,
            String client,
            String amount,
            String status
    ) {

        HBox row =
                new HBox(14);

        row.setPadding(
                new Insets(
                        13,
                        22,
                        13,
                        22
                )
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-border-color: " +
                "rgba(255,255,255,0.045)" +
                " transparent transparent transparent;"
        );

        VBox info =
                new VBox(3);

        Label serviceLabel =
                new Label(service);

        serviceLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label clientLabel =
                new Label(client);

        clientLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        info.getChildren().addAll(
                serviceLabel,
                clientLabel
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label amountLabel =
                new Label(amount);

        amountLabel.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        String statusStyle;

        if (status.equalsIgnoreCase("Pending")) {

            statusStyle =
                    "-fx-text-fill: #ffd27d;" +
                    "-fx-border-color: #ffd27d;" +
                    "-fx-background-color: rgba(255,210,125,0.06);";

        } else {

            statusStyle =
                    "-fx-text-fill: " +
                    PRIMARY +
                    ";" +
                    "-fx-border-color: " +
                    PRIMARY +
                    ";" +
                    "-fx-background-color: " +
                    PRIMARY_DIM +
                    ";";
        }

        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                statusStyle +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 4 10;" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        row.getChildren().addAll(
                info,
                spacer,
                amountLabel,
                statusLabel
        );

        parent.getChildren().add(
                row
        );
    }

    // =========================================================
    // SEPARATOR
    // =========================================================

    private Region createSeparator() {

        Region separator =
                new Region();

        separator.setPrefHeight(
                1
        );

        separator.setMaxWidth(
                Double.MAX_VALUE
        );

        separator.setStyle(
                "-fx-background-color: " +
                BORDER +
                ";"
        );

        VBox.setMargin(
                separator,
                new Insets(
                        20,
                        4,
                        18,
                        4
                )
        );

        return separator;
    }

    // =========================================================
    // NO ARGUMENT VERSION
    // =========================================================

    public Scene getEarningsScene() {

        return getEarningsScene(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
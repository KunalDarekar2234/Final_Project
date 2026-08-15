package com.visionx.view.trainer_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.effect.DropShadow;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class WorkoutPlans {

    private Scene workoutPlansScene;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#0d150e";

    private final String CARD_BG = "#020914";

    private final String SURFACE_BORDER =
            "rgba(255,255,255,0.1)";

    private final String PRIMARY =
            "#75ff9e";

    private final String PRIMARY_DIM =
            "rgba(117,255,158,0.1)";

    private final String TEXT_MAIN =
            "#dbe5d9";

    private final String TEXT_MUTED =
            "#bacbb9";

    private final String WARNING =
            "#facc15";

    private final String ERROR =
            "#ff6b6b";

    // =========================================================
    // SHADOW
    // =========================================================

    private final DropShadow cardShadow =
            new DropShadow(
                    20,
                    0,
                    8,
                    Color.color(0, 0, 0, 0.4)
            );

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getWorkoutPlansScene(
            Runnable dashboardAction,
            Runnable clientsAction,
            Runnable requestsAction,
            Runnable chatAction,
            Runnable scheduleAction,
            Runnable earningsAction,
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
        // HEADER
        // =====================================================

        HBox header =
                createHeader();

        root.setTop(header);

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar =
                createSidebar(
                        dashboardAction,
                        clientsAction,
                        requestsAction,
                        chatAction,
                        scheduleAction,
                        earningsAction,
                        reviewsAction,
                        profileAction,
                        logoutAction
                );

        root.setLeft(sidebar);

        // =====================================================
        // CENTER
        // =====================================================

        ScrollPane scroll =
                createWorkoutContent();

        root.setCenter(scroll);

        // =====================================================
        // SCENE
        // =====================================================

        workoutPlansScene =
                new Scene(
                        root,
                        1280,
                        900
                );

        return workoutPlansScene;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createHeader() {

        HBox header =
                new HBox();

        header.setPrefHeight(70);

        header.setPadding(
                new Insets(
                        0,
                        24,
                        0,
                        24
                )
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-width: 0 0 1 0;"
        );

        // =====================================================
        // LOGO
        // =====================================================

        Label logo =
                new Label(
                        "FITNEESFREAK"
                );

        logo.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        Label search =
                new Label(
                        "⌕   Search clients, plans, sessions..."
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
                "-fx-background-color: rgba(255,255,255,0.04);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
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
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;"
        );

        header.getChildren().addAll(
                logo,
                createHorizontalSpacer(35),
                search,
                spacer,
                notification,
                settings,
                createHorizontalSpacer(18),
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
                40,
                40
        );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 16px;" +
                "-fx-cursor: hand;" +
                "-fx-background-radius: 10;"
        );

        button.setOnMouseEntered(
                e -> button.setStyle(
                        "-fx-background-color: " +
                        PRIMARY_DIM +
                        ";" +
                        "-fx-text-fill: " +
                        PRIMARY +
                        ";" +
                        "-fx-font-size: 16px;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 10;"
                )
        );

        button.setOnMouseExited(
                e -> button.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: " +
                        TEXT_MUTED +
                        ";" +
                        "-fx-font-size: 16px;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 10;"
                )
        );

        return button;
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private VBox createSidebar(

            Runnable dashboardAction,
            Runnable clientsAction,
            Runnable requestsAction,
            Runnable chatAction,
            Runnable scheduleAction,
            Runnable earningsAction,
            Runnable reviewsAction,
            Runnable profileAction,
            Runnable logoutAction

    ) {

        VBox sidebar =
                new VBox(8);

        sidebar.setPrefWidth(
                220
        );

        sidebar.setPadding(
                new Insets(
                        24,
                        14,
                        20,
                        14
                )
        );

        sidebar.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-width: 0 1 0 0;"
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "⌂",
                        "Dashboard",
                        dashboardAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "👥",
                        "My Clients",
                        clientsAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "📩",
                        "Client Requests",
                        requestsAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "🏋",
                        "Workout Plans",
                        null,
                        true
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "💬",
                        "Chatbox",
                        chatAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "📅",
                        "Schedule Manager",
                        scheduleAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "💰",
                        "Earnings",
                        earningsAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "⭐",
                        "Reviews & Ratings",
                        reviewsAction,
                        false
                )
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "👤",
                        "My Profile",
                        profileAction,
                        false
                )
        );

        Region spacer =
                new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS
        );

        sidebar.getChildren().add(
                spacer
        );

        sidebar.getChildren().add(
                createSidebarButton(
                        "🚪",
                        "Logout",
                        logoutAction,
                        false
                )
        );

        return sidebar;
    }

    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private Button createSidebarButton(

            String icon,
            String text,
            Runnable action,
            boolean active

    ) {

        Button button =
                new Button(
                        icon + "   " + text
                );

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
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;";

        button.setStyle(
                active
                        ? activeStyle
                        : normalStyle
        );

        if (!active) {

            button.setOnMouseEntered(
                    e -> button.setStyle(
                            "-fx-background-color: " +
                            PRIMARY_DIM +
                            ";" +
                            "-fx-text-fill: " +
                            PRIMARY +
                            ";" +
                            "-fx-font-size: 12px;" +
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

        if (action != null) {

            button.setOnAction(
                    e -> action.run()
            );
        }

        return button;
    }

    // =========================================================
    // WORKOUT CONTENT
    // =========================================================

    private ScrollPane createWorkoutContent() {

        VBox content =
                new VBox(22);

        content.setPadding(
                new Insets(
                        28,
                        30,
                        40,
                        30
                )
        );

        content.setMaxWidth(
                1200
        );

        // =====================================================
        // PAGE HEADER
        // =====================================================

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox titleBox =
                new VBox(5);

        Label title =
                new Label(
                        "Workout Plans"
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
                        "Create, manage and monitor personalized workout plans for your clients."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 13px;"
        );

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button createPlan =
                new Button(
                        "+  Create Workout Plan"
                );

        createPlan.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 11 18;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;"
        );

        createPlan.setOnAction(
                e -> openCreateWorkoutWindow(
                        createPlan
                )
        );

        header.getChildren().addAll(
                titleBox,
                spacer,
                createPlan
        );

        // =====================================================
        // STATS
        // =====================================================

        GridPane stats =
                new GridPane();

        stats.setHgap(14);

        stats.setVgap(14);

        VBox stat1 =
                createStatCard(
                        "ACTIVE PLANS",
                        "24",
                        "+8.2%",
                        "this month"
                );

        VBox stat2 =
                createStatCard(
                        "CLIENTS ASSIGNED",
                        "86",
                        "+12.5%",
                        "active clients"
                );

        VBox stat3 =
                createStatCard(
                        "COMPLETED PLANS",
                        "142",
                        "+15.4%",
                        "all time"
                );

        VBox stat4 =
                createStatCard(
                        "AVG. COMPLETION",
                        "87.6%",
                        "+4.8%",
                        "client progress"
                );

        stats.add(
                stat1,
                0,
                0
        );

        stats.add(
                stat2,
                1,
                0
        );

        stats.add(
                stat3,
                2,
                0
        );

        stats.add(
                stat4,
                3,
                0
        );

        for (
                int i = 0;
                i < 4;
                i++
        ) {

            GridPane.setHgrow(
                    stats.getChildren().get(i),
                    Priority.ALWAYS
            );
        }

        // =====================================================
        // FILTER BAR
        // =====================================================

        HBox filters =
                new HBox(10);

        filters.setAlignment(
                Pos.CENTER_LEFT
        );

        Button all =
                createFilterButton(
                        "All Plans",
                        true
                );

        Button active =
                createFilterButton(
                        "Active",
                        false
                );

        Button completed =
                createFilterButton(
                        "Completed",
                        false
                );

        Button draft =
                createFilterButton(
                        "Drafts",
                        false
                );

        filters.getChildren().addAll(
                all,
                active,
                completed,
                draft
        );

        // =====================================================
        // PLAN GRID - 3 COLUMNS
        // =====================================================

        GridPane plans =
                new GridPane();

        plans.setHgap(16);

        plans.setVgap(16);

        // -----------------------------------------------------
        // ROW 1
        // -----------------------------------------------------

        plans.add(
                createWorkoutCard(
                        "Elite Strength Program",
                        "Alex Vance",
                        "Strength",
                        "12 Weeks",
                        "5 Days / Week",
                        "78%",
                        PRIMARY
                ),
                0,
                0
        );

        plans.add(
                createWorkoutCard(
                        "Fat Loss & Conditioning",
                        "Maya Thorne",
                        "Weight Loss",
                        "8 Weeks",
                        "4 Days / Week",
                        "64%",
                        PRIMARY
                ),
                1,
                0
        );

        plans.add(
                createWorkoutCard(
                        "Muscle Building Plan",
                        "Julian Sterling",
                        "Hypertrophy",
                        "16 Weeks",
                        "5 Days / Week",
                        "52%",
                        WARNING
                ),
                2,
                0
        );

        // -----------------------------------------------------
        // ROW 2
        // -----------------------------------------------------

        plans.add(
                createWorkoutCard(
                        "Beginner Fitness Program",
                        "Arthur Vance",
                        "General Fitness",
                        "6 Weeks",
                        "3 Days / Week",
                        "91%",
                        PRIMARY
                ),
                0,
                1
        );

        plans.add(
                createWorkoutCard(
                        "Athletic Performance",
                        "Noah Carter",
                        "Performance",
                        "10 Weeks",
                        "5 Days / Week",
                        "72%",
                        PRIMARY
                ),
                1,
                1
        );

        plans.add(
                createWorkoutCard(
                        "Core & Mobility",
                        "Emma Stone",
                        "Mobility",
                        "8 Weeks",
                        "4 Days / Week",
                        "83%",
                        PRIMARY
                ),
                2,
                1
        );

        // -----------------------------------------------------
        // ROW 3
        // -----------------------------------------------------

        plans.add(
                createWorkoutCard(
                        "Lean Muscle Program",
                        "Liam Brooks",
                        "Hypertrophy",
                        "12 Weeks",
                        "5 Days / Week",
                        "61%",
                        WARNING
                ),
                0,
                2
        );

        plans.add(
                createWorkoutCard(
                        "Cardio Endurance",
                        "Sophia Reed",
                        "Endurance",
                        "10 Weeks",
                        "4 Days / Week",
                        "88%",
                        PRIMARY
                ),
                1,
                2
        );

        plans.add(
                createWorkoutCard(
                        "Total Body Transformation",
                        "Ethan Cole",
                        "Transformation",
                        "16 Weeks",
                        "5 Days / Week",
                        "47%",
                        WARNING
                ),
                2,
                2
        );

        // =====================================================
        // RECENT ACTIVITY
        // =====================================================

        VBox activity =
                createRecentActivity();

        content.getChildren().addAll(
                header,
                stats,
                filters,
                plans,
                activity
        );

        // =====================================================
        // WRAPPER
        // =====================================================

        StackPane wrapper =
                new StackPane(
                        content
                );

        wrapper.setAlignment(
                Pos.TOP_CENTER
        );

        wrapper.setStyle(
                "-fx-background-color: transparent;"
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scroll =
                new ScrollPane(
                        wrapper
                );

        scroll.setFitToWidth(
                true
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
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
            String sub

    ) {

        VBox card =
                new VBox(7);

        card.setPadding(
                new Insets(18)
        );

        card.setMinHeight(
                118
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
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

        HBox bottom =
                new HBox(7);

        Label changeLabel =
                new Label(change);

        changeLabel.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        Label subLabel =
                new Label(sub);

        subLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        bottom.getChildren().addAll(
                changeLabel,
                subLabel
        );

        card.getChildren().addAll(
                titleLabel,
                valueLabel,
                bottom
        );

        return card;
    }

    // =========================================================
    // FILTER BUTTON
    // =========================================================

    private Button createFilterButton(

            String text,
            boolean active

    ) {

        Button button =
                new Button(text);

        button.setPadding(
                new Insets(
                        8,
                        18,
                        8,
                        18
                )
        );

        if (active) {

            button.setStyle(
                    "-fx-background-color: " +
                    PRIMARY +
                    ";" +
                    "-fx-text-fill: #003918;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 20;" +
                    "-fx-cursor: hand;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color: " +
                    CARD_BG +
                    ";" +
                    "-fx-border-color: " +
                    SURFACE_BORDER +
                    ";" +
                    "-fx-text-fill: " +
                    TEXT_MUTED +
                    ";" +
                    "-fx-background-radius: 20;" +
                    "-fx-border-radius: 20;" +
                    "-fx-cursor: hand;"
            );
        }

        return button;
    }

    // =========================================================
    // WORKOUT CARD
    // =========================================================

    private VBox createWorkoutCard(

            String planName,
            String clientName,
            String category,
            String duration,
            String frequency,
            String progress,
            String progressColor

    ) {

        VBox card =
                new VBox(12);

        card.setPadding(
                new Insets(18)
        );

        card.setPrefHeight(
                245
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
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        card.setEffect(
                cardShadow
        );

        // =====================================================
        // TITLE ROW
        // =====================================================

        HBox titleRow =
                new HBox();

        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label title =
                new Label(planName);

        title.setWrapText(true);

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label status =
                new Label(
                        "ACTIVE"
                );

        status.setStyle(
                "-fx-background-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-padding: 4 8;" +
                "-fx-background-radius: 8;" +
                "-fx-font-size: 8px;" +
                "-fx-font-weight: bold;"
        );

        titleRow.getChildren().addAll(
                title,
                spacer,
                status
        );

        // =====================================================
        // CLIENT
        // =====================================================

        Label client =
                new Label(
                        "Client  •  " +
                        clientName
                );

        client.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        // =====================================================
        // DETAILS
        // =====================================================

        HBox details =
                new HBox(18);

        details.getChildren().addAll(

                createDetail(
                        "CATEGORY",
                        category
                ),

                createDetail(
                        "DURATION",
                        duration
                ),

                createDetail(
                        "FREQUENCY",
                        frequency
                )
        );

        // =====================================================
        // PROGRESS
        // =====================================================

        Label progressText =
                new Label(
                        "Client Progress"
                );

        progressText.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        Label progressValue =
                new Label(
                        progress
                );

        progressValue.setStyle(
                "-fx-text-fill: " +
                progressColor +
                ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        HBox progressHeader =
                new HBox();

        Region progressSpacer =
                new Region();

        HBox.setHgrow(
                progressSpacer,
                Priority.ALWAYS
        );

        progressHeader.getChildren().addAll(
                progressText,
                progressSpacer,
                progressValue
        );

        ProgressBar progressBar =
        new ProgressBar(
                Double.parseDouble(
                        progress.replace(
                                "%",
                                ""
                        )
                ) / 100
        );

        progressBar.setMaxWidth(
                Double.MAX_VALUE
        );

        progressBar.setPrefHeight(
                8
        );

        progressBar.setMinHeight(
                8
        );

        progressBar.setStyle(
                "-fx-accent: " + progressColor + ";" +
                "-fx-control-inner-background: rgba(255,255,255,0.08);" +
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;"
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        HBox buttons =
                new HBox(8);

        Button view =
                new Button(
                        "View Plan"
                );

        view.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 7 13;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        Button edit =
                new Button(
                        "Edit"
                );

        edit.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-padding: 7 13;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;"
        );

        buttons.getChildren().addAll(
                view,
                edit
        );

        // =====================================================
        // VIEW ACTION
        // =====================================================

        view.setOnAction(
                e -> openViewPlanWindow(
                        view,
                        planName,
                        clientName,
                        category,
                        duration,
                        frequency,
                        progress
                )
        );

        // =====================================================
        // EDIT ACTION
        // =====================================================

        edit.setOnAction(
                e -> openEditPlanWindow(
                        edit,
                        planName,
                        clientName,
                        category,
                        duration,
                        frequency,
                        progress
                )
        );

        card.getChildren().addAll(
                titleRow,
                client,
                details,
                progressHeader,
                progressBar,
                buttons
        );

        GridPane.setHgrow(
                card,
                Priority.ALWAYS
        );

        return card;
    }

    // =========================================================
    // DETAIL
    // =========================================================

    private VBox createDetail(

            String title,
            String value

    ) {

        VBox box =
                new VBox(3);

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 8px;" +
                "-fx-font-weight: bold;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        box.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return box;
    }

    // =========================================================
    // RECENT ACTIVITY
    // =========================================================

    private VBox createRecentActivity() {

        VBox card =
                new VBox();

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        Label title =
                new Label(
                        "Recent Workout Activity"
                );

        title.setPadding(
                new Insets(
                        20,
                        22,
                        15,
                        22
                )
        );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().add(
                title
        );

        addActivity(
                card,
                "🏋",
                "Alex Vance completed Week 8 of Elite Strength Program",
                "10 min ago",
                PRIMARY
        );

        addActivity(
                card,
                "✓",
                "Maya Thorne completed today's conditioning workout",
                "35 min ago",
                PRIMARY
        );

        addActivity(
                card,
                "📋",
                "New workout plan assigned to Arthur Vance",
                "1 hour ago",
                WARNING
        );

        addActivity(
                card,
                "⚡",
                "Julian Sterling reached 50% workout plan completion",
                "2 hours ago",
                PRIMARY
        );

        return card;
    }

    // =========================================================
    // ACTIVITY ROW
    // =========================================================

    private void addActivity(

            VBox parent,
            String icon,
            String text,
            String time,
            String color

    ) {

        HBox row =
                new HBox(14);

        row.setPadding(
                new Insets(
                        12,
                        22,
                        12,
                        22
                )
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-border-color: rgba(255,255,255,0.05) transparent transparent transparent;"
        );

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-text-fill: " +
                color +
                ";" +
                "-fx-font-size: 16px;"
        );

        Label textLabel =
                new Label(text);

        textLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;"
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
                "-fx-font-size: 10px;"
        );

        row.getChildren().addAll(
                iconLabel,
                textLabel,
                spacer,
                timeLabel
        );

        parent.getChildren().add(
                row
        );
    }

    // =========================================================
    // VIEW PLAN WINDOW 
    // =========================================================

    private void openViewPlanWindow(

            Button source,
            String planName,
            String clientName,
            String category,
            String duration,
            String frequency,
            String progress

    ) {

        Stage stage =
                new Stage();

        stage.initModality(
                Modality.WINDOW_MODAL
        );

        Window owner =
                source.getScene().getWindow();

        stage.initOwner(
                owner
        );

        stage.initStyle(
                StageStyle.UNDECORATED
        );

        // -----------------------------------------------------
        // MAIN
        // -----------------------------------------------------

        VBox main =
                new VBox(18);

        main.setPadding(
                new Insets(26)
        );

        main.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        main.setEffect(
                new DropShadow(
                        35,
                        0,
                        12,
                        Color.color(
                                0,
                                0,
                                0,
                                0.55
                        )
                )
        );

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox heading =
                new VBox(4);

        Label smallTitle =
                new Label(
                        "WORKOUT PLAN"
                );

        smallTitle.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        Label title =
                new Label(
                        planName
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Assigned to " +
                        clientName
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        heading.getChildren().addAll(
                smallTitle,
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label active =
                new Label(
                        "● ACTIVE"
                );

        active.setStyle(
                "-fx-background-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-padding: 6 10;" +
                "-fx-background-radius: 15;" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        header.getChildren().addAll(
                heading,
                spacer,
                active
        );

        // -----------------------------------------------------
        // INFO GRID
        // -----------------------------------------------------

        GridPane overview =
                new GridPane();

        overview.setHgap(12);
        overview.setVgap(12);

        overview.add(
                createViewInfoCard(
                        "CLIENT",
                        clientName
                ),
                0,
                0
        );

        overview.add(
                createViewInfoCard(
                        "CATEGORY",
                        category
                ),
                1,
                0
        );

        overview.add(
                createViewInfoCard(
                        "DURATION",
                        duration
                ),
                0,
                1
        );

        overview.add(
                createViewInfoCard(
                        "FREQUENCY",
                        frequency
                ),
                1,
                1
        );

        // -----------------------------------------------------
        // PROGRESS
        // -----------------------------------------------------

        VBox progressCard =
                new VBox(9);

        progressCard.setPadding(
                new Insets(16)
        );

        progressCard.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 15;"
        );

        HBox progressHeader =
                new HBox();

        Label progressLabel =
                new Label(
                        "CLIENT PROGRESS"
                );

        progressLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        Region progressSpacer =
                new Region();

        HBox.setHgrow(
                progressSpacer,
                Priority.ALWAYS
        );

        Label progressValue =
                new Label(
                        progress
                );

        progressValue.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        progressHeader.getChildren().addAll(
                progressLabel,
                progressSpacer,
                progressValue
        );

        ProgressBar progressBar =
        new ProgressBar(
                Double.parseDouble(
                        progress.replace(
                                "%",
                                ""
                        )
                ) / 100
        );

        progressBar.setMaxWidth(
                Double.MAX_VALUE
        );

        progressBar.setPrefHeight(
                8
        );

        progressBar.setMinHeight(
                8
        );

        progressBar.setStyle(
                "-fx-accent: " +
                PRIMARY +
                ";" +
                "-fx-control-inner-background: rgba(255,255,255,0.08);" +
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;"
        );
        // -----------------------------------------------------
        // OVERVIEW
        // -----------------------------------------------------

        VBox description =
                new VBox(7);

        description.setPadding(
                new Insets(16)
        );

        description.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 15;"
        );

        Label descriptionTitle =
                new Label(
                        "PLAN OVERVIEW"
                );

        descriptionTitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionText =
                new Label(
                        "This plan is designed for " +
                        clientName +
                        " and focuses on " +
                        category.toLowerCase() +
                        ". The program runs for " +
                        duration +
                        " with a schedule of " +
                        frequency +
                        "."
                );

        descriptionText.setWrapText(
                true
        );

        descriptionText.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        description.getChildren().addAll(
                descriptionTitle,
                descriptionText
        );

        // -----------------------------------------------------
        // BACK
        // -----------------------------------------------------

        HBox bottom =
                new HBox();

        bottom.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button back =
                new Button(
                        "←  Back to Workout Plans"
                );

        back.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 17;" +
                "-fx-background-radius: 9;" +
                "-fx-cursor: hand;"
        );

        back.setOnAction(
                e -> stage.close()
        );

        bottom.getChildren().add(
                back
        );

        main.getChildren().addAll(
                header,
                overview,
                progressCard,
                description,
                bottom
        );

        Scene scene =
                new Scene(
                        main,
                        620,
                        560
                );

        scene.setFill(
                Color.TRANSPARENT
        );

        stage.setScene(
                scene
        );

        stage.setResizable(
                false
        );

        stage.showAndWait();
    }

    // =========================================================
    // VIEW INFO CARD
    // =========================================================

    private VBox createViewInfoCard(

            String title,
            String value

    ) {

        VBox card =
                new VBox(4);

        card.setPadding(
                new Insets(13)
        );

        card.setPrefHeight(
                68
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 13;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 13;"
        );

        Label titleLabel =
                new Label(
                        title
                );

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 8px;" +
                "-fx-font-weight: bold;"
        );

        Label valueLabel =
                new Label(
                        value
                );

        valueLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        GridPane.setHgrow(
                card,
                Priority.ALWAYS
        );

        return card;
    }

    // =========================================================
    // EDIT WORKOUT PLAN
    // =========================================================

    private void openEditPlanWindow(

            Button source,
            String planName,
            String clientName,
            String category,
            String duration,
            String frequency,
            String progress

    ) {

        Stage stage =
                new Stage();

        stage.initModality(
                Modality.WINDOW_MODAL
        );

        stage.initOwner(
                source.getScene().getWindow()
        );

        stage.initStyle(
                StageStyle.UNDECORATED
        );

        VBox root =
                new VBox(18);

        root.setPadding(
                new Insets(26)
        );

        root.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        root.setEffect(
                new DropShadow(
                        35,
                        0,
                        12,
                        Color.color(
                                0,
                                0,
                                0,
                                0.55
                        )
                )
        );

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        VBox heading =
                new VBox(4);

        Label small =
                new Label(
                        "PLAN EDITOR"
                );

        small.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        Label title =
                new Label(
                        "Edit Workout Plan"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Update the program details for " +
                        clientName
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        heading.getChildren().addAll(
                small,
                title,
                subtitle
        );

        // -----------------------------------------------------
        // FORM
        // -----------------------------------------------------

        VBox form =
                new VBox(10);

        form.setPadding(
                new Insets(18)
        );

        form.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 16;"
        );

        TextField nameField =
                createEditField(
                        "Plan Name",
                        planName
                );

        TextField clientField =
                createEditField(
                        "Client",
                        clientName
                );

        ComboBox<String> categoryBox =
                new ComboBox<>();

        categoryBox.getItems().addAll(
                "Strength",
                "Weight Loss",
                "Hypertrophy",
                "General Fitness",
                "Performance",
                "Mobility",
                "Endurance",
                "Transformation",
                "Cardio"
        );

        categoryBox.setValue(
                category
        );

        styleComboBox(
                categoryBox
        );

        TextField durationField =
                createEditField(
                        "Duration",
                        duration
                );

        TextField frequencyField =
                createEditField(
                        "Frequency",
                        frequency
                );

        TextField progressField =
                createEditField(
                        "Client Progress",
                        progress
                );

        form.getChildren().addAll(

                createFieldLabel(
                        "PLAN NAME"
                ),

                nameField,

                createFieldLabel(
                        "CLIENT"
                ),

                clientField,

                createFieldLabel(
                        "CATEGORY"
                ),

                categoryBox,

                createFieldLabel(
                        "DURATION"
                ),

                durationField,

                createFieldLabel(
                        "FREQUENCY"
                ),

                frequencyField,

                createFieldLabel(
                        "CLIENT PROGRESS"
                ),

                progressField
        );

        // -----------------------------------------------------
        // BUTTONS
        // -----------------------------------------------------

        HBox buttons =
                new HBox(10);

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button cancel =
                new Button(
                        "Cancel"
                );

        cancel.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-padding: 9 17;" +
                "-fx-background-radius: 9;" +
                "-fx-border-radius: 9;" +
                "-fx-cursor: hand;"
        );

        cancel.setOnAction(
                e -> stage.close()
        );

        Button save =
                new Button(
                        "✓  Save Changes"
                );

        save.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 18;" +
                "-fx-background-radius: 9;" +
                "-fx-cursor: hand;"
        );

        save.setOnAction(
                e -> {

                    String updatedName =
                            nameField.getText().trim();

                    String updatedClient =
                            clientField.getText().trim();

                    String updatedProgress =
                            progressField.getText().trim();

                    if (
                            updatedName.isEmpty()
                            ||
                            updatedClient.isEmpty()
                            ||
                            categoryBox.getValue() == null
                    ) {

                        showInfo(
                                "Missing Information",
                                "Please complete all required fields."
                        );

                        return;
                    }

                    if (
                            updatedProgress.isEmpty()
                    ) {

                        showInfo(
                                "Missing Progress",
                                "Please enter client progress."
                        );

                        return;
                    }

                    showInfo(
                            "Workout Plan Updated",
                            updatedName +
                            " has been updated successfully."
                    );

                    stage.close();
                }
        );

        buttons.getChildren().addAll(
                cancel,
                save
        );

        root.getChildren().addAll(
                heading,
                form,
                buttons
        );

        ScrollPane scroll =
                new ScrollPane(
                        root
                );

        scroll.setFitToWidth(
                true
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        Scene scene =
                new Scene(
                        scroll,
                        620,
                        650
                );

        scene.setFill(
                Color.TRANSPARENT
        );

        stage.setScene(
                scene
        );

        stage.setResizable(
                false
        );

        stage.showAndWait();
    }

    // =========================================================
    // CREATE NEW WORKOUT
    // =========================================================

    private void openCreateWorkoutWindow(
            Button source
    ) {

        Stage stage =
                new Stage();

        stage.initModality(
                Modality.WINDOW_MODAL
        );

        stage.initOwner(
                source.getScene().getWindow()
        );

        stage.initStyle(
                StageStyle.UNDECORATED
        );

        VBox root =
                new VBox(18);

        root.setPadding(
                new Insets(26)
        );

        root.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 18;"
        );

        root.setEffect(
                new DropShadow(
                        35,
                        0,
                        12,
                        Color.color(
                                0,
                                0,
                                0,
                                0.55
                        )
                )
        );

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        VBox heading =
                new VBox(4);

        Label small =
                new Label(
                        "NEW PROGRAM"
                );

        small.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        Label title =
                new Label(
                        "Create Workout Plan"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Build a personalized training program for your client."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        heading.getChildren().addAll(
                small,
                title,
                subtitle
        );

        // -----------------------------------------------------
        // FORM
        // -----------------------------------------------------

        VBox form =
                new VBox(10);

        form.setPadding(
                new Insets(18)
        );

        form.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 16;"
        );

        TextField planName =
                createEditField(
                        "",
                        ""
                );

        planName.setPromptText(
                "e.g. Elite Strength Program"
        );

        TextField client =
                createEditField(
                        "",
                        ""
                );

        client.setPromptText(
                "e.g. Alex Vance"
        );

        ComboBox<String> category =
                new ComboBox<>();

        category.getItems().addAll(
                "Strength",
                "Weight Loss",
                "Hypertrophy",
                "General Fitness",
                "Performance",
                "Mobility",
                "Endurance",
                "Transformation",
                "Cardio"
        );

        category.setPromptText(
                "Select category"
        );

        styleComboBox(
                category
        );

        TextField duration =
                createEditField(
                        "",
                        ""
                );

        duration.setPromptText(
                "e.g. 12 Weeks"
        );

        TextField frequency =
                createEditField(
                        "",
                        ""
                );

        frequency.setPromptText(
                "e.g. 5 Days / Week"
        );

        TextArea notes =
                new TextArea();

        notes.setPromptText(
                "Add workout goals, instructions or notes..."
        );

        notes.setPrefRowCount(
                4
        );

        notes.setWrapText(
                true
        );

        notes.setStyle(
                "-fx-control-inner-background: #020914;" +
                "-fx-background-color: #020914;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 11px;"
        );

        form.getChildren().addAll(

                createFieldLabel(
                        "PLAN NAME"
                ),

                planName,

                createFieldLabel(
                        "CLIENT"
                ),

                client,

                createFieldLabel(
                        "CATEGORY"
                ),

                category,

                createFieldLabel(
                        "DURATION"
                ),

                duration,

                createFieldLabel(
                        "FREQUENCY"
                ),

                frequency,

                createFieldLabel(
                        "TRAINER NOTES"
                ),

                notes
        );

        // -----------------------------------------------------
        // BUTTONS
        // -----------------------------------------------------

        HBox buttons =
                new HBox(10);

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button back =
                new Button(
                        "←  Back to Workout Plans"
                );

        back.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-padding: 9 17;" +
                "-fx-background-radius: 9;" +
                "-fx-border-radius: 9;" +
                "-fx-cursor: hand;"
        );

        back.setOnAction(
                e -> stage.close()
        );

        Button create =
                new Button(
                        "+  Create Plan"
                );

        create.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 18;" +
                "-fx-background-radius: 9;" +
                "-fx-cursor: hand;"
        );

        create.setOnAction(
                e -> {

                    if (
                            planName.getText()
                                    .trim()
                                    .isEmpty()
                            ||
                            client.getText()
                                    .trim()
                                    .isEmpty()
                            ||
                            category.getValue() == null
                            ||
                            duration.getText()
                                    .trim()
                                    .isEmpty()
                            ||
                            frequency.getText()
                                    .trim()
                                    .isEmpty()
                    ) {

                        showInfo(
                                "Missing Information",
                                "Please complete all required fields."
                        );

                        return;
                    }

                    showInfo(
                            "Workout Plan Created",
                            planName.getText() +
                            " has been created successfully."
                    );

                    stage.close();
                }
        );

        buttons.getChildren().addAll(
                back,
                create
        );

        root.getChildren().addAll(
                heading,
                form,
                buttons
        );

        ScrollPane scroll =
                new ScrollPane(
                        root
                );

        scroll.setFitToWidth(
                true
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        Scene scene =
                new Scene(
                        scroll,
                        640,
                        690
                );

        scene.setFill(
                Color.TRANSPARENT
        );

        stage.setScene(
                scene
        );

        stage.setResizable(
                false
        );

        stage.showAndWait();
    }

    // =========================================================
    // EDIT FIELD
    // =========================================================

    private TextField createEditField(

            String label,
            String value

    ) {

        TextField field =
                new TextField(
                        value
                );

        field.setPrefHeight(
                40
        );

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setStyle(
                "-fx-background-color: rgba(255,255,255,0.045);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-prompt-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-padding: 0 13;" +
                "-fx-font-size: 11px;"
        );

        return field;
    }

    // =========================================================
    // FIELD LABEL
    // =========================================================

    private Label createFieldLabel(
            String text
    ) {

        Label label =
                new Label(
                        text
                );

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 8px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // COMBO BOX
    // =========================================================

    private void styleComboBox(
            ComboBox<String> combo
    ) {

        combo.setPrefHeight(
                40
        );

        combo.setMaxWidth(
                Double.MAX_VALUE
        );

        combo.setStyle(
                "-fx-background-color: rgba(255,255,255,0.045);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 11px;"
        );
    }

    // =========================================================
    // HORIZONTAL SPACER
    // =========================================================

    private Region createHorizontalSpacer(
            double width
    ) {

        Region spacer =
                new Region();

        spacer.setPrefWidth(
                width
        );

        return spacer;
    }

    // =========================================================
    // INFO
    // =========================================================

    private void showInfo(

            String title,
            String message

    ) {

        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(
                        javafx.scene.control.Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                title
        );

        alert.setHeaderText(
                null
        );

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }

    // =========================================================
    // NO ARGUMENT VERSION
    // =========================================================

    public Scene getWorkoutPlansScene() {

        return getWorkoutPlansScene(
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
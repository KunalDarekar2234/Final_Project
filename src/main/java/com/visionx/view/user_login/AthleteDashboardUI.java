
package com.visionx.view.user_login;

import com.visionx.view.SplashScreen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Popup;

public class AthleteDashboardUI {

    
    private Scene dashboardScene;

    // =========================================================
    // GET DASHBOARD SCENE
    // =========================================================

    public Scene getAthleteDashboardScene(Runnable callBackAction) {

        BorderPane borderPane = new BorderPane();

        borderPane.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #050912, #0a111d, #050912);");

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = new VBox(15);

        sidebar.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #020914, #06111d);" +
                        "-fx-padding: 30px 20px 20px 20px;" +
                        "-fx-border-color: #182330;" +
                        "-fx-border-width: 0 1 0 0;");

        sidebar.setPrefWidth(260);

        // =====================================================
        // LOGO
        // =====================================================

        Text logoTxt = new Text("FitVerse");

        logoTxt.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-fill: #62ff96;");

        Text subLogoTxt = new Text("AI FITNESS PRO");

        subLogoTxt.setStyle(
                "-fx-font-size: 9px;" +
                        "-fx-fill: #647180;" +
                        "-fx-font-weight: bold;" +
                        "-fx-letter-spacing: 3px;");

        VBox logoBox = new VBox(2, logoTxt, subLogoTxt);

        logoBox.setPadding(
                new Insets(0, 0, 30, 10));

        // =====================================================
        // NAVIGATION BUTTONS
        // =====================================================

        VBox navBox = new VBox(5);

        Button btnDashboard = createNavButton("Dashboard", true);

        Button btnAnalytics = createNavButton("Analytics", false);

        // Button btnAiMentor =
        // createNavButton("AI Mentor", false);

        Button btnPlanner = createNavButton("Planner", false);

        Button btnGymPlanner = createNavButton("Gym Planner", false);

        Button btnTrainers = createNavButton("Gym Trainers", false);

        Button btnFindGym = createNavButton("Find Gym", false);

        Button btnMarketplace = createNavButton("Marketplace", false);

        Button btnSettings = createNavButton("Settings", false);

        Button[] allNavBtns = {
                btnDashboard,
                btnAnalytics,
                // btnAiMentor,
                btnPlanner,
                btnGymPlanner,
                btnFindGym,
                btnTrainers,
                btnMarketplace,
                btnSettings
        };

        navBox.getChildren().addAll(allNavBtns);

        // =====================================================
        // SPACER
        // =====================================================

        Region spacer = new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS);

        // =====================================================
        // PREMIUM CARD
        // =====================================================

        VBox premiumCard = new VBox(8);

        String premiumNormal = "-fx-background-color: linear-gradient(to bottom right, #071c16, #07111d);" +
                "-fx-background-radius: 16px;" +
                "-fx-padding: 16px;" +
                "-fx-border-color: rgba(98,255,150,0.25);" +
                "-fx-border-radius: 16px;";

        String premiumHover = "-fx-background-color: #0b1825;" +
                "-fx-background-radius: 16px;" +
                "-fx-padding: 16px;" +
                "-fx-border-color: rgba(98,255,150,0.55);" +
                "-fx-border-radius: 16px;" +
                "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.25), 20, 0.2, 0, 4);";

        addHoverEffect(
                premiumCard,
                premiumNormal,
                premiumHover);

        Text premiumLabel = new Text("PREMIUM STATUS");

        premiumLabel.setStyle(
                "-fx-font-size:9px;" +
                        "-fx-fill:#62ff96;" +
                        "-fx-font-weight:bold;");

        Text upgradeText = new Text("Upgrade to Pro");

        upgradeText.setStyle(
                "-fx-font-size:14px;" +
                        "-fx-fill:#ffffff;" +
                        "-fx-font-weight:bold;");

        Button unlockBtn = new Button("Unlock Features");

        String unlockNormal = "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 20px;" +
                "-fx-padding: 8px 12px;" +
                "-fx-cursor: hand;";

        String unlockHover = "-fx-background-color: #9cffbb;" +
                "-fx-text-fill: #000000;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 20px;" +
                "-fx-padding: 8px 12px;" +
                "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.4), 18, 0.3, 0, 2);" +
                "-fx-cursor: hand;";

        addHoverEffect(
                unlockBtn,
                unlockNormal,
                unlockHover);

        unlockBtn.setMaxWidth(
                Double.MAX_VALUE);

        premiumCard.getChildren().addAll(
                premiumLabel,
                upgradeText,
                unlockBtn);

        // =====================================================
        // USER PROFILE
        // =====================================================

        HBox userProfile = new HBox(12);

        userProfile.setAlignment(
                Pos.CENTER_LEFT);

        userProfile.setPadding(
                new Insets(10, 0, 0, 0));

        Circle avatar = new Circle(18, Color.web("#3a3d41"));

        VBox userInfo = new VBox(2);

        Text userName = new Text("FitVerse User");

        userName.setStyle(
                "-fx-font-size:13px;" +
                        "-fx-fill:#ffffff;" +
                        "-fx-font-weight:bold;");

        Text userRole = new Text("Pro Athlete");

        userRole.setStyle(
                "-fx-font-size:11px;" +
                        "-fx-fill:#8a8d91;");

        userInfo.getChildren().addAll(
                userName,
                userRole);

        userProfile.getChildren().addAll(
                avatar,
                userInfo);

        sidebar.getChildren().addAll(
                logoBox,
                navBox,
                spacer,
                premiumCard,
                userProfile);

        borderPane.setLeft(sidebar);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent = new VBox(30);

        mainContent.setStyle(
                "-fx-background-color: #080C14;" +
                        "-fx-padding: 30px 40px 40px 40px;");

        mainContent.setMaxWidth(1100);

        // =====================================================
        // HEADER
        // =====================================================

        HBox topHeader = new HBox();

        topHeader.setAlignment(
                Pos.CENTER_LEFT);

        Text headerTitle1 = new Text("Athlete ");

        headerTitle1.setStyle(
                "-fx-font-size:22px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Text headerTitle2 = new Text("Dashboard");

        headerTitle2.setStyle(
                "-fx-font-size:22px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#62ff96;");

        HBox titleBox = new HBox(
                headerTitle1,
                headerTitle2);

        Region headerSpacer = new Region();

        HBox.setHgrow(
                headerSpacer,
                Priority.ALWAYS);

        TextField searchField = new TextField();

        searchField.setPromptText(
                "Search data...");

        searchField.setStyle(
                "-fx-background-color:#111a24;" +
                        "-fx-text-fill:#ffffff;" +
                        "-fx-prompt-text-fill:#596675;" +
                        "-fx-background-radius:22px;" +
                        "-fx-border-color:#1e2b38;" +
                        "-fx-border-radius:22px;" +
                        "-fx-padding:10px 16px;" +
                        "-fx-pref-width:250px;");

        Circle notifCircle = new Circle(18, Color.web("#212428"));

        Text notifText = new Text("🔔");
        notifText.setStyle("-fx-fill: #8a8d91; -fx-font-size: 16px;");

        StackPane notifIcon = new StackPane(notifCircle, notifText);
        notifIcon.setStyle("-fx-cursor: hand;");

        Popup notifPopup = new Popup();
        notifPopup.setAutoHide(true);

        VBox notifBox = new VBox(10);
        notifBox.setStyle(
                "-fx-background-color: #111a24;" +
                        "-fx-padding: 15px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-color: #1e2b38;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 0, 5);");
        notifBox.setPrefWidth(250);

        Text notifTitle = new Text("Notifications");
        notifTitle.setStyle("-fx-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 14px;");

        VBox notif1 = createNotificationItem("System", "Your metabolic score is updated!");
        VBox notif2 = createNotificationItem("Reminder", "Time for your afternoon workout.");
        VBox notif3 = createNotificationItem("Achievement", "You reached your protein goal today!");

        notifBox.getChildren().addAll(notifTitle, notif1, notif2, notif3);
        notifPopup.getContent().add(notifBox);

        notifIcon.setOnMouseClicked(e -> {
            if (!notifPopup.isShowing()) {
                javafx.geometry.Bounds bounds = notifIcon.localToScreen(notifIcon.getBoundsInLocal());
                notifPopup.show(notifIcon, bounds.getMinX() - 100, bounds.getMaxY() + 10);
            } else {
                notifPopup.hide();
            }
        });

        Circle settingsCircle = new Circle(18, Color.web("#212428"));

        Text settingsText = new Text("⚙");
        settingsText.setStyle("-fx-fill: #8a8d91; -fx-font-size: 18px;");

        StackPane settingsIcon = new StackPane(settingsCircle, settingsText);
        settingsIcon.setStyle("-fx-cursor: hand;");

        settingsIcon.setOnMouseClicked(e -> {
            btnSettings.fire();
        });

        HBox iconsBox = new HBox(
                10,
                searchField,
                notifIcon,
                settingsIcon);

        iconsBox.setAlignment(
                Pos.CENTER);

        topHeader.getChildren().addAll(
                titleBox,
                headerSpacer,
                iconsBox);

        // =====================================================
        // WELCOME SECTION
        // =====================================================

        HBox welcomeSection = new HBox();

        welcomeSection.setAlignment(
                Pos.BOTTOM_LEFT);

        VBox welcomeTexts = new VBox(5);

        Text welcomeTxt = new Text(
                "Welcome back, Darekar Kunal");

        welcomeTxt.setStyle(
                "-fx-font-size:32px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Text subWelcomeTxt = new Text(
                "Your current metabolic score is 92. Ready for today's session?");

        subWelcomeTxt.setStyle(
                "-fx-font-size:13px;" +
                        "-fx-fill:#8a8d91;");

        welcomeTexts.getChildren().addAll(
                welcomeTxt,
                subWelcomeTxt);

        Region welcomeSpacer = new Region();

        HBox.setHgrow(
                welcomeSpacer,
                Priority.ALWAYS);

        Button genWorkout = new Button("⚡ Generate Workout");

        String workoutNormal = "-fx-background-color:#62ff96;" +
                "-fx-text-fill:#06100a;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:13px;" +
                "-fx-background-radius:24px;" +
                "-fx-padding:11px 20px;" +
                "-fx-cursor:hand;";

        String workoutHover = "-fx-background-color:#8affb0;" +
                "-fx-text-fill:#000000;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:13px;" +
                "-fx-background-radius:24px;" +
                "-fx-padding:11px 20px;" +
                "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.45), 18, 0.3, 0, 0);" +
                "-fx-cursor:hand;";

        addHoverEffect(
                genWorkout,
                workoutNormal,
                workoutHover);

        Button genDiet = new Button("🍽 Generate Diet");

        // Button askAi =
        // new Button("🧠 Ask AI");

        String darkButtonNormal = "-fx-background-color:#151b24;" +
                "-fx-text-fill:#ffffff;" +
                "-fx-background-radius:24px;" +
                "-fx-padding:11px 20px;" +
                "-fx-border-color:#27303a;" +
                "-fx-border-radius:24px;" +
                "-fx-cursor:hand;";

        String darkButtonHover = "-fx-background-color:#1e2833;" +
                "-fx-text-fill:#62ff96;" +
                "-fx-background-radius:24px;" +
                "-fx-padding:11px 20px;" +
                "-fx-border-color:#62ff96;" +
                "-fx-border-radius:24px;" +
                "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.20), 15, 0.2, 0, 0);" +
                "-fx-cursor:hand;";

        addHoverEffect(
                genDiet,
                darkButtonNormal,
                darkButtonHover);

        // addHoverEffect(
        // askAi,
        // darkButtonNormal,
        // darkButtonHover
        // );

        // =====================================================
        // ASK AI
        // =====================================================

        // askAi.setOnAction(e -> {

        // AiMentorView aiMentorView =
        // new AiMentorView();

        // Node aiMentorPage =
        // aiMentorView
        // .getAiMentorScene(callBackAction)
        // .getRoot();

        // switchPage(
        // borderPane,
        // aiMentorPage,
        // btnAiMentor,
        // allNavBtns
        // );
        // });

        HBox actionButtons = new HBox(
                15,
                genWorkout,
                genDiet
        // askAi
        );

        welcomeSection.getChildren().addAll(
                welcomeTexts,
                welcomeSpacer,
                actionButtons);

        // =====================================================
        // STATS GRID
        // =====================================================

        HBox statsGrid = new HBox(20);

        statsGrid.getChildren().addAll(
                createBmiCard(),
                createRingCard(
                        "Calories",
                        "1,840",
                        "Target: 2,400",
                        76),
                createRingCard(
                        "Protein",
                        "112g",
                        "Target: 160g",
                        68),
                createRingCard(
                        "Hydration",
                        "2.4L",
                        "Target: 3.5L",
                        62));

        // =====================================================
        // MIDDLE SECTION
        // =====================================================

        HBox middleSection = new HBox(20);

        VBox chartBox = new VBox(10);

        chartBox.setStyle(
                "-fx-background-color:linear-gradient(to bottom right, #07111d, #091522);" +
                        "-fx-background-radius:18px;" +
                        "-fx-padding:25px;" +
                        "-fx-border-color:#172431;" +
                        "-fx-border-radius:18px;");

        HBox.setHgrow(
                chartBox,
                Priority.ALWAYS);

        chartBox.setPrefHeight(300);

        HBox chartTop = new HBox();

        VBox chartTexts = new VBox(2);

        Text chartTitle = new Text("Workout Progress");

        chartTitle.setStyle(
                "-fx-font-size:18px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Text chartSub = new Text(
                "Heart rate & Intensity over the last 7 days");

        chartSub.setStyle(
                "-fx-font-size:11px;" +
                        "-fx-fill:#8a8d91;");

        chartTexts.getChildren().addAll(
                chartTitle,
                chartSub);

        Region chartSpacer = new Region();

        HBox.setHgrow(
                chartSpacer,
                Priority.ALWAYS);

        HBox toggleBox = new HBox(10);

        Text weekTxt = new Text("Week");

        weekTxt.setStyle(
                "-fx-fill:#62ff96;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-color:rgba(98,255,150,0.1);" +
                        "-fx-padding:5px 10px;" +
                        "-fx-background-radius:10px;");

        Text monthTxt = new Text("Month");

        monthTxt.setStyle(
                "-fx-fill:#8a8d91;");

        toggleBox.getChildren().addAll(
                weekTxt,
                monthTxt);

        toggleBox.setAlignment(
                Pos.CENTER);

        chartTop.getChildren().addAll(
                chartTexts,
                chartSpacer,
                toggleBox);

        // =====================================================
        // WORKOUT GRAPH
        // =====================================================

        CategoryAxis xAxis = new CategoryAxis();

        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("");
        yAxis.setLabel("");

        LineChart<String, Number> workoutChart = new LineChart<>(
                xAxis,
                yAxis);

        workoutChart.setTitle("");

        workoutChart.setLegendVisible(false);
        workoutChart.setAnimated(false);
        workoutChart.setCreateSymbols(true);

        workoutChart.setStyle(
                "-fx-background-color:transparent;" +
                        "-fx-padding:10px;");

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        series.getData().add(
                new XYChart.Data<>("Mon", 65));

        series.getData().add(
                new XYChart.Data<>("Tue", 72));

        series.getData().add(
                new XYChart.Data<>("Wed", 58));

        series.getData().add(
                new XYChart.Data<>("Thu", 82));

        series.getData().add(
                new XYChart.Data<>("Fri", 75));

        series.getData().add(
                new XYChart.Data<>("Sat", 90));

        series.getData().add(
                new XYChart.Data<>("Sun", 85));

        workoutChart.getData().add(series);

        workoutChart.applyCss();
        workoutChart.layout();

        Node seriesLine = workoutChart.lookup(
                ".series0.chart-series-line");

        if (seriesLine != null) {

            seriesLine.setStyle(
                    "-fx-stroke:#62ff96;" +
                            "-fx-stroke-width:3px;");
        }

        Node chartSymbol = workoutChart.lookup(
                ".series0.chart-line-symbol");

        if (chartSymbol != null) {

            chartSymbol.setStyle(
                    "-fx-background-color:#62ff96, #07111d;" +
                            "-fx-background-insets:0, 2;");
        }

        xAxis.setTickLabelFill(
                Color.web("#8a8d91"));

        yAxis.setTickLabelFill(
                Color.web("#8a8d91"));

        xAxis.setTickLabelFont(
                javafx.scene.text.Font.font(10));

        yAxis.setTickLabelFont(
                javafx.scene.text.Font.font(10));

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(20);

        Node plotBackground = workoutChart.lookup(
                ".chart-plot-background");

        if (plotBackground != null) {

            plotBackground.setStyle(
                    "-fx-background-color:transparent;");
        }

        Node verticalGrid = workoutChart.lookup(
                ".chart-vertical-grid-lines");

        if (verticalGrid != null) {

            verticalGrid.setStyle(
                    "-fx-stroke:#212428;");
        }

        Node horizontalGrid = workoutChart.lookup(
                ".chart-horizontal-grid-lines");

        if (horizontalGrid != null) {

            horizontalGrid.setStyle(
                    "-fx-stroke:#212428;");
        }

        VBox chartArea = new VBox(workoutChart);

        chartArea.setAlignment(
                Pos.CENTER);

        chartArea.setPadding(
                new Insets(20, 0, 0, 0));

        VBox.setVgrow(
                chartArea,
                Priority.ALWAYS);

        chartBox.getChildren().addAll(
                chartTop,
                chartArea);

        // =====================================================
        // GOALS
        // =====================================================

        VBox goalsBox = new VBox(20);

        goalsBox.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #07111d, #091522);" +
                        "-fx-background-radius:18px;" +
                        "-fx-padding:25px;" +
                        "-fx-border-color:#172431;" +
                        "-fx-border-radius:18px;");

        goalsBox.setPrefWidth(320);

        Text goalsTitle = new Text("Today's Goal");

        goalsTitle.setStyle(
                "-fx-font-size:18px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Button addGoalBtn = new Button("+ Add New Goal");

        String goalButtonNormal = "-fx-background-color:transparent;" +
                "-fx-text-fill:#ffffff;" +
                "-fx-border-color:#293642;" +
                "-fx-border-radius:10px;" +
                "-fx-padding:10px;" +
                "-fx-cursor:hand;";

        String goalButtonHover = "-fx-background-color:rgba(98,255,150,0.08);" +
                "-fx-text-fill:#62ff96;" +
                "-fx-border-color:#62ff96;" +
                "-fx-border-radius:10px;" +
                "-fx-padding:10px;" +
                "-fx-cursor:hand;";

        addHoverEffect(
                addGoalBtn,
                goalButtonNormal,
                goalButtonHover);

        addGoalBtn.setMaxWidth(
                Double.MAX_VALUE);

        VBox goalsContainer = new VBox(15);

        goalsContainer.getChildren().addAll(
                createGoalItem(
                        "5km Morning Run",
                        "Completed at 06:45 AM",
                        true),
                createGoalItem(
                        "Push Day Session",
                        "Scheduled for 05:30 PM",
                        false),
                createGoalItem(
                        "Drink 3L Water",
                        "2.4L / 3.0L Tracked",
                        false));

        addGoalBtn.setOnAction(e -> {

            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle(
                    "Add New Goal");

            dialog.setHeaderText(
                    "Create Today's Goal");

            dialog.setContentText(
                    "Enter your goal:");

            dialog.showAndWait()
                    .ifPresent(goalName -> {

                        if (!goalName.trim().isEmpty()) {

                            HBox newGoal = createGoalItem(
                                    goalName.trim(),
                                    "Just now",
                                    false);

                            goalsContainer
                                    .getChildren()
                                    .add(newGoal);
                        }
                    });
        });

        goalsBox.getChildren().addAll(
                goalsTitle,
                goalsContainer,
                addGoalBtn);

        middleSection.getChildren().addAll(
                chartBox,
                goalsBox);

        // =====================================================
        // BOTTOM SECTION
        // =====================================================

        HBox bottomSection = new HBox(20);

        VBox aiBox = new VBox(15);

        aiBox.setStyle(
                "-fx-background-color:linear-gradient(to bottom right, #07111d, #091a17);" +
                        "-fx-background-radius:18px;" +
                        "-fx-padding:25px;" +
                        "-fx-border-color:rgba(98,255,150,0.20);" +
                        "-fx-border-radius:18px;" +
                        "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.06), 25, 0.2, 0, 5);");

        aiBox.setPrefWidth(300);

        HBox aiTop = new HBox(10);

        Circle aiIcon = new Circle(
                12,
                Color.web("rgba(98,255,150,0.2)"));

        Text aiTitle = new Text("AI INSIGHT");

        aiTitle.setStyle(
                "-fx-font-size:12px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#62ff96;" +
                        "-fx-letter-spacing:1px;");

        aiTop.getChildren().addAll(
                aiIcon,
                aiTitle);

        aiTop.setAlignment(
                Pos.CENTER_LEFT);

        Label aiText = new Label(
                "\"Your recovery rate is 15% higher than average today. I suggest pushing your bench press volume by 2.5kg. Your sleep data indicates perfect REM cycles for high-intensity power.\"");

        aiText.setWrapText(true);

        aiText.setStyle(
                "-fx-font-size:13px;" +
                        "-fx-text-fill:#ffffff;" +
                        "-fx-line-spacing:4px;");

        Text viewReport = new Text(
                "View detailed report →");

        viewReport.setStyle(
                "-fx-font-size:12px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#62ff96;");

        aiBox.getChildren().addAll(
                aiTop,
                aiText,
                viewReport);

        // =====================================================
        // ROUTINE
        // =====================================================

        HBox routineBox = new HBox(20);

        routineBox.setStyle(
                "-fx-background-color:linear-gradient(to right, #07111d, #091522);" +
                        "-fx-background-radius:18px;" +
                        "-fx-padding:20px;" +
                        "-fx-border-color:#172431;" +
                        "-fx-border-radius:18px;");

        HBox.setHgrow(
                routineBox,
                Priority.ALWAYS);

        StackPane routineImage = new StackPane();

        Image workoutImage = new Image(
                "https://images.unsplash.com/photo-1581009146145-b5ef050c2e1e?" +
                        "auto=format&fit=crop&w=600&q=80",
                200,
                140,
                false,
                true);

        ImageView workoutImageView = new ImageView(workoutImage);

        workoutImageView.setFitWidth(200);
        workoutImageView.setFitHeight(140);
        workoutImageView.setPreserveRatio(false);

        Rectangle clip = new Rectangle(200, 140);

        clip.setArcWidth(15);
        clip.setArcHeight(15);

        workoutImageView.setClip(clip);

        routineImage.getChildren().add(
                workoutImageView);

        VBox imgTagBox = new VBox(5);

        imgTagBox.setAlignment(
                Pos.BOTTOM_LEFT);

        imgTagBox.setPadding(
                new Insets(10));

        Text tag1 = new Text("TODAY'S FOCUS");

        tag1.setStyle(
                "-fx-background-color:#62ff96;" +
                        "-fx-fill:#000000;" +
                        "-fx-font-size:8px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-padding:2px 6px;");

        Text tag2 = new Text("Upper Body Power");

        tag2.setStyle(
                "-fx-fill:#ffffff;" +
                        "-fx-font-size:14px;" +
                        "-fx-font-weight:bold;");

        imgTagBox.getChildren().addAll(
                tag1,
                tag2);

        routineImage.getChildren().add(
                imgTagBox);

        VBox routineDetails = new VBox(10);

        HBox.setHgrow(
                routineDetails,
                Priority.ALWAYS);

        HBox blockTop = new HBox();

        Text blockTitle = new Text("Hypertrophy Block A");

        blockTitle.setStyle(
                "-fx-font-size:16px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Region bSpacer = new Region();

        HBox.setHgrow(
                bSpacer,
                Priority.ALWAYS);

        Text timeTxt = new Text("60 min");

        timeTxt.setStyle(
                "-fx-font-size:11px;" +
                        "-fx-fill:#62ff96;");

        blockTop.getChildren().addAll(
                blockTitle,
                bSpacer,
                timeTxt);

        Button startWorkout = new Button("Start Workout");

        String startNormal = "-fx-background-color:#151b24;" +
                "-fx-text-fill:#ffffff;" +
                "-fx-background-radius:10px;" +
                "-fx-padding:10px;" +
                "-fx-border-color:#293642;" +
                "-fx-border-radius:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;";

        String startHover = "-fx-background-color:#62ff96;" +
                "-fx-text-fill:#06100a;" +
                "-fx-background-radius:10px;" +
                "-fx-padding:10px;" +
                "-fx-border-color:#62ff96;" +
                "-fx-border-radius:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.35), 18, 0.3, 0, 2);" +
                "-fx-cursor:hand;";

        addHoverEffect(
                startWorkout,
                startNormal,
                startHover);

        startWorkout.setMaxWidth(
                Double.MAX_VALUE);

        startWorkout.setOnAction(e -> {

            WorkoutExecutionView workoutView = new WorkoutExecutionView();

            Node workoutPage = workoutView
                    .getWorkoutExecutionScene(
                            () -> {
                                System.out.println(
                                        "Workout finished");
                            })
                    .getRoot();

            switchPage(
                    borderPane,
                    workoutPage,
                    btnDashboard,
                    allNavBtns);
        });

        routineDetails.getChildren().addAll(
                blockTop,
                createExerciseRow(
                        "Bench Press",
                        "4 Sets x 8 Reps"),
                createExerciseRow(
                        "Weighted Pullups",
                        "3 Sets x 12 Reps"),
                createExerciseRow(
                        "Overhead Press",
                        "3 Sets x 10 Reps"),
                startWorkout);

        routineBox.getChildren().addAll(
                routineImage,
                routineDetails);

        bottomSection.getChildren().addAll(
                aiBox,
                routineBox);

        // =====================================================
        // TOP PERFORMER SECTION
        // =====================================================

        VBox topPerformerBox = new VBox(15);
        topPerformerBox.setStyle(
                "-fx-background-color:linear-gradient(to bottom right, #1a1505, #110e03);" +
                        "-fx-background-radius:18px;" +
                        "-fx-padding:20px;" +
                        "-fx-border-color:#33290b;" +
                        "-fx-border-radius:18px;" +
                        "-fx-effect:dropshadow(gaussian, rgba(255,215,0,0.1), 20, 0.2, 0, 0);");
        topPerformerBox.setMaxWidth(Double.MAX_VALUE);

        HBox performerHeader = new HBox();
        performerHeader.setAlignment(Pos.CENTER_LEFT);

        Text performerTitle = new Text("\uD83C\uDFC6 GYM LEADERBOARD #1");
        performerTitle.setStyle("-fx-font-size:12px; -fx-font-weight:bold; -fx-fill:#ffd700; -fx-letter-spacing:1px;");
        performerHeader.getChildren().add(performerTitle);

        HBox performerContent = new HBox(15);
        performerContent.setAlignment(Pos.CENTER_LEFT);

        Circle performerAvatar = new Circle(25, Color.web("#2a2307"));
        performerAvatar.setStroke(Color.web("#ffd700"));
        performerAvatar.setStrokeWidth(2);

        VBox performerDetails = new VBox(2);
        Text performerName = new Text("Alex Mercer");
        performerName.setStyle("-fx-font-size:16px; -fx-font-weight:bold; -fx-fill:#ffffff;");

        Text performerStats = new Text("Streak: 45 Days  \u2022  Total Volume: 12,400 kg  \u2022  Level 42");
        performerStats.setStyle("-fx-font-size:12px; -fx-fill:#8a8d91;");

        performerDetails.getChildren().addAll(performerName, performerStats);

        Region pSpacer = new Region();
        HBox.setHgrow(pSpacer, Priority.ALWAYS);

        Button viewProfileBtn = new Button("View Profile");
        String pBtnNormal = "-fx-background-color:transparent; -fx-text-fill:#ffd700; -fx-border-color:#ffd700; -fx-border-radius:10px; -fx-padding:8px 15px; -fx-cursor:hand;";
        String pBtnHover = "-fx-background-color:rgba(255,215,0,0.1); -fx-text-fill:#ffd700; -fx-border-color:#ffd700; -fx-border-radius:10px; -fx-padding:8px 15px; -fx-cursor:hand;";
        addHoverEffect(viewProfileBtn, pBtnNormal, pBtnHover);

        performerContent.getChildren().addAll(performerAvatar, performerDetails, pSpacer, viewProfileBtn);

        topPerformerBox.getChildren().addAll(performerHeader, performerContent);

        // =====================================================
        // FOOTER
        // =========================================================

        HBox footer = new HBox();

        footer.setStyle(
                "-fx-padding:18px 40px;" +
                        "-fx-background-color:#050a11;" +
                        "-fx-border-color:#17212c transparent transparent transparent;" +
                        "-fx-border-width:1px 0 0 0;");

        VBox fLogoBox = new VBox(2);

        Text fLogo = new Text("FitVerse");

        fLogo.setStyle(
                "-fx-fill:#62ff96;" +
                        "-fx-font-size:18px;" +
                        "-fx-font-weight:bold;");

        Text fCopy = new Text(
                "© 2024 FitVerse AI. All rights reserved.");

        fCopy.setStyle(
                "-fx-fill:#8a8d91;" +
                        "-fx-font-size:10px;");

        fLogoBox.getChildren().addAll(
                fLogo,
                fCopy);

        Region fSpacer = new Region();

        HBox.setHgrow(
                fSpacer,
                Priority.ALWAYS);

        HBox fLinks = new HBox(20);

        fLinks.setAlignment(
                Pos.CENTER);

        String[] links = {
                "Privacy Policy",
                "Terms of Service",
                "Contact",
                "About"
        };

        for (String l : links) {

            Text t = new Text(l);

            t.setStyle(
                    "-fx-fill:#8a8d91;" +
                            "-fx-font-size:11px;" +
                            "-fx-font-weight:bold;");

            fLinks.getChildren().add(t);
        }

        footer.getChildren().addAll(
                fLogoBox,
                fSpacer,
                fLinks);

        // =====================================================
        // ADD MAIN CONTENT
        // =====================================================

        mainContent.getChildren().addAll(
                topHeader,
                welcomeSection,
                statsGrid,
                middleSection,
                bottomSection,
                topPerformerBox,
                footer);

        // =====================================================
        // FOOTER
        // =====================================================

        // HBox footer =
        // new HBox();

        // footer.setStyle(
        // "-fx-padding:18px 40px;" +
        // "-fx-background-color:#050a11;" +
        // "-fx-border-color:#17212c transparent transparent transparent;" +
        // "-fx-border-width:1px 0 0 0;"
        // );

        // VBox fLogoBox =
        // new VBox(2);

        // Text fLogo =
        // new Text("FitVerse");

        // fLogo.setStyle(
        // "-fx-fill:#62ff96;" +
        // "-fx-font-size:18px;" +
        // "-fx-font-weight:bold;"
        // );

        // Text fCopy =
        // new Text(
        // "© 2024 FitVerse AI. All rights reserved."
        // );

        // fCopy.setStyle(
        // "-fx-fill:#8a8d91;" +
        // "-fx-font-size:10px;"
        // );

        // fLogoBox.getChildren().addAll(
        // fLogo,
        // fCopy
        // );

        // Region fSpacer =
        // new Region();

        // HBox.setHgrow(
        // fSpacer,
        // Priority.ALWAYS
        // );

        // HBox fLinks =
        // new HBox(20);

        // fLinks.setAlignment(
        // Pos.CENTER
        // );

        // String[] links = {
        // "Privacy Policy",
        // "Terms of Service",
        // "Contact",
        // "About"
        // };

        // for (String l : links) {

        // Text t =
        // new Text(l);

        // t.setStyle(
        // "-fx-fill:#8a8d91;" +
        // "-fx-font-size:11px;" +
        // "-fx-font-weight:bold;"
        // );

        // fLinks.getChildren().add(t);
        // }

        // footer.getChildren().addAll(
        // fLogoBox,
        // fSpacer,
        // fLinks
        // );

        // =====================================================
        // DASHBOARD ROOT
        // =====================================================

        BorderPane dashboardRoot = new BorderPane();

        ScrollPane scrollPane = new ScrollPane(mainContent);

        scrollPane.setStyle(
                "-fx-background:#080C14;" +
                        "-fx-background-color:#080C14;" +
                        "-fx-border-color:transparent;");

        scrollPane.setFitToWidth(true);

        dashboardRoot.setCenter(
                scrollPane);

        // dashboardRoot.setBottom(
        // footer
        // );

        borderPane.setCenter(
                dashboardRoot);

        // StackPane pageRoot = new StackPane();

        // pageRoot.getChildren().add(borderPane);

        // AiMentorFloating.addTo(pageRoot);

        // =====================================================
        // DASHBOARD
        // =====================================================

        btnDashboard.setOnAction(e -> {

            switchPage(
                    borderPane,
                    dashboardRoot,
                    btnDashboard,
                    allNavBtns);
        });

        // =====================================================
        // ANALYTICS
        // =====================================================

        btnAnalytics.setOnAction(e -> {

            ProgressAnalyticsView progressAnalyticsView = new ProgressAnalyticsView();

            Node analyticsPage = progressAnalyticsView
                    .getAnalyticsScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    analyticsPage,
                    btnAnalytics,
                    allNavBtns);
        });

        // =====================================================
        // AI MENTOR
        // =====================================================

        // btnAiMentor.setOnAction(e -> {

        // AiMentorView aiMentorView =
        // new AiMentorView();

        // Node aiMentorPage =
        // aiMentorView
        // .getAiMentorScene(callBackAction)
        // .getRoot();

        // switchPage(
        // borderPane,
        // aiMentorPage,
        // btnAiMentor,
        // allNavBtns
        // );
        // });

        // =====================================================
        // PLANNER
        // =====================================================

        btnPlanner.setOnAction(e -> {

            DietPlannerView dietPlannerView = new DietPlannerView();

            Node plannerPage = dietPlannerView
                    .getDietPlannerScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    plannerPage,
                    btnPlanner,
                    allNavBtns);
        });

        // =====================================================
        // GYM PLANNER
        // =====================================================

        btnGymPlanner.setOnAction(e -> {

            GymPlannerView gymPlannerView = new GymPlannerView();

            Node gymPlannerPage = gymPlannerView
                    .getGymPlannerScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    gymPlannerPage,
                    btnGymPlanner,
                    allNavBtns);
        });

        // =====================================================
        // FIND GYM
        // =====================================================

        btnFindGym.setOnAction(e -> {

            GymFinderView gymFinderView = new GymFinderView();

            Node gymPage = gymFinderView
                    .getGymFinderScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    gymPage,
                    btnFindGym,
                    allNavBtns);
        });

        // =====================================================
        // GYM TRAINERS
        // =====================================================

        btnTrainers.setOnAction(e -> {

            GymTrainerView gymTrainerView = new GymTrainerView();

            Node trainerPage = gymTrainerView
                    .getTrainerScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    trainerPage,
                    btnTrainers,
                    allNavBtns);
        });
        // =====================================================
        // SETTINGS
        // =====================================================

        btnSettings.setOnAction(e -> {

            AccountSettingsView accountSettingsView = new AccountSettingsView();

            Node settingsPage = accountSettingsView
                    .getAccountSettingsScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    settingsPage,
                    btnSettings,
                    allNavBtns);
        });

        // =====================================================
        // MARKETPLACE
        // =====================================================

        btnMarketplace.setOnAction(e -> {

            SupplementMarketplaceView marketplaceView = new SupplementMarketplaceView();

            Node marketplacePage = marketplaceView
                    .getMarketplaceScene(callBackAction)
                    .getRoot();

            switchPage(
                    borderPane,
                    marketplacePage,
                    btnMarketplace,
                    allNavBtns);
        });

        StackPane pageRoot = new StackPane();

        pageRoot.getChildren().add(borderPane);

        AiMentorFloating.addTo(pageRoot);

        // =====================================================
        // SCENE
        // =====================================================

        dashboardScene = new Scene(
                pageRoot,
                SplashScreen.primaryStage.getWidth(),
                SplashScreen.primaryStage.getHeight());

        SplashScreen.primaryStage.setMaximized(true);

        return dashboardScene;
    }

    // =========================================================
    // NAVIGATION LOGIC
    // =========================================================

    private void switchPage(
            BorderPane mainPane,
            Node newContent,
            Button activeBtn,
            Button[] allBtns) {

        // Change page
        mainPane.setCenter(
                newContent);

        // =====================================================
        // IMPORTANT:
        // ACTIVE SIDEBAR EFFECT
        // =====================================================

        for (Button btn : allBtns) {

            if (btn == activeBtn) {

                btn.setUserData(true);

                setActiveButtonStyle(btn);

            } else {

                btn.setUserData(false);

                setNormalButtonStyle(btn);
            }
        }
    }

    // =========================================================
    // ACTIVE NAV BUTTON
    // =========================================================

    private void setActiveButtonStyle(Button btn) {

        btn.setStyle(
                "-fx-background-color:rgba(98,255,150,0.10);" +
                        "-fx-text-fill:#62ff96;" +
                        "-fx-font-size:13px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-padding:12px 15px;" +
                        "-fx-background-radius:12px;" +
                        "-fx-border-color:#62ff96;" +
                        "-fx-border-width:0 0 0 3px;" +
                        "-fx-cursor:hand;" +
                        "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.12), 12, 0.2, 0, 0);");
    }

    // =========================================================
    // NORMAL NAV BUTTON
    // =========================================================

    private void setNormalButtonStyle(Button btn) {

        btn.setStyle(
                "-fx-background-color:transparent;" +
                        "-fx-text-fill:#8a8d91;" +
                        "-fx-font-size:13px;" +
                        "-fx-padding:12px 15px;" +
                        "-fx-background-radius:12px;" +
                        "-fx-cursor:hand;");
    }

    // =========================================================
    // NAV BUTTON CREATOR
    // =========================================================

    private Button createNavButton(
            String text,
            boolean isActive) {

        Button btn = new Button("   " + text);

        btn.setPrefWidth(220);
        btn.setPrefHeight(46);

        btn.setAlignment(
                Pos.CENTER_LEFT);

        // true = active
        btn.setUserData(isActive);

        if (isActive) {

            setActiveButtonStyle(btn);

        } else {

            setNormalButtonStyle(btn);
        }

        // =====================================================
        // HOVER EFFECT
        // =====================================================

        btn.setOnMouseEntered(e -> {

            boolean active = Boolean.TRUE.equals(
                    btn.getUserData());

            if (active) {

                btn.setStyle(
                        "-fx-background-color:rgba(98,255,150,0.18);" +
                                "-fx-text-fill:#ffffff;" +
                                "-fx-font-size:13px;" +
                                "-fx-font-weight:bold;" +
                                "-fx-padding:12px 15px;" +
                                "-fx-background-radius:12px;" +
                                "-fx-border-color:#62ff96;" +
                                "-fx-border-width:0 0 0 4px;" +
                                "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.28), 18, 0.25, 0, 0);" +
                                "-fx-cursor:hand;");

            } else {

                btn.setStyle(
                        "-fx-background-color:rgba(98,255,150,0.07);" +
                                "-fx-text-fill:#62ff96;" +
                                "-fx-font-size:13px;" +
                                "-fx-padding:12px 15px;" +
                                "-fx-background-radius:12px;" +
                                "-fx-border-color:rgba(98,255,150,0.15);" +
                                "-fx-border-radius:12px;" +
                                "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.08), 10, 0.2, 0, 0);" +
                                "-fx-cursor:hand;");
            }
        });

        // =====================================================
        // MOUSE EXIT
        // =====================================================

        btn.setOnMouseExited(e -> {

            boolean active = Boolean.TRUE.equals(
                    btn.getUserData());

            if (active) {

                setActiveButtonStyle(btn);

            } else {

                setNormalButtonStyle(btn);
            }
        });

        return btn;
    }

    // =========================================================
    // PLACEHOLDER
    // =========================================================

    private BorderPane createPlaceholder(
            String pageTitle,
            HBox footer) {

        BorderPane pane = new BorderPane();

        pane.setStyle(
                "-fx-background-color:#020c19;");

        VBox centerBox = new VBox(15);

        centerBox.setAlignment(
                Pos.CENTER);

        Text title = new Text(pageTitle);

        title.setStyle(
                "-fx-font-size:32px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Text subtitle = new Text(
                "Page content will be rendered here soon.");

        subtitle.setStyle(
                "-fx-font-size:16px;" +
                        "-fx-fill:#8a8d91;");

        centerBox.getChildren().addAll(
                title,
                subtitle);

        pane.setCenter(
                centerBox);

        pane.setBottom(
                footer);

        return pane;
    }

    // =========================================================
    // BMI CARD
    // =========================================================

    private VBox createBmiCard() {

        VBox card = new VBox(12);

        card.setStyle(
                "-fx-background-color:#020c19;" +
                        "-fx-background-radius:16px;" +
                        "-fx-padding:20px;");

        HBox.setHgrow(
                card,
                Priority.ALWAYS);

        HBox top = new HBox();

        VBox texts = new VBox(5);

        Text titleTxt = new Text("Current BMI");

        titleTxt.setStyle(
                "-fx-font-size:12px;" +
                        "-fx-fill:#8a8d91;");

        Text valTxt = new Text("22.4");

        valTxt.setStyle(
                "-fx-font-size:28px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        texts.getChildren().addAll(
                titleTxt,
                valTxt);

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS);

        Circle icon = new Circle(
                15,
                Color.web("rgba(98,255,150,0.1)"));

        top.getChildren().addAll(
                texts,
                spacer,
                icon);

        Rectangle bgLine = new Rectangle(
                180,
                4,
                Color.web("#2a2d31"));

        bgLine.setArcWidth(4);
        bgLine.setArcHeight(4);

        Rectangle fgLine = new Rectangle(
                120,
                4,
                Color.web("#62ff96"));

        fgLine.setArcWidth(4);
        fgLine.setArcHeight(4);

        StackPane bar = new StackPane(
                bgLine,
                fgLine);

        bar.setAlignment(
                Pos.CENTER_LEFT);

        Text subTxt = new Text(
                "Ideal range: 18.5 - 24.9");

        subTxt.setStyle(
                "-fx-font-size:10px;" +
                        "-fx-fill:#8a8d91;");

        card.getChildren().addAll(
                top,
                bar,
                subTxt);

        return card;
    }

    // =========================================================
    // RING CARD
    // =========================================================

    private HBox createRingCard(
            String title,
            String value,
            String subText,
            int percentage) {

        HBox card = new HBox(15);

        card.setStyle(
                "-fx-background-color:#020c19;" +
                        "-fx-background-radius:16px;" +
                        "-fx-padding:20px;");

        HBox.setHgrow(
                card,
                Priority.ALWAYS);

        card.setAlignment(
                Pos.CENTER_LEFT);

        VBox texts = new VBox(5);

        Text titleTxt = new Text(title);

        titleTxt.setStyle(
                "-fx-font-size:12px;" +
                        "-fx-fill:#8a8d91;");

        Text valTxt = new Text(value);

        valTxt.setStyle(
                "-fx-font-size:24px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        Text subTxt = new Text(subText);

        subTxt.setStyle(
                "-fx-font-size:10px;" +
                        "-fx-fill:#62ff96;");

        texts.getChildren().addAll(
                titleTxt,
                valTxt,
                subTxt);

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS);

        StackPane ringPane = new StackPane();

        Circle bgCircle = new Circle(
                25,
                Color.TRANSPARENT);

        bgCircle.setStroke(
                Color.web("#2a2d31"));

        bgCircle.setStrokeWidth(5);

        Arc fgArc = new Arc(
                0,
                0,
                25,
                25,
                90,
                -360 * (percentage / 100.0));

        fgArc.setType(
                ArcType.OPEN);

        fgArc.setFill(
                Color.TRANSPARENT);

        fgArc.setStroke(
                Color.web("#62ff96"));

        fgArc.setStrokeWidth(5);

        Text percentTxt = new Text(
                percentage + "%");

        percentTxt.setStyle(
                "-fx-font-size:11px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#ffffff;");

        ringPane.getChildren().addAll(
                bgCircle,
                fgArc,
                percentTxt);

        card.getChildren().addAll(
                texts,
                spacer,
                ringPane);

        return card;
    }

    // =========================================================
    // GOAL ITEM
    // =========================================================

    private HBox createGoalItem(
            String title,
            String subText,
            boolean completed) {

        HBox box = new HBox(15);

        box.setAlignment(
                Pos.CENTER_LEFT);

        box.setStyle(
                "-fx-border-color:#2a2d31;" +
                        "-fx-border-width:0 0 1 0;" +
                        "-fx-padding:0 0 15px 0;");

        Button checkButton = new Button();

        checkButton.setMinSize(
                36,
                36);

        checkButton.setMaxSize(
                36,
                36);

        VBox texts = new VBox(3);

        Text t1 = new Text(title);

        Text t2 = new Text(subText);

        texts.getChildren().addAll(
                t1,
                t2);

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS);

        final boolean[] isCompleted = {
                completed
        };

        Runnable updateGoalStyle = () -> {

            if (isCompleted[0]) {

                checkButton.setText("✓");

                checkButton.setStyle(
                        "-fx-background-color:#62ff96;" +
                                "-fx-text-fill:#000000;" +
                                "-fx-font-size:16px;" +
                                "-fx-font-weight:bold;" +
                                "-fx-background-radius:50%;" +
                                "-fx-border-radius:50%;");

                t1.setStyle(
                        "-fx-font-size:13px;" +
                                "-fx-fill:#62ff96;" +
                                "-fx-strikethrough:true;");

                t2.setText(
                        "Completed ✓");

                t2.setStyle(
                        "-fx-font-size:11px;" +
                                "-fx-fill:#62ff96;");

            } else {

                checkButton.setText("○");

                checkButton.setStyle(
                        "-fx-background-color:transparent;" +
                                "-fx-text-fill:#8a8d91;" +
                                "-fx-font-size:20px;" +
                                "-fx-font-weight:bold;" +
                                "-fx-border-color:#8a8d91;" +
                                "-fx-border-radius:50%;");

                t1.setStyle(
                        "-fx-font-size:13px;" +
                                "-fx-fill:#ffffff;" +
                                "-fx-strikethrough:false;");

                t2.setStyle(
                        "-fx-font-size:11px;" +
                                "-fx-fill:#8a8d91;");
            }
        };

        updateGoalStyle.run();

        checkButton.setOnAction(e -> {

            isCompleted[0] = !isCompleted[0];

            updateGoalStyle.run();
        });

        String goalNormal = "-fx-background-color:transparent;" +
                "-fx-border-color:#1d2935;" +
                "-fx-border-width:0 0 1 0;" +
                "-fx-padding:0 0 15px 0;";

        String goalHover = "-fx-background-color:rgba(98,255,150,0.035);" +
                "-fx-border-color:rgba(98,255,150,0.20);" +
                "-fx-border-width:0 0 1 0;" +
                "-fx-padding:0 0 15px 0;" +
                "-fx-background-radius:8px;";

        addHoverEffect(
                box,
                goalNormal,
                goalHover);

        box.getChildren().addAll(
                checkButton,
                texts,
                spacer);

        return box;
    }

    // =========================================================
    // EXERCISE ROW
    // =========================================================

    private HBox createExerciseRow(
            String name,
            String reps) {

        HBox row = new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT);

        String normal = "-fx-background-color:#111a24;" +
                "-fx-background-radius:8px;" +
                "-fx-padding:11px 15px;" +
                "-fx-border-color:transparent;" +
                "-fx-border-radius:8px;" +
                "-fx-cursor:hand;";

        String hover = "-fx-background-color:rgba(98,255,150,0.08);" +
                "-fx-background-radius:8px;" +
                "-fx-padding:11px 15px;" +
                "-fx-border-color:rgba(98,255,150,0.25);" +
                "-fx-border-radius:8px;" +
                "-fx-cursor:hand;";

        addHoverEffect(
                row,
                normal,
                hover);

        Text tName = new Text(name);

        tName.setStyle(
                "-fx-font-size:12px;" +
                        "-fx-fill:#b8c1ca;");

        Region space = new Region();

        HBox.setHgrow(
                space,
                Priority.ALWAYS);

        Text tReps = new Text(reps);

        tReps.setStyle(
                "-fx-font-size:12px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#62ff96;");

        row.getChildren().addAll(
                tName,
                space,
                tReps);

        return row;
    }

    // =========================================================
    // GENERAL HOVER EFFECT
    // =========================================================

    private void addHoverEffect(
            Node node,
            String normalStyle,
            String hoverStyle) {

        node.setStyle(
                normalStyle);

        node.setOnMouseEntered(e -> {

            node.setStyle(
                    hoverStyle);

            node.setScaleX(
                    1.02);

            node.setScaleY(
                    1.02);
        });

        node.setOnMouseExited(e -> {

            node.setStyle(
                    normalStyle);

            node.setScaleX(
                    1.0);

            node.setScaleY(
                    1.0);
        });
    }

    private VBox createNotificationItem(String title, String desc) {
        VBox item = new VBox(5);
        item.setPadding(new Insets(10));
        item.setStyle(
                "-fx-background-color: #1a2634;" +
                        "-fx-background-radius: 8px;");

        Text titleText = new Text(title);
        titleText.setStyle("-fx-fill: #62ff96; -fx-font-weight: bold; -fx-font-size: 13px;");

        Text descText = new Text(desc);
        descText.setStyle("-fx-fill: #8a8d91; -fx-font-size: 11px;");
        descText.setWrappingWidth(210);

        item.getChildren().addAll(titleText, descText);

        addHoverEffect(item,
                "-fx-background-color: #1a2634; -fx-background-radius: 8px;",
                "-fx-background-color: #233446; -fx-background-radius: 8px;");

        return item;
    }

    // =========================================================
    // =========================================================

    // @Override
    // public void start(Stage stage)
    // throws Exception {

    // primaryStage =
    // stage;

    // Runnable dummyCallback =
    // () -> {

    // System.out.println(
    // "Navigating..."
    // );
    // };

    // stage.setScene(
    // getAthleteDashboardScene(
    // dummyCallback
    // )
    // );

    // stage.setTitle(
    // "FitVerse - AI Athlete Dashboard"
    // );

    // stage.setMaximized(
    // true
    // );

    // stage.show();
    // }
}
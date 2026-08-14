package com.visionx.view.super_admin;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Dashboard extends Application {
        public static Stage homeStage;
        private static Scene DashboardScene;
        private static javafx.scene.Parent dashboardRoot;

        // =========================================================
        // COLORS
        // =========================================================

        private static final String NAVY = "#07152D";
        private static final String BLUE = "#1479E8";
        private static final String BLUE_DARK = "#0D6DD8";

        private static final String BACKGROUND = "#F4F7FB";
        private static final String WHITE = "#FFFFFF";
        private static final String BORDER = "#DDE3EB";

        private static final String TEXT = "#171A1F";
        private static final String GRAY = "#667085";
        private static final String LIGHT_GRAY = "#F1F4F8";

        private static final String GREEN = "#21A366";
        private static final String LIGHT_GREEN = "#E4F7EC";

        private static final String RED = "#D92D3A";
        private static final String LIGHT_RED = "#FDE7E9";

        private static final String ORANGE = "#F59E0B";
        private static final String LIGHT_ORANGE = "#FFF4D8";

        public static void switchScene(Scene scene) {
                if (homeStage.getScene() != null) {
                        if (scene == DashboardScene) {
                                homeStage.getScene().setRoot(dashboardRoot);
                        } else {
                                javafx.scene.Parent root = scene.getRoot();
                                scene.setRoot(new javafx.scene.layout.Region()); // Detach from new scene
                                homeStage.getScene().setRoot(root); // Attach to current scene
                        }
                } else {
                        homeStage.setScene(scene);
                        homeStage.setMaximized(true);
                }
        }

        @Override
        public void start(Stage stage) {
                homeStage = stage;

                // =====================================================
                // ROOT
                // =====================================================

                BorderPane root = new BorderPane();
                dashboardRoot = root;

                root.setStyle(
                                "-fx-background-color: " + BACKGROUND + ";");

                // =====================================================
                // SIDEBAR
                // =====================================================

                VBox sidebar = createSidebar();

                // =====================================================
                // RIGHT AREA
                // =====================================================

                BorderPane rightArea = new BorderPane();

                HBox topBar = createTopBar();

                BorderPane content = createDashboardContent();

                rightArea.setTop(topBar);
                rightArea.setCenter(content);

                // =====================================================
                // ROOT
                // =====================================================

                root.setLeft(sidebar);
                root.setCenter(rightArea);

                // =====================================================
                // SCENE
                // =====================================================

                Scene scene = new Scene(
                                root,
                                stage.getWidth(),
                                stage.getHeight()

                );
                stage.setMaximized(true);

                stage.setTitle(
                                "FitVerse - Super Admin Dashboard");

                DashboardScene = scene;
                stage.setScene(scene);

                stage.setMinWidth(1100);
                stage.setMinHeight(700);

                stage.setMaximized(true);

                stage.show();
        }

        // =========================================================
        // SIDEBAR
        // =========================================================

        private VBox createSidebar() {

                VBox sidebar = new VBox();

                sidebar.setPrefWidth(235);
                sidebar.setMinWidth(235);
                sidebar.setMaxWidth(235);

                sidebar.setPadding(
                                new Insets(25, 10, 20, 10));

                sidebar.setStyle(
                                "-fx-background-color: " + NAVY + ";");

                // =====================================================
                // LOGO
                // =====================================================

                HBox logo = new HBox(10);

                logo.setAlignment(
                                Pos.CENTER_LEFT);

                logo.setPadding(
                                new Insets(0, 10, 30, 10));

                Label logoIcon = new Label("➤");

                logoIcon.setFont(
                                Font.font(
                                                27));

                logoIcon.setTextFill(
                                Color.web(BLUE));

                Label logoText = new Label(
                                "FitVerse");

                logoText.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                23));

                logoText.setTextFill(
                                Color.WHITE);

                logo.getChildren().addAll(
                                logoIcon,
                                logoText);

                // =====================================================
                // MENU
                // =====================================================

                VBox menu = new VBox(7);

                HBox dashboardItem = createMenuItem("▦", "Dashboard", true);
                HBox usersItem = createMenuItem("♙", "Users", false);
                HBox gymsItem = createMenuItem("♜", "Gyms", false);
                HBox storesItem = createMenuItem("▤", "Stores", false);
                HBox reportsItem = createMenuItem("▥", "Reports", false);
                HBox settingsItem = createMenuItem("⚙", "Settings", false);

                Runnable backToDashboard = () -> switchScene(DashboardScene);

                usersItem.setOnMouseClicked(e -> {
                        UserManagement um = new UserManagement();
                        switchScene(um.getUserManagementScene(backToDashboard));
                });

                gymsItem.setOnMouseClicked(e -> {
                        GymManagement gm = new GymManagement();
                        switchScene(gm.getGymManagementScene(backToDashboard));
                });

                storesItem.setOnMouseClicked(e -> {
                        SupplementStoreManagement sm = new SupplementStoreManagement();
                        switchScene(sm.getSupplementStoreManagementScene(backToDashboard));
                });

                reportsItem.setOnMouseClicked(e -> {
                        Reports rm = new Reports();
                        switchScene(rm.getReportsScene(backToDashboard));
                });

                settingsItem.setOnMouseClicked(e -> {
                        SettingsPage sp = new SettingsPage();
                        switchScene(sp.getSettingsPageScene(backToDashboard));
                });

                menu.getChildren().addAll(
                                dashboardItem,
                                usersItem,
                                gymsItem,
                                storesItem,
                                reportsItem,
                                settingsItem);

                Region spacer = new Region();

                VBox.setVgrow(
                                spacer,
                                Priority.ALWAYS);

                // =====================================================
                // BOTTOM AREA (PROFILE + LOGOUT)
                // =====================================================

                VBox bottom = new VBox(20);

                HBox profileArea = new HBox(12);
                profileArea.setAlignment(Pos.CENTER_LEFT);

                javafx.scene.shape.Circle profileCircle = new javafx.scene.shape.Circle(17);
                profileCircle.setFill(Color.web("#E3EAF4"));

                Label profileLetter = new Label("J");
                profileLetter.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                // profileLetter.setTextFill(Color.web(DARK_BLUE));

                StackPane profile = new StackPane(profileCircle, profileLetter);

                VBox adminInfo = new VBox(2);
                adminInfo.setAlignment(Pos.CENTER_LEFT);

                Label adminName = new Label("John Doe");
                adminName.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                adminName.setTextFill(Color.WHITE);

                Label adminRole = new Label("Admin");
                adminRole.setFont(Font.font("Arial", 11));
                adminRole.setTextFill(Color.web("#9AA7BB"));

                adminInfo.getChildren().addAll(adminName, adminRole);

                profileArea.getChildren().addAll(profile, adminInfo);

                HBox logoutItem = createMenuItem("↪", "Logout", false);

                bottom.getChildren().addAll(profileArea, logoutItem);

                sidebar.getChildren().addAll(
                                logo,
                                menu,
                                spacer,
                                bottom);

                return sidebar;
        }

        // =========================================================
        // MENU ITEM
        // =========================================================

        private HBox createMenuItem(
                        String icon,
                        String text,
                        boolean active) {

                HBox item = new HBox(13);

                item.setAlignment(
                                Pos.CENTER_LEFT);

                item.setPrefHeight(42);

                item.setPadding(
                                new Insets(
                                                0,
                                                12,
                                                0,
                                                14));

                Label iconLabel = new Label(
                                icon);

                iconLabel.setFont(
                                Font.font(18));

                Label textLabel = new Label(
                                text);

                textLabel.setFont(
                                Font.font(
                                                "Arial",
                                                active
                                                                ? FontWeight.BOLD
                                                                : FontWeight.NORMAL,
                                                14));

                if (active) {

                        item.setStyle(
                                        "-fx-background-color: " + BLUE + ";" +
                                                        "-fx-background-radius: 8;");

                        iconLabel.setTextFill(
                                        Color.WHITE);

                        textLabel.setTextFill(
                                        Color.WHITE);

                } else {

                        item.setStyle(
                                        "-fx-background-color: transparent;" +
                                                        "-fx-background-radius: 8;");

                        iconLabel.setTextFill(
                                        Color.web("#9AA7BB"));

                        textLabel.setTextFill(
                                        Color.web("#AEB8C8"));

                        item.setOnMouseEntered(e -> {

                                item.setStyle(
                                                "-fx-background-color: #102342;" +
                                                                "-fx-background-radius: 8;");

                        });

                        item.setOnMouseExited(e -> {

                                item.setStyle(
                                                "-fx-background-color: transparent;" +
                                                                "-fx-background-radius: 8;");

                        });
                }

                item.getChildren().addAll(
                                iconLabel,
                                textLabel);

                return item;
        }

        // =========================================================
        // TOP BAR
        // =========================================================

        private HBox createTopBar() {

                HBox topBar = new HBox();

                topBar.setPrefHeight(65);

                topBar.setPadding(
                                new Insets(
                                                0,
                                                25,
                                                0,
                                                25));

                topBar.setAlignment(
                                Pos.CENTER);

                topBar.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-width: 0 0 1 0;");

                // =====================================================
                // BREADCRUMB
                // =====================================================

                HBox breadcrumb = new HBox(9);

                breadcrumb.setAlignment(
                                Pos.CENTER_LEFT);

                Label home = new Label(
                                "Home");

                home.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                home.setTextFill(
                                Color.web(GRAY));

                Label slash = new Label(
                                "/");

                slash.setFont(
                                Font.font(14));

                slash.setTextFill(
                                Color.web("#98A2B3"));

                Label dashboard = new Label(
                                "Dashboard");

                dashboard.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                14));

                dashboard.setTextFill(
                                Color.web(TEXT));

                breadcrumb.getChildren().addAll(
                                home,
                                slash,
                                dashboard);

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                // =====================================================
                // SEARCH
                // =====================================================

                HBox searchBox = new HBox(8);

                searchBox.setPrefWidth(270);
                searchBox.setPrefHeight(40);

                searchBox.setAlignment(
                                Pos.CENTER_LEFT);

                searchBox.setPadding(
                                new Insets(
                                                0,
                                                12,
                                                0,
                                                12));

                searchBox.setStyle(
                                "-fx-background-color: #F3F6FA;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;");

                Label searchIcon = new Label(
                                "⌕");

                searchIcon.setFont(
                                Font.font(22));

                searchIcon.setTextFill(
                                Color.web("#475467"));

                TextField search = new TextField();

                search.setPromptText(
                                "Search...");

                search.setFont(
                                Font.font(
                                                "Arial",
                                                13));

                search.setPrefHeight(35);

                search.setBorder(
                                Border.EMPTY);

                search.setBackground(
                                new Background(
                                                new BackgroundFill(
                                                                Color.TRANSPARENT,
                                                                CornerRadii.EMPTY,
                                                                Insets.EMPTY)));

                HBox.setHgrow(
                                search,
                                Priority.ALWAYS);

                searchBox.getChildren().addAll(
                                searchIcon,
                                search);

                topBar.getChildren().addAll(
                                breadcrumb,
                                spacer,
                                searchBox);

                return topBar;
        }

        // =========================================================
        // DASHBOARD CONTENT
        // =========================================================

        private BorderPane createDashboardContent() {

                BorderPane wrapper = new BorderPane();

                VBox content = new VBox(20);

                content.setPadding(
                                new Insets(
                                                24,
                                                28,
                                                30,
                                                28));

                content.setStyle(
                                "-fx-background-color: " + BACKGROUND + ";");

                // =====================================================
                // KPI CARDS
                // =====================================================

                HBox cards = new HBox(18);

                cards.getChildren().addAll(

                                createKpiCard(
                                                "Total Users",
                                                "1,245,600",
                                                "↑ 15%",
                                                "vs last month",
                                                BLUE,
                                                "↗"),

                                createKpiCard(
                                                "Active Users",
                                                "850,200",
                                                "↑ 8%",
                                                "vs last month",
                                                GREEN,
                                                "↗"),

                                createKpiCard(
                                                "Total Gyms",
                                                "15,300",
                                                "→ 2%",
                                                "vs last month",
                                                ORANGE,
                                                "♜"),

                                createKpiCard(
                                                "Revenue",
                                                "$5,450,000",
                                                "↑ 10%",
                                                "vs last month",
                                                GREEN,
                                                "$"));

                // =====================================================
                // CHARTS
                // =====================================================

                HBox charts = new HBox(18);

                VBox growthCard = createUserGrowthChart();

                VBox revenueCard = createRevenueChart();

                HBox.setHgrow(
                                growthCard,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                revenueCard,
                                Priority.ALWAYS);

                charts.getChildren().addAll(
                                growthCard,
                                revenueCard);

                // =====================================================
                // BOTTOM SECTION
                // =====================================================

                HBox bottom = new HBox(18);

                VBox activities = createActivities();

                VBox approvals = createApprovals();

                VBox health = createSystemHealth();

                HBox.setHgrow(
                                activities,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                approvals,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                health,
                                Priority.ALWAYS);

                bottom.getChildren().addAll(
                                activities,
                                approvals,
                                health);

                content.getChildren().addAll(
                                cards,
                                charts,
                                bottom);

                // =====================================================
                // SCROLL
                // =====================================================

                ScrollPane scroll = new ScrollPane(
                                content);

                scroll.setFitToWidth(
                                true);

                scroll.setHbarPolicy(
                                ScrollPane.ScrollBarPolicy.NEVER);

                scroll.setVbarPolicy(
                                ScrollPane.ScrollBarPolicy.AS_NEEDED);

                scroll.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;");

                wrapper.setCenter(
                                scroll);

                return wrapper;
        }

        // =========================================================
        // KPI CARD
        // =========================================================

        private VBox createKpiCard(
                        String title,
                        String value,
                        String percentage,
                        String description,
                        String accent,
                        String icon) {

                VBox card = new VBox();

                card.setPadding(
                                new Insets(17));

                card.setPrefHeight(
                                125);

                card.setMinHeight(
                                125);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 11;" +
                                                "-fx-background-radius: 11;");

                javafx.scene.effect.DropShadow shadow = new javafx.scene.effect.DropShadow();
                shadow.setColor(Color.web("#E2E8F0"));
                shadow.setRadius(10);
                shadow.setOffsetY(4);
                card.setEffect(shadow);

                card.setOnMouseEntered(e -> {
                        card.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: " + accent + ";" +
                                                        "-fx-border-radius: 11;" +
                                                        "-fx-background-radius: 11;" +
                                                        "-fx-cursor: hand;");
                        shadow.setRadius(15);
                        shadow.setOffsetY(6);
                        shadow.setColor(Color.web("#CBD5E1"));
                        card.setTranslateY(-3);
                });

                card.setOnMouseExited(e -> {
                        card.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: " + BORDER + ";" +
                                                        "-fx-border-radius: 11;" +
                                                        "-fx-background-radius: 11;");
                        shadow.setRadius(10);
                        shadow.setOffsetY(4);
                        shadow.setColor(Color.web("#E2E8F0"));
                        card.setTranslateY(0);
                });

                HBox top = new HBox();

                Label titleLabel = new Label(title);

                titleLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                15));

                titleLabel.setTextFill(
                                Color.web(TEXT));

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                Label iconLabel = new Label(icon);

                iconLabel.setAlignment(
                                Pos.CENTER);

                iconLabel.setPrefSize(
                                35,
                                35);

                iconLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                15));

                iconLabel.setTextFill(
                                Color.web(accent));

                iconLabel.setStyle(
                                "-fx-background-color: " +
                                                getLightColor(accent) + ";" +
                                                "-fx-background-radius: 8;");

                top.getChildren().addAll(
                                titleLabel,
                                spacer,
                                iconLabel);

                Label valueLabel = new Label(value);

                valueLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                27));

                valueLabel.setTextFill(
                                Color.web("#101828"));

                HBox bottom = new HBox(6);

                Label percent = new Label(
                                percentage);

                percent.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                12));

                percent.setTextFill(
                                Color.web(
                                                percentage.startsWith("↑")
                                                                ? GREEN
                                                                : ORANGE));

                Label desc = new Label(
                                description);

                desc.setFont(
                                Font.font(
                                                "Arial",
                                                12));

                desc.setTextFill(
                                Color.web("#344054"));

                bottom.getChildren().addAll(
                                percent,
                                desc);

                VBox.setMargin(
                                valueLabel,
                                new Insets(
                                                7,
                                                0,
                                                1,
                                                0));

                card.getChildren().addAll(
                                top,
                                valueLabel,
                                bottom);

                HBox.setHgrow(
                                card,
                                Priority.ALWAYS);

                return card;
        }

        // =========================================================
        // LIGHT COLOR
        // =========================================================

        private String getLightColor(
                        String color) {

                if (color.equals(BLUE)) {
                        return "#E5F0FF";
                }

                if (color.equals(GREEN)) {
                        return LIGHT_GREEN;
                }

                if (color.equals(ORANGE)) {
                        return LIGHT_ORANGE;
                }

                return "#F2F4F7";
        }

        // =========================================================
        // USER GROWTH CHART
        // =========================================================

        private VBox createUserGrowthChart() {

                VBox card = new VBox(10);

                card.setPadding(
                                new Insets(15));

                card.setPrefHeight(
                                330);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 11;" +
                                                "-fx-background-radius: 11;");

                javafx.scene.effect.DropShadow shadow = new javafx.scene.effect.DropShadow();
                shadow.setColor(Color.web("#E2E8F0"));
                shadow.setRadius(10);
                shadow.setOffsetY(4);
                card.setEffect(shadow);

                card.setOnMouseEntered(e -> {
                        shadow.setRadius(15);
                        shadow.setOffsetY(6);
                        shadow.setColor(Color.web("#CBD5E1"));
                        card.setTranslateY(-3);
                });

                card.setOnMouseExited(e -> {
                        shadow.setRadius(10);
                        shadow.setOffsetY(4);
                        shadow.setColor(Color.web("#E2E8F0"));
                        card.setTranslateY(0);
                });

                Label title = new Label(
                                "User Growth (Last 12 Months)");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                16));

                title.setTextFill(
                                Color.web(TEXT));

                // =====================================================
                // AXES
                // =====================================================

                CategoryAxis xAxis = new CategoryAxis();

                NumberAxis yAxis = new NumberAxis();

                xAxis.setLabel(
                                "");

                yAxis.setLabel(
                                "");

                xAxis.setTickLabelFill(
                                Color.web("#667085"));

                yAxis.setTickLabelFill(
                                Color.web("#667085"));

                xAxis.setTickLabelFont(
                                Font.font(
                                                11));

                yAxis.setTickLabelFont(
                                Font.font(
                                                11));

                LineChart<String, Number> chart = new LineChart<>(
                                xAxis,
                                yAxis);

                chart.setAnimated(false);

                chart.setLegendVisible(false);

                chart.setCreateSymbols(true);

                chart.setVerticalGridLinesVisible(false);

                chart.setHorizontalGridLinesVisible(true);

                chart.setPrefHeight(
                                260);

                chart.setMinHeight(
                                240);

                chart.setStyle(
                                "-fx-background-color: transparent;");

                // =====================================================
                // DATA
                // =====================================================

                XYChart.Series<String, Number> series = new XYChart.Series<>();

                series.setName(
                                "Users");

                String[] months = {
                                "Jan",
                                "Feb",
                                "Mar",
                                "Apr",
                                "May",
                                "Jun",
                                "Jul",
                                "Aug",
                                "Sep",
                                "Oct",
                                "Nov",
                                "Dec"
                };

                int[] users = {
                                800,
                                950,
                                1100,
                                1450,
                                1370,
                                1550,
                                1900,
                                2050,
                                2200,
                                2550,
                                2750,
                                3100
                };

                for (int i = 0; i < months.length; i++) {

                        series.getData().add(
                                        new XYChart.Data<>(
                                                        months[i],
                                                        users[i]));
                }

                chart.getData().add(
                                series);

                // =====================================================
                // SERIES STYLE
                // =====================================================

                series.nodeProperty().addListener(
                                (obs, oldNode, newNode) -> {

                                        if (newNode != null) {

                                                newNode.setStyle(
                                                                "-fx-stroke: " + BLUE + ";" +
                                                                                "-fx-stroke-width: 3;");
                                        }
                                });

                card.getChildren().addAll(
                                title,
                                chart);

                VBox.setVgrow(
                                chart,
                                Priority.ALWAYS);

                return card;
        }

        // =========================================================
        // REVENUE CHART
        // =========================================================

        private VBox createRevenueChart() {

                VBox card = new VBox(10);

                card.setPadding(
                                new Insets(15));

                card.setPrefHeight(
                                330);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 11;" +
                                                "-fx-background-radius: 11;");

                javafx.scene.effect.DropShadow shadow = new javafx.scene.effect.DropShadow();
                shadow.setColor(Color.web("#E2E8F0"));
                shadow.setRadius(10);
                shadow.setOffsetY(4);
                card.setEffect(shadow);

                card.setOnMouseEntered(e -> {
                        shadow.setRadius(15);
                        shadow.setOffsetY(6);
                        shadow.setColor(Color.web("#CBD5E1"));
                        card.setTranslateY(-3);
                });

                card.setOnMouseExited(e -> {
                        shadow.setRadius(10);
                        shadow.setOffsetY(4);
                        shadow.setColor(Color.web("#E2E8F0"));
                        card.setTranslateY(0);
                });

                Label title = new Label(
                                "Platform Revenue (By Category)");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                16));

                title.setTextFill(
                                Color.web(TEXT));

                CategoryAxis xAxis = new CategoryAxis();

                NumberAxis yAxis = new NumberAxis();

                xAxis.setTickLabelFill(
                                Color.web("#667085"));

                yAxis.setTickLabelFill(
                                Color.web("#667085"));

                xAxis.setTickLabelFont(
                                Font.font(11));

                yAxis.setTickLabelFont(
                                Font.font(11));

                BarChart<String, Number> chart = new BarChart<>(
                                xAxis,
                                yAxis);

                chart.setAnimated(false);

                chart.setPrefHeight(
                                260);

                chart.setCategoryGap(25);

                chart.setBarGap(4);

                chart.setLegendVisible(true);

                // =====================================================
                // SERIES 1
                // =====================================================

                XYChart.Series<String, Number> gymSeries = new XYChart.Series<>();

                gymSeries.setName(
                                "Subscriptions");

                gymSeries.getData().addAll(

                                new XYChart.Data<>(
                                                "Gym Subscriptions",
                                                3150),

                                new XYChart.Data<>(
                                                "Store Sales",
                                                3650),

                                new XYChart.Data<>(
                                                "Premium Features",
                                                2200));

                // =====================================================
                // SERIES 2
                // =====================================================

                XYChart.Series<String, Number> storeSeries = new XYChart.Series<>();

                storeSeries.setName(
                                "Store Revenue");

                storeSeries.getData().addAll(

                                new XYChart.Data<>(
                                                "Gym Subscriptions",
                                                1850),

                                new XYChart.Data<>(
                                                "Store Sales",
                                                2450),

                                new XYChart.Data<>(
                                                "Premium Features",
                                                2600));

                chart.getData().addAll(
                                gymSeries,
                                storeSeries);

                card.getChildren().addAll(
                                title,
                                chart);

                VBox.setVgrow(
                                chart,
                                Priority.ALWAYS);

                return card;
        }

        // =========================================================
        // RECENT ACTIVITIES
        // =========================================================

        private VBox createActivities() {

                VBox card = createBottomCard();

                Label title = createSectionTitle(
                                "Recent Platform Activities");

                VBox list = new VBox(0);

                list.getChildren().addAll(

                                createActivity(
                                                "♜",
                                                "Gym \"FitLife Studio\" added",
                                                "by Admin1",
                                                "10:30 AM"),

                                createActivity(
                                                "♙",
                                                "User \"Sarah K.\" upgraded to Premium",
                                                "by Admin1",
                                                "10:15 AM"),

                                createActivity(
                                                "▤",
                                                "Store \"SportGear Shop\" approved",
                                                "by Admin2",
                                                "10:00 AM"));

                card.getChildren().addAll(
                                title,
                                list);

                return card;
        }

        // =========================================================
        // ACTIVITY ROW
        // =========================================================

        private HBox createActivity(
                        String icon,
                        String title,
                        String by,
                        String time) {

                HBox row = new HBox(10);

                row.setAlignment(
                                Pos.CENTER_LEFT);

                row.setPadding(
                                new Insets(
                                                9,
                                                0,
                                                9,
                                                0));

                Label iconLabel = new Label(icon);

                iconLabel.setPrefSize(
                                35,
                                35);

                iconLabel.setAlignment(
                                Pos.CENTER);

                iconLabel.setStyle(
                                "-fx-background-color: #EAF0FA;" +
                                                "-fx-background-radius: 50;");

                iconLabel.setTextFill(
                                Color.web("#53647A"));

                VBox details = new VBox(2);

                Label titleLabel = new Label(title);

                titleLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                12));

                titleLabel.setTextFill(
                                Color.web(TEXT));

                Label byLabel = new Label(by);

                byLabel.setFont(
                                Font.font(
                                                "Arial",
                                                11));

                byLabel.setTextFill(
                                Color.web(GRAY));

                details.getChildren().addAll(
                                titleLabel,
                                byLabel);

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                Label timeLabel = new Label(time);

                timeLabel.setFont(
                                Font.font(
                                                "Arial",
                                                11));

                timeLabel.setTextFill(
                                Color.web("#344054"));

                row.getChildren().addAll(
                                iconLabel,
                                details,
                                spacer,
                                timeLabel);

                return row;
        }

        // =========================================================
        // PENDING APPROVALS
        // =========================================================

        private VBox createApprovals() {

                VBox card = createBottomCard();

                Label title = createSectionTitle(
                                "Pending Approvals");

                VBox list = new VBox(7);

                list.getChildren().addAll(

                                createApprovalRow(
                                                "Gym: \"Downtown Fitness\"",
                                                "Awaiting review"),

                                createApprovalRow(
                                                "Store: \"Athlete's Choice\"",
                                                "Awaiting review"),

                                createApprovalRow(
                                                "User: \"Trainer Mike\"",
                                                "Verification Pending"));

                card.getChildren().addAll(
                                title,
                                list);

                return card;
        }

        // =========================================================
        // APPROVAL ROW
        // =========================================================

        private HBox createApprovalRow(
                        String title,
                        String subtitle) {

                HBox row = new HBox(8);

                row.setAlignment(
                                Pos.CENTER_LEFT);

                VBox details = new VBox(2);

                Label titleLabel = new Label(title);

                titleLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                12));

                titleLabel.setTextFill(
                                Color.web(TEXT));

                Label sub = new Label(subtitle);

                sub.setFont(
                                Font.font(
                                                "Arial",
                                                11));

                sub.setTextFill(
                                Color.web(GRAY));

                details.getChildren().addAll(
                                titleLabel,
                                sub);

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                Button approve = new Button(
                                "Approve");

                approve.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-text-fill: white;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-padding: 7 12;" +
                                                "-fx-cursor: hand;");

                Button reject = new Button(
                                "Reject");

                reject.setStyle(
                                "-fx-background-color: " + RED + ";" +
                                                "-fx-text-fill: white;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-padding: 7 12;" +
                                                "-fx-cursor: hand;");

                approve.setOnAction(
                                e -> showMessage(
                                                "Approval",
                                                title + " approved."));

                reject.setOnAction(
                                e -> showMessage(
                                                "Rejected",
                                                title + " rejected."));

                row.getChildren().addAll(
                                details,
                                spacer,
                                approve,
                                reject);

                return row;
        }

        // =========================================================
        // SYSTEM HEALTH
        // =========================================================

        private VBox createSystemHealth() {

                VBox card = createBottomCard();

                Label title = createSectionTitle(
                                "System Health");

                GridPane grid = new GridPane();

                grid.setHgap(28);
                grid.setVgap(18);

                grid.add(
                                createHealthItem(
                                                "Database Status",
                                                "Healthy"),
                                0,
                                0);

                grid.add(
                                createHealthItem(
                                                "API Services",
                                                "Operational"),
                                1,
                                0);

                grid.add(
                                createHealthItem(
                                                "Server Load",
                                                "Normal"),
                                0,
                                1);

                grid.add(
                                createHealthItem(
                                                "Security Alerts",
                                                "None"),
                                1,
                                1);

                Label updated = new Label(
                                "Last updated: 11:40:00 UTC");

                updated.setFont(
                                Font.font(
                                                "Arial",
                                                11));

                updated.setTextFill(
                                Color.web(GRAY));

                card.getChildren().addAll(
                                title,
                                grid,
                                updated);

                return card;
        }

        // =========================================================
        // HEALTH ITEM
        // =========================================================

        private HBox createHealthItem(
                        String title,
                        String status) {

                HBox box = new HBox(9);

                box.setAlignment(
                                Pos.CENTER_LEFT);

                StackPane circle = new StackPane();

                Circle background = new Circle(18);

                background.setFill(
                                Color.web(LIGHT_GREEN));

                Label check = new Label(
                                "✓");

                check.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                16));

                check.setTextFill(
                                Color.web(GREEN));

                circle.getChildren().addAll(
                                background,
                                check);

                VBox text = new VBox(2);

                Label titleLabel = new Label(title);

                titleLabel.setFont(
                                Font.font(
                                                "Arial",
                                                12));

                titleLabel.setTextFill(
                                Color.web(TEXT));

                Label statusLabel = new Label(status);

                statusLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                11));

                statusLabel.setTextFill(
                                Color.web(GREEN));

                text.getChildren().addAll(
                                titleLabel,
                                statusLabel);

                box.getChildren().addAll(
                                circle,
                                text);

                return box;
        }

        // =========================================================
        // BOTTOM CARD
        // =========================================================

        private VBox createBottomCard() {

                VBox card = new VBox(10);

                card.setPadding(
                                new Insets(15));

                card.setMinHeight(
                                210);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 11;" +
                                                "-fx-background-radius: 11;");

                javafx.scene.effect.DropShadow shadow = new javafx.scene.effect.DropShadow();
                shadow.setColor(Color.web("#E2E8F0"));
                shadow.setRadius(10);
                shadow.setOffsetY(4);
                card.setEffect(shadow);

                card.setOnMouseEntered(e -> {
                        shadow.setRadius(15);
                        shadow.setOffsetY(6);
                        shadow.setColor(Color.web("#CBD5E1"));
                        card.setTranslateY(-3);
                });

                card.setOnMouseExited(e -> {
                        shadow.setRadius(10);
                        shadow.setOffsetY(4);
                        shadow.setColor(Color.web("#E2E8F0"));
                        card.setTranslateY(0);
                });

                return card;
        }

        // =========================================================
        // SECTION TITLE
        // =========================================================

        private Label createSectionTitle(
                        String text) {

                Label label = new Label(text);

                label.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                16));

                label.setTextFill(
                                Color.web(TEXT));

                label.setPadding(
                                new Insets(
                                                0,
                                                0,
                                                5,
                                                0));

                return label;
        }

        // =========================================================
        // MESSAGE
        // =========================================================

        private void showMessage(
                        String title,
                        String message) {

                Alert alert = new Alert(
                                Alert.AlertType.INFORMATION);

                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.showAndWait();
        }

        // =========================================================
        // MAIN
        // =========================================================

        public static void main(
                        String[] args) {

                launch(args);
        }
}
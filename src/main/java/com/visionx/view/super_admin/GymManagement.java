package com.visionx.view.super_admin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;

public class GymManagement {
        private Runnable callBackAction;

        private record Gym(
                        String logoInitial,
                        String name,
                        String owner,
                        String verification,
                        String rating,
                        String location,
                        int colorIndex) {
        }

        private java.util.List<Gym> allGyms = new java.util.ArrayList<>(java.util.Arrays.asList(
                        new Gym("P", "Peak Performance Center", "John Smith", "Verified", "4.8", "New York", 0),
                        new Gym("G", "Gym Performance", "John Smith", "Pending", "4.8", "Los Angeles", 1),
                        new Gym("P", "Peak Performance Center", "Jones Smith", "Rejected", "4.8", "Chicago", 2),
                        new Gym("G", "Gym Performance Center", "Kanu Smith", "Rejected", "4.8", "Miami", 3),
                        new Gym("P", "Gym Performance Center", "John Smith", "Rejected", "4.8", "Houston", 4),
                        new Gym("F", "FitVerse Ormester", "John Smith", "Rejected", "4.8", "Seattle", 5)));

        // =========================================================
        // COLORS
        // =========================================================

        private static final String BLUE = "#1769E0";
        private static final String DARK_BLUE = "#07152D";
        private static final String BACKGROUND = "#F5F8FC";
        private static final String WHITE = "#FFFFFF";

        private static final String BORDER = "#D8E0EA";
        private static final String TEXT = "#17212F";
        private static final String SECONDARY = "#657181";

        private static final String GREEN = "#20A864";
        private static final String LIGHT_GREEN = "#DDF6E8";

        private static final String YELLOW = "#E6A700";
        private static final String LIGHT_YELLOW = "#FFF2CC";

        private static final String RED = "#D9343E";
        private static final String LIGHT_RED = "#FFE0E2";

        // =========================================================
        // START
        // =========================================================

        public Scene getGymManagementScene(Runnable callBackAction) {
                this.callBackAction = callBackAction;

                BorderPane root = new BorderPane();

                root.setStyle(
                                "-fx-background-color: " + BACKGROUND + ";");

                // LEFT SIDEBAR
                VBox sidebar = createSidebar();

                // RIGHT SIDE
                BorderPane rightSide = new BorderPane();

                HBox topBar = createTopBar();

                VBox mainContent = createMainContent();

                rightSide.setTop(topBar);
                rightSide.setCenter(mainContent);

                root.setLeft(sidebar);
                root.setCenter(rightSide);

                // =====================================================
                // SCENE
                // =====================================================

                Scene scene = new Scene(
                                root,
                                Dashboard.homeStage.getWidth(),
                                Dashboard.homeStage.getHeight());
                Dashboard.homeStage.setMaximized(true);

                scene.setFill(Color.web(BACKGROUND));

                return scene;
        }

        // =========================================================
        // SIDEBAR
        // =========================================================

        private VBox createSidebar() {

                VBox sidebar = new VBox();

                sidebar.setPrefWidth(245);
                sidebar.setMinWidth(245);
                sidebar.setMaxWidth(245);

                sidebar.setPadding(
                                new Insets(24, 15, 20, 15));

                sidebar.setStyle(
                                "-fx-background-color: " + DARK_BLUE + ";");

                // =====================================================
                // LOGO
                // =====================================================

                HBox logoBox = new HBox(10);

                logoBox.setAlignment(Pos.CENTER_LEFT);

                logoBox.setPadding(
                                new Insets(0, 10, 35, 10));

                StackPane logo = new StackPane();

                logo.setPrefSize(44, 44);
                logo.setMinSize(44, 44);
                logo.setMaxSize(44, 44);

                logo.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-background-radius: 10;");

                Label logoText = new Label("F");

                logoText.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                26));

                logoText.setStyle(
                                "-fx-text-fill: white;");

                logo.getChildren().add(logoText);

                Label fitVerse = new Label("FitVerse");

                fitVerse.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                23));

                fitVerse.setStyle(
                                "-fx-text-fill: white;");

                logoBox.getChildren().addAll(
                                logo,
                                fitVerse);

                // =====================================================
                // MENU
                // =====================================================

                VBox menu = new VBox(7);

                HBox dashboardItem = createMenuItem("▦", "Dashboard", false);
                HBox usersItem = createMenuItem("♟", "Users", false);
                HBox gymsItem = createMenuItem("▣", "Gyms", true);
                HBox storesItem = createMenuItem("▤", "Stores", false);
                HBox reportsItem = createMenuItem("▥", "Reports", false);
                HBox settingsItem = createMenuItem("⚙", "Settings", false);

                dashboardItem.setOnMouseClicked(e -> {
                        if (callBackAction != null)
                                callBackAction.run();
                });

                usersItem.setOnMouseClicked(e -> {
                        UserManagement um = new UserManagement();
                        Dashboard.switchScene(um.getUserManagementScene(callBackAction));
                });

                gymsItem.setOnMouseClicked(e -> {
                        GymManagement gm = new GymManagement();
                        Dashboard.switchScene(gm.getGymManagementScene(callBackAction));
                });

                storesItem.setOnMouseClicked(e -> {
                        SupplementStoreManagement sm = new SupplementStoreManagement();
                        Dashboard.switchScene(sm.getSupplementStoreManagementScene(callBackAction));
                });

                reportsItem.setOnMouseClicked(e -> {
                        Reports rm = new Reports();
                        Dashboard.switchScene(rm.getReportsScene(callBackAction));
                });

                settingsItem.setOnMouseClicked(e -> {
                        SettingsPage sp = new SettingsPage();
                        Dashboard.switchScene(sp.getSettingsPageScene(callBackAction));
                });

                menu.getChildren().addAll(
                                dashboardItem,
                                usersItem,
                                gymsItem,
                                storesItem,
                                reportsItem,
                                settingsItem);

                // =====================================================
                // SPACER
                // =====================================================

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
                profileLetter.setTextFill(Color.web(DARK_BLUE));

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
                                logoBox,
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

                item.setPrefHeight(44);
                item.setMinHeight(44);
                item.setMaxHeight(44);

                item.setAlignment(
                                Pos.CENTER_LEFT);

                item.setPadding(
                                new Insets(0, 13, 0, 13));

                Label iconLabel = new Label(icon);

                iconLabel.setFont(
                                Font.font(
                                                "Arial",
                                                18));

                Label textLabel = new Label(text);

                textLabel.setFont(
                                Font.font(
                                                "Arial",
                                                active
                                                                ? FontWeight.BOLD
                                                                : FontWeight.NORMAL,
                                                15));

                if (active) {

                        item.setStyle(
                                        "-fx-background-color: " + BLUE + ";" +
                                                        "-fx-background-radius: 9;");

                        iconLabel.setStyle(
                                        "-fx-text-fill: white;");

                        textLabel.setStyle(
                                        "-fx-text-fill: white;");

                } else {

                        item.setStyle(
                                        "-fx-background-color: transparent;" +
                                                        "-fx-background-radius: 9;");

                        iconLabel.setStyle(
                                        "-fx-text-fill: #AEB9CB;");

                        textLabel.setStyle(
                                        "-fx-text-fill: #AEB9CB;");

                        item.setOnMouseEntered(e -> {

                                item.setStyle(
                                                "-fx-background-color: #122442;" +
                                                                "-fx-background-radius: 9;");

                        });

                        item.setOnMouseExited(e -> {

                                item.setStyle(
                                                "-fx-background-color: transparent;" +
                                                                "-fx-background-radius: 9;");

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

                topBar.setPrefHeight(72);
                topBar.setMinHeight(72);
                topBar.setMaxHeight(72);

                topBar.setPadding(
                                new Insets(0, 28, 0, 30));

                topBar.setAlignment(
                                Pos.CENTER);

                topBar.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-width: 0 0 1 0;");

                // =====================================================
                // TITLE
                // =====================================================

                Label title = new Label(
                                "Super Admin Dashboard");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                20));

                title.setStyle(
                                "-fx-text-fill: " + TEXT + ";");

                // =====================================================
                // SPACER
                // =====================================================

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                // =====================================================
                // NOTIFICATION
                // =====================================================

                StackPane notification = new StackPane();

                notification.setPrefSize(40, 40);

                Label bell = new Label("♧");

                bell.setFont(
                                Font.font(
                                                "Arial",
                                                22));

                bell.setStyle(
                                "-fx-text-fill: #596575;");

                Circle redDot = new Circle(4);

                redDot.setFill(
                                Color.web(RED));

                StackPane.setAlignment(
                                redDot,
                                Pos.TOP_RIGHT);

                StackPane.setMargin(
                                redDot,
                                new Insets(3, 3, 0, 0));

                notification.getChildren().addAll(
                                bell,
                                redDot);

                topBar.getChildren().addAll(
                                title,
                                spacer,
                                notification);

                return topBar;
        }

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        private VBox createMainContent() {

                VBox content = new VBox(20);

                content.setPadding(
                                new Insets(
                                                25,
                                                30,
                                                30,
                                                30));

                content.setStyle(
                                "-fx-background-color: " + BACKGROUND + ";");

                // =====================================================
                // PAGE TITLE
                // =====================================================

                Label pageTitle = new Label(
                                "Gym Management");

                pageTitle.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                30));

                pageTitle.setStyle(
                                "-fx-text-fill: " + TEXT + ";");

                // =====================================================
                // KPI CARDS
                // =====================================================

                HBox cards = new HBox(20);

                VBox totalGyms = createKpiCard(
                                "Total Gyms",
                                "245",
                                "▦",
                                BLUE,
                                "#E4F0FF");

                VBox pending = createKpiCard(
                                "Pending Approval",
                                "28",
                                "!",
                                YELLOW,
                                LIGHT_YELLOW);

                VBox approved = createKpiCard(
                                "Approved",
                                "205",
                                "✓",
                                GREEN,
                                LIGHT_GREEN);

                VBox rejected = createKpiCard(
                                "Rejected",
                                "12",
                                "×",
                                RED,
                                LIGHT_RED);

                HBox.setHgrow(
                                totalGyms,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                pending,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                approved,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                rejected,
                                Priority.ALWAYS);

                cards.getChildren().addAll(
                                totalGyms,
                                pending,
                                approved,
                                rejected);

                // =====================================================
                // TABLE
                // =====================================================

                VBox tableCard = createGymTable();

                VBox.setVgrow(
                                tableCard,
                                Priority.ALWAYS);

                content.getChildren().addAll(
                                pageTitle,
                                cards,
                                tableCard);

                // =====================================================
                // SCROLL
                // =====================================================

                ScrollPane scroll = new ScrollPane();

                scroll.setContent(content);

                scroll.setFitToWidth(true);
                scroll.setFitToHeight(false);

                scroll.setHbarPolicy(
                                ScrollPane.ScrollBarPolicy.NEVER);

                scroll.setVbarPolicy(
                                ScrollPane.ScrollBarPolicy.AS_NEEDED);

                scroll.setPannable(false);

                scroll.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;" +
                                                "-fx-background: transparent;");

                VBox wrapper = new VBox(scroll);

                VBox.setVgrow(
                                scroll,
                                Priority.ALWAYS);

                wrapper.setStyle(
                                "-fx-background-color: " + BACKGROUND + ";");

                return wrapper;
        }

        // =========================================================
        // KPI CARD
        // =========================================================

        private VBox createKpiCard(
                        String title,
                        String value,
                        String iconText,
                        String accent,
                        String iconBackground) {

                VBox card = new VBox();

                card.setPrefHeight(110);
                card.setMinHeight(110);

                card.setPadding(
                                new Insets(
                                                16,
                                                18,
                                                15,
                                                18));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 10;" +
                                                "-fx-background-radius: 10;");

                // =====================================================
                // TOP
                // =====================================================

                HBox top = new HBox();

                top.setAlignment(
                                Pos.CENTER_LEFT);

                Label titleLabel = new Label(title);

                titleLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.NORMAL,
                                                15));

                titleLabel.setStyle(
                                "-fx-text-fill: #47515E;");

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                StackPane icon = new StackPane();

                icon.setPrefSize(40, 40);
                icon.setMinSize(40, 40);
                icon.setMaxSize(40, 40);

                icon.setStyle(
                                "-fx-background-color: " +
                                                iconBackground + ";" +
                                                "-fx-background-radius: 9;");

                Label iconLabel = new Label(iconText);

                iconLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                21));

                iconLabel.setStyle(
                                "-fx-text-fill: " + accent + ";");

                icon.getChildren().add(
                                iconLabel);

                top.getChildren().addAll(
                                titleLabel,
                                spacer,
                                icon);

                // =====================================================
                // VALUE
                // =====================================================

                Label valueLabel = new Label(value);

                valueLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                30));

                valueLabel.setStyle(
                                "-fx-text-fill: " + TEXT + ";");

                VBox.setMargin(
                                valueLabel,
                                new Insets(4, 0, 0, 0));

                card.getChildren().addAll(
                                top,
                                valueLabel);

                return card;
        }

        // =========================================================
        // TABLE
        // =========================================================

        private VBox createGymTable() {

                VBox tableCard = new VBox();

                tableCard.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 10;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 10;");

                // =====================================================
                // FILTER BAR
                // =====================================================

                HBox filterBar = new HBox();

                filterBar.setPrefHeight(72);

                filterBar.setPadding(
                                new Insets(15, 16, 15, 16));

                filterBar.setAlignment(
                                Pos.CENTER_LEFT);

                // SEARCH
                HBox searchBox = new HBox();

                searchBox.setPrefWidth(300);
                searchBox.setMinWidth(300);
                searchBox.setPrefHeight(42);

                searchBox.setAlignment(
                                Pos.CENTER_LEFT);

                searchBox.setPadding(
                                new Insets(0, 12, 0, 12));

                searchBox.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;");

                Label searchIcon = new Label("⌕");

                searchIcon.setFont(
                                Font.font(
                                                "Arial",
                                                22));

                searchIcon.setStyle(
                                "-fx-text-fill: #596575;");

                TextField searchField = new TextField();

                searchField.setPromptText(
                                "Search");

                searchField.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                searchField.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-prompt-text-fill: #8A95A3;");

                HBox.setHgrow(
                                searchField,
                                Priority.ALWAYS);

                searchBox.getChildren().addAll(
                                searchIcon,
                                searchField);

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                Label filterLabel = new Label("Filter by:");

                filterLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                filterLabel.setStyle(
                                "-fx-text-fill: " + TEXT + ";");

                ComboBox<String> location = createComboBox("Location (Any)", "New York", "Los Angeles", "Chicago",
                                "Miami", "Houston", "Seattle");
                ComboBox<String> status = createComboBox("Status (All)", "Verified", "Pending", "Rejected");
                ComboBox<String> bulk = createComboBox("Bulk Actions", "Approve Selected", "Reject Selected");

                filterBar.getChildren().addAll(
                                searchBox,
                                spacer,
                                filterLabel,
                                location,
                                status,
                                bulk);

                // =====================================================
                // HEADER
                // =====================================================

                GridPane header = createTableHeader();

                // =====================================================
                // ROWS
                // =====================================================

                VBox rows = new VBox();

                Runnable[] updateRef = new Runnable[1];
                Runnable updateTable = () -> {
                        rows.getChildren().clear();
                        String query = searchField.getText().toLowerCase();
                        String selectedLocation = location.getValue();
                        String selectedStatus = status.getValue();

                        for (Gym g : allGyms) {
                                boolean matchSearch = g.name().toLowerCase().contains(query)
                                                || g.owner().toLowerCase().contains(query);
                                boolean matchLoc = selectedLocation.equals("Location (Any)")
                                                || g.location().equals(selectedLocation);
                                boolean matchStatus = selectedStatus.equals("Status (All)")
                                                || g.verification().equals(selectedStatus);

                                if (matchSearch && matchLoc && matchStatus) {
                                        rows.getChildren().add(createGymRow(g, updateRef[0]));
                                }
                        }
                };
                updateRef[0] = updateTable;

                searchField.textProperty().addListener((obs, oldV, newV) -> updateTable.run());
                location.valueProperty().addListener((obs, oldV, newV) -> updateTable.run());
                status.valueProperty().addListener((obs, oldV, newV) -> updateTable.run());

                updateTable.run();

                // Select All listener
                javafx.scene.Node headerNode = header.getChildren().get(0);
                if (headerNode instanceof CheckBox selectAllCb) {
                        selectAllCb.setOnAction(e -> {
                                boolean selected = selectAllCb.isSelected();
                                for (javafx.scene.Node node : rows.getChildren()) {
                                        if (node instanceof GridPane rowGrid) {
                                                for (javafx.scene.Node child : rowGrid.getChildren()) {
                                                        if (child instanceof CheckBox cb) {
                                                                cb.setSelected(selected);
                                                        }
                                                }
                                        }
                                }
                        });
                }

                bulk.setOnAction(e -> {
                        String action = bulk.getValue();
                        if (action == null || action.equals("Bulk Actions"))
                                return;

                        java.util.List<Gym> selectedGyms = new java.util.ArrayList<>();
                        for (javafx.scene.Node node : rows.getChildren()) {
                                if (node instanceof GridPane rowGrid) {
                                        for (javafx.scene.Node child : rowGrid.getChildren()) {
                                                if (child instanceof CheckBox cb && cb.isSelected()
                                                                && cb.getUserData() instanceof Gym g) {
                                                        selectedGyms.add(g);
                                                }
                                        }
                                }
                        }

                        if (action.equals("Approve Selected")) {
                                for (int i = 0; i < allGyms.size(); i++) {
                                        Gym g = allGyms.get(i);
                                        if (selectedGyms.contains(g)) {
                                                allGyms.set(i, new Gym(g.logoInitial(), g.name(), g.owner(), "Verified",
                                                                g.rating(), g.location(), g.colorIndex()));
                                        }
                                }
                        } else if (action.equals("Reject Selected")) {
                                for (int i = 0; i < allGyms.size(); i++) {
                                        Gym g = allGyms.get(i);
                                        if (selectedGyms.contains(g)) {
                                                allGyms.set(i, new Gym(g.logoInitial(), g.name(), g.owner(), "Rejected",
                                                                g.rating(), g.location(), g.colorIndex()));
                                        }
                                }
                        }

                        javafx.application.Platform.runLater(() -> bulk.getSelectionModel().selectFirst());
                        updateTable.run();
                });

                // =====================================================
                // PAGINATION
                // =====================================================

                HBox pagination = new HBox(12);

                pagination.setAlignment(
                                Pos.CENTER);

                pagination.setPadding(
                                new Insets(14));

                Button previous = createPageButton("‹", false);

                Button one = createPageButton("1", true);

                Button two = createPageButton("2", false);

                Button three = createPageButton("3", false);

                Label dots = new Label("...");

                dots.setFont(
                                Font.font(
                                                "Arial",
                                                15));

                dots.setStyle(
                                "-fx-text-fill: " + SECONDARY + ";");

                Button ten = createPageButton("10", false);

                Button next = createPageButton("›", false);

                pagination.getChildren().addAll(
                                previous,
                                one,
                                two,
                                three,
                                dots,
                                ten,
                                next);

                tableCard.getChildren().addAll(
                                filterBar,
                                header,
                                rows,
                                pagination);

                return tableCard;
        }

        // =========================================================
        // TABLE HEADER
        // =========================================================

        private GridPane createTableHeader() {

                GridPane header = new GridPane();

                header.setPrefHeight(44);
                header.setMinHeight(44);

                header.setPadding(
                                new Insets(
                                                0,
                                                15,
                                                0,
                                                15));

                header.setAlignment(
                                Pos.CENTER_LEFT);

                header.setStyle(
                                "-fx-background-color: #EEF2F6;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-width: 1 0 1 0;");

                addColumns(header);

                CheckBox selectAll = new CheckBox();
                selectAll.setCursor(javafx.scene.Cursor.HAND);
                selectAll.setStyle("-fx-accent: #20A864;");
                header.add(selectAll, 0, 0);

                String[] titles = {
                                "Gym Logo",
                                "Name",
                                "Owner",
                                "Verification Status",
                                "Rating",
                                "Actions"
                };

                for (int i = 0; i < titles.length; i++) {

                        Label label = new Label(titles[i]);

                        label.setFont(
                                        Font.font(
                                                        "Arial",
                                                        FontWeight.BOLD,
                                                        14));

                        label.setStyle(
                                        "-fx-text-fill: " + TEXT + ";");

                        label.setMaxWidth(
                                        Double.MAX_VALUE);

                        header.add(
                                        label,
                                        i + 1,
                                        0);
                }

                return header;
        }

        // =========================================================
        // ADD TABLE COLUMNS
        // =========================================================

        private void addColumns(GridPane grid) {

                double[] widths = {
                                4,
                                10,
                                22,
                                16,
                                19,
                                12,
                                17
                };

                for (double width : widths) {

                        ColumnConstraints column = new ColumnConstraints();

                        column.setPercentWidth(width);

                        column.setHalignment(
                                        javafx.geometry.HPos.LEFT);

                        grid.getColumnConstraints()
                                        .add(column);
                }
        }

        // =========================================================
        // GYM ROW
        // =========================================================

        private GridPane createGymRow(
                        Gym g, Runnable updateTable) {
                String logoText = g.logoInitial();
                String name = g.name();
                String owner = g.owner();
                String verification = g.verification();
                String rating = g.rating();
                int index = g.colorIndex();

                GridPane row = new GridPane();

                row.setPrefHeight(62);
                row.setMinHeight(62);

                row.setPadding(
                                new Insets(
                                                0,
                                                15,
                                                0,
                                                15));

                row.setAlignment(
                                Pos.CENTER_LEFT);

                row.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-width: 0 0 1 0;");

                row.setOnMouseEntered(e -> {
                        row.setStyle(
                                        "-fx-background-color: #F8FAFC;" +
                                                        "-fx-border-color: " + BORDER + ";" +
                                                        "-fx-border-width: 0 0 1 0;");
                });

                row.setOnMouseExited(e -> {
                        row.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: " + BORDER + ";" +
                                                        "-fx-border-width: 0 0 1 0;");
                });

                addColumns(row);

                CheckBox cb = new CheckBox();
                cb.setCursor(javafx.scene.Cursor.HAND);
                cb.setStyle("-fx-accent: #20A864;");
                cb.setUserData(g);

                row.add(
                                cb,
                                0,
                                0);

                // =====================================================
                // LOGO
                // =====================================================

                StackPane logo = new StackPane();

                logo.setPrefSize(43, 43);
                logo.setMinSize(43, 43);
                logo.setMaxSize(43, 43);

                logo.setStyle(
                                "-fx-background-color: " +
                                                getLogoColor(index) + ";" +
                                                "-fx-background-radius: 6;");

                Label logoLabel = new Label(logoText);

                logoLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                15));

                logoLabel.setStyle(
                                "-fx-text-fill: white;");

                logo.getChildren().add(
                                logoLabel);

                row.add(
                                logo,
                                1,
                                0);

                // =====================================================
                // NAME
                // =====================================================

                Label nameLabel = createCellLabel(name);

                row.add(
                                nameLabel,
                                2,
                                0);

                // =====================================================
                // OWNER
                // =====================================================

                Label ownerLabel = createCellLabel(owner);

                row.add(
                                ownerLabel,
                                3,
                                0);

                // =====================================================
                // STATUS
                // =====================================================

                Label statusLabel = createStatusLabel(
                                verification);

                row.add(
                                statusLabel,
                                4,
                                0);

                // =====================================================
                // RATING
                // =====================================================

                HBox ratingBox = new HBox(7);

                ratingBox.setAlignment(
                                Pos.CENTER_LEFT);

                Label ratingLabel = new Label(rating);

                ratingLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                ratingLabel.setStyle(
                                "-fx-text-fill: " + TEXT + ";");

                Label star = new Label("★");

                star.setFont(
                                Font.font(
                                                "Arial",
                                                20));

                star.setStyle(
                                "-fx-text-fill: #F4B400;");

                ratingBox.getChildren().addAll(
                                ratingLabel,
                                star);

                row.add(
                                ratingBox,
                                5,
                                0);

                // =====================================================
                // ACTIONS
                // =====================================================

                HBox actions = new HBox(8);

                actions.setAlignment(
                                Pos.CENTER_LEFT);

                if (verification.equals("Pending")) {

                        Button approve = createActionButton(
                                        "Approve",
                                        GREEN);

                        Button reject = createActionButton(
                                        "Reject",
                                        RED);

                        approve.setOnAction(e -> {
                                int idx = allGyms.indexOf(g);
                                if (idx != -1) {
                                        allGyms.set(idx, new Gym(g.logoInitial(), g.name(), g.owner(), "Verified",
                                                        g.rating(), g.location(), g.colorIndex()));
                                        updateTable.run();
                                }
                        });

                        reject.setOnAction(e -> {
                                int idx = allGyms.indexOf(g);
                                if (idx != -1) {
                                        allGyms.set(idx, new Gym(g.logoInitial(), g.name(), g.owner(), "Rejected",
                                                        g.rating(), g.location(), g.colorIndex()));
                                        updateTable.run();
                                }
                        });

                        actions.getChildren().addAll(
                                        approve,
                                        reject);

                } else {
                        Button viewBtn = createViewButton();
                        viewBtn.setOnAction(e -> showGymProfile(g));
                        actions.getChildren().add(
                                        viewBtn);
                }

                row.add(
                                actions,
                                6,
                                0);

                return row;
        }

        // =========================================================
        // CELL LABEL
        // =========================================================

        private Label createCellLabel(
                        String text) {

                Label label = new Label(text);

                label.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.NORMAL,
                                                15));

                label.setStyle(
                                "-fx-text-fill: " + TEXT + ";");

                label.setWrapText(false);

                return label;
        }

        // =========================================================
        // STATUS
        // =========================================================

        private Label createStatusLabel(
                        String status) {

                Label label = new Label();

                label.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                if (status.equals("Verified")) {

                        label.setText(
                                        "✓ Verified");

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_GREEN + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 7 12;" +
                                                        "-fx-text-fill: #176C3D;");

                } else if (status.equals("Pending")) {

                        label.setText(
                                        "! Pending");

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_YELLOW + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 7 12;" +
                                                        "-fx-text-fill: #896500;");

                } else {

                        label.setText(
                                        "× Rejected");

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_RED + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 7 12;" +
                                                        "-fx-text-fill: #8C1D25;");
                }

                return label;
        }

        // =========================================================
        // VIEW BUTTON
        // =========================================================

        private Button createViewButton() {

                Button view = new Button("View");

                view.setPrefWidth(70);
                view.setPrefHeight(35);

                view.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-cursor: hand;");

                view.setOnMouseEntered(e -> {

                        view.setStyle(
                                        "-fx-background-color: #EEF4FF;" +
                                                        "-fx-border-color: " + BLUE + ";" +
                                                        "-fx-border-radius: 7;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-text-fill: " + BLUE + ";" +
                                                        "-fx-font-size: 14px;" +
                                                        "-fx-cursor: hand;");
                });

                view.setOnMouseExited(e -> {

                        view.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: #C8D0DA;" +
                                                        "-fx-border-radius: 7;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-text-fill: " + TEXT + ";" +
                                                        "-fx-font-size: 14px;" +
                                                        "-fx-cursor: hand;");
                });

                return view;
        }

        // =========================================================
        // ACTION BUTTON
        // =========================================================

        private Button createActionButton(
                        String text,
                        String background) {

                Button button = new Button(text);

                button.setPrefHeight(35);

                button.setStyle(
                                "-fx-background-color: " +
                                                background + ";" +
                                                "-fx-text-fill: white;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-padding: 0 15;" +
                                                "-fx-cursor: hand;");

                return button;
        }

        // =========================================================
        // FILTER BUTTON
        // =========================================================

        private Button createFilterButton(
                        String text) {

                Button button = new Button(
                                text + "   ▾");

                button.setPrefHeight(42);
                button.setMinWidth(155);

                button.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-padding: 0 14;" +
                                                "-fx-cursor: hand;");

                return button;
        }

        // =========================================================
        // PAGINATION
        // =========================================================

        private Button createPageButton(
                        String text,
                        boolean active) {

                Button button = new Button(text);

                button.setPrefSize(
                                36,
                                34);

                if (active) {

                        button.setStyle(
                                        "-fx-background-color: " + BLUE + ";" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-font-weight: bold;" +
                                                        "-fx-font-size: 14px;");

                } else {

                        button.setStyle(
                                        "-fx-background-color: transparent;" +
                                                        "-fx-text-fill: #4E5968;" +
                                                        "-fx-font-size: 14px;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-cursor: hand;");
                }

                return button;
        }

        // =========================================================
        // LOGO COLORS
        // =========================================================

        private String getLogoColor(
                        int index) {

                switch (index) {

                        case 0:
                                return "#27384E";

                        case 1:
                                return "#7A8795";

                        case 2:
                                return "#556B7A";

                        case 3:
                                return "#303B46";

                        case 4:
                                return "#66501C";

                        default:
                                return "#697581";
                }
        }

        // =========================================================
        // COMBOBOX & SHOW PROFILE
        // =========================================================

        private ComboBox<String> createComboBox(String... items) {
                ComboBox<String> combo = new ComboBox<>();
                combo.getItems().addAll(items);
                combo.getSelectionModel().selectFirst();
                combo.setPrefWidth(155);
                combo.setPrefHeight(42);
                combo.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-cursor: hand;");
                return combo;
        }

        private void showGymProfile(Gym g) {
                javafx.stage.Stage modal = new javafx.stage.Stage();
                modal.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                modal.setTitle("Gym Profile");

                VBox layout = new VBox(20);
                layout.setAlignment(Pos.CENTER);
                layout.setPadding(new Insets(30));
                layout.setStyle("-fx-background-color: white;");

                StackPane logo = new StackPane();
                logo.setPrefSize(60, 60);
                logo.setStyle("-fx-background-color: " + getLogoColor(g.colorIndex()) + "; -fx-background-radius: 10;");
                Label initial = new Label(g.logoInitial());
                initial.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                initial.setTextFill(Color.WHITE);
                logo.getChildren().add(initial);

                Label name = new Label(g.name());
                name.setFont(Font.font("Arial", FontWeight.BOLD, 22));
                name.setTextFill(Color.web(TEXT));

                GridPane details = new GridPane();
                details.setHgap(20);
                details.setVgap(15);
                details.setAlignment(Pos.CENTER);

                details.add(new Label("Owner:"), 0, 0);
                details.add(new Label(g.owner()), 1, 0);

                details.add(new Label("Location:"), 0, 1);
                details.add(new Label(g.location()), 1, 1);

                details.add(new Label("Rating:"), 0, 2);
                details.add(new Label(g.rating() + " ★"), 1, 2);

                details.add(new Label("Status:"), 0, 3);
                Label statusLbl = createStatusLabel(g.verification());
                details.add(statusLbl, 1, 3);

                for (javafx.scene.Node n : details.getChildren()) {
                        if (n instanceof Label l && n != statusLbl) {
                                l.setFont(Font.font("Arial", 14));
                        }
                }

                Button closeBtn = new Button("Close");
                closeBtn.setPrefWidth(120);
                closeBtn.setPrefHeight(35);
                closeBtn.setStyle("-fx-background-color: " + BLUE
                                + "; -fx-text-fill: white; -fx-background-radius: 5; -fx-cursor: hand;");
                closeBtn.setOnAction(e -> modal.close());

                layout.getChildren().addAll(logo, name, details, closeBtn);

                Scene scene = new Scene(layout, 350, 400);
                modal.setScene(scene);
                modal.showAndWait();
        }

}
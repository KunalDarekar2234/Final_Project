package com.visionx.view.super_admin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;

public class SupplementStoreManagement {
        private Runnable callBackAction;

        private record Store(
                        String storeName,
                        String owner,
                        String productCount,
                        String revenue,
                        String verification) {
        }

        private java.util.List<Store> allStores = new java.util.ArrayList<>(java.util.Arrays.asList(
                        new Store("Flex Fuel Supplies", "David Chen", "120", "$12,500", "Verified"),
                        new Store("Peak Performance Nutrition", "Sarah Miller", "85", "$8,200", "Verified"),
                        new Store("FitFueII Supplies", "Sarah Miller", "80", "$8,200", "Pending"),
                        new Store("Peak Performance Nutrition", "Joan Tirmpo", "40", "$3,800", "Pending"),
                        new Store("Flex Fuel Supplies", "David Chen", "30", "$2,200", "Verified"),
                        new Store("Peak Faet Supplies", "David Chen", "120", "$3,700", "Pending"),
                        new Store("Peak Performance Nutrition", "Sarah Miller", "110", "$2,300", "Verified"),
                        new Store("Flex Fuel Supplies", "Joan Tirmpo", "85", "$8,200", "Verified")));

        // =========================================================
        // COLORS
        // =========================================================

        private static final String BLUE = "#214D73";
        private static final String DARK_BLUE = "#07152D";
        private static final String BG = "#F4F7FA";
        private static final String WHITE = "#FFFFFF";

        private static final String BORDER = "#D5DCE4";
        private static final String TEXT = "#17212F";
        private static final String GRAY = "#66717F";

        private static final String GREEN = "#21A65A";
        private static final String LIGHT_GREEN = "#D7F4E1";

        private static final String RED = "#B73737";
        private static final String LIGHT_RED = "#F9E1E1";

        private static final String YELLOW = "#B88600";
        private static final String LIGHT_YELLOW = "#FFF0B8";

        // =========================================================
        // START
        // =========================================================

        public Scene getSupplementStoreManagementScene(Runnable callBackAction) {
                this.callBackAction = callBackAction;

                BorderPane root = new BorderPane();

                root.setStyle(
                                "-fx-background-color: " + BG + ";");

                // LEFT SIDEBAR
                VBox sidebar = createSidebar();

                // RIGHT AREA
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
                                1450,
                                850);

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
                                new Insets(25, 15, 20, 15));

                sidebar.setStyle(
                                "-fx-background-color: " + DARK_BLUE + ";");

                // =====================================================
                // LOGO
                // =====================================================

                HBox logoBox = new HBox(10);

                logoBox.setAlignment(
                                Pos.CENTER_LEFT);

                logoBox.setPadding(
                                new Insets(0, 10, 35, 10));

                StackPane logo = new StackPane();

                logo.setPrefSize(44, 44);
                logo.setMaxSize(44, 44);

                logo.setStyle(
                                "-fx-background-color: #1769E0;" +
                                                "-fx-background-radius: 10;");

                Label logoText = new Label("F");

                logoText.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                25));

                logoText.setTextFill(
                                Color.WHITE);

                logo.getChildren().add(logoText);

                Label fitVerse = new Label(
                                "FitVerse");

                fitVerse.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                23));

                fitVerse.setTextFill(
                                Color.WHITE);

                logoBox.getChildren().addAll(
                                logo,
                                fitVerse);

                // =====================================================
                // MENU
                // =====================================================

                VBox menu = new VBox(7);

                HBox dashboardItem = createMenuItem("▦", "Dashboard", false);
                HBox usersItem = createMenuItem("♟", "Users", false);
                HBox gymsItem = createMenuItem("▣", "Gyms", false);
                HBox storesItem = createMenuItem("▤", "Stores", true);
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

                item.setPrefHeight(43);
                item.setMinHeight(43);

                item.setAlignment(
                                Pos.CENTER_LEFT);

                item.setPadding(
                                new Insets(0, 12, 0, 12));

                Label iconLabel = new Label(
                                icon);

                iconLabel.setFont(
                                Font.font(
                                                "Arial",
                                                18));

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
                                        "-fx-background-color: #1769E0;" +
                                                        "-fx-background-radius: 9;");

                        iconLabel.setTextFill(
                                        Color.WHITE);

                        textLabel.setTextFill(
                                        Color.WHITE);

                } else {

                        item.setStyle(
                                        "-fx-background-color: transparent;" +
                                                        "-fx-background-radius: 9;");

                        iconLabel.setTextFill(
                                        Color.web("#AEB9CB"));

                        textLabel.setTextFill(
                                        Color.web("#AEB9CB"));

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

                topBar.setPrefHeight(68);
                topBar.setMinHeight(68);

                topBar.setPadding(
                                new Insets(0, 30, 0, 30));

                topBar.setAlignment(
                                Pos.CENTER);

                topBar.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-width: 0 0 1 0;");

                Label title = new Label(
                                "Super Admin Dashboard");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                19));

                title.setTextFill(
                                Color.web(TEXT));

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                // Notification

                StackPane notification = new StackPane();

                Label bell = new Label(
                                "●");

                bell.setFont(
                                Font.font(
                                                "Arial",
                                                18));

                bell.setTextFill(
                                Color.web("#657181"));

                Circle dot = new Circle(4);

                dot.setFill(
                                Color.web("#D9343E"));

                StackPane.setAlignment(
                                dot,
                                Pos.TOP_RIGHT);

                notification.getChildren().addAll(
                                bell,
                                dot);

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

                VBox content = new VBox(18);

                content.setPadding(
                                new Insets(
                                                28,
                                                38,
                                                30,
                                                38));

                content.setStyle(
                                "-fx-background-color: " + BG + ";");

                // =====================================================
                // PAGE TITLE
                // =====================================================

                Label pageTitle = new Label(
                                "Supplement Store Management");

                pageTitle.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                30));

                pageTitle.setTextFill(
                                Color.web(TEXT));

                // =====================================================
                // KPI CARDS
                // =====================================================

                HBox cards = new HBox(15);

                VBox totalStores = createKpiCard(
                                "Total Stores:",
                                "150");

                VBox revenue = createKpiCard(
                                "Total Revenue:",
                                "$540,000");

                VBox pending = createKpiCard(
                                "Pending Verifications:",
                                "8");

                VBox avgOrder = createKpiCard(
                                "Avg. Order Value:",
                                "$85.50");

                HBox.setHgrow(
                                totalStores,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                revenue,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                pending,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                avgOrder,
                                Priority.ALWAYS);

                cards.getChildren().addAll(
                                totalStores,
                                revenue,
                                pending,
                                avgOrder);

                // =====================================================
                // TABLE
                // =====================================================

                VBox table = createStoreTable();

                VBox.setVgrow(
                                table,
                                Priority.ALWAYS);

                content.getChildren().addAll(
                                pageTitle,
                                cards,
                                table);

                ScrollPane scroll = new ScrollPane(content);

                scroll.setFitToWidth(true);

                scroll.setHbarPolicy(
                                ScrollPane.ScrollBarPolicy.NEVER);

                scroll.setVbarPolicy(
                                ScrollPane.ScrollBarPolicy.AS_NEEDED);

                scroll.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;");

                VBox wrapper = new VBox(scroll);

                VBox.setVgrow(
                                scroll,
                                Priority.ALWAYS);

                wrapper.setStyle(
                                "-fx-background-color: " + BG + ";");

                return wrapper;
        }

        // =========================================================
        // KPI CARD
        // =========================================================

        private VBox createKpiCard(
                        String title,
                        String value) {

                VBox card = new VBox(6);

                card.setPadding(
                                new Insets(
                                                16,
                                                18,
                                                16,
                                                18));

                card.setPrefHeight(84);
                card.setMinHeight(84);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 8;" +
                                                "-fx-background-radius: 8;");

                Label titleLabel = new Label(title);

                titleLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                titleLabel.setTextFill(
                                Color.web("#343C46"));

                Label valueLabel = new Label(value);

                valueLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                25));

                valueLabel.setTextFill(
                                Color.web(TEXT));

                card.getChildren().addAll(
                                titleLabel,
                                valueLabel);

                return card;
        }

        // =========================================================
        // STORE TABLE
        // =========================================================

        private VBox createStoreTable() {

                VBox card = new VBox();

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 8;" +
                                                "-fx-background-radius: 8;");

                // =====================================================
                // TOOLBAR
                // =====================================================

                HBox toolbar = new HBox(8);

                toolbar.setPadding(
                                new Insets(14));

                toolbar.setAlignment(
                                Pos.CENTER_LEFT);

                ComboBox<String> status = createComboBox("Status (All)", "Verified", "Pending", "Suspended");
                ComboBox<String> bulk = createComboBox("Bulk Actions", "Verify Selected", "Suspend Selected");

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                HBox search = new HBox(8);

                search.setPrefWidth(195);
                search.setPrefHeight(34);

                search.setAlignment(
                                Pos.CENTER_LEFT);

                search.setPadding(
                                new Insets(0, 10, 0, 10));

                search.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;");

                Label searchIcon = new Label("⌕");

                searchIcon.setFont(
                                Font.font(
                                                "Arial",
                                                20));

                searchIcon.setTextFill(
                                Color.web(GRAY));

                TextField searchField = new TextField();

                searchField.setPromptText(
                                "Search");

                searchField.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                searchField.setBorder(
                                Border.EMPTY);

                searchField.setBackground(
                                new Background(
                                                new BackgroundFill(
                                                                Color.TRANSPARENT,
                                                                CornerRadii.EMPTY,
                                                                Insets.EMPTY)));

                HBox.setHgrow(
                                searchField,
                                Priority.ALWAYS);

                search.getChildren().addAll(
                                searchIcon,
                                searchField);

                toolbar.getChildren().addAll(
                                status,
                                bulk,
                                spacer,
                                search);

                // =====================================================
                // HEADER
                // =====================================================

                GridPane header = createHeader();

                // =====================================================
                // ROWS
                // =====================================================

                VBox rows = new VBox();

                Runnable[] updateRef = new Runnable[1];
                Runnable updateTable = () -> {
                        rows.getChildren().clear();
                        String query = searchField.getText().toLowerCase();
                        String selectedStatus = status.getValue();

                        for (Store s : allStores) {
                                boolean matchSearch = s.storeName().toLowerCase().contains(query)
                                                || s.owner().toLowerCase().contains(query);
                                boolean matchStatus = selectedStatus.equals("Status (All)")
                                                || s.verification().equals(selectedStatus);

                                if (matchSearch && matchStatus) {
                                        rows.getChildren().add(createStoreRow(s, updateRef[0]));
                                }
                        }
                };
                updateRef[0] = updateTable;

                searchField.textProperty().addListener((obs, oldV, newV) -> updateTable.run());
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

                        java.util.List<Store> selectedStores = new java.util.ArrayList<>();
                        for (javafx.scene.Node node : rows.getChildren()) {
                                if (node instanceof GridPane rowGrid) {
                                        for (javafx.scene.Node child : rowGrid.getChildren()) {
                                                if (child instanceof CheckBox cb && cb.isSelected()
                                                                && cb.getUserData() instanceof Store s) {
                                                        selectedStores.add(s);
                                                }
                                        }
                                }
                        }

                        if (action.equals("Verify Selected")) {
                                for (int i = 0; i < allStores.size(); i++) {
                                        Store s = allStores.get(i);
                                        if (selectedStores.contains(s)) {
                                                allStores.set(i, new Store(s.storeName(), s.owner(), s.productCount(),
                                                                s.revenue(), "Verified"));
                                        }
                                }
                        } else if (action.equals("Suspend Selected")) {
                                for (int i = 0; i < allStores.size(); i++) {
                                        Store s = allStores.get(i);
                                        if (selectedStores.contains(s)) {
                                                allStores.set(i, new Store(s.storeName(), s.owner(), s.productCount(),
                                                                s.revenue(), "Suspended"));
                                        }
                                }
                        }

                        javafx.application.Platform.runLater(() -> bulk.getSelectionModel().selectFirst());
                        updateTable.run();
                });

                // =====================================================
                // PAGINATION
                // =====================================================

                HBox pagination = new HBox(7);

                pagination.setAlignment(
                                Pos.CENTER);

                pagination.setPadding(
                                new Insets(15));

                Button first = createPageButton("‹|", false);

                Button previous = createPageButton("‹", false);

                Button one = createPageButton("1", true);

                Label dots = new Label("...");

                dots.setFont(
                                Font.font(
                                                "Arial",
                                                15));

                Button next = createPageButton("›", false);

                Button last = createPageButton("|›", false);

                pagination.getChildren().addAll(
                                first,
                                previous,
                                one,
                                dots,
                                next,
                                last);

                card.getChildren().addAll(
                                toolbar,
                                header,
                                rows,
                                pagination);

                return card;
        }

        // =========================================================
        // TABLE HEADER
        // =========================================================

        private GridPane createHeader() {

                GridPane header = new GridPane();

                header.setPrefHeight(38);

                header.setPadding(
                                new Insets(
                                                0,
                                                14,
                                                0,
                                                14));

                header.setAlignment(
                                Pos.CENTER_LEFT);

                header.setStyle(
                                "-fx-background-color: #F0F2F4;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-width: 1 0 1 0;");

                CheckBox selectAll = new CheckBox();
                selectAll.setCursor(javafx.scene.Cursor.HAND);
                selectAll.setStyle("-fx-accent: #21A65A;");
                header.add(selectAll, 0, 0);

                String[] titles = {

                                "Store Name",
                                "Owner",
                                "Product Count",
                                "Revenue",
                                "Verification Status",
                                "Actions"

                };

                double[] widths = {
                                4,
                                20,
                                17,
                                14,
                                14,
                                18,
                                13

                };

                for (int i = 0; i < titles.length; i++) {

                        ColumnConstraints column = new ColumnConstraints();

                        column.setPercentWidth(
                                        widths[i + 1]);

                        header.getColumnConstraints()
                                        .add(column);

                        Label label = new Label(
                                        titles[i]);

                        label.setFont(
                                        Font.font(
                                                        "Arial",
                                                        FontWeight.BOLD,
                                                        14));

                        label.setTextFill(
                                        Color.web(TEXT));

                        header.add(
                                        label,
                                        i + 1,
                                        0);
                }

                return header;
        }

        // =========================================================
        // STORE ROW
        // =========================================================

        private GridPane createStoreRow(
                        Store s, Runnable updateTable) {
                String storeName = s.storeName();
                String owner = s.owner();
                String productCount = s.productCount();
                String revenue = s.revenue();
                String verification = s.verification();

                GridPane row = new GridPane();

                row.setMinHeight(38);
                row.setPrefHeight(38);

                row.setPadding(
                                new Insets(
                                                0,
                                                14,
                                                0,
                                                14));

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

                double[] widths = {
                                4,
                                20,
                                17,
                                14,
                                14,
                                18,
                                13

                };

                for (double width : widths) {

                        ColumnConstraints column = new ColumnConstraints();

                        column.setPercentWidth(
                                        width);

                        row.getColumnConstraints()
                                        .add(column);
                }

                CheckBox cb = new CheckBox();
                cb.setCursor(javafx.scene.Cursor.HAND);
                cb.setStyle("-fx-accent: #21A65A;");
                cb.setUserData(s);

                row.add(
                                cb,
                                0,
                                0);

                // =====================================================
                // STORE NAME
                // =====================================================

                Label store = new Label(
                                storeName);

                store.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                store.setTextFill(
                                Color.web(TEXT));

                row.add(
                                store,
                                1,
                                0);

                // =====================================================
                // OWNER
                // =====================================================

                Label ownerLabel = new Label(
                                owner);

                ownerLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                ownerLabel.setTextFill(
                                Color.web(TEXT));

                row.add(
                                ownerLabel,
                                2,
                                0);

                // =====================================================
                // PRODUCT COUNT
                // =====================================================

                Label products = new Label(
                                productCount);

                products.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                products.setTextFill(
                                Color.web(TEXT));

                row.add(
                                products,
                                3,
                                0);

                // =====================================================
                // REVENUE
                // =====================================================

                Label revenueLabel = new Label(
                                revenue);

                revenueLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                revenueLabel.setTextFill(
                                Color.web(TEXT));

                row.add(
                                revenueLabel,
                                4,
                                0);

                // =====================================================
                // STATUS
                // =====================================================

                Label status = createVerificationLabel(
                                verification);

                row.add(
                                status,
                                5,
                                0);

                // =====================================================
                // ACTIONS
                // =====================================================

                HBox actions = new HBox(6);

                actions.setAlignment(
                                Pos.CENTER_LEFT);

                Button view = new Button(
                                "View Store");

                view.setPrefHeight(28);

                view.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-text-fill: white;" +
                                                "-fx-background-radius: 5;" +
                                                "-fx-font-size: 12px;" +
                                                "-fx-padding: 0 10;" +
                                                "-fx-cursor: hand;");

                Button actionBtn = new Button();
                actionBtn.setPrefHeight(28);
                if (verification.equals("Suspended")) {
                        actionBtn.setText("Verify");
                        actionBtn.setStyle(
                                        "-fx-background-color: #E6F4EA;" +
                                                        "-fx-text-fill: #176C3D;" +
                                                        "-fx-border-color: #21A65A;" +
                                                        "-fx-border-radius: 5;" +
                                                        "-fx-background-radius: 5;" +
                                                        "-fx-font-size: 12px;" +
                                                        "-fx-padding: 0 9;" +
                                                        "-fx-cursor: hand;");
                        actionBtn.setOnAction(e -> {
                                int idx = allStores.indexOf(s);
                                if (idx != -1) {
                                        allStores.set(idx, new Store(s.storeName(), s.owner(), s.productCount(),
                                                        s.revenue(), "Verified"));
                                        updateTable.run();
                                }
                        });
                } else {
                        actionBtn.setText("Suspend");
                        actionBtn.setStyle(
                                        "-fx-background-color: #F9EEEE;" +
                                                        "-fx-text-fill: #7A2B2B;" +
                                                        "-fx-border-color: #B98383;" +
                                                        "-fx-border-radius: 5;" +
                                                        "-fx-background-radius: 5;" +
                                                        "-fx-font-size: 12px;" +
                                                        "-fx-padding: 0 9;" +
                                                        "-fx-cursor: hand;");
                        actionBtn.setOnAction(e -> {
                                int idx = allStores.indexOf(s);
                                if (idx != -1) {
                                        allStores.set(idx, new Store(s.storeName(), s.owner(), s.productCount(),
                                                        s.revenue(), "Suspended"));
                                        updateTable.run();
                                }
                        });
                }

                view.setOnAction(e -> showStoreProfile(s));

                actions.getChildren().addAll(
                                view,
                                actionBtn);

                row.add(
                                actions,
                                6,
                                0);

                return row;
        }

        // =========================================================
        // STATUS LABEL
        // =========================================================

        private Label createVerificationLabel(
                        String status) {

                Label label = new Label();

                label.setFont(
                                Font.font(
                                                "Arial",
                                                13));

                if (status.equalsIgnoreCase(
                                "Verified")) {

                        label.setText(
                                        "Verified");

                        label.setTextFill(
                                        Color.web("#176C3D"));

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_GREEN + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 5 11;");

                } else {

                        label.setText(
                                        "Pending");

                        label.setTextFill(
                                        Color.web("#806000"));

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_YELLOW + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 5 11;");
                }

                return label;
        }

        // =========================================================
        // PAGINATION BUTTON
        // =========================================================

        private Button createPageButton(
                        String text,
                        boolean active) {

                Button button = new Button(text);

                button.setPrefSize(
                                34,
                                30);

                if (active) {

                        button.setStyle(
                                        "-fx-background-color: " + BLUE + ";" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-background-radius: 5;" +
                                                        "-fx-font-weight: bold;");

                } else {

                        button.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-text-fill: #56616F;" +
                                                        "-fx-border-color: #D1D8E0;" +
                                                        "-fx-border-radius: 5;" +
                                                        "-fx-background-radius: 5;" +
                                                        "-fx-font-size: 13px;" +
                                                        "-fx-cursor: hand;");
                }

                return button;
        }

        // =========================================================
        // ALERT / INFO
        // =========================================================

        private void showInfo(
                        String title,
                        String content) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(content);
                alert.showAndWait();
        }

        // =========================================================
        // COMBOBOX & SHOW PROFILE
        // =========================================================

        private ComboBox<String> createComboBox(String... items) {
                ComboBox<String> combo = new ComboBox<>();
                combo.getItems().addAll(items);
                combo.getSelectionModel().selectFirst();
                combo.setPrefWidth(165);
                combo.setPrefHeight(34);
                combo.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-cursor: hand;");
                return combo;
        }

        private void showStoreProfile(Store s) {
                javafx.stage.Stage modal = new javafx.stage.Stage();
                modal.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                modal.setTitle("Store Profile");

                VBox layout = new VBox(20);
                layout.setAlignment(Pos.CENTER);
                layout.setPadding(new Insets(30));
                layout.setStyle("-fx-background-color: white;");

                Label name = new Label(s.storeName());
                name.setFont(Font.font("Arial", FontWeight.BOLD, 22));
                name.setTextFill(Color.web(TEXT));

                GridPane details = new GridPane();
                details.setHgap(20);
                details.setVgap(15);
                details.setAlignment(Pos.CENTER);

                details.add(new Label("Owner:"), 0, 0);
                details.add(new Label(s.owner()), 1, 0);

                details.add(new Label("Products:"), 0, 1);
                details.add(new Label(s.productCount()), 1, 1);

                details.add(new Label("Revenue:"), 0, 2);
                details.add(new Label(s.revenue()), 1, 2);

                details.add(new Label("Status:"), 0, 3);
                Label statusLbl = createVerificationLabel(s.verification());
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

                layout.getChildren().addAll(name, details, closeBtn);

                Scene scene = new Scene(layout, 350, 400);
                modal.setScene(scene);
                modal.showAndWait();
        }

}
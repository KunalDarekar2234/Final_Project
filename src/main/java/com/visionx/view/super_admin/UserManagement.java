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

public class UserManagement {
        private Runnable callBackAction;

        private record User(
                        String initial,
                        String avatarColor,
                        String name,
                        String email,
                        String role,
                        String date,
                        String accountStatus) {
        }

        private java.util.List<User> allUsers = new java.util.ArrayList<>(java.util.Arrays.asList(
                        new User("A", "#68B4D1", "Alex Johnson", "alexjohnson@gmail.com", "Fitness User", "21/03/2023",
                                        "Active"),
                        new User("S", "#B58DE3", "Sarah Lee", "sarah.lee@gmail.com", "Gym Owner", "15/07/2023",
                                        "Active"),
                        new User("M", "#70BFA2", "Michael Chen", "michaelchen@gmail.com", "Fitness User", "13/07/2023",
                                        "Suspended"),
                        new User("E", "#9278D7", "Emily Davis", "emilydavis@gmail.com", "Fitness User", "11/06/2023",
                                        "Active"),
                        new User("D", "#A8B0C8", "David Kim", "davidkim@gmail.com", "Gym Owner", "03/07/2023",
                                        "Active")));

        // =========================================================
        // COLORS
        // =========================================================

        private final String SIDEBAR = "#FFFFFF";
        private final String BG = "#F5F7FB";
        private final String WHITE = "#FFFFFF";

        private final String BLUE = "#2176E8";
        private final String LIGHT_BLUE = "#E8EEFF";

        private final String PURPLE = "#8B7AD8";
        private final String LIGHT_PURPLE = "#DCDDF5";

        private final String GREEN = "#25A65A";
        private final String LIGHT_GREEN = "#CFF3D9";

        private final String RED = "#D9303E";
        private final String LIGHT_RED = "#F8D0D4";

        private final String BORDER = "#D5D9E2";
        private final String TEXT = "#15171A";
        private final String GRAY = "#667085";

        public Scene getUserManagementScene(Runnable callBackAction) {
                this.callBackAction = callBackAction;

                // =====================================================
                // ROOT
                // =====================================================

                BorderPane root = new BorderPane();

                root.setStyle(
                                "-fx-background-color: " + BG + ";");

                // =====================================================
                // SIDEBAR
                // =====================================================

                VBox sidebar = createSidebar();

                // =====================================================
                // RIGHT AREA
                // =====================================================

                BorderPane rightArea = new BorderPane();

                HBox topBar = createTopBar();

                BorderPane content = createMainContent();

                rightArea.setTop(topBar);
                rightArea.setCenter(content);

                root.setLeft(sidebar);
                root.setCenter(rightArea);

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

                sidebar.setPrefWidth(210);
                sidebar.setMinWidth(210);
                sidebar.setMaxWidth(210);

                sidebar.setPadding(
                                new Insets(25, 12, 20, 12));

                sidebar.setStyle(
                                "-fx-background-color: #07152D;");

                // =====================================================
                // LOGO
                // =====================================================

                HBox logo = new HBox(10);

                logo.setAlignment(
                                Pos.CENTER_LEFT);

                logo.setPadding(
                                new Insets(0, 8, 38, 8));

                StackPane logoIcon = new StackPane();

                logoIcon.setPrefSize(43, 43);
                logoIcon.setMaxSize(43, 43);

                logoIcon.setStyle(
                                "-fx-background-color: #4C8FEF;" +
                                                "-fx-background-radius: 11;");

                Label f = new Label("F");

                f.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                22));

                f.setTextFill(Color.WHITE);

                logoIcon.getChildren().add(f);

                Label fitVerse = new Label("FitVerse");

                fitVerse.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                22));

                fitVerse.setTextFill(Color.WHITE);

                logo.getChildren().addAll(
                                logoIcon,
                                fitVerse);

                // =====================================================
                // MENU
                // =====================================================

                VBox menu = new VBox(7);

                HBox dashboardItem = createMenuItem("▦", "Dashboard", false);
                HBox usersItem = createMenuItem("♟", "Users", true);
                HBox gymsItem = createMenuItem("▦", "Gyms", false);
                HBox storesItem = createMenuItem("▤", "Stores", false);
                HBox reportsItem = createMenuItem("▥", "Reports", false);
                HBox settingsItem = createMenuItem("⚙", "Settings", false);

                dashboardItem.setOnMouseClicked(e -> {
                        if (callBackAction != null)
                                callBackAction.run();
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
                profileLetter.setTextFill(Color.web(BLUE));

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

                topBar.setPrefHeight(66);

                topBar.setPadding(
                                new Insets(
                                                10,
                                                25,
                                                10,
                                                25));

                topBar.setAlignment(
                                Pos.CENTER);

                topBar.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #D8DDE6;" +
                                                "-fx-border-width: 0 0 1 0;");

                // =====================================================
                // SEARCH
                // =====================================================

                HBox searchBox = new HBox(10);

                searchBox.setPrefWidth(470);
                searchBox.setPrefHeight(42);

                searchBox.setAlignment(
                                Pos.CENTER_LEFT);

                searchBox.setPadding(
                                new Insets(0, 15, 0, 15));

                searchBox.setStyle(
                                "-fx-background-color: #F5F7FB;" +
                                                "-fx-border-color: #D8DDE6;" +
                                                "-fx-border-radius: 9;" +
                                                "-fx-background-radius: 9;");

                Label searchIcon = new Label("⌕");

                searchIcon.setFont(
                                Font.font(24));

                TextField search = new TextField();

                search.setPromptText(
                                "Search...");

                search.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                search.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;" +
                                                "-fx-padding: 0;");

                HBox.setHgrow(
                                search,
                                Priority.ALWAYS);

                searchBox.getChildren().addAll(
                                searchIcon,
                                search);

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                topBar.getChildren().addAll(
                                searchBox,
                                spacer);

                return topBar;
        }

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        private BorderPane createMainContent() {

                BorderPane wrapper = new BorderPane();

                VBox content = new VBox(16);

                content.setPadding(
                                new Insets(
                                                28,
                                                28,
                                                35,
                                                28));

                content.setStyle(
                                "-fx-background-color: " + BG + ";");

                // =====================================================
                // BREADCRUMB
                // =====================================================

                HBox breadcrumb = new HBox(8);

                Label home = new Label("Home");

                home.setFont(
                                Font.font(
                                                "Arial",
                                                13));

                home.setTextFill(
                                Color.web("#667085"));

                Label slash = new Label("/");

                slash.setTextFill(
                                Color.web("#98A2B3"));

                Label dashboard = new Label("Dashboard");

                dashboard.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                13));

                dashboard.setTextFill(
                                Color.web("#101828"));

                breadcrumb.getChildren().addAll(
                                home,
                                slash,
                                dashboard);

                // =====================================================
                // TITLE
                // =====================================================

                Label title = new Label(
                                "User Management");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                29));

                title.setTextFill(
                                Color.web("#111827"));

                // =====================================================
                // SEPARATOR
                // =====================================================

                Region line = new Region();

                line.setPrefHeight(1);

                line.setStyle(
                                "-fx-background-color: #CBD1DA;");

                // =====================================================
                // TABLE
                // =====================================================

                VBox table = createUserTable();

                VBox.setVgrow(
                                table,
                                Priority.ALWAYS);

                content.getChildren().addAll(
                                breadcrumb,
                                title,
                                line,
                                table);

                // =====================================================
                // SCROLL PANE
                // =====================================================

                ScrollPane scroll = new ScrollPane();

                scroll.setContent(
                                content);

                scroll.setFitToWidth(true);

                scroll.setHbarPolicy(
                                ScrollPane.ScrollBarPolicy.NEVER);

                scroll.setVbarPolicy(
                                ScrollPane.ScrollBarPolicy.AS_NEEDED);

                scroll.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;");

                wrapper.setCenter(scroll);

                return wrapper;
        }

        // =========================================================
        // USER TABLE
        // =========================================================

        private VBox createUserTable() {

                VBox tableCard = new VBox();

                tableCard.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 13;" +
                                                "-fx-border-color: #C9CED8;" +
                                                "-fx-border-radius: 13;");

                // =====================================================
                // FILTER BAR
                // =====================================================

                HBox filters = new HBox(8);

                filters.setPadding(
                                new Insets(
                                                19,
                                                18,
                                                19,
                                                18));

                filters.setAlignment(
                                Pos.CENTER_LEFT);

                // Search users

                TextField userSearch = new TextField();

                userSearch.setPromptText(
                                "Search users...");

                userSearch.setPrefWidth(270);
                userSearch.setPrefHeight(43);

                userSearch.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #8992A3;" +
                                                "-fx-border-radius: 8;" +
                                                "-fx-background-radius: 8;" +
                                                "-fx-padding: 0 14;" +
                                                "-fx-font-size: 14px;");

                Region filterSpacer = new Region();

                HBox.setHgrow(
                                filterSpacer,
                                Priority.ALWAYS);

                ComboBox<String> role = createComboBox(
                                "All Roles", "Fitness User", "Gym Owner");

                ComboBox<String> status = createComboBox(
                                "All Statuses", "Active", "Suspended");

                ComboBox<String> bulk = createComboBox(
                                "Bulk Actions", "Suspend Selected", "Delete Selected");

                filters.getChildren().addAll(
                                userSearch,
                                filterSpacer,
                                role,
                                status,
                                bulk);

                // =====================================================
                // HEADER
                // =====================================================

                GridPane header = createGrid();

                header.setPadding(
                                new Insets(
                                                0,
                                                15,
                                                0,
                                                15));

                header.setPrefHeight(52);

                header.setStyle(
                                "-fx-background-color: #DADBF5;" +
                                                "-fx-border-color: #C7CADB;" +
                                                "-fx-border-width: 1 0 1 0;");

                CheckBox selectAll = new CheckBox();
                selectAll.setCursor(javafx.scene.Cursor.HAND);
                selectAll.setStyle("-fx-accent: #2176E8;");
                header.add(selectAll, 0, 0);

                addHeader(
                                header,
                                "User Profile",
                                1);

                addHeader(
                                header,
                                "Name",
                                2);

                addHeader(
                                header,
                                "Email",
                                3);

                addHeader(
                                header,
                                "Role",
                                4);

                addHeader(
                                header,
                                "Registration Date",
                                5);

                addHeader(
                                header,
                                "Account Status",
                                6);

                addHeader(
                                header,
                                "Actions",
                                7);

                // =====================================================
                // ROWS
                // =====================================================

                VBox rows = new VBox();

                Runnable updateTable = () -> {
                        rows.getChildren().clear();
                        String query = userSearch.getText().toLowerCase();
                        String selectedRole = role.getValue();
                        String selectedStatus = status.getValue();

                        for (User u : allUsers) {
                                boolean matchSearch = u.name().toLowerCase().contains(query)
                                                || u.email().toLowerCase().contains(query);
                                boolean matchRole = selectedRole.equals("All Roles") || u.role().equals(selectedRole);
                                boolean matchStatus = selectedStatus.equals("All Statuses")
                                                || u.accountStatus().equals(selectedStatus);

                                if (matchSearch && matchRole && matchStatus) {
                                        rows.getChildren().add(createUserRow(u));
                                }
                        }
                };

                userSearch.textProperty().addListener((obs, oldV, newV) -> updateTable.run());
                role.valueProperty().addListener((obs, oldV, newV) -> updateTable.run());
                status.valueProperty().addListener((obs, oldV, newV) -> updateTable.run());

                updateTable.run();

                selectAll.setOnAction(e -> {
                        boolean selected = selectAll.isSelected();
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

                bulk.setOnAction(e -> {
                        String action = bulk.getValue();
                        if (action == null || action.equals("Bulk Actions"))
                                return;

                        java.util.List<User> selectedUsers = new java.util.ArrayList<>();
                        for (javafx.scene.Node node : rows.getChildren()) {
                                if (node instanceof GridPane rowGrid) {
                                        for (javafx.scene.Node child : rowGrid.getChildren()) {
                                                if (child instanceof CheckBox cb && cb.isSelected()
                                                                && cb.getUserData() instanceof User u) {
                                                        selectedUsers.add(u);
                                                }
                                        }
                                }
                        }

                        if (action.equals("Delete Selected")) {
                                allUsers.removeAll(selectedUsers);
                        } else if (action.equals("Suspend Selected")) {
                                for (int i = 0; i < allUsers.size(); i++) {
                                        User u = allUsers.get(i);
                                        if (selectedUsers.contains(u)) {
                                                allUsers.set(i, new User(u.initial(), u.avatarColor(), u.name(),
                                                                u.email(), u.role(), u.date(), "Suspended"));
                                        }
                                }
                        }

                        javafx.application.Platform.runLater(() -> bulk.getSelectionModel().selectFirst());
                        updateTable.run();
                });

                // =====================================================
                // FOOTER
                // =====================================================

                HBox footer = new HBox(7);

                footer.setPadding(
                                new Insets(
                                                13,
                                                15,
                                                13,
                                                15));

                footer.setAlignment(
                                Pos.CENTER_LEFT);

                Label previous = new Label("Previous");

                previous.setPadding(
                                new Insets(
                                                8,
                                                12,
                                                8,
                                                12));

                previous.setStyle(
                                "-fx-border-color: #D0D5DD;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: #667085;" +
                                                "-fx-cursor: hand;");

                previous.setOnMouseEntered(e -> previous.setStyle(
                                "-fx-background-color: #F1F5F9;" +
                                                "-fx-border-color: #D0D5DD;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: #667085;" +
                                                "-fx-cursor: hand;"));

                previous.setOnMouseExited(e -> previous.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: #D0D5DD;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: #667085;" +
                                                "-fx-cursor: hand;"));

                Label page1 = pageNumber(
                                "1",
                                true);

                Label page2 = pageNumber(
                                "2",
                                false);

                Label page3 = pageNumber(
                                "3",
                                false);

                Label dots = new Label("...");

                dots.setPadding(
                                new Insets(8, 5, 8, 5));

                Label page10 = pageNumber(
                                "10",
                                false);

                Label next = new Label("Next");

                next.setPadding(
                                new Insets(
                                                8,
                                                12,
                                                8,
                                                12));

                next.setStyle(
                                "-fx-border-color: #D0D5DD;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: #344054;" +
                                                "-fx-cursor: hand;");

                next.setOnMouseEntered(e -> next.setStyle(
                                "-fx-background-color: #F1F5F9;" +
                                                "-fx-border-color: #D0D5DD;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: #344054;" +
                                                "-fx-cursor: hand;"));

                next.setOnMouseExited(e -> next.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: #D0D5DD;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: #344054;" +
                                                "-fx-cursor: hand;"));

                footer.getChildren().addAll(
                                previous,
                                page1,
                                page2,
                                page3,
                                dots,
                                page10,
                                next);

                // =====================================================
                // ADD ALL
                // =====================================================

                tableCard.getChildren().addAll(
                                filters,
                                header,
                                rows,
                                footer);

                return tableCard;
        }

        // =========================================================
        // GRID
        // =========================================================

        private GridPane createGrid() {

                GridPane grid = new GridPane();

                grid.setMaxWidth(
                                Double.MAX_VALUE);

                /*
                 * IMPORTANT:
                 *
                 * Same percentage widths are used
                 * for header and every row.
                 *
                 * This fixes the blank-column problem.
                 */

                double[] widths = {
                                4,
                                8,
                                11,
                                22,
                                13,
                                14,
                                12,
                                16
                };

                for (double width : widths) {

                        ColumnConstraints column = new ColumnConstraints();

                        column.setPercentWidth(width);

                        column.setHgrow(
                                        Priority.ALWAYS);

                        grid.getColumnConstraints()
                                        .add(column);
                }

                return grid;
        }

        // =========================================================
        // HEADER LABEL
        // =========================================================

        private void addHeader(
                        GridPane grid,
                        String text,
                        int column) {

                Label label = new Label(text);

                label.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                13));

                label.setTextFill(
                                Color.web("#171A21"));

                label.setAlignment(
                                Pos.CENTER_LEFT);

                label.setMaxWidth(
                                Double.MAX_VALUE);

                grid.add(
                                label,
                                column,
                                0);
        }

        // =========================================================
        // USER ROW
        // =========================================================

        private GridPane createUserRow(
                        User u) {

                String initial = u.initial();
                String avatarColor = u.avatarColor();
                String name = u.name();
                String email = u.email();
                String role = u.role();
                String date = u.date();
                String accountStatus = u.accountStatus();

                GridPane row = createGrid();

                row.setMinHeight(64);
                row.setPrefHeight(64);

                row.setPadding(
                                new Insets(
                                                0,
                                                15,
                                                0,
                                                15));

                row.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #D7DAE1;" +
                                                "-fx-border-width: 0 0 1 0;");

                row.setOnMouseEntered(e -> {
                        row.setStyle(
                                        "-fx-background-color: #F8FAFC;" +
                                                        "-fx-border-color: #D7DAE1;" +
                                                        "-fx-border-width: 0 0 1 0;");
                });

                row.setOnMouseExited(e -> {
                        row.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: #D7DAE1;" +
                                                        "-fx-border-width: 0 0 1 0;");
                });

                CheckBox cb = new CheckBox();
                cb.setCursor(javafx.scene.Cursor.HAND);
                cb.setStyle("-fx-accent: #2176E8;");
                cb.setUserData(u);

                row.add(
                                cb,
                                0,
                                0);

                // =====================================================
                // PROFILE
                // =====================================================

                Circle avatarCircle = new Circle(21);

                avatarCircle.setFill(
                                Color.web(avatarColor));

                Label initialLabel = new Label(initial);

                initialLabel.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                15));

                initialLabel.setTextFill(
                                Color.WHITE);

                StackPane avatar = new StackPane(
                                avatarCircle,
                                initialLabel);

                row.add(
                                avatar,
                                1,
                                0);

                // =====================================================
                // NAME
                // =====================================================

                Label nameLabel = createRowLabel(
                                name,
                                true);

                row.add(
                                nameLabel,
                                2,
                                0);

                // =====================================================
                // EMAIL
                // =====================================================

                Label emailLabel = createRowLabel(
                                email,
                                false);

                row.add(
                                emailLabel,
                                3,
                                0);

                // =====================================================
                // ROLE
                // =====================================================

                Label roleLabel = createRowLabel(
                                role,
                                false);

                row.add(
                                roleLabel,
                                4,
                                0);

                // =====================================================
                // DATE
                // =====================================================

                Label dateLabel = createRowLabel(
                                date,
                                false);

                row.add(
                                dateLabel,
                                5,
                                0);

                // =====================================================
                // STATUS
                // =====================================================

                Label statusLabel = new Label(
                                accountStatus);

                statusLabel.setFont(
                                Font.font(
                                                "Arial",
                                                13));

                statusLabel.setPadding(
                                new Insets(
                                                5,
                                                10,
                                                5,
                                                10));

                if (accountStatus.equals("Active")) {

                        statusLabel.setTextFill(
                                        Color.web("#166534"));

                        statusLabel.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_GREEN + ";" +
                                                        "-fx-background-radius: 15;");

                } else {

                        statusLabel.setTextFill(
                                        Color.web("#8B1E2D"));

                        statusLabel.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_RED + ";" +
                                                        "-fx-background-radius: 15;");
                }

                row.add(
                                statusLabel,
                                6,
                                0);

                // =====================================================
                // ACTIONS
                // =====================================================

                HBox actions = new HBox(7);

                actions.setAlignment(
                                Pos.CENTER_LEFT);

                Button view = createActionButton(
                                "◉  View",
                                "#F8FAFC",
                                "#25345C",
                                "#7A86A8");

                view.setOnAction(e -> showUserProfile(u));

                actions.getChildren().addAll(
                                view);

                row.add(
                                actions,
                                7,
                                0);

                return row;
        }

        // =========================================================
        // ROW LABEL
        // =========================================================

        private Label createRowLabel(
                        String text,
                        boolean bold) {

                Label label = new Label(text);

                label.setFont(
                                Font.font(
                                                "Arial",
                                                bold
                                                                ? FontWeight.BOLD
                                                                : FontWeight.NORMAL,
                                                14));

                label.setTextFill(
                                Color.web("#101828"));

                label.setMaxWidth(
                                Double.MAX_VALUE);

                return label;
        }

        // =========================================================
        // ACTION BUTTON
        // =========================================================

        private Button createActionButton(
                        String text,
                        String background,
                        String textColor,
                        String borderColor) {

                Button button = new Button(text);

                button.setPrefHeight(34);

                button.setPadding(
                                new Insets(
                                                0,
                                                11,
                                                0,
                                                11));

                button.setStyle(
                                "-fx-background-color: " +
                                                background + ";" +
                                                "-fx-text-fill: " +
                                                textColor + ";" +
                                                "-fx-border-color: " +
                                                borderColor + ";" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-font-size: 12px;" +
                                                "-fx-cursor: hand;");

                button.setOnMouseEntered(e -> {
                        button.setStyle(
                                        "-fx-background-color: #E2E8F0;" +
                                                        "-fx-text-fill: " + textColor + ";" +
                                                        "-fx-border-color: " + borderColor + ";" +
                                                        "-fx-border-radius: 6;" +
                                                        "-fx-background-radius: 6;" +
                                                        "-fx-font-size: 12px;" +
                                                        "-fx-cursor: hand;");
                });

                button.setOnMouseExited(e -> {
                        button.setStyle(
                                        "-fx-background-color: " + background + ";" +
                                                        "-fx-text-fill: " + textColor + ";" +
                                                        "-fx-border-color: " + borderColor + ";" +
                                                        "-fx-border-radius: 6;" +
                                                        "-fx-background-radius: 6;" +
                                                        "-fx-font-size: 12px;" +
                                                        "-fx-cursor: hand;");
                });

                return button;
        }

        // =========================================================
        // SHOW PROFILE MODAL
        // =========================================================

        private void showUserProfile(User u) {
                javafx.stage.Stage modal = new javafx.stage.Stage();
                modal.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                modal.setTitle("User Profile");

                VBox layout = new VBox(20);
                layout.setAlignment(Pos.CENTER);
                layout.setPadding(new Insets(30));
                layout.setStyle("-fx-background-color: white;");

                Circle avatar = new Circle(40, Color.web(u.avatarColor()));
                Label initial = new Label(u.initial());
                initial.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                initial.setTextFill(Color.WHITE);
                StackPane avatarStack = new StackPane(avatar, initial);

                Label name = new Label(u.name());
                name.setFont(Font.font("Arial", FontWeight.BOLD, 22));
                name.setTextFill(Color.web(TEXT));

                GridPane details = new GridPane();
                details.setHgap(20);
                details.setVgap(15);
                details.setAlignment(Pos.CENTER);

                details.add(new Label("Email:"), 0, 0);
                details.add(new Label(u.email()), 1, 0);

                details.add(new Label("Role:"), 0, 1);
                details.add(new Label(u.role()), 1, 1);

                details.add(new Label("Joined:"), 0, 2);
                details.add(new Label(u.date()), 1, 2);

                details.add(new Label("Status:"), 0, 3);
                Label statusLbl = new Label(u.accountStatus());
                if (u.accountStatus().equals("Active")) {
                        statusLbl.setTextFill(Color.web("#166534"));
                } else {
                        statusLbl.setTextFill(Color.web("#8B1E2D"));
                }
                details.add(statusLbl, 1, 3);

                for (javafx.scene.Node n : details.getChildren()) {
                        if (n instanceof Label l) {
                                l.setFont(Font.font("Arial", 14));
                        }
                }

                Button closeBtn = new Button("Close");
                closeBtn.setPrefWidth(120);
                closeBtn.setPrefHeight(35);
                closeBtn.setStyle("-fx-background-color: " + BLUE
                                + "; -fx-text-fill: white; -fx-background-radius: 5; -fx-cursor: hand;");
                closeBtn.setOnAction(e -> modal.close());

                layout.getChildren().addAll(avatarStack, name, details, closeBtn);

                Scene scene = new Scene(layout, 350, 400);
                modal.setScene(scene);
                modal.showAndWait();
        }

        // =========================================================
        // COMBOBOX
        // =========================================================

        private ComboBox<String> createComboBox(String... items) {
                ComboBox<String> combo = new ComboBox<>();
                combo.getItems().addAll(items);
                combo.getSelectionModel().selectFirst();
                combo.setPrefWidth(180);
                combo.setPrefHeight(43);
                combo.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #8992A3;" +
                                                "-fx-border-radius: 8;" +
                                                "-fx-background-radius: 8;" +
                                                "-fx-text-fill: #344054;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-cursor: hand;");
                return combo;
        }

        // =========================================================
        // FILTER BUTTON
        // =========================================================

        private Button createFilter(
                        String text) {

                Button button = new Button(
                                text + "        ▾");

                button.setPrefWidth(180);
                button.setPrefHeight(43);

                button.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #8992A3;" +
                                                "-fx-border-radius: 8;" +
                                                "-fx-background-radius: 8;" +
                                                "-fx-text-fill: #344054;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-alignment: CENTER_LEFT;" +
                                                "-fx-padding: 0 14;" +
                                                "-fx-cursor: hand;");

                button.setOnMouseEntered(e -> {
                        button.setStyle(
                                        "-fx-background-color: #F1F5F9;" +
                                                        "-fx-border-color: #8992A3;" +
                                                        "-fx-border-radius: 8;" +
                                                        "-fx-background-radius: 8;" +
                                                        "-fx-text-fill: #344054;" +
                                                        "-fx-font-size: 14px;" +
                                                        "-fx-alignment: CENTER_LEFT;" +
                                                        "-fx-padding: 0 14;" +
                                                        "-fx-cursor: hand;");
                });

                button.setOnMouseExited(e -> {
                        button.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: #8992A3;" +
                                                        "-fx-border-radius: 8;" +
                                                        "-fx-background-radius: 8;" +
                                                        "-fx-text-fill: #344054;" +
                                                        "-fx-font-size: 14px;" +
                                                        "-fx-alignment: CENTER_LEFT;" +
                                                        "-fx-padding: 0 14;" +
                                                        "-fx-cursor: hand;");
                });

                return button;
        }

        // =========================================================
        // PAGE NUMBER
        // =========================================================

        private Label pageNumber(
                        String text,
                        boolean active) {

                Label page = new Label(text);

                page.setAlignment(
                                Pos.CENTER);

                page.setPrefSize(
                                32,
                                32);

                if (active) {

                        page.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_PURPLE + ";" +
                                                        "-fx-background-radius: 6;" +
                                                        "-fx-text-fill: #30376D;" +
                                                        "-fx-font-weight: bold;");

                } else {

                        page.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: #D0D5DD;" +
                                                        "-fx-border-radius: 6;" +
                                                        "-fx-background-radius: 6;" +
                                                        "-fx-text-fill: #344054;" +
                                                        "-fx-cursor: hand;");

                        page.setOnMouseEntered(e -> {
                                page.setStyle(
                                                "-fx-background-color: #F1F5F9;" +
                                                                "-fx-border-color: #D0D5DD;" +
                                                                "-fx-border-radius: 6;" +
                                                                "-fx-background-radius: 6;" +
                                                                "-fx-text-fill: #344054;" +
                                                                "-fx-cursor: hand;");
                        });

                        page.setOnMouseExited(e -> {
                                page.setStyle(
                                                "-fx-background-color: white;" +
                                                                "-fx-border-color: #D0D5DD;" +
                                                                "-fx-border-radius: 6;" +
                                                                "-fx-background-radius: 6;" +
                                                                "-fx-text-fill: #344054;" +
                                                                "-fx-cursor: hand;");
                        });
                }

                return page;
        }

}
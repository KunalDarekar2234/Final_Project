package com.visionx.view.super_admin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;

public class Reports {
        private Runnable callBackAction;

        private record Report(
                        String name,
                        String dateRange,
                        String generatedOn,
                        String status) {
        }

        private java.util.List<Report> allReports = new java.util.ArrayList<>(java.util.Arrays.asList(
                        new Report("Monthly Sales Report - Oct 2023", "10/01/23 - 10/31/23", "Nov 1, 2023, 10:00 AM",
                                        "Ready"),
                        new Report("User Growth Q3 2023", "07/01/23 - 09/30/23", "Oct 5, 2023, 02:30 PM", "Ready"),
                        new Report("Revenue by Location - YTD", "01/01/23 - 10/31/23", "Nov 1, 2023, 10:15 AM",
                                        "Processing..."),
                        new Report("Member Retention Analysis", "09/01/23 - 09/30/23", "Oct 2, 2023, 11:00 AM",
                                        "Failed")));

        // =========================================================
        // COLORS
        // =========================================================

        private static final String BLUE = "#1769E0";
        private static final String DARK_BLUE = "#07152D";

        private static final String BG = "#F5F8FC";
        private static final String WHITE = "#FFFFFF";

        private static final String TEXT = "#17212F";
        private static final String GRAY = "#657181";

        private static final String BORDER = "#D7DEE8";
        private static final String HEADER_BG = "#EEF2F6";

        private static final String GREEN = "#20A864";
        private static final String LIGHT_GREEN = "#DDF6E8";

        private static final String YELLOW = "#E6A700";
        private static final String LIGHT_YELLOW = "#FFF2CC";

        private static final String RED = "#D9343E";
        private static final String LIGHT_RED = "#FFE0E2";

        // =========================================================
        // START
        // =========================================================

        public Scene getReportsScene(Runnable callBackAction) {
                this.callBackAction = callBackAction;

                BorderPane root = new BorderPane();

                root.setStyle(
                                "-fx-background-color: " + BG + ";");

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

                Scene scene = new Scene(root, 1450, 850);

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

                // -----------------------------------------------------
                // LOGO
                // -----------------------------------------------------

                HBox logoBox = new HBox(10);

                logoBox.setAlignment(Pos.CENTER_LEFT);

                logoBox.setPadding(
                                new Insets(0, 10, 35, 10));

                StackPane logo = new StackPane();

                logo.setPrefSize(45, 45);
                logo.setMinSize(45, 45);
                logo.setMaxSize(45, 45);

                logo.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-background-radius: 10;");

                Label logoLetter = new Label("F");

                logoLetter.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                26));

                logoLetter.setTextFill(Color.WHITE);

                logo.getChildren().add(logoLetter);

                Label fitVerse = new Label("FitVerse");

                fitVerse.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                23));

                fitVerse.setTextFill(Color.WHITE);

                logoBox.getChildren().addAll(
                                logo,
                                fitVerse);

                // -----------------------------------------------------
                // MENU
                // -----------------------------------------------------

                VBox menu = new VBox(7);

                HBox dashboardItem = createMenuItem("▦", "Dashboard", false);
                HBox usersItem = createMenuItem("♟", "Users", false);
                HBox gymsItem = createMenuItem("▣", "Gyms", false);
                HBox storesItem = createMenuItem("▤", "Stores", false);
                HBox reportsItem = createMenuItem("▥", "Reports", true);
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

                // -----------------------------------------------------
                // SPACER
                // -----------------------------------------------------

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

                item.setAlignment(
                                Pos.CENTER_LEFT);

                item.setPadding(
                                new Insets(0, 12, 0, 12));

                Label iconLabel = new Label(icon);

                iconLabel.setFont(
                                Font.font(
                                                "Arial",
                                                17));

                Label textLabel = new Label(text);

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
                                                        "-fx-background-radius: 9;");

                        iconLabel.setTextFill(Color.WHITE);

                        textLabel.setTextFill(Color.WHITE);

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

                // -----------------------------------------------------
                // TITLE
                // -----------------------------------------------------

                Label title = new Label(
                                "Super Admin Dashboard");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                19));

                title.setTextFill(
                                Color.web(TEXT));

                // -----------------------------------------------------
                // SPACER
                // -----------------------------------------------------

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                // -----------------------------------------------------
                // NOTIFICATION
                // -----------------------------------------------------

                Label notification = new Label("♧");

                notification.setFont(
                                Font.font(
                                                "Arial",
                                                23));

                notification.setTextFill(
                                Color.web("#596575"));

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
                                                28,
                                                35,
                                                35,
                                                35));

                content.setStyle(
                                "-fx-background-color: " + BG + ";");

                // -----------------------------------------------------
                // PAGE TITLE
                // -----------------------------------------------------

                Label pageTitle = new Label(
                                "Enterprise Reporting Center");

                pageTitle.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                30));

                pageTitle.setTextFill(
                                Color.web(TEXT));

                // -----------------------------------------------------
                // REPORT AREA
                // -----------------------------------------------------

                HBox reportArea = new HBox(25);

                reportArea.setAlignment(
                                Pos.TOP_LEFT);

                Runnable[] updateRef = new Runnable[1];

                VBox generateCard = createGenerateReportCard(updateRef);

                VBox recentCard = createRecentReportsCard(updateRef);

                HBox.setHgrow(
                                recentCard,
                                Priority.ALWAYS);

                reportArea.getChildren().addAll(
                                generateCard,
                                recentCard);

                content.getChildren().addAll(
                                pageTitle,
                                reportArea);

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
        // GENERATE REPORT CARD
        // =========================================================

        private VBox createGenerateReportCard(Runnable[] updateRef) {

                VBox card = new VBox(18);

                card.setPrefWidth(355);
                card.setMinWidth(355);

                card.setPadding(
                                new Insets(22));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 10;" +
                                                "-fx-background-radius: 10;");

                // -----------------------------------------------------
                // CARD TITLE
                // -----------------------------------------------------

                Label title = new Label(
                                "Generate New Report");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                21));

                title.setTextFill(
                                Color.web(TEXT));

                // -----------------------------------------------------
                // REPORT TYPE LABEL
                // -----------------------------------------------------

                Label typeLabel = createFieldLabel(
                                "Report Type");

                // -----------------------------------------------------
                // REPORT TYPE COMBOBOX
                // -----------------------------------------------------

                ComboBox<String> reportType = new ComboBox<>();

                reportType.getItems().addAll(
                                "Monthly Sales",
                                "User Growth",
                                "Member Retention",
                                "Revenue by Location");

                reportType.setValue(
                                "Monthly Sales");

                reportType.setMaxWidth(
                                Double.MAX_VALUE);

                reportType.setPrefHeight(40);

                reportType.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #BFC9D6;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-text-fill: " + TEXT + ";");

                // -----------------------------------------------------
                // DATE LABEL
                // -----------------------------------------------------

                Label dateLabel = createFieldLabel(
                                "Date Range");

                // -----------------------------------------------------
                // DATE FIELD
                // -----------------------------------------------------

                TextField dateField = new TextField(
                                "Oct 1, 2023 - Oct 31, 2023");

                dateField.setPrefHeight(40);

                dateField.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #BFC9D6;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-text-fill: " + TEXT + ";");

                // -----------------------------------------------------
                // EXPORT FORMAT
                // -----------------------------------------------------

                Label exportLabel = createFieldLabel(
                                "Export Format");

                ToggleGroup exportGroup = new ToggleGroup();

                RadioButton pdf = new RadioButton("PDF");

                RadioButton excel = new RadioButton("Excel");

                RadioButton csv = new RadioButton("CSV");

                pdf.setToggleGroup(exportGroup);
                excel.setToggleGroup(exportGroup);
                csv.setToggleGroup(exportGroup);

                pdf.setSelected(true);

                pdf.setTextFill(Color.web(TEXT));
                excel.setTextFill(Color.web(TEXT));
                csv.setTextFill(Color.web(TEXT));

                pdf.setFont(
                                Font.font("Arial", 14));

                excel.setFont(
                                Font.font("Arial", 14));

                csv.setFont(
                                Font.font("Arial", 14));

                HBox formats = new HBox(
                                20,
                                pdf,
                                excel,
                                csv);

                formats.setAlignment(
                                Pos.CENTER_LEFT);

                // -----------------------------------------------------
                // GENERATE BUTTON
                // -----------------------------------------------------

                Button generate = new Button(
                                "Generate Report");

                generate.setPrefHeight(42);

                generate.setMaxWidth(
                                Double.MAX_VALUE);

                generate.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-size: 15px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-cursor: hand;");

                generate.setOnMouseEntered(e -> {

                        generate.setStyle(
                                        "-fx-background-color: #0F5AC8;" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-font-size: 15px;" +
                                                        "-fx-font-weight: bold;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-cursor: hand;");

                });

                generate.setOnMouseExited(e -> {

                        generate.setStyle(
                                        "-fx-background-color: " + BLUE + ";" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-font-size: 15px;" +
                                                        "-fx-font-weight: bold;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-cursor: hand;");

                });

                generate.setOnAction(e -> {
                        String selectedType = reportType.getValue();
                        String range = dateField.getText();
                        String time = java.time.LocalDateTime.now()
                                        .format(java.time.format.DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm a"));

                        allReports.add(0, new Report(selectedType, range, time, "Processing..."));
                        if (updateRef[0] != null)
                                updateRef[0].run();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("FitVerse");
                        alert.setHeaderText("Report Generation");
                        alert.setContentText("Your " + selectedType + " report is being generated.");
                        alert.showAndWait();
                });

                card.getChildren().addAll(

                                title,

                                typeLabel,
                                reportType,

                                dateLabel,
                                dateField,

                                exportLabel,
                                formats,

                                generate);

                return card;
        }

        // =========================================================
        // FIELD LABEL
        // =========================================================

        private Label createFieldLabel(
                        String text) {

                Label label = new Label(text);

                label.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                14));

                label.setTextFill(
                                Color.web(TEXT));

                return label;
        }

        // =========================================================
        // RECENT REPORTS CARD
        // =========================================================

        private VBox createRecentReportsCard(Runnable[] updateRef) {

                VBox card = new VBox(0);

                card.setPadding(
                                new Insets(22));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 10;" +
                                                "-fx-background-radius: 10;");

                HBox topArea = new HBox(20);
                topArea.setAlignment(Pos.CENTER_LEFT);

                Label title = new Label(
                                "Recently Generated Reports");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                21));

                title.setTextFill(
                                Color.web(TEXT));

                Region topSpacer = new Region();
                HBox.setHgrow(topSpacer, Priority.ALWAYS);

                ComboBox<String> bulk = new ComboBox<>();
                bulk.getItems().addAll("Bulk Actions", "Delete Selected");
                bulk.getSelectionModel().selectFirst();
                bulk.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 6;" +
                                                "-fx-background-radius: 6;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-cursor: hand;");

                topArea.getChildren().addAll(title, topSpacer, bulk);

                VBox.setMargin(
                                topArea,
                                new Insets(0, 0, 18, 0));

                // -----------------------------------------------------
                // TABLE HEADER
                // -----------------------------------------------------

                GridPane header = createReportHeader();

                // -----------------------------------------------------
                // REPORT ROWS
                // -----------------------------------------------------

                VBox rows = new VBox();

                Runnable updateTable = () -> {
                        rows.getChildren().clear();
                        for (Report r : allReports) {
                                rows.getChildren().add(createReportRow(r, updateRef[0]));
                        }
                };
                updateRef[0] = updateTable;

                updateTable.run();

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

                        java.util.List<Report> toDelete = new java.util.ArrayList<>();
                        for (javafx.scene.Node node : rows.getChildren()) {
                                if (node instanceof GridPane rowGrid) {
                                        for (javafx.scene.Node child : rowGrid.getChildren()) {
                                                if (child instanceof CheckBox cb && cb.isSelected()
                                                                && cb.getUserData() instanceof Report r) {
                                                        toDelete.add(r);
                                                }
                                        }
                                }
                        }

                        if (action.equals("Delete Selected")) {
                                allReports.removeAll(toDelete);
                        }

                        javafx.application.Platform.runLater(() -> bulk.getSelectionModel().selectFirst());
                        updateTable.run();
                });

                card.getChildren().addAll(
                                topArea,
                                header,
                                rows);

                return card;
        }

        // =========================================================
        // REPORT HEADER
        // =========================================================

        private GridPane createReportHeader() {

                GridPane header = new GridPane();

                header.setMinHeight(43);
                header.setPrefHeight(43);

                header.setPadding(
                                new Insets(
                                                0,
                                                10,
                                                0,
                                                10));

                header.setStyle(
                                "-fx-background-color: " +
                                                HEADER_BG + ";" +
                                                "-fx-border-color: " +
                                                BORDER + ";" +
                                                "-fx-border-width: 1 0 1 0;");

                CheckBox selectAll = new CheckBox();
                selectAll.setCursor(javafx.scene.Cursor.HAND);
                selectAll.setStyle("-fx-accent: #21A65A;");
                header.add(selectAll, 0, 0);

                double[] widths = {
                                4,
                                28,
                                21,
                                23,
                                15,
                                9
                };

                String[] titles = {
                                "Report Name",
                                "Date Range",
                                "Generated On",
                                "Status",
                                "Action"
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
        // REPORT ROW
        // =========================================================

        private GridPane createReportRow(
                        Report r, Runnable updateTable) {

                GridPane row = new GridPane();

                row.setMinHeight(61);
                row.setPrefHeight(61);

                row.setPadding(
                                new Insets(
                                                0,
                                                10,
                                                0,
                                                10));

                row.setAlignment(
                                Pos.CENTER_LEFT);

                row.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " +
                                                BORDER + ";" +
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
                                28,
                                21,
                                23,
                                15,
                                9
                };

                for (double width : widths) {

                        ColumnConstraints column = new ColumnConstraints();

                        column.setPercentWidth(width);

                        row.getColumnConstraints()
                                        .add(column);
                }

                CheckBox cb = new CheckBox();
                cb.setCursor(javafx.scene.Cursor.HAND);
                cb.setStyle("-fx-accent: #21A65A;");
                cb.setUserData(r);
                row.add(cb, 0, 0);

                // -----------------------------------------------------
                // NAME
                // -----------------------------------------------------

                Label nameLabel = new Label(r.name());

                nameLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                nameLabel.setTextFill(
                                Color.web(TEXT));

                nameLabel.setWrapText(true);

                row.add(
                                nameLabel,
                                1,
                                0);

                // -----------------------------------------------------
                // DATE
                // -----------------------------------------------------

                Label dateLabel = new Label(r.dateRange());

                dateLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                dateLabel.setTextFill(
                                Color.web(TEXT));

                row.add(
                                dateLabel,
                                2,
                                0);

                // -----------------------------------------------------
                // GENERATED ON
                // -----------------------------------------------------

                Label generatedLabel = new Label(r.generatedOn());

                generatedLabel.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                generatedLabel.setTextFill(
                                Color.web(TEXT));

                row.add(
                                generatedLabel,
                                3,
                                0);

                // -----------------------------------------------------
                // STATUS
                // -----------------------------------------------------

                Label statusLabel = createReportStatus(r.status());

                row.add(
                                statusLabel,
                                4,
                                0);

                // -----------------------------------------------------
                // ACTION
                // -----------------------------------------------------

                Button actionButton;

                if (r.status().equals("Ready")) {

                        actionButton = createDownloadButton("↓");

                        actionButton.setOnAction(e -> {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("FitVerse");
                                alert.setHeaderText("Report Ready");
                                alert.setContentText("Report downloaded successfully.");
                                alert.showAndWait();
                        });

                } else if (r.status().equals("Processing...")) {

                        actionButton = createDownloadButton("↓");

                        actionButton.setDisable(true);

                } else {

                        actionButton = createDownloadButton("↻");

                        actionButton.setOnAction(e -> {
                                int idx = allReports.indexOf(r);
                                if (idx != -1) {
                                        allReports.set(idx, new Report(r.name(), r.dateRange(), r.generatedOn(),
                                                        "Processing..."));
                                        updateTable.run();
                                }
                        });
                }

                row.add(
                                actionButton,
                                5,
                                0);

                return row;
        }

        // =========================================================
        // STATUS
        // =========================================================

        private Label createReportStatus(
                        String status) {

                Label label = new Label();

                label.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.NORMAL,
                                                13));

                if (status.equals("Ready")) {

                        label.setText(
                                        "● Ready");

                        label.setTextFill(
                                        Color.web("#176C3D"));

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_GREEN + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 6 12;");

                }

                else if (status.equals("Processing...")) {

                        label.setText(
                                        "● Processing...");

                        label.setTextFill(
                                        Color.web("#896500"));

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_YELLOW + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 6 12;");

                }

                else {

                        label.setText(
                                        "● Failed");

                        label.setTextFill(
                                        Color.web("#8C1D25"));

                        label.setStyle(
                                        "-fx-background-color: " +
                                                        LIGHT_RED + ";" +
                                                        "-fx-background-radius: 15;" +
                                                        "-fx-padding: 6 12;");
                }

                return label;
        }

        // =========================================================
        // DOWNLOAD BUTTON
        // =========================================================

        private Button createDownloadButton(
                        String text) {

                Button button = new Button(text);

                button.setPrefSize(
                                42,
                                36);

                button.setMinSize(
                                42,
                                36);

                button.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-size: 18px;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-cursor: hand;");

                button.setOnMouseEntered(e -> {

                        if (!button.isDisabled()) {

                                button.setStyle(
                                                "-fx-background-color: #F1F5FA;" +
                                                                "-fx-border-color: " + BLUE + ";" +
                                                                "-fx-border-radius: 7;" +
                                                                "-fx-background-radius: 7;" +
                                                                "-fx-font-size: 18px;" +
                                                                "-fx-text-fill: " + BLUE + ";" +
                                                                "-fx-cursor: hand;");
                        }

                });

                button.setOnMouseExited(e -> {

                        button.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-border-color: #C8D0DA;" +
                                                        "-fx-border-radius: 7;" +
                                                        "-fx-background-radius: 7;" +
                                                        "-fx-font-size: 18px;" +
                                                        "-fx-text-fill: " + TEXT + ";" +
                                                        "-fx-cursor: hand;");

                });

                // Action handler removed here, moved to row builder for custom actions.

                return button;
        }

}
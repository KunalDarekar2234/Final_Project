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

public class SettingsPage {
        private Runnable callBackAction;

        // =========================================================
        // COLORS
        // =========================================================

        private static final String BLUE = "#1769E0";
        private static final String DARK_BLUE = "#07152D";
        private static final String BG = "#F5F8FC";
        private static final String WHITE = "#FFFFFF";

        private static final String BORDER = "#D7DEE8";
        private static final String TEXT = "#17212F";
        private static final String GRAY = "#657181";

        private static final String LIGHT_BLUE = "#EAF2FF";
        private static final String RED = "#D9343E";

        // =========================================================
        // START
        // =========================================================

        public Scene getSettingsPageScene(Runnable callBackAction) {
                this.callBackAction = callBackAction;

                BorderPane root = new BorderPane();

                root.setStyle(
                                "-fx-background-color: " + BG + ";");

                // LEFT SIDEBAR
                VBox sidebar = createSidebar();

                // RIGHT SIDE
                BorderPane rightSide = new BorderPane();

                HBox topBar = createTopBar();

                VBox content = createSettingsContent();

                rightSide.setTop(topBar);
                rightSide.setCenter(content);

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

                logo.setPrefSize(42, 42);
                logo.setMaxSize(42, 42);

                logo.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-background-radius: 10;");

                Label logoLetter = new Label("F");

                logoLetter.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                25));

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

                // =====================================================
                // MENU
                // =====================================================

                VBox menu = new VBox(7);

                HBox dashboardItem = createMenuItem("▦", "Dashboard", false);
                HBox usersItem = createMenuItem("♟", "Users", false);
                HBox gymsItem = createMenuItem("▣", "Gyms", false);
                HBox storesItem = createMenuItem("▤", "Stores", false);
                HBox reportsItem = createMenuItem("▥", "Reports", false);
                HBox settingsItem = createMenuItem("⚙", "Settings", true);

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
                                                14));

                if (active) {

                        item.setStyle(
                                        "-fx-background-color: " + BLUE + ";" +
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

                // =====================================================
                // TITLE
                // =====================================================

                Label title = new Label(
                                "Super Admin Dashboard");

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                19));

                title.setTextFill(
                                Color.web(TEXT));

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

                Label bell = new Label("♧");

                bell.setFont(
                                Font.font(
                                                "Arial",
                                                23));

                bell.setTextFill(
                                Color.web("#596575"));

                Circle dot = new Circle(4);

                dot.setFill(
                                Color.web(RED));

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
        // SETTINGS CONTENT
        // =========================================================

        private VBox createSettingsContent() {

                VBox main = new VBox(20);

                main.setPadding(
                                new Insets(
                                                30,
                                                40,
                                                40,
                                                40));

                main.setStyle(
                                "-fx-background-color: " + BG + ";");

                // =====================================================
                // PAGE TITLE
                // =====================================================

                Label pageTitle = new Label(
                                "Settings");

                pageTitle.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                30));

                pageTitle.setTextFill(
                                Color.web(TEXT));

                Label subtitle = new Label(
                                "Manage your FitVerse platform settings and preferences.");

                subtitle.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                subtitle.setTextFill(
                                Color.web(GRAY));

                VBox heading = new VBox(
                                5,
                                pageTitle,
                                subtitle);

                // =====================================================
                // SETTINGS CARDS
                // =====================================================

                HBox columns = new HBox(20);

                VBox leftColumn = new VBox(20);
                VBox rightColumn = new VBox(20);

                HBox.setHgrow(
                                leftColumn,
                                Priority.ALWAYS);

                HBox.setHgrow(
                                rightColumn,
                                Priority.ALWAYS);

                // GENERAL SETTINGS
                VBox generalCard = createGeneralSettings();

                // ADMIN PROFILE
                VBox profileCard = createAdminProfile();

                // NOTIFICATION SETTINGS
                VBox notificationCard = createNotificationSettings();

                // SECURITY
                VBox securityCard = createSecuritySettings();

                leftColumn.getChildren().addAll(
                                generalCard,
                                profileCard);

                rightColumn.getChildren().addAll(
                                notificationCard,
                                securityCard);

                columns.getChildren().addAll(
                                leftColumn,
                                rightColumn);

                // =====================================================
                // SAVE BUTTON
                // =====================================================

                HBox saveArea = new HBox();

                saveArea.setAlignment(
                                Pos.CENTER_RIGHT);

                Button cancel = new Button(
                                "Cancel");

                cancel.setPrefSize(
                                100,
                                42);

                cancel.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-cursor: hand;");

                Button save = new Button(
                                "Save Changes");

                save.setPrefSize(
                                145,
                                42);

                save.setStyle(
                                "-fx-background-color: " + BLUE + ";" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-cursor: hand;");

                save.setOnAction(e -> {

                        Alert alert = new Alert(
                                        Alert.AlertType.INFORMATION);

                        alert.setTitle(
                                        "Settings");

                        alert.setHeaderText(
                                        null);

                        alert.setContentText(
                                        "Settings saved successfully.");

                        alert.showAndWait();

                });

                HBox.setMargin(
                                save,
                                new Insets(0, 0, 0, 10));

                saveArea.getChildren().addAll(
                                cancel,
                                save);

                // =====================================================
                // SCROLL
                // =====================================================

                VBox content = new VBox(
                                20,
                                heading,
                                columns,
                                saveArea);

                ScrollPane scroll = new ScrollPane(
                                content);

                scroll.setFitToWidth(true);

                scroll.setHbarPolicy(
                                ScrollPane.ScrollBarPolicy.NEVER);

                scroll.setVbarPolicy(
                                ScrollPane.ScrollBarPolicy.AS_NEEDED);

                scroll.setStyle(
                                "-fx-background-color: transparent;" +
                                                "-fx-border-color: transparent;");

                VBox wrapper = new VBox(
                                scroll);

                VBox.setVgrow(
                                scroll,
                                Priority.ALWAYS);

                wrapper.setStyle(
                                "-fx-background-color: " + BG + ";");

                return wrapper;
        }

        // =========================================================
        // GENERAL SETTINGS
        // =========================================================

        private VBox createGeneralSettings() {

                VBox card = createCard();

                Label title = createCardTitle(
                                "General Settings");

                Label languageLabel = createFieldLabel(
                                "Language");

                ComboBox<String> language = new ComboBox<>();

                language.getItems().addAll(
                                "English",
                                "Hindi",
                                "Marathi");

                language.setValue(
                                "English");

                styleComboBox(language);

                Label timezoneLabel = createFieldLabel(
                                "Timezone");

                ComboBox<String> timezone = new ComboBox<>();

                timezone.getItems().addAll(
                                "Asia/Kolkata (IST)",
                                "UTC",
                                "America/New_York",
                                "Europe/London");

                timezone.setValue(
                                "Asia/Kolkata (IST)");

                styleComboBox(timezone);

                Label currencyLabel = createFieldLabel(
                                "Currency");

                ComboBox<String> currency = new ComboBox<>();

                currency.getItems().addAll(
                                "INR - Indian Rupee",
                                "USD - US Dollar",
                                "EUR - Euro");

                currency.setValue(
                                "INR - Indian Rupee");

                styleComboBox(currency);

                card.getChildren().addAll(
                                title,

                                languageLabel,
                                language,

                                timezoneLabel,
                                timezone,

                                currencyLabel,
                                currency);

                return card;
        }

        // =========================================================
        // ADMIN PROFILE
        // =========================================================

        private VBox createAdminProfile() {

                VBox card = createCard();

                Label title = createCardTitle(
                                "Admin Profile");

                HBox profileRow = new HBox(15);

                profileRow.setAlignment(
                                Pos.CENTER_LEFT);

                StackPane avatar = new StackPane();

                avatar.setPrefSize(
                                60,
                                60);

                avatar.setMaxSize(
                                60,
                                60);

                avatar.setStyle(
                                "-fx-background-color: #DCE5F2;" +
                                                "-fx-background-radius: 30;");

                Label avatarText = new Label("J");

                avatarText.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                22));

                avatarText.setTextFill(
                                Color.web(DARK_BLUE));

                avatar.getChildren().add(
                                avatarText);

                VBox userInfo = new VBox(3);

                Label name = new Label(
                                "John Doe");

                name.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                16));

                name.setTextFill(
                                Color.web(TEXT));

                Label role = new Label(
                                "Super Administrator");

                role.setFont(
                                Font.font(
                                                "Arial",
                                                13));

                role.setTextFill(
                                Color.web(GRAY));

                userInfo.getChildren().addAll(
                                name,
                                role);

                profileRow.getChildren().addAll(
                                avatar,
                                userInfo);

                Label emailLabel = createFieldLabel(
                                "Email Address");

                TextField email = createTextField(
                                "john.doe@fitverse.com");

                Label phoneLabel = createFieldLabel(
                                "Phone Number");

                TextField phone = createTextField(
                                "+91 98765 43210");

                card.getChildren().addAll(
                                title,
                                profileRow,
                                emailLabel,
                                email,
                                phoneLabel,
                                phone);

                return card;
        }

        // =========================================================
        // NOTIFICATION SETTINGS
        // =========================================================

        private VBox createNotificationSettings() {

                VBox card = createCard();

                Label title = createCardTitle(
                                "Notification Settings");

                Label subtitle = new Label(
                                "Choose which notifications you want to receive.");

                subtitle.setFont(
                                Font.font(
                                                "Arial",
                                                13));

                subtitle.setTextFill(
                                Color.web(GRAY));

                CheckBox newUsers = createCheckBox(
                                "New user registrations",
                                true);

                CheckBox gymApproval = createCheckBox(
                                "Gym approval requests",
                                true);

                CheckBox storeApproval = createCheckBox(
                                "Store verification requests",
                                true);

                CheckBox reports = createCheckBox(
                                "Weekly reports",
                                false);

                CheckBox systemAlerts = createCheckBox(
                                "System health alerts",
                                true);

                card.getChildren().addAll(
                                title,
                                subtitle,
                                newUsers,
                                gymApproval,
                                storeApproval,
                                reports,
                                systemAlerts);

                return card;
        }

        // =========================================================
        // SECURITY
        // =========================================================

        private VBox createSecuritySettings() {

                VBox card = createCard();

                Label title = createCardTitle(
                                "Security");

                Label passwordLabel = createFieldLabel(
                                "Current Password");

                PasswordField currentPassword = createPasswordField(
                                "Enter current password");

                Label newPasswordLabel = createFieldLabel(
                                "New Password");

                PasswordField newPassword = createPasswordField(
                                "Enter new password");

                Label confirmPasswordLabel = createFieldLabel(
                                "Confirm Password");

                PasswordField confirmPassword = createPasswordField(
                                "Confirm new password");

                CheckBox twoFactor = createCheckBox(
                                "Enable two-factor authentication",
                                true);

                Button changePassword = new Button(
                                "Change Password");

                changePassword.setPrefHeight(
                                38);

                changePassword.setStyle(
                                "-fx-background-color: " + LIGHT_BLUE + ";" +
                                                "-fx-text-fill: " + BLUE + ";" +
                                                "-fx-border-color: " + BLUE + ";" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-cursor: hand;");

                card.getChildren().addAll(
                                title,

                                passwordLabel,
                                currentPassword,

                                newPasswordLabel,
                                newPassword,

                                confirmPasswordLabel,
                                confirmPassword,

                                twoFactor,

                                changePassword);

                return card;
        }

        // =========================================================
        // CARD
        // =========================================================

        private VBox createCard() {

                VBox card = new VBox(10);

                card.setPadding(
                                new Insets(22));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: " + BORDER + ";" +
                                                "-fx-border-radius: 10;" +
                                                "-fx-background-radius: 10;");

                return card;
        }

        // =========================================================
        // CARD TITLE
        // =========================================================

        private Label createCardTitle(
                        String text) {

                Label title = new Label(text);

                title.setFont(
                                Font.font(
                                                "Arial",
                                                FontWeight.BOLD,
                                                19));

                title.setTextFill(
                                Color.web(TEXT));

                VBox.setMargin(
                                title,
                                new Insets(0, 0, 8, 0));

                return title;
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
                                                13));

                label.setTextFill(
                                Color.web(TEXT));

                VBox.setMargin(
                                label,
                                new Insets(6, 0, 0, 0));

                return label;
        }

        // =========================================================
        // TEXT FIELD
        // =========================================================

        private TextField createTextField(
                        String text) {

                TextField field = new TextField();

                field.setText(text);

                field.setPrefHeight(40);

                field.setMaxWidth(
                                Double.MAX_VALUE);

                field.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                field.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-prompt-text-fill: #8A94A3;" +
                                                "-fx-padding: 0 12;");

                return field;
        }

        // =========================================================
        // PASSWORD FIELD
        // =========================================================

        private PasswordField createPasswordField(
                        String prompt) {

                PasswordField field = new PasswordField();

                field.setPromptText(
                                prompt);

                field.setPrefHeight(40);

                field.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                field.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-text-fill: " + TEXT + ";" +
                                                "-fx-prompt-text-fill: #8A94A3;" +
                                                "-fx-padding: 0 12;");

                return field;
        }

        // =========================================================
        // COMBO BOX
        // =========================================================

        private void styleComboBox(
                        ComboBox<String> combo) {

                combo.setPrefHeight(40);

                combo.setMaxWidth(
                                Double.MAX_VALUE);

                combo.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-border-color: #C8D0DA;" +
                                                "-fx-border-radius: 7;" +
                                                "-fx-background-radius: 7;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-text-fill: " + TEXT + ";");
        }

        // =========================================================
        // CHECK BOX
        // =========================================================

        private CheckBox createCheckBox(
                        String text,
                        boolean selected) {

                CheckBox checkBox = new CheckBox(text);

                checkBox.setSelected(
                                selected);

                checkBox.setFont(
                                Font.font(
                                                "Arial",
                                                14));

                checkBox.setTextFill(
                                Color.web(TEXT));

                checkBox.setPrefHeight(35);

                return checkBox;
        }

}
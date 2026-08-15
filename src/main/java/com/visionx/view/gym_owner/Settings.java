package com.visionx.view.gym_owner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Settings {

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String SURFACE = "#020914";
    private final String SURFACE_HOVER = "#132A20";
    private final String BORDER = "#2a352b";

    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DARK = "#003918";

    private final String TEXT_MAIN = "#dbe5d9";
    private final String TEXT_MUTED = "#bacbb9";

    // =========================================================
    // EFFECTS
    // =========================================================

    private final DropShadow cardShadow =
            new DropShadow(
                    30,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.35)
            );

    private final DropShadow greenGlow =
            new DropShadow(
                    18,
                    Color.web(PRIMARY, 0.18)
            );

    // =========================================================
    // VARIABLES
    // =========================================================

    private Scene settingsScene;

    private BorderPane root;

    private VBox settingsNavigation;

    private HBox activeSettingItem;

    private Label activeSettingIcon;

    private Label activeSettingText;

    private Runnable backAction;

    private Label pageTitle;

    private Label pageSubtitle;

    private VBox detailsArea;

    // =========================================================
    // GET SETTINGS SCENE
    // =========================================================

    public Scene getSettingsScene(Runnable onBack) {

        this.backAction = onBack;

        root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI';"
        );

        /*
         * IMPORTANT:
         *
         * Header intentionally removed from Settings.
         *
         * Main dashboard already has the common header.
         * Therefore Settings contains only its own content.
         */

        HBox settingsArea = createSettingsArea();

        root.setCenter(settingsArea);

        settingsScene = new Scene(
                root,
                1440,
                900
        );

        return settingsScene;
    }

    // =========================================================
    // MAIN SETTINGS AREA
    // =========================================================

    private HBox createSettingsArea() {

        HBox area = new HBox(60);

        area.setPadding(
                new Insets(
                        36,
                        68,
                        36,
                        36
                )
        );

        area.setStyle(
                "-fx-background-color: " + BG_COLOR + ";"
        );

        // -----------------------------------------------------
        // LEFT PANEL
        // -----------------------------------------------------

        VBox leftPanel = createSettingsNavigationPanel();

        leftPanel.setPrefWidth(330);
        leftPanel.setMinWidth(330);
        leftPanel.setMaxWidth(330);

        // -----------------------------------------------------
        // RIGHT PANEL
        // -----------------------------------------------------

        VBox rightPanel = createDetailsPanel();

        HBox.setHgrow(
                rightPanel,
                Priority.ALWAYS
        );

        area.getChildren().addAll(
                leftPanel,
                rightPanel
        );

        return area;
    }

    // =========================================================
    // LEFT SETTINGS NAVIGATION PANEL
    // =========================================================

    private VBox createSettingsNavigationPanel() {

        VBox panel = new VBox();

        panel.setPadding(
                new Insets(
                        26,
                        22,
                        22,
                        22
                )
        );

        panel.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-background-radius: 26;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 26;" +
                "-fx-border-width: 1;"
        );

        panel.setEffect(cardShadow);

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label("SETTINGS");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // NAVIGATION
        // =====================================================

        settingsNavigation = new VBox(6);

        settingsNavigation.setPadding(
                new Insets(
                        22,
                        0,
                        0,
                        0
                )
        );

        HBox general = createSettingItem(
                "⚙",
                "General Settings",
                true
        );

        HBox notifications = createSettingItem(
                "🔔",
                "Notification Settings",
                false
        );

        HBox security = createSettingItem(
                "🔒",
                "Security Settings",
                false
        );

        HBox ai = createSettingItem(
                "🧠",
                "AI Configuration",
                false
        );

        HBox appearance = createSettingItem(
                "🎨",
                "Appearance",
                false
        );

        settingsNavigation.getChildren().addAll(
                general,
                notifications,
                security,
                ai,
                appearance
        );

        // =====================================================
        // SPACER
        // =====================================================

        Region spacer = new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS
        );

        // =====================================================
        // DIVIDER
        // =====================================================

        Region divider = new Region();

        divider.setMinHeight(1);

        divider.setStyle(
                "-fx-background-color: " + BORDER + ";"
        );

        // =====================================================
        // BACK BUTTON
        // =====================================================

        Button backButton = new Button(
                "←  BACK TO DASHBOARD"
        );

        backButton.setMaxWidth(
                Double.MAX_VALUE
        );

        backButton.setPrefHeight(46);

        String backNormal =
                "-fx-background-color: transparent;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;" +
                "-fx-cursor: hand;";

        String backHover =
                "-fx-background-color: " + SURFACE_HOVER + ";" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 12px;" +
                "-fx-cursor: hand;";

        backButton.setStyle(backNormal);

        backButton.setOnMouseEntered(
                e -> backButton.setStyle(backHover)
        );

        backButton.setOnMouseExited(
                e -> backButton.setStyle(backNormal)
        );

        backButton.setOnAction(
                e -> {

                    if (backAction != null) {
                        backAction.run();
                    }
                }
        );

        VBox.setMargin(
                backButton,
                new Insets(
                        18,
                        0,
                        0,
                        0
                )
        );

        panel.getChildren().addAll(
                title,
                settingsNavigation,
                spacer,
                divider,
                backButton
        );

        return panel;
    }

    // =========================================================
    // SETTINGS NAV ITEM
    // =========================================================

    private HBox createSettingItem(
            String icon,
            String text,
            boolean active
    ) {

        HBox item = new HBox(12);

        item.setAlignment(
                Pos.CENTER_LEFT
        );

        item.setPadding(
                new Insets(
                        12,
                        14,
                        12,
                        14
                )
        );

        item.setMinHeight(44);
        item.setPrefHeight(44);

        Label iconLabel = new Label(icon);

        iconLabel.setMinWidth(24);

        Label textLabel = new Label(text);

        item.getChildren().addAll(
                iconLabel,
                textLabel
        );

        if (active) {

            setActiveSettingStyle(
                    item,
                    iconLabel,
                    textLabel
            );

            activeSettingItem = item;
            activeSettingIcon = iconLabel;
            activeSettingText = textLabel;

        } else {

            setNormalSettingStyle(
                    item,
                    iconLabel,
                    textLabel
            );
        }

        // =====================================================
        // CLICK
        // =====================================================

        item.setOnMouseClicked(
                e -> {

                    setActiveSetting(
                            item,
                            iconLabel,
                            textLabel
                    );

                    switch (text) {

                        case "General Settings":
                            showGeneralSettings();
                            break;

                        case "Notification Settings":
                            showNotificationSettings();
                            break;

                        case "Security Settings":
                            showSecuritySettings();
                            break;

                        case "AI Configuration":
                            showAIConfiguration();
                            break;

                        case "Appearance":
                            showAppearanceSettings();
                            break;

                        default:
                            break;
                    }
                }
        );

        // =====================================================
        // HOVER
        // =====================================================

        item.setOnMouseEntered(
                e -> {

                    if (item != activeSettingItem) {

                        item.setStyle(
                                "-fx-background-color: " +
                                SURFACE_HOVER + ";" +
                                "-fx-background-radius: 12;" +
                                "-fx-cursor: hand;"
                        );

                        iconLabel.setStyle(
                                "-fx-text-fill: " +
                                PRIMARY + ";" +
                                "-fx-font-size: 17px;"
                        );

                        textLabel.setStyle(
                                "-fx-text-fill: " +
                                TEXT_MAIN + ";" +
                                "-fx-font-size: 13px;"
                        );
                    }
                }
        );

        item.setOnMouseExited(
                e -> {

                    if (item != activeSettingItem) {

                        setNormalSettingStyle(
                                item,
                                iconLabel,
                                textLabel
                        );
                    }
                }
        );

        return item;
    }

    // =========================================================
    // NORMAL STYLE
    // =========================================================

    private void setNormalSettingStyle(
            HBox item,
            Label icon,
            Label text
    ) {

        item.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;"
        );

        icon.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 17px;"
        );

        text.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 13px;"
        );
    }

    // =========================================================
    // ACTIVE STYLE
    // =========================================================

    private void setActiveSettingStyle(
            HBox item,
            Label icon,
            Label text
    ) {

        item.setStyle(
                "-fx-background-color: #163B2A;" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-width: 1.2;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;"
        );

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 17px;"
        );

        text.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );
    }

    // =========================================================
    // CHANGE ACTIVE SETTING
    // =========================================================

    private void setActiveSetting(
            HBox newItem,
            Label newIcon,
            Label newText
    ) {

        if (activeSettingItem != null) {

            setNormalSettingStyle(
                    activeSettingItem,
                    activeSettingIcon,
                    activeSettingText
            );
        }

        setActiveSettingStyle(
                newItem,
                newIcon,
                newText
        );

        activeSettingItem = newItem;
        activeSettingIcon = newIcon;
        activeSettingText = newText;
    }

    // =========================================================
    // RIGHT DETAILS PANEL
    // =========================================================

    private VBox createDetailsPanel() {

        VBox container = new VBox(24);

        container.setPadding(
                new Insets(
                        0,
                        0,
                        30,
                        0
                )
        );

        // =====================================================
        // PAGE HEADING
        // =====================================================

        VBox heading = new VBox(5);

        pageTitle = new Label(
                "General Settings"
        );

        pageTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        pageSubtitle = new Label(
                "Manage your gym, regional preferences and basic system configuration."
        );

        pageSubtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 14px;"
        );

        heading.getChildren().addAll(
                pageTitle,
                pageSubtitle
        );

        // =====================================================
        // DETAILS AREA
        // =====================================================

        detailsArea = new VBox(22);

        detailsArea.setPadding(
                new Insets(
                        24,
                        0,
                        0,
                        0
                )
        );

        ScrollPane scroll = new ScrollPane(
                detailsArea
        );

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        VBox.setVgrow(
                scroll,
                Priority.ALWAYS
        );

        container.getChildren().addAll(
                heading,
                scroll
        );

        // Initial content
        showGeneralSettings();

        return container;
    }

    // =========================================================
    // GENERAL SETTINGS
    // =========================================================

    private void showGeneralSettings() {

        pageTitle.setText(
                "General Settings"
        );

        pageSubtitle.setText(
                "Manage your gym, regional preferences and basic system configuration."
        );

        detailsArea.getChildren().clear();

        VBox generalCard = createCard();

        VBox cardContent = new VBox(22);

        // =====================================================
        // CARD TITLE
        // =====================================================

        HBox cardTitle = new HBox(12);

        cardTitle.setAlignment(
                Pos.CENTER_LEFT
        );

        Label icon = new Label("⚙");

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;"
        );

        Label title = new Label(
                "General Configuration"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        cardTitle.getChildren().addAll(
                icon,
                title
        );

        // =====================================================
        // GRID
        // =====================================================

        GridPane grid = new GridPane();

        grid.setHgap(22);
        grid.setVgap(20);

        ColumnConstraints left =
                new ColumnConstraints();

        left.setPercentWidth(50);

        ColumnConstraints right =
                new ColumnConstraints();

        right.setPercentWidth(50);

        grid.getColumnConstraints().addAll(
                left,
                right
        );

        VBox gymName = createTextField(
                "Gym Name",
                "FitneesFreak Elite"
        );

        VBox timezone = createComboField(
                "Timezone",
                "(GMT+05:30) Asia/Kolkata",
                "(GMT+05:30) Asia/Kolkata",
                "(GMT+00:00) UTC",
                "(GMT-05:00) America/New_York"
        );

        VBox currency = createComboField(
                "Currency",
                "USD - US Dollar ($)",
                "USD - US Dollar ($)",
                "INR - Indian Rupee (₹)",
                "EUR - Euro (€)"
        );

        VBox dateFormat = createComboField(
                "Date Format",
                "DD MMM YYYY",
                "DD MMM YYYY",
                "DD/MM/YYYY",
                "MM/DD/YYYY"
        );

        grid.add(gymName, 0, 0);
        grid.add(timezone, 1, 0);
        grid.add(currency, 0, 1);
        grid.add(dateFormat, 1, 1);

        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button save = new Button(
                "✓  SAVE CHANGES"
        );

        save.setPrefHeight(44);

        save.setPadding(
                new Insets(
                        0,
                        22,
                        0,
                        22
                )
        );

        String saveNormal =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: " + PRIMARY_DARK + ";" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;";

        String saveHover =
                "-fx-background-color: #8bffb0;" +
                "-fx-text-fill: " + PRIMARY_DARK + ";" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;";

        save.setStyle(saveNormal);

        save.setEffect(greenGlow);

        save.setOnMouseEntered(
                e -> save.setStyle(saveHover)
        );

        save.setOnMouseExited(
                e -> save.setStyle(saveNormal)
        );

        save.setOnAction(
                e -> showInfo(
                        "Settings Saved",
                        "Your general settings have been saved successfully."
                )
        );

        cardContent.getChildren().addAll(
                cardTitle,
                grid,
                save
        );

        generalCard.getChildren().add(
                cardContent
        );

        // =====================================================
        // APPEARANCE PREVIEW CARD
        // =====================================================

        VBox appearanceCard =
                createAppearancePreviewCard();

        detailsArea.getChildren().addAll(
                generalCard,
                appearanceCard
        );
    }

    // =========================================================
    // TEXT FIELD
    // =========================================================

    private VBox createTextField(
            String labelText,
            String value
    ) {

        VBox box = new VBox(8);

        Label label = new Label(labelText);

        label.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        TextField field = new TextField(value);

        field.setPrefHeight(48);

        field.setStyle(
                "-fx-background-color: #111a12;" +
                "-fx-background-radius: 11;" +
                "-fx-border-color: #2c3a2e;" +
                "-fx-border-radius: 11;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 0 14 0 14;"
        );

        box.getChildren().addAll(
                label,
                field
        );

        return box;
    }

    // =========================================================
    // COMBO FIELD
    // =========================================================

    private VBox createComboField(
            String labelText,
            String selected,
            String... values
    ) {

        VBox box = new VBox(8);

        Label label = new Label(labelText);

        label.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        ComboBox<String> combo =
                new ComboBox<>();

        combo.getItems().addAll(values);

        combo.setValue(selected);

        combo.setPrefHeight(48);

        combo.setMaxWidth(
                Double.MAX_VALUE
        );

        combo.setStyle(
                "-fx-background-color: #111a12;" +
                "-fx-background-radius: 11;" +
                "-fx-border-color: #2c3a2e;" +
                "-fx-border-radius: 11;" +
                "-fx-font-size: 13px;"
        );

        combo.setCellFactory(
                list -> new ListCell<String>() {

                    @Override
                    protected void updateItem(
                            String item,
                            boolean empty
                    ) {

                        super.updateItem(
                                item,
                                empty
                        );

                        if (empty || item == null) {

                            setText(null);

                        } else {

                            setText(item);

                            setStyle(
                                    "-fx-background-color: #111a12;" +
                                    "-fx-text-fill: " +
                                    TEXT_MAIN + ";" +
                                    "-fx-font-size: 13px;"
                            );
                        }
                    }
                }
        );

        box.getChildren().addAll(
                label,
                combo
        );

        return box;
    }

    // =========================================================
    // APPEARANCE PREVIEW
    // =========================================================

    private VBox createAppearancePreviewCard() {

        VBox card = createCard();

        VBox content = new VBox(18);

        HBox titleRow = new HBox(12);

        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label icon = new Label("🎨");

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;"
        );

        Label title = new Label(
                "Appearance"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        titleRow.getChildren().addAll(
                icon,
                title
        );

        HBox themeRow = new HBox(20);

        themeRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label theme = new Label("Theme");

        theme.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        ToggleGroup group = new ToggleGroup();

        RadioButton dark =
                new RadioButton("Dark");

        dark.setToggleGroup(group);
        dark.setSelected(true);

        RadioButton light =
                new RadioButton("Light");

        light.setToggleGroup(group);

        String radioStyle =
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 13px;";

        dark.setStyle(radioStyle);
        light.setStyle(radioStyle);

        themeRow.getChildren().addAll(
                theme,
                dark,
                light
        );

        content.getChildren().addAll(
                titleRow,
                themeRow
        );

        card.getChildren().add(
                content
        );

        return card;
    }

    // =========================================================
    // NOTIFICATION SETTINGS
    // =========================================================

    private void showNotificationSettings() {

        pageTitle.setText(
                "Notification Settings"
        );

        pageSubtitle.setText(
                "Control how FitneesFreak sends important notifications."
        );

        detailsArea.getChildren().clear();

        VBox card = createCard();

        VBox content = new VBox(22);

        content.getChildren().add(
                createSectionTitle(
                        "🔔",
                        "Notification Preferences",
                        "Manage system and gym notifications."
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "Email Notifications",
                        "Receive important system emails.",
                        true
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "Membership Alerts",
                        "Get notified when a new membership request arrives.",
                        true
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "Trainer Alerts",
                        "Receive trainer-related notifications.",
                        false
                )
        );

        card.getChildren().add(content);

        detailsArea.getChildren().add(card);
    }

    // =========================================================
    // SECURITY SETTINGS
    // =========================================================

    private void showSecuritySettings() {

        pageTitle.setText(
                "Security Settings"
        );

        pageSubtitle.setText(
                "Manage authentication, sessions and administrator security."
        );

        detailsArea.getChildren().clear();

        VBox card = createCard();

        VBox content = new VBox(22);

        content.getChildren().add(
                createSectionTitle(
                        "🔒",
                        "Security Configuration",
                        "Protect your FitneesFreak administrator account."
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "Two-Factor Authentication",
                        "Require an additional verification step during login.",
                        false
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "Login Alerts",
                        "Notify administrators about new login attempts.",
                        true
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "Automatic Session Expiration",
                        "Automatically expire inactive administrator sessions.",
                        true
                )
        );

        card.getChildren().add(content);

        detailsArea.getChildren().add(card);
    }

    // =========================================================
    // AI CONFIGURATION
    // =========================================================

    private void showAIConfiguration() {

        pageTitle.setText(
                "AI Configuration"
        );

        pageSubtitle.setText(
                "Configure AI-powered insights and recommendations."
        );

        detailsArea.getChildren().clear();

        VBox card = createCard();

        VBox content = new VBox(22);

        content.getChildren().add(
                createSectionTitle(
                        "🧠",
                        "AI System Configuration",
                        "Manage FitneesFreak AI features."
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "AI Performance Insights",
                        "Allow AI to analyze gym performance and trends.",
                        true
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "AI Recommendations",
                        "Generate automatic gym management recommendations.",
                        true
                )
        );

        content.getChildren().add(
                createToggleRow(
                        "AI Predictive Analytics",
                        "Enable predictive member and revenue analysis.",
                        true
                )
        );

        card.getChildren().add(content);

        detailsArea.getChildren().add(card);
    }

    // =========================================================
    // APPEARANCE SETTINGS
    // =========================================================

    private void showAppearanceSettings() {

        pageTitle.setText(
                "Appearance"
        );

        pageSubtitle.setText(
                "Customize the visual appearance of your FitneesFreak dashboard."
        );

        detailsArea.getChildren().clear();

        VBox card = createCard();

        VBox content = new VBox(24);

        content.getChildren().add(
                createSectionTitle(
                        "🎨",
                        "Theme",
                        "Choose how the dashboard should appear."
                )
        );

        ToggleGroup group =
                new ToggleGroup();

        RadioButton dark =
                new RadioButton("Dark");

        dark.setToggleGroup(group);
        dark.setSelected(true);

        RadioButton light =
                new RadioButton("Light");

        light.setToggleGroup(group);

        dark.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
        );

        light.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
        );

        HBox themes =
                new HBox(
                        24,
                        dark,
                        light
                );

        themes.setAlignment(
                Pos.CENTER_LEFT
        );

        content.getChildren().add(themes);

        card.getChildren().add(content);

        detailsArea.getChildren().add(card);
    }

    // =========================================================
    // SECTION TITLE
    // =========================================================

    private VBox createSectionTitle(
            String icon,
            String titleText,
            String description
    ) {

        VBox box = new VBox(4);

        HBox titleRow =
                new HBox(10);

        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;"
        );

        Label title =
                new Label(titleText);

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        titleRow.getChildren().addAll(
                iconLabel,
                title
        );

        Label desc =
                new Label(description);

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        box.getChildren().addAll(
                titleRow,
                desc
        );

        return box;
    }

    // =========================================================
    // TOGGLE ROW
    // =========================================================

    private HBox createToggleRow(
            String titleText,
            String description,
            boolean selected
    ) {

        HBox row = new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(16)
        );

        row.setStyle(
                "-fx-background-color: rgba(255,255,255,0.025);" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-border-radius: 12;"
        );

        VBox text = new VBox(3);

        Label title =
                new Label(titleText);

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label desc =
                new Label(description);

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );

        text.getChildren().addAll(
                title,
                desc
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        CheckBox check =
                new CheckBox();

        check.setSelected(selected);

        row.getChildren().addAll(
                text,
                spacer,
                check
        );

        return row;
    }

    // =========================================================
    // CARD
    // =========================================================

    private VBox createCard() {

        VBox card = new VBox();

        card.setPadding(
                new Insets(26)
        );

        card.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-background-radius: 26;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 26;" +
                "-fx-border-width: 1;"
        );

        card.setEffect(cardShadow);

        return card;
    }

    // =========================================================
    // ALERT
    // =========================================================

    private void showInfo(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }

    // =========================================================
    // NO ARGUMENT VERSION
    // =========================================================

    public Scene getSettingsScene() {

        return getSettingsScene(null);
    }
}
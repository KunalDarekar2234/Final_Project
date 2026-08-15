package com.visionx.view.trainer_login;

import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

public class Settings {

    // =========================================================
    // COLORS
    // =========================================================

    private static final String BG_COLOR = "#0d150e";
    private static final String CARD_BG = "#07110d";
    private static final String SURFACE = "#020914";
    private static final String SURFACE_BORDER = "#24332a";

    private static final String PRIMARY = "#75ff9e";
    private static final String PRIMARY_DARK = "#163b2a";

    private static final String TEXT_MAIN = "#f1f6f1";
    private static final String TEXT_MUTED = "#9caf9f";
    private static final String ERROR = "#ffb4ab";

    private static final String BORDER =
            "rgba(255,255,255,0.09)";

    // =========================================================
    // LANGUAGE
    // =========================================================

    private String currentLanguage = "English";

    private ComboBox<String> languageCombo;

    // =========================================================
    // MAIN UI REFERENCES
    // =========================================================

    private VBox mainContent;

    private Label pageTitle;
    private Label pageSubtitle;

    // Account
    private Label accountTitle;
    private Label accountSubtitle;

    // Language
    private Label languageTitle;
    private Label languageSubtitle;

    // Notifications
    private Label notificationTitle;
    private Label notificationSubtitle;

    // Security
    private Label securityTitle;
    private Label securitySubtitle;

    // Privacy
    private Label privacyTitle;
    private Label privacySubtitle;

    // Sessions
    private Label sessionTitle;
    private Label sessionSubtitle;

    // =========================================================
    // GET SETTINGS SCENE
    // =========================================================

    public Scene getSettingsScene(
            Runnable backToDashboard
    ) {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        // =====================================================
        // SETTINGS NAVIGATION
        // =====================================================

        VBox settingsPanel =
                new VBox(8);

        settingsPanel.setPrefWidth(300);
        settingsPanel.setMinWidth(300);
        settingsPanel.setMaxWidth(300);

        settingsPanel.setPadding(
                new Insets(26, 20, 20, 20)
        );

        settingsPanel.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #0b1912, #06100b);" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: rgba(117,255,158,0.16);" +
                "-fx-border-radius: 20;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.30), 18, 0.18, 0, 6);"
        );

        Label settingsLabel =
                new Label("SETTINGS");

        settingsLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1.2px;" +
                "-fx-padding: 0 0 12 4;"
        );

        VBox nav =
                new VBox(5);

        Button generalButton =
                createSettingsNavButton(
                        "⚙",
                        "General Settings",
                        true
                );

        Button notificationButton =
                createSettingsNavButton(
                        "🔔",
                        "Notification Settings",
                        false
                );

        Button securityButton =
                createSettingsNavButton(
                        "🔒",
                        "Security Settings",
                        false
                );

        Button aiButton =
                createSettingsNavButton(
                        "▣",
                        "AI Configuration",
                        false
                );

        Button languageButton =
                createSettingsNavButton(
                        "文",
                        "Language Settings",
                        false
                );

        nav.getChildren().addAll(
                generalButton,
                notificationButton,
                securityButton,
                aiButton,
                languageButton
        );

        Region navSpacer =
                new Region();

        VBox.setVgrow(
                navSpacer,
                Priority.ALWAYS
        );

        Region separator =
                new Region();

        separator.setMinHeight(1);
        separator.setPrefHeight(1);
        separator.setMaxHeight(1);

        separator.setStyle(
                "-fx-background-color: " +
                SURFACE_BORDER
        );

        Button backButton =
                new Button("←  BACK TO DASHBOARD");

        backButton.setMaxWidth(
                Double.MAX_VALUE
        );

        String backNormal =
                "-fx-background-color: rgba(117,255,158,0.03);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 15;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        String backHover =
                "-fx-background-color: " + PRIMARY_DARK + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 15;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        addHoverEffect(
                backButton,
                backNormal,
                backHover
        );

        backButton.setOnAction(
                e -> {
                    if (backToDashboard != null) {
                        backToDashboard.run();
                    }
                }
        );

        settingsPanel.getChildren().addAll(
                settingsLabel,
                nav,
                navSpacer,
                separator,
                backButton
        );

        // =====================================================
        // RIGHT CONTENT
        // =====================================================

        BorderPane content =
                new BorderPane();

        content.setPadding(
                new Insets(6, 38, 24, 38)
        );

        VBox pageHeader =
                new VBox(5);

        pageTitle =
                new Label("General Settings");

        pageTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.18), 10, 0.10, 0, 1);"
        );

        pageSubtitle =
                new Label(
                        "Manage your gym, regional preferences and basic system configuration."
                );

        pageSubtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 2 0 0 0;"
        );

        pageHeader.getChildren().addAll(
                pageTitle,
                pageSubtitle
        );

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane pageScroll =
                new ScrollPane();

        pageScroll.setFitToWidth(true);
        pageScroll.setFitToHeight(false);

        pageScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        pageScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        pageScroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-control-inner-background: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-padding: 0;"
        );

        mainContent =
                new VBox(20);

        mainContent.setFillWidth(true);

        mainContent.setPadding(
                new Insets(24, 0, 20, 0)
        );

        VBox generalPage =
                new VBox(18);

        generalPage.setFillWidth(true);

        generalPage.getChildren().addAll(
                createGeneralConfigurationCard(),
                createAccountCard()
        );

        mainContent.getChildren().addAll(
                generalPage.getChildren()
        );

        pageScroll.setContent(
                mainContent
        );

        content.setTop(pageHeader);
        content.setCenter(pageScroll);

        // =====================================================
        // NAV ACTIONS
        // =====================================================

        generalButton.setOnAction(
                e -> showSettingsPage(
                        "General Settings",
                        "Manage your gym, regional preferences and basic system configuration.",
                        createGeneralPage(),
                        generalButton,
                        notificationButton,
                        securityButton,
                        aiButton,
                        languageButton
                )
        );

        notificationButton.setOnAction(
                e -> showSettingsPage(
                        "Notification Settings",
                        "Control how FitneesFreak sends important notifications.",
                        createNotificationCard(),
                        notificationButton,
                        generalButton,
                        securityButton,
                        aiButton,
                        languageButton
                )
        );

        securityButton.setOnAction(
                e -> showSettingsPage(
                        "Security Settings",
                        "Manage authentication, sessions and administrator security.",
                        createSecurityPage(),
                        securityButton,
                        generalButton,
                        notificationButton,
                        aiButton,
                        languageButton
                )
        );

        aiButton.setOnAction(
                e -> showSettingsPage(
                        "AI Configuration",
                        "Configure AI-powered insights and recommendations.",
                        createAIConfigurationCard(),
                        aiButton,
                        generalButton,
                        notificationButton,
                        securityButton,
                        languageButton
                )
        );

        languageButton.setOnAction(
                e -> showSettingsPage(
                        "Language Settings",
                        "Choose the language used across the FitneesFreak application.",
                        createLanguageCard(),
                        languageButton,
                        generalButton,
                        notificationButton,
                        securityButton,
                        aiButton
                )
        );

        // =====================================================
        // BODY
        // =====================================================

        HBox body =
                new HBox(28);

        body.setPadding(
                new Insets(30, 36, 26, 36)
        );

        body.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0d150e, #0a130d);"
        );

        body.setFillHeight(true);

        HBox.setHgrow(
                content,
                Priority.ALWAYS
        );

        body.getChildren().addAll(
                settingsPanel,
                content
        );

        root.setCenter(body);

        Scene scene =
                new Scene(
                        root,
                        1200,
                        800
                );

        // Fix ScrollPane viewport background after skin creation
        pageScroll.skinProperty().addListener(
                (obs, oldSkin, newSkin) -> {
                    if (newSkin != null) {

                        javafx.application.Platform.runLater(
                                () -> {

                                    javafx.scene.Node viewport =
                                            pageScroll.lookup(".viewport");

                                    if (viewport != null) {

                                        viewport.setStyle(
                                                "-fx-background-color: transparent;"
                                        );
                                    }

                                    javafx.scene.Node corner =
                                            pageScroll.lookup(".corner");

                                    if (corner != null) {

                                        corner.setStyle(
                                                "-fx-background-color: transparent;"
                                        );
                                    }
                                }
                        );
                    }
                }
        );

        return scene;
    }

    // =========================================================
    // SETTINGS NAV BUTTON
    // =========================================================

    private Button createSettingsNavButton(
            String icon,
            String title,
            boolean active
    ) {

        Button button =
                new Button(
                        icon + "     " + title
                );

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        String normal =
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 14;" +
                "-fx-font-size: 13px;" +
                "-fx-cursor: hand;";

        String hover =
                "-fx-background-color: rgba(117,255,158,0.10);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 14;" +
                "-fx-font-size: 13px;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: " + PRIMARY_DARK + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-border-color: rgba(117,255,158,0.55);" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 14;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        button.getProperties().put(
                "settingsActive",
                active
        );

        button.setStyle(
                active ? activeStyle : normal
        );

        button.setOnMouseEntered(
                e -> {

                    boolean isActive =
                            Boolean.TRUE.equals(
                                    button.getProperties()
                                            .get("settingsActive")
                            );

                    if (!isActive) {
                        button.setStyle(hover);
                    }
                }
        );

        button.setOnMouseExited(
                e -> {

                    boolean isActive =
                            Boolean.TRUE.equals(
                                    button.getProperties()
                                            .get("settingsActive")
                            );

                    if (!isActive) {
                        button.setStyle(normal);
                    } else {
                        button.setStyle(activeStyle);
                    }
                }
        );

        return button;
    }

    // =========================================================
    // SETTINGS PAGE SWITCH
    // =========================================================

    private void showSettingsPage(
            String title,
            String subtitle,
            VBox page,
            Button activeButton,
            Button... otherButtons
    ) {

        pageTitle.setText(title);
        pageSubtitle.setText(subtitle);

        page.setFillWidth(true);

        mainContent.getChildren().setAll(page);

        setSettingsNavActive(
                activeButton,
                otherButtons
        );
    }

    private void setSettingsNavActive(
            Button activeButton,
            Button... otherButtons
    ) {

        String normal =
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 14;" +
                "-fx-font-size: 13px;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: " + PRIMARY_DARK + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-border-color: rgba(117,255,158,0.55);" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 14;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        activeButton.getProperties().put(
                "settingsActive",
                true
        );

        activeButton.setStyle(
                activeStyle
        );

        for (Button button : otherButtons) {

            button.getProperties().put(
                    "settingsActive",
                    false
            );

            button.setStyle(
                    normal
            );
        }
    }

    // =========================================================
    // GENERAL PAGE
    // =========================================================

    private VBox createGeneralPage() {

        VBox page =
                new VBox(18);

        page.setFillWidth(true);

        page.getChildren().addAll(
                createGeneralConfigurationCard(),
                createAccountCard()
        );

        return page;
    }

    // =========================================================
    // SECURITY PAGE
    // =========================================================

    private VBox createSecurityPage() {

        VBox page =
                new VBox(18);

        page.setFillWidth(true);

        page.getChildren().addAll(
                createSecurityCard(),
                createSessionCard(),
                createPrivacyCard(),
                createLogoutCard()
        );

        return page;
    }

    // =========================================================
    // GENERAL CONFIGURATION
    // =========================================================

    private VBox createGeneralConfigurationCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "General Configuration",
                        "Manage FitneesFreak regional and basic system preferences."
                );

        TextField gymName =
                new TextField("FitneesFreak Elite");

        styleTextField(gymName);

        ComboBox<String> timezone =
                new ComboBox<>();

        timezone.getItems().addAll(
                "(GMT+05:30) Asia/Kolkata",
                "(GMT+00:00) Europe/London",
                "(GMT-05:00) America/New_York"
        );

        timezone.setValue(
                "(GMT+05:30) Asia/Kolkata"
        );

        timezone.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(timezone);

        ComboBox<String> currency =
                new ComboBox<>();

        currency.getItems().addAll(
                "INR - Indian Rupee (₹)",
                "USD - US Dollar ($)",
                "EUR - Euro (€)"
        );

        currency.setValue(
                "INR - Indian Rupee (₹)"
        );

        currency.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(currency);

        ComboBox<String> dateFormat =
                new ComboBox<>();

        dateFormat.getItems().addAll(
                "DD MMM YYYY",
                "DD/MM/YYYY",
                "MM/DD/YYYY"
        );

        dateFormat.setValue(
                "DD MMM YYYY"
        );

        dateFormat.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(dateFormat);

        GridPane grid =
                new GridPane();

        grid.setHgap(20);
        grid.setVgap(16);

        ColumnConstraints left =
                new ColumnConstraints();

        left.setPercentWidth(50);
        left.setHgrow(
                Priority.ALWAYS
        );

        ColumnConstraints right =
                new ColumnConstraints();

        right.setPercentWidth(50);
        right.setHgrow(
                Priority.ALWAYS
        );

        grid.getColumnConstraints().addAll(
                left,
                right
        );

        grid.add(
                createFieldBox(
                        "Gym Name",
                        gymName
                ),
                0,
                0
        );

        grid.add(
                createFieldBox(
                        "Timezone",
                        timezone
                ),
                1,
                0
        );

        grid.add(
                createFieldBox(
                        "Currency",
                        currency
                ),
                0,
                1
        );

        grid.add(
                createFieldBox(
                        "Date Format",
                        dateFormat
                ),
                1,
                1
        );

        Button save =
                createPrimaryButton(
                        "✓  SAVE CHANGES"
                );

        save.setOnAction(
                e -> showInformation(
                        "Settings Saved",
                        "Your general FitneesFreak settings have been updated successfully."
                )
        );

        card.getChildren().addAll(
                heading,
                grid,
                save
        );

        return card;
    }

    private VBox createFieldBox(
            String labelText,
            Control control
    ) {

        VBox box =
                new VBox(6);

        Label label =
                createSettingLabel(
                        labelText
                );

        box.getChildren().addAll(
                label,
                control
        );

        VBox.setVgrow(
                control,
                Priority.NEVER
        );

        return box;
    }

    // =========================================================
    // AI CONFIGURATION
    // =========================================================

    private VBox createAIConfigurationCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "AI System Configuration",
                        "Manage FitneesFreak AI-powered features."
                );

        CheckBox performance =
                createCheckBox(
                        "AI Performance Insights",
                        "Allow AI to analyze gym performance and trends."
                );

        performance.setSelected(true);

        CheckBox recommendations =
                createCheckBox(
                        "AI Recommendations",
                        "Generate automatic gym management recommendations."
                );

        recommendations.setSelected(true);

        CheckBox predictive =
                createCheckBox(
                        "AI Predictive Analytics",
                        "Enable predictive member and revenue analysis."
                );

        predictive.setSelected(true);

        card.getChildren().addAll(
                heading,
                performance,
                recommendations,
                predictive
        );

        return card;
    }

    // =========================================================
    // ACCOUNT CARD
    // =========================================================

    private VBox createAccountCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Account",
                        "Manage your trainer account information."
                );

        Label name =
                createSettingLabel(
                        "Trainer Name"
                );

        TextField nameField =
                new TextField(
                        "Alex Trainer"
                );

        styleTextField(
                nameField
        );

        Label email =
                createSettingLabel(
                        "Email Address"
                );

        TextField emailField =
                new TextField(
                        "alex.trainer@example.com"
                );

        styleTextField(
                emailField
        );

        Label phone =
                createSettingLabel(
                        "Phone Number"
                );

        TextField phoneField =
                new TextField(
                        "+91 98765 43210"
                );

        styleTextField(
                phoneField
        );

        GridPane fields =
                new GridPane();

        fields.setHgap(16);
        fields.setVgap(10);

        ColumnConstraints first =
                new ColumnConstraints();

        first.setPercentWidth(33.33);
        first.setHgrow(
                Priority.ALWAYS
        );

        ColumnConstraints second =
                new ColumnConstraints();

        second.setPercentWidth(33.33);
        second.setHgrow(
                Priority.ALWAYS
        );

        ColumnConstraints third =
                new ColumnConstraints();

        third.setPercentWidth(33.34);
        third.setHgrow(
                Priority.ALWAYS
        );

        fields.getColumnConstraints().addAll(
                first,
                second,
                third
        );

        VBox nameBox =
                new VBox(6);

        nameBox.getChildren().addAll(
                name,
                nameField
        );

        VBox emailBox =
                new VBox(6);

        emailBox.getChildren().addAll(
                email,
                emailField
        );

        VBox phoneBox =
                new VBox(6);

        phoneBox.getChildren().addAll(
                phone,
                phoneField
        );

        fields.add(
                nameBox,
                0,
                0
        );

        fields.add(
                emailBox,
                1,
                0
        );

        fields.add(
                phoneBox,
                2,
                0
        );

        Button save =
                createPrimaryButton(
                        "Save Account Changes"
                );

        save.setOnAction(
                e -> showInformation(
                        "Account Updated",
                        "Your trainer account information has been saved."
                )
        );

        card.getChildren().addAll(
                heading,
                fields,
                save
        );

        return card;
    }

    // =========================================================
    // LANGUAGE CARD
    // =========================================================

    private VBox createLanguageCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Language",
                        "Choose the language used by the trainer application."
                );

        languageTitle =
                headingTitleFrom(
                        heading
                );

        languageSubtitle =
                headingSubtitleFrom(
                        heading
                );

        HBox row =
                new HBox(15);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox textBox =
                new VBox(3);

        Label title =
                new Label(
                        "Application Language"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "English is selected by default."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        textBox.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        languageCombo =
                new ComboBox<>();

        languageCombo.getItems().addAll(
                "English",
                "मराठी",
                "हिन्दी"
        );

        languageCombo.setValue(
                "English"
        );

        languageCombo.setPrefWidth(
                170
        );

        styleComboBox(
                languageCombo
        );

        languageCombo.setOnAction(
                e -> {

                    String selected =
                            languageCombo.getValue();

                    if (selected == null) {
                        return;
                    }

                    if (selected.equals("मराठी")) {

                        currentLanguage =
                                "Marathi";

                    } else if (
                            selected.equals("हिन्दी")
                    ) {

                        currentLanguage =
                                "Hindi";

                    } else {

                        currentLanguage =
                                "English";
                    }

                    updateLanguageText();

                    showInformation(
                            getLocalized(
                                    "Language Updated",
                                    "भाषा अपडेट झाली",
                                    "भाषा अपडेट हो गई"
                            ),
                            getLocalized(
                                    "Application language changed to "
                                            + currentLanguage + ".",
                                    "अॅप्लिकेशनची भाषा "
                                            + currentLanguage
                                            + " करण्यात आली आहे.",
                                    "ऐप्लिकेशन की भाषा "
                                            + currentLanguage
                                            + " कर दी गई है।"
                            )
                    );
                }
        );

        row.getChildren().addAll(
                textBox,
                spacer,
                languageCombo
        );

        card.getChildren().addAll(
                heading,
                row
        );

        return card;
    }

    // =========================================================
    // NOTIFICATION CARD
    // =========================================================

    private VBox createNotificationCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Notifications",
                        "Choose which trainer alerts you want to receive."
                );

        CheckBox sessionNotifications =
                createCheckBox(
                        "Session reminders",
                        "Receive reminders before scheduled training sessions."
                );

        sessionNotifications.setSelected(
                true
        );

        CheckBox clientNotifications =
                createCheckBox(
                        "Client updates",
                        "Get alerts when clients update progress or complete workouts."
                );

        clientNotifications.setSelected(
                true
        );

        CheckBox requestNotifications =
                createCheckBox(
                        "Client requests",
                        "Receive notifications for new client requests."
                );

        requestNotifications.setSelected(
                true
        );

        CheckBox messageNotifications =
                createCheckBox(
                        "New messages",
                        "Get notified when a client sends a new message."
                );

        messageNotifications.setSelected(
                true
        );

        CheckBox reviewNotifications =
                createCheckBox(
                        "Reviews and ratings",
                        "Receive alerts when clients leave reviews or ratings."
                );

        reviewNotifications.setSelected(
                true
        );

        card.getChildren().addAll(
                heading,
                sessionNotifications,
                clientNotifications,
                requestNotifications,
                messageNotifications,
                reviewNotifications
        );

        return card;
    }

    // =========================================================
    // SECURITY CARD
    // =========================================================

    private VBox createSecurityCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Security",
                        "Protect your trainer account and login information."
                );

        HBox passwordRow =
                createActionRow(
                        "Change Password",
                        "Update your account password regularly.",
                        "Change Password"
                );

        Button passwordButton =
                (Button) passwordRow.getChildren().get(
                        passwordRow.getChildren().size() - 1
                );

        passwordButton.setOnAction(
                e -> showPasswordDialog()
        );

        HBox sessionRow =
                createActionRow(
                        "Active Sessions",
                        "Review devices currently signed in to your trainer account.",
                        "View Sessions"
                );

        Button sessionsButton =
                (Button) sessionRow.getChildren().get(
                        sessionRow.getChildren().size() - 1
                );

        sessionsButton.setOnAction(
                e -> showInformation(
                        "Active Sessions",
                        "Your current trainer session is active on this device."
                )
        );

        card.getChildren().addAll(
                heading,
                passwordRow,
                sessionRow
        );

        return card;
    }

    // =========================================================
    // SESSION CARD
    // =========================================================

    private VBox createSessionCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Training Sessions",
                        "Manage reminders and scheduling preferences."
                );

        CheckBox reminder30 =
                createCheckBox(
                        "30-minute session reminder",
                        "Notify me 30 minutes before a scheduled session."
                );

        reminder30.setSelected(
                true
        );

        CheckBox reminder10 =
                createCheckBox(
                        "10-minute session reminder",
                        "Notify me 10 minutes before a scheduled session."
                );

        reminder10.setSelected(
                true
        );

        CheckBox missedSession =
                createCheckBox(
                        "Missed session alerts",
                        "Notify me when a scheduled session is missed or cancelled."
                );

        missedSession.setSelected(
                true
        );

        CheckBox bookingUpdates =
                createCheckBox(
                        "Booking updates",
                        "Receive updates when clients book or reschedule sessions."
                );

        bookingUpdates.setSelected(
                true
        );

        card.getChildren().addAll(
                heading,
                reminder30,
                reminder10,
                missedSession,
                bookingUpdates
        );

        return card;
    }

    // =========================================================
    // PRIVACY CARD
    // =========================================================

    private VBox createPrivacyCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Privacy",
                        "Control how your trainer account information is handled."
                );

        CheckBox profileVisibility =
                createCheckBox(
                        "Trainer profile visibility",
                        "Allow active clients to view your trainer profile."
                );

        profileVisibility.setSelected(
                true
        );

        CheckBox onlineStatus =
                createCheckBox(
                        "Show online status",
                        "Allow clients to see when you are available in Chatbox."
                );

        onlineStatus.setSelected(
                true
        );

        CheckBox progressSharing =
                createCheckBox(
                        "Client progress sharing",
                        "Allow approved client progress information to appear in trainer reports."
                );

        progressSharing.setSelected(
                true
        );

        card.getChildren().addAll(
                heading,
                profileVisibility,
                onlineStatus,
                progressSharing
        );

        return card;
    }

    // =========================================================
    // LOGOUT CARD
    // =========================================================

    private VBox createLogoutCard() {

        VBox card =
                createCard();

        HBox heading =
                createSectionHeading(
                        "Account Actions",
                        "Actions related to your current trainer account."
                );

        HBox logoutRow =
                new HBox();

        logoutRow.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox text =
                new VBox(3);

        Label title =
                new Label(
                        "Log out"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "End your current trainer session."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );

        text.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button logout =
                new Button(
                        "🚪 Logout"
                );

        logout.setStyle(
                "-fx-background-color: rgba(255,180,171,0.07);" +
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-border-color: rgba(255,180,171,0.18);" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 9 18;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        logout.setOnAction(
                e -> showInformation(
                        "Logout",
                        "Connect this button with your existing trainer logout method."
                )
        );

        logoutRow.getChildren().addAll(
                text,
                spacer,
                logout
        );

        card.getChildren().addAll(
                heading,
                logoutRow
        );

        return card;
    }

    // =========================================================
    // CARD
    // =========================================================

    private VBox createCard() {

        VBox card =
                new VBox(16);

        card.setPadding(
                new Insets(22)
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setFillWidth(true);

        card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0b1711, " +
                CARD_BG + ");" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: rgba(255,255,255,0.11);" +
                "-fx-border-radius: 16;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.22), 12, 0.10, 0, 4);"
        );

        return card;
    }

    // =========================================================
    // SECTION HEADING
    // =========================================================

    private HBox createSectionHeading(
            String title,
            String subtitle
    ) {

        HBox box =
                new HBox(10);

        box.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox text =
                new VBox(3);

        Region accent =
                new Region();

        accent.setMinSize(4, 32);
        accent.setPrefSize(4, 32);
        accent.setMaxSize(4, 32);

        accent.setStyle(
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-background-radius: 4;" +
                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.40), 8, 0.30, 0, 0);"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;" +
                "-fx-padding: 1 0 0 0;"
        );

        text.getChildren().addAll(
                titleLabel,
                subtitleLabel
        );

        box.getChildren().addAll(
                accent,
                text
        );

        return box;
    }

    // =========================================================
    // CHECKBOX
    // =========================================================

    private CheckBox createCheckBox(
            String title,
            String subtitle
    ) {

        CheckBox checkBox =
                new CheckBox();

        /*
         * IMPORTANT:
         *
         * RIGHT_TO_LEFT is used only for the CheckBox control
         * so that the actual checkbox indicator appears on
         * the RIGHT side.
         *
         * The text VBox itself is forced to LEFT_TO_RIGHT so
         * English text remains properly left aligned.
         */
        checkBox.setNodeOrientation(
                NodeOrientation.RIGHT_TO_LEFT
        );

        checkBox.setMaxWidth(
                Double.MAX_VALUE
        );

        checkBox.setMinHeight(
                52
        );

        checkBox.setPrefHeight(
                52
        );

        checkBox.setAlignment(
                Pos.CENTER_LEFT
        );

        checkBox.setContentDisplay(
                ContentDisplay.RIGHT
        );

        checkBox.setGraphicTextGap(
                12
        );

        checkBox.setSelected(
                true
        );

        // =====================================================
        // TEXT AREA
        // =====================================================

        VBox text =
                new VBox(3);

        /*
         * Do NOT inherit RTL orientation here.
         * This is the important part which fixes the text
         * appearing on the wrong side / wrong alignment.
         */
        text.setNodeOrientation(
                NodeOrientation.LEFT_TO_RIGHT
        );

        text.setAlignment(
                Pos.CENTER_LEFT
        );

        /*
         * Fixed graphic width keeps all checkbox rows aligned
         * and prevents the text from collapsing towards the
         * right side.
         */
        text.setPrefWidth(
                540
        );

        text.setMinWidth(
                0
        );

        text.setMaxWidth(
                540
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setMaxWidth(
                Double.MAX_VALUE
        );

        titleLabel.setAlignment(
                Pos.CENTER_LEFT
        );

        titleLabel.setTextAlignment(
                TextAlignment.LEFT
        );

        titleLabel.setNodeOrientation(
                NodeOrientation.LEFT_TO_RIGHT
        );

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-alignment: CENTER-LEFT;"
        );

        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setMaxWidth(
                Double.MAX_VALUE
        );

        subtitleLabel.setWrapText(
                true
        );

        subtitleLabel.setAlignment(
                Pos.CENTER_LEFT
        );

        subtitleLabel.setTextAlignment(
                TextAlignment.LEFT
        );

        subtitleLabel.setNodeOrientation(
                NodeOrientation.LEFT_TO_RIGHT
        );

        subtitleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;" +
                "-fx-alignment: CENTER-LEFT;"
        );

        text.getChildren().addAll(
                titleLabel,
                subtitleLabel
        );

        // =====================================================
        // GRAPHIC CONTAINER
        // =====================================================

        HBox graphic =
                new HBox();

        graphic.setAlignment(
                Pos.CENTER_LEFT
        );

        graphic.setPrefWidth(
                540
        );

        graphic.setMinWidth(
                540
        );

        graphic.setMaxWidth(
                540
        );

        graphic.getChildren().add(
                text
        );

        checkBox.setGraphic(
                graphic
        );

        // =====================================================
        // CHECKBOX STYLE
        // =====================================================

        checkBox.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-cursor: hand;" +
                "-fx-focus-color: transparent;" +
                "-fx-faint-focus-color: transparent;" +
                "-fx-mark-color: " +
                PRIMARY +
                ";" +
                "-fx-focused-mark-color: " +
                PRIMARY +
                ";"
        );

        return checkBox;
    }

    // =========================================================
    // ACTION ROW
    // =========================================================

    private HBox createActionRow(
            String title,
            String subtitle,
            String buttonText
    ) {

        HBox row =
                new HBox(15);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox text =
                new VBox(3);

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;"
        );

        text.getChildren().addAll(
                titleLabel,
                subtitleLabel
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button button =
                createSecondaryButton(
                        buttonText
                );

        row.getChildren().addAll(
                text,
                spacer,
                button
        );

        return row;
    }

    // =========================================================
    // PRIMARY BUTTON
    // =========================================================

    private Button createPrimaryButton(
            String text
    ) {

        Button button =
                new Button(text);

        String normal =
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 10 18;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        String hover =
                "-fx-background-color: #9affb7;" +
                "-fx-text-fill: #003918;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 10 18;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        addHoverEffect(
                button,
                normal,
                hover
        );

        return button;
    }

    // =========================================================
    // SECONDARY BUTTON
    // =========================================================

    private Button createSecondaryButton(
            String text
    ) {

        Button button =
                new Button(text);

        String normal =
                "-fx-background-color: rgba(117,255,158,0.08);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-border-color: rgba(117,255,158,0.15);" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 8 14;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        String hover =
                "-fx-background-color: " + PRIMARY_DARK + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 8 14;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";

        addHoverEffect(
                button,
                normal,
                hover
        );

        return button;
    }

    // =========================================================
    // TEXT FIELD STYLE
    // =========================================================

    private void styleTextField(
            TextField field
    ) {

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setStyle(
                "-fx-background-color: #0a1510;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-border-color: rgba(117,255,158,0.16);" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 10 12;" +
                "-fx-font-size: 11px;"
        );
    }

    // =========================================================
    // COMBOBOX STYLE
    // =========================================================

    private void styleComboBox(
            ComboBox<String> combo
    ) {

        combo.setStyle(
                "-fx-background-color: #0a1510;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-border-color: rgba(117,255,158,0.20);" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 2 4;" +
                "-fx-font-size: 11px;"
        );
    }

    // =========================================================
    // SETTING LABEL
    // =========================================================

    private Label createSettingLabel(
            String text
    ) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // LANGUAGE UPDATE
    // =========================================================

    private void updateLanguageText() {

        if (currentLanguage.equals("Marathi")) {

            pageTitle.setText(
                    "सेटिंग्ज"
            );

            pageSubtitle.setText(
                    "तुमचे ट्रेनर खाते आणि अॅप्लिकेशनच्या सेटिंग्ज व्यवस्थापित करा."
            );

        } else if (
                currentLanguage.equals("Hindi")
        ) {

            pageTitle.setText(
                    "सेटिंग्स"
            );

            pageSubtitle.setText(
                    "अपने ट्रेनर अकाउंट और एप्लिकेशन की सेटिंग्स प्रबंधित करें."
            );

        } else {

            pageTitle.setText(
                    "Settings"
            );

            pageSubtitle.setText(
                    "Manage your trainer account and application preferences."
            );
        }
    }

    // =========================================================
    // LOCALIZED TEXT
    // =========================================================

    private String getLocalized(
            String english,
            String marathi,
            String hindi
    ) {

        if (currentLanguage.equals("Marathi")) {
            return marathi;
        }

        if (currentLanguage.equals("Hindi")) {
            return hindi;
        }

        return english;
    }

    // =========================================================
    // PASSWORD DIALOG
    // =========================================================

    private void showPasswordDialog() {

        Dialog<ButtonType> dialog =
                new Dialog<>();

        dialog.setTitle(
                "Change Password"
        );

        dialog.setHeaderText(
                "Update your trainer account password."
        );

        PasswordField oldPassword =
                new PasswordField();

        oldPassword.setPromptText(
                "Current password"
        );

        PasswordField newPassword =
                new PasswordField();

        newPassword.setPromptText(
                "New password"
        );

        PasswordField confirmPassword =
                new PasswordField();

        confirmPassword.setPromptText(
                "Confirm new password"
        );

        VBox content =
                new VBox(10);

        content.setPadding(
                new Insets(10)
        );

        content.getChildren().addAll(
                oldPassword,
                newPassword,
                confirmPassword
        );

        dialog.getDialogPane().setContent(
                content
        );

        ButtonType update =
                new ButtonType(
                        "Update",
                        ButtonBar.ButtonData.OK_DONE
                );

        dialog.getDialogPane()
                .getButtonTypes()
                .addAll(
                        update,
                        ButtonType.CANCEL
                );

        dialog.showAndWait().ifPresent(
                result -> {

                    if (result == update) {

                        if (
                                newPassword
                                        .getText()
                                        .isBlank() ||
                                !newPassword
                                        .getText()
                                        .equals(
                                                confirmPassword
                                                        .getText()
                                        )
                        ) {

                            showInformation(
                                    "Password Error",
                                    "New password and confirmation password must match."
                            );

                            return;
                        }

                        showInformation(
                                "Password Updated",
                                "Your trainer password has been updated successfully."
                        );
                    }
                }
        );
    }

    // =========================================================
    // INFORMATION DIALOG
    // =========================================================

    private void showInformation(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
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
    // HOVER EFFECT
    // =========================================================

    private void addHoverEffect(
            Button button,
            String normalStyle,
            String hoverStyle
    ) {

        button.setStyle(
                normalStyle
        );

        button.setOnMouseEntered(
                e -> button.setStyle(
                        hoverStyle
                )
        );

        button.setOnMouseExited(
                e -> button.setStyle(
                        normalStyle
                )
        );
    }

    // =========================================================
    // HEADING HELPERS
    // =========================================================

    private Label headingTitleFrom(
            HBox heading
    ) {

        for (javafx.scene.Node child :
                heading.getChildren()) {

            if (!(child instanceof VBox)) {
                continue;
            }

            VBox box =
                    (VBox) child;

            if (
                    box.getChildren().size() > 0 &&
                    box.getChildren().get(0)
                            instanceof Label
            ) {

                return (Label)
                        box.getChildren().get(0);
            }
        }

        return null;
    }

    private Label headingSubtitleFrom(
            HBox heading
    ) {

        for (javafx.scene.Node child :
                heading.getChildren()) {

            if (!(child instanceof VBox)) {
                continue;
            }

            VBox box =
                    (VBox) child;

            if (
                    box.getChildren().size() > 1 &&
                    box.getChildren().get(1)
                            instanceof Label
            ) {

                return (Label)
                        box.getChildren().get(1);
            }
        }

        return null;
    }
}
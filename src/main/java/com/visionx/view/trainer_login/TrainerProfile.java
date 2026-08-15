package com.visionx.view.trainer_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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
import javafx.scene.shape.Circle;

public class TrainerProfile {

    private Scene profileScene;

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

    private final String ERROR =
            "#ffb4ab";

    // =========================================================
    // SHADOW
    // =========================================================

    private final DropShadow cardShadow =
            new DropShadow(
                    20,
                    0,
                    8,
                    Color.color(
                            0,
                            0,
                            0,
                            0.4
                    )
            );

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getTrainerProfileScene(
            Runnable callBackAction
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
        // CONTENT
        // =====================================================

        VBox content =
                createProfileContent(
                        callBackAction
                );

        ScrollPane scroll =
                new ScrollPane(
                        content
                );

        scroll.setFitToWidth(
                true
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        root.setCenter(
                scroll
        );

        // =====================================================
        // SCENE
        // =====================================================

        profileScene =
                new Scene(
                        root,
                        1160,
                        900
                );

        return profileScene;
    }

    // =========================================================
    // PROFILE CONTENT
    // =========================================================

    private VBox createProfileContent(
            Runnable callBackAction
    ) {

        VBox content =
                new VBox(24);

        content.setPadding(
                new Insets(
                        32,
                        32,
                        40,
                        32
                )
        );

        content.setMaxWidth(
                Double.MAX_VALUE
        );

        content.setFillWidth(
                true
        );

        // =====================================================
        // PAGE HEADER
        // =====================================================

        VBox header =
                new VBox(5);

        Label breadcrumb =
                new Label(
                        "Trainer Portal  ›  My Profile"
                );

        breadcrumb.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        Label title =
                new Label(
                        "My Profile"
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
                        "Manage your personal information, professional details and account settings."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 14px;"
        );

        header.getChildren().addAll(
                breadcrumb,
                title,
                subtitle
        );

        // =====================================================
        // PROFILE HEADER CARD
        // =====================================================

        VBox profileCard =
                createProfileHeader();

        // =====================================================
        // PERSONAL INFORMATION
        // =====================================================

        VBox personalCard =
                createPersonalInformation();

        // =====================================================
        // PROFESSIONAL INFORMATION
        // =====================================================

        VBox professionalCard =
                createProfessionalInformation();

        // =====================================================
        // ACCOUNT SETTINGS
        // =====================================================

        VBox accountCard =
                createAccountSettings();

        // =====================================================
        // CONTENT
        // =====================================================

        content.getChildren().addAll(
                header,
                profileCard,
                personalCard,
                professionalCard,
                accountCard
        );

        return content;
    }

    // =========================================================
    // PROFILE HEADER
    // =========================================================

    private VBox createProfileHeader() {

        VBox card =
                createCard();

        HBox row =
                new HBox(20);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // AVATAR
        // =====================================================

        StackPane avatar =
                new StackPane();

        avatar.setMinSize(
                90,
                90
        );

        avatar.setMaxSize(
                90,
                90
        );

        avatar.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #163b2a, #071b12);" +
                "-fx-background-radius: 50;" +
                "-fx-border-color: rgba(117,255,158,0.25);" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 50;"
        );

        Circle circle =
                new Circle(
                        40
                );

        circle.setFill(
                Color.web(
                        PRIMARY_DIM
                )
        );

        Label avatarText =
                new Label(
                        "AT"
                );

        avatarText.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        avatar.getChildren().addAll(
                circle,
                avatarText
        );

        // =====================================================
        // PROFILE INFO
        // =====================================================

        VBox info =
                new VBox(6);

        Label name =
                new Label(
                        "Alex Trainer"
                );

        name.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        Label role =
                new Label(
                        "Certified Fitness Trainer"
                );

        role.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label location =
                new Label(
                        "📍 Mumbai, India"
                );

        location.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        Label status =
                new Label(
                        "● Active Trainer"
                );

        status.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        info.getChildren().addAll(
                name,
                role,
                location,
                status
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // =====================================================
        // EDIT BUTTON
        // =====================================================

        Button edit =
                new Button(
                        "✎  Edit Profile"
                );

        String normal =
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 10 18;" +
                "-fx-cursor: hand;";

        String hover =
                "-fx-background-color: #8affad;" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 10 18;" +
                "-fx-cursor: hand;";

        edit.setStyle(
                normal
        );

        edit.setOnMouseEntered(
                e -> edit.setStyle(
                        hover
                )
        );

        edit.setOnMouseExited(
                e -> edit.setStyle(
                        normal
                )
        );

        row.getChildren().addAll(
                avatar,
                info,
                spacer,
                edit
        );

        card.setPadding(
                new Insets(
                        24,
                        26,
                        24,
                        26
                )
        );

        card.setStyle(
                "-fx-background-color: linear-gradient(to right, #071b12, #020914);" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: rgba(117,255,158,0.16);" +
                "-fx-border-radius: 20;"
        );

        card.setEffect(
                new DropShadow(
                        24,
                        0,
                        8,
                        Color.color(
                                0,
                                0,
                                0,
                                0.48
                        )
                )
        );

        card.getChildren().add(
                row
        );

        return card;
    }

    // =========================================================
    // PERSONAL INFORMATION
    // =========================================================

    private VBox createPersonalInformation() {

        VBox card =
                createCard();

        Label title =
                createSectionTitle(
                        "Personal Information"
                );

        Label subtitle =
                createSectionSubtitle(
                        "Your basic personal and contact information."
                );

        GridPane grid =
                new GridPane();

        grid.setHgap(
                20
        );

        grid.setVgap(
                16
        );

        TextField firstName =
                createTextField(
                        "Jordan"
                );

        TextField lastName =
                createTextField(
                        "Sterling"
                );

        TextField email =
                createTextField(
                        "jordan.sterling@example.com"
                );

        TextField phone =
                createTextField(
                        "+91 98765 43210"
                );

        TextField location =
                createTextField(
                        "Mumbai, India"
                );

        TextField dob =
                createTextField(
                        "12 March 1998"
                );

        grid.add(
                createField(
                        "First Name",
                        firstName
                ),
                0,
                0
        );

        grid.add(
                createField(
                        "Last Name",
                        lastName
                ),
                1,
                0
        );

        grid.add(
                createField(
                        "Email Address",
                        email
                ),
                0,
                1
        );

        grid.add(
                createField(
                        "Phone Number",
                        phone
                ),
                1,
                1
        );

        grid.add(
                createField(
                        "Location",
                        location
                ),
                0,
                2
        );

        grid.add(
                createField(
                        "Date of Birth",
                        dob
                ),
                1,
                2
        );

        ColumnConstraintsHelper.setColumns(
                grid
        );

        card.getChildren().addAll(
                title,
                subtitle,
                createSeparator(),
                grid
        );

        return card;
    }

    // =========================================================
    // PROFESSIONAL INFORMATION
    // =========================================================

    private VBox createProfessionalInformation() {

        VBox card =
                createCard();

        Label title =
                createSectionTitle(
                        "Professional Information"
                );

        Label subtitle =
                createSectionSubtitle(
                        "Details about your training expertise and experience."
                );

        GridPane grid =
                new GridPane();

        grid.setHgap(
                20
        );

        grid.setVgap(
                16
        );

        TextField specialization =
                createTextField(
                        "Strength & Conditioning"
                );

        TextField experience =
                createTextField(
                        "6 Years"
                );

        TextField certification =
                createTextField(
                        "Certified Personal Trainer"
                );

        TextField hourlyRate =
                createTextField(
                        "$45 / Hour"
                );

        TextField clients =
                createTextField(
                        "48 Active Clients"
                );

        TextField rating =
                createTextField(
                        "4.8 / 5.0"
                );

        grid.add(
                createField(
                        "Specialization",
                        specialization
                ),
                0,
                0
        );

        grid.add(
                createField(
                        "Experience",
                        experience
                ),
                1,
                0
        );

        grid.add(
                createField(
                        "Certification",
                        certification
                ),
                0,
                1
        );

        grid.add(
                createField(
                        "Hourly Rate",
                        hourlyRate
                ),
                1,
                1
        );

        grid.add(
                createField(
                        "Active Clients",
                        clients
                ),
                0,
                2
        );

        grid.add(
                createField(
                        "Average Rating",
                        rating
                ),
                1,
                2
        );

        ColumnConstraintsHelper.setColumns(
                grid
        );

        card.getChildren().addAll(
                title,
                subtitle,
                createSeparator(),
                grid
        );

        return card;
    }

    // =========================================================
    // ACCOUNT SETTINGS
    // =========================================================

    private VBox createAccountSettings() {

        VBox card =
                createCard();

        Label title =
                createSectionTitle(
                        "Account Settings"
                );

        Label subtitle =
                createSectionSubtitle(
                        "Manage your account preferences and security."
                );

        // =====================================================
        // CHANGE PASSWORD
        // =====================================================

        HBox passwordRow =
                createSettingRow(
                        "Change Password",
                        "Update your account password regularly for better security.",
                        "Change"
                );

        // =====================================================
        // NOTIFICATIONS
        // =====================================================

        HBox notificationRow =
                createSettingRow(
                        "Notifications",
                        "Manage trainer alerts, client requests and messages.",
                        "Manage"
                );

        // =====================================================
        // PRIVACY
        // =====================================================

        HBox privacyRow =
                createSettingRow(
                        "Profile Visibility",
                        "Control how clients can discover your trainer profile.",
                        "Public"
                );

        card.getChildren().addAll(
                title,
                subtitle,
                createSeparator(),
                passwordRow,
                createSeparator(),
                notificationRow,
                createSeparator(),
                privacyRow
        );

        return card;
    }

    // =========================================================
    // SETTING ROW
    // =========================================================

    private HBox createSettingRow(
            String titleText,
            String description,
            String buttonText
    ) {

        HBox row =
                new HBox(15);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox text =
                new VBox(4);

        HBox.setHgrow(
                text,
                Priority.ALWAYS
        );

        Label title =
                new Label(
                        titleText
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label desc =
                new Label(
                        description
                );

        desc.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        desc.setWrapText(
                true
        );

        text.getChildren().addAll(
                title,
                desc
        );

        Button action =
                new Button(
                        buttonText
                );

        action.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 7 16;" +
                "-fx-cursor: hand;"
        );

        row.getChildren().addAll(
                text,
                action
        );

        return row;
    }

    // =========================================================
    // FIELD
    // =========================================================

    private VBox createField(
            String labelText,
            TextField field
    ) {

        VBox box =
                new VBox(7);

        Label label =
                new Label(
                        labelText
                );

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        box.getChildren().addAll(
                label,
                field
        );

        return box;
    }

    // =========================================================
    // TEXT FIELD
    // =========================================================

    private TextField createTextField(
            String text
    ) {

        TextField field =
                new TextField(
                        text
                );

        field.setPrefHeight(
                40
        );

        field.setStyle(
                "-fx-background-color: rgba(255,255,255,0.03);" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-padding: 8 12;" +
                "-fx-font-size: 12px;"
        );

        return field;
    }

    // =========================================================
    // SECTION TITLE
    // =========================================================

    private Label createSectionTitle(
            String text
    ) {

        Label label =
                new Label(
                        text
                );

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // SECTION SUBTITLE
    // =========================================================

    private Label createSectionSubtitle(
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
                "-fx-font-size: 11px;"
        );

        return label;
    }

    // =========================================================
    // SEPARATOR
    // =========================================================

    private Separator createSeparator() {

        Separator separator =
                new Separator();

        separator.setStyle(
                "-fx-background-color: " +
                SURFACE_BORDER +
                ";"
        );

        return separator;
    }

    // =========================================================
    // CARD
    // =========================================================

    private VBox createCard() {

        VBox card =
                new VBox(12);

        card.setPadding(
                new Insets(20)
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

        return card;
    }

    // =========================================================
    // HELPER FOR GRID COLUMNS
    // =========================================================

    private static class ColumnConstraintsHelper {

        static void setColumns(
                GridPane grid
        ) {

            javafx.scene.layout.ColumnConstraints col1 =
                    new javafx.scene.layout.ColumnConstraints();

            javafx.scene.layout.ColumnConstraints col2 =
                    new javafx.scene.layout.ColumnConstraints();

            col1.setHgrow(
                    Priority.ALWAYS
            );

            col2.setHgrow(
                    Priority.ALWAYS
            );

            col1.setPercentWidth(
                    50
            );

            col2.setPercentWidth(
                    50
            );

            grid.getColumnConstraints().addAll(
                    col1,
                    col2
            );
        }
    }

    // =========================================================
    // NO ARGUMENT VERSION
    // =========================================================

    public Scene getTrainerProfileScene() {

        return getTrainerProfileScene(
                null
        );
    }
}
package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Settings {

    private Scene settingsScene;

    public Scene getSettingsScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Settings");


        /*
         * =========================================
         * TOP BAR
         * =========================================
         */

        HBox topBar = new HBox();

        topBar.setPrefHeight(70);

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        topBar.setPadding(
                new Insets(0, 35, 0, 35)
        );

        topBar.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-border-color: #e1e5ef;" +
                "-fx-border-width: 0 0 1 0;"
        );


        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search settings..."
        );

        searchField.setPrefWidth(430);

        searchField.setPrefHeight(40);

        searchField.setStyle(
                "-fx-background-color: #f0f3ff;" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 0 20;" +
                "-fx-border-color: transparent;"
        );


        Region topSpacer =
                new Region();

        HBox.setHgrow(
                topSpacer,
                Priority.ALWAYS
        );


        VBox userDetails =
                new VBox(2);

        userDetails.setAlignment(
                Pos.CENTER_RIGHT
        );


        Text userName =
                new Text("Alex Rivera");

        userName.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text userType =
                new Text("STORE OWNER");

        userType.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #737686;"
        );


        userDetails.getChildren().addAll(
                userName,
                userType
        );


        topBar.getChildren().addAll(
                searchField,
                topSpacer,
                userDetails
        );


        /*
         * =========================================
         * CENTRE
         * =========================================
         */

        VBox centre =
                new VBox(25);

        centre.setPadding(
                new Insets(35)
        );

        centre.setStyle(
                "-fx-background-color: #f9f9ff;"
        );


        /*
         * =========================================
         * PAGE HEADER
         * =========================================
         */

        VBox headingBox =
                new VBox(5);


        Text heading =
                new Text("Settings");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text subHeading =
                new Text(
                        "Manage your store account, preferences and security."
                );

        subHeading.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-fill: #737686;"
        );


        headingBox.getChildren().addAll(
                heading,
                subHeading
        );


        /*
         * =========================================
         * PROFILE SETTINGS
         * =========================================
         */

        VBox profileCard =
                new VBox(18);

        profileCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-padding: 25;"
        );


        Text profileTitle =
                new Text("Profile Settings");

        profileTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text profileSubTitle =
                new Text(
                        "Update your personal and store information."
                );

        profileSubTitle.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #737686;"
        );


        HBox nameRow =
                new HBox(20);


        VBox firstNameBox =
                createField(
                        "First Name",
                        "Alex"
                );


        VBox lastNameBox =
                createField(
                        "Last Name",
                        "Rivera"
                );


        HBox.setHgrow(
                firstNameBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                lastNameBox,
                Priority.ALWAYS
        );


        nameRow.getChildren().addAll(
                firstNameBox,
                lastNameBox
        );


        VBox emailBox =
                createField(
                        "Email Address",
                        "alexrivera@example.com"
                );


        VBox phoneBox =
                createField(
                        "Phone Number",
                        "+91 98765 43210"
                );


        HBox contactRow =
                new HBox(20);


        HBox.setHgrow(
                emailBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                phoneBox,
                Priority.ALWAYS
        );


        contactRow.getChildren().addAll(
                emailBox,
                phoneBox
        );


        Button saveProfileButton =
                new Button("Save Profile");

        saveProfileButton.setPrefHeight(40);

        saveProfileButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 20;" +
                "-fx-font-weight: bold;"
        );


        profileCard.getChildren().addAll(
                profileTitle,
                profileSubTitle,
                nameRow,
                contactRow,
                saveProfileButton
        );


        /*
         * =========================================
         * STORE SETTINGS
         * =========================================
         */

        VBox storeCard =
                new VBox(18);

        storeCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-padding: 25;"
        );


        Text storeTitle =
                new Text("Store Settings");

        storeTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text storeSubTitle =
                new Text(
                        "Configure your store preferences."
                );

        storeSubTitle.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #737686;"
        );


        VBox storeNameBox =
                createField(
                        "Store Name",
                        "FitLife Supplements"
                );


        VBox storeEmailBox =
                createField(
                        "Store Email",
                        "support@fitlife.com"
                );


        VBox addressBox =
                createField(
                        "Store Address",
                        "Pune, Maharashtra"
                );


        HBox storeOptions =
                new HBox(35);

        storeOptions.setAlignment(
                Pos.CENTER_LEFT
        );


        CheckBox orderNotification =
                new CheckBox(
                        "Order Notifications"
                );

        orderNotification.setSelected(true);

        orderNotification.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        CheckBox lowStockNotification =
                new CheckBox(
                        "Low Stock Alerts"
                );

        lowStockNotification.setSelected(true);

        lowStockNotification.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        CheckBox reviewNotification =
                new CheckBox(
                        "Customer Review Alerts"
                );

        reviewNotification.setSelected(true);

        reviewNotification.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        storeOptions.getChildren().addAll(
                orderNotification,
                lowStockNotification,
                reviewNotification
        );


        Button saveStoreButton =
                new Button("Save Store Settings");

        saveStoreButton.setPrefHeight(40);

        saveStoreButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 20;" +
                "-fx-font-weight: bold;"
        );


        storeCard.getChildren().addAll(
                storeTitle,
                storeSubTitle,
                storeNameBox,
                storeEmailBox,
                addressBox,
                storeOptions,
                saveStoreButton
        );


        /*
         * =========================================
         * SECURITY SETTINGS
         * =========================================
         */

        VBox securityCard =
                new VBox(18);

        securityCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-padding: 25;"
        );


        Text securityTitle =
                new Text("Security");

        securityTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text securitySubTitle =
                new Text(
                        "Change your password and manage account security."
                );

        securitySubTitle.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #737686;"
        );


        PasswordField currentPassword =
                new PasswordField();

        currentPassword.setPromptText(
                "Current Password"
        );

        currentPassword.setPrefHeight(42);

        currentPassword.setStyle(
                "-fx-background-color: #f5f6fb;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 15;"
        );


        PasswordField newPassword =
                new PasswordField();

        newPassword.setPromptText(
                "New Password"
        );

        newPassword.setPrefHeight(42);

        newPassword.setStyle(
                "-fx-background-color: #f5f6fb;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 15;"
        );


        PasswordField confirmPassword =
                new PasswordField();

        confirmPassword.setPromptText(
                "Confirm New Password"
        );

        confirmPassword.setPrefHeight(42);

        confirmPassword.setStyle(
                "-fx-background-color: #f5f6fb;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 15;"
        );


        Button changePasswordButton =
                new Button("Change Password");

        changePasswordButton.setPrefHeight(40);

        changePasswordButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 20;" +
                "-fx-font-weight: bold;"
        );


        securityCard.getChildren().addAll(
                securityTitle,
                securitySubTitle,
                currentPassword,
                newPassword,
                confirmPassword,
                changePasswordButton
        );


        /*
         * =========================================
         * PREFERENCES
         * =========================================
         */

        VBox preferencesCard =
                new VBox(15);

        preferencesCard.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Text preferenceTitle =
                new Text(
                        "⚙  Store Preferences"
                );

        preferenceTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        CheckBox emailUpdates =
                new CheckBox(
                        "Receive important updates through email"
                );

        emailUpdates.setSelected(true);

        emailUpdates.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        CheckBox promotionalUpdates =
                new CheckBox(
                        "Receive promotional offers and discounts"
                );

        promotionalUpdates.setSelected(true);

        promotionalUpdates.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        CheckBox analyticsUpdates =
                new CheckBox(
                        "Receive weekly sales and analytics reports"
                );

        analyticsUpdates.setSelected(true);

        analyticsUpdates.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        preferencesCard.getChildren().addAll(
                preferenceTitle,
                emailUpdates,
                promotionalUpdates,
                analyticsUpdates
        );


        /*
         * =========================================
         * BACK BUTTON
         * =========================================
         */

        Button backButton =
                new Button("←  Back to Dashboard");

        backButton.setPrefHeight(40);

        backButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 18;"
        );


        backButton.setOnAction(event -> {

            System.out.println(
                    "Back Button Clicked"
            );

            callBackAction.run();

        });


        /*
         * =========================================
         * ADD CENTRE CONTENT
         * =========================================
         */

        centre.getChildren().addAll(

                headingBox,

                profileCard,

                storeCard,

                securityCard,

                preferencesCard,

                backButton

        );


        /*
         * =========================================
         * SCROLLPANE
         *
         * Horizontal = NEVER
         * Vertical   = AS NEEDED
         * =========================================
         */

        ScrollPane scrollPane =
                new ScrollPane(centre);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: #f9f9ff;" +
                "-fx-border-color: transparent;"
        );


        /*
         * =========================================
         * MAIN LAYOUT
         * =========================================
         */

        BorderPane mainPane =
                new BorderPane();

        mainPane.setLeft(
                sideBar
        );

        mainPane.setTop(
                topBar
        );

        mainPane.setCenter(
                scrollPane
        );


        /*
         * =========================================
         * SCENE ONLY
         *
         * NO STAGE
         * NO APPLICATION
         * NO MAIN METHOD
         * =========================================
         */

        Scene sc =
                new Scene(
                        mainPane,
                        1400,
                        800
                );


        settingsScene = sc;

        return settingsScene;

    }


    /*
     * =========================================
     * FIELD CREATOR
     * =========================================
     */

    public VBox createField(
            String title,
            String value) {

        VBox box =
                new VBox(7);


        Text label =
                new Text(title);

        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #434655;"
        );


        TextField field =
                new TextField(value);

        field.setPrefHeight(42);

        field.setStyle(
                "-fx-background-color: #f5f6fb;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 15;" +
                "-fx-border-color: transparent;"
        );


        box.getChildren().addAll(
                label,
                field
        );


        HBox.setHgrow(
                box,
                Priority.ALWAYS
        );


        return box;

    }

}

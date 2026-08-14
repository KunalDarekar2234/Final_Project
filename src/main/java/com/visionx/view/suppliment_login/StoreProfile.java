package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class StoreProfile {

    private Scene storeProfileScene;


    public Scene getStoreProfileScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Store Profile");


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


        Label searchBox =
                new Label(
                        "🔍  Search analytics or products..."
                );

        searchBox.setPrefWidth(430);

        searchBox.setPrefHeight(40);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.setStyle(
                "-fx-background-color: #f0f3ff;" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 0 20;" +
                "-fx-text-fill: #737686;" +
                "-fx-font-size: 14px;"
        );


        VBox userDetails =
                new VBox(2);

        userDetails.setAlignment(
                Pos.CENTER_RIGHT
        );


        Label userName =
                new Label("Alex Rivera");

        userName.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label userType =
                new Label("STORE OWNER");

        userType.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-text-fill: #737686;"
        );


        userDetails.getChildren().addAll(
                userName,
                userType
        );


        HBox topSpacer =
                new HBox();

        HBox.setHgrow(
                topSpacer,
                Priority.ALWAYS
        );


        topBar.getChildren().addAll(
                searchBox,
                topSpacer,
                userDetails
        );


        /*
         * =========================================
         * STORE PROFILE CENTRE
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

        Label heading =
                new Label("Store Profile");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Manage your store information and profile details."
                );

        subHeading.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * =========================================
         * STORE INFORMATION CARD
         * =========================================
         */

        VBox storeCard =
                new VBox(20);

        storeCard.setMaxWidth(
                Double.MAX_VALUE
        );

        storeCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 30;"
        );


        Label storeTitle =
                new Label("Store Information");

        storeTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * =========================================
         * STORE NAME
         * =========================================
         */

        Label storeNameLabel =
                new Label("Store Name");

        storeNameLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        TextField storeName =
                new TextField("FitVerse Supplements");

        storeName.setPrefHeight(42);

        storeName.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 12;"
        );


        /*
         * =========================================
         * OWNER NAME
         * =========================================
         */

        Label ownerLabel =
                new Label("Owner Name");

        ownerLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        TextField ownerName =
                new TextField("Alex Rivera");

        ownerName.setPrefHeight(42);

        ownerName.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 12;"
        );


        /*
         * =========================================
         * EMAIL
         * =========================================
         */

        Label emailLabel =
                new Label("Email Address");

        emailLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        TextField email =
                new TextField("store@fitverse.com");

        email.setPrefHeight(42);

        email.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 12;"
        );


        /*
         * =========================================
         * PHONE
         * =========================================
         */

        Label phoneLabel =
                new Label("Phone Number");

        phoneLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        TextField phone =
                new TextField("+91 9876543210");

        phone.setPrefHeight(42);

        phone.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 12;"
        );


        /*
         * =========================================
         * ADDRESS
         * =========================================
         */

        Label addressLabel =
                new Label("Store Address");

        addressLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        TextField address =
                new TextField(
                        "123 Fitness Street, Mumbai, Maharashtra"
                );

        address.setPrefHeight(42);

        address.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 12;"
        );


        /*
         * =========================================
         * BUTTONS
         * =========================================
         */

        Button saveButton =
                new Button("Save Changes");

        saveButton.setPrefHeight(42);

        saveButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 25;" +
                "-fx-font-weight: bold;"
        );


        Button cancelButton =
                new Button("Cancel");

        cancelButton.setPrefHeight(42);

        cancelButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 25;"
        );


        /*
         * =========================================
         * BUTTON ACTION
         * =========================================
         */

        cancelButton.setOnAction(event -> {

            System.out.println(
                    "Back Button Clicked"
            );

            callBackAction.run();

        });


        saveButton.setOnAction(event -> {

            System.out.println(
                    "Store Profile Saved"
            );

        });


        HBox buttonBox =
                new HBox(12);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                cancelButton,
                saveButton
        );


        /*
         * =========================================
         * ADD STORE FORM
         * =========================================
         */

        storeCard.getChildren().addAll(

                storeTitle,

                storeNameLabel,
                storeName,

                ownerLabel,
                ownerName,

                emailLabel,
                email,

                phoneLabel,
                phone,

                addressLabel,
                address,

                buttonBox

        );


        /*
         * =========================================
         * ADD CENTRE CONTENT
         * =========================================
         */

        centre.getChildren().addAll(

                heading,

                subHeading,

                storeCard

        );


        /*
         * =========================================
         * VERTICAL SCROLL
         *
         * Horizontal scrollbar = NEVER
         * Vertical scrollbar = AS NEEDED
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

        mainPane.setLeft(sideBar);

        mainPane.setTop(topBar);

        mainPane.setCenter(scrollPane);


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


        storeProfileScene = sc;

        return storeProfileScene;

    }

}

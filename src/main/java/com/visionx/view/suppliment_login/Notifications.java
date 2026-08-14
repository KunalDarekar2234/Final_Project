package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Notifications {

    private Scene notificationsScene;

    public Scene getNotificationsScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Notifications");


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
                "Search notifications..."
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

        HBox pageHeader =
                new HBox();

        pageHeader.setAlignment(
                Pos.CENTER_LEFT
        );


        VBox headingBox =
                new VBox(5);


        Text heading =
                new Text("Notifications");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text subHeading =
                new Text(
                        "Stay updated with orders, inventory and store activities."
                );

        subHeading.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-fill: #737686;"
        );


        headingBox.getChildren().addAll(
                heading,
                subHeading
        );


        Region headingSpacer =
                new Region();

        HBox.setHgrow(
                headingSpacer,
                Priority.ALWAYS
        );


        Button markAllButton =
                new Button("✓  Mark All as Read");

        markAllButton.setPrefHeight(42);

        markAllButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                markAllButton
        );


        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox unreadCard =
                createSummaryCard(
                        "●",
                        "12",
                        "Unread",
                        "#ba1a1a"
                );


        VBox orderCard =
                createSummaryCard(
                        "📦",
                        "5",
                        "Order Updates",
                        "#004ac6"
                );


        VBox inventoryCard =
                createSummaryCard(
                        "!",
                        "4",
                        "Inventory Alerts",
                        "#7a4d00"
                );


        VBox systemCard =
                createSummaryCard(
                        "⚙",
                        "3",
                        "System Updates",
                        "#006c49"
                );


        summaryBox.getChildren().addAll(
                unreadCard,
                orderCard,
                inventoryCard,
                systemCard
        );


        /*
         * =========================================
         * FILTER BAR
         * =========================================
         */

        HBox filterBox =
                new HBox(12);

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Button allButton =
                new Button("All");

        allButton.setPrefHeight(40);

        allButton.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 10;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 22;"
        );


        Button unreadButton =
                new Button("Unread");

        unreadButton.setPrefHeight(40);

        unreadButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;"
        );


        Button ordersButton =
                new Button("Orders");

        ordersButton.setPrefHeight(40);

        ordersButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;"
        );


        Button inventoryButton =
                new Button("Inventory");

        inventoryButton.setPrefHeight(40);

        inventoryButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;"
        );


        Button systemButton =
                new Button("System");

        systemButton.setPrefHeight(40);

        systemButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;"
        );


        filterBox.getChildren().addAll(
                allButton,
                unreadButton,
                ordersButton,
                inventoryButton,
                systemButton
        );


        /*
         * =========================================
         * NOTIFICATION LIST
         * =========================================
         */

        VBox notificationList =
                new VBox(15);


        /*
         * =========================================
         * ALL NOTIFICATIONS
         * =========================================
         */

        HBox orderNotification =
                createNotificationCard(
                        "📦",
                        "New Order Received",
                        "Order #ORD-1048 has been placed by Rahul Sharma.",
                        "2 minutes ago",
                        "#004ac6",
                        true
                );


        HBox inventoryNotification =
                createNotificationCard(
                        "⚠",
                        "Low Stock Alert",
                        "Whey Protein 2kg has only 8 units remaining.",
                        "18 minutes ago",
                        "#ba1a1a",
                        true
                );


        HBox deliveredNotification =
                createNotificationCard(
                        "✓",
                        "Order Delivered",
                        "Order #ORD-1042 was successfully delivered.",
                        "1 hour ago",
                        "#006c49",
                        true
                );


        HBox reviewNotification =
                createNotificationCard(
                        "★",
                        "New Customer Review",
                        "Priya Patel gave your store a 5-star review.",
                        "2 hours ago",
                        "#7a4d00",
                        false
                );


        HBox paymentNotification =
                createNotificationCard(
                        "₹",
                        "Payment Received",
                        "Payment of ₹4,299 has been successfully received.",
                        "4 hours ago",
                        "#006c49",
                        false
                );


        HBox systemNotification =
                createNotificationCard(
                        "⚙",
                        "System Update",
                        "Your store dashboard has been updated successfully.",
                        "Yesterday",
                        "#737686",
                        false
                );


        /*
         * =========================================
         * METHOD TO SHOW NOTIFICATIONS
         * =========================================
         */

        Runnable showAllNotifications = () -> {

            notificationList.getChildren().clear();

            Text title =
                    new Text("Recent Notifications");

            title.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: #111c2d;"
            );

            notificationList.getChildren().addAll(
                    title,
                    orderNotification,
                    inventoryNotification,
                    deliveredNotification,
                    reviewNotification,
                    paymentNotification,
                    systemNotification
            );
        };


        Runnable showUnreadNotifications = () -> {

            notificationList.getChildren().clear();

            Text title =
                    new Text("Unread Notifications");

            title.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: #111c2d;"
            );

            notificationList.getChildren().add(
                    title
            );

            notificationList.getChildren().addAll(
                    orderNotification,
                    inventoryNotification,
                    deliveredNotification
            );
        };


        Runnable showOrderNotifications = () -> {

            notificationList.getChildren().clear();

            Text title =
                    new Text("Order Notifications");

            title.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: #111c2d;"
            );

            notificationList.getChildren().add(
                    title
            );

            notificationList.getChildren().addAll(
                    orderNotification,
                    deliveredNotification,
                    paymentNotification
            );
        };


        Runnable showInventoryNotifications = () -> {

            notificationList.getChildren().clear();

            Text title =
                    new Text("Inventory Notifications");

            title.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: #111c2d;"
            );

            notificationList.getChildren().add(
                    title
            );

            notificationList.getChildren().add(
                    inventoryNotification
            );
        };


        Runnable showSystemNotifications = () -> {

            notificationList.getChildren().clear();

            Text title =
                    new Text("System Notifications");

            title.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: #111c2d;"
            );

            notificationList.getChildren().add(
                    title
            );

            notificationList.getChildren().add(
                    systemNotification
            );
        };


        /*
         * =========================================
         * BUTTON ACTIVE STYLE
         * =========================================
         */

        String activeStyle =
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 10;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 22;";


        String inactiveStyle =
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;";


        /*
         * =========================================
         * ALL BUTTON
         * =========================================
         */

        allButton.setOnAction(event -> {

            allButton.setStyle(activeStyle);

            unreadButton.setStyle(inactiveStyle);
            ordersButton.setStyle(inactiveStyle);
            inventoryButton.setStyle(inactiveStyle);
            systemButton.setStyle(inactiveStyle);

            showAllNotifications.run();
        });


        /*
         * =========================================
         * UNREAD BUTTON
         * =========================================
         */

        unreadButton.setOnAction(event -> {

            unreadButton.setStyle(activeStyle);

            allButton.setStyle(inactiveStyle);
            ordersButton.setStyle(inactiveStyle);
            inventoryButton.setStyle(inactiveStyle);
            systemButton.setStyle(inactiveStyle);

            showUnreadNotifications.run();
        });


        /*
         * =========================================
         * ORDERS BUTTON
         * =========================================
         */

        ordersButton.setOnAction(event -> {

            ordersButton.setStyle(activeStyle);

            allButton.setStyle(inactiveStyle);
            unreadButton.setStyle(inactiveStyle);
            inventoryButton.setStyle(inactiveStyle);
            systemButton.setStyle(inactiveStyle);

            showOrderNotifications.run();
        });


        /*
         * =========================================
         * INVENTORY BUTTON
         * =========================================
         */

        inventoryButton.setOnAction(event -> {

            inventoryButton.setStyle(activeStyle);

            allButton.setStyle(inactiveStyle);
            unreadButton.setStyle(inactiveStyle);
            ordersButton.setStyle(inactiveStyle);
            systemButton.setStyle(inactiveStyle);

            showInventoryNotifications.run();
        });


        /*
         * =========================================
         * SYSTEM BUTTON
         * =========================================
         */

        systemButton.setOnAction(event -> {

            systemButton.setStyle(activeStyle);

            allButton.setStyle(inactiveStyle);
            unreadButton.setStyle(inactiveStyle);
            ordersButton.setStyle(inactiveStyle);
            inventoryButton.setStyle(inactiveStyle);

            showSystemNotifications.run();
        });


        /*
         * =========================================
         * SHOW ALL BY DEFAULT
         * =========================================
         */

        showAllNotifications.run();


        /*
         * =========================================
         * IMPORTANT ALERT
         * =========================================
         */

        VBox alertBox =
                new VBox(10);

        alertBox.setStyle(
                "-fx-background-color: #fff7e6;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Text alertTitle =
                new Text(
                        "⚠  Important Alert"
                );

        alertTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #7a4d00;"
        );


        Text alertText =
                new Text(
                        "4 products are below their minimum stock level. " +
                        "Review your inventory and place a restocking order " +
                        "to avoid products becoming unavailable."
                );

        alertText.setWrappingWidth(1050);

        alertText.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #5f4a20;"
        );


        Button inventoryReviewButton =
                new Button("Review Inventory");

        inventoryReviewButton.setPrefHeight(38);

        inventoryReviewButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c9a85d;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;"
        );


        alertBox.getChildren().addAll(
                alertTitle,
                alertText,
                inventoryReviewButton
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

                pageHeader,

                summaryBox,

                filterBox,

                notificationList,

                alertBox,

                backButton

        );


        /*
         * =========================================
         * SCROLLPANE
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
         * SCENE
         * =========================================
         */

        Scene sc =
                new Scene(
                        mainPane,
                        1400,
                        800
                );


        notificationsScene = sc;

        return notificationsScene;

    }


    /*
     * =========================================
     * SUMMARY CARD
     * =========================================
     */

    public VBox createSummaryCard(
            String icon,
            String value,
            String title,
            String color) {

        VBox card =
                new VBox(10);

        card.setPrefWidth(240);

        card.setPrefHeight(135);

        card.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-padding: 20;"
        );


        Text iconLabel =
                new Text(icon);

        iconLabel.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-fill: " + color + ";"
        );


        Text valueLabel =
                new Text(value);

        valueLabel.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text titleLabel =
                new Text(title);

        titleLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #737686;"
        );


        card.getChildren().addAll(
                iconLabel,
                valueLabel,
                titleLabel
        );


        return card;

    }


    /*
     * =========================================
     * NOTIFICATION CARD
     * =========================================
     */

    public HBox createNotificationCard(
            String icon,
            String title,
            String description,
            String time,
            String color,
            boolean unread) {

        HBox card =
                new HBox(15);

        card.setMinHeight(95);

        card.setAlignment(
                Pos.CENTER_LEFT
        );

        card.setPadding(
                new Insets(18)
        );


        if (unread) {

            card.setStyle(
                    "-fx-background-color: #eef3ff;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #d7e2ff;" +
                    "-fx-border-radius: 18;"
            );

        } else {

            card.setStyle(
                    "-fx-background-color: rgba(255,255,255,0.90);" +
                    "-fx-background-radius: 18;"
            );

        }


        Text iconText =
                new Text(icon);

        iconText.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-fill: " + color + ";"
        );


        VBox notificationDetails =
                new VBox(5);


        Text titleText =
                new Text(title);

        titleText.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text descriptionText =
                new Text(description);

        descriptionText.setWrappingWidth(850);

        descriptionText.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #5f6372;"
        );


        Text timeText =
                new Text(time);

        timeText.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #8a8d9b;"
        );


        notificationDetails.getChildren().addAll(
                titleText,
                descriptionText,
                timeText
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button viewButton =
                new Button("View");

        viewButton.setPrefHeight(34);

        viewButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #d5d9e4;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 0 16;"
        );


        card.getChildren().addAll(
                iconText,
                notificationDetails,
                spacer,
                viewButton
        );


        return card;

    }

}

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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Orders {

    private Scene ordersScene;

    public Scene getOrdersScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Orders");


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
                        "🔍  Search orders..."
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


        topBar.getChildren().addAll(
                searchBox,
                topSpacer,
                userDetails
        );


        /*
         * =========================================
         * ORDERS CENTRE
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


        Label heading =
                new Label("Orders");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Manage customer orders, deliveries and order status."
                );

        subHeading.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: #737686;"
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


        Button exportButton =
                new Button("Export Orders");

        exportButton.setPrefHeight(42);

        exportButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                exportButton
        );


        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox totalOrdersCard =
                createSummaryCard(
                        "📦",
                        "248",
                        "Total Orders",
                        "#004ac6"
                );


        VBox pendingCard =
                createSummaryCard(
                        "◷",
                        "32",
                        "Pending",
                        "#7a4d00"
                );


        VBox shippedCard =
                createSummaryCard(
                        "✓",
                        "186",
                        "Shipped",
                        "#006c49"
                );


        VBox cancelledCard =
                createSummaryCard(
                        "×",
                        "8",
                        "Cancelled",
                        "#ba1a1a"
                );


        summaryBox.getChildren().addAll(
                totalOrdersCard,
                pendingCard,
                shippedCard,
                cancelledCard
        );


        /*
         * =========================================
         * SEARCH AND FILTER
         * =========================================
         */

        HBox filterBox =
                new HBox(12);

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );

        filterBox.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 18;"
        );


        TextField orderSearch =
                new TextField();

        orderSearch.setPromptText(
                "Search order ID, customer or product..."
        );

        orderSearch.setPrefWidth(350);

        orderSearch.setPrefHeight(40);

        orderSearch.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        Button allButton =
                new Button("All Orders");

        allButton.setPrefHeight(40);


        Button pendingButton =
                new Button("Pending");

        pendingButton.setPrefHeight(40);


        Button shippedButton =
                new Button("Shipped");

        shippedButton.setPrefHeight(40);


        Button deliveredButton =
                new Button("Delivered");

        deliveredButton.setPrefHeight(40);


        Button cancelledButton =
                new Button("Cancelled");

        cancelledButton.setPrefHeight(40);


        filterBox.getChildren().addAll(
                orderSearch,
                allButton,
                pendingButton,
                shippedButton,
                deliveredButton,
                cancelledButton
        );


        /*
         * =========================================
         * ORDERS LIST
         * =========================================
         */

        VBox orderList =
                new VBox(0);

        orderList.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        /*
         * =========================================
         * TABLE HEADER
         * =========================================
         */

        HBox tableHeader =
                new HBox();


        Label orderHeader =
                new Label("Order");

        orderHeader.setPrefWidth(150);

        orderHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label customerHeader =
                new Label("Customer");

        customerHeader.setPrefWidth(180);

        customerHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label productsHeader =
                new Label("Products");

        productsHeader.setPrefWidth(120);

        productsHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label amountHeader =
                new Label("Amount");

        amountHeader.setPrefWidth(120);

        amountHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label dateHeader =
                new Label("Date");

        dateHeader.setPrefWidth(130);

        dateHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label statusHeader =
                new Label("Status");

        statusHeader.setPrefWidth(130);

        statusHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label actionHeader =
                new Label("Action");

        actionHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        tableHeader.getChildren().addAll(
                orderHeader,
                customerHeader,
                productsHeader,
                amountHeader,
                dateHeader,
                statusHeader,
                actionHeader
        );


        /*
         * =========================================
         * SELECTED FILTER
         * =========================================
         */

        String[] selectedFilter =
                {"All Orders"};


        /*
         * =========================================
         * UPDATE ORDERS
         *
         * CATEGORY + SEARCH
         * =========================================
         */

        Runnable updateOrders = () -> {

            orderList.getChildren().clear();

            orderList.getChildren().add(
                    tableHeader
            );


            String searchText =
                    orderSearch.getText()
                            .trim()
                            .toLowerCase();


            /*
             * =====================================
             * ORDER 1048
             * =====================================
             */

            if (matchesOrder(
                    "#ORD-1048",
                    "Rahul Sharma",
                    "3 Items",
                    "₹5,499",
                    "12 Aug 2026",
                    "Delivered",
                    selectedFilter[0],
                    searchText)) {

                orderList.getChildren().add(
                        createOrderRow(
                                "#ORD-1048",
                                "Rahul Sharma",
                                "3 Items",
                                "₹5,499",
                                "12 Aug 2026",
                                "Delivered",
                                "#006c49"
                        )
                );
            }


            /*
             * =====================================
             * ORDER 1047
             * =====================================
             */

            if (matchesOrder(
                    "#ORD-1047",
                    "Priya Patel",
                    "2 Items",
                    "₹3,299",
                    "12 Aug 2026",
                    "Shipped",
                    selectedFilter[0],
                    searchText)) {

                orderList.getChildren().add(
                        createOrderRow(
                                "#ORD-1047",
                                "Priya Patel",
                                "2 Items",
                                "₹3,299",
                                "12 Aug 2026",
                                "Shipped",
                                "#004ac6"
                        )
                );
            }


            /*
             * =====================================
             * ORDER 1046
             * =====================================
             */

            if (matchesOrder(
                    "#ORD-1046",
                    "Aarav Mehta",
                    "5 Items",
                    "₹8,799",
                    "11 Aug 2026",
                    "Pending",
                    selectedFilter[0],
                    searchText)) {

                orderList.getChildren().add(
                        createOrderRow(
                                "#ORD-1046",
                                "Aarav Mehta",
                                "5 Items",
                                "₹8,799",
                                "11 Aug 2026",
                                "Pending",
                                "#7a4d00"
                        )
                );
            }


            /*
             * =====================================
             * ORDER 1045
             * =====================================
             */

            if (matchesOrder(
                    "#ORD-1045",
                    "Sneha Joshi",
                    "1 Item",
                    "₹1,899",
                    "11 Aug 2026",
                    "Delivered",
                    selectedFilter[0],
                    searchText)) {

                orderList.getChildren().add(
                        createOrderRow(
                                "#ORD-1045",
                                "Sneha Joshi",
                                "1 Item",
                                "₹1,899",
                                "11 Aug 2026",
                                "Delivered",
                                "#006c49"
                        )
                );
            }


            /*
             * =====================================
             * ORDER 1044
             * =====================================
             */

            if (matchesOrder(
                    "#ORD-1044",
                    "Vikram Singh",
                    "4 Items",
                    "₹6,450",
                    "10 Aug 2026",
                    "Cancelled",
                    selectedFilter[0],
                    searchText)) {

                orderList.getChildren().add(
                        createOrderRow(
                                "#ORD-1044",
                                "Vikram Singh",
                                "4 Items",
                                "₹6,450",
                                "10 Aug 2026",
                                "Cancelled",
                                "#ba1a1a"
                        )
                );
            }


            /*
             * =====================================
             * ORDER 1043
             * =====================================
             */

            if (matchesOrder(
                    "#ORD-1043",
                    "Neha Kulkarni",
                    "2 Items",
                    "₹3,999",
                    "10 Aug 2026",
                    "Shipped",
                    selectedFilter[0],
                    searchText)) {

                orderList.getChildren().add(
                        createOrderRow(
                                "#ORD-1043",
                                "Neha Kulkarni",
                                "2 Items",
                                "₹3,999",
                                "10 Aug 2026",
                                "Shipped",
                                "#004ac6"
                        )
                );
            }
        };


        /*
         * =========================================
         * BUTTON STYLES
         * =========================================
         */

        String normalStyle =
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 20;";


        String selectedStyle =
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 10;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 20;";


        /*
         * =========================================
         * ALL ORDERS
         * =========================================
         */

        allButton.setStyle(
                selectedStyle
        );

        allButton.setOnAction(event -> {

            selectedFilter[0] =
                    "All Orders";

            allButton.setStyle(
                    selectedStyle
            );

            pendingButton.setStyle(
                    normalStyle
            );

            shippedButton.setStyle(
                    normalStyle
            );

            deliveredButton.setStyle(
                    normalStyle
            );

            cancelledButton.setStyle(
                    normalStyle
            );

            updateOrders.run();
        });


        /*
         * =========================================
         * PENDING
         * =========================================
         */

        pendingButton.setStyle(
                normalStyle
        );

        pendingButton.setOnAction(event -> {

            selectedFilter[0] =
                    "Pending";

            allButton.setStyle(
                    normalStyle
            );

            pendingButton.setStyle(
                    selectedStyle
            );

            shippedButton.setStyle(
                    normalStyle
            );

            deliveredButton.setStyle(
                    normalStyle
            );

            cancelledButton.setStyle(
                    normalStyle
            );

            updateOrders.run();
        });


        /*
         * =========================================
         * SHIPPED
         * =========================================
         */

        shippedButton.setStyle(
                normalStyle
        );

        shippedButton.setOnAction(event -> {

            selectedFilter[0] =
                    "Shipped";

            allButton.setStyle(
                    normalStyle
            );

            pendingButton.setStyle(
                    normalStyle
            );

            shippedButton.setStyle(
                    selectedStyle
            );

            deliveredButton.setStyle(
                    normalStyle
            );

            cancelledButton.setStyle(
                    normalStyle
            );

            updateOrders.run();
        });


        /*
         * =========================================
         * DELIVERED
         * =========================================
         */

        deliveredButton.setStyle(
                normalStyle
        );

        deliveredButton.setOnAction(event -> {

            selectedFilter[0] =
                    "Delivered";

            allButton.setStyle(
                    normalStyle
            );

            pendingButton.setStyle(
                    normalStyle
            );

            shippedButton.setStyle(
                    normalStyle
            );

            deliveredButton.setStyle(
                    selectedStyle
            );

            cancelledButton.setStyle(
                    normalStyle
            );

            updateOrders.run();
        });


        /*
         * =========================================
         * CANCELLED
         * =========================================
         */

        cancelledButton.setStyle(
                normalStyle
        );

        cancelledButton.setOnAction(event -> {

            selectedFilter[0] =
                    "Cancelled";

            allButton.setStyle(
                    normalStyle
            );

            pendingButton.setStyle(
                    normalStyle
            );

            shippedButton.setStyle(
                    normalStyle
            );

            deliveredButton.setStyle(
                    normalStyle
            );

            cancelledButton.setStyle(
                    selectedStyle
            );

            updateOrders.run();
        });


        /*
         * =========================================
         * SEARCH FUNCTIONALITY
         *
         * SEARCH + CATEGORY
         * =========================================
         */

        orderSearch.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    updateOrders.run();

                }
        );


        /*
         * =========================================
         * INITIAL DISPLAY
         * =========================================
         */

        updateOrders.run();


        /*
         * =========================================
         * AI ORDER INSIGHT
         * =========================================
         */

        VBox aiInsight =
                new VBox(10);

        aiInsight.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 20;"
        );


        Label aiTitle =
                new Label(
                        "🧠  AI Order Insight"
                );

        aiTitle.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label aiText =
                new Label(
                        "Orders are performing well today. " +
                        "Protein products are currently the most frequently " +
                        "ordered category. Consider keeping popular products " +
                        "well stocked to avoid delivery delays."
                );

        aiText.setWrapText(true);

        aiText.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #434655;"
        );


        aiInsight.getChildren().addAll(
                aiTitle,
                aiText
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

                orderList,

                aiInsight,

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


        ordersScene = sc;

        return ordersScene;

    }


    /*
     * =========================================
     * FILTER + SEARCH CHECK
     * =========================================
     */

    private boolean matchesOrder(
            String order,
            String customer,
            String products,
            String amount,
            String date,
            String status,
            String selectedFilter,
            String searchText) {


        /*
         * =====================================
         * SEARCH CHECK
         *
         * Search can match:
         * Order ID
         * Customer
         * Products
         * Amount
         * Date
         * Status
         * =====================================
         */

        String searchableText =
                (
                        order + " " +
                        customer + " " +
                        products + " " +
                        amount + " " +
                        date + " " +
                        status
                ).toLowerCase();


        boolean searchMatches =
                searchText.isEmpty()
                ||
                searchableText.contains(
                        searchText
                );


        if (!searchMatches) {

            return false;

        }


        /*
         * =====================================
         * ALL ORDERS
         * =====================================
         */

        if (selectedFilter.equals(
                "All Orders")) {

            return true;

        }


        /*
         * =====================================
         * PENDING
         * =====================================
         */

        if (selectedFilter.equals(
                "Pending")) {

            return status.equals(
                    "Pending"
            );

        }


        /*
         * =====================================
         * SHIPPED
         * =====================================
         */

        if (selectedFilter.equals(
                "Shipped")) {

            return status.equals(
                    "Shipped"
            );

        }


        /*
         * =====================================
         * DELIVERED
         * =====================================
         */

        if (selectedFilter.equals(
                "Delivered")) {

            return status.equals(
                    "Delivered"
            );

        }


        /*
         * =====================================
         * CANCELLED
         * =====================================
         */

        if (selectedFilter.equals(
                "Cancelled")) {

            return status.equals(
                    "Cancelled"
            );

        }


        return false;
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


        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 8;" +
                "-fx-font-size: 17px;" +
                "-fx-text-fill: " + color + ";"
        );


        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
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
     * ORDER ROW
     * =========================================
     */

    public HBox createOrderRow(
            String order,
            String customer,
            String products,
            String amount,
            String date,
            String status,
            String color) {

        HBox row =
                new HBox();

        row.setPrefHeight(70);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-border-color: #eef0f5;" +
                "-fx-border-width: 0 0 1 0;"
        );


        /*
         * ORDER
         */

        Label orderLabel =
                new Label(order);

        orderLabel.setPrefWidth(150);

        orderLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        /*
         * CUSTOMER
         */

        Label customerLabel =
                new Label(customer);

        customerLabel.setPrefWidth(180);

        customerLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * PRODUCTS
         */

        Label productsLabel =
                new Label(products);

        productsLabel.setPrefWidth(120);

        productsLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * AMOUNT
         */

        Label amountLabel =
                new Label(amount);

        amountLabel.setPrefWidth(120);

        amountLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * DATE
         */

        Label dateLabel =
                new Label(date);

        dateLabel.setPrefWidth(130);

        dateLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * STATUS
         */

        Label statusLabel =
                new Label(status);

        statusLabel.setPrefWidth(130);

        statusLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 15;" +
                "-fx-padding: 6 12;" +
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        /*
         * ACTION
         */

        Button viewButton =
                new Button("View");

        viewButton.setPrefHeight(32);

        viewButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 0 15;"
        );


        row.getChildren().addAll(
                orderLabel,
                customerLabel,
                productsLabel,
                amountLabel,
                dateLabel,
                statusLabel,
                viewButton
        );


        return row;

    }

}
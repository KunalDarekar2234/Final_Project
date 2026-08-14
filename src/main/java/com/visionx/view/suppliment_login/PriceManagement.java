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

public class PriceManagement {

    private Scene priceManagementScene;
    private Runnable callBackAction;

    /*
     * =========================================
     * SUMMARY VALUES
     * =========================================
     */

    private Label totalProductsValue;
    private Label priceChangesValue;
    private Label discountsValue;
    private Label priceAlertsValue;


    /*
     * =========================================
     * PRODUCT DATA
     *
     * SINGLE SOURCE OF DATA
     *
     * [0] Product Name
     * [1] Old Price
     * [2] Current Price
     * [3] Change
     * [4] Type
     * =========================================
     */

    private String[][] products = {

            {
                    "Ultra Whey Pro",
                    "₹3,999",
                    "₹4,199",
                    "+5%",
                    "increase"
            },

            {
                    "Daily Multivit",
                    "₹2,499",
                    "₹2,299",
                    "-8%",
                    "decrease"
            },

            {
                    "Ignite Pre-Workout",
                    "₹3,199",
                    "₹3,399",
                    "+6%",
                    "increase"
            },

            {
                    "Creatine Monohydrate",
                    "₹2,999",
                    "₹2,999",
                    "0%",
                    "discount"
            },

            {
                    "Omega 3 Plus",
                    "₹1,999",
                    "₹1,899",
                    "-5%",
                    "decrease"
            },

            {
                    "BCAA Recovery",
                    "₹2,699",
                    "₹2,799",
                    "+4%",
                    "increase"
            }
    };


    public Scene getPriceManagementScene(
            Runnable callBackAction) {


        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Price Management");


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
                        "🔍  Search products..."
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
         * PRICE MANAGEMENT CENTRE
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
         *
         * THIS PART NEVER CHANGES
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
                new Label("Price Management");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Manage product prices, discounts and pricing changes."
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


        /*
         * =========================================
         * UPDATE PRICES BUTTON
         * =========================================
         */

        Button updateAllButton =
                new Button("Update Prices");

        updateAllButton.setPrefHeight(42);

        updateAllButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                updateAllButton
        );


        /*
         * =========================================
         * SCROLLPANE
         *
         * SAME SCROLLPANE IS USED FOR BOTH
         * NORMAL PAGE AND UPDATE PAGE
         * =========================================
         */

        VBox contentBox =
                new VBox(25);

        contentBox.setPadding(
                new Insets(0)
        );


        ScrollPane scrollPane =
                new ScrollPane(contentBox);

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

        /*
         * Header remains fixed.
         * Only content below header changes.
         */

        VBox centreContainer =
                new VBox();

        centreContainer.setStyle(
                "-fx-background-color: #f9f9ff;"
        );

        centreContainer.getChildren().addAll(
                pageHeader,
                scrollPane
        );

        mainPane.setCenter(
                centreContainer
        );


        /*
         * =========================================
         * LOAD NORMAL PRICE MANAGEMENT PAGE
         * =========================================
         */

        Runnable showNormalPage =
                () -> {

                    contentBox.getChildren().clear();

                    VBox normalContent =
                            createNormalPriceManagementContent(
                                    contentBox
                            );

                    contentBox.getChildren().addAll(
                            normalContent.getChildren()
                    );

                    scrollPane.setVvalue(0);
                };


        /*
         * =========================================
         * UPDATE PRICES BUTTON ACTION
         * =========================================
         */

        updateAllButton.setOnAction(
                event -> {

                    contentBox.getChildren().clear();

                    VBox updatePage =
                            createUpdatePricesPage(
                                    showNormalPage
                            );

                    contentBox.getChildren().addAll(
                            updatePage.getChildren()
                    );

                    scrollPane.setVvalue(0);
                }
        );


        /*
         * =========================================
         * INITIAL PAGE
         * =========================================
         */

        showNormalPage.run();


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


        priceManagementScene =
                sc;

        return priceManagementScene;
    }


    /*
     * =========================================
     * NORMAL PRICE MANAGEMENT CONTENT
     * =========================================
     */

    private VBox createNormalPriceManagementContent(
            VBox contentBox) {


        VBox normalContent =
                new VBox(25);


        /*
         * =========================================
         * PRICE SUMMARY
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox totalProductsCard =
                createSummaryCard(
                        "₹",
                        "0",
                        "Products",
                        "#004ac6"
                );


        VBox priceChangesCard =
                createSummaryCard(
                        "↕",
                        "0",
                        "Price Changes",
                        "#006c49"
                );


        VBox discountsCard =
                createSummaryCard(
                        "%",
                        "0",
                        "Active Discounts",
                        "#7a4d00"
                );


        VBox alertsCard =
                createSummaryCard(
                        "!",
                        "0",
                        "Price Alerts",
                        "#ba1a1a"
                );


        totalProductsValue =
                (Label) totalProductsCard
                        .getChildren()
                        .get(1);


        priceChangesValue =
                (Label) priceChangesCard
                        .getChildren()
                        .get(1);


        discountsValue =
                (Label) discountsCard
                        .getChildren()
                        .get(1);


        priceAlertsValue =
                (Label) alertsCard
                        .getChildren()
                        .get(1);


        summaryBox.getChildren().addAll(
                totalProductsCard,
                priceChangesCard,
                discountsCard,
                alertsCard
        );


        /*
         * =========================================
         * SEARCH / FILTER
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


        TextField priceSearch =
                new TextField();

        priceSearch.setPromptText(
                "Search product..."
        );

        priceSearch.setPrefWidth(350);

        priceSearch.setPrefHeight(40);

        priceSearch.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        Button allButton =
                new Button("All Products");

        allButton.setPrefHeight(40);


        Button increaseButton =
                new Button("Price Increase");

        increaseButton.setPrefHeight(40);


        Button decreaseButton =
                new Button("Price Decrease");

        decreaseButton.setPrefHeight(40);


        Button discountButton =
                new Button("Discounts");

        discountButton.setPrefHeight(40);


        filterBox.getChildren().addAll(
                priceSearch,
                allButton,
                increaseButton,
                decreaseButton,
                discountButton
        );


        /*
         * =========================================
         * PRICE LIST
         * =========================================
         */

        VBox priceList =
                new VBox(0);

        priceList.setStyle(
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


        Label productHeader =
                new Label("Product");

        productHeader.setPrefWidth(260);

        productHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label oldPriceHeader =
                new Label("Old Price");

        oldPriceHeader.setPrefWidth(130);

        oldPriceHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label newPriceHeader =
                new Label("Current Price");

        newPriceHeader.setPrefWidth(150);

        newPriceHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label changeHeader =
                new Label("Change");

        changeHeader.setPrefWidth(130);

        changeHeader.setStyle(
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
                productHeader,
                oldPriceHeader,
                newPriceHeader,
                changeHeader,
                actionHeader
        );


        /*
         * =========================================
         * SELECTED FILTER
         * =========================================
         */

        final String[] selectedFilter = {
                "all"
        };


        /*
         * =========================================
         * REFRESH PRODUCTS
         * =========================================
         */

        Runnable refreshProducts =
                () -> {

                    priceList.getChildren().clear();

                    priceList.getChildren().add(
                            tableHeader
                    );


                    String searchText =
                            priceSearch.getText()
                                    .trim()
                                    .toLowerCase();


                    for (String[] product : products) {

                        String productName =
                                product[0];

                        String type =
                                product[4];


                        boolean searchMatch =
                                productName
                                        .toLowerCase()
                                        .contains(searchText);


                        boolean filterMatch =
                                selectedFilter[0]
                                        .equals("all")
                                ||
                                selectedFilter[0]
                                        .equals(type);


                        if (searchMatch &&
                                filterMatch) {


                            String color =
                                    "#737686";


                            if (type.equals("increase")) {

                                color =
                                        "#ba1a1a";

                            } else if (
                                    type.equals("decrease")) {

                                color =
                                        "#006c49";

                            } else if (
                                    type.equals("discount")) {

                                color =
                                        "#7a4d00";
                            }


                            priceList.getChildren().add(
                                    createPriceRow(
                                            product[0],
                                            product[1],
                                            product[2],
                                            product[3],
                                            color
                                    )
                            );
                        }
                    }
                };


        /*
         * =========================================
         * BUTTON STYLES
         * =========================================
         */

        Runnable updateButtonStyle =
                () -> {

                    String activeStyle =
                            "-fx-background-color: #eef3ff;" +
                            "-fx-text-fill: #004ac6;" +
                            "-fx-background-radius: 10;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 0 18;";


                    String normalStyle =
                            "-fx-background-color: white;" +
                            "-fx-border-color: #dfe2ec;" +
                            "-fx-border-radius: 10;" +
                            "-fx-background-radius: 10;" +
                            "-fx-padding: 0 18;";


                    allButton.setStyle(
                            normalStyle
                    );

                    increaseButton.setStyle(
                            normalStyle
                    );

                    decreaseButton.setStyle(
                            normalStyle
                    );

                    discountButton.setStyle(
                            normalStyle
                    );


                    if (selectedFilter[0]
                            .equals("all")) {

                        allButton.setStyle(
                                activeStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("increase")) {

                        increaseButton.setStyle(
                                activeStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("decrease")) {

                        decreaseButton.setStyle(
                                activeStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("discount")) {

                        discountButton.setStyle(
                                activeStyle
                        );
                    }
                };


        /*
         * =========================================
         * ALL PRODUCTS
         * =========================================
         */

        allButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "all";

                    updateButtonStyle.run();

                    refreshProducts.run();
                }
        );


        /*
         * =========================================
         * PRICE INCREASE
         * =========================================
         */

        increaseButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "increase";

                    updateButtonStyle.run();

                    refreshProducts.run();
                }
        );


        /*
         * =========================================
         * PRICE DECREASE
         * =========================================
         */

        decreaseButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "decrease";

                    updateButtonStyle.run();

                    refreshProducts.run();
                }
        );


        /*
         * =========================================
         * DISCOUNTS
         * =========================================
         */

        discountButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "discount";

                    updateButtonStyle.run();

                    refreshProducts.run();
                }
        );


        /*
         * =========================================
         * SEARCH
         * =========================================
         */

        priceSearch.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    refreshProducts.run();
                }
        );


        /*
         * =========================================
         * SUMMARY
         * =========================================
         */

        updateSummaryCards(products);


        /*
         * =========================================
         * INITIAL LOAD
         * =========================================
         */

        updateButtonStyle.run();

        refreshProducts.run();


        /*
         * =========================================
         * AI PRICE INSIGHT
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
                        "🧠  AI Pricing Insight"
                );

        aiTitle.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label aiText =
                new Label(
                        "Based on recent sales and inventory levels, " +
                        "Ultra Whey Pro has room for a small price increase. " +
                        "Daily Multivit may benefit from its current lower price."
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
         * BACK TO DASHBOARD
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


        backButton.setOnAction(
                event -> {

                    System.out.println(
                            "Back Button Clicked"
                    );

                    if (callBackAction != null) {

                        callBackAction.run();
                    }
                }
        );


        /*
         * =========================================
         * ADD NORMAL CONTENT
         * =========================================
         */

        normalContent.getChildren().addAll(

                summaryBox,

                filterBox,

                priceList,

                aiInsight,

                backButton
        );


        return normalContent;
    }


    /*
     * =========================================
     * UPDATE PRICES PAGE
     * =========================================
     */

    private VBox createUpdatePricesPage(
            Runnable backAction) {


        VBox updateContent =
                new VBox(25);


        /*
         * =========================================
         * PAGE INTRO
         * =========================================
         */

        VBox introBox =
                new VBox(8);

        introBox.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Label introTitle =
                new Label(
                        "Update Product Prices"
                );

        introTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label introText =
                new Label(
                        "Review and update the current selling price " +
                        "of your products. Changes will be reflected " +
                        "in the Price Management page."
                );

        introText.setWrapText(true);

        introText.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #737686;"
        );


        introBox.getChildren().addAll(
                introTitle,
                introText
        );


        /*
         * =========================================
         * PRODUCT UPDATE LIST
         * =========================================
         */

        VBox updateList =
                new VBox(15);

        updateList.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label listTitle =
                new Label(
                        "Product Pricing"
                );

        listTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        updateList.getChildren().add(
                listTitle
        );


        /*
         * =========================================
         * CREATE INPUTS FOR EACH PRODUCT
         * =========================================
         */

        TextField[] priceFields =
                new TextField[products.length];


        for (int i = 0;
             i < products.length;
             i++) {


            final int index =
                    i;


            HBox productBox =
                    new HBox(20);

            productBox.setAlignment(
                    Pos.CENTER_LEFT
            );

            productBox.setPrefHeight(75);

            productBox.setStyle(
                    "-fx-border-color: #eef0f5;" +
                    "-fx-border-width: 0 0 1 0;" +
                    "-fx-padding: 8 0;"
            );


            /*
             * PRODUCT NAME
             */

            VBox productDetails =
                    new VBox(5);

            productDetails.setPrefWidth(280);


            Label productName =
                    new Label(
                            products[i][0]
                    );

            productName.setStyle(
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: #111c2d;"
            );


            Label oldPrice =
                    new Label(
                            "Previous price: " +
                            products[i][1]
                    );

            oldPrice.setStyle(
                    "-fx-font-size: 11px;" +
                    "-fx-text-fill: #737686;"
            );


            productDetails.getChildren().addAll(
                    productName,
                    oldPrice
            );


            /*
             * CURRENT PRICE INPUT
             */

            VBox priceBox =
                    new VBox(5);

            priceBox.setPrefWidth(210);


            Label priceLabel =
                    new Label(
                            "Current Price"
                    );

            priceLabel.setStyle(
                    "-fx-font-size: 11px;" +
                    "-fx-text-fill: #737686;"
            );


            TextField priceField =
                    new TextField();

            priceField.setPrefWidth(190);

            priceField.setPrefHeight(38);

            priceField.setText(
                    products[i][2]
                            .replace("₹", "")
                            .replace(",", "")
            );

            priceField.setStyle(
                    "-fx-background-color: #f7f8fc;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-color: #dfe2ec;" +
                    "-fx-border-radius: 10;" +
                    "-fx-padding: 0 12;" +
                    "-fx-font-size: 13px;"
            );


            priceFields[i] =
                    priceField;


            priceBox.getChildren().addAll(
                    priceLabel,
                    priceField
            );


            /*
             * SAVE INDIVIDUAL PRICE
             */

            Button saveButton =
                    new Button("Save Price");

            saveButton.setPrefHeight(36);

            saveButton.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #c3c6d7;" +
                    "-fx-border-radius: 8;" +
                    "-fx-background-radius: 8;" +
                    "-fx-padding: 0 15;"
            );


            Label messageLabel =
                    new Label();

            messageLabel.setStyle(
                    "-fx-font-size: 11px;" +
                    "-fx-text-fill: #006c49;"
            );


            saveButton.setOnAction(
                    event -> {

                        String enteredPrice =
                                priceField
                                        .getText()
                                        .trim();


                        double newPrice =
                                convertPrice(
                                        enteredPrice
                                );


                        if (newPrice <= 0) {

                            messageLabel.setText(
                                    "Enter a valid price"
                            );

                            messageLabel.setStyle(
                                    "-fx-font-size: 11px;" +
                                    "-fx-text-fill: #ba1a1a;"
                            );

                            return;
                        }


                        /*
                         * Save the new price
                         */

                        products[index][2] =
                                formatPrice(
                                        newPrice
                                );


                        /*
                         * Recalculate percentage
                         */

                        updateProductChange(
                                index
                        );


                        messageLabel.setText(
                                "Price saved"
                        );

                        messageLabel.setStyle(
                                "-fx-font-size: 11px;" +
                                "-fx-text-fill: #006c49;"
                        );
                    }
            );


            VBox actionBox =
                    new VBox(5);

            actionBox.setAlignment(
                    Pos.CENTER_LEFT
            );

            actionBox.setPrefWidth(130);


            actionBox.getChildren().addAll(
                    saveButton,
                    messageLabel
            );


            productBox.getChildren().addAll(
                    productDetails,
                    priceBox,
                    actionBox
            );


            updateList.getChildren().add(
                    productBox
            );
        }


        /*
         * =========================================
         * SAVE ALL CHANGES
         * =========================================
         */

        Button saveAllButton =
                new Button(
                        "✓  Save All Changes"
                );

        saveAllButton.setPrefHeight(42);

        saveAllButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        Label saveAllMessage =
                new Label();


        saveAllMessage.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #006c49;"
        );


        saveAllButton.setOnAction(
                event -> {

                    boolean valid =
                            true;


                    /*
                     * First validate all prices
                     */

                    for (int i = 0;
                         i < priceFields.length;
                         i++) {


                        String value =
                                priceFields[i]
                                        .getText()
                                        .trim();


                        double newPrice =
                                convertPrice(
                                        value
                                );


                        if (newPrice <= 0) {

                            valid =
                                    false;

                            break;
                        }
                    }


                    if (!valid) {

                        saveAllMessage.setText(
                                "Please enter valid prices for all products."
                        );

                        saveAllMessage.setStyle(
                                "-fx-font-size: 12px;" +
                                "-fx-text-fill: #ba1a1a;"
                        );

                        return;
                    }


                    /*
                     * Save all prices
                     */

                    for (int i = 0;
                         i < priceFields.length;
                         i++) {


                        double newPrice =
                                convertPrice(
                                        priceFields[i]
                                                .getText()
                                                .trim()
                                );


                        products[i][2] =
                                formatPrice(
                                        newPrice
                                );


                        updateProductChange(
                                i
                        );
                    }


                    saveAllMessage.setText(
                            "✓ All product prices updated successfully."
                    );

                    saveAllMessage.setStyle(
                            "-fx-font-size: 12px;" +
                            "-fx-text-fill: #006c49;"
                    );
                }
        );


        /*
         * =========================================
         * SAVE AREA
         * =========================================
         */

        HBox saveArea =
                new HBox(15);

        saveArea.setAlignment(
                Pos.CENTER_LEFT
        );

        saveArea.setPadding(
                new Insets(5, 0, 5, 0)
        );


        saveArea.getChildren().addAll(
                saveAllButton,
                saveAllMessage
        );


        /*
         * =========================================
         * BACK BUTTON
         * =========================================
         */

        Button backButton =
                new Button(
                        "←  Back to Price Management"
                );

        backButton.setPrefHeight(40);

        backButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 18;"
        );


        backButton.setOnAction(
                event -> {

                    backAction.run();
                }
        );


        /*
         * =========================================
         * INFORMATION BOX
         * =========================================
         */

        VBox infoBox =
                new VBox(8);

        infoBox.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 20;"
        );


        Label infoTitle =
                new Label(
                        "💡 Pricing Information"
                );

        infoTitle.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label infoText =
                new Label(
                        "Use the fields above to update product prices. " +
                        "The previous price is shown for reference. " +
                        "After saving, the updated price and percentage " +
                        "change will be reflected in Price Management."
                );

        infoText.setWrapText(true);

        infoText.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #434655;"
        );


        infoBox.getChildren().addAll(
                infoTitle,
                infoText
        );


        /*
         * =========================================
         * ADD UPDATE PAGE CONTENT
         * =========================================
         */

        updateContent.getChildren().addAll(

                introBox,

                updateList,

                saveArea,

                infoBox,

                backButton
        );


        return updateContent;
    }


    /*
     * =========================================
     * UPDATE PRODUCT CHANGE
     * =========================================
     */

    private void updateProductChange(
            int index) {


        double oldValue =
                convertPrice(
                        products[index][1]
                );


        double currentValue =
                convertPrice(
                        products[index][2]
                );


        if (oldValue <= 0) {

            products[index][3] =
                    "0%";

            products[index][4] =
                    "discount";

            return;
        }


        double percentage =
                (
                        (currentValue - oldValue)
                        / oldValue
                        * 100
                );


        /*
         * Round percentage
         */

        long rounded =
                Math.round(
                        percentage
                );


        if (rounded > 0) {

            products[index][3] =
                    "+" + rounded + "%";

            products[index][4] =
                    "increase";

        } else if (rounded < 0) {

            products[index][3] =
                    rounded + "%";

            products[index][4] =
                    "decrease";

        } else {

            products[index][3] =
                    "0%";

            products[index][4] =
                    "discount";
        }
    }


    /*
     * =========================================
     * FORMAT PRICE
     * =========================================
     */

    private String formatPrice(
            double price) {


        if (price == Math.floor(price)) {

            return "₹" +
                    String.format(
                            "%,.0f",
                            price
                    );

        }


        return "₹" +
                String.format(
                        "%,.2f",
                        price
                );
    }


    /*
     * =========================================
     * UPDATE SUMMARY CARDS
     * =========================================
     */

    private void updateSummaryCards(
            String[][] products) {


        int totalProducts =
                products.length;


        int priceChanges =
                0;


        int activeDiscounts =
                0;


        int priceAlerts =
                0;


        for (String[] product :
                products) {


            String oldPrice =
                    product[1];


            String currentPrice =
                    product[2];


            String type =
                    product[4];


            /*
             * PRICE CHANGES
             */

            if (type.equals("increase")
                    ||
                    type.equals("decrease")) {

                priceChanges++;
            }


            /*
             * ACTIVE DISCOUNTS
             */

            if (type.equals("discount")) {

                activeDiscounts++;
            }


            /*
             * PRICE ALERT
             */

            double oldValue =
                    convertPrice(
                            oldPrice
                    );


            double currentValue =
                    convertPrice(
                            currentPrice
                    );


            if (oldValue > 0) {

                double percentageChange =
                        Math.abs(
                                (
                                        currentValue
                                        -
                                        oldValue
                                )
                                /
                                oldValue
                                * 100
                        );


                if (percentageChange >= 5) {

                    priceAlerts++;
                }
            }
        }


        /*
         * UPDATE UI
         */

        if (totalProductsValue != null) {

            totalProductsValue.setText(
                    String.valueOf(
                            totalProducts
                    )
            );
        }


        if (priceChangesValue != null) {

            priceChangesValue.setText(
                    String.valueOf(
                            priceChanges
                    )
            );
        }


        if (discountsValue != null) {

            discountsValue.setText(
                    String.valueOf(
                            activeDiscounts
                    )
            );
        }


        if (priceAlertsValue != null) {

            priceAlertsValue.setText(
                    String.valueOf(
                            priceAlerts
                    )
            );
        }
    }


    /*
     * =========================================
     * CONVERT ₹ PRICE TO NUMBER
     * =========================================
     */

    private double convertPrice(
            String price) {


        try {

            return Double.parseDouble(
                    price
                            .replace("₹", "")
                            .replace(",", "")
                            .trim()
            );

        } catch (Exception e) {

            return 0;
        }
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
     * PRICE ROW
     * =========================================
     */

    public HBox createPriceRow(
            String product,
            String oldPrice,
            String currentPrice,
            String change,
            String color) {


        HBox row =
                new HBox();

        row.setPrefHeight(65);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-border-color: #eef0f5;" +
                "-fx-border-width: 0 0 1 0;"
        );


        /*
         * PRODUCT
         */

        Label productLabel =
                new Label(product);

        productLabel.setPrefWidth(260);

        productLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * OLD PRICE
         */

        Label oldPriceLabel =
                new Label(oldPrice);

        oldPriceLabel.setPrefWidth(130);

        oldPriceLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * CURRENT PRICE
         */

        Label currentPriceLabel =
                new Label(currentPrice);

        currentPriceLabel.setPrefWidth(150);

        currentPriceLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * PRICE CHANGE
         */

        Label changeLabel =
                new Label(change);

        changeLabel.setPrefWidth(130);

        changeLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 15;" +
                "-fx-padding: 6 12;" +
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        /*
         * EDIT BUTTON
         */

        Button editButton =
                new Button("Edit Price");

        editButton.setPrefHeight(32);

        editButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 0 15;"
        );


        /*
         * EDIT PRICE BUTTON
         *
         * For now it opens the same
         * Update Prices page.
         *
         * The main Update Prices button
         * is handled separately.
         */

        editButton.setOnAction(
                event -> {

                    System.out.println(
                            "Edit Price clicked for: "
                                    + product
                    );
                }
        );


        row.getChildren().addAll(
                productLabel,
                oldPriceLabel,
                currentPriceLabel,
                changeLabel,
                editButton
        );


        return row;
    }

}
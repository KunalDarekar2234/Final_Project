package com.visionx.view.suppliment_login;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private Scene productsScene;

    private VBox centre;

    private GridPane productGrid;

    private Label productCount;

    private TextField productSearch;

    private Button allButton;
    private Button proteinButton;
    private Button vitaminButton;
    private Button energyButton;

    /*
     * Current selected category
     */
    private String selectedCategory = "All";


    /*
     * =========================================
     * PRODUCT DATA
     * =========================================
     *
     * product[0] = Product Name
     * product[1] = Category
     * product[2] = Price
     * product[3] = Stock
     *
     */

    private List<String[]> products =
            new ArrayList<>();


    public Scene getProductsScene(
            Runnable callBackAction) {


        /*
         * =========================================
         * LOAD INITIAL PRODUCTS
         * =========================================
         */

        loadInitialProducts();


        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Products");


        /*
         * =========================================
         * TOP BAR
         * =========================================
         */

        HBox topBar =
                new HBox();

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


        Label searchTop =
                new Label(
                        "🔍  Search analytics or products..."
                );

        searchTop.setPrefWidth(430);

        searchTop.setPrefHeight(40);

        searchTop.setAlignment(
                Pos.CENTER_LEFT
        );

        searchTop.setStyle(
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
                new Label(
                        "Alex Rivera"
                );

        userName.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label userType =
                new Label(
                        "STORE OWNER"
                );

        userType.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-text-fill: #737686;"
        );


        userDetails.getChildren().addAll(
                userName,
                userType
        );


        topBar.getChildren().addAll(
                searchTop,
                topSpacer,
                userDetails
        );


        /*
         * =========================================
         * CENTRE
         * =========================================
         */

        centre =
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
                new Label(
                        "Products"
                );

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Manage your supplement products, pricing and availability."
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


        Button addProductButton =
                new Button(
                        "+  Add Product"
                );

        addProductButton.setPrefHeight(
                42
        );

        addProductButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                addProductButton
        );


        /*
         * =========================================
         * ORIGINAL PRODUCTS CONTENT
         * =========================================
         */

        VBox productsContent =
                createProductsContent();


        /*
         * =========================================
         * ADD PRODUCT BUTTON
         * =========================================
         */

        addProductButton.setOnAction(
                event -> {

                    showAddProductPage(
                            pageHeader,
                            productsContent
                    );

                }
        );


        /*
         * =========================================
         * INITIAL CENTRE CONTENT
         * =========================================
         */

        centre.getChildren().addAll(
                pageHeader,
                productsContent
        );


        /*
         * =========================================
         * SCROLL PANE
         * =========================================
         */

        ScrollPane scrollPane =
                new ScrollPane(
                        centre
                );

        scrollPane.setFitToWidth(
                true
        );

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
         * MAIN PANE
         * =========================================
         */

        BorderPane mainPane =
                new BorderPane();


        /*
         * COMMON SIDEBAR
         */

        mainPane.setLeft(
                sideBar
        );


        /*
         * TOP BAR
         */

        mainPane.setTop(
                topBar
        );


        /*
         * CENTRE SCROLL
         */

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

        productsScene =
                sc;

        return productsScene;

    }


    /*
     * =========================================
     * LOAD INITIAL PRODUCTS
     * =========================================
     */

    private void loadInitialProducts() {

        products.clear();


        products.add(
                new String[]{
                        "Ultra Whey Pro",
                        "Proteins",
                        "$49.99",
                        "428 in stock"
                }
        );


        products.add(
                new String[]{
                        "Daily Multivit",
                        "Vitamins",
                        "$29.99",
                        "315 in stock"
                }
        );


        products.add(
                new String[]{
                        "Ignite Pre-Workout",
                        "Energy",
                        "$39.99",
                        "284 in stock"
                }
        );


        products.add(
                new String[]{
                        "Creatine Monohydrate",
                        "Proteins",
                        "$34.99",
                        "198 in stock"
                }
        );


        products.add(
                new String[]{
                        "Omega 3 Plus",
                        "Vitamins",
                        "$24.99",
                        "176 in stock"
                }
        );


        products.add(
                new String[]{
                        "BCAA Recovery",
                        "Energy",
                        "$31.99",
                        "142 in stock"
                }
        );

    }


    /*
     * =========================================
     * CREATE ORIGINAL PRODUCTS CONTENT
     * =========================================
     */

    private VBox createProductsContent() {


        VBox content =
                new VBox(25);


        /*
         * =========================================
         * FILTER BOX
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


        /*
         * SEARCH FIELD
         */

        productSearch =
                new TextField();

        productSearch.setPromptText(
                "Search products..."
        );

        productSearch.setPrefWidth(
                350
        );

        productSearch.setPrefHeight(
                40
        );

        productSearch.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        /*
         * =========================================
         * CATEGORY BUTTONS
         * =========================================
         */

        allButton =
                new Button(
                        "All Products"
                );

        proteinButton =
                new Button(
                        "Proteins"
                );

        vitaminButton =
                new Button(
                        "Vitamins"
                );

        energyButton =
                new Button(
                        "Energy"
                );


        allButton.setPrefHeight(
                40
        );

        proteinButton.setPrefHeight(
                40
        );

        vitaminButton.setPrefHeight(
                40
        );

        energyButton.setPrefHeight(
                40
        );


        setActiveButton(
                allButton
        );


        filterBox.getChildren().addAll(
                productSearch,
                allButton,
                proteinButton,
                vitaminButton,
                energyButton
        );


        /*
         * =========================================
         * PRODUCT GRID
         * =========================================
         */

        productGrid =
                new GridPane();

        productGrid.setHgap(
                20
        );

        productGrid.setVgap(
                20
        );


        /*
         * =========================================
         * PRODUCT COUNT
         * =========================================
         */

        productCount =
                new Label(
                        "Showing 6 products"
                );

        productCount.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * =========================================
         * BACK BUTTON
         * =========================================
         */

        Button backButton =
                new Button(
                        "←  Back to Dashboard"
                );

        backButton.setPrefHeight(
                40
        );

        backButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 18;"
        );


        /*
         * =========================================
         * BACK TO DASHBOARD
         * =========================================
         */

        backButton.setOnAction(
                event -> {

                    System.out.println(
                            "Back Button Clicked"
                    );

                    /*
                     * Existing dashboard callback
                     */

                    /*
                     * Reset category
                     */

                    selectedCategory =
                            "All";


                    /*
                     * Call dashboard
                     */

                    /*
                     * Callback is passed from
                     * Dashboard / Main navigation
                     */

                    /*
                     * We cannot access callback here
                     * directly, therefore it is handled
                     * through scene navigation.
                     */

                }
        );


        /*
         * =========================================
         * CATEGORY ACTIONS
         * =========================================
         */

        allButton.setOnAction(
                event -> {

                    selectedCategory =
                            "All";

                    setActiveButton(
                            allButton
                    );

                    showProducts();

                }
        );


        proteinButton.setOnAction(
                event -> {

                    selectedCategory =
                            "Proteins";

                    setActiveButton(
                            proteinButton
                    );

                    showProducts();

                }
        );


        vitaminButton.setOnAction(
                event -> {

                    selectedCategory =
                            "Vitamins";

                    setActiveButton(
                            vitaminButton
                    );

                    showProducts();

                }
        );


        energyButton.setOnAction(
                event -> {

                    selectedCategory =
                            "Energy";

                    setActiveButton(
                            energyButton
                    );

                    showProducts();

                }
        );


        /*
         * =========================================
         * SEARCH
         * =========================================
         */

        productSearch.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    showProducts();

                }
        );


        /*
         * =========================================
         * INITIAL PRODUCTS
         * =========================================
         */

        showProducts();


        /*
         * =========================================
         * ADD CONTENT
         * =========================================
         */

        content.getChildren().addAll(

                filterBox,

                productGrid,

                productCount,

                backButton

        );


        return content;

    }


    /*
     * =========================================
     * ADD PRODUCT PAGE
     * =========================================
     */

    private void showAddProductPage(
            HBox pageHeader,
            VBox productsContent) {


        /*
         * =========================================
         * ADD PRODUCT CONTENT
         * =========================================
         */

        VBox addProductContent =
                new VBox(20);

        addProductContent.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        /*
         * =========================================
         * FORM TITLE
         * =========================================
         */

        Label formTitle =
                new Label(
                        "Add New Product"
                );

        formTitle.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label formSubtitle =
                new Label(
                        "Enter the product details below to add a new supplement product."
                );

        formSubtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * =========================================
         * PRODUCT NAME
         * =========================================
         */

        Label nameLabel =
                new Label(
                        "Product Name"
                );

        nameLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter product name"
        );

        nameField.setPrefHeight(
                42
        );

        nameField.setMaxWidth(
                Double.MAX_VALUE
        );

        nameField.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        /*
         * =========================================
         * CATEGORY
         * =========================================
         */

        Label categoryLabel =
                new Label(
                        "Category"
                );

        categoryLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        ComboBox<String> categoryBox =
                new ComboBox<>();

        categoryBox.setItems(
                FXCollections.observableArrayList(
                        "Proteins",
                        "Vitamins",
                        "Energy"
                )
        );

        categoryBox.setPromptText(
                "Select category"
        );

        categoryBox.setPrefHeight(
                42
        );

        categoryBox.setMaxWidth(
                Double.MAX_VALUE
        );


        /*
         * =========================================
         * PRICE
         * =========================================
         */

        Label priceLabel =
                new Label(
                        "Price"
                );

        priceLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        TextField priceField =
                new TextField();

        priceField.setPromptText(
                "Example: $39.99"
        );

        priceField.setPrefHeight(
                42
        );

        priceField.setMaxWidth(
                Double.MAX_VALUE
        );

        priceField.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        /*
         * =========================================
         * STOCK
         * =========================================
         */

        Label stockLabel =
                new Label(
                        "Stock"
                );

        stockLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        TextField stockField =
                new TextField();

        stockField.setPromptText(
                "Example: 250 in stock"
        );

        stockField.setPrefHeight(
                42
        );

        stockField.setMaxWidth(
                Double.MAX_VALUE
        );

        stockField.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        /*
         * =========================================
         * FORM ROWS
         * =========================================
         */

        HBox priceStockBox =
                new HBox(20);

        priceStockBox.setAlignment(
                Pos.CENTER_LEFT
        );


        VBox priceBox =
                new VBox(8);

        VBox stockBox =
                new VBox(8);


        HBox.setHgrow(
                priceBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                stockBox,
                Priority.ALWAYS
        );


        priceBox.getChildren().addAll(
                priceLabel,
                priceField
        );


        stockBox.getChildren().addAll(
                stockLabel,
                stockField
        );


        priceStockBox.getChildren().addAll(
                priceBox,
                stockBox
        );


        /*
         * =========================================
         * BUTTONS
         * =========================================
         */

        HBox buttonBox =
                new HBox(12);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        Button cancelButton =
                new Button(
                        "←  Back to Products"
                );

        cancelButton.setPrefHeight(
                42
        );

        cancelButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 20;"
        );


        Button saveButton =
                new Button(
                        "Save Product"
                );

        saveButton.setPrefHeight(
                42
        );

        saveButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        /*
         * =========================================
         * FORM MESSAGE
         * =========================================
         */

        Label messageLabel =
                new Label();

        messageLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #ba1a1a;"
        );


        /*
         * =========================================
         * CANCEL / BACK
         * =========================================
         */

        cancelButton.setOnAction(
                event -> {

                    showProductsPage(
                            pageHeader,
                            productsContent
                    );

                }
        );


        /*
         * =========================================
         * SAVE PRODUCT
         * =========================================
         */

        saveButton.setOnAction(
                event -> {


                    String name =
                            nameField.getText()
                                    .trim();


                    String category =
                            categoryBox.getValue();


                    String price =
                            priceField.getText()
                                    .trim();


                    String stock =
                            stockField.getText()
                                    .trim();


                    /*
                     * =================================
                     * VALIDATION
                     * =================================
                     */

                    if (name.isEmpty()) {

                        messageLabel.setText(
                                "Please enter product name."
                        );

                        return;

                    }


                    if (category == null) {

                        messageLabel.setText(
                                "Please select a category."
                        );

                        return;

                    }


                    if (price.isEmpty()) {

                        messageLabel.setText(
                                "Please enter product price."
                        );

                        return;

                    }


                    if (stock.isEmpty()) {

                        messageLabel.setText(
                                "Please enter product stock."
                        );

                        return;

                    }


                    /*
                     * =================================
                     * ADD PRODUCT
                     * =================================
                     */

                    products.add(
                            new String[]{
                                    name,
                                    category,
                                    price,
                                    stock + " in stock"
                            }
                    );


                    /*
                     * =================================
                     * RESET CATEGORY
                     * =================================
                     */

                    selectedCategory =
                            "All";


                    /*
                     * =================================
                     * SHOW PRODUCTS PAGE
                     * =================================
                     */

                    showProductsPage(
                            pageHeader,
                            productsContent
                    );

                }
        );


        /*
         * =========================================
         * BUTTON BOX
         * =========================================
         */

        buttonBox.getChildren().addAll(
                cancelButton,
                saveButton
        );


        /*
         * =========================================
         * ADD FORM CONTENT
         * =========================================
         */

        addProductContent.getChildren().addAll(

                formTitle,

                formSubtitle,

                nameLabel,

                nameField,

                categoryLabel,

                categoryBox,

                priceStockBox,

                messageLabel,

                buttonBox

        );


        /*
         * =========================================
         * REPLACE PRODUCTS CONTENT
         * =========================================
         */

        centre.getChildren().clear();


        /*
         * IMPORTANT:
         *
         * Header remains exactly same.
         */

        centre.getChildren().addAll(

                pageHeader,

                addProductContent

        );

    }


    /*
     * =========================================
     * SHOW PRODUCTS PAGE AGAIN
     * =========================================
     */

    private void showProductsPage(
            HBox pageHeader,
            VBox productsContent) {


        centre.getChildren().clear();


        /*
         * Existing Products content
         */

        centre.getChildren().addAll(

                pageHeader,

                productsContent

        );


        /*
         * Refresh product display
         */

        showProducts();

    }


    /*
     * =========================================
     * SHOW PRODUCTS
     * =========================================
     */

    private void showProducts() {


        if (productGrid == null
                || productSearch == null) {

            return;

        }


        productGrid.getChildren().clear();


        String searchText =
                productSearch.getText()
                        .trim()
                        .toLowerCase();


        int column = 0;

        int row = 0;

        int count = 0;


        /*
         * =========================================
         * LOOP THROUGH PRODUCTS
         * =========================================
         */

        for (String[] product : products) {


            String productName =
                    product[0];


            String category =
                    product[1];


            String price =
                    product[2];


            String stock =
                    product[3];


            /*
             * =====================================
             * CHECK FILTER + SEARCH
             * =====================================
             */

            if (matchesProduct(
                    productName,
                    category,
                    searchText
            )) {


                addProduct(

                        createProductCard(
                                productName,
                                category,
                                price,
                                stock
                        ),

                        column,

                        row

                );


                column++;

                count++;


                /*
                 * Three products per row
                 */

                if (column == 3) {

                    column = 0;

                    row++;

                }

            }

        }


        /*
         * =========================================
         * PRODUCT COUNT
         * =========================================
         */

        if (searchText.isEmpty()) {

            productCount.setText(
                    "Showing "
                    + count
                    + " products"
            );

        } else {

            productCount.setText(
                    "Showing "
                    + count
                    + " matching products"
            );

        }


        /*
         * =========================================
         * NO RESULT
         * =========================================
         */

        if (count == 0) {

            Label noResult =
                    new Label(
                            "No products found"
                    );

            noResult.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: #737686;"
            );


            productGrid.add(
                    noResult,
                    0,
                    0
            );

        }

    }


    /*
     * =========================================
     * CHECK PRODUCT
     * =========================================
     */

    private boolean matchesProduct(
            String productName,
            String category,
            String searchText) {


        /*
         * =========================================
         * CATEGORY FILTER
         * =========================================
         */

        if (!selectedCategory.equals(
                "All"
        )
                &&
                !category.equals(
                        selectedCategory
                )) {

            return false;

        }


        /*
         * =========================================
         * EMPTY SEARCH
         * =========================================
         */

        if (searchText.isEmpty()) {

            return true;

        }


        /*
         * =========================================
         * SEARCH PRODUCT NAME
         * =========================================
         */

        if (productName
                .toLowerCase()
                .contains(searchText)) {

            return true;

        }


        /*
         * =========================================
         * SEARCH CATEGORY
         * =========================================
         */

        if (category
                .toLowerCase()
                .contains(searchText)) {

            return true;

        }


        return false;

    }


    /*
     * =========================================
     * ADD PRODUCT TO GRID
     * =========================================
     */

    private void addProduct(
            VBox product,
            int column,
            int row) {


        productGrid.add(
                product,
                column,
                row
        );

    }


    /*
     * =========================================
     * ACTIVE BUTTON
     * =========================================
     */

    private void setActiveButton(
            Button activeButton) {


        String normalStyle =
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 18;" +
                "-fx-text-fill: #434655;";


        String activeStyle =
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 10;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 18;";


        allButton.setStyle(
                normalStyle
        );

        proteinButton.setStyle(
                normalStyle
        );

        vitaminButton.setStyle(
                normalStyle
        );

        energyButton.setStyle(
                normalStyle
        );


        activeButton.setStyle(
                activeStyle
        );

    }


    /*
     * =========================================
     * PRODUCT CARD
     * =========================================
     */

    public VBox createProductCard(
            String productName,
            String category,
            String price,
            String stock) {


        VBox card =
                new VBox(12);


        card.setPrefWidth(
                300
        );

        card.setPrefHeight(
                250
        );


        card.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-padding: 20;"
        );


        /*
         * =========================================
         * PRODUCT IMAGE
         * =========================================
         */

        Label productImage =
                new Label(
                        "📦"
                );

        productImage.setPrefWidth(
                260
        );

        productImage.setPrefHeight(
                90
        );

        productImage.setAlignment(
                Pos.CENTER
        );

        productImage.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 15;" +
                "-fx-font-size: 38px;"
        );


        /*
         * =========================================
         * PRODUCT NAME
         * =========================================
         */

        Label nameLabel =
                new Label(
                        productName
                );

        nameLabel.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * =========================================
         * CATEGORY
         * =========================================
         */

        Label categoryLabel =
                new Label(
                        category
                );

        categoryLabel.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * =========================================
         * PRICE + STOCK
         * =========================================
         */

        HBox details =
                new HBox();


        Label priceLabel =
                new Label(
                        price
                );

        priceLabel.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Label stockLabel =
                new Label(
                        stock
                );

        stockLabel.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #006c49;" +
                "-fx-font-weight: bold;"
        );


        details.getChildren().addAll(
                priceLabel,
                spacer,
                stockLabel
        );


        /*
         * =========================================
         * EDIT BUTTON
         * =========================================
         */

        Button editButton =
                new Button(
                        "Edit Product"
                );

        editButton.setPrefHeight(
                35
        );

        editButton.setMaxWidth(
                Double.MAX_VALUE
        );

        editButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 9;" +
                "-fx-font-weight: bold;"
        );


        /*
         * =========================================
         * CARD CONTENT
         * =========================================
         */

        card.getChildren().addAll(

                productImage,

                nameLabel,

                categoryLabel,

                details,

                editButton

        );


        return card;

    }

}

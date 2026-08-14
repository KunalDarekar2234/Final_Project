package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Inventory {

    private Scene inventoryScene;

    /*
     * =========================================================
     * PRODUCT DATA
     * =========================================================
     */

    private static class Product {

        String name;
        String category;
        int stock;

        Product(String name, String category, int stock) {
            this.name = name;
            this.category = category;
            this.stock = stock;
        }
    }


    /*
     * =========================================================
     * INVENTORY DATA
     * =========================================================
     */

    private final Product[] products = {

            new Product(
                    "Ultra Whey Pro",
                    "Proteins",
                    428
            ),

            new Product(
                    "Daily Multivit",
                    "Vitamins",
                    315
            ),

            new Product(
                    "Ignite Pre-Workout",
                    "Energy",
                    22
            ),

            new Product(
                    "Creatine Monohydrate",
                    "Proteins",
                    198
            ),

            new Product(
                    "Omega 3 Plus",
                    "Vitamins",
                    8
            ),

            new Product(
                    "BCAA Recovery",
                    "Energy",
                    142
            )
    };


    /*
     * =========================================================
     * MAIN SCENE
     * =========================================================
     */

    public Scene getInventoryScene(
            Runnable callBackAction) {


        /*
         * =====================================================
         * COMMON SIDEBAR
         * =====================================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Inventory");


        /*
         * =====================================================
         * TOP BAR
         * =====================================================
         */

        HBox topBar =
                new HBox();

        topBar.setPrefHeight(70);

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        topBar.setPadding(
                new Insets(
                        0,
                        35,
                        0,
                        35
                )
        );

        topBar.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-border-color: #e1e5ef;" +
                "-fx-border-width: 0 0 1 0;"
        );


        Label searchBox =
                new Label(
                        "🔍  Search inventory..."
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
                searchBox,
                topSpacer,
                userDetails
        );


        /*
         * =====================================================
         * CENTRE
         * =====================================================
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
         * =====================================================
         * PAGE HEADER
         * =====================================================
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
                        "Inventory"
                );

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Monitor stock levels, inventory health and product availability."
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
         * =====================================================
         * ADD STOCK BUTTON
         * =====================================================
         */

        Button addStockButton =
                new Button(
                        "+  Add Stock"
                );

        addStockButton.setPrefHeight(42);

        addStockButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                addStockButton
        );


        /*
         * =====================================================
         * MAIN CONTENT CONTAINER
         *
         * Only this section will change.
         * Sidebar + header remain unchanged.
         * =====================================================
         */

        VBox contentArea =
                new VBox(25);


        /*
         * =====================================================
         * METHOD TO SHOW INVENTORY CONTENT
         * =====================================================
         */

        Runnable showInventoryPage =
                () -> {

                    contentArea.getChildren().clear();

                    /*
                     * SUMMARY
                     */

                    HBox summaryBox =
                            createSummaryBox();


                    /*
                     * SEARCH / FILTER
                     */

                    HBox filterBox =
                            createFilterBox(
                                    contentArea
                            );


                    /*
                     * PRODUCT TABLE
                     */

                    VBox inventoryList =
                            createInventoryList(
                                    contentArea
                            );


                    contentArea.getChildren().addAll(

                            summaryBox,

                            filterBox,

                            inventoryList

                    );
                };


        /*
         * =====================================================
         * ADD STOCK PAGE
         * =====================================================
         */

        Runnable showAddStockPage =
                () -> {

                    contentArea.getChildren().clear();


                    /*
                     * ADD STOCK HEADER
                     */

                    HBox addHeader =
                            new HBox();

                    addHeader.setAlignment(
                            Pos.CENTER_LEFT
                    );


                    VBox addHeadingBox =
                            new VBox(5);


                    Label addHeading =
                            new Label(
                                    "Add Stock"
                            );

                    addHeading.setStyle(
                            "-fx-font-size: 28px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #004ac6;"
                    );


                    Label addSubHeading =
                            new Label(
                                    "Add new stock quantity to an existing product."
                            );

                    addSubHeading.setStyle(
                            "-fx-font-size: 14px;" +
                            "-fx-text-fill: #737686;"
                    );


                    addHeadingBox.getChildren().addAll(
                            addHeading,
                            addSubHeading
                    );


                    Region addSpacer =
                            new Region();

                    HBox.setHgrow(
                            addSpacer,
                            Priority.ALWAYS
                    );


                    Button backButton =
                            new Button(
                                    "←  Back to Inventory"
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
                            event ->
                                    showInventoryPage.run()
                    );


                    addHeader.getChildren().addAll(
                            addHeadingBox,
                            addSpacer,
                            backButton
                    );


                    /*
                     * =================================================
                     * ADD STOCK CARD
                     * =================================================
                     */

                    VBox addStockCard =
                            new VBox(20);

                    addStockCard.setMaxWidth(
                            Double.MAX_VALUE
                    );

                    addStockCard.setStyle(
                            "-fx-background-color: rgba(255,255,255,0.95);" +
                            "-fx-background-radius: 25;" +
                            "-fx-padding: 30;"
                    );


                    /*
                     * PRODUCT
                     */

                    Label productLabel =
                            new Label(
                                    "Select Product"
                            );

                    productLabel.setStyle(
                            "-fx-font-size: 13px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #111c2d;"
                    );


                    ComboBox<String> productComboBox =
                            new ComboBox<>();


                    for (Product product : products) {

                        productComboBox.getItems().add(
                                product.name
                        );
                    }


                    productComboBox.setPromptText(
                            "Select product"
                    );

                    productComboBox.setPrefHeight(42);

                    productComboBox.setMaxWidth(
                            Double.MAX_VALUE
                    );

                    productComboBox.setStyle(
                            "-fx-background-color: #f7f8fc;" +
                            "-fx-border-color: #dfe2ec;" +
                            "-fx-border-radius: 10;" +
                            "-fx-background-radius: 10;"
                    );


                    /*
                     * CURRENT STOCK
                     */

                    Label currentStockLabel =
                            new Label(
                                    "Current Stock: Select a product"
                            );

                    currentStockLabel.setStyle(
                            "-fx-font-size: 12px;" +
                            "-fx-text-fill: #737686;"
                    );


                    productComboBox.setOnAction(
                            event -> {

                                String selected =
                                        productComboBox.getValue();

                                for (Product product : products) {

                                    if (product.name.equals(
                                            selected
                                    )) {

                                        currentStockLabel.setText(
                                                "Current Stock: "
                                                        + product.stock
                                                        + " units"
                                        );

                                        break;
                                    }
                                }
                            }
                    );


                    /*
                     * QUANTITY
                     */

                    Label quantityLabel =
                            new Label(
                                    "Quantity to Add"
                            );

                    quantityLabel.setStyle(
                            "-fx-font-size: 13px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #111c2d;"
                    );


                    TextField quantityField =
                            new TextField();

                    quantityField.setPromptText(
                            "Enter quantity"
                    );

                    quantityField.setPrefHeight(42);

                    quantityField.setStyle(
                            "-fx-background-color: #f7f8fc;" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-color: #dfe2ec;" +
                            "-fx-border-radius: 10;" +
                            "-fx-padding: 0 15;"
                    );


                    /*
                     * SUPPLIER
                     */

                    Label supplierLabel =
                            new Label(
                                    "Supplier"
                            );

                    supplierLabel.setStyle(
                            "-fx-font-size: 13px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #111c2d;"
                    );


                    TextField supplierField =
                            new TextField();

                    supplierField.setPromptText(
                            "Enter supplier name"
                    );

                    supplierField.setPrefHeight(42);

                    supplierField.setStyle(
                            "-fx-background-color: #f7f8fc;" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-color: #dfe2ec;" +
                            "-fx-border-radius: 10;" +
                            "-fx-padding: 0 15;"
                    );


                    /*
                     * NOTES
                     */

                    Label notesLabel =
                            new Label(
                                    "Notes"
                            );

                    notesLabel.setStyle(
                            "-fx-font-size: 13px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #111c2d;"
                    );


                    TextArea notesField =
                            new TextArea();

                    notesField.setPromptText(
                            "Add any additional information..."
                    );

                    notesField.setPrefHeight(100);

                    notesField.setWrapText(true);

                    notesField.setStyle(
                            "-fx-background-color: #f7f8fc;" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-color: #dfe2ec;" +
                            "-fx-border-radius: 10;" +
                            "-fx-padding: 10 15;"
                    );


                    /*
                     * BUTTONS
                     */

                    HBox buttonBox =
                            new HBox(12);

                    buttonBox.setAlignment(
                            Pos.CENTER_RIGHT
                    );


                    Button cancelButton =
                            new Button(
                                    "Cancel"
                            );

                    cancelButton.setPrefHeight(40);

                    cancelButton.setStyle(
                            "-fx-background-color: white;" +
                            "-fx-border-color: #c3c6d7;" +
                            "-fx-border-radius: 10;" +
                            "-fx-background-radius: 10;" +
                            "-fx-padding: 0 20;"
                    );


                    cancelButton.setOnAction(
                            event ->
                                    showInventoryPage.run()
                    );


                    Button saveStockButton =
                            new Button(
                                    "Add Stock"
                            );

                    saveStockButton.setPrefHeight(40);

                    saveStockButton.setStyle(
                            "-fx-background-color: #004ac6;" +
                            "-fx-text-fill: white;" +
                            "-fx-background-radius: 10;" +
                            "-fx-padding: 0 22;" +
                            "-fx-font-weight: bold;"
                    );


                    /*
                     * =================================================
                     * SAVE STOCK
                     * =================================================
                     */

                    saveStockButton.setOnAction(
                            event -> {

                                String selectedProduct =
                                        productComboBox.getValue();

                                String quantityText =
                                        quantityField.getText().trim();


                                if (selectedProduct == null
                                        || selectedProduct.isEmpty()) {

                                    showMessage(
                                            addStockCard,
                                            "Please select a product."
                                    );

                                    return;
                                }


                                if (quantityText.isEmpty()) {

                                    showMessage(
                                            addStockCard,
                                            "Please enter quantity."
                                    );

                                    return;
                                }


                                int quantity;

                                try {

                                    quantity =
                                            Integer.parseInt(
                                                    quantityText
                                            );

                                } catch (NumberFormatException e) {

                                    showMessage(
                                            addStockCard,
                                            "Quantity must be a valid number."
                                    );

                                    return;
                                }


                                if (quantity <= 0) {

                                    showMessage(
                                            addStockCard,
                                            "Quantity must be greater than 0."
                                    );

                                    return;
                                }


                                /*
                                 * UPDATE PRODUCT STOCK
                                 */

                                for (Product product : products) {

                                    if (product.name.equals(
                                            selectedProduct
                                    )) {

                                        product.stock =
                                                product.stock
                                                        + quantity;

                                        break;
                                    }
                                }


                                /*
                                 * RETURN TO INVENTORY
                                 */

                                showInventoryPage.run();
                            }
                    );


                    buttonBox.getChildren().addAll(
                            cancelButton,
                            saveStockButton
                    );


                    /*
                     * ADD EVERYTHING TO CARD
                     */

                    addStockCard.getChildren().addAll(

                            productLabel,

                            productComboBox,

                            currentStockLabel,

                            quantityLabel,

                            quantityField,

                            supplierLabel,

                            supplierField,

                            notesLabel,

                            notesField,

                            buttonBox

                    );


                    contentArea.getChildren().addAll(

                            addHeader,

                            addStockCard

                    );
                };


        /*
         * =====================================================
         * ADD STOCK BUTTON ACTION
         * =====================================================
         */

        addStockButton.setOnAction(
                event ->
                        showAddStockPage.run()
        );


        /*
         * =====================================================
         * INITIAL PAGE
         * =====================================================
         */

        showInventoryPage.run();


        /*
         * =====================================================
         * CENTRE CONTENT
         * =====================================================
         */

        centre.getChildren().addAll(

                pageHeader,

                contentArea

        );


        /*
         * =====================================================
         * SCROLL PANE
         * =====================================================
         */

        ScrollPane scrollPane =
                new ScrollPane(
                        centre
                );

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
         * =====================================================
         * MAIN LAYOUT
         * =====================================================
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
         * =====================================================
         * SCENE
         * =====================================================
         */

        Scene sc =
                new Scene(
                        mainPane,
                        1400,
                        800
                );


        inventoryScene =
                sc;

        return inventoryScene;
    }


    /*
     * =========================================================
     * SUMMARY BOX
     * =========================================================
     */

    private HBox createSummaryBox() {

        HBox summaryBox =
                new HBox(18);


        int totalProducts =
                products.length;


        int optimalStock = 0;

        int lowStock = 0;

        int outOfStock = 0;


        for (Product product : products) {

            if (product.stock == 0) {

                outOfStock++;

            } else if (product.stock <= 25) {

                lowStock++;

            } else {

                optimalStock++;
            }
        }


        VBox totalCard =
                createSummaryCard(
                        "▣",
                        String.valueOf(
                                totalProducts
                        ),
                        "Total Products",
                        "#004ac6"
                );


        VBox optimalCard =
                createSummaryCard(
                        "✓",
                        String.valueOf(
                                optimalStock
                        ),
                        "Optimal Stock",
                        "#006c49"
                );


        VBox lowCard =
                createSummaryCard(
                        "!",
                        String.valueOf(
                                lowStock
                        ),
                        "Low Stock",
                        "#ba1a1a"
                );


        VBox outCard =
                createSummaryCard(
                        "×",
                        String.valueOf(
                                outOfStock
                        ),
                        "Out of Stock",
                        "#ba1a1a"
                );


        summaryBox.getChildren().addAll(

                totalCard,

                optimalCard,

                lowCard,

                outCard

        );


        return summaryBox;
    }


    /*
     * =========================================================
     * SEARCH + FILTER
     * =========================================================
     */

    private HBox createFilterBox(
            VBox contentArea) {


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


        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search inventory..."
        );

        searchField.setPrefWidth(
                350
        );

        searchField.setPrefHeight(
                40
        );

        searchField.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        Button allButton =
                new Button("All");


        Button availableButton =
                new Button("Available");


        Button lowStockButton =
                new Button("Low Stock");


        Button outStockButton =
                new Button("Out of Stock");


        Button[] buttons = {

                allButton,
                availableButton,
                lowStockButton,
                outStockButton

        };


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


        for (Button button : buttons) {

            button.setPrefHeight(40);

            button.setStyle(
                    normalStyle
            );
        }


        allButton.setStyle(
                selectedStyle
        );


        String[] selectedFilter = {

                "All"

        };


        Runnable updateFilterStyle =
                () -> {

                    for (Button button : buttons) {

                        button.setStyle(
                                normalStyle
                        );
                    }


                    if (selectedFilter[0].equals("All")) {

                        allButton.setStyle(
                                selectedStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("Available")) {

                        availableButton.setStyle(
                                selectedStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("Low Stock")) {

                        lowStockButton.setStyle(
                                selectedStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("Out of Stock")) {

                        outStockButton.setStyle(
                                selectedStyle
                        );
                    }
                };


        /*
         * =====================================================
         * REBUILD LIST
         * =====================================================
         */

        Runnable refreshList =
                () -> {

                    /*
                     * Find list from content area.
                     */

                    VBox list =
                            findInventoryList(
                                    contentArea
                            );


                    if (list == null) {

                        return;
                    }


                    list.getChildren().clear();


                    list.getChildren().add(
                            createTableHeader()
                    );


                    String searchText =
                            searchField.getText()
                                    .trim()
                                    .toLowerCase();


                    for (Product product : products) {

                        boolean searchMatch =
                                product.name
                                        .toLowerCase()
                                        .contains(
                                                searchText
                                        )
                                ||
                                product.category
                                        .toLowerCase()
                                        .contains(
                                                searchText
                                        );


                        if (!searchMatch) {

                            continue;
                        }


                        boolean filterMatch =
                                matchesInventoryFilter(
                                        product,
                                        selectedFilter[0]
                                );


                        if (filterMatch) {

                            list.getChildren().add(
                                    createInventoryRow(
                                            product
                                    )
                            );
                        }
                    }
                };


        /*
         * =====================================================
         * BUTTON ACTIONS
         * =====================================================
         */

        allButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "All";

                    updateFilterStyle.run();

                    refreshList.run();
                }
        );


        availableButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "Available";

                    updateFilterStyle.run();

                    refreshList.run();
                }
        );


        lowStockButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "Low Stock";

                    updateFilterStyle.run();

                    refreshList.run();
                }
        );


        outStockButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "Out of Stock";

                    updateFilterStyle.run();

                    refreshList.run();
                }
        );


        searchField.textProperty()
                .addListener(
                        (
                                observable,
                                oldValue,
                                newValue
                        ) -> {

                            refreshList.run();

                        }
                );


        filterBox.getChildren().addAll(

                searchField,

                allButton,

                availableButton,

                lowStockButton,

                outStockButton

        );


        return filterBox;
    }


    /*
     * =========================================================
     * INVENTORY LIST
     * =========================================================
     */

    private VBox createInventoryList(
            VBox contentArea) {


        VBox inventoryList =
                new VBox(0);

        inventoryList.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        inventoryList.setId(
                "inventoryList"
        );


        inventoryList.getChildren().add(
                createTableHeader()
        );


        for (Product product : products) {

            inventoryList.getChildren().add(
                    createInventoryRow(
                            product
                    )
            );
        }


        return inventoryList;
    }


    /*
     * =========================================================
     * FIND INVENTORY LIST
     * =========================================================
     */

    private VBox findInventoryList(
            VBox contentArea) {


        for (
                javafx.scene.Node node
                : contentArea.getChildren()
        ) {

            if (
                    node instanceof VBox
                    &&
                    "inventoryList".equals(
                            node.getId()
                    )
            ) {

                return (VBox) node;
            }
        }


        return null;
    }


    /*
     * =========================================================
     * TABLE HEADER
     * =========================================================
     */

    private HBox createTableHeader() {

        HBox tableHeader =
                new HBox();


        Label productHeader =
                new Label(
                        "Product"
                );

        productHeader.setPrefWidth(
                330
        );


        Label categoryHeader =
                new Label(
                        "Category"
                );

        categoryHeader.setPrefWidth(
                165
        );


        Label stockHeader =
                new Label(
                        "Stock"
                );

        stockHeader.setPrefWidth(
                130
        );


        Label statusHeader =
                new Label(
                        "Status"
                );

        statusHeader.setPrefWidth(
                165
        );


        Label actionHeader =
                new Label(
                        "Action"
                );


        String headerStyle =
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;";


        productHeader.setStyle(
                headerStyle
        );

        categoryHeader.setStyle(
                headerStyle
        );

        stockHeader.setStyle(
                headerStyle
        );

        statusHeader.setStyle(
                headerStyle
        );

        actionHeader.setStyle(
                headerStyle
        );


        tableHeader.getChildren().addAll(

                productHeader,

                categoryHeader,

                stockHeader,

                statusHeader,

                actionHeader

        );


        return tableHeader;
    }


    /*
     * =========================================================
     * PRODUCT ROW
     * =========================================================
     */

    private HBox createInventoryRow(
            Product product) {


        HBox row =
                new HBox();


        row.setPrefHeight(
                72
        );

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
                new Label(
                        product.name
                );

        productLabel.setPrefWidth(
                330
        );

        productLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * CATEGORY
         */

        Label categoryLabel =
                new Label(
                        product.category
                );

        categoryLabel.setPrefWidth(
                165
        );

        categoryLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * STOCK
         */

        Label stockLabel =
                new Label(
                        String.valueOf(
                                product.stock
                        )
                );

        stockLabel.setPrefWidth(
                130
        );

        stockLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * STATUS
         */

        String status;

        String color;


        if (product.stock == 0) {

            status =
                    "Out of Stock";

            color =
                    "#ba1a1a";

        } else if (product.stock <= 25) {

            status =
                    "Low Stock";

            color =
                    "#ba1a1a";

        } else {

            status =
                    "Optimal";

            color =
                    "#006c49";
        }


        Label statusLabel =
                new Label(
                        status
                );

        statusLabel.setPrefWidth(
                165
        );

        statusLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 15;" +
                "-fx-padding: 6 12;" +
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        /*
         * MANAGE BUTTON
         */

        Button manageButton =
                new Button(
                        "Manage"
                );

        manageButton.setPrefHeight(
                34
        );

        manageButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 0 15;"
        );


        /*
         * Manage button opens Add Stock
         */

        manageButton.setOnAction(
                event -> {

                    // This button can be connected
                    // to product-specific stock management
                    System.out.println(
                            "Manage: "
                                    + product.name
                    );
                }
        );


        row.getChildren().addAll(

                productLabel,

                categoryLabel,

                stockLabel,

                statusLabel,

                manageButton

        );


        return row;
    }


    /*
     * =========================================================
     * FILTER LOGIC
     * =========================================================
     */

    private boolean matchesInventoryFilter(
            Product product,
            String filter) {


        if (filter.equals("All")) {

            return true;
        }


        if (filter.equals("Available")) {

            return product.stock > 0;
        }


        if (filter.equals("Low Stock")) {

            return product.stock > 0
                    && product.stock <= 25;
        }


        if (filter.equals("Out of Stock")) {

            return product.stock == 0;
        }


        return true;
    }


    /*
     * =========================================================
     * SUMMARY CARD
     * =========================================================
     */

    private VBox createSummaryCard(
            String icon,
            String value,
            String title,
            String color) {


        VBox card =
                new VBox(10);

        card.setPrefWidth(
                240
        );

        card.setPrefHeight(
                135
        );

        card.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-padding: 20;"
        );


        Label iconLabel =
                new Label(
                        icon
                );

        iconLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 8;" +
                "-fx-font-size: 17px;" +
                "-fx-text-fill: " + color + ";"
        );


        Label valueLabel =
                new Label(
                        value
                );

        valueLabel.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label titleLabel =
                new Label(
                        title
                );

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
     * =========================================================
     * ERROR MESSAGE
     * =========================================================
     */

    private void showMessage(
            VBox parent,
            String message) {


        Label messageLabel =
                new Label(
                        message
                );

        messageLabel.setStyle(
                "-fx-text-fill: #ba1a1a;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        /*
         * Avoid adding the same message repeatedly.
         */

        parent.getChildren()
                .removeIf(
                        node ->
                                node.getId() != null
                                &&
                                node.getId().equals(
                                        "errorMessage"
                                )
                );


        messageLabel.setId(
                "errorMessage"
        );


        parent.getChildren().add(
                messageLabel
        );
    }
}



package com.visionx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SupplementMarketplaceView {

    private Scene marketplaceScene;

    // =========================================================
    // COLORS
    // =========================================================

    private final String GREEN = "#62ff96";
    private final String DARK = "#080C14";
    private final String CARD = "#07111d";
    private final String TEXT = "#ffffff";
    private final String SECONDARY = "#8a8d91";

    // =========================================================
    // PRODUCT MODEL
    // =========================================================

    static class Product {

        String name;
        String category;
        double price;
        double rating;
        String description;

        Product(
                String name,
                String category,
                double price,
                double rating,
                String description
        ) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.rating = rating;
            this.description = description;
        }
    }

    // =========================================================
    // CART ITEM MODEL
    // =========================================================

    static class CartItem {

        Product product;
        int quantity;

        CartItem(
                Product product,
                int quantity
        ) {
            this.product = product;
            this.quantity = quantity;
        }

        double getTotal() {
            return product.price * quantity;
        }
    }

    // =========================================================
    // PRODUCT LIST
    // =========================================================

    private final List<Product> products =
            new ArrayList<>();

    // =========================================================
    // CART LIST
    // =========================================================

    private final List<CartItem> cart =
            new ArrayList<>();

    // =========================================================
    // CART COUNT
    // =========================================================

    private Button cartButton;

    // =========================================================
    // CURRENT FILTER
    // =========================================================

    private String selectedCategory = "All";

    private String selectedPrice = "All Prices";

    // =========================================================
    // GET MARKETPLACE SCENE
    // =========================================================

    public Scene getMarketplaceScene(
            Runnable callBackAction
    ) {

        loadProducts();

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color: #080C14;"
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent =
                new VBox(25);

        mainContent.setPadding(
                new Insets(
                        30,
                        40,
                        40,
                        40
                )
        );

        mainContent.setStyle(
                "-fx-background-color: #080C14;"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        // -----------------------------------------------------
        // TITLE
        // -----------------------------------------------------

        VBox titleBox =
                new VBox(5);

        Text title =
                new Text(
                        "Supplement Marketplace"
                );

        title.setStyle(
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text subtitle =
                new Text(
                        "Find supplements that support your fitness goals."
                );

        subtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #8a8d91;"
        );

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // -----------------------------------------------------
        // HEADER SPACER
        // -----------------------------------------------------

        Region headerSpacer =
                new Region();

        HBox.setHgrow(
                headerSpacer,
                Priority.ALWAYS
        );

        // -----------------------------------------------------
        // CART BUTTON
        // -----------------------------------------------------

        cartButton =
                new Button();

        updateCartButton();

        addHoverEffect(
                cartButton,

                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #62ff96;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        cartButton.setOnAction(
                e -> showCartDialog()
        );

        // -----------------------------------------------------
        // BACK BUTTON
        // -----------------------------------------------------

        Button backButton =
                new Button(
                        "← Dashboard"
                );

        addHoverEffect(
                backButton,

                "-fx-background-color: #151b24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px 18px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #62ff96;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        backButton.setOnAction(
                e -> {

                    if (callBackAction != null) {
                        callBackAction.run();
                    }

                }
        );

        header.getChildren().addAll(
                titleBox,
                headerSpacer,
                cartButton,
                backButton
        );

        // =====================================================
        // SEARCH
        // =====================================================

        HBox searchSection =
                new HBox(12);

        searchSection.setAlignment(
                Pos.CENTER_LEFT
        );

        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search supplements..."
        );

        searchField.setPrefHeight(
                45
        );

        searchField.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #596675;" +
                "-fx-background-radius: 12px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 12px;" +
                "-fx-padding: 10px 15px;"
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        Button searchButton =
                new Button(
                        "Search"
                );

        searchButton.setPrefHeight(
                45
        );

        addHoverEffect(
                searchButton,

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12px;" +
                "-fx-padding: 10px 22px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #9cffbb;" +
                "-fx-text-fill: black;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12px;" +
                "-fx-padding: 10px 22px;" +
                "-fx-cursor: hand;"
        );

        searchSection.getChildren().addAll(
                searchField,
                searchButton
        );

        // =====================================================
        // CATEGORY TITLE
        // =====================================================

        Text categoryTitle =
                new Text(
                        "Shop By Category"
                );

        categoryTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        // =====================================================
        // CATEGORY BUTTONS
        // =====================================================

        HBox categoryBox =
                new HBox(10);

        categoryBox.setAlignment(
                Pos.CENTER_LEFT
        );

        String[] categories = {
                "All",
                "Protein",
                "Creatine",
                "Vitamins",
                "Pre-Workout",
                "Mass Gainer",
                "Omega 3"
        };

        // =====================================================
        // PRODUCT GRID
        // =====================================================

        FlowPane productGrid =
                new FlowPane();

        productGrid.setHgap(
                18
        );

        productGrid.setVgap(
                18
        );

        productGrid.setPrefWrapLength(
                1050
        );

        // =====================================================
        // PRICE FILTER
        // =====================================================

        HBox filterSection =
                new HBox(15);

        filterSection.setAlignment(
                Pos.CENTER_LEFT
        );

        Text priceLabel =
                new Text(
                        "Price Range:"
                );

        priceLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        ComboBox<String> priceBox =
                new ComboBox<>();

        priceBox.getItems().addAll(
                "All Prices",
                "Under ₹1000",
                "₹1000 - ₹2000",
                "₹2000 - ₹3000",
                "Above ₹3000"
        );

        priceBox.setValue(
                "All Prices"
        );

        priceBox.setPrefWidth(
                180
        );

        priceBox.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;"
        );

        filterSection.getChildren().addAll(
                priceLabel,
                priceBox
        );

        // =====================================================
        // PRODUCT TITLE
        // =====================================================

        HBox productTitleRow =
                new HBox();

        productTitleRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Text productTitle =
                new Text(
                        "All Supplements"
                );

        productTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Region productSpacer =
                new Region();

        HBox.setHgrow(
                productSpacer,
                Priority.ALWAYS
        );

        Text productCount =
                new Text();

        productCount.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #62ff96;"
        );

        productTitleRow.getChildren().addAll(
                productTitle,
                productSpacer,
                productCount
        );

        // =====================================================
        // CATEGORY BUTTON CREATION
        // =====================================================

        for (String category : categories) {

            Button categoryButton =
                    createCategoryButton(
                            category
                    );

            categoryBox.getChildren().add(
                    categoryButton
            );

            if (category.equals("All")) {

                setSelectedCategoryStyle(
                        categoryButton
                );
            }

            categoryButton.setOnAction(
                    e -> {

                        selectedCategory =
                                category;

                        resetCategoryButtons(
                                categoryBox,
                                categoryButton
                        );

                        refreshProducts(
                                productGrid,
                                productCount,
                                searchField.getText()
                        );
                    }
            );
        }

        // =====================================================
        // INITIAL PRODUCTS
        // =====================================================

        refreshProducts(
                productGrid,
                productCount,
                ""
        );

        // =====================================================
        // PRICE CHANGE
        // =====================================================

        priceBox.setOnAction(
                e -> {

                    selectedPrice =
                            priceBox.getValue();

                    refreshProducts(
                            productGrid,
                            productCount,
                            searchField.getText()
                    );
                }
        );

        // =====================================================
        // SEARCH BUTTON
        // =====================================================

        searchButton.setOnAction(
                e -> {

                    refreshProducts(
                            productGrid,
                            productCount,
                            searchField.getText()
                    );
                }
        );

        // =====================================================
        // LIVE SEARCH
        // =====================================================

        searchField.setOnKeyReleased(
                e -> {

                    refreshProducts(
                            productGrid,
                            productCount,
                            searchField.getText()
                    );
                }
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        mainContent.getChildren().addAll(
                header,
                searchSection,
                categoryTitle,
                categoryBox,
                filterSection,
                productTitleRow,
                productGrid
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(
                        mainContent
                );

        scrollPane.setFitToWidth(
                true
        );

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setStyle(
                "-fx-background: #080C14;" +
                "-fx-background-color: #080C14;" +
                "-fx-border-color: transparent;"
        );

        root.setCenter(
                scrollPane
        );

        // =====================================================
        // SCENE
        // =====================================================

        marketplaceScene =
                new Scene(
                        root,
                        1200,
                        800
                );

        return marketplaceScene;
    }

    // =========================================================
    // LOAD PRODUCTS
    // =========================================================

    private void loadProducts() {

        products.clear();

        products.add(
                new Product(
                        "Whey Protein Gold",
                        "Protein",
                        2499,
                        4.8,
                        "High quality whey protein for muscle recovery."
                )
        );

        products.add(
                new Product(
                        "100% Whey Protein",
                        "Protein",
                        1899,
                        4.6,
                        "Premium whey protein with high protein content."
                )
        );

        products.add(
                new Product(
                        "Plant Protein",
                        "Protein",
                        1599,
                        4.4,
                        "Plant based protein for daily nutrition."
                )
        );

        products.add(
                new Product(
                        "Creatine Monohydrate",
                        "Creatine",
                        999,
                        4.7,
                        "Pure creatine monohydrate for strength and performance."
                )
        );

        products.add(
                new Product(
                        "Creatine Micronized",
                        "Creatine",
                        1299,
                        4.6,
                        "Micronized creatine for improved workout performance."
                )
        );

        products.add(
                new Product(
                        "Daily Multivitamin",
                        "Vitamins",
                        699,
                        4.5,
                        "Daily essential vitamins and minerals."
                )
        );

        products.add(
                new Product(
                        "Vitamin D3",
                        "Vitamins",
                        499,
                        4.4,
                        "Vitamin D3 supplement for daily nutrition."
                )
        );

        products.add(
                new Product(
                        "Pre Workout Blast",
                        "Pre-Workout",
                        1499,
                        4.6,
                        "Energy and focus support before training."
                )
        );

        products.add(
                new Product(
                        "Extreme Pre Workout",
                        "Pre-Workout",
                        2199,
                        4.7,
                        "High intensity pre-workout formula."
                )
        );

        products.add(
                new Product(
                        "Mass Gainer Pro",
                        "Mass Gainer",
                        2799,
                        4.5,
                        "High calorie formula designed for mass gain."
                )
        );

        products.add(
                new Product(
                        "Mega Mass Gainer",
                        "Mass Gainer",
                        3299,
                        4.6,
                        "High calorie mass gainer for muscle growth."
                )
        );

        products.add(
                new Product(
                        "Omega 3 Fish Oil",
                        "Omega 3",
                        799,
                        4.5,
                        "Omega 3 fatty acids for daily wellness."
                )
        );

        products.add(
                new Product(
                        "Triple Strength Omega 3",
                        "Omega 3",
                        1799,
                        4.7,
                        "High strength omega 3 supplement."
                )
        );
    }

    // =========================================================
    // REFRESH PRODUCTS
    // =========================================================

    private void refreshProducts(
            FlowPane productGrid,
            Text productCount,
            String searchText
    ) {

        productGrid.getChildren().clear();

        String search =
                searchText == null
                        ? ""
                        : searchText
                                .trim()
                                .toLowerCase();

        int count = 0;

        for (Product product : products) {

            boolean categoryMatch =
                    selectedCategory.equals("All")
                            ||
                    product.category.equals(
                            selectedCategory
                    );

            boolean priceMatch =
                    checkPrice(
                            product.price,
                            selectedPrice
                    );

            boolean searchMatch =
                    search.isEmpty()
                            ||
                    product.name
                            .toLowerCase()
                            .contains(search)
                            ||
                    product.category
                            .toLowerCase()
                            .contains(search);

            if (
                    categoryMatch
                            &&
                    priceMatch
                            &&
                    searchMatch
            ) {

                VBox card =
                        createProductCard(
                                product
                        );

                productGrid.getChildren().add(
                        card
                );

                count++;
            }
        }

        productCount.setText(
                count + " Products"
        );

        // =====================================================
        // NO PRODUCT
        // =====================================================

        if (count == 0) {

            VBox noProduct =
                    new VBox(10);

            noProduct.setAlignment(
                    Pos.CENTER
            );

            noProduct.setPadding(
                    new Insets(40)
            );

            Text text =
                    new Text(
                            "No supplements found"
                    );

            text.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: white;"
            );

            Text sub =
                    new Text(
                            "Try another category, price range or search."
                    );

            sub.setStyle(
                    "-fx-font-size: 12px;" +
                    "-fx-fill: #8a8d91;"
            );

            noProduct.getChildren().addAll(
                    text,
                    sub
            );

            productGrid.getChildren().add(
                    noProduct
            );
        }
    }

    // =========================================================
    // PRICE CHECK
    // =========================================================

    private boolean checkPrice(
            double price,
            String priceRange
    ) {

        if (
                priceRange == null
                        ||
                priceRange.equals(
                        "All Prices"
                )
        ) {

            return true;
        }

        if (
                priceRange.equals(
                        "Under ₹1000"
                )
        ) {

            return price < 1000;
        }

        if (
                priceRange.equals(
                        "₹1000 - ₹2000"
                )
        ) {

            return price >= 1000
                    &&
                    price <= 2000;
        }

        if (
                priceRange.equals(
                        "₹2000 - ₹3000"
                )
        ) {

            return price > 2000
                    &&
                    price <= 3000;
        }

        if (
                priceRange.equals(
                        "Above ₹3000"
                )
        ) {

            return price > 3000;
        }

        return true;
    }

    // =========================================================
    // PRODUCT CARD
    // =========================================================

    private VBox createProductCard(
            Product product
    ) {

        VBox card =
                new VBox(12);

        card.setPrefWidth(
                245
        );

        card.setMinWidth(
                245
        );

        card.setPadding(
                new Insets(18)
        );

        card.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 18px;"
        );

        // =====================================================
        // IMAGE AREA
        // =====================================================

        HBox imageArea =
                new HBox();

        imageArea.setAlignment(
                Pos.CENTER
        );

        imageArea.setPrefHeight(
                120
        );

        imageArea.setStyle(
                "-fx-background-color: #0d1824;" +
                "-fx-background-radius: 14px;"
        );

        Circle productCircle =
                new Circle(
                        38,
                        Color.web(
                                "#10281b"
                        )
                );

        Text productIcon =
                new Text(
                        getCategoryIcon(
                                product.category
                        )
                );

        productIcon.setStyle(
                "-fx-font-size: 28px;"
        );

        VBox iconBox =
                new VBox();

        iconBox.setAlignment(
                Pos.CENTER
        );

        iconBox.getChildren().addAll(
                productCircle,
                productIcon
        );

        imageArea.getChildren().add(
                iconBox
        );

        // =====================================================
        // CATEGORY
        // =====================================================

        Text category =
                new Text(
                        product.category
                );

        category.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #62ff96;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Text name =
                new Text(
                        product.name
                );

        name.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        name.setWrappingWidth(
                210
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        Text description =
                new Text(
                        product.description
                );

        description.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #8a8d91;"
        );

        description.setWrappingWidth(
                210
        );

        // =====================================================
        // RATING
        // =====================================================

        Text rating =
                new Text(
                        "★ "
                                + product.rating
                                + "  •  "
                                + product.category
                );

        rating.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #62ff96;"
        );

        // =====================================================
        // PRICE
        // =====================================================

        Text price =
                new Text(
                        "₹"
                                + String.format(
                                        "%.0f",
                                        product.price
                                )
                );

        price.setStyle(
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        // =====================================================
        // ADD TO CART
        // =====================================================

        Button addToCart =
                new Button(
                        "🛒 Add to Cart"
                );

        addToCart.setMaxWidth(
                Double.MAX_VALUE
        );

        addHoverEffect(
                addToCart,

                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #193326;" +
                "-fx-text-fill: #62ff96;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #62ff96;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px;" +
                "-fx-cursor: hand;"
        );

        addToCart.setOnAction(
                e -> {

                    addProductToCart(
                            product
                    );

                    addToCart.setText(
                            "✓ Added to Cart"
                    );
                }
        );

        // =====================================================
        // BUY NOW
        // =====================================================

        Button buyNow =
                new Button(
                        "Buy Now"
                );

        buyNow.setMaxWidth(
                Double.MAX_VALUE
        );

        addHoverEffect(
                buyNow,

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 10px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #9cffbb;" +
                "-fx-text-fill: black;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 10px;" +
                "-fx-cursor: hand;"
        );

        buyNow.setOnAction(
                e -> showBuyNowDialog(
                        product
                )
        );

        // =====================================================
        // BUTTON ROW
        // =====================================================

        VBox buttonBox =
                new VBox(8);

        buttonBox.getChildren().addAll(
                addToCart,
                buyNow
        );

        // =====================================================
        // CARD
        // =====================================================

        card.getChildren().addAll(
                imageArea,
                category,
                name,
                description,
                rating,
                price,
                buttonBox
        );

        // =====================================================
        // CARD HOVER
        // =====================================================

        addHoverEffect(
                card,

                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 18px;",

                "-fx-background-color: #0b1825;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #62ff96;" +
                "-fx-border-radius: 18px;" +
                "-fx-effect: dropshadow(" +
                "gaussian," +
                "rgba(98,255,150,0.18)," +
                "20," +
                "0.2," +
                "0," +
                "4);"
        );

        return card;
    }

    // =========================================================
    // ADD PRODUCT TO CART
    // =========================================================

    private void addProductToCart(
            Product product
    ) {

        for (CartItem item : cart) {

            if (
                    item.product.name.equals(
                            product.name
                    )
            ) {

                item.quantity++;

                updateCartButton();

                return;
            }
        }

        cart.add(
                new CartItem(
                        product,
                        1
                )
        );

        updateCartButton();

        System.out.println(
                "Added to cart: "
                        + product.name
        );
    }

    // =========================================================
    // UPDATE CART BUTTON
    // =========================================================

    private void updateCartButton() {

        if (cartButton == null) {
            return;
        }

        int count =
                getCartItemCount();

        cartButton.setText(
                "🛒 Cart (" + count + ")"
        );
    }

    // =========================================================
    // GET CART ITEM COUNT
    // =========================================================

    private int getCartItemCount() {

        int count = 0;

        for (CartItem item : cart) {

            count += item.quantity;
        }

        return count;
    }

    // =========================================================
    // GET CART TOTAL
    // =========================================================

    private double getCartTotal() {

        double total = 0;

        for (CartItem item : cart) {

            total += item.getTotal();
        }

        return total;
    }

    // =========================================================
    // CART DIALOG
    // =========================================================

    private void showCartDialog() {

        Stage cartStage =
                new Stage();

        cartStage.initModality(
                Modality.APPLICATION_MODAL
        );

        cartStage.setTitle(
                "Shopping Cart"
        );

        VBox root =
                new VBox(18);

        root.setPadding(
                new Insets(25)
        );

        root.setPrefWidth(
                550
        );

        root.setStyle(
                "-fx-background-color: #080C14;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        HBox titleRow =
                new HBox();

        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Text title =
                new Text(
                        "🛒 Shopping Cart"
                );

        title.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Text itemCount =
                new Text(
                        getCartItemCount()
                                + " items"
                );

        itemCount.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #62ff96;"
        );

        titleRow.getChildren().addAll(
                title,
                spacer,
                itemCount
        );

        // =====================================================
        // CART CONTENT
        // =====================================================

        VBox cartContent =
                new VBox(10);

        ScrollPane cartScroll =
                new ScrollPane(
                        cartContent
                );

        cartScroll.setFitToWidth(
                true
        );

        cartScroll.setPrefHeight(
                350
        );

        cartScroll.setStyle(
                "-fx-background: #080C14;" +
                "-fx-background-color: #080C14;" +
                "-fx-border-color: transparent;"
        );

        refreshCartContent(
                cartContent,
                itemCount,
                cartStage
        );

        // =====================================================
        // TOTAL
        // =====================================================

        HBox totalRow =
                new HBox();

        totalRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Text totalLabel =
                new Text(
                        "Total"
                );

        totalLabel.setStyle(
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Region totalSpacer =
                new Region();

        HBox.setHgrow(
                totalSpacer,
                Priority.ALWAYS
        );

        Text total =
                new Text();

        total.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #62ff96;"
        );

        total.setText(
                "₹"
                        + String.format(
                                "%.0f",
                                getCartTotal()
                        )
        );

        totalRow.getChildren().addAll(
                totalLabel,
                totalSpacer,
                total
        );

        // =====================================================
        // CHECKOUT
        // =====================================================

        Button checkout =
                new Button(
                        "Proceed to Checkout"
                );

        checkout.setMaxWidth(
                Double.MAX_VALUE
        );

        addHoverEffect(
                checkout,

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 12px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #9cffbb;" +
                "-fx-text-fill: black;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 12px;" +
                "-fx-cursor: hand;"
        );

        checkout.setOnAction(
                e -> {

                    if (cart.isEmpty()) {

                        showAlert(
                                "Cart Empty",
                                "Please add a product to cart first."
                        );

                        return;
                    }

                    showAlert(
                            "Checkout",
                            "Checkout functionality will be connected here."
                    );
                }
        );

        // =====================================================
        // CLOSE
        // =====================================================

        Button close =
                new Button(
                        "Continue Shopping"
                );

        close.setMaxWidth(
                Double.MAX_VALUE
        );

        close.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px;" +
                "-fx-cursor: hand;"
        );

        close.setOnAction(
                e -> cartStage.close()
        );

        root.getChildren().addAll(
                titleRow,
                cartScroll,
                totalRow,
                checkout,
                close
        );

        Scene scene =
                new Scene(
                        root
                );

        cartStage.setScene(
                scene
        );

        cartStage.showAndWait();
    }

    // =========================================================
    // REFRESH CART
    // =========================================================

    private void refreshCartContent(
            VBox cartContent,
            Text itemCount,
            Stage cartStage
    ) {

        cartContent.getChildren().clear();

        if (cart.isEmpty()) {

            VBox empty =
                    new VBox(10);

            empty.setAlignment(
                    Pos.CENTER
            );

            empty.setPadding(
                    new Insets(50)
            );

            Text icon =
                    new Text(
                            "🛒"
                    );

            icon.setStyle(
                    "-fx-font-size: 40px;"
            );

            Text title =
                    new Text(
                            "Your cart is empty"
                    );

            title.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-fill: white;"
            );

            Text sub =
                    new Text(
                            "Add supplements to your cart."
                    );

            sub.setStyle(
                    "-fx-font-size: 11px;" +
                    "-fx-fill: #8a8d91;"
            );

            empty.getChildren().addAll(
                    icon,
                    title,
                    sub
            );

            cartContent.getChildren().add(
                    empty
            );

            itemCount.setText(
                    "0 items"
            );

            return;
        }

        for (CartItem item : cart) {

            HBox cartItem =
                    createCartItem(
                            item,
                            cartContent,
                            itemCount,
                            cartStage
                    );

            cartContent.getChildren().add(
                    cartItem
            );
        }

        itemCount.setText(
                getCartItemCount()
                        + " items"
        );
    }

    // =========================================================
    // CART ITEM
    // =========================================================

    private HBox createCartItem(
            CartItem item,
            VBox cartContent,
            Text itemCount,
            Stage cartStage
    ) {

        HBox box =
                new HBox(12);

        box.setAlignment(
                Pos.CENTER_LEFT
        );

        box.setPadding(
                new Insets(15)
        );

        box.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 12px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 12px;"
        );

        // =====================================================
        // PRODUCT INFO
        // =====================================================

        VBox info =
                new VBox(4);

        Text name =
                new Text(
                        item.product.name
                );

        name.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text category =
                new Text(
                        item.product.category
                );

        category.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #62ff96;"
        );

        Text price =
                new Text(
                        "₹"
                                + String.format(
                                        "%.0f",
                                        item.product.price
                                )
                );

        price.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        info.getChildren().addAll(
                name,
                category,
                price
        );

        HBox.setHgrow(
                info,
                Priority.ALWAYS
        );

        // =====================================================
        // MINUS
        // =====================================================

        Button minus =
                new Button(
                        "-"
                );

        styleQuantityButton(
                minus
        );

        minus.setOnAction(
                e -> {

                    if (item.quantity > 1) {

                        item.quantity--;

                    } else {

                        cart.remove(item);
                    }

                    updateCartButton();

                    refreshCartContent(
                            cartContent,
                            itemCount,
                            cartStage
                    );
                }
        );

        // =====================================================
        // QUANTITY
        // =====================================================

        Label quantity =
                new Label(
                        String.valueOf(
                                item.quantity
                        )
                );

        quantity.setMinWidth(
                25
        );

        quantity.setAlignment(
                Pos.CENTER
        );

        quantity.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // PLUS
        // =====================================================

        Button plus =
                new Button(
                        "+"
                );

        styleQuantityButton(
                plus
        );

        plus.setOnAction(
                e -> {

                    item.quantity++;

                    updateCartButton();

                    refreshCartContent(
                            cartContent,
                            itemCount,
                            cartStage
                    );
                }
        );

        // =====================================================
        // ITEM TOTAL
        // =====================================================

        Text itemTotal =
                new Text(
                        "₹"
                                + String.format(
                                        "%.0f",
                                        item.getTotal()
                                )
                );

        itemTotal.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #62ff96;"
        );

        // =====================================================
        // REMOVE
        // =====================================================

        Button remove =
                new Button(
                        "✕"
                );

        remove.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #ff6b6b;" +
                "-fx-font-size: 14px;" +
                "-fx-cursor: hand;"
        );

        remove.setOnAction(
                e -> {

                    cart.remove(item);

                    updateCartButton();

                    refreshCartContent(
                            cartContent,
                            itemCount,
                            cartStage
                    );
                }
        );

        HBox quantityBox =
                new HBox(5);

        quantityBox.setAlignment(
                Pos.CENTER
        );

        quantityBox.getChildren().addAll(
                minus,
                quantity,
                plus
        );

        box.getChildren().addAll(
                info,
                quantityBox,
                itemTotal,
                remove
        );

        return box;
    }

    // =========================================================
    // QUANTITY BUTTON STYLE
    // =========================================================

    private void styleQuantityButton(
            Button button
    ) {

        button.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 6px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 6px;" +
                "-fx-min-width: 28px;" +
                "-fx-min-height: 28px;" +
                "-fx-cursor: hand;"
        );
    }

    // =========================================================
    // BUY NOW
    // =========================================================

    private void showBuyNowDialog(
            Product product
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                "Buy Now"
        );

        alert.setHeaderText(
                "Ready to Buy?"
        );

        alert.setContentText(
                "Product: "
                        + product.name
                        + "\n\n"
                        + "Category: "
                        + product.category
                        + "\n"
                        + "Price: ₹"
                        + String.format(
                                "%.0f",
                                product.price
                        )
                        + "\n\n"
                        + "Payment / Checkout can be connected here."
        );

        alert.showAndWait();
    }

    // =========================================================
    // CATEGORY ICON
    // =========================================================

    private String getCategoryIcon(
            String category
    ) {

        switch (category) {

            case "Protein":
                return "🥛";

            case "Creatine":
                return "💪";

            case "Vitamins":
                return "💊";

            case "Pre-Workout":
                return "⚡";

            case "Mass Gainer":
                return "🏋";

            case "Omega 3":
                return "🐟";

            default:
                return "🏃";
        }
    }

    // =========================================================
    // CATEGORY BUTTON
    // =========================================================

    private Button createCategoryButton(
            String category
    ) {

        Button button =
                new Button(
                        category
                );

        setNormalCategoryStyle(
                button
        );

        button.setOnMouseEntered(
                e -> {

                    if (
                            !category.equals(
                                    selectedCategory
                            )
                    ) {

                        button.setStyle(
                                "-fx-background-color: #193326;" +
                                "-fx-text-fill: #62ff96;" +
                                "-fx-font-weight: bold;" +
                                "-fx-background-radius: 20px;" +
                                "-fx-border-color: #62ff96;" +
                                "-fx-border-radius: 20px;" +
                                "-fx-padding: 9px 17px;" +
                                "-fx-cursor: hand;"
                        );
                    }
                }
        );

        button.setOnMouseExited(
                e -> {

                    if (
                            category.equals(
                                    selectedCategory
                            )
                    ) {

                        setSelectedCategoryStyle(
                                button
                        );

                    } else {

                        setNormalCategoryStyle(
                                button
                        );
                    }
                }
        );

        return button;
    }

    // =========================================================
    // NORMAL CATEGORY STYLE
    // =========================================================

    private void setNormalCategoryStyle(
            Button button
    ) {

        button.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: #ffffff;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 20px;" +
                "-fx-padding: 9px 17px;" +
                "-fx-cursor: hand;"
        );
    }

    // =========================================================
    // SELECTED CATEGORY STYLE
    // =========================================================

    private void setSelectedCategoryStyle(
            Button button
    ) {

        button.setStyle(
                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-color: #62ff96;" +
                "-fx-border-radius: 20px;" +
                "-fx-padding: 9px 17px;" +
                "-fx-cursor: hand;"
        );
    }

    // =========================================================
    // RESET CATEGORY BUTTONS
    // =========================================================

    private void resetCategoryButtons(
            HBox categoryBox,
            Button selected
    ) {

        for (
                Node node :
                categoryBox.getChildren()
        ) {

            if (
                    node instanceof Button
            ) {

                Button button =
                        (Button) node;

                setNormalCategoryStyle(
                        button
                );
            }
        }

        setSelectedCategoryStyle(
                selected
        );
    }

    // =========================================================
    // ALERT
    // =========================================================

    private void showAlert(
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
            Node node,
            String normalStyle,
            String hoverStyle
    ) {

        node.setStyle(
                normalStyle
        );

        node.setOnMouseEntered(
                e -> {

                    node.setStyle(
                            hoverStyle
                    );

                    node.setScaleX(
                            1.02
                    );

                    node.setScaleY(
                            1.02
                    );
                }
        );

        node.setOnMouseExited(
                e -> {

                    node.setStyle(
                            normalStyle
                    );

                    node.setScaleX(
                            1.0
                    );

                    node.setScaleY(
                            1.0
                    );
                }
        );
    }
}
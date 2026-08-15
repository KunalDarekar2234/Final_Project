package com.visionx.view.suppliment_login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.visionx.view.SplashScreen;

public class Dashboard  {

//     public static Stage primaryStage;

    public static Scene dashboardScene;

    public static BorderPane mainPane;

    private static Node dashboardCentre;

//     public static Stage primaryStage;

    public Scene getSupplimentDashboardScene(Runnable callBackAction) {



        // dashboardStage = stage;


        /*
         * =========================================
         * DASHBOARD CENTRE
         * =========================================
         */

        dashboardCentre =
                createDashboardCentre();


        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                createSidebar("Dashboard");


        /*
         * =========================================
         * MAIN PANE
         * =========================================
         */

        mainPane =
                new BorderPane();


        mainPane.setLeft(
                sideBar
        );


        mainPane.setCenter(
                dashboardCentre
        );


        /*
         * =========================================
         * SCENE
         * =========================================
         */

        dashboardScene =
                new Scene(
                        mainPane,
                        SplashScreen.primaryStage.getWidth(),
                        SplashScreen.primaryStage.getHeight()
                );

                SplashScreen.primaryStage.setMaximized(true);
        // dashboardStage.setScene(
        //         dashboardScene
        // );


        // dashboardStage.setTitle(
        //         "VisionX - Dashboard"
        // );


        // dashboardStage.show();

        return dashboardScene;
    }


    /*
     * =========================================
     * COMMON SIDEBAR
     * =========================================
     */

    public static VBox createSidebar(
            String selectedPage) {

        VBox sideBar =
                new VBox(7);

        sideBar.setPrefWidth(
                245
        );

        sideBar.setPadding(
                new Insets(25, 15, 25, 15)
        );

        sideBar.setStyle(
                "-fx-background-color: #ffffff;" +
                "-fx-border-color: #e1e5ef;" +
                "-fx-border-width: 0 1 0 0;"
        );


        /*
         * =========================================
         * LOGO
         * =========================================
         */

        Text logo =
                new Text("VISIONX");

        logo.setStyle(
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text logoSub =
                new Text("Store Management");

        logoSub.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #737686;"
        );


        VBox logoBox =
                new VBox(3);

        logoBox.setPadding(
                new Insets(0, 10, 25, 10)
        );


        logoBox.getChildren().addAll(
                logo,
                logoSub
        );


        /*
         * =========================================
         * DASHBOARD
         * =========================================
         */

        Button dashboardButton =
                createSidebarButton(
                        "Dashboard",
                        selectedPage
                );


        dashboardButton.setOnAction(
                event -> {

                    showDashboard();

                }
        );


        /*
         * =========================================
         * STORE
         * =========================================
         */

        Text storeHeading =
                new Text("STORE");

        storeHeading.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #9094a3;"
        );

        storeHeading.setTranslateX(12);


        /*
         * STORE PROFILE
         */

        Button storeProfileButton =
                createSidebarButton(
                        "Store Profile",
                        selectedPage
                );


        storeProfileButton.setOnAction(
                event -> {

                    StoreProfile page =
                            new StoreProfile();


                    Scene pageScene =
                            page.getStoreProfileScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Store Profile"
                    );

                }
        );


        /*
         * PRODUCTS
         */

        Button productsButton =
                createSidebarButton(
                        "Products",
                        selectedPage
                );


        productsButton.setOnAction(
                event -> {

                    Products page =
                            new Products();


                    Scene pageScene =
                            page.getProductsScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Products"
                    );

                }
        );


        /*
         * INVENTORY
         */

        Button inventoryButton =
                createSidebarButton(
                        "Inventory",
                        selectedPage
                );


        inventoryButton.setOnAction(
                event -> {

                    Inventory page =
                            new Inventory();


                    Scene pageScene =
                            page.getInventoryScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Inventory"
                    );

                }
        );


        /*
         * PRICE MANAGEMENT
         */

        Button priceButton =
                createSidebarButton(
                        "Price Management",
                        selectedPage
                );


        priceButton.setOnAction(
                event -> {

                    PriceManagement page =
                            new PriceManagement();


                    Scene pageScene =
                            page.getPriceManagementScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Price Management"
                    );

                }
        );


        /*
         * DISCOUNTS
         */

        Button discountsButton =
                createSidebarButton(
                        "Discounts",
                        selectedPage
                );


        discountsButton.setOnAction(
                event -> {

                    Discounts page =
                            new Discounts();


                    Scene pageScene =
                            page.getDiscountsScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Discounts"
                    );

                }
        );


        /*
         * ORDERS
         */

        Button ordersButton =
                createSidebarButton(
                        "Orders",
                        selectedPage
                );


        ordersButton.setOnAction(
                event -> {

                    Orders page =
                            new Orders();


                    Scene pageScene =
                            page.getOrdersScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Orders"
                    );

                }
        );


        /*
         * =========================================
         * ANALYTICS
         * =========================================
         */

        Text analyticsHeading =
                new Text("ANALYTICS");

        analyticsHeading.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #9094a3;"
        );

        analyticsHeading.setTranslateX(12);


        /*
         * INVENTORY ANALYSIS
         */

        Button inventoryAnalysisButton =
                createSidebarButton(
                        "Inventory Analysis",
                        selectedPage
                );


        inventoryAnalysisButton.setOnAction(
                event -> {

                    InventoryAnalysis page =
                            new InventoryAnalysis();


                    Scene pageScene =
                            page.getInventoryAnalysisScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Inventory Analysis"
                    );

                }
        );


        /*
         * SALES ANALYTICS
         */

        Button salesAnalyticsButton =
                createSidebarButton(
                        "Sales Analytics",
                        selectedPage
                );


        salesAnalyticsButton.setOnAction(
                event -> {

                    SalesAnalytics page =
                            new SalesAnalytics();


                    Scene pageScene =
                            page.getSalesAnalyticsScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Sales Analytics"
                    );

                }
        );


        /*
         * CUSTOMER REVIEWS
         */

        Button reviewsButton =
                createSidebarButton(
                        "Customer Reviews",
                        selectedPage
                );


        reviewsButton.setOnAction(
                event -> {

                    CustomerReviews page =
                            new CustomerReviews();


                    Scene pageScene =
                            page.getCustomerReviewsScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Customer Reviews"
                    );

                }
        );


        /*
         * =========================================
         * OTHER
         * =========================================
         */

        Text otherHeading =
                new Text("OTHER");

        otherHeading.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #9094a3;"
        );

        otherHeading.setTranslateX(12);


        /*
         * NOTIFICATIONS
         */

        Button notificationsButton =
                createSidebarButton(
                        "Notifications",
                        selectedPage
                );


        notificationsButton.setOnAction(
                event -> {

                    Notifications page =
                            new Notifications();


                    Scene pageScene =
                            page.getNotificationsScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Notifications"
                    );

                }
        );


        /*
         * SETTINGS
         */

        Button settingsButton =
                createSidebarButton(
                        "Settings",
                        selectedPage
                );


        settingsButton.setOnAction(
                event -> {

                    Settings page =
                            new Settings();


                    Scene pageScene =
                            page.getSettingsScene(

                                    new Runnable() {

                                        @Override
                                        public void run() {

                                            showDashboard();

                                        }

                                    }

                            );


                    showPage(
                            pageScene,
                            "Settings"
                    );

                }
        );


        /*
         * =========================================
         * SPACER
         * =========================================
         */

        Region spacer =
                new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS
        );


        /*
         * =========================================
         * ADD EVERYTHING TO SIDEBAR
         * =========================================
         */

        sideBar.getChildren().addAll(

                logoBox,

                dashboardButton,

                storeHeading,

                storeProfileButton,
                productsButton,
                inventoryButton,
                priceButton,
                discountsButton,
                ordersButton,

                analyticsHeading,

                inventoryAnalysisButton,
                salesAnalyticsButton,
                reviewsButton,

                otherHeading,

                notificationsButton,
                settingsButton,

                spacer

        );


        return sideBar;

    }


    /*
     * =========================================
     * SIDEBAR BUTTON CREATOR
     * =========================================
     */

    private static Button createSidebarButton(
            String text,
            String selectedPage) {

        Button button =
                new Button(text);


        button.setMaxWidth(
                Double.MAX_VALUE
        );


        button.setPrefHeight(
                42
        );


        button.setAlignment(
                Pos.CENTER_LEFT
        );


        button.setPadding(
                new Insets(
                        0,
                        15,
                        0,
                        15
                )
        );


        if (text.equals(selectedPage)) {

            button.setStyle(
                    "-fx-background-color: #eef3ff;" +
                    "-fx-text-fill: #004ac6;" +
                    "-fx-background-radius: 10;" +
                    "-fx-font-weight: bold;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #434655;" +
                    "-fx-background-radius: 10;"
            );

        }


        return button;

    }


    /*
     * =========================================
     * SHOW DASHBOARD
     * =========================================
     */

    public static void showDashboard() {

        try {
            mainPane.setCenter(
                    dashboardCentre
            );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        mainPane.setLeft(
                createSidebar("Dashboard")
        );

    }


    /*
     * =========================================
     * SHOW PAGE
     *
     * ONLY CENTRE IS TAKEN
     * =========================================
     */

    public static void showPage(
            Scene pageScene,
            String pageName) {


        BorderPane pagePane =
                (BorderPane) pageScene.getRoot();


        /*
         * Get only centre from page
         */

        Node pageCentre =
                pagePane.getCenter();


        /*
         * Set only centre in Dashboard
         */

        mainPane.setCenter(
                pageCentre
        );


        /*
         * Same common sidebar
         */

        mainPane.setLeft(
                createSidebar(pageName)
        );

    }


    /*
     * =========================================
     * DASHBOARD CENTRE
     * =========================================
     */

    private VBox createDashboardCentre() {

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
         * HEADER
         * =========================================
         */

        Text heading =
                new Text("Dashboard");


        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text subHeading =
                new Text(
                        "Welcome back! Here's what's happening in your store."
                );


        subHeading.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-fill: #737686;"
        );


        VBox headingBox =
                new VBox(5);


        headingBox.getChildren().addAll(
                heading,
                subHeading
        );


        /*
         * =========================================
         * CARDS
         * =========================================
         */

        HBox cards =
                new HBox(20);


        VBox salesCard =
                createDashboardCard(
                        "Total Sales",
                        "₹1,24,500",
                        "This Month"
                );


        VBox ordersCard =
                createDashboardCard(
                        "Total Orders",
                        "248",
                        "This Month"
                );


        VBox productsCard =
                createDashboardCard(
                        "Products",
                        "156",
                        "Active Products"
                );


        VBox customersCard =
                createDashboardCard(
                        "Customers",
                        "1,248",
                        "Total Customers"
                );


        cards.getChildren().addAll(
                salesCard,
                ordersCard,
                productsCard,
                customersCard
        );


        /*
         * =========================================
         * LOWER SECTION
         * =========================================
         */

        HBox lowerSection =
                new HBox(20);


        VBox recentOrders =
                new VBox(15);


        recentOrders.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 25;"
        );


        Text recentTitle =
                new Text("Recent Orders");


        recentTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text order1 =
                new Text(
                        "ORD-1048       ₹2,499       Pending"
                );


        Text order2 =
                new Text(
                        "ORD-1047       ₹1,899       Delivered"
                );


        Text order3 =
                new Text(
                        "ORD-1046       ₹3,299       Processing"
                );


        Text order4 =
                new Text(
                        "ORD-1045       ₹999         Delivered"
                );


        order1.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        order2.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        order3.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        order4.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        recentOrders.getChildren().addAll(
                recentTitle,
                order1,
                order2,
                order3,
                order4
        );


        VBox lowStock =
                new VBox(15);


        lowStock.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 25;"
        );


        Text lowStockTitle =
                new Text("Low Stock Products");


        lowStockTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text product1 =
                new Text(
                        "Whey Protein 2kg       8 left"
                );


        Text product2 =
                new Text(
                        "Creatine 500g           5 left"
                );


        Text product3 =
                new Text(
                        "Mass Gainer 3kg         7 left"
                );


        Text product4 =
                new Text(
                        "BCAA 300g               9 left"
                );


        product1.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        product2.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        product3.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        product4.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        lowStock.getChildren().addAll(
                lowStockTitle,
                product1,
                product2,
                product3,
                product4
        );


        HBox.setHgrow(
                recentOrders,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                lowStock,
                Priority.ALWAYS
        );


        lowerSection.getChildren().addAll(
                recentOrders,
                lowStock
        );


        /*
         * =========================================
         * ADD TO CENTRE
         * =========================================
         */

        centre.getChildren().addAll(

                headingBox,

                cards,

                lowerSection

        );


        return centre;

    }


    /*
     * =========================================
     * DASHBOARD CARD
     * =========================================
     */

    private VBox createDashboardCard(
            String title,
            String value,
            String subtitle) {


        VBox card =
                new VBox(8);


        card.setPrefHeight(
                145
        );


        card.setPrefWidth(
                230
        );


        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Text titleText =
                new Text(title);


        titleText.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #737686;"
        );


        Text valueText =
                new Text(value);


        valueText.setStyle(
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text subtitleText =
                new Text(subtitle);


        subtitleText.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #9094a3;"
        );


        card.getChildren().addAll(
                titleText,
                valueText,
                subtitleText
        );


        HBox.setHgrow(
                card,
                Priority.ALWAYS
        );


        return card;

    }

        // Minimal stub to resolve InventoryAnalysis reference
        private static class InventoryAnalysis {

                public InventoryAnalysis() {}

                public Scene getInventoryAnalysisScene(Runnable onBack) {
                        BorderPane pane = new BorderPane();
                        // centre content placeholder
                        pane.setCenter(new VBox());
                        return new Scene(pane, 800, 600);
                }

        }
}

package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class AllInventoryAnalysis {

    private Scene allInventoryAnalysisScene;

    public Scene getAllInventoryAnalysisScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Inventory Analysis");


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
                        "🔍  Search inventory analysis..."
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


        Label heading =
                new Label("Inventory Analysis");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Analyze stock levels, product movement and inventory performance."
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


        Button refreshButton =
                new Button("↻  Refresh Analysis");

        refreshButton.setPrefHeight(42);

        refreshButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                refreshButton
        );


        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox totalProductsCard =
                createSummaryCard(
                        "📦",
                        "452",
                        "Total Products",
                        "#004ac6"
                );


        VBox totalStockCard =
                createSummaryCard(
                        "▣",
                        "12,480",
                        "Total Stock Units",
                        "#006c49"
                );


        VBox lowStockCard =
                createSummaryCard(
                        "!",
                        "22",
                        "Low Stock Items",
                        "#ba1a1a"
                );


        VBox stockValueCard =
                createSummaryCard(
                        "₹",
                        "₹28.6L",
                        "Inventory Value",
                        "#7a4d00"
                );


        summaryBox.getChildren().addAll(
                totalProductsCard,
                totalStockCard,
                lowStockCard,
                stockValueCard
        );


        /*
         * =========================================
         * CHARTS AREA
         * =========================================
         */

        HBox chartsBox =
                new HBox(20);


        /*
         * =========================================
         * STOCK DISTRIBUTION PIE CHART
         * =========================================
         */

        VBox stockDistributionCard =
                new VBox(15);

        stockDistributionCard.setPrefWidth(450);

        stockDistributionCard.setPrefHeight(350);

        stockDistributionCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label distributionTitle =
                new Label("Stock Distribution");

        distributionTitle.setStyle(
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        PieChart stockPieChart =
                new PieChart();

        stockPieChart.setPrefHeight(270);

        stockPieChart.setLegendVisible(true);

        stockPieChart.getData().addAll(

                new PieChart.Data(
                        "Optimal Stock",
                        380
                ),

                new PieChart.Data(
                        "Low Stock",
                        22
                ),

                new PieChart.Data(
                        "Out of Stock",
                        5
                )

        );


        stockDistributionCard.getChildren().addAll(
                distributionTitle,
                stockPieChart
        );


        /*
         * =========================================
         * CATEGORY STOCK BAR CHART
         * =========================================
         */

        VBox categoryAnalysisCard =
                new VBox(15);

        HBox.setHgrow(
                categoryAnalysisCard,
                Priority.ALWAYS
        );

        categoryAnalysisCard.setPrefHeight(350);

        categoryAnalysisCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label categoryTitle =
                new Label("Stock by Category");

        categoryTitle.setStyle(
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        CategoryAxis xAxis =
                new CategoryAxis();

        xAxis.setLabel(
                "Category"
        );


        NumberAxis yAxis =
                new NumberAxis();

        yAxis.setLabel(
                "Stock Units"
        );


        BarChart<String, Number> barChart =
                new BarChart<>(
                        xAxis,
                        yAxis
                );

        barChart.setPrefHeight(280);

        barChart.setLegendVisible(false);

        XYChart.Series<String, Number> series =
                new XYChart.Series<>();


        series.getData().add(
                new XYChart.Data<>(
                        "Proteins",
                        5200
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Vitamins",
                        3100
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Energy",
                        2400
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Recovery",
                        1780
                )
        );


        barChart.getData().add(
                series
        );


        categoryAnalysisCard.getChildren().addAll(
                categoryTitle,
                barChart
        );


        chartsBox.getChildren().addAll(
                stockDistributionCard,
                categoryAnalysisCard
        );


        /*
         * =========================================
         * INVENTORY PERFORMANCE
         * =========================================
         */

        VBox performanceCard =
                new VBox(18);

        performanceCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label performanceTitle =
                new Label("Inventory Performance");

        performanceTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        HBox performanceRows =
                new HBox(25);


        VBox turnoverBox =
                createPerformanceBox(
                        "Inventory Turnover",
                        "4.8x",
                        "Healthy",
                        "#006c49"
                );


        VBox movementBox =
                createPerformanceBox(
                        "Fast Moving Products",
                        "36",
                        "Products",
                        "#004ac6"
                );


        VBox deadStockBox =
                createPerformanceBox(
                        "Slow Moving Products",
                        "14",
                        "Products",
                        "#7a4d00"
                );


        VBox wastageBox =
                createPerformanceBox(
                        "Stock Risk",
                        "3.2%",
                        "Low",
                        "#006c49"
                );


        performanceRows.getChildren().addAll(
                turnoverBox,
                movementBox,
                deadStockBox,
                wastageBox
        );


        performanceCard.getChildren().addAll(
                performanceTitle,
                performanceRows
        );


        /*
         * =========================================
         * LOW STOCK ALERT
         * =========================================
         */

        VBox alertCard =
                new VBox(15);

        alertCard.setStyle(
                "-fx-background-color: #fff7e6;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Label alertTitle =
                new Label(
                        "⚠  Low Stock Alert"
                );

        alertTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #7a4d00;"
        );


        Label alertText =
                new Label(
                        "22 products are currently below their recommended " +
                        "stock level. Ignite Pre-Workout, Omega 3 Plus and " +
                        "BCAA Recovery require immediate attention."
                );

        alertText.setWrapText(true);

        alertText.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #5f4a20;"
        );


        Button inventoryButton =
                new Button("View Inventory");

        inventoryButton.setPrefHeight(38);

        inventoryButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c9a85d;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;"
        );


        alertCard.getChildren().addAll(
                alertTitle,
                alertText,
                inventoryButton
        );


        /*
         * =========================================
         * AI ANALYSIS
         * =========================================
         */

        VBox aiInsight =
                new VBox(10);

        aiInsight.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Label aiTitle =
                new Label(
                        "🧠  AI Inventory Analysis"
                );

        aiTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label aiText =
                new Label(
                        "Your overall inventory health is good. " +
                        "Protein products have the highest stock movement. " +
                        "The current low-stock products should be replenished " +
                        "soon to maintain availability and prevent lost sales."
                );

        aiText.setWrapText(true);

        aiText.setStyle(
                "-fx-font-size: 13px;" +
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

                chartsBox,

                performanceCard,

                alertCard,

                aiInsight,

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


        allInventoryAnalysisScene = sc;

        return allInventoryAnalysisScene;

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
     * PERFORMANCE BOX
     * =========================================
     */

    public VBox createPerformanceBox(
            String title,
            String value,
            String description,
            String color) {

        VBox box =
                new VBox(7);

        box.setPrefWidth(220);

        box.setPadding(
                new Insets(15)
        );

        box.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 15;"
        );


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + color + ";"
        );


        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: " + color + ";"
        );


        box.getChildren().addAll(
                titleLabel,
                valueLabel,
                descriptionLabel
        );


        return box;

    }

}

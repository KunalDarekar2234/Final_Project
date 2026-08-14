package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SalesAnalytics {

    private Scene salesAnalyticsScene;
    private Runnable callBackAction;

    public Scene getSalesAnalyticsScene(Runnable callBackAction) {

        // If necessary this.callBackAction = callBackAction;

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Sales Analytics");


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
                        "🔍  Search sales..."
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
                new Label("Sales Analytics");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Track sales performance, revenue and customer buying trends."
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


        Button reportButton =
                new Button("Generate Report");

        reportButton.setPrefHeight(42);

        reportButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                reportButton
        );


        /*
         * =========================================
         * CONTENT CONTAINER
         *
         * Only this container changes when
         * Generate Report is clicked.
         *
         * Heading/subheading remain unchanged.
         * =========================================
         */

        VBox contentContainer =
                new VBox(25);

        contentContainer.setFillWidth(true);


        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox revenueCard =
                createSummaryCard(
                        "₹",
                        "₹4.82L",
                        "Total Revenue",
                        "#006c49"
                );


        VBox ordersCard =
                createSummaryCard(
                        "📦",
                        "248",
                        "Total Orders",
                        "#004ac6"
                );


        VBox averageCard =
                createSummaryCard(
                        "↗",
                        "₹1,944",
                        "Average Order Value",
                        "#7a4d00"
                );


        VBox growthCard =
                createSummaryCard(
                        "%",
                        "+18.6%",
                        "Sales Growth",
                        "#006c49"
                );


        summaryBox.getChildren().addAll(
                revenueCard,
                ordersCard,
                averageCard,
                growthCard
        );


        /*
         * =========================================
         * PERIOD FILTER
         * =========================================
         */

        HBox filterBox =
                new HBox(10);

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Label periodLabel =
                new Label("Sales Period:");

        periodLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #434655;"
        );


        Button weekButton =
                new Button("7 Days");

        weekButton.setPrefHeight(38);

        weekButton.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 9;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 18;"
        );


        Button monthButton =
                new Button("30 Days");

        monthButton.setPrefHeight(38);

        monthButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;"
        );


        Button yearButton =
                new Button("12 Months");

        yearButton.setPrefHeight(38);

        yearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;"
        );


        filterBox.getChildren().addAll(
                periodLabel,
                weekButton,
                monthButton,
                yearButton
        );


        /*
         * =========================================
         * SALES GRAPH CARD
         * =========================================
         */

        VBox salesGraphCard =
                new VBox(15);

        salesGraphCard.setPrefHeight(390);

        salesGraphCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        /*
         * =========================================
         * GRAPH HEADER
         * =========================================
         */

        HBox graphHeader =
                new HBox();


        Label graphTitle =
                new Label("Revenue Overview");

        graphTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Region graphSpacer =
                new Region();

        HBox.setHgrow(
                graphSpacer,
                Priority.ALWAYS
        );


        Label graphInfo =
                new Label(
                        "Revenue in ₹"
                );

        graphInfo.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        graphHeader.getChildren().addAll(
                graphTitle,
                graphSpacer,
                graphInfo
        );


        /*
         * =========================================
         * X AXIS
         * =========================================
         */

        CategoryAxis xAxis =
                new CategoryAxis();

        xAxis.setLabel(
                "Days"
        );


        /*
         * =========================================
         * Y AXIS
         * =========================================
         */

        NumberAxis yAxis =
                new NumberAxis();

        yAxis.setLabel(
                "Revenue"
        );


        /*
         * =========================================
         * AREA CHART
         * =========================================
         */

        AreaChart<String, Number> salesChart =
                new AreaChart<>(
                        xAxis,
                        yAxis
                );

        salesChart.setPrefHeight(300);

        salesChart.setLegendVisible(false);

        salesChart.setCreateSymbols(true);


        /*
         * =========================================
         * DEFAULT GRAPH - 7 DAYS
         * =========================================
         */

        XYChart.Series<String, Number> salesSeries =
                new XYChart.Series<>();


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Mon",
                        42000
                )
        );


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Tue",
                        58000
                )
        );


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Wed",
                        46000
                )
        );


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Thu",
                        72000
                )
        );


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Fri",
                        65000
                )
        );


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Sat",
                        89000
                )
        );


        salesSeries.getData().add(
                new XYChart.Data<>(
                        "Sun",
                        74000
                )
        );


        salesChart.getData().add(
                salesSeries
        );


        salesGraphCard.getChildren().addAll(
                graphHeader,
                salesChart
        );


        /*
         * =========================================
         * PERIOD BUTTON NAVIGATION
         * =========================================
         */

        weekButton.setOnAction(event -> {

            updateRevenueChart(
                    salesChart,
                    xAxis,
                    "7 Days"
            );


            setActivePeriodButton(
                    weekButton,
                    monthButton,
                    yearButton
            );

        });


        monthButton.setOnAction(event -> {

            updateRevenueChart(
                    salesChart,
                    xAxis,
                    "30 Days"
            );


            setActivePeriodButton(
                    monthButton,
                    weekButton,
                    yearButton
            );

        });


        yearButton.setOnAction(event -> {

            updateRevenueChart(
                    salesChart,
                    xAxis,
                    "12 Months"
            );


            setActivePeriodButton(
                    yearButton,
                    weekButton,
                    monthButton
            );

        });


        /*
         * =========================================
         * LOWER ANALYTICS SECTION
         * =========================================
         */

        HBox lowerSection =
                new HBox(20);


        /*
         * =========================================
         * TOP SELLING PRODUCTS
         * =========================================
         */

        VBox topProductsCard =
                new VBox(15);

        topProductsCard.setPrefWidth(600);

        topProductsCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label productsTitle =
                new Label("Top Selling Products");

        productsTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        topProductsCard.getChildren().add(
                productsTitle
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Whey Protein",
                        "84 units",
                        "₹1,68,000"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Creatine Monohydrate",
                        "62 units",
                        "₹93,000"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Omega 3",
                        "48 units",
                        "₹57,600"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "BCAA Recovery",
                        "35 units",
                        "₹42,000"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Pre Workout",
                        "28 units",
                        "₹39,200"
                )
        );


        /*
         * =========================================
         * SALES BY CATEGORY
         * =========================================
         */

        VBox categoryCard =
                new VBox(15);

        HBox.setHgrow(
                categoryCard,
                Priority.ALWAYS
        );

        categoryCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label categoryTitle =
                new Label("Sales by Category");

        categoryTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        categoryCard.getChildren().add(
                categoryTitle
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Protein Supplements",
                        "42%",
                        "#004ac6"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Vitamins",
                        "24%",
                        "#006c49"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Pre Workout",
                        "18%",
                        "#7a4d00"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Recovery",
                        "10%",
                        "#ba1a1a"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Other",
                        "6%",
                        "#737686"
                )
        );


        lowerSection.getChildren().addAll(
                topProductsCard,
                categoryCard
        );


        /*
         * =========================================
         * AI SALES INSIGHT
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
                        "🧠  AI Sales Insight"
                );

        aiTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label aiText =
                new Label(
                        "Sales are up by 18.6% compared with the previous period. " +
                        "Protein supplements are your strongest category, while " +
                        "Saturday generates the highest revenue. Consider running " +
                        "targeted weekend promotions to increase sales further."
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
         * BACK BUTTON - DASHBOARD
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
         * ORIGINAL ANALYTICS CONTENT
         *
         * Everything that was originally below
         * the heading is kept inside this container.
         * =========================================
         */

        contentContainer.getChildren().addAll(

                summaryBox,

                filterBox,

                salesGraphCard,

                lowerSection,

                aiInsight,

                backButton

        );


        /*
         * =========================================
         * GENERATE REPORT BUTTON
         *
         * Only contentContainer is replaced.
         * Sidebar, top bar, heading and subheading
         * remain unchanged.
         * =========================================
         */

        reportButton.setOnAction(event -> {

            contentContainer
                    .getChildren()
                    .clear();

            contentContainer
                    .getChildren()
                    .add(
                            createReportContent(
                                    contentContainer
                            )
                    );

        });


        /*
         * =========================================
         * ADD CENTRE CONTENT
         * =========================================
         */

        centre.getChildren().addAll(

                pageHeader,

                contentContainer

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


        salesAnalyticsScene =
                sc;

        return salesAnalyticsScene;

    }


    /*
     * =========================================
     * REPORT CONTENT
     * =========================================
     */

    private VBox createReportContent(
            VBox contentContainer) {

        VBox reportContainer =
                new VBox(20);

        reportContainer.setFillWidth(true);


        /*
         * =========================================
         * REPORT HEADER
         * =========================================
         */

        HBox reportHeader =
                new HBox();

        reportHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        Label reportTitle =
                new Label(
                        "Sales Report"
                );

        reportTitle.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Region reportSpacer =
                new Region();

        HBox.setHgrow(
                reportSpacer,
                Priority.ALWAYS
        );


        Label reportPeriod =
                new Label(
                        "Report Period: Current Sales Overview"
                );

        reportPeriod.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        reportHeader.getChildren().addAll(
                reportTitle,
                reportSpacer,
                reportPeriod
        );


        /*
         * =========================================
         * REPORT SUMMARY
         * =========================================
         */

        HBox reportSummary =
                new HBox(18);


        reportSummary.getChildren().addAll(

                createReportStatCard(
                        "₹",
                        "₹4.82L",
                        "Total Revenue",
                        "#006c49"
                ),

                createReportStatCard(
                        "📦",
                        "248",
                        "Total Orders",
                        "#004ac6"
                ),

                createReportStatCard(
                        "↗",
                        "₹1,944",
                        "Average Order Value",
                        "#7a4d00"
                ),

                createReportStatCard(
                        "%",
                        "+18.6%",
                        "Sales Growth",
                        "#006c49"
                )

        );


        /*
         * =========================================
         * SALES PERFORMANCE CARD
         * =========================================
         */

        VBox performanceCard =
                new VBox(15);

        performanceCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label performanceTitle =
                new Label(
                        "Sales Performance"
                );

        performanceTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        performanceCard.getChildren().add(
                performanceTitle
        );


        performanceCard.getChildren().add(
                createReportInfoRow(
                        "Total Revenue",
                        "₹4,82,000"
                )
        );


        performanceCard.getChildren().add(
                createReportInfoRow(
                        "Total Orders",
                        "248"
                )
        );


        performanceCard.getChildren().add(
                createReportInfoRow(
                        "Average Order Value",
                        "₹1,944"
                )
        );


        performanceCard.getChildren().add(
                createReportInfoRow(
                        "Sales Growth",
                        "+18.6%"
                )
        );


        performanceCard.getChildren().add(
                createReportInfoRow(
                        "Highest Revenue Day",
                        "Saturday"
                )
        );


        /*
         * =========================================
         * CATEGORY REPORT
         * =========================================
         */

        VBox categoryReportCard =
                new VBox(15);

        categoryReportCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label categoryReportTitle =
                new Label(
                        "Sales by Category"
                );

        categoryReportTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        categoryReportCard.getChildren().add(
                categoryReportTitle
        );


        categoryReportCard.getChildren().add(
                createReportCategoryRow(
                        "Protein Supplements",
                        "42%",
                        "#004ac6"
                )
        );


        categoryReportCard.getChildren().add(
                createReportCategoryRow(
                        "Vitamins",
                        "24%",
                        "#006c49"
                )
        );


        categoryReportCard.getChildren().add(
                createReportCategoryRow(
                        "Pre Workout",
                        "18%",
                        "#7a4d00"
                )
        );


        categoryReportCard.getChildren().add(
                createReportCategoryRow(
                        "Recovery",
                        "10%",
                        "#ba1a1a"
                )
        );


        categoryReportCard.getChildren().add(
                createReportCategoryRow(
                        "Other",
                        "6%",
                        "#737686"
                )
        );


        /*
         * =========================================
         * TOP PRODUCTS REPORT
         * =========================================
         */

        VBox productsReportCard =
                new VBox(15);

        productsReportCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label productsReportTitle =
                new Label(
                        "Top Selling Products"
                );

        productsReportTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        productsReportCard.getChildren().add(
                productsReportTitle
        );


        productsReportCard.getChildren().add(
                createProductRow(
                        "Whey Protein",
                        "84 units",
                        "₹1,68,000"
                )
        );


        productsReportCard.getChildren().add(
                createProductRow(
                        "Creatine Monohydrate",
                        "62 units",
                        "₹93,000"
                )
        );


        productsReportCard.getChildren().add(
                createProductRow(
                        "Omega 3",
                        "48 units",
                        "₹57,600"
                )
        );


        productsReportCard.getChildren().add(
                createProductRow(
                        "BCAA Recovery",
                        "35 units",
                        "₹42,000"
                )
        );


        productsReportCard.getChildren().add(
                createProductRow(
                        "Pre Workout",
                        "28 units",
                        "₹39,200"
                )
        );


        /*
         * =========================================
         * REPORT INSIGHT
         * =========================================
         */

        VBox reportInsight =
                new VBox(10);

        reportInsight.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Label reportInsightTitle =
                new Label(
                        "🧠  Report Insight"
                );

        reportInsightTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label reportInsightText =
                new Label(
                        "Protein supplements are the strongest sales category " +
                        "with 42% of total category sales. Saturday recorded " +
                        "the highest revenue, while overall sales increased " +
                        "by 18.6% compared with the previous period."
                );

        reportInsightText.setWrapText(true);

        reportInsightText.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        reportInsight.getChildren().addAll(
                reportInsightTitle,
                reportInsightText
        );


        /*
         * =========================================
         * BACK TO ANALYTICS BUTTON
         * =========================================
         */

        Button backToAnalyticsButton =
                new Button(
                        "←  Back to Sales Analytics"
                );

        backToAnalyticsButton.setPrefHeight(
                40
        );

        backToAnalyticsButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 18;" +
                "-fx-font-weight: bold;"
        );


        backToAnalyticsButton.setOnAction(
                event -> {

                    /*
                     * Clear report
                     */

                    contentContainer
                            .getChildren()
                            .clear();


                    /*
                     * Recreate original content
                     *
                     * This keeps the original
                     * functionality intact.
                     */

                    recreateOriginalAnalyticsContent(
                            contentContainer
                    );

                }
        );


        /*
         * =========================================
         * ADD REPORT CONTENT
         * =========================================
         */

        reportContainer.getChildren().addAll(

                reportHeader,

                reportSummary,

                performanceCard,

                categoryReportCard,

                productsReportCard,

                reportInsight,

                backToAnalyticsButton

        );


        return reportContainer;

    }


    /*
     * =========================================
     * RECREATE ORIGINAL ANALYTICS CONTENT
     * =========================================
     *
     * This method restores the original page
     * after Back to Sales Analytics.
     * =========================================
     */

    private void recreateOriginalAnalyticsContent(
            VBox contentContainer) {

        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox revenueCard =
                createSummaryCard(
                        "₹",
                        "₹4.82L",
                        "Total Revenue",
                        "#006c49"
                );


        VBox ordersCard =
                createSummaryCard(
                        "📦",
                        "248",
                        "Total Orders",
                        "#004ac6"
                );


        VBox averageCard =
                createSummaryCard(
                        "↗",
                        "₹1,944",
                        "Average Order Value",
                        "#7a4d00"
                );


        VBox growthCard =
                createSummaryCard(
                        "%",
                        "+18.6%",
                        "Sales Growth",
                        "#006c49"
                );


        summaryBox.getChildren().addAll(
                revenueCard,
                ordersCard,
                averageCard,
                growthCard
        );


        /*
         * =========================================
         * PERIOD FILTER
         * =========================================
         */

        HBox filterBox =
                new HBox(10);

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Label periodLabel =
                new Label("Sales Period:");

        periodLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #434655;"
        );


        Button weekButton =
                new Button("7 Days");

        weekButton.setPrefHeight(38);

        weekButton.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 9;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 18;"
        );


        Button monthButton =
                new Button("30 Days");

        monthButton.setPrefHeight(38);

        monthButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;"
        );


        Button yearButton =
                new Button("12 Months");

        yearButton.setPrefHeight(38);

        yearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;"
        );


        filterBox.getChildren().addAll(
                periodLabel,
                weekButton,
                monthButton,
                yearButton
        );


        /*
         * =========================================
         * GRAPH
         * =========================================
         */

        VBox salesGraphCard =
                new VBox(15);

        salesGraphCard.setPrefHeight(390);

        salesGraphCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        HBox graphHeader =
                new HBox();


        Label graphTitle =
                new Label("Revenue Overview");

        graphTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Region graphSpacer =
                new Region();

        HBox.setHgrow(
                graphSpacer,
                Priority.ALWAYS
        );


        Label graphInfo =
                new Label(
                        "Revenue in ₹"
                );

        graphInfo.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        graphHeader.getChildren().addAll(
                graphTitle,
                graphSpacer,
                graphInfo
        );


        CategoryAxis xAxis =
                new CategoryAxis();

        xAxis.setLabel(
                "Days"
        );


        NumberAxis yAxis =
                new NumberAxis();

        yAxis.setLabel(
                "Revenue"
        );


        AreaChart<String, Number> salesChart =
                new AreaChart<>(
                        xAxis,
                        yAxis
                );

        salesChart.setPrefHeight(300);

        salesChart.setLegendVisible(false);

        salesChart.setCreateSymbols(true);


        XYChart.Series<String, Number> salesSeries =
                new XYChart.Series<>();


        salesSeries.getData().add(
                new XYChart.Data<>("Mon", 42000)
        );

        salesSeries.getData().add(
                new XYChart.Data<>("Tue", 58000)
        );

        salesSeries.getData().add(
                new XYChart.Data<>("Wed", 46000)
        );

        salesSeries.getData().add(
                new XYChart.Data<>("Thu", 72000)
        );

        salesSeries.getData().add(
                new XYChart.Data<>("Fri", 65000)
        );

        salesSeries.getData().add(
                new XYChart.Data<>("Sat", 89000)
        );

        salesSeries.getData().add(
                new XYChart.Data<>("Sun", 74000)
        );


        salesChart.getData().add(
                salesSeries
        );


        salesGraphCard.getChildren().addAll(
                graphHeader,
                salesChart
        );


        weekButton.setOnAction(event -> {

            updateRevenueChart(
                    salesChart,
                    xAxis,
                    "7 Days"
            );

            setActivePeriodButton(
                    weekButton,
                    monthButton,
                    yearButton
            );

        });


        monthButton.setOnAction(event -> {

            updateRevenueChart(
                    salesChart,
                    xAxis,
                    "30 Days"
            );

            setActivePeriodButton(
                    monthButton,
                    weekButton,
                    yearButton
            );

        });


        yearButton.setOnAction(event -> {

            updateRevenueChart(
                    salesChart,
                    xAxis,
                    "12 Months"
            );

            setActivePeriodButton(
                    yearButton,
                    weekButton,
                    monthButton
            );

        });


        /*
         * =========================================
         * LOWER SECTION
         * =========================================
         */

        HBox lowerSection =
                new HBox(20);


        VBox topProductsCard =
                new VBox(15);

        topProductsCard.setPrefWidth(600);

        topProductsCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label productsTitle =
                new Label(
                        "Top Selling Products"
                );

        productsTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        topProductsCard.getChildren().add(
                productsTitle
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Whey Protein",
                        "84 units",
                        "₹1,68,000"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Creatine Monohydrate",
                        "62 units",
                        "₹93,000"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Omega 3",
                        "48 units",
                        "₹57,600"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "BCAA Recovery",
                        "35 units",
                        "₹42,000"
                )
        );


        topProductsCard.getChildren().add(
                createProductRow(
                        "Pre Workout",
                        "28 units",
                        "₹39,200"
                )
        );


        /*
         * =========================================
         * CATEGORY CARD
         * =========================================
         */

        VBox categoryCard =
                new VBox(15);

        HBox.setHgrow(
                categoryCard,
                Priority.ALWAYS
        );

        categoryCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 25;"
        );


        Label categoryTitle =
                new Label(
                        "Sales by Category"
                );

        categoryTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        categoryCard.getChildren().add(
                categoryTitle
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Protein Supplements",
                        "42%",
                        "#004ac6"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Vitamins",
                        "24%",
                        "#006c49"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Pre Workout",
                        "18%",
                        "#7a4d00"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Recovery",
                        "10%",
                        "#ba1a1a"
                )
        );


        categoryCard.getChildren().add(
                createCategoryRow(
                        "Other",
                        "6%",
                        "#737686"
                )
        );


        lowerSection.getChildren().addAll(
                topProductsCard,
                categoryCard
        );


        /*
         * =========================================
         * AI INSIGHT
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
                        "🧠  AI Sales Insight"
                );

        aiTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label aiText =
                new Label(
                        "Sales are up by 18.6% compared with the previous period. " +
                        "Protein supplements are your strongest category, while " +
                        "Saturday generates the highest revenue. Consider running " +
                        "targeted weekend promotions to increase sales further."
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
         * BACK TO DASHBOARD
         * =========================================
         */

        Button backButton =
                new Button(
                        "←  Back to Dashboard"
                );

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
         * RESTORE ORIGINAL CONTENT
         * =========================================
         */

        contentContainer.getChildren().addAll(

                summaryBox,

                filterBox,

                salesGraphCard,

                lowerSection,

                aiInsight,

                backButton

        );

    }


    /*
     * =========================================
     * REPORT STAT CARD
     * =========================================
     */

    private VBox createReportStatCard(
            String icon,
            String value,
            String title,
            String color) {

        VBox card =
                new VBox(10);

        card.setPrefWidth(240);

        card.setPrefHeight(125);

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
                "-fx-font-size: 22px;" +
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
     * REPORT INFORMATION ROW
     * =========================================
     */

    private HBox createReportInfoRow(
            String title,
            String value) {

        HBox row =
                new HBox();

        row.setPrefHeight(50);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-border-color: #eef0f5;" +
                "-fx-border-width: 0 0 1 0;"
        );


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #434655;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        row.getChildren().addAll(
                titleLabel,
                spacer,
                valueLabel
        );


        return row;

    }


    /*
     * =========================================
     * REPORT CATEGORY ROW
     * =========================================
     */

    private VBox createReportCategoryRow(
            String category,
            String percentage,
            String color) {

        VBox row =
                new VBox(7);


        HBox textRow =
                new HBox();


        Label categoryLabel =
                new Label(category);

        categoryLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #434655;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Label percentageLabel =
                new Label(percentage);

        percentageLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + color + ";"
        );


        textRow.getChildren().addAll(
                categoryLabel,
                spacer,
                percentageLabel
        );


        HBox progressBar =
                new HBox();

        progressBar.setPrefHeight(8);

        progressBar.setMinHeight(8);

        progressBar.setMaxHeight(8);

        progressBar.setMaxWidth(
                Double.MAX_VALUE
        );

        progressBar.setStyle(
                "-fx-background-color: #edf0f6;" +
                "-fx-background-radius: 10;"
        );


        double percent =
                Double.parseDouble(
                        percentage
                                .replace("%", "")
                                .trim()
                );


        Region progressFill =
                new Region();

        progressFill.setPrefHeight(8);

        progressFill.setMinHeight(8);

        progressFill.setMaxHeight(8);

        progressFill.setStyle(
                "-fx-background-color: " + color + ";" +
                "-fx-background-radius: 10;"
        );


        progressFill.prefWidthProperty().bind(
                progressBar.widthProperty()
                        .multiply(
                                percent / 100.0
                        )
        );


        progressBar.getChildren().add(
                progressFill
        );


        row.getChildren().addAll(
                textRow,
                progressBar
        );


        return row;

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
     * PRODUCT ROW
     * =========================================
     */

    public HBox createProductRow(
            String product,
            String units,
            String revenue) {

        HBox row =
                new HBox();

        row.setPrefHeight(55);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-border-color: #eef0f5;" +
                "-fx-border-width: 0 0 1 0;"
        );


        Label productLabel =
                new Label(product);

        productLabel.setPrefWidth(250);

        productLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label unitsLabel =
                new Label(units);

        unitsLabel.setPrefWidth(110);

        unitsLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        Label revenueLabel =
                new Label(revenue);

        revenueLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #006c49;"
        );


        row.getChildren().addAll(
                productLabel,
                unitsLabel,
                revenueLabel
        );


        return row;

    }


    /*
     * =========================================
     * CATEGORY ROW
     * =========================================
     */

    public VBox createCategoryRow(
            String category,
            String percentage,
            String color) {

        VBox row =
                new VBox(7);


        HBox textRow =
                new HBox();


        Label categoryLabel =
                new Label(category);

        categoryLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #434655;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Label percentageLabel =
                new Label(percentage);

        percentageLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + color + ";"
        );


        textRow.getChildren().addAll(
                categoryLabel,
                spacer,
                percentageLabel
        );


        /*
         * =========================================
         * 100% BACKGROUND
         * =========================================
         */

        HBox progressBar =
                new HBox();

        progressBar.setPrefHeight(8);

        progressBar.setMinHeight(8);

        progressBar.setMaxHeight(8);

        progressBar.setMaxWidth(
                Double.MAX_VALUE
        );

        progressBar.setStyle(
                "-fx-background-color: #edf0f6;" +
                "-fx-background-radius: 10;"
        );


        double percent =
                Double.parseDouble(
                        percentage
                                .replace(
                                        "%",
                                        ""
                                )
                                .trim()
                );


        /*
         * =========================================
         * COLOURED PERCENTAGE
         * =========================================
         */

        Region progressFill =
                new Region();

        progressFill.setPrefHeight(8);

        progressFill.setMinHeight(8);

        progressFill.setMaxHeight(8);

        progressFill.setStyle(
                "-fx-background-color: " + color + ";" +
                "-fx-background-radius: 10;"
        );


        progressFill.prefWidthProperty().bind(
                progressBar.widthProperty()
                        .multiply(
                                percent / 100.0
                        )
        );


        progressBar.getChildren().add(
                progressFill
        );


        row.getChildren().addAll(
                textRow,
                progressBar
        );


        return row;

    }


    /*
     * =========================================
     * UPDATE REVENUE CHART
     * =========================================
     */

    private void updateRevenueChart(
            AreaChart<String, Number> salesChart,
            CategoryAxis xAxis,
            String period) {


        salesChart.getData().clear();


        /*
         * =========================================
         * 7 DAYS
         * =========================================
         */

        if (period.equals("7 Days")) {

            xAxis.setLabel(
                    "Days"
            );


            XYChart.Series<String, Number> series =
                    new XYChart.Series<>();


            series.getData().add(
                    new XYChart.Data<>(
                            "Mon",
                            42000
                    )
            );

            series.getData().add(
                    new XYChart.Data<>(
                            "Tue",
                            58000
                    )
            );

            series.getData().add(
                    new XYChart.Data<>(
                            "Wed",
                            46000
                    )
            );

            series.getData().add(
                    new XYChart.Data<>(
                            "Thu",
                            72000
                    )
            );

            series.getData().add(
                    new XYChart.Data<>(
                            "Fri",
                            65000
                    )
            );

            series.getData().add(
                    new XYChart.Data<>(
                            "Sat",
                            89000
                    )
            );

            series.getData().add(
                    new XYChart.Data<>(
                            "Sun",
                            74000
                    )
            );


            salesChart.getData().add(
                    series
            );
        }


        /*
         * =========================================
         * 30 DAYS
         * =========================================
         */

        else if (period.equals("30 Days")) {

            xAxis.setLabel(
                    "Days"
            );


            XYChart.Series<String, Number> series =
                    new XYChart.Series<>();


            series.getData().add(
                    new XYChart.Data<>("1", 32000)
            );

            series.getData().add(
                    new XYChart.Data<>("2", 41000)
            );

            series.getData().add(
                    new XYChart.Data<>("3", 38000)
            );

            series.getData().add(
                    new XYChart.Data<>("4", 52000)
            );

            series.getData().add(
                    new XYChart.Data<>("5", 46000)
            );

            series.getData().add(
                    new XYChart.Data<>("6", 61000)
            );

            series.getData().add(
                    new XYChart.Data<>("7", 55000)
            );

            series.getData().add(
                    new XYChart.Data<>("8", 68000)
            );

            series.getData().add(
                    new XYChart.Data<>("9", 59000)
            );

            series.getData().add(
                    new XYChart.Data<>("10", 72000)
            );

            series.getData().add(
                    new XYChart.Data<>("11", 64000)
            );

            series.getData().add(
                    new XYChart.Data<>("12", 78000)
            );

            series.getData().add(
                    new XYChart.Data<>("13", 69000)
            );

            series.getData().add(
                    new XYChart.Data<>("14", 83000)
            );

            series.getData().add(
                    new XYChart.Data<>("15", 76000)
            );

            series.getData().add(
                    new XYChart.Data<>("16", 88000)
            );

            series.getData().add(
                    new XYChart.Data<>("17", 81000)
            );

            series.getData().add(
                    new XYChart.Data<>("18", 93000)
            );

            series.getData().add(
                    new XYChart.Data<>("19", 87000)
            );

            series.getData().add(
                    new XYChart.Data<>("20", 96000)
            );

            series.getData().add(
                    new XYChart.Data<>("21", 91000)
            );

            series.getData().add(
                    new XYChart.Data<>("22", 102000)
            );

            series.getData().add(
                    new XYChart.Data<>("23", 97000)
            );

            series.getData().add(
                    new XYChart.Data<>("24", 108000)
            );

            series.getData().add(
                    new XYChart.Data<>("25", 99000)
            );

            series.getData().add(
                    new XYChart.Data<>("26", 112000)
            );

            series.getData().add(
                    new XYChart.Data<>("27", 105000)
            );

            series.getData().add(
                    new XYChart.Data<>("28", 118000)
            );

            series.getData().add(
                    new XYChart.Data<>("29", 110000)
            );

            series.getData().add(
                    new XYChart.Data<>("30", 124000)
            );


            salesChart.getData().add(
                    series
            );
        }


        /*
         * =========================================
         * 12 MONTHS
         * =========================================
         */

        else if (period.equals("12 Months")) {

            xAxis.setLabel(
                    "Months"
            );


            XYChart.Series<String, Number> series =
                    new XYChart.Series<>();


            series.getData().add(
                    new XYChart.Data<>("Jan", 320000)
            );

            series.getData().add(
                    new XYChart.Data<>("Feb", 350000)
            );

            series.getData().add(
                    new XYChart.Data<>("Mar", 390000)
            );

            series.getData().add(
                    new XYChart.Data<>("Apr", 410000)
            );

            series.getData().add(
                    new XYChart.Data<>("May", 450000)
            );

            series.getData().add(
                    new XYChart.Data<>("Jun", 430000)
            );

            series.getData().add(
                    new XYChart.Data<>("Jul", 470000)
            );

            series.getData().add(
                    new XYChart.Data<>("Aug", 482000)
            );

            series.getData().add(
                    new XYChart.Data<>("Sep", 510000)
            );

            series.getData().add(
                    new XYChart.Data<>("Oct", 540000)
            );

            series.getData().add(
                    new XYChart.Data<>("Nov", 580000)
            );

            series.getData().add(
                    new XYChart.Data<>("Dec", 620000)
            );


            salesChart.getData().add(
                    series
            );
        }
    }


    /*
     * =========================================
     * ACTIVE PERIOD BUTTON
     * =========================================
     */

    private void setActivePeriodButton(
            Button activeButton,
            Button button1,
            Button button2) {


        activeButton.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 9;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 18;"
        );


        String normalStyle =
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 9;" +
                "-fx-background-radius: 9;" +
                "-fx-padding: 0 18;";


        button1.setStyle(
                normalStyle
        );

        button2.setStyle(
                normalStyle
        );
    }
}
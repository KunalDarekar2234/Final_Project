package com.visionx.view.gym_owner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import javafx.scene.effect.DropShadow;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;


public class Analytics {

    private Scene analyticsScene;


    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR =
            "#0d150e";

    private final String SURFACE =
            "rgba(13, 21, 14, 0.6)";

    private final String SURFACE_BORDER =
            "rgba(255,255,255,0.1)";

    private final String CARD_BG =
            "#020914";

    private final String PRIMARY =
            "#75ff9e";

    private final String PRIMARY_DIM =
            "rgba(117,255,158,0.1)";

    private final String TEXT_MAIN =
            "#dbe5d9";

    private final String TEXT_MUTED =
            "#bacbb9";

    private final String ERROR =
            "#ffb4ab";


    // =========================================================
    // SHADOW
    // =========================================================

    private final DropShadow glassShadow =
            new DropShadow(
                    25,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.45)
            );


    // =========================================================
    // NAVIGATION
    // =========================================================

    private Button overviewBtn;
    private Button revenueBtn;
    private Button customerBtn;
    private Button productsBtn;

    // IMPORTANT:
    // Navigation is now outside pageContent.
    // So page switching will NOT remove it.
    private HBox navigationBar;

    private VBox pageContent;

    private int currentPage = 1;


    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getAnalyticsScene(
            Runnable callBackAction
    ) {

        BorderPane root =
                new BorderPane();


        root.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI';"
        );


        // =====================================================
        // FIXED HORIZONTAL NAVIGATION
        // =====================================================

        navigationBar =
                createNavigation();


        StackPane navigationHolder =
                new StackPane(
                        navigationBar
                );


        navigationHolder.setAlignment(
                Pos.CENTER
        );


        navigationHolder.setPadding(
                new Insets(
                        20,
                        32,
                        12,
                        32
                )
        );


        navigationHolder.setStyle(
                "-fx-background-color: " +
                BG_COLOR + ";"
        );


        // IMPORTANT:
        // Navigation is fixed at the top.
        root.setTop(
                navigationHolder
        );


        // =====================================================
        // PAGE CONTENT
        // =====================================================

        pageContent =
                new VBox(28);


        pageContent.setPadding(
                new Insets(
                        20,
                        32,
                        40,
                        32
                )
        );


        pageContent.setMaxWidth(
                1250
        );


        StackPane centered =
                new StackPane(
                        pageContent
                );


        centered.setAlignment(
                Pos.TOP_CENTER
        );


        ScrollPane scroll =
                new ScrollPane(
                        centered
                );


        scroll.setFitToWidth(
                true
        );


        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );


        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );


        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );


        root.setCenter(
                scroll
        );


        // =====================================================
        // DEFAULT PAGE
        // =====================================================

        currentPage = 1;

        setActiveNavigation(
                overviewBtn
        );

        showOverview();


        analyticsScene =
                new Scene(
                        root,
                        1160,
                        900
                );


        return analyticsScene;
    }


    // =========================================================
    // OVERVIEW PAGE
    // =========================================================

    private void showOverview() {

        pageContent.getChildren().clear();


        // =====================================================
        // PAGE HEADER
        // =====================================================

        HBox titleRow =
                new HBox();


        titleRow.setAlignment(
                Pos.BOTTOM_LEFT
        );


        VBox titleBox =
                new VBox(5);


        Label breadcrumb =
                new Label(
                        "Analytics  ›  Business Analysis"
                );


        breadcrumb.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );


        Label title =
                new Label(
                        "Business Analysis Overview"
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle =
                new Label(
                        "Comprehensive insights into performance, growth, revenue and operations."
                );


        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 14px;"
        );


        titleBox.getChildren().addAll(
                breadcrumb,
                title,
                subtitle
        );


        Region spacer =
                new Region();


        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button date =
                new Button(
                        "Oct 18, 2023  -  Nov 18, 2023  ▾"
                );


        date.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-padding: 10 16;"
        );


        titleRow.getChildren().addAll(
                titleBox,
                spacer,
                date
        );


        // =====================================================
        // KPI
        // =====================================================

        GridPane stats =
                new GridPane();


        stats.setHgap(
                16
        );


        stats.setVgap(
                16
        );


        VBox revenue =
                createKpiCard(
                        "TOTAL REVENUE",
                        "$48,250",
                        "+12.5%",
                        "vs last 30 days",
                        "💲",
                        PRIMARY
                );


        VBox orders =
                createKpiCard(
                        "TOTAL ORDERS",
                        "1,842",
                        "+8.2%",
                        "vs last 30 days",
                        "▣",
                        PRIMARY
                );


        VBox customers =
                createKpiCard(
                        "ACTIVE CUSTOMERS",
                        "1,320",
                        "+15.3%",
                        "vs last 30 days",
                        "♙",
                        PRIMARY
                );


        VBox margin =
                createKpiCard(
                        "PROFIT MARGIN",
                        "24.6%",
                        "+3.1%",
                        "vs last 30 days",
                        "⌁",
                        PRIMARY
                );


        stats.add(
                revenue,
                0,
                0
        );


        stats.add(
                orders,
                1,
                0
        );


        stats.add(
                customers,
                2,
                0
        );


        stats.add(
                margin,
                3,
                0
        );


        for (int i = 0; i < 4; i++) {

            GridPane.setHgrow(
                    stats.getChildren().get(i),
                    Priority.ALWAYS
            );
        }


        // =====================================================
        // CHART ROW
        // =====================================================

        HBox chartRow =
                new HBox(20);


        VBox revenueChartCard =
                createRevenueChart();


        VBox pieChartCard =
                createRevenuePieChart();


        HBox.setHgrow(
                revenueChartCard,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                pieChartCard,
                Priority.ALWAYS
        );


        chartRow.getChildren().addAll(
                revenueChartCard,
                pieChartCard
        );


        // =====================================================
        // PRODUCT + CUSTOMER
        // =====================================================

        HBox secondRow =
                new HBox(20);


        VBox products =
                createProductsTable();


        VBox customerGrowth =
                createCustomerGrowthChart();


        HBox.setHgrow(
                products,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                customerGrowth,
                Priority.ALWAYS
        );


        secondRow.getChildren().addAll(
                products,
                customerGrowth
        );


        // =====================================================
        // RECENT ACTIVITY
        // =====================================================

        VBox activity =
                createRecentActivity();


        // =====================================================
        // PAGINATION
        // =====================================================

        HBox pagination =
                createPagination();


        // =====================================================
        // IMPORTANT
        // =====================================================
        //
        // Navigation is NOT added here.
        //
        // It is already fixed in BorderPane TOP.
        //
        // =====================================================

        pageContent.getChildren().addAll(
                titleRow,
                stats,
                chartRow,
                secondRow,
                activity,
                pagination
        );
    }


    // =========================================================
    // NAVIGATION
    // =========================================================

    private HBox createNavigation() {

        HBox nav =
                new HBox(8);


        nav.setMaxWidth(
                1250
        );


        nav.setMaxHeight(
                54
        );


        nav.setPadding(
                new Insets(5)
        );


        nav.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 12;"
        );


        // =====================================================
        // BUTTONS
        // =====================================================

        overviewBtn =
                createNavButton(
                        "Overview"
                );


        revenueBtn =
                createNavButton(
                        "Revenue"
                );


        customerBtn =
                createNavButton(
                        "Customers"
                );


        productsBtn =
                createNavButton(
                        "Products"
                );


        // =====================================================
        // OVERVIEW
        // =====================================================

        overviewBtn.setOnAction(
                e -> {

                    currentPage = 1;

                    setActiveNavigation(
                            overviewBtn
                    );

                    showOverview();
                }
        );


        // =====================================================
        // REVENUE
        // =====================================================

        revenueBtn.setOnAction(
                e -> {

                    currentPage = 1;

                    setActiveNavigation(
                            revenueBtn
                    );

                    showRevenuePage();
                }
        );


        // =====================================================
        // CUSTOMERS
        // =====================================================

        customerBtn.setOnAction(
                e -> {

                    currentPage = 1;

                    setActiveNavigation(
                            customerBtn
                    );

                    showCustomerPage();
                }
        );


        // =====================================================
        // PRODUCTS
        // =====================================================

        productsBtn.setOnAction(
                e -> {

                    currentPage = 1;

                    setActiveNavigation(
                            productsBtn
                    );

                    showProductsPage();
                }
        );


        nav.getChildren().addAll(
                overviewBtn,
                revenueBtn,
                customerBtn,
                productsBtn
        );


        setActiveNavigation(
                overviewBtn
        );


        return nav;
    }


    // =========================================================
    // NAVIGATION BUTTON
    // =========================================================

    private Button createNavButton(
            String text
    ) {

        Button button =
                new Button(
                        text
                );


        button.setPrefHeight(
                36
        );


        button.setPadding(
                new Insets(
                        7,
                        20,
                        7,
                        20
                )
        );


        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );


        return button;
    }


    // =========================================================
    // ACTIVE NAVIGATION
    // =========================================================

    private void setActiveNavigation(
            Button active
    ) {

        Button[] buttons = {
                overviewBtn,
                revenueBtn,
                customerBtn,
                productsBtn
        };


        String normalStyle =
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";


        String activeStyle =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";


        for (Button b : buttons) {

            if (b == null) {
                continue;
            }


            b.setStyle(
                    normalStyle
            );
        }


        if (active != null) {

            active.setStyle(
                    activeStyle
            );
        }
    }


    // =========================================================
    // KPI CARD
    // =========================================================

    private VBox createKpiCard(
            String title,
            String value,
            String change,
            String sub,
            String icon,
            String color
    ) {

        VBox card =
                new VBox(7);


        card.setPadding(
                new Insets(20)
        );


        card.setMinHeight(
                130
        );


        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 18;"
        );


        card.setEffect(
                glassShadow
        );


        HBox top =
                new HBox();


        top.setAlignment(
                Pos.CENTER_LEFT
        );


        Label titleLabel =
                new Label(
                        title
                );


        titleLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        Region sp =
                new Region();


        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );


        Label iconLabel =
                new Label(
                        icon
                );


        iconLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 18px;" +
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-background-radius: 50;" +
                "-fx-padding: 8;"
        );


        top.getChildren().addAll(
                titleLabel,
                sp,
                iconLabel
        );


        Label valueLabel =
                new Label(
                        value
                );


        valueLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;"
        );


        HBox bottom =
                new HBox(8);


        bottom.setAlignment(
                Pos.CENTER_LEFT
        );


        Label changeLabel =
                new Label(
                        change
                );


        changeLabel.setStyle(
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        Label subLabel =
                new Label(
                        sub
                );


        subLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );


        bottom.getChildren().addAll(
                changeLabel,
                subLabel
        );


        card.getChildren().addAll(
                top,
                valueLabel,
                bottom
        );


        card.setOnMouseEntered(
                e -> {

                    card.setTranslateY(
                            -3
                    );


                    card.setStyle(
                            "-fx-background-color: " + CARD_BG + ";" +
                            "-fx-background-radius: 18;" +
                            "-fx-border-color: " + PRIMARY_DIM + ";" +
                            "-fx-border-radius: 18;"
                    );
                }
        );


        card.setOnMouseExited(
                e -> {

                    card.setTranslateY(
                            0
                    );


                    card.setStyle(
                            "-fx-background-color: " + CARD_BG + ";" +
                            "-fx-background-radius: 18;" +
                            "-fx-border-color: " + SURFACE_BORDER + ";" +
                            "-fx-border-radius: 18;"
                    );
                }
        );


        return card;
    }


    // =========================================================
    // REVENUE LINE CHART
    // =========================================================

    private VBox createRevenueChart() {

        VBox card =
                new VBox(12);


        card.setPadding(
                new Insets(22)
        );


        card.setPrefHeight(
                330
        );


        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 20;"
        );


        HBox heading =
                new HBox();


        heading.setAlignment(
                Pos.CENTER_LEFT
        );


        VBox text =
                new VBox(4);


        Label title =
                new Label(
                        "Revenue Overview"
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        HBox amount =
                new HBox(10);


        amount.setAlignment(
                Pos.CENTER_LEFT
        );


        Label total =
                new Label(
                        "$48,250.75"
                );


        total.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;"
        );


        Label growth =
                new Label(
                        "+12.5%"
                );


        growth.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        Label period =
                new Label(
                        "vs last 30 days"
                );


        period.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );


        amount.getChildren().addAll(
                total,
                growth,
                period
        );


        text.getChildren().addAll(
                title,
                amount
        );


        Region spacer =
                new Region();


        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button month =
                new Button(
                        "This Month ▾"
                );


        month.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 8;" +
                "-fx-text-fill: " + TEXT_MUTED + ";"
        );


        heading.getChildren().addAll(
                text,
                spacer,
                month
        );


        CategoryAxis xAxis =
                new CategoryAxis();


        NumberAxis yAxis =
                new NumberAxis();


        yAxis.setLabel(
                "$"
        );


        yAxis.setForceZeroInRange(
                false
        );


        LineChart<String, Number> chart =
                new LineChart<>(
                        xAxis,
                        yAxis
                );


        chart.setLegendVisible(
                false
        );


        chart.setAnimated(
                false
        );


        chart.setCreateSymbols(
                true
        );


        chart.setVerticalGridLinesVisible(
                false
        );


        chart.setHorizontalGridLinesVisible(
                true
        );


        chart.setAlternativeRowFillVisible(
                false
        );


        chart.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-padding: 0;"
        );


        XYChart.Series<String, Number> series =
                new XYChart.Series<>();


        series.getData().add(
                new XYChart.Data<>(
                        "Oct 18",
                        2200
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Oct 22",
                        3100
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Oct 25",
                        2700
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Oct 29",
                        4300
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Nov 01",
                        3900
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Nov 05",
                        4800
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Nov 08",
                        4100
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Nov 10",
                        5230
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Nov 15",
                        2900
                )
        );


        series.getData().add(
                new XYChart.Data<>(
                        "Nov 18",
                        4300
                )
        );


        chart.getData().add(
                series
        );


        card.getChildren().addAll(
                heading,
                chart
        );


        VBox.setVgrow(
                chart,
                Priority.ALWAYS
        );


        return card;
    }


    // =========================================================
    // PIE CHART
    // =========================================================

    private VBox createRevenuePieChart() {

        VBox card =
                new VBox(10);


        card.setPadding(
                new Insets(22)
        );


        card.setPrefHeight(
                330
        );


        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 20;"
        );


        Label title =
                new Label(
                        "Revenue by Category"
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        PieChart pie =
                new PieChart();


        pie.setLegendVisible(
                true
        );


        pie.setLabelsVisible(
                true
        );


        pie.setStartAngle(
                90
        );


        pie.setAnimated(
                false
        );


        pie.setStyle(
                "-fx-background-color: transparent;"
        );


        pie.getData().addAll(

                new PieChart.Data(
                        "Memberships",
                        16887
                ),

                new PieChart.Data(
                        "Personal Training",
                        12062
                ),

                new PieChart.Data(
                        "Supplements",
                        9650
                ),

                new PieChart.Data(
                        "Merchandise",
                        7241
                ),

                new PieChart.Data(
                        "Others",
                        2410
                )
        );


        card.getChildren().addAll(
                title,
                pie
        );


        VBox.setVgrow(
                pie,
                Priority.ALWAYS
        );


        return card;
    }


    // =========================================================
    // PRODUCTS TABLE
    // =========================================================

    private VBox createProductsTable() {

        VBox card =
                new VBox();


        card.setPrefHeight(
                330
        );


        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 20;"
        );


        HBox header =
                new HBox();


        header.setPadding(
                new Insets(
                        20,
                        22,
                        16,
                        22
                )
        );


        Label title =
                new Label(
                        "Top Products / Services"
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        header.getChildren().add(
                title
        );


        HBox columns =
                new HBox();


        columns.setPadding(
                new Insets(
                        12,
                        22,
                        12,
                        22
                )
        );


        columns.setStyle(
                "-fx-background-color: rgba(255,255,255,0.025);"
        );


        addColumn(
                columns,
                "#",
                30
        );


        addColumn(
                columns,
                "Product / Service",
                180
        );


        addColumn(
                columns,
                "Category",
                110
        );


        addColumn(
                columns,
                "Revenue",
                90
        );


        addColumn(
                columns,
                "Sold",
                60
        );


        addColumn(
                columns,
                "Growth",
                70
        );


        VBox rows =
                new VBox();


        addProductRow(
                rows,
                "1",
                "Elite Membership",
                "Memberships",
                "$16,887",
                "520",
                "+15.2%"
        );


        addProductRow(
                rows,
                "2",
                "Personal Training",
                "Training",
                "$12,062",
                "310",
                "+8.7%"
        );


        addProductRow(
                rows,
                "3",
                "Whey Protein",
                "Supplements",
                "$7,560",
                "1,240",
                "+12.1%"
        );


        addProductRow(
                rows,
                "4",
                "Creatine Monohydrate",
                "Supplements",
                "$4,120",
                "980",
                "+5.3%"
        );


        addProductRow(
                rows,
                "5",
                "Gym Merchandise",
                "Merchandise",
                "$3,890",
                "760",
                "+9.8%"
        );


        card.getChildren().addAll(
                header,
                columns,
                rows
        );


        return card;
    }


    private void addColumn(
            HBox row,
            String text,
            double width
    ) {

        Label label =
                new Label(
                        text
                );


        label.setPrefWidth(
                width
        );


        label.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );


        row.getChildren().add(
                label
        );
    }


    private void addProductRow(
            VBox parent,
            String number,
            String product,
            String category,
            String revenue,
            String sold,
            String growth
    ) {

        HBox row =
                new HBox();


        row.setPadding(
                new Insets(
                        10,
                        22,
                        10,
                        22
                )
        );


        row.setAlignment(
                Pos.CENTER_LEFT
        );


        addColumn(
                row,
                number,
                30
        );


        addColumn(
                row,
                product,
                180
        );


        addColumn(
                row,
                category,
                110
        );


        addColumn(
                row,
                revenue,
                90
        );


        addColumn(
                row,
                sold,
                60
        );


        Label growthLabel =
                new Label(
                        growth
                );


        growthLabel.setPrefWidth(
                70
        );


        growthLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        row.getChildren().add(
                growthLabel
        );


        parent.getChildren().add(
                row
        );
    }


    // =========================================================
    // CUSTOMER GROWTH
    // =========================================================

    private VBox createCustomerGrowthChart() {

        VBox card =
                new VBox(12);


        card.setPrefHeight(
                330
        );


        card.setPadding(
                new Insets(22)
        );


        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 20;"
        );


        HBox titleRow =
                new HBox();


        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label title =
                new Label(
                        "Customer Growth"
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        Region spacer =
                new Region();


        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button month =
                new Button(
                        "This Month ▾"
                );


        month.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 8;" +
                "-fx-text-fill: " + TEXT_MUTED + ";"
        );


        titleRow.getChildren().addAll(
                title,
                spacer,
                month
        );


        CategoryAxis xAxis =
                new CategoryAxis();


        NumberAxis yAxis =
                new NumberAxis();


        BarChart<String, Number> chart =
                new BarChart<>(
                        xAxis,
                        yAxis
                );


        chart.setAnimated(
                false
        );


        chart.setLegendVisible(
                true
        );


        chart.setVerticalGridLinesVisible(
                false
        );


        chart.setBarGap(
                4
        );


        chart.setCategoryGap(
                20
        );


        XYChart.Series<String, Number> newCustomers =
                new XYChart.Series<>();


        newCustomers.setName(
                "New Customers"
        );


        newCustomers.getData().add(
                new XYChart.Data<>(
                        "Week 1",
                        290
                )
        );


        newCustomers.getData().add(
                new XYChart.Data<>(
                        "Week 2",
                        310
                )
        );


        newCustomers.getData().add(
                new XYChart.Data<>(
                        "Week 3",
                        330
                )
        );


        newCustomers.getData().add(
                new XYChart.Data<>(
                        "Week 4",
                        350
                )
        );


        newCustomers.getData().add(
                new XYChart.Data<>(
                        "Week 5",
                        340
                )
        );


        XYChart.Series<String, Number> returning =
                new XYChart.Series<>();


        returning.setName(
                "Returning Customers"
        );


        returning.getData().add(
                new XYChart.Data<>(
                        "Week 1",
                        180
                )
        );


        returning.getData().add(
                new XYChart.Data<>(
                        "Week 2",
                        195
                )
        );


        returning.getData().add(
                new XYChart.Data<>(
                        "Week 3",
                        205
                )
        );


        returning.getData().add(
                new XYChart.Data<>(
                        "Week 4",
                        215
                )
        );


        returning.getData().add(
                new XYChart.Data<>(
                        "Week 5",
                        210
                )
        );


        chart.getData().addAll(
                newCustomers,
                returning
        );


        card.getChildren().addAll(
                titleRow,
                chart
        );


        VBox.setVgrow(
                chart,
                Priority.ALWAYS
        );


        return card;
    }


    // =========================================================
    // RECENT ACTIVITY
    // =========================================================

    private VBox createRecentActivity() {

        VBox card =
                new VBox();


        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 20;"
        );


        HBox header =
                new HBox();


        header.setPadding(
                new Insets(
                        20,
                        22,
                        16,
                        22
                )
        );


        Label title =
                new Label(
                        "Recent Business Activities"
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        header.getChildren().add(
                title
        );


        card.getChildren().add(
                header
        );


        addActivity(
                card,
                "♙",
                "New membership (Elite) purchased by Julian Sterling",
                "10 minutes ago",
                "Success",
                PRIMARY
        );


        addActivity(
                card,
                "♧",
                "Personal training session booked by Maya Thorne",
                "25 minutes ago",
                "Success",
                PRIMARY
        );


        addActivity(
                card,
                "▣",
                "Bulk order of supplements (Whey Protein)",
                "45 minutes ago",
                "Pending",
                "#facc15"
        );


        addActivity(
                card,
                "✓",
                "Refund processed for order #ORD-1234",
                "1 hour ago",
                "Completed",
                "#4fc3f7"
        );


        addActivity(
                card,
                "♙",
                "New customer registered: Arthur Vance",
                "2 hours ago",
                "Success",
                PRIMARY
        );


        return card;
    }


    private void addActivity(
            VBox parent,
            String icon,
            String activity,
            String time,
            String status,
            String color
    ) {

        HBox row =
                new HBox(14);


        row.setPadding(
                new Insets(
                        12,
                        22,
                        12,
                        22
                )
        );


        row.setAlignment(
                Pos.CENTER_LEFT
        );


        row.setStyle(
                "-fx-border-color: " +
                "rgba(255,255,255,0.05) " +
                "transparent transparent transparent;"
        );


        Label iconLabel =
                new Label(
                        icon
                );


        iconLabel.setStyle(
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 16px;"
        );


        Label activityLabel =
                new Label(
                        activity
                );


        activityLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 12px;"
        );


        Region spacer =
                new Region();


        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Label timeLabel =
                new Label(
                        time
                );


        timeLabel.setPrefWidth(
                100
        );


        timeLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );


        Label statusLabel =
                new Label(
                        status
                );


        statusLabel.setMinWidth(
                80
        );


        statusLabel.setAlignment(
                Pos.CENTER
        );


        statusLabel.setStyle(
                "-fx-text-fill: " + color + ";" +
                "-fx-border-color: " + color + ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 4 10;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );


        row.getChildren().addAll(
                iconLabel,
                activityLabel,
                spacer,
                timeLabel,
                statusLabel
        );


        parent.getChildren().add(
                row
        );
    }


    // =========================================================
    // PAGINATION
    // =========================================================

    private HBox createPagination() {

        HBox pagination =
                new HBox(8);


        pagination.setAlignment(
                Pos.CENTER_RIGHT
        );


        Button previous =
                createPageButton(
                        "‹"
                );


        Button page1 =
                createPageButton(
                        "1"
                );


        Button page2 =
                createPageButton(
                        "2"
                );


        Button page3 =
                createPageButton(
                        "3"
                );


        Button next =
                createPageButton(
                        "›"
                );


        updatePagination(
                page1,
                page2,
                page3
        );


        previous.setOnAction(
                e -> {

                    if (currentPage > 1) {

                        currentPage--;

                        updatePagination(
                                page1,
                                page2,
                                page3
                        );
                    }
                }
        );


        next.setOnAction(
                e -> {

                    if (currentPage < 3) {

                        currentPage++;

                        updatePagination(
                                page1,
                                page2,
                                page3
                        );
                    }
                }
        );


        page1.setOnAction(
                e -> {

                    currentPage = 1;

                    updatePagination(
                            page1,
                            page2,
                            page3
                    );
                }
        );


        page2.setOnAction(
                e -> {

                    currentPage = 2;

                    updatePagination(
                            page1,
                            page2,
                            page3
                    );
                }
        );


        page3.setOnAction(
                e -> {

                    currentPage = 3;

                    updatePagination(
                            page1,
                            page2,
                            page3
                    );
                }
        );


        pagination.getChildren().addAll(
                previous,
                page1,
                page2,
                page3,
                next
        );


        return pagination;
    }


    private Button createPageButton(
            String text
    ) {

        Button button =
                new Button(
                        text
                );


        button.setPrefWidth(
                34
        );


        button.setPrefHeight(
                34
        );


        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-cursor: hand;"
        );


        return button;
    }


    private void updatePagination(
            Button page1,
            Button page2,
            Button page3
    ) {

        String normal =
                "-fx-background-color: transparent;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-cursor: hand;";


        String active =
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-border-color: " + PRIMARY_DIM + ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;";


        page1.setStyle(
                currentPage == 1
                        ? active
                        : normal
        );


        page2.setStyle(
                currentPage == 2
                        ? active
                        : normal
        );


        page3.setStyle(
                currentPage == 3
                        ? active
                        : normal
        );
    }


    // =========================================================
    // REVENUE PAGE
    // =========================================================

    private void showRevenuePage() {

        pageContent.getChildren().clear();


        Label title =
                createPageTitle(
                        "Revenue Analytics",
                        "Detailed revenue performance and business income analysis."
                );


        HBox charts =
                new HBox(20);


        VBox line =
                createRevenueChart();


        VBox pie =
                createRevenuePieChart();


        HBox.setHgrow(
                line,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                pie,
                Priority.ALWAYS
        );


        charts.getChildren().addAll(
                line,
                pie
        );


        VBox activity =
                createRecentActivity();


        HBox pagination =
                createPagination();


        pageContent.getChildren().addAll(
                title,
                charts,
                activity,
                pagination
        );
    }


    // =========================================================
    // CUSTOMER PAGE
    // =========================================================

    private void showCustomerPage() {

        pageContent.getChildren().clear();


        Label title =
                createPageTitle(
                        "Customer Analytics",
                        "Track customer acquisition, retention and growth."
                );


        GridPane stats =
                new GridPane();


        stats.setHgap(
                16
        );


        stats.add(
                createKpiCard(
                        "TOTAL CUSTOMERS",
                        "1,842",
                        "+15.3%",
                        "vs last month",
                        "♙",
                        PRIMARY
                ),
                0,
                0
        );


        stats.add(
                createKpiCard(
                        "NEW CUSTOMERS",
                        "340",
                        "+12.4%",
                        "this month",
                        "+",
                        PRIMARY
                ),
                1,
                0
        );


        stats.add(
                createKpiCard(
                        "RETURNING",
                        "1,020",
                        "+8.7%",
                        "active customers",
                        "↻",
                        PRIMARY
                ),
                2,
                0
        );


        stats.add(
                createKpiCard(
                        "RETENTION",
                        "82.4%",
                        "+4.2%",
                        "customer retention",
                        "✓",
                        PRIMARY
                ),
                3,
                0
        );


        VBox growth =
                createCustomerGrowthChart();


        VBox activity =
                createRecentActivity();


        HBox pagination =
                createPagination();


        pageContent.getChildren().addAll(
                title,
                stats,
                growth,
                activity,
                pagination
        );
    }


    // =========================================================
    // PRODUCTS PAGE
    // =========================================================

    private void showProductsPage() {

        pageContent.getChildren().clear();


        Label title =
                createPageTitle(
                        "Products & Services Analytics",
                        "Analyse top-performing memberships, training and supplements."
                );


        VBox products =
                createProductsTable();


        HBox charts =
                new HBox(20);


        VBox pie =
                createRevenuePieChart();


        VBox revenue =
                createRevenueChart();


        HBox.setHgrow(
                pie,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                revenue,
                Priority.ALWAYS
        );


        charts.getChildren().addAll(
                pie,
                revenue
        );


        HBox pagination =
                createPagination();


        pageContent.getChildren().addAll(
                title,
                products,
                charts,
                pagination
        );
    }


    // =========================================================
    // PAGE TITLE
    // =========================================================

    private Label createPageTitle(
            String titleText,
            String subText
    ) {

        Label title =
                new Label(
                        titleText +
                        "\n" +
                        subText
                );


        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;"
        );


        return title;
    }
}
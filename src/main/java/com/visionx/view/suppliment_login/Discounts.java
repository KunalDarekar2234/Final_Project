package com.visionx.view.suppliment_login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Discounts {

    private Scene discountsScene;
    private Runnable callBackAction;

    /*
     * =========================================
     * DISCOUNT DATA
     * =========================================
     *
     * [0] Offer
     * [1] Coupon Code
     * [2] Discount
     * [3] Validity
     * [4] Status
     * [5] Used Offers
     * [6] Customer Savings
     *
     */

    private final ObservableList<String[]> discounts =
            FXCollections.observableArrayList(

                    new String[]{
                            "Summer Fitness Sale",
                            "SUMMER20",
                            "20% OFF",
                            "01 Aug - 31 Aug",
                            "Active",
                            "120",
                            "₹8,400"
                    },

                    new String[]{
                            "New Customer Offer",
                            "WELCOME15",
                            "15% OFF",
                            "01 Aug - 30 Sep",
                            "Active",
                            "85",
                            "₹4,250"
                    },

                    new String[]{
                            "Protein Power Deal",
                            "PROTEIN10",
                            "10% OFF",
                            "15 Aug - 30 Aug",
                            "Scheduled",
                            "0",
                            "₹0"
                    },

                    new String[]{
                            "Weekend Special",
                            "WEEKEND25",
                            "25% OFF",
                            "Every Weekend",
                            "Active",
                            "64",
                            "₹3,200"
                    },

                    new String[]{
                            "Festive Mega Sale",
                            "FESTIVE30",
                            "30% OFF",
                            "01 Jul - 31 Jul",
                            "Expired",
                            "210",
                            "₹9,800"
                    }
            );


    /*
     * =========================================
     * GET DISCOUNTS SCENE
     * =========================================
     */

    public Scene getDiscountsScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Discounts");


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


        Label searchBox =
                new Label(
                        "🔍  Search discounts..."
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
         * MAIN CENTRE
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
         * THIS WILL ALWAYS REMAIN
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
                new Label("Discounts");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label subHeading =
                new Label(
                        "Create and manage discounts, offers and promotional campaigns."
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


        Button createDiscountButton =
                new Button("+  Create Discount");

        createDiscountButton.setPrefHeight(42);

        createDiscountButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                createDiscountButton
        );


        /*
         * =========================================
         * CONTENT CONTAINER
         *
         * Existing page content and create form
         * will be placed here.
         *
         * PAGE HEADER WILL NOT CHANGE.
         * =========================================
         */

        VBox contentContainer =
                new VBox(25);


        /*
         * =========================================
         * NORMAL DISCOUNTS CONTENT
         * =========================================
         */

        VBox normalContent =
                createNormalDiscountContent();


        /*
         * =========================================
         * ADD NORMAL CONTENT
         * =========================================
         */

        contentContainer
                .getChildren()
                .add(normalContent);


        /*
         * =========================================
         * CREATE DISCOUNT FORM
         * =========================================
         */

        VBox createDiscountContent =
                createDiscountForm(
                        contentContainer,
                        normalContent
                );


        /*
         * =========================================
         * CREATE DISCOUNT BUTTON FUNCTIONALITY
         * =========================================
         */

        createDiscountButton.setOnAction(
                event -> {

                    contentContainer
                            .getChildren()
                            .clear();

                    contentContainer
                            .getChildren()
                            .add(
                                    createDiscountContent
                            );
                }
        );


        /*
         * =========================================
         * ADD PAGE HEADER + CONTENT
         * =========================================
         */

        centre.getChildren().addAll(
                pageHeader,
                contentContainer
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


        discountsScene =
                sc;

        return discountsScene;
    }


    /*
     * =========================================
     * NORMAL DISCOUNT PAGE CONTENT
     * =========================================
     */

    private VBox createNormalDiscountContent() {

        VBox content =
                new VBox(25);


        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox activeCard =
                createSummaryCard(
                        "%",
                        "0",
                        "Active Discounts",
                        "#006c49"
                );


        VBox scheduledCard =
                createSummaryCard(
                        "◷",
                        "0",
                        "Scheduled",
                        "#004ac6"
                );


        VBox usedOffersCard =
                createSummaryCard(
                        "✓",
                        "0",
                        "Used Offers",
                        "#7a4d00"
                );


        VBox savingsCard =
                createSummaryCard(
                        "₹",
                        "₹0",
                        "Customer Savings",
                        "#006c49"
                );


        summaryBox.getChildren().addAll(
                activeCard,
                scheduledCard,
                usedOffersCard,
                savingsCard
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


        TextField discountSearch =
                new TextField();

        discountSearch.setPromptText(
                "Search discount or coupon..."
        );

        discountSearch.setPrefWidth(350);

        discountSearch.setPrefHeight(40);

        discountSearch.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;"
        );


        Button allButton =
                new Button("All");

        allButton.setPrefHeight(40);


        Button activeButton =
                new Button("Active");

        activeButton.setPrefHeight(40);


        Button scheduledButton =
                new Button("Scheduled");

        scheduledButton.setPrefHeight(40);


        Button expiredButton =
                new Button("Expired");

        expiredButton.setPrefHeight(40);


        filterBox.getChildren().addAll(
                discountSearch,
                allButton,
                activeButton,
                scheduledButton,
                expiredButton
        );


        /*
         * =========================================
         * DISCOUNT LIST
         * =========================================
         */

        VBox discountList =
                new VBox(0);

        discountList.setStyle(
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


        Label offerHeader =
                new Label("Offer");

        offerHeader.setPrefWidth(260);

        offerHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label codeHeader =
                new Label("Coupon Code");

        codeHeader.setPrefWidth(150);

        codeHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label discountHeader =
                new Label("Discount");

        discountHeader.setPrefWidth(130);

        discountHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label validityHeader =
                new Label("Validity");

        validityHeader.setPrefWidth(170);

        validityHeader.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #737686;"
        );


        Label statusHeader =
                new Label("Status");

        statusHeader.setPrefWidth(120);

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
                offerHeader,
                codeHeader,
                discountHeader,
                validityHeader,
                statusHeader,
                actionHeader
        );


        /*
         * =========================================
         * SELECTED FILTER
         * =========================================
         */

        String[] selectedFilter =
                {"All"};


        /*
         * =========================================
         * UPDATE SUMMARY
         * =========================================
         */

        Runnable updateSummary =
                () -> {

                    int activeCount = 0;

                    int scheduledCount = 0;

                    int usedOffers = 0;

                    int customerSavings = 0;


                    for (String[] discount :
                            discounts) {

                        String status =
                                discount[4];


                        if (status.equals("Active")) {

                            activeCount++;
                        }


                        if (status.equals("Scheduled")) {

                            scheduledCount++;
                        }


                        usedOffers +=
                                Integer.parseInt(
                                        discount[5]
                                );


                        String savings =
                                discount[6]
                                        .replace(
                                                "₹",
                                                ""
                                        )
                                        .replace(
                                                ",",
                                                ""
                                        );


                        customerSavings +=
                                Integer.parseInt(
                                        savings
                                );
                    }


                    updateSummaryCard(
                            activeCard,
                            "%",
                            String.valueOf(
                                    activeCount
                            ),
                            "Active Discounts",
                            "#006c49"
                    );


                    updateSummaryCard(
                            scheduledCard,
                            "◷",
                            String.valueOf(
                                    scheduledCount
                            ),
                            "Scheduled",
                            "#004ac6"
                    );


                    updateSummaryCard(
                            usedOffersCard,
                            "✓",
                            String.valueOf(
                                    usedOffers
                            ),
                            "Used Offers",
                            "#7a4d00"
                    );


                    updateSummaryCard(
                            savingsCard,
                            "₹",
                            "₹" +
                            String.format(
                                    "%,d",
                                    customerSavings
                            ),
                            "Customer Savings",
                            "#006c49"
                    );
                };


        /*
         * =========================================
         * UPDATE DISCOUNT LIST
         * =========================================
         */

        Runnable updateDiscounts =
                () -> {

                    discountList
                            .getChildren()
                            .clear();


                    discountList
                            .getChildren()
                            .add(
                                    tableHeader
                            );


                    String searchText =
                            discountSearch
                                    .getText()
                                    .trim()
                                    .toLowerCase();


                    for (String[] discount :
                            discounts) {

                        String offer =
                                discount[0];

                        String code =
                                discount[1];

                        String discountValue =
                                discount[2];

                        String validity =
                                discount[3];

                        String status =
                                discount[4];


                        boolean searchMatches =
                                searchText.isEmpty()
                                ||
                                offer.toLowerCase()
                                        .contains(
                                                searchText
                                        )
                                ||
                                code.toLowerCase()
                                        .contains(
                                                searchText
                                        )
                                ||
                                status.toLowerCase()
                                        .contains(
                                                searchText
                                        );


                        boolean filterMatches =
                                selectedFilter[0]
                                        .equals("All")
                                ||
                                selectedFilter[0]
                                        .equals(status);


                        if (searchMatches &&
                                filterMatches) {

                            String color =
                                    "#737686";


                            if (status.equals(
                                    "Active")) {

                                color =
                                        "#006c49";

                            } else if (
                                    status.equals(
                                            "Scheduled")) {

                                color =
                                        "#004ac6";

                            } else if (
                                    status.equals(
                                            "Expired")) {

                                color =
                                        "#ba1a1a";
                            }


                            discountList
                                    .getChildren()
                                    .add(
                                            createDiscountRow(
                                                    offer,
                                                    code,
                                                    discountValue,
                                                    validity,
                                                    status,
                                                    color
                                            )
                                    );
                        }
                    }


                    if (discountList
                            .getChildren()
                            .size() == 1) {

                        Label noResult =
                                new Label(
                                        "No discounts found"
                                );

                        noResult.setStyle(
                                "-fx-font-size: 16px;" +
                                "-fx-font-weight: bold;" +
                                "-fx-text-fill: #737686;" +
                                "-fx-padding: 25;"
                        );

                        discountList
                                .getChildren()
                                .add(
                                        noResult
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


        Runnable updateButtonStyles =
                () -> {

                    allButton.setStyle(
                            normalStyle
                    );

                    activeButton.setStyle(
                            normalStyle
                    );

                    scheduledButton.setStyle(
                            normalStyle
                    );

                    expiredButton.setStyle(
                            normalStyle
                    );


                    if (selectedFilter[0]
                            .equals("All")) {

                        allButton.setStyle(
                                selectedStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("Active")) {

                        activeButton.setStyle(
                                selectedStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("Scheduled")) {

                        scheduledButton.setStyle(
                                selectedStyle
                        );

                    } else if (
                            selectedFilter[0]
                                    .equals("Expired")) {

                        expiredButton.setStyle(
                                selectedStyle
                        );
                    }
                };


        /*
         * =========================================
         * FILTER BUTTONS
         * =========================================
         */

        allButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "All";

                    updateButtonStyles.run();

                    updateDiscounts.run();
                }
        );


        activeButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "Active";

                    updateButtonStyles.run();

                    updateDiscounts.run();
                }
        );


        scheduledButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "Scheduled";

                    updateButtonStyles.run();

                    updateDiscounts.run();
                }
        );


        expiredButton.setOnAction(
                event -> {

                    selectedFilter[0] =
                            "Expired";

                    updateButtonStyles.run();

                    updateDiscounts.run();
                }
        );


        /*
         * =========================================
         * SEARCH
         * =========================================
         */

        discountSearch
                .textProperty()
                .addListener(
                        (observable,
                         oldValue,
                         newValue) -> {

                            updateDiscounts.run();
                        }
                );


        /*
         * =========================================
         * INITIAL LOAD
         * =========================================
         */

        updateSummary.run();

        updateButtonStyles.run();

        updateDiscounts.run();


        /*
         * =========================================
         * PROMOTION INSIGHT
         * =========================================
         */

        VBox promotionInsight =
                new VBox(10);

        promotionInsight.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 20;"
        );


        Label insightTitle =
                new Label(
                        "🧠  AI Promotion Insight"
                );

        insightTitle.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        Label insightText =
                new Label(
                        "Your Summer Fitness Sale is performing well. " +
                        "Weekend discounts are generating higher customer " +
                        "engagement. Consider extending the best-performing " +
                        "offer to increase sales."
                );

        insightText.setWrapText(true);

        insightText.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #434655;"
        );


        promotionInsight.getChildren().addAll(
                insightTitle,
                insightText
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


        backButton.setOnAction(
                event -> {
                        System.out.println(
                            "Back Button Clicked"
                    );

                    if (callBackAction != null) {

                        callBackAction.run();
                    }

                   // callBackAction.run();
                }
        );


        /*
         * =========================================
         * ADD NORMAL CONTENT
         * =========================================
         */

        content.getChildren().addAll(

                summaryBox,

                filterBox,

                discountList,

                promotionInsight,

                backButton
        );


        return content;
    }


    /*
     * =========================================
     * CREATE DISCOUNT FORM
     * =========================================
     */

    private VBox createDiscountForm(
            VBox contentContainer,
            VBox normalContent) {

        VBox formContainer =
                new VBox(20);

        formContainer.setPadding(
                new Insets(25)
        );

        formContainer.setStyle(
                "-fx-background-color: rgba(255,255,255,0.95);" +
                "-fx-background-radius: 25;"
        );


        /*
         * =========================================
         * FORM TITLE
         * =========================================
         */

        Label formTitle =
                new Label(
                        "Create New Discount"
                );

        formTitle.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        Label formSubtitle =
                new Label(
                        "Enter the details below to create a new discount offer."
                );

        formSubtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * =========================================
         * OFFER NAME
         * =========================================
         */

        Label offerLabel =
                createFieldLabel(
                        "Offer Name"
                );


        TextField offerField =
                new TextField();

        offerField.setPromptText(
                "Enter offer name"
        );

        styleFormField(
                offerField
        );


        /*
         * =========================================
         * COUPON CODE
         * =========================================
         */

        Label couponLabel =
                createFieldLabel(
                        "Coupon Code"
                );


        TextField couponField =
                new TextField();

        couponField.setPromptText(
                "Enter coupon code"
        );

        styleFormField(
                couponField
        );


        /*
         * =========================================
         * DISCOUNT %
         * =========================================
         */

        Label discountLabel =
                createFieldLabel(
                        "Discount Percentage"
                );


        TextField discountField =
                new TextField();

        discountField.setPromptText(
                "Example: 20"
        );

        styleFormField(
                discountField
        );


        /*
         * =========================================
         * START DATE
         * =========================================
         */

        Label startDateLabel =
                createFieldLabel(
                        "Start Date"
                );


        DatePicker startDate =
                new DatePicker();

        startDate.setPromptText(
                "Select start date"
        );

        styleDatePicker(
                startDate
        );


        /*
         * =========================================
         * END DATE
         * =========================================
         */

        Label endDateLabel =
                createFieldLabel(
                        "End Date"
                );


        DatePicker endDate =
                new DatePicker();

        endDate.setPromptText(
                "Select end date"
        );

        styleDatePicker(
                endDate
        );


        /*
         * =========================================
         * STATUS
         * =========================================
         */

        Label statusLabel =
                createFieldLabel(
                        "Status"
                );


        ComboBox<String> statusBox =
                new ComboBox<>();

        statusBox.getItems().addAll(
                "Active",
                "Scheduled",
                "Expired"
        );

        statusBox.setValue(
                "Active"
        );

        statusBox.setPrefHeight(42);

        statusBox.setMaxWidth(
                Double.MAX_VALUE
        );

        statusBox.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );


        /*
         * =========================================
         * DATE ROW
         * =========================================
         */

        HBox dateRow =
                new HBox(20);

        VBox startDateBox =
                new VBox(8);

        VBox endDateBox =
                new VBox(8);

        HBox.setHgrow(
                startDateBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                endDateBox,
                Priority.ALWAYS
        );


        startDateBox.getChildren().addAll(
                startDateLabel,
                startDate
        );

        endDateBox.getChildren().addAll(
                endDateLabel,
                endDate
        );


        dateRow.getChildren().addAll(
                startDateBox,
                endDateBox
        );


        /*
         * =========================================
         * FORM BUTTONS
         * =========================================
         */

        HBox buttonBox =
                new HBox(12);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        Button backButton =
                new Button(
                        "←  Back to Discounts"
                );

        backButton.setPrefHeight(42);

        backButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 20;"
        );


        Button saveButton =
                new Button(
                        "Create Discount"
                );

        saveButton.setPrefHeight(42);

        saveButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        /*
         * =========================================
         * BACK FUNCTIONALITY
         * =========================================
         */

        backButton.setOnAction(
                event -> {

                    contentContainer
                            .getChildren()
                            .clear();

                    contentContainer
                            .getChildren()
                            .add(
                                    normalContent
                            );
                }
        );


        /*
         * =========================================
         * SAVE / CREATE FUNCTIONALITY
         * =========================================
         */

        saveButton.setOnAction(
                event -> {

                    String offer =
                            offerField
                                    .getText()
                                    .trim();


                    String coupon =
                            couponField
                                    .getText()
                                    .trim()
                                    .toUpperCase();


                    String discountText =
                            discountField
                                    .getText()
                                    .trim();


                    LocalDate start =
                            startDate.getValue();


                    LocalDate end =
                            endDate.getValue();


                    String status =
                            statusBox.getValue();


                    /*
                     * VALIDATION
                     */

                    if (offer.isEmpty()
                            ||
                            coupon.isEmpty()
                            ||
                            discountText.isEmpty()
                            ||
                            start == null
                            ||
                            end == null) {

                        showAlert(
                                "Missing Information",
                                "Please fill all the required fields."
                        );

                        return;
                    }


                    /*
                     * VALIDATE DISCOUNT
                     */

                    double discountValue;

                    try {

                        discountValue =
                                Double.parseDouble(
                                        discountText
                                );

                    } catch (NumberFormatException e) {

                        showAlert(
                                "Invalid Discount",
                                "Please enter a valid discount percentage."
                        );

                        return;
                    }


                    if (discountValue <= 0
                            ||
                            discountValue > 100) {

                        showAlert(
                                "Invalid Discount",
                                "Discount must be between 1 and 100."
                        );

                        return;
                    }


                    /*
                     * VALIDATE DATE
                     */

                    if (end.isBefore(start)) {

                        showAlert(
                                "Invalid Dates",
                                "End date cannot be before start date."
                        );

                        return;
                    }


                    /*
                     * FORMAT DATE
                     */

                    DateTimeFormatter formatter =
                            DateTimeFormatter.ofPattern(
                                    "dd MMM"
                            );


                    String validity =
                            start.format(formatter)
                            +
                            " - "
                            +
                            end.format(formatter);


                    /*
                     * DISCOUNT TEXT
                     */

                    String discount =
                            String.format(
                                    "%.0f%% OFF",
                                    discountValue
                            );


                    /*
                     * ADD NEW DISCOUNT
                     */

                    discounts.add(
                            new String[]{
                                    offer,
                                    coupon,
                                    discount,
                                    validity,
                                    status,
                                    "0",
                                    "₹0"
                            }
                    );


                    /*
                     * SHOW SUCCESS MESSAGE
                     */

                    showAlert(
                            "Discount Created",
                            "The discount \"" +
                            offer +
                            "\" has been created successfully."
                    );


                    /*
                     * CLEAR FORM
                     */

                    offerField.clear();

                    couponField.clear();

                    discountField.clear();

                    startDate.setValue(
                            null
                    );

                    endDate.setValue(
                            null
                    );

                    statusBox.setValue(
                            "Active"
                    );


                    /*
                     * RETURN TO ORIGINAL CONTENT
                     */

                    contentContainer
                            .getChildren()
                            .clear();

                    contentContainer
                            .getChildren()
                            .add(
                                    normalContent
                            );


                    /*
                     * REFRESH NORMAL PAGE
                     *
                     * Recreate the content so that
                     * summary and list show the
                     * newly created discount.
                     */

                    VBox refreshedContent =
                            createNormalDiscountContent();

                    contentContainer
                            .getChildren()
                            .clear();

                    contentContainer
                            .getChildren()
                            .add(
                                    refreshedContent
                            );
                }
        );


        buttonBox.getChildren().addAll(
                backButton,
                saveButton
        );


        /*
         * =========================================
         * FORM LAYOUT
         * =========================================
         */

        formContainer.getChildren().addAll(

                formTitle,

                formSubtitle,

                offerLabel,

                offerField,

                couponLabel,

                couponField,

                discountLabel,

                discountField,

                dateRow,

                statusLabel,

                statusBox,

                buttonBox
        );


        return formContainer;
    }


    /*
     * =========================================
     * FORM FIELD LABEL
     * =========================================
     */

    private Label createFieldLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );

        return label;
    }


    /*
     * =========================================
     * STYLE TEXT FIELD
     * =========================================
     */

    private void styleFormField(
            TextField field) {

        field.setPrefHeight(42);

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 0 15;" +
                "-fx-font-size: 13px;"
        );
    }


    /*
     * =========================================
     * STYLE DATE PICKER
     * =========================================
     */

    private void styleDatePicker(
            DatePicker datePicker) {

        datePicker.setPrefHeight(42);

        datePicker.setMaxWidth(
                Double.MAX_VALUE
        );

        datePicker.setStyle(
                "-fx-background-color: #f7f8fc;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );
    }


    /*
     * =========================================
     * ALERT
     * =========================================
     */

    private void showAlert(
            String title,
            String message) {

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
     * UPDATE SUMMARY CARD
     * =========================================
     */

    private void updateSummaryCard(
            VBox card,
            String icon,
            String value,
            String title,
            String color) {

        Label iconLabel =
                (Label) card
                        .getChildren()
                        .get(0);

        Label valueLabel =
                (Label) card
                        .getChildren()
                        .get(1);

        Label titleLabel =
                (Label) card
                        .getChildren()
                        .get(2);


        iconLabel.setText(
                icon
        );


        iconLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 8;" +
                "-fx-font-size: 17px;" +
                "-fx-text-fill: " + color + ";"
        );


        valueLabel.setText(
                value
        );


        titleLabel.setText(
                title
        );
    }


    /*
     * =========================================
     * DISCOUNT ROW
     * =========================================
     */

    public HBox createDiscountRow(
            String offer,
            String code,
            String discount,
            String validity,
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
         * OFFER
         */

        Label offerLabel =
                new Label(offer);

        offerLabel.setPrefWidth(260);

        offerLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #111c2d;"
        );


        /*
         * COUPON CODE
         */

        Label codeLabel =
                new Label(code);

        codeLabel.setPrefWidth(150);

        codeLabel.setStyle(
                "-fx-background-color: #f0f3ff;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 6 10;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        /*
         * DISCOUNT
         */

        Label discountLabel =
                new Label(discount);

        discountLabel.setPrefWidth(130);

        discountLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #004ac6;"
        );


        /*
         * VALIDITY
         */

        Label validityLabel =
                new Label(validity);

        validityLabel.setPrefWidth(170);

        validityLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #737686;"
        );


        /*
         * STATUS
         */

        Label statusLabel =
                new Label(status);

        statusLabel.setPrefWidth(120);

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

        Button editButton =
                new Button("Edit");

        editButton.setPrefHeight(32);

        editButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #c3c6d7;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 0 15;"
        );


        row.getChildren().addAll(
                offerLabel,
                codeLabel,
                discountLabel,
                validityLabel,
                statusLabel,
                editButton
        );


        return row;
    }
}

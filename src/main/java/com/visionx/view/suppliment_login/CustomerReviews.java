package com.visionx.view.suppliment_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CustomerReviews {

    private Scene customerReviewsScene;

    public Scene getCustomerReviewsScene(Runnable callBackAction) {

        /*
         * =========================================
         * COMMON SIDEBAR
         * =========================================
         */

        VBox sideBar =
                Dashboard.createSidebar("Customer Reviews");


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


        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search reviews..."
        );

        searchField.setPrefWidth(430);

        searchField.setPrefHeight(40);

        searchField.setStyle(
                "-fx-background-color: #f0f3ff;" +
                "-fx-background-radius: 25;" +
                "-fx-padding: 0 20;" +
                "-fx-border-color: transparent;"
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


        Text userName =
                new Text("Alex Rivera");

        userName.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text userType =
                new Text("STORE OWNER");

        userType.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #737686;"
        );


        userDetails.getChildren().addAll(
                userName,
                userType
        );


        topBar.getChildren().addAll(
                searchField,
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


        Text heading =
                new Text("Customer Reviews");

        heading.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text subHeading =
                new Text(
                        "View customer feedback and manage your store reputation."
                );

        subHeading.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-fill: #737686;"
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


        Button replyButton =
                new Button("Reply to Reviews");

        replyButton.setPrefHeight(42);

        replyButton.setStyle(
                "-fx-background-color: #004ac6;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 22;" +
                "-fx-font-weight: bold;"
        );


        pageHeader.getChildren().addAll(
                headingBox,
                headingSpacer,
                replyButton
        );


        /*
         * =========================================
         * SUMMARY CARDS
         * =========================================
         */

        HBox summaryBox =
                new HBox(18);


        VBox ratingCard =
                createSummaryCard(
                        "★",
                        "4.7",
                        "Average Rating",
                        "#7a4d00"
                );


        VBox reviewsCard =
                createSummaryCard(
                        "✦",
                        "1,248",
                        "Total Reviews",
                        "#004ac6"
                );


        VBox positiveCard =
                createSummaryCard(
                        "✓",
                        "91%",
                        "Positive Reviews",
                        "#006c49"
                );


        VBox pendingCard =
                createSummaryCard(
                        "◷",
                        "18",
                        "Pending Replies",
                        "#ba1a1a"
                );


        summaryBox.getChildren().addAll(
                ratingCard,
                reviewsCard,
                positiveCard,
                pendingCard
        );


        /*
         * =========================================
         * FILTER BAR
         * =========================================
         */

        HBox filterBox =
                new HBox(12);

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Button allButton =
                new Button("All Reviews");

        allButton.setPrefHeight(40);


        Button fiveStarButton =
                new Button("★★★★★  5 Star");

        fiveStarButton.setPrefHeight(40);


        Button fourStarButton =
                new Button("★★★★  4 Star");

        fourStarButton.setPrefHeight(40);


        Button threeStarButton =
                new Button("★★★  3 Star");

        threeStarButton.setPrefHeight(40);


        Button lowRatingButton =
                new Button("Low Rating");

        lowRatingButton.setPrefHeight(40);


        filterBox.getChildren().addAll(
                allButton,
                fiveStarButton,
                fourStarButton,
                threeStarButton,
                lowRatingButton
        );


        /*
         * =========================================
         * REVIEW LIST
         * =========================================
         */

        VBox reviewList =
                new VBox(15);


        Text reviewsTitle =
                new Text("Recent Customer Reviews");

        reviewsTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        reviewList.getChildren().add(
                reviewsTitle
        );


        /*
         * =========================================
         * REVIEW DATA
         * =========================================
         *
         * star count:
         *
         * 5 = 5 Star
         * 4 = 4 Star
         * 3 = 3 Star
         * 2 = Low Rating
         * 1 = Low Rating
         *
         * =========================================
         */

        reviewList.getChildren().add(
                createReviewCard(
                        "Rahul Sharma",
                        "★★★★★",
                        "Excellent product quality!",
                        "The whey protein arrived quickly and the packaging was excellent. " +
                        "I will definitely order again.",
                        "2 hours ago"
                )
        );


        reviewList.getChildren().add(
                createReviewCard(
                        "Priya Patel",
                        "★★★★★",
                        "Very satisfied",
                        "Good quality products and fast delivery. " +
                        "The prices are also reasonable compared with other stores.",
                        "5 hours ago"
                )
        );


        reviewList.getChildren().add(
                createReviewCard(
                        "Aarav Mehta",
                        "★★★★",
                        "Good product",
                        "The product is genuine and delivery was on time. " +
                        "Would like to see more discounts in future.",
                        "Yesterday"
                )
        );


        reviewList.getChildren().add(
                createReviewCard(
                        "Sneha Joshi",
                        "★★★★",
                        "Nice experience",
                        "Overall a good shopping experience. Product quality was good " +
                        "and customer support was helpful.",
                        "Yesterday"
                )
        );


        reviewList.getChildren().add(
                createReviewCard(
                        "Vikram Singh",
                        "★★★",
                        "Could be better",
                        "The product was good but delivery took longer than expected.",
                        "2 days ago"
                )
        );


        /*
         * =========================================
         * EXTRA LOW RATING REVIEWS
         * =========================================
         */

        reviewList.getChildren().add(
                createReviewCard(
                        "Rohan Deshmukh",
                        "★★",
                        "Delivery was disappointing",
                        "The product quality was acceptable but the delivery was much slower " +
                        "than expected.",
                        "3 days ago"
                )
        );


        reviewList.getChildren().add(
                createReviewCard(
                        "Karan Shah",
                        "★",
                        "Not satisfied",
                        "The overall experience was not good. The order took too long " +
                        "to arrive.",
                        "4 days ago"
                )
        );


        /*
         * =========================================
         * CUSTOMER FEEDBACK INSIGHT
         * =========================================
         */

        VBox feedbackInsight =
                new VBox(10);

        feedbackInsight.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 20;" +
                "-fx-padding: 22;"
        );


        Text insightTitle =
                new Text(
                        "🧠  Customer Feedback Insight"
                );

        insightTitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #004ac6;"
        );


        Text insightText =
                new Text(
                        "Customers are highly satisfied with product quality and delivery speed. " +
                        "The most common positive feedback is about genuine products. " +
                        "Some customers are requesting more discounts and offers."
                );

        insightText.setWrappingWidth(1050);

        insightText.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-fill: #434655;"
        );


        feedbackInsight.getChildren().addAll(
                insightTitle,
                insightText
        );


        /*
         * =========================================
         * FILTER FUNCTION
         * =========================================
         */

        Runnable showAllReviews =
                () -> {

                    applyReviewFilter(
                            reviewList,
                            "All",
                            searchField.getText()
                    );

                    setActiveButton(
                            allButton,
                            fiveStarButton,
                            fourStarButton,
                            threeStarButton,
                            lowRatingButton
                    );
                };


        Runnable showFiveStar =
                () -> {

                    applyReviewFilter(
                            reviewList,
                            "5",
                            searchField.getText()
                    );

                    setActiveButton(
                            fiveStarButton,
                            allButton,
                            fourStarButton,
                            threeStarButton,
                            lowRatingButton
                    );
                };


        Runnable showFourStar =
                () -> {

                    applyReviewFilter(
                            reviewList,
                            "4",
                            searchField.getText()
                    );

                    setActiveButton(
                            fourStarButton,
                            allButton,
                            fiveStarButton,
                            threeStarButton,
                            lowRatingButton
                    );
                };


        Runnable showThreeStar =
                () -> {

                    applyReviewFilter(
                            reviewList,
                            "3",
                            searchField.getText()
                    );

                    setActiveButton(
                            threeStarButton,
                            allButton,
                            fiveStarButton,
                            fourStarButton,
                            lowRatingButton
                    );
                };


        Runnable showLowRating =
                () -> {

                    applyReviewFilter(
                            reviewList,
                            "Low",
                            searchField.getText()
                    );

                    setActiveButton(
                            lowRatingButton,
                            allButton,
                            fiveStarButton,
                            fourStarButton,
                            threeStarButton
                    );
                };


        /*
         * =========================================
         * BUTTON ACTIONS
         * =========================================
         */

        allButton.setOnAction(
                event -> showAllReviews.run()
        );


        fiveStarButton.setOnAction(
                event -> showFiveStar.run()
        );


        fourStarButton.setOnAction(
                event -> showFourStar.run()
        );


        threeStarButton.setOnAction(
                event -> showThreeStar.run()
        );


        lowRatingButton.setOnAction(
                event -> showLowRating.run()
        );


        /*
         * =========================================
         * SEARCH
         * =========================================
         *
         * Current selected filter is remembered.
         *
         * =========================================
         */

        final String[] currentFilter =
                {"All"};


        allButton.setOnAction(event -> {

            currentFilter[0] = "All";

            applyReviewFilter(
                    reviewList,
                    currentFilter[0],
                    searchField.getText()
            );

            setActiveButton(
                    allButton,
                    fiveStarButton,
                    fourStarButton,
                    threeStarButton,
                    lowRatingButton
            );
        });


        fiveStarButton.setOnAction(event -> {

            currentFilter[0] = "5";

            applyReviewFilter(
                    reviewList,
                    currentFilter[0],
                    searchField.getText()
            );

            setActiveButton(
                    fiveStarButton,
                    allButton,
                    fourStarButton,
                    threeStarButton,
                    lowRatingButton
            );
        });


        fourStarButton.setOnAction(event -> {

            currentFilter[0] = "4";

            applyReviewFilter(
                    reviewList,
                    currentFilter[0],
                    searchField.getText()
            );

            setActiveButton(
                    fourStarButton,
                    allButton,
                    fiveStarButton,
                    threeStarButton,
                    lowRatingButton
            );
        });


        threeStarButton.setOnAction(event -> {

            currentFilter[0] = "3";

            applyReviewFilter(
                    reviewList,
                    currentFilter[0],
                    searchField.getText()
            );

            setActiveButton(
                    threeStarButton,
                    allButton,
                    fiveStarButton,
                    fourStarButton,
                    lowRatingButton
            );
        });


        lowRatingButton.setOnAction(event -> {

            currentFilter[0] = "Low";

            applyReviewFilter(
                    reviewList,
                    currentFilter[0],
                    searchField.getText()
            );

            setActiveButton(
                    lowRatingButton,
                    allButton,
                    fiveStarButton,
                    fourStarButton,
                    threeStarButton
            );
        });


        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    applyReviewFilter(
                            reviewList,
                            currentFilter[0],
                            newValue
                    );
                }
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

                reviewList,

                feedbackInsight,

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


        customerReviewsScene = sc;

        return customerReviewsScene;

    }


    /*
     * =========================================
     * APPLY REVIEW FILTER
     * =========================================
     */

    private void applyReviewFilter(
            VBox reviewList,
            String filter,
            String searchText) {

        /*
         * Keep the title.
         */

        while (reviewList.getChildren().size() > 1) {

            reviewList.getChildren().remove(1);
        }


        /*
         * Review data
         */

        String[][] reviews = {

                {
                        "Rahul Sharma",
                        "★★★★★",
                        "Excellent product quality!",
                        "The whey protein arrived quickly and the packaging was excellent. " +
                        "I will definitely order again.",
                        "2 hours ago"
                },

                {
                        "Priya Patel",
                        "★★★★★",
                        "Very satisfied",
                        "Good quality products and fast delivery. " +
                        "The prices are also reasonable compared with other stores.",
                        "5 hours ago"
                },

                {
                        "Aarav Mehta",
                        "★★★★",
                        "Good product",
                        "The product is genuine and delivery was on time. " +
                        "Would like to see more discounts in future.",
                        "Yesterday"
                },

                {
                        "Sneha Joshi",
                        "★★★★",
                        "Nice experience",
                        "Overall a good shopping experience. Product quality was good " +
                        "and customer support was helpful.",
                        "Yesterday"
                },

                {
                        "Vikram Singh",
                        "★★★",
                        "Could be better",
                        "The product was good but delivery took longer than expected.",
                        "2 days ago"
                },

                {
                        "Rohan Deshmukh",
                        "★★",
                        "Delivery was disappointing",
                        "The product quality was acceptable but the delivery was much slower " +
                        "than expected.",
                        "3 days ago"
                },

                {
                        "Karan Shah",
                        "★",
                        "Not satisfied",
                        "The overall experience was not good. The order took too long " +
                        "to arrive.",
                        "4 days ago"
                }
        };


        String search =
                searchText == null
                        ? ""
                        : searchText.trim().toLowerCase();


        boolean found = false;


        for (String[] review : reviews) {

            String customer = review[0];

            String stars = review[1];

            String title = review[2];

            String text = review[3];

            String time = review[4];


            /*
             * =========================================
             * RATING FILTER
             * =========================================
             */

            boolean ratingMatches = false;


            if (filter.equals("All")) {

                ratingMatches = true;

            } else if (filter.equals("5")) {

                ratingMatches =
                        stars.length() == 5;

            } else if (filter.equals("4")) {

                ratingMatches =
                        stars.length() == 4;

            } else if (filter.equals("3")) {

                ratingMatches =
                        stars.length() == 3;

            } else if (filter.equals("Low")) {

                ratingMatches =
                        stars.length() <= 2;
            }


            /*
             * =========================================
             * SEARCH FILTER
             * =========================================
             */

            boolean searchMatches =
                    search.isEmpty()
                    ||
                    customer.toLowerCase().contains(search)
                    ||
                    title.toLowerCase().contains(search)
                    ||
                    text.toLowerCase().contains(search)
                    ||
                    stars.contains(search);


            /*
             * =========================================
             * SHOW REVIEW
             * =========================================
             */

            if (ratingMatches && searchMatches) {

                reviewList.getChildren().add(
                        createReviewCard(
                                customer,
                                stars,
                                title,
                                text,
                                time
                        )
                );

                found = true;
            }
        }


        /*
         * =========================================
         * NO RESULTS
         * =========================================
         */

        if (!found) {

            Text noReviews =
                    new Text(
                            "No reviews found."
                    );

            noReviews.setStyle(
                    "-fx-font-size: 14px;" +
                    "-fx-fill: #737686;"
            );

            reviewList.getChildren().add(
                    noReviews
            );
        }
    }


    /*
     * =========================================
     * ACTIVE BUTTON STYLE
     * =========================================
     */

    private void setActiveButton(
            Button activeButton,
            Button button1,
            Button button2,
            Button button3,
            Button button4) {

        activeButton.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 10;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 20;"
        );


        setNormalButtonStyle(button1);

        setNormalButtonStyle(button2);

        setNormalButtonStyle(button3);

        setNormalButtonStyle(button4);
    }


    /*
     * =========================================
     * NORMAL BUTTON STYLE
     * =========================================
     */

    private void setNormalButtonStyle(
            Button button) {

        button.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #dfe2ec;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 0 18;"
        );
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


        Text iconLabel =
                new Text(icon);

        iconLabel.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-background-radius: 10;" +
                "-fx-font-size: 17px;" +
                "-fx-fill: " + color + ";"
        );


        Text valueLabel =
                new Text(value);

        valueLabel.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text titleLabel =
                new Text(title);

        titleLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #737686;"
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
     * REVIEW CARD
     * =========================================
     */

    public VBox createReviewCard(
            String customer,
            String stars,
            String reviewTitle,
            String reviewText,
            String time) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color: rgba(255,255,255,0.90);" +
                "-fx-background-radius: 20;"
        );


        HBox topRow =
                new HBox();

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );


        VBox customerBox =
                new VBox(4);


        Text customerName =
                new Text(customer);

        customerName.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text timeText =
                new Text(time);

        timeText.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #737686;"
        );


        customerBox.getChildren().addAll(
                customerName,
                timeText
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Text starsText =
                new Text(stars);

        starsText.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-fill: #e0a800;"
        );


        topRow.getChildren().addAll(
                customerBox,
                spacer,
                starsText
        );


        Text titleText =
                new Text(reviewTitle);

        titleText.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #111c2d;"
        );


        Text reviewTextLabel =
                new Text(reviewText);

        reviewTextLabel.setWrappingWidth(1000);

        reviewTextLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-fill: #5f6372;"
        );


        Button replyButton =
                new Button("Reply");

        replyButton.setPrefHeight(34);

        replyButton.setStyle(
                "-fx-background-color: #eef3ff;" +
                "-fx-text-fill: #004ac6;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 0 18;" +
                "-fx-font-weight: bold;"
        );


        card.getChildren().addAll(
                topRow,
                titleText,
                reviewTextLabel,
                replyButton
        );


        return card;

    }

}

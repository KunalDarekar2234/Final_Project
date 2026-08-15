package com.visionx.view.trainer_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import javafx.scene.effect.DropShadow;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

public class TrainerReviews {

    private Scene reviewsScene;

    private VBox reviewsContainer;
    private Label reviewsCountLabel;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#0d150e";

    private final String CARD_BG = "#020914";

    private final String SURFACE_BORDER =
            "rgba(255,255,255,0.1)";

    private final String PRIMARY = "#75ff9e";

    private final String PRIMARY_DIM =
            "rgba(117,255,158,0.1)";

    private final String TEXT_MAIN = "#dbe5d9";

    private final String TEXT_MUTED = "#bacbb9";

    private final String GOLD = "#facc15";

    // =========================================================
    // SHADOW
    // =========================================================

    private final DropShadow cardShadow =
            new DropShadow(
                    20,
                    0,
                    8,
                    Color.color(0, 0, 0, 0.4)
            );

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getTrainerReviewsScene(
            Runnable callBackAction
    ) {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-font-family: 'Segoe UI';"
        );

        // =====================================================
        // CENTER CONTENT
        // =====================================================

        VBox content =
                createReviewsContent(
                        callBackAction
                );

        ScrollPane scroll =
                new ScrollPane(
                        content
                );

        scroll.setFitToWidth(true);

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        root.setCenter(scroll);

        // =====================================================
        // SCENE
        // =====================================================

        reviewsScene =
                new Scene(
                        root,
                        1160,
                        900
                );

        return reviewsScene;
    }

    // =========================================================
    // REVIEWS CONTENT
    // =========================================================

    private VBox createReviewsContent(
            Runnable callBackAction
    ) {

        VBox content =
                new VBox(20);

        content.setPadding(
                new Insets(
                        24,
                        24,
                        32,
                        24
                )
        );

        content.setMaxWidth(
                Double.MAX_VALUE
        );

        // =====================================================
        // PAGE HEADER
        // =====================================================

        VBox header =
                new VBox(5);

        Label breadcrumb =
                new Label(
                        "Trainer Portal  ›  Reviews & Ratings"
                );

        breadcrumb.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        Label title =
                new Label(
                        "Reviews & Ratings"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "View client feedback, ratings and manage your responses."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 14px;"
        );

        header.getChildren().addAll(
                breadcrumb,
                title,
                subtitle
        );

        // =====================================================
        // RATING SUMMARY
        // =====================================================

        HBox summary =
                new HBox(18);

        VBox overall =
                createOverallRating();

        VBox fiveStar =
                createRatingBreakdown(
                        "5 Stars",
                        "78%",
                        78
                );

        VBox fourStar =
                createRatingBreakdown(
                        "4 Stars",
                        "14%",
                        14
                );

        VBox threeStar =
                createRatingBreakdown(
                        "3 Stars",
                        "5%",
                        5
                );

        VBox lowStar =
                createRatingBreakdown(
                        "1-2 Stars",
                        "3%",
                        3
                );

        HBox.setHgrow(
                overall,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                fiveStar,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                fourStar,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                threeStar,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                lowStar,
                Priority.ALWAYS
        );

        summary.getChildren().addAll(
                overall,
                fiveStar,
                fourStar,
                threeStar,
                lowStar
        );

        // =====================================================
        // REVIEW LIST
        // =====================================================

        VBox reviews =
                new VBox(16);

        // =====================================================
        // FILTER BAR
        // =====================================================

        HBox filterBar =
                createFilterBar(reviews);

        reviews.getChildren().addAll(

                createReviewCard(
                        "Alex Morgan",
                        "Elite Performance Program",
                        "2 hours ago",
                        5,
                        "The training plan was extremely effective. " +
                        "My strength and endurance improved noticeably " +
                        "within a few weeks.",
                        true
                ),

                createReviewCard(
                        "Sarah Wilson",
                        "Personal Training",
                        "Yesterday",
                        5,
                        "Very professional trainer. Every session was " +
                        "well planned and the exercises were explained clearly.",
                        true
                ),

                createReviewCard(
                        "Daniel Carter",
                        "Weight Loss Program",
                        "2 days ago",
                        4,
                        "Great experience overall. The workout routine " +
                        "was challenging but manageable.",
                        false
                ),

                createReviewCard(
                        "Maya Thompson",
                        "Strength Training",
                        "4 days ago",
                        4,
                        "Good training sessions and excellent motivation. " +
                        "Would definitely recommend.",
                        false
                ),

                createReviewCard(
                        "Ryan Cooper",
                        "Personal Training",
                        "1 week ago",
                        3,
                        "The sessions were good, although I would prefer " +
                        "a little more variation in the workouts.",
                        false
                )
        );

        // =====================================================
        // FOOTER
        // =====================================================

        HBox footer =
                new HBox();

        footer.setAlignment(
                Pos.CENTER
        );

        reviewsCountLabel =
                new Label(
                        "Showing 5 of 24 reviews"
                );

        Label footerText =
                reviewsCountLabel;

        footerText.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );

        footer.getChildren().add(
                footerText
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        content.getChildren().addAll(
                header,
                summary,
                filterBar,
                reviews,
                footer
        );

        return content;
    }

    // =========================================================
    // OVERALL RATING
    // =========================================================

    private VBox createOverallRating() {

        VBox card =
                createCard();

        card.setAlignment(
                Pos.CENTER
        );

        Label title =
                new Label(
                        "Overall Rating"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label rating =
                new Label(
                        "4.8"
                );

        rating.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 34px;" +
                "-fx-font-weight: bold;"
        );

        Label stars =
                new Label(
                        "★★★★★"
                );

        stars.setStyle(
                "-fx-text-fill: " +
                GOLD +
                ";" +
                "-fx-font-size: 18px;"
        );

        Label reviews =
                new Label(
                        "Based on 24 reviews"
                );

        reviews.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                title,
                rating,
                stars,
                reviews
        );

        return card;
    }

    // =========================================================
    // RATING BREAKDOWN
    // =========================================================

    private VBox createRatingBreakdown(
            String title,
            String percentage,
            double progress
    ) {

        VBox card =
                createCard();

        card.setSpacing(10);

        HBox heading =
                new HBox();

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
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
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        heading.getChildren().addAll(
                titleLabel,
                spacer,
                percentageLabel
        );

        Region background =
                new Region();

        background.setPrefHeight(7);
        background.setMaxWidth(
                Double.MAX_VALUE
        );

        background.setStyle(
                "-fx-background-color: " +
                "rgba(255,255,255,0.08);" +
                "-fx-background-radius: 10;"
        );

        Region progressBar =
                new Region();

        progressBar.setPrefHeight(7);

        progressBar.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-background-radius: 10;"
        );

        StackPaneProgress wrapper =
                new StackPaneProgress(
                        background,
                        progressBar,
                        progress
                );

        wrapper.setMaxWidth(
                Double.MAX_VALUE
        );

        card.getChildren().addAll(
                heading,
                wrapper
        );

        return card;
    }

    // =========================================================
    // FILTER BAR
    // =========================================================

    private HBox createFilterBar(
            VBox reviews
    ) {

        HBox filterBar =
                new HBox(10);

        filterBar.setAlignment(
                Pos.CENTER_LEFT
        );

        Button all =
                createFilterButton(
                        "All Reviews",
                        true,
                        reviews,
                        0
                );

        Button five =
                createFilterButton(
                        "★★★★★  5",
                        false,
                        reviews,
                        5
                );

        Button four =
                createFilterButton(
                        "★★★★  4",
                        false,
                        reviews,
                        4
                );

        Button three =
                createFilterButton(
                        "★★★  3",
                        false,
                        reviews,
                        3
                );

        Button low =
                createFilterButton(
                        "1-2 Stars",
                        false,
                        reviews,
                        2
                );

        filterBar.getChildren().addAll(
                all,
                five,
                four,
                three,
                low
        );

        return filterBar;
    }


    // =========================================================
    // FILTER BUTTON
    // =========================================================

    private Button createFilterButton(
            String text,
            boolean active,
            VBox reviews,
            int filterRating
    ) {

        Button button =
                new Button(text);

        String normal =
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 9 16;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 9 16;" +
                "-fx-cursor: hand;";

        button.setStyle(
                active
                        ? activeStyle
                        : normal
        );

        button.setOnAction(
                e -> {

                    for (javafx.scene.Node node : reviews.getChildren()) {

                        if (filterRating == 0) {

                            node.setVisible(true);
                            node.setManaged(true);

                        } else {

                            Object value =
                                    node.getUserData();

                            int rating =
                                    value instanceof Integer
                                            ? (Integer) value
                                            : 0;

                            boolean show =
                                    filterRating == 2
                                            ? rating <= 2
                                            : rating == filterRating;

                            node.setVisible(show);
                            node.setManaged(show);
                        }
                    }

                    for (javafx.scene.Node node :
                            ((HBox) button.getParent()).getChildren()) {

                        if (node instanceof Button) {

                            Button filter =
                                    (Button) node;

                            filter.setStyle(
                                    filter == button
                                            ? activeStyle
                                            : normal
                            );
                        }
                    }

                    updateReviewCount(reviews);
                }
        );

        button.setOnMouseEntered(
                e -> {

                    if (!button.getStyle().equals(activeStyle)) {

                        button.setStyle(
                                "-fx-background-color: " +
                                PRIMARY_DIM +
                                ";" +
                                "-fx-border-color: " +
                                PRIMARY +
                                ";" +
                                "-fx-text-fill: " +
                                PRIMARY +
                                ";" +
                                "-fx-font-size: 12px;" +
                                "-fx-font-weight: bold;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-radius: 10;" +
                                "-fx-padding: 9 16;" +
                                "-fx-cursor: hand;"
                        );
                    }
                }
        );

        button.setOnMouseExited(
                e -> {

                    if (!button.getStyle().equals(activeStyle)) {

                        button.setStyle(
                                normal
                        );
                    }
                }
        );

        return button;
    }


    private void updateReviewCount(
            VBox reviews
    ) {

        int visible = 0;

        for (javafx.scene.Node node :
                reviews.getChildren()) {

            if (node.isManaged() &&
                node.isVisible()) {

                visible++;
            }
        }

        reviewsCountLabel.setText(
                "Showing " +
                visible +
                " of 24 reviews"
        );
    }


    // =========================================================
    // REVIEW CARD
    // =========================================================

    private VBox createReviewCard(
            String clientName,
            String service,
            String time,
            int rating,
            String reviewText,
            boolean replied
    ) {

        VBox card =
                createCard();

        card.setUserData(
                rating
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox clientInfo =
                new VBox(3);

        Label client =
                new Label(
                        clientName
                );

        client.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );

        Label serviceLabel =
                new Label(
                        service
                );

        serviceLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        clientInfo.getChildren().addAll(
                client,
                serviceLabel
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

        timeLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 11px;"
        );

        header.getChildren().addAll(
                clientInfo,
                spacer,
                timeLabel
        );

        // =====================================================
        // RATING
        // =====================================================

        HBox ratingBox =
                new HBox(8);

        Label stars =
                new Label(
                        getStars(rating)
                );

        stars.setStyle(
                "-fx-text-fill: " +
                GOLD +
                ";" +
                "-fx-font-size: 16px;"
        );

        Label ratingLabel =
                new Label(
                        rating + ".0"
                );

        ratingLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        ratingBox.getChildren().addAll(
                stars,
                ratingLabel
        );

        // =====================================================
        // REVIEW TEXT
        // =====================================================

        Label review =
                new Label(
                        reviewText
                );

        review.setWrapText(
                true
        );

        review.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 13px;" +
                "-fx-line-spacing: 3px;"
        );

        // =====================================================
        // BOTTOM
        // =====================================================

        HBox bottom =
                new HBox();

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        if (replied) {

            Label repliedLabel =
                    new Label(
                            "✓ Replied"
                    );

            repliedLabel.setStyle(
                    "-fx-text-fill: " +
                    PRIMARY +
                    ";" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-color: " +
                    PRIMARY_DIM +
                    ";" +
                    "-fx-background-radius: 8;" +
                    "-fx-padding: 5 10;"
            );

            bottom.getChildren().add(
                    repliedLabel
            );

        } else {

            Button reply =
                    new Button(
                            "Reply"
                    );

            reply.setStyle(
                    "-fx-background-color: " +
                    PRIMARY +
                    ";" +
                    "-fx-text-fill: #003918;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 8;" +
                    "-fx-padding: 6 16;" +
                    "-fx-cursor: hand;"
            );

            reply.setOnAction(
                    e -> showReplyBox(
                            clientName
                    )
            );

            bottom.getChildren().add(
                    reply
            );
        }

        card.getChildren().addAll(
                header,
                ratingBox,
                review,
                bottom
        );

        // =====================================================
        // HOVER
        // =====================================================

        card.setOnMouseEntered(
                e -> {

                    card.setStyle(
                            "-fx-background-color: " +
                            CARD_BG +
                            ";" +
                            "-fx-background-radius: 16;" +
                            "-fx-border-color: " +
                            PRIMARY_DIM +
                            ";" +
                            "-fx-border-radius: 16;"
                    );

                    card.setTranslateY(-2);
                }
        );

        card.setOnMouseExited(
                e -> {

                    card.setStyle(
                            "-fx-background-color: " +
                            CARD_BG +
                            ";" +
                            "-fx-background-radius: 16;" +
                            "-fx-border-color: " +
                            SURFACE_BORDER +
                            ";" +
                            "-fx-border-radius: 16;"
                    );

                    card.setTranslateY(0);
                }
        );

        return card;
    }

    // =========================================================
    // CARD
    // =========================================================

    private VBox createCard() {

        VBox card =
                new VBox(12);

        card.setPadding(
                new Insets(18)
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 16;"
        );

        card.setEffect(
                cardShadow
        );

        HBox.setHgrow(
                card,
                Priority.ALWAYS
        );

        return card;
    }

    // =========================================================
    // STARS
    // =========================================================

    private String getStars(
            int rating
    ) {

        StringBuilder stars =
                new StringBuilder();

        for (int i = 1; i <= 5; i++) {

            if (i <= rating) {

                stars.append("★");

            } else {

                stars.append("☆");
            }
        }

        return stars.toString();
    }

    // =========================================================
    // REPLY BOX
    // =========================================================

    private void showReplyBox(
            String clientName
    ) {

        VBox dialog =
                new VBox(12);

        dialog.setPadding(
                new Insets(20)
        );

        dialog.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 14;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 14;"
        );

        Label title =
                new Label(
                        "Reply to " + clientName
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        TextArea reply =
                new TextArea();

        reply.setPromptText(
                "Write your response..."
        );

        reply.setPrefRowCount(
                4
        );

        reply.setWrapText(
                true
        );

        reply.setStyle(
                "-fx-control-inner-background: " +
                CARD_BG +
                ";" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-prompt-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";"
        );

        Button send =
                new Button(
                        "Send Reply"
                );

        send.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 8 18;" +
                "-fx-cursor: hand;"
        );

        send.setOnAction(
                e -> {

                    send.setText(
                            "✓ Reply Sent"
                    );

                    reply.setDisable(
                            true
                    );

                    send.setDisable(
                            true
                    );
                }
        );

        dialog.getChildren().addAll(
                title,
                reply,
                send
        );

        javafx.stage.Stage stage =
                new javafx.stage.Stage();

        stage.setTitle(
                "Reply to Review"
        );

        stage.setScene(
                new Scene(
                        dialog,
                        420,
                        280
                )
        );

        stage.show();
    }

    // =========================================================
    // NO ARGUMENT VERSION
    // =========================================================

    public Scene getTrainerReviewsScene() {

        return getTrainerReviewsScene(
                null
        );
    }

    // =========================================================
    // SIMPLE PROGRESS STACK
    // =========================================================

    private static class StackPaneProgress
            extends javafx.scene.layout.StackPane {

        StackPaneProgress(
                Region background,
                Region progress,
                double percentage
        ) {

            setAlignment(
                    Pos.CENTER_LEFT
            );

            setMaxWidth(
                    Double.MAX_VALUE
            );

            progress.prefWidthProperty().bind(
                    background.widthProperty()
                            .multiply(percentage / 100.0)
            );

            getChildren().addAll(
                    background,
                    progress
            );
        }
    }
}
package com.visionx.view.trainer_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Trainer Notifications page.
 *
 * This page is opened from the bell icon in TrainerDashboard.
 * It follows the existing FitneesFreak dark/green UI and does not
 * replace or modify the dashboard navigation.
 */
public class Notifications {

    // =========================================================
    // COLORS - MATCH TRAINER DASHBOARD
    // =========================================================

    private static final String BG_COLOR = "#0d150e";
    private static final String CARD_BG = "#020914";
    private static final String BORDER = "rgba(255,255,255,0.10)";
    private static final String PRIMARY = "#75ff9e";
    private static final String TEXT_MAIN = "#dbe5d9";
    private static final String TEXT_MUTED = "#bacbb9";

    // =========================================================
    // PAGE
    // =========================================================

    public Scene getNotificationsScene(
            Runnable dashboardAction,
            Runnable clientsAction,
            Runnable requestsAction,
            Runnable workoutAction,
            Runnable chatAction,
            Runnable scheduleAction,
            Runnable earningsAction,
            Runnable reviewsAction,
            Runnable profileAction,
            Runnable logoutAction
    ) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        VBox content = new VBox(18);
        content.setPadding(new Insets(28, 34, 34, 34));
        content.setStyle(
                "-fx-background-color: " + BG_COLOR + ";"
        );

        // =====================================================
        // PAGE HEADER
        // =====================================================

        HBox heading = new HBox();
        heading.setAlignment(Pos.CENTER_LEFT);

        VBox headingText = new VBox(4);

        Label title = new Label("Notifications");
        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Stay updated with your clients, sessions and trainer activity."
        );
        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 13px;"
        );

        headingText.getChildren().addAll(title, subtitle);

        Region headingSpacer = new Region();
        HBox.setHgrow(headingSpacer, Priority.ALWAYS);

        Button markAll = new Button("✓  Mark all as read");
        markAll.setStyle(
                "-fx-background-color: rgba(117,255,158,0.10);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-border-color: rgba(117,255,158,0.35);" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 9 14;" +
                "-fx-cursor: hand;"
        );

        heading.getChildren().addAll(headingText, headingSpacer, markAll);

        // =====================================================
        // SUMMARY CARDS
        // =====================================================

        HBox summary = new HBox(14);

        VBox unreadCard = createSummaryCard(
                "Unread",
                "04",
                "Needs your attention"
        );

        VBox todayCard = createSummaryCard(
                "Today",
                "07",
                "New updates"
        );

        VBox sessionCard = createSummaryCard(
                "Sessions",
                "03",
                "Upcoming today"
        );

        summary.getChildren().addAll(
                unreadCard,
                todayCard,
                sessionCard
        );

        // =====================================================
        // FILTER BAR
        // =====================================================

        HBox filterBar = new HBox(8);
        filterBar.setAlignment(Pos.CENTER_LEFT);

        Button allButton = createFilterButton("All", true);
        Button unreadButton = createFilterButton("Unread", false);
        Button sessionsButton = createFilterButton("Sessions", false);
        Button clientsButton = createFilterButton("Clients", false);
        Button paymentsButton = createFilterButton("Payments", false);

        filterBar.getChildren().addAll(
                allButton,
                unreadButton,
                sessionsButton,
                clientsButton,
                paymentsButton
        );

        // =====================================================
        // NOTIFICATION LIST
        // =====================================================

        VBox notificationsList = new VBox(10);

        notificationsList.getChildren().addAll(
                createNotification(
                        "👤",
                        "New client request",
                        "Riya Deshmukh sent a new personal training request.",
                        "5 min ago",
                        "New",
                        true
                ),
                createNotification(
                        "📅",
                        "Session starting soon",
                        "Your session with Rahul Mehta starts in 30 minutes.",
                        "30 min ago",
                        "Session",
                        true
                ),
                createNotification(
                        "💪",
                        "Client progress updated",
                        "Aman Verma completed his weekly progress update.",
                        "1 hour ago",
                        "Progress",
                        true
                ),
                createNotification(
                        "💰",
                        "Payment received",
                        "₹2,500 payment received from Priya Sharma.",
                        "2 hours ago",
                        "Payment",
                        false
                ),
                createNotification(
                        "⭐",
                        "New review received",
                        "Neha Patil gave your training service a 5-star rating.",
                        "3 hours ago",
                        "Review",
                        false
                ),
                createNotification(
                        "📋",
                        "Workout plan completed",
                        "Rahul completed the assigned Chest Day workout plan.",
                        "Yesterday",
                        "Workout",
                        false
                )
        );

        ScrollPane scrollPane = new ScrollPane(notificationsList);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        content.getChildren().addAll(
                heading,
                summary,
                filterBar,
                scrollPane
        );

        root.setCenter(content);

        // The shell's navigation remains in TrainerDashboard.
        // These parameters are intentionally accepted so this page can
        // also be reused with the existing navigation callbacks later.
        return new Scene(root);
    }

    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private VBox createSummaryCard(
            String title,
            String value,
            String caption
    ) {

        VBox card = new VBox(5);
        card.setPadding(new Insets(15, 18, 15, 18));
        card.setPrefWidth(190);
        card.setMinHeight(82);
        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 10;"
        );

        Label titleLabel = new Label(title);
        titleLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;"
        );

        Label valueLabel = new Label(value);
        valueLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        Label captionLabel = new Label(caption);
        captionLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 9px;"
        );

        card.getChildren().addAll(
                titleLabel,
                valueLabel,
                captionLabel
        );

        return card;
    }

    // =========================================================
    // FILTER BUTTON
    // =========================================================

    private Button createFilterButton(
            String text,
            boolean active
    ) {

        Button button = new Button(text);

        String activeStyle =
                "-fx-background-color: #163b2a;" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-background-radius: 7;" +
                "-fx-border-color: rgba(117,255,158,0.25);" +
                "-fx-border-radius: 7;" +
                "-fx-padding: 7 13;" +
                "-fx-cursor: hand;";

        String normalStyle =
                "-fx-background-color: rgba(255,255,255,0.04);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 7;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 7;" +
                "-fx-padding: 7 13;" +
                "-fx-cursor: hand;";

        button.setStyle(active ? activeStyle : normalStyle);

        button.setOnMouseEntered(e -> {
            if (!active) {
                button.setStyle(
                        "-fx-background-color: #132a20;" +
                        "-fx-text-fill: " + TEXT_MAIN + ";" +
                        "-fx-background-radius: 7;" +
                        "-fx-border-color: rgba(117,255,158,0.20);" +
                        "-fx-border-radius: 7;" +
                        "-fx-padding: 7 13;" +
                        "-fx-cursor: hand;"
                );
            }
        });

        button.setOnMouseExited(e -> {
            if (!active) {
                button.setStyle(normalStyle);
            }
        });

        return button;
    }

    // =========================================================
    // NOTIFICATION ITEM
    // =========================================================

    private HBox createNotification(
            String icon,
            String title,
            String message,
            String time,
            String category,
            boolean unread
    ) {

        HBox row = new HBox(14);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(15, 16, 15, 16));

        String normalBackground = unread
                ? "rgba(117,255,158,0.055)"
                : CARD_BG;

        row.setStyle(
                "-fx-background-color: " + normalBackground + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 10;" +
                "-fx-cursor: hand;"
        );

        Label iconLabel = new Label(icon);
        iconLabel.setAlignment(Pos.CENTER);
        iconLabel.setPrefSize(42, 42);
        iconLabel.setStyle(
                "-fx-background-color: #163b2a;" +
                "-fx-background-radius: 21;" +
                "-fx-font-size: 17px;"
        );

        VBox details = new VBox(4);
        HBox.setHgrow(details, Priority.ALWAYS);

        HBox titleLine = new HBox(8);
        titleLine.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label(title);
        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label categoryLabel = new Label(category);
        categoryLabel.setStyle(
                "-fx-background-color: rgba(117,255,158,0.10);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 8px;" +
                "-fx-padding: 3 7;" +
                "-fx-background-radius: 5;"
        );

        titleLine.getChildren().addAll(
                titleLabel,
                categoryLabel
        );

        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true);
        messageLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;"
        );

        details.getChildren().addAll(
                titleLine,
                messageLabel
        );

        VBox right = new VBox(8);
        right.setAlignment(Pos.CENTER_RIGHT);

        Label timeLabel = new Label(time);
        timeLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 9px;"
        );

        Label status = new Label(unread ? "● New" : "Read");
        status.setStyle(
                "-fx-text-fill: " +
                (unread ? PRIMARY : TEXT_MUTED) + ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        right.getChildren().addAll(
                timeLabel,
                status
        );

        row.getChildren().addAll(
                iconLabel,
                details,
                right
        );

        row.setOnMouseEntered(e -> row.setStyle(
                "-fx-background-color: #132a20;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(117,255,158,0.18);" +
                "-fx-border-radius: 10;" +
                "-fx-cursor: hand;"
        ));

        row.setOnMouseExited(e -> row.setStyle(
                "-fx-background-color: " + normalBackground + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 10;" +
                "-fx-cursor: hand;"
        ));

        return row;
    }
}
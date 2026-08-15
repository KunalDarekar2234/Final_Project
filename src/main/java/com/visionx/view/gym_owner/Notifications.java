package com.visionx.view.gym_owner;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Notifications {

    private Scene notificationsScene;

    // ==========================================
    // COLOR PALETTE
    // ==========================================

    private final String BG_COLOR = "#0d150e";
    private final String SURFACE = "#020914";

    private final String SURFACE_BORDER =
            "rgba(255, 255, 255, 0.1)";

    private final String PRIMARY = "#75ff9e";

    private final String SECONDARY = "#c0c6db";
    private final String TERTIARY = "#ffba79";

    private final String TEXT_MAIN = "#dbe5d9";
    private final String TEXT_MUTED = "#bacbb9";
    private final String ERROR = "#ffb4ab";

    // ==========================================
    // SHARED EFFECTS
    // ==========================================

    private final DropShadow glassShadow =
            new DropShadow(
                    20,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.4)
            );

    // ==========================================
    // STATE
    // ==========================================

    private final List<NotificationData> allNotifications =
            new ArrayList<>();

    private final List<Runnable> markAsReadActions =
            new ArrayList<>();

    private VBox notificationsContainer;

    private String activeFilter = "All";

    private Button allBtn;
    private Button membershipBtn;
    private Button reviewsBtn;
    private Button trainersBtn;
    private Button systemBtn;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    public Notifications() {

        loadNotificationData();
    }

    // ==========================================
    // NOTIFICATION DATA
    // ==========================================

    private void loadNotificationData() {

        allNotifications.clear();

        // ==========================================
        // TODAY - MEMBERSHIP
        // ==========================================

        allNotifications.add(
                new NotificationData(
                        "Elite Package Upgrade Request",
                        "2m ago",
                        "User @alex_vance has requested an upgrade to the Elite Performance Package. Requires immediate approval.",
                        "💳",
                        PRIMARY,
                        "Membership",
                        "Today",
                        true,
                        true
                )
        );

        // ==========================================
        // TODAY - TRAINERS
        // ==========================================

        allNotifications.add(
                new NotificationData(
                        "New Trainer Onboarding",
                        "45m ago",
                        "Trainer Sarah Jenkins completed the initial screening. Portfolio and certifications are ready for review.",
                        "🏋",
                        TERTIARY,
                        "Trainers",
                        "Today",
                        true,
                        false
                )
        );

        // ==========================================
        // YESTERDAY - REVIEWS
        // ==========================================

        allNotifications.add(
                new NotificationData(
                        "New 5-Star Review",
                        "1d ago",
                        "\"The AI-driven insights helped me hit my deadlift PR in just 3 weeks! Amazing facility.\" — Mark Thompson",
                        "⭐",
                        SECONDARY,
                        "Reviews",
                        "Yesterday",
                        false,
                        false
                )
        );

        // ==========================================
        // YESTERDAY - SYSTEM ALERTS
        // ==========================================

        allNotifications.add(
                new NotificationData(
                        "System Security Patch",
                        "1d ago",
                        "Automatic security update v2.4.1 successful. Biometric sensors across all locations synchronized.",
                        "🛡",
                        ERROR,
                        "System Alerts",
                        "Yesterday",
                        false,
                        false
                )
        );
    }

    // ==========================================
    // MAIN SCENE
    // ==========================================

    public Scene getNotificationsScene(Runnable callBackAction) {

        StackPane rootLayer =
                new StackPane();

        rootLayer.setStyle(
                "-fx-background-color: " +
                        BG_COLOR +
                        ";" +
                        "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        ScrollPane content =
                createMainContent();

        rootLayer.getChildren().add(content);

        Scene scene =
                new Scene(
                        rootLayer,
                        1160,
                        900
                );

        notificationsScene = scene;

        return notificationsScene;
    }

    // ==========================================
    // MAIN CONTENT
    // ==========================================

    private ScrollPane createMainContent() {

        VBox content =
                new VBox(32);

        content.setPadding(
                new Insets(
                        40,
                        32,
                        40,
                        32
                )
        );

        content.setMaxWidth(1000);

        content.setAlignment(
                Pos.TOP_CENTER
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );

        // ==========================================
        // TOP HEADER
        // ==========================================

        HBox topRow =
                new HBox();

        topRow.setAlignment(
                Pos.BOTTOM_LEFT
        );

        VBox titleBox =
                new VBox(4);

        Label title =
                new Label(
                        "Notification Center"
                );

        title.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 36px;" +
                        "-fx-font-weight: 800;"
        );

        Label sub =
                new Label(
                        "Manage your real-time updates and alerts."
                );

        sub.setStyle(
                "-fx-text-fill: " +
                        TEXT_MUTED +
                        ";" +
                        "-fx-font-size: 16px;"
        );

        titleBox.getChildren().addAll(
                title,
                sub
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // ==========================================
        // MARK ALL READ
        // ==========================================

        Button markReadBtn =
                new Button(
                        "✔ Mark All Read"
                );

        String bDef =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                        "-fx-border-color: rgba(255,255,255,0.1);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 24;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-radius: 12;" +
                        "-fx-cursor: hand;";

        String bHov =
                "-fx-background-color: " +
                        PRIMARY +
                        ";" +
                        "-fx-border-color: " +
                        PRIMARY +
                        ";" +
                        "-fx-text-fill: #0d150e;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 24;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-radius: 12;" +
                        "-fx-cursor: hand;";

        markReadBtn.setStyle(bDef);

        markReadBtn.setOnMouseEntered(
                e -> markReadBtn.setStyle(bHov)
        );

        markReadBtn.setOnMouseExited(
                e -> markReadBtn.setStyle(bDef)
        );

        markReadBtn.setOnAction(e -> {

            for (Runnable action :
                    new ArrayList<>(markAsReadActions)) {

                action.run();
            }

            markAsReadActions.clear();

            markReadBtn.setText(
                    "✔ Done!"
            );

            markReadBtn.setStyle(bHov);

            new Thread(() -> {

                try {

                    Thread.sleep(1500);

                } catch (InterruptedException ex) {

                    Thread.currentThread().interrupt();
                }

                Platform.runLater(() -> {

                    markReadBtn.setText(
                            "✔ Mark All Read"
                    );

                    markReadBtn.setStyle(
                            bDef
                    );

                    renderNotifications();
                });

            }).start();
        });

        topRow.getChildren().addAll(
                titleBox,
                spacer,
                markReadBtn
        );

        // ==========================================
        // FILTER NAVIGATION
        // ==========================================

        HBox filters =
                new HBox(12);

        filters.setAlignment(
                Pos.CENTER_LEFT
        );

        allBtn =
                createFilterPill(
                        "All",
                        true
                );

        membershipBtn =
                createFilterPill(
                        "Membership",
                        false
                );

        reviewsBtn =
                createFilterPill(
                        "Reviews",
                        false
                );

        trainersBtn =
                createFilterPill(
                        "Trainers",
                        false
                );

        systemBtn =
                createFilterPill(
                        "System Alerts",
                        false
                );

        filters.getChildren().addAll(
                allBtn,
                membershipBtn,
                reviewsBtn,
                trainersBtn,
                systemBtn
        );

        // ==========================================
        // NOTIFICATION CONTAINER
        // ==========================================

        notificationsContainer =
                new VBox(24);

        notificationsContainer.setMaxWidth(
                Double.MAX_VALUE
        );

        renderNotifications();

        // ==========================================
        // VIEW ARCHIVE
        // ==========================================

        HBox botRow =
                new HBox();

        botRow.setAlignment(
                Pos.CENTER
        );

        botRow.setPadding(
                new Insets(
                        32,
                        0,
                        0,
                        0
                )
        );

        Button archBtn =
                new Button(
                        "View Archive ⌄"
                );

        String archiveNormal =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                        "-fx-border-color: rgba(255,255,255,0.1);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 12 32;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-radius: 12;" +
                        "-fx-cursor: hand;";

        String archiveHover =
                "-fx-background-color: rgba(255,255,255,0.1);" +
                        "-fx-border-color: rgba(117,255,158,0.3);" +
                        "-fx-text-fill: " +
                        PRIMARY +
                        ";" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 12 32;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-translate-y: 2;";

        archBtn.setStyle(
                archiveNormal
        );

        archBtn.setOnMouseEntered(
                e -> archBtn.setStyle(
                        archiveHover
                )
        );

        archBtn.setOnMouseExited(
                e -> archBtn.setStyle(
                        archiveNormal
                )
        );

        botRow.getChildren().add(
                archBtn
        );

        content.getChildren().addAll(
                topRow,
                filters,
                notificationsContainer,
                botRow
        );

        // ==========================================
        // SCROLL PANE
        // ==========================================

        StackPane contentWrapper =
                new StackPane(content);

        contentWrapper.setStyle(
                "-fx-background-color: transparent;"
        );

        ScrollPane scroll =
                new ScrollPane(
                        contentWrapper
                );

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background: transparent;" +
                        "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        return scroll;
    }

    // ==========================================
    // FILTER PILL
    // ==========================================

    private Button createFilterPill(
            String text,
            boolean active
    ) {

        Button button =
                new Button(text);

        updateFilterButtonStyle(
                button,
                active
        );

        button.setOnMouseEntered(e -> {

            if (!activeFilter.equals(text)) {

                button.setStyle(
                        "-fx-background-color: #020914;" +
                                "-fx-border-color: rgba(117,255,158,0.35);" +
                                "-fx-text-fill: " +
                                PRIMARY +
                                ";" +
                                "-fx-font-weight: bold;" +
                                "-fx-padding: 8 24;" +
                                "-fx-background-radius: 50;" +
                                "-fx-border-radius: 50;" +
                                "-fx-cursor: hand;"
                );
            }
        });

        button.setOnMouseExited(e -> {

            updateFilterButtonStyle(
                    button,
                    activeFilter.equals(text)
            );
        });

        button.setOnAction(e -> {

            activeFilter = text;

            updateAllFilterButtons();

            renderNotifications();
        });

        return button;
    }

    // ==========================================
    // UPDATE FILTER BUTTONS
    // ==========================================

    private void updateAllFilterButtons() {

        updateFilterButtonStyle(
                allBtn,
                activeFilter.equals("All")
        );

        updateFilterButtonStyle(
                membershipBtn,
                activeFilter.equals("Membership")
        );

        updateFilterButtonStyle(
                reviewsBtn,
                activeFilter.equals("Reviews")
        );

        updateFilterButtonStyle(
                trainersBtn,
                activeFilter.equals("Trainers")
        );

        updateFilterButtonStyle(
                systemBtn,
                activeFilter.equals("System Alerts")
        );
    }

    // ==========================================
    // FILTER BUTTON STYLE
    // ==========================================

    private void updateFilterButtonStyle(
            Button button,
            boolean active
    ) {

        if (active) {

            button.setStyle(
                    "-fx-background-color: " +
                            PRIMARY +
                            ";" +
                            "-fx-text-fill: #0d150e;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 8 24;" +
                            "-fx-background-radius: 50;" +
                            "-fx-border-radius: 50;" +
                            "-fx-cursor: hand;"
            );

            button.setEffect(
                    new DropShadow(
                            15,
                            Color.web(
                                    PRIMARY,
                                    0.4
                            )
                    )
            );

        } else {

            button.setStyle(
                    "-fx-background-color: #020914;" +
                            "-fx-border-color: rgba(255,255,255,0.1);" +
                            "-fx-text-fill: " +
                            TEXT_MUTED +
                            ";" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 8 24;" +
                            "-fx-background-radius: 50;" +
                            "-fx-border-radius: 50;" +
                            "-fx-cursor: hand;"
            );

            button.setEffect(null);
        }
    }

    // ==========================================
    // RENDER NOTIFICATIONS
    // ==========================================

    private void renderNotifications() {

        if (notificationsContainer == null) {
            return;
        }

        notificationsContainer.getChildren().clear();

        markAsReadActions.clear();

        // ==========================================
        // FILTER DATA
        // ==========================================

        List<NotificationData> filtered =
                new ArrayList<>();

        for (NotificationData data :
                allNotifications) {

            if (activeFilter.equals("All")
                    || data.category.equals(activeFilter)) {

                filtered.add(data);
            }
        }

        // ==========================================
        // TODAY
        // ==========================================

        List<NotificationData> today =
                new ArrayList<>();

        for (NotificationData data :
                filtered) {

            if (data.dateGroup.equals("Today")) {
                today.add(data);
            }
        }

        if (!today.isEmpty()) {

            VBox todayGroup =
                    createDateGroup(
                            "TODAY",
                            today
                    );

            notificationsContainer
                    .getChildren()
                    .add(todayGroup);
        }

        // ==========================================
        // YESTERDAY
        // ==========================================

        List<NotificationData> yesterday =
                new ArrayList<>();

        for (NotificationData data :
                filtered) {

            if (data.dateGroup.equals("Yesterday")) {
                yesterday.add(data);
            }
        }

        if (!yesterday.isEmpty()) {

            VBox yesterdayGroup =
                    createDateGroup(
                            "YESTERDAY",
                            yesterday
                    );

            notificationsContainer
                    .getChildren()
                    .add(yesterdayGroup);
        }

        // ==========================================
        // EMPTY STATE
        // ==========================================

        if (filtered.isEmpty()) {

            VBox emptyBox =
                    new VBox(10);

            emptyBox.setAlignment(
                    Pos.CENTER
            );

            emptyBox.setPadding(
                    new Insets(60)
            );

            Label emptyIcon =
                    new Label("🔔");

            emptyIcon.setStyle(
                    "-fx-font-size: 36px;"
            );

            Label emptyTitle =
                    new Label(
                            "No notifications"
                    );

            emptyTitle.setStyle(
                    "-fx-text-fill: white;" +
                            "-fx-font-size: 20px;" +
                            "-fx-font-weight: bold;"
            );

            Label emptyText =
                    new Label(
                            "There are no notifications in " +
                                    activeFilter +
                                    "."
                    );

            emptyText.setStyle(
                    "-fx-text-fill: " +
                            TEXT_MUTED +
                            ";" +
                            "-fx-font-size: 14px;"
            );

            emptyBox.getChildren().addAll(
                    emptyIcon,
                    emptyTitle,
                    emptyText
            );

            notificationsContainer
                    .getChildren()
                    .add(emptyBox);
        }
    }

    // ==========================================
    // DATE GROUP
    // ==========================================

    private VBox createDateGroup(
            String label,
            List<NotificationData> dataList
    ) {

        VBox group =
                new VBox(16);

        Label dateLabel =
                new Label(label);

        dateLabel.setStyle(
                "-fx-text-fill: " +
                        TEXT_MUTED +
                        ";" +
                        "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-letter-spacing: 2px;" +
                        "-fx-opacity: 0.6;"
        );

        group.getChildren().add(
                dateLabel
        );

        for (NotificationData data :
                dataList) {

            group.getChildren().add(
                    createNotificationCard(data)
            );
        }

        return group;
    }

    // ==========================================
    // NOTIFICATION CARD
    // ==========================================

    private VBox createNotificationCard(
            NotificationData data
    ) {

        VBox cardWrapper =
                new VBox();

        HBox card =
                new HBox(20);

        card.setPadding(
                new Insets(20)
        );

        // ==========================================
        // CARD STYLES
        // ==========================================

        String baseStyle =
                "-fx-background-color: #020914;" +
                        "-fx-background-radius: 16;" +
                        "-fx-border-color: " +
                        SURFACE_BORDER +
                        ";" +
                        "-fx-border-radius: 16;";

        String unreadStyle =
                "-fx-background-color: #020914;" +
                        "-fx-background-radius: 16;" +
                        "-fx-border-color: " +
                        SURFACE_BORDER +
                        " " +
                        SURFACE_BORDER +
                        " " +
                        SURFACE_BORDER +
                        " " +
                        PRIMARY +
                        ";" +
                        "-fx-border-radius: 16;" +
                        "-fx-border-width: 1 1 1 4;";

        boolean isUnread =
                !data.read;

        card.setStyle(
                isUnread
                        ? unreadStyle
                        : baseStyle
        );

        card.setOpacity(
                isUnread
                        ? 1.0
                        : 0.7
        );

        card.setEffect(
                glassShadow
        );

        // ==========================================
        // ICON BOX
        // ==========================================

        StackPane iconBox =
                new StackPane();

        iconBox.setMinSize(
                48,
                48
        );

        iconBox.setMaxSize(
                48,
                48
        );

        iconBox.setStyle(
                "-fx-background-color: " +
                        getIconBackgroundColor(
                                data.iconColor
                        ) +
                        ";" +
                        "-fx-background-radius: 12;"
        );

        Label iconLabel =
                new Label(
                        data.icon
                );

        iconLabel.setStyle(
                "-fx-text-fill: " +
                        data.iconColor +
                        ";" +
                        "-fx-font-size: 24px;"
        );

        iconBox.getChildren().add(
                iconLabel
        );

        // ==========================================
        // CENTER CONTENT
        // ==========================================

        VBox center =
                new VBox(8);

        HBox.setHgrow(
                center,
                Priority.ALWAYS
        );

        HBox head =
                new HBox();

        Label titleLabel =
                new Label(
                        data.title
                );

        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        Region titleSpacer =
                new Region();

        HBox.setHgrow(
                titleSpacer,
                Priority.ALWAYS
        );

        Label timeLabel =
                new Label(
                        data.time
                );

        timeLabel.setStyle(
                "-fx-text-fill: " +
                        TEXT_MUTED +
                        ";" +
                        "-fx-font-size: 12px;"
        );

        head.getChildren().addAll(
                titleLabel,
                titleSpacer,
                timeLabel
        );

        Label descLabel =
                new Label(
                        data.description
                );

        descLabel.setStyle(
                "-fx-text-fill: " +
                        TEXT_MUTED +
                        ";" +
                        "-fx-font-size: 14px;" +
                        "-fx-line-spacing: 4px;"
        );

        descLabel.setWrapText(true);

        center.getChildren().addAll(
                head,
                descLabel
        );

        // ==========================================
        // ACTION BUTTONS
        // ==========================================

        if (data.hasActionButtons) {

            HBox buttons =
                    new HBox(12);

            buttons.setPadding(
                    new Insets(
                            8,
                            0,
                            0,
                            0
                    )
            );

            Button approve =
                    new Button(
                            "Approve"
                    );

            approve.setStyle(
                    "-fx-background-color: " +
                            PRIMARY +
                            ";" +
                            "-fx-text-fill: #0d150e;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 6 16;" +
                            "-fx-background-radius: 8;" +
                            "-fx-cursor: hand;"
            );

            Button details =
                    new Button(
                            "Details"
                    );

            String detailsNormal =
                    "-fx-background-color: rgba(255,255,255,0.05);" +
                            "-fx-border-color: rgba(255,255,255,0.1);" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 6 16;" +
                            "-fx-background-radius: 8;" +
                            "-fx-border-radius: 8;" +
                            "-fx-cursor: hand;";

            String detailsHover =
                    "-fx-background-color: rgba(255,255,255,0.1);" +
                            "-fx-border-color: rgba(255,255,255,0.1);" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 6 16;" +
                            "-fx-background-radius: 8;" +
                            "-fx-border-radius: 8;" +
                            "-fx-cursor: hand;";

            details.setStyle(
                    detailsNormal
            );

            buttons.getChildren().addAll(
                    approve,
                    details
            );

            center.getChildren().add(
                    buttons
            );

            approve.setOnMouseEntered(
                    e -> {
                        approve.setScaleX(1.05);
                        approve.setScaleY(1.05);
                    }
            );

            approve.setOnMouseExited(
                    e -> {
                        approve.setScaleX(1.0);
                        approve.setScaleY(1.0);
                    }
            );

            details.setOnMouseEntered(
                    e -> details.setStyle(
                            detailsHover
                    )
            );

            details.setOnMouseExited(
                    e -> details.setStyle(
                            detailsNormal
                    )
            );

            approve.setOnAction(
                    e -> showInfo(
                            "Approved",
                            "The upgrade request has been approved."
                    )
            );

            details.setOnAction(
                    e -> showInfo(
                            "Notification Details",
                            data.description
                    )
            );
        }

        // ==========================================
        // RIGHT SIDE
        // ==========================================

        VBox right =
                new VBox(16);

        right.setAlignment(
                Pos.TOP_RIGHT
        );

        Circle dot =
                new Circle(4);

        if (!data.read) {

            dot.setFill(
                    Color.web(PRIMARY)
            );

            dot.setEffect(
                    new DropShadow(
                            10,
                            Color.web(
                                    PRIMARY,
                                    0.6
                            )
                    )
            );

        } else {

            dot.setFill(
                    Color.web(
                            "rgba(255,255,255,0.1)"
                    )
            );
        }

        Label close =
                new Label("✖");

        close.setStyle(
                "-fx-text-fill: " +
                        TEXT_MUTED +
                        ";" +
                        "-fx-font-size: 16px;" +
                        "-fx-cursor: hand;"
        );

        close.setOpacity(0);

        close.setOnMouseEntered(
                e -> close.setStyle(
                        "-fx-text-fill: " +
                                ERROR +
                                ";" +
                                "-fx-font-size: 16px;" +
                                "-fx-cursor: hand;"
                )
        );

        close.setOnMouseExited(
                e -> close.setStyle(
                        "-fx-text-fill: " +
                                TEXT_MUTED +
                                ";" +
                                "-fx-font-size: 16px;" +
                                "-fx-cursor: hand;"
                )
        );

        right.getChildren().addAll(
                dot,
                close
        );

        card.getChildren().addAll(
                iconBox,
                center,
                right
        );

        // ==========================================
        // HOVER EFFECT
        // ==========================================

        card.setOnMouseEntered(
                e -> {

                    String hoverStyle =
                            !data.read
                                    ? unreadStyle.replace(
                                            SURFACE_BORDER,
                                            "rgba(255,255,255,0.2)"
                                    )
                                    : baseStyle.replace(
                                            SURFACE_BORDER,
                                            "rgba(255,255,255,0.2)"
                                    );

                    card.setStyle(
                            hoverStyle
                    );

                    titleLabel.setStyle(
                            "-fx-text-fill: " +
                                    data.iconColor +
                                    ";" +
                                    "-fx-font-size: 18px;" +
                                    "-fx-font-weight: bold;"
                    );

                    close.setOpacity(1.0);
                }
        );

        card.setOnMouseExited(
                e -> {

                    card.setStyle(
                            data.read
                                    ? baseStyle
                                    : unreadStyle
                    );

                    titleLabel.setStyle(
                            "-fx-text-fill: white;" +
                                    "-fx-font-size: 18px;" +
                                    "-fx-font-weight: bold;"
                    );

                    close.setOpacity(0);
                }
        );

        // ==========================================
        // CLOSE / REMOVE
        // ==========================================

        close.setOnMouseClicked(
                e -> {

                    TranslateTransition translate =
                            new TranslateTransition(
                                    Duration.millis(300),
                                    cardWrapper
                            );

                    translate.setByX(50);

                    FadeTransition fade =
                            new FadeTransition(
                                    Duration.millis(300),
                                    cardWrapper
                            );

                    fade.setToValue(0);

                    ParallelTransition animation =
                            new ParallelTransition(
                                    translate,
                                    fade
                            );

                    animation.setOnFinished(
                            event -> {

                                allNotifications.remove(
                                        data
                                );

                                renderNotifications();
                            }
                    );

                    animation.play();
                }
        );

        // ==========================================
        // MARK AS READ
        // ==========================================

        if (!data.read) {

            markAsReadActions.add(
                    () -> markNotificationAsRead(
                            data
                    )
            );
        }

        cardWrapper.getChildren().add(
                card
        );

        return cardWrapper;
    }

    // ==========================================
    // MARK NOTIFICATION AS READ
    // ==========================================

    private void markNotificationAsRead(
            NotificationData data
    ) {

        data.read = true;
    }

    // ==========================================
    // ICON BACKGROUND COLOR
    // ==========================================

    private String getIconBackgroundColor(
            String color
    ) {

        if (color.equals(PRIMARY)) {

            return "rgba(117,255,158,0.1)";

        } else if (color.equals(TERTIARY)) {

            return "rgba(255,186,121,0.1)";

        } else if (color.equals(SECONDARY)) {

            return "rgba(192,198,219,0.1)";

        } else if (color.equals(ERROR)) {

            return "rgba(255,180,171,0.1)";
        }

        return "rgba(255,255,255,0.1)";
    }

    // ==========================================
    // INFO ALERT
    // ==========================================

    private void showInfo(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    // ==========================================
    // NOTIFICATION DATA CLASS
    // ==========================================

    private static class NotificationData {

        String title;
        String time;
        String description;
        String icon;
        String iconColor;
        String category;
        String dateGroup;

        boolean read;
        boolean hasActionButtons;

        NotificationData(
                String title,
                String time,
                String description,
                String icon,
                String iconColor,
                String category,
                String dateGroup,
                boolean read,
                boolean hasActionButtons
        ) {

            this.title = title;
            this.time = time;
            this.description = description;
            this.icon = icon;
            this.iconColor = iconColor;
            this.category = category;
            this.dateGroup = dateGroup;
            this.read = read;
            this.hasActionButtons = hasActionButtons;
        }
    }

    // ==========================================
    // NO ARGUMENT VERSION
    // ==========================================

    public Scene getNotificationsScene() {

        return getNotificationsScene(null);
    }
}
package com.visionx.view.gym_owner;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

    // =========================================================
    // COLOR PALETTE
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String SURFACE = "#020914";
    private final String SURFACE_2 = "#07140f";
    private final String SURFACE_BORDER = "#2a352b";

    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DARK = "#163B2A";
    private final String ON_PRIMARY = "#000000";
    private final String ON_SURFACE = "#dbe5d9";
    private final String ON_SURFACE_VARIANT = "#bacbb9";
    private final String MUTED = "#6f7f73";
    private final String GOLD = "#ffd76a";
    private final String SILVER = "#c9d2dc";
    private final String BRONZE = "#d99a68";

    // =========================================================
    // ROOT / SCENE
    // =========================================================

    private BorderPane root;
    private Scene scene;
    private Runnable backAction;

    // =========================================================
    // COMPETITION STATE
    // =========================================================

    private final List<Competition> competitions = new ArrayList<>();

    private Image selectedCompetitionImage;
    private ImageView announcementImagePreview;


    // =========================================================
    // GET SCENE
    // =========================================================

    public Scene getLeaderboardScene(Runnable backAction) {

        this.backAction = backAction;

        root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        seedCompetitions();

        ScrollPane scroll = createLeaderboardContent();
        root.setCenter(scroll);

        scene = new Scene(root, 1200, 800);

        root.setOpacity(0);
        root.setTranslateY(18);

        FadeTransition fade =
                new FadeTransition(Duration.millis(420), root);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition slide =
                new TranslateTransition(Duration.millis(420), root);
        slide.setFromY(18);
        slide.setToY(0);

        new ParallelTransition(fade, slide).play();

        return scene;
    }

    // =========================================================
    // CONTENT
    // =========================================================

    private ScrollPane createLeaderboardContent() {

        VBox content = new VBox(22);

        content.setPadding(new Insets(34, 42, 42, 42));
        content.setStyle("-fx-background-color: " + BG_COLOR + ";");

        content.getChildren().add(createPageHeader());
        content.getChildren().add(createHeroStats());
        content.getChildren().add(createPodiumSection());
        content.getChildren().add(createLeaderboardTable());
        content.getChildren().add(createEventsSection());

        ScrollPane scroll = new ScrollPane(content);

        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                " -fx-background: " + BG_COLOR + ";" +
                " -fx-border-color: transparent;"
        );

        return scroll;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createPageHeader() {

        HBox header = new HBox(18);
        header.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);

        Label eyebrow = new Label("PERFORMANCE INTELLIGENCE");
        eyebrow.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 2px;"
        );

        Label title = new Label("Leaderboard");
        title.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 32px;" +
                " -fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Recognize your top performers and turn consistency into competition."
        );
        subtitle.setStyle(
                "-fx-text-fill: " + ON_SURFACE_VARIANT +
                "; -fx-font-size: 14px;"
        );

        titleBox.getChildren().addAll(eyebrow, title, subtitle);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        VBox liveBox = createLiveStatus();

        Button backBtn = new Button("←  BACK TO DASHBOARD");

        String normal =
                "-fx-background-color: " + SURFACE + ";" +
                " -fx-border-color: " + SURFACE_BORDER + ";" +
                " -fx-text-fill: " + ON_SURFACE_VARIANT + ";" +
                " -fx-border-radius: 12;" +
                " -fx-background-radius: 12;" +
                " -fx-padding: 11 17;" +
                " -fx-font-size: 11px;" +
                " -fx-font-weight: bold;" +
                " -fx-cursor: hand;";

        String hover =
                "-fx-background-color: " + PRIMARY_DARK + ";" +
                " -fx-border-color: " + PRIMARY + ";" +
                " -fx-text-fill: " + PRIMARY + ";" +
                " -fx-border-radius: 12;" +
                " -fx-background-radius: 12;" +
                " -fx-padding: 11 17;" +
                " -fx-font-size: 11px;" +
                " -fx-font-weight: bold;" +
                " -fx-cursor: hand;";

        backBtn.setStyle(normal);

        backBtn.setOnMouseEntered(e -> {
            backBtn.setStyle(hover);
            scaleIn(backBtn);
        });

        backBtn.setOnMouseExited(e -> {
            backBtn.setStyle(normal);
            scaleOut(backBtn);
        });

        backBtn.setOnAction(e -> {
            if (backAction != null) {
                backAction.run();
            }
        });

        header.getChildren().addAll(
                titleBox,
                spacer,
                liveBox,
                backBtn
        );

        return header;
    }

    private VBox createLiveStatus() {

        VBox box = new VBox(3);
        box.setAlignment(Pos.CENTER_RIGHT);

        HBox status = new HBox(7);
        status.setAlignment(Pos.CENTER_RIGHT);

        Circle dot = new Circle(4, Color.web(PRIMARY));

        Timeline pulse = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(dot.opacityProperty(), 1.0)
                ),
                new KeyFrame(
                        Duration.millis(750),
                        new KeyValue(dot.opacityProperty(), 0.25)
                ),
                new KeyFrame(
                        Duration.millis(1500),
                        new KeyValue(dot.opacityProperty(), 1.0)
                )
        );
        pulse.setCycleCount(Timeline.INDEFINITE);
        pulse.play();

        Label live = new Label("LIVE RANKINGS");
        live.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;"
        );

        Label updated = new Label("Updated just now");
        updated.setStyle(
                "-fx-text-fill: " + MUTED +
                "; -fx-font-size: 9px;"
        );

        status.getChildren().addAll(dot, live);
        box.getChildren().addAll(status, updated);

        return box;
    }

    // =========================================================
    // HERO STATS
    // =========================================================

    private HBox createHeroStats() {

        HBox stats = new HBox(14);

        VBox card1 = createMetricCard(
                "🏆", "CURRENT #1", "Alex Sterling",
                "128 day streak", PRIMARY
        );

        VBox card2 = createMetricCard(
                "🔥", "GYM RECORD", "128 DAYS",
                "Longest active streak", GOLD
        );

        VBox card3 = createMetricCard(
                "⚡", "ACTIVE RANKED", "2,842",
                "Members competing", PRIMARY
        );

        VBox card4 = createMetricCard(
                "↗", "MONTHLY GROWTH", "+18%",
                "vs. previous month", PRIMARY
        );

        stats.getChildren().addAll(card1, card2, card3, card4);

        for (int i = 0; i < stats.getChildren().size(); i++) {
            animateEntrance(stats.getChildren().get(i), 80 + i * 80);
        }

        return stats;
    }

    private VBox createMetricCard(
            String icon,
            String title,
            String value,
            String subtitle,
            String accent
    ) {

        VBox card = new VBox(8);
        card.setPadding(new Insets(18));
        HBox.setHgrow(card, Priority.ALWAYS);

        setCardStyle(card, 18);

        Label iconLabel = new Label(icon);
        iconLabel.setStyle(
                "-fx-text-fill: " + accent +
                "; -fx-font-size: 20px;"
        );

        Label titleLabel = new Label(title);
        titleLabel.setStyle(
                "-fx-text-fill: " + ON_SURFACE_VARIANT +
                "; -fx-font-size: 9px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 1.6px;"
        );

        Label valueLabel = new Label(value);
        valueLabel.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 21px;" +
                " -fx-font-weight: bold;"
        );

        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.setStyle(
                "-fx-text-fill: " + MUTED +
                "; -fx-font-size: 10px;"
        );

        card.getChildren().addAll(
                iconLabel,
                titleLabel,
                valueLabel,
                subtitleLabel
        );

        addHoverAnimation(card);
        return card;
    }

    // =========================================================
    // PODIUM
    // =========================================================

    private VBox createPodiumSection() {

        VBox section = new VBox(12);

        HBox heading = new HBox();

        VBox titleBox = new VBox(4);

        Label title = new Label("Top Performers");
        title.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 22px;" +
                " -fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "The members setting the pace for the entire gym."
        );
        subtitle.setStyle(
                "-fx-text-fill: " + ON_SURFACE_VARIANT +
                "; -fx-font-size: 11px;"
        );

        titleBox.getChildren().addAll(title, subtitle);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox filters = new HBox(7);
        filters.getChildren().addAll(
                createFilter("ALL TIME", true),
                createFilter("THIS MONTH", false),
                createFilter("THIS WEEK", false)
        );

        heading.getChildren().addAll(titleBox, spacer, filters);

        HBox podium = new HBox(12);
        podium.setAlignment(Pos.BOTTOM_CENTER);

        VBox second = createPodiumCard(
                "2", "🥈", "Jordan Davis", "112 DAYS", SILVER, 175
        );

        VBox first = createPodiumCard(
                "1", "🥇", "Alex Sterling", "128 DAYS", GOLD, 205
        );

        VBox third = createPodiumCard(
                "3", "🥉", "Sarah Miller", "97 DAYS", BRONZE, 155
        );

        HBox.setHgrow(second, Priority.ALWAYS);
        HBox.setHgrow(first, Priority.ALWAYS);
        HBox.setHgrow(third, Priority.ALWAYS);

        podium.getChildren().addAll(second, first, third);

        section.getChildren().addAll(heading, podium);

        animateEntrance(podium, 180);

        return section;
    }

    private Button createFilter(String text, boolean active) {

        Button button = new Button(text);

        button.setStyle(filterStyle(active));

        button.setOnMouseEntered(e -> {
            button.setStyle(filterStyle(true));
            scaleIn(button);
        });

        button.setOnMouseExited(e -> {
            if (!active) {
                button.setStyle(filterStyle(false));
            }
            scaleOut(button);
        });

        button.setOnAction(e -> {
            // Visual interaction for the current static leaderboard data.
            // Backend filtering can be connected here later.
            for (javafx.scene.Node node :
                    ((HBox) button.getParent()).getChildren()) {

                if (node instanceof Button) {
                    Button b = (Button) node;
                    b.setStyle(filterStyle(false));
                }
            }

            button.setStyle(filterStyle(true));
        });

        return button;
    }

    private String filterStyle(boolean active) {
        return
                "-fx-background-color: " +
                (active ? PRIMARY_DARK : SURFACE) + ";" +
                " -fx-border-color: " +
                (active ? PRIMARY : SURFACE_BORDER) + ";" +
                " -fx-text-fill: " +
                (active ? PRIMARY : ON_SURFACE_VARIANT) + ";" +
                " -fx-border-radius: 9;" +
                " -fx-background-radius: 9;" +
                " -fx-padding: 8 11;" +
                " -fx-font-size: 8px;" +
                " -fx-font-weight: bold;" +
                " -fx-cursor: hand;";
    }

    private VBox createPodiumCard(
            String rank,
            String medal,
            String name,
            String score,
            String accent,
            double height
    ) {

        VBox card = new VBox(9);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(18, 16, 17, 16));
        card.setMinHeight(height);
        card.setPrefHeight(height);

        setCardStyle(card, 20);

        Label medalLabel = new Label(medal);
        medalLabel.setStyle(
                "-fx-font-size: " +
                (rank.equals("1") ? "32px;" : "26px;")
        );

        Label rankLabel = new Label("#" + rank);
        rankLabel.setStyle(
                "-fx-text-fill: " + accent +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 1.5px;"
        );

        StackPane avatarWrap = new StackPane();

        Circle ring = new Circle(
                rank.equals("1") ? 31 : 27,
                Color.web(accent, 0.10)
        );

        Circle avatarCircle = new Circle(
                rank.equals("1") ? 24 : 21,
                Color.web("#0b2418")
        );

        Label initials = new Label(
                initialsFor(name)
        );
        initials.setStyle(
                "-fx-text-fill: " + accent +
                "; -fx-font-size: 11px;" +
                " -fx-font-weight: bold;"
        );

        avatarWrap.getChildren().addAll(
                ring,
                avatarCircle,
                initials
        );

        Label nameLabel = new Label(name);
        nameLabel.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 14px;" +
                " -fx-font-weight: bold;"
        );

        Label scoreLabel = new Label(score);
        scoreLabel.setStyle(
                "-fx-text-fill: " + accent +
                "; -fx-font-size: 11px;" +
                " -fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                medalLabel,
                rankLabel,
                avatarWrap,
                nameLabel,
                scoreLabel
        );

        addHoverAnimation(card);
        return card;
    }

    // =========================================================
    // MAIN TABLE
    // =========================================================

    private VBox createLeaderboardTable() {

        VBox card = new VBox();
        card.setPadding(new Insets(22));

        setCardStyle(card, 22);

        HBox heading = new HBox();
        heading.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(4);

        Label title = new Label("Member Rankings");
        title.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 21px;" +
                " -fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Ranked by current active streak"
        );
        subtitle.setStyle(
                "-fx-text-fill: " + MUTED +
                "; -fx-font-size: 10px;"
        );

        titleBox.getChildren().addAll(title, subtitle);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label count = new Label("6 MEMBERS");
        count.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-background-color: rgba(117,255,158,0.08);" +
                " -fx-background-radius: 8;" +
                " -fx-padding: 7 10;" +
                " -fx-font-size: 9px;" +
                " -fx-font-weight: bold;"
        );

        heading.getChildren().addAll(titleBox, spacer, count);

        HBox columns = createLeaderboardHeader();

        VBox rows = new VBox();

        rows.getChildren().addAll(
                createLeaderboardRow("1", "AS", "Alex Sterling", "128", GOLD),
                createLeaderboardRow("2", "JD", "Jordan Davis", "112", SILVER),
                createLeaderboardRow("3", "SM", "Sarah Miller", "97", BRONZE),
                createLeaderboardRow("4", "KW", "Kevin Wong", "86", PRIMARY),
                createLeaderboardRow("5", "RM", "Ryan Miller", "74", PRIMARY),
                createLeaderboardRow("6", "EW", "Emma Wilson", "69", PRIMARY)
        );

        card.getChildren().addAll(
                heading,
                columns,
                rows
        );

        return card;
    }

    private HBox createLeaderboardHeader() {

        HBox header = new HBox();

        header.setPadding(new Insets(20, 0, 10, 0));
        header.setStyle(
                "-fx-border-color: transparent transparent " +
                SURFACE_BORDER + " transparent;"
        );

        Label rank = new Label("RANK");
        rank.setPrefWidth(75);

        Label member = new Label("MEMBER");
        member.setPrefWidth(320);

        Label streak = new Label("STREAK");
        streak.setPrefWidth(180);

        Label progress = new Label("CONSISTENCY");
        progress.setPrefWidth(180);

        Label status = new Label("STATUS");

        HBox.setHgrow(status, Priority.ALWAYS);

        String style =
                "-fx-text-fill: " + MUTED +
                "; -fx-font-size: 8px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 1.5px;";

        rank.setStyle(style);
        member.setStyle(style);
        streak.setStyle(style);
        progress.setStyle(style);
        status.setStyle(style);

        header.getChildren().addAll(
                rank, member, streak, progress, status
        );

        return header;
    }

    private HBox createLeaderboardRow(
            String rank,
            String initials,
            String name,
            String streak,
            String accent
    ) {

        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);

        row.setPadding(new Insets(14, 0, 14, 0));
        row.setStyle(
                "-fx-border-color: transparent transparent " +
                SURFACE_BORDER + " transparent;"
        );

        Label rankLabel = new Label(
                rank.equals("1") ? "🥇" :
                rank.equals("2") ? "🥈" :
                rank.equals("3") ? "🥉" : "#" + rank
        );

        rankLabel.setPrefWidth(75);
        rankLabel.setStyle(
                "-fx-text-fill: " + accent +
                "; -fx-font-size: 13px;" +
                " -fx-font-weight: bold;"
        );

        HBox memberBox = new HBox(11);
        memberBox.setPrefWidth(320);
        memberBox.setAlignment(Pos.CENTER_LEFT);

        StackPane avatar = new StackPane();
        avatar.setMinSize(38, 38);
        avatar.setPrefSize(38, 38);

        Circle avatarBg = new Circle(
                19,
                Color.web(PRIMARY, 0.09)
        );

        Label avatarText = new Label(initials);
        avatarText.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;"
        );

        avatar.getChildren().addAll(avatarBg, avatarText);

        VBox memberText = new VBox(2);

        Label nameLabel = new Label(name);
        nameLabel.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 13px;" +
                " -fx-font-weight: bold;"
        );

        Label memberType = new Label(
                "VERIFIED GYM MEMBER"
        );
        memberType.setStyle(
                "-fx-text-fill: " + MUTED +
                "; -fx-font-size: 8px;"
        );

        memberText.getChildren().addAll(
                nameLabel,
                memberType
        );

        memberBox.getChildren().addAll(
                avatar,
                memberText
        );

        HBox streakBox = new HBox(7);
        streakBox.setPrefWidth(180);
        streakBox.setAlignment(Pos.CENTER_LEFT);

        Label fire = new Label("🔥");
        fire.setStyle("-fx-font-size: 13px;");

        Label streakLabel = new Label(
                streak + " days"
        );
        streakLabel.setStyle(
                "-fx-text-fill: " + accent +
                "; -fx-font-size: 13px;" +
                " -fx-font-weight: bold;"
        );

        streakBox.getChildren().addAll(
                fire,
                streakLabel
        );

        HBox progressBox = new HBox();
        progressBox.setPrefWidth(180);
        progressBox.setAlignment(Pos.CENTER_LEFT);

        Region track = new Region();
        track.setPrefHeight(5);
        track.setMaxWidth(125);
        track.setStyle(
                "-fx-background-color: #17231b;" +
                " -fx-background-radius: 5;"
        );

        Region progress = new Region();
        double value =
                Math.min(1.0, Integer.parseInt(streak) / 128.0);
        progress.setPrefHeight(5);
        progress.setPrefWidth(125 * value);
        progress.setStyle(
                "-fx-background-color: " + accent +
                "; -fx-background-radius: 5;"
        );

        StackPane progressWrap = new StackPane(
                track,
                progress
        );
        progressWrap.setAlignment(Pos.CENTER_LEFT);

        progressBox.getChildren().add(progressWrap);

        Label status = new Label("ACTIVE");
        status.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-background-color: rgba(117,255,158,0.08);" +
                " -fx-border-color: rgba(117,255,158,0.18);" +
                " -fx-border-radius: 7;" +
                " -fx-background-radius: 7;" +
                " -fx-padding: 5 9;" +
                " -fx-font-size: 8px;" +
                " -fx-font-weight: bold;"
        );

        HBox.setHgrow(status, Priority.ALWAYS);
        status.setAlignment(Pos.CENTER_RIGHT);

        row.getChildren().addAll(
                rankLabel,
                memberBox,
                streakBox,
                progressBox,
                status
        );

        row.setOnMouseEntered(e -> {
            row.setStyle(
                    "-fx-background-color: rgba(117,255,158,0.035);" +
                    " -fx-border-color: transparent transparent " +
                    SURFACE_BORDER + " transparent;"
            );
            scaleIn(row);
        });

        row.setOnMouseExited(e -> {
            row.setStyle(
                    "-fx-background-color: transparent;" +
                    " -fx-border-color: transparent transparent " +
                    SURFACE_BORDER + " transparent;"
            );
            scaleOut(row);
        });

        animateEntrance(row, 260 + Integer.parseInt(rank) * 65);

        return row;
    }

    // =========================================================
    // EVENTS
    // =========================================================

    private VBox createEventsSection() {

        VBox section = new VBox(12);

        HBox titleRow = new HBox();
        titleRow.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(4);

        Label title = new Label("Live Competitions");
        title.setStyle(
                "-fx-text-fill: " + ON_SURFACE +
                "; -fx-font-size: 21px;" +
                " -fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Launch, manage and control active gym competitions from one place."
        );
        subtitle.setStyle(
                "-fx-text-fill: " + MUTED +
                "; -fx-font-size: 10px;"
        );

        titleBox.getChildren().addAll(title, subtitle);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button announce = createPrimaryButton("＋  ANNOUNCE A COMPETITION");
        announce.setOnAction(e -> showAnnouncementPage(null));

        titleRow.getChildren().addAll(titleBox, spacer, announce);

        VBox cards = new VBox(12);
        refreshCompetitionCards(cards);

        section.getChildren().addAll(titleRow, cards);

        return section;
    }

    private void refreshCompetitionCards(VBox cards) {
        cards.getChildren().clear();

        for (Competition competition : competitions) {
            if (competition.active) {
                cards.getChildren().add(createEventCard(competition));
            }
        }

        if (cards.getChildren().isEmpty()) {
            Label empty = new Label("No live competitions. Announce a new competition to get started.");
            empty.setStyle("-fx-text-fill: " + MUTED + "; -fx-font-size: 11px;");
            cards.getChildren().add(empty);
        }
    }

    private VBox createEventCard(Competition competition) {

        VBox card = new VBox(14);
        card.setPadding(new Insets(20));
        setCardStyle(card, 18);
        addHoverAnimation(card);

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        Label iconLabel = new Label("🏆");
        iconLabel.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-background-color: rgba(117,255,158,0.08);" +
                " -fx-padding: 11; -fx-background-radius: 11; -fx-font-size: 18px;"
        );

        VBox text = new VBox(3);
        Label eventName = new Label(competition.name);
        eventName.setStyle("-fx-text-fill: " + ON_SURFACE + "; -fx-font-size: 14px; -fx-font-weight: bold;");

        Label eventMeta = new Label(
                competition.type + "  •  " + competition.participants + " Participants  •  Prize " + competition.price
        );
        eventMeta.setStyle("-fx-text-fill: " + MUTED + "; -fx-font-size: 9px;");
        text.getChildren().addAll(eventName, eventMeta);

        HBox titleBox = new HBox(12);
        titleBox.setAlignment(Pos.CENTER_LEFT);
        titleBox.getChildren().addAll(iconLabel, text);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label live = new Label("● LIVE");
        live.setStyle("-fx-text-fill: " + PRIMARY + "; -fx-background-color: rgba(117,255,158,0.08); -fx-background-radius: 8; -fx-padding: 7 10; -fx-font-size: 8px; -fx-font-weight: bold;");

        Button update = createSmallActionButton("UPDATE");
        update.setOnAction(e -> showAnnouncementPage(competition));

        Button end = createSmallActionButton("END");
        end.setStyle(smallActionStyle(GOLD));
        end.setOnAction(e -> endCompetition(competition));

        Button delete = createSmallActionButton("DELETE");
        delete.setStyle(smallActionStyle("#ff8f8f"));
        delete.setOnAction(e -> deleteCompetition(competition));

        header.getChildren().addAll(titleBox, spacer, live, update, end, delete);

        HBox line = new HBox();
        line.setPrefHeight(1);
        line.setStyle("-fx-background-color: " + SURFACE_BORDER + ";");

        Label hint = new Label(
                competition.description.isBlank() ? "Competition is live and accepting participants." : competition.description
        );
        hint.setStyle("-fx-text-fill: " + ON_SURFACE_VARIANT + "; -fx-font-size: 10px;");

        card.getChildren().addAll(header, line, hint);
        return card;
    }

    private Button createPrimaryButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color: " + PRIMARY + "; -fx-text-fill: " + ON_PRIMARY + "; -fx-background-radius: 10; -fx-padding: 10 15; -fx-font-size: 9px; -fx-font-weight: bold; -fx-cursor: hand;");
        b.setOnMouseEntered(e -> { b.setStyle("-fx-background-color: #9affb7; -fx-text-fill: " + ON_PRIMARY + "; -fx-background-radius: 10; -fx-padding: 10 15; -fx-font-size: 9px; -fx-font-weight: bold; -fx-cursor: hand;"); scaleIn(b); });
        b.setOnMouseExited(e -> { b.setStyle("-fx-background-color: " + PRIMARY + "; -fx-text-fill: " + ON_PRIMARY + "; -fx-background-radius: 10; -fx-padding: 10 15; -fx-font-size: 9px; -fx-font-weight: bold; -fx-cursor: hand;"); scaleOut(b); });
        return b;
    }

    private Button createSmallActionButton(String text) {
        Button b = new Button(text);
        b.setStyle(smallActionStyle(PRIMARY));
        b.setOnMouseEntered(e -> scaleIn(b));
        b.setOnMouseExited(e -> scaleOut(b));
        return b;
    }

    private String smallActionStyle(String accent) {
        return "-fx-background-color: rgba(117,255,158,0.06); -fx-border-color: " + accent + "; -fx-text-fill: " + accent + "; -fx-border-radius: 7; -fx-background-radius: 7; -fx-padding: 6 8; -fx-font-size: 7px; -fx-font-weight: bold; -fx-cursor: hand;";
    }

    // =========================================================
    // ANNOUNCE / UPDATE PAGE
    // =========================================================

    private void showAnnouncementPage(Competition editing) {

        VBox page = new VBox(18);
        page.setPadding(new Insets(34, 42, 42, 42));
        page.setStyle("-fx-background-color: " + BG_COLOR + ";");

        HBox top = new HBox();
        top.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);
        Label eyebrow = new Label(editing == null ? "COMPETITION MANAGEMENT" : "EDIT COMPETITION");
        eyebrow.setStyle("-fx-text-fill: " + PRIMARY + "; -fx-font-size: 10px; -fx-font-weight: bold; -fx-letter-spacing: 2px;");
        Label title = new Label(editing == null ? "Announce a Competition" : "Update Competition");
        title.setStyle("-fx-text-fill: " + ON_SURFACE + "; -fx-font-size: 30px; -fx-font-weight: bold;");
        Label sub = new Label("Create a premium challenge with pricing, media and participation details.");
        sub.setStyle("-fx-text-fill: " + ON_SURFACE_VARIANT + "; -fx-font-size: 13px;");
        titleBox.getChildren().addAll(eyebrow, title, sub);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Button back = createSmallActionButton("← BACK TO LEADERBOARD");
        back.setOnAction(e -> returnToLeaderboard());
        top.getChildren().addAll(titleBox, spacer, back);

        TextField name = field("Competition name", editing == null ? "" : editing.name);
        TextField type = field("Competition type", editing == null ? "Fitness Challenge" : editing.type);
        TextField participants = field("Participants", editing == null ? "0" : String.valueOf(editing.participants));
        TextField price = field("Entry / prize price", editing == null ? "₹0" : editing.price);
        DatePicker start = new DatePicker(editing == null ? LocalDate.now() : editing.startDate);
        DatePicker end = new DatePicker(editing == null ? LocalDate.now().plusDays(30) : editing.endDate);
        start.setStyle(inputStyle());
        end.setStyle(inputStyle());
        TextArea description = new TextArea(editing == null ? "" : editing.description);
        description.setPromptText("Competition description, rules, goals and eligibility...");
        description.setPrefRowCount(5);
        description.setWrapText(true);
        description.setStyle(inputStyle());

        VBox imageBox = new VBox(10);
        imageBox.setPadding(new Insets(18));
        setCardStyle(imageBox, 16);

        Label imageTitle = new Label("Competition Cover Image");
        imageTitle.setStyle("-fx-text-fill: " + ON_SURFACE + "; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label imageHint = new Label("Upload a JPG, PNG or WEBP image for the competition card.");
        imageHint.setStyle("-fx-text-fill: " + MUTED + "; -fx-font-size: 9px;");

        announcementImagePreview = new ImageView();
        announcementImagePreview.setFitWidth(300);
        announcementImagePreview.setFitHeight(145);
        announcementImagePreview.setPreserveRatio(true);
        if (editing != null && editing.image != null) announcementImagePreview.setImage(editing.image);

        Button chooseImage = createSmallActionButton("＋ ADD / CHANGE IMAGE");
        chooseImage.setOnAction(e -> chooseCompetitionImage());
        imageBox.getChildren().addAll(imageTitle, imageHint, announcementImagePreview, chooseImage);

        HBox row1 = formRow(fieldBox("COMPETITION NAME", name), fieldBox("TYPE", type));
        HBox row2 = formRow(fieldBox("PARTICIPANTS", participants), fieldBox("PRICE", price));
        HBox row3 = formRow(fieldBox("START DATE", start), fieldBox("END DATE", end));

        Button save = createPrimaryButton(editing == null ? "✓  ANNOUNCE COMPETITION" : "✓  SAVE CHANGES");
        save.setOnAction(e -> {
            if (name.getText().isBlank()) {
                showMessage("Competition name is required.");
                return;
            }
            int count;
            try { count = Integer.parseInt(participants.getText().trim()); }
            catch (Exception ex) { showMessage("Participants must be a valid number."); return; }

            if (editing == null) {
                Competition c = new Competition(
                        name.getText().trim(), type.getText().trim(), count, price.getText().trim(),
                        description.getText().trim(), start.getValue(), end.getValue(), selectedCompetitionImage
                );
                competitions.add(c);
            } else {
                editing.name = name.getText().trim();
                editing.type = type.getText().trim();
                editing.participants = count;
                editing.price = price.getText().trim();
                editing.description = description.getText().trim();
                editing.startDate = start.getValue();
                editing.endDate = end.getValue();
                if (selectedCompetitionImage != null) editing.image = selectedCompetitionImage;
            }
            selectedCompetitionImage = null;
            returnToLeaderboard();
        });

        page.getChildren().addAll(top, row1, row2, row3, fieldBox("DESCRIPTION / RULES", description), imageBox, save);

        ScrollPane scroll = new ScrollPane(page);
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setStyle("-fx-background-color: transparent; -fx-background: " + BG_COLOR + "; -fx-border-color: transparent;");

        root.setCenter(scroll);
        animatePage(root);
    }

    private VBox fieldBox(String labelText, javafx.scene.Node input) {
        VBox box = new VBox(7);
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: " + MUTED + "; -fx-font-size: 8px; -fx-font-weight: bold; -fx-letter-spacing: 1.2px;");
        box.getChildren().addAll(label, input);
        HBox.setHgrow(box, Priority.ALWAYS);
        return box;
    }

    private HBox formRow(javafx.scene.Node left, javafx.scene.Node right) {
        HBox row = new HBox(14, left, right);
        HBox.setHgrow(left, Priority.ALWAYS);
        HBox.setHgrow(right, Priority.ALWAYS);
        return row;
    }

    private TextField field(String prompt, String value) {
        TextField f = new TextField(value);
        f.setPromptText(prompt);
        f.setStyle(inputStyle());
        return f;
    }

    private String inputStyle() {
        return "-fx-background-color: " + SURFACE + "; -fx-text-fill: " + ON_SURFACE + "; -fx-prompt-text-fill: " + MUTED + "; -fx-border-color: " + SURFACE_BORDER + "; -fx-border-radius: 9; -fx-background-radius: 9; -fx-padding: 11 12;";
    }

    private void chooseCompetitionImage() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose Competition Image");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.webp")
        );
        File file = chooser.showOpenDialog(root.getScene().getWindow());
        if (file != null) {
            selectedCompetitionImage = new Image(file.toURI().toString(), 700, 350, true, true);
            if (announcementImagePreview != null) announcementImagePreview.setImage(selectedCompetitionImage);
        }
    }

    private void returnToLeaderboard() {
        selectedCompetitionImage = null;
        root.setCenter(createLeaderboardContent());
        animatePage(root);
    }

    private void animatePage(javafx.scene.Node node) {
        node.setOpacity(0.0);
        node.setTranslateY(10);
        FadeTransition f = new FadeTransition(Duration.millis(300), node);
        f.setToValue(1);
        TranslateTransition t = new TranslateTransition(Duration.millis(300), node);
        t.setToY(0);
        new ParallelTransition(f, t).play();
    }

    private void endCompetition(Competition competition) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "End '" + competition.name + "'? It will no longer appear in Live Competitions.",
                ButtonType.CANCEL, ButtonType.OK);
        alert.setHeaderText("End Competition");
        alert.showAndWait().ifPresent(result -> {
            if (result == ButtonType.OK) {
                competition.active = false;
                competition.ended = true;
                returnToLeaderboard();
            }
        });
    }

    private void deleteCompetition(Competition competition) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Delete '" + competition.name + "' permanently?",
                ButtonType.CANCEL, ButtonType.OK);
        alert.setHeaderText("Delete Competition");
        alert.showAndWait().ifPresent(result -> {
            if (result == ButtonType.OK) {
                competitions.remove(competition);
                returnToLeaderboard();
            }
        });
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.setHeaderText("Competition Details");
        alert.showAndWait();
    }

    private void seedCompetitions() {
        if (!competitions.isEmpty()) return;
        competitions.add(new Competition(
                "Weight Lifting Championship", "POWER WEEK 2026", 48, "₹5,000",
                "Highest total lift wins. Verified gym members only.", LocalDate.now(), LocalDate.now().plusDays(7), null
        ));
        competitions.add(new Competition(
                "30 Day Transformation Challenge", "FITNESS CHALLENGE", 124, "₹2,500",
                "Track consistency, body composition and weekly progress.", LocalDate.now(), LocalDate.now().plusDays(30), null
        ));
    }

    private static class Competition {
        String name;
        String type;
        int participants;
        String price;
        String description;
        LocalDate startDate;
        LocalDate endDate;
        Image image;
        boolean active = true;
        boolean ended = false;

        Competition(String name, String type, int participants, String price, String description, LocalDate startDate, LocalDate endDate, Image image) {
            this.name = name;
            this.type = type;
            this.participants = participants;
            this.price = price;
            this.description = description;
            this.startDate = startDate;
            this.endDate = endDate;
            this.image = image;
        }
    }

    // =========================================================
    // ANIMATION / INTERACTION
    // =========================================================

    private void animateEntrance(
            javafx.scene.Node node,
            double delay
    ) {

        node.setOpacity(0);
        node.setTranslateY(12);

        FadeTransition fade =
                new FadeTransition(Duration.millis(380), node);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setDelay(Duration.millis(delay));

        TranslateTransition slide =
                new TranslateTransition(Duration.millis(380), node);
        slide.setFromY(12);
        slide.setToY(0);
        slide.setDelay(Duration.millis(delay));

        new ParallelTransition(fade, slide).play();
    }

    private void addHoverAnimation(javafx.scene.Node node) {

        node.setOnMouseEntered(e -> scaleIn(node));
        node.setOnMouseExited(e -> scaleOut(node));
    }

    private void scaleIn(javafx.scene.Node node) {

        ScaleTransition transition =
                new ScaleTransition(
                        Duration.millis(120),
                        node
                );

        transition.setToX(1.012);
        transition.setToY(1.012);
        transition.play();
    }

    private void scaleOut(javafx.scene.Node node) {

        ScaleTransition transition =
                new ScaleTransition(
                        Duration.millis(120),
                        node
                );

        transition.setToX(1.0);
        transition.setToY(1.0);
        transition.play();
    }

    // =========================================================
    // HELPERS
    // =========================================================

    private String initialsFor(String name) {

        String[] parts = name.split(" ");

        if (parts.length >= 2) {
            return "" +
                    Character.toUpperCase(parts[0].charAt(0)) +
                    Character.toUpperCase(parts[1].charAt(0));
        }

        return name.length() >= 2
                ? name.substring(0, 2).toUpperCase()
                : name.toUpperCase();
    }

    private void setCardStyle(
            Region region,
            double radius
    ) {

        region.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                " -fx-background-radius: " + radius + ";" +
                " -fx-border-color: " + SURFACE_BORDER + ";" +
                " -fx-border-radius: " + radius + ";"
        );
    }
}
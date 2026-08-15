package com.visionx.view.gym_owner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Reviews {

    private Scene ReviewsScene;

    // ==========================================
    // COLOR PALETTE
    // ==========================================

    private final String BG_COLOR = "#0d150e";

    private final String SURFACE = "#020914";

    private final String SURFACE_BORDER =
            "rgba(255, 255, 255, 0.1)";

    private final String PRIMARY = "#75ff9e";

    private final String PRIMARY_DIM =
            "rgba(117, 255, 158, 0.1)";

    private final String TERTIARY = "#ffba79";

    private final String TEXT_MAIN = "#dbe5d9";

    private final String TEXT_MUTED = "#bacbb9";

    private final String ERROR = "#ffb4ab";

    // ==========================================
    // EFFECTS
    // ==========================================

    private final DropShadow glassShadow =
            new DropShadow(
                    30,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.3)
            );

    private final DropShadow primaryGlow =
            new DropShadow(
                    20,
                    Color.web(PRIMARY, 0.2)
            );

    // ==========================================
    // MAIN SCENE
    // ==========================================

    public Scene getReviewsScene(Runnable callBackAction) {

        StackPane rootLayer = new StackPane();

        rootLayer.setStyle(
                "-fx-background-color: " + BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        // ==========================================
        // NO LOCAL HEADER HERE
        // Common header is handled by the parent page.
        // ==========================================

        ScrollPane content = createMainContent();

        StackPane.setMargin(
                content,
                Insets.EMPTY
        );

        rootLayer.getChildren().add(content);

        Scene scene =
                new Scene(
                        rootLayer,
                        1160,
                        900
                );

        ReviewsScene = scene;

        return ReviewsScene;
    }

    // ==========================================
    // MAIN CONTENT
    // ==========================================

    private ScrollPane createMainContent() {

        VBox content = new VBox(32);

        content.setPadding(
                new Insets(40, 32, 40, 32)
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );

        // ==========================================
        // TOP STATS
        // ==========================================

        HBox bentoGrid = new HBox(24);

        VBox ratingCard =
                createOverallRatingCard();

        VBox distCard =
                createRatingDistributionCard();

        VBox sentimentCard =
                createSentimentCard();

        HBox.setHgrow(
                ratingCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                distCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                sentimentCard,
                Priority.ALWAYS
        );

        bentoGrid.getChildren().addAll(
                ratingCard,
                distCard,
                sentimentCard
        );

        // ==========================================
        // FEED CONTROLS
        // ==========================================

        HBox feedControls = new HBox();

        feedControls.setAlignment(
                Pos.CENTER_LEFT
        );

        Label feedTitle =
                new Label("Recent Feedback");

        feedTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Region sp = new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        HBox filterGroup = new HBox(8);

        filterGroup.setAlignment(
                Pos.CENTER
        );

        HBox filters = new HBox(4);

        filters.setPadding(
                new Insets(4)
        );

        filters.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;"
        );

        Button fAll =
                new Button("All");

        fAll.setStyle(
                "-fx-background-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;" +
                "-fx-cursor: hand;"
        );

        Button fPos =
                new Button("Positive");

        fPos.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 6;" +
                "-fx-cursor: hand;"
        );

        Button fNeg =
                new Button("Negative");

        fNeg.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 6;" +
                "-fx-cursor: hand;"
        );

        filters.getChildren().addAll(
                fAll,
                fPos,
                fNeg
        );

        Button sortBtn =
                new Button("≡ Sort by: Newest");

        sortBtn.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-border-radius: 8;" +
                "-fx-padding: 8 16;" +
                "-fx-cursor: hand;"
        );

        filterGroup.getChildren().addAll(
                filters,
                sortBtn
        );

        feedControls.getChildren().addAll(
                feedTitle,
                sp,
                filterGroup
        );

        // ==========================================
        // REVIEWS LIST
        // ==========================================

        VBox reviewsList = new VBox(16);

        reviewsList.getChildren().addAll(
                createReviewCard1(),
                createReviewCard2(),
                createReviewCard3()
        );

        // ==========================================
        // PAGINATION
        // ==========================================

        HBox pagination = new HBox();

        pagination.setAlignment(
                Pos.CENTER_LEFT
        );

        pagination.setPadding(
                new Insets(16)
        );

        pagination.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;"
        );

        Label pLbl =
                new Label(
                        "Showing 1-10 of 1,248 reviews"
                );

        pLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        Region pSp = new Region();

        HBox.setHgrow(
                pSp,
                Priority.ALWAYS
        );

        HBox pBtns = new HBox(8);

        pBtns.getChildren().addAll(
                createPageBtn("‹", false),
                createPageBtn("1", true),
                createPageBtn("2", false),
                createPageBtn("3", false),
                createPageBtn("›", false)
        );

        pagination.getChildren().addAll(
                pLbl,
                pSp,
                pBtns
        );

        // ==========================================
        // ADD EVERYTHING
        // ==========================================

        content.getChildren().addAll(
                bentoGrid,
                feedControls,
                reviewsList,
                pagination
        );

        // ==========================================
        // SCROLL PANE
        // ==========================================

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollBarPolicy.ALWAYS
        );

        scroll.setHbarPolicy(
                ScrollBarPolicy.NEVER
        );

        return scroll;
    }

    // ==========================================
    // OVERALL RATING CARD
    // ==========================================

    private VBox createOverallRatingCard() {

        VBox card = new VBox(8);

        card.setPadding(
                new Insets(24)
        );

        setGlassStyle(card);

        card.setMinWidth(250);

        Label lbl1 =
                new Label("GLOBAL SATISFACTION");

        lbl1.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1px;"
        );

        HBox scoreBox = new HBox(8);

        scoreBox.setAlignment(
                Pos.BASELINE_LEFT
        );

        Label v1 =
                new Label("4.8");

        v1.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 48px;" +
                "-fx-font-weight: bold;"
        );

        Label v2 =
                new Label("/ 5.0");

        v2.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 16px;"
        );

        scoreBox.getChildren().addAll(
                v1,
                v2
        );

        Label stars =
                new Label("★★★★★");

        stars.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;"
        );

        Region sp = new Region();

        VBox.setVgrow(
                sp,
                Priority.ALWAYS
        );

        Label foot =
                new Label(
                        "Based on 1,248 verified member reviews"
                );

        foot.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        card.getChildren().addAll(
                lbl1,
                scoreBox,
                stars,
                sp,
                foot
        );

        cardHoverEffect(card);

        return card;
    }

    // ==========================================
    // RATING DISTRIBUTION
    // ==========================================

    private VBox createRatingDistributionCard() {

        VBox card = new VBox(12);

        card.setPadding(
                new Insets(24)
        );

        setGlassStyle(card);

        card.setMinWidth(350);

        Label lbl1 =
                new Label("RATING BREAKDOWN");

        lbl1.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1px;" +
                "-fx-padding: 0 0 8 0;"
        );

        card.getChildren().add(lbl1);

        card.getChildren().addAll(

                createDistRow(
                        "5",
                        0.82,
                        "82%",
                        PRIMARY
                ),

                createDistRow(
                        "4",
                        0.12,
                        "12%",
                        PRIMARY_DIM.replace(
                                "0.1",
                                "0.7"
                        )
                ),

                createDistRow(
                        "3",
                        0.04,
                        "4%",
                        PRIMARY_DIM.replace(
                                "0.1",
                                "0.4"
                        )
                ),

                createDistRow(
                        "2",
                        0.01,
                        "1%",
                        "rgba(255, 180, 171, 0.4)"
                ),

                createDistRow(
                        "1",
                        0.01,
                        "1%",
                        "rgba(255, 180, 171, 0.7)"
                )
        );

        cardHoverEffect(card);

        return card;
    }

    // ==========================================
    // DISTRIBUTION ROW
    // ==========================================

    private HBox createDistRow(
            String starLbl,
            double pct,
            String pctLbl,
            String col
    ) {

        HBox row = new HBox(16);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label s =
                new Label(starLbl);

        s.setMinWidth(20);

        s.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        StackPane track =
                new StackPane();

        HBox.setHgrow(
                track,
                Priority.ALWAYS
        );

        track.setPrefHeight(8);

        track.setAlignment(
                Pos.CENTER_LEFT
        );

        track.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-background-radius: 4;"
        );

        Region fill =
                new Region();

        fill.setPrefHeight(8);

        fill.setStyle(
                "-fx-background-color: " + col +
                "; -fx-background-radius: 4;"
        );

        fill.maxWidthProperty().bind(
                track.widthProperty().multiply(pct)
        );

        track.getChildren().add(fill);

        Label p =
                new Label(pctLbl);

        p.setMinWidth(30);

        p.setAlignment(
                Pos.CENTER_RIGHT
        );

        p.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        row.getChildren().addAll(
                s,
                track,
                p
        );

        return row;
    }

    // ==========================================
    // SENTIMENT CARD
    // ==========================================

    private VBox createSentimentCard() {

        VBox card = new VBox();

        card.setPadding(
                new Insets(24)
        );

        setGlassStyle(card);

        card.setStyle(
                card.getStyle() +
                "-fx-border-color: " +
                PRIMARY_DIM + ";"
        );

        card.setMinWidth(250);

        Label icon =
                new Label("✨");

        icon.setStyle(
                "-fx-background-color: " +
                PRIMARY_DIM + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 10;" +
                "-fx-background-radius: 50;"
        );

        Label t1 =
                new Label("\"Elite Coaching\"");

        t1.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 16 0 8 0;"
        );

        Label t2 =
                new Label(
                        "Most frequent positive keyword detected by AI this week."
                );

        t2.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 14px;"
        );

        t2.setWrapText(true);

        Region sp = new Region();

        VBox.setVgrow(
                sp,
                Priority.ALWAYS
        );

        Button btn =
                new Button("Generate AI Report ⚡");

        btn.setMaxWidth(
                Double.MAX_VALUE
        );

        String bDef =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #0d150e;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 10 16;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";

        String bHov =
                "-fx-background-color: #85ffaa;" +
                "-fx-text-fill: #0d150e;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 10 16;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 0.98;" +
                "-fx-scale-y: 0.98;";

        btn.setStyle(bDef);

        btn.setEffect(primaryGlow);

        btn.setOnMouseEntered(
                e -> btn.setStyle(bHov)
        );

        btn.setOnMouseExited(
                e -> btn.setStyle(bDef)
        );

        card.getChildren().addAll(
                icon,
                t1,
                t2,
                sp,
                btn
        );

        cardHoverEffect(card);

        return card;
    }

    // ==========================================
    // REVIEW CARD 1
    // ==========================================

    private VBox createReviewCard1() {

        String imgUrl =
                "https://lh3.googleusercontent.com/aida-public/AB6AXuBCSZHySogklRY3WUICgRX5qWWE5dyIwsIik1EiFrXnQhkldSosI5WuxLM5WEzbj3yskyefim7bIZEX8lkoSpJaegEy7SDozyKOr8N9knyMEJ_Ac8ruiaVvgdli__UJIQ9oRvi0BjXGDaXFja1oXLdtGArnKqbQBA8kpyNoZMUgcPVa7GDOIumMSUzHBJRE2OqQIrvI5mJAYHa6ZpUQGnGmbMHpVdku5WHUNxoMcicnLYAZoon-4qbL";

        String txt =
                "The AI-driven insights have completely changed how I track my progress. " +
                "My trainer, Marcus, used the performance data to pivot my routine last week " +
                "and I'm already seeing measurable gains in my explosive power. " +
                "The facilities are always spotless.";

        HBox footerLeft = new HBox(16);

        footerLeft.getChildren().addAll(
                createActionBtn("↩ Reply", false),
                createActionBtn("👁 Hide", false),
                createActionBtn("⚠ Report", true)
        );

        HBox footerRight = new HBox(12);

        footerRight.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label ft =
                new Label(
                        "Relevant to: Performance Analytics, Personal Training"
                );

        ft.setStyle(
                "-fx-text-fill: rgba(186, 203, 185, 0.6);" +
                "-fx-font-size: 12px;" +
                "-fx-font-style: italic;"
        );

        Label fi =
                new Label("👍");

        fi.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-padding: 8;" +
                "-fx-background-radius: 50;" +
                "-fx-border-radius: 50;"
        );

        footerRight.getChildren().addAll(
                ft,
                fi
        );

        return buildReviewCard(
                imgUrl,
                "Sarah Mitchell",
                "Member since Jan 2024 • Verified Elite Member",
                "★★★★★",
                "2 hours ago",
                txt,
                footerLeft,
                footerRight,
                PRIMARY
        );
    }

    // ==========================================
    // REVIEW CARD 2
    // ==========================================

    private VBox createReviewCard2() {

        String imgUrl =
                "https://lh3.googleusercontent.com/aida-public/AB6AXuDysIRi5k3398JaCuCqGx1nGBLD_Gp9VAbBIfPULDgGKD0tiZwSi-InqrNPsZwfnvDFFU5nf1hDOf6gZsy1E_xApXUZ1576eaza7cBO2JgTCUdXvrQidrXLuy2I9MGIx8JH5Mrn1f813PqnUEUQPK1VB1YGXKvx6yqLtNkEI_QC66Yjlm5TgPOeQ2ir4IEAjkStKBNi2Bcua6-qMph8prCDqFbvaTw6vc0uCEtdR5HP9jM9y-pMd3ap";

        String txt =
                "Great experience overall, but the peak hours (6 PM - 8 PM) are becoming quite crowded. " +
                "It would be helpful if the app showed \"real-time occupancy\" for specific zones like " +
                "the squat racks. Still the best gym in the city by a mile.";

        HBox footerLeft = new HBox(16);

        footerLeft.getChildren().addAll(
                createActionBtn("↩ Reply", false),
                createActionBtn("👁 Hide", false),
                createActionBtn("⚠ Report", true)
        );

        HBox footerRight = new HBox(8);

        footerRight.setAlignment(
                Pos.CENTER_RIGHT
        );

        footerRight.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-padding: 4 12;" +
                "-fx-background-radius: 50;"
        );

        Circle dot =
                new Circle(
                        4,
                        Color.web(TERTIARY)
                );

        Label ft =
                new Label("ACTION REQUIRED");

        ft.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        footerRight.getChildren().addAll(
                dot,
                ft
        );

        return buildReviewCard(
                imgUrl,
                "David Chen",
                "Member since Oct 2023 • Local Guide",
                "★★★★☆",
                "Yesterday",
                txt,
                footerLeft,
                footerRight,
                PRIMARY
        );
    }

    // ==========================================
    // REVIEW CARD 3
    // ==========================================

    private VBox createReviewCard3() {

        String imgUrl =
                "https://lh3.googleusercontent.com/aida-public/AB6AXuBE2oMzxd6BOa2_sqzXq6mRVaLf2kgmTK-u1NPj6yZGfY65Mplev1NjChctfaPFb7Guajf9H6a_oexLy4t-ksjj07FuPS6Ugz2nCLRmQ2gABtpZSEEDRmirquKfoUoGVHTRMg45D1TfjDXBXp21gW33a57Qh4QzEJqkPgbnK3Uaaw348MUd1GGbolVyZeR3RWxabMZ1x2gHl6K0T5CrdH4fYhj4NboMPn1K9pGSkeyHX8GDyE2TYIbi";

        String txt =
                "I had an issue with my membership billing where I was charged twice. " +
                "Tried calling but was on hold for 20 minutes. Need this resolved ASAP.";

        HBox footerLeft = new HBox(16);

        Button res =
                new Button("🎧 Resolve Now");

        res.setStyle(
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #0d150e;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 6 16;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        Button rep =
                createActionBtn(
                        "↩ Reply",
                        false
                );

        footerLeft.getChildren().addAll(
                res,
                rep
        );

        HBox footerRight = new HBox(8);

        footerRight.setAlignment(
                Pos.CENTER_RIGHT
        );

        footerRight.setStyle(
                "-fx-background-color: rgba(147, 0, 10, 0.2);" +
                "-fx-border-color: rgba(147, 0, 10, 0.2);" +
                "-fx-padding: 4 12;" +
                "-fx-background-radius: 50;" +
                "-fx-border-radius: 50;"
        );

        Circle dot =
                new Circle(
                        4,
                        Color.web(ERROR)
                );

        Label ft =
                new Label("HIGH PRIORITY");

        ft.setStyle(
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        footerRight.getChildren().addAll(
                dot,
                ft
        );

        return buildReviewCard(
                imgUrl,
                "Jordan Banks",
                "Member since Mar 2024",
                "★★☆☆☆",
                "3 days ago",
                txt,
                footerLeft,
                footerRight,
                ERROR
        );
    }

    // ==========================================
    // BUILD REVIEW CARD
    // ==========================================

    private VBox buildReviewCard(
            String imgUrl,
            String name,
            String meta,
            String stars,
            String time,
            String txt,
            HBox footerLeft,
            HBox footerRight,
            String hoverCol
    ) {

        VBox card = new VBox();

        setGlassStyle(card);

        card.setPadding(
                new Insets(24)
        );

        HBox layout = new HBox(24);

        // ==========================================
        // LEFT IMAGE
        // ==========================================

        ImageView avatar =
                new ImageView(
                        new Image(
                                imgUrl,
                                56,
                                56,
                                true,
                                true
                        )
                );

        Rectangle clip =
                new Rectangle(
                        56,
                        56
                );

        clip.setArcWidth(16);
        clip.setArcHeight(16);

        avatar.setClip(clip);

        StackPane wrap =
                new StackPane(avatar);

        wrap.setStyle(
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-border-radius: 16;" +
                "-fx-border-width: 2;"
        );

        wrap.setAlignment(
                Pos.TOP_LEFT
        );

        // ==========================================
        // RIGHT CONTENT
        // ==========================================

        VBox content = new VBox(8);

        HBox.setHgrow(
                content,
                Priority.ALWAYS
        );

        HBox header = new HBox();

        VBox hL = new VBox(2);

        Label nLbl =
                new Label(name);

        nLbl.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        Label mLbl =
                new Label(meta);

        mLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        hL.getChildren().addAll(
                nLbl,
                mLbl
        );

        Region sp = new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        VBox hR = new VBox(2);

        hR.setAlignment(
                Pos.TOP_RIGHT
        );

        Label sLbl =
                new Label(stars);

        String starColor;

        if (stars.equals("★★☆☆☆")) {
            starColor = ERROR;
        } else {
            starColor = PRIMARY;
        }

        sLbl.setStyle(
                "-fx-text-fill: " + starColor + ";" +
                "-fx-font-size: 16px;"
        );

        Label tLbl =
                new Label(time);

        tLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        hR.getChildren().addAll(
                sLbl,
                tLbl
        );

        header.getChildren().addAll(
                hL,
                sp,
                hR
        );

        Label body =
                new Label(txt);

        body.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-line-spacing: 5px;" +
                "-fx-padding: 8 0 16 0;"
        );

        body.setWrapText(true);

        HBox footer = new HBox();

        footer.setStyle(
                "-fx-border-color: rgba(255,255,255,0.05) " +
                "transparent transparent transparent;" +
                "-fx-padding: 16 0 0 0;"
        );

        footer.setAlignment(
                Pos.CENTER_LEFT
        );

        Region fsp = new Region();

        HBox.setHgrow(
                fsp,
                Priority.ALWAYS
        );

        footer.getChildren().addAll(
                footerLeft,
                fsp,
                footerRight
        );

        content.getChildren().addAll(
                header,
                body,
                footer
        );

        layout.getChildren().addAll(
                wrap,
                content
        );

        card.getChildren().add(layout);

        // ==========================================
        // HOVER
        // ==========================================

        String hoverBorder;

        if (hoverCol.equals(ERROR)) {

            hoverBorder =
                    "rgba(255,180,171,0.3)";

        } else {

            hoverBorder =
                    "rgba(117,255,158,0.3)";
        }

        String cDef =
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 16;";

        String cHov =
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " + hoverBorder + ";" +
                "-fx-border-radius: 16;";

        card.setOnMouseEntered(e -> {

            card.setStyle(cHov);

            card.setTranslateY(-2);
        });

        card.setOnMouseExited(e -> {

            card.setStyle(cDef);

            card.setTranslateY(0);
        });

        return card;
    }

    // ==========================================
    // ACTION BUTTON
    // ==========================================

    private Button createActionBtn(
            String txt,
            boolean isError
    ) {

        Button b =
                new Button(txt);

        String col =
                isError
                        ? ERROR
                        : TEXT_MUTED;

        String hovCol =
                isError
                        ? ERROR
                        : PRIMARY;

        b.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + col + ";" +
                "-fx-font-size: 12px;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 0;"
        );

        b.setOnMouseEntered(e -> {

            b.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " + hovCol + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-cursor: hand;" +
                    "-fx-padding: 0;"
            );

            b.setTranslateY(-1);
        });

        b.setOnMouseExited(e -> {

            b.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " + col + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-cursor: hand;" +
                    "-fx-padding: 0;"
            );

            b.setTranslateY(0);
        });

        return b;
    }

    // ==========================================
    // PAGINATION BUTTON
    // ==========================================

    private Button createPageBtn(
            String txt,
            boolean active
    ) {

        Button b =
                new Button(txt);

        if (active) {

            b.setStyle(
                    "-fx-background-color: " + PRIMARY + ";" +
                    "-fx-text-fill: #0d150e;" +
                    "-fx-font-weight: bold;" +
                    "-fx-pref-width: 40;" +
                    "-fx-pref-height: 40;" +
                    "-fx-background-radius: 8;"
            );

        } else {

            String def =
                    "-fx-background-color: transparent;" +
                    "-fx-border-color: rgba(255,255,255,0.1);" +
                    "-fx-text-fill: " + TEXT_MUTED + ";" +
                    "-fx-border-radius: 8;" +
                    "-fx-pref-width: 40;" +
                    "-fx-pref-height: 40;" +
                    "-fx-cursor: hand;";

            String hov =
                    "-fx-background-color: rgba(255,255,255,0.05);" +
                    "-fx-border-color: " + PRIMARY + ";" +
                    "-fx-text-fill: " + PRIMARY + ";" +
                    "-fx-border-radius: 8;" +
                    "-fx-pref-width: 40;" +
                    "-fx-pref-height: 40;" +
                    "-fx-cursor: hand;";

            b.setStyle(def);

            b.setOnMouseEntered(
                    e -> b.setStyle(hov)
            );

            b.setOnMouseExited(
                    e -> b.setStyle(def)
            );
        }

        return b;
    }

    // ==========================================
    // UTILITIES
    // ==========================================

    private void setGlassStyle(Region region) {

        String base =
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 16;";

        region.setStyle(base);

        region.setEffect(glassShadow);
    }

    private void cardHoverEffect(Region card) {

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: " + SURFACE + ";" +
                    "-fx-background-radius: 16;" +
                    "-fx-border-color: rgba(117, 255, 158, 0.3);" +
                    "-fx-border-radius: 16;"
            );

            card.setTranslateY(-2);
        });

        card.setOnMouseExited(e -> {

            setGlassStyle(card);

            card.setTranslateY(0);
        });
    }
}
package com.visionx.view.gym_owner;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AIInsights {

    // ==========================================
    // COLOR PALETTE
    // ==========================================

    private final String BG_COLOR = "#0d150e";

    private final String SURFACE = "#020914";

    private final String SURFACE_BORDER =
            "rgba(255, 255, 255, 0.05)";

    private final String PRIMARY = "#75ff9e";

    private final String PRIMARY_DIM =
            "rgba(117, 255, 158, 0.2)";

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
                    30,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.3)
            );

    private final DropShadow primaryGlow =
            new DropShadow(
                    20,
                    Color.web(PRIMARY, 0.3)
            );


    private Scene AIAnalyticsScene;


    // ==========================================
    // MAIN SCENE
    // HEADER REMOVED
    // ==========================================

    public Scene getAIAnalyticsScene(Runnable callBackAction) {

        StackPane rootLayer = new StackPane();

        rootLayer.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );


        // ======================================
        // MAIN CONTENT ONLY
        // ======================================

        ScrollPane content = createMainContent();

        StackPane.setAlignment(
                content,
                Pos.CENTER
        );


        // ======================================
        // AI FLOATING BUTTON
        // ======================================

        StackPane fab = createAIFab();

        StackPane.setAlignment(
                fab,
                Pos.BOTTOM_RIGHT
        );

        StackPane.setMargin(
                fab,
                new Insets(32)
        );


        rootLayer.getChildren().addAll(
                content,
                fab
        );


        Scene scene = new Scene(
                rootLayer,
                1160,
                900
        );


        AIAnalyticsScene = scene;

        return AIAnalyticsScene;
    }


    // ==========================================
    // MAIN CONTENT
    // ==========================================

    private ScrollPane createMainContent() {

        VBox content = new VBox(32);

        content.setPadding(
                new Insets(40, 32, 40, 32)
        );

        content.setMaxWidth(1200);

        content.setAlignment(
                Pos.TOP_CENTER
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );


        // ======================================
        // TITLE SECTION
        // ======================================

        VBox titleBox = new VBox(8);


        HBox titleRow = new HBox(12);

        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label spark = new Label("✨");

        spark.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 32px;"
        );


        Label title = new Label(
                "Intelligent Business Pulse"
        );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 36px;" +
                "-fx-font-weight: 800;"
        );


        titleRow.getChildren().addAll(
                spark,
                title
        );


        Label sub = new Label(
                "FitVerse AI has processed over 24,000 data points "
                + "this morning. Here are your optimized growth strategies."
        );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 16px;"
        );

        sub.setWrapText(true);


        titleBox.getChildren().addAll(
                titleRow,
                sub
        );


        // ======================================
        // GRID
        // ======================================

        GridPane grid = new GridPane();

        grid.setHgap(24);
        grid.setVgap(24);


        ColumnConstraints cc1 =
                new ColumnConstraints();

        cc1.setPercentWidth(33.33);


        ColumnConstraints cc2 =
                new ColumnConstraints();

        cc2.setPercentWidth(33.33);


        ColumnConstraints cc3 =
                new ColumnConstraints();

        cc3.setPercentWidth(33.33);


        grid.getColumnConstraints().addAll(
                cc1,
                cc2,
                cc3
        );


        // ======================================
        // TOP ROW
        // ======================================

        VBox pricingCard =
                createPricingCard();

        GridPane.setColumnSpan(
                pricingCard,
                2
        );

        grid.add(
                pricingCard,
                0,
                0
        );


        VBox peakCard =
                createPeakCard();

        grid.add(
                peakCard,
                2,
                0
        );


        // ======================================
        // BOTTOM ROW
        // ======================================

        grid.add(
                createRetentionCard(),
                0,
                1
        );


        grid.add(
                createMarketingCard(),
                1,
                1
        );


        grid.add(
                createActivityCard(),
                2,
                1
        );


        content.getChildren().addAll(
                titleBox,
                grid
        );


        // ======================================
        // SCROLL PANE
        // ======================================

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setFitToHeight(false);

        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollBarPolicy.AS_NEEDED
        );

        scroll.setHbarPolicy(
                ScrollBarPolicy.NEVER
        );


        return scroll;
    }


    // ==========================================
    // PRICING CARD
    // ==========================================

    private VBox createPricingCard() {

        VBox card = new VBox();

        setGlassStyle(card);

        card.setPadding(
                new Insets(32)
        );


        StackPane contentWrap =
                new StackPane();


        Label bgIcon =
                new Label("💵");

        bgIcon.setStyle(
                "-fx-text-fill: rgba(117,255,158,0.05);" +
                "-fx-font-size: 120px;"
        );

        bgIcon.setRotate(15);

        bgIcon.setTranslateX(40);

        bgIcon.setTranslateY(-40);


        StackPane.setAlignment(
                bgIcon,
                Pos.TOP_RIGHT
        );


        VBox fg = new VBox(16);


        HBox badges = new HBox(8);


        Label b1 =
                new Label("HIGH PRIORITY");

        b1.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 4 12;" +
                "-fx-background-radius: 50;"
        );


        Label b2 =
                new Label("Dynamic Strategy");

        b2.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        badges.getChildren().addAll(
                b1,
                b2
        );


        Label title =
                new Label(
                        "Pricing Optimization Opportunity"
                );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );


        Label desc =
                new Label(
                        "Current conversion data suggests a 14% increase "
                        + "in 'Elite' tier sign-ups if bundled with "
                        + "'Advanced Recovery' sessions. "
                        + "Predicted revenue lift: +$12,400/mo."
                );

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 14px;"
        );

        desc.setWrapText(true);

        desc.setMaxWidth(500);


        HBox statsRow =
                new HBox(16);

        statsRow.setAlignment(
                Pos.BOTTOM_LEFT
        );


        VBox s1 =
                createDataBox(
                        "Current Conversion",
                        "8.2%",
                        false
                );


        VBox s2 =
                createDataBox(
                        "AI Target",
                        "11.5%",
                        true
                );


        HBox.setHgrow(
                s1,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                s2,
                Priority.ALWAYS
        );


        Button btn =
                new Button("Apply Strategy ⚡");


        String bDef =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #111827;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 20 32;" +
                "-fx-background-radius: 16;" +
                "-fx-cursor: hand;";


        btn.setStyle(bDef);

        btn.setEffect(primaryGlow);


        btn.setOnMouseEntered(
                e -> btn.setStyle(
                        bDef +
                        "-fx-scale-x: 1.02;" +
                        "-fx-scale-y: 1.02;"
                )
        );


        btn.setOnMouseExited(
                e -> btn.setStyle(bDef)
        );


        statsRow.getChildren().addAll(
                s1,
                s2,
                btn
        );


        fg.getChildren().addAll(
                badges,
                title,
                desc,
                statsRow
        );


        contentWrap.getChildren().addAll(
                bgIcon,
                fg
        );


        card.getChildren().add(
                contentWrap
        );


        cardHoverEffect(card);

        return card;
    }


    // ==========================================
    // DATA BOX
    // ==========================================

    private VBox createDataBox(
            String lbl,
            String val,
            boolean isTarget
    ) {

        VBox box =
                new VBox(4);

        box.setPadding(
                new Insets(16)
        );


        String borderCol =
                isTarget
                        ? "rgba(117,255,158,0.3)"
                        : SURFACE_BORDER;


        String textCol =
                isTarget
                        ? PRIMARY
                        : TEXT_MUTED;


        String valCol =
                isTarget
                        ? PRIMARY
                        : white();


        box.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-border-color: " + borderCol + ";" +
                "-fx-border-radius: 16;" +
                "-fx-background-radius: 16;"
        );


        Label l =
                new Label(
                        lbl.toUpperCase()
                );

        l.setStyle(
                "-fx-text-fill: " + textCol + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );


        Label v =
                new Label(val);

        v.setStyle(
                "-fx-text-fill: " + valCol + ";" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );


        box.getChildren().addAll(
                l,
                v
        );


        return box;
    }


    // ==========================================
    // PEAK CARD
    // ==========================================

    private VBox createPeakCard() {

        VBox card =
                new VBox(20);

        setGlassStyle(card);

        card.setPadding(
                new Insets(32)
        );


        HBox head =
                new HBox();


        VBox text =
                new VBox(4);


        Label t1 =
                new Label("Peak Analysis");

        t1.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        Label t2 =
                new Label(
                        "Optimal Staffing Window"
                );

        t2.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );


        text.getChildren().addAll(
                t1,
                t2
        );


        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );


        Label icon =
                new Label("⏱");

        icon.setStyle(
                "-fx-background-color: rgba(192,198,219,0.1);" +
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 12;" +
                "-fx-background-radius: 16;"
        );


        head.getChildren().addAll(
                text,
                sp,
                icon
        );


        // ======================================
        // CHART
        // ======================================

        HBox chart =
                new HBox(4);

        chart.setPrefHeight(150);

        chart.setAlignment(
                Pos.BOTTOM_CENTER
        );


        double[] heights = {
                0.4,
                0.6,
                0.35,
                0.9,
                0.85,
                0.5,
                0.3
        };


        for (double h : heights) {

            StackPane bar =
                    new StackPane();


            bar.prefHeightProperty().bind(
                    chart.heightProperty()
                            .multiply(h)
            );


            HBox.setHgrow(
                    bar,
                    Priority.ALWAYS
            );


            String col =
                    h > 0.8
                            ? PRIMARY
                            : PRIMARY_DIM;


            bar.setStyle(
                    "-fx-background-color: " + col + ";" +
                    "-fx-background-radius: 8 8 0 0;"
            );


            if (h > 0.8) {

                bar.setEffect(
                        new DropShadow(
                                15,
                                Color.web(PRIMARY, 0.3)
                        )
                );
            }


            chart.getChildren().add(bar);
        }


        // ======================================
        // SUGGESTION BOX
        // ======================================

        VBox sugBox =
                new VBox(4);

        sugBox.setPadding(
                new Insets(16)
        );

        sugBox.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-background-radius: 16;" +
                "-fx-border-radius: 16;"
        );


        Label s1 =
                new Label(
                        "Critical Peak: 17:00 - 19:30"
                );

        s1.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );


        Label s2 =
                new Label(
                        "Suggestion: Deploy 2 additional PTs "
                        + "for functional floor assistance."
                );

        s2.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        s2.setWrapText(true);


        sugBox.getChildren().addAll(
                s1,
                s2
        );


        card.getChildren().addAll(
                head,
                chart,
                sugBox
        );


        cardHoverEffect(card);

        return card;
    }


    // ==========================================
    // RETENTION CARD
    // ==========================================

    private VBox createRetentionCard() {

        VBox card =
                new VBox(20);

        setGlassStyle(card);

        card.setPadding(
                new Insets(32)
        );


        HBox head =
                new HBox(12);

        head.setAlignment(
                Pos.CENTER_LEFT
        );


        Label icon =
                new Label("⚠️");

        icon.setStyle(
                "-fx-background-color: rgba(255,186,121,0.1);" +
                "-fx-text-fill: " + TERTIARY + ";" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 12;" +
                "-fx-background-radius: 16;"
        );


        VBox text =
                new VBox(4);


        Label t1 =
                new Label("Retention Pulse");

        t1.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        Label t2 =
                new Label(
                        "Churn Risk Detected"
                );

        t2.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );


        text.getChildren().addAll(
                t1,
                t2
        );


        head.getChildren().addAll(
                icon,
                text
        );


        // ======================================
        // ALERT BOX
        // ======================================

        HBox alertBox =
                new HBox(12);

        alertBox.setAlignment(
                Pos.CENTER_LEFT
        );

        alertBox.setPadding(
                new Insets(16)
        );

        alertBox.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-border-color: rgba(255,255,255,0.05);" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;"
        );


        Label aIco =
                new Label("👥");

        aIco.setStyle(
                "-fx-font-size: 24px;"
        );


        Label aTxt =
                new Label(
                        "12 At-Risk Members"
                );

        aTxt.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );


        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );


        Label aVal =
                new Label("-14% Growth");

        aVal.setStyle(
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;"
        );


        alertBox.getChildren().addAll(
                aIco,
                aTxt,
                sp,
                aVal
        );


        Label desc =
                new Label(
                        "AI recommends a personalized \"Re-engage\" "
                        + "email campaign for users inactive for > 7 days."
                );

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;" +
                "-fx-line-spacing: 4px;"
        );

        desc.setWrapText(true);


        Region vsp =
                new Region();

        VBox.setVgrow(
                vsp,
                Priority.ALWAYS
        );


        Button btn =
                new Button(
                        "Launch Retention Campaign"
                );

        btn.setMaxWidth(
                Double.MAX_VALUE
        );


        String bDef =
                "-fx-background-color: transparent;" +
                "-fx-border-color: " + TERTIARY + ";" +
                "-fx-text-fill: " + TERTIARY + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;";


        String bHov =
                "-fx-background-color: " + TERTIARY + ";" +
                "-fx-border-color: " + TERTIARY + ";" +
                "-fx-text-fill: #111827;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;";


        btn.setStyle(bDef);


        btn.setOnMouseEntered(
                e -> btn.setStyle(bHov)
        );


        btn.setOnMouseExited(
                e -> btn.setStyle(bDef)
        );


        card.getChildren().addAll(
                head,
                alertBox,
                desc,
                vsp,
                btn
        );


        cardHoverEffect(card);

        return card;
    }


    // ==========================================
    // MARKETING CARD
    // ==========================================

    private StackPane createMarketingCard() {

        StackPane wrapper =
                new StackPane();

        setGlassStyle(wrapper);


        Region imgBg =
                new Region();

        imgBg.setStyle(
                "-fx-background-color: #14231a;" +
                "-fx-background-radius: 24;"
        );

        imgBg.setOpacity(0.15);


        VBox content =
                new VBox(16);

        content.setPadding(
                new Insets(32)
        );


        HBox head =
                new HBox();


        Label badge =
                new Label(
                        "MARKETING INSIGHT"
                );

        badge.setStyle(
                "-fx-background-color: rgba(192,198,219,0.2);" +
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 4 12;" +
                "-fx-background-radius: 50;"
        );


        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );


        Label icon =
                new Label("📈");

        icon.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 20px;"
        );


        head.getChildren().addAll(
                badge,
                sp,
                icon
        );


        Label title =
                new Label(
                        "Yoga & Mobility Surge"
                );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );


        Label desc =
                new Label(
                        "Waitlist for morning Yoga has grown 40%. "
                        + "Recommend adding a 7:30 AM slot on "
                        + "Tuesdays/Thursdays."
                );

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 14px;"
        );

        desc.setWrapText(true);


        Region vsp =
                new Region();

        VBox.setVgrow(
                vsp,
                Priority.ALWAYS
        );


        HBox bot =
                new HBox();

        bot.setAlignment(
                Pos.BOTTOM_LEFT
        );


        Label bigVal =
                new Label("+40%");

        bigVal.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 48px;" +
                "-fx-font-weight: 800;"
        );


        Region sp2 =
                new Region();

        HBox.setHgrow(
                sp2,
                Priority.ALWAYS
        );


        Button addBtn =
                new Button("➕");


        String adef =
                "-fx-background-color: #020914;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 12;" +
                "-fx-background-radius: 50;" +
                "-fx-cursor: hand;";


        String aHov =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #111827;" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 12;" +
                "-fx-background-radius: 50;" +
                "-fx-cursor: hand;";


        addBtn.setStyle(adef);


        addBtn.setOnMouseEntered(
                e -> addBtn.setStyle(aHov)
        );


        addBtn.setOnMouseExited(
                e -> addBtn.setStyle(adef)
        );


        bot.getChildren().addAll(
                bigVal,
                sp2,
                addBtn
        );


        content.getChildren().addAll(
                head,
                title,
                desc,
                vsp,
                bot
        );


        wrapper.getChildren().addAll(
                imgBg,
                content
        );


        cardHoverEffect(wrapper);

        return wrapper;
    }


    // ==========================================
    // ACTIVITY CARD
    // ==========================================

    private VBox createActivityCard() {

        VBox card =
                new VBox(24);

        setGlassStyle(card);

        card.setPadding(
                new Insets(32)
        );


        Label title =
                new Label(
                        "Neural Activity"
                );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        VBox list =
                new VBox(20);


        list.getChildren().addAll(

                createTimelineItem(
                        PRIMARY,
                        "Pricing Model Updated",
                        "2 mins ago",
                        "Successfully analyzed competitor pricing "
                        + "in a 5-mile radius.",
                        true
                ),


                createTimelineItem(
                        SECONDARY,
                        "New Segment Identified",
                        "1 hour ago",
                        "'Corporate Wellness' interest is rising "
                        + "among local startups.",
                        true
                ),


                createTimelineItem(
                        "#ffffff",
                        "Data Sync Complete",
                        "3 hours ago",
                        "Wearable integration data from 1.2k "
                        + "members ingested.",
                        false
                )
        );


        card.getChildren().addAll(
                title,
                list
        );


        cardHoverEffect(card);

        return card;
    }


    // ==========================================
    // TIMELINE ITEM
    // ==========================================

    private HBox createTimelineItem(
            String colorHex,
            String title,
            String time,
            String desc,
            boolean hasLine
    ) {

        HBox row =
                new HBox(16);


        VBox leftCol =
                new VBox(4);

        leftCol.setAlignment(
                Pos.TOP_CENTER
        );


        StackPane outerDot =
                new StackPane();

        outerDot.setMinSize(
                24,
                24
        );

        outerDot.setPrefSize(
                24,
                24
        );


        String dotColor;

        if (colorHex.equalsIgnoreCase("#ffffff")) {

            dotColor =
                    "rgba(255,255,255,0.2)";

        } else if (
                colorHex.equalsIgnoreCase(PRIMARY)
        ) {

            dotColor =
                    "rgba(117,255,158,0.2)";

        } else {

            dotColor =
                    "rgba(192,198,219,0.2)";
        }


        String borderColor;

        if (colorHex.equalsIgnoreCase("#ffffff")) {

            borderColor =
                    "rgba(255,255,255,0.4)";

        } else if (
                colorHex.equalsIgnoreCase(PRIMARY)
        ) {

            borderColor =
                    "rgba(117,255,158,0.4)";

        } else {

            borderColor =
                    "rgba(192,198,219,0.4)";
        }


        outerDot.setStyle(
                "-fx-background-color: " + dotColor + ";" +
                "-fx-border-color: " + borderColor + ";" +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;"
        );


        Circle innerDot =
                new Circle(
                        4,
                        Color.web(colorHex)
                );


        outerDot.getChildren().add(
                innerDot
        );


        leftCol.getChildren().add(
                outerDot
        );


        if (hasLine) {

            Region line =
                    new Region();

            line.setPrefWidth(2);

            line.setMinWidth(2);

            line.setStyle(
                    "-fx-background-color: "
                    + "rgba(255,255,255,0.1);"
            );


            VBox.setVgrow(
                    line,
                    Priority.ALWAYS
            );


            leftCol.getChildren().add(
                    line
            );
        }


        VBox rightCol =
                new VBox(4);


        Label tLbl =
                new Label(title);

        tLbl.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );


        Label dLbl =
                new Label(time);

        dLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;"
        );


        Label mLbl =
                new Label(desc);

        mLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        mLbl.setWrapText(true);


        rightCol.getChildren().addAll(
                tLbl,
                dLbl,
                mLbl
        );


        // ======================================
        // HOVER ANIMATION
        // ======================================

        ScaleTransition st =
                new ScaleTransition(
                        Duration.millis(200),
                        outerDot
                );


        row.setOnMouseEntered(
                e -> {

                    st.setToX(1.3);
                    st.setToY(1.3);

                    st.play();
                }
        );


        row.setOnMouseExited(
                e -> {

                    st.setToX(1.0);
                    st.setToY(1.0);

                    st.play();
                }
        );


        row.getChildren().addAll(
                leftCol,
                rightCol
        );


        return row;
    }


    // ==========================================
    // AI FAB
    // ==========================================

    private StackPane createAIFab() {

        StackPane fab =
                new StackPane();


        fab.setMaxSize(
                64,
                64
        );

        fab.setMinSize(
                64,
                64
        );


        fab.setStyle(
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-background-radius: 20;" +
                "-fx-cursor: hand;"
        );


        fab.setEffect(
                new DropShadow(
                        20,
                        Color.web(PRIMARY, 0.4)
                )
        );


        Label icon =
                new Label("🧠");

        icon.setStyle(
                "-fx-font-size: 32px;" +
                "-fx-text-fill: #0d150e;"
        );


        fab.getChildren().add(
                icon
        );


        ScaleTransition st =
                new ScaleTransition(
                        Duration.millis(150),
                        fab
                );


        fab.setOnMouseEntered(
                e -> {

                    st.setToX(1.1);
                    st.setToY(1.1);

                    st.play();
                }
        );


        fab.setOnMouseExited(
                e -> {

                    st.setToX(1.0);
                    st.setToY(1.0);

                    st.play();
                }
        );


        return fab;
    }


    // ==========================================
    // GLASS STYLE
    // ==========================================

    private void setGlassStyle(
            Region region
    ) {

        String base =
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-background-radius: 24;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 24;";


        region.setStyle(base);

        region.setEffect(
                glassShadow
        );
    }


    // ==========================================
    // CARD HOVER EFFECT
    // ==========================================

    private void cardHoverEffect(
            Region card
    ) {

        card.setOnMouseEntered(
                e -> {

                    card.setStyle(
                            "-fx-background-color: " + SURFACE + ";" +
                            "-fx-background-radius: 24;" +
                            "-fx-border-color: rgba(117,255,158,0.3);" +
                            "-fx-border-radius: 24;"
                    );

                    card.setTranslateY(-4);
                }
        );


        card.setOnMouseExited(
                e -> {

                    setGlassStyle(card);

                    card.setTranslateY(0);
                }
        );
    }


    // ==========================================
    // WHITE COLOR
    // ==========================================

    private String white() {

        return "#ffffff";
    }
}
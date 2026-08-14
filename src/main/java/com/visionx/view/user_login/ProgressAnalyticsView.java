



package com.visionx.view.user_login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class ProgressAnalyticsView extends Application {

    private Scene analyticsScene;

    public Scene getAnalyticsScene(Runnable callBackAction) {

        BorderPane borderPane = new BorderPane();

        // Main background
        borderPane.setStyle(
            "-fx-background-color: #080C14;"
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox mainContent = new VBox(25);

        mainContent.setPadding(
            new Insets(35, 45, 40, 45)
        );

        mainContent.setStyle(
            "-fx-background-color: #080C14;"
        );

        // =========================================================
        // HEADER
        // =========================================================

        HBox header = new HBox();

        header.setAlignment(
            Pos.CENTER_LEFT
        );

        VBox titleBox = new VBox(5);

        Text title = new Text(
            "Progress Analytics"
        );

        title.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;"
        );

        Text subtitle = new Text(
            "Precision tracking for elite performance."
        );

        subtitle.setStyle(
            "-fx-fill: #8a8d91;" +
            "-fx-font-size: 14px;"
        );

        titleBox.getChildren().addAll(
            title,
            subtitle
        );

        Region headerSpacer = new Region();

        HBox.setHgrow(
            headerSpacer,
            Priority.ALWAYS
        );

        // Date button
        Button last30Btn = new Button(
            "ðŸ“…  Last 30 Days"
        );

        last30Btn.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-border-color: #2A323D;" +
            "-fx-border-radius: 22px;" +
            "-fx-background-radius: 22px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-font-size: 13px;"
        );

        // Export button
        Button exportBtn = new Button(
            "â†“  Export Data"
        );

        exportBtn.setStyle(
            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #061009;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 22px;" +
            "-fx-padding: 10px 20px;" +
            "-fx-font-size: 13px;"
        );

        HBox headerButtons = new HBox(
            12,
            last30Btn,
            exportBtn
        );

        headerButtons.setAlignment(
            Pos.CENTER_RIGHT
        );

        header.getChildren().addAll(
            titleBox,
            headerSpacer,
            headerButtons
        );

        // =========================================================
        // AI INSIGHT CARD
        // =========================================================

        HBox aiCard = new HBox(20);

        aiCard.setAlignment(
            Pos.CENTER_LEFT
        );

        aiCard.setPadding(
            new Insets(22, 25, 22, 25)
        );

        aiCard.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        // AI Icon
        StackPane aiIconPane = new StackPane();

        Circle aiCircle = new Circle(
            25,
            Color.web("#10291B")
        );

        aiCircle.setStroke(
            Color.web("#62ff96")
        );

        aiCircle.setStrokeWidth(1.5);

        Text aiIcon = new Text("âœ¦");

        aiIcon.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;"
        );

        aiIconPane.getChildren().addAll(
            aiCircle,
            aiIcon
        );

        // AI text
        VBox aiText = new VBox(7);

        HBox.setHgrow(
            aiText,
            Priority.ALWAYS
        );

        Text aiTitle = new Text(
            "AI Insights"
        );

        aiTitle.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 17px;" +
            "-fx-font-weight: bold;"
        );

        HBox insightLine = new HBox();

        Text text1 = new Text(
            "Your consistency has improved by "
        );

        text1.setStyle(
            "-fx-fill: #A0A6AE;" +
            "-fx-font-size: 13px;"
        );

        Text percentage = new Text(
            "14%"
        );

        percentage.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;"
        );

        Text text2 = new Text(
            " over the last month."
        );

        text2.setStyle(
            "-fx-fill: #A0A6AE;" +
            "-fx-font-size: 13px;"
        );

        insightLine.getChildren().addAll(
            text1,
            percentage,
            text2
        );

        Text insight2 = new Text(
            "Recovery cycles are peaking on Wednesdays â€” consider increasing"
        );

        insight2.setStyle(
            "-fx-fill: #8A919B;" +
            "-fx-font-size: 12px;"
        );

        Text insight3 = new Text(
            "intensity during mid-week leg sessions for optimal hypertrophy gains."
        );

        insight3.setStyle(
            "-fx-fill: #8A919B;" +
            "-fx-font-size: 12px;"
        );

        aiText.getChildren().addAll(
            aiTitle,
            insightLine,
            insight2,
            insight3
        );

        Button analysisBtn = new Button(
            "View Full Analysis"
        );

        analysisBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #62ff96;" +
            "-fx-border-color: #315B43;" +
            "-fx-border-radius: 20px;" +
            "-fx-background-radius: 20px;" +
            "-fx-padding: 9px 15px;" +
            "-fx-font-size: 12px;"
        );

        aiCard.getChildren().addAll(
            aiIconPane,
            aiText,
            analysisBtn
        );

        // =========================================================
        // MIDDLE ROW
        // =========================================================

        HBox middleRow = new HBox(22);

        // =========================================================
        // WEIGHT CARD
        // =========================================================

        VBox weightCard = createCard();

        HBox.setHgrow(
            weightCard,
            Priority.ALWAYS
        );

        HBox weightHeader = new HBox();

        VBox weightTitleBox = new VBox(4);

        Text weightTitle = new Text(
            "Weight & Body Fat"
        );

        weightTitle.setStyle(
            "-fx-fill: #ffffff;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;"
        );

        Text weightSub = new Text(
            "â— Tracking metabolic progress"
        );

        weightSub.setStyle(
            "-fx-fill: #7F8792;" +
            "-fx-font-size: 12px;"
        );

        weightTitleBox.getChildren().addAll(
            weightTitle,
            weightSub
        );

        Region weightSpacer = new Region();

        HBox.setHgrow(
            weightSpacer,
            Priority.ALWAYS
        );

        Text weightLegend = new Text(
            "â— Weight     â— Body Fat %"
        );

        weightLegend.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 11px;"
        );

        weightHeader.getChildren().addAll(
            weightTitleBox,
            weightSpacer,
            weightLegend
        );

        // Chart
        HBox chartBox = new HBox(25);

        chartBox.setAlignment(
            Pos.BOTTOM_CENTER
        );

        chartBox.setPrefHeight(170);

        int[] weightHeights = {
            110, 100, 108, 105, 102, 100
        };

        int[] bodyFatHeights = {
            95, 90, 88, 86, 82, 80
        };

        String[] dates = {
            "Oct 01",
            "Oct 07",
            "Oct 14",
            "Oct 21",
            "Oct 28",
            "Now"
        };

        for (int i = 0; i < dates.length; i++) {

            VBox column = new VBox(8);

            column.setAlignment(
                Pos.BOTTOM_CENTER
            );

            HBox bars = new HBox(5);

            bars.setAlignment(
                Pos.BOTTOM_CENTER
            );

            Rectangle weightBar =
                new Rectangle(
                    25,
                    weightHeights[i]
                );

            weightBar.setArcWidth(6);
            weightBar.setArcHeight(6);

            weightBar.setFill(
                Color.web("#087858")
            );

            Rectangle fatBar =
                new Rectangle(
                    25,
                    bodyFatHeights[i]
                );

            fatBar.setArcWidth(6);
            fatBar.setArcHeight(6);

            fatBar.setFill(
                Color.web("#62ff96")
            );

            Text date = new Text(
                dates[i]
            );

            date.setStyle(
                "-fx-fill: #68758A;" +
                "-fx-font-size: 10px;"
            );

            bars.getChildren().addAll(
                weightBar,
                fatBar
            );

            column.getChildren().addAll(
                bars,
                date
            );

            chartBox.getChildren().add(
                column
            );
        }

        weightCard.getChildren().addAll(
            weightHeader,
            chartBox
        );

        // =========================================================
        // BMI CARD
        // =========================================================

        VBox bmiCard = createCard();

        bmiCard.setPrefWidth(360);
        bmiCard.setMinWidth(360);
        bmiCard.setMaxWidth(360);

        HBox bmiHeader = new HBox();

        Text bmiTitle = new Text(
            "BMI Metric"
        );

        bmiTitle.setStyle(
            "-fx-fill: #ffffff;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;"
        );

        Region bmiSpacer = new Region();

        HBox.setHgrow(
            bmiSpacer,
            Priority.ALWAYS
        );

        Label optimalBadge = new Label(
            "OPTIMAL"
        );

        optimalBadge.setStyle(
            "-fx-background-color: #10291B;" +
            "-fx-text-fill: #62ff96;" +
            "-fx-border-color: #315B43;" +
            "-fx-border-radius: 5px;" +
            "-fx-background-radius: 5px;" +
            "-fx-padding: 4px 9px;" +
            "-fx-font-size: 10px;" +
            "-fx-font-weight: bold;"
        );

        bmiHeader.getChildren().addAll(
            bmiTitle,
            bmiSpacer,
            optimalBadge
        );

        // Gauge
        StackPane gaugePane = new StackPane();

        gaugePane.setPrefHeight(200);

        Circle backgroundCircle =
            new Circle(
                65,
                Color.TRANSPARENT
            );

        backgroundCircle.setStroke(
            Color.web("#273142")
        );

        backgroundCircle.setStrokeWidth(11);

        Arc bmiArc = new Arc(
            0,
            0,
            65,
            65,
            225,
            -250
        );

        bmiArc.setType(
            ArcType.OPEN
        );

        bmiArc.setFill(
            Color.TRANSPARENT
        );

        bmiArc.setStroke(
            Color.web("#62ff96")
        );

        bmiArc.setStrokeWidth(11);

        bmiArc.setStrokeLineCap(
            javafx.scene.shape.StrokeLineCap.ROUND
        );

        VBox bmiText = new VBox(2);

        bmiText.setAlignment(
            Pos.CENTER
        );

        Text bmiValue = new Text(
            "22.4"
        );

        bmiValue.setStyle(
            "-fx-fill: #ffffff;" +
            "-fx-font-size: 36px;" +
            "-fx-font-weight: bold;"
        );

        Text index = new Text(
            "INDEX"
        );

        index.setStyle(
            "-fx-fill: #7D8795;" +
            "-fx-font-size: 10px;" +
            "-fx-font-weight: bold;"
        );

        bmiText.getChildren().addAll(
            bmiValue,
            index
        );

        gaugePane.getChildren().addAll(
            backgroundCircle,
            bmiArc,
            bmiText
        );

        // Scale labels
        HBox scaleLabels = new HBox();

        Text underweight = new Text(
            "Underweight"
        );

        underweight.setStyle(
            "-fx-fill: #64748B;" +
            "-fx-font-size: 10px;"
        );

        Region s1 = new Region();
        HBox.setHgrow(
            s1,
            Priority.ALWAYS
        );

        Text optimal = new Text(
            "Optimal"
        );

        optimal.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 10px;" +
            "-fx-font-weight: bold;"
        );

        Region s2 = new Region();
        HBox.setHgrow(
            s2,
            Priority.ALWAYS
        );

        Text overweight = new Text(
            "Overweight"
        );

        overweight.setStyle(
            "-fx-fill: #64748B;" +
            "-fx-font-size: 10px;"
        );

        scaleLabels.getChildren().addAll(
            underweight,
            s1,
            optimal,
            s2,
            overweight
        );

        // Scale bar
        HBox scaleBar = new HBox();

        scaleBar.setPrefHeight(7);

        Region blue = new Region();

        blue.setStyle(
            "-fx-background-color: #315B9B;" +
            "-fx-background-radius: 5px 0 0 5px;"
        );

        HBox.setHgrow(
            blue,
            Priority.ALWAYS
        );

        Region green = new Region();

        green.setStyle(
            "-fx-background-color: #62ff96;"
        );

        HBox.setHgrow(
            green,
            Priority.ALWAYS
        );

        Region orange = new Region();

        orange.setStyle(
            "-fx-background-color: #9A7B32;" +
            "-fx-background-radius: 0 5px 5px 0;"
        );

        HBox.setHgrow(
            orange,
            Priority.ALWAYS
        );

        scaleBar.getChildren().addAll(
            blue,
            green,
            orange
        );

        HBox rangeBox = new HBox();

        Text min = new Text("18.5");

        min.setStyle(
            "-fx-fill: #596273;" +
            "-fx-font-size: 10px;"
        );

        Region r1 = new Region();

        HBox.setHgrow(
            r1,
            Priority.ALWAYS
        );

        Text normal = new Text(
            "18.5 â€“ 24.9"
        );

        normal.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 10px;" +
            "-fx-font-weight: bold;"
        );

        Region r2 = new Region();

        HBox.setHgrow(
            r2,
            Priority.ALWAYS
        );

        Text max = new Text(
            "25+"
        );

        max.setStyle(
            "-fx-fill: #596273;" +
            "-fx-font-size: 10px;"
        );

        rangeBox.getChildren().addAll(
            min,
            r1,
            normal,
            r2,
            max
        );

        bmiCard.getChildren().addAll(
            bmiHeader,
            gaugePane,
            scaleLabels,
            scaleBar,
            rangeBox
        );

        middleRow.getChildren().addAll(
            weightCard,
            bmiCard
        );

        // =========================================================
        // BOTTOM ROW
        // =========================================================

        HBox bottomRow = new HBox(22);

        // =========================================================
        // CONSISTENCY CARD
        // =========================================================

        VBox consistencyCard = createCard();

        HBox.setHgrow(
            consistencyCard,
            Priority.ALWAYS
        );

        HBox consistencyHeader = new HBox();
        consistencyHeader.setAlignment(Pos.TOP_LEFT);

        VBox consistencyTitleBox = new VBox(2);
        Text consistencyTitle = new Text("Workout Consistency");
        consistencyTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 16px; -fx-font-weight: bold;");
        Text consistencySubtitle = new Text("Monthly workout frequency");
        consistencySubtitle.setStyle("-fx-fill: #8a8d91; -fx-font-size: 12px;");
        consistencyTitleBox.getChildren().addAll(consistencyTitle, consistencySubtitle);

        Region consistencySpacer = new Region();
        HBox.setHgrow(consistencySpacer, Priority.ALWAYS);

        Label trend = new Label("+12% vs last month");
        trend.setStyle(
            "-fx-text-fill: #38ff8e;" +
            "-fx-background-color: #0d281a;" +
            "-fx-border-color: #114f34;" +
            "-fx-border-radius: 4px;" +
            "-fx-background-radius: 4px;" +
            "-fx-padding: 4px 8px;" +
            "-fx-font-size: 11px;" +
            "-fx-font-weight: bold;"
        );

        consistencyHeader.getChildren().addAll(consistencyTitleBox, consistencySpacer, trend);

        // Heatmap
        GridPane heatMap = new GridPane();
        heatMap.setHgap(8);
        heatMap.setVgap(8);

        Random random = new Random(42);
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 7; col++) {
                Rectangle square = new Rectangle(55, 22);
                square.setArcWidth(8);
                square.setArcHeight(8);

                double value = random.nextDouble();
                if (value < 0.25) {
                    square.setFill(Color.web("#171e27"));
                } else if (value < 0.5) {
                    square.setFill(Color.web("#114f34"));
                } else if (value < 0.75) {
                    square.setFill(Color.web("#0fb659"));
                } else {
                    square.setFill(Color.web("#38ff8e"));
                }

                heatMap.add(square, col, row);
            }
        }
        heatMap.setAlignment(Pos.CENTER);

        HBox consistencyFooter = new HBox();
        consistencyFooter.setAlignment(Pos.CENTER_LEFT);

        Text monthText = new Text("Monday \u2014 Oct 2024");
        monthText.setStyle("-fx-fill: #596273; -fx-font-size: 11px;");

        Region footerSpacer = new Region();
        HBox.setHgrow(footerSpacer, Priority.ALWAYS);

        HBox consistencyLegend = new HBox(6);
        consistencyLegend.setAlignment(Pos.CENTER_RIGHT);

        Text less = new Text("Less");
        less.setStyle("-fx-fill: #8A8D91; -fx-font-size: 11px;");

        Circle c1 = new Circle(4, Color.web("#171e27"));
        Circle c2 = new Circle(4, Color.web("#114f34"));
        Circle c3 = new Circle(4, Color.web("#0fb659"));
        Circle c4 = new Circle(4, Color.web("#38ff8e"));

        Text more = new Text("More");
        more.setStyle("-fx-fill: #8A8D91; -fx-font-size: 11px;");

        consistencyLegend.getChildren().addAll(less, c1, c2, c3, c4, more);
        consistencyFooter.getChildren().addAll(monthText, footerSpacer, consistencyLegend);

        consistencyCard.getChildren().addAll(
            consistencyHeader,
            heatMap,
            consistencyFooter
        );

        // =========================================================
        // BADGES CARD
        // =========================================================

        VBox badgesCard = createCard();

        HBox.setHgrow(
            badgesCard,
            Priority.ALWAYS
        );

        HBox badgesHeader = new HBox();
        badgesHeader.setAlignment(Pos.CENTER_LEFT);

        Text badgesTitle = new Text("Earned Badges");
        badgesTitle.setStyle("-fx-fill: #ffffff; -fx-font-size: 16px; -fx-font-weight: bold;");

        Region badgesSpacer = new Region();
        HBox.setHgrow(badgesSpacer, Priority.ALWAYS);

        Text viewAll = new Text("View All 42 >");
        viewAll.setStyle("-fx-fill: #38ff8e; -fx-font-size: 12px;");

        badgesHeader.getChildren().addAll(badgesTitle, badgesSpacer, viewAll);

        HBox badgesBox = new HBox(15);
        badgesBox.setAlignment(Pos.CENTER);

        badgesBox.getChildren().addAll(
            createCustomBadge("🛡️", "Iron Heart", "Lvl 5", true),
            createCustomBadge("⚡", "Fast Mover", "Lvl 3", true),
            createCustomBadge("🔥", "Calorie Burner", "Lvl 4", true),
            createCustomBadge("🏅", "Marathoner", "Locked", false)
        );

        Text unlockText = new Text("Complete 3 more high-intensity sessions to unlock Marathoner.");
        unlockText.setStyle("-fx-fill: #596273; -fx-font-size: 11px;");
        
        VBox badgesContainer = new VBox(25);
        badgesContainer.setAlignment(Pos.CENTER);
        badgesContainer.getChildren().addAll(badgesBox, unlockText);

        badgesCard.getChildren().addAll(
            badgesHeader,
            badgesContainer
        );

        bottomRow.getChildren().addAll(
            consistencyCard,
            badgesCard
        );

        // =========================================================
        // ADD MAIN CONTENT
        // =========================================================

        mainContent.getChildren().addAll(
            header,
            aiCard,
            middleRow,
            bottomRow
        );

        // =========================================================
        // FOOTER
        // =========================================================

        HBox footer = new HBox();

        footer.setPadding(
            new Insets(22, 45, 22, 45)
        );

        footer.setAlignment(
            Pos.CENTER_LEFT
        );

        footer.setStyle(
            "-fx-background-color: #0C1119;" +
            "-fx-border-color: #1D252E;" +
            "-fx-border-width: 1 0 0 0;"
        );

        Text logo = new Text(
            "FitVerse AI"
        );

        logo.setStyle(
            "-fx-fill: #62ff96;" +
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;"
        );

        Region footerSpacer1 = new Region();

        HBox.setHgrow(
            footerSpacer1,
            Priority.ALWAYS
        );

        HBox links = new HBox(20);

        String[] footerLinks = {
            "Privacy Policy",
            "Terms of Service",
            "Contact",
            "About"
        };

        for (String link : footerLinks) {

            Text t = new Text(link);

            t.setStyle(
                "-fx-fill: #737B87;" +
                "-fx-font-size: 11px;"
            );

            links.getChildren().add(t);
        }

        Region footerSpacer2 = new Region();

        HBox.setHgrow(
            footerSpacer2,
            Priority.ALWAYS
        );

        Text copyright = new Text(
            "Â© 2026 FitVerse AI"
        );

        copyright.setStyle(
            "-fx-fill: #737B87;" +
            "-fx-font-size: 11px;"
        );

        footer.getChildren().addAll(
            logo,
            footerSpacer1,
            links,
            footerSpacer2,
            copyright
        );

        // =========================================================
        // SCROLL PANE
        // =========================================================

        ScrollPane scrollPane =
            new ScrollPane();

        scrollPane.setContent(
            mainContent
        );

        scrollPane.setFitToWidth(
            true
        );

        scrollPane.setStyle(
            "-fx-background: #080C14;" +
            "-fx-background-color: #080C14;" +
            "-fx-border-color: transparent;"
        );

        borderPane.setCenter(
            scrollPane
        );

        // borderPane.setBottom(
        //     footer
        // );

        StackPane pageRoot = new StackPane();
        pageRoot.setStyle("-fx-background-color: #080C14;");

        pageRoot.getChildren().add(borderPane);

        AiMentorFloating.addTo(pageRoot);
        // =========================================================
        // SCENE
        // =========================================================

        analyticsScene =
            new Scene(
                pageRoot,
                1350,
                900
            );

        return analyticsScene;
    }

    // =============================================================
    // CARD HELPER
    // =============================================================

    private VBox createCard() {

        VBox card = new VBox(18);

        card.setPadding(
            new Insets(23)
        );

        card.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        return card;
    }

    // =============================================================
    // BADGE HELPER
    // =============================================================

    private VBox createBadge(
        String iconStr,
        String label,
        boolean primary
    ) {

        VBox box = new VBox(10);

        box.setAlignment(Pos.CENTER);

        StackPane iconPane = new StackPane();
        Circle circle = new Circle(22, Color.TRANSPARENT);
        circle.setStroke(primary ? Color.web("#38ff8e") : Color.web("#303842"));
        circle.setStrokeWidth(1.5);

        Text icon = new Text(iconStr);
        icon.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-fill: " + (primary ? "#38ff8e" : "#707883") + ";"
        );
        iconPane.getChildren().addAll(circle, icon);

        Text badgeLabel = new Text(label);
        badgeLabel.setStyle(
            "-fx-fill: " + (primary ? "#ffffff" : "#7F8792") + ";" +
            "-fx-font-size: 12px; -fx-font-weight: bold;"
        );

        box.getChildren().addAll(iconPane, badgeLabel);
        return box;
    }

    private VBox createCustomBadge(String iconStr, String title, String subtitle, boolean unlocked) {
        VBox badge = new VBox(10);
        badge.setAlignment(Pos.CENTER);
        badge.setPadding(new Insets(20, 18, 20, 18));
        badge.setStyle(
            "-fx-background-color: #0b1825;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 12px;"
        );

        StackPane iconPane = new StackPane();
        Circle circle = new Circle(22, Color.web("#172431")); // Filled circle for background
        circle.setStroke(unlocked ? Color.web("#0fb659") : Color.TRANSPARENT);
        circle.setStrokeWidth(1);

        Text icon = new Text(iconStr);
        icon.setStyle("-fx-font-size: 18px;");
        if (!unlocked) {
            icon.setOpacity(0.4);
        }

        iconPane.getChildren().addAll(circle, icon);

        Text titleText = new Text(title);
        titleText.setStyle("-fx-fill: " + (unlocked ? "#ffffff" : "#8a8d91") + "; -fx-font-size: 12px; -fx-font-weight: bold;");

        Text subtitleText = new Text(subtitle);
        subtitleText.setStyle("-fx-fill: #596273; -fx-font-size: 10px;");

        badge.getChildren().addAll(iconPane, titleText, subtitleText);
        
        // Give badge some preferred width so they are equal
        badge.setPrefWidth(100);

        return badge;
    }

    // =============================================================
    // START
    // =============================================================

    @Override
    public void start(Stage stage) {

        Runnable navCallback = () -> {

            System.out.println(
                "Executing Callback Navigation..."
            );
        };

        stage.setScene(
            getAnalyticsScene(
                navCallback
            )
        );

        stage.setTitle(
            "FitVerse AI - Progress Analytics"
        );

        stage.show();
    }
}

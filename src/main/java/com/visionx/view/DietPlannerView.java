


package com.visionx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DietPlannerView {

    private Scene dietPlannerScene;

    private final String GREEN = "#62ff96";
    private final String DARK = "#080C14";
    private final String CARD = "#07111d";
    private final String TEXT = "#ffffff";
    private final String SECONDARY = "#8a8d91";

    public Scene getDietPlannerScene(Runnable callBackAction) {

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root = new BorderPane();

        root.setStyle(
            "-fx-background-color: #080C14;"
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent = new VBox(25);

        mainContent.setPadding(
            new Insets(30, 40, 40, 40)
        );

        mainContent.setStyle(
            "-fx-background-color: #080C14;"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header = new HBox();

        header.setAlignment(
            Pos.CENTER_LEFT
        );

        VBox titleBox = new VBox(5);

        Text title = new Text(
            "Diet Planner"
        );

        title.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text subtitle = new Text(
            "Get a personalized nutrition plan designed around your fitness goals."
        );

        subtitle.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-fill: #8a8d91;"
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

        // =====================================================
        // BACK BUTTON
        // =====================================================

        Button backButton = new Button(
            "← Dashboard"
        );

        addHoverEffect(
            backButton,

            "-fx-background-color: #151b24;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-background-radius: 10px;" +
            "-fx-border-color: #293642;" +
            "-fx-border-radius: 10px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-background-radius: 10px;" +
            "-fx-border-color: #62ff96;" +
            "-fx-border-radius: 10px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        backButton.setOnAction(e -> {

            if (callBackAction != null) {
                callBackAction.run();
            }

        });

        header.getChildren().addAll(
            titleBox,
            headerSpacer,
            backButton
        );

        // =====================================================
        // AI GENERATE SECTION
        // =====================================================

        VBox aiCard = new VBox(15);

        aiCard.setPadding(
            new Insets(25)
        );

        aiCard.setStyle(
            "-fx-background-color: linear-gradient(to right, #07111d, #091a17);" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: rgba(98,255,150,0.25);" +
            "-fx-border-radius: 18px;"
        );

        Text aiTitle = new Text(
            "🤖 AI Personalized Diet Plan"
        );

        aiTitle.setStyle(
            "-fx-font-size: 21px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text aiDescription = new Text(
            "Let AI create a nutrition plan based on your goal, body metrics, activity level and food preferences."
        );

        aiDescription.setWrappingWidth(
            750
        );

        aiDescription.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-fill: #8a8d91;"
        );

        HBox aiBottom = new HBox();

        aiBottom.setAlignment(
            Pos.CENTER_LEFT
        );

        Text aiInfo = new Text(
            "Personalized • Goal Based • Nutrition Focused"
        );

        aiInfo.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        Region aiSpacer = new Region();

        HBox.setHgrow(
            aiSpacer,
            Priority.ALWAYS
        );

        Button generateButton = new Button(
            "✨ Generate Diet Plan with AI"
        );

        addHoverEffect(
            generateButton,

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 12px 22px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #9cffbb;" +
            "-fx-text-fill: #000000;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 12px 22px;" +
            "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.35), 20, 0.3, 0, 3);" +
            "-fx-cursor: hand;"
        );

        /*
         * IMPORTANT:
         *
         * इथे नंतर तुझा AI API call करायचा आहे.
         *
         * Example:
         *
         * generateButton.setOnAction(e -> {
         *
         *     DietAIController.generateDietPlan();
         *
         * });
         *
         */

        generateButton.setOnAction(e -> {

            System.out.println(
                "AI Diet Plan Generation Started..."
            );

            // इथे AI Controller call कर
            //
            // DietController.generateDietPlan();

        });

        aiBottom.getChildren().addAll(
            aiInfo,
            aiSpacer,
            generateButton
        );

        aiCard.getChildren().addAll(
            aiTitle,
            aiDescription,
            aiBottom
        );

        // =====================================================
        // DAILY NUTRITION
        // =====================================================

        Text nutritionTitle = new Text(
            "Daily Nutrition"
        );

        nutritionTitle.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        HBox nutritionCards =
            new HBox(15);

        nutritionCards.setAlignment(
            Pos.CENTER_LEFT
        );

        VBox caloriesCard =
            createNutritionCard(
                "🔥",
                "2,918",
                "Calories",
                "kcal / day"
            );

        VBox proteinCard =
            createNutritionCard(
                "💪",
                "150g",
                "Protein",
                "daily target"
            );

        VBox carbsCard =
            createNutritionCard(
                "⚡",
                "360g",
                "Carbs",
                "daily target"
            );

        VBox fatsCard =
            createNutritionCard(
                "🥑",
                "85g",
                "Healthy Fats",
                "daily target"
            );

        nutritionCards.getChildren().addAll(
            caloriesCard,
            proteinCard,
            carbsCard,
            fatsCard
        );

        // =====================================================
        // MEAL PLAN
        // =====================================================

        HBox mealHeader = new HBox();

        mealHeader.setAlignment(
            Pos.CENTER_LEFT
        );

        Text mealTitle = new Text(
            "Today's Meal Plan"
        );

        mealTitle.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Region mealSpacer = new Region();

        HBox.setHgrow(
            mealSpacer,
            Priority.ALWAYS
        );

        Text mealInfo = new Text(
            "AI Generated"
        );

        mealInfo.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #62ff96;"
        );

        mealHeader.getChildren().addAll(
            mealTitle,
            mealSpacer,
            mealInfo
        );

        // =====================================================
        // MEALS
        // =====================================================

        VBox mealContainer =
            new VBox(12);

        HBox breakfast =
            createMealCard(
                "01",
                "Breakfast",
                "Oats • Banana • Peanut Butter • Milk",
                "650 kcal",
                "32g Protein"
            );

        HBox lunch =
            createMealCard(
                "02",
                "Lunch",
                "Brown Rice • Paneer • Dal • Salad",
                "780 kcal",
                "45g Protein"
            );

        HBox snack =
            createMealCard(
                "03",
                "Evening Snack",
                "Greek Yogurt • Fruits • Almonds",
                "420 kcal",
                "25g Protein"
            );

        HBox dinner =
            createMealCard(
                "04",
                "Dinner",
                "Roti • Paneer • Vegetables • Curd",
                "680 kcal",
                "40g Protein"
            );

        mealContainer.getChildren().addAll(
            breakfast,
            lunch,
            snack,
            dinner
        );

        // =====================================================
        // WATER + SUMMARY
        // =====================================================

        HBox bottomSection =
            new HBox(20);

        VBox waterCard =
            createWaterCard();

        VBox summaryCard =
            createSummaryCard();

        HBox.setHgrow(
            waterCard,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            summaryCard,
            Priority.ALWAYS
        );

        bottomSection.getChildren().addAll(
            waterCard,
            summaryCard
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        mainContent.getChildren().addAll(
            header,
            aiCard,
            nutritionTitle,
            nutritionCards,
            mealHeader,
            mealContainer,
            bottomSection
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
            new ScrollPane(
                mainContent
            );

        scrollPane.setFitToWidth(
            true
        );

        scrollPane.setHbarPolicy(
            ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setStyle(
            "-fx-background: #080C14;" +
            "-fx-background-color: #080C14;" +
            "-fx-border-color: transparent;"
        );

        root.setCenter(
            scrollPane
        );

        // =====================================================
        // SCENE
        // =====================================================

        dietPlannerScene =
            new Scene(
                root,
                1200,
                800
            );

        return dietPlannerScene;
    }

    // =========================================================
    // NUTRITION CARD
    // =========================================================

    private VBox createNutritionCard(
        String icon,
        String value,
        String title,
        String subtitle
    ) {

        VBox card =
            new VBox(8);

        card.setPadding(
            new Insets(20)
        );

        card.setPrefWidth(
            250
        );

        card.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 16px;"
        );

        Text iconText =
            new Text(icon);

        iconText.setStyle(
            "-fx-font-size: 20px;"
        );

        Text valueText =
            new Text(value);

        valueText.setStyle(
            "-fx-font-size: 25px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text titleText =
            new Text(title);

        titleText.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        Text subText =
            new Text(subtitle);

        subText.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #8a8d91;"
        );

        card.getChildren().addAll(
            iconText,
            valueText,
            titleText,
            subText
        );

        addHoverEffect(
            card,

            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 16px;",

            "-fx-background-color: #0b1825;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #62ff96;" +
            "-fx-border-radius: 16px;" +
            "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.15), 20, 0.2, 0, 4);"
        );

        return card;
    }

    // =========================================================
    // MEAL CARD
    // =========================================================

    private HBox createMealCard(
        String number,
        String meal,
        String foods,
        String calories,
        String protein
    ) {

        HBox card =
            new HBox(18);

        card.setAlignment(
            Pos.CENTER_LEFT
        );

        card.setPadding(
            new Insets(18, 22, 18, 22)
        );

        card.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 16px;"
        );

        // -----------------------------------------------------
        // NUMBER
        // -----------------------------------------------------

        Text numberText =
            new Text(number);

        numberText.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        // -----------------------------------------------------
        // DETAILS
        // -----------------------------------------------------

        VBox details =
            new VBox(5);

        Text mealText =
            new Text(meal);

        mealText.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text foodText =
            new Text(foods);

        foodText.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        foodText.setWrappingWidth(
            550
        );

        details.getChildren().addAll(
            mealText,
            foodText
        );

        HBox.setHgrow(
            details,
            Priority.ALWAYS
        );

        // -----------------------------------------------------
        // CALORIES
        // -----------------------------------------------------

        VBox nutrition =
            new VBox(4);

        nutrition.setAlignment(
            Pos.CENTER_RIGHT
        );

        Text calorieText =
            new Text(calories);

        calorieText.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text proteinText =
            new Text(protein);

        proteinText.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        nutrition.getChildren().addAll(
            calorieText,
            proteinText
        );

        card.getChildren().addAll(
            numberText,
            details,
            nutrition
        );

        addHoverEffect(
            card,

            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 16px;",

            "-fx-background-color: #0b1825;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #62ff96;" +
            "-fx-border-radius: 16px;"
        );

        return card;
    }

    // =========================================================
    // WATER CARD
    // =========================================================

    private VBox createWaterCard() {

        VBox card =
            new VBox(12);

        card.setPadding(
            new Insets(22)
        );

        card.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #07111d, #091522);" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        Text title =
            new Text(
                "💧 Daily Hydration"
            );

        title.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text amount =
            new Text(
                "2.8 L"
            );

        amount.setStyle(
            "-fx-font-size: 28px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        Text info =
            new Text(
                "Recommended daily water intake"
            );

        info.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        card.getChildren().addAll(
            title,
            amount,
            info
        );

        return card;
    }

    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private VBox createSummaryCard() {

        VBox card =
            new VBox(10);

        card.setPadding(
            new Insets(22)
        );

        card.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #07111d, #091a17);" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: rgba(98,255,150,0.20);" +
            "-fx-border-radius: 18px;"
        );

        Text title =
            new Text(
                "AI Nutrition Insight"
            );

        title.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text insight =
            new Text(
                "Your current plan focuses on high protein intake " +
                "to support muscle growth while maintaining a balanced " +
                "carbohydrate and healthy fat intake."
            );

        insight.setWrappingWidth(
            450
        );

        insight.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        Text recommendation =
            new Text(
                "✓ Protein target aligned with your goal"
            );

        recommendation.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        card.getChildren().addAll(
            title,
            insight,
            recommendation
        );

        return card;
    }

    // =========================================================
    // HOVER EFFECT
    // =========================================================

    private void addHoverEffect(
        Node node,
        String normalStyle,
        String hoverStyle
    ) {

        node.setStyle(
            normalStyle
        );

        node.setOnMouseEntered(e -> {

            node.setStyle(
                hoverStyle
            );

            node.setScaleX(
                1.02
            );

            node.setScaleY(
                1.02
            );
        });

        node.setOnMouseExited(e -> {

            node.setStyle(
                normalStyle
            );

            node.setScaleX(
                1.0
            );

            node.setScaleY(
                1.0
            );
        });
    }
}
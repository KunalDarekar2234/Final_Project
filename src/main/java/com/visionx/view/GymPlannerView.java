
package com.visionx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GymPlannerView {

    private Scene gymPlannerScene;

    private final String GREEN = "#62ff96";
    private final String DARK = "#080C14";
    private final String CARD = "#07111d";
    private final String TEXT = "#ffffff";
    private final String SECONDARY = "#8a8d91";

    // =========================================================
    // AI GENERATED PLAN DATA
    // =========================================================

    private final List<WorkoutDay> workoutPlan = new ArrayList<>();
    private HBox weekContainer;

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getGymPlannerScene(Runnable callBackAction) {

        BorderPane root = new BorderPane();

        root.setStyle(
            "-fx-background-color: #080C14;"
        );

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
            "Gym Planner"
        );

        title.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text subtitle = new Text(
            "Generate a personalized workout plan using AI."
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

        Button backButton = new Button(
            "← Dashboard"
        );

        addHoverEffect(
            backButton,

            "-fx-background-color: #151b24;" +
            "-fx-text-fill: white;" +
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
        // AI GENERATOR CARD
        // =====================================================

        VBox aiCard = createAIGeneratorCard(
            mainContent
        );

        // =====================================================
        // WEEK HEADER
        // =====================================================

        HBox weekHeader = new HBox(10);

        weekHeader.setAlignment(
            Pos.CENTER_LEFT
        );

        Text weekTitle = new Text(
            "AI Generated Weekly Plan"
        );

        weekTitle.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Region weekSpacer = new Region();

        HBox.setHgrow(
            weekSpacer,
            Priority.ALWAYS
        );

        Text weekInfo = new Text(
            "7 Day Workout Schedule"
        );

        weekInfo.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #62ff96;"
        );

        weekHeader.getChildren().addAll(
            weekTitle,
            weekSpacer,
            weekInfo
        );

        // =====================================================
        // WEEK CONTAINER
        // =====================================================

        weekContainer = new HBox(15);

        weekContainer.setAlignment(
            Pos.TOP_LEFT
        );

        // Initially show message instead of hardcoded plan

        VBox emptyPlan = createEmptyPlanMessage();

        weekContainer.getChildren().add(
            emptyPlan
        );

        ScrollPane weekScroll = new ScrollPane(weekContainer);
        weekScroll.setFitToHeight(true);
        weekScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        weekScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        weekScroll.setStyle(
            "-fx-background: transparent; " +
            "-fx-background-color: transparent; " +
            "-fx-border-color: transparent;"
        );

        // =====================================================
        // PROGRESS SECTION
        // =====================================================

        HBox progressSection = new HBox(20);

        VBox progressCard =
            createProgressCard();

        VBox targetCard =
            createTargetCard();

        HBox.setHgrow(
            progressCard,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            targetCard,
            Priority.ALWAYS
        );

        progressSection.getChildren().addAll(
            progressCard,
            targetCard
        );

        // =====================================================
        // TODAY WORKOUT
        // =====================================================

        VBox todaySection = new VBox(15);

        Text todayTitle = new Text(
            "Today's Workout"
        );

        todayTitle.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        HBox todayCard =
            createTodayWorkout();

        todaySection.getChildren().addAll(
            todayTitle,
            todayCard
        );

        // =====================================================
        // ADD CUSTOM WORKOUT
        // =====================================================

        HBox addSection =
            new HBox();

        addSection.setAlignment(
            Pos.CENTER_RIGHT
        );

        Button addWorkout =
            new Button(
                "+ Add Custom Workout"
            );

        addHoverEffect(
            addWorkout,

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 20px;" +
            "-fx-padding: 11px 20px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #9cffbb;" +
            "-fx-text-fill: black;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 20px;" +
            "-fx-padding: 11px 20px;" +
            "-fx-cursor: hand;"
        );

        addWorkout.setOnAction(e -> {

            showCustomWorkoutDialog();

        });

        addSection.getChildren().add(
            addWorkout
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        mainContent.getChildren().addAll(
            header,
            aiCard,
            weekHeader,
            weekScroll,
            progressSection,
            todaySection,
            addSection
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
            new ScrollPane(
                mainContent
            );

        scrollPane.setFitToWidth(true);

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

        gymPlannerScene =
            new Scene(
                root,
                1200,
                800
            );

        return gymPlannerScene;
    }

    // =========================================================
    // AI GENERATOR CARD
    // =========================================================

    private VBox createAIGeneratorCard(
        VBox mainContent
    ) {

        VBox card =
            new VBox(18);

        card.setPadding(
            new Insets(22)
        );

        card.setStyle(
            "-fx-background-color: linear-gradient(to right, #07111d, #091a17);" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: rgba(98,255,150,0.25);" +
            "-fx-border-radius: 18px;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        HBox titleRow =
            new HBox(12);

        titleRow.setAlignment(
            Pos.CENTER_LEFT
        );

        Circle aiIcon =
            new Circle(
                23,
                Color.web("#10281b")
            );

        Text aiSymbol =
            new Text("AI");

        aiSymbol.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        StackPane iconBox =
            new StackPane(
                aiIcon,
                aiSymbol
            );

        VBox heading =
            new VBox(3);

        Text title =
            new Text(
                "AI Workout Generator"
            );

        title.setStyle(
            "-fx-font-size: 19px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text description =
            new Text(
                "Let AI create a workout plan based on your fitness profile."
            );

        description.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        heading.getChildren().addAll(
            title,
            description
        );

        titleRow.getChildren().addAll(
            iconBox,
            heading
        );

        // =====================================================
        // INPUTS
        // =====================================================

        HBox inputs =
            new HBox(12);

        ComboBox<String> goal =
            createComboBox(
                "Fitness Goal"
            );

        goal.getItems().addAll(
            "Muscle Gain",
            "Fat Loss",
            "Strength",
            "Endurance",
            "General Fitness"
        );

        goal.setValue(
            "Muscle Gain"
        );

        ComboBox<String> level =
            createComboBox(
                "Experience"
            );

        level.getItems().addAll(
            "Beginner",
            "Intermediate",
            "Advanced"
        );

        level.setValue(
            "Intermediate"
        );

        ComboBox<String> days =
            createComboBox(
                "Training Days"
            );

        days.getItems().addAll(
            "3 Days",
            "4 Days",
            "5 Days",
            "6 Days",
            "7 Days"
        );

        days.setValue(
            "5 Days"
        );

        ComboBox<String> equipment =
            createComboBox(
                "Equipment"
            );

        equipment.getItems().addAll(
            "Full Gym",
            "Dumbbells Only",
            "Home Workout",
            "Bodyweight"
        );

        equipment.setValue(
            "Full Gym"
        );

        HBox.setHgrow(
            goal,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            level,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            days,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            equipment,
            Priority.ALWAYS
        );

        inputs.getChildren().addAll(
            goal,
            level,
            days,
            equipment
        );

        // =====================================================
        // GENERATE BUTTON
        // =====================================================

        HBox buttonRow =
            new HBox();

        buttonRow.setAlignment(
            Pos.CENTER_RIGHT
        );

        Button generateButton =
            new Button(
                "✨ Generate AI Workout Plan"
            );

        addHoverEffect(
            generateButton,

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 12px 22px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #9cffbb;" +
            "-fx-text-fill: black;" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 12px 22px;" +
            "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.4), 20, 0.3, 0, 3);" +
            "-fx-cursor: hand;"
        );

        generateButton.setOnAction(e -> {

            generateAIWorkoutPlan(
                goal.getValue(),
                level.getValue(),
                days.getValue(),
                equipment.getValue()
            );

        });

        buttonRow.getChildren().add(
            generateButton
        );

        card.getChildren().addAll(
            titleRow,
            inputs,
            buttonRow
        );

        return card;
    }

    // =========================================================
    // COMBO BOX
    // =========================================================

    private ComboBox<String> createComboBox(
        String prompt
    ) {

        ComboBox<String> combo =
            new ComboBox<>();

        combo.setPromptText(
            prompt
        );

        combo.setStyle(
            "-fx-background-color: #111a24;" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 10px;" +
            "-fx-border-color: #293642;" +
            "-fx-border-radius: 10px;"
        );

        combo.setMaxWidth(
            Double.MAX_VALUE
        );

        return combo;
    }

    // =========================================================
    // AI GENERATE METHOD
    // =========================================================

    private void generateAIWorkoutPlan(
        String goal,
        String level,
        String days,
        String equipment
    ) {

        System.out.println(
            "Generating AI Workout Plan..."
        );

        System.out.println(
            "Goal: " + goal
        );

        System.out.println(
            "Level: " + level
        );

        System.out.println(
            "Days: " + days
        );

        System.out.println(
            "Equipment: " + equipment
        );

        /*
         * =====================================================
         * IMPORTANT
         * =====================================================
         *
         * इथे तुझा Gemini / OpenAI API call करायचा आहे.
         *
         * Example:
         *
         * String prompt =
         *     "Create a personalized workout plan..."
         *
         * String aiResponse =
         *     AIService.generateWorkout(prompt);
         *
         * मग aiResponse JSON मध्ये parse करून
         * workoutPlan मध्ये data add करायचा.
         *
         * =====================================================
         */

        workoutPlan.clear();

        // -----------------------------------------------------
        // DEMO AI RESPONSE
        // -----------------------------------------------------

        workoutPlan.add(
            new WorkoutDay(
                "MON",
                "Push Day",
                "Chest • Shoulders • Triceps",
                "Bench Press",
                "4 Sets × 8 Reps",
                "60 min"
            )
        );

        workoutPlan.add(
            new WorkoutDay(
                "TUE",
                "Pull Day",
                "Back • Biceps",
                "Pull Ups",
                "4 Sets × 10 Reps",
                "55 min"
            )
        );

        workoutPlan.add(
            new WorkoutDay(
                "WED",
                "Leg Day",
                "Quads • Hamstrings • Calves",
                "Squats",
                "4 Sets × 8 Reps",
                "65 min"
            )
        );

        workoutPlan.add(
            new WorkoutDay(
                "THU",
                "Active Recovery",
                "Mobility • Stretching",
                "Light Cardio",
                "30 min",
                "30 min"
            )
        );

        workoutPlan.add(
            new WorkoutDay(
                "FRI",
                "Upper Body",
                "Chest • Back • Arms",
                "Incline Press",
                "3 Sets × 10 Reps",
                "60 min"
            )
        );

        workoutPlan.add(
            new WorkoutDay(
                "SAT",
                "Lower Body",
                "Legs • Glutes • Core",
                "Romanian Deadlift",
                "4 Sets × 10 Reps",
                "60 min"
            )
        );

        workoutPlan.add(
            new WorkoutDay(
                "SUN",
                "Rest Day",
                "Recovery • Sleep",
                "Full Recovery",
                "Rest",
                "0 min"
            )
        );

        showGeneratedPlan();

    }

    // =========================================================
    // SHOW GENERATED PLAN
    // =========================================================

    private void showGeneratedPlan() {

        System.out.println(
            "AI Workout Plan Generated!"
        );

        if (weekContainer != null) {
            weekContainer.getChildren().clear();

            for (WorkoutDay dayData : workoutPlan) {
                VBox card = createDayCard(dayData);
                weekContainer.getChildren().add(card);
            }
        }

    }

    // =========================================================
    // EMPTY PLAN MESSAGE
    // =========================================================

    private VBox createEmptyPlanMessage() {

        VBox box =
            new VBox(8);

        box.setAlignment(
            Pos.CENTER
        );

        box.setPadding(
            new Insets(35)
        );

        box.setMaxWidth(
            Double.MAX_VALUE
        );

        box.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        Text icon =
            new Text("✨");

        icon.setStyle(
            "-fx-font-size: 30px;"
        );

        Text title =
            new Text(
                "No Workout Plan Yet"
            );

        title.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text message =
            new Text(
                "Select your preferences above and let AI create your personalized plan."
            );

        message.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        box.getChildren().addAll(
            icon,
            title,
            message
        );

        return box;
    }

    // =========================================================
    // DAY CARD
    // =========================================================

    private VBox createDayCard(
        WorkoutDay data
    ) {

        VBox card =
            new VBox(10);

        card.setPrefWidth(
            190
        );

        card.setMinWidth(
            190
        );

        card.setPadding(
            new Insets(15)
        );

        card.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 16px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 16px;"
        );

        HBox dayRow =
            new HBox();

        dayRow.setAlignment(
            Pos.CENTER_LEFT
        );

        Text dayText =
            new Text(
                data.day
            );

        dayText.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        Region spacer =
            new Region();

        HBox.setHgrow(
            spacer,
            Priority.ALWAYS
        );

        Circle status =
            new Circle(
                5,
                Color.web("#293642")
            );

        dayRow.getChildren().addAll(
            dayText,
            spacer,
            status
        );

        Text workoutText =
            new Text(
                data.workout
            );

        workoutText.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        workoutText.setWrappingWidth(
            120
        );

        Text muscleText =
            new Text(
                data.muscles
            );

        muscleText.setStyle(
            "-fx-font-size: 9px;" +
            "-fx-fill: #8a8d91;"
        );

        muscleText.setWrappingWidth(
            120
        );

        Text exerciseText =
            new Text(
                data.exercise
            );

        exerciseText.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #b8c1ca;"
        );

        Text repsText =
            new Text(
                data.reps
            );

        repsText.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        Text durationText =
            new Text(
                "⏱ " + data.duration
            );

        durationText.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #8a8d91;"
        );

        // -----------------------------------------------------
        // VIDEO RECOMMENDATION & RISK TOGGLE
        // -----------------------------------------------------

        Button watchVideoBtn = new Button("▶ Watch Video");
        
        addHoverEffect(
            watchVideoBtn,

            "-fx-background-color: #151b24;" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 8px;" +
            "-fx-border-color: #293642;" +
            "-fx-border-radius: 8px;" +
            "-fx-padding: 6px 10px;" +
            "-fx-font-size: 10px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-background-radius: 8px;" +
            "-fx-border-color: #62ff96;" +
            "-fx-border-radius: 8px;" +
            "-fx-padding: 6px 10px;" +
            "-fx-font-size: 10px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        watchVideoBtn.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(watchVideoBtn, Priority.ALWAYS);
        
        watchVideoBtn.setOnAction(e -> {
            System.out.println("Opening video tutorial for: " + data.exercise);
        });

        Button riskBtn = new Button("🔄");
        
        addHoverEffect(
            riskBtn,
            "-fx-background-color: #151b24; -fx-text-fill: #8a8d91; -fx-background-radius: 8px; -fx-border-color: #293642; -fx-border-radius: 8px; -fx-padding: 6px 10px; -fx-cursor: hand;",
            "-fx-background-color: #293642; -fx-text-fill: white; -fx-background-radius: 8px; -fx-border-color: #62ff96; -fx-border-radius: 8px; -fx-padding: 6px 10px; -fx-cursor: hand;"
        );

        riskBtn.setOnAction(e -> {
            showInjuryPredictionDialog(data.exercise);
        });

        HBox actionRow = new HBox(8);
        actionRow.getChildren().addAll(watchVideoBtn, riskBtn);

        // -----------------------------------------------------

        card.getChildren().addAll(
            dayRow,
            workoutText,
            muscleText,
            exerciseText,
            repsText,
            durationText,
            actionRow
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
    // AI INJURY PREDICTION DIALOG
    // =========================================================

    private void showInjuryPredictionDialog(String exercise) {
        javafx.stage.Stage dialog = new javafx.stage.Stage();
        dialog.initStyle(javafx.stage.StageStyle.TRANSPARENT);
        dialog.initModality(javafx.stage.Modality.APPLICATION_MODAL);

        VBox content = new VBox(15);
        content.setPadding(new Insets(30));
        content.setAlignment(Pos.CENTER);
        content.setStyle(
            "-fx-background-color: #0b1118;" +
            "-fx-background-radius: 20px;" +
            "-fx-border-color: #26323d;" +
            "-fx-border-radius: 20px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 40, 0.5, 0, 10);"
        );

        Text title = new Text("🤖 AI Injury Analysis");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: white;");

        Text subtitle = new Text("Analyzing: " + exercise);
        subtitle.setStyle("-fx-font-size: 14px; -fx-fill: #8a8d91;");

        /*
         * =====================================================
         * AI RISK PREDICTION INTEGRATION
         * =====================================================
         * इथे तुझा AI API call करायचा आहे.
         *
         * Example:
         * String prompt = "Analyze injury risk for " + exercise;
         * String aiRisk = AIService.predictRisk(prompt);
         * result.setText(aiRisk);
         * =====================================================
         */

        Text result = new Text(
            "Fetching deep insights from AI...\n\n" +
            "Please integrate your API here to show joint strain, muscle load, and form correction tips."
        );
        result.setStyle("-fx-font-size: 13px; -fx-fill: #62ff96;");
        result.setWrappingWidth(350);

        Button closeBtn = new Button("Close");
        closeBtn.setStyle(
            "-fx-background-color: #293642;" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 8px 20px;" +
            "-fx-cursor: hand;"
        );
        closeBtn.setOnAction(e -> dialog.close());

        content.getChildren().addAll(title, subtitle, result, closeBtn);

        Scene scene = new Scene(content);
        scene.setFill(Color.TRANSPARENT);
        dialog.setScene(scene);
        dialog.show();
    }

    // =========================================================
    // PROGRESS CARD
    // =========================================================

    private VBox createProgressCard() {

        VBox card =
            new VBox(15);

        card.setPadding(
            new Insets(22)
        );

        card.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        Text title =
            new Text(
                "Weekly Progress"
            );

        title.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        HBox progressRow =
            new HBox(15);

        progressRow.setAlignment(
            Pos.CENTER_LEFT
        );

        Circle progressCircle =
            new Circle(
                40,
                Color.TRANSPARENT
            );

        progressCircle.setStroke(
            Color.web("#62ff96")
        );

        progressCircle.setStrokeWidth(
            7
        );

        VBox progressValue =
            new VBox(2);

        Text percentage =
            new Text(
                "72%"
            );

        percentage.setStyle(
            "-fx-font-size: 28px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text sub =
            new Text(
                "Workout completion"
            );

        sub.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        progressValue.getChildren().addAll(
            percentage,
            sub
        );

        progressRow.getChildren().addAll(
            progressCircle,
            progressValue
        );

        Text detail =
            new Text(
                "5 of 7 planned sessions completed this week."
            );

        detail.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        card.getChildren().addAll(
            title,
            progressRow,
            detail
        );

        return card;
    }

    // =========================================================
    // TARGET CARD
    // =========================================================

    private VBox createTargetCard() {

        VBox card =
            new VBox(15);

        card.setPadding(
            new Insets(22)
        );

        card.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: rgba(98,255,150,0.20);" +
            "-fx-border-radius: 18px;"
        );

        Text title =
            new Text(
                "Training Target"
            );

        title.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text target =
            new Text(
                "AI Personalized"
            );

        target.setStyle(
            "-fx-font-size: 25px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #62ff96;"
        );

        Text info =
            new Text(
                "Plan generated according to your fitness profile."
            );

        info.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        HBox stats =
            new HBox(30);

        stats.getChildren().addAll(
            createSmallStat(
                "AI",
                "Generated"
            ),

            createSmallStat(
                "7",
                "Days"
            ),

            createSmallStat(
                "5",
                "Sessions"
            )
        );

        card.getChildren().addAll(
            title,
            target,
            info,
            stats
        );

        return card;
    }

    // =========================================================
    // SMALL STAT
    // =========================================================

    private VBox createSmallStat(
        String value,
        String label
    ) {

        VBox box =
            new VBox(3);

        Text valueText =
            new Text(value);

        valueText.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text labelText =
            new Text(label);

        labelText.setStyle(
            "-fx-font-size: 9px;" +
            "-fx-fill: #8a8d91;"
        );

        box.getChildren().addAll(
            valueText,
            labelText
        );

        return box;
    }

    // =========================================================
    // TODAY WORKOUT
    // =========================================================

    private HBox createTodayWorkout() {

        HBox card =
            new HBox(20);

        card.setAlignment(
            Pos.CENTER_LEFT
        );

        card.setPadding(
            new Insets(20)
        );

        card.setStyle(
            "-fx-background-color: linear-gradient(to right, #07111d, #091a17);" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: rgba(98,255,150,0.20);" +
            "-fx-border-radius: 18px;"
        );

        Circle icon =
            new Circle(
                30,
                Color.web("#10281b")
            );

        VBox details =
            new VBox(6);

        Text title =
            new Text(
                "Generate your plan first"
            );

        title.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text exercises =
            new Text(
                "Your AI-generated today's workout will appear here."
            );

        exercises.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        Text time =
            new Text(
                "✨ Personalized by AI"
            );

        time.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        details.getChildren().addAll(
            title,
            exercises,
            time
        );

        HBox.setHgrow(
            details,
            Priority.ALWAYS
        );

        Button startButton =
            new Button(
                "Start Workout"
            );

        addHoverEffect(
            startButton,

            "-fx-background-color: #151b24;" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-border-color: #293642;" +
            "-fx-border-radius: 10px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        card.getChildren().addAll(
            icon,
            details,
            startButton
        );

        return card;
    }

    // =========================================================
    // CUSTOM WORKOUT
    // =========================================================

    private void showCustomWorkoutDialog() {

        Dialog<ButtonType> dialog =
            new Dialog<>();

        dialog.setTitle(
            "Add Custom Workout"
        );

        VBox box =
            new VBox(12);

        box.setPadding(
            new Insets(20)
        );

        TextField workout =
            new TextField();

        workout.setPromptText(
            "Workout name"
        );

        TextField exercise =
            new TextField();

        exercise.setPromptText(
            "Exercise"
        );

        TextField duration =
            new TextField();

        duration.setPromptText(
            "Duration"
        );

        box.getChildren().addAll(
            workout,
            exercise,
            duration
        );

        dialog.getDialogPane()
            .setContent(box);

        dialog.getDialogPane()
            .getButtonTypes()
            .addAll(
                ButtonType.OK,
                ButtonType.CANCEL
            );

        dialog.showAndWait();
    }

    // =========================================================
    // HOVER
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

    // =========================================================
    // WORKOUT MODEL
    // =========================================================

    private static class WorkoutDay {

        String day;
        String workout;
        String muscles;
        String exercise;
        String reps;
        String duration;

        WorkoutDay(
            String day,
            String workout,
            String muscles,
            String exercise,
            String reps,
            String duration
        ) {

            this.day = day;
            this.workout = workout;
            this.muscles = muscles;
            this.exercise = exercise;
            this.reps = reps;
            this.duration = duration;
        }
    }
}



package com.visionx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class AccountSettingsView {

    private Scene accountScene;

    private final String GREEN = "#62ff96";
    private final String DARK = "#080C14";
    private final String CARD = "#07111d";
    private final String TEXT = "#ffffff";
    private final String SECONDARY = "#8a8d91";

    // =========================================================
    // GET ACCOUNT SETTINGS SCENE
    // =========================================================

    public Scene getAccountSettingsScene(Runnable callBackAction) {

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
                "Account Settings"
        );

        title.setStyle(
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text subtitle = new Text(
                "Manage your profile, preferences and account security."
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
        // PROFILE CARD
        // =====================================================

        VBox profileCard = new VBox(15);

        profileCard.setAlignment(
                Pos.CENTER
        );

        profileCard.setPadding(
                new Insets(20)
        );
        
        profileCard.setMinSize(
                280,
                280
        );

        profileCard.setMaxSize(
                280,
                280
        );

        profileCard.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 140px;" +
                "-fx-border-color: #294237;" +
                "-fx-border-radius: 140px;" +
                "-fx-effect: dropshadow(three-pass-box, #62ff961a, 30, 0, 0, 10);"
        );

        // -----------------------------------------------------
        // PROFILE ICON
        // -----------------------------------------------------

        Circle profileCircle = new Circle(
                40,
                Color.web("#10281b")
        );

        Text profileIcon = new Text(
                "👤"
        );

        profileIcon.setStyle(
                "-fx-font-size: 32px;"
        );

        StackPane profileImage = new StackPane();

        profileImage.setAlignment(
                Pos.CENTER
        );

        profileImage.setMinSize(
                80,
                80
        );

        profileImage.setMaxSize(
                80,
                80
        );

        profileImage.getChildren().addAll(
                profileCircle,
                profileIcon
        );

        // -----------------------------------------------------
        // PROFILE DETAILS
        // -----------------------------------------------------

        VBox profileDetails = new VBox(6);
        
        profileDetails.setAlignment(
                Pos.CENTER
        );

        Text profileName = new Text(
                "Nawale Pradip"
        );

        profileName.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text profileEmail = new Text(
                "pradip@example.com"
        );

        profileEmail.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        Text member = new Text(
                "FitVerse Member • Active"
        );

        member.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #62ff96;"
        );

        profileDetails.getChildren().addAll(
                profileName,
                profileEmail,
                member
        );

        Button changePhoto = new Button(
                "Change Photo"
        );

        addHoverEffect(
                changePhoto,

                "-fx-background-color: #151b24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 20px;" +
                "-fx-padding: 6px 12px;" +
                "-fx-font-size: 11px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-color: #62ff96;" +
                "-fx-border-radius: 20px;" +
                "-fx-padding: 6px 12px;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        changePhoto.setOnAction(e -> {

            System.out.println(
                    "Change profile photo clicked"
            );

        });

        profileCard.getChildren().addAll(
                profileImage,
                profileDetails,
                changePhoto
        );

        // =====================================================
        // PERSONAL INFORMATION
        // =====================================================

        Text personalTitle = new Text(
                "Personal Information"
        );

        personalTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text personalSubtitle = new Text(
                "Update your basic profile information."
        );

        personalSubtitle.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        VBox personalHeading = new VBox(4);

        personalHeading.getChildren().addAll(
                personalTitle,
                personalSubtitle
        );

        // =====================================================
        // PERSONAL CARD
        // =====================================================

        VBox personalCard = new VBox(18);

        personalCard.setPadding(
                new Insets(22)
        );

        personalCard.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 18px;"
        );

        GridPane personalGrid = new GridPane();

        personalGrid.setHgap(20);
        personalGrid.setVgap(15);

        // FIRST NAME

        VBox firstNameBox = createFieldBox(
                "First Name",
                "Nawale"
        );

        TextField firstName =
                (TextField) firstNameBox
                        .getChildren()
                        .get(1);

        // LAST NAME

        VBox lastNameBox = createFieldBox(
                "Last Name",
                "Pradip"
        );

        TextField lastName =
                (TextField) lastNameBox
                        .getChildren()
                        .get(1);

        // EMAIL

        VBox emailBox = createFieldBox(
                "Email Address",
                "pradip@example.com"
        );

        TextField emailField =
                (TextField) emailBox
                        .getChildren()
                        .get(1);

        // PHONE

        VBox phoneBox = createFieldBox(
                "Phone Number",
                "+91 98765 43210"
        );

        TextField phoneField =
                (TextField) phoneBox
                        .getChildren()
                        .get(1);

        personalGrid.add(
                firstNameBox,
                0,
                0
        );

        personalGrid.add(
                lastNameBox,
                1,
                0
        );

        personalGrid.add(
                emailBox,
                0,
                1
        );

        personalGrid.add(
                phoneBox,
                1,
                1
        );

        personalCard.getChildren().add(
                personalGrid
        );

        // =====================================================
        // FITNESS PROFILE
        // =====================================================

        Text fitnessTitle = new Text(
                "Fitness Profile"
        );

        fitnessTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text fitnessSubtitle = new Text(
                "These details help FitVerse personalize your plans."
        );

        fitnessSubtitle.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        VBox fitnessHeading = new VBox(4);

        fitnessHeading.getChildren().addAll(
                fitnessTitle,
                fitnessSubtitle
        );

        // =====================================================
        // FITNESS CARD
        // =====================================================

        VBox fitnessCard = new VBox(18);

        fitnessCard.setPadding(
                new Insets(22)
        );

        fitnessCard.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 18px;"
        );

        GridPane fitnessGrid = new GridPane();

        fitnessGrid.setHgap(20);
        fitnessGrid.setVgap(15);

        // HEIGHT

        VBox heightBox = createFieldBox(
                "Height (cm)",
                "175"
        );

        // WEIGHT

        VBox weightBox = createFieldBox(
                "Weight (kg)",
                "70"
        );

        // AGE

        VBox ageBox = createFieldBox(
                "Age",
                "22"
        );

        // TARGET WEIGHT

        VBox targetWeightBox = createFieldBox(
                "Target Weight (kg)",
                "75"
        );

        // FITNESS GOAL

        VBox goalBox = new VBox(7);

        Text goalLabel = new Text(
                "Fitness Goal"
        );

        goalLabel.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        ComboBox<String> goalBoxCombo =
                new ComboBox<>();

        goalBoxCombo.getItems().addAll(
                "Muscle Gain",
                "Weight Loss",
                "Fat Loss",
                "Strength",
                "Endurance",
                "General Fitness"
        );

        goalBoxCombo.setValue(
                "Muscle Gain"
        );

        goalBoxCombo.setMaxWidth(
                Double.MAX_VALUE
        );

        goalBoxCombo.setPrefHeight(
                40
        );

        styleComboBox(
                goalBoxCombo
        );

        goalBox.getChildren().addAll(
                goalLabel,
                goalBoxCombo
        );

        // ACTIVITY LEVEL

        VBox activityBox = new VBox(7);

        Text activityLabel = new Text(
                "Activity Level"
        );

        activityLabel.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        ComboBox<String> activityCombo =
                new ComboBox<>();

        activityCombo.getItems().addAll(
                "Beginner",
                "Intermediate",
                "Advanced",
                "Very Active"
        );

        activityCombo.setValue(
                "Intermediate"
        );

        activityCombo.setMaxWidth(
                Double.MAX_VALUE
        );

        activityCombo.setPrefHeight(
                40
        );

        styleComboBox(
                activityCombo
        );

        activityBox.getChildren().addAll(
                activityLabel,
                activityCombo
        );

        fitnessGrid.add(
                heightBox,
                0,
                0
        );

        fitnessGrid.add(
                weightBox,
                1,
                0
        );

        fitnessGrid.add(
                ageBox,
                0,
                1
        );

        fitnessGrid.add(
                targetWeightBox,
                1,
                1
        );

        fitnessGrid.add(
                goalBox,
                0,
                2
        );

        fitnessGrid.add(
                activityBox,
                1,
                2
        );

        fitnessCard.getChildren().add(
                fitnessGrid
        );

        // =====================================================
        // PREFERENCES
        // =====================================================

        Text preferenceTitle = new Text(
                "Preferences"
        );

        preferenceTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        VBox preferenceCard = new VBox(15);

        preferenceCard.setPadding(
                new Insets(22)
        );

        preferenceCard.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 18px;"
        );

        // -----------------------------------------------------
        // WORKOUT REMINDER
        // -----------------------------------------------------

        HBox workoutReminder =
                createSettingRow(
                        "Workout Reminders",
                        "Get notified when it's time to train."
                );

        // FIX: CheckBox is at index 2
        CheckBox workoutCheck =
                (CheckBox) workoutReminder
                        .getChildren()
                        .get(2);

        workoutCheck.setSelected(true);

        // -----------------------------------------------------
        // DIET REMINDER
        // -----------------------------------------------------

        HBox dietReminder =
                createSettingRow(
                        "Diet Reminders",
                        "Receive reminders for your meals."
                );

        // FIX: CheckBox is at index 2
        CheckBox dietCheck =
                (CheckBox) dietReminder
                        .getChildren()
                        .get(2);

        dietCheck.setSelected(true);

        // -----------------------------------------------------
        // AI INSIGHTS
        // -----------------------------------------------------

        HBox aiInsight =
                createSettingRow(
                        "AI Fitness Insights",
                        "Receive personalized AI recommendations."
                );

        // FIX: CheckBox is at index 2
        CheckBox aiCheck =
                (CheckBox) aiInsight
                        .getChildren()
                        .get(2);

        aiCheck.setSelected(true);

        preferenceCard.getChildren().addAll(
                workoutReminder,
                dietReminder,
                aiInsight
        );

        // =====================================================
        // SECURITY
        // =====================================================

        Text securityTitle = new Text(
                "Security"
        );

        securityTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        VBox securityCard = new VBox(15);

        securityCard.setPadding(
                new Insets(22)
        );

        securityCard.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 18px;"
        );

        // CURRENT PASSWORD

        PasswordField currentPassword =
                new PasswordField();

        currentPassword.setPromptText(
                "Current password"
        );

        stylePasswordField(
                currentPassword
        );

        // NEW PASSWORD

        PasswordField newPassword =
                new PasswordField();

        newPassword.setPromptText(
                "New password"
        );

        stylePasswordField(
                newPassword
        );

        // CONFIRM PASSWORD

        PasswordField confirmPassword =
                new PasswordField();

        confirmPassword.setPromptText(
                "Confirm new password"
        );

        stylePasswordField(
                confirmPassword
        );

        HBox passwordFields =
                new HBox(12);

        HBox.setHgrow(
                currentPassword,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                newPassword,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                confirmPassword,
                Priority.ALWAYS
        );

        passwordFields.getChildren().addAll(
                currentPassword,
                newPassword,
                confirmPassword
        );

        Button changePassword =
                new Button(
                        "Change Password"
                );

        addHoverEffect(
                changePassword,

                "-fx-background-color: #151b24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #293642;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px 18px;" +
                "-fx-font-weight: bold;" +
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

        changePassword.setOnAction(e -> {

            if (
                    currentPassword.getText().isEmpty()
                            ||
                    newPassword.getText().isEmpty()
                            ||
                    confirmPassword.getText().isEmpty()
            ) {

                System.out.println(
                        "Please fill all password fields."
                );

                return;
            }

            if (
                    !newPassword.getText()
                            .equals(
                                    confirmPassword.getText()
                            )
            ) {

                System.out.println(
                        "Passwords do not match."
                );

                return;
            }

            System.out.println(
                    "Password change requested."
            );

        });

        securityCard.getChildren().addAll(
                passwordFields,
                changePassword
        );

        // =====================================================
        // ACTION SECTION
        // =====================================================

        HBox actionSection =
                new HBox(12);

        actionSection.setAlignment(
                Pos.CENTER_RIGHT
        );

        // LOGOUT

        Button logoutButton =
                new Button(
                        "Logout"
                );

        addHoverEffect(
                logoutButton,

                "-fx-background-color: #151b24;" +
                "-fx-text-fill: #ff6b6b;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #493035;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 11px 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #ff6b6b;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #ff6b6b;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 11px 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        logoutButton.setOnAction(e -> {

            System.out.println(
                    "Logout clicked"
            );

        });

        // SAVE

        Button saveButton =
                new Button(
                        "Save Changes"
                );

        addHoverEffect(
                saveButton,

                "-fx-background-color: #62ff96;" +
                "-fx-text-fill: #06100a;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 11px 25px;" +
                "-fx-cursor: hand;",

                "-fx-background-color: #9cffbb;" +
                "-fx-text-fill: black;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 11px 25px;" +
                "-fx-cursor: hand;"
        );

        saveButton.setOnAction(e -> {

            System.out.println(
                    "================================"
            );

            System.out.println(
                    "Account settings saved!"
            );

            System.out.println(
                    "Name: "
                            + firstName.getText()
                            + " "
                            + lastName.getText()
            );

            System.out.println(
                    "Email: "
                            + emailField.getText()
            );

            System.out.println(
                    "Phone: "
                            + phoneField.getText()
            );

            System.out.println(
                    "Height: "
                            + ((TextField) heightBox
                            .getChildren()
                            .get(1))
                            .getText()
            );

            System.out.println(
                    "Weight: "
                            + ((TextField) weightBox
                            .getChildren()
                            .get(1))
                            .getText()
            );

            System.out.println(
                    "Goal: "
                            + goalBoxCombo.getValue()
            );

            System.out.println(
                    "Activity: "
                            + activityCombo.getValue()
            );

            System.out.println(
                    "Workout Reminder: "
                            + workoutCheck.isSelected()
            );

            System.out.println(
                    "Diet Reminder: "
                            + dietCheck.isSelected()
            );

            System.out.println(
                    "AI Insights: "
                            + aiCheck.isSelected()
            );

            System.out.println(
                    "================================"
            );

        });

        actionSection.getChildren().addAll(
                logoutButton,
                saveButton
        );

        // =====================================================
        // BMI CARD
        // =====================================================

        VBox bmiCard = new VBox(15);
        
        bmiCard.setAlignment(
                Pos.CENTER
        );
        
        bmiCard.setPadding(
                new Insets(20)
        );
        
        bmiCard.setMinSize(
                280,
                280
        );
        
        bmiCard.setMaxSize(
                280,
                280
        );
        
        bmiCard.setStyle(
                "-fx-background-color: #07111d;" +
                "-fx-background-radius: 140px;" +
                "-fx-border-color: #294237;" +
                "-fx-border-radius: 140px;" +
                "-fx-effect: dropshadow(three-pass-box, #62ff961a, 30, 0, 0, 10);"
        );

        Text bmiTitle = new Text(
                "Your BMI"
        );
        
        bmiTitle.setStyle(
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text bmiValueLabel = new Text(
                "0.0"
        );
        
        bmiValueLabel.setStyle(
                "-fx-font-size: 48px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: #62ff96;"
        );

        Text bmiCategory = new Text(
                "Unknown"
        );
        
        bmiCategory.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-fill: #8a8d91;"
        );

        bmiCard.getChildren().addAll(
                bmiTitle,
                bmiValueLabel,
                bmiCategory
        );

        TextField heightField = (TextField) heightBox.getChildren().get(1);
        TextField weightField = (TextField) weightBox.getChildren().get(1);

        Runnable updateBmi = () -> {
            try {
                double h = Double.parseDouble(heightField.getText()) / 100.0;
                double w = Double.parseDouble(weightField.getText());
                if (h > 0) {
                    double bmi = w / (h * h);
                    bmiValueLabel.setText(String.format("%.1f", bmi));
                    if (bmi < 18.5) {
                        bmiCategory.setText("Underweight");
                        bmiCategory.setStyle("-fx-font-size: 14px; -fx-fill: #ffaa00;");
                        bmiValueLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: #ffaa00;");
                    } else if (bmi < 25) {
                        bmiCategory.setText("Normal Weight");
                        bmiCategory.setStyle("-fx-font-size: 14px; -fx-fill: #62ff96;");
                        bmiValueLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: #62ff96;");
                    } else if (bmi < 30) {
                        bmiCategory.setText("Overweight");
                        bmiCategory.setStyle("-fx-font-size: 14px; -fx-fill: #ffaa00;");
                        bmiValueLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: #ffaa00;");
                    } else {
                        bmiCategory.setText("Obese");
                        bmiCategory.setStyle("-fx-font-size: 14px; -fx-fill: #ff5555;");
                        bmiValueLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: #ff5555;");
                    }
                }
            } catch (Exception ex) {
                bmiValueLabel.setText("--");
                bmiCategory.setText("Invalid Input");
                bmiCategory.setStyle("-fx-font-size: 14px; -fx-fill: #8a8d91;");
                bmiValueLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: #8a8d91;");
            }
        };

        updateBmi.run();
        
        heightField.textProperty().addListener((obs, oldV, newV) -> updateBmi.run());
        weightField.textProperty().addListener((obs, oldV, newV) -> updateBmi.run());

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        HBox profileCardWrapper = new HBox(
                80,
                profileCard,
                bmiCard
        );

        profileCardWrapper.setAlignment(
                Pos.CENTER
        );

        mainContent.getChildren().addAll(

                header,

                profileCardWrapper,

                personalHeading,
                personalCard,

                fitnessHeading,
                fitnessCard,

                preferenceTitle,
                preferenceCard,

                securityTitle,
                securityCard,

                actionSection

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

        accountScene =
                new Scene(
                        root,
                        1200,
                        800
                );

        return accountScene;
    }

    // =========================================================
    // CREATE FIELD BOX
    // =========================================================

    private VBox createFieldBox(
            String labelText,
            String value
    ) {

        VBox box =
                new VBox(7);

        Text label =
                new Text(
                        labelText
                );

        label.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-fill: #8a8d91;"
        );

        TextField field =
                new TextField(
                        value
                );

        field.setPrefHeight(
                40
        );

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #596675;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 8px 12px;"
        );

        box.getChildren().addAll(
                label,
                field
        );

        return box;
    }

    // =========================================================
    // CREATE SETTING ROW
    // =========================================================

    private HBox createSettingRow(
            String titleText,
            String description
    ) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(8, 0, 8, 0)
        );

        VBox textBox =
                new VBox(4);

        Text title =
                new Text(
                        titleText
                );

        title.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-fill: white;"
        );

        Text desc =
                new Text(
                        description
                );

        desc.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-fill: #8a8d91;"
        );

        textBox.getChildren().addAll(
                title,
                desc
        );

        // IMPORTANT
        // index 0 = textBox
        // index 1 = spacer
        // index 2 = CheckBox

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        CheckBox checkBox =
                new CheckBox();

        checkBox.setStyle(
                "-fx-text-fill: white;"
        );

        row.getChildren().addAll(
                textBox,
                spacer,
                checkBox
        );

        return row;
    }

    // =========================================================
    // PASSWORD FIELD STYLE
    // =========================================================

    private void stylePasswordField(
            PasswordField field
    ) {

        field.setPrefHeight(
                42
        );

        field.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #596675;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 8px 12px;"
        );
    }

    // =========================================================
    // COMBO BOX STYLE
    // =========================================================

    private void styleComboBox(
            ComboBox<String> combo
    ) {

        combo.setStyle(
                "-fx-background-color: #111a24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color: #172431;" +
                "-fx-border-radius: 10px;"
        );
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
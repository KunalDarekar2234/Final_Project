package com.visionx.view.gym_owner;

import java.io.File;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class TrainerMang {

    private Scene TrainerMangScene;

    // --- Color Palette (Matched to Tailwind Config) ---
    private final String BG_COLOR = "#0d150e";
    private final String SURFACE = "rgba(21, 30, 22, 0.6)";
    private final String SURFACE_BORDER = "rgba(255, 255, 255, 0.08)";
    private final String SURFACE_HOVER_BORDER = "rgba(117, 255, 158, 0.3)";
    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DIM = "rgba(117, 255, 158, 0.2)";
    private final String TEXT_MAIN = "#dbe5d9";
    private final String TEXT_MUTED = "#bacbb9";
    private final String ERROR = "#ffb4ab";

    private final DropShadow glassShadow =
            new DropShadow(30, 0, 10, Color.color(0, 0, 0, 0.4));

    private final DropShadow cardHoverShadow =
            new DropShadow(40, 0, 20, Color.color(0, 0, 0, 0.5));

    public Scene getTrainerMangScene(Runnable callBackAction) {

        cardHoverShadow.setInput(
                new DropShadow(20, Color.web(PRIMARY, 0.05))
        );

        VBox mainArea = new VBox();

        mainArea.setStyle(
                "-fx-background-color: " + BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        /*
         * StackPane is used only so that the Add Trainer popup
         * appears INSIDE the same Scene.
         */
        StackPane root = new StackPane();

        ScrollPane content = createMainContent(root);

        VBox.setVgrow(
                content,
                Priority.ALWAYS
        );

        /*
         * Duplicate page header removed.
         * The main Dashboard header/search bar will remain outside.
         */
        mainArea.getChildren().add(
                content
        );

        root.getChildren().add(mainArea);

        Scene scene =
                new Scene(root, 1160, 900);

        TrainerMangScene = scene;

        return TrainerMangScene;
    }

    // ==========================================
    // 2. MAIN CONTENT
    // ==========================================
    private ScrollPane createMainContent(StackPane root) {

        VBox content = new VBox(32);

        content.setPadding(
                new Insets(32)
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );

        // Top Row: Title & Action
        HBox topRow = new HBox();

        topRow.setAlignment(
                Pos.BOTTOM_LEFT
        );

        VBox titleBox = new VBox(4);

        Label bread =
                new Label("Management > Trainers");

        bread.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 12px;"
        );

        Label title =
                new Label("Trainer Roster");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 32px; -fx-font-weight: bold;"
        );

        Label sub =
                new Label(
                        "Manage elite fitness instructors and track their performance metrics."
                );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 16px;"
        );

        titleBox.getChildren().addAll(
                bread,
                title,
                sub
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button addBtn =
                new Button("⊕ Add New Trainer");

        String bDef =
                "-fx-background-color: " + PRIMARY +
                "; -fx-text-fill: #003918;" +
                " -fx-font-weight: bold;" +
                " -fx-font-size: 14px;" +
                " -fx-padding: 12 24;" +
                " -fx-background-radius: 50;" +
                " -fx-cursor: hand;";

        String bHov =
                "-fx-background-color: #8affab;" +
                " -fx-text-fill: #003918;" +
                " -fx-font-weight: bold;" +
                " -fx-font-size: 14px;" +
                " -fx-padding: 12 24;" +
                " -fx-background-radius: 50;" +
                " -fx-cursor: hand;" +
                " -fx-scale-x: 1.02;" +
                " -fx-scale-y: 1.02;";

        addBtn.setStyle(bDef);

        addBtn.setEffect(
                new DropShadow(
                        15,
                        Color.web(PRIMARY, 0.2)
                )
        );

        addBtn.setOnMouseEntered(
                e -> addBtn.setStyle(bHov)
        );

        addBtn.setOnMouseExited(
                e -> addBtn.setStyle(bDef)
        );

        // ==========================================
        // ADD TRAINER POPUP
        // ==========================================
        addBtn.setOnAction(
                e -> showAddTrainerPopup(root)
        );

        topRow.getChildren().addAll(
                titleBox,
                spacer,
                addBtn
        );

        // ==========================================
        // STATS GRID
        // 2 COLUMNS x 2 ROWS
        // ==========================================

        GridPane statsGrid =
                new GridPane();

        statsGrid.setHgap(16);
        statsGrid.setVgap(16);

        ColumnConstraints statsColumn1 =
                new ColumnConstraints();

        ColumnConstraints statsColumn2 =
                new ColumnConstraints();

        statsColumn1.setPercentWidth(50);
        statsColumn2.setPercentWidth(50);

        statsColumn1.setHgrow(
                Priority.ALWAYS
        );

        statsColumn2.setHgrow(
                Priority.ALWAYS
        );

        statsGrid.getColumnConstraints().addAll(
                statsColumn1,
                statsColumn2
        );

        statsGrid.add(
                createStatCard(
                        "Total Active",
                        "32",
                        "+4",
                        PRIMARY,
                        false
                ),
                0,
                0
        );

        statsGrid.add(
                createStatCard(
                        "Live Now",
                        "12",
                        "",
                        PRIMARY,
                        true
                ),
                1,
                0
        );

        statsGrid.add(
                createStatCard(
                        "Avg. Experience",
                        "6.4",
                        "Years",
                        TEXT_MUTED,
                        false
                ),
                0,
                1
        );

        statsGrid.add(
                createStatCard(
                        "Certification Rate",
                        "100%",
                        "✔",
                        PRIMARY,
                        false
                ),
                1,
                1
        );

        // ==========================================
        // TRAINERS GRID
        // 2 COLUMNS x MULTIPLE ROWS
        // ==========================================

        GridPane trainersGrid =
                new GridPane();

        trainersGrid.setHgap(24);
        trainersGrid.setVgap(24);

        ColumnConstraints trainerColumn1 =
                new ColumnConstraints();

        ColumnConstraints trainerColumn2 =
                new ColumnConstraints();

        trainerColumn1.setPercentWidth(50);
        trainerColumn2.setPercentWidth(50);

        trainerColumn1.setHgrow(
                Priority.ALWAYS
        );

        trainerColumn2.setHgrow(
                Priority.ALWAYS
        );

        trainersGrid.getColumnConstraints().addAll(
                trainerColumn1,
                trainerColumn2
        );

        trainersGrid.add(
                createTrainerCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuD2ykUdZ_EyXbnh8IUaarZ-RogYXZXVTdV_s6-AimMMvXS7VfoOQDDi7oZom3xwAggmnRXF3DhhOdslABuMZD4Ai85S5BuUbqs25AkM16eT4Kk3Rx0t9DIhqjp8qR7O_WAqqHjmVx6s-YPIaL324372hVTIHO6ioFQKha8laka_h8cTb_NB-pU3qptPy1tTBf28L1Ek7Zu14orjS8oCdkI1nMfcsM_RsMGZLz1UQ4Xj3UbPiy50J57H",
                        "Marcus Thorne",
                        "Master HIIT Specialist",
                        "8+ Years",
                        "NASM, CrossFit-L2",
                        true
                ),
                0,
                0
        );

        trainersGrid.add(
                createTrainerCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuAo9w7lCia999myzQUmfNGOwVY1bXj-6LkDtasTMN15LcN4IxvF6-s9lMIu3NpROZ-866bt2vub7GnIzLxXSzmLorA3CgKavQMpf3gw0aZz8Ilu8lc6nzOz00PgwYjYUfZE4eGuDktDU5VPXvvKT7HBtj8wzBDqAPURYWS_OuexEeCEaL8OLR8IoY_epLaF9LTrjKt0NqKHTXg-6Kw9Dita_3c5M3cxLgG6FcjV4U1mEz-WbAyXJzy8",
                        "Sasha Vane",
                        "Yoga & Mindfulness",
                        "5 Years",
                        "RYT-500, Pilates",
                        false
                ),
                1,
                0
        );

        trainersGrid.add(
                createTrainerCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuDKKJgsXsL9UNvQY6Rv8ayJxSO3zFjXV-m3T82D3WIQtJi-PX4lBJ4O9-YG47O-luZpn106jLXaA2Phx-5RNThc-iSSpYGCKJXvEm1gPxodZdWF75e4Th5wqakZr5I0MonfKiBkALRFYUg3RbV9FDoyJJErvspUAhKJYLs3wxqfZnz_75Ig1_9bw0rSxLwSh37vmWZxSKZ2YWSV8RIMfvyVCTX1x5G3VqsQ8q6VqM9f9121AX_GLmma",
                        "David Kross",
                        "Strength & Power",
                        "12 Years",
                        "CSCS, Nutritionist",
                        true
                ),
                0,
                1
        );

        trainersGrid.add(
                createTrainerCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuDyJf5gT6gCOBbwmEYvIR7svkWjS4T4fETSaG5_TijiiCe7GnzXyBtIetU5FLoE6AlNflIJ3X7cCl0gyetzess16ApkR63lBkCGzg3HbY2i5nzxQVodC-EL6e6I6PNIVjhjnA-OkHYdq3aXSUlRYDquH6MnmtMN7lMCrtryzUibhvJDU3pT8bSLR18gvWOt15MwqUF6MmZ34TBpZWE49YsHsjyH6Mt6ZpASOAiV0cw4Iim9-cfRqWAk",
                        "Elena Rojas",
                        "Boxing & Cardio",
                        "7 Years",
                        "WBA certified, ACE",
                        false
                ),
                1,
                1
        );

        // Chart Section
        VBox chartPanel =
                createChartPanel();

        content.getChildren().addAll(
                topRow,
                statsGrid,
                trainersGrid,
                chartPanel
        );

        // ==========================================
        // VERTICAL SCROLL ONLY
        // ==========================================

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        // Horizontal scrollbar completely disabled
        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        // Vertical scrollbar enabled
        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        return scroll;
    }

    // ==========================================
    // ADD TRAINER POPUP
    // SAME SCENE - CENTERED
    // ==========================================
    private void showAddTrainerPopup(StackPane root) {

        StackPane overlay = new StackPane();

        overlay.setStyle(
                "-fx-background-color: rgba(0,0,0,0.72);"
        );

        overlay.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        // ==========================================
        // POPUP CARD
        // ==========================================
        VBox popup = new VBox(20);

        popup.setPrefWidth(560);
        popup.setMaxWidth(560);
        popup.setMaxHeight(Region.USE_PREF_SIZE);

        popup.setPadding(
                new Insets(30)
        );

        popup.setStyle(
                "-fx-background-color: #101b12;" +
                "-fx-border-color: rgba(117,255,158,0.22);" +
                "-fx-border-width: 1;" +
                "-fx-background-radius: 24;" +
                "-fx-border-radius: 24;"
        );

        popup.setEffect(
                new DropShadow(
                        45,
                        0,
                        20,
                        Color.color(0, 0, 0, 0.65)
                )
        );

        // ==========================================
        // POPUP HEADER
        // ==========================================
        HBox popupHeader = new HBox();

        popupHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox headerText = new VBox(4);

        Label popupTitle =
                new Label("Add New Trainer");

        popupTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 26px;" +
                " -fx-font-weight: bold;"
        );

        Label popupSub =
                new Label(
                        "Create a new trainer profile for your fitness ecosystem."
                );

        popupSub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 12px;"
        );

        headerText.getChildren().addAll(
                popupTitle,
                popupSub
        );

        Region headerSpacer = new Region();

        HBox.setHgrow(
                headerSpacer,
                Priority.ALWAYS
        );

        Button close =
                new Button("✕");

        String closeDef =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 16px;" +
                "-fx-background-radius: 50;" +
                "-fx-cursor: hand;";

        String closeHov =
                "-fx-background-color: rgba(255,180,171,0.15);" +
                "-fx-text-fill: " + ERROR +
                "; -fx-font-size: 16px;" +
                "-fx-background-radius: 50;" +
                "-fx-cursor: hand;";

        close.setStyle(closeDef);

        close.setOnMouseEntered(
                e -> close.setStyle(closeHov)
        );

        close.setOnMouseExited(
                e -> close.setStyle(closeDef)
        );

        popupHeader.getChildren().addAll(
                headerText,
                headerSpacer,
                close
        );

        // ==========================================
        // IMAGE AREA
        // ==========================================
        HBox imageSection = new HBox(18);

        imageSection.setAlignment(
                Pos.CENTER_LEFT
        );

        StackPane imagePreview =
                new StackPane();

        imagePreview.setMinSize(120, 120);
        imagePreview.setMaxSize(120, 120);

        imagePreview.setStyle(
                "-fx-background-color: rgba(255,255,255,0.04);" +
                "-fx-border-color: rgba(117,255,158,0.18);" +
                "-fx-border-width: 1;" +
                "-fx-background-radius: 18;" +
                "-fx-border-radius: 18;"
        );

        Label imageIcon =
                new Label("📷");

        imageIcon.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-font-size: 30px;"
        );

        Label imageText =
                new Label("Trainer Image");

        imageText.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 11px;"
        );

        VBox imageInside =
                new VBox(6);

        imageInside.setAlignment(
                Pos.CENTER
        );

        imageInside.getChildren().addAll(
                imageIcon,
                imageText
        );

        imagePreview.getChildren().add(
                imageInside
        );

        VBox imageControls =
                new VBox(10);

        Label imageTitle =
                new Label("Profile Image");

        imageTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 14px;" +
                " -fx-font-weight: bold;"
        );

        Label imageHint =
                new Label(
                        "Upload a professional trainer photo."
                );

        imageHint.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 11px;"
        );

        Button chooseImage =
                new Button("Choose Image");

        chooseImage.setStyle(
                "-fx-background-color: " + PRIMARY_DIM +
                "; -fx-border-color: rgba(117,255,158,0.25);" +
                "-fx-text-fill: " + PRIMARY +
                "; -fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 9 16;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        chooseImage.setOnMouseEntered(
                e -> chooseImage.setStyle(
                        "-fx-background-color: rgba(117,255,158,0.3);" +
                        "-fx-border-color: rgba(117,255,158,0.5);" +
                        "-fx-text-fill: " + PRIMARY +
                        "; -fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 9 16;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        chooseImage.setOnMouseExited(
                e -> chooseImage.setStyle(
                        "-fx-background-color: " + PRIMARY_DIM +
                        "; -fx-border-color: rgba(117,255,158,0.25);" +
                        "-fx-text-fill: " + PRIMARY +
                        "; -fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 9 16;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        chooseImage.setOnAction(
                e -> {

                    FileChooser fileChooser =
                            new FileChooser();

                    fileChooser.setTitle(
                            "Choose Trainer Image"
                    );

                    fileChooser.getExtensionFilters().add(
                            new FileChooser.ExtensionFilter(
                                    "Image Files",
                                    "*.png",
                                    "*.jpg",
                                    "*.jpeg",
                                    "*.webp"
                            )
                    );

                    File file =
                            fileChooser.showOpenDialog(
                                    root.getScene().getWindow()
                            );

                    if (file != null) {

                        Image selectedImage =
                                new Image(
                                        file.toURI().toString(),
                                        120,
                                        120,
                                        true,
                                        true
                                );

                        ImageView selectedView =
                                new ImageView(selectedImage);

                        selectedView.setFitWidth(120);
                        selectedView.setFitHeight(120);

                        Rectangle imageClip =
                                new Rectangle(
                                        120,
                                        120
                                );

                        imageClip.setArcWidth(18);
                        imageClip.setArcHeight(18);

                        selectedView.setClip(
                                imageClip
                        );

                        imagePreview.getChildren().clear();

                        imagePreview.getChildren().add(
                                selectedView
                        );
                    }
                }
        );

        imageControls.getChildren().addAll(
                imageTitle,
                imageHint,
                chooseImage
        );

        imageSection.getChildren().addAll(
                imagePreview,
                imageControls
        );

        // ==========================================
        // FORM
        // ==========================================
        GridPane form =
                new GridPane();

        form.setHgap(16);
        form.setVgap(14);

        ColumnConstraints formCol1 =
                new ColumnConstraints();

        ColumnConstraints formCol2 =
                new ColumnConstraints();

        formCol1.setPercentWidth(50);
        formCol2.setPercentWidth(50);

        form.getColumnConstraints().addAll(
                formCol1,
                formCol2
        );

        // Name
        VBox nameBox =
                createPopupField(
                        "FULL NAME",
                        "Enter trainer name..."
                );

        // Role
        VBox roleBox =
                createPopupField(
                        "SPECIALIZATION",
                        "e.g. Strength & Power"
                );

        // Experience
        VBox expBox =
                createPopupField(
                        "EXPERIENCE",
                        "e.g. 6 Years"
                );

        // Certifications
        VBox certBox =
                createPopupField(
                        "CERTIFICATIONS",
                        "e.g. NASM, ACE"
                );

        form.add(
                nameBox,
                0,
                0
        );

        form.add(
                roleBox,
                1,
                0
        );

        form.add(
                expBox,
                0,
                1
        );

        form.add(
                certBox,
                1,
                1
        );

        // ==========================================
        // BUTTONS
        // ==========================================
        HBox actions =
                new HBox(12);

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        actions.setPadding(
                new Insets(8, 0, 0, 0)
        );

        Button cancel =
                new Button("Cancel");

        cancel.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 20;" +
                "-fx-cursor: hand;"
        );

        Button save =
                new Button("✓ Save Trainer");

        save.setStyle(
                "-fx-background-color: " + PRIMARY +
                "; -fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 10 22;" +
                "-fx-cursor: hand;"
        );

        save.setOnMouseEntered(
                e -> save.setStyle(
                        "-fx-background-color: #8affab;" +
                        "-fx-text-fill: #003918;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 10 22;" +
                        "-fx-cursor: hand;"
                )
        );

        save.setOnMouseExited(
                e -> save.setStyle(
                        "-fx-background-color: " + PRIMARY +
                        "; -fx-text-fill: #003918;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 10 22;" +
                        "-fx-cursor: hand;"
                )
        );

        actions.getChildren().addAll(
                cancel,
                save
        );

        popup.getChildren().addAll(
                popupHeader,
                imageSection,
                form,
                actions
        );

        // ==========================================
        // CENTER POPUP
        // ==========================================
        StackPane.setAlignment(
                popup,
                Pos.CENTER
        );

        overlay.getChildren().add(
                popup
        );

        root.getChildren().add(
                overlay
        );

        // ==========================================
        // ANIMATION
        // ==========================================
        overlay.setOpacity(0);

        popup.setScaleX(0.88);
        popup.setScaleY(0.88);

        FadeTransition fadeIn =
                new FadeTransition(
                        Duration.millis(220),
                        overlay
                );

        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        ScaleTransition scaleIn =
                new ScaleTransition(
                        Duration.millis(280),
                        popup
                );

        scaleIn.setFromX(0.88);
        scaleIn.setFromY(0.88);
        scaleIn.setToX(1);
        scaleIn.setToY(1);

        fadeIn.play();
        scaleIn.play();

        // ==========================================
        // CLOSE POPUP
        // ==========================================
        Runnable closePopup = () -> {

            FadeTransition fadeOut =
                    new FadeTransition(
                            Duration.millis(180),
                            overlay
                    );

            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);

            ScaleTransition scaleOut =
                    new ScaleTransition(
                            Duration.millis(180),
                            popup
                    );

            scaleOut.setFromX(1);
            scaleOut.setFromY(1);
            scaleOut.setToX(0.92);
            scaleOut.setToY(0.92);

            fadeOut.setOnFinished(
                    ev -> root.getChildren().remove(
                            overlay
                    )
            );

            fadeOut.play();
            scaleOut.play();
        };

        close.setOnAction(
                e -> closePopup.run()
        );

        cancel.setOnAction(
                e -> closePopup.run()
        );

        save.setOnAction(
                e -> {

                    // Demo functionality:
                    // Trainer data can be connected to Firebase later.

                    closePopup.run();
                }
        );
    }

    // ==========================================
    // POPUP FIELD
    // ==========================================
    private VBox createPopupField(
            String labelText,
            String prompt
    ) {

        VBox box =
                new VBox(7);

        Label label =
                new Label(labelText);

        label.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 1px;"
        );

        TextField field =
                new TextField();

        field.setPromptText(
                prompt
        );

        String normalStyle =
                "-fx-background-color: rgba(255,255,255,0.04);" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-width: 1;" +
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-prompt-text-fill: rgba(186,203,185,0.45);" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 12;";

        String focusStyle =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: rgba(117,255,158,0.5);" +
                "-fx-border-width: 1;" +
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-prompt-text-fill: rgba(186,203,185,0.45);" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 12;";

        field.setStyle(
                normalStyle
        );

        field.focusedProperty().addListener(
                (obs, old, focused) ->
                        field.setStyle(
                                focused
                                        ? focusStyle
                                        : normalStyle
                        )
        );

        box.getChildren().addAll(
                label,
                field
        );

        return box;
    }

    // --- Component Builders ---

    private VBox createStatCard(
            String title,
            String value,
            String suffix,
            String suffixColor,
            boolean hasPulse
    ) {

        VBox card = new VBox(4);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color: #020914 " +
                "; -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-background-radius: 16;" +
                " -fx-border-radius: 16;"
        );

        card.setEffect(glassShadow);

        Label tLbl =
                new Label(title.toUpperCase());

        tLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 12px;" +
                " -fx-letter-spacing: 1px;" +
                " -fx-font-weight: bold;"
        );

        HBox vBox =
                new HBox(8);

        vBox.setAlignment(
                Pos.BASELINE_LEFT
        );

        Label vLbl =
                new Label(value);

        vLbl.setStyle(
                "-fx-text-fill: " +
                (hasPulse ? PRIMARY : TEXT_MAIN) +
                "; -fx-font-size: 36px;" +
                " -fx-font-weight: bold;"
        );

        if (hasPulse) {

            Circle dot =
                    new Circle(
                            4,
                            Color.web(PRIMARY)
                    );

            dot.setTranslateY(-4);

            vBox.getChildren().addAll(
                    vLbl,
                    dot
            );

        } else {

            Label sLbl =
                    new Label(suffix);

            sLbl.setStyle(
                    "-fx-text-fill: " +
                    suffixColor +
                    "; -fx-font-size: 14px;" +
                    " -fx-font-weight: bold;"
            );

            vBox.getChildren().addAll(
                    vLbl,
                    sLbl
            );
        }

        card.getChildren().addAll(
                tLbl,
                vBox
        );

        return card;
    }

    private VBox createTrainerCard(
            String imgUrl,
            String name,
            String role,
            String exp,
            String certs,
            boolean isLive
    ) {

        VBox card =
                new VBox();

        card.setStyle(
                "-fx-background-color: #020914" +
                "; -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-background-radius: 24;" +
                " -fx-border-radius: 24;"
        );

        card.setEffect(glassShadow);

        // Top Image Section
        StackPane imgSection =
                new StackPane();

        imgSection.setPrefHeight(256);

        ImageView img =
                new ImageView(
                        new Image(
                                imgUrl,
                                400,
                                400,
                                true,
                                true
                        )
                );

        img.setFitWidth(350);

        Rectangle clip =
                new Rectangle(
                        400,
                        256
                );

        clip.setArcWidth(24);
        clip.setArcHeight(24);

        img.setClip(clip);

        Region gradient =
                new Region();

        gradient.setStyle(
                "-fx-background-color: linear-gradient(to top, " +
                BG_COLOR +
                ", transparent, transparent);" +
                " -fx-background-radius: 24 24 0 0;"
        );

        // Status Badge
        HBox badge =
                new HBox(8);

        badge.setAlignment(
                Pos.CENTER
        );

        badge.setPadding(
                new Insets(6, 12, 6, 12)
        );

        badge.setMaxWidth(
                Region.USE_PREF_SIZE
        );

        badge.setMaxHeight(
                Region.USE_PREF_SIZE
        );

        StackPane.setAlignment(
                badge,
                Pos.TOP_LEFT
        );

        StackPane.setMargin(
                badge,
                new Insets(16)
        );

        if (isLive) {

            badge.setStyle(
                    "-fx-background-color: rgba(0,0,0,0.5);" +
                    " -fx-border-color: rgba(255,255,255,0.1);" +
                    " -fx-background-radius: 50;" +
                    " -fx-border-radius: 50;"
            );

            Circle dot =
                    new Circle(
                            4,
                            Color.web(PRIMARY)
                    );

            Label bLbl =
                    new Label("LIVE AVAILABLE");

            bLbl.setStyle(
                    "-fx-text-fill: " + PRIMARY +
                    "; -fx-font-size: 10px;" +
                    " -fx-font-weight: bold;"
            );

            badge.getChildren().addAll(
                    dot,
                    bLbl
            );

        } else {

            badge.setStyle(
                    "-fx-background-color: rgba(0,0,0,0.5);" +
                    " -fx-border-color: rgba(255,255,255,0.1);" +
                    " -fx-background-radius: 50;" +
                    " -fx-border-radius: 50;" +
                    " -fx-opacity: 0.4;"
            );

            Circle dot =
                    new Circle(
                            4,
                            Color.web(TEXT_MUTED)
                    );

            Label bLbl =
                    new Label(
                            name.equals("Elena Rojas")
                                    ? "OFFLINE"
                                    : "IN SESSION"
                    );

            bLbl.setStyle(
                    "-fx-text-fill: " + TEXT_MUTED +
                    "; -fx-font-size: 10px;" +
                    " -fx-font-weight: bold;"
            );

            badge.getChildren().addAll(
                    dot,
                    bLbl
            );
        }

        // Name and Role over image
        VBox nameBox =
                new VBox(2);

        StackPane.setAlignment(
                nameBox,
                Pos.BOTTOM_LEFT
        );

        StackPane.setMargin(
                nameBox,
                new Insets(16)
        );

        Label nLbl =
                new Label(name);

        nLbl.setStyle(
                "-fx-text-fill: white;" +
                " -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label rLbl =
                new Label(role.toUpperCase());

        rLbl.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-font-size: 12px;" +
                " -fx-letter-spacing: 2px;" +
                " -fx-font-weight: bold;"
        );

        nameBox.getChildren().addAll(
                nLbl,
                rLbl
        );

        imgSection.getChildren().addAll(
                img,
                gradient,
                badge,
                nameBox
        );

        // Bottom Details Section
        VBox details =
                new VBox(24);

        details.setPadding(
                new Insets(24)
        );

        VBox.setVgrow(
                details,
                Priority.ALWAYS
        );

        HBox statsRow =
                new HBox(16);

        statsRow.getChildren().addAll(
                createTrainerStat(
                        "EXPERIENCE",
                        exp
                ),
                createTrainerStat(
                        "CERTIFICATIONS",
                        certs
                )
        );

        Region spacer =
                new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS
        );

        HBox actions =
                new HBox();

        actions.setAlignment(
                Pos.CENTER_LEFT
        );

        actions.setStyle(
                "-fx-border-color: rgba(255,255,255,0.1) " +
                "transparent transparent transparent;" +
                " -fx-padding: 16 0 0 0;"
        );

        Label view =
                new Label("👁 Details");

        view.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 12px;" +
                " -fx-cursor: hand;"
        );

        view.setOnMouseEntered(
                e -> view.setStyle(
                        "-fx-text-fill: " + PRIMARY +
                        "; -fx-font-size: 12px;" +
                        " -fx-cursor: hand;"
                )
        );

        view.setOnMouseExited(
                e -> view.setStyle(
                        "-fx-text-fill: " + TEXT_MUTED +
                        "; -fx-font-size: 12px;" +
                        " -fx-cursor: hand;"
                )
        );

        Region sp2 =
                new Region();

        HBox.setHgrow(
                sp2,
                Priority.ALWAYS
        );

        HBox btns =
                new HBox(8);

        Button edit =
                new Button("✎");

        edit.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                " -fx-text-fill: " + TEXT_MUTED +
                "; -fx-background-radius: 8;" +
                " -fx-cursor: hand;"
        );

        edit.setOnMouseEntered(
                e -> edit.setStyle(
                        "-fx-background-color: " +
                        PRIMARY_DIM +
                        "; -fx-text-fill: " +
                        PRIMARY +
                        "; -fx-background-radius: 8;" +
                        " -fx-cursor: hand;"
                )
        );

        edit.setOnMouseExited(
                e -> edit.setStyle(
                        "-fx-background-color: rgba(255,255,255,0.05);" +
                        " -fx-text-fill: " + TEXT_MUTED +
                        "; -fx-background-radius: 8;"
                )
        );

        Button del =
                new Button("🗑");

        del.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                " -fx-text-fill: " + TEXT_MUTED +
                "; -fx-background-radius: 8;" +
                " -fx-cursor: hand;"
        );

        del.setOnMouseEntered(
                e -> del.setStyle(
                        "-fx-background-color: rgba(255, 180, 171, 0.2);" +
                        " -fx-text-fill: " + ERROR +
                        "; -fx-background-radius: 8;" +
                        " -fx-cursor: hand;"
                )
        );

        del.setOnMouseExited(
                e -> del.setStyle(
                        "-fx-background-color: rgba(255,255,255,0.05);" +
                        " -fx-text-fill: " + TEXT_MUTED +
                        "; -fx-background-radius: 8;" +
                        " -fx-cursor: hand;"
                )
        );

        btns.getChildren().addAll(
                edit,
                del
        );

        actions.getChildren().addAll(
                view,
                sp2,
                btns
        );

        details.getChildren().addAll(
                statsRow,
                spacer,
                actions
        );

        card.getChildren().addAll(
                imgSection,
                details
        );

        // Hover Effect on whole card
        String cDef =
                "-fx-background-color: #020914 " +
                "; -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-background-radius: 24;" +
                " -fx-border-radius: 24;";

        String cHov =
                "-fx-background-color: #020914" +
                "; -fx-border-color: " +
                SURFACE_HOVER_BORDER +
                "; -fx-background-radius: 24;" +
                " -fx-border-radius: 24;";

        card.setOnMouseEntered(
                e -> {

                    card.setStyle(cHov);

                    card.setTranslateY(-4);

                    card.setEffect(
                            cardHoverShadow
                    );
                }
        );

        card.setOnMouseExited(
                e -> {

                    card.setStyle(cDef);

                    card.setTranslateY(0);

                    card.setEffect(
                            glassShadow
                    );
                }
        );

        return card;
    }

    private VBox createTrainerStat(
            String title,
            String val
    ) {

        VBox box =
                new VBox(4);

        HBox.setHgrow(
                box,
                Priority.ALWAYS
        );

        box.setPadding(
                new Insets(12)
        );

        box.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                " -fx-border-color: rgba(255,255,255,0.05);" +
                " -fx-background-radius: 12;" +
                " -fx-border-radius: 12;"
        );

        Label t =
                new Label(title);

        t.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;" +
                " text-transform: uppercase;"
        );

        Label v =
                new Label(val);

        v.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 14px;" +
                " -fx-font-weight: bold;"
        );

        box.getChildren().addAll(
                t,
                v
        );

        return box;
    }

    private VBox createChartPanel() {

        VBox card =
                new VBox(32);

        card.setPadding(
                new Insets(32)
        );

        card.setStyle(
                "-fx-background-color: #020914 " +
                "; -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-background-radius: 24;" +
                " -fx-border-radius: 24;"
        );

        card.setEffect(glassShadow);

        HBox top =
                new HBox();

        top.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox text =
                new VBox(4);

        Label title =
                new Label(
                        "Trainer Performance Overview"
                );

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label sub =
                new Label(
                        "Live metrics of user satisfaction and session conversion."
                );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 14px;"
        );

        text.getChildren().addAll(
                title,
                sub
        );

        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        HBox filters =
                new HBox(8);

        Button b1 =
                new Button("This Month");

        b1.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                " -fx-border-color: rgba(255,255,255,0.05);" +
                " -fx-text-fill: " + TEXT_MAIN +
                "; -fx-background-radius: 50;" +
                " -fx-border-radius: 50;" +
                " -fx-padding: 8 16;" +
                " -fx-font-weight: bold;"
        );

        Button b2 =
                new Button("Last Quarter");

        b2.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                " -fx-border-color: rgba(255,255,255,0.05);" +
                " -fx-text-fill: " + TEXT_MUTED +
                "; -fx-background-radius: 50;" +
                " -fx-border-radius: 50;" +
                " -fx-padding: 8 16;" +
                " -fx-font-weight: bold;"
        );

        filters.getChildren().addAll(
                b1,
                b2
        );

        top.getChildren().addAll(
                text,
                sp,
                filters
        );

        // Chart Area Mockup
        HBox chart =
                new HBox(16);

        chart.setPrefHeight(256);

        chart.setAlignment(
                Pos.BOTTOM_CENTER
        );

        chart.getChildren().addAll(
                createChartBar(
                        "M. Thorne",
                        0.65,
                        false
                ),
                createChartBar(
                        "S. Vane",
                        0.45,
                        false
                ),
                createChartBar(
                        "D. Kross",
                        0.90,
                        true
                ),
                createChartBar(
                        "E. Rojas",
                        0.75,
                        false
                ),
                createChartBar(
                        "J. Doe",
                        0.55,
                        false
                )
        );

        card.getChildren().addAll(
                top,
                chart
        );

        return card;
    }

    private VBox createChartBar(
            String label,
            double percent,
            boolean isTop
    ) {

        VBox col =
                new VBox(8);

        HBox.setHgrow(
                col,
                Priority.ALWAYS
        );

        col.setAlignment(
                Pos.BOTTOM_CENTER
        );

        StackPane bar =
                new StackPane();

        bar.prefHeightProperty().bind(
                col.heightProperty().multiply(percent)
        );

        bar.setStyle(
                "-fx-background-color: " +
                PRIMARY_DIM +
                "; -fx-background-radius: 12 12 0 0;"
        );

        Region hoverFill =
                new Region();

        hoverFill.setStyle(
                "-fx-background-color: rgba(117, 255, 158, 0.3);" +
                " -fx-background-radius: 12 12 0 0;"
        );

        hoverFill.setOpacity(0);

        bar.getChildren().add(
                hoverFill
        );

        bar.setOnMouseEntered(
                e -> hoverFill.setOpacity(1)
        );

        bar.setOnMouseExited(
                e -> hoverFill.setOpacity(0)
        );

        if (isTop) {

            Label topLbl =
                    new Label("Top Performer");

            topLbl.setStyle(
                    "-fx-text-fill: " + PRIMARY +
                    "; -fx-font-size: 12px;" +
                    " -fx-font-weight: bold;"
            );

            topLbl.setTranslateY(-20);

            StackPane.setAlignment(
                    topLbl,
                    Pos.TOP_CENTER
            );

            bar.getChildren().add(
                    topLbl
            );
        }

        Label lbl =
                new Label(
                        label.toUpperCase()
                );

        lbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;"
        );

        col.getChildren().addAll(
                bar,
                lbl
        );

        return col;
    }
}
package com.visionx.view.user_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TrainerProfileView {

    public Scene getTrainerProfileScene(
            String trainerName,
            String specialization,
            String experience,
            String rating,
            String price,
            String imageUrl,
            Runnable backAction) {

        BorderPane root = new BorderPane();

        root.setStyle(
            "-fx-background-color:#080C14;"
        );

        // =====================================================
        // TOP BAR
        // =====================================================

        HBox topBar = new HBox(15);

        topBar.setAlignment(Pos.CENTER_LEFT);

        topBar.setPadding(
            new Insets(20, 35, 20, 35)
        );

        topBar.setStyle(
            "-fx-background-color:#050A11;" +
            "-fx-border-color:#17212c;" +
            "-fx-border-width:0 0 1 0;"
        );

        Button backButton = new Button("← Back");

        backButton.setStyle(
            "-fx-background-color:#111a24;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-background-radius:10px;" +
            "-fx-border-color:#293642;" +
            "-fx-border-radius:10px;" +
            "-fx-padding:9px 16px;" +
            "-fx-cursor:hand;"
        );

        backButton.setOnAction(e -> {

            if (backAction != null) {
                backAction.run();
            }
        });

        Text pageTitle = new Text("Trainer Profile");

        pageTitle.setStyle(
            "-fx-font-size:22px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        topBar.getChildren().addAll(
            backButton,
            pageTitle
        );

        root.setTop(topBar);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox content = new VBox(25);

        content.setPadding(
            new Insets(35, 50, 50, 50)
        );

        // =====================================================
        // PROFILE HEADER
        // =====================================================

        HBox profileHeader = new HBox(30);

        profileHeader.setAlignment(
            Pos.CENTER_LEFT
        );

        profileHeader.setPadding(
            new Insets(25)
        );

        profileHeader.setStyle(
            "-fx-background-color:linear-gradient(to right,#0c1722,#0a141f);" +
            "-fx-background-radius:20px;" +
            "-fx-border-color:#1a2936;" +
            "-fx-border-radius:20px;"
        );

        Image image = new Image(
            imageUrl +
            "?auto=format&fit=crop&w=500&q=80",
            180,
            180,
            false,
            true
        );

        ImageView imageView =
                new ImageView(image);

        imageView.setFitWidth(180);
        imageView.setFitHeight(180);

        imageView.setPreserveRatio(false);

        Rectangle clip =
                new Rectangle(180, 180);

        clip.setArcWidth(25);
        clip.setArcHeight(25);

        imageView.setClip(clip);

        VBox trainerInfo =
                new VBox(10);

        Text name =
                new Text(trainerName);

        name.setStyle(
            "-fx-font-size:30px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        Text spec =
                new Text(specialization);

        spec.setStyle(
            "-fx-font-size:15px;" +
            "-fx-fill:#62ff96;" +
            "-fx-font-weight:bold;"
        );

        Text exp =
                new Text(
                    "💪 " + experience
                );

        exp.setStyle(
            "-fx-font-size:13px;" +
            "-fx-fill:#a4adb7;"
        );

        Text ratingText =
                new Text(
                    "★ " + rating + " Rating"
                );

        ratingText.setStyle(
            "-fx-font-size:14px;" +
            "-fx-fill:#ffffff;" +
            "-fx-font-weight:bold;"
        );

        Text priceText =
                new Text(price);

        priceText.setStyle(
            "-fx-font-size:17px;" +
            "-fx-fill:#62ff96;" +
            "-fx-font-weight:bold;"
        );

        Text available =
                new Text("● Available for Booking");

        available.setStyle(
            "-fx-font-size:12px;" +
            "-fx-fill:#62ff96;" +
            "-fx-font-weight:bold;"
        );

        trainerInfo.getChildren().addAll(
            name,
            spec,
            exp,
            ratingText,
            priceText,
            available
        );

        Region headerSpacer = new Region();

        HBox.setHgrow(
            headerSpacer,
            Priority.ALWAYS
        );

        Button messageButton =
                new Button("💬 Message");

        messageButton.setStyle(
            "-fx-background-color:#151e28;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-background-radius:12px;" +
            "-fx-border-color:#62ff96;" +
            "-fx-border-radius:12px;" +
            "-fx-padding:12px 20px;" +
            "-fx-font-weight:bold;" +
            "-fx-cursor:hand;"
        );

        Button bookButton =
                new Button("Book Trainer");

        bookButton.setStyle(
            "-fx-background-color:#62ff96;" +
            "-fx-text-fill:#06100a;" +
            "-fx-background-radius:12px;" +
            "-fx-padding:12px 25px;" +
            "-fx-font-weight:bold;" +
            "-fx-cursor:hand;"
        );

        VBox actionButtons =
                new VBox(10);

        actionButtons.getChildren().addAll(
            messageButton,
            bookButton
        );

        profileHeader.getChildren().addAll(
            imageView,
            trainerInfo,
            headerSpacer,
            actionButtons
        );

        // =====================================================
        // ABOUT
        // =====================================================

        VBox aboutBox =
                createSectionBox();

        Text aboutTitle =
                new Text("About Trainer");

        aboutTitle.setStyle(
            "-fx-font-size:20px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        Label aboutText =
                new Label(
                    trainerName +
                    " is a professional fitness trainer specializing in " +
                    specialization +
                    ". With " +
                    experience +
                    ", the trainer helps clients build strength, " +
                    "improve fitness and achieve their personal goals."
                );

        aboutText.setWrapText(true);

        aboutText.setStyle(
            "-fx-font-size:13px;" +
            "-fx-text-fill:#9ca6b0;" +
            "-fx-line-spacing:5px;"
        );

        aboutBox.getChildren().addAll(
            aboutTitle,
            aboutText
        );

        // =====================================================
        // SPECIALIZATION
        // =====================================================

        VBox specializationBox =
                createSectionBox();

        Text specializationTitle =
                new Text("Specializations");

        specializationTitle.setStyle(
            "-fx-font-size:20px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        HBox tags =
                new HBox(10);

        tags.getChildren().addAll(
            createTag(specialization),
            createTag("Workout Planning"),
            createTag("Nutrition Guidance"),
            createTag("Personal Training")
        );

        specializationBox.getChildren().addAll(
            specializationTitle,
            tags
        );

        // =====================================================
        // TRAINING INFORMATION
        // =====================================================

        HBox information =
                new HBox(20);

        information.getChildren().addAll(
            createInfoCard(
                "Experience",
                experience
            ),
            createInfoCard(
                "Rating",
                "★ " + rating
            ),
            createInfoCard(
                "Session Price",
                price
            ),
            createInfoCard(
                "Clients",
                "120+"
            )
        );

        // =====================================================
        // BOOK BUTTON
        // =====================================================

        Button bookSession =
                new Button(
                    "Book a Personal Training Session"
                );

        bookSession.setMaxWidth(
            Double.MAX_VALUE
        );

        bookSession.setStyle(
            "-fx-background-color:#62ff96;" +
            "-fx-text-fill:#06100a;" +
            "-fx-font-size:15px;" +
            "-fx-font-weight:bold;" +
            "-fx-background-radius:12px;" +
            "-fx-padding:14px;" +
            "-fx-cursor:hand;"
        );

        bookSession.setOnAction(e -> {

            System.out.println(
                "Booking trainer: " + trainerName
            );
        });

        // =====================================================
        // MESSAGE ACTION
        // =====================================================

        messageButton.setOnAction(e -> {

            TrainerChatView chatView =
                    new TrainerChatView();

            Scene chatScene =
                    chatView.getTrainerChatScene(
                        trainerName,
                        imageUrl,
                        () -> {

                            root.getScene()
                                .setRoot(root);
                        }
                    );

            root.getScene()
                .setRoot(chatScene.getRoot());
        });

        // =====================================================
        // BOOK ACTION
        // =====================================================

        bookButton.setOnAction(e -> {

            System.out.println(
                "Booking trainer: " + trainerName
            );
        });

        content.getChildren().addAll(
            profileHeader,
            information,
            aboutBox,
            specializationBox,
            bookSession
        );

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
            "-fx-background:#080C14;" +
            "-fx-background-color:#080C14;" +
            "-fx-border-color:transparent;"
        );

        root.setCenter(scrollPane);

        return new Scene(
            root,
            1200,
            800
        );
    }

    // =====================================================
    // SECTION BOX
    // =====================================================

    private VBox createSectionBox() {

        VBox box =
                new VBox(15);

        box.setPadding(
            new Insets(25)
        );

        box.setStyle(
            "-fx-background-color:#0c1520;" +
            "-fx-background-radius:18px;" +
            "-fx-border-color:#1a2936;" +
            "-fx-border-radius:18px;"
        );

        return box;
    }

    // =====================================================
    // TAG
    // =====================================================

    private Text createTag(
            String text
    ) {

        Text tag =
                new Text(text);

        tag.setStyle(
            "-fx-background-color:rgba(98,255,150,0.08);" +
            "-fx-fill:#62ff96;" +
            "-fx-font-size:11px;" +
            "-fx-font-weight:bold;" +
            "-fx-padding:8px 12px;" +
            "-fx-background-radius:12px;"
        );

        return tag;
    }

    // =====================================================
    // INFO CARD
    // =====================================================

    private VBox createInfoCard(
            String title,
            String value
    ) {

        VBox card =
                new VBox(6);

        card.setPadding(
            new Insets(18)
        );

        card.setPrefWidth(200);

        card.setStyle(
            "-fx-background-color:#0c1520;" +
            "-fx-background-radius:15px;" +
            "-fx-border-color:#1a2936;" +
            "-fx-border-radius:15px;"
        );

        Text titleText =
                new Text(title);

        titleText.setStyle(
            "-fx-font-size:11px;" +
            "-fx-fill:#8a8d91;"
        );

        Text valueText =
                new Text(value);

        valueText.setStyle(
            "-fx-font-size:17px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        card.getChildren().addAll(
            titleText,
            valueText
        );

        return card;
    }
}
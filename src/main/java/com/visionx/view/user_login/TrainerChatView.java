package com.visionx.view.user_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class TrainerChatView {

    public Scene getTrainerChatScene(
            String trainerName,
            String imageUrl,
            Runnable backAction) {

        BorderPane root =
                new BorderPane();

        root.setStyle(
            "-fx-background-color:#080C14;"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                new HBox(15);

        header.setAlignment(
            Pos.CENTER_LEFT
        );

        header.setPadding(
            new Insets(18, 25, 18, 25)
        );

        header.setStyle(
            "-fx-background-color:#050A11;" +
            "-fx-border-color:#17212c;" +
            "-fx-border-width:0 0 1 0;"
        );

        Button back =
                new Button("←");

        back.setStyle(
            "-fx-background-color:#111a24;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-background-radius:10px;" +
            "-fx-font-size:18px;" +
            "-fx-cursor:hand;"
        );

        back.setOnAction(e -> {

            if (backAction != null) {
                backAction.run();
            }
        });

        Image image =
                new Image(
                    imageUrl +
                    "?auto=format&fit=crop&w=200&q=80",
                    45,
                    45,
                    false,
                    true
                );

        ImageView imageView =
                new ImageView(image);

        imageView.setFitWidth(45);
        imageView.setFitHeight(45);

        Circle clip =
                new Circle(
                    22.5,
                    22.5,
                    22.5
                );

        imageView.setClip(clip);

        VBox trainerInfo =
                new VBox(3);

        Text name =
                new Text(trainerName);

        name.setStyle(
            "-fx-font-size:16px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        Text online =
                new Text("● Online");

        online.setStyle(
            "-fx-font-size:11px;" +
            "-fx-fill:#62ff96;"
        );

        trainerInfo.getChildren().addAll(
            name,
            online
        );

        header.getChildren().addAll(
            back,
            imageView,
            trainerInfo
        );

        root.setTop(header);

        // =====================================================
        // CHAT AREA
        // =====================================================

        VBox messages =
                new VBox(15);

        messages.setPadding(
            new Insets(25)
        );

        HBox trainerMessage =
                createMessage(
                    trainerName,
                    "Hello! 👋 How can I help you with your fitness goals?",
                    false
                );

        HBox userMessage =
                createMessage(
                    "You",
                    "Hi! I want to improve my strength and build muscle.",
                    true
                );

        HBox trainerMessage2 =
                createMessage(
                    trainerName,
                    "Great! I can create a personalized workout plan for you. 💪",
                    false
                );

        messages.getChildren().addAll(
            trainerMessage,
            userMessage,
            trainerMessage2
        );

        ScrollPane scrollPane =
                new ScrollPane(messages);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
            "-fx-background:#080C14;" +
            "-fx-background-color:#080C14;" +
            "-fx-border-color:transparent;"
        );

        root.setCenter(scrollPane);

        // =====================================================
        // MESSAGE INPUT
        // =====================================================

        HBox inputBox =
                new HBox(10);

        inputBox.setPadding(
            new Insets(15, 20, 15, 20)
        );

        inputBox.setStyle(
            "-fx-background-color:#050A11;" +
            "-fx-border-color:#17212c;" +
            "-fx-border-width:1px 0 0 0;"
        );

        TextField messageField =
                new TextField();

        messageField.setPromptText(
            "Type your message..."
        );

        messageField.setStyle(
            "-fx-background-color:#111a24;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-prompt-text-fill:#596675;" +
            "-fx-background-radius:20px;" +
            "-fx-border-color:#293642;" +
            "-fx-border-radius:20px;" +
            "-fx-padding:11px 16px;"
        );

        HBox.setHgrow(
            messageField,
            Priority.ALWAYS
        );

        Button sendButton =
                new Button("Send");

        sendButton.setStyle(
            "-fx-background-color:#62ff96;" +
            "-fx-text-fill:#06100a;" +
            "-fx-font-weight:bold;" +
            "-fx-background-radius:20px;" +
            "-fx-padding:10px 20px;" +
            "-fx-cursor:hand;"
        );

        sendButton.setOnAction(e -> {

            String message =
                    messageField.getText().trim();

            if (!message.isEmpty()) {

                HBox newMessage =
                        createMessage(
                            "You",
                            message,
                            true
                        );

                messages.getChildren()
                        .add(newMessage);

                messageField.clear();

                scrollPane.setVvalue(
                    1.0
                );
            }
        });

        messageField.setOnAction(e ->
                sendButton.fire()
        );

        inputBox.getChildren().addAll(
            messageField,
            sendButton
        );

        root.setBottom(inputBox);

        return new Scene(
            root,
            1200,
            800
        );
    }

    // =====================================================
    // MESSAGE
    // =====================================================

    private HBox createMessage(
            String sender,
            String message,
            boolean user
    ) {

        HBox box =
                new HBox();

        box.setMaxWidth(
            Double.MAX_VALUE
        );

        if (user) {

            box.setAlignment(
                Pos.CENTER_RIGHT
            );

        } else {

            box.setAlignment(
                Pos.CENTER_LEFT
            );
        }

        VBox messageBox =
                new VBox(5);

        messageBox.setMaxWidth(500);

        Text senderText =
                new Text(sender);

        senderText.setStyle(
            "-fx-font-size:10px;" +
            "-fx-fill:#8a8d91;"
        );

        Text messageText =
                new Text(message);

        messageText.setWrappingWidth(450);

        messageText.setStyle(
            "-fx-font-size:13px;" +
            "-fx-fill:#ffffff;" +
            "-fx-line-spacing:4px;"
        );

        messageBox.getChildren().addAll(
            senderText,
            messageText
        );

        messageBox.setPadding(
            new Insets(12, 16, 12, 16)
        );

        if (user) {

            messageBox.setStyle(
                "-fx-background-color:#174d2c;" +
                "-fx-background-radius:15px 15px 3px 15px;"
            );

        } else {

            messageBox.setStyle(
                "-fx-background-color:#111a24;" +
                "-fx-background-radius:15px 15px 15px 3px;" +
                "-fx-border-color:#1e2b38;" +
                "-fx-border-radius:15px;"
            );
        }

        box.getChildren().add(
            messageBox
        );

        return box;
    }
}
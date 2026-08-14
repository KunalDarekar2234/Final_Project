package com.visionx.view.user_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class AiMentorFloating {

    // =========================================================
    // ADD AI MENTOR TO ANY PAGE
    // =========================================================

    public static void addTo(StackPane root) {

        // =====================================================
        // FLOATING AI BUTTON
        // =====================================================

        Button aiButton = new Button("✨");

        aiButton.setStyle(
            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-background-radius: 30px;" +
            "-fx-min-width: 60px;" +
            "-fx-min-height: 60px;" +
            "-fx-max-width: 60px;" +
            "-fx-max-height: 60px;" +
            "-fx-font-size: 28px;" +
            "-fx-alignment: center;" +
            "-fx-padding: 0;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.6), 15, 0.4, 0, 4);"
        );

        // =====================================================
        // FLOATING BUTTON POSITION
        // =====================================================

        StackPane.setAlignment(
            aiButton,
            Pos.BOTTOM_RIGHT
        );

        StackPane.setMargin(
            aiButton,
            new Insets(0, 50, 60, 0)
        );

        // =====================================================
        // CHAT WINDOW
        // =====================================================

        HBox chatWindow = createChatWindow(aiButton);

        StackPane.setAlignment(
            chatWindow,
            Pos.BOTTOM_RIGHT
        );

        StackPane.setMargin(
            chatWindow,
            new Insets(0, 30, 130, 30)
        );

        // Initially hidden

        chatWindow.setVisible(false);

        // =====================================================
        // BUTTON CLICK
        // =====================================================

        aiButton.setOnAction(e -> {

            boolean visible =
                chatWindow.isVisible();

            chatWindow.setVisible(
                !visible
            );

        });

        // =====================================================
        // ADD TO ROOT
        // =====================================================

        root.getChildren().addAll(
            chatWindow,
            aiButton
        );
    }

    // =========================================================
    // CREATE CHAT WINDOW
    // =========================================================

    private static HBox createChatWindow(
        Button aiButton
    ) {

        HBox mainLayout = new HBox();
        mainLayout.setPrefSize(390, 560);
        mainLayout.setMaxSize(390, 560);
        mainLayout.setStyle(
            "-fx-background-color: #0b1118;" +
            "-fx-background-radius: 20px;" +
            "-fx-border-color: #26323d;" +
            "-fx-border-radius: 20px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.65), 30, 0.3, 0, 8);"
        );

        VBox historySidebar = new VBox(15);
        historySidebar.setPrefWidth(250);
        historySidebar.setPadding(new Insets(20));
        historySidebar.setStyle(
            "-fx-background-color: #111922;" +
            "-fx-background-radius: 20px 0 0 20px;" +
            "-fx-border-color: transparent #26323d transparent transparent;" +
            "-fx-border-width: 0 1px 0 0;"
        );
        historySidebar.setVisible(false);
        historySidebar.setManaged(false);

        Text historyTitle = new Text("Search History");
        historyTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-fill: white;");
        
        VBox historyList = new VBox(10);
        historySidebar.getChildren().addAll(historyTitle, historyList);

        VBox window = new VBox();
        HBox.setHgrow(window, Priority.ALWAYS);

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
            new HBox();

        header.setAlignment(
            Pos.CENTER_LEFT
        );

        header.setPadding(
            new Insets(18)
        );

        header.setStyle(
            "-fx-background-color: #111922;" +
            "-fx-background-radius: 20px 20px 0 0;" +
            "-fx-border-color: transparent transparent #26323d transparent;" +
            "-fx-border-width: 0 0 1px 0;"
        );

        // AI icon

        Circle aiCircle =
            new Circle(
                21,
                Color.web("#62ff96")
            );

        // Title

        VBox titleBox =
            new VBox(2);

        titleBox.setPadding(
            new Insets(0, 0, 0, 10)
        );

        Text title =
            new Text(
                "AI Mentor"
            );

        title.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: white;"
        );

        Text status =
            new Text(
                "● Online"
            );

        status.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        titleBox.getChildren().addAll(
            title,
            status
        );

        HBox.setHgrow(
            titleBox,
            Priority.ALWAYS
        );

        // Full screen button

        Button fullScreenButton =
            new Button("⤢");

        fullScreenButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #8a8d91;" +
            "-fx-font-size: 18px;" +
            "-fx-cursor: hand;"
        );

        boolean[] isFullScreen = {false};

        fullScreenButton.setOnAction(e -> {
            if (!isFullScreen[0]) {
                mainLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                StackPane.setMargin(mainLayout, new Insets(20));
                StackPane.setAlignment(mainLayout, Pos.CENTER);
                isFullScreen[0] = true;
                fullScreenButton.setText("⤡");
                historySidebar.setVisible(true);
                historySidebar.setManaged(true);
            } else {
                mainLayout.setMaxSize(390, 560);
                StackPane.setMargin(mainLayout, new Insets(0, 30, 100, 30));
                StackPane.setAlignment(mainLayout, Pos.BOTTOM_RIGHT);
                isFullScreen[0] = false;
                fullScreenButton.setText("⤢");
                historySidebar.setVisible(false);
                historySidebar.setManaged(false);
            }
        });

        // Close button

        Button closeButton =
            new Button("×");

        closeButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #8a8d91;" +
            "-fx-font-size: 25px;" +
            "-fx-cursor: hand;"
        );

        // When close is clicked, we also reset full screen if it was active
        closeButton.setOnAction(e -> {
            mainLayout.setVisible(false);
            if (isFullScreen[0]) {
                fullScreenButton.fire(); // reset to normal size
            }
        });

        header.getChildren().addAll(
            aiCircle,
            titleBox,
            fullScreenButton,
            closeButton
        );

        // =====================================================
        // MESSAGE AREA
        // =====================================================

        VBox messages =
            new VBox(15);

        messages.setPadding(
            new Insets(20)
        );

        // Welcome message

        messages.getChildren().add(
            createAIMessage(
                "Hi 👋 I'm your FitVerse AI Mentor. Ask me anything about your workout, diet, calories or fitness.",
                "Now"
            )
        );

        ScrollPane scrollPane =
            new ScrollPane(
                messages
            );

        scrollPane.setFitToWidth(
            true
        );

        scrollPane.setHbarPolicy(
            ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setStyle(
            "-fx-background:#0b1118;" +
            "-fx-background-color:#0b1118;" +
            "-fx-border-color:transparent;"
        );

        VBox.setVgrow(
            scrollPane,
            Priority.ALWAYS
        );

        // =====================================================
        // INPUT AREA
        // =====================================================

        HBox inputArea =
            new HBox(8);

        inputArea.setAlignment(
            Pos.CENTER_LEFT
        );

        inputArea.setPadding(
            new Insets(12)
        );

        inputArea.setStyle(
            "-fx-background-color:#111922;" +
            "-fx-background-radius:0 0 20px 20px;" +
            "-fx-border-color:#26323d transparent transparent transparent;" +
            "-fx-border-width:1px 0 0 0;"
        );

        TextField input =
            new TextField();

        input.setPromptText(
            "Ask your fitness question..."
        );

        input.setStyle(
            "-fx-background-color:#18222c;" +
            "-fx-text-fill:white;" +
            "-fx-prompt-text-fill:#687582;" +
            "-fx-background-radius:20px;" +
            "-fx-padding:10px 15px;" +
            "-fx-font-size:12px;"
        );

        HBox.setHgrow(
            input,
            Priority.ALWAYS
        );

        Button sendButton =
            new Button("➤");

        sendButton.setStyle(
            "-fx-background-color:#62ff96;" +
            "-fx-text-fill:#06100a;" +
            "-fx-background-radius:50%;" +
            "-fx-min-width:40px;" +
            "-fx-min-height:40px;" +
            "-fx-font-weight:bold;" +
            "-fx-cursor:hand;"
        );

        // =====================================================
        // SEND QUESTION
        // =====================================================

        sendButton.setOnAction(e -> {
            sendMessage(
                input,
                messages,
                scrollPane,
                historyList
            );
        });

        // Enter key

        input.setOnAction(e -> {
            sendMessage(
                input,
                messages,
                scrollPane,
                historyList
            );
        });

        inputArea.getChildren().addAll(
            input,
            sendButton
        );

        // Close button logic is handled earlier in the file

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        window.getChildren().addAll(
            header,
            scrollPane,
            inputArea
        );
        mainLayout.getChildren().addAll(historySidebar, window);

        return mainLayout;
    }

    // =========================================================
    // SEND MESSAGE
    // =========================================================

    private static void sendMessage(
        TextField input,
        VBox messages,
        ScrollPane scrollPane,
        VBox historyList
    ) {

        String question =
            input.getText().trim();

        if (question.isEmpty()) {
            return;
        }

        // Add to history sidebar
        Label historyItem = new Label("🕒 " + question);
        historyItem.setStyle("-fx-text-fill: #8a8d91; -fx-font-size: 12px; -fx-padding: 5px 0; -fx-cursor: hand;");
        historyList.getChildren().add(historyItem);

        // =====================================================
        // USER QUESTION
        // =====================================================

        messages.getChildren().add(
            createUserMessage(
                question
            )
        );

        // Clear input

        input.clear();

        // =====================================================
        // AI ANSWER
        // =====================================================

        String answer =
            generateAnswer(
                question
            );

        messages.getChildren().add(
            createAIMessage(
                answer,
                "Now"
            )
        );

        // =====================================================
        // SCROLL DOWN
        // =====================================================

        scrollPane.layout();

        scrollPane.setVvalue(
            1.0
        );
    }

    // =========================================================
    // USER MESSAGE
    // =========================================================

    private static HBox createUserMessage(
        String text
    ) {

        HBox row =
            new HBox();

        row.setAlignment(
            Pos.CENTER_RIGHT
        );

        Label message =
            new Label(
                text
            );

        message.setWrapText(
            true
        );

        message.setMaxWidth(
            270
        );

        message.setStyle(
            "-fx-background-color:#323c45;" +
            "-fx-text-fill:white;" +
            "-fx-padding:10px 14px;" +
            "-fx-background-radius:15px 15px 2px 15px;" +
            "-fx-font-size:12px;"
        );

        row.getChildren().add(
            message
        );

        return row;
    }

    // =========================================================
    // AI MESSAGE
    // =========================================================

    private static HBox createAIMessage(
        String text,
        String time
    ) {

        HBox row =
            new HBox(8);

        row.setAlignment(
            Pos.TOP_LEFT
        );

        Circle icon =
            new Circle(
                14,
                Color.web("#62ff96")
            );

        VBox messageBox =
            new VBox(3);

        Label message =
            new Label(
                text
            );

        message.setWrapText(
            true
        );

        message.setMaxWidth(
            280
        );

        message.setStyle(
            "-fx-background-color:#18232b;" +
            "-fx-text-fill:#dce3e7;" +
            "-fx-padding:10px 14px;" +
            "-fx-background-radius:2px 15px 15px 15px;" +
            "-fx-font-size:12px;"
        );

        Text timeText =
            new Text(
                time
            );

        timeText.setStyle(
            "-fx-font-size:8px;" +
            "-fx-fill:#687582;"
        );

        messageBox.getChildren().addAll(
            message,
            timeText
        );

        row.getChildren().addAll(
            icon,
            messageBox
        );

        return row;
    }

    // =========================================================
    // DEMO AI
    // =========================================================

    private static String generateAnswer(
        String question
    ) {

        String q =
            question.toLowerCase();

        if (
            q.contains("workout") ||
            q.contains("exercise")
        ) {

            return
                "Try a balanced workout with 5–10 minutes "
                + "of warm-up, followed by strength exercises. "
                + "Focus on proper form and progressive overload.";

        }

        if (
            q.contains("protein") ||
            q.contains("diet") ||
            q.contains("food")
        ) {

            return
                "Include protein-rich foods such as eggs, "
                + "paneer, dal, chicken, fish or Greek yogurt. "
                + "Combine them with vegetables, whole grains "
                + "and healthy fats.";

        }

        if (
            q.contains("calorie") ||
            q.contains("calories")
        ) {

            return
                "Your calorie requirement depends on your age, "
                + "height, weight and activity level. "
                + "For a proper calculation, use your FitVerse profile data.";

        }

        if (
            q.contains("muscle") ||
            q.contains("bulk")
        ) {

            return
                "For muscle gain, focus on progressive overload, "
                + "adequate protein, enough calories and good sleep.";

        }

        if (
            q.contains("weight") ||
            q.contains("fat")
        ) {

            return
                "For fat loss, maintain a moderate calorie deficit, "
                + "eat enough protein and combine strength training "
                + "with regular physical activity.";

        }

        return
            "That's a good question. Tell me more about your "
            + "fitness goal, current activity level and experience "
            + "so I can give you a more personalized answer.";
    }
}
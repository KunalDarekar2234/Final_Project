package com.visionx.view.trainer_login;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Chatbox {

    // =========================================================
    // SCENE
    // =========================================================

    private Scene chatboxScene;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#07100c";
    private final String CARD_BG = "#020914";
    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DIM = "rgba(117,255,158,0.10)";
    private final String BORDER = "rgba(255,255,255,0.10)";
    private final String TEXT_MAIN = "#e5eee4";
    private final String TEXT_MUTED = "#9caf9d";

    private final DropShadow glassShadow =
            new DropShadow(
                    24,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.38)
            );

    // =========================================================
    // STATE
    // =========================================================

    private VBox messageContainer;
    private Label selectedClientName;
    private Label selectedClientStatus;
    private Label selectedAvatar;
    private TextField messageField;
    private ScrollPane messageScroll;

    // Voice recording state
    private boolean recording = false;
    private int recordingSeconds = 0;
    private Timeline recordingTimeline;
    private Label recordingLabel;

    private TargetDataLine targetDataLine;
    private Thread recordingThread;
    private File currentVoiceFile;

    // Demo profile data.
    // Replace these values with your database/model values later.
    private final Map<String, String[]> profileData = new HashMap<>();

    public Chatbox() {
        seedProfileData();
    }

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getChatboxScene(Runnable callBackAction) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG_COLOR + ";" +
                "-fx-font-family:'Segoe UI';"
        );

        // Small top bar with a real back callback.
        HBox topBar = createTopBar(callBackAction);

        BorderPane chatLayout = new BorderPane();

        chatLayout.setPadding(
                new Insets(18, 22, 22, 22)
        );

        VBox header = createHeader();

        chatLayout.setTop(header);

        HBox chatArea = new HBox(14);

        VBox conversations = createConversationPanel();

        VBox chatWindow = createChatWindow();

        HBox.setHgrow(
                chatWindow,
                Priority.ALWAYS
        );

        chatArea.getChildren().addAll(
                conversations,
                chatWindow
        );

        chatLayout.setCenter(chatArea);

        root.setTop(topBar);
        root.setCenter(chatLayout);

        // Slightly smaller than the old 1160 x 900 scene.
        chatboxScene = new Scene(
                root,
                1160,
                760
        );

        return chatboxScene;
    }

    // =========================================================
    // TOP BAR / BACK
    // =========================================================

    private HBox createTopBar(Runnable callBackAction) {

        HBox bar = new HBox(12);

        bar.setPadding(
                new Insets(10, 18, 10, 18)
        );

        bar.setAlignment(
                Pos.CENTER_LEFT
        );

        bar.setStyle(
                "-fx-background-color:rgba(2,9,20,0.96);" +
                "-fx-border-color:transparent transparent " +
                BORDER +
                " transparent;"
        );

        Button back = new Button("‹  Back");

        back.setTooltip(
                new Tooltip("Return to previous page")
        );

        back.setOnAction(e -> {

            if (callBackAction != null) {

                callBackAction.run();

            } else {

                Window window =
                        bar.getScene() == null
                                ? null
                                : bar.getScene().getWindow();

                if (window != null) {
                    window.hide();
                }
            }
        });

        styleGhostButton(
                back,
                86
        );

        Label title = new Label(
                "Messages"
        );

        title.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label live = new Label(
                "●  Secure chat"
        );

        live.setStyle(
                "-fx-text-fill:" + PRIMARY + ";" +
                "-fx-background-color:" + PRIMARY_DIM + ";" +
                "-fx-background-radius:20;" +
                "-fx-padding:6 10;" +
                "-fx-font-size:11px;"
        );

        bar.getChildren().addAll(
                back,
                title,
                spacer,
                live
        );

        return bar;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private VBox createHeader() {

        VBox header = new VBox(3);

        header.setPadding(
                new Insets(0, 0, 12, 0)
        );

        Label title = new Label(
                "Chatbox"
        );

        title.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle = new Label(
                "Stay connected with your clients, share updates and keep their training on track."
        );

        subtitle.setStyle(
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-font-size:12px;"
        );

        header.getChildren().addAll(
                title,
                subtitle
        );

        return header;
    }

    // =========================================================
    // LEFT CONVERSATION PANEL
    // =========================================================

    private VBox createConversationPanel() {

        VBox panel = new VBox(12);

        panel.setPrefWidth(300);
        panel.setMinWidth(270);

        panel.setPadding(
                new Insets(16)
        );

        panel.setStyle(
                cardStyle()
        );

        panel.setEffect(
                glassShadow
        );

        // -----------------------------------------------------
        // Heading
        // -----------------------------------------------------

        HBox heading = new HBox();

        heading.setAlignment(
                Pos.CENTER_LEFT
        );

        Label title = new Label(
                "Messages"
        );

        title.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label count = new Label(
                "8"
        );

        count.setStyle(
                "-fx-text-fill:" + PRIMARY + ";" +
                "-fx-background-color:" + PRIMARY_DIM + ";" +
                "-fx-background-radius:20;" +
                "-fx-padding:4 9;" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;"
        );

        heading.getChildren().addAll(
                title,
                spacer,
                count
        );

        // -----------------------------------------------------
        // Search
        // -----------------------------------------------------

        TextField search = new TextField();

        search.setPromptText(
                "Search conversations..."
        );

        search.setPrefHeight(
                36
        );

        search.setStyle(
                inputStyle()
        );

        // -----------------------------------------------------
        // Client list
        // -----------------------------------------------------

        VBox clientList = new VBox(4);

        addConversation(
                clientList,
                "Alex Vance",
                "Can you update my workout plan?",
                "2m",
                "3",
                true
        );

        addConversation(
                clientList,
                "Sarah Jenkins",
                "Thank you for the session!",
                "18m",
                "",
                false
        );

        addConversation(
                clientList,
                "Mark Thompson",
                "I will be there tomorrow.",
                "42m",
                "1",
                false
        );

        addConversation(
                clientList,
                "Maya Wilson",
                "What time is our next session?",
                "1h",
                "",
                false
        );

        addConversation(
                clientList,
                "Daniel Carter",
                "My progress looks great.",
                "2h",
                "",
                false
        );

        addConversation(
                clientList,
                "Emily Stone",
                "Can you check my nutrition plan?",
                "3h",
                "2",
                false
        );

        addConversation(
                clientList,
                "Ryan Cooper",
                "See you on Monday.",
                "5h",
                "",
                false
        );

        addConversation(
                clientList,
                "Jessica Brown",
                "Thanks coach!",
                "Yesterday",
                "",
                false
        );

        search.textProperty().addListener(
                (obs, oldValue, newValue) -> {

                    String query =
                            newValue == null
                                    ? ""
                                    : newValue.trim().toLowerCase();

                    for (javafx.scene.Node node :
                            clientList.getChildren()) {

                        if (node.getUserData() instanceof String) {

                            String name =
                                    (String) node.getUserData();

                            boolean visible =
                                    query.isEmpty() ||
                                    name.toLowerCase().contains(query);

                            node.setVisible(
                                    visible
                            );

                            node.setManaged(
                                    visible
                            );
                        }
                    }
                }
        );

        // -----------------------------------------------------
        // LEFT SCROLL
        // -----------------------------------------------------

        ScrollPane scroll =
                new ScrollPane(
                        clientList
                );

        scroll.setFitToWidth(
                true
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setPrefViewportHeight(
                420
        );

        scroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-background:transparent;" +
                "-fx-border-color:transparent;" +
                "-fx-padding:0;"
        );

        VBox.setVgrow(
                scroll,
                Priority.ALWAYS
        );

        panel.getChildren().addAll(
                heading,
                search,
                scroll
        );

        javafx.application.Platform.runLater(
                () -> styleScrollBar(scroll)
        );

        return panel;
    }

    // =========================================================
    // SCROLLBAR - GREEN THUMB / DARK BACKGROUND
    // =========================================================

    private void styleScrollBar(ScrollPane scroll) {

        javafx.scene.Node verticalBar =
                scroll.lookup(
                        ".scroll-bar:vertical"
                );

        if (verticalBar instanceof javafx.scene.control.ScrollBar) {

            javafx.scene.control.ScrollBar bar =
                    (javafx.scene.control.ScrollBar) verticalBar;

            bar.setPrefWidth(8);
            bar.setMinWidth(8);
            bar.setMaxWidth(8);

            bar.setStyle(
                    "-fx-background-color:" +
                    CARD_BG +
                    ";" +
                    "-fx-background-radius:8;"
            );

            javafx.scene.Node thumb =
                    bar.lookup(
                            ".thumb"
                    );

            if (thumb != null) {

                thumb.setStyle(
                        "-fx-background-color:" +
                        PRIMARY +
                        ";" +
                        "-fx-background-radius:8;"
                );
            }
        }
    }

    // =========================================================
    // CONVERSATION ITEM
    // =========================================================

    private void addConversation(
            VBox parent,
            String name,
            String message,
            String time,
            String unread,
            boolean active
    ) {

        HBox item = new HBox(10);

        item.setPadding(
                new Insets(10, 8, 10, 8)
        );

        item.setAlignment(
                Pos.CENTER_LEFT
        );

        // Used by search.
        item.setUserData(
                name
        );

        String normalStyle =
                "-fx-background-color:transparent;" +
                "-fx-background-radius:12;" +
                "-fx-cursor:hand;";

        String activeStyle =
                "-fx-background-color:" +
                PRIMARY_DIM +
                ";" +
                "-fx-background-radius:12;" +
                "-fx-border-color:rgba(117,255,158,0.24);" +
                "-fx-border-radius:12;" +
                "-fx-cursor:hand;";

        item.setStyle(
                active
                        ? activeStyle
                        : normalStyle
        );

        // -----------------------------------------------------
        // Avatar
        // -----------------------------------------------------

        StackPane avatar =
                makeAvatar(
                        name.substring(0, 1),
                        40
                );

        // -----------------------------------------------------
        // Center
        // -----------------------------------------------------

        VBox center = new VBox(3);

        HBox.setHgrow(
                center,
                Priority.ALWAYS
        );

        HBox nameRow = new HBox();

        Label nameLabel =
                new Label(
                        name
                );

        nameLabel.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:12px;" +
                "-fx-font-weight:bold;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label timeLabel =
                new Label(
                        time
                );

        timeLabel.setStyle(
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-font-size:9px;"
        );

        nameRow.getChildren().addAll(
                nameLabel,
                spacer,
                timeLabel
        );

        Label messageLabel =
                new Label(
                        message
                );

        messageLabel.setMaxWidth(
                175
        );

        messageLabel.setEllipsisString(
                "..."
        );

        messageLabel.setStyle(
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-font-size:10px;"
        );

        center.getChildren().addAll(
                nameRow,
                messageLabel
        );

        item.getChildren().addAll(
                avatar,
                center
        );

        // -----------------------------------------------------
        // Unread
        // -----------------------------------------------------

        if (!unread.isEmpty()) {

            Label unreadLabel =
                    new Label(
                            unread
                    );

            unreadLabel.setStyle(
                    "-fx-text-fill:#003918;" +
                    "-fx-background-color:" +
                    PRIMARY +
                    ";" +
                    "-fx-background-radius:50;" +
                    "-fx-padding:3 6;" +
                    "-fx-font-size:8px;" +
                    "-fx-font-weight:bold;"
            );

            item.getChildren().add(
                    unreadLabel
            );
        }

        // -----------------------------------------------------
        // Hover
        // -----------------------------------------------------

        item.setOnMouseEntered(
                e -> {

                    if (!active) {

                        item.setStyle(
                                "-fx-background-color:rgba(255,255,255,0.035);" +
                                "-fx-background-radius:12;" +
                                "-fx-cursor:hand;"
                        );
                    }
                }
        );

        item.setOnMouseExited(
                e -> {

                    item.setStyle(
                            active
                                    ? activeStyle
                                    : normalStyle
                    );
                }
        );

        // -----------------------------------------------------
        // Click
        // -----------------------------------------------------

        item.setOnMouseClicked(
                e -> loadConversation(
                        name
                )
        );

        parent.getChildren().add(
                item
        );
    }

    // =========================================================
    // CHAT WINDOW
    // =========================================================

    private VBox createChatWindow() {

        VBox window = new VBox();

        window.setStyle(
                cardStyle()
        );

        window.setEffect(
                glassShadow
        );

        // -----------------------------------------------------
        // Chat header
        // -----------------------------------------------------

        HBox chatHeader = new HBox(12);

        chatHeader.setPadding(
                new Insets(14, 16, 14, 16)
        );

        chatHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        chatHeader.setStyle(
                "-fx-background-color:rgba(7,18,14,0.72);" +
                "-fx-border-color:transparent transparent " +
                BORDER +
                " transparent;" +
                "-fx-background-radius:18 18 0 0;"
        );

        StackPane avatar =
                makeAvatar(
                        "A",
                        42
                );

        selectedAvatar =
                (Label) avatar.getChildren().get(0);

        VBox userInfo = new VBox(2);

        selectedClientName =
                new Label(
                        "Alex Vance"
                );

        selectedClientName.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;"
        );

        selectedClientStatus =
                new Label(
                        "● Online"
                );

        selectedClientStatus.setStyle(
                "-fx-text-fill:" + PRIMARY + ";" +
                "-fx-font-size:10px;"
        );

        userInfo.getChildren().addAll(
                selectedClientName,
                selectedClientStatus
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // -----------------------------------------------------
        // VIDEO + PHONE
        // -----------------------------------------------------

        Button video =
                createIconButton(
                        "▣",
                        "Video call"
                );

        Button phone =
                createIconButton(
                        "☎",
                        "Phone call"
                );

        video.setOnAction(
                e -> showCallDialog(
                        "Video Call",
                        "Starting a video call with " +
                        selectedClientName.getText()
                )
        );

        phone.setOnAction(
                e -> showCallDialog(
                        "Phone Call",
                        "Calling " +
                        selectedClientName.getText()
                )
        );

        // -----------------------------------------------------
        // PROFILE
        // -----------------------------------------------------

        Button profile =
                new Button(
                        "View Profile"
                );

        styleGhostButton(
                profile,
                104
        );

        profile.setOnAction(
                e -> showClientProfile()
        );

        chatHeader.getChildren().addAll(
                avatar,
                userInfo,
                spacer,
                video,
                phone,
                profile
        );

        // -----------------------------------------------------
        // Messages
        // -----------------------------------------------------

        messageContainer =
                new VBox(12);

        messageContainer.setPadding(
                new Insets(20)
        );

        messageContainer.setStyle(
                "-fx-background-color:transparent;"
        );

        addDateChip(
                "Today"
        );

        addReceivedMessage(
                "Hi Coach! Can you update my workout plan for next week?",
                "9:42 PM"
        );

        addSentMessage(
                "Sure, Alex. I'll update it based on your current progress.",
                "9:43 PM"
        );

        addReceivedMessage(
                "Perfect. I'd also like to focus more on strength training.",
                "9:44 PM"
        );

        addSentMessage(
                "Absolutely. I'll add more compound movements and progressive overload.",
                "9:45 PM"
        );

        addReceivedMessage(
                "Thanks! Looking forward to the new plan.",
                "9:46 PM"
        );

        messageScroll =
                new ScrollPane(
                        messageContainer
                );

        messageScroll.setFitToWidth(
                true
        );

        messageScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        messageScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        messageScroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-background:transparent;" +
                "-fx-border-color:transparent;" +
                "-fx-padding:0;"
        );

        VBox.setVgrow(
                messageScroll,
                Priority.ALWAYS
        );

        // -----------------------------------------------------
        // Floating message composer
        // -----------------------------------------------------

        HBox inputArea =
                createMessageComposer();

        window.getChildren().addAll(
                chatHeader,
                messageScroll,
                inputArea
        );

        javafx.application.Platform.runLater(
                () -> {

                    styleScrollBar(
                            messageScroll
                    );

                    messageScroll.setVvalue(
                            1.0
                    );
                }
        );

        return window;
    }

    // =========================================================
    // MESSAGE COMPOSER
    // =========================================================

    private HBox createMessageComposer() {

        HBox wrapper =
                new HBox();

        wrapper.setPadding(
                new Insets(
                        10,
                        12,
                        12,
                        12
                )
        );

        wrapper.setAlignment(
                Pos.CENTER
        );

        wrapper.setStyle(
                "-fx-background-color:rgba(2,9,20,0.92);" +
                "-fx-border-color:" +
                BORDER +
                " transparent transparent transparent;"
        );

        HBox composer =
                new HBox(8);

        composer.setAlignment(
                Pos.CENTER_LEFT
        );

        composer.setPadding(
                new Insets(
                        6,
                        7,
                        6,
                        7
                )
        );

        composer.setStyle(
                "-fx-background-color:#0a1310;" +
                "-fx-background-radius:16;" +
                "-fx-border-color:rgba(117,255,158,0.12);" +
                "-fx-border-radius:16;"
        );

        composer.setEffect(
                new DropShadow(
                        18,
                        0,
                        5,
                        Color.color(0, 0, 0, 0.28)
                )
        );

        // -----------------------------------------------------
        // IMAGE UPLOAD - LEFT SIDE
        // -----------------------------------------------------

        Button attach =
                createIconButton(
                        "＋",
                        "Upload image"
                );

        attach.setOnAction(
                e -> uploadImage()
        );

        // -----------------------------------------------------
        // TEXT
        // -----------------------------------------------------

        messageField =
                new TextField();

        messageField.setPromptText(
                "Type a message..."
        );

        messageField.setPrefHeight(
                40
        );

        messageField.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;" +
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-prompt-text-fill:" + TEXT_MUTED + ";" +
                "-fx-font-size:12px;" +
                "-fx-padding:8 6;"
        );

        HBox.setHgrow(
                messageField,
                Priority.ALWAYS
        );

        // -----------------------------------------------------
        // RECORDING STATUS
        // -----------------------------------------------------

        recordingLabel =
                new Label(
                        ""
                );

        recordingLabel.setManaged(
                false
        );

        recordingLabel.setVisible(
                false
        );

        recordingLabel.setStyle(
                "-fx-text-fill:" + PRIMARY + ";" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;"
        );

        // -----------------------------------------------------
        // MIC - LEFT OF SEND
        // -----------------------------------------------------

        Button mic =
                createIconButton(
                        "●",
                        "Record voice note"
                );

        mic.setOnAction(
                e -> toggleRecording(
                        mic
                )
        );

        // -----------------------------------------------------
        // SEND
        // -----------------------------------------------------

        Button send =
                new Button(
                        "Send  ➤"
                );

        send.setPrefHeight(
                38
        );

        send.setStyle(
                "-fx-background-color:" + PRIMARY + ";" +
                "-fx-text-fill:#003918;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:11;" +
                "-fx-padding:7 15;" +
                "-fx-cursor:hand;"
        );

        send.setOnAction(
                e -> sendMessage()
        );

        messageField.setOnAction(
                e -> sendMessage()
        );

        composer.getChildren().addAll(
                attach,
                messageField,
                recordingLabel,
                mic,
                send
        );

        wrapper.getChildren().add(
                composer
        );

        return wrapper;
    }

    // =========================================================
    // ICON BUTTON
    // =========================================================

    private Button createIconButton(
            String icon,
            String tooltip
    ) {

        Button button =
                new Button(
                        icon
                );

        button.setMinSize(
                36,
                36
        );

        button.setPrefSize(
                36,
                36
        );

        button.setMaxSize(
                36,
                36
        );

        button.setTooltip(
                new Tooltip(
                        tooltip
                )
        );

        button.setStyle(
                "-fx-background-color:rgba(255,255,255,0.035);" +
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-background-radius:10;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:10;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );

        return button;
    }

    // =========================================================
    // DATE CHIP
    // =========================================================

    private void addDateChip(
            String text
    ) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER
        );

        Label chip =
                new Label(
                        text
                );

        chip.setStyle(
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-background-color:rgba(255,255,255,0.035);" +
                "-fx-background-radius:20;" +
                "-fx-padding:5 10;" +
                "-fx-font-size:9px;"
        );

        row.getChildren().add(
                chip
        );

        messageContainer.getChildren().add(
                row
        );
    }

    // =========================================================
    // RECEIVED MESSAGE
    // =========================================================

    private void addReceivedMessage(
            String message,
            String time
    ) {

        HBox row =
                new HBox(7);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label bubble =
                new Label(
                        message
                );

        bubble.setWrapText(
                true
        );

        bubble.setMaxWidth(
                460
        );

        bubble.setStyle(
                "-fx-background-color:#0b1512;" +
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-background-radius:14 14 14 4;" +
                "-fx-border-color:rgba(255,255,255,0.055);" +
                "-fx-border-radius:14 14 14 4;" +
                "-fx-padding:10 13;" +
                "-fx-font-size:12px;"
        );

        Label timestamp =
                new Label(
                        time
                );

        timestamp.setStyle(
                "-fx-text-fill:#6f8273;" +
                "-fx-font-size:8px;"
        );

        VBox stack =
                new VBox(
                        3,
                        bubble,
                        timestamp
                );

        row.getChildren().add(
                stack
        );

        messageContainer.getChildren().add(
                row
        );
    }

    // =========================================================
    // SENT MESSAGE
    // =========================================================

    private void addSentMessage(
            String message,
            String time
    ) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label bubble =
                new Label(
                        message
                );

        bubble.setWrapText(
                true
        );

        bubble.setMaxWidth(
                480
        );

        bubble.setStyle(
                "-fx-background-color:" + PRIMARY_DIM + ";" +
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-background-radius:14 14 4 14;" +
                "-fx-border-color:rgba(117,255,158,0.12);" +
                "-fx-border-radius:14 14 4 14;" +
                "-fx-padding:10 13;" +
                "-fx-font-size:12px;"
        );

        Label timestamp =
                new Label(
                        time +
                        "  ✓✓"
                );

        timestamp.setStyle(
                "-fx-text-fill:#7eaa89;" +
                "-fx-font-size:8px;"
        );

        VBox stack =
                new VBox(
                        3,
                        bubble,
                        timestamp
                );

        stack.setAlignment(
                Pos.CENTER_RIGHT
        );

        row.getChildren().add(
                stack
        );

        messageContainer.getChildren().add(
                row
        );
    }

    // =========================================================
    // IMAGE MESSAGE
    // =========================================================

    private void addImageMessage(
            File file
    ) {

        if (file == null) {
            return;
        }

        Image image =
                new Image(
                        file.toURI().toString(),
                        260,
                        190,
                        true,
                        true
                );

        ImageView imageView =
                new ImageView(
                        image
                );

        imageView.setFitWidth(
                260
        );

        imageView.setFitHeight(
                190
        );

        imageView.setPreserveRatio(
                true
        );

        StackPane imageCard =
                new StackPane(
                        imageView
                );

        imageCard.setPadding(
                new Insets(4)
        );

        imageCard.setStyle(
                "-fx-background-color:" +
                PRIMARY_DIM +
                ";" +
                "-fx-background-radius:14;"
        );

        Label name =
                new Label(
                        file.getName()
                );

        name.setStyle(
                "-fx-text-fill:#7eaa89;" +
                "-fx-font-size:8px;"
        );

        VBox stack =
                new VBox(
                        4,
                        imageCard,
                        name
                );

        stack.setAlignment(
                Pos.CENTER_RIGHT
        );

        HBox row =
                new HBox(
                        stack
                );

        row.setAlignment(
                Pos.CENTER_RIGHT
        );

        messageContainer.getChildren().add(
                row
        );

        javafx.application.Platform.runLater(
                () -> messageScroll.setVvalue(1.0)
        );
    }

    // =========================================================
    // SEND
    // =========================================================

    private void sendMessage() {

        if (messageField == null) {
            return;
        }

        String text =
                messageField.getText() == null
                        ? ""
                        : messageField.getText().trim();

        if (text.isEmpty()) {
            return;
        }

        addSentMessage(
                text,
                "Now"
        );

        messageField.clear();

        javafx.application.Platform.runLater(
                () -> messageScroll.setVvalue(1.0)
        );
    }

    // =========================================================
    // IMAGE UPLOAD
    // =========================================================

    private void uploadImage() {

        FileChooser chooser =
                new FileChooser();

        chooser.setTitle(
                "Upload image"
        );

        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Image Files",
                        "*.png",
                        "*.jpg",
                        "*.jpeg",
                        "*.gif",
                        "*.webp"
                )
        );

        Window owner =
                chatboxScene == null
                        ? null
                        : chatboxScene.getWindow();

        File selected =
                chooser.showOpenDialog(
                        owner
                );

        if (selected != null) {
            addImageMessage(
                    selected
            );
        }
    }

    // =========================================================
    // VOICE RECORDING
    // =========================================================

    private void toggleRecording(
            Button mic
    ) {

        if (!recording) {

            startRecording(
                    mic
            );

        } else {

            stopRecording(
                    mic
            );
        }
    }

    private void startRecording(
            Button mic
    ) {

        AudioFormat format =
                new AudioFormat(
                        44100.0f,
                        16,
                        1,
                        true,
                        true
                );

        DataLine.Info info =
                new DataLine.Info(
                        TargetDataLine.class,
                        format
                );

        try {

            targetDataLine =
                    (TargetDataLine)
                            AudioSystem.getLine(
                                    info
                            );

            targetDataLine.open(
                    format
            );

            targetDataLine.start();

            currentVoiceFile =
                    File.createTempFile(
                            "fitnessfreak_voice_",
                            ".wav"
                    );

            recording = true;
            recordingSeconds = 0;

            recordingLabel.setManaged(
                    true
            );

            recordingLabel.setVisible(
                    true
            );

            recordingLabel.setText(
                    "●  Recording 0:00"
            );

            mic.setText(
                    "■"
            );

            mic.setStyle(
                    "-fx-background-color:rgba(255,80,80,0.12);" +
                    "-fx-text-fill:#ff7d7d;" +
                    "-fx-background-radius:10;" +
                    "-fx-border-color:rgba(255,80,80,0.25);" +
                    "-fx-border-radius:10;" +
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-cursor:hand;"
            );

            recordingThread =
                    new Thread(
                            () -> {

                                try (
                                        AudioInputStream audioStream =
                                                new AudioInputStream(
                                                        targetDataLine
                                                )
                                ) {

                                    AudioSystem.write(
                                            audioStream,
                                            AudioFileFormat.Type.WAVE,
                                            currentVoiceFile
                                    );

                                } catch (IOException ex) {

                                    javafx.application.Platform.runLater(
                                            () -> showInfo(
                                                    "Voice Note",
                                                    "The recording could not be saved.\n" +
                                                    ex.getMessage()
                                            )
                                    );
                                }
                            },
                            "VoiceRecorder"
                    );

            recordingThread.setDaemon(
                    true
            );

            recordingThread.start();

            recordingTimeline =
                    new Timeline(
                            new KeyFrame(
                                    Duration.seconds(1),
                                    e -> {

                                        recordingSeconds++;

                                        int minutes =
                                                recordingSeconds / 60;

                                        int seconds =
                                                recordingSeconds % 60;

                                        recordingLabel.setText(
                                                String.format(
                                                        "●  Recording %d:%02d",
                                                        minutes,
                                                        seconds
                                                )
                                        );
                                    }
                            )
                    );

            recordingTimeline.setCycleCount(
                    Timeline.INDEFINITE
            );

            recordingTimeline.play();

        } catch (
                LineUnavailableException |
                IOException ex
        ) {

            recording = false;

            showInfo(
                    "Microphone unavailable",
                    "Java could not access the microphone.\n\n" +
                    "Check your system microphone permission and audio device.\n\n" +
                    ex.getMessage()
            );
        }
    }

    private void stopRecording(
            Button mic
    ) {

        if (!recording) {
            return;
        }

        recording = false;

        if (recordingTimeline != null) {

            recordingTimeline.stop();

            recordingTimeline = null;
        }

        if (targetDataLine != null) {

            targetDataLine.stop();
            targetDataLine.close();

            targetDataLine = null;
        }

        recordingLabel.setManaged(
                false
        );

        recordingLabel.setVisible(
                false
        );

        mic.setText(
                "●"
        );

        mic.setStyle(
                "-fx-background-color:rgba(255,255,255,0.035);" +
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-background-radius:10;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:10;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );

        File finishedFile =
                currentVoiceFile;

        int duration =
                Math.max(
                        recordingSeconds,
                        1
                );

        Thread writer =
                recordingThread;

        new Thread(
                () -> {

                    try {

                        if (writer != null) {
                            writer.join(1500);
                        }

                    } catch (InterruptedException ex) {

                        Thread.currentThread().interrupt();
                    }

                    javafx.application.Platform.runLater(
                            () -> {

                                if (
                                        finishedFile != null &&
                                        finishedFile.exists()
                                ) {

                                    addVoiceNoteBubble(
                                            finishedFile,
                                            duration
                                    );

                                } else {

                                    showInfo(
                                            "Voice Note",
                                            "The recording stopped, but no audio file was created."
                                    );
                                }
                            }
                    );

                },
                "VoiceRecorderFinalize"
        ).start();
    }

    // =========================================================
    // VOICE NOTE BUBBLE + PLAYBACK
    // =========================================================

    private void addVoiceNoteBubble(
            File audioFile,
            int seconds
    ) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button play =
                new Button(
                        "▶  Voice note  " +
                        formatTime(seconds)
                );

        play.setStyle(
                "-fx-background-color:" + PRIMARY_DIM + ";" +
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-background-radius:14;" +
                "-fx-border-color:rgba(117,255,158,0.12);" +
                "-fx-border-radius:14;" +
                "-fx-padding:10 14;" +
                "-fx-font-size:11px;" +
                "-fx-cursor:hand;"
        );

        final Clip[] clipHolder =
                new Clip[1];

        play.setOnAction(
                e -> {

                    try {

                        if (
                                clipHolder[0] != null &&
                                clipHolder[0].isRunning()
                        ) {

                            clipHolder[0].stop();

                            play.setText(
                                    "▶  Voice note  " +
                                    formatTime(seconds)
                            );

                            return;
                        }

                        AudioInputStream audioInputStream =
                                AudioSystem.getAudioInputStream(
                                        audioFile
                                );

                        Clip clip =
                                AudioSystem.getClip();

                        clip.open(
                                audioInputStream
                        );

                        clipHolder[0] =
                                clip;

                        clip.start();

                        play.setText(
                                "❚❚  Playing  " +
                                formatTime(seconds)
                        );

                        clip.addLineListener(
                                event -> {

                                    if (!clip.isRunning()) {

                                        javafx.application.Platform.runLater(
                                                () -> play.setText(
                                                        "▶  Voice note  " +
                                                        formatTime(seconds)
                                                )
                                        );

                                        clip.close();
                                    }
                                }
                        );

                    } catch (Exception ex) {

                        showInfo(
                                "Voice Note",
                                "Unable to play the recording.\n" +
                                ex.getMessage()
                        );
                    }
                }
        );

        row.getChildren().add(
                play
        );

        messageContainer.getChildren().add(
                row
        );

        javafx.application.Platform.runLater(
                () -> messageScroll.setVvalue(1.0)
        );
    }

    private String formatTime(
            int seconds
    ) {

        return String.format(
                "%d:%02d",
                seconds / 60,
                seconds % 60
        );
    }

    // =========================================================
    // VIEW PROFILE
    // =========================================================

    private void showClientProfile() {

        String name =
                selectedClientName == null
                        ? "Alex Vance"
                        : selectedClientName.getText();

        String[] data =
                profileData.getOrDefault(
                        name,
                        new String[]{
                                "Not provided",
                                "Not specified",
                                "Not specified",
                                "Not provided",
                                "Not provided"
                        }
                );

        Dialog<Void> dialog =
                new Dialog<>();

        dialog.initModality(
                Modality.WINDOW_MODAL
        );

        if (
                chatboxScene != null &&
                chatboxScene.getWindow() != null
        ) {

            dialog.initOwner(
                    chatboxScene.getWindow()
            );
        }

        dialog.setTitle(
                name + " - Profile"
        );

        dialog.setHeaderText(
                null
        );

        VBox content =
                new VBox(14);

        content.setPadding(
                new Insets(20)
        );

        content.setPrefWidth(
                410
        );

        content.setStyle(
                "-fx-background-color:" +
                CARD_BG +
                ";" +
                "-fx-background-radius:18;"
        );

        // -----------------------------------------------------
        // Identity
        // -----------------------------------------------------

        HBox identity =
                new HBox(12);

        identity.setAlignment(
                Pos.CENTER_LEFT
        );

        StackPane avatar =
                makeAvatar(
                        name.isEmpty()
                                ? "?"
                                : name.substring(0, 1),
                        54
                );

        VBox identityText =
                new VBox(3);

        Label nameLabel =
                new Label(
                        name
                );

        nameLabel.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;"
        );

        Label status =
                new Label(
                        "● Online"
                );

        status.setStyle(
                "-fx-text-fill:" + PRIMARY + ";" +
                "-fx-font-size:10px;"
        );

        identityText.getChildren().addAll(
                nameLabel,
                status
        );

        identity.getChildren().addAll(
                avatar,
                identityText
        );

        Separator separator =
                new Separator();

        separator.setStyle(
                "-fx-opacity:0.12;"
        );

        VBox details =
                new VBox(9);

        details.getChildren().addAll(
                profileRow(
                        "Goal / Focus",
                        data[0]
                ),
                profileRow(
                        "Current Plan",
                        data[1]
                ),
                profileRow(
                        "Next Session",
                        data[2]
                ),
                profileRow(
                        "Email",
                        data[3]
                ),
                profileRow(
                        "Phone",
                        data[4]
                )
        );

        Label note =
                new Label(
                        "Profile data shown here uses the values available in this chat demo. " +
                        "Connect this view to your client database/model for live data."
                );

        note.setWrapText(
                true
        );

        note.setStyle(
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-font-size:9px;"
        );

        content.getChildren().addAll(
                identity,
                separator,
                details,
                note
        );

        dialog.getDialogPane().setContent(
                content
        );

        dialog.getDialogPane().getButtonTypes().add(
                ButtonType.CLOSE
        );

        dialog.getDialogPane().setStyle(
                "-fx-background-color:" +
                CARD_BG +
                ";" +
                "-fx-border-color:rgba(117,255,158,0.15);" +
                "-fx-border-radius:18;"
        );

        dialog.getDialogPane()
                .lookupButton(
                        ButtonType.CLOSE
                )
                .setStyle(
                        "-fx-background-color:" + PRIMARY + ";" +
                        "-fx-text-fill:#003918;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:9;"
                );

        dialog.showAndWait();
    }

    private HBox profileRow(
            String label,
            String value
    ) {

        HBox row =
                new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label left =
                new Label(
                        label
                );

        left.setPrefWidth(
                105
        );

        left.setStyle(
                "-fx-text-fill:" + TEXT_MUTED + ";" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;"
        );

        Label right =
                new Label(
                        value
                );

        right.setWrapText(
                true
        );

        right.setStyle(
                "-fx-text-fill:" + TEXT_MAIN + ";" +
                "-fx-font-size:11px;"
        );

        HBox.setHgrow(
                right,
                Priority.ALWAYS
        );

        row.getChildren().addAll(
                left,
                right
        );

        return row;
    }

    // =========================================================
    // VIDEO / PHONE ACTION
    // =========================================================

    private void showCallDialog(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        if (
                chatboxScene != null &&
                chatboxScene.getWindow() != null
        ) {

            alert.initOwner(
                    chatboxScene.getWindow()
            );
        }

        alert.setTitle(
                title
        );

        alert.setHeaderText(
                title
        );

        alert.setContentText(
                message +
                "\n\nConnect your WebRTC/telephony service here for the real call."
        );

        alert.showAndWait();
    }

    private void showInfo(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        if (
                chatboxScene != null &&
                chatboxScene.getWindow() != null
        ) {

            alert.initOwner(
                    chatboxScene.getWindow()
            );
        }

        alert.setTitle(
                title
        );

        alert.setHeaderText(
                title
        );

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }

    // =========================================================
    // AVATAR
    // =========================================================

    private StackPane makeAvatar(
            String text,
            double size
    ) {

        StackPane avatar =
                new StackPane();

        avatar.setMinSize(
                size,
                size
        );

        avatar.setPrefSize(
                size,
                size
        );

        avatar.setMaxSize(
                size,
                size
        );

        avatar.setStyle(
                "-fx-background-color:" +
                PRIMARY_DIM +
                ";" +
                "-fx-background-radius:50;" +
                "-fx-border-color:rgba(117,255,158,0.08);" +
                "-fx-border-radius:50;"
        );

        Label label =
                new Label(
                        text
                );

        label.setStyle(
                "-fx-text-fill:" + PRIMARY + ";" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:" +
                Math.max(
                        14,
                        size * 0.38
                ) +
                "px;"
        );

        avatar.getChildren().add(
                label
        );

        return avatar;
    }

    // =========================================================
    // STYLES
    // =========================================================

    private String cardStyle() {

        return
                "-fx-background-color:" +
                CARD_BG +
                ";" +
                "-fx-background-radius:18;" +
                "-fx-border-color:" +
                BORDER +
                ";" +
                "-fx-border-radius:18;";
    }

    private String inputStyle() {

        return
                "-fx-background-color:rgba(255,255,255,0.035);" +
                "-fx-border-color:" +
                BORDER +
                ";" +
                "-fx-border-radius:10;" +
                "-fx-background-radius:10;" +
                "-fx-text-fill:" +
                TEXT_MAIN +
                ";" +
                "-fx-prompt-text-fill:" +
                TEXT_MUTED +
                ";" +
                "-fx-padding:8 12;" +
                "-fx-font-size:11px;";
    }

    private void styleGhostButton(
            Button button,
            double width
    ) {

        button.setMinWidth(
                width
        );

        button.setPrefHeight(
                34
        );

        button.setStyle(
                "-fx-background-color:rgba(255,255,255,0.035);" +
                "-fx-border-color:" +
                BORDER +
                ";" +
                "-fx-border-radius:9;" +
                "-fx-background-radius:9;" +
                "-fx-text-fill:" +
                TEXT_MUTED +
                ";" +
                "-fx-font-size:10px;" +
                "-fx-padding:6 12;" +
                "-fx-cursor:hand;"
        );
    }

    // =========================================================
    // DEMO PROFILE DATA
    // =========================================================

    private void seedProfileData() {

        profileData.put(
                "Alex Vance",
                new String[]{
                        "Strength training",
                        "Workout plan - current progress",
                        "Not provided",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Sarah Jenkins",
                new String[]{
                        "Not specified",
                        "Not provided",
                        "Tomorrow, 6:00 PM",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Mark Thompson",
                new String[]{
                        "Not specified",
                        "Workout ready",
                        "Tomorrow",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Maya Wilson",
                new String[]{
                        "Not specified",
                        "Not provided",
                        "Thursday, 5:00 PM",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Daniel Carter",
                new String[]{
                        "Not specified",
                        "Not provided",
                        "Not provided",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Emily Stone",
                new String[]{
                        "Nutrition / training",
                        "Nutrition plan",
                        "Not provided",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Ryan Cooper",
                new String[]{
                        "Not specified",
                        "Not provided",
                        "Monday",
                        "Not provided",
                        "Not provided"
                }
        );

        profileData.put(
                "Jessica Brown",
                new String[]{
                        "Not specified",
                        "Not provided",
                        "Not provided",
                        "Not provided",
                        "Not provided"
                }
        );
    }

    // =========================================================
    // LOAD CONVERSATION
    // =========================================================

    private void loadConversation(
            String clientName
    ) {

        if (selectedClientName != null) {

            selectedClientName.setText(
                    clientName
            );
        }

        if (
                selectedAvatar != null &&
                !clientName.isEmpty()
        ) {

            selectedAvatar.setText(
                    clientName.substring(0, 1)
            );
        }

        if (selectedClientStatus != null) {

            selectedClientStatus.setText(
                    "● Online"
            );
        }

        if (messageContainer == null) {
            return;
        }

        messageContainer.getChildren().clear();

        addDateChip(
                "Today"
        );

        if (
                clientName.equals(
                        "Sarah Jenkins"
                )
        ) {

            addReceivedMessage(
                    "Hi Coach! I wanted to ask about my next training session.",
                    "9:30 PM"
            );

            addSentMessage(
                    "Your session is scheduled for tomorrow at 6 PM.",
                    "9:31 PM"
            );

            addReceivedMessage(
                    "Thank you for the session!",
                    "9:32 PM"
            );

        } else if (
                clientName.equals(
                        "Mark Thompson"
                )
        ) {

            addReceivedMessage(
                    "I will be there tomorrow.",
                    "8:42 PM"
            );

            addSentMessage(
                    "Great! I'll have your workout ready.",
                    "8:43 PM"
            );

        } else if (
                clientName.equals(
                        "Maya Wilson"
                )
        ) {

            addReceivedMessage(
                    "What time is our next session?",
                    "7:10 PM"
            );

            addSentMessage(
                    "Your next session is scheduled for Thursday at 5 PM.",
                    "7:11 PM"
            );

        } else {

            addReceivedMessage(
                    "Hi Coach! Can you update my workout plan for next week?",
                    "9:42 PM"
            );

            addSentMessage(
                    "Sure, I'll update it based on your current progress.",
                    "9:43 PM"
            );

            addReceivedMessage(
                    "Perfect. I'd also like to focus more on strength training.",
                    "9:44 PM"
            );

            addSentMessage(
                    "Absolutely. I'll add more compound movements and progressive overload.",
                    "9:45 PM"
            );
        }

        javafx.application.Platform.runLater(
                () -> messageScroll.setVvalue(1.0)
        );
    }

    // =========================================================
    // NO-ARGUMENT VERSION
    // =========================================================

    public Scene getChatboxScene() {

        return getChatboxScene(
                null
        );
    }
}
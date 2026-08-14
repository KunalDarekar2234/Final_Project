// package com.visionx.view;

// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.Region;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;

// public class AiMentorView {

//     private Scene aiMentorScene;

//     public Scene getAiMentorScene(Runnable callBackAction) {

//         // Root Container: 3 Columns (Sidebar, History, Chat)
//         HBox root = new HBox();
//         root.setStyle(
//             "-fx-background-color: #080C14;"
//         );

//         // ==========================================
//         // 1. LEFT SIDEBAR (Navigation)
//         // ==========================================
//         // VBox sidebar = new VBox(25);
//         // sidebar.setPrefWidth(240);
//         // sidebar.setStyle("-fx-background-color : #16191b; -fx-padding: 30px 20px 20px 20px;");

//         // // Logo
//         // Text logoTxt = new Text("FitVerse AI");
//         // logoTxt.setStyle("-fx-font-size:24px; -fx-font-weight:bold; -fx-fill: #62ff96;");

//         // // Profile Box
//         // HBox profileBox = new HBox(12);
//         // profileBox.setStyle("-fx-background-color: #212428; -fx-background-radius: 12px; -fx-padding: 10px; -fx-border-color: #2a2d31; -fx-border-radius: 12px;");
//         // profileBox.setAlignment(Pos.CENTER_LEFT);
//         // Circle avatar = new Circle(18, Color.web("#3a3d41")); // Avatar Placeholder
//         // VBox profileTexts = new VBox(2);
//         // Text pName = new Text("FitVerse Admin");
//         // pName.setStyle("-fx-font-size:13px; -fx-font-weight:bold; -fx-fill: #ffffff;");
//         // Text pRole = new Text("PRO ATHLETE ACCOUNT");
//         // pRole.setStyle("-fx-font-size:9px; -fx-font-weight:bold; -fx-fill: #8a8d91;");
//         // profileTexts.getChildren().addAll(pName, pRole);
//         // profileBox.getChildren().addAll(avatar, profileTexts);

//         // // Navigation Menu
//         // VBox navMenu = new VBox(5);
//         // navMenu.getChildren().addAll(
//         //     createNavButton("Dashboard", false),
//         //     createNavButton("Analytics", false),
//         //     createNavButton("AI Mentor", true),
//         //     createNavButton("Planner", false),
//         //     createNavButton("Find Gym", false),
//         //     createNavButton("Settings", false)
//         // );

//         // Region sideSpacer = new Region();
//         // VBox.setVgrow(sideSpacer, Priority.ALWAYS);

//         // // Upgrade Button
//         // Button upgradeBtn = new Button("Upgrade to Pro");
//         // upgradeBtn.setStyle("-fx-background-color: #62ff96; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 20px; -fx-padding: 12px;");
//         // upgradeBtn.setMaxWidth(Double.MAX_VALUE);

//         // sidebar.getChildren().addAll(logoTxt, profileBox, navMenu, sideSpacer, upgradeBtn);

//         // ==========================================
//         // 2. MIDDLE COLUMN (Recent Sessions)
//         // ==========================================
//         VBox historyCol = new VBox(20);
//         historyCol.setPrefWidth(300);
//         historyCol.setMinWidth(300);
//         historyCol.setMaxWidth(300);

//         historyCol.setStyle(
//             "-fx-background-color: #11161A;" +
//             "-fx-border-color: transparent #2a2d31 transparent transparent;" +
//             "-fx-border-width: 0 1px 0 0;"
//         );

//         // Top Padded Area
//         VBox historyTop = new VBox(20);
//         historyTop.setStyle("-fx-padding: 30px 20px 0 20px;");
        
//         Button newSessionBtn = new Button("+ New Mentorship Session");
//         newSessionBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-color: #3a3d41; -fx-border-radius: 12px; -fx-padding: 10px; -fx-font-size: 13px;");
//         newSessionBtn.setMaxWidth(Double.MAX_VALUE);

//         Text recentLabel = new Text("RECENT SESSIONS");
//         recentLabel.setStyle("-fx-font-size:10px; -fx-font-weight:bold; -fx-fill: #8a8d91; -fx-letter-spacing: 1px;");

//         historyTop.getChildren().addAll(newSessionBtn, recentLabel);

//         // List of Sessions
//         VBox sessionList = new VBox(10);
//         sessionList.setStyle("-fx-padding: 0 20px 0 20px;");
//         sessionList.getChildren().addAll(
//             createHistoryItem("14:20 TODAY", "Macros for Lean Bulking", "Analyzing your protein intake...", true),
//             createHistoryItem("YESTERDAY", "Leg Day Optimization", "Squat form and progression...", false),
//             createHistoryItem("OCT 24", "Post-Injury Recovery Plan", "Mobility exercises for ankle...", false)
//         );

//         Region historySpacer = new Region();
//         VBox.setVgrow(historySpacer, Priority.ALWAYS);

//         // Footer Intelligence Indicator
//         HBox historyFooter = new HBox(8);
//         historyFooter.setStyle("-fx-padding: 20px; -fx-border-color: #2a2d31 transparent transparent transparent; -fx-border-width: 1px 0 0 0;");
//         historyFooter.setAlignment(Pos.CENTER_LEFT);
//         Circle boltIcon = new Circle(10, Color.web("#62ff96")); // Simulated Lightning Bolt
//         Text verText = new Text("Active Intelligence v4.2");
//         verText.setStyle("-fx-font-size:11px; -fx-font-weight:bold; -fx-fill: #8a8d91;");
//         historyFooter.getChildren().addAll(boltIcon, verText);

//         historyCol.getChildren().addAll(historyTop, sessionList, historySpacer, historyFooter);

//         // ==========================================
//         // 3. RIGHT COLUMN (Chat Canvas)
//         // ==========================================
//         BorderPane chatArea = new BorderPane();
//         chatArea.setStyle("-fx-background-color : #080C14;");
//         HBox.setHgrow(chatArea, Priority.ALWAYS);

//         // Chat Header
//         HBox chatHeader = new HBox();
//         chatHeader.setStyle("-fx-padding: 25px 40px; -fx-border-color: transparent transparent #2a2d31 transparent; -fx-border-width: 0 0 1px 0; -fx-background-color: #11161A");
//         chatHeader.setAlignment(Pos.CENTER_LEFT);
        
//         Circle aiAvatar = new Circle(20, Color.web("rgba(98,255,150,0.1)")); // AI Icon placeholder
//         aiAvatar.setStroke(Color.web("#2a2d31"));
        
//         VBox aiTitles = new VBox(2);
//         aiTitles.setPadding(new Insets(0, 0, 0, 15));
//         HBox titleRow = new HBox(8);
//         titleRow.setAlignment(Pos.CENTER_LEFT);
//         Text aiName = new Text("AI Mentor");
//         aiName.setStyle("-fx-font-size:20px; -fx-font-weight:bold; -fx-fill: #ffffff;");
//         Circle onlineDot = new Circle(4, Color.web("#62ff96"));
//         titleRow.getChildren().addAll(aiName, onlineDot);
//         Text aiSub = new Text("Expert Digital Coach • Always Online");
//         aiSub.setStyle("-fx-font-size:12px; -fx-fill: #8a8d91;");
//         aiTitles.getChildren().addAll(titleRow, aiSub);

//         Region headerSpacer = new Region();
//         HBox.setHgrow(headerSpacer, Priority.ALWAYS);

//         Button shareBtn = new Button("↑"); // Placeholder for share icon
//         shareBtn.setStyle("-fx-background-color: #212428; -fx-text-fill: #fff; -fx-background-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px;");
//         Button infoBtn = new Button("i"); // Placeholder for info icon
//         infoBtn.setStyle("-fx-background-color: #212428; -fx-text-fill: #fff; -fx-background-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px; -fx-font-family: serif;");
//         HBox headerActions = new HBox(10, shareBtn, infoBtn);

//         chatHeader.getChildren().addAll(aiAvatar, aiTitles, headerSpacer, headerActions);
//         chatArea.setTop(chatHeader);

//         // Chat Messages Stream
//         VBox messageStream = new VBox(30);
//         messageStream.setStyle("-fx-padding: 30px 40px;");
        
//         // AI Intro Message (cut off top)
//         VBox aiIntro = createAiMessage(
//             "capitalize on this energy. Shall we outline the routine?", 
//             "14:15 PM"
//         );

//         // User Message
//         VBox userMsg = createUserMessage(
//             "Sounds good. My left knee has been a bit stiff lately though, so maybe let's avoid heavy squats today? Can we do some alternatives?", 
//             "14:17 PM"
//         );

//         // AI Response with Complex Card
//         VBox aiResponse = createAiMessageWithCard(
//             "Acknowledged. We will prioritize joint longevity. I've swapped heavy back squats for high-rep Romanian Deadlifts and Bulgarian Split Squats to focus on unilateral stability without compression load.", 
//             "14:20 PM"
//         );

//         messageStream.getChildren().addAll(aiIntro, userMsg, aiResponse);
        
//         ScrollPane chatScroll = new ScrollPane(messageStream);
//         chatScroll.setStyle("-fx-background: #111415; -fx-border-color: transparent;");
//         chatScroll.setFitToWidth(true);
//         chatArea.setCenter(chatScroll);

//         // Chat Input Footer
//         VBox chatFooter = new VBox(15);
//         chatFooter.setStyle("-fx-padding: 20px 40px 30px 40px;");

//         // Suggestions
//         // Input Field
//         // TextField queryField = new TextField();
//         // queryField.setPromptText("Type your fitness query...");
//         // queryField.setStyle(
//         //     "-fx-background-color: transparent; " +
//         //     "-fx-text-fill: #ffffff; " +
//         //     "-fx-font-size: 14px;"
//         // );

//         // HBox.setHgrow(queryField, Priority.ALWAYS);

//         // ==========================================
//         // INPUT FIELD
//         // ==========================================

//         HBox inputBox = new HBox(15);

//         inputBox.setStyle(
//             "-fx-background-color: #1a1e22;" +
//             "-fx-background-radius: 30px;" +
//             "-fx-padding: 8px 10px 8px 25px;" +
//             "-fx-border-color: #2a2d31;" +
//             "-fx-border-radius: 30px;"
//         );

//         inputBox.setAlignment(Pos.CENTER_LEFT);


//         // TextField
//         TextField queryField = new TextField();

//         queryField.setPromptText("Type your fitness query...");

//         queryField.setStyle(
//             "-fx-background-color: transparent;" +
//             "-fx-text-fill: #ffffff;" +
//             "-fx-prompt-text-fill: #8a8d91;" +
//             "-fx-font-size: 14px;"
//         );

//         HBox.setHgrow(queryField, Priority.ALWAYS);


//         // Microphone button
//         Button micBtn = new Button("🎤");

//         micBtn.setStyle(
//             "-fx-background-color: transparent;" +
//             "-fx-text-fill: #8a8d91;" +
//             "-fx-font-size: 16px;"
//         );


//         // Send button
//         Button sendBtn = new Button("✓");

//         sendBtn.setStyle(
//             "-fx-background-color: rgba(98,255,150,0.1);" +
//             "-fx-text-fill: #62ff96;" +
//             "-fx-background-radius: 50%;" +
//             "-fx-min-width: 40px;" +
//             "-fx-min-height: 40px;" +
//             "-fx-border-color: #62ff96;" +
//             "-fx-border-radius: 50%;"
//         );

//         // Suggestions
//         HBox suggestions = new HBox(10);

//         Button suggestion1 = createSuggestionBtn("Suggest a leg workout");
//         Button suggestion2 = createSuggestionBtn("Analyze my calories");
//         Button suggestion3 = createSuggestionBtn("Review HRV trend");

//         suggestions.getChildren().addAll(
//             suggestion1,
//             suggestion2,
//             suggestion3
//         );


//         // Suggestion click actions
//         suggestion1.setOnAction(e -> {
//             queryField.setText("Suggest a leg workout");
//             queryField.requestFocus();
//         });

//         suggestion2.setOnAction(e -> {
//             queryField.setText("Analyze my calories");
//             queryField.requestFocus();
//         });

//         suggestion3.setOnAction(e -> {
//             queryField.setText("Review my HRV trend");
//             queryField.requestFocus();
//         });

//         // Input Field Area
//         // HBox inputBox = new HBox(15);
//         // inputBox.setStyle("-fx-background-color: #1a1d21; -fx-background-radius: 30px; -fx-padding: 8px 10px 8px 25px; -fx-border-color: #2a2d31; -fx-border-radius: 30px;");
//         // inputBox.setAlignment(Pos.CENTER_LEFT);
        
//         // TextField queryField = new TextField();
//         // queryField.setPromptText("Type your fitness query...");
//         // queryField.setStyle("-fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-font-size: 14px;");
//         // HBox.setHgrow(queryField, Priority.ALWAYS);

//         // Button micBtn = new Button("🎤"); // Placeholder for mic
//         // micBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 16px;");
//         // Button sendBtn = new Button("✓"); // Placeholder for send/magic icon
//         // sendBtn.setStyle("-fx-background-color: rgba(98,255,150,0.1); -fx-text-fill: #62ff96; -fx-background-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px; -fx-border-color: #62ff96; -fx-border-radius: 50%;");
        
//         sendBtn.setOnAction(e -> {

//             String question = queryField.getText().trim();

//             if (!question.isEmpty()) {

//                 // User question chat मध्ये add कर
//                 VBox userQuestion = createUserMessage(
//                     question,
//                     "Now"
//                 );

//                 messageStream.getChildren().add(userQuestion);

//                 // Input clear
//                 queryField.clear();

//                 // Chat bottom ला scroll
//                 chatScroll.layout();

//                 chatScroll.setVvalue(1.0);
//             }
//         });

//         inputBox.getChildren().addAll(queryField, micBtn, sendBtn);

//         Text disclaimer = new Text("FITVERSE AI MENTOR CAN MAKE MISTAKES. CHECK IMPORTANT INFORMATION.");
//         disclaimer.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-fill: #3a3d41; -fx-letter-spacing: 1px;");
//         HBox disclaimerBox = new HBox(disclaimer);
//         disclaimerBox.setAlignment(Pos.CENTER);
        
//         chatFooter.getChildren().addAll(suggestions, inputBox, disclaimerBox);
//         chatArea.setBottom(chatFooter);

//         root.getChildren().addAll( historyCol, chatArea);

//         aiMentorScene = new Scene(root, 1400, 850);
//         return aiMentorScene;
//     }

//     // --- Helper Methods ---

//     private Button createNavButton(String text, boolean isActive) {
//         Button btn = new Button("   " + text); // spaces for visual icon alignment
//         btn.setPrefWidth(Double.MAX_VALUE);
//         btn.setAlignment(Pos.CENTER_LEFT);
//         if (isActive) {
//             btn.setStyle("-fx-background-color: rgba(98,255,150,0.1); -fx-text-fill: #62ff96; -fx-font-size: 14px; -fx-font-weight:bold; -fx-padding: 12px 15px; -fx-background-radius: 10px; -fx-border-color: #62ff96; -fx-border-width: 0 0 0 3px;");
//         } else {
//             btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8a8d91; -fx-font-size: 14px; -fx-padding: 12px 15px;");
//         }
//         return btn;
//     }

//     private VBox createHistoryItem(String time, String title, String sub, boolean isActive) {
//         VBox box = new VBox(5);
//         if (isActive) {
//             box.setStyle("-fx-background-color: rgba(98,255,150,0.08); -fx-border-color: rgba(98,255,150,0.2); -fx-border-radius: 12px; -fx-background-radius: 12px; -fx-padding: 14px;");
//         } else {
//             box.setStyle("-fx-background-color: transparent; -fx-padding: 14px;");
//         }

//         HBox topRow = new HBox();
//         Text timeTxt = new Text(time);
//         timeTxt.setStyle("-fx-font-size:10px; -fx-font-weight:bold; -fx-fill: " + (isActive ? "#62ff96" : "#8a8d91") + ";");
//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);
//         Text dots = new Text("•••");
//         dots.setStyle("-fx-fill: #3a3d41; -fx-font-weight: bold;");
//         topRow.getChildren().addAll(timeTxt, spacer, dots);

//         Text titleTxt = new Text(title);
//         titleTxt.setStyle("-fx-font-size:14px; -fx-fill: #ffffff;");
        
//         Text subTxt = new Text(sub);
//         subTxt.setStyle("-fx-font-size:11px; -fx-fill: #8a8d91;");

//         box.getChildren().addAll(topRow, titleTxt, subTxt);
//         return box;
//     }

//     private VBox createAiMessage(String text, String time) {
//         VBox wrapper = new VBox(5);
        
//         HBox msgRow = new HBox(15);
//         msgRow.setAlignment(Pos.TOP_LEFT);
        
//         Circle aiIcon = new Circle(15, Color.web("#62ff96")); // Simple representation
        
//         Label content = new Label(text);
//         content.setWrapText(true);
//         content.setMaxWidth(600);
//         content.setStyle("-fx-background-color: #27302D; -fx-text-fill: #d0d5d8; -fx-padding: 15px 20px; -fx-background-radius: 0 16px 16px 16px; -fx-font-size: 14px; -fx-line-spacing: 5px;");
        
//         msgRow.getChildren().addAll(aiIcon, content);
        
//         Text timeTxt = new Text(time);
//         timeTxt.setStyle("-fx-font-size:10px; -fx-font-weight:bold; -fx-fill: #3a3d41;");
//         HBox timeBox = new HBox(timeTxt);
//         timeBox.setPadding(new Insets(0, 0, 0, 50));
        
//         wrapper.getChildren().addAll(msgRow, timeBox);
//         return wrapper;
//     }

//     private VBox createUserMessage(String text, String time) {
//         VBox wrapper = new VBox(5);
        
//         HBox msgRow = new HBox(15);
//         msgRow.setAlignment(Pos.TOP_RIGHT);
        
//         Label content = new Label(text);
//         content.setWrapText(true);
//         content.setMaxWidth(600);
//         content.setStyle("-fx-background-color: #323539; -fx-text-fill: #ffffff; -fx-padding: 15px 20px; -fx-background-radius: 16px 0 16px 16px; -fx-font-size: 14px; -fx-line-spacing: 5px;");
        
//         Circle userIcon = new Circle(15, Color.web("#212428"));
//         userIcon.setStroke(Color.web("#3a3d41"));
        
//         msgRow.getChildren().addAll(content, userIcon);
        
//         Text timeTxt = new Text(time);
//         timeTxt.setStyle("-fx-font-size:10px; -fx-font-weight:bold; -fx-fill: #3a3d41;");
//         HBox timeBox = new HBox(timeTxt);
//         timeBox.setAlignment(Pos.CENTER_RIGHT);
//         timeBox.setPadding(new Insets(0, 50, 0, 0));
        
//         wrapper.getChildren().addAll(msgRow, timeBox);
//         return wrapper;
//     }

//     private VBox createAiMessageWithCard(String text, String time) {
//         VBox wrapper = new VBox(5);
        
//         HBox msgRow = new HBox(15);
//         msgRow.setAlignment(Pos.TOP_LEFT);
        
//         Circle aiIcon = new Circle(15, Color.web("#62ff96"));
        
//         VBox contentBubble = new VBox(15);
//         contentBubble.setMaxWidth(600);
//         contentBubble.setStyle("-fx-background-color: #1a1d21; -fx-padding: 20px; -fx-background-radius: 0 16px 16px 16px;");
        
//         Label textLabel = new Label(text);
//         textLabel.setWrapText(true);
//         textLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 14px; -fx-line-spacing: 5px;");
        
//         // Inner Routine Card
//         VBox routineCard = new VBox(15);
//         routineCard.setStyle("-fx-background-color: #1e2426; -fx-background-radius: 12px; -fx-padding: 15px; -fx-border-color: rgba(255,255,255,0.05); -fx-border-radius: 12px;");
        
//         HBox cardTop = new HBox();
//         Text routineTitle = new Text("Revised Routine");
//         routineTitle.setStyle("-fx-font-size:14px; -fx-font-weight:bold; -fx-fill: #62ff96;");
//         Region cSpacer = new Region();
//         HBox.setHgrow(cSpacer, Priority.ALWAYS);
//         Text tag = new Text("Knee-Safe");
//         tag.setStyle("-fx-background-color: rgba(98,255,150,0.15); -fx-fill: #62ff96; -fx-font-size: 10px; -fx-font-weight:bold; -fx-padding: 3px 8px; -fx-background-radius: 10px;");
//         cardTop.getChildren().addAll(routineTitle, cSpacer, tag);
        
//         HBox exercisesBox = new HBox(15);
//         exercisesBox.getChildren().addAll(
//             createExerciseBlock("EXERCISE 1", "RDLs (DBs)", "3 sets × 12 reps"),
//             createExerciseBlock("EXERCISE 2", "Leg Press", "4 sets × 15 reps")
//         );
        
//         routineCard.getChildren().addAll(cardTop, exercisesBox);
//         contentBubble.getChildren().addAll(textLabel, routineCard);
        
//         msgRow.getChildren().addAll(aiIcon, contentBubble);
        
//         Text timeTxt = new Text(time);
//         timeTxt.setStyle("-fx-font-size:10px; -fx-font-weight:bold; -fx-fill: #3a3d41;");
//         HBox timeBox = new HBox(timeTxt);
//         timeBox.setPadding(new Insets(0, 0, 0, 50));
        
//         wrapper.getChildren().addAll(msgRow, timeBox);
//         return wrapper;
//     }

//     private VBox createExerciseBlock(String label, String name, String details) {
//         VBox block = new VBox(5);
//         block.setStyle("-fx-background-color: rgba(0,0,0,0.2); -fx-background-radius: 8px; -fx-padding: 12px;");
//         HBox.setHgrow(block, Priority.ALWAYS);
        
//         Text lbl = new Text(label);
//         lbl.setStyle("-fx-font-size:9px; -fx-font-weight:bold; -fx-fill: #8a8d91;");
//         Text n = new Text(name);
//         n.setStyle("-fx-font-size:14px; -fx-font-weight:bold; -fx-fill: #ffffff;");
//         Text d = new Text(details);
//         d.setStyle("-fx-font-size:11px; -fx-fill: #62ff96;");
        
//         block.getChildren().addAll(lbl, n, d);
//         return block;
//     }

//     private Button createSuggestionBtn(String text) {
//         Button btn = new Button("↗ " + text); // Simple arrow for icon
//         btn.setStyle("-fx-background-color: #212428; -fx-text-fill: #ffffff; -fx-background-radius: 20px; -fx-padding: 8px 16px; -fx-font-size: 13px; -fx-font-weight: bold;");
//         return btn;
//     }

//     // @Override
//     // public void start(Stage stage) throws Exception {
//     //     Runnable dummyCallback = () -> {
//     //         System.out.println("Navigating Back...");
//     //     };
        
//     //     stage.setScene(getAiMentorScene(dummyCallback));
//     //     stage.setTitle("FitVerse - AI Mentor");
//     //     stage.show();
//     // }
// }




package com.visionx.view.user_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class AiMentorView {

    private Scene aiMentorScene;

    public Scene getAiMentorScene(Runnable callBackAction) {

        // =========================================================
        // ROOT
        // =========================================================

        HBox root = new HBox();

        root.setStyle(
            "-fx-background-color: #080C14;"
        );

        // =========================================================
        // MIDDLE COLUMN - HISTORY
        // =========================================================

        VBox historyCol = new VBox(20);

        historyCol.setPrefWidth(300);
        historyCol.setMinWidth(300);
        historyCol.setMaxWidth(300);

        historyCol.setStyle(
            "-fx-background-color: #11161A;" +
            "-fx-border-color: transparent #2a2d31 transparent transparent;" +
            "-fx-border-width: 0 1px 0 0;"
        );

        VBox historyTop = new VBox(20);

        historyTop.setStyle(
            "-fx-padding: 30px 20px 0 20px;"
        );

        // New Session Button

        Button newSessionBtn =
            new Button("+ New Mentorship Session");

        newSessionBtn.setMaxWidth(
            Double.MAX_VALUE
        );

        newSessionBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-border-color: #3a3d41;" +
            "-fx-border-radius: 12px;" +
            "-fx-padding: 10px;" +
            "-fx-font-size: 13px;"
        );

        Text recentLabel =
            new Text("RECENT SESSIONS");

        recentLabel.setStyle(
            "-fx-font-size:10px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#8a8d91;"
        );

        historyTop.getChildren().addAll(
            newSessionBtn,
            recentLabel
        );

        // =========================================================
        // SESSION LIST
        // =========================================================

        VBox sessionList =
            new VBox(10);

        sessionList.setStyle(
            "-fx-padding: 0 20px 0 20px;"
        );

        sessionList.getChildren().addAll(

            createHistoryItem(
                "NOW",
                "Current AI Session",
                "Fitness questions...",
                true
            ),

            createHistoryItem(
                "YESTERDAY",
                "Leg Day Optimization",
                "Workout planning...",
                false
            ),

            createHistoryItem(
                "AUG 09",
                "Diet Planning",
                "Protein & calories...",
                false
            )
        );

        Region historySpacer =
            new Region();

        VBox.setVgrow(
            historySpacer,
            Priority.ALWAYS
        );

        // =========================================================
        // HISTORY FOOTER
        // =========================================================

        HBox historyFooter =
            new HBox(8);

        historyFooter.setAlignment(
            Pos.CENTER_LEFT
        );

        historyFooter.setStyle(
            "-fx-padding:20px;" +
            "-fx-border-color:#2a2d31 transparent transparent transparent;" +
            "-fx-border-width:1px 0 0 0;"
        );

        Circle boltIcon =
            new Circle(
                10,
                Color.web("#62ff96")
            );

        Text verText =
            new Text(
                "Active Intelligence v4.2"
            );

        verText.setStyle(
            "-fx-font-size:11px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#8a8d91;"
        );

        historyFooter.getChildren().addAll(
            boltIcon,
            verText
        );

        historyCol.getChildren().addAll(
            historyTop,
            sessionList,
            historySpacer,
            historyFooter
        );

        // =========================================================
        // RIGHT CHAT AREA
        // =========================================================

        BorderPane chatArea =
            new BorderPane();

        chatArea.setStyle(
            "-fx-background-color:#080C14;"
        );

        HBox.setHgrow(
            chatArea,
            Priority.ALWAYS
        );

        // =========================================================
        // CHAT HEADER
        // =========================================================

        HBox chatHeader =
            new HBox();

        chatHeader.setAlignment(
            Pos.CENTER_LEFT
        );

        chatHeader.setStyle(
            "-fx-padding:25px 40px;" +
            "-fx-border-color:transparent transparent #2a2d31 transparent;" +
            "-fx-border-width:0 0 1px 0;" +
            "-fx-background-color:#11161A;"
        );

        Circle aiAvatar =
            new Circle(
                20,
                Color.web("#62ff96")
            );

        VBox aiTitles =
            new VBox(2);

        aiTitles.setPadding(
            new Insets(0, 0, 0, 15)
        );

        HBox titleRow =
            new HBox(8);

        titleRow.setAlignment(
            Pos.CENTER_LEFT
        );

        Text aiName =
            new Text("AI Mentor");

        aiName.setStyle(
            "-fx-font-size:20px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        Circle onlineDot =
            new Circle(
                4,
                Color.web("#62ff96")
            );

        titleRow.getChildren().addAll(
            aiName,
            onlineDot
        );

        Text aiSub =
            new Text(
                "Expert Digital Coach • Always Online"
            );

        aiSub.setStyle(
            "-fx-font-size:12px;" +
            "-fx-fill:#8a8d91;"
        );

        aiTitles.getChildren().addAll(
            titleRow,
            aiSub
        );

        Region headerSpacer =
            new Region();

        HBox.setHgrow(
            headerSpacer,
            Priority.ALWAYS
        );

        Button backButton =
            new Button("←");

        backButton.setStyle(
            "-fx-background-color:#212428;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-background-radius:50%;" +
            "-fx-min-width:40px;" +
            "-fx-min-height:40px;"
        );

        backButton.setOnAction(e -> {

            if (callBackAction != null) {
                callBackAction.run();
            }

        });

        chatHeader.getChildren().addAll(
            aiAvatar,
            aiTitles,
            headerSpacer,
            backButton
        );

        chatArea.setTop(
            chatHeader
        );

        // =========================================================
        // MESSAGE STREAM
        // =========================================================

        VBox messageStream =
            new VBox(30);

        messageStream.setPadding(
            new Insets(30, 40, 30, 40)
        );

        // Initial AI message

        VBox welcomeMessage =
            createAiMessage(
                "Hi! I'm your FitVerse AI Mentor. Ask me anything about workouts, diet, calories, recovery or fitness.",
                "Now"
            );

        messageStream.getChildren().add(
            welcomeMessage
        );

        // =========================================================
        // SCROLL PANE
        // =========================================================

        ScrollPane chatScroll =
            new ScrollPane(
                messageStream
            );

        chatScroll.setFitToWidth(
            true
        );

        chatScroll.setHbarPolicy(
            ScrollPane.ScrollBarPolicy.NEVER
        );

        chatScroll.setStyle(
            "-fx-background:#080C14;" +
            "-fx-background-color:#080C14;" +
            "-fx-border-color:transparent;"
        );

        chatArea.setCenter(
            chatScroll
        );

        // =========================================================
        // CHAT FOOTER
        // =========================================================

        VBox chatFooter =
            new VBox(15);

        chatFooter.setPadding(
            new Insets(20, 40, 30, 40)
        );

        chatFooter.setStyle(
            "-fx-background-color:#080C14;"
        );

        // =========================================================
        // SUGGESTIONS
        // =========================================================

        HBox suggestions =
            new HBox(10);

        Button suggestion1 =
            createSuggestionBtn(
                "Suggest a workout"
            );

        Button suggestion2 =
            createSuggestionBtn(
                "Analyze my calories"
            );

        Button suggestion3 =
            createSuggestionBtn(
                "Give me a diet plan"
            );

        suggestions.getChildren().addAll(
            suggestion1,
            suggestion2,
            suggestion3
        );

        // =========================================================
        // INPUT BOX
        // =========================================================

        HBox inputBox =
            new HBox(15);

        inputBox.setAlignment(
            Pos.CENTER_LEFT
        );

        inputBox.setStyle(
            "-fx-background-color:#1a1e22;" +
            "-fx-background-radius:30px;" +
            "-fx-padding:8px 10px 8px 25px;" +
            "-fx-border-color:#2a2d31;" +
            "-fx-border-radius:30px;"
        );

        // TextField

        TextField queryField =
            new TextField();

        queryField.setPromptText(
            "Ask your AI fitness mentor..."
        );

        queryField.setStyle(
            "-fx-background-color:transparent;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-prompt-text-fill:#8a8d91;" +
            "-fx-font-size:14px;"
        );

        HBox.setHgrow(
            queryField,
            Priority.ALWAYS
        );

        // =========================================================
        // MICROPHONE
        // =========================================================

        Button micBtn =
            new Button("🎤");

        micBtn.setStyle(
            "-fx-background-color:transparent;" +
            "-fx-text-fill:#8a8d91;" +
            "-fx-font-size:16px;" +
            "-fx-cursor:hand;"
        );

        // =========================================================
        // SEND BUTTON
        // =========================================================

        Button sendBtn =
            new Button("➤");

        sendBtn.setStyle(
            "-fx-background-color:#62ff96;" +
            "-fx-text-fill:#06100a;" +
            "-fx-font-size:16px;" +
            "-fx-font-weight:bold;" +
            "-fx-background-radius:50%;" +
            "-fx-min-width:42px;" +
            "-fx-min-height:42px;" +
            "-fx-cursor:hand;"
        );

        // =========================================================
        // SUGGESTION ACTIONS
        // =========================================================

        suggestion1.setOnAction(e -> {

            queryField.setText(
                "Suggest a workout"
            );

            queryField.requestFocus();

        });

        suggestion2.setOnAction(e -> {

            queryField.setText(
                "Analyze my calories"
            );

            queryField.requestFocus();

        });

        suggestion3.setOnAction(e -> {

            queryField.setText(
                "Give me a diet plan"
            );

            queryField.requestFocus();

        });

        // =========================================================
        // SEND QUESTION
        // =========================================================

        sendBtn.setOnAction(e -> {

            sendQuestion(
                queryField,
                messageStream,
                chatScroll
            );

        });

        // ENTER KEY SEND

        queryField.setOnAction(e -> {

            sendQuestion(
                queryField,
                messageStream,
                chatScroll
            );

        });

        inputBox.getChildren().addAll(
            queryField,
            micBtn,
            sendBtn
        );

        // =========================================================
        // DISCLAIMER
        // =========================================================

        Text disclaimer =
            new Text(
                "FITVERSE AI MENTOR CAN MAKE MISTAKES. CHECK IMPORTANT INFORMATION."
            );

        disclaimer.setStyle(
            "-fx-font-size:9px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#3a3d41;"
        );

        HBox disclaimerBox =
            new HBox(
                disclaimer
            );

        disclaimerBox.setAlignment(
            Pos.CENTER
        );

        // =========================================================
        // FOOTER ADD
        // =========================================================

        chatFooter.getChildren().addAll(
            suggestions,
            inputBox,
            disclaimerBox
        );

        chatArea.setBottom(
            chatFooter
        );

        // =========================================================
        // ROOT ADD
        // =========================================================

        root.getChildren().addAll(
            historyCol,
            chatArea
        );

        // =========================================================
        // SCENE
        // =========================================================

        aiMentorScene =
            new Scene(
                root,
                1400,
                850
            );

        return aiMentorScene;
    }

    // =========================================================
    // SEND QUESTION METHOD
    // =========================================================

    private void sendQuestion(
        TextField queryField,
        VBox messageStream,
        ScrollPane chatScroll
    ) {

        String question =
            queryField.getText().trim();

        if (question.isEmpty()) {
            return;
        }

        // =====================================================
        // USER QUESTION
        // =====================================================

        VBox userQuestion =
            createUserMessage(
                question,
                "Now"
            );

        messageStream.getChildren().add(
            userQuestion
        );

        // Clear input

        queryField.clear();

        // =====================================================
        // AI ANSWER
        // =====================================================

        String answer =
            generateAnswer(question);

        VBox aiAnswer =
            createAiMessage(
                answer,
                "Now"
            );

        messageStream.getChildren().add(
            aiAnswer
        );

        // =====================================================
        // SCROLL TO BOTTOM
        // =====================================================

        chatScroll.layout();

        chatScroll.setVvalue(
            1.0
        );
    }

    // =========================================================
    // DEMO AI ANSWER
    // =========================================================

    private String generateAnswer(
        String question
    ) {

        String q =
            question.toLowerCase();

        if (
            q.contains("workout") ||
            q.contains("exercise") ||
            q.contains("gym")
        ) {

            return
                "For a good workout, start with 5–10 minutes of warm-up. "
                + "Then focus on compound exercises followed by accessory movements. "
                + "Keep your form controlled and take enough rest between sets.";

        }

        if (
            q.contains("diet") ||
            q.contains("food") ||
            q.contains("protein")
        ) {

            return
                "For your fitness goal, focus on a balanced diet with enough "
                + "protein, complex carbohydrates, healthy fats and vegetables. "
                + "Good protein sources include eggs, paneer, dal, chicken, "
                + "fish and Greek yogurt.";

        }

        if (
            q.contains("calorie") ||
            q.contains("calories")
        ) {

            return
                "Your daily calorie requirement depends on your age, height, "
                + "weight, activity level and fitness goal. "
                + "For accurate planning, calculate your BMR first and then "
                + "adjust calories according to your goal.";

        }

        if (
            q.contains("weight") ||
            q.contains("fat") ||
            q.contains("lose")
        ) {

            return
                "For fat loss, maintain a moderate calorie deficit, "
                + "consume enough protein and combine strength training "
                + "with regular physical activity. Avoid extreme dieting.";

        }

        if (
            q.contains("muscle") ||
            q.contains("bulk")
        ) {

            return
                "For muscle gain, focus on progressive overload, adequate "
                + "protein intake, sufficient calories and 7–9 hours of sleep. "
                + "Consistency is more important than constantly changing workouts.";

        }

        if (
            q.contains("sleep") ||
            q.contains("recovery")
        ) {

            return
                "Recovery is an important part of fitness. Aim for 7–9 hours "
                + "of quality sleep, stay hydrated and give your muscles enough "
                + "time to recover between intense workouts.";

        }

        return
            "That's a good fitness question. I recommend considering your "
            + "current goal, activity level, workout experience and recovery "
            + "before making a plan. Tell me more about your goal and I'll "
            + "help you create a better fitness strategy.";
    }

    // =========================================================
    // HISTORY ITEM
    // =========================================================

    private VBox createHistoryItem(
        String time,
        String title,
        String sub,
        boolean isActive
    ) {

        VBox box =
            new VBox(5);

        if (isActive) {

            box.setStyle(
                "-fx-background-color:rgba(98,255,150,0.08);" +
                "-fx-border-color:rgba(98,255,150,0.2);" +
                "-fx-border-radius:12px;" +
                "-fx-background-radius:12px;" +
                "-fx-padding:14px;"
            );

        } else {

            box.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-padding:14px;"
            );
        }

        HBox topRow =
            new HBox();

        Text timeTxt =
            new Text(
                time
            );

        timeTxt.setStyle(
            "-fx-font-size:10px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:" +
            (isActive
                ? "#62ff96"
                : "#8a8d91") +
            ";"
        );

        Region spacer =
            new Region();

        HBox.setHgrow(
            spacer,
            Priority.ALWAYS
        );

        Text dots =
            new Text(
                "•••"
            );

        dots.setStyle(
            "-fx-fill:#3a3d41;" +
            "-fx-font-weight:bold;"
        );

        topRow.getChildren().addAll(
            timeTxt,
            spacer,
            dots
        );

        Text titleTxt =
            new Text(
                title
            );

        titleTxt.setStyle(
            "-fx-font-size:14px;" +
            "-fx-fill:#ffffff;"
        );

        Text subTxt =
            new Text(
                sub
            );

        subTxt.setStyle(
            "-fx-font-size:11px;" +
            "-fx-fill:#8a8d91;"
        );

        box.getChildren().addAll(
            topRow,
            titleTxt,
            subTxt
        );

        return box;
    }

    // =========================================================
    // AI MESSAGE
    // =========================================================

    private VBox createAiMessage(
        String text,
        String time
    ) {

        VBox wrapper =
            new VBox(5);

        HBox msgRow =
            new HBox(15);

        msgRow.setAlignment(
            Pos.TOP_LEFT
        );

        Circle aiIcon =
            new Circle(
                15,
                Color.web("#62ff96")
            );

        Label content =
            new Label(
                text
            );

        content.setWrapText(
            true
        );

        content.setMaxWidth(
            650
        );

        content.setStyle(
            "-fx-background-color:#27302D;" +
            "-fx-text-fill:#d0d5d8;" +
            "-fx-padding:15px 20px;" +
            "-fx-background-radius:0 16px 16px 16px;" +
            "-fx-font-size:14px;"
        );

        msgRow.getChildren().addAll(
            aiIcon,
            content
        );

        Text timeTxt =
            new Text(
                time
            );

        timeTxt.setStyle(
            "-fx-font-size:10px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#3a3d41;"
        );

        HBox timeBox =
            new HBox(
                timeTxt
            );

        timeBox.setPadding(
            new Insets(
                0,
                0,
                0,
                45
            )
        );

        wrapper.getChildren().addAll(
            msgRow,
            timeBox
        );

        return wrapper;
    }

    // =========================================================
    // USER MESSAGE
    // =========================================================

    private VBox createUserMessage(
        String text,
        String time
    ) {

        VBox wrapper =
            new VBox(5);

        HBox msgRow =
            new HBox(15);

        msgRow.setAlignment(
            Pos.TOP_RIGHT
        );

        Label content =
            new Label(
                text
            );

        content.setWrapText(
            true
        );

        content.setMaxWidth(
            650
        );

        content.setStyle(
            "-fx-background-color:#323539;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-padding:15px 20px;" +
            "-fx-background-radius:16px 0 16px 16px;" +
            "-fx-font-size:14px;"
        );

        Circle userIcon =
            new Circle(
                15,
                Color.web("#212428")
            );

        userIcon.setStroke(
            Color.web("#3a3d41")
        );

        msgRow.getChildren().addAll(
            content,
            userIcon
        );

        Text timeTxt =
            new Text(
                time
            );

        timeTxt.setStyle(
            "-fx-font-size:10px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#3a3d41;"
        );

        HBox timeBox =
            new HBox(
                timeTxt
            );

        timeBox.setAlignment(
            Pos.CENTER_RIGHT
        );

        timeBox.setPadding(
            new Insets(
                0,
                45,
                0,
                0
            )
        );

        wrapper.getChildren().addAll(
            msgRow,
            timeBox
        );

        return wrapper;
    }

    // =========================================================
    // SUGGESTION BUTTON
    // =========================================================

    private Button createSuggestionBtn(
        String text
    ) {

        Button btn =
            new Button(
                "↗ " + text
            );

        btn.setStyle(
            "-fx-background-color:#212428;" +
            "-fx-text-fill:#ffffff;" +
            "-fx-background-radius:20px;" +
            "-fx-padding:8px 16px;" +
            "-fx-font-size:13px;" +
            "-fx-font-weight:bold;" +
            "-fx-cursor:hand;"
        );

        return btn;
    }
}
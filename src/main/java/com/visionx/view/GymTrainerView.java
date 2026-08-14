
// package com.visionx.view;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.Region;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Rectangle;
// import javafx.scene.text.Text;

// public class GymTrainerView {

//     // =========================================================
//     // MAIN TRAINER PAGE
//     // =========================================================

//     public Scene getTrainerScene(Runnable callBackAction) {

//         BorderPane root = new BorderPane();

//         root.setStyle(
//             "-fx-background-color:#080C14;"
//         );

//         // =====================================================
//         // HEADER
//         // =====================================================

//         VBox header = new VBox(8);

//         header.setPadding(
//             new Insets(30, 40, 20, 40)
//         );

//         Text title = new Text(
//             "Find Your "
//         );

//         title.setStyle(
//             "-fx-font-size:32px;" +
//             "-fx-font-weight:bold;" +
//             "-fx-fill:#ffffff;"
//         );

//         Text greenTitle = new Text(
//             "Perfect Trainer"
//         );

//         greenTitle.setStyle(
//             "-fx-font-size:32px;" +
//             "-fx-font-weight:bold;" +
//             "-fx-fill:#62ff96;"
//         );

//         HBox titleBox = new HBox(
//             title,
//             greenTitle
//         );

//         Text subtitle = new Text(
//             "Choose from professional trainers and book your personal fitness session."
//         );

//         subtitle.setStyle(
//             "-fx-font-size:14px;" +
//             "-fx-fill:#8a8d91;"
//         );

//         header.getChildren().addAll(
//             titleBox,
//             subtitle
//         );

//         // =====================================================
//         // SEARCH + FILTER
//         // =====================================================

//         HBox searchSection = new HBox(15);

//         searchSection.setAlignment(
//             Pos.CENTER_LEFT
//         );

//         searchSection.setPadding(
//             new Insets(0, 40, 20, 40)
//         );

//         TextField searchField = new TextField();

//         searchField.setPromptText(
//             "Search trainer..."
//         );

//         searchField.setStyle(
//             "-fx-background-color:#111a24;" +
//             "-fx-text-fill:#ffffff;" +
//             "-fx-prompt-text-fill:#596675;" +
//             "-fx-background-radius:20px;" +
//             "-fx-border-color:#1e2b38;" +
//             "-fx-border-radius:20px;" +
//             "-fx-padding:10px 18px;"
//         );

//         searchField.setPrefWidth(350);

//         Button allBtn =
//                 createFilterButton(
//                     "All Trainers",
//                     true
//                 );

//         Button strengthBtn =
//                 createFilterButton(
//                     "Strength",
//                     false
//                 );

//         Button weightLossBtn =
//                 createFilterButton(
//                     "Weight Loss",
//                     false
//                 );

//         Button yogaBtn =
//                 createFilterButton(
//                     "Yoga",
//                     false
//                 );

//         searchSection.getChildren().addAll(
//             searchField,
//             allBtn,
//             strengthBtn,
//             weightLossBtn,
//             yogaBtn
//         );

//         // =====================================================
//         // TRAINER GRID
//         // =====================================================

//         GridPane trainerGrid = new GridPane();

//         trainerGrid.setHgap(20);
//         trainerGrid.setVgap(20);

//         trainerGrid.setPadding(
//             new Insets(10, 40, 40, 40)
//         );

//         TrainerCard trainer1 =
//                 new TrainerCard(
//                     "Rahul Sharma",
//                     "Strength & Muscle Building",
//                     "8 Years Experience",
//                     "4.9",
//                     "₹800 / Session",
//                     "https://images.unsplash.com/photo-1583454110551-21f2fa2afe61"
//                 );

//         TrainerCard trainer2 =
//                 new TrainerCard(
//                     "Amit Patil",
//                     "Weight Loss Specialist",
//                     "6 Years Experience",
//                     "4.8",
//                     "₹600 / Session",
//                     "https://images.unsplash.com/photo-1534438327276-14e5300c3a48"
//                 );

//         TrainerCard trainer3 =
//                 new TrainerCard(
//                     "Sneha Joshi",
//                     "Yoga & Flexibility",
//                     "7 Years Experience",
//                     "4.9",
//                     "₹700 / Session",
//                     "https://images.unsplash.com/photo-1544717305-2782549b5136"
//                 );

//         TrainerCard trainer4 =
//                 new TrainerCard(
//                     "Vikram Singh",
//                     "Bodybuilding Coach",
//                     "10 Years Experience",
//                     "5.0",
//                     "₹1000 / Session",
//                     "https://images.unsplash.com/photo-1567013127542-490d757e51fc"
//                 );

//         TrainerCard trainer5 =
//                 new TrainerCard(
//                     "Priya Kulkarni",
//                     "Women's Fitness",
//                     "5 Years Experience",
//                     "4.8",
//                     "₹650 / Session",
//                     "https://images.unsplash.com/photo-1594381898411-846e7d193883"
//                 );

//         TrainerCard trainer6 =
//                 new TrainerCard(
//                     "Arjun Deshmukh",
//                     "Functional Training",
//                     "9 Years Experience",
//                     "4.9",
//                     "₹750 / Session",
//                     "https://images.unsplash.com/photo-1581009146145-b5ef050c2e1e"
//                 );

//         trainerGrid.add(
//             trainer1.createCard(),
//             0,
//             0
//         );

//         trainerGrid.add(
//             trainer2.createCard(),
//             1,
//             0
//         );

//         trainerGrid.add(
//             trainer3.createCard(),
//             2,
//             0
//         );

//         trainerGrid.add(
//             trainer4.createCard(),
//             0,
//             1
//         );

//         trainerGrid.add(
//             trainer5.createCard(),
//             1,
//             1
//         );

//         trainerGrid.add(
//             trainer6.createCard(),
//             2,
//             1
//         );

//         // =====================================================
//         // SEARCH FUNCTION
//         // =====================================================

//         searchField.textProperty().addListener(
//             (observable, oldValue, newValue) -> {

//                 String search =
//                     newValue.toLowerCase();

//                 for (Node node :
//                         trainerGrid.getChildren()) {

//                     if (node instanceof VBox) {

//                         VBox card =
//                             (VBox) node;

//                         String trainerName =
//                             String.valueOf(
//                                 card.getUserData()
//                             ).toLowerCase();

//                         card.setVisible(
//                             trainerName.contains(search)
//                         );

//                         card.setManaged(
//                             trainerName.contains(search)
//                         );
//                     }
//                 }
//             }
//         );

//         // =====================================================
//         // SCROLL
//         // =====================================================

//         ScrollPane scrollPane =
//                 new ScrollPane(trainerGrid);

//         scrollPane.setFitToWidth(true);

//         scrollPane.setStyle(
//             "-fx-background:#080C14;" +
//             "-fx-background-color:#080C14;" +
//             "-fx-border-color:transparent;"
//         );

//         root.setTop(
//             new VBox(
//                 header,
//                 searchSection
//             )
//         );

//         root.setCenter(
//             scrollPane
//         );

//         // =====================================================
//         // SCENE
//         // =====================================================

//         return new Scene(
//             root,
//             1200,
//             800
//         );
//     }

//     // =========================================================
//     // FILTER BUTTON
//     // =========================================================

//     private Button createFilterButton(
//             String text,
//             boolean active
//     ) {

//         Button button =
//                 new Button(text);

//         button.setStyle(
//             active
//             ?
//             "-fx-background-color:#62ff96;" +
//             "-fx-text-fill:#06100a;" +
//             "-fx-font-weight:bold;" +
//             "-fx-background-radius:20px;" +
//             "-fx-padding:9px 16px;" +
//             "-fx-cursor:hand;"
//             :
//             "-fx-background-color:#111a24;" +
//             "-fx-text-fill:#8a8d91;" +
//             "-fx-background-radius:20px;" +
//             "-fx-padding:9px 16px;" +
//             "-fx-cursor:hand;"
//         );

//         return button;
//     }

//     // =========================================================
//     // TRAINER CARD CLASS
//     // =========================================================

//     private class TrainerCard {

//         private String name;
//         private String specialization;
//         private String experience;
//         private String rating;
//         private String price;
//         private String imageUrl;

//         TrainerCard(
//                 String name,
//                 String specialization,
//                 String experience,
//                 String rating,
//                 String price,
//                 String imageUrl
//         ) {

//             this.name = name;
//             this.specialization = specialization;
//             this.experience = experience;
//             this.rating = rating;
//             this.price = price;
//             this.imageUrl = imageUrl;
//         }

//         // =====================================================
//         // CREATE CARD
//         // =====================================================

//         VBox createCard() {

//             VBox card =
//                     new VBox(12);

//             card.setPrefWidth(330);
//             card.setMaxWidth(330);

//             card.setPadding(
//                 new Insets(15)
//             );

//             card.setUserData(
//                 name
//             );

//             card.setStyle(
//                 "-fx-background-color:#0c1520;" +
//                 "-fx-background-radius:18px;" +
//                 "-fx-border-color:#1a2936;" +
//                 "-fx-border-radius:18px;"
//             );

//             // =================================================
//             // TRAINER IMAGE
//             // =================================================

//             StackPane imagePane =
//                     new StackPane();

//             javafx.scene.image.Image image =
//                     new javafx.scene.image.Image(
//                         imageUrl +
//                         "?auto=format&fit=crop&w=500&q=80",
//                         300,
//                         190,
//                         false,
//                         true
//                     );

//             javafx.scene.image.ImageView imageView =
//                     new javafx.scene.image.ImageView(
//                         image
//                     );

//             imageView.setFitWidth(300);
//             imageView.setFitHeight(190);

//             imageView.setPreserveRatio(false);

//             Rectangle clip =
//                     new Rectangle(
//                         300,
//                         190
//                     );

//             clip.setArcWidth(18);
//             clip.setArcHeight(18);

//             imageView.setClip(
//                 clip
//             );

//             imagePane.getChildren().add(
//                 imageView
//             );

//             // =================================================
//             // ONLINE TAG
//             // =================================================

//             Text online =
//                     new Text(
//                         "● AVAILABLE"
//                     );

//             online.setStyle(
//                 "-fx-background-color:#62ff96;" +
//                 "-fx-fill:#06100a;" +
//                 "-fx-font-size:9px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-padding:5px 8px;" +
//                 "-fx-background-radius:10px;"
//             );

//             StackPane.setAlignment(
//                 online,
//                 Pos.TOP_RIGHT
//             );

//             StackPane.setMargin(
//                 online,
//                 new Insets(10)
//             );

//             imagePane.getChildren().add(
//                 online
//             );

//             // =================================================
//             // NAME
//             // =================================================

//             Text trainerName =
//                     new Text(
//                         name
//                     );

//             trainerName.setStyle(
//                 "-fx-font-size:19px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//             );

//             // =================================================
//             // SPECIALIZATION
//             // =================================================

//             Text trainerSpecialization =
//                     new Text(
//                         specialization
//                     );

//             trainerSpecialization.setStyle(
//                 "-fx-font-size:12px;" +
//                 "-fx-fill:#62ff96;"
//             );

//             // =================================================
//             // DETAILS
//             // =================================================

//             HBox details =
//                     new HBox(15);

//             Text exp =
//                     new Text(
//                         "💪 " + experience
//                     );

//             exp.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-fill:#8a8d91;"
//             );

//             Text ratingText =
//                     new Text(
//                         "★ " + rating
//                     );

//             ratingText.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-fill:#ffffff;" +
//                 "-fx-font-weight:bold;"
//             );

//             details.getChildren().addAll(
//                 exp,
//                 ratingText
//             );

//             // =================================================
//             // PRICE
//             // =================================================

//             Text priceText =
//                     new Text(
//                         price
//                     );

//             priceText.setStyle(
//                 "-fx-font-size:14px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//             );

//             // =================================================
//             // BUTTONS
//             // =================================================

//             Button profileButton =
//                     new Button(
//                         "View Profile"
//                     );

//             profileButton.setMaxWidth(
//                 Double.MAX_VALUE
//             );

//             profileButton.setStyle(
//                 "-fx-background-color:#151e28;" +
//                 "-fx-text-fill:#ffffff;" +
//                 "-fx-border-color:#293642;" +
//                 "-fx-border-radius:10px;" +
//                 "-fx-background-radius:10px;" +
//                 "-fx-padding:10px;" +
//                 "-fx-cursor:hand;"
//             );

//             Button bookButton =
//                     new Button(
//                         "Book Trainer"
//                     );

//             bookButton.setMaxWidth(
//                 Double.MAX_VALUE
//             );

//             bookButton.setStyle(
//                 "-fx-background-color:#62ff96;" +
//                 "-fx-text-fill:#06100a;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-background-radius:10px;" +
//                 "-fx-padding:10px;" +
//                 "-fx-cursor:hand;"
//             );

//             // =================================================
//             // PROFILE ACTION
//             // =================================================

//             profileButton.setOnAction(
//                 e -> showTrainerProfile()
//             );

//             // =================================================
//             // BOOK ACTION
//             // =================================================

//             bookButton.setOnAction(
//                 e -> showBookingDialog()
//             );

//             HBox buttons =
//                     new HBox(10);

//             HBox.setHgrow(
//                 profileButton,
//                 Priority.ALWAYS
//             );

//             HBox.setHgrow(
//                 bookButton,
//                 Priority.ALWAYS
//             );

//             profileButton.setMaxWidth(
//                 Double.MAX_VALUE
//             );

//             bookButton.setMaxWidth(
//                 Double.MAX_VALUE
//             );

//             buttons.getChildren().addAll(
//                 profileButton,
//                 bookButton
//             );

//             // =================================================
//             // ADD EVERYTHING
//             // =================================================

//             card.getChildren().addAll(
//                 imagePane,
//                 trainerName,
//                 trainerSpecialization,
//                 details,
//                 priceText,
//                 buttons
//             );

//             // =================================================
//             // HOVER
//             // =================================================

//             card.setOnMouseEntered(
//                 e -> {

//                     card.setStyle(
//                         "-fx-background-color:#101c29;" +
//                         "-fx-background-radius:18px;" +
//                         "-fx-border-color:#62ff96;" +
//                         "-fx-border-radius:18px;" +
//                         "-fx-effect:dropshadow(gaussian, rgba(98,255,150,0.15), 20, 0.2, 0, 5);"
//                     );
//                 }
//             );

//             card.setOnMouseExited(
//                 e -> {

//                     card.setStyle(
//                         "-fx-background-color:#0c1520;" +
//                         "-fx-background-radius:18px;" +
//                         "-fx-border-color:#1a2936;" +
//                         "-fx-border-radius:18px;"
//                     );
//                 }
//             );

//             return card;
//         }

//         // =====================================================
//         // TRAINER PROFILE
//         // =====================================================

//         private void showTrainerProfile() {

//             Alert alert =
//                     new Alert(
//                         Alert.AlertType.INFORMATION
//                     );

//             alert.setTitle(
//                 "Trainer Profile"
//             );

//             alert.setHeaderText(
//                 name
//             );

//             alert.setContentText(
//                 "Specialization: "
//                 + specialization
//                 + "\n\nExperience: "
//                 + experience
//                 + "\n\nRating: ★ "
//                 + rating
//                 + "\n\nPrice: "
//                 + price
//                 + "\n\nAbout Trainer:\n"
//                 + "Professional fitness trainer focused on helping clients achieve their fitness goals."
//             );

//             alert.showAndWait();
//         }

//         // =====================================================
//         // BOOK TRAINER
//         // =====================================================

//         private void showBookingDialog() {

//             Alert alert =
//                     new Alert(
//                         Alert.AlertType.INFORMATION
//                     );

//             alert.setTitle(
//                 "Book Trainer"
//             );

//             alert.setHeaderText(
//                 "Booking Confirmed"
//             );

//             alert.setContentText(
//                 "Trainer: "
//                 + name
//                 + "\n\n"
//                 + "Specialization: "
//                 + specialization
//                 + "\n\n"
//                 + "Price: "
//                 + price
//                 + "\n\n"
//                 + "Your trainer booking request has been created."
//             );

//             alert.showAndWait();
//         }
//     }
// }



// package com.visionx.view;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.CheckBox;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.Region;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Rectangle;
// import javafx.scene.text.Text;

// import java.util.ArrayList;
// import java.util.List;

// public class GymTrainerView {

//     // =========================================================
//     // COLORS
//     // =========================================================

//     private final String GREEN = "#62ff96";
//     private final String DARK_BG = "#080C14";
//     private final String CARD_BG = "#0c1520";
//     private final String LIGHT_TEXT = "#ffffff";
//     private final String MUTED_TEXT = "#8a8d91";

//     // =========================================================
//     // MAIN TRAINER PAGE
//     // =========================================================

//     public Scene getTrainerScene(Runnable callBackAction) {

//         BorderPane root = new BorderPane();

//         root.setStyle(
//                 "-fx-background-color:" + DARK_BG + ";"
//         );

//         // =====================================================
//         // HEADER
//         // =====================================================

//         VBox header = new VBox(8);

//         header.setPadding(
//                 new Insets(30, 40, 20, 40)
//         );

//         Text title = new Text("My ");

//         title.setStyle(
//                 "-fx-font-size:32px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//         );

//         Text greenTitle = new Text("Gym Trainer");

//         greenTitle.setStyle(
//                 "-fx-font-size:32px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#62ff96;"
//         );

//         HBox titleBox = new HBox(
//                 title,
//                 greenTitle
//         );

//         Text subtitle = new Text(
//                 "Manage your assigned trainer, complete assigned tasks and explore professional trainers."
//         );

//         subtitle.setStyle(
//                 "-fx-font-size:14px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         header.getChildren().addAll(
//                 titleBox,
//                 subtitle
//         );

//         // =====================================================
//         // MAIN CONTENT
//         // =====================================================

//         VBox content = new VBox(35);

//         content.setPadding(
//                 new Insets(10, 40, 50, 40)
//         );

//         // =====================================================
//         // MY ASSIGNED TRAINER
//         // =====================================================

//         VBox assignedSection = createAssignedTrainerSection();

//         // =====================================================
//         // ASSIGNED TASKS
//         // =====================================================

//         VBox tasksSection = createAssignedTasksSection();

//         // =====================================================
//         // EXPLORE TRAINERS HEADER
//         // =====================================================

//         VBox exploreSection = createExploreTrainersSection();

//         content.getChildren().addAll(
//                 assignedSection,
//                 tasksSection,
//                 exploreSection
//         );

//         // =====================================================
//         // SCROLL
//         // =====================================================

//         ScrollPane scrollPane =
//                 new ScrollPane(content);

//         scrollPane.setFitToWidth(true);

//         scrollPane.setStyle(
//                 "-fx-background:#080C14;" +
//                 "-fx-background-color:#080C14;" +
//                 "-fx-border-color:transparent;"
//         );

//         root.setTop(header);

//         root.setCenter(scrollPane);

//         // =====================================================
//         // SCENE
//         // =====================================================

//         return new Scene(
//                 root,
//                 1200,
//                 800
//         );
//     }

//     // =========================================================
//     // ASSIGNED TRAINER SECTION
//     // =========================================================

//     private VBox createAssignedTrainerSection() {

//         VBox section = new VBox(15);

//         Text sectionTitle =
//                 new Text("Your Assigned Trainer");

//         sectionTitle.setStyle(
//                 "-fx-font-size:20px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//         );

//         Text sectionSubtitle =
//                 new Text(
//                         "Your personal fitness coach and current training partner."
//                 );

//         sectionSubtitle.setStyle(
//                 "-fx-font-size:12px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         // =====================================================
//         // TRAINER CARD
//         // =====================================================

//         HBox trainerCard =
//                 new HBox(25);

//         trainerCard.setPadding(
//                 new Insets(20)
//         );

//         trainerCard.setStyle(
//                 "-fx-background-color:linear-gradient(to right,#07111d,#091a17);" +
//                 "-fx-background-radius:20px;" +
//                 "-fx-border-color:rgba(98,255,150,0.25);" +
//                 "-fx-border-radius:20px;" +
//                 "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.08),25,0.2,0,5);"
//         );

//         // =====================================================
//         // TRAINER IMAGE
//         // =====================================================

//         StackPane imagePane =
//                 new StackPane();

//         javafx.scene.image.Image trainerImage =
//                 new javafx.scene.image.Image(
//                         "https://images.unsplash.com/photo-1583454110551-21f2fa2afe61"
//                                 + "?auto=format&fit=crop&w=500&q=80",
//                         180,
//                         180,
//                         false,
//                         true
//                 );

//         javafx.scene.image.ImageView imageView =
//                 new javafx.scene.image.ImageView(
//                         trainerImage
//                 );

//         imageView.setFitWidth(180);
//         imageView.setFitHeight(180);
//         imageView.setPreserveRatio(false);

//         Rectangle clip =
//                 new Rectangle(180, 180);

//         clip.setArcWidth(20);
//         clip.setArcHeight(20);

//         imageView.setClip(clip);

//         imagePane.getChildren().add(
//                 imageView
//         );

//         // Available badge

//         Text available =
//                 new Text("● ONLINE");

//         available.setStyle(
//                 "-fx-background-color:#62ff96;" +
//                 "-fx-fill:#06100a;" +
//                 "-fx-font-size:9px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-padding:5px 9px;" +
//                 "-fx-background-radius:10px;"
//         );

//         StackPane.setAlignment(
//                 available,
//                 Pos.TOP_RIGHT
//         );

//         StackPane.setMargin(
//                 available,
//                 new Insets(10)
//         );

//         imagePane.getChildren().add(
//                 available
//         );

//         // =====================================================
//         // TRAINER INFORMATION
//         // =====================================================

//         VBox trainerInfo =
//                 new VBox(10);

//         HBox.setHgrow(
//                 trainerInfo,
//                 Priority.ALWAYS
//         );

//         Text assignedLabel =
//                 new Text("ASSIGNED PERSONAL TRAINER");

//         assignedLabel.setStyle(
//                 "-fx-font-size:9px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#62ff96;" +
//                 "-fx-letter-spacing:1px;"
//         );

//         Text trainerName =
//                 new Text("Rahul Sharma");

//         trainerName.setStyle(
//                 "-fx-font-size:25px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//         );

//         Text specialization =
//                 new Text(
//                         "Strength & Muscle Building Coach"
//                 );

//         specialization.setStyle(
//                 "-fx-font-size:13px;" +
//                 "-fx-fill:#62ff96;"
//         );

//         HBox details =
//                 new HBox(20);

//         Text experience =
//                 new Text("💪 8 Years Experience");

//         experience.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         Text rating =
//                 new Text("★ 4.9 Rating");

//         rating.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-fill:#ffffff;" +
//                 "-fx-font-weight:bold;"
//         );

//         details.getChildren().addAll(
//                 experience,
//                 rating
//         );

//         Text focus =
//                 new Text(
//                         "Current Focus: Muscle Gain & Upper Body Strength"
//                 );

//         focus.setStyle(
//                 "-fx-font-size:12px;" +
//                 "-fx-fill:#b8c1ca;"
//         );

//         // =====================================================
//         // PROGRESS
//         // =====================================================

//         Text progressLabel =
//                 new Text("Training Progress");

//         progressLabel.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         Rectangle progressBg =
//                 new Rectangle(
//                         350,
//                         6,
//                         Color.web("#26313b")
//                 );

//         progressBg.setArcWidth(6);
//         progressBg.setArcHeight(6);

//         Rectangle progress =
//                 new Rectangle(
//                         245,
//                         6,
//                         Color.web(GREEN)
//                 );

//         progress.setArcWidth(6);
//         progress.setArcHeight(6);

//         StackPane progressBar =
//                 new StackPane(
//                         progressBg,
//                         progress
//                 );

//         progressBar.setAlignment(
//                 Pos.CENTER_LEFT
//         );

//         Text progressValue =
//                 new Text("70%");

//         progressValue.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#62ff96;"
//         );

//         // =====================================================
//         // BUTTONS
//         // =====================================================

//         Button profileButton =
//                 new Button("View Trainer Profile");

//         Button messageButton =
//                 new Button("Message Trainer");

//         Button changeButton =
//                 new Button("Change Trainer");

//         styleDarkButton(profileButton);

//         styleDarkButton(messageButton);

//         styleGreenButton(changeButton);

//         profileButton.setOnAction(
//                 e -> showTrainerProfile(
//                         "Rahul Sharma",
//                         "Strength & Muscle Building",
//                         "8 Years Experience",
//                         "4.9",
//                         "₹800 / Session"
//                 )
//         );

//         messageButton.setOnAction(
//                 e -> showMessageDialog(
//                         "Rahul Sharma"
//                 )
//         );

//         changeButton.setOnAction(
//                 e -> showChangeTrainerDialog()
//         );

//         HBox buttons =
//                 new HBox(10);

//         buttons.getChildren().addAll(
//                 profileButton,
//                 messageButton,
//                 changeButton
//         );

//         trainerInfo.getChildren().addAll(
//                 assignedLabel,
//                 trainerName,
//                 specialization,
//                 details,
//                 focus,
//                 progressLabel,
//                 progressBar,
//                 progressValue,
//                 buttons
//         );

//         trainerCard.getChildren().addAll(
//                 imagePane,
//                 trainerInfo
//         );

//         section.getChildren().addAll(
//                 sectionTitle,
//                 sectionSubtitle,
//                 trainerCard
//         );

//         return section;
//     }

//     // =========================================================
//     // ASSIGNED TASKS SECTION
//     // =========================================================

//     private VBox createAssignedTasksSection() {

//         VBox section =
//                 new VBox(15);

//         HBox heading =
//                 new HBox();

//         VBox headingTexts =
//                 new VBox(4);

//         Text title =
//                 new Text("Assigned Tasks");

//         title.setStyle(
//                 "-fx-font-size:20px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//         );

//         Text subtitle =
//                 new Text(
//                         "Tasks assigned by Rahul Sharma for your current fitness plan."
//                 );

//         subtitle.setStyle(
//                 "-fx-font-size:12px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         headingTexts.getChildren().addAll(
//                 title,
//                 subtitle
//         );

//         Region spacer =
//                 new Region();

//         HBox.setHgrow(
//                 spacer,
//                 Priority.ALWAYS
//         );

//         Text taskCount =
//                 new Text("3 Tasks");

//         taskCount.setStyle(
//                 "-fx-background-color:rgba(98,255,150,0.10);" +
//                 "-fx-fill:#62ff96;" +
//                 "-fx-padding:7px 12px;" +
//                 "-fx-background-radius:12px;" +
//                 "-fx-font-size:11px;" +
//                 "-fx-font-weight:bold;"
//         );

//         heading.getChildren().addAll(
//                 headingTexts,
//                 spacer,
//                 taskCount
//         );

//         // =====================================================
//         // TASK GRID
//         // =====================================================

//         HBox taskGrid =
//                 new HBox(15);

//         taskGrid.getChildren().addAll(
//                 createTaskCard(
//                         "Upper Body Workout",
//                         "4 Sets × 10 Reps",
//                         "Today • 05:30 PM",
//                         false
//                 ),
//                 createTaskCard(
//                         "Protein Intake",
//                         "160g Protein",
//                         "Daily Target",
//                         true
//                 ),
//                 createTaskCard(
//                         "Evening Walk",
//                         "30 Minutes",
//                         "Today • 07:00 PM",
//                         false
//                 )
//         );

//         section.getChildren().addAll(
//                 heading,
//                 taskGrid
//         );

//         return section;
//     }

//     // =========================================================
//     // TASK CARD
//     // =========================================================

//     private VBox createTaskCard(
//             String taskName,
//             String taskDetails,
//             String schedule,
//             boolean completed
//     ) {

//         VBox card =
//                 new VBox(10);

//         card.setPadding(
//                 new Insets(18)
//         );

//         card.setPrefWidth(350);

//         card.setStyle(
//                 "-fx-background-color:#0c1520;" +
//                 "-fx-background-radius:16px;" +
//                 "-fx-border-color:#1a2936;" +
//                 "-fx-border-radius:16px;"
//         );

//         HBox top =
//                 new HBox();

//         VBox taskInfo =
//                 new VBox(5);

//         Text label =
//                 new Text("TRAINER TASK");

//         label.setStyle(
//                 "-fx-font-size:8px;" +
//                 "-fx-fill:#62ff96;" +
//                 "-fx-font-weight:bold;"
//         );

//         Text name =
//                 new Text(taskName);

//         name.setStyle(
//                 "-fx-font-size:15px;" +
//                 "-fx-fill:#ffffff;" +
//                 "-fx-font-weight:bold;"
//         );

//         taskInfo.getChildren().addAll(
//                 label,
//                 name
//         );

//         Region spacer =
//                 new Region();

//         HBox.setHgrow(
//                 spacer,
//                 Priority.ALWAYS
//         );

//         CheckBox checkBox =
//                 new CheckBox();

//         checkBox.setSelected(
//                 completed
//         );

//         checkBox.setStyle(
//                 "-fx-text-fill:#62ff96;"
//         );

//         top.getChildren().addAll(
//                 taskInfo,
//                 spacer,
//                 checkBox
//         );

//         Text details =
//                 new Text(taskDetails);

//         details.setStyle(
//                 "-fx-font-size:12px;" +
//                 "-fx-fill:#b8c1ca;"
//         );

//         Text time =
//                 new Text(schedule);

//         time.setStyle(
//                 "-fx-font-size:11px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         Text status =
//                 new Text();

//         status.setStyle(
//                 "-fx-font-size:10px;" +
//                 "-fx-font-weight:bold;"
//         );

//         Runnable updateStatus = () -> {

//             if (checkBox.isSelected()) {

//                 status.setText(
//                         "✓ COMPLETED"
//                 );

//                 status.setStyle(
//                         "-fx-font-size:10px;" +
//                         "-fx-font-weight:bold;" +
//                         "-fx-fill:#62ff96;"
//                 );

//                 name.setStyle(
//                         "-fx-font-size:15px;" +
//                         "-fx-fill:#62ff96;" +
//                         "-fx-font-weight:bold;" +
//                         "-fx-strikethrough:true;"
//                 );

//             } else {

//                 status.setText(
//                         "○ PENDING"
//                 );

//                 status.setStyle(
//                         "-fx-font-size:10px;" +
//                         "-fx-font-weight:bold;" +
//                         "-fx-fill:#8a8d91;"
//                 );

//                 name.setStyle(
//                         "-fx-font-size:15px;" +
//                         "-fx-fill:#ffffff;" +
//                         "-fx-font-weight:bold;"
//                 );
//             }
//         };

//         updateStatus.run();

//         checkBox.setOnAction(
//                 e -> updateStatus.run()
//         );

//         card.getChildren().addAll(
//                 top,
//                 details,
//                 time,
//                 status
//         );

//         return card;
//     }

//     // =========================================================
//     // EXPLORE TRAINERS
//     // =========================================================

//     private VBox createExploreTrainersSection() {

//         VBox section =
//                 new VBox(15);

//         Text title =
//                 new Text("Explore Other Trainers");

//         title.setStyle(
//                 "-fx-font-size:22px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-fill:#ffffff;"
//         );

//         Text subtitle =
//                 new Text(
//                         "Want to change your trainer? Explore other professionals and find the right coach for you."
//                 );

//         subtitle.setStyle(
//                 "-fx-font-size:12px;" +
//                 "-fx-fill:#8a8d91;"
//         );

//         // =====================================================
//         // SEARCH
//         // =====================================================

//         HBox searchBar =
//                 new HBox(12);

//         searchBar.setAlignment(
//                 Pos.CENTER_LEFT
//         );

//         TextField searchField =
//                 new TextField();

//         searchField.setPromptText(
//                 "Search trainer by name or specialization..."
//         );

//         searchField.setPrefWidth(400);

//         searchField.setStyle(
//                 "-fx-background-color:#111a24;" +
//                 "-fx-text-fill:#ffffff;" +
//                 "-fx-prompt-text-fill:#596675;" +
//                 "-fx-background-radius:22px;" +
//                 "-fx-border-color:#1e2b38;" +
//                 "-fx-border-radius:22px;" +
//                 "-fx-padding:11px 18px;"
//         );

//         Button allButton =
//                 createFilterButton(
//                         "All",
//                         true
//                 );

//         Button strengthButton =
//                 createFilterButton(
//                         "Strength",
//                         false
//                 );

//         Button weightLossButton =
//                 createFilterButton(
//                         "Weight Loss",
//                         false
//                 );

//         Button yogaButton =
//                 createFilterButton(
//                         "Yoga",
//                         false
//                 );

//         Button functionalButton =
//                 createFilterButton(
//                         "Functional",
//                         false
//                 );

//         searchBar.getChildren().addAll(
//                 searchField,
//                 allButton,
//                 strengthButton,
//                 weightLossButton,
//                 yogaButton,
//                 functionalButton
//         );

//         // =====================================================
//         // TRAINERS
//         // =====================================================

//         GridPane grid =
//                 new GridPane();

//         grid.setHgap(20);
//         grid.setVgap(20);

//         List<TrainerCard> trainers =
//                 new ArrayList<>();

//         trainers.add(
//                 new TrainerCard(
//                         "Amit Patil",
//                         "Weight Loss Specialist",
//                         "6 Years Experience",
//                         "4.8",
//                         "₹600 / Session",
//                         "https://images.unsplash.com/photo-1534438327276-14e5300c3a48"
//                 )
//         );

//         trainers.add(
//                 new TrainerCard(
//                         "Sneha Joshi",
//                         "Yoga & Flexibility",
//                         "7 Years Experience",
//                         "4.9",
//                         "₹700 / Session",
//                         "https://images.unsplash.com/photo-1544717305-2782549b5136"
//                 )
//         );

//         trainers.add(
//                 new TrainerCard(
//                         "Vikram Singh",
//                         "Bodybuilding Coach",
//                         "10 Years Experience",
//                         "5.0",
//                         "₹1000 / Session",
//                         "https://images.unsplash.com/photo-1567013127542-490d757e51fc"
//                 )
//         );

//         trainers.add(
//                 new TrainerCard(
//                         "Priya Kulkarni",
//                         "Women's Fitness",
//                         "5 Years Experience",
//                         "4.8",
//                         "₹650 / Session",
//                         "https://images.unsplash.com/photo-1594381898411-846e7d193883"
//                 )
//         );

//         trainers.add(
//                 new TrainerCard(
//                         "Arjun Deshmukh",
//                         "Functional Training",
//                         "9 Years Experience",
//                         "4.9",
//                         "₹750 / Session",
//                         "https://images.unsplash.com/photo-1581009146145-b5ef050c2e1e"
//                 )
//         );

//         trainers.add(
//                 new TrainerCard(
//                         "Neha More",
//                         "Strength & Conditioning",
//                         "8 Years Experience",
//                         "4.9",
//                         "₹850 / Session",
//                         "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b"
//                 )
//         );

//         for (int i = 0; i < trainers.size(); i++) {

//             int column =
//                     i % 3;

//             int row =
//                     i / 3;

//             grid.add(
//                     trainers.get(i).createCard(),
//                     column,
//                     row
//             );
//         }

//         // =====================================================
//         // SEARCH FUNCTION
//         // =====================================================

//         searchField.textProperty().addListener(
//                 (observable, oldValue, newValue) -> {

//                     String search =
//                             newValue
//                                     .toLowerCase()
//                                     .trim();

//                     for (Node node :
//                             grid.getChildren()) {

//                         if (node instanceof VBox) {

//                             VBox card =
//                                     (VBox) node;

//                             String trainerData =
//                                     String.valueOf(
//                                             card.getUserData()
//                                     ).toLowerCase();

//                             boolean visible =
//                                     trainerData.contains(
//                                             search
//                                     );

//                             card.setVisible(
//                                     visible
//                             );

//                             card.setManaged(
//                                     visible
//                             );
//                         }
//                     }
//                 }
//         );

//         section.getChildren().addAll(
//                 title,
//                 subtitle,
//                 searchBar,
//                 grid
//         );

//         return section;
//     }

//     // =========================================================
//     // FILTER BUTTON
//     // =========================================================

//     private Button createFilterButton(
//             String text,
//             boolean active
//     ) {

//         Button button =
//                 new Button(text);

//         if (active) {

//             styleGreenButton(button);

//         } else {

//             styleDarkButton(button);
//         }

//         return button;
//     }

//     // =========================================================
//     // TRAINER CARD
//     // =========================================================

//     private class TrainerCard {

//         private String name;
//         private String specialization;
//         private String experience;
//         private String rating;
//         private String price;
//         private String imageUrl;

//         TrainerCard(
//                 String name,
//                 String specialization,
//                 String experience,
//                 String rating,
//                 String price,
//                 String imageUrl
//         ) {

//             this.name = name;
//             this.specialization = specialization;
//             this.experience = experience;
//             this.rating = rating;
//             this.price = price;
//             this.imageUrl = imageUrl;
//         }

//         // =====================================================
//         // CREATE CARD
//         // =====================================================

//         VBox createCard() {

//             VBox card =
//                     new VBox(12);

//             card.setPrefWidth(350);
//             card.setMaxWidth(350);

//             card.setPadding(
//                     new Insets(15)
//             );

//             card.setUserData(
//                     name + " " + specialization
//             );

//             card.setStyle(
//                     "-fx-background-color:#0c1520;" +
//                     "-fx-background-radius:18px;" +
//                     "-fx-border-color:#1a2936;" +
//                     "-fx-border-radius:18px;"
//             );

//             // =================================================
//             // IMAGE
//             // =================================================

//             StackPane imagePane =
//                     new StackPane();

//             javafx.scene.image.Image image =
//                     new javafx.scene.image.Image(
//                             imageUrl
//                                     + "?auto=format&fit=crop&w=500&q=80",
//                             320,
//                             190,
//                             false,
//                             true
//                     );

//             javafx.scene.image.ImageView imageView =
//                     new javafx.scene.image.ImageView(
//                             image
//                     );

//             imageView.setFitWidth(320);
//             imageView.setFitHeight(190);

//             imageView.setPreserveRatio(false);

//             Rectangle clip =
//                     new Rectangle(
//                             320,
//                             190
//                     );

//             clip.setArcWidth(18);
//             clip.setArcHeight(18);

//             imageView.setClip(
//                     clip
//             );

//             imagePane.getChildren().add(
//                     imageView
//             );

//             Text online =
//                     new Text("● AVAILABLE");

//             online.setStyle(
//                     "-fx-background-color:#62ff96;" +
//                     "-fx-fill:#06100a;" +
//                     "-fx-font-size:9px;" +
//                     "-fx-font-weight:bold;" +
//                     "-fx-padding:5px 8px;" +
//                     "-fx-background-radius:10px;"
//             );

//             StackPane.setAlignment(
//                     online,
//                     Pos.TOP_RIGHT
//             );

//             StackPane.setMargin(
//                     online,
//                     new Insets(10)
//             );

//             imagePane.getChildren().add(
//                     online
//             );

//             // =================================================
//             // NAME
//             // =================================================

//             Text trainerName =
//                     new Text(name);

//             trainerName.setStyle(
//                     "-fx-font-size:19px;" +
//                     "-fx-font-weight:bold;" +
//                     "-fx-fill:#ffffff;"
//             );

//             // =================================================
//             // SPECIALIZATION
//             // =================================================

//             Text trainerSpecialization =
//                     new Text(
//                             specialization
//                     );

//             trainerSpecialization.setStyle(
//                     "-fx-font-size:12px;" +
//                     "-fx-fill:#62ff96;"
//             );

//             // =================================================
//             // DETAILS
//             // =================================================

//             HBox details =
//                     new HBox(15);

//             Text exp =
//                     new Text(
//                             "💪 " + experience
//                     );

//             exp.setStyle(
//                     "-fx-font-size:11px;" +
//                     "-fx-fill:#8a8d91;"
//             );

//             Text ratingText =
//                     new Text(
//                             "★ " + rating
//                     );

//             ratingText.setStyle(
//                     "-fx-font-size:11px;" +
//                     "-fx-fill:#ffffff;" +
//                     "-fx-font-weight:bold;"
//             );

//             details.getChildren().addAll(
//                     exp,
//                     ratingText
//             );

//             // =================================================
//             // PRICE
//             // =================================================

//             Text priceText =
//                     new Text(
//                             price
//                     );

//             priceText.setStyle(
//                     "-fx-font-size:14px;" +
//                     "-fx-font-weight:bold;" +
//                     "-fx-fill:#ffffff;"
//             );

//             // =================================================
//             // BUTTONS
//             // =================================================

//             Button profileButton =
//                     new Button(
//                             "View Profile"
//                     );

//             Button bookButton =
//                     new Button(
//                             "Book Trainer"
//                     );

//             styleDarkButton(
//                     profileButton
//             );

//             styleGreenButton(
//                     bookButton
//             );

//             profileButton.setMaxWidth(
//                     Double.MAX_VALUE
//             );

//             bookButton.setMaxWidth(
//                     Double.MAX_VALUE
//             );

//             HBox.setHgrow(
//                     profileButton,
//                     Priority.ALWAYS
//             );

//             HBox.setHgrow(
//                     bookButton,
//                     Priority.ALWAYS
//             );

//             // =================================================
//             // PROFILE ACTION
//             // =================================================

//             profileButton.setOnAction(
//                     e -> showTrainerProfile(
//                             name,
//                             specialization,
//                             experience,
//                             rating,
//                             price
//                     )
//             );

//             // =================================================
//             // BOOK ACTION
//             // =================================================

//             bookButton.setOnAction(
//                     e -> showBookingDialog(
//                             name,
//                             specialization,
//                             price
//                     )
//             );

//             HBox buttons =
//                     new HBox(10);

//             buttons.getChildren().addAll(
//                     profileButton,
//                     bookButton
//             );

//             // =================================================
//             // ADD EVERYTHING
//             // =================================================

//             card.getChildren().addAll(
//                     imagePane,
//                     trainerName,
//                     trainerSpecialization,
//                     details,
//                     priceText,
//                     buttons
//             );

//             // =================================================
//             // HOVER
//             // =================================================

//             card.setOnMouseEntered(
//                     e -> {

//                         card.setStyle(
//                                 "-fx-background-color:#101c29;" +
//                                 "-fx-background-radius:18px;" +
//                                 "-fx-border-color:#62ff96;" +
//                                 "-fx-border-radius:18px;" +
//                                 "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.15),20,0.2,0,5);"
//                         );
//                     }
//             );

//             card.setOnMouseExited(
//                     e -> {

//                         card.setStyle(
//                                 "-fx-background-color:#0c1520;" +
//                                 "-fx-background-radius:18px;" +
//                                 "-fx-border-color:#1a2936;" +
//                                 "-fx-border-radius:18px;"
//                         );
//                     }
//             );

//             return card;
//         }
//     }

//     // =========================================================
//     // TRAINER PROFILE
//     // =========================================================

//     private void showTrainerProfile(
//             String name,
//             String specialization,
//             String experience,
//             String rating,
//             String price
//     ) {

//         Alert alert =
//                 new Alert(
//                         Alert.AlertType.INFORMATION
//                 );

//         alert.setTitle(
//                 "Trainer Profile"
//         );

//         alert.setHeaderText(
//                 "🏋 " + name
//         );

//         alert.setContentText(
//                 "SPECIALIZATION\n"
//                         + specialization
//                         + "\n\n"

//                         + "EXPERIENCE\n"
//                         + experience
//                         + "\n\n"

//                         + "RATING\n"
//                         + "★ " + rating
//                         + "\n\n"

//                         + "SESSION PRICE\n"
//                         + price
//                         + "\n\n"

//                         + "ABOUT TRAINER\n"
//                         + "Professional fitness trainer dedicated "
//                         + "to helping clients achieve their fitness goals."
//                         + "\n\n"

//                         + "CERTIFICATIONS\n"
//                         + "• Certified Personal Trainer\n"
//                         + "• Strength & Conditioning Coach\n"
//                         + "• Nutrition Fundamentals"
//         );

//         alert.showAndWait();
//     }

//     // =========================================================
//     // BOOK TRAINER
//     // =========================================================

//     private void showBookingDialog(
//             String name,
//             String specialization,
//             String price
//     ) {

//         Alert alert =
//                 new Alert(
//                         Alert.AlertType.CONFIRMATION
//                 );

//         alert.setTitle(
//                 "Book Trainer"
//         );

//         alert.setHeaderText(
//                 "Book " + name
//         );

//         alert.setContentText(
//                 "Trainer: "
//                         + name
//                         + "\n\n"

//                         + "Specialization: "
//                         + specialization
//                         + "\n\n"

//                         + "Price: "
//                         + price
//                         + "\n\n"

//                         + "Do you want to send a booking request?"
//         );

//         alert.showAndWait()
//                 .ifPresent(response -> {

//                     Alert success =
//                             new Alert(
//                                     Alert.AlertType.INFORMATION
//                             );

//                     success.setTitle(
//                             "Booking Request"
//                     );

//                     success.setHeaderText(
//                             "Request Sent ✓"
//                     );

//                     success.setContentText(
//                             "Your booking request has been sent to "
//                                     + name
//                                     + ".\n\n"
//                                     + "You will be notified once the trainer accepts your request."
//                     );

//                     success.showAndWait();
//                 });
//     }

//     // =========================================================
//     // MESSAGE TRAINER
//     // =========================================================

//     private void showMessageDialog(
//             String trainerName
//     ) {

//         Alert alert =
//                 new Alert(
//                         Alert.AlertType.INFORMATION
//                 );

//         alert.setTitle(
//                 "Message Trainer"
//         );

//         alert.setHeaderText(
//                 "Chat with " + trainerName
//         );

//         alert.setContentText(
//                 "Messaging feature will allow you to communicate "
//                         + "directly with your assigned trainer."
//                         + "\n\n"
//                         + "You can ask about:"
//                         + "\n• Workout"
//                         + "\n• Diet"
//                         + "\n• Progress"
//                         + "\n• Exercise technique"
//         );

//         alert.showAndWait();
//     }

//     // =========================================================
//     // CHANGE TRAINER
//     // =========================================================

//     private void showChangeTrainerDialog() {

//         Alert alert =
//                 new Alert(
//                         Alert.AlertType.CONFIRMATION
//                 );

//         alert.setTitle(
//                 "Change Trainer"
//         );

//         alert.setHeaderText(
//                 "Change Your Assigned Trainer?"
//         );

//         alert.setContentText(
//                 "You can explore other trainers below "
//                         + "and send a booking request."
//         );

//         alert.showAndWait();
//     }

//     // =========================================================
//     // GREEN BUTTON STYLE
//     // =========================================================

//     private void styleGreenButton(
//             Button button
//     ) {

//         String normal =
//                 "-fx-background-color:#62ff96;" +
//                 "-fx-text-fill:#06100a;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-background-radius:10px;" +
//                 "-fx-padding:10px 15px;" +
//                 "-fx-cursor:hand;";

//         String hover =
//                 "-fx-background-color:#91ffb5;" +
//                 "-fx-text-fill:#000000;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-background-radius:10px;" +
//                 "-fx-padding:10px 15px;" +
//                 "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.35),15,0.2,0,2);" +
//                 "-fx-cursor:hand;";

//         button.setStyle(normal);

//         button.setOnMouseEntered(
//                 e -> button.setStyle(hover)
//         );

//         button.setOnMouseExited(
//                 e -> button.setStyle(normal)
//         );
//     }

//     // =========================================================
//     // DARK BUTTON STYLE
//     // =========================================================

//     private void styleDarkButton(
//             Button button
//     ) {

//         String normal =
//                 "-fx-background-color:#151e28;" +
//                 "-fx-text-fill:#ffffff;" +
//                 "-fx-border-color:#293642;" +
//                 "-fx-border-radius:10px;" +
//                 "-fx-background-radius:10px;" +
//                 "-fx-padding:10px 15px;" +
//                 "-fx-cursor:hand;";

//         String hover =
//                 "-fx-background-color:rgba(98,255,150,0.08);" +
//                 "-fx-text-fill:#62ff96;" +
//                 "-fx-border-color:#62ff96;" +
//                 "-fx-border-radius:10px;" +
//                 "-fx-background-radius:10px;" +
//                 "-fx-padding:10px 15px;" +
//                 "-fx-cursor:hand;";

//         button.setStyle(normal);

//         button.setOnMouseEntered(
//                 e -> button.setStyle(hover)
//         );

//         button.setOnMouseExited(
//                 e -> button.setStyle(normal)
//         );
//     }
// }




package com.visionx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GymTrainerView {

    // =========================================================
    // COLORS
    // =========================================================

    private final String GREEN = "#62ff96";
    private final String DARK_BG = "#080C14";
    private final String CARD_BG = "#0c1520";
    private final String LIGHT_TEXT = "#ffffff";
    private final String MUTED_TEXT = "#8a8d91";

    // =========================================================
    // MAIN TRAINER PAGE
    // =========================================================

    public Scene getTrainerScene(Runnable callBackAction) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color:" + DARK_BG + ";"
        );

        // =====================================================
        // HEADER
        // =====================================================

        VBox header = new VBox(8);

        header.setPadding(
                new Insets(30, 40, 20, 40)
        );

        Text title = new Text("My ");

        title.setStyle(
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text greenTitle = new Text("Gym Trainer");

        greenTitle.setStyle(
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#62ff96;"
        );

        HBox titleBox = new HBox(
                title,
                greenTitle
        );

        Text subtitle = new Text(
                "Manage your assigned trainer, complete assigned tasks and explore professional trainers."
        );

        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-fill:#8a8d91;"
        );

        header.getChildren().addAll(
                titleBox,
                subtitle
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox content = new VBox(35);

        content.setPadding(
                new Insets(10, 40, 50, 40)
        );

        // =====================================================
        // ASSIGNED TRAINER
        // =====================================================

        VBox assignedTrainer =
                createAssignedTrainerSection();

        // =====================================================
        // ASSIGNED TASKS
        // =====================================================

        VBox assignedTasks =
                createAssignedTasksSection();

        // =====================================================
        // EXPLORE TRAINERS
        // =====================================================

        VBox exploreTrainers =
                createExploreTrainersSection();

        content.getChildren().addAll(
                assignedTrainer,
                assignedTasks,
                exploreTrainers
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background:#080C14;" +
                "-fx-background-color:#080C14;" +
                "-fx-border-color:transparent;"
        );

        root.setTop(header);
        root.setCenter(scrollPane);

        return new Scene(
                root,
                1200,
                800
        );
    }

    // =========================================================
    // ASSIGNED TRAINER SECTION
    // =========================================================

    private VBox createAssignedTrainerSection() {

        VBox section = new VBox(15);

        Text title =
                new Text("Your Assigned Trainer");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text subtitle =
                new Text(
                        "Your personal fitness coach and current training partner."
                );

        subtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#8a8d91;"
        );

        HBox trainerCard =
                new HBox(25);

        trainerCard.setPadding(
                new Insets(20)
        );

        trainerCard.setStyle(
                "-fx-background-color:#09151c;" +
                "-fx-background-radius:20px;" +
                "-fx-border-color:#1c4430;" +
                "-fx-border-radius:20px;" +
                "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.08),25,0.2,0,5);"
        );

        // =====================================================
        // IMAGE
        // =====================================================

        StackPane imagePane =
                new StackPane();

        javafx.scene.image.Image image =
                new javafx.scene.image.Image(
                        "https://images.unsplash.com/photo-1583454110551-21f2fa2afe61"
                                + "?auto=format&fit=crop&w=500&q=80",
                        180,
                        180,
                        false,
                        true
                );

        javafx.scene.image.ImageView imageView =
                new javafx.scene.image.ImageView(image);

        imageView.setFitWidth(180);
        imageView.setFitHeight(180);
        imageView.setPreserveRatio(false);

        Rectangle clip =
                new Rectangle(180, 180);

        clip.setArcWidth(20);
        clip.setArcHeight(20);

        imageView.setClip(clip);

        imagePane.getChildren().add(imageView);

        Text online =
                new Text("● ONLINE");

        online.setStyle(
                "-fx-background-color:#62ff96;" +
                "-fx-fill:#06100a;" +
                "-fx-font-size:9px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 9px;" +
                "-fx-background-radius:10px;"
        );

        StackPane.setAlignment(
                online,
                Pos.TOP_RIGHT
        );

        StackPane.setMargin(
                online,
                new Insets(10)
        );

        imagePane.getChildren().add(online);

        // =====================================================
        // TRAINER INFO
        // =====================================================

        VBox info =
                new VBox(10);

        HBox.setHgrow(
                info,
                Priority.ALWAYS
        );

        Text assignedLabel =
                new Text("ASSIGNED PERSONAL TRAINER");

        assignedLabel.setStyle(
                "-fx-font-size:9px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#62ff96;"
        );

        Text trainerName =
                new Text("Rahul Sharma");

        trainerName.setStyle(
                "-fx-font-size:25px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text specialization =
                new Text(
                        "Strength & Muscle Building Coach"
                );

        specialization.setStyle(
                "-fx-font-size:13px;" +
                "-fx-fill:#62ff96;"
        );

        HBox details =
                new HBox(20);

        Text experience =
                new Text(
                        "💪 8 Years Experience"
                );

        experience.setStyle(
                "-fx-font-size:11px;" +
                "-fx-fill:#8a8d91;"
        );

        Text rating =
                new Text(
                        "★ 4.9 Rating"
                );

        rating.setStyle(
                "-fx-font-size:11px;" +
                "-fx-fill:#ffffff;" +
                "-fx-font-weight:bold;"
        );

        details.getChildren().addAll(
                experience,
                rating
        );

        Text focus =
                new Text(
                        "Current Focus: Muscle Gain & Upper Body Strength"
                );

        focus.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#b8c1ca;"
        );

        // =====================================================
        // PROGRESS
        // =====================================================

        Text progressLabel =
                new Text("Training Progress");

        progressLabel.setStyle(
                "-fx-font-size:11px;" +
                "-fx-fill:#8a8d91;"
        );

        Rectangle progressBackground =
                new Rectangle(
                        350,
                        6,
                        Color.web("#26313b")
                );

        Rectangle progress =
                new Rectangle(
                        245,
                        6,
                        Color.web(GREEN)
                );

        StackPane progressBar =
                new StackPane(
                        progressBackground,
                        progress
                );

        progressBar.setAlignment(
                Pos.CENTER_LEFT
        );

        Text progressValue =
                new Text("70%");

        progressValue.setStyle(
                "-fx-font-size:11px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#62ff96;"
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        Button profileButton =
                new Button("View Trainer Profile");

        Button messageButton =
                new Button("Message Trainer");

        Button changeButton =
                new Button("Change Trainer");

        styleDarkButton(profileButton);
        styleDarkButton(messageButton);
        styleGreenButton(changeButton);

        profileButton.setOnAction(
                e -> showTrainerProfile(
                        "Rahul Sharma",
                        "Strength & Muscle Building Coach",
                        "8 Years Experience",
                        "4.9",
                        "₹800 / Session",
                        "rahul"
                )
        );

        messageButton.setOnAction(
                e -> showMessageWindow("Rahul Sharma")
        );

        changeButton.setOnAction(
                e -> showChangeTrainerDialog()
        );

        HBox buttons =
                new HBox(10);

        buttons.getChildren().addAll(
                profileButton,
                messageButton,
                changeButton
        );

        info.getChildren().addAll(
                assignedLabel,
                trainerName,
                specialization,
                details,
                focus,
                progressLabel,
                progressBar,
                progressValue,
                buttons
        );

        trainerCard.getChildren().addAll(
                imagePane,
                info
        );

        section.getChildren().addAll(
                title,
                subtitle,
                trainerCard
        );

        return section;
    }

    // =========================================================
    // ASSIGNED TASKS
    // =========================================================

    private VBox createAssignedTasksSection() {

        VBox section =
                new VBox(15);

        HBox heading =
                new HBox();

        VBox texts =
                new VBox(4);

        Text title =
                new Text("Assigned Tasks");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text subtitle =
                new Text(
                        "Tasks assigned by Rahul Sharma for your current fitness plan."
                );

        subtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#8a8d91;"
        );

        texts.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Text count =
                new Text("3 Tasks");

        count.setStyle(
                "-fx-background-color:rgba(98,255,150,0.10);" +
                "-fx-fill:#62ff96;" +
                "-fx-padding:7px 12px;" +
                "-fx-background-radius:12px;" +
                "-fx-font-size:11px;" +
                "-fx-font-weight:bold;"
        );

        heading.getChildren().addAll(
                texts,
                spacer,
                count
        );

        HBox taskGrid =
                new HBox(15);

        taskGrid.getChildren().addAll(

                createTaskCard(
                        "Upper Body Workout",
                        "4 Sets × 10 Reps",
                        "Today • 05:30 PM",
                        false
                ),

                createTaskCard(
                        "Protein Intake",
                        "160g Protein",
                        "Daily Target",
                        true
                ),

                createTaskCard(
                        "Evening Walk",
                        "30 Minutes",
                        "Today • 07:00 PM",
                        false
                )
        );

        section.getChildren().addAll(
                heading,
                taskGrid
        );

        return section;
    }

    // =========================================================
    // TASK CARD
    // =========================================================

    private VBox createTaskCard(
            String taskName,
            String taskDetails,
            String schedule,
            boolean completed
    ) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(18)
        );

        card.setPrefWidth(350);

        card.setStyle(
                "-fx-background-color:#0c1520;" +
                "-fx-background-radius:16px;" +
                "-fx-border-color:#1a2936;" +
                "-fx-border-radius:16px;"
        );

        HBox top =
                new HBox();

        VBox taskInfo =
                new VBox(5);

        Text label =
                new Text("TRAINER TASK");

        label.setStyle(
                "-fx-font-size:8px;" +
                "-fx-fill:#62ff96;" +
                "-fx-font-weight:bold;"
        );

        Text name =
                new Text(taskName);

        name.setStyle(
                "-fx-font-size:15px;" +
                "-fx-fill:#ffffff;" +
                "-fx-font-weight:bold;"
        );

        taskInfo.getChildren().addAll(
                label,
                name
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        CheckBox checkBox =
                new CheckBox();

        checkBox.setSelected(
                completed
        );

        top.getChildren().addAll(
                taskInfo,
                spacer,
                checkBox
        );

        Text details =
                new Text(taskDetails);

        details.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#b8c1ca;"
        );

        Text time =
                new Text(schedule);

        time.setStyle(
                "-fx-font-size:11px;" +
                "-fx-fill:#8a8d91;"
        );

        Text status =
                new Text();

        Runnable updateStatus = () -> {

            if (checkBox.isSelected()) {

                status.setText("✓ COMPLETED");

                status.setStyle(
                        "-fx-font-size:10px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#62ff96;"
                );

                name.setStyle(
                        "-fx-font-size:15px;" +
                        "-fx-fill:#62ff96;" +
                        "-fx-font-weight:bold;" +
                        "-fx-strikethrough:true;"
                );

            } else {

                status.setText("○ PENDING");

                status.setStyle(
                        "-fx-font-size:10px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-fill:#8a8d91;"
                );

                name.setStyle(
                        "-fx-font-size:15px;" +
                        "-fx-fill:#ffffff;" +
                        "-fx-font-weight:bold;"
                );
            }
        };

        updateStatus.run();

        checkBox.setOnAction(
                e -> updateStatus.run()
        );

        card.getChildren().addAll(
                top,
                details,
                time,
                status
        );

        return card;
    }

    // =========================================================
    // EXPLORE TRAINERS
    // =========================================================

    private VBox createExploreTrainersSection() {

        VBox section =
                new VBox(15);

        Text title =
                new Text("Explore Other Trainers");

        title.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text subtitle =
                new Text(
                        "Explore other professional trainers and find the right coach for you."
                );

        subtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#8a8d91;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        HBox searchBar =
                new HBox(12);

        searchBar.setAlignment(
                Pos.CENTER_LEFT
        );

        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search trainer by name or specialization..."
        );

        searchField.setPrefWidth(400);

        searchField.setStyle(
                "-fx-background-color:#111a24;" +
                "-fx-text-fill:#ffffff;" +
                "-fx-prompt-text-fill:#596675;" +
                "-fx-background-radius:22px;" +
                "-fx-border-color:#1e2b38;" +
                "-fx-border-radius:22px;" +
                "-fx-padding:11px 18px;"
        );

        Button allButton =
                createFilterButton("All", true);

        Button strengthButton =
                createFilterButton("Strength", false);

        Button weightLossButton =
                createFilterButton("Weight Loss", false);

        Button yogaButton =
                createFilterButton("Yoga", false);

        Button functionalButton =
                createFilterButton("Functional", false);

        searchBar.getChildren().addAll(
                searchField,
                allButton,
                strengthButton,
                weightLossButton,
                yogaButton,
                functionalButton
        );

        // =====================================================
        // GRID
        // =====================================================

        GridPane grid =
                new GridPane();

        grid.setHgap(20);
        grid.setVgap(20);

        List<TrainerCard> trainers =
                new ArrayList<>();

        trainers.add(
                new TrainerCard(
                        "Amit Patil",
                        "Weight Loss Specialist",
                        "6 Years Experience",
                        "4.8",
                        "₹600 / Session",
                        "https://images.unsplash.com/photo-1534438327276-14e5300c3a48"
                )
        );

        trainers.add(
                new TrainerCard(
                        "Sneha Joshi",
                        "Yoga & Flexibility",
                        "7 Years Experience",
                        "4.9",
                        "₹700 / Session",
                        "https://images.unsplash.com/photo-1544717305-2782549b5136"
                )
        );

        trainers.add(
                new TrainerCard(
                        "Vikram Singh",
                        "Bodybuilding Coach",
                        "10 Years Experience",
                        "5.0",
                        "₹1000 / Session",
                        "https://images.unsplash.com/photo-1567013127542-490d757e51fc"
                )
        );

        trainers.add(
                new TrainerCard(
                        "Priya Kulkarni",
                        "Women's Fitness",
                        "5 Years Experience",
                        "4.8",
                        "₹650 / Session",
                        "https://images.unsplash.com/photo-1594381898411-846e7d193883"
                )
        );

        trainers.add(
                new TrainerCard(
                        "Arjun Deshmukh",
                        "Functional Training",
                        "9 Years Experience",
                        "4.9",
                        "₹750 / Session",
                        "https://images.unsplash.com/photo-1581009146145-b5ef050c2e1e"
                )
        );

        trainers.add(
                new TrainerCard(
                        "Neha More",
                        "Strength & Conditioning",
                        "8 Years Experience",
                        "4.9",
                        "₹850 / Session",
                        "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b"
                )
        );

        for (int i = 0; i < trainers.size(); i++) {

            int column = i % 3;
            int row = i / 3;

            grid.add(
                    trainers.get(i).createCard(),
                    column,
                    row
            );
        }

        // =====================================================
        // SEARCH
        // =====================================================

        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    String search =
                            newValue
                                    .toLowerCase()
                                    .trim();

                    for (Node node :
                            grid.getChildren()) {

                        if (node instanceof VBox) {

                            VBox card =
                                    (VBox) node;

                            String trainerData =
                                    String.valueOf(
                                            card.getUserData()
                                    ).toLowerCase();

                            boolean visible =
                                    trainerData.contains(
                                            search
                                    );

                            card.setVisible(
                                    visible
                            );

                            card.setManaged(
                                    visible
                            );
                        }
                    }
                }
        );

        section.getChildren().addAll(
                title,
                subtitle,
                searchBar,
                grid
        );

        return section;
    }

    // =========================================================
    // FILTER BUTTON
    // =========================================================

    private Button createFilterButton(
            String text,
            boolean active
    ) {

        Button button =
                new Button(text);

        if (active) {
            styleGreenButton(button);
        } else {
            styleDarkButton(button);
        }

        return button;
    }

    // =========================================================
    // TRAINER CARD
    // =========================================================

    private class TrainerCard {

        private String name;
        private String specialization;
        private String experience;
        private String rating;
        private String price;
        private String imageUrl;

        TrainerCard(
                String name,
                String specialization,
                String experience,
                String rating,
                String price,
                String imageUrl
        ) {

            this.name = name;
            this.specialization = specialization;
            this.experience = experience;
            this.rating = rating;
            this.price = price;
            this.imageUrl = imageUrl;
        }

        VBox createCard() {

            VBox card =
                    new VBox(12);

            card.setPrefWidth(350);
            card.setMaxWidth(350);

            card.setPadding(
                    new Insets(15)
            );

            card.setUserData(
                    name + " " + specialization
            );

            card.setStyle(
                    "-fx-background-color:#0c1520;" +
                    "-fx-background-radius:18px;" +
                    "-fx-border-color:#1a2936;" +
                    "-fx-border-radius:18px;"
            );

            // =================================================
            // IMAGE
            // =================================================

            StackPane imagePane =
                    new StackPane();

            javafx.scene.image.Image image =
                    new javafx.scene.image.Image(
                            imageUrl
                                    + "?auto=format&fit=crop&w=500&q=80",
                            320,
                            190,
                            false,
                            true
                    );

            javafx.scene.image.ImageView imageView =
                    new javafx.scene.image.ImageView(image);

            imageView.setFitWidth(320);
            imageView.setFitHeight(190);
            imageView.setPreserveRatio(false);

            Rectangle clip =
                    new Rectangle(320, 190);

            clip.setArcWidth(18);
            clip.setArcHeight(18);

            imageView.setClip(clip);

            imagePane.getChildren().add(imageView);

            Text online =
                    new Text("● AVAILABLE");

            online.setStyle(
                    "-fx-background-color:#62ff96;" +
                    "-fx-fill:#06100a;" +
                    "-fx-font-size:9px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 8px;" +
                    "-fx-background-radius:10px;"
            );

            StackPane.setAlignment(
                    online,
                    Pos.TOP_RIGHT
            );

            StackPane.setMargin(
                    online,
                    new Insets(10)
            );

            imagePane.getChildren().add(online);

            // =================================================
            // TEXT
            // =================================================

            Text trainerName =
                    new Text(name);

            trainerName.setStyle(
                    "-fx-font-size:19px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-fill:#ffffff;"
            );

            Text trainerSpecialization =
                    new Text(specialization);

            trainerSpecialization.setStyle(
                    "-fx-font-size:12px;" +
                    "-fx-fill:#62ff96;"
            );

            HBox details =
                    new HBox(15);

            Text exp =
                    new Text(
                            "💪 " + experience
                    );

            exp.setStyle(
                    "-fx-font-size:11px;" +
                    "-fx-fill:#8a8d91;"
            );

            Text ratingText =
                    new Text(
                            "★ " + rating
                    );

            ratingText.setStyle(
                    "-fx-font-size:11px;" +
                    "-fx-fill:#ffffff;" +
                    "-fx-font-weight:bold;"
            );

            details.getChildren().addAll(
                    exp,
                    ratingText
            );

            Text priceText =
                    new Text(price);

            priceText.setStyle(
                    "-fx-font-size:14px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-fill:#ffffff;"
            );

            // =================================================
            // BUTTONS
            // =================================================

            Button profileButton =
                    new Button("View Profile");

            Button bookButton =
                    new Button("Book Trainer");

            styleDarkButton(profileButton);
            styleGreenButton(bookButton);

            HBox.setHgrow(
                    profileButton,
                    Priority.ALWAYS
            );

            HBox.setHgrow(
                    bookButton,
                    Priority.ALWAYS
            );

            profileButton.setMaxWidth(
                    Double.MAX_VALUE
            );

            bookButton.setMaxWidth(
                    Double.MAX_VALUE
            );

            profileButton.setOnAction(
                    e -> showTrainerProfile(
                            name,
                            specialization,
                            experience,
                            rating,
                            price,
                            name
                    )
            );

            bookButton.setOnAction(
                    e -> showBookingDialog(
                            name,
                            specialization,
                            price
                    )
            );

            HBox buttons =
                    new HBox(10);

            buttons.getChildren().addAll(
                    profileButton,
                    bookButton
            );

            card.getChildren().addAll(
                    imagePane,
                    trainerName,
                    trainerSpecialization,
                    details,
                    priceText,
                    buttons
            );

            // =================================================
            // HOVER
            // =================================================

            card.setOnMouseEntered(
                    e -> card.setStyle(
                            "-fx-background-color:#101c29;" +
                            "-fx-background-radius:18px;" +
                            "-fx-border-color:#62ff96;" +
                            "-fx-border-radius:18px;" +
                            "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.15),20,0.2,0,5);"
                    )
            );

            card.setOnMouseExited(
                    e -> card.setStyle(
                            "-fx-background-color:#0c1520;" +
                            "-fx-background-radius:18px;" +
                            "-fx-border-color:#1a2936;" +
                            "-fx-border-radius:18px;"
                    )
            );

            return card;
        }
    }

    // =========================================================
    // FULL TRAINER PROFILE WINDOW
    // =========================================================

    private void showTrainerProfile(
            String name,
            String specialization,
            String experience,
            String rating,
            String price,
            String trainerId
    ) {

        Stage stage =
                new Stage();

        stage.initModality(
                Modality.APPLICATION_MODAL
        );

        stage.setTitle(
                name + " - Trainer Profile"
        );

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#080C14;"
        );

        // =====================================================
        // TOP
        // =====================================================

        VBox top =
                new VBox(5);

        top.setPadding(
                new Insets(25)
        );

        Text heading =
                new Text("Trainer Profile");

        heading.setStyle(
                "-fx-font-size:26px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text sub =
                new Text(
                        "Professional fitness coach"
                );

        sub.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#8a8d91;"
        );

        top.getChildren().addAll(
                heading,
                sub
        );

        // =====================================================
        // CONTENT
        // =====================================================

        VBox content =
                new VBox(18);

        content.setPadding(
                new Insets(0, 25, 25, 25)
        );

        StackPane profileImagePane =
                new StackPane();

        javafx.scene.image.Image image =
                new javafx.scene.image.Image(
                        getTrainerImage(name)
                                + "?auto=format&fit=crop&w=700&q=80",
                        180,
                        180,
                        false,
                        true
                );

        javafx.scene.image.ImageView imageView =
                new javafx.scene.image.ImageView(image);

        imageView.setFitWidth(180);
        imageView.setFitHeight(180);
        imageView.setPreserveRatio(false);

        Rectangle clip =
                new Rectangle(180, 180);

        clip.setArcWidth(25);
        clip.setArcHeight(25);

        imageView.setClip(clip);

        profileImagePane.getChildren().add(
                imageView
        );

        Text nameText =
                new Text(name);

        nameText.setStyle(
                "-fx-font-size:27px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text specializationText =
                new Text(specialization);

        specializationText.setStyle(
                "-fx-font-size:14px;" +
                "-fx-fill:#62ff96;"
        );

        HBox stats =
                new HBox(15);

        stats.getChildren().addAll(
                createProfileStat(
                        "EXPERIENCE",
                        experience
                ),
                createProfileStat(
                        "RATING",
                        "★ " + rating
                ),
                createProfileStat(
                        "SESSION",
                        price
                )
        );

        VBox aboutCard =
                createProfileInfoCard(
                        "About Trainer",
                        "Professional fitness trainer dedicated to helping clients achieve their fitness goals through personalized workouts, proper exercise techniques and consistent progress tracking."
                );

        VBox certificationCard =
                createProfileInfoCard(
                        "Certifications",
                        "• Certified Personal Trainer\n"
                                + "• Strength & Conditioning Coach\n"
                                + "• Nutrition Fundamentals\n"
                                + "• Advanced Fitness Training"
                );

        VBox specializationCard =
                createProfileInfoCard(
                        "Training Specializations",
                        "• Strength Training\n"
                                + "• Muscle Building\n"
                                + "• Fat Loss\n"
                                + "• Personalized Workout Plans"
                );

        Button message =
                new Button(
                        "Message Trainer"
                );

        Button book =
                new Button(
                        "Book Trainer"
                );

        styleDarkButton(message);
        styleGreenButton(book);

        HBox actions =
                new HBox(12);

        actions.getChildren().addAll(
                message,
                book
        );

        message.setOnAction(
                e -> showMessageWindow(name)
        );

        book.setOnAction(
                e -> {
                    stage.close();

                    showBookingDialog(
                            name,
                            specialization,
                            price
                    );
                }
        );

        content.getChildren().addAll(
                profileImagePane,
                nameText,
                specializationText,
                stats,
                aboutCard,
                certificationCard,
                specializationCard,
                actions
        );

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background-color:#080C14;" +
                "-fx-background:#080C14;" +
                "-fx-border-color:transparent;"
        );

        root.setTop(top);
        root.setCenter(scroll);

        Scene scene =
                new Scene(
                        root,
                        700,
                        750
                );

        stage.setScene(scene);
        stage.showAndWait();
    }

    // =========================================================
    // PROFILE STAT
    // =========================================================

    private VBox createProfileStat(
            String title,
            String value
    ) {

        VBox box =
                new VBox(5);

        box.setPadding(
                new Insets(12)
        );

        box.setPrefWidth(190);

        box.setStyle(
                "-fx-background-color:#0c1520;" +
                "-fx-background-radius:12px;" +
                "-fx-border-color:#1a2936;" +
                "-fx-border-radius:12px;"
        );

        Text titleText =
                new Text(title);

        titleText.setStyle(
                "-fx-font-size:9px;" +
                "-fx-fill:#8a8d91;" +
                "-fx-font-weight:bold;"
        );

        Text valueText =
                new Text(value);

        valueText.setStyle(
                "-fx-font-size:13px;" +
                "-fx-fill:#ffffff;" +
                "-fx-font-weight:bold;"
        );

        box.getChildren().addAll(
                titleText,
                valueText
        );

        return box;
    }

    // =========================================================
    // PROFILE INFO CARD
    // =========================================================

    private VBox createProfileInfoCard(
            String title,
            String content
    ) {

        VBox box =
                new VBox(8);

        box.setPadding(
                new Insets(16)
        );

        box.setStyle(
                "-fx-background-color:#0c1520;" +
                "-fx-background-radius:14px;" +
                "-fx-border-color:#1a2936;" +
                "-fx-border-radius:14px;"
        );

        Text titleText =
                new Text(title);

        titleText.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#62ff96;"
        );

        Text contentText =
                new Text(content);

        contentText.setWrappingWidth(600);

        contentText.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:#b8c1ca;"
        );

        box.getChildren().addAll(
                titleText,
                contentText
        );

        return box;
    }

    // =========================================================
    // TRAINER IMAGE
    // =========================================================

    private String getTrainerImage(
            String name
    ) {

        if (name.equals("Rahul Sharma")) {

            return "https://images.unsplash.com/photo-1583454110551-21f2fa2afe61";

        } else if (name.equals("Amit Patil")) {

            return "https://images.unsplash.com/photo-1534438327276-14e5300c3a48";

        } else if (name.equals("Sneha Joshi")) {

            return "https://images.unsplash.com/photo-1544717305-2782549b5136";

        } else if (name.equals("Vikram Singh")) {

            return "https://images.unsplash.com/photo-1567013127542-490d757e51fc";

        } else if (name.equals("Priya Kulkarni")) {

            return "https://images.unsplash.com/photo-1594381898411-846e7d193883";

        } else if (name.equals("Arjun Deshmukh")) {

            return "https://images.unsplash.com/photo-1581009146145-b5ef050c2e1e";

        } else {

            return "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b";
        }
    }

    // =========================================================
    // MESSAGE WINDOW
    // =========================================================

    private void showMessageWindow(
            String trainerName
    ) {

        Stage chatStage =
                new Stage();

        chatStage.initModality(
                Modality.APPLICATION_MODAL
        );

        chatStage.setTitle(
                "Chat - " + trainerName
        );

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#080C14;"
        );

        // =====================================================
        // CHAT HEADER
        // =====================================================

        HBox header =
                new HBox(12);

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setPadding(
                new Insets(18)
        );

        header.setStyle(
                "-fx-background-color:#0c1520;" +
                "-fx-border-color:#1a2936;" +
                "-fx-border-width:0 0 1px 0;"
        );

        StackPane avatar =
                new StackPane();

        javafx.scene.shape.Circle circle =
                new javafx.scene.shape.Circle(
                        22,
                        Color.web(GREEN)
                );

        Text initial =
                new Text(
                        trainerName.substring(0, 1)
                );

        initial.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#06100a;"
        );

        avatar.getChildren().addAll(
                circle,
                initial
        );

        VBox trainerHeader =
                new VBox(3);

        Text trainerText =
                new Text(trainerName);

        trainerText.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:#ffffff;"
        );

        Text online =
                new Text(
                        "● Online"
                );

        online.setStyle(
                "-fx-font-size:10px;" +
                "-fx-fill:#62ff96;"
        );

        trainerHeader.getChildren().addAll(
                trainerText,
                online
        );

        header.getChildren().addAll(
                avatar,
                trainerHeader
        );

        // =====================================================
        // CHAT AREA
        // =====================================================

        VBox chatArea =
                new VBox(12);

        chatArea.setPadding(
                new Insets(20)
        );

        ScrollPane chatScroll =
                new ScrollPane(chatArea);

        chatScroll.setFitToWidth(true);

        chatScroll.setStyle(
                "-fx-background-color:#080C14;" +
                "-fx-background:#080C14;" +
                "-fx-border-color:transparent;"
        );

        // Initial trainer message

        chatArea.getChildren().add(
                createChatBubble(
                        trainerName,
                        "Hi! How is your workout going today?",
                        false
                )
        );

        chatArea.getChildren().add(
                createChatBubble(
                        trainerName,
                        "Remember to complete your upper body workout.",
                        false
                )
        );

        // =====================================================
        // MESSAGE INPUT
        // =====================================================

        HBox inputArea =
                new HBox(10);

        inputArea.setPadding(
                new Insets(15)
        );

        inputArea.setStyle(
                "-fx-background-color:#0c1520;" +
                "-fx-border-color:#1a2936;" +
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
                "-fx-border-color:#26313b;" +
                "-fx-border-radius:20px;" +
                "-fx-padding:10px 15px;"
        );

        HBox.setHgrow(
                messageField,
                Priority.ALWAYS
        );

        Button sendButton =
                new Button("Send");

        styleGreenButton(sendButton);

        Runnable sendMessage = () -> {

            String message =
                    messageField
                            .getText()
                            .trim();

            if (message.isEmpty()) {
                return;
            }

            chatArea.getChildren().add(
                    createChatBubble(
                            "You",
                            message,
                            true
                    )
            );

            messageField.clear();

            chatScroll.setVvalue(
                    1.0
            );
        };

        sendButton.setOnAction(
                e -> sendMessage.run()
        );

        messageField.setOnAction(
                e -> sendMessage.run()
        );

        inputArea.getChildren().addAll(
                messageField,
                sendButton
        );

        root.setTop(header);
        root.setCenter(chatScroll);
        root.setBottom(inputArea);

        Scene scene =
                new Scene(
                        root,
                        550,
                        650
                );

        chatStage.setScene(scene);

        chatStage.showAndWait();
    }

    // =========================================================
    // CHAT BUBBLE
    // =========================================================

    private HBox createChatBubble(
            String sender,
            String message,
            boolean isUser
    ) {

        HBox container =
                new HBox();

        container.setMaxWidth(
                Double.MAX_VALUE
        );

        if (isUser) {

            container.setAlignment(
                    Pos.CENTER_RIGHT
            );

        } else {

            container.setAlignment(
                    Pos.CENTER_LEFT
            );
        }

        VBox bubble =
                new VBox(4);

        bubble.setPadding(
                new Insets(
                        10,
                        14,
                        10,
                        14
                )
        );

        bubble.setMaxWidth(
                350
        );

        String background =
                isUser
                        ? "#62ff96"
                        : "#111a24";

        String textColor =
                isUser
                        ? "#06100a"
                        : "#ffffff";

        bubble.setStyle(
                "-fx-background-color:"
                        + background
                        + ";" +
                "-fx-background-radius:15px;"
        );

        Text senderText =
                new Text(sender);

        senderText.setStyle(
                "-fx-font-size:9px;" +
                "-fx-font-weight:bold;" +
                "-fx-fill:"
                        + (isUser
                        ? "#06100a"
                        : "#62ff96")
                        + ";"
        );

        Text messageText =
                new Text(message);

        messageText.setWrappingWidth(
                300
        );

        messageText.setStyle(
                "-fx-font-size:12px;" +
                "-fx-fill:"
                        + textColor
                        + ";"
        );

        bubble.getChildren().addAll(
                senderText,
                messageText
        );

        container.getChildren().add(
                bubble
        );

        return container;
    }

    // =========================================================
    // BOOK TRAINER
    // =========================================================

    private void showBookingDialog(
            String name,
            String specialization,
            String price
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        alert.setTitle(
                "Book Trainer"
        );

        alert.setHeaderText(
                "Book " + name
        );

        alert.setContentText(
                "Trainer: "
                        + name
                        + "\n\n"
                        + "Specialization: "
                        + specialization
                        + "\n\n"
                        + "Price: "
                        + price
                        + "\n\n"
                        + "Do you want to send a booking request?"
        );

        alert.showAndWait()
                .ifPresent(response -> {

                    Alert success =
                            new Alert(
                                    Alert.AlertType.INFORMATION
                            );

                    success.setTitle(
                            "Booking Request"
                    );

                    success.setHeaderText(
                            "Request Sent ✓"
                    );

                    success.setContentText(
                            "Your booking request has been sent to "
                                    + name
                                    + ".\n\n"
                                    + "You will be notified once the trainer accepts your request."
                    );

                    success.showAndWait();
                });
    }

    // =========================================================
    // CHANGE TRAINER
    // =========================================================

    private void showChangeTrainerDialog() {

        Alert alert =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        alert.setTitle(
                "Change Trainer"
        );

        alert.setHeaderText(
                "Change Your Assigned Trainer?"
        );

        alert.setContentText(
                "Explore the trainers below and send a booking request to your preferred trainer."
        );

        alert.showAndWait();
    }

    // =========================================================
    // GREEN BUTTON STYLE
    // =========================================================

    private void styleGreenButton(
            Button button
    ) {

        String normal =
                "-fx-background-color:#62ff96;" +
                "-fx-text-fill:#06100a;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:10px;" +
                "-fx-padding:10px 15px;" +
                "-fx-cursor:hand;";

        String hover =
                "-fx-background-color:#91ffb5;" +
                "-fx-text-fill:#000000;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:10px;" +
                "-fx-padding:10px 15px;" +
                "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.35),15,0.2,0,2);" +
                "-fx-cursor:hand;";

        button.setStyle(normal);

        button.setOnMouseEntered(
                e -> button.setStyle(hover)
        );

        button.setOnMouseExited(
                e -> button.setStyle(normal)
        );
    }

    // =========================================================
    // DARK BUTTON STYLE
    // =========================================================

    private void styleDarkButton(
            Button button
    ) {

        String normal =
                "-fx-background-color:#151e28;" +
                "-fx-text-fill:#ffffff;" +
                "-fx-border-color:#293642;" +
                "-fx-border-radius:10px;" +
                "-fx-background-radius:10px;" +
                "-fx-padding:10px 15px;" +
                "-fx-cursor:hand;";

        String hover =
                "-fx-background-color:rgba(98,255,150,0.08);" +
                "-fx-text-fill:#62ff96;" +
                "-fx-border-color:#62ff96;" +
                "-fx-border-radius:10px;" +
                "-fx-background-radius:10px;" +
                "-fx-padding:10px 15px;" +
                "-fx-cursor:hand;";

        button.setStyle(normal);

        button.setOnMouseEntered(
                e -> button.setStyle(hover)
        );

        button.setOnMouseExited(
                e -> button.setStyle(normal)
        );
    }
}
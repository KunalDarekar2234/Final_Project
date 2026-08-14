
package com.visionx.view.user_login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

public class GymFinderView {

    private Scene gymFinderScene;

    private final String GREEN = "#62ff96";
    private final String DARK = "#080C14";
    private final String CARD = "#07111d";
    private final String TEXT = "#ffffff";
    private final String SECONDARY = "#8a8d91";

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getGymFinderScene(Runnable callBackAction) {

        BorderPane root = new BorderPane();

        root.setStyle(
            "-fx-background-color: #080C14;"
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent = new VBox(22);

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
            "Find a Gym"
        );

        title.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text subtitle = new Text(
            "Find the best gyms near your current location."
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
        // MY GYM
        // =====================================================

        VBox myGymSection =
            createMyGymSection();

        // =====================================================
        // SEARCH BAR
        // =====================================================

        HBox searchSection = new HBox(12);

        searchSection.setAlignment(
            Pos.CENTER_LEFT
        );

        TextField searchField =
            new TextField();

        searchField.setPromptText(
            "Search gyms, fitness centers..."
        );

        searchField.setPrefHeight(
            45
        );

        searchField.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-prompt-text-fill: #596675;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 12px;" +
            "-fx-padding: 0 15px;" +
            "-fx-font-size: 12px;"
        );

        HBox.setHgrow(
            searchField,
            Priority.ALWAYS
        );

        Button searchButton =
            new Button("🔍 Search");

        addHoverEffect(
            searchButton,

            "-fx-background-color: #151b24;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #293642;" +
            "-fx-border-radius: 12px;" +
            "-fx-padding: 12px 20px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #62ff96;" +
            "-fx-border-radius: 12px;" +
            "-fx-padding: 12px 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        Button locationButton =
            new Button("📍 Use My Location");

        addHoverEffect(
            locationButton,

            "-fx-background-color: #62ff96;" +
            "-fx-text-fill: #06100a;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 12px 20px;" +
            "-fx-cursor: hand;",

            "-fx-background-color: #9cffbb;" +
            "-fx-text-fill: #000000;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 12px 20px;" +
            "-fx-effect: dropshadow(gaussian, rgba(98,255,150,0.35), 20, 0.3, 0, 3);" +
            "-fx-cursor: hand;"
        );

        // =====================================================
        // LOCATION ACTION
        // =====================================================

        locationButton.setOnAction(e -> {

            System.out.println(
                "Getting current location..."
            );

        });

        searchButton.setOnAction(e -> {

            String search =
                searchField.getText();

            System.out.println(
                "Searching gyms: " + search
            );

        });

        searchSection.getChildren().addAll(
            searchField,
            searchButton,
            locationButton
        );

        // =====================================================
        // LOCATION INFO
        // =====================================================

        HBox locationInfo =
            new HBox(10);

        locationInfo.setAlignment(
            Pos.CENTER_LEFT
        );

        Circle locationDot =
            new Circle(
                5,
                Color.web("#62ff96")
            );

        Text currentLocation =
            new Text(
                "Location: Waiting for your location..."
            );

        currentLocation.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-fill: #8a8d91;"
        );

        locationInfo.getChildren().addAll(
            locationDot,
            currentLocation
        );

        // =====================================================
        // MAP + GYM LIST
        // =====================================================

        HBox mapSection =
            new HBox(20);

        StackPane mapContainer =
            createMap();

        HBox.setHgrow(
            mapContainer,
            Priority.ALWAYS
        );

        VBox gymList =
            createNearbyGyms();

        gymList.setPrefWidth(
            370
        );

        mapSection.getChildren().addAll(
            mapContainer,
            gymList
        );

        // =====================================================
        // FOOTER
        // =====================================================

        HBox footer =
            new HBox();

        footer.setAlignment(
            Pos.CENTER_LEFT
        );

        Text footerText =
            new Text(
                "Showing gyms near your current location"
            );

        footerText.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #596675;"
        );

        Region footerSpacer =
            new Region();

        HBox.setHgrow(
            footerSpacer,
            Priority.ALWAYS
        );

        Text apiText =
            new Text(
                "📍 Location Based Search"
            );

        apiText.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        footer.getChildren().addAll(
            footerText,
            footerSpacer,
            apiText
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        mainContent.getChildren().addAll(
            header,

            // USER'S OWN GYM
            myGymSection,

            searchSection,
            locationInfo,
            mapSection,
            footer
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

        // StackPane pageRoot = new StackPane();

        // pageRoot.getChildren().add(root);

        // AiMentorFloating.addTo(pageRoot);

        // =====================================================
        // SCENE
        // =====================================================

        gymFinderScene =
            new Scene(
                root,
                1200,
                800
            );

        return gymFinderScene;
    }

    // =========================================================
    // MY GYM SECTION
    // =========================================================

    private VBox createMyGymSection() {

        VBox section =
            new VBox(12);

        // =====================================================
        // SECTION HEADER
        // =====================================================

        HBox heading =
            new HBox();

        heading.setAlignment(
            Pos.CENTER_LEFT
        );

        VBox headingText =
            new VBox(4);

        Text title =
            new Text(
                "My Gym"
            );

        title.setStyle(
            "-fx-font-size: 21px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text subtitle =
            new Text(
                "Your currently registered gym and membership details."
            );

        subtitle.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-fill: #8a8d91;"
        );

        headingText.getChildren().addAll(
            title,
            subtitle
        );

        Region spacer =
            new Region();

        HBox.setHgrow(
            spacer,
            Priority.ALWAYS
        );

        Text active =
            new Text(
                "● ACTIVE MEMBERSHIP"
            );

        active.setStyle(
            "-fx-background-color: rgba(98,255,150,0.12);" +
            "-fx-text-fill: #62ff96;" +
            "-fx-padding: 7px 12px;" +
            "-fx-background-radius: 12px;" +
            "-fx-font-size: 9px;" +
            "-fx-font-weight: bold;"
        );

        heading.getChildren().addAll(
            headingText,
            spacer,
            active
        );

        // =====================================================
        // MY GYM CARD
        // =====================================================

        HBox gymCard =
            new HBox(20);

        gymCard.setPadding(
            new Insets(20)
        );

        gymCard.setAlignment(
            Pos.CENTER_LEFT
        );

        gymCard.setStyle(
            "-fx-background-color: linear-gradient(to right,#07111d,#091a17);" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: rgba(98,255,150,0.25);" +
            "-fx-border-radius: 18px;" +
            "-fx-effect: dropshadow(gaussian,rgba(98,255,150,0.08),25,0.2,0,5);"
        );

        // =====================================================
        // GYM IMAGE
        // =====================================================

        StackPane imagePane =
            new StackPane();

        javafx.scene.image.Image gymImage =
            new javafx.scene.image.Image(
                "https://images.unsplash.com/photo-1534438327276-14e5300c3a48"
                    + "?auto=format&fit=crop&w=500&q=80",
                180,
                135,
                false,
                true
            );

        javafx.scene.image.ImageView imageView =
            new javafx.scene.image.ImageView(
                gymImage
            );

        imageView.setFitWidth(
            180
        );

        imageView.setFitHeight(
            135
        );

        imageView.setPreserveRatio(
            false
        );

        Rectangle clip =
            new Rectangle(
                180,
                135
            );

        clip.setArcWidth(
            18
        );

        clip.setArcHeight(
            18
        );

        imageView.setClip(
            clip
        );

        imagePane.getChildren().add(
            imageView
        );

        // =====================================================
        // MY GYM BADGE
        // =====================================================

        Text myGymBadge =
            new Text(
                "MY GYM"
            );

        myGymBadge.setStyle(
            "-fx-background-color:#62ff96;" +
            "-fx-text-fill:#06100a;" +
            "-fx-font-size:9px;" +
            "-fx-font-weight:bold;" +
            "-fx-padding:5px 9px;" +
            "-fx-background-radius:10px;"
        );

        StackPane.setAlignment(
            myGymBadge,
            Pos.TOP_LEFT
        );

        StackPane.setMargin(
            myGymBadge,
            new Insets(10)
        );

        imagePane.getChildren().add(
            myGymBadge
        );

        // =====================================================
        // GYM INFORMATION
        // =====================================================

        VBox info =
            new VBox(8);

        HBox.setHgrow(
            info,
            Priority.ALWAYS
        );

        Text gymName =
            new Text(
                "FitZone Premium Gym"
            );

        gymName.setStyle(
            "-fx-font-size:23px;" +
            "-fx-font-weight:bold;" +
            "-fx-fill:#ffffff;"
        );

        Text gymType =
            new Text(
                "Premium Fitness & Strength Center"
            );

        gymType.setStyle(
            "-fx-font-size:12px;" +
            "-fx-fill:#62ff96;"
        );

        Text address =
            new Text(
                "📍 Baner Road, Pune"
            );

        address.setStyle(
            "-fx-font-size:11px;" +
            "-fx-fill:#b8c1ca;"
        );

        HBox details =
            new HBox(18);

        Text distance =
            new Text(
                "📍 1.2 km"
            );

        Text rating =
            new Text(
                "★ 4.8"
            );

        Text timing =
            new Text(
                "🕒 5:00 AM - 11:00 PM"
            );

        distance.setStyle(
            "-fx-font-size:10px;" +
            "-fx-fill:#8a8d91;"
        );

        rating.setStyle(
            "-fx-font-size:10px;" +
            "-fx-fill:#62ff96;" +
            "-fx-font-weight:bold;"
        );

        timing.setStyle(
            "-fx-font-size:10px;" +
            "-fx-fill:#8a8d91;"
        );

        details.getChildren().addAll(
            distance,
            rating,
            timing
        );

        // =====================================================
        // MEMBERSHIP
        // =====================================================

        HBox membership =
            new HBox(20);

        VBox membershipBox =
            new VBox(3);

        Text membershipLabel =
            new Text(
                "MEMBERSHIP"
            );

        membershipLabel.setStyle(
            "-fx-font-size:8px;" +
            "-fx-fill:#8a8d91;" +
            "-fx-font-weight:bold;"
        );

        Text membershipValue =
            new Text(
                "Premium • Monthly"
            );

        membershipValue.setStyle(
            "-fx-font-size:11px;" +
            "-fx-fill:#ffffff;" +
            "-fx-font-weight:bold;"
        );

        membershipBox.getChildren().addAll(
            membershipLabel,
            membershipValue
        );

        VBox expiryBox =
            new VBox(3);

        Text expiryLabel =
            new Text(
                "VALID UNTIL"
            );

        expiryLabel.setStyle(
            "-fx-font-size:8px;" +
            "-fx-fill:#8a8d91;" +
            "-fx-font-weight:bold;"
        );

        Text expiryValue =
            new Text(
                "30 September 2026"
            );

        expiryValue.setStyle(
            "-fx-font-size:11px;" +
            "-fx-fill:#62ff96;" +
            "-fx-font-weight:bold;"
        );

        expiryBox.getChildren().addAll(
            expiryLabel,
            expiryValue
        );

        membership.getChildren().addAll(
            membershipBox,
            expiryBox
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        Button viewButton =
            new Button(
                "View Gym"
            );

        Button membershipButton =
            new Button(
                "My Membership"
            );

        styleDarkButton(
            viewButton
        );

        styleGreenButton(
            membershipButton
        );

        viewButton.setOnAction(
            e -> showMyGymProfile()
        );

        membershipButton.setOnAction(
            e -> showMembership()
        );

        HBox buttons =
            new HBox(10);

        buttons.getChildren().addAll(
            viewButton,
            membershipButton
        );

        info.getChildren().addAll(
            gymName,
            gymType,
            address,
            details,
            membership,
            buttons
        );

        gymCard.getChildren().addAll(
            imagePane,
            info
        );

        // =====================================================
        // HOVER
        // =====================================================

        addHoverEffect(
            gymCard,

            "-fx-background-color: linear-gradient(to right,#07111d,#091a17);" +
            "-fx-background-radius:18px;" +
            "-fx-border-color:rgba(98,255,150,0.25);" +
            "-fx-border-radius:18px;",

            "-fx-background-color: linear-gradient(to right,#0a1924,#0b2119);" +
            "-fx-background-radius:18px;" +
            "-fx-border-color:#62ff96;" +
            "-fx-border-radius:18px;" +
            "-fx-effect:dropshadow(gaussian,rgba(98,255,150,0.18),25,0.2,0,5);"
        );

        section.getChildren().addAll(
            heading,
            gymCard
        );

        return section;
    }

    // =========================================================
    // MY GYM PROFILE
    // =========================================================

    private void showMyGymProfile() {

        Alert alert =
            new Alert(
                Alert.AlertType.INFORMATION
            );

        alert.setTitle(
            "My Gym"
        );

        alert.setHeaderText(
            "🏋 FitZone Premium Gym"
        );

        alert.setContentText(
            "GYM TYPE\n" +
            "Premium Fitness & Strength Center\n\n" +

            "ADDRESS\n" +
            "Baner Road, Pune\n\n" +

            "RATING\n" +
            "★ 4.8 / 5.0\n\n" +

            "TIMINGS\n" +
            "5:00 AM - 11:00 PM\n\n" +

            "FACILITIES\n" +
            "• Strength Training\n" +
            "• Cardio Zone\n" +
            "• Free Weights\n" +
            "• Personal Training\n" +
            "• Locker Room\n" +
            "• Shower Facility\n\n" +

            "MEMBERSHIP\n" +
            "Premium Monthly\n\n" +

            "STATUS\n" +
            "✓ Active"
        );

        alert.showAndWait();
    }

    // =========================================================
    // MEMBERSHIP
    // =========================================================

    private void showMembership() {

        Alert alert =
            new Alert(
                Alert.AlertType.INFORMATION
            );

        alert.setTitle(
            "My Membership"
        );

        alert.setHeaderText(
            "Premium Membership ✓"
        );

        alert.setContentText(
            "Gym: FitZone Premium Gym\n\n" +

            "Plan: Premium Monthly\n\n" +

            "Status: ACTIVE\n\n" +

            "Start Date: 01 September 2026\n\n" +

            "Valid Until: 30 September 2026\n\n" +

            "Benefits:\n" +
            "• Unlimited Gym Access\n" +
            "• Personal Trainer Access\n" +
            "• Cardio & Strength Zone\n" +
            "• Locker Facility\n" +
            "• Progress Tracking"
        );

        alert.showAndWait();
    }

    // =========================================================
    // MAP
    // =========================================================

    private StackPane createMap() {

        StackPane map =
            new StackPane();

        map.setPrefHeight(
            500
        );

        map.setMinHeight(
            500
        );

        map.setStyle(
            "-fx-background-color: #101821;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        // =====================================================
        // MAP TITLE
        // =====================================================

        VBox mapOverlay =
            new VBox(5);

        mapOverlay.setPadding(
            new Insets(15)
        );

        mapOverlay.setAlignment(
            Pos.TOP_LEFT
        );

        Text mapTitle =
            new Text(
                "Nearby Gyms"
            );

        mapTitle.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text mapSubtitle =
            new Text(
                "Map will show gyms around your location"
            );

        mapSubtitle.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #8a8d91;"
        );

        mapOverlay.getChildren().addAll(
            mapTitle,
            mapSubtitle
        );

        StackPane.setAlignment(
            mapOverlay,
            Pos.TOP_LEFT
        );

        // =====================================================
        // USER LOCATION
        // =====================================================

        Circle userLocation =
            new Circle(
                10,
                Color.web("#62ff96")
            );

        userLocation.setStroke(
            Color.WHITE
        );

        userLocation.setStrokeWidth(
            3
        );

        StackPane.setAlignment(
            userLocation,
            Pos.CENTER
        );

        // =====================================================
        // MAP MARKERS
        // =====================================================

        VBox marker1 =
            createMapMarker(
                "Iron Gym"
            );

        StackPane.setAlignment(
            marker1,
            Pos.TOP_CENTER
        );

        StackPane.setMargin(
            marker1,
            new Insets(130, 0, 0, 0)
        );

        VBox marker2 =
            createMapMarker(
                "FitZone"
            );

        StackPane.setAlignment(
            marker2,
            Pos.CENTER_RIGHT
        );

        StackPane.setMargin(
            marker2,
            new Insets(0, 100, 80, 0)
        );

        VBox marker3 =
            createMapMarker(
                "Power House"
            );

        StackPane.setAlignment(
            marker3,
            Pos.BOTTOM_LEFT
        );

        StackPane.setMargin(
            marker3,
            new Insets(0, 0, 100, 100)
        );

        // =====================================================
        // MAP GRID
        // =====================================================

        VBox mapLines =
            new VBox();

        mapLines.setMouseTransparent(
            true
        );

        map.getChildren().addAll(
            mapLines,
            userLocation,
            marker1,
            marker2,
            marker3,
            mapOverlay
        );

        return map;
    }

    // =========================================================
    // MAP MARKER
    // =========================================================

    private VBox createMapMarker(
        String gymName
    ) {

        VBox marker =
            new VBox(3);

        marker.setAlignment(
            Pos.CENTER
        );

        Text pin =
            new Text("📍");

        pin.setStyle(
            "-fx-font-size: 24px;"
        );

        Text name =
            new Text(
                gymName
            );

        name.setStyle(
            "-fx-font-size: 9px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;" +
            "-fx-background-color: #07111d;" +
            "-fx-padding: 4px 7px;" +
            "-fx-background-radius: 6px;"
        );

        marker.getChildren().addAll(
            pin,
            name
        );

        return marker;
    }

    // =========================================================
    // NEARBY GYMS
    // =========================================================

    private VBox createNearbyGyms() {

        VBox container =
            new VBox(12);

        container.setPadding(
            new Insets(20)
        );

        container.setStyle(
            "-fx-background-color: #07111d;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 18px;"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
            new HBox();

        header.setAlignment(
            Pos.CENTER_LEFT
        );

        Text title =
            new Text(
                "Nearby Gyms"
            );

        title.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Region spacer =
            new Region();

        HBox.setHgrow(
            spacer,
            Priority.ALWAYS
        );

        Text count =
            new Text(
                "3 found"
            );

        count.setStyle(
            "-fx-font-size: 10px;" +
            "-fx-fill: #62ff96;"
        );

        header.getChildren().addAll(
            title,
            spacer,
            count
        );

        // =====================================================
        // GYM CARDS
        // =====================================================

        VBox gyms =
            new VBox(10);

        HBox gym1 =
            createGymCard(
                "Iron Gym",
                "Strength & Fitness",
                "0.8 km",
                "4.8"
            );

        HBox gym2 =
            createGymCard(
                "FitZone Fitness",
                "Gym & CrossFit",
                "1.2 km",
                "4.6"
            );

        HBox gym3 =
            createGymCard(
                "Power House",
                "Fitness Center",
                "1.7 km",
                "4.5"
            );

        gyms.getChildren().addAll(
            gym1,
            gym2,
            gym3
        );

        container.getChildren().addAll(
            header,
            gyms
        );

        return container;
    }

    // =========================================================
    // GYM CARD
    // =========================================================

    private HBox createGymCard(
        String gymName,
        String type,
        String distance,
        String rating
    ) {

        HBox card =
            new HBox(12);

        card.setAlignment(
            Pos.CENTER_LEFT
        );

        card.setPadding(
            new Insets(13)
        );

        card.setStyle(
            "-fx-background-color: #0b1825;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 12px;"
        );

        // =====================================================
        // ICON
        // =====================================================

        StackPane icon =
            new StackPane();

        Circle iconCircle =
            new Circle(
                22,
                Color.web("#10281b")
            );

        Text dumbbell =
            new Text(
                "🏋"
            );

        dumbbell.setStyle(
            "-fx-font-size: 17px;"
        );

        icon.getChildren().addAll(
            iconCircle,
            dumbbell
        );

        // =====================================================
        // DETAILS
        // =====================================================

        VBox details =
            new VBox(4);

        Text name =
            new Text(
                gymName
            );

        name.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text gymType =
            new Text(
                type
            );

        gymType.setStyle(
            "-fx-font-size: 9px;" +
            "-fx-fill: #8a8d91;"
        );

        Text ratingText =
            new Text(
                "⭐ " + rating
            );

        ratingText.setStyle(
            "-fx-font-size: 9px;" +
            "-fx-fill: #62ff96;"
        );

        details.getChildren().addAll(
            name,
            gymType,
            ratingText
        );

        HBox.setHgrow(
            details,
            Priority.ALWAYS
        );

        // =====================================================
        // DISTANCE
        // =====================================================

        VBox distanceBox =
            new VBox(3);

        distanceBox.setAlignment(
            Pos.CENTER_RIGHT
        );

        Text distanceText =
            new Text(
                distance
            );

        distanceText.setStyle(
            "-fx-font-size: 11px;" +
            "-fx-font-weight: bold;" +
            "-fx-fill: #ffffff;"
        );

        Text awayText =
            new Text(
                "away"
            );

        awayText.setStyle(
            "-fx-font-size: 8px;" +
            "-fx-fill: #8a8d91;"
        );

        distanceBox.getChildren().addAll(
            distanceText,
            awayText
        );

        card.getChildren().addAll(
            icon,
            details,
            distanceBox
        );

        addHoverEffect(
            card,

            "-fx-background-color: #0b1825;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #172431;" +
            "-fx-border-radius: 12px;",

            "-fx-background-color: #10201d;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #62ff96;" +
            "-fx-border-radius: 12px;"
        );

        return card;
    }

    // =========================================================
    // GREEN BUTTON
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
            "-fx-cursor:hand;";

        button.setStyle(
            normal
        );

        button.setOnMouseEntered(
            e -> button.setStyle(hover)
        );

        button.setOnMouseExited(
            e -> button.setStyle(normal)
        );
    }

    // =========================================================
    // DARK BUTTON
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

        button.setStyle(
            normal
        );

        button.setOnMouseEntered(
            e -> button.setStyle(hover)
        );

        button.setOnMouseExited(
            e -> button.setStyle(normal)
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

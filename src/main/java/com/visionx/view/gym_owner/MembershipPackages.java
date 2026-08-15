package com.visionx.view.gym_owner;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MembershipPackages {

    // =========================================================
    // COLORS
    // =========================================================

    // IMPORTANT:
    // Scene background remains this color.
    private final String BG_COLOR = "#0d150e";

    // Package BOX background
    private final String BOX_COLOR = "#020914";

    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DIM = "rgba(117,255,158,0.12)";

    private final String SECONDARY = "#c0c6db";
    private final String TERTIARY = "#ffba79";

    private final String TEXT_MAIN = "#ffffff";
    private final String TEXT_MUTED = "#bacbb9";

    private final String BORDER = "rgba(255,255,255,0.08)";
    private final String BORDER_HOVER = "rgba(117,255,158,0.45)";

    private final String ERROR = "#ffb4ab";

    private Scene membershipScene;

    private StackPane rootContainer;
    private VBox membershipMainArea;

    private boolean yearlyMode = false;


    public Scene getMembershipPackagesScene(Runnable callBackAction) {

        
        StackPane root = new StackPane();

        root.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI';"
        );

        VBox mainContent = createMembershipContent();
        membershipMainArea = mainContent;

        root.getChildren().add(mainContent);
        rootContainer = root;

        membershipScene = new Scene(root, 1160, 900);

        return membershipScene;
    }

    private VBox createMembershipContent() {

        VBox content = new VBox(26);

        content.setPadding(
                new Insets(40, 38, 40, 38)
        );

        content.setAlignment(Pos.TOP_CENTER);

        content.setFillWidth(true);

     
        HBox header = new HBox();

        header.setAlignment(Pos.CENTER_LEFT);

       

        VBox titleBox = new VBox(5);

        Label title = new Label("Membership Packages");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 36px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Manage your membership plans, pricing and benefits."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 15px;"
        );

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );
        

        HBox toggleBox = createPlanToggle();

        Button addNewBtn =
                new Button("＋  Add New Membership");

        String addNewDef =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #07110a;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10 20;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;";

        String addNewHover =
                "-fx-background-color: #8affab;" +
                "-fx-text-fill: #07110a;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10 20;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;";

        addNewBtn.setStyle(addNewDef);

        addNewBtn.setOnMouseEntered(
                e -> addNewBtn.setStyle(addNewHover)
        );

        addNewBtn.setOnMouseExited(
                e -> addNewBtn.setStyle(addNewDef)
        );

        addNewBtn.setOnAction(
                e -> showAddMembershipEditor()
        );

        HBox rightBox = new HBox(14);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        rightBox.getChildren().addAll(
                addNewBtn,
                toggleBox
        );

        header.getChildren().addAll(
                titleBox,
                spacer,
                rightBox
        );

        // =====================================================
        // PACKAGE GRID
        // =====================================================

        GridPane packageGrid = new GridPane();

        packageGrid.setHgap(22);
        packageGrid.setVgap(22);

        packageGrid.setMaxWidth(
                Double.MAX_VALUE
        );

        ColumnConstraints column1 =
                new ColumnConstraints();

        ColumnConstraints column2 =
                new ColumnConstraints();

        column1.setPercentWidth(50);
        column2.setPercentWidth(50);

        column1.setHgrow(Priority.ALWAYS);
        column2.setHgrow(Priority.ALWAYS);

        packageGrid.getColumnConstraints().addAll(
                column1,
                column2
        );

        // =====================================================
        // FOUR PACKAGES ONLY
        // =====================================================

        VBox basicCard = createPackageCard(
                "Basic",
                "🥉",
                "$19",
                "$190",
                "For beginners starting their fitness journey.",
                new String[]{
                        "Gym facility access",
                        "Basic workout plans",
                        "Member dashboard",
                        "Progress tracking",
                        "Email support"
                },
                PRIMARY,
                false
        );

        VBox proCard = createPackageCard(
                "Pro",
                "⚡",
                "$39",
                "$390",
                "For members who want structured fitness training.",
                new String[]{
                        "Everything in Basic",
                        "Personalized workout plans",
                        "AI fitness recommendations",
                        "Diet tracking",
                        "Priority support"
                },
                PRIMARY,
                false
        );

        VBox premiumCard = createPackageCard(
                "Premium",
                "💎",
                "$69",
                "$690",
                "Advanced fitness experience with AI assistance.",
                new String[]{
                        "Everything in Pro",
                        "Advanced AI fitness plans",
                        "Personal diet planner",
                        "Trainer consultation",
                        "Advanced analytics",
                        "Priority trainer support"
                },
                TERTIARY,
                true
        );

        VBox eliteCard = createPackageCard(
                "Elite",
                "♛",
                "$99",
                "$990",
                "Complete premium experience for serious athletes.",
                new String[]{
                        "Everything in Premium",
                        "Personal fitness trainer",
                        "AI performance analytics",
                        "Custom nutrition strategy",
                        "Unlimited trainer consultation",
                        "Exclusive Elite support"
                },
                PRIMARY,
                false
        );

        // =====================================================
        // 2 x 2 GRID
        // =====================================================

        packageGrid.add(
                basicCard,
                0,
                0
        );

        packageGrid.add(
                proCard,
                1,
                0
        );

        packageGrid.add(
                premiumCard,
                0,
                1
        );

        packageGrid.add(
                eliteCard,
                1,
                1
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(packageGrid);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        content.getChildren().addAll(
                header,
                scrollPane
        );

        return content;
    }

    // =========================================================
    // MONTHLY / YEARLY TOGGLE
    // =========================================================

    private HBox createPlanToggle() {

        HBox toggle = new HBox();

        toggle.setPadding(
                new Insets(5)
        );

        toggle.setSpacing(4);

        toggle.setAlignment(
                Pos.CENTER
        );

        toggle.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 14;" +
                "-fx-background-radius: 14;"
        );

        Button monthly =
                new Button("Monthly");

        Button yearly =
                new Button("Yearly");

        monthly.setPrefWidth(92);
        yearly.setPrefWidth(92);

        updateToggleStyle(
                monthly,
                !yearlyMode
        );

        updateToggleStyle(
                yearly,
                yearlyMode
        );

        monthly.setOnAction(e -> {

            yearlyMode = false;

            updateToggleStyle(
                    monthly,
                    true
            );

            updateToggleStyle(
                    yearly,
                    false
            );
        });

        yearly.setOnAction(e -> {

            yearlyMode = true;

            updateToggleStyle(
                    monthly,
                    false
            );

            updateToggleStyle(
                    yearly,
                    true
            );
        });

        toggle.getChildren().addAll(
                monthly,
                yearly
        );

        return toggle;
    }

    // =========================================================
    // TOGGLE STYLE
    // =========================================================

    private void updateToggleStyle(
            Button button,
            boolean active
    ) {

        if (active) {

            button.setStyle(
                    "-fx-background-color: " + PRIMARY + ";" +
                    "-fx-text-fill: #07110a;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 10 18;" +
                    "-fx-background-radius: 10;" +
                    "-fx-cursor: hand;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " + TEXT_MUTED + ";" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 10 18;" +
                    "-fx-background-radius: 10;" +
                    "-fx-cursor: hand;"
            );
        }
    }

    // =========================================================
    // PACKAGE CARD
    // =========================================================

    private VBox createPackageCard(
            String packageName,
            String icon,
            String monthlyPrice,
            String yearlyPrice,
            String description,
            String[] benefits,
            String accentColor,
            boolean popular
    ) {

        VBox card = new VBox(16);

        card.setPadding(
                new Insets(26)
        );

        card.setMinHeight(410);

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        // =====================================================
        // BOX BACKGROUND
        // =====================================================

        String normalStyle =
                "-fx-background-color: " + BOX_COLOR + ";" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 22;" +
                "-fx-border-width: 1;";

        String hoverStyle =
                "-fx-background-color: " + BOX_COLOR + ";" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: " + BORDER_HOVER + ";" +
                "-fx-border-radius: 22;" +
                "-fx-border-width: 1;";

        card.setStyle(normalStyle);

        card.setEffect(
                new DropShadow(
                        22,
                        0,
                        8,
                        Color.color(0, 0, 0, 0.35)
                )
        );

        // =====================================================
        // CARD HEADER
        // =====================================================

        HBox cardHeader = new HBox();

        cardHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        // Icon
        StackPane iconBox = new StackPane();

        iconBox.setMinSize(56, 56);
        iconBox.setMaxSize(56, 56);

        iconBox.setStyle(
                "-fx-background-color: rgba(117,255,158,0.08);" +
                "-fx-background-radius: 16;"
        );

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-font-size: 28px;"
        );

        iconBox.getChildren().add(
                iconLabel
        );

        // Name
        VBox nameBox = new VBox(3);

        HBox.setMargin(
                nameBox,
                new Insets(0, 0, 0, 14)
        );

        Label name =
                new Label(packageName);

        name.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        Label membership =
                new Label("FITNESS MEMBERSHIP");

        membership.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1px;"
        );

        nameBox.getChildren().addAll(
                name,
                membership
        );

        Region headerSpacer =
                new Region();

        HBox.setHgrow(
                headerSpacer,
                Priority.ALWAYS
        );

        cardHeader.getChildren().addAll(
                iconBox,
                nameBox,
                headerSpacer
        );

        // =====================================================
        // POPULAR BADGE
        // =====================================================

        if (popular) {

            Label popularLabel =
                    new Label("POPULAR");

            popularLabel.setStyle(
                    "-fx-background-color: rgba(117,255,158,0.12);" +
                    "-fx-text-fill: " + PRIMARY + ";" +
                    "-fx-font-size: 9px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 10;" +
                    "-fx-background-radius: 50;"
            );

            cardHeader.getChildren().add(
                    popularLabel
            );
        }

        // =====================================================
        // PRICE
        // =====================================================

        Label price =
                new Label();

        price.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label yearlyInfo =
                new Label();

        yearlyInfo.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        updatePriceLabels(
                price,
                yearlyInfo,
                monthlyPrice,
                yearlyPrice
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label desc =
                new Label(description);

        desc.setWrapText(true);

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 13px;"
        );

        // =====================================================
        // SEPARATOR
        // =====================================================

        Region separator =
                new Region();

        separator.setMinHeight(1);
        separator.setMaxHeight(1);

        separator.setStyle(
                "-fx-background-color: rgba(255,255,255,0.08);"
        );

        // =====================================================
        // BENEFITS
        // =====================================================

        VBox benefitsBox =
                new VBox(9);

        for (String benefit : benefits) {

            HBox benefitRow =
                    new HBox(9);

            benefitRow.setAlignment(
                    Pos.CENTER_LEFT
            );

            Label check =
                    new Label("✓");

            check.setStyle(
                    "-fx-text-fill: " + PRIMARY + ";" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;"
            );

            Label benefitLabel =
                    new Label(benefit);

            benefitLabel.setWrapText(true);

            benefitLabel.setStyle(
                    "-fx-text-fill: " + TEXT_MUTED + ";" +
                    "-fx-font-size: 13px;"
            );

            benefitRow.getChildren().addAll(
                    check,
                    benefitLabel
            );

            benefitsBox.getChildren().add(
                    benefitRow
            );
        }

        // =====================================================
        // PUSH BUTTON TO BOTTOM
        // =====================================================

        Region bottomSpacer =
                new Region();

        VBox.setVgrow(
                bottomSpacer,
                Priority.ALWAYS
        );

        // =====================================================
        // EDIT BUTTON
        // =====================================================

        Button editButton =
                new Button("✎  Edit Package");

        editButton.setMaxWidth(
                Double.MAX_VALUE
        );

        String editNormal =
                "-fx-background-color: rgba(255,255,255,0.04);" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 11 18;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;";

        String editHover =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-text-fill: #07110a;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 11 18;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;";

        editButton.setStyle(
                editNormal
        );

        editButton.setOnMouseEntered(
                e -> editButton.setStyle(editHover)
        );

        editButton.setOnMouseExited(
                e -> editButton.setStyle(editNormal)
        );

        editButton.setOnAction(
                e -> showEditDialog(
                        packageName,
                        monthlyPrice,
                        yearlyPrice,
                        description,
                        benefits
                )
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        card.getChildren().addAll(
                cardHeader,
                price,
                yearlyInfo,
                desc,
                separator,
                benefitsBox,
                bottomSpacer,
                editButton
        );

        // =====================================================
        // CARD HOVER
        // =====================================================

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    hoverStyle
            );

            card.setTranslateY(-3);
        });

        card.setOnMouseExited(e -> {

            card.setStyle(
                    normalStyle
            );

            card.setTranslateY(0);
        });

        // =====================================================
        // PRICE UPDATE WHEN MONTHLY / YEARLY CHANGES
        // =====================================================

        card.setUserData(
                new PriceData(
                        price,
                        yearlyInfo,
                        monthlyPrice,
                        yearlyPrice
                )
        );

        return card;
    }

    // =========================================================
    // PRICE LABEL UPDATE
    // =========================================================

    private void updatePriceLabels(
            Label price,
            Label yearlyInfo,
            String monthlyPrice,
            String yearlyPrice
    ) {

        if (yearlyMode) {

            price.setText(
                    yearlyPrice + " / year"
            );

            yearlyInfo.setText(
                    "Billed annually"
            );

        } else {

            price.setText(
                    monthlyPrice + " / month"
            );

            yearlyInfo.setText(
                    "Yearly: " + yearlyPrice
            );
        }
    }

    // =========================================================
    // EDIT DIALOG
    // UPDATED PREMIUM + ANIMATED VERSION
    // =========================================================

    private void showEditDialog(
            String packageName,
            String monthlyPrice,
            String yearlyPrice,
            String description,
            String[] benefits
    ) {

        // =====================================================
        // FULL SCREEN OVERLAY
        // =====================================================
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.65);");
        overlay.setAlignment(Pos.CENTER);

        // =====================================================
        // MAIN DIALOG CONTAINER
        // =====================================================

        VBox root =
                new VBox(20);

        root.setPadding(
                new Insets(26)
        );

        root.setPrefWidth(540);

        root.setStyle(
                "-fx-background-color: " + BOX_COLOR + ";" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: rgba(117,255,158,0.28);" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 22;"
        );

        root.setEffect(
                new DropShadow(
                        35,
                        0,
                        12,
                        Color.color(0, 0, 0, 0.55)
                )
        );

        // =====================================================
        // PREMIUM HEADER
        // =====================================================

        HBox header =
                new HBox(14);

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        StackPane packageIcon =
                new StackPane();

        packageIcon.setMinSize(
                54,
                54
        );

        packageIcon.setMaxSize(
                54,
                54
        );

        packageIcon.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: rgba(117,255,158,0.25);" +
                "-fx-border-radius: 16;"
        );

        Label icon =
                new Label("✎");

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        packageIcon.getChildren().add(
                icon
        );

        VBox heading =
                new VBox(4);

        Label title =
                new Label(
                        "Edit " + packageName
                );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Update membership package information"
                );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        heading.getChildren().addAll(
                title,
                subtitle
        );

        header.getChildren().addAll(
                packageIcon,
                heading
        );

        // =====================================================
        // SMALL STATUS BADGE
        // =====================================================

        HBox statusRow =
                new HBox();

        statusRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label status =
                new Label(
                        "●  PACKAGE CONFIGURATION"
                );

        status.setStyle(
                "-fx-background-color: rgba(117,255,158,0.08);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 7 11;" +
                "-fx-background-radius: 50;"
        );

        statusRow.getChildren().add(
                status
        );

        // =====================================================
        // FORM CARD
        // =====================================================

        VBox formCard =
                new VBox(15);

        formCard.setPadding(
                new Insets(20)
        );

        formCard.setStyle(
                "-fx-background-color: rgba(255,255,255,0.035);" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: rgba(255,255,255,0.07);" +
                "-fx-border-radius: 16;"
        );

        // =====================================================
        // MONTHLY PRICE
        // =====================================================

        VBox monthlyBox =
                new VBox(7);

        Label monthlyLabel =
                new Label("MONTHLY PRICE");

        monthlyLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1.2px;"
        );

        HBox monthlyInputBox =
                new HBox();

        monthlyInputBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Label dollar1 =
                new Label("$");

        dollar1.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        TextField monthlyField =
                new TextField(
                        monthlyPrice.replace("$", "")
                );

        monthlyField.setMaxWidth(
                Double.MAX_VALUE
        );

        HBox.setHgrow(
                monthlyField,
                Priority.ALWAYS
        );

        monthlyField.setStyle(
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #617062;" +
                "-fx-font-size: 15px;" +
                "-fx-padding: 11 13;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;"
        );

        monthlyInputBox.getChildren().addAll(
                dollar1,
                monthlyField
        );

        monthlyBox.getChildren().addAll(
                monthlyLabel,
                monthlyInputBox
        );

        // =====================================================
        // YEARLY PRICE
        // =====================================================

        VBox yearlyBox =
                new VBox(7);

        Label yearlyLabel =
                new Label("YEARLY PRICE");

        yearlyLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1.2px;"
        );

        HBox yearlyInputBox =
                new HBox();

        yearlyInputBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Label dollar2 =
                new Label("$");

        dollar2.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        TextField yearlyField =
                new TextField(
                        yearlyPrice.replace("$", "")
                );

        yearlyField.setMaxWidth(
                Double.MAX_VALUE
        );

        HBox.setHgrow(
                yearlyField,
                Priority.ALWAYS
        );

        yearlyField.setStyle(
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #617062;" +
                "-fx-font-size: 15px;" +
                "-fx-padding: 11 13;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;"
        );

        yearlyInputBox.getChildren().addAll(
                dollar2,
                yearlyField
        );

        yearlyBox.getChildren().addAll(
                yearlyLabel,
                yearlyInputBox
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        VBox descriptionBox =
                new VBox(7);

        Label descriptionLabel =
                new Label("PACKAGE DESCRIPTION");

        descriptionLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1.2px;"
        );

        TextArea descriptionArea =
                new TextArea(
                        description
                );

        descriptionArea.setWrapText(
                true
        );

        descriptionArea.setPrefRowCount(
                3
        );

        descriptionArea.setStyle(
                "-fx-control-inner-background: #0d150e;" +
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;"
        );

        descriptionBox.getChildren().addAll(
                descriptionLabel,
                descriptionArea
        );

        formCard.getChildren().addAll(
                monthlyBox,
                yearlyBox,
                descriptionBox
        );

        // =====================================================
        // INFO MESSAGE
        // =====================================================

        HBox infoBox =
                new HBox(10);

        infoBox.setAlignment(
                Pos.CENTER_LEFT
        );

        infoBox.setPadding(
                new Insets(10, 13, 10, 13)
        );

        infoBox.setStyle(
                "-fx-background-color: rgba(117,255,158,0.05);" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(117,255,158,0.10);" +
                "-fx-border-radius: 10;"
        );

        Label infoIcon =
                new Label("ⓘ");

        infoIcon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 15px;"
        );

        Label infoText =
                new Label(
                        "Changes will update the package information."
                );

        infoText.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );

        infoBox.getChildren().addAll(
                infoIcon,
                infoText
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        root.getChildren().addAll(
                header,
                statusRow,
                formCard,
                infoBox
        );

        // =====================================================
        // BUTTONS
        // =====================================================
        HBox buttonBox = new HBox(14);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        Button cancel = new Button("Cancel");
        Button save = new Button("Save Changes");

        buttonBox.getChildren().addAll(cancel, save);
        root.getChildren().add(buttonBox);

        cancel.setOnAction(e -> closeEditDialog(overlay, root));
        save.setOnAction(e -> {
            // Handle save logic here
            closeEditDialog(overlay, root);
        });

        // =====================================================
        // BUTTON STYLING
        // =====================================================

        cancel.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 22;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;" +
                "-fx-cursor: hand;"
        );

        save.setStyle(
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #07110a;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 24;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;"
        );

        cancel.setOnMouseEntered(e ->
                cancel.setStyle(
                        "-fx-background-color: rgba(255,255,255,0.10);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 22;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: rgba(255,255,255,0.15);" +
                        "-fx-border-radius: 10;" +
                        "-fx-cursor: hand;"
                )
        );

        cancel.setOnMouseExited(e ->
                cancel.setStyle(
                        "-fx-background-color: rgba(255,255,255,0.05);" +
                        "-fx-text-fill: " + TEXT_MUTED + ";" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 22;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: rgba(255,255,255,0.08);" +
                        "-fx-border-radius: 10;" +
                        "-fx-cursor: hand;"
                )
        );

        save.setOnMouseEntered(e ->
                save.setStyle(
                        "-fx-background-color: #8affad;" +
                        "-fx-text-fill: #07110a;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 24;" +
                        "-fx-background-radius: 10;" +
                        "-fx-cursor: hand;"
                )
        );

        save.setOnMouseExited(e ->
                save.setStyle(
                        "-fx-background-color: " + PRIMARY + ";" +
                        "-fx-text-fill: #07110a;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 24;" +
                        "-fx-background-radius: 10;" +
                        "-fx-cursor: hand;"
                )
        );

        // =====================================================
        // INPUT FOCUS EFFECT
        // =====================================================

        String fieldNormal =
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-padding: 11 13;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;";

        String fieldFocus =
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-padding: 11 13;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.18), 12, 0.2, 0, 0);";

        monthlyField.focusedProperty().addListener(
                (obs, oldValue, focused) ->
                        monthlyField.setStyle(
                                focused ? fieldFocus : fieldNormal
                        )
        );

        yearlyField.focusedProperty().addListener(
                (obs, oldValue, focused) ->
                        yearlyField.setStyle(
                                focused ? fieldFocus : fieldNormal
                        )
        );

        descriptionArea.focusedProperty().addListener(
                (obs, oldValue, focused) -> {

                    if (focused) {

                        descriptionArea.setStyle(
                                "-fx-control-inner-background: #0d150e;" +
                                "-fx-background-color: #0d150e;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-size: 13px;" +
                                "-fx-padding: 10;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-color: " + PRIMARY + ";" +
                                "-fx-border-radius: 10;" +
                                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.18), 12, 0.2, 0, 0);"
                        );

                    } else {

                        descriptionArea.setStyle(
                                "-fx-control-inner-background: #0d150e;" +
                                "-fx-background-color: #0d150e;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-size: 13px;" +
                                "-fx-padding: 10;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-color: rgba(255,255,255,0.08);" +
                                "-fx-border-radius: 10;"
                        );
                    }
                }
        );

        // =====================================================
        // OPEN ANIMATION & SHOW
        // =====================================================

        overlay.getChildren().add(root);
        rootContainer.getChildren().add(overlay);

        overlay.setOpacity(0);
        root.setOpacity(0);
        root.setScaleX(0.85);
        root.setScaleY(0.85);
        root.setTranslateY(20);

        FadeTransition overlayFade = new FadeTransition(Duration.millis(250), overlay);
        overlayFade.setToValue(1);

        FadeTransition rootFade = new FadeTransition(Duration.millis(300), root);
        rootFade.setToValue(1);

        javafx.animation.ScaleTransition scale = new javafx.animation.ScaleTransition(Duration.millis(350), root);
        scale.setToX(1);
        scale.setToY(1);
        scale.setInterpolator(javafx.animation.Interpolator.SPLINE(0.25, 0.1, 0.25, 1)); // smooth ease out

        TranslateTransition translate = new TranslateTransition(Duration.millis(350), root);
        translate.setToY(0);
        translate.setInterpolator(javafx.animation.Interpolator.SPLINE(0.25, 0.1, 0.25, 1));

        overlayFade.play();
        rootFade.play();
        scale.play();
        translate.play();
    }

    private void closeEditDialog(StackPane overlay, VBox root) {
        FadeTransition overlayFade = new FadeTransition(Duration.millis(250), overlay);
        overlayFade.setToValue(0);

        FadeTransition rootFade = new FadeTransition(Duration.millis(200), root);
        rootFade.setToValue(0);

        javafx.animation.ScaleTransition scale = new javafx.animation.ScaleTransition(Duration.millis(250), root);
        scale.setToX(0.85);
        scale.setToY(0.85);
        scale.setInterpolator(javafx.animation.Interpolator.EASE_IN);

        TranslateTransition translate = new TranslateTransition(Duration.millis(250), root);
        translate.setToY(20);
        translate.setInterpolator(javafx.animation.Interpolator.EASE_IN);

        overlayFade.setOnFinished(e -> rootContainer.getChildren().remove(overlay));

        overlayFade.play();
        rootFade.play();
        scale.play();
        translate.play();
    }

    // =========================================================
    // PRICE DATA CLASS
    // =========================================================

    private static class PriceData {

        Label priceLabel;
        Label yearlyLabel;

        String monthlyPrice;
        String yearlyPrice;

        PriceData(
                Label priceLabel,
                Label yearlyLabel,
                String monthlyPrice,
                String yearlyPrice
        ) {

            this.priceLabel = priceLabel;
            this.yearlyLabel = yearlyLabel;

            this.monthlyPrice = monthlyPrice;
            this.yearlyPrice = yearlyPrice;
        }
    }

    // =========================================================
    // ADD NEW MEMBERSHIP EDITOR
    // =========================================================

    private void showAddMembershipEditor() {

        VBox page = new VBox();
        page.setFillWidth(true);

        page.setStyle(
                "-fx-background-color: " + BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        ScrollPane scroll = new ScrollPane();

        VBox form = new VBox(22);

        form.setPadding(
                new Insets(28, 30, 35, 30)
        );

        form.setMaxWidth(900);

        form.setStyle(
                "-fx-background-color: transparent;"
        );

        // =====================================================
        // TOP ROW
        // =====================================================

        HBox editorTopRow = new HBox();

        editorTopRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Button back = new Button("← Back");

        String backDef =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 18;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";

        String backHover =
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 18;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";

        back.setStyle(backDef);

        back.setOnMouseEntered(
                e -> back.setStyle(backHover)
        );

        back.setOnMouseExited(
                e -> back.setStyle(backDef)
        );

        back.setOnAction(
                e -> showMainPage()
        );

        Region topSpacer = new Region();

        HBox.setHgrow(
                topSpacer,
                Priority.ALWAYS
        );

        Label modeLabel = new Label(
                "Add New Membership"
        );

        modeLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 19px;" +
                " -fx-font-weight: bold;"
        );

        editorTopRow.getChildren().addAll(
                back,
                topSpacer,
                modeLabel
        );

        // =====================================================
        // TITLE SECTION
        // =====================================================

        VBox titleSection = new VBox(5);

        Label mainTitle = new Label(
                "Create a New Membership Package"
        );

        mainTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 30px;" +
                " -fx-font-weight: bold;"
        );

        Label mainSub = new Label(
                "Configure pricing, benefits, and details for a new membership tier."
        );

        mainSub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 13px;"
        );

        mainSub.setWrapText(true);

        titleSection.getChildren().addAll(
                mainTitle,
                mainSub
        );

        // =====================================================
        // FORM CARD
        // =====================================================

        VBox formCard = new VBox(18);

        formCard.setPadding(
                new Insets(24)
        );

        formCard.setStyle(
                "-fx-background-color: " + BOX_COLOR + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-radius: 18;"
        );

        formCard.setEffect(
                new DropShadow(
                        30, 0, 10,
                        Color.color(0, 0, 0, 0.4)
                )
        );

        // =====================================================
        // FORM FIELDS
        // =====================================================

        TextField packageName = createMembershipField(
                "Package Name",
                "e.g. Gold, Diamond, Starter"
        );

        TextField packageIcon = createMembershipField(
                "Package Icon (emoji)",
                "e.g. 🏆, ⚡, 💎"
        );

        // ----- Monthly Price -----
        VBox monthlyBox = new VBox(7);

        Label monthlyLabel = new Label("MONTHLY PRICE");

        monthlyLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        HBox monthlyInputBox = new HBox(6);
        monthlyInputBox.setAlignment(Pos.CENTER_LEFT);

        Label dollar1 = new Label("$");

        dollar1.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        TextField monthlyField = new TextField();
        monthlyField.setPromptText("e.g. 29");

        monthlyField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(monthlyField, Priority.ALWAYS);

        String fStyle =
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #617062;" +
                "-fx-font-size: 15px;" +
                "-fx-padding: 11 13;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;";

        String fFocus =
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #617062;" +
                "-fx-font-size: 15px;" +
                "-fx-padding: 11 13;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.18), 12, 0.2, 0, 0);";

        monthlyField.setStyle(fStyle);

        monthlyField.focusedProperty().addListener(
                (obs, oldV, focused) ->
                        monthlyField.setStyle(
                                focused ? fFocus : fStyle
                        )
        );

        monthlyInputBox.getChildren().addAll(
                dollar1, monthlyField
        );

        monthlyBox.getChildren().addAll(
                monthlyLabel, monthlyInputBox
        );

        // ----- Yearly Price -----
        VBox yearlyBox = new VBox(7);

        Label yearlyLabel = new Label("YEARLY PRICE");

        yearlyLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        HBox yearlyInputBox = new HBox(6);
        yearlyInputBox.setAlignment(Pos.CENTER_LEFT);

        Label dollar2 = new Label("$");

        dollar2.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        TextField yearlyField = new TextField();
        yearlyField.setPromptText("e.g. 290");

        yearlyField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(yearlyField, Priority.ALWAYS);

        yearlyField.setStyle(fStyle);

        yearlyField.focusedProperty().addListener(
                (obs, oldV, focused) ->
                        yearlyField.setStyle(
                                focused ? fFocus : fStyle
                        )
        );

        yearlyInputBox.getChildren().addAll(
                dollar2, yearlyField
        );

        yearlyBox.getChildren().addAll(
                yearlyLabel, yearlyInputBox
        );

        // ----- Description -----
        VBox descriptionBox = new VBox(7);

        Label descriptionLabel = new Label(
                "PACKAGE DESCRIPTION"
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        TextArea descriptionArea = new TextArea();

        descriptionArea.setPromptText(
                "Describe what this membership offers..."
        );

        descriptionArea.setWrapText(true);
        descriptionArea.setPrefRowCount(3);

        String aStyle =
                "-fx-control-inner-background: #0d150e;" +
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 10;";

        String aFocus =
                "-fx-control-inner-background: #0d150e;" +
                "-fx-background-color: #0d150e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.18), 12, 0.2, 0, 0);";

        descriptionArea.setStyle(aStyle);

        descriptionArea.focusedProperty().addListener(
                (obs, oldV, focused) ->
                        descriptionArea.setStyle(
                                focused ? aFocus : aStyle
                        )
        );

        descriptionBox.getChildren().addAll(
                descriptionLabel, descriptionArea
        );

        // ----- Benefits -----
        VBox benefitsBox = new VBox(7);

        Label benefitsLabel = new Label(
                "BENEFITS (one per line)"
        );

        benefitsLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        TextArea benefitsArea = new TextArea();

        benefitsArea.setPromptText(
                "Gym facility access\nBasic workout plans\nMember dashboard"
        );

        benefitsArea.setWrapText(true);
        benefitsArea.setPrefRowCount(5);
        benefitsArea.setStyle(aStyle);

        benefitsArea.focusedProperty().addListener(
                (obs, oldV, focused) ->
                        benefitsArea.setStyle(
                                focused ? aFocus : aStyle
                        )
        );

        benefitsBox.getChildren().addAll(
                benefitsLabel, benefitsArea
        );

        // ----- Popular Toggle -----
        HBox popularRow = new HBox(12);
        popularRow.setAlignment(Pos.CENTER_LEFT);

        CheckBox popularCheck = new CheckBox();

        Label popularLbl = new Label(
                "Mark as Popular"
        );

        popularLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        popularRow.getChildren().addAll(
                popularCheck, popularLbl
        );

        formCard.getChildren().addAll(
                packageName,
                packageIcon,
                monthlyBox,
                yearlyBox,
                descriptionBox,
                benefitsBox,
                popularRow
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        HBox buttons = new HBox(12);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        Button cancel = new Button("Cancel");

        cancel.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 24;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;"
        );

        cancel.setOnAction(
                e -> showMainPage()
        );

        Button save = new Button(
                "✓ Create Membership"
        );

        String saveDef =
                "-fx-background-color: " + PRIMARY +
                "; -fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 24;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";

        String saveHover =
                "-fx-background-color: #8affab;" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 24;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";

        save.setStyle(saveDef);

        save.setOnMouseEntered(
                e -> save.setStyle(saveHover)
        );

        save.setOnMouseExited(
                e -> save.setStyle(saveDef)
        );

        save.setOnAction(
                e -> {

                    if (packageName.getText()
                            .trim().isEmpty()) {

                        Alert alert = new Alert(
                                Alert.AlertType.WARNING
                        );

                        alert.setTitle(
                                "Package Name Required"
                        );

                        alert.setHeaderText(null);

                        alert.setContentText(
                                "Please enter a package name."
                        );

                        alert.showAndWait();
                        return;
                    }

                    Alert alert = new Alert(
                            Alert.AlertType.INFORMATION
                    );

                    alert.setTitle(
                            "Membership Created"
                    );

                    alert.setHeaderText(null);

                    alert.setContentText(
                            "New membership package '" +
                            packageName.getText() +
                            "' created successfully."
                    );

                    alert.showAndWait();
                    showMainPage();
                }
        );

        buttons.getChildren().addAll(
                cancel, save
        );

        // =====================================================
        // ASSEMBLE
        // =====================================================

        form.getChildren().addAll(
                editorTopRow,
                titleSection,
                formCard,
                buttons
        );

        StackPane formHolder =
                new StackPane(form);

        formHolder.setAlignment(Pos.TOP_CENTER);

        scroll.setContent(formHolder);
        scroll.setFitToWidth(true);

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        VBox.setVgrow(scroll, Priority.ALWAYS);

        page.getChildren().add(scroll);

        // =====================================================
        // ENTRY ANIMATION
        // =====================================================

        page.setOpacity(0);
        page.setTranslateY(28);

        rootContainer.getChildren().setAll(page);

        FadeTransition fade =
                new FadeTransition(
                        Duration.millis(320), page
                );

        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition slide =
                new TranslateTransition(
                        Duration.millis(360), page
                );

        slide.setFromY(28);
        slide.setToY(0);

        fade.play();
        slide.play();
    }

    // =========================================================
    // MEMBERSHIP FIELD HELPER
    // =========================================================

    private TextField createMembershipField(
            String labelText,
            String placeholder) {

        TextField field = new TextField();
        field.setPromptText(placeholder);
        field.setPrefHeight(44);

        field.setMaxWidth(Double.MAX_VALUE);

        String normalStyle =
                "-fx-background-color: #0d150e;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-prompt-text-fill: #617062;" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 14;";

        String focusStyle =
                "-fx-background-color: #0d150e;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-prompt-text-fill: #617062;" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 14;" +
                "-fx-effect: dropshadow(gaussian, rgba(117,255,158,0.18), 12, 0.2, 0, 0);";

        field.setStyle(normalStyle);

        field.focusedProperty().addListener(
                (obs, oldValue, focused) ->
                        field.setStyle(
                                focused ? focusStyle : normalStyle
                        )
        );

        return field;
    }

    // =========================================================
    // BACK TO MAIN PAGE
    // =========================================================

    private void showMainPage() {

        if (rootContainer == null ||
                membershipMainArea == null) {
            return;
        }

        if (rootContainer.getChildren().isEmpty()) {
            return;
        }

        Node currentPage =
                rootContainer.getChildren().get(0);

        FadeTransition fadeOut =
                new FadeTransition(
                        Duration.millis(200),
                        currentPage
                );

        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        TranslateTransition slideOut =
                new TranslateTransition(
                        Duration.millis(230),
                        currentPage
                );

        slideOut.setFromY(0);
        slideOut.setToY(18);

        fadeOut.setOnFinished(
                e -> {

                    rootContainer.getChildren()
                            .setAll(
                                    membershipMainArea
                            );

                    membershipMainArea.setOpacity(0);
                    membershipMainArea.setTranslateY(18);

                    FadeTransition fadeIn =
                            new FadeTransition(
                                    Duration.millis(280),
                                    membershipMainArea
                            );

                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);

                    TranslateTransition slideIn =
                            new TranslateTransition(
                                    Duration.millis(320),
                                    membershipMainArea
                            );

                    slideIn.setFromY(18);
                    slideIn.setToY(0);

                    fadeIn.play();
                    slideIn.play();
                }
        );

        fadeOut.play();
        slideOut.play();
    }
}
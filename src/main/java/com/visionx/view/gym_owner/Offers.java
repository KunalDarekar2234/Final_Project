package com.visionx.view.gym_owner;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Offers {

    private Scene OffersScene;
    private StackPane rootContainer;
    private ScrollPane offersMainArea;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String BOX_COLOR = "#020914";
    private final String SURFACE_BORDER = "rgba(255,255,255,0.05)";
    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DIM = "rgba(117,255,158,0.1)";
    private final String TEXT_MAIN = "#dbe5d9";
    private final String TEXT_MUTED = "#bacbb9";
    private final String ERROR = "#ffb4ab";
    private final String TERTIARY = "#ffba79";

    private final DropShadow glassShadow =
            new DropShadow(25, 0, 8, Color.color(0, 0, 0, 0.35));

    private final DropShadow primaryGlow =
            new DropShadow(15, Color.web(PRIMARY, 0.3));

    // =========================================================
    // REALTIME PROMOTION DATA
    // =========================================================

    private final List<Promotion> promotions = new ArrayList<>();

    private VBox promotionListContainer;

    // =========================================================
    // SCENE
    // =========================================================

    public Scene getOffersScene(Runnable callBackAction) {

        if (promotions.isEmpty()) {
            loadDefaultPromotions();
        }

        StackPane root = new StackPane();

        root.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        ScrollPane content = createMainContent();

        offersMainArea = content;
        rootContainer = root;

        root.getChildren().add(content);

        OffersScene = new Scene(root, 1160, 900);

        return OffersScene;
    }

    // =========================================================
    // DEFAULT PROMOTIONS
    // =========================================================

    private void loadDefaultPromotions() {

        promotions.add(new Promotion(
                "Annual Elite Pass Exclusive",
                "Ends in 12 Days • Code: ELITE2024",
                "30%",
                PRIMARY,
                "Active Now",
                true,
                "https://lh3.googleusercontent.com/aida-public/AB6AXuBAvkDG4bzg9eLy_XRkBkmb2JV3yyfoa9x2Vv610qfycLl4U_8B93bDeIkRM47f7grHekBbqRpCGIy9jedaW_t1rnj5Uf2KKsQxIIx5cKL5eOxj-bMDVyqCPIdpRTvtgKlRrZO2M9hFTg0aCPCzweWUYuDmpcMQr2AqylzGGlSjtYj5b35oSKZpSU1Nk6NEQrOZMCfYqICB4Ych3oXJelwz7Wp77nki1pZejkmjeNPMNepNnv2Bx8Td"
        ));

        promotions.add(new Promotion(
                "Mind & Body Renewal Week",
                "Starts July 01 • Code: ZENFIT",
                "15%",
                TERTIARY,
                "Scheduled",
                false,
                "https://lh3.googleusercontent.com/aida-public/AB6AXuBkPvODAR3Z_N_ci31WKpTUtOrTBDeGXAnUOhpww_OM8-waYR-65oK0sqmd1zRPxRV2WH-Zc7p1V61238IE71cAjk3gqXy8I8JZZUZhvfYeYvfkwPpxHadopCILgUrt5XY-HQ68hGu8vUM8-plMmIbept8bf0b7aUX-aNi_LJFZRX1rnAnTjVqT9PZMmnSiDeiTQ11_8Vk1E2o8clZlMngl3gxhYnxpw_6GGThyBGec_NY1V1_lRy63"
        ));

        promotions.add(new Promotion(
                "AI Trainer Pro Upgrade",
                "Ends in 2 Days • Code: AIREADY",
                "50%",
                PRIMARY,
                "Active Now",
                true,
                "https://lh3.googleusercontent.com/aida-public/AB6AXuB4Yz3dkXr56zxmtx4vxx5fjvTFhLZ6zjgdsH9z9zniwowonZh-Rv3bMMztxsM_Iy62cdotwObHdIh_uGY4R4Blbo9TicnQBFqB3-GQRtcgy7po5Js18b9-kss3xCQvbsR6kZZr_nsAVie-ZySgGY2Gg0IQObE5D1AKRLvrHeUsFh7Ld7B9wCB1pVNxzqwKXmD0RbN4f6EdIMwx0Fmf2cuBLx_j2JfPUgFEceTILaroEaPUkbhGNq"
        ));
    }

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private ScrollPane createMainContent() {

        VBox content = new VBox(32);

        content.setPadding(
                new Insets(32, 32, 40, 32)
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        HBox topRow = new HBox();

        topRow.setAlignment(Pos.BOTTOM_LEFT);

        VBox titleBox = new VBox(6);

        Label title = new Label("Offers & Discounts");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 34px;" +
                "-fx-font-weight: 800;"
        );

        Label sub = new Label(
                "Design and manage high-impact promotional campaigns."
        );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 15px;"
        );

        titleBox.getChildren().addAll(title, sub);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox statCard = new HBox(12);

        statCard.setAlignment(Pos.CENTER);
        statCard.setPadding(new Insets(8, 16, 8, 16));

        setGlassStyle(statCard);

        Label statIcon = new Label("📈");

        statIcon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;"
        );

        VBox sText = new VBox(2);

        Label s1 = new Label("CONVERSION RATE");

        s1.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label s2 = new Label("+12.4%");

        s2.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        sText.getChildren().addAll(s1, s2);
        statCard.getChildren().addAll(statIcon, sText);

        topRow.getChildren().addAll(
                titleBox,
                spacer,
                statCard
        );

        // -----------------------------------------------------
        // MIDDLE
        // -----------------------------------------------------

        HBox middleRow = new HBox(24);

        VBox formCard = createFormCard();
        VBox rightBento = createPreviewBento();

        formCard.setPrefWidth(430);
        formCard.setMinWidth(400);
        formCard.setMaxWidth(450);

        HBox.setHgrow(rightBento, Priority.ALWAYS);

        middleRow.getChildren().addAll(
                formCard,
                rightBento
        );

        // -----------------------------------------------------
        // PROMOTION LIST
        // -----------------------------------------------------

        VBox promoList = createPromoList();

        content.getChildren().addAll(
                topRow,
                middleRow,
                promoList
        );

        ScrollPane scroll = new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        return scroll;
    }

    // =========================================================
    // CREATE FORM CARD
    // =========================================================

    private VBox createFormCard() {

        VBox card = new VBox(18);

        card.setPadding(new Insets(24));

        setGlassStyle(card);

        card.setEffect(primaryGlow);

        HBox header = new HBox(12);

        header.setAlignment(Pos.CENTER_LEFT);

        Label icon = new Label("🖼");

        icon.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 9;" +
                "-fx-background-radius: 12;"
        );

        Label title = new Label("Create New Banner");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        header.getChildren().addAll(icon, title);

        VBox f1 = createInputGroup(
                "PROMOTION TITLE",
                "e.g., Summer Shred Kickoff",
                false
        );

        HBox f2Row = new HBox(12);

        VBox f2a = createInputGroup(
                "DISCOUNT %",
                "20",
                true
        );

        VBox f2b = createInputGroup(
                "VALIDITY DAYS",
                "30",
                false
        );

        HBox.setHgrow(f2a, Priority.ALWAYS);
        HBox.setHgrow(f2b, Priority.ALWAYS);

        f2Row.getChildren().addAll(f2a, f2b);

        // -----------------------------------------------------
        // BANNER UPLOAD
        // -----------------------------------------------------

        VBox uploadGroup = new VBox(7);

        Label uLbl = new Label("BANNER MEDIA");

        uLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        StackPane bannerPicker = createBannerPicker();

        uploadGroup.getChildren().addAll(
                uLbl,
                bannerPicker
        );

        // -----------------------------------------------------
        // CREATE BUTTON
        // -----------------------------------------------------

        Button submitBtn = new Button(
                "🚀  GENERATE PROMOTION"
        );

        submitBtn.setMaxWidth(Double.MAX_VALUE);

        String btnDef =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #111827;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 13;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;";

        submitBtn.setStyle(btnDef);

        submitBtn.setOnMouseEntered(e ->
                submitBtn.setEffect(primaryGlow)
        );

        submitBtn.setOnMouseExited(e ->
                submitBtn.setEffect(null)
        );

        card.getChildren().addAll(
                header,
                f1,
                f2Row,
                uploadGroup,
                submitBtn
        );

        return card;
    }

    // =========================================================
    // BANNER PICKER
    // =========================================================

    private StackPane createBannerPicker() {

        StackPane picker = new StackPane();

        picker.setPrefHeight(135);
        picker.setMinHeight(135);
        picker.setMaxHeight(135);

        picker.setStyle(
                "-fx-background-color: rgba(255,255,255,0.02);" +
                "-fx-border-color: rgba(255,255,255,0.10);" +
                "-fx-border-style: dashed;" +
                "-fx-border-width: 1.5;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;"
        );

        VBox defaultContent = new VBox(6);

        defaultContent.setAlignment(Pos.CENTER);

        Label icon = new Label("☁");

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 30px;"
        );

        Label text = new Label("Click to upload banner");

        text.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label sub = new Label(
                "PNG / JPG • Recommended 1920 × 600"
        );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );

        defaultContent.getChildren().addAll(
                icon,
                text,
                sub
        );

        picker.getChildren().add(defaultContent);

        picker.setOnMouseClicked(e -> {

            Window window = picker.getScene() != null
                    ? picker.getScene().getWindow()
                    : null;

            FileChooser chooser = new FileChooser();

            chooser.setTitle("Select Banner Image");

            chooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "Image Files",
                            "*.png",
                            "*.jpg",
                            "*.jpeg",
                            "*.webp"
                    )
            );

            File file = chooser.showOpenDialog(window);

            if (file != null) {

                showBannerPreview(
                        picker,
                        file.toURI().toString()
                );
            }
        });

        return picker;
    }

    // =========================================================
    // SHOW SELECTED BANNER
    // =========================================================

    private void showBannerPreview(
            StackPane picker,
            String imageUrl
    ) {

        Image image;

        try {

            image = new Image(
                    imageUrl,
                    500,
                    125,
                    true,
                    true
            );

        } catch (Exception ex) {
            return;
        }

        if (image.isError()) {
            return;
        }

        ImageView imageView = new ImageView(image);

        // IMPORTANT:
        // IMAGE WILL NOT FLOAT
        imageView.setFitWidth(480);
        imageView.setFitHeight(125);
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);
        imageView.setMouseTransparent(true);

        StackPane.setAlignment(
                imageView,
                Pos.CENTER
        );

        Button change = new Button("CHANGE");

        change.setStyle(
                "-fx-background-color: rgba(0,0,0,0.65);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 6 10;" +
                "-fx-background-radius: 7;" +
                "-fx-cursor: hand;"
        );

        StackPane.setAlignment(
                change,
                Pos.BOTTOM_RIGHT
        );

        StackPane.setMargin(
                change,
                new Insets(0, 8, 8, 0)
        );

        change.setOnAction(e -> {

            Window window = picker.getScene() != null
                    ? picker.getScene().getWindow()
                    : null;

            FileChooser chooser = new FileChooser();

            chooser.setTitle("Change Banner Image");

            chooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "Image Files",
                            "*.png",
                            "*.jpg",
                            "*.jpeg",
                            "*.webp"
                    )
            );

            File file = chooser.showOpenDialog(window);

            if (file != null) {

                showBannerPreview(
                        picker,
                        file.toURI().toString()
                );
            }
        });

        picker.getChildren().clear();

        picker.getChildren().addAll(
                imageView,
                change
        );

        picker.setStyle(
                "-fx-background-color: #050b07;" +
                "-fx-border-color: rgba(117,255,158,0.4);" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;"
        );

        // Keep image non-interactive.
        imageView.setMouseTransparent(true);
    }

    // =========================================================
    // INPUT
    // =========================================================

    private VBox createInputGroup(
            String label,
            String prompt,
            boolean isPercentage
    ) {

        VBox box = new VBox(6);

        Label lbl = new Label(label);

        lbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        StackPane inputWrap = new StackPane();

        TextField field = new TextField();

        field.setPromptText(prompt);

        String normal =
                "-fx-background-color: #081009;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-padding: 10 13;";

        String focused =
                "-fx-background-color: #081009;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-padding: 10 13;";

        field.setStyle(normal);

        field.focusedProperty().addListener(
                (obs, oldValue, focusedValue) -> {

                    field.setStyle(
                            focusedValue
                                    ? focused
                                    : normal
                    );
                }
        );

        inputWrap.getChildren().add(field);

        if (isPercentage) {

            Label pct = new Label("%");

            pct.setStyle(
                    "-fx-text-fill: " + TEXT_MUTED + ";" +
                    "-fx-padding: 0 12 0 0;"
            );

            StackPane.setAlignment(
                    pct,
                    Pos.CENTER_RIGHT
            );

            inputWrap.getChildren().add(pct);
        }

        box.getChildren().addAll(
                lbl,
                inputWrap
        );

        return box;
    }

    // =========================================================
    // RIGHT PREVIEW
    // =========================================================

    private VBox createPreviewBento() {

        VBox col = new VBox(18);

        StackPane preview = new StackPane();

        preview.setPrefHeight(275);
        preview.setMinHeight(275);
        preview.setMaxHeight(275);

        setGlassStyle(preview);

        Region imageRegion = new Region();

        imageRegion.setStyle(
                "-fx-background-color: #17231a;" +
                "-fx-background-radius: 22;"
        );

        Region gradient = new Region();

        gradient.setStyle(
                "-fx-background-color: linear-gradient(to right, #0d150e 5%, transparent 90%);" +
                "-fx-background-radius: 22;"
        );

        VBox pText = new VBox(8);

        pText.setPadding(
                new Insets(28)
        );

        pText.setAlignment(
                Pos.CENTER_LEFT
        );

        Label badge = new Label("NEW CAMPAIGN");

        badge.setStyle(
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #111827;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 10px;" +
                "-fx-padding: 4 10;" +
                "-fx-background-radius: 20;"
        );

        Label t1 = new Label("SUMMER");

        t1.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 40px;" +
                "-fx-font-weight: 800;"
        );

        Label t2 = new Label("SHRED 2024");

        t2.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 40px;" +
                "-fx-font-weight: 800;"
        );

        Label desc = new Label(
                "Experience elite training with 25% off all premium packages."
        );

        desc.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 13px;"
        );

        desc.setWrapText(true);
        desc.setMaxWidth(330);

        pText.getChildren().addAll(
                badge,
                t1,
                t2,
                desc
        );

        preview.getChildren().addAll(
                imageRegion,
                gradient,
                pText
        );

        HBox stats = new HBox(18);

        VBox s1 = createStatsCard(
                "🎯",
                "Total Impressions",
                "4.2k",
                "+18%",
                PRIMARY
        );

        VBox s2 = createStatsCard(
                "🎟",
                "Coupons Redeemed",
                "842",
                "New",
                TERTIARY
        );

        HBox.setHgrow(s1, Priority.ALWAYS);
        HBox.setHgrow(s2, Priority.ALWAYS);

        stats.getChildren().addAll(s1, s2);

        col.getChildren().addAll(
                preview,
                stats
        );

        return col;
    }

    // =========================================================
    // STATS
    // =========================================================

    private VBox createStatsCard(
            String icon,
            String title,
            String value,
            String badge,
            String color
    ) {

        VBox card = new VBox(15);

        card.setPadding(
                new Insets(18)
        );

        setGlassStyle(card);

        HBox top = new HBox();

        Label i = new Label(icon);

        i.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 7;" +
                "-fx-background-radius: 8;"
        );

        Region sp = new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        Label b = new Label(badge);

        b.setStyle(
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        top.getChildren().addAll(
                i,
                sp,
                b
        );

        Label val = new Label(value);

        val.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;"
        );

        Label txt = new Label(
                title.toUpperCase()
        );

        txt.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                top,
                val,
                txt
        );

        return card;
    }

    // =========================================================
    // PROMOTION LIST
    // =========================================================

    private VBox createPromoList() {

        VBox list = new VBox(14);

        HBox header = new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox titleBox = new HBox(10);

        titleBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Label icon = new Label("📋");

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 21px;"
        );

        Label title = new Label(
                "Active Promotions"
        );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        titleBox.getChildren().addAll(
                icon,
                title
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button addBtn = new Button(
                "+  Add Promotion"
        );

        String addStyle =
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #07110a;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 9 16;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";

        addBtn.setStyle(addStyle);

        addBtn.setOnAction(
                e -> showAddPromotionEditor()
        );

        header.getChildren().addAll(
                titleBox,
                spacer,
                addBtn
        );

        list.getChildren().add(header);

        // REALTIME CONTAINER
        promotionListContainer = new VBox(10);

        refreshPromotionList();

        list.getChildren().add(
                promotionListContainer
        );

        return list;
    }

    // =========================================================
    // REFRESH LIST - REALTIME
    // =========================================================

    private void refreshPromotionList() {

        if (promotionListContainer == null) {
            return;
        }

        promotionListContainer.getChildren().clear();

        for (Promotion promotion : promotions) {

            promotionListContainer.getChildren().add(
                    createPromoRow(promotion)
            );
        }
    }

    // =========================================================
    // PROMOTION ROW
    // =========================================================

    private HBox createPromoRow(
            Promotion promotion
    ) {

        HBox row = new HBox(18);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(12)
        );

        row.setMinHeight(120);
        row.setPrefHeight(120);
        row.setMaxHeight(120);

        setGlassStyle(row);

        // -----------------------------------------------------
        // FIXED IMAGE
        // -----------------------------------------------------

        StackPane imageBox = new StackPane();

        imageBox.setMinSize(170, 94);
        imageBox.setPrefSize(170, 94);
        imageBox.setMaxSize(170, 94);

        imageBox.setStyle(
                "-fx-background-color: #111a13;" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: rgba(255,255,255,0.08);" +
                "-fx-border-radius: 12;"
        );

        ImageView imageView = createSafeImageView(
                promotion.imageUrl,
                170,
                94
        );

        // VERY IMPORTANT
        imageView.setMouseTransparent(true);

        imageBox.getChildren().add(imageView);

        // -----------------------------------------------------
        // INFO
        // -----------------------------------------------------

        VBox info = new VBox(4);

        info.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                info,
                Priority.ALWAYS
        );

        HBox statusBox = new HBox(6);

        statusBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Circle dot = new Circle(
                3.5,
                Color.web(promotion.statusColor)
        );

        Label status = new Label(
                promotion.status.toUpperCase()
        );

        status.setStyle(
                "-fx-text-fill: " + promotion.statusColor + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        statusBox.getChildren().addAll(
                dot,
                status
        );

        Label title = new Label(
                promotion.title
        );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        title.setWrapText(true);

        Label sub = new Label(
                promotion.sub
        );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 10px;"
        );

        info.getChildren().addAll(
                statusBox,
                title,
                sub
        );

        // -----------------------------------------------------
        // DISCOUNT
        // -----------------------------------------------------

        VBox discount = new VBox(1);

        discount.setAlignment(
                Pos.CENTER
        );

        discount.setMinWidth(85);
        discount.setPrefWidth(85);
        discount.setMaxWidth(85);

        Label discountValue = new Label(
                promotion.discount
        );

        discountValue.setStyle(
                "-fx-text-fill: " + promotion.discountColor + ";" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label discountText = new Label(
                "DISCOUNT"
        );

        discountText.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 9px;"
        );

        discount.getChildren().addAll(
                discountValue,
                discountText
        );

        // -----------------------------------------------------
        // ACTIONS
        // -----------------------------------------------------

        HBox actions = new HBox(6);

        actions.setAlignment(
                Pos.CENTER
        );

        Button publish = new Button(
                promotion.active
                        ? "PUBLISH"
                        : "PUBLISHED"
        );

        publish.setStyle(
                promotion.active
                        ? "-fx-background-color: " + PRIMARY + ";" +
                          "-fx-text-fill: #07110a;" +
                          "-fx-font-weight: bold;" +
                          "-fx-font-size: 10px;" +
                          "-fx-padding: 9 12;" +
                          "-fx-background-radius: 8;" +
                          "-fx-cursor: hand;"
                        : "-fx-background-color: #2e372e;" +
                          "-fx-text-fill: " + TEXT_MUTED + ";" +
                          "-fx-font-weight: bold;" +
                          "-fx-font-size: 10px;" +
                          "-fx-padding: 9 12;" +
                          "-fx-background-radius: 8;"
        );

        Button update = new Button(
                "UPDATE"
        );

        update.setStyle(
                "-fx-background-color: rgba(255,255,255,0.06);" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 10px;" +
                "-fx-padding: 9 12;" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;"
        );

        update.setOnAction(
                e -> showUpdatePromotionEditor(promotion)
        );

        Button delete = new Button(
                "🗑"
        );

        delete.setStyle(
                "-fx-background-color: rgba(255,180,171,0.1);" +
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-padding: 9;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        delete.setOnAction(e -> {

            Alert confirm = new Alert(
                    Alert.AlertType.CONFIRMATION
            );

            confirm.setTitle(
                    "Delete Promotion"
            );

            confirm.setHeaderText(
                    null
            );

            confirm.setContentText(
                    "Delete \"" +
                    promotion.title +
                    "\"?"
            );

            confirm.showAndWait().ifPresent(
                    result -> {

                        if (result ==
                                ButtonType.OK) {

                            promotions.remove(
                                    promotion
                            );

                            refreshPromotionList();
                        }
                    }
            );
        });

        actions.getChildren().addAll(
                publish,
                update,
                delete
        );

        row.getChildren().addAll(
                imageBox,
                info,
                discount,
                actions
        );

        return row;
    }

    // =========================================================
    // SAFE IMAGE VIEW
    // =========================================================

    private ImageView createSafeImageView(
            String url,
            double width,
            double height
    ) {

        Image image;

        try {

            image = new Image(
                    url,
                    width,
                    height,
                    false,
                    true,
                    true
            );

        } catch (Exception ex) {

            image = null;
        }

        ImageView imageView = new ImageView();

        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        // Fixed box - image won't float
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);
        imageView.setMouseTransparent(true);

        if (image != null && !image.isError()) {
            imageView.setImage(image);
        }

        return imageView;
    }

    // =========================================================
    // UPDATE EDITOR
    // =========================================================

    private void showUpdatePromotionEditor(
            Promotion promotion
    ) {

        if (rootContainer == null) {
            return;
        }

        VBox page = createEditorPage(
                promotion,
                false
        );

        showEditorPage(page);
    }

    // =========================================================
    // ADD EDITOR
    // =========================================================

    private void showAddPromotionEditor() {

        if (rootContainer == null) {
            return;
        }

        VBox page = createEditorPage(
                null,
                true
        );

        showEditorPage(page);
    }

    // =========================================================
    // COMMON EDITOR
    // =========================================================

    private VBox createEditorPage(
            Promotion existing,
            boolean isAdd
    ) {

        VBox page = new VBox();

        page.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        ScrollPane scroll = new ScrollPane();

        VBox form = new VBox(20);

        form.setPadding(
                new Insets(30, 40, 40, 40)
        );

        form.setMaxWidth(820);

        // -----------------------------------------------------
        // TOP
        // -----------------------------------------------------

        HBox topRow = new HBox();

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Button back = new Button(
                "← Back"
        );

        back.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 16;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        back.setOnAction(
                e -> closeAddPromotionEditor()
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label pageTitle = new Label(
                isAdd
                        ? "Add New Promotion"
                        : "Update Promotion"
        );

        pageTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        topRow.getChildren().addAll(
                back,
                spacer,
                pageTitle
        );

        // -----------------------------------------------------
        // CARD
        // -----------------------------------------------------

        VBox card = new VBox(18);

        card.setPadding(
                new Insets(25)
        );

        setGlassStyle(card);

        TextField titleField = new TextField();

        titleField.setPromptText(
                "e.g. Summer Flash Sale"
        );

        titleField.setText(
                existing != null
                        ? existing.title
                        : ""
        );

        styleTextField(titleField);

        VBox titleBox = labeled(
                "PROMOTION TITLE",
                titleField
        );

        TextField discountField = new TextField();

        discountField.setPromptText(
                "25"
        );

        if (existing != null) {

            discountField.setText(
                    existing.discount
                            .replace("%", "")
            );
        }

        styleTextField(discountField);

        VBox discountBox = labeled(
                "DISCOUNT %",
                discountField
        );

        // -----------------------------------------------------
        // DATES
        // -----------------------------------------------------

        HBox dateRow = new HBox(12);

        DatePicker startDate =
                new DatePicker();

        DatePicker endDate =
                new DatePicker();

        if (existing != null) {

            startDate.setValue(
                    existing.startDate
            );

            endDate.setValue(
                    existing.endDate
            );
        }

        startDate.setMaxWidth(
                Double.MAX_VALUE
        );

        endDate.setMaxWidth(
                Double.MAX_VALUE
        );

        styleDatePicker(startDate);
        styleDatePicker(endDate);

        VBox startBox =
                labeled(
                        "START DATE",
                        startDate
                );

        VBox endBox =
                labeled(
                        "END DATE",
                        endDate
                );

        HBox.setHgrow(
                startBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                endBox,
                Priority.ALWAYS
        );

        dateRow.getChildren().addAll(
                startBox,
                endBox
        );

        // -----------------------------------------------------
        // BANNER
        // -----------------------------------------------------

        Label bannerLabel =
                new Label("BANNER MEDIA");

        bannerLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        StackPane bannerPicker =
                createEditorBannerPicker(
                        existing != null
                                ? existing.imageUrl
                                : null
                );

        // -----------------------------------------------------
        // BUTTONS
        // -----------------------------------------------------

        HBox buttons = new HBox(10);

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button cancel =
                new Button("Cancel");

        cancel.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        cancel.setOnAction(
                e -> closeAddPromotionEditor()
        );

        Button save =
                new Button(
                        isAdd
                                ? "✓ Create Promotion"
                                : "✓ Update Promotion"
                );

        save.setStyle(
                "-fx-background-color: " + PRIMARY + ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        save.setOnAction(e -> {

            String title =
                    titleField.getText().trim();

            String discount =
                    discountField.getText().trim();

            String imageUrl =
                    (String) bannerPicker.getUserData();

            if (title.isEmpty()) {

                showError(
                        "Please enter promotion title."
                );

                return;
            }

            if (discount.isEmpty()) {

                showError(
                        "Please enter discount."
                );

                return;
            }

            if (imageUrl == null ||
                    imageUrl.isBlank()) {

                showError(
                        "Please select a banner image."
                );

                return;
            }

            String dateText;

            if (startDate.getValue() != null &&
                    endDate.getValue() != null) {

                dateText =
                        "Valid " +
                        startDate.getValue() +
                        " to " +
                        endDate.getValue();

            } else {

                dateText =
                        "Promotion available now";
            }

            if (isAdd) {

                Promotion newPromotion =
                        new Promotion(
                                title,
                                dateText,
                                discount + "%",
                                PRIMARY,
                                "Active Now",
                                true,
                                imageUrl
                        );

                newPromotion.startDate =
                        startDate.getValue();

                newPromotion.endDate =
                        endDate.getValue();

                promotions.add(
                        0,
                        newPromotion
                );

            } else {

                existing.title =
                        title;

                existing.discount =
                        discount + "%";

                existing.sub =
                        dateText;

                existing.imageUrl =
                        imageUrl;

                existing.startDate =
                        startDate.getValue();

                existing.endDate =
                        endDate.getValue();

                existing.status =
                        "Active Now";
            }

            // =================================================
            // REALTIME UPDATE
            // =================================================

            refreshPromotionList();

            closeAddPromotionEditor();
        });

        buttons.getChildren().addAll(
                cancel,
                save
        );

        card.getChildren().addAll(
                titleBox,
                discountBox,
                dateRow,
                bannerLabel,
                bannerPicker,
                buttons
        );

        form.getChildren().addAll(
                topRow,
                card
        );

        StackPane holder =
                new StackPane(form);

        holder.setAlignment(
                Pos.TOP_CENTER
        );

        scroll.setContent(holder);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;"
        );

        page.getChildren().add(
                scroll
        );

        VBox.setVgrow(
                scroll,
                Priority.ALWAYS
        );

        return page;
    }

    // =========================================================
    // EDITOR BANNER PICKER
    // =========================================================

    private StackPane createEditorBannerPicker(
            String existingImage
    ) {

        StackPane picker =
                new StackPane();

        picker.setPrefHeight(180);
        picker.setMinHeight(180);
        picker.setMaxHeight(180);

        picker.setUserData(
                existingImage
        );

        if (existingImage != null &&
                !existingImage.isBlank()) {

            setEditorImage(
                    picker,
                    existingImage
            );

        } else {

            showEditorPlaceholder(
                    picker
            );
        }

        picker.setOnMouseClicked(
                e -> openBannerChooser(picker)
        );

        return picker;
    }

    // =========================================================
    // OPEN FILE CHOOSER
    // =========================================================

    private void openBannerChooser(
            StackPane picker
    ) {

        Window window =
                picker.getScene() != null
                        ? picker.getScene().getWindow()
                        : null;

        FileChooser chooser =
                new FileChooser();

        chooser.setTitle(
                "Select Banner Image"
        );

        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Banner Images",
                        "*.png",
                        "*.jpg",
                        "*.jpeg",
                        "*.webp"
                )
        );

        File file =
                chooser.showOpenDialog(window);

        if (file == null) {
            return;
        }

        String imageUrl =
                file.toURI().toString();

        picker.setUserData(
                imageUrl
        );

        setEditorImage(
                picker,
                imageUrl
        );
    }

    // =========================================================
    // EDITOR IMAGE
    // =========================================================

    private void setEditorImage(
            StackPane picker,
            String imageUrl
    ) {

        Image image =
                new Image(
                        imageUrl,
                        700,
                        170,
                        false,
                        true,
                        true
                );

        if (image.isError()) {
            showEditorPlaceholder(
                    picker
            );
            return;
        }

        ImageView imageView =
                new ImageView(image);

        imageView.setFitWidth(700);
        imageView.setFitHeight(170);

        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);

        // NO FLOATING / NO CLICK
        imageView.setMouseTransparent(true);

        Button change =
                new Button("CHANGE BANNER");

        change.setStyle(
                "-fx-background-color: rgba(0,0,0,0.7);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 7 12;" +
                "-fx-background-radius: 7;" +
                "-fx-cursor: hand;"
        );

        change.setOnAction(
                e -> openBannerChooser(picker)
        );

        StackPane.setAlignment(
                change,
                Pos.BOTTOM_RIGHT
        );

        StackPane.setMargin(
                change,
                new Insets(0, 10, 10, 0)
        );

        picker.getChildren().clear();

        picker.getChildren().addAll(
                imageView,
                change
        );

        picker.setStyle(
                "-fx-background-color: #050b07;" +
                "-fx-border-color: rgba(117,255,158,0.4);" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;"
        );
    }

    // =========================================================
    // PLACEHOLDER
    // =========================================================

    private void showEditorPlaceholder(
            StackPane picker
    ) {

        VBox box =
                new VBox(7);

        box.setAlignment(
                Pos.CENTER
        );

        Label icon =
                new Label("☁");

        icon.setStyle(
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 36px;"
        );

        Label text =
                new Label(
                        "Click to upload banner"
                );

        text.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label sub =
                new Label(
                        "PNG / JPG / WEBP • 1920 × 600 recommended"
                );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );

        box.getChildren().addAll(
                icon,
                text,
                sub
        );

        picker.getChildren().clear();

        picker.getChildren().add(
                box
        );

        picker.setStyle(
                "-fx-background-color: rgba(255,255,255,0.02);" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-style: dashed;" +
                "-fx-border-width: 1.5;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;"
        );
    }

    // =========================================================
    // LABEL WRAPPER
    // =========================================================

    private VBox labeled(
            String label,
            Node node
    ) {

        VBox box =
                new VBox(6);

        Label lbl =
                new Label(label);

        lbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        box.getChildren().addAll(
                lbl,
                node
        );

        return box;
    }

    // =========================================================
    // TEXT FIELD STYLE
    // =========================================================

    private void styleTextField(
            TextField field
    ) {

        String normal =
                "-fx-background-color: #081009;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-padding: 11 13;";

        String focus =
                "-fx-background-color: #081009;" +
                "-fx-border-color: " + PRIMARY + ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-padding: 11 13;";

        field.setStyle(normal);

        field.focusedProperty().addListener(
                (obs, old, value) ->
                        field.setStyle(
                                value ? focus : normal
                        )
        );
    }

    // =========================================================
    // DATE PICKER STYLE
    // =========================================================

    private void styleDatePicker(
            DatePicker picker
    ) {

        picker.setStyle(
                "-fx-background-color: #081009;" +
                "-fx-control-inner-background: #081009;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );
    }

    // =========================================================
    // EDITOR SHOW
    // =========================================================

    private void showEditorPage(
            VBox page
    ) {

        page.setOpacity(0);
        page.setTranslateY(20);

        rootContainer.getChildren().add(
                page
        );

        FadeTransition fade =
                new FadeTransition(
                        Duration.millis(220),
                        page
                );

        fade.setToValue(1);

        TranslateTransition slide =
                new TranslateTransition(
                        Duration.millis(250),
                        page
                );

        slide.setToY(0);

        fade.play();
        slide.play();
    }

    // =========================================================
    // CLOSE EDITOR
    // =========================================================

    private void closeAddPromotionEditor() {

        if (rootContainer == null ||
                rootContainer.getChildren().size() < 2) {

            return;
        }

        Node page =
                rootContainer.getChildren().get(
                        rootContainer.getChildren().size() - 1
                );

        FadeTransition fade =
                new FadeTransition(
                        Duration.millis(180),
                        page
                );

        fade.setToValue(0);

        TranslateTransition slide =
                new TranslateTransition(
                        Duration.millis(180),
                        page
                );

        slide.setToY(15);

        fade.setOnFinished(
                e -> rootContainer.getChildren().remove(
                        page
                )
        );

        fade.play();
        slide.play();
    }

    // =========================================================
    // ERROR
    // =========================================================

    private void showError(
            String message
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.WARNING
                );

        alert.setTitle(
                "Missing Information"
        );

        alert.setHeaderText(
                null
        );

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }

    // =========================================================
    // GLASS
    // =========================================================

    private void setGlassStyle(
            Region region
    ) {

        region.setStyle(
                "-fx-background-color: " + BOX_COLOR + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-border-radius: 18;"
        );

        region.setEffect(
                glassShadow
        );
    }

    // =========================================================
    // PROMOTION MODEL
    // =========================================================

    private static class Promotion {

        String title;
        String sub;
        String discount;
        String discountColor;
        String status;
        String statusColor;
        boolean active;
        String imageUrl;

        LocalDate startDate;
        LocalDate endDate;

        Promotion(
                String title,
                String sub,
                String discount,
                String discountColor,
                String status,
                boolean active,
                String imageUrl
        ) {

            this.title = title;
            this.sub = sub;
            this.discount = discount;
            this.discountColor = discountColor;
            this.status = status;
            this.statusColor = active
                    ? "#75ff9e"
                    : "#ffba79";
            this.active = active;
            this.imageUrl = imageUrl;
        }
    }
}
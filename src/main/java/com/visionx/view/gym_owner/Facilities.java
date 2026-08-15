package com.visionx.view.gym_owner;

import java.io.File;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class Facilities {

    private Scene FacilitiesScene;

    // =========================================================
    // Navigation Containers
    // =========================================================

    private StackPane rootContainer;
    private VBox facilitiesMainArea;

    // =========================================================
    // Color Palette
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String SURFACE = "rgba(21, 30, 22, 0.6)";
    private final String SURFACE_BORDER = "rgba(255, 255, 255, 0.08)";
    private final String PRIMARY = "#75ff9e";
    private final String PRIMARY_DIM = "rgba(117, 255, 158, 0.1)";
    private final String TEXT_MAIN = "#dbe5d9";
    private final String TEXT_MUTED = "#bacbb9";
    private final String ERROR = "#ffb4ab";
    private final String ERROR_BG = "rgba(147, 0, 10, 0.9)";
    private final String TERTIARY = "#ffba79";
    private final String TERTIARY_BG = "rgba(255, 186, 121, 0.9)";

    // =========================================================
    // Shared Effects
    // =========================================================

    private final DropShadow glassShadow =
            new DropShadow(
                    30,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.4)
            );

    // =========================================================
    // SCENE
    // =========================================================

    public Scene getFacilitiesScene(Runnable callBackAction) {

        VBox mainArea = new VBox();

        mainArea.setFillWidth(true);
        mainArea.setStyle(
                "-fx-background-color: " + BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        facilitiesMainArea = mainArea;

        ScrollPane content = createMainContent();

        VBox.setVgrow(
                content,
                Priority.ALWAYS
        );

        mainArea.getChildren().add(content);

        rootContainer = new StackPane();
        rootContainer.getChildren().add(mainArea);

        Scene scene =
                new Scene(
                        rootContainer,
                        1160,
                        900
                );

        FacilitiesScene = scene;

        return FacilitiesScene;
    }

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private ScrollPane createMainContent() {

        VBox content =
                new VBox(24);

        content.setPadding(
                new Insets(26, 30, 30, 30)
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );

        // =====================================================
        // PAGE TITLE
        // =====================================================

        HBox topRow =
                new HBox();

        topRow.setAlignment(
                Pos.BOTTOM_LEFT
        );

        VBox titleBox =
                new VBox(6);

        Label title =
                new Label(
                        "Facility Management"
                );

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 32px;" +
                " -fx-font-weight: 800;"
        );

        Label sub =
                new Label(
                        "Monitor your high-performance zones, " +
                        "track equipment health, and manage elite " +
                        "training environments in real-time."
                );

        sub.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 14px;"
        );

        sub.setWrapText(true);
        sub.setMaxWidth(620);

        titleBox.getChildren().addAll(
                title,
                sub
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // =====================================================
        // QUICK STATS
        // =====================================================

        HBox statsBox =
                new HBox(18);

        statsBox.setAlignment(
                Pos.BOTTOM_RIGHT
        );

        statsBox.getChildren().addAll(
                createMiniStat(
                        "12",
                        "TOTAL AREAS",
                        PRIMARY
                ),
                createStatDivider(),
                createMiniStat(
                        "98%",
                        "FUNCTIONAL",
                        "#fdb878"
                )
        );

        topRow.getChildren().addAll(
                titleBox,
                spacer,
                statsBox
        );

        // =====================================================
        // FACILITY GRID
        // =====================================================

        GridPane grid =
                new GridPane();

        grid.setHgap(18);
        grid.setVgap(18);

        ColumnConstraints cc1 =
                new ColumnConstraints();

        cc1.setPercentWidth(50);
        cc1.setHgrow(Priority.ALWAYS);

        ColumnConstraints cc2 =
                new ColumnConstraints();

        cc2.setPercentWidth(50);
        cc2.setHgrow(Priority.ALWAYS);

        grid.getColumnConstraints().addAll(
                cc1,
                cc2
        );

        // =====================================================
        // FACILITIES
        // =====================================================

        grid.add(
                createFacilityCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuCkkdo9GW6s7M8ltJ7tHVSiLfHwAeYpf1k8c5VpLNHarPi5EvbHGVxzyogn6dCc5AUVtw5t59_ZIXBTWw__HvyOJTOtJ6KjjDrDkGUb7RgHI4rkutjGSsIt_GPlzka5Mm8G56SuiUqxImKUd9mFnBBfA5aH1MYMYgZEBBFgyW81YQjUfw1lVf25RTidT8OIr99YLPEXoLMh7jABvRHAft-IKDFF4jQTi5nwjStReT4rVrl_4Ei2ucGB",
                        "Cardio Area",
                        "Zone A • Level 1",
                        "🏃",
                        "Active",
                        PRIMARY,
                        "Equipment Count",
                        "42 Units",
                        "Fully Functional",
                        PRIMARY
                ),
                0, 0
        );

        grid.add(
                createFacilityCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuCOEwcDJ6I4qpGkpwqX7hpoUma64ANvDYR_kXYmy557Mp6yp6AGREowohRaJ0qtw-ZZEdWkU2Utp4uAoSU40qGg7CwGAxVO09dEZCeHEutaeA5DgbswY25MiYG5Ev-Wfrx8fUJukZwQq_f841CYWECPro7dTdPXSdnZzg6sQPQLhzxucsYq7UbBkLXzB9abtDowP15HV3a8JGd7827TOLJZ1BhBcfTY4DsACar2fv2sl3dZ-Me6ZrGR",
                        "Yoga Room",
                        "Zone B • Level 3",
                        "🧘",
                        "Scheduled",
                        TERTIARY,
                        "Capacity",
                        "25 Persons",
                        "Fully Functional",
                        PRIMARY
                ),
                1, 0
        );

        grid.add(
                createFacilityCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuB5z4hJObK1RwMVTj_GnL_dz7C4IF8D6vQ3HhUwAIsy47iEXrWeXh4G5M-0RU4k4eBKeGAgJI-W_L4VAMPPOWjeNHpmh1OUy-YV4gkP6FYRaM1Ef1CI2c1JFTgGeM8dbNSJeoxeI75LzWuN7o1Iowa15xaA4bQuE7TwvMnqWZmPvasm7sFhgRaQ5HUcnhWZPHwLOSsSp0VbXNZZnu4PgAu-0dckVo4JDQgzd78GgmdZYIphJ55xgjbn",
                        "Strength Zone",
                        "Zone C • Level 1",
                        "🏋",
                        "Maintenance",
                        ERROR,
                        "Equipment Count",
                        "58 Units",
                        "2 Units Offline",
                        ERROR
                ),
                0, 1
        );

        grid.add(
                createFacilityCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuC_GvhDmfA7XCkRFKmRQmZR_dUaxuqRqv2BFGPTX5d3wLLaS2mUk6sDn0fLRoP4hgLgEPlTvJ4FcD4YJ4swTB9-hUAsfgWpet0nbN7MCfVnsgqNbNU4Ao_PQdhY7WU7aJpd9mYC7sqgRIEpNtb4wgAPO91qb0M3_Z-elijxeuf3ORjZUQa9wp2fbBE9XPx4-HpnbR6utk5UAAcTSYMpDIhMBG4uCgritatYgjuNwNypqJImvxzB4MJX",
                        "Aquatic Center",
                        "Zone D • Ground",
                        "🏊",
                        "Active",
                        PRIMARY,
                        "Current Occupancy",
                        "12 / 30",
                        "Fully Functional",
                        PRIMARY
                ),
                1, 1
        );

        grid.add(
                createFacilityCard(
                        "https://lh3.googleusercontent.com/aida-public/AB6AXuDkRTuBWfcibZzaTfhVaDFHYV4O_uUJ65rBE0xMV2ZZ0T_lXEBzcWbozAeiolvZcfUigM09RrfkB1aI0edf7YiLM8yL2Zc0L8pwQiToKoaknYmZ6UL-eynAzbOeH28EZOdgaubJ-hEHaxq705rgkDjI61YJugYkqfBMA7ZU4FodOpdV iUuUbfPHhHkvkVM_NygfwIWsxF-AXW2L0mnBtXc3T_hDaEQEkW7JSdy2Z_NioOO9Fy2oPdh",
                        "Sports Court",
                        "Zone E • Level 2",
                        "🏀",
                        "Active",
                        PRIMARY,
                        "Last Cleaning",
                        "2h ago",
                        "Fully Functional",
                        PRIMARY
                ),
                0, 2
        );

        grid.add(
                createAddFacilityCard(),
                1, 2
        );

        content.getChildren().addAll(
                topRow,
                grid
        );

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background: transparent;" +
                " -fx-background-color: transparent;" +
                " -fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        return scroll;
    }

    // =========================================================
    // MINI STAT
    // =========================================================

    private VBox createMiniStat(
            String value,
            String label,
            String color) {

        VBox box =
                new VBox(2);

        box.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " + color +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label text =
                new Label(label);

        text.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 9px;" +
                " -fx-font-weight: bold;"
        );

        box.getChildren().addAll(
                valueLabel,
                text
        );

        return box;
    }

    private Region createStatDivider() {

        Region divider =
                new Region();

        divider.setMinWidth(1);
        divider.setMinHeight(34);
        divider.setMaxHeight(34);

        divider.setStyle(
                "-fx-background-color: rgba(255,255,255,0.1);"
        );

        return divider;
    }

    // =========================================================
    // FACILITY CARD
    // =========================================================

    private VBox createFacilityCard(
            String imgUrl,
            String title,
            String subTitle,
            String icon,
            String badgeText,
            String badgeColorHex,
            String statLbl,
            String statVal,
            String statusTxt,
            String statusColHex) {

        final String[] currentImgUrl = {imgUrl};
        final String[] currentTitle = {title};

        VBox card =
                new VBox();

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setPrefHeight(315);
        card.setMinHeight(315);
        card.setMaxHeight(315);

        String cDef =
                "-fx-background-color: #020914;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-background-radius: 14;" +
                "-fx-border-radius: 14;";

        card.setStyle(cDef);
        card.setEffect(glassShadow);

        // =====================================================
        // IMAGE
        // =====================================================

        StackPane imgWrap =
                new StackPane();

        imgWrap.setPrefHeight(138);
        imgWrap.setMinHeight(138);
        imgWrap.setMaxHeight(138);

        imgWrap.setStyle(
                "-fx-background-color: #07110b;" +
                "-fx-background-radius: 14 14 0 0;"
        );

        ImageView img =
                new ImageView();

        try {

            if (currentImgUrl[0] != null &&
                    !currentImgUrl[0].isBlank()) {

                Image image =
                        new Image(
                                currentImgUrl[0],
                                700,
                                400,
                                false,
                                true
                        );

                if (!image.isError()) {
                    img.setImage(image);
                }
            }

        } catch (Exception ignored) {
        }

        img.setPreserveRatio(false);

        img.fitWidthProperty().bind(
                imgWrap.widthProperty()
        );

        img.setFitHeight(138);

        Rectangle clip =
                new Rectangle();

        clip.widthProperty().bind(
                imgWrap.widthProperty()
        );

        clip.setHeight(138);
        clip.setArcWidth(28);
        clip.setArcHeight(28);

        imgWrap.setClip(clip);

        // Dark overlay prevents image from overpowering text/badge.
        Rectangle overlay =
                new Rectangle();

        overlay.widthProperty().bind(
                imgWrap.widthProperty()
        );

        overlay.setHeight(138);
        overlay.setFill(
                Color.color(0, 0, 0, 0.16)
        );

        overlay.setMouseTransparent(true);

        // =====================================================
        // BADGE
        // =====================================================

        Label badge =
                new Label(
                        badgeText.toUpperCase()
                );

        String badgeBg =
                badgeColorHex.equals(PRIMARY)
                        ? "rgba(117,255,158,0.9)"
                        : badgeColorHex.equals(TERTIARY)
                        ? TERTIARY_BG
                        : ERROR_BG;

        String badgeTextCol =
                badgeColorHex.equals(PRIMARY)
                        ? "#003918"
                        : badgeColorHex.equals(TERTIARY)
                        ? "#794810"
                        : "#ffdad6";

        badge.setStyle(
                "-fx-background-color: " + badgeBg + ";" +
                "-fx-text-fill: " + badgeTextCol + ";" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 4 10;" +
                "-fx-background-radius: 50;"
        );

        StackPane.setAlignment(
                badge,
                Pos.TOP_RIGHT
        );

        StackPane.setMargin(
                badge,
                new Insets(11)
        );

        imgWrap.getChildren().addAll(
                img,
                overlay,
                badge
        );

        // =====================================================
        // BODY
        // =====================================================

        VBox body =
                new VBox(10);

        body.setPadding(
                new Insets(
                        15,
                        17,
                        14,
                        17
                )
        );

        VBox.setVgrow(
                body,
                Priority.ALWAYS
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox hText =
                new VBox(2);

        Label tLbl =
                new Label(currentTitle[0]);

        tLbl.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 19px;" +
                " -fx-font-weight: bold;"
        );

        Label sLbl =
                new Label(subTitle);

        sLbl.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 11px;"
        );

        hText.getChildren().addAll(
                tLbl,
                sLbl
        );

        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        Label iLbl =
                new Label(icon);

        iLbl.setStyle(
                "-fx-text-fill: " + badgeColorHex +
                "; -fx-font-size: 19px;"
        );

        header.getChildren().addAll(
                hText,
                sp,
                iLbl
        );

        // =====================================================
        // STATS
        // =====================================================

        VBox stats =
                new VBox(7);

        HBox row1 =
                new HBox();

        Label statLabel =
                new Label(statLbl);

        statLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 11px;"
        );

        Region sr1 =
                new Region();

        HBox.setHgrow(
                sr1,
                Priority.ALWAYS
        );

        Label statValue =
                new Label(statVal);

        statValue.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-weight: bold;" +
                " -fx-font-size: 11px;"
        );

        row1.getChildren().addAll(
                statLabel,
                sr1,
                statValue
        );

        HBox row2 =
                new HBox();

        row2.setAlignment(
                Pos.CENTER_LEFT
        );

        Label operational =
                new Label(
                        "Operational Status"
                );

        operational.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 11px;"
        );

        Region sr2 =
                new Region();

        HBox.setHgrow(
                sr2,
                Priority.ALWAYS
        );

        HBox statusBox =
                new HBox(6);

        statusBox.setAlignment(
                Pos.CENTER
        );

        Circle dot =
                new Circle(
                        3.5,
                        Color.web(statusColHex)
                );

        dot.setEffect(
                new DropShadow(
                        8,
                        Color.web(statusColHex)
                )
        );

        Label statusValue =
                new Label(statusTxt);

        statusValue.setStyle(
                "-fx-text-fill: " + statusColHex +
                "; -fx-font-weight: bold;" +
                " -fx-font-size: 11px;"
        );

        statusBox.getChildren().addAll(
                dot,
                statusValue
        );

        row2.getChildren().addAll(
                operational,
                sr2,
                statusBox
        );

        stats.getChildren().addAll(
                row1,
                row2
        );

        // =====================================================
        // ACTIONS
        // =====================================================

        HBox actions =
                new HBox(8);

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        actions.setPadding(
                new Insets(8, 0, 0, 0)
        );

        actions.setStyle(
                "-fx-border-color: rgba(255,255,255,0.05) " +
                "transparent transparent transparent;"
        );

        Button edit =
                new Button("✎ Edit");

        edit.setMaxWidth(
                Double.MAX_VALUE
        );

        HBox.setHgrow(
                edit,
                Priority.ALWAYS
        );

        String editDef =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 7 14;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;";

        String editHover =
                "-fx-background-color: rgba(117,255,158,0.12);" +
                "-fx-border-color: rgba(117,255,158,0.35);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 7 14;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;";

        edit.setStyle(editDef);

        edit.setOnMouseEntered(
                e -> edit.setStyle(editHover)
        );

        edit.setOnMouseExited(
                e -> edit.setStyle(editDef)
        );

        edit.setOnAction(
                e -> showFacilityEditor(
                        true,
                        currentTitle[0],
                        subTitle,
                        icon,
                        badgeText,
                        statLbl,
                        statVal,
                        statusTxt,
                        currentImgUrl[0],
                        updatedData -> {
                            currentTitle[0] = updatedData[0];
                            tLbl.setText(currentTitle[0]);
                            if (updatedData[1] != null) {
                                currentImgUrl[0] = updatedData[1];
                                try {
                                    Image newImg = new Image(currentImgUrl[0], 700, 400, false, true);
                                    if (!newImg.isError()) {
                                        img.setImage(newImg);
                                    }
                                } catch (Exception ignored) {}
                            }
                        }
                )
        );

        Button del =
                new Button("🗑");

        String delDef =
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-padding: 7 12;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;";

        String delHover =
                "-fx-background-color: rgba(255,180,171,0.1);" +
                "-fx-border-color: rgba(255,180,171,0.3);" +
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-font-size: 11px;" +
                "-fx-padding: 7 12;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;";

        del.setStyle(delDef);

        del.setOnMouseEntered(
                e -> del.setStyle(delHover)
        );

        del.setOnMouseExited(
                e -> del.setStyle(delDef)
        );

        del.setOnAction(
                e -> {

                    Alert confirm =
                            new Alert(
                                    Alert.AlertType.CONFIRMATION
                            );

                    confirm.setTitle(
                            "Delete Facility"
                    );

                    confirm.setHeaderText(
                            "Delete " + title + "?"
                    );

                    confirm.setContentText(
                            "This facility card will be removed from the current dashboard."
                    );

                    confirm.showAndWait()
                            .ifPresent(
                                    result -> {

                                        if (result ==
                                                javafx.scene.control.ButtonType.OK) {

                                            if (card.getParent()
                                                    instanceof GridPane) {

                                                GridPane parent =
                                                        (GridPane)
                                                                card.getParent();

                                                parent.getChildren()
                                                        .remove(card);
                                            }
                                        }
                                    }
                            );
                }
        );

        actions.getChildren().addAll(
                edit,
                del
        );

        body.getChildren().addAll(
                header,
                stats,
                actions
        );

        card.getChildren().addAll(
                imgWrap,
                body
        );

        // =====================================================
        // HOVER ANIMATION
        // =====================================================

        ScaleTransition imageScale =
                new ScaleTransition(
                        Duration.millis(280),
                        img
                );

        TranslateTransition cardMove =
                new TranslateTransition(
                        Duration.millis(280),
                        card
                );

        card.setOnMouseEntered(
                e -> {

                    card.setStyle(
                            "-fx-background-color: #020914;" +
                            "-fx-border-color: rgba(117,255,158,0.35);" +
                            "-fx-background-radius: 14;" +
                            "-fx-border-radius: 14;"
                    );

                    imageScale.setToX(1.04);
                    imageScale.setToY(1.04);
                    imageScale.play();

                    cardMove.setToY(-3);
                    cardMove.play();

                    card.setEffect(
                            new DropShadow(
                                    32,
                                    Color.color(
                                            0,
                                            0,
                                            0,
                                            0.5
                                    )
                            )
                    );
                }
        );

        card.setOnMouseExited(
                e -> {

                    card.setStyle(cDef);

                    imageScale.setToX(1);
                    imageScale.setToY(1);
                    imageScale.play();

                    cardMove.setToY(0);
                    cardMove.play();

                    card.setEffect(
                            glassShadow
                    );
                }
        );

        return card;
    }

    // =========================================================
    // ADD FACILITY CARD
    // =========================================================

    private Button createAddFacilityCard() {

        Button card =
                new Button();

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setMinHeight(315);
        card.setPrefHeight(315);
        card.setMaxHeight(315);

        String defaultStyle =
                "-fx-background-color: rgba(255,255,255,0.035);" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-style: dashed;" +
                "-fx-border-width: 2;" +
                "-fx-background-radius: 14;" +
                "-fx-border-radius: 14;" +
                "-fx-cursor: hand;";

        String hoverStyle =
                "-fx-background-color: " + PRIMARY_DIM + ";" +
                "-fx-border-color: rgba(117,255,158,0.5);" +
                "-fx-border-style: dashed;" +
                "-fx-border-width: 2;" +
                "-fx-background-radius: 14;" +
                "-fx-border-radius: 14;" +
                "-fx-cursor: hand;";

        card.setStyle(defaultStyle);

        VBox content =
                new VBox(10);

        content.setAlignment(
                Pos.CENTER
        );

        StackPane iconCircle =
                new StackPane();

        iconCircle.setMinSize(58, 58);
        iconCircle.setMaxSize(58, 58);

        iconCircle.setStyle(
                "-fx-background-color: " + SURFACE + ";" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;"
        );

        Label plus =
                new Label("＋");

        plus.setStyle(
                "-fx-text-fill: " + PRIMARY +
                "; -fx-font-size: 24px;"
        );

        iconCircle.getChildren().add(plus);

        Label title =
                new Label(
                        "Add Facility"
                );

        title.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 21px;" +
                " -fx-font-weight: bold;"
        );

        Label sub =
                new Label(
                        "Initialize a new specialized\n" +
                        "performance zone"
                );

        sub.setAlignment(
                Pos.CENTER
        );

        sub.setStyle(
                "-fx-text-fill: rgba(186,203,185,0.6);" +
                " -fx-font-size: 11px;"
        );

        content.getChildren().addAll(
                iconCircle,
                title,
                sub
        );

        card.setGraphic(content);

        card.setOnAction(
                e -> showFacilityEditor(
                        false,
                        "",
                        "",
                        "",
                        "Active",
                        "Equipment Count",
                        "",
                        "Fully Functional",
                        null,
                        null
                )
        );

        ScaleTransition scale =
                new ScaleTransition(
                        Duration.millis(220),
                        iconCircle
                );

        card.setOnMouseEntered(
                e -> {

                    card.setStyle(hoverStyle);

                    title.setStyle(
                            "-fx-text-fill: " + PRIMARY +
                            "; -fx-font-size: 21px;" +
                            " -fx-font-weight: bold;"
                    );

                    iconCircle.setStyle(
                            "-fx-background-color: rgba(117,255,158,0.2);" +
                            "-fx-border-color: rgba(117,255,158,0.4);" +
                            "-fx-border-radius: 50;" +
                            "-fx-background-radius: 50;"
                    );

                    scale.setToX(1.08);
                    scale.setToY(1.08);
                    scale.play();
                }
        );

        card.setOnMouseExited(
                e -> {

                    card.setStyle(defaultStyle);

                    title.setStyle(
                            "-fx-text-fill: " + TEXT_MUTED +
                            "; -fx-font-size: 21px;" +
                            " -fx-font-weight: bold;"
                    );

                    iconCircle.setStyle(
                            "-fx-background-color: " + SURFACE + ";" +
                            "-fx-border-color: rgba(255,255,255,0.1);" +
                            "-fx-border-radius: 50;" +
                            "-fx-background-radius: 50;"
                    );

                    scale.setToX(1);
                    scale.setToY(1);
                    scale.play();
                }
        );

        return card;
    }

    // =========================================================
    // ADD / EDIT FACILITY
    // =========================================================

    private void showFacilityEditor(
            boolean editMode,
            String existingTitle,
            String existingSubTitle,
            String existingIcon,
            String existingBadge,
            String existingStatLabel,
            String existingStatValue,
            String existingStatus,
            String existingImageUrl,
            java.util.function.Consumer<String[]> onSaveCallback) {

        VBox page =
                new VBox();

        page.setFillWidth(true);

        page.setStyle(
                "-fx-background-color: " + BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        // Mutable holder so the selected image can be
        // changed/removed while the editor is open.
        final String[] selectedImage =
                new String[] {
                        existingImageUrl
                };

        ScrollPane scroll =
                new ScrollPane();

        VBox form =
                new VBox(22);

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

        HBox editorTopRow =
                new HBox();

        editorTopRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Button back =
                new Button("← Back");

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
                e -> showFacilitiesMainPage()
        );

        Region topSpacer =
                new Region();

        HBox.setHgrow(
                topSpacer,
                Priority.ALWAYS
        );

        Label mode =
                new Label(
                        editMode
                                ? "Edit Facility"
                                : "Add New Facility"
                );

        mode.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 19px;" +
                " -fx-font-weight: bold;"
        );

        editorTopRow.getChildren().addAll(
                back,
                topSpacer,
                mode
        );

        // =====================================================
        // TITLE
        // =====================================================

        VBox titleSection =
                new VBox(5);

        Label mainTitle =
                new Label(
                        editMode
                                ? "Update Facility Details"
                                : "Create a New Facility"
                );

        mainTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN +
                "; -fx-font-size: 30px;" +
                " -fx-font-weight: bold;"
        );

        Label mainSub =
                new Label(
                        editMode
                                ? "Modify the facility information, image, and operational details."
                                : "Configure a specialized performance zone for your fitness ecosystem."
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

        VBox formCard =
                new VBox(18);

        formCard.setPadding(
                new Insets(24)
        );

        formCard.setStyle(
                "-fx-background-color: #020914;" +
                "-fx-border-color: " + SURFACE_BORDER + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-radius: 18;"
        );

        formCard.setEffect(
                glassShadow
        );

        // =====================================================
        // IMAGE MANAGEMENT
        // =====================================================

        VBox imageSection =
                new VBox(10);

        Label imageLabel =
                new Label("Facility Image");

        imageLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 12px;" +
                " -fx-font-weight: bold;"
        );

        StackPane imagePreview =
                new StackPane();

        imagePreview.setPrefHeight(180);
        imagePreview.setMinHeight(180);
        imagePreview.setMaxHeight(180);

        imagePreview.setStyle(
                "-fx-background-color: #07110b;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 14;" +
                "-fx-background-radius: 14;"
        );

        ImageView previewImage =
                new ImageView();

        previewImage.setFitWidth(800);
        previewImage.setFitHeight(180);
        previewImage.setPreserveRatio(false);

        Rectangle previewClip =
                new Rectangle();

        previewClip.setWidth(800);
        previewClip.setHeight(180);
        previewClip.setArcWidth(28);
        previewClip.setArcHeight(28);

        previewImage.setClip(previewClip);

        Label noImage =
                new Label(
                        "＋\nAdd Facility Image"
                );

        noImage.setAlignment(
                Pos.CENTER
        );

        noImage.setStyle(
                "-fx-text-fill: rgba(186,203,185,0.55);" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-alignment: center;"
        );

        imagePreview.getChildren().add(
                noImage
        );

        // Load existing image into editor.
        if (existingImageUrl != null &&
                !existingImageUrl.isBlank()) {

            try {

                Image existing =
                        new Image(
                                existingImageUrl,
                                900,
                                500,
                                false,
                                true
                        );

                if (!existing.isError()) {

                    previewImage.setImage(
                            existing
                    );

                    imagePreview.getChildren()
                            .clear();

                    imagePreview.getChildren()
                            .add(previewImage);
                }

            } catch (Exception ignored) {
            }
        }

        HBox imageButtons =
                new HBox(10);

        imageButtons.setAlignment(
                Pos.CENTER_LEFT
        );

        Button addImage =
                new Button(
                        existingImageUrl == null
                                ? "＋ Add Image"
                                : "↻ Change Image"
                );

        Button removeImage =
                new Button(
                        "🗑 Remove Image"
                );

        String imageButtonStyle =
                "-fx-background-color: rgba(117,255,158,0.1);" +
                "-fx-border-color: rgba(117,255,158,0.25);" +
                "-fx-text-fill: " + PRIMARY + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 16;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;";

        String removeButtonStyle =
                "-fx-background-color: rgba(255,180,171,0.08);" +
                "-fx-border-color: rgba(255,180,171,0.2);" +
                "-fx-text-fill: " + ERROR + ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 16;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-cursor: hand;";

        addImage.setStyle(
                imageButtonStyle
        );

        removeImage.setStyle(
                removeButtonStyle
        );

        addImage.setOnAction(
                e -> {

                    FileChooser chooser =
                            new FileChooser();

                    chooser.setTitle(
                            "Select Facility Image"
                    );

                    chooser.getExtensionFilters()
                            .add(
                                    new FileChooser.ExtensionFilter(
                                            "Image Files",
                                            "*.png",
                                            "*.jpg",
                                            "*.jpeg",
                                            "*.webp"
                                    )
                            );

                    File file =
                            chooser.showOpenDialog(
                                    FacilitiesScene.getWindow()
                            );

                    if (file == null) {
                        return;
                    }

                    try {

                        String imagePath =
                                file.toURI().toString();

                        Image selected =
                                new Image(
                                        imagePath,
                                        1200,
                                        700,
                                        false,
                                        true
                                );

                        if (selected.isError()) {
                            throw new IllegalArgumentException(
                                    "Image could not be loaded."
                            );
                        }

                        selectedImage[0] =
                                imagePath;

                        previewImage.setImage(
                                selected
                        );

                        imagePreview.getChildren()
                                .clear();

                        imagePreview.getChildren()
                                .add(previewImage);

                        addImage.setText(
                                "↻ Change Image"
                        );

                    } catch (Exception ex) {

                        Alert alert =
                                new Alert(
                                        Alert.AlertType.ERROR
                                );

                        alert.setTitle(
                                "Image Error"
                        );

                        alert.setHeaderText(
                                null
                        );

                        alert.setContentText(
                                "Unable to load the selected image."
                        );

                        alert.showAndWait();
                    }
                }
        );

        removeImage.setOnAction(
                e -> {

                    selectedImage[0] = null;

                    previewImage.setImage(null);

                    imagePreview.getChildren()
                            .clear();

                    imagePreview.getChildren()
                            .add(noImage);

                    addImage.setText(
                            "＋ Add Image"
                    );
                }
        );

        imageButtons.getChildren().addAll(
                addImage,
                removeImage
        );

        imageSection.getChildren().addAll(
                imageLabel,
                imagePreview,
                imageButtons
        );

        // =====================================================
        // TEXT FIELDS
        // =====================================================

        TextField facilityName =
                createEditorField(
                        "Facility Name",
                        existingTitle
                );

        TextField location =
                createEditorField(
                        "Location / Zone",
                        existingSubTitle
                );

        TextField icon =
                createEditorField(
                        "Facility Icon",
                        existingIcon
                );

        TextField statLabel =
                createEditorField(
                        "Main Statistic",
                        existingStatLabel
                );

        TextField statValue =
                createEditorField(
                        "Statistic Value",
                        existingStatValue
                );

        // =====================================================
        // STATUS
        // =====================================================

        ComboBox<String> status =
                new ComboBox<>();

        status.getItems().addAll(
                "Active",
                "Scheduled",
                "Maintenance",
                "Offline"
        );

        String initialStatus =
                existingStatus == null ||
                existingStatus.isBlank()
                        ? "Active"
                        : existingStatus;

        if (!status.getItems().contains(
                initialStatus)) {

            initialStatus = "Active";
        }

        status.setValue(
                initialStatus
        );

        status.setMaxWidth(
                Double.MAX_VALUE
        );

        status.setStyle(
                "-fx-background-color: #151e16;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 5;"
        );

        Label statusLabel =
                new Label(
                        "Operational Status"
                );

        statusLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED +
                "; -fx-font-size: 12px;" +
                " -fx-font-weight: bold;"
        );

        VBox statusBox =
                new VBox(8);

        statusBox.getChildren().addAll(
                statusLabel,
                status
        );

        formCard.getChildren().addAll(
                imageSection,
                facilityName,
                location,
                icon,
                statLabel,
                statValue,
                statusBox
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        HBox buttons =
                new HBox(12);

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button cancel =
                new Button("Cancel");

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
                e -> showFacilitiesMainPage()
        );

        Button save =
                new Button(
                        editMode
                                ? "✓ Update Facility"
                                : "✓ Create Facility"
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

                    if (facilityName.getText()
                            .trim()
                            .isEmpty()) {

                        Alert alert =
                                new Alert(
                                        Alert.AlertType.WARNING
                                );

                        alert.setTitle(
                                "Facility Name Required"
                        );

                        alert.setHeaderText(
                                null
                        );

                        alert.setContentText(
                                "Please enter a facility name."
                        );

                        alert.showAndWait();

                        return;
                    }

                    // selectedImage[0] contains:
                    // - the original URL when editing
                    // - the selected local file URL after Change Image
                    // - null after Remove Image
                    String finalImage =
                            selectedImage[0];

                    if (onSaveCallback != null) {
                        onSaveCallback.accept(new String[]{
                                facilityName.getText(),
                                finalImage
                        });
                    }

                    // Keep variable ready for your future
                    // database/model integration.
                    @SuppressWarnings("unused")
                    String imageToSave = finalImage;

                    Alert alert =
                            new Alert(
                                    Alert.AlertType.INFORMATION
                            );

                    alert.setTitle(
                            editMode
                                    ? "Facility Updated"
                                    : "Facility Created"
                    );

                    alert.setHeaderText(
                            null
                    );

                    alert.setContentText(
                            editMode
                                    ? "Facility details and image updated successfully."
                                    : "New facility created successfully."
                    );

                    alert.showAndWait();

                    showFacilitiesMainPage();
                }
        );

        buttons.getChildren().addAll(
                cancel,
                save
        );

        // =====================================================
        // FORM
        // =====================================================

        form.getChildren().addAll(
                editorTopRow,
                titleSection,
                formCard,
                buttons
        );

        StackPane formHolder =
                new StackPane(form);

        formHolder.setAlignment(
                Pos.TOP_CENTER
        );

        scroll.setContent(
                formHolder
        );

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

        VBox.setVgrow(
                scroll,
                Priority.ALWAYS
        );

        page.getChildren().add(
                scroll
        );

        // =====================================================
        // PAGE ENTRY ANIMATION
        // =====================================================

        page.setOpacity(0);
        page.setTranslateY(28);

        rootContainer.getChildren().setAll(
                page
        );

        FadeTransition fade =
                new FadeTransition(
                        Duration.millis(320),
                        page
                );

        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition slide =
                new TranslateTransition(
                        Duration.millis(360),
                        page
                );

        slide.setFromY(28);
        slide.setToY(0);

        fade.play();
        slide.play();
    }

    // =========================================================
    // EDITOR TEXT FIELD
    // =========================================================

    private TextField createEditorField(
            String labelText,
            String value) {

        TextField field =
                new TextField();

        field.setText(
                value == null
                        ? ""
                        : value
        );

        field.setPromptText(
                labelText
        );

        field.setPrefHeight(44);

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        String normalStyle =
                "-fx-background-color: #151e16;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 14;";

        String focusStyle =
                "-fx-background-color: #151e16;" +
                "-fx-border-color: rgba(117,255,158,0.5);" +
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-prompt-text-fill: " + TEXT_MUTED + ";" +
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10 14;";

        field.setStyle(
                normalStyle
        );

        field.focusedProperty().addListener(
                (obs, oldValue, focused) -> {

                    field.setStyle(
                            focused
                                    ? focusStyle
                                    : normalStyle
                    );
                }
        );

        return field;
    }

    // =========================================================
    // BACK TO MAIN PAGE
    // =========================================================

    private void showFacilitiesMainPage() {

        if (rootContainer == null ||
                facilitiesMainArea == null) {

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
                                    facilitiesMainArea
                            );

                    facilitiesMainArea.setOpacity(0);
                    facilitiesMainArea.setTranslateY(18);

                    FadeTransition fadeIn =
                            new FadeTransition(
                                    Duration.millis(280),
                                    facilitiesMainArea
                            );

                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);

                    TranslateTransition slideIn =
                            new TranslateTransition(
                                    Duration.millis(320),
                                    facilitiesMainArea
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
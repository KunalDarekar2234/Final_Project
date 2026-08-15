package com.visionx.view.gym_owner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import javafx.scene.effect.DropShadow;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MembershipRequests {

    private Scene MembershipRequestsScene;

    // =========================================================
    // COLOR PALETTE
    // =========================================================

    private final String BG_COLOR = "#0d150e";

    private final String SURFACE =
            "rgba(13, 21, 14, 0.6)";

    private final String SURFACE_BORDER =
            "rgba(255, 255, 255, 0.1)";

    private final String CARD_BG =
            "#020914";

    private final String PRIMARY =
            "#75ff9e";

    private final String PRIMARY_DIM =
            "rgba(117, 255, 158, 0.1)";

    private final String TEXT_MAIN =
            "#dbe5d9";

    private final String TEXT_MUTED =
            "#bacbb9";

    private final String ERROR =
            "#ffb4ab";


    // =========================================================
    // SHARED EFFECT
    // =========================================================

    private final DropShadow glassShadow =
            new DropShadow(
                    30,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.5)
            );


    // =========================================================
    // NAVIGATION STATE
    // =========================================================

    private int currentPage = 1;

    private String currentStatus = "Pending";


    // =========================================================
    // TABLE REFERENCES
    // =========================================================

    private VBox requestRows;

    private Label requestTableTitle;

    private Button pendingButton;

    private Button approvedButton;

    private Button rejectedButton;

    private Button previousPageButton;

    private Button page1Button;

    private Button page2Button;

    private Button page3Button;

    private Button nextPageButton;


    // =========================================================
    // MAIN SCENE
    // HEADER REMOVED COMPLETELY
    // =========================================================

    public Scene getMembershipRequestsScene(
            Runnable callBackAction
    ) {

        VBox mainArea = new VBox();

        mainArea.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );


        // =====================================================
        // ONLY MAIN CONTENT
        // NO HEADER
        // =====================================================

        ScrollPane content =
                createMainContent();

        VBox.setVgrow(
                content,
                Priority.ALWAYS
        );


        mainArea.getChildren().add(
                content
        );


        Scene scene =
                new Scene(
                        mainArea,
                        1160,
                        900
                );


        MembershipRequestsScene =
                scene;


        return MembershipRequestsScene;
    }


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private ScrollPane createMainContent() {

        VBox content =
                new VBox(40);


        content.setPadding(
                new Insets(
                        40,
                        32,
                        40,
                        32
                )
        );


        content.setMaxWidth(1200);


        content.setAlignment(
                Pos.TOP_CENTER
        );


        content.setStyle(
                "-fx-background-color: transparent;"
        );


        // =====================================================
        // TOP ROW
        // =====================================================

        HBox topRow =
                new HBox();


        topRow.setAlignment(
                Pos.BOTTOM_LEFT
        );


        VBox titleBox =
                new VBox(4);


        Label title =
                new Label(
                        "Membership Requests"
                );


        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: 800;"
        );


        Label sub =
                new Label(
                        "Review and manage pending signups for the Elite Performance tier."
                );


        sub.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 16px;"
        );


        titleBox.getChildren().addAll(
                title,
                sub
        );


        Region spacer =
                new Region();


        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        // =====================================================
        // FILTERS
        // =====================================================

        HBox filters =
                new HBox(8);


        filters.setPadding(
                new Insets(4)
        );


        filters.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 12;"
        );


        pendingButton =
                new Button("Pending (24)");


        approvedButton =
                new Button("Approved");


        rejectedButton =
                new Button("Rejected");


        pendingButton.setOnAction(
                e -> changeStatus("Pending")
        );


        approvedButton.setOnAction(
                e -> changeStatus("Approved")
        );


        rejectedButton.setOnAction(
                e -> changeStatus("Rejected")
        );


        filters.getChildren().addAll(
                pendingButton,
                approvedButton,
                rejectedButton
        );


        updateFilterButtons();


        topRow.getChildren().addAll(
                titleBox,
                spacer,
                filters
        );


        // =====================================================
        // STATS
        // =====================================================

        HBox statsRow =
                new HBox(24);


        VBox s1 =
                createStatCard(
                        "New Today",
                        "12",
                        "+15% from yesterday",
                        "👤+",
                        PRIMARY
                );


        VBox s2 =
                createStatCard(
                        "Avg. Approval Time",
                        "4.2h",
                        "Based on last 100 requests",
                        "⏱",
                        TEXT_MAIN
                );


        VBox s3 =
                createStatCard(
                        "Conversion Rate",
                        "89%",
                        "High interest period",
                        "✅",
                        "#00e676"
                );


        HBox.setHgrow(
                s1,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                s2,
                Priority.ALWAYS
        );


        HBox.setHgrow(
                s3,
                Priority.ALWAYS
        );


        statsRow.getChildren().addAll(
                s1,
                s2,
                s3
        );


        // =====================================================
        // TABLE
        // =====================================================

        VBox table =
                createRequestsTable();


        // =====================================================
        // ACTIVITY PANEL
        // =====================================================

        HBox bottomRow =
                new HBox(32);


        VBox activityPanel =
                createActivityPanel();


        HBox.setHgrow(
                activityPanel,
                Priority.ALWAYS
        );


        bottomRow.getChildren().add(
                activityPanel
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        content.getChildren().addAll(
                topRow,
                statsRow,
                table,
                bottomRow
        );


        // =====================================================
        // SCROLL
        // =====================================================

        StackPane centeredContent =
                new StackPane(content);


        ScrollPane scroll =
                new ScrollPane(
                        centeredContent
                );


        scroll.setFitToWidth(true);


        scroll.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );


        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );


        return scroll;
    }


    // =========================================================
    // FILTER NAVIGATION
    // =========================================================

    private void changeStatus(
            String status
    ) {

        currentStatus =
                status;


        currentPage =
                1;


        updateFilterButtons();


        updateRequestsTable();
    }


    // =========================================================
    // FILTER BUTTON STYLE
    // =========================================================

    private void updateFilterButtons() {

        String activeStyle =
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 20;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";


        String inactiveStyle =
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 20;" +
                "-fx-cursor: hand;";


        pendingButton.setStyle(
                currentStatus.equals("Pending")
                        ? activeStyle
                        : inactiveStyle
        );


        approvedButton.setStyle(
                currentStatus.equals("Approved")
                        ? activeStyle
                        : inactiveStyle
        );


        rejectedButton.setStyle(
                currentStatus.equals("Rejected")
                        ? activeStyle
                        : inactiveStyle
        );


        if (currentStatus.equals("Pending")) {

            pendingButton.setEffect(
                    new DropShadow(
                            10,
                            Color.web(
                                    PRIMARY,
                                    0.3
                            )
                    )
            );


            approvedButton.setEffect(null);

            rejectedButton.setEffect(null);

        }

        else if (currentStatus.equals("Approved")) {

            approvedButton.setEffect(
                    new DropShadow(
                            10,
                            Color.web(
                                    PRIMARY,
                                    0.3
                            )
                    )
            );


            pendingButton.setEffect(null);

            rejectedButton.setEffect(null);

        }

        else {

            rejectedButton.setEffect(
                    new DropShadow(
                            10,
                            Color.web(
                                    PRIMARY,
                                    0.3
                            )
                    )
            );


            pendingButton.setEffect(null);

            approvedButton.setEffect(null);
        }
    }


    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String val,
            String sub,
            String icon,
            String primaryColor
    ) {

        VBox card =
                new VBox(8);


        card.setPadding(
                new Insets(24)
        );


        String cardDefault =
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 24;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 24;";


        String cardHover =
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 24;" +
                "-fx-border-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-border-radius: 24;";


        card.setStyle(
                cardDefault
        );


        card.setEffect(
                glassShadow
        );


        Label tLbl =
                new Label(
                        title.toUpperCase()
                );


        tLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        Label vLbl =
                new Label(val);


        vLbl.setStyle(
                "-fx-text-fill: " +
                primaryColor +
                ";" +
                "-fx-font-size: 36px;" +
                "-fx-font-weight: bold;"
        );


        Label sLbl =
                new Label(sub);


        sLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );


        card.getChildren().addAll(
                tLbl,
                vLbl,
                sLbl
        );


        card.setOnMouseEntered(
                e -> {

                    card.setStyle(
                            cardHover
                    );


                    card.setTranslateY(-2);


                    card.setEffect(
                            new DropShadow(
                                    25,
                                    Color.web(
                                            PRIMARY,
                                            0.12
                                    )
                            )
                    );
                }
        );


        card.setOnMouseExited(
                e -> {

                    card.setStyle(
                            cardDefault
                    );


                    card.setTranslateY(0);


                    card.setEffect(
                            glassShadow
                    );
                }
        );


        return card;
    }


    // =========================================================
    // REQUESTS TABLE
    // =========================================================

    private VBox createRequestsTable() {

        VBox card =
                new VBox();


        setGlassStyle(card);


        card.setPadding(
                new Insets(0)
        );


        // =====================================================
        // TABLE HEADER
        // =====================================================

        HBox head =
                new HBox();


        head.setPadding(
                new Insets(
                        24,
                        32,
                        24,
                        32
                )
        );


        head.setStyle(
                "-fx-border-color: transparent transparent " +
                SURFACE_BORDER +
                " transparent;"
        );


        head.setAlignment(
                Pos.CENTER_LEFT
        );


        requestTableTitle =
                new Label(
                        "Pending Signups"
                );


        requestTableTitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        Region sp =
                new Region();


        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );


        Label filter =
                new Label(
                        "≡ Filter"
                );


        filter.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-cursor: hand;" +
                "-fx-padding: 0 16 0 0;"
        );


        Label export =
                new Label(
                        "📥 Export"
                );


        export.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-cursor: hand;"
        );


        head.getChildren().addAll(
                requestTableTitle,
                sp,
                filter,
                export
        );


        // =====================================================
        // TABLE HEADERS
        // =====================================================

        HBox th =
                new HBox();


        th.setPadding(
                new Insets(
                        16,
                        32,
                        16,
                        32
                )
        );


        th.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-border-color: transparent transparent " +
                "rgba(255,255,255,0.05) transparent;"
        );


        String thStyle =
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-letter-spacing: 1px;";


        Label h1 =
                new Label(
                        "USER NAME"
                );


        h1.setPrefWidth(250);

        h1.setStyle(thStyle);


        Label h2 =
                new Label(
                        "MEMBERSHIP PLAN"
                );


        h2.setPrefWidth(200);

        h2.setStyle(thStyle);


        Label h3 =
                new Label(
                        "DATE REQUESTED"
                );


        h3.setPrefWidth(150);

        h3.setStyle(thStyle);


        Label h4 =
                new Label(
                        "STATUS"
                );


        h4.setPrefWidth(150);

        h4.setStyle(thStyle);


        Label h5 =
                new Label(
                        "ACTIONS"
                );


        h5.setMaxWidth(
                Double.MAX_VALUE
        );


        HBox.setHgrow(
                h5,
                Priority.ALWAYS
        );


        h5.setAlignment(
                Pos.CENTER_RIGHT
        );


        h5.setStyle(thStyle);


        th.getChildren().addAll(
                h1,
                h2,
                h3,
                h4,
                h5
        );


        // =====================================================
        // ROWS
        // =====================================================

        requestRows =
                new VBox();


        populateRows();


        // =====================================================
        // FOOTER
        // =====================================================

        HBox footer =
                new HBox();


        footer.setPadding(
                new Insets(
                        24,
                        32,
                        24,
                        32
                )
        );


        footer.setAlignment(
                Pos.CENTER_LEFT
        );


        footer.setStyle(
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-border-color: rgba(255,255,255,0.05) " +
                "transparent transparent transparent;" +
                "-fx-background-radius: 0 0 24 24;"
        );


        Label fLbl =
                new Label(
                        "Showing 1-4 of 24 requests"
                );


        fLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );


        Region sp2 =
                new Region();


        HBox.setHgrow(
                sp2,
                Priority.ALWAYS
        );


        HBox pag =
                new HBox(8);


        // =====================================================
        // PAGINATION
        // =====================================================

        previousPageButton =
                createPageBtn(
                        "‹",
                        false,
                        false
                );


        page1Button =
                createPageBtn(
                        "1",
                        true,
                        true
                );


        page2Button =
                createPageBtn(
                        "2",
                        false,
                        true
                );


        page3Button =
                createPageBtn(
                        "3",
                        false,
                        true
                );


        nextPageButton =
                createPageBtn(
                        "›",
                        false,
                        true
                );


        // =====================================================
        // PAGINATION ACTIONS
        // =====================================================

        previousPageButton.setOnAction(
                e -> {

                    if (currentPage > 1) {

                        currentPage--;

                        updateRequestsTable();
                    }
                }
        );


        page1Button.setOnAction(
                e -> {

                    currentPage = 1;

                    updateRequestsTable();
                }
        );


        page2Button.setOnAction(
                e -> {

                    currentPage = 2;

                    updateRequestsTable();
                }
        );


        page3Button.setOnAction(
                e -> {

                    currentPage = 3;

                    updateRequestsTable();
                }
        );


        nextPageButton.setOnAction(
                e -> {

                    if (currentPage < 3) {

                        currentPage++;

                        updateRequestsTable();
                    }
                }
        );


        pag.getChildren().addAll(
                previousPageButton,
                page1Button,
                page2Button,
                page3Button,
                nextPageButton
        );


        footer.getChildren().addAll(
                fLbl,
                sp2,
                pag
        );


        card.getChildren().addAll(
                head,
                th,
                requestRows,
                footer
        );


        updatePaginationButtons();


        return card;
    }


    // =========================================================
    // UPDATE TABLE
    // =========================================================

    private void updateRequestsTable() {

        if (requestRows == null) {
            return;
        }


        requestTableTitle.setText(
                currentStatus +
                " Signups"
        );


        requestRows.getChildren().clear();


        populateRows();


        updatePaginationButtons();
    }


    // =========================================================
    // POPULATE ROWS
    // =========================================================

    private void populateRows() {

        if (requestRows == null) {
            return;
        }


        requestRows.getChildren().clear();


        if (currentStatus.equals("Pending")) {

            populatePendingRows();

        }

        else if (currentStatus.equals("Approved")) {

            populateApprovedRows();

        }

        else {

            populateRejectedRows();
        }
    }


    // =========================================================
    // PENDING ROWS
    // =========================================================

    private void populatePendingRows() {

        String[][] data;


        if (currentPage == 1) {

            data = new String[][]{

                    {
                            "Julian Sterling",
                            "julian.s@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 24, 2023",
                            "10:45 AM"
                    },

                    {
                            "Maya Thorne",
                            "m.thorne@cloud.io",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 23, 2023",
                            "02:15 PM"
                    },

                    {
                            "Arthur Vance",
                            "vance.corp@global.net",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 23, 2023",
                            "09:12 AM"
                    },

                    {
                            "Sasha Reed",
                            "sasha.reed@design.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 22, 2023",
                            "11:58 PM"
                    }
            };

        }

        else if (currentPage == 2) {

            data = new String[][]{

                    {
                            "Daniel Brooks",
                            "daniel.b@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 21, 2023",
                            "04:30 PM"
                    },

                    {
                            "Sophia Miller",
                            "sophia.m@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 21, 2023",
                            "01:20 PM"
                    },

                    {
                            "Ryan Cooper",
                            "ryan.c@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 20, 2023",
                            "11:10 AM"
                    },

                    {
                            "Emma Wilson",
                            "emma.w@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 19, 2023",
                            "09:45 AM"
                    }
            };

        }

        else {

            data = new String[][]{

                    {
                            "Noah Carter",
                            "noah.c@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 18, 2023",
                            "05:40 PM"
                    },

                    {
                            "Olivia Smith",
                            "olivia.s@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 18, 2023",
                            "03:15 PM"
                    },

                    {
                            "Liam Taylor",
                            "liam.t@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 17, 2023",
                            "12:25 PM"
                    },

                    {
                            "Ava Johnson",
                            "ava.j@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 16, 2023",
                            "10:05 AM"
                    }
            };
        }


        addRows(data);
    }


    // =========================================================
    // APPROVED ROWS
    // =========================================================

    private void populateApprovedRows() {

        String[][] data;


        if (currentPage == 1) {

            data = new String[][]{

                    {
                            "Marcus Chen",
                            "marcus.c@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 24, 2023",
                            "09:20 AM"
                    },

                    {
                            "Elena Rossi",
                            "elena.r@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 23, 2023",
                            "04:10 PM"
                    },

                    {
                            "Leo Grant",
                            "leo.g@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 22, 2023",
                            "01:45 PM"
                    },

                    {
                            "Isla Morgan",
                            "isla.m@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 21, 2023",
                            "10:30 AM"
                    }
            };

        }

        else if (currentPage == 2) {

            data = new String[][]{

                    {
                            "James Anderson",
                            "james.a@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 20, 2023",
                            "03:30 PM"
                    },

                    {
                            "Grace Hall",
                            "grace.h@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 19, 2023",
                            "12:10 PM"
                    },

                    {
                            "Henry Clark",
                            "henry.c@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 18, 2023",
                            "09:50 AM"
                    },

                    {
                            "Chloe Davis",
                            "chloe.d@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 17, 2023",
                            "05:25 PM"
                    }
            };

        }

        else {

            data = new String[][]{

                    {
                            "Benjamin Scott",
                            "ben.s@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 16, 2023",
                            "03:40 PM"
                    },

                    {
                            "Amelia King",
                            "amelia.k@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 15, 2023",
                            "01:15 PM"
                    },

                    {
                            "Lucas Wright",
                            "lucas.w@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 14, 2023",
                            "11:35 AM"
                    },

                    {
                            "Mia Turner",
                            "mia.t@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 13, 2023",
                            "09:05 AM"
                    }
            };
        }


        addRows(data);
    }


    // =========================================================
    // REJECTED ROWS
    // =========================================================

    private void populateRejectedRows() {

        String[][] data;


        if (currentPage == 1) {

            data = new String[][]{

                    {
                            "Robert Evans",
                            "robert.e@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 24, 2023",
                            "08:20 AM"
                    },

                    {
                            "Nora Adams",
                            "nora.a@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 23, 2023",
                            "06:15 PM"
                    },

                    {
                            "William Moore",
                            "william.m@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 22, 2023",
                            "03:05 PM"
                    },

                    {
                            "Ella White",
                            "ella.w@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 21, 2023",
                            "11:45 AM"
                    }
            };

        }

        else if (currentPage == 2) {

            data = new String[][]{

                    {
                            "Michael Harris",
                            "michael.h@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 20, 2023",
                            "04:25 PM"
                    },

                    {
                            "Lily Martin",
                            "lily.m@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 19, 2023",
                            "02:10 PM"
                    },

                    {
                            "Alexander Lee",
                            "alex.l@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 18, 2023",
                            "10:40 AM"
                    },

                    {
                            "Harper Lewis",
                            "harper.l@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 17, 2023",
                            "08:55 AM"
                    }
            };

        }

        else {

            data = new String[][]{

                    {
                            "Ethan Walker",
                            "ethan.w@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 16, 2023",
                            "05:20 PM"
                    },

                    {
                            "Sophie Young",
                            "sophie.y@example.com",
                            "⚡",
                            "Power Pro",
                            "rgba(64, 71, 88, 0.2)",
                            "#c0c6db",
                            "Oct 15, 2023",
                            "03:45 PM"
                    },

                    {
                            "Daniel King",
                            "daniel.k@example.com",
                            "⭐",
                            "Elite Performance",
                            PRIMARY_DIM,
                            PRIMARY,
                            "Oct 14, 2023",
                            "01:30 PM"
                    },

                    {
                            "Scarlett Green",
                            "scarlett.g@example.com",
                            "🍃",
                            "Zen Wellness",
                            "rgba(255, 186, 121, 0.1)",
                            "#ffba79",
                            "Oct 13, 2023",
                            "10:15 AM"
                    }
            };
        }


        addRows(data);
    }


    // =========================================================
    // ADD ROWS
    // =========================================================

    private void addRows(
            String[][] data
    ) {

        for (String[] row : data) {

            requestRows.getChildren().add(

                    createTableRow(
                            "",
                            row[0],
                            row[1],
                            row[2],
                            row[3],
                            row[4],
                            row[5],
                            row[6],
                            row[7]
                    )
            );
        }
    }


    // =========================================================
    // UPDATE PAGINATION
    // =========================================================

    private void updatePaginationButtons() {

        if (page1Button == null) {
            return;
        }


        String activeStyle =
                "-fx-background-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-border-color: " +
                PRIMARY_DIM +
                ";" +
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-weight: bold;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";


        String normalStyle =
                "-fx-background-color: transparent;" +
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";


        page1Button.setStyle(
                currentPage == 1
                        ? activeStyle
                        : normalStyle
        );


        page2Button.setStyle(
                currentPage == 2
                        ? activeStyle
                        : normalStyle
        );


        page3Button.setStyle(
                currentPage == 3
                        ? activeStyle
                        : normalStyle
        );


        // =====================================================
        // PREVIOUS
        // =====================================================

        if (currentPage == 1) {

            previousPageButton.setDisable(
                    true
            );


            previousPageButton.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-border-color: rgba(255,255,255,0.1);" +
                    "-fx-text-fill: " +
                    TEXT_MUTED +
                    ";" +
                    "-fx-opacity: 0.3;" +
                    "-fx-border-radius: 8;"
            );

        }

        else {

            previousPageButton.setDisable(
                    false
            );


            previousPageButton.setStyle(
                    normalStyle
            );
        }


        // =====================================================
        // NEXT
        // =====================================================

        if (currentPage == 3) {

            nextPageButton.setDisable(
                    true
            );


            nextPageButton.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-border-color: rgba(255,255,255,0.1);" +
                    "-fx-text-fill: " +
                    TEXT_MUTED +
                    ";" +
                    "-fx-opacity: 0.3;" +
                    "-fx-border-radius: 8;"
            );

        }

        else {

            nextPageButton.setDisable(
                    false
            );


            nextPageButton.setStyle(
                    normalStyle
            );
        }
    }


    // =========================================================
    // PAGE BUTTON
    // =========================================================

    private Button createPageBtn(
            String text,
            boolean active,
            boolean enabled
    ) {

        Button b =
                new Button(text);


        if (!enabled) {

            b.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-border-color: rgba(255,255,255,0.1);" +
                    "-fx-text-fill: " +
                    TEXT_MUTED +
                    ";" +
                    "-fx-opacity: 0.3;" +
                    "-fx-border-radius: 8;"
            );


            return b;
        }


        if (active) {

            b.setStyle(
                    "-fx-background-color: " +
                    PRIMARY_DIM +
                    ";" +
                    "-fx-border-color: " +
                    PRIMARY_DIM +
                    ";" +
                    "-fx-text-fill: " +
                    PRIMARY +
                    ";" +
                    "-fx-font-weight: bold;" +
                    "-fx-border-radius: 8;" +
                    "-fx-background-radius: 8;"
            );

        }

        else {

            String def =
                    "-fx-background-color: transparent;" +
                    "-fx-border-color: rgba(255,255,255,0.1);" +
                    "-fx-text-fill: " +
                    TEXT_MAIN +
                    ";" +
                    "-fx-border-radius: 8;";


            String hov =
                    "-fx-background-color: rgba(255,255,255,0.05);" +
                    "-fx-border-color: rgba(255,255,255,0.1);" +
                    "-fx-text-fill: " +
                    TEXT_MAIN +
                    ";" +
                    "-fx-border-radius: 8;" +
                    "-fx-cursor: hand;";


            b.setStyle(def);


            b.setOnMouseEntered(
                    e -> {

                        if (!b.isDisabled()) {

                            b.setStyle(hov);
                        }
                    }
            );


            b.setOnMouseExited(
                    e -> {

                        if (!b.isDisabled()) {

                            b.setStyle(def);
                        }
                    }
            );
        }


        return b;
    }


    // =========================================================
    // TABLE ROW
    // =========================================================

    private HBox createTableRow(
            String imgUrl,
            String name,
            String email,
            String planIcon,
            String planTxt,
            String planBg,
            String planCol,
            String date,
            String time
    ) {

        HBox row =
                new HBox();


        row.setAlignment(
                Pos.CENTER_LEFT
        );


        row.setPadding(
                new Insets(
                        16,
                        32,
                        16,
                        32
                )
        );


        String rowDefault =
                "-fx-border-color: transparent transparent " +
                "rgba(255,255,255,0.05) transparent;" +
                "-fx-background-color: transparent;";


        String rowHover =
                "-fx-border-color: transparent transparent " +
                "rgba(255,255,255,0.05) transparent;" +
                "-fx-background-color: rgba(255,255,255,0.03);" +
                "-fx-effect: innershadow(gaussian, " +
                "rgba(117,255,158,0.05), 20, 0, 0, 0;";


        row.setStyle(
                rowDefault
        );


        // =====================================================
        // USER
        // =====================================================

        HBox userBox =
                new HBox(16);


        userBox.setPrefWidth(
                250
        );


        userBox.setAlignment(
                Pos.CENTER_LEFT
        );


        StackPane wrap;


        if (imgUrl != null &&
                !imgUrl.isEmpty()) {

            ImageView avatar =
                    new ImageView(
                            new Image(
                                    imgUrl,
                                    40,
                                    40,
                                    true,
                                    true
                            )
                    );


            Circle clip =
                    new Circle(
                            20,
                            20,
                            20
                    );


            avatar.setClip(
                    clip
            );


            wrap =
                    new StackPane(
                            avatar
                    );

        }

        else {

            Circle avatarCircle =
                    new Circle(
                            20,
                            Color.web(
                                    PRIMARY_DIM
                            )
                    );


            Label initial =
                    new Label(
                            name
                                    .substring(0, 1)
                                    .toUpperCase()
                    );


            initial.setStyle(
                    "-fx-text-fill: " +
                    PRIMARY +
                    ";" +
                    "-fx-font-weight: bold;" +
                    "-fx-font-size: 14px;"
            );


            wrap =
                    new StackPane(
                            avatarCircle,
                            initial
                    );
        }


        wrap.setStyle(
                "-fx-border-color: rgba(255,255,255,0.1);" +
                "-fx-border-radius: 50;"
        );


        VBox utxt =
                new VBox(2);


        Label nLbl =
                new Label(name);


        nLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );


        Label eLbl =
                new Label(email);


        eLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );


        utxt.getChildren().addAll(
                nLbl,
                eLbl
        );


        userBox.getChildren().addAll(
                wrap,
                utxt
        );


        // =====================================================
        // PLAN
        // =====================================================

        HBox planBox =
                new HBox();


        planBox.setPrefWidth(
                200
        );


        planBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Label pLbl =
                new Label(
                        planIcon +
                        " " +
                        planTxt
                );


        pLbl.setStyle(
                "-fx-background-color: " +
                planBg +
                ";" +
                "-fx-border-color: " +
                planCol +
                "40;" +
                "-fx-text-fill: " +
                planCol +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 4 12;" +
                "-fx-background-radius: 50;" +
                "-fx-border-radius: 50;"
        );


        planBox.getChildren().add(
                pLbl
        );


        // =====================================================
        // DATE
        // =====================================================

        VBox dBox =
                new VBox(2);


        dBox.setPrefWidth(
                150
        );


        dBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Label dLbl =
                new Label(date);


        dLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 14px;"
        );


        Label tLbl =
                new Label(time);


        tLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 10px;"
        );


        dBox.getChildren().addAll(
                dLbl,
                tLbl
        );


        // =====================================================
        // STATUS
        // =====================================================

        HBox sBox =
                new HBox(8);


        sBox.setPrefWidth(
                150
        );


        sBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Color statusColor;

        String statusText;


        if (currentStatus.equals("Approved")) {

            statusColor =
                    Color.web(PRIMARY);

            statusText =
                    "Approved";

        }

        else if (currentStatus.equals("Rejected")) {

            statusColor =
                    Color.web(ERROR);

            statusText =
                    "Rejected";

        }

        else {

            statusColor =
                    Color.web("#facc15");

            statusText =
                    "Pending Review";
        }


        Circle dot =
                new Circle(
                        4,
                        statusColor
                );


        Label sLbl =
                new Label(
                        statusText
                );


        sLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        sBox.getChildren().addAll(
                dot,
                sLbl
        );


        // =====================================================
        // ACTIONS
        // =====================================================

        HBox actBox =
                new HBox(12);


        actBox.setMaxWidth(
                Double.MAX_VALUE
        );


        HBox.setHgrow(
                actBox,
                Priority.ALWAYS
        );


        actBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        actBox.setOpacity(
                0.4
        );


        Label view =
                new Label(
                        "View Profile"
                );


        view.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 0 16 0 0;"
        );


        Button ok =
                new Button("✔");


        ok.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                ";" +
                "-fx-text-fill: #003918;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;" +
                "-fx-pref-width: 32;" +
                "-fx-pref-height: 32;"
        );


        Button no =
                new Button("✖");


        no.setStyle(
                "-fx-background-color: #2e372e;" +
                "-fx-text-fill: " +
                ERROR +
                ";" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;" +
                "-fx-pref-width: 32;" +
                "-fx-pref-height: 32;"
        );


        actBox.getChildren().addAll(
                view,
                ok,
                no
        );


        row.getChildren().addAll(
                userBox,
                planBox,
                dBox,
                sBox,
                actBox
        );


        // =====================================================
        // ROW HOVER
        // =====================================================

        row.setOnMouseEntered(
                e -> {

                    row.setStyle(
                            rowHover
                    );


                    actBox.setOpacity(
                            1.0
                    );
                }
        );


        row.setOnMouseExited(
                e -> {

                    row.setStyle(
                            rowDefault
                    );


                    actBox.setOpacity(
                            0.4
                    );
                }
        );


        return row;
    }


    // =========================================================
    // ACTIVITY PANEL
    // =========================================================

    private VBox createActivityPanel() {

        VBox card =
                new VBox(24);


        card.setPadding(
                new Insets(32)
        );


        setGlassStyle(card);


        Label title =
                new Label(
                        "Recent Activity"
                );


        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        VBox list =
                new VBox(16);


        list.getChildren().addAll(

                createActivityItem(
                        "Marcus Chen",
                        "approved for Elite Performance",
                        "2 minutes ago • By Admin",
                        PRIMARY
                ),

                createActivityItem(
                        "Elena Rossi",
                        "membership request rejected",
                        "14 minutes ago • Reason: Invalid payment method",
                        ERROR
                ),

                createActivityItem(
                        "Leo Grant",
                        "updated profile details",
                        "45 minutes ago • Pending verification",
                        "#c0c6db"
                )
        );


        card.getChildren().addAll(
                title,
                list
        );


        return card;
    }


    // =========================================================
    // ACTIVITY ITEM
    // =========================================================

    private HBox createActivityItem(
            String name,
            String action,
            String sub,
            String colorHex
    ) {

        HBox row =
                new HBox(16);


        row.setAlignment(
                Pos.TOP_LEFT
        );


        Circle dot =
                new Circle(
                        4,
                        Color.web(
                                colorHex
                        )
                );


        dot.setTranslateY(
                6
        );


        dot.setEffect(
                new DropShadow(
                        8,
                        Color.web(
                                colorHex
                        )
                )
        );


        VBox text =
                new VBox(4);


        HBox mainTxt =
                new HBox(4);


        Label nLbl =
                new Label(name);


        nLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );


        Label aLbl =
                new Label(action);


        aLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN +
                ";" +
                "-fx-font-size: 14px;"
        );


        mainTxt.getChildren().addAll(
                nLbl,
                aLbl
        );


        Label sLbl =
                new Label(sub);


        sLbl.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED +
                ";" +
                "-fx-font-size: 12px;"
        );


        text.getChildren().addAll(
                mainTxt,
                sLbl
        );


        row.getChildren().addAll(
                dot,
                text
        );


        return row;
    }


    // =========================================================
    // GLASS STYLE
    // =========================================================

    private void setGlassStyle(
            Region region
    ) {

        String base =
                "-fx-background-color: " +
                CARD_BG +
                ";" +
                "-fx-background-radius: 24;" +
                "-fx-border-color: " +
                SURFACE_BORDER +
                ";" +
                "-fx-border-radius: 24;";


        region.setStyle(base);


        region.setEffect(
                glassShadow
        );
    }
}
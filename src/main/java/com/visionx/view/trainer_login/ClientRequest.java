package com.visionx.view.trainer_login;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Trainer-side Client Requests page.
 *
 * Features:
 * - Pending / Approved / Rejected request tabs
 * - Search
 * - Approve / Reject actions
 * - Status-specific lists
 * - Pagination
 * - Vertical scrolling
 * - Dynamic request counts
 * - Trainer dashboard callback support
 */
public class ClientRequest {

    private Scene requestsScene;
    private Runnable callbackAction;

    // =========================================================
    // COLORS - FITNESSFREAK THEME
    // =========================================================

    private static final String BG_COLOR = "#0d150e";
    private static final String CARD_BG = "#020914";
    private static final String TABLE_BG = "#030a16";

    private static final String BORDER =
            "rgba(255,255,255,0.10)";

    private static final String BORDER_SOLID =
            "#18251c";

    private static final String PRIMARY =
            "#75ff9e";

    private static final String PRIMARY_DARK =
            "#003918";

    private static final String PRIMARY_DIM =
            "rgba(117,255,158,0.10)";

    private static final String TEXT_MAIN =
            "#dbe5d9";

    private static final String TEXT_MUTED =
            "#bacbb9";

    private static final String WARNING =
            "#ffd84d";

    private static final String ERROR =
            "#ff8f86";

    private static final String APPROVED =
            "#75ff9e";

    private static final String REJECTED =
            "#ff8f86";

    private static final DropShadow CARD_SHADOW =
            new DropShadow(
                    26,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.34)
            );

    // =========================================================
    // PAGINATION
    // =========================================================

    private static final int REQUESTS_PER_PAGE = 5;

    private int currentPage = 1;

    private RequestStatus activeStatus =
            RequestStatus.PENDING;

    // =========================================================
    // DATA
    // =========================================================

    private final List<RequestData> pendingRequests =
            new ArrayList<>();

    private final List<RequestData> approvedRequests =
            new ArrayList<>();

    private final List<RequestData> rejectedRequests =
            new ArrayList<>();

    // =========================================================
    // UI REFERENCES
    // =========================================================

    private Button pendingTab;
    private Button approvedTab;
    private Button rejectedTab;

    private Label requestCardTitle;

    private TextField searchField;

    private VBox requestRows;

    private HBox paginationBox;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ClientRequest() {
        loadRequestData();
    }

    // =========================================================
    // REQUEST STATUS
    // =========================================================

    private enum RequestStatus {

        PENDING,
        APPROVED,
        REJECTED
    }

    // =========================================================
    // LOAD SAMPLE DATA
    // =========================================================

    private void loadRequestData() {

        /*
         * Pending requests
         */
        pendingRequests.add(
                new RequestData(
                        "J",
                        "Julian Sterling",
                        "julian.s@example.com",
                        "Elite Performance",
                        "Oct 24, 2023",
                        "10:45 AM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "M",
                        "Maya Thorne",
                        "m.thorne@cloud.io",
                        "Power Pro",
                        "Oct 23, 2023",
                        "02:15 PM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "A",
                        "Arthur Vance",
                        "vance.corp@global.net",
                        "Elite Performance",
                        "Oct 23, 2023",
                        "09:12 AM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "S",
                        "Sasha Reed",
                        "s.reed@example.com",
                        "Weight Loss",
                        "Oct 22, 2023",
                        "04:30 PM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "D",
                        "Daniel Brooks",
                        "daniel.b@example.com",
                        "Strength Training",
                        "Oct 22, 2023",
                        "11:20 AM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "E",
                        "Emma Carter",
                        "emma.c@example.com",
                        "Fitness Beginner",
                        "Oct 21, 2023",
                        "03:40 PM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "R",
                        "Ryan Mitchell",
                        "ryan.m@example.com",
                        "Muscle Gain",
                        "Oct 21, 2023",
                        "01:15 PM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "N",
                        "Nora Wilson",
                        "nora.w@example.com",
                        "General Fitness",
                        "Oct 20, 2023",
                        "05:10 PM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "K",
                        "Kevin Thomas",
                        "kevin.t@example.com",
                        "Power Pro",
                        "Oct 20, 2023",
                        "10:30 AM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "L",
                        "Liam Anderson",
                        "liam.a@example.com",
                        "Weight Loss",
                        "Oct 19, 2023",
                        "02:45 PM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "P",
                        "Priya Shah",
                        "priya.s@example.com",
                        "Elite Performance",
                        "Oct 19, 2023",
                        "09:50 AM"
                )
        );

        pendingRequests.add(
                new RequestData(
                        "A",
                        "Aarav Mehta",
                        "aarav.m@example.com",
                        "Strength Training",
                        "Oct 18, 2023",
                        "04:05 PM"
                )
        );

        /*
         * Approved requests
         */
        approvedRequests.add(
                new RequestData(
                        "R",
                        "Rahul Mehta",
                        "rahul.m@example.com",
                        "Muscle Gain",
                        "Oct 17, 2023",
                        "11:10 AM"
                )
        );

        approvedRequests.add(
                new RequestData(
                        "P",
                        "Priya Sharma",
                        "priya.s@example.com",
                        "Weight Loss",
                        "Oct 16, 2023",
                        "03:25 PM"
                )
        );

        approvedRequests.add(
                new RequestData(
                        "A",
                        "Aman Verma",
                        "aman.v@example.com",
                        "Strength & Conditioning",
                        "Oct 16, 2023",
                        "12:40 PM"
                )
        );

        approvedRequests.add(
                new RequestData(
                        "N",
                        "Neha Patil",
                        "neha.p@example.com",
                        "General Fitness",
                        "Oct 15, 2023",
                        "10:15 AM"
                )
        );

        approvedRequests.add(
                new RequestData(
                        "V",
                        "Vikram Rao",
                        "vikram.r@example.com",
                        "Elite Performance",
                        "Oct 14, 2023",
                        "04:20 PM"
                )
        );

        approvedRequests.add(
                new RequestData(
                        "S",
                        "Sneha Kapoor",
                        "sneha.k@example.com",
                        "Fitness Beginner",
                        "Oct 13, 2023",
                        "02:35 PM"
                )
        );

        /*
         * Rejected requests
         */
        rejectedRequests.add(
                new RequestData(
                        "T",
                        "Thomas Green",
                        "thomas.g@example.com",
                        "Power Pro",
                        "Oct 12, 2023",
                        "09:20 AM"
                )
        );

        rejectedRequests.add(
                new RequestData(
                        "O",
                        "Olivia Brown",
                        "olivia.b@example.com",
                        "Weight Loss",
                        "Oct 11, 2023",
                        "01:50 PM"
                )
        );

        rejectedRequests.add(
                new RequestData(
                        "J",
                        "Jason Miller",
                        "jason.m@example.com",
                        "Elite Performance",
                        "Oct 10, 2023",
                        "03:30 PM"
                )
        );

        rejectedRequests.add(
                new RequestData(
                        "C",
                        "Chloe Davis",
                        "chloe.d@example.com",
                        "General Fitness",
                        "Oct 09, 2023",
                        "11:45 AM"
                )
        );
    }

    // =========================================================
    // SCENE
    // =========================================================

    public Scene getTrainerMyClientsScene(
            Runnable callBackAction
    ) {

        this.callbackAction = callBackAction;

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG_COLOR + ";" +
                "-fx-font-family: 'Segoe UI', sans-serif;"
        );

        VBox page = createPage();

        ScrollPane scroll =
                new ScrollPane(page);

        scroll.setFitToWidth(true);

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        root.setCenter(scroll);

        requestsScene =
                new Scene(root, 1160, 780);

        return requestsScene;
    }

    /**
     * Compatibility overload.
     */
    public Scene getTrainerMyClientsScene() {
        return getTrainerMyClientsScene(null);
    }

    // =========================================================
    // MAIN PAGE
    // =========================================================

    private VBox createPage() {

        VBox page =
                new VBox(28);

        page.setPadding(
                new Insets(42, 52, 48, 52)
        );

        page.setFillWidth(true);

        HBox titleRow =
                createTitleRow();

        HBox tabs =
                createTabs();

        HBox stats =
                createStats();

        VBox requestCard =
                createRequestsCard();

        page.getChildren().addAll(
                titleRow,
                tabs,
                stats,
                requestCard
        );

        return page;
    }

    // =========================================================
    // TITLE
    // =========================================================

    private HBox createTitleRow() {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox text =
                new VBox(6);

        Label breadcrumb =
                new Label(" Client Requests");

        breadcrumb.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        Label title =
                new Label("Client Requests");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";" +
                "-fx-font-size: 34px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Review and manage client requests for your training programs."
                );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";" +
                "-fx-font-size: 14px;"
        );

        text.getChildren().addAll(
                breadcrumb,
                title,
                subtitle
        );

        row.getChildren().add(text);

        return row;
    }

    // =========================================================
    // STATUS TABS
    // =========================================================

    private HBox createTabs() {

        HBox outer =
                new HBox();

        outer.setAlignment(
                Pos.CENTER_RIGHT
        );

        HBox tabs =
                new HBox();

        tabs.setPrefWidth(390);
        tabs.setMaxWidth(390);

        tabs.setStyle(
                "-fx-background-color: " + CARD_BG + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;"
        );

        pendingTab =
                createTabButton(
                        "Pending (" +
                        pendingRequests.size() +
                        ")",
                        true
                );

        approvedTab =
                createTabButton(
                        "Approved (" +
                        approvedRequests.size() +
                        ")",
                        false
                );

        rejectedTab =
                createTabButton(
                        "Rejected (" +
                        rejectedRequests.size() +
                        ")",
                        false
                );

        pendingTab.setOnAction(
                e -> switchStatus(
                        RequestStatus.PENDING
                )
        );

        approvedTab.setOnAction(
                e -> switchStatus(
                        RequestStatus.APPROVED
                )
        );

        rejectedTab.setOnAction(
                e -> switchStatus(
                        RequestStatus.REJECTED
                )
        );

        HBox.setHgrow(
                pendingTab,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                approvedTab,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                rejectedTab,
                Priority.ALWAYS
        );

        tabs.getChildren().addAll(
                pendingTab,
                approvedTab,
                rejectedTab
        );

        outer.getChildren().add(tabs);

        return outer;
    }

    // =========================================================
    // CREATE TAB BUTTON
    // =========================================================

    private Button createTabButton(
            String text,
            boolean active
    ) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setPrefHeight(48);

        applyTabStyle(
                button,
                active
        );

        return button;
    }

    // =========================================================
    // SWITCH TAB
    // =========================================================

    private void switchStatus(
            RequestStatus status
    ) {

        activeStatus = status;

        currentPage = 1;

        applyTabStyle(
                pendingTab,
                status == RequestStatus.PENDING
        );

        applyTabStyle(
                approvedTab,
                status == RequestStatus.APPROVED
        );

        applyTabStyle(
                rejectedTab,
                status == RequestStatus.REJECTED
        );

        updateTabTexts();

        updateRequestCardTitle();

        renderRequestRows();
    }

    // =========================================================
    // TAB TEXT COUNTS
    // =========================================================

    private void updateTabTexts() {

        if (pendingTab != null) {
            pendingTab.setText(
                    "Pending (" +
                    pendingRequests.size() +
                    ")"
            );
        }

        if (approvedTab != null) {
            approvedTab.setText(
                    "Approved (" +
                    approvedRequests.size() +
                    ")"
            );
        }

        if (rejectedTab != null) {
            rejectedTab.setText(
                    "Rejected (" +
                    rejectedRequests.size() +
                    ")"
            );
        }
    }

    // =========================================================
    // TAB STYLE
    // =========================================================

    private void applyTabStyle(
            Button button,
            boolean active
    ) {

        if (button == null) {
            return;
        }

        if (active) {

            button.setStyle(
                    "-fx-background-color: " +
                    PRIMARY + ";" +
                    "-fx-text-fill: " +
                    PRIMARY_DARK + ";" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-radius: 10;" +
                    "-fx-padding: 11 15;" +
                    "-fx-cursor: hand;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " +
                    TEXT_MUTED + ";" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-radius: 10;" +
                    "-fx-padding: 11 15;" +
                    "-fx-cursor: hand;"
            );
        }
    }

    // =========================================================
    // STATISTICS
    // =========================================================

    private HBox createStats() {

        HBox stats =
                new HBox(20);

        stats.setFillHeight(true);

        VBox newToday =
                createStatCard(
                        "NEW TODAY",
                        "12",
                        "+15% from yesterday",
                        true
                );

        VBox responseTime =
                createStatCard(
                        "AVG. RESPONSE TIME",
                        "4.2h",
                        "Based on last 100 requests",
                        false
                );

        VBox conversion =
                createStatCard(
                        "CONVERSION RATE",
                        "89%",
                        "High interest period",
                        true
                );

        HBox.setHgrow(
                newToday,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                responseTime,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                conversion,
                Priority.ALWAYS
        );

        stats.getChildren().addAll(
                newToday,
                responseTime,
                conversion
        );

        return stats;
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String value,
            String subtitle,
            boolean primaryValue
    ) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(24)
        );

        card.setMinHeight(130);

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                BORDER + ";" +
                "-fx-border-radius: 18;"
        );

        card.setEffect(CARD_SHADOW);

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " +
                (primaryValue
                        ? PRIMARY
                        : TEXT_MAIN) +
                ";" +
                "-fx-font-size: 34px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                titleLabel,
                valueLabel,
                subtitleLabel
        );

        return card;
    }

    // =========================================================
    // REQUEST CARD
    // =========================================================

    private VBox createRequestsCard() {

        VBox card =
                new VBox();

        card.setFillWidth(true);

        card.setStyle(
                "-fx-background-color: " +
                CARD_BG + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " +
                BORDER + ";" +
                "-fx-border-radius: 18;"
        );

        card.setEffect(CARD_SHADOW);

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        HBox cardHeader =
                new HBox();

        cardHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        cardHeader.setPadding(
                new Insets(24, 24, 20, 24)
        );

        requestCardTitle =
                new Label();

        requestCardTitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN + ";" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        updateRequestCardTitle();

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label filter =
                new Label("☷  Filter");

        filter.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        Label export =
                new Label("⇩  Export");

        export.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        HBox actions =
                new HBox(
                        18,
                        filter,
                        export
                );

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        cardHeader.getChildren().addAll(
                requestCardTitle,
                spacer,
                actions
        );

        // -----------------------------------------------------
        // SEARCH
        // -----------------------------------------------------

        HBox searchRow =
                new HBox(12);

        searchRow.setPadding(
                new Insets(0, 24, 18, 24)
        );

        searchRow.setAlignment(
                Pos.CENTER_LEFT
        );

        searchField =
                new TextField();

        searchField.setPromptText(
                "Search client requests..."
        );

        searchField.setPrefHeight(42);

        searchField.setMaxWidth(
                Double.MAX_VALUE
        );

        searchField.setStyle(
                "-fx-background-color: " +
                TABLE_BG + ";" +
                "-fx-border-color: " +
                BORDER + ";" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: " +
                TEXT_MAIN + ";" +
                "-fx-prompt-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-padding: 0 14;"
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        /*
         * Search changes the visible list.
         */
        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    currentPage = 1;

                    renderRequestRows();
                }
        );

        searchRow.getChildren().add(
                searchField
        );

        // -----------------------------------------------------
        // TABLE HEADER
        // -----------------------------------------------------

        HBox columns =
                createColumnHeader();

        // -----------------------------------------------------
        // REQUEST LIST
        // -----------------------------------------------------

        requestRows =
                new VBox();

        requestRows.setFillWidth(true);

        ScrollPane requestScroll =
                new ScrollPane(
                        requestRows
                );

        requestScroll.setFitToWidth(true);

        requestScroll.setPrefViewportHeight(
                390
        );

        requestScroll.setMaxHeight(
                440
        );

        requestScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        requestScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        requestScroll.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        // -----------------------------------------------------
        // PAGINATION
        // -----------------------------------------------------

        paginationBox =
                new HBox(7);

        paginationBox.setAlignment(
                Pos.CENTER
        );

        paginationBox.setPadding(
                new Insets(18, 24, 22, 24)
        );

        // -----------------------------------------------------
        // ADD EVERYTHING
        // -----------------------------------------------------

        card.getChildren().addAll(
                cardHeader,
                searchRow,
                columns,
                requestScroll,
                paginationBox
        );

        /*
         * First render.
         */
        renderRequestRows();

        return card;
    }

    // =========================================================
    // UPDATE CARD TITLE
    // =========================================================

    private void updateRequestCardTitle() {

        if (requestCardTitle == null) {
            return;
        }

        switch (activeStatus) {

            case PENDING:
                requestCardTitle.setText(
                        "Pending Client Requests"
                );
                break;

            case APPROVED:
                requestCardTitle.setText(
                        "Approved Client Requests"
                );
                break;

            case REJECTED:
                requestCardTitle.setText(
                        "Rejected Client Requests"
                );
                break;
        }
    }

    // =========================================================
    // GET ACTIVE LIST
    // =========================================================

    private List<RequestData> getActiveList() {

        switch (activeStatus) {

            case APPROVED:
                return approvedRequests;

            case REJECTED:
                return rejectedRequests;

            case PENDING:
            default:
                return pendingRequests;
        }
    }

    // =========================================================
    // FILTERED LIST
    // =========================================================

    private List<RequestData> getFilteredRequests() {

        List<RequestData> source =
                getActiveList();

        if (searchField == null) {
            return new ArrayList<>(source);
        }

        String query =
                searchField.getText();

        if (query == null ||
                query.trim().isEmpty()) {

            return new ArrayList<>(source);
        }

        query =
                query.trim().toLowerCase();

        List<RequestData> filtered =
                new ArrayList<>();

        for (RequestData request : source) {

            boolean matchesName =
                    request.name
                            .toLowerCase()
                            .contains(query);

            boolean matchesEmail =
                    request.email
                            .toLowerCase()
                            .contains(query);

            boolean matchesProgram =
                    request.program
                            .toLowerCase()
                            .contains(query);

            boolean matchesDate =
                    request.date
                            .toLowerCase()
                            .contains(query);

            if (matchesName ||
                    matchesEmail ||
                    matchesProgram ||
                    matchesDate) {

                filtered.add(request);
            }
        }

        return filtered;
    }

    // =========================================================
    // RENDER REQUESTS
    // =========================================================

    private void renderRequestRows() {

        if (requestRows == null) {
            return;
        }

        List<RequestData> filtered =
                getFilteredRequests();

        int totalPages =
                getPageCount(filtered.size());

        /*
         * Protect against currentPage becoming
         * larger than the available pages after
         * approve/reject/search operations.
         */
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        if (currentPage < 1) {
            currentPage = 1;
        }

        requestRows.getChildren().clear();

        if (filtered.isEmpty()) {

            requestRows.getChildren().add(
                    createEmptyState()
            );

        } else {

            int start =
                    (currentPage - 1)
                    * REQUESTS_PER_PAGE;

            int end =
                    Math.min(
                            start + REQUESTS_PER_PAGE,
                            filtered.size()
                    );

            for (int i = start; i < end; i++) {

                RequestData request =
                        filtered.get(i);

                HBox row =
                        createRequestRow(request);

                requestRows
                        .getChildren()
                        .add(row);
            }
        }

        renderPagination(
                totalPages
        );
    }

    // =========================================================
    // PAGE COUNT
    // =========================================================

    private int getPageCount(
            int totalItems
    ) {

        if (totalItems <= 0) {
            return 1;
        }

        return (
                (totalItems - 1)
                        / REQUESTS_PER_PAGE
        ) + 1;
    }

    // =========================================================
    // EMPTY STATE
    // =========================================================

    private VBox createEmptyState() {

        VBox empty =
                new VBox(10);

        empty.setAlignment(
                Pos.CENTER
        );

        empty.setPadding(
                new Insets(45)
        );

        Label icon =
                new Label("✓");

        icon.setStyle(
                "-fx-text-fill: " +
                PRIMARY + ";" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label title =
                new Label(
                        "No requests found"
                );

        title.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "There are no requests matching this view."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        empty.getChildren().addAll(
                icon,
                title,
                subtitle
        );

        return empty;
    }

    // =========================================================
    // PAGINATION
    // =========================================================

    private void renderPagination(
            int totalPages
    ) {

        if (paginationBox == null) {
            return;
        }

        paginationBox.getChildren().clear();

        /*
         * Previous button
         */
        Button previous =
                createPageNavigationButton(
                        "‹"
                );

        previous.setDisable(
                currentPage <= 1
        );

        previous.setOnAction(
                e -> {

                    if (currentPage > 1) {

                        currentPage--;

                        renderRequestRows();
                    }
                }
        );

        paginationBox.getChildren().add(
                previous
        );

        /*
         * Page number buttons.
         *
         * IMPORTANT:
         * final int pageNumber fixes the
         * lambda / p++ problem.
         */
        for (
                int p = 1;
                p <= totalPages;
                p++
        ) {

            final int pageNumber = p;

            Button number =
                    pageNumber == currentPage
                            ? primaryPageButton(
                                    String.valueOf(pageNumber)
                            )
                            : secondaryPageButton(
                                    String.valueOf(pageNumber)
                            );

            number.setMinWidth(40);

            number.setPrefHeight(36);

            number.setOnAction(
                    e -> showRequestPage(
                            pageNumber
                    )
            );

            paginationBox
                    .getChildren()
                    .add(number);
        }

        /*
         * Next button
         */
        Button next =
                createPageNavigationButton(
                        "›"
                );

        next.setDisable(
                currentPage >= totalPages
        );

        next.setOnAction(
                e -> {

                    if (currentPage < totalPages) {

                        currentPage++;

                        renderRequestRows();
                    }
                }
        );

        paginationBox.getChildren().add(
                next
        );
    }

    // =========================================================
    // SHOW REQUEST PAGE
    // =========================================================

    private void showRequestPage(
            int page
    ) {

        currentPage = page;

        renderRequestRows();
    }

    // =========================================================
    // PAGE BUTTON
    // =========================================================

    private Button createPageNavigationButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setMinSize(
                40,
                36
        );

        button.setMaxSize(
                40,
                36
        );

        button.setStyle(
                "-fx-background-color: " +
                TABLE_BG + ";" +
                "-fx-text-fill: " +
                TEXT_MAIN + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 9;" +
                "-fx-border-color: " +
                BORDER + ";" +
                "-fx-border-radius: 9;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // PRIMARY PAGE BUTTON
    // =========================================================

    private Button primaryPageButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color: " +
                PRIMARY + ";" +
                "-fx-text-fill: " +
                PRIMARY_DARK + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 9;" +
                "-fx-border-radius: 9;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // SECONDARY PAGE BUTTON
    // =========================================================

    private Button secondaryPageButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color: " +
                TABLE_BG + ";" +
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 9;" +
                "-fx-border-color: " +
                BORDER + ";" +
                "-fx-border-radius: 9;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // TABLE HEADER
    // =========================================================

    private HBox createColumnHeader() {

        HBox header =
                new HBox();

        header.setPadding(
                new Insets(16, 24, 16, 24)
        );

        header.setStyle(
                "-fx-background-color: " +
                "rgba(255,255,255,0.018);" +
                "-fx-border-color: " +
                BORDER_SOLID +
                " transparent transparent transparent;"
        );

        Label user =
                createColumnLabel(
                        "CLIENT",
                        300
                );

        Label program =
                createColumnLabel(
                        "REQUESTED PROGRAM",
                        210
                );

        Label date =
                createColumnLabel(
                        "DATE REQUESTED",
                        180
                );

        Label status =
                createColumnLabel(
                        "STATUS",
                        160
                );

        Label actions =
                createColumnLabel(
                        "ACTIONS",
                        0
                );

        HBox.setHgrow(
                actions,
                Priority.ALWAYS
        );

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        header.getChildren().addAll(
                user,
                program,
                date,
                status,
                actions
        );

        return header;
    }

    // =========================================================
    // COLUMN LABEL
    // =========================================================

    private Label createColumnLabel(
            String text,
            double width
    ) {

        Label label =
                new Label(text);

        if (width > 0) {

            label.setPrefWidth(width);
        }

        label.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // REQUEST ROW
    // =========================================================

    private HBox createRequestRow(
            RequestData request
    ) {

        HBox row =
                new HBox();

        row.setMinHeight(82);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(14, 24, 14, 24)
        );

        row.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: " +
                BORDER_SOLID +
                " transparent transparent transparent;"
        );

        HBox.setHgrow(
                row,
                Priority.ALWAYS
        );

        // -----------------------------------------------------
        // CLIENT
        // -----------------------------------------------------

        HBox client =
                new HBox(12);

        client.setAlignment(
                Pos.CENTER_LEFT
        );

        client.setPrefWidth(300);

        StackPane avatar =
                createAvatar(
                        request.initial
                );

        VBox clientText =
                new VBox(3);

        Label name =
                new Label(request.name);

        name.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label email =
                new Label(request.email);

        email.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 10px;"
        );

        clientText.getChildren().addAll(
                name,
                email
        );

        client.getChildren().addAll(
                avatar,
                clientText
        );

        // -----------------------------------------------------
        // PROGRAM
        // -----------------------------------------------------

        Label program =
                new Label(
                        request.program
                );

        program.setPrefWidth(210);

        program.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 12px;"
        );

        // -----------------------------------------------------
        // DATE
        // -----------------------------------------------------

        VBox dateBox =
                new VBox(3);

        dateBox.setPrefWidth(180);

        Label date =
                new Label(request.date);

        date.setStyle(
                "-fx-text-fill: " +
                TEXT_MAIN + ";" +
                "-fx-font-size: 12px;"
        );

        Label time =
                new Label(request.time);

        time.setStyle(
                "-fx-text-fill: " +
                TEXT_MUTED + ";" +
                "-fx-font-size: 10px;"
        );

        dateBox.getChildren().addAll(
                date,
                time
        );

        // -----------------------------------------------------
        // STATUS
        // -----------------------------------------------------

        Label status =
                createStatusLabel();

        status.setPrefWidth(160);

        // -----------------------------------------------------
        // ACTIONS
        // -----------------------------------------------------

        HBox actions =
                new HBox(8);

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        HBox.setHgrow(
                actions,
                Priority.ALWAYS
        );

        Button view =
                createViewButton();

        view.setOnAction(
                e -> showRequestDetails(
                        request
                )
        );

        actions.getChildren().add(
                view
        );

        /*
         * Pending requests get Approve / Reject.
         *
         * Approved and Rejected requests only
         * have View Profile.
         */
        if (activeStatus ==
                RequestStatus.PENDING) {

            Button approve =
                    createActionButton(
                            "✓",
                            PRIMARY_DIM,
                            PRIMARY
                    );

            Button reject =
                    createActionButton(
                            "×",
                            "rgba(255,143,134,0.08)",
                            ERROR
                    );

            approve.setOnAction(
                    e -> handleDecision(
                            request,
                            RequestStatus.APPROVED
                    )
            );

            reject.setOnAction(
                    e -> handleDecision(
                            request,
                            RequestStatus.REJECTED
                    )
            );

            actions.getChildren().addAll(
                    approve,
                    reject
            );
        }

        row.getChildren().addAll(
                client,
                program,
                dateBox,
                status,
                actions
        );

        return row;
    }

    // =========================================================
    // AVATAR
    // =========================================================

    private StackPane createAvatar(
            String initial
    ) {

        StackPane avatar =
                new StackPane();

        avatar.setMinSize(
                44,
                44
        );

        avatar.setMaxSize(
                44,
                44
        );

        avatar.setStyle(
                "-fx-background-color: " +
                PRIMARY_DIM + ";" +
                "-fx-background-radius: 50;"
        );

        Label initialLabel =
                new Label(initial);

        initialLabel.setStyle(
                "-fx-text-fill: " +
                PRIMARY + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        avatar.getChildren().add(
                initialLabel
        );

        return avatar;
    }

    // =========================================================
    // STATUS LABEL
    // =========================================================

    private Label createStatusLabel() {

        Label status =
                new Label();

        switch (activeStatus) {

            case PENDING:

                status.setText(
                        "●  Pending Review"
                );

                status.setStyle(
                        "-fx-text-fill: " +
                        WARNING + ";" +
                        "-fx-font-size: 11px;" +
                        "-fx-font-weight: bold;"
                );

                break;

            case APPROVED:

                status.setText(
                        "●  Approved"
                );

                status.setStyle(
                        "-fx-text-fill: " +
                        APPROVED + ";" +
                        "-fx-font-size: 11px;" +
                        "-fx-font-weight: bold;"
                );

                break;

            case REJECTED:

                status.setText(
                        "●  Rejected"
                );

                status.setStyle(
                        "-fx-text-fill: " +
                        REJECTED + ";" +
                        "-fx-font-size: 11px;" +
                        "-fx-font-weight: bold;"
                );

                break;
        }

        return status;
    }

    // =========================================================
    // VIEW BUTTON
    // =========================================================

    private Button createViewButton() {

        Button button =
                new Button("View Profile");

        button.setPrefHeight(36);

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " +
                PRIMARY + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(
                e -> button.setStyle(
                        "-fx-background-color: " +
                        PRIMARY_DIM + ";" +
                        "-fx-text-fill: " +
                        PRIMARY + ";" +
                        "-fx-font-size: 11px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
                )
        );

        button.setOnMouseExited(
                e -> button.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: " +
                        PRIMARY + ";" +
                        "-fx-font-size: 11px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        return button;
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private Button createActionButton(
            String text,
            String background,
            String foreground
    ) {

        Button button =
                new Button(text);

        button.setMinSize(
                38,
                36
        );

        button.setMaxSize(
                38,
                36
        );

        button.setStyle(
                "-fx-background-color: " +
                background + ";" +
                "-fx-text-fill: " +
                foreground + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 9;" +
                "-fx-border-radius: 9;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(
                e -> button.setStyle(
                        "-fx-background-color: " +
                        foreground + ";" +
                        "-fx-text-fill: " +
                        (
                                foreground.equals(
                                        PRIMARY
                                )
                                        ? PRIMARY_DARK
                                        : "#32110f"
                        ) +
                        ";" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 9;" +
                        "-fx-border-radius: 9;" +
                        "-fx-cursor: hand;"
                )
        );

        button.setOnMouseExited(
                e -> button.setStyle(
                        "-fx-background-color: " +
                        background + ";" +
                        "-fx-text-fill: " +
                        foreground + ";" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 9;" +
                        "-fx-border-radius: 9;" +
                        "-fx-cursor: hand;"
                )
        );

        return button;
    }

    // =========================================================
    // REQUEST DETAILS
    // =========================================================

    private void showRequestDetails(
            RequestData request
    ) {

        /*
         * Keeping this method compatible with
         * your current implementation.
         *
         * You can connect your detailed profile
         * scene here later.
         */
        System.out.println(
                "Client request: " +
                request.name +
                " | " +
                request.program +
                " | " +
                request.email
        );
    }

    // =========================================================
    // APPROVE / REJECT
    // =========================================================

    private void handleDecision(
            RequestData request,
            RequestStatus decision
    ) {

        /*
         * Remove from Pending first.
         */
        pendingRequests.remove(request);

        /*
         * Then add to the selected status.
         */
        if (decision ==
                RequestStatus.APPROVED) {

            approvedRequests.add(
                    request
            );

            System.out.println(
                    "Client request approved: " +
                    request.name
            );

        } else if (
                decision ==
                RequestStatus.REJECTED
        ) {

            rejectedRequests.add(
                    request
            );

            System.out.println(
                    "Client request rejected: " +
                    request.name
            );
        }

        /*
         * Refresh all counters.
         */
        updateTabTexts();

        /*
         * Keep trainer on Pending after
         * approving/rejecting.
         */
        activeStatus =
                RequestStatus.PENDING;

        currentPage = 1;

        applyTabStyle(
                pendingTab,
                true
        );

        applyTabStyle(
                approvedTab,
                false
        );

        applyTabStyle(
                rejectedTab,
                false
        );

        updateRequestCardTitle();

        renderRequestRows();
    }

    // =========================================================
    // BACK TO DASHBOARD
    // =========================================================

    public void backToDashboard() {

        if (callbackAction != null) {

            callbackAction.run();
        }
    }

    // =========================================================
    // DATA CLASS
    // =========================================================

    private static final class RequestData {

        private final String initial;

        private final String name;

        private final String email;

        private final String program;

        private final String date;

        private final String time;

        private RequestData(
                String initial,
                String name,
                String email,
                String program,
                String date,
                String time
        ) {

            this.initial = initial;

            this.name = name;

            this.email = email;

            this.program = program;

            this.date = date;

            this.time = time;
        }
    }
}
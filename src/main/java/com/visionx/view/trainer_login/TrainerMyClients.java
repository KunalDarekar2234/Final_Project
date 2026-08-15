package com.visionx.view.trainer_login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * Trainer-side My Clients page.
 *
 * Important:
 * - No external image/resource is loaded, so this class cannot introduce a
 *   getResource(...).toExternalForm() null-pointer.
 * - Client avatars are generated locally as small profile illustrations.
 * - "View all 48 members" navigates inside the existing TrainerDashboard
 *   content area; it does not open a second window or a modal directory.
 * - The directory is 3 pages, 16 clients per page, 2 columns (2 x N cards).
 */
public class TrainerMyClients {

    // =========================================================
    // THEME
    // =========================================================

    private static final String BG = "#0d150e";
    private static final String CARD = "#020914";
    private static final String CARD_ALT = "#071019";
    private static final String CARD_SOFT = "#0d1a14";
    private static final String BORDER = "#26332a";

    private static final String PRIMARY = "#75ff9e";
    private static final String PRIMARY_DARK = "#163b2a";
    private static final String TEXT = "#dbe5d9";
    private static final String MUTED = "#9bac9e";
    private static final String TRACK = "#17231d";

    private static final int PAGE_SIZE = 16;
    private static final int DIRECTORY_PAGE_COUNT = 3;

    // Soft green theme colors for the completed part of the progress bar.
    private static final String PROGRESS_HIGH = "#35d6a0";
    private static final String PROGRESS_GOOD = "#55f08b";
    private static final String PROGRESS_MID = "#8be36a";
    private static final String PROGRESS_LOW = "#c8dc62";

    private static final String[] AVATAR_BACKGROUNDS = {
            "#173d2a", "#243b58", "#4a2e4a", "#234b46",
            "#4a3a24", "#303b52", "#254438", "#3d3048"
    };

    private static final String[] SKIN_TONES = {
            "#f2c7a5", "#d99b72", "#b86f4d", "#f0b98b",
            "#c98662", "#e6ad82", "#9e6044", "#f4d0ad"
    };

    private static final String[] HAIR_COLORS = {
            "#241b18", "#33251e", "#161719", "#4a3020",
            "#1d2420", "#3a2424", "#242024", "#513628"
    };

    private static final String[] SHIRT_COLORS = {
            "#75ff9e", "#76a7ff", "#d889ff", "#61d5c2",
            "#f0c96a", "#89a6c9", "#c77fa8", "#72c98d"
    };

    // =========================================================
    // NAVIGATION CALLBACKS
    // =========================================================

    private final Runnable dashboardAction;
    private final Runnable myClientsAction;
    private final Runnable clientRequestsAction;
    private final Runnable workoutPlansAction;
    private final Runnable chatboxAction;
    private final Runnable scheduleAction;
    private final Runnable earningsAction;
    private final Runnable reviewsAction;
    private final Runnable profileAction;
    private final Runnable logoutAction;

    // =========================================================
    // PAGE HOST
    // =========================================================

    /** This is the node TrainerDashboard extracts and places in its center. */
    private final StackPane pageHost = new StackPane();

    private int directoryPage = 1;

    private final List<ClientProfile> clients = buildDemoClients();

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public TrainerMyClients(
            Runnable dashboardAction,
            Runnable myClientsAction,
            Runnable clientRequestsAction,
            Runnable workoutPlansAction,
            Runnable chatboxAction,
            Runnable scheduleAction,
            Runnable earningsAction,
            Runnable reviewsAction,
            Runnable profileAction,
            Runnable logoutAction
    ) {
        this.dashboardAction = dashboardAction;
        this.myClientsAction = myClientsAction;
        this.clientRequestsAction = clientRequestsAction;
        this.workoutPlansAction = workoutPlansAction;
        this.chatboxAction = chatboxAction;
        this.scheduleAction = scheduleAction;
        this.earningsAction = earningsAction;
        this.reviewsAction = reviewsAction;
        this.profileAction = profileAction;
        this.logoutAction = logoutAction;
    }

    // =========================================================
    // SCENE
    // =========================================================

    /**
     * TrainerDashboard calls extractCenterContent(scene), so the actual
     * navigation host must be the center node of this BorderPane.
     */
    public Scene getMyClientsScene() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color:" + BG + ";-fx-font-family:'Segoe UI';");

        pageHost.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        pageHost.setStyle("-fx-background-color:" + BG + ";");
        pageHost.getChildren().clear();
        pageHost.getChildren().add(createMyClientsContent());

        // TrainerDashboard extracts this center node. That keeps its existing
        // sidebar/header and lets this class replace the center content for
        // directory page 1 -> 2 -> 3 without opening another Scene/window.
        root.setCenter(pageHost);

        return new Scene(root, 1200, 800);
    }

    // =========================================================
    // PAGE 1 - MY CLIENTS
    // =========================================================

    private ScrollPane createMyClientsContent() {
        VBox content = new VBox(22);
        content.setPadding(new Insets(30, 36, 42, 36));
        content.setStyle("-fx-background-color:" + BG + ";");

        HBox heading = new HBox();
        heading.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);
        titleBox.getChildren().addAll(
                label("Trainer Portal  >  My Clients", 11, MUTED, false),
                label("My Clients", 31, TEXT, true),
                label("Manage your clients, track progress and monitor their fitness journey.", 14, MUTED, false)
        );

        Region headingSpacer = new Region();
        HBox.setHgrow(headingSpacer, Priority.ALWAYS);

        

        heading.getChildren().addAll(titleBox, headingSpacer);

        GridPane stats = new GridPane();
        stats.setHgap(20);
        stats.setVgap(20);
        stats.setMaxWidth(Double.MAX_VALUE);
        addTwoColumnConstraints(stats);

        stats.add(metricCard("ALL ENROLLED CLIENTS", "48", "+6 this month", "✦"), 0, 0);
        stats.add(metricCard("TOTAL ACTIVE CLIENTS", "36", "75% of roster", "●"), 1, 0);
        stats.add(metricCard("NEW CLIENTS", "08", "Joined in August", "+"), 0, 1);
        stats.add(metricCard("PROGRAM COMPLETION RATE", "82%", "+5.4% vs last month", "✓"), 1, 1);

        HBox rosterHeader = new HBox();
        rosterHeader.setAlignment(Pos.CENTER_LEFT);

        VBox rosterText = new VBox(3);
        rosterText.getChildren().addAll(
                label("Your clients", 21, TEXT, true),
                label("Tap a profile to see their complete coaching snapshot.", 12, MUTED, false)
        );

        Region rosterSpacer = new Region();
        HBox.setHgrow(rosterSpacer, Priority.ALWAYS);

        Button viewAll = secondaryButton("View all 48 members  →");
        viewAll.setOnAction(e -> showClientDirectory(1));

        rosterHeader.getChildren().addAll(rosterText, rosterSpacer, viewAll);

        GridPane clientsGrid = new GridPane();
        clientsGrid.setHgap(20);
        clientsGrid.setVgap(20);
        clientsGrid.setMaxWidth(Double.MAX_VALUE);
        addTwoColumnConstraints(clientsGrid);

        // Main page keeps the clean 2 x 2 layout shown in the reference.
        for (int i = 0; i < 4; i++) {
            clientsGrid.add(buildClientCard(clients.get(i), i), i % 2, i / 2);
        }

        content.getChildren().addAll(heading, stats, rosterHeader, clientsGrid);

        ScrollPane scroll = new ScrollPane(content);
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setStyle(
                "-fx-background:" + BG + ";" +
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );
        return scroll;
    }

    private VBox metricCard(String heading, String value, String note, String symbol) {
        VBox card = new VBox(12);
        card.setMinHeight(132);
        card.setPadding(new Insets(20, 23, 18, 23));
        card.setStyle(
                cardStyle() +
                "-fx-background-radius:20;" +
                "-fx-border-radius:20;" +
                "-fx-effect:dropshadow(gaussian, rgba(0,0,0,0.25), 14, 0, 0, 4);"
        );

        HBox top = new HBox();
        top.setAlignment(Pos.CENTER_LEFT);

        Label h = label(heading, 11, "#c7d3c6", true);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label icon = label(symbol, 15, PRIMARY, true);
        icon.setStyle(icon.getStyle() +
                "-fx-background-color:rgba(117,255,158,0.10);" +
                "-fx-background-radius:18;" +
                "-fx-padding:5 9;"
        );

        top.getChildren().addAll(h, spacer, icon);

        HBox numberLine = new HBox(10);
        numberLine.setAlignment(Pos.BASELINE_LEFT);
        numberLine.getChildren().addAll(
                label(value, 39, TEXT, true),
                label(note, 11, PRIMARY, true)
        );

        card.getChildren().addAll(top, numberLine);
        return card;
    }

    // =========================================================
    // CLIENT CARD
    // =========================================================

    private VBox buildClientCard(ClientProfile client, int index) {
        VBox card = new VBox(15);
        card.setPadding(new Insets(18));
        card.setMinHeight(255);
        card.setMaxWidth(Double.MAX_VALUE);
        card.setStyle(
                cardStyle() +
                "-fx-background-radius:20;" +
                "-fx-border-radius:20;" +
                "-fx-effect:dropshadow(gaussian, rgba(0,0,0,0.26), 16, 0, 0, 6);"
        );

        HBox profileRow = new HBox(13);
        profileRow.setAlignment(Pos.CENTER_LEFT);
        profileRow.getChildren().add(createProfileImage(index, 27));

        VBox names = new VBox(3);
        names.getChildren().addAll(
                label(client.name, 17, TEXT, true),
                label(client.goal, 11, PRIMARY, true)
        );

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label status = badge("ACTIVE", PRIMARY);
        profileRow.getChildren().addAll(names, spacer, status);

        HBox details = new HBox(34);
        details.getChildren().addAll(
                statText("PROGRAM", client.program),
                statText("TRAINING", client.training)
        );

        VBox progressBlock = new VBox(7);
        HBox progressHeader = new HBox();
        progressHeader.setAlignment(Pos.CENTER_LEFT);
        progressHeader.getChildren().addAll(
                label("PROGRAM PROGRESS", 10, MUTED, true),
                spacer(),
                label(client.progressValue, 12, progressColor(client.progress()), true)
        );

        // Custom progress bar instead of JavaFX ProgressBar. This prevents the
        // default skin from rendering a large white fill/track.
        StackPane progress = createProgressBar(client.progress());
        progressBlock.getChildren().addAll(progressHeader, progress);

        HBox actions = new HBox(10);
        Button info = secondaryButton("Client info");
        Button task = primaryButton("Assign task");

        HBox.setHgrow(info, Priority.ALWAYS);
        HBox.setHgrow(task, Priority.ALWAYS);
        info.setMaxWidth(Double.MAX_VALUE);
        task.setMaxWidth(Double.MAX_VALUE);

        info.setOnAction(e -> showClientInfo(client, index));
        task.setOnAction(e -> showAssignTask(client));
        actions.getChildren().addAll(info, task);

        card.getChildren().addAll(profileRow, details, progressBlock, actions);
        return card;
    }

    private StackPane createProgressBar(double progress) {
        StackPane stack = new StackPane();
        stack.setMinHeight(8);
        stack.setPrefHeight(8);
        stack.setMaxHeight(8);
        stack.setMaxWidth(Double.MAX_VALUE);
        stack.setAlignment(Pos.CENTER_LEFT);

        Region track = new Region();
        track.setMaxWidth(Double.MAX_VALUE);
        track.setMinHeight(8);
        track.setPrefHeight(8);
        track.setMaxHeight(8);
        track.setStyle(
                "-fx-background-color:" + TRACK + ";" +
                "-fx-background-radius:6;"
        );

        Region fill = new Region();
        fill.setMinHeight(8);
        fill.setPrefHeight(8);
        fill.setMaxHeight(8);
        fill.setMaxWidth(Double.MAX_VALUE);
        fill.setStyle(
                "-fx-background-color:" + progressColor(progress) + ";" +
                "-fx-background-radius:6;"
        );

        // The completed portion gets a responsive width while the dark track
        // stays visible underneath it. This is deliberately not a JavaFX
        // ProgressBar, so the default white skin can never cover the theme.
        fill.prefWidthProperty().bind(stack.widthProperty().multiply(progress));
        fill.maxWidthProperty().bind(stack.widthProperty().multiply(progress));

        stack.getChildren().addAll(track, fill);
        return stack;
    }

    private String progressColor(double progress) {
        if (progress >= 0.90) return PROGRESS_HIGH;
        if (progress >= 0.75) return PROGRESS_GOOD;
        if (progress >= 0.60) return PROGRESS_MID;
        return PROGRESS_LOW;
    }

    private VBox statText(String caption, String value) {
        VBox box = new VBox(4);
        box.getChildren().addAll(
                label(caption, 9, MUTED, true),
                label(value, 11, TEXT, false)
        );
        return box;
    }

    private Region spacer() {
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        return region;
    }

    // =========================================================
    // DIRECTORY - PAGE 1 / PAGE 2 / PAGE 3
    // =========================================================

    private void showClientDirectory(int page) {
        directoryPage = Math.max(1, Math.min(DIRECTORY_PAGE_COUNT, page));
        pageHost.getChildren().setAll(createDirectoryPage(directoryPage));
    }

    private ScrollPane createDirectoryPage(int page) {
        VBox content = new VBox(20);
        content.setPadding(new Insets(30, 36, 36, 36));
        content.setStyle("-fx-background-color:" + BG + ";");

        HBox heading = new HBox();
        heading.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);
        titleBox.getChildren().addAll(
                label("Trainer Portal  >  My Clients  >  All Members", 11, MUTED, false),
                label("All 48 Members", 31, TEXT, true),
                label("Client roster • Page " + page + " of " + DIRECTORY_PAGE_COUNT, 13, MUTED, false)
        );

        Region headingSpacer = new Region();
        HBox.setHgrow(headingSpacer, Priority.ALWAYS);

        Button back = secondaryButton("← Back to My Clients");
        back.setOnAction(e -> pageHost.getChildren().setAll(createMyClientsContent()));

        heading.getChildren().addAll(titleBox, headingSpacer, back);

        HBox summary = new HBox(12);
        summary.getChildren().addAll(
                directoryPill("48", "TOTAL MEMBERS"),
                directoryPill("36", "ACTIVE"),
                directoryPill("82%", "AVG. PROGRESS")
        );

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setMaxWidth(Double.MAX_VALUE);
        addTwoColumnConstraints(grid);

        int start = (page - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, clients.size());

        for (int i = start; i < end; i++) {
            int localIndex = i - start;
            grid.add(buildDirectoryCard(clients.get(i), i), localIndex % 2, localIndex / 2);
        }

        HBox pager = new HBox(10);
        pager.setAlignment(Pos.CENTER);
        pager.setPadding(new Insets(8, 0, 8, 0));

        Button previous = secondaryButton("← Previous");
        previous.setDisable(page == 1);
        previous.setOnAction(e -> showClientDirectory(page - 1));

        HBox pageButtons = new HBox(7);

        for (int p = 1; p <= DIRECTORY_PAGE_COUNT; p++) {

        final int pageNumber = p;

        Button number = page == pageNumber
                ? primaryButton(String.valueOf(pageNumber))
                : secondaryButton(String.valueOf(pageNumber));

        number.setMinWidth(42);

        number.setOnAction(e -> showClientDirectory(pageNumber));

        pageButtons.getChildren().add(number);
        }
        Button next = primaryButton("Next →");
        next.setDisable(page == DIRECTORY_PAGE_COUNT);
        next.setOnAction(e -> showClientDirectory(page + 1));

        pager.getChildren().addAll(previous, pageButtons, next);

        content.getChildren().addAll(heading, summary, grid, pager);

        ScrollPane scroll = new ScrollPane(content);
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setStyle(
                "-fx-background:" + BG + ";" +
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );
        return scroll;
    }

    private VBox directoryPill(String value, String caption) {
        VBox box = new VBox(3);
        box.setPadding(new Insets(11, 16, 11, 16));
        box.setStyle(
                "-fx-background-color:" + CARD_SOFT + ";" +
                "-fx-background-radius:13;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:13;"
        );
        box.getChildren().addAll(
                label(value, 18, TEXT, true),
                label(caption, 9, MUTED, true)
        );
        return box;
    }

    private VBox buildDirectoryCard(ClientProfile client, int index) {
        VBox card = new VBox(14);
        card.setPadding(new Insets(18));
        card.setMinHeight(214);
        card.setMaxWidth(Double.MAX_VALUE);
        card.setStyle(
                cardStyle() +
                "-fx-background-radius:20;" +
                "-fx-border-radius:20;" +
                "-fx-effect:dropshadow(gaussian, rgba(0,0,0,0.24), 14, 0, 0, 5);"
        );

        HBox top = new HBox(13);
        top.setAlignment(Pos.CENTER_LEFT);
        top.getChildren().add(createProfileImage(index, 29));

        VBox nameBox = new VBox(3);
        nameBox.getChildren().addAll(
                label(client.name, 16, TEXT, true),
                label(client.goal, 10, PRIMARY, true)
        );

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        top.getChildren().addAll(nameBox, spacer, badge("ACTIVE", PRIMARY));

        HBox info = new HBox(22);
        info.getChildren().addAll(
                statText("PROGRAM", client.program),
                statText("SESSIONS", client.training)
        );

        HBox progressHeader = new HBox();
        progressHeader.setAlignment(Pos.CENTER_LEFT);
        progressHeader.getChildren().addAll(
                label("PROGRAM PROGRESS", 9, MUTED, true),
                spacer(),
                label(client.progressValue, 11, progressColor(client.progress()), true)
        );

        VBox progress = new VBox(6);
        progress.getChildren().addAll(progressHeader, createProgressBar(client.progress()));

        HBox actions = new HBox(9);
        Button view = secondaryButton("Client info");
        Button task = primaryButton("Assign task");
        HBox.setHgrow(view, Priority.ALWAYS);
        HBox.setHgrow(task, Priority.ALWAYS);
        view.setMaxWidth(Double.MAX_VALUE);
        task.setMaxWidth(Double.MAX_VALUE);
        view.setOnAction(e -> showClientInfo(client, index));
        task.setOnAction(e -> showAssignTask(client));
        actions.getChildren().addAll(view, task);

        card.getChildren().addAll(top, info, progress, actions);
        return card;
    }

    // =========================================================
    // CLIENT PROFILE VIEW
    // =========================================================

    private void showClientInfo(ClientProfile client, int index) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Client Profile");
        dialog.setResizable(true);

        DialogPane pane = dialog.getDialogPane();
        pane.getButtonTypes().add(new ButtonType("Back to My Clients", ButtonBar.ButtonData.CANCEL_CLOSE));
        pane.setStyle("-fx-background-color:" + CARD + ";-fx-font-family:'Segoe UI';");
        pane.setPrefWidth(620);
        pane.setPrefHeight(560);

        VBox body = new VBox(17);
        body.setPadding(new Insets(4, 2, 4, 2));

        HBox profile = new HBox(15);
        profile.setAlignment(Pos.CENTER_LEFT);
        profile.getChildren().add(createProfileImage(index, 38));

        VBox profileText = new VBox(4);
        profileText.getChildren().addAll(
                label(client.name, 23, TEXT, true),
                label(client.goal + "  •  Active client", 12, PRIMARY, true),
                label("Trainer-facing coaching information only", 10, MUTED, false)
        );
        profile.getChildren().add(profileText);

        GridPane info = new GridPane();
        info.setHgap(12);
        info.setVgap(12);
        addTwoColumnConstraints(info);

        info.add(infoTile("PROGRAM", client.program), 0, 0);
        info.add(infoTile("TRAINING", client.training), 1, 0);
        info.add(infoTile("PROGRESS", client.progressValue), 0, 1);
        info.add(infoTile("STAGE", client.stage), 1, 1);
        info.add(infoTile("FOCUS", client.detailType), 0, 2);
        info.add(infoTile("STATUS", "Active"), 1, 2);

        Label progressTitle = section("PROGRAM PROGRESS");
        HBox progressLine = new HBox();
        progressLine.setAlignment(Pos.CENTER_LEFT);
        progressLine.getChildren().addAll(
                label("Current completion", 11, MUTED, false),
                spacer(),
                label(client.progressValue, 12, progressColor(client.progress()), true)
        );

        VBox progressBox = new VBox(8);
        progressBox.getChildren().addAll(progressLine, createProgressBar(client.progress()));

        VBox coachingBox = new VBox(8);
        coachingBox.setPadding(new Insets(14));
        coachingBox.setStyle(
                "-fx-background-color:" + CARD_ALT + ";" +
                "-fx-background-radius:14;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:14;"
        );
        coachingBox.getChildren().addAll(
                label("COACHING NOTES", 10, PRIMARY, true),
                label(
                        "Keep progressive overload controlled, protect recovery days, and review weekly adherence before the next checkpoint.",
                        11, TEXT, false
                )
        );

        Button assign = primaryButton("Assign task to " + client.name);
        assign.setMaxWidth(Double.MAX_VALUE);
        assign.setOnAction(e -> {
            dialog.close();
            showAssignTask(client);
        });

        body.getChildren().addAll(
                profile,
                section("CLIENT OVERVIEW"),
                info,
                progressTitle,
                progressBox,
                coachingBox,
                assign
        );

        pane.setContent(body);
        dialog.showAndWait();
    }

    private VBox infoTile(String header, String value) {
        VBox box = new VBox(5);
        box.setPadding(new Insets(12));
        box.setStyle(
                "-fx-background-color:" + CARD_ALT + ";" +
                "-fx-background-radius:12;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:12;"
        );
        box.getChildren().addAll(
                label(header, 9, MUTED, true),
                label(value, 12, TEXT, true)
        );
        return box;
    }

    // =========================================================
    // ASSIGN TASK POPUP
    // =========================================================

    private void showAssignTask(ClientProfile client) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Assign Task");
        dialog.setResizable(true);

        DialogPane pane = dialog.getDialogPane();
        pane.getButtonTypes().add(new ButtonType("Back to My Clients", ButtonBar.ButtonData.CANCEL_CLOSE));
        pane.setStyle("-fx-background-color:" + CARD + ";-fx-font-family:'Segoe UI';");
        pane.setPrefWidth(650);
        pane.setPrefHeight(600);

        VBox body = new VBox(11);
        body.setPadding(new Insets(4, 2, 4, 2));

        HBox heading = new HBox(13);
        heading.setAlignment(Pos.CENTER_LEFT);
        heading.getChildren().add(createProfileImage(clients.indexOf(client), 31));

        VBox headingText = new VBox(3);
        headingText.getChildren().addAll(
                label("Assign task", 22, TEXT, true),
                label("Create a focused action for " + client.name, 11, MUTED, false)
        );
        heading.getChildren().add(headingText);

        TextField task = field("e.g. Complete lower body strength session");

        ComboBox<String> category = new ComboBox<>();
        category.getItems().addAll("Workout", "Nutrition", "Recovery", "Progress check-in");
        category.setValue("Workout");
        category.setMaxWidth(Double.MAX_VALUE);
        styleInput(category);

        DatePicker due = new DatePicker();
        due.setPromptText("Select due date");
        due.setMaxWidth(Double.MAX_VALUE);
        styleInput(due);

        TextArea instructions = new TextArea();
        instructions.setPromptText("Add clear instructions, sets/reps, intensity guidance, or notes for your client...");
        instructions.setPrefRowCount(5);
        instructions.setWrapText(true);
        styleInput(instructions);

        CheckBox reminder = new CheckBox("Send a reminder 2 hours before the due time");
        reminder.setSelected(true);
        reminder.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:11px;"
        );

        Label hint = label(
                "The client will see the assigned task in their trainer communication area.",
                10, MUTED, false
        );

        Button send = primaryButton("Assign task & notify client");
        send.setMaxWidth(Double.MAX_VALUE);
        send.setOnAction(e -> {
            if (task.getText().trim().isEmpty()) {
                task.setStyle(
                        "-fx-background-color:" + CARD_ALT + ";" +
                        "-fx-text-fill:" + TEXT + ";" +
                        "-fx-prompt-text-fill:#6e8173;" +
                        "-fx-border-color:#ff8d8d;" +
                        "-fx-border-radius:10;" +
                        "-fx-background-radius:10;" +
                        "-fx-font-size:12px;"
                );
                task.requestFocus();
                return;
            }

            showTaskAssignedState(body, client, task.getText().trim());
        });

        body.getChildren().addAll(
                heading,
                formLabel("TASK TITLE"), task,
                formLabel("CATEGORY"), category,
                formLabel("DUE DATE"), due,
                formLabel("INSTRUCTIONS"), instructions,
                reminder,
                hint,
                send
        );

        pane.setContent(body);
        dialog.showAndWait();
    }

    private void showTaskAssignedState(VBox body, ClientProfile client, String taskTitle) {
        body.getChildren().clear();
        body.setAlignment(Pos.CENTER);
        body.setPadding(new Insets(30));

        Label check = label("✓", 42, PRIMARY, true);
        StackPane checkBox = new StackPane(check);
        checkBox.setMinSize(72, 72);
        checkBox.setPrefSize(72, 72);
        checkBox.setMaxSize(72, 72);
        checkBox.setStyle(
                "-fx-background-color:rgba(117,255,158,0.12);" +
                "-fx-background-radius:36;" +
                "-fx-border-color:rgba(117,255,158,0.30);" +
                "-fx-border-radius:36;"
        );

        Label title = label("Task assigned", 24, TEXT, true);
        title.setAlignment(Pos.CENTER);

        Label detail = label(
                "\"" + taskTitle + "\" has been assigned to " + client.name + ".",
                12, MUTED, false
        );
        detail.setMaxWidth(440);
        detail.setAlignment(Pos.CENTER);
        detail.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Label closeHint = label("Use Back to My Clients to return to the roster.", 10, MUTED, false);
        closeHint.setAlignment(Pos.CENTER);

        body.getChildren().addAll(checkBox, title, detail, closeHint);
    }

    // =========================================================
    // SMALL HELPERS
    // =========================================================

    private Label formLabel(String text) {
        return label(text, 10, MUTED, true);
    }

    private TextField field(String prompt) {
        TextField field = new TextField();
        field.setPromptText(prompt);
        styleInput(field);
        return field;
    }

    private void styleInput(Control control) {
        control.setStyle(
                "-fx-background-color:" + CARD_ALT + ";" +
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-prompt-text-fill:#6e8173;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:10;" +
                "-fx-background-radius:10;" +
                "-fx-font-size:12px;" +
                "-fx-padding:9 11;"
        );
    }

    private Label section(String text) {
        return label(text, 10, PRIMARY, true);
    }

    private Label label(String text, int size, String color, boolean bold) {
        Label label = new Label(text);
        label.setWrapText(true);
        label.setStyle(
                "-fx-text-fill:" + color + ";" +
                "-fx-font-size:" + size + "px;" +
                "-fx-font-weight:" + (bold ? "bold" : "normal") + ";"
        );
        return label;
    }

    private Label badge(String text, String color) {
        Label label = label(text, 10, color, true);
        label.setStyle(label.getStyle() +
                "-fx-background-color:rgba(117,255,158,0.12);" +
                "-fx-background-radius:12;" +
                "-fx-padding:5 9;"
        );
        return label;
    }

    private Button primaryButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color:" + PRIMARY + ";" +
                "-fx-text-fill:#062310;" +
                "-fx-font-size:11px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:12;" +
                "-fx-padding:10 16;" +
                "-fx-cursor:hand;"
        );
        return button;
    }

    private Button secondaryButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color:#121f18;" +
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:12;" +
                "-fx-background-radius:12;" +
                "-fx-font-size:11px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:9 15;" +
                "-fx-cursor:hand;"
        );
        return button;
    }

    private String cardStyle() {
        return "-fx-background-color:" + CARD + ";" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-width:1;";
    }

    private void addTwoColumnConstraints(GridPane grid) {
        grid.getColumnConstraints().clear();
        for (int i = 0; i < 2; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(50);
            column.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(column);
        }
    }

   

    // =========================================================
    // PROFILE IMAGE GENERATOR
    // =========================================================

    /**
     * Creates a local profile illustration. This is an actual ImageView, but
     * no PNG/JPG resource is needed, so there is no missing-resource failure.
     */
    private ImageView createProfileImage(int index, double radius) {
        int size = Math.max(64, (int) Math.ceil(radius * 2.0));
        WritableImage image = new WritableImage(size, size);
        javafx.scene.image.PixelWriter writer = image.getPixelWriter();

        Color background = Color.web(AVATAR_BACKGROUNDS[index % AVATAR_BACKGROUNDS.length]);
        Color skin = Color.web(SKIN_TONES[index % SKIN_TONES.length]);
        Color hair = Color.web(HAIR_COLORS[index % HAIR_COLORS.length]);
        Color shirt = Color.web(SHIRT_COLORS[index % SHIRT_COLORS.length]);

        double cx = size / 2.0;
        double cy = size / 2.0;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                double dx = x - cx;
                double dy = y - cy;
                if (Math.sqrt(dx * dx + dy * dy) <= size * 0.50) {
                    writer.setColor(x, y, background);
                } else {
                    writer.setColor(x, y, Color.TRANSPARENT);
                }
            }
        }

        // Neck.
        paintEllipse(writer, size, cx, cy + size * 0.16, size * 0.12, size * 0.17, skin);

        // Shirt / shoulders.
        paintEllipse(writer, size, cx, cy + size * 0.42, size * 0.38, size * 0.27, shirt);

        // Face.
        paintEllipse(writer, size, cx, cy - size * 0.02, size * 0.22, size * 0.27, skin);

        // Hair cap.
        paintEllipse(writer, size, cx, cy - size * 0.18, size * 0.23, size * 0.17, hair);

        // Ears.
        paintEllipse(writer, size, cx - size * 0.22, cy - size * 0.01, size * 0.045, size * 0.07, skin);
        paintEllipse(writer, size, cx + size * 0.22, cy - size * 0.01, size * 0.045, size * 0.07, skin);

        // Eyes.
        Color eye = Color.web("#16201b");
        paintEllipse(writer, size, cx - size * 0.075, cy - size * 0.03, size * 0.022, size * 0.018, eye);
        paintEllipse(writer, size, cx + size * 0.075, cy - size * 0.03, size * 0.022, size * 0.018, eye);

        // Small smile.
        paintEllipse(writer, size, cx, cy + size * 0.085, size * 0.065, size * 0.018, Color.web("#7d4639"));

        ImageView view = new ImageView(image);
        view.setFitWidth(radius * 2);
        view.setFitHeight(radius * 2);
        view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setClip(new Circle(radius, radius, radius));
        view.setStyle("-fx-effect:dropshadow(gaussian, rgba(0,0,0,0.30), 7, 0, 0, 2);");
        return view;
    }

    private void paintEllipse(
            javafx.scene.image.PixelWriter writer,
            int size,
            double cx,
            double cy,
            double rx,
            double ry,
            Color color
    ) {
        int minX = Math.max(0, (int) Math.floor(cx - rx - 1));
        int maxX = Math.min(size - 1, (int) Math.ceil(cx + rx + 1));
        int minY = Math.max(0, (int) Math.floor(cy - ry - 1));
        int maxY = Math.min(size - 1, (int) Math.ceil(cy + ry + 1));

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                double nx = (x - cx) / rx;
                double ny = (y - cy) / ry;
                if (nx * nx + ny * ny <= 1.0) {
                    writer.setColor(x, y, color);
                }
            }
        }
    }

    // =========================================================
    // DEMO ROSTER - 48 TRAINER-SAFE PROFILES
    // =========================================================

    private List<ClientProfile> buildDemoClients() {
        List<ClientProfile> data = new ArrayList<>();
        data.addAll(Arrays.asList(
                new ClientProfile("Rahul Mehta", "Muscle Gain", "72%", "24 sessions", "Strength Phase", "Hypertrophy", "Mile 12"),
                new ClientProfile("Priya Sharma", "Weight Loss", "68%", "18 sessions", "Fat Loss Cycle", "Functional Conditioning", "Phase 4"),
                new ClientProfile("Aman Verma", "Strength & Conditioning", "80%", "20 sessions", "Performance Build", "Mobility + Lift", "Month 3"),
                new ClientProfile("Neha Patil", "General Fitness", "60%", "16 sessions", "Consistency Plan", "Core + Cardio", "Week 5"),
                new ClientProfile("Karan Singh", "Hypertrophy", "75%", "22 sessions", "Lean Mass Build", "Strength Lift", "Stage 2"),
                new ClientProfile("Shreya Iyer", "Fat Loss", "65%", "12 sessions", "Cut Phase", "HIIT + Core", "Week 6"),
                new ClientProfile("Vikram Rao", "Strength Gain", "81%", "26 sessions", "Power Build", "Olympic Lift", "Advanced"),
                new ClientProfile("Meera Joshi", "Body Recomposition", "71%", "17 sessions", "Transformation", "Intervals + Strength", "Phase 3"),
                new ClientProfile("Rohit Nair", "Muscle Gain", "79%", "19 sessions", "Bulk Plan", "Heavy Lift", "Progressing"),
                new ClientProfile("Ananya Sen", "General Fitness", "59%", "15 sessions", "Foundation", "Strength + Mobility", "Week 4"),
                new ClientProfile("Deepak Shah", "Weight Loss", "69%", "18 sessions", "Metabolic Reset", "Cardio Circuit", "Phase 2"),
                new ClientProfile("Isha Kulkarni", "Athletic Conditioning", "87%", "28 sessions", "Performance Push", "Sprint + Core", "Elite"),
                new ClientProfile("Siddharth Nanda", "Core Strength", "74%", "21 sessions", "Stability Plan", "Core Lift", "Cycle 2"),
                new ClientProfile("Pooja Kale", "Mobility", "63%", "11 sessions", "Recovery Focus", "Mobility Flow", "Adjustment"),
                new ClientProfile("Harsh Malhotra", "Body Sculpting", "73%", "20 sessions", "Definition Plan", "Circuit + Lift", "Month 2"),
                new ClientProfile("Nisha Khanna", "Low Impact Cardio", "62%", "14 sessions", "Cardio Reset", "Low Impact", "Week 4"),
                new ClientProfile("Yash Patel", "Strength Gain", "84%", "25 sessions", "Performance Block", "Heavy Press", "Peak"),
                new ClientProfile("Aditi Desai", "Functional Fitness", "66%", "16 sessions", "Movement Quality", "Functional Circuit", "Stage 2"),
                new ClientProfile("Rishi Kapoor", "Muscle Gain", "77%", "23 sessions", "Mass Build", "Leg + Push", "Progress"),
                new ClientProfile("Tanvi Singh", "Fat Loss", "67%", "13 sessions", "Cut Plan", "HIIT + Strength", "Week 3"),
                new ClientProfile("Arjun Menon", "Athletic Performance", "88%", "30 sessions", "Sprint Block", "Explosive Lift", "Elite"),
                new ClientProfile("Smriti Shah", "Lifestyle Fitness", "58%", "12 sessions", "Habit Stack", "Circuit + Mobility", "Adjustment"),
                new ClientProfile("Varun Bhatia", "Lean Muscle", "76%", "22 sessions", "Build Cycle", "Upper Body Lift", "Consistency"),
                new ClientProfile("Divya Nair", "Endurance", "72%", "18 sessions", "Cardio Capacity", "Tempo Run", "Plateau Break"),
                new ClientProfile("Manav Patel", "Functional Strength", "82%", "24 sessions", "Stability Block", "Strength + Mobility", "Progressing"),
                new ClientProfile("Jiya Khurana", "Posture Correction", "61%", "10 sessions", "Mobility Reset", "Desk Rehab", "Week 4"),
                new ClientProfile("Kunal Shah", "Powerlifting", "85%", "29 sessions", "Performance Lift", "Heavy Squat", "Advanced"),
                new ClientProfile("Bhavya Gupta", "General Fitness", "70%", "17 sessions", "Foundation Plan", "Strength + Cardio", "Stable"),
                new ClientProfile("Nakul Reddy", "Weight Loss", "64%", "15 sessions", "Fat Burner", "Interval Cardio", "Adjusting"),
                new ClientProfile("Tanya Verma", "Body Toning", "78%", "21 sessions", "Tone Phase", "Circuit + Lift", "Strong"),
                new ClientProfile("Aditya Iyer", "Muscle Gain", "83%", "27 sessions", "Mass Block", "Leg Press + Pull", "Peak"),
                new ClientProfile("Riya Mehta", "Weight Loss", "74%", "19 sessions", "Cut Focus", "Cardio + Lift", "Progressing"),
                new ClientProfile("Zaid Qureshi", "Strength Conditioning", "80%", "24 sessions", "Conditioning Plan", "Sprint + Lift", "Strong"),
                new ClientProfile("Leah Thomas", "General Fitness", "68%", "14 sessions", "Movement Base", "Circuit Training", "Steady"),
                new ClientProfile("Jayant Joshi", "Lean Muscle", "72%", "18 sessions", "Build Plan", "Upper + Lower", "Strong"),
                new ClientProfile("Sakshi Singh", "Recovery", "57%", "9 sessions", "Recovery Reset", "Mobility + Breath", "Week 2"),
                new ClientProfile("Omkar Patil", "Powerlifting", "86%", "31 sessions", "Strength Peak", "Squat + Deadlift", "Elite"),
                new ClientProfile("Mitali Das", "Core & Balance", "65%", "13 sessions", "Balance Block", "Core Circuit", "Week 5"),
                new ClientProfile("Rohan Bansal", "Athletic Fitness", "79%", "23 sessions", "Performance Lift", "Sprint + Strength", "Progress"),
                new ClientProfile("Ankita Bose", "Body Sculpting", "71%", "17 sessions", "Definition Build", "Circuit + Core", "Steady"),
                new ClientProfile("Vivaan Kapoor", "Strength Shift", "76%", "20 sessions", "Stability Lift", "Compound Pull", "Phase 3"),
                new ClientProfile("Pallavi Nair", "General Fitness", "69%", "16 sessions", "Foundations", "Core + Cardio", "Stable"),
                new ClientProfile("Shubham Jain", "Hybrid Training", "81%", "26 sessions", "Hybrid Block", "Strength + Intervals", "Peak"),
                new ClientProfile("Esha Mallick", "Fat Loss", "66%", "15 sessions", "Reduction Phase", "Cardio + Core", "Week 6"),
                new ClientProfile("Kabir Verma", "Muscle Gain", "75%", "22 sessions", "Mass Plan", "Pull + Legs", "Progressing"),
                new ClientProfile("Noor Khan", "Low Impact Fitness", "60%", "11 sessions", "Joint Friendly", "Low Impact Circuit", "Balanced"),
                new ClientProfile("Gaurav Sethi", "Body Composition", "73%", "19 sessions", "Shape Phase", "Strength + HIIT", "Turning point"),
                new ClientProfile("Alex Morgan", "Elite Performance", "91%", "32 sessions", "Elite Performance", "Strength + Speed", "Peak")
        ));
        return data;
    }

    // =========================================================
    // MODEL
    // =========================================================

    private static final class ClientProfile {
        private final String name;
        private final String goal;
        private final String progressValue;
        private final String training;
        private final String program;
        private final String detailType;
        private final String stage;

        private ClientProfile(
                String name,
                String goal,
                String progressValue,
                String training,
                String program,
                String detailType,
                String stage
        ) {
            this.name = name;
            this.goal = goal;
            this.progressValue = progressValue;
            this.training = training;
            this.program = program;
            this.detailType = detailType;
            this.stage = stage;
        }

        private double progress() {
            try {
                return Math.max(0.0, Math.min(1.0,
                        Double.parseDouble(progressValue.replace("%", "")) / 100.0));
            } catch (NumberFormatException ex) {
                return 0.0;
            }
        }
    }
}
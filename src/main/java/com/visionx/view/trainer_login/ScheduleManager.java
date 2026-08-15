package com.visionx.view.trainer_login;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import javafx.scene.effect.DropShadow;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * FITNEESFREAK
 * Trainer - Schedule Manager
 *
 * FIXED VERSION
 *
 * - Reliable schedule rendering
 * - Rich Add Session modal
 * - No popup X / cross button
 * - Back to Schedule
 * - Working calendar
 * - Working View All
 * - Working Today / Previous / Next
 * - Modal overlay stays inside same Scene
 */
public class ScheduleManager {

    // =========================================================
    // SCENE
    // =========================================================

    private Scene scheduleScene;

    private StackPane rootLayer;
    private BorderPane mainRoot;

    private VBox schedulePage;
    private VBox allSessionsPage;

    private Runnable backToDashboardAction;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG_COLOR = "#08110B";
    private final String CARD_BG = "#050D18";
    private final String CARD_BG_2 = "#081321";

    private final String PRIMARY = "#75FF9E";
    private final String PRIMARY_HOVER = "#9CFFB8";

    private final String PRIMARY_DIM = "rgba(117,255,158,0.10)";
    private final String PRIMARY_BORDER = "rgba(117,255,158,0.22)";

    private final String BORDER = "rgba(255,255,255,0.09)";

    private final String TEXT_MAIN = "#E7F0E6";
    private final String TEXT_MUTED = "#9EAEA0";

    private final String BLUE = "#55C7FF";
    private final String WARNING = "#FACC15";
    private final String RED = "#FF7070";

    // =========================================================
    // DATE STATE
    // =========================================================

    private LocalDate selectedDate = LocalDate.now();
    private YearMonth displayedMonth = YearMonth.from(selectedDate);

    private Label selectedDateLabel;
    private Label monthLabel;

    // =========================================================
    // SHADOW
    // =========================================================

    private final DropShadow glassShadow =
            new DropShadow(
                    25,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.40)
            );

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getScheduleManagerScene(Runnable callBackAction) {

        this.backToDashboardAction = callBackAction;

        // ---------------------------------------------------------
        // MAIN ROOT
        // ---------------------------------------------------------

        mainRoot = new BorderPane();

        mainRoot.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainRoot.setStyle(
                "-fx-background-color: " + BG_COLOR + ";"
                        + "-fx-font-family: 'Segoe UI';"
        );

        // ---------------------------------------------------------
        // SCHEDULE PAGE
        // ---------------------------------------------------------

        schedulePage = createSchedulePage();

        ScrollPane scheduleScroll =
                createTransparentScroll(schedulePage);

        mainRoot.setCenter(scheduleScroll);

        // ---------------------------------------------------------
        // ROOT LAYER
        // ---------------------------------------------------------

        rootLayer = new StackPane();

        rootLayer.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        rootLayer.setStyle(
                "-fx-background-color: " + BG_COLOR + ";"
        );

        rootLayer.getChildren().add(mainRoot);

        // ---------------------------------------------------------
        // SCENE
        // ---------------------------------------------------------

        scheduleScene = new Scene(
                rootLayer,
                1200,
                900
        );

        return scheduleScene;
    }

    // =========================================================
    // SCHEDULE PAGE
    // =========================================================

    private VBox createSchedulePage() {

        VBox content = new VBox(22);

        content.setPadding(
                new Insets(
                        30,
                        34,
                        40,
                        34
                )
        );

        content.setFillWidth(true);

        content.setMaxWidth(1280);

        // ---------------------------------------------------------
        // HEADER
        // ---------------------------------------------------------

        HBox header = createHeader();

        // ---------------------------------------------------------
        // CONTROL BAR
        // ---------------------------------------------------------

        HBox controls = createControlBar();

        // ---------------------------------------------------------
        // BODY
        // ---------------------------------------------------------

        HBox mainArea = new HBox(20);

        mainArea.setFillHeight(true);

        VBox calendar = createCalendar();

        VBox appointments = createAppointments();

        HBox.setHgrow(
                appointments,
                Priority.ALWAYS
        );

        mainArea.getChildren().addAll(
                calendar,
                appointments
        );

        // ---------------------------------------------------------
        // UPCOMING
        // ---------------------------------------------------------

        VBox upcoming = createUpcomingSchedule();

        content.getChildren().addAll(
                header,
                controls,
                mainArea,
                upcoming
        );

        // IMPORTANT:
        // Directly return content.
        // No extra VBox -> StackPane -> VBox nesting.
        return content;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createHeader() {

        HBox header = new HBox();

        header.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);

        Label breadcrumb =
                new Label("Schedule  ›  Manager");

        breadcrumb.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 12px;"
        );

        Label title =
                new Label("Schedule Manager");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 30px;"
                        + "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Manage your training sessions, client appointments and daily schedule."
                );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 14px;"
        );

        titleBox.getChildren().addAll(
                breadcrumb,
                title,
                subtitle
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button addSession =
                createPrimaryButton("＋  Add Session");

        addSession.setOnAction(
                e -> showAddSessionPopup()
        );

        header.getChildren().addAll(
                titleBox,
                spacer,
                addSession
        );

        return header;
    }

    // =========================================================
    // CONTROL BAR
    // =========================================================

    private HBox createControlBar() {

        HBox bar = new HBox(10);

        bar.setAlignment(Pos.CENTER_LEFT);

        bar.setPadding(
                new Insets(
                        12,
                        14,
                        12,
                        14
                )
        );

        bar.setStyle(
                "-fx-background-color: " + CARD_BG + ";"
                        + "-fx-background-radius: 15;"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 15;"
        );

        Button previous =
                createNavigationButton("‹");

        Button next =
                createNavigationButton("›");

        selectedDateLabel =
                new Label(
                        formatLongDate(selectedDate)
                );

        selectedDateLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 14px;"
                        + "-fx-font-weight: bold;"
        );

        Button calendarButton =
                createIconButton("▣");

        calendarButton.setTooltip(
                new Tooltip("Choose date")
        );

        calendarButton.setOnAction(
                e -> showCalendarPopup()
        );

        Button today =
                new Button("Today");

        today.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";"
                        + "-fx-border-color: " + PRIMARY_BORDER + ";"
                        + "-fx-border-radius: 9;"
                        + "-fx-background-radius: 9;"
                        + "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-weight: bold;"
                        + "-fx-padding: 8 14;"
                        + "-fx-cursor: hand;"
        );

        today.setOnAction(
                e -> {

                    selectedDate = LocalDate.now();
                    displayedMonth =
                            YearMonth.from(selectedDate);

                    rebuildSchedulePage();
                }
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        TextField search =
                new TextField();

        search.setPromptText(
                "Search client..."
        );

        search.setPrefWidth(200);

        search.setStyle(
                "-fx-background-color: rgba(255,255,255,0.035);"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 9;"
                        + "-fx-background-radius: 9;"
                        + "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-prompt-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-padding: 9 12;"
        );

        previous.setOnAction(
                e -> {

                    selectedDate =
                            selectedDate.minusDays(1);

                    displayedMonth =
                            YearMonth.from(selectedDate);

                    rebuildSchedulePage();
                }
        );

        next.setOnAction(
                e -> {

                    selectedDate =
                            selectedDate.plusDays(1);

                    displayedMonth =
                            YearMonth.from(selectedDate);

                    rebuildSchedulePage();
                }
        );

        bar.getChildren().addAll(
                previous,
                selectedDateLabel,
                calendarButton,
                next,
                today,
                spacer,
                search
        );

        return bar;
    }

    // =========================================================
    // CALENDAR
    // =========================================================

    private VBox createCalendar() {

        VBox card = new VBox(15);

        card.setPrefWidth(430);
        card.setMinWidth(380);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";"
                        + "-fx-background-radius: 18;"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 18;"
        );

        card.setEffect(glassShadow);

        HBox heading = new HBox();

        heading.setAlignment(Pos.CENTER_LEFT);

        monthLabel =
                new Label(
                        displayedMonth.format(
                                DateTimeFormatter.ofPattern(
                                        "MMMM yyyy"
                                )
                        )
                );

        monthLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 17px;"
                        + "-fx-font-weight: bold;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button monthBack =
                createMiniIconButton("‹");

        Button monthNext =
                createMiniIconButton("›");

        monthBack.setOnAction(
                e -> {

                    displayedMonth =
                            displayedMonth.minusMonths(1);

                    rebuildSchedulePage();
                }
        );

        monthNext.setOnAction(
                e -> {

                    displayedMonth =
                            displayedMonth.plusMonths(1);

                    rebuildSchedulePage();
                }
        );

        heading.getChildren().addAll(
                monthLabel,
                spacer,
                monthBack,
                monthNext
        );

        GridPane calendarGrid =
                new GridPane();

        calendarGrid.setHgap(6);
        calendarGrid.setVgap(8);
        calendarGrid.setAlignment(Pos.CENTER);

        buildCalendarGrid(calendarGrid);

        Label note =
                new Label(
                        "● Scheduled     ● Available     ● Selected"
                );

        note.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 10px;"
        );

        card.getChildren().addAll(
                heading,
                calendarGrid,
                note
        );

        return card;
    }

    // =========================================================
    // BUILD CALENDAR
    // =========================================================

    private void buildCalendarGrid(GridPane grid) {

        grid.getChildren().clear();

        String[] days = {
                "MON",
                "TUE",
                "WED",
                "THU",
                "FRI",
                "SAT",
                "SUN"
        };

        for (int i = 0; i < days.length; i++) {

            Label day =
                    new Label(days[i]);

            day.setPrefWidth(50);

            day.setAlignment(
                    Pos.CENTER
            );

            day.setStyle(
                    "-fx-text-fill: " + TEXT_MUTED + ";"
                            + "-fx-font-size: 9px;"
                            + "-fx-font-weight: bold;"
            );

            grid.add(
                    day,
                    i,
                    0
            );
        }

        LocalDate first =
                displayedMonth.atDay(1);

        int firstColumn =
                first.getDayOfWeek().getValue() - 1;

        int daysInMonth =
                displayedMonth.lengthOfMonth();

        for (
                int dayNumber = 1;
                dayNumber <= daysInMonth;
                dayNumber++
        ) {

            int index =
                    firstColumn + dayNumber - 1;

            int row =
                    index / 7 + 1;

            int col =
                    index % 7;

            LocalDate date =
                    displayedMonth.atDay(dayNumber);

            Button dayButton =
                    new Button(
                            String.valueOf(dayNumber)
                    );

            dayButton.setPrefSize(
                    50,
                    42
            );

            boolean selected =
                    date.equals(selectedDate);

            boolean today =
                    date.equals(LocalDate.now());

            if (selected) {

                dayButton.setStyle(
                        "-fx-background-color: " + PRIMARY + ";"
                                + "-fx-text-fill: #003918;"
                                + "-fx-background-radius: 10;"
                                + "-fx-font-weight: bold;"
                                + "-fx-cursor: hand;"
                );

            } else if (today) {

                dayButton.setStyle(
                        "-fx-background-color: rgba(117,255,158,0.08);"
                                + "-fx-border-color: " + PRIMARY + ";"
                                + "-fx-border-radius: 10;"
                                + "-fx-background-radius: 10;"
                                + "-fx-text-fill: " + PRIMARY + ";"
                                + "-fx-font-weight: bold;"
                                + "-fx-cursor: hand;"
                );

            } else {

                dayButton.setStyle(
                        "-fx-background-color: transparent;"
                                + "-fx-text-fill: " + TEXT_MAIN + ";"
                                + "-fx-background-radius: 10;"
                                + "-fx-cursor: hand;"
                );
            }

            dayButton.setOnAction(
                    e -> {

                        selectedDate = date;
                        displayedMonth =
                                YearMonth.from(date);

                        rebuildSchedulePage();
                    }
            );

            grid.add(
                    dayButton,
                    col,
                    row
            );
        }
    }

    // =========================================================
    // APPOINTMENTS
    // =========================================================

    private VBox createAppointments() {

        VBox card = new VBox(14);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";"
                        + "-fx-background-radius: 18;"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 18;"
        );

        card.setEffect(glassShadow);

        HBox heading = new HBox();

        heading.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox titleBox =
                new VBox(3);

        Label title =
                new Label("Today's Schedule");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 17px;"
                        + "-fx-font-weight: bold;"
        );

        Label count =
                new Label("5 sessions scheduled");

        count.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 11px;"
        );

        titleBox.getChildren().addAll(
                title,
                count
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button viewAll =
                new Button("View All");

        viewAll.setStyle(
                "-fx-background-color: transparent;"
                        + "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-weight: bold;"
                        + "-fx-cursor: hand;"
        );

        viewAll.setOnAction(
                e -> showAllSessionsPage()
        );

        heading.getChildren().addAll(
                titleBox,
                spacer,
                viewAll
        );

        VBox list =
                new VBox(10);

        addScheduleItem(
                list,
                "08:00 AM",
                "Alex Vance",
                "Strength Training",
                "60 min",
                PRIMARY
        );

        addScheduleItem(
                list,
                "10:00 AM",
                "Sarah Jenkins",
                "Personal Training",
                "60 min",
                BLUE
        );

        addScheduleItem(
                list,
                "01:30 PM",
                "Mark Thompson",
                "Fitness Assessment",
                "45 min",
                WARNING
        );

        addScheduleItem(
                list,
                "04:00 PM",
                "Maya Wilson",
                "HIIT Training",
                "60 min",
                PRIMARY
        );

        addScheduleItem(
                list,
                "06:00 PM",
                "Daniel Carter",
                "Strength & Conditioning",
                "60 min",
                BLUE
        );

        card.getChildren().addAll(
                heading,
                list
        );

        return card;
    }

    // =========================================================
    // SCHEDULE ITEM
    // =========================================================

    private void addScheduleItem(
            VBox parent,
            String time,
            String client,
            String session,
            String duration,
            String color
    ) {

        HBox row =
                new HBox(14);

        row.setPadding(
                new Insets(13)
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-background-color: rgba(255,255,255,0.025);"
                        + "-fx-background-radius: 12;"
                        + "-fx-border-color: rgba(255,255,255,0.05);"
                        + "-fx-border-radius: 12;"
        );

        Label timeLabel =
                new Label(time);

        timeLabel.setPrefWidth(70);

        timeLabel.setStyle(
                "-fx-text-fill: " + color + ";"
                        + "-fx-font-size: 11px;"
                        + "-fx-font-weight: bold;"
        );

        StackPane icon =
                createPersonIcon(color);

        VBox info =
                new VBox(3);

        HBox.setHgrow(
                info,
                Priority.ALWAYS
        );

        Label clientLabel =
                new Label(client);

        clientLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 13px;"
                        + "-fx-font-weight: bold;"
        );

        Label sessionLabel =
                new Label(session);

        sessionLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 11px;"
        );

        info.getChildren().addAll(
                clientLabel,
                sessionLabel
        );

        Label durationLabel =
                new Label(duration);

        durationLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 10px;"
        );

        row.getChildren().addAll(
                timeLabel,
                icon,
                info,
                durationLabel
        );

        parent.getChildren().add(row);
    }

    // =========================================================
    // UPCOMING
    // =========================================================

    private VBox createUpcomingSchedule() {

        VBox card =
                new VBox(14);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";"
                        + "-fx-background-radius: 18;"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 18;"
        );

        Label title =
                new Label("Upcoming Sessions");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 17px;"
                        + "-fx-font-weight: bold;"
        );

        HBox row =
                new HBox(12);

        row.getChildren().addAll(

                createUpcomingCard(
                        "TUE",
                        "19",
                        "Alex Vance",
                        "Strength Training",
                        "08:00 AM"
                ),

                createUpcomingCard(
                        "WED",
                        "20",
                        "Sarah Jenkins",
                        "Personal Training",
                        "10:00 AM"
                ),

                createUpcomingCard(
                        "THU",
                        "21",
                        "Mark Thompson",
                        "Fitness Assessment",
                        "01:30 PM"
                )
        );

        card.getChildren().addAll(
                title,
                row
        );

        return card;
    }

    // =========================================================
    // UPCOMING CARD
    // =========================================================

    private VBox createUpcomingCard(
            String day,
            String date,
            String client,
            String session,
            String time
    ) {

        VBox card =
                new VBox(6);

        card.setPadding(
                new Insets(14)
        );

        HBox.setHgrow(
                card,
                Priority.ALWAYS
        );

        card.setStyle(
                "-fx-background-color: rgba(255,255,255,0.025);"
                        + "-fx-background-radius: 12;"
                        + "-fx-border-color: rgba(255,255,255,0.05);"
                        + "-fx-border-radius: 12;"
        );

        HBox dateRow =
                new HBox(8);

        Label dayLabel =
                new Label(day);

        dayLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-size: 10px;"
                        + "-fx-font-weight: bold;"
        );

        Label dateLabel =
                new Label(date);

        dateLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 16px;"
                        + "-fx-font-weight: bold;"
        );

        dateRow.getChildren().addAll(
                dayLabel,
                dateLabel
        );

        Label clientLabel =
                new Label(client);

        clientLabel.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 13px;"
                        + "-fx-font-weight: bold;"
        );

        Label sessionLabel =
                new Label(session);

        sessionLabel.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 11px;"
        );

        Label timeLabel =
                new Label("◷  " + time);

        timeLabel.setStyle(
                "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-size: 11px;"
                        + "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                dateRow,
                clientLabel,
                sessionLabel,
                timeLabel
        );

        return card;
    }

    // =========================================================
    // ALL SESSIONS
    // =========================================================

    private void showAllSessionsPage() {

        allSessionsPage =
                new VBox(22);

        allSessionsPage.setPadding(
                new Insets(
                        30,
                        50,
                        40,
                        50
                )
        );

        allSessionsPage.setMaxWidth(1050);

        HBox top =
                new HBox();

        top.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox titleBox =
                new VBox(5);

        Label small =
                new Label("SCHEDULE  ›  ALL SESSIONS");

        small.setStyle(
                "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-size: 11px;"
                        + "-fx-font-weight: bold;"
        );

        Label title =
                new Label("All Training Sessions");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 28px;"
                        + "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "View and manage every scheduled training session from one place."
                );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 13px;"
        );

        titleBox.getChildren().addAll(
                small,
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button back =
                new Button("←  Back to Schedule");

        back.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";"
                        + "-fx-border-color: " + PRIMARY_BORDER + ";"
                        + "-fx-border-radius: 10;"
                        + "-fx-background-radius: 10;"
                        + "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-weight: bold;"
                        + "-fx-padding: 10 16;"
                        + "-fx-cursor: hand;"
        );

        back.setOnAction(
                e -> showSchedulePage()
        );

        top.getChildren().addAll(
                titleBox,
                spacer,
                back
        );

        HBox stats =
                new HBox(14);

        stats.getChildren().addAll(
                createStatCard(
                        "05",
                        "Today's Sessions",
                        PRIMARY
                ),
                createStatCard(
                        "32",
                        "This Month",
                        BLUE
                ),
                createStatCard(
                        "18",
                        "Active Clients",
                        WARNING
                )
        );

        VBox listCard =
                new VBox(10);

        listCard.setPadding(
                new Insets(20)
        );

        listCard.setStyle(
                "-fx-background-color: " + CARD_BG + ";"
                        + "-fx-background-radius: 18;"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 18;"
        );

        Label listTitle =
                new Label("Session Overview");

        listTitle.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 17px;"
                        + "-fx-font-weight: bold;"
        );

        listCard.getChildren().add(
                listTitle
        );

        addFullSession(
                listCard,
                "MON 18 NOV",
                "08:00 AM",
                "Alex Vance",
                "Strength Training",
                PRIMARY
        );

        addFullSession(
                listCard,
                "MON 18 NOV",
                "10:00 AM",
                "Sarah Jenkins",
                "Personal Training",
                BLUE
        );

        addFullSession(
                listCard,
                "MON 18 NOV",
                "01:30 PM",
                "Mark Thompson",
                "Fitness Assessment",
                WARNING
        );

        addFullSession(
                listCard,
                "MON 18 NOV",
                "04:00 PM",
                "Maya Wilson",
                "HIIT Training",
                PRIMARY
        );

        addFullSession(
                listCard,
                "MON 18 NOV",
                "06:00 PM",
                "Daniel Carter",
                "Strength & Conditioning",
                BLUE
        );

        allSessionsPage.getChildren().addAll(
                top,
                stats,
                listCard
        );

        mainRoot.setCenter(
                createTransparentScroll(
                        allSessionsPage
                )
        );
    }

    // =========================================================
    // FULL SESSION
    // =========================================================

    private void addFullSession(
            VBox parent,
            String date,
            String time,
            String client,
            String type,
            String color
    ) {

        HBox row =
                new HBox(15);

        row.setPadding(
                new Insets(14)
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-background-color: rgba(255,255,255,0.025);"
                        + "-fx-background-radius: 12;"
                        + "-fx-border-color: rgba(255,255,255,0.06);"
                        + "-fx-border-radius: 12;"
        );

        VBox dateBox =
                new VBox(2);

        Label d =
                new Label(date);

        d.setStyle(
                "-fx-text-fill: " + color + ";"
                        + "-fx-font-size: 10px;"
                        + "-fx-font-weight: bold;"
        );

        Label t =
                new Label(time);

        t.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 13px;"
                        + "-fx-font-weight: bold;"
        );

        dateBox.getChildren().addAll(
                d,
                t
        );

        dateBox.setPrefWidth(110);

        StackPane icon =
                createPersonIcon(color);

        VBox info =
                new VBox(3);

        HBox.setHgrow(
                info,
                Priority.ALWAYS
        );

        Label c =
                new Label(client);

        c.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 14px;"
                        + "-fx-font-weight: bold;"
        );

        Label s =
                new Label(type);

        s.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 11px;"
        );

        info.getChildren().addAll(
                c,
                s
        );

        Label status =
                new Label("Scheduled");

        status.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";"
                        + "-fx-background-radius: 8;"
                        + "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-padding: 6 10;"
                        + "-fx-font-size: 10px;"
                        + "-fx-font-weight: bold;"
        );

        row.getChildren().addAll(
                dateBox,
                icon,
                info,
                status
        );

        parent.getChildren().add(row);
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String number,
            String title,
            String color
    ) {

        VBox card =
                new VBox(5);

        card.setPadding(
                new Insets(18)
        );

        HBox.setHgrow(
                card,
                Priority.ALWAYS
        );

        card.setStyle(
                "-fx-background-color: " + CARD_BG + ";"
                        + "-fx-background-radius: 15;"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 15;"
        );

        Label n =
                new Label(number);

        n.setStyle(
                "-fx-text-fill: " + color + ";"
                        + "-fx-font-size: 25px;"
                        + "-fx-font-weight: bold;"
        );

        Label t =
                new Label(title);

        t.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                n,
                t
        );

        return card;
    }

    // =========================================================
    // ADD SESSION POPUP
    // =========================================================

    private void showAddSessionPopup() {

        StackPane overlay =
                createModalOverlay();

        VBox modal =
                new VBox(16);

        modal.setPrefWidth(560);
        modal.setMaxWidth(560);
        modal.setPadding(
                new Insets(28)
        );

        modal.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0C1D20, #07130F);"
                        + "-fx-background-radius: 24;"
                        + "-fx-border-color: rgba(117,255,158,0.30);"
                        + "-fx-border-radius: 24;"
        );

        modal.setEffect(
                new DropShadow(
                        45,
                        0,
                        18,
                        Color.color(0, 0, 0, 0.75)
                )
        );

        // ---------------------------------------------------------
        // HEADER
        // ---------------------------------------------------------

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox titleBox =
                new VBox(5);

        Label small =
                new Label("NEW TRAINING SESSION");

        small.setStyle(
                "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-size: 10px;"
                        + "-fx-font-weight: bold;"
        );

        Label title =
                new Label("Add Session");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 25px;"
                        + "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Create a new appointment for your client."
                );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 12px;"
        );

        titleBox.getChildren().addAll(
                small,
                title,
                subtitle
        );

        Region headerSpacer =
                new Region();

        HBox.setHgrow(
                headerSpacer,
                Priority.ALWAYS
        );

        // NO X BUTTON HERE

        header.getChildren().addAll(
                titleBox,
                headerSpacer
        );

        // ---------------------------------------------------------
        // CLIENT
        // ---------------------------------------------------------

        Label clientLabel =
                createFieldLabel("CLIENT");

        ComboBox<String> client =
                new ComboBox<>();

        client.getItems().addAll(
                "Alex Vance",
                "Sarah Jenkins",
                "Mark Thompson",
                "Maya Wilson",
                "Daniel Carter"
        );

        client.setPromptText(
                "Select client"
        );

        client.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(client);

        // ---------------------------------------------------------
        // SESSION TYPE
        // ---------------------------------------------------------

        Label typeLabel =
                createFieldLabel("SESSION TYPE");

        ComboBox<String> sessionType =
                new ComboBox<>();

        sessionType.getItems().addAll(
                "Strength Training",
                "Personal Training",
                "Fitness Assessment",
                "HIIT Training",
                "Strength & Conditioning"
        );

        sessionType.setPromptText(
                "Select training type"
        );

        sessionType.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(sessionType);

        // ---------------------------------------------------------
        // DATE + TIME
        // ---------------------------------------------------------

        HBox dateTime =
                new HBox(12);

        VBox dateBox =
                new VBox(7);

        HBox.setHgrow(
                dateBox,
                Priority.ALWAYS
        );

        Label dateLabel =
                createFieldLabel("DATE");

        TextField date =
                createInput(
                        selectedDate.format(
                                DateTimeFormatter.ofPattern(
                                        "dd MMM yyyy"
                                )
                        )
                );

        date.setEditable(false);

        dateBox.getChildren().addAll(
                dateLabel,
                date
        );

        VBox timeBox =
                new VBox(7);

        HBox.setHgrow(
                timeBox,
                Priority.ALWAYS
        );

        Label timeLabel =
                createFieldLabel("TIME");

        ComboBox<String> time =
                new ComboBox<>();

        time.getItems().addAll(
                "08:00 AM",
                "09:00 AM",
                "10:00 AM",
                "11:00 AM",
                "01:30 PM",
                "03:00 PM",
                "04:00 PM",
                "06:00 PM"
        );

        time.setPromptText(
                "Choose time"
        );

        time.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(time);

        timeBox.getChildren().addAll(
                timeLabel,
                time
        );

        dateTime.getChildren().addAll(
                dateBox,
                timeBox
        );

        // ---------------------------------------------------------
        // DURATION
        // ---------------------------------------------------------

        Label durationLabel =
                createFieldLabel("DURATION");

        ComboBox<String> duration =
                new ComboBox<>();

        duration.getItems().addAll(
                "30 minutes",
                "45 minutes",
                "60 minutes",
                "90 minutes",
                "120 minutes"
        );

        duration.setPromptText(
                "Select duration"
        );

        duration.setMaxWidth(
                Double.MAX_VALUE
        );

        styleComboBox(duration);

        // ---------------------------------------------------------
        // VALIDATION MESSAGE
        // ---------------------------------------------------------

        Label validation =
                new Label();

        validation.setWrapText(true);

        validation.setVisible(false);
        validation.setManaged(false);

        validation.setStyle(
                "-fx-text-fill: " + RED + ";"
                        + "-fx-background-color: rgba(255,112,112,0.10);"
                        + "-fx-border-color: rgba(255,112,112,0.20);"
                        + "-fx-border-radius: 10;"
                        + "-fx-background-radius: 10;"
                        + "-fx-padding: 10 12;"
                        + "-fx-font-size: 11px;"
        );

        // ---------------------------------------------------------
        // BUTTONS
        // ---------------------------------------------------------

        HBox buttons =
                new HBox(10);

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button cancel =
                new Button("Cancel");

        cancel.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);"
                        + "-fx-border-color: rgba(255,255,255,0.10);"
                        + "-fx-border-radius: 11;"
                        + "-fx-background-radius: 11;"
                        + "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-padding: 11 20;"
                        + "-fx-font-size: 12px;"
                        + "-fx-cursor: hand;"
        );

        cancel.setOnAction(
                e -> closeOverlay(overlay)
        );

        Button save =
                createPrimaryButton(
                        "Create Session  →"
                );

        save.setOnAction(
                e -> {

                    boolean invalid =
                            client.getValue() == null
                                    || sessionType.getValue() == null
                                    || time.getValue() == null
                                    || duration.getValue() == null;

                    if (invalid) {

                        validation.setText(
                                "Please select client, session type, time and duration."
                        );

                        validation.setVisible(true);
                        validation.setManaged(true);

                        return;
                    }

                    closeOverlay(overlay);

                    showSuccessPopup(
                            client.getValue(),
                            sessionType.getValue(),
                            time.getValue(),
                            duration.getValue()
                    );
                }
        );

        buttons.getChildren().addAll(
                cancel,
                save
        );

        // ---------------------------------------------------------
        // ADD EVERYTHING
        // ---------------------------------------------------------

        modal.getChildren().addAll(
                header,
                createSeparator(),

                clientLabel,
                client,

                typeLabel,
                sessionType,

                dateTime,

                durationLabel,
                duration,

                validation,

                buttons
        );

        overlay.getChildren().add(modal);

        StackPane.setAlignment(
                modal,
                Pos.CENTER
        );

        rootLayer.getChildren().add(overlay);
    }

    // =========================================================
    // SUCCESS POPUP
    // =========================================================

    private void showSuccessPopup(
            String client,
            String type,
            String time,
            String duration
    ) {

        StackPane overlay =
                createModalOverlay();

        VBox card =
                new VBox(16);

        card.setAlignment(
                Pos.CENTER
        );

        card.setPrefWidth(450);
        card.setMaxWidth(450);

        card.setPadding(
                new Insets(32)
        );

        card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0B2118, #07151B);"
                        + "-fx-background-radius: 24;"
                        + "-fx-border-color: rgba(117,255,158,0.30);"
                        + "-fx-border-radius: 24;"
        );

        card.setEffect(
                new DropShadow(
                        45,
                        0,
                        18,
                        Color.color(0, 0, 0, 0.75)
                )
        );

        // ---------------------------------------------------------
        // SUCCESS ICON
        // ---------------------------------------------------------

        StackPane check =
                new StackPane();

        Circle outer =
                new Circle(
                        34,
                        Color.web(PRIMARY)
                );

        Circle inner =
                new Circle(
                        27,
                        Color.web("#0B2118")
                );

        Label tick =
                new Label("✓");

        tick.setStyle(
                "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-size: 28px;"
                        + "-fx-font-weight: bold;"
        );

        check.getChildren().addAll(
                outer,
                inner,
                tick
        );

        // ---------------------------------------------------------
        // TITLE
        // ---------------------------------------------------------

        Label title =
                new Label("Session Created Successfully");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 22px;"
                        + "-fx-font-weight: bold;"
        );

        // ---------------------------------------------------------
        // SUBTITLE
        // ---------------------------------------------------------

        Label subtitle =
                new Label(
                        "Your training appointment has been added to the schedule."
                );

        subtitle.setWrapText(true);
        subtitle.setAlignment(Pos.CENTER);

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 12px;"
        );

        // ---------------------------------------------------------
        // DETAILS CARD
        // ---------------------------------------------------------

        VBox details =
                new VBox(8);

        details.setPadding(
                new Insets(16)
        );

        details.setMaxWidth(
                Double.MAX_VALUE
        );

        details.setStyle(
                "-fx-background-color: rgba(255,255,255,0.035);"
                        + "-fx-background-radius: 14;"
                        + "-fx-border-color: rgba(255,255,255,0.07);"
                        + "-fx-border-radius: 14;"
        );

        Label clientLabel =
                createDetailRow(
                        "CLIENT",
                        client
                );

        Label typeLabel =
                createDetailRow(
                        "SESSION",
                        type
                );

        Label timeLabel =
                createDetailRow(
                        "TIME",
                        time
                );

        Label durationLabel =
                createDetailRow(
                        "DURATION",
                        duration
                );

        details.getChildren().addAll(
                clientLabel,
                typeLabel,
                timeLabel,
                durationLabel
        );

        // ---------------------------------------------------------
        // BACK TO SCHEDULE
        // ---------------------------------------------------------

        Button done =
                createPrimaryButton(
                        "Back to Schedule"
                );

        done.setPrefWidth(
                220
        );

        done.setOnAction(
                e -> {

                    closeOverlay(overlay);

                    // Explicitly restore schedule page.
                    showSchedulePage();
                }
        );

        card.getChildren().addAll(
                check,
                title,
                subtitle,
                details,
                done
        );

        overlay.getChildren().add(card);

        StackPane.setAlignment(
                card,
                Pos.CENTER
        );

        rootLayer.getChildren().add(overlay);
    }

    // =========================================================
    // SUCCESS DETAIL
    // =========================================================

    private Label createDetailRow(
            String label,
            String value
    ) {

        Label row =
                new Label(
                        label + "   " + value
                );

        row.setWrapText(true);

        row.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 12px;"
        );

        return row;
    }

    // =========================================================
    // CALENDAR POPUP
    // =========================================================

    private void showCalendarPopup() {

        StackPane overlay =
                createModalOverlay();

        VBox card =
                new VBox(16);

        card.setPrefWidth(430);
        card.setMaxWidth(430);

        card.setPadding(
                new Insets(24)
        );

        card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0A1820, #06130E);"
                        + "-fx-background-radius: 22;"
                        + "-fx-border-color: rgba(117,255,158,0.25);"
                        + "-fx-border-radius: 22;"
        );

        card.setEffect(
                new DropShadow(
                        40,
                        0,
                        15,
                        Color.color(0, 0, 0, 0.70)
                )
        );

        Label title =
                new Label("Choose Date");

        title.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 22px;"
                        + "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Select a date for your training schedule."
                );

        subtitle.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 12px;"
        );

        HBox monthHeader =
                new HBox();

        monthHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        Label currentMonth =
                new Label();

        currentMonth.setStyle(
                "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 15px;"
                        + "-fx-font-weight: bold;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button prev =
                createMiniIconButton("‹");

        Button nxt =
                createMiniIconButton("›");

        monthHeader.getChildren().addAll(
                currentMonth,
                spacer,
                prev,
                nxt
        );

        GridPane grid =
                new GridPane();

        grid.setHgap(5);
        grid.setVgap(6);
        grid.setAlignment(Pos.CENTER);

        buildPopupCalendar(
                grid,
                currentMonth,
                overlay
        );

        prev.setOnAction(
                e -> {

                    displayedMonth =
                            displayedMonth.minusMonths(1);

                    buildPopupCalendar(
                            grid,
                            currentMonth,
                            overlay
                    );
                }
        );

        nxt.setOnAction(
                e -> {

                    displayedMonth =
                            displayedMonth.plusMonths(1);

                    buildPopupCalendar(
                            grid,
                            currentMonth,
                            overlay
                    );
                }
        );

        Button done =
                createPrimaryButton(
                        "Back to Schedule"
                );

        done.setOnAction(
                e -> closeOverlay(overlay)
        );

        card.getChildren().addAll(
                title,
                subtitle,
                createSeparator(),
                monthHeader,
                grid,
                done
        );

        overlay.getChildren().add(card);

        StackPane.setAlignment(
                card,
                Pos.CENTER
        );

        rootLayer.getChildren().add(overlay);
    }

    // =========================================================
    // POPUP CALENDAR
    // =========================================================

    private void buildPopupCalendar(
            GridPane grid,
            Label monthLabelPopup,
            StackPane overlay
    ) {

        grid.getChildren().clear();

        monthLabelPopup.setText(
                displayedMonth.format(
                        DateTimeFormatter.ofPattern(
                                "MMMM yyyy"
                        )
                )
        );

        String[] days = {
                "M",
                "T",
                "W",
                "T",
                "F",
                "S",
                "S"
        };

        for (int i = 0; i < 7; i++) {

            Label d =
                    new Label(days[i]);

            d.setPrefWidth(45);

            d.setAlignment(
                    Pos.CENTER
            );

            d.setStyle(
                    "-fx-text-fill: " + TEXT_MUTED + ";"
                            + "-fx-font-size: 10px;"
                            + "-fx-font-weight: bold;"
            );

            grid.add(
                    d,
                    i,
                    0
            );
        }

        LocalDate first =
                displayedMonth.atDay(1);

        int start =
                first.getDayOfWeek().getValue() - 1;

        int length =
                displayedMonth.lengthOfMonth();

        for (
                int n = 1;
                n <= length;
                n++
        ) {

            int index =
                    start + n - 1;

            int row =
                    index / 7 + 1;

            int col =
                    index % 7;

            LocalDate date =
                    displayedMonth.atDay(n);

            Button b =
                    new Button(
                            String.valueOf(n)
                    );

            b.setPrefSize(
                    45,
                    40
            );

            if (date.equals(selectedDate)) {

                b.setStyle(
                        "-fx-background-color: " + PRIMARY + ";"
                                + "-fx-text-fill: #003918;"
                                + "-fx-background-radius: 9;"
                                + "-fx-font-weight: bold;"
                                + "-fx-cursor: hand;"
                );

            } else if (date.equals(LocalDate.now())) {

                b.setStyle(
                        "-fx-background-color: rgba(117,255,158,0.08);"
                                + "-fx-border-color: " + PRIMARY + ";"
                                + "-fx-border-radius: 9;"
                                + "-fx-background-radius: 9;"
                                + "-fx-text-fill: " + PRIMARY + ";"
                                + "-fx-font-weight: bold;"
                                + "-fx-cursor: hand;"
                );

            } else {

                b.setStyle(
                        "-fx-background-color: transparent;"
                                + "-fx-text-fill: " + TEXT_MAIN + ";"
                                + "-fx-background-radius: 9;"
                                + "-fx-cursor: hand;"
                );
            }

            b.setOnAction(
                    e -> {

                        selectedDate = date;

                        displayedMonth =
                                YearMonth.from(date);

                        closeOverlay(overlay);

                        rebuildSchedulePage();
                    }
            );

            grid.add(
                    b,
                    col,
                    row
            );
        }
    }

    // =========================================================
    // REBUILD SCHEDULE PAGE
    // =========================================================

    private void rebuildSchedulePage() {

        if (mainRoot == null) {
            return;
        }

        schedulePage =
                createSchedulePage();

        mainRoot.setCenter(
                createTransparentScroll(
                        schedulePage
                )
        );
    }

    // =========================================================
    // SHOW SCHEDULE PAGE
    // =========================================================

    private void showSchedulePage() {

        schedulePage =
                createSchedulePage();

        mainRoot.setCenter(
                createTransparentScroll(
                        schedulePage
                )
        );
    }

    // =========================================================
    // MODAL OVERLAY
    // =========================================================

    private StackPane createModalOverlay() {

        StackPane overlay =
                new StackPane();

        overlay.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        overlay.setStyle(
                "-fx-background-color: rgba(0,0,0,0.76);"
        );

        // IMPORTANT:
        // Prevent clicks from reaching schedule page.
        overlay.setPickOnBounds(true);

        return overlay;
    }

    // =========================================================
    // CLOSE OVERLAY
    // =========================================================

    private void closeOverlay(
            StackPane overlay
    ) {

        if (overlay == null || rootLayer == null) {
            return;
        }

        rootLayer.getChildren().remove(
                overlay
        );
    }

    // =========================================================
    // INPUT
    // =========================================================

    private TextField createInput(
            String text
    ) {

        TextField field =
                new TextField(text);

        field.setPrefHeight(42);

        field.setStyle(
                "-fx-background-color: rgba(255,255,255,0.045);"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 10;"
                        + "-fx-background-radius: 10;"
                        + "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-padding: 10 12;"
        );

        return field;
    }

    // =========================================================
    // FIELD LABEL
    // =========================================================

    private Label createFieldLabel(
            String text
    ) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: " + TEXT_MUTED + ";"
                        + "-fx-font-size: 10px;"
                        + "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // COMBOBOX STYLE
    // =========================================================

    private void styleComboBox(
            ComboBox<String> combo
    ) {

        combo.setPrefHeight(42);

        combo.setStyle(
                "-fx-background-color: rgba(255,255,255,0.045);"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 10;"
                        + "-fx-background-radius: 10;"
                        + "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-padding: 3 7;"
        );
    }

    // =========================================================
    // PRIMARY BUTTON
    // =========================================================

    private Button createPrimaryButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color: " + PRIMARY + ";"
                        + "-fx-text-fill: #003918;"
                        + "-fx-background-radius: 11;"
                        + "-fx-font-weight: bold;"
                        + "-fx-padding: 11 20;"
                        + "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(
                e -> button.setStyle(
                        "-fx-background-color: " + PRIMARY_HOVER + ";"
                                + "-fx-text-fill: #003918;"
                                + "-fx-background-radius: 11;"
                                + "-fx-font-weight: bold;"
                                + "-fx-padding: 11 20;"
                                + "-fx-cursor: hand;"
                )
        );

        button.setOnMouseExited(
                e -> button.setStyle(
                        "-fx-background-color: " + PRIMARY + ";"
                                + "-fx-text-fill: #003918;"
                                + "-fx-background-radius: 11;"
                                + "-fx-font-weight: bold;"
                                + "-fx-padding: 11 20;"
                                + "-fx-cursor: hand;"
                )
        );

        return button;
    }

    // =========================================================
    // NAVIGATION BUTTON
    // =========================================================

    private Button createNavigationButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setPrefSize(
                34,
                34
        );

        button.setStyle(
                "-fx-background-color: rgba(255,255,255,0.04);"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 8;"
                        + "-fx-background-radius: 8;"
                        + "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 20px;"
                        + "-fx-padding: 0;"
                        + "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // ICON BUTTON
    // =========================================================

    private Button createIconButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setPrefSize(
                38,
                34
        );

        button.setStyle(
                "-fx-background-color: " + PRIMARY_DIM + ";"
                        + "-fx-border-color: " + PRIMARY_BORDER + ";"
                        + "-fx-border-radius: 8;"
                        + "-fx-background-radius: 8;"
                        + "-fx-text-fill: " + PRIMARY + ";"
                        + "-fx-font-size: 15px;"
                        + "-fx-font-weight: bold;"
                        + "-fx-padding: 0;"
                        + "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // MINI ICON BUTTON
    // =========================================================

    private Button createMiniIconButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setPrefSize(
                30,
                30
        );

        button.setStyle(
                "-fx-background-color: rgba(255,255,255,0.04);"
                        + "-fx-border-color: " + BORDER + ";"
                        + "-fx-border-radius: 8;"
                        + "-fx-background-radius: 8;"
                        + "-fx-text-fill: " + TEXT_MAIN + ";"
                        + "-fx-font-size: 16px;"
                        + "-fx-padding: 0;"
                        + "-fx-cursor: hand;"
        );

        return button;
    }

    // =========================================================
    // PERSON ICON
    // =========================================================

    private StackPane createPersonIcon(
            String color
    ) {

        StackPane icon =
                new StackPane();

        icon.setMinSize(
                38,
                38
        );

        icon.setMaxSize(
                38,
                38
        );

        icon.setStyle(
                "-fx-background-color: rgba(117,255,158,0.08);"
                        + "-fx-background-radius: 10;"
        );

        Circle head =
                new Circle(
                        5,
                        Color.web(color)
                );

        head.setTranslateY(-6);

        Circle body =
                new Circle(
                        9,
                        Color.web(color)
                );

        body.setScaleY(0.55);

        body.setTranslateY(5);

        icon.getChildren().addAll(
                body,
                head
        );

        return icon;
    }

    // =========================================================
    // SEPARATOR
    // =========================================================

    private Region createSeparator() {

        Region separator =
                new Region();

        separator.setMinHeight(1);
        separator.setMaxHeight(1);

        separator.setStyle(
                "-fx-background-color: rgba(255,255,255,0.08);"
        );

        return separator;
    }

    // =========================================================
    // SCROLL
    // =========================================================

    private ScrollPane createTransparentScroll(
            VBox content
    ) {

        StackPane centered =
                new StackPane();

        centered.setAlignment(
                Pos.TOP_CENTER
        );

        centered.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        centered.getChildren().add(
                content
        );

        ScrollPane scroll =
                new ScrollPane(centered);

        scroll.setFitToWidth(true);
        scroll.setFitToHeight(false);

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scroll.setStyle(
                "-fx-background-color: transparent;"
                        + "-fx-background: transparent;"
                        + "-fx-border-color: transparent;"
        );

        return scroll;
    }

    // =========================================================
    // DATE FORMAT
    // =========================================================

    private String formatLongDate(
            LocalDate date
    ) {

        return date.format(
                DateTimeFormatter.ofPattern(
                        "EEEE, MMMM d, yyyy"
                )
        );
    }

    // =========================================================
    // NO ARGUMENT VERSION
    // =========================================================

    public Scene getScheduleManagerScene() {

        return getScheduleManagerScene(null);
    }
}
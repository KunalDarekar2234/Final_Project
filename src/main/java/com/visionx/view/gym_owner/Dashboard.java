package com.visionx.view.gym_owner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import com.visionx.view.SplashScreen;

public class Dashboard {

    // =========================================================
    // COLOR PALETTE
    // =========================================================

    private final String BG_COLOR = "#0d150e";
    private final String SURFACE = "#020914";
    private final String SURFACE_BORDER = "#2a352b";

    private final String PRIMARY = "#75ff9e";
    private final String ON_PRIMARY = "#003918";

    private final String ON_SURFACE = "#dbe5d9";
    private final String ON_SURFACE_VARIANT = "#bacbb9";

    private final String ERROR = "#ffb4ab";

    // =========================================================
    // EFFECTS
    // =========================================================

    private final DropShadow primaryGlow =
            new DropShadow(
                    20,
                    Color.web(PRIMARY, 0.2)
            );

    private final DropShadow cardShadow =
            new DropShadow(
                    30,
                    0,
                    10,
                    Color.color(0, 0, 0, 0.3)
            );

    // =========================================================
    // STAGE / SCENE
    // =========================================================

//     public static Stage DashboardStage;
    public static Scene DashboardScene;
//     public static Stage primaryStage;

    /*
     * Kept for compatibility with your old architecture.
     * Main navigation is now handled by appShell.
     */
    public static BorderPane mainLayout;
    public static Stage primaryStage;

    private BorderPane appShell;
    private BorderPane mainAreaShell;

    // =========================================================
    // PERMANENT UI
    // =========================================================

    private VBox sidebar;

    private HBox header;

    private StackPane contentArea;
        private VBox dashboardContent;

        private ScrollPane dashboardScroll;

    // =========================================================
    // NAVIGATION STATE
    // =========================================================

    private String currentPage = "Dashboard";

    private HBox activeNavBox;
    private Label activeIconLabel;
    private Label activeTextLabel;

    // =========================================================
    // PAGE CACHE
    // =========================================================

    private final Map<String, Node> pageCache =
            new HashMap<>();

    private Runnable logoutCallback;

    // =========================================================
    // START
    // =========================================================

    public Scene getDashboardScene(Runnable callback) {
        this.logoutCallback = callback;

        // DashboardStage = primaryStage;
        // Image img = new Image(
        // getClass()
        //         .getResource("/assets/Icon/LOGO.png")
        //         .toExternalForm()
        // );

        // DashboardStage.getIcons().add(img);


        // -----------------------------------------------------
        // SIDEBAR
        // -----------------------------------------------------

        sidebar = createSidebar();

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        header = createHeader();

       
        // -----------------------------------------------------
        // CONTENT AREA
        // -----------------------------------------------------

        contentArea = new StackPane();

        contentArea.setStyle(
                "-fx-background-color: " +
                BG_COLOR + ";"
        );

        dashboardContent =
                createDashboardContent();

        contentArea.getChildren().add(
                dashboardContent
        );

        // -----------------------------------------------------
        // MAIN AREA (RIGHT SIDE OF SIDEBAR)
        // -----------------------------------------------------

        mainAreaShell = new BorderPane();

        // Header belongs ONLY to the right side.
        // This keeps the sidebar full-height from the very top.
        mainAreaShell.setTop(header);
        mainAreaShell.setCenter(contentArea);

        mainAreaShell.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        // -----------------------------------------------------
        // APP SHELL
        // -----------------------------------------------------

        appShell = new BorderPane();

        // Sidebar occupies the complete left side, including
        // the area where the header used to be.
        appShell.setLeft(sidebar);
        appShell.setCenter(mainAreaShell);

        appShell.setStyle(
                "-fx-background-color: " +
                BG_COLOR +
                "; -fx-font-family: 'Segoe UI', sans-serif;"
        );

        /*
         * Keep compatibility with old code.
         */
        mainLayout = appShell;

        // -----------------------------------------------------
        // SCENE
        // -----------------------------------------------------

        DashboardScene =
                new Scene(
                        appShell,
                        SplashScreen.primaryStage.getWidth(),
                        SplashScreen.primaryStage.getHeight()
                );

        SplashScreen.primaryStage.setMaximized(true);

        // DashboardStage.setTitle(
        //         "FitneesFreak | Elite Performance Dashboard"
        // );

        // DashboardStage.setScene(
        //         DashboardScene
        // );


        // DashboardStage.show();

        return DashboardScene;
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private VBox createSidebar() {

        VBox sidebar = new VBox();

        sidebar.setPrefWidth(307);
        sidebar.setMinWidth(307);

        sidebar.setStyle(
                "-fx-background-color: " +
                SURFACE +
                "; -fx-border-color: transparent " +
                SURFACE_BORDER +
                " transparent transparent;"
        );

        sidebar.setPadding(
                new Insets(24, 0, 0, 0)
        );

        // =====================================================
        // LOGO
        // =====================================================

        HBox logoBox = new HBox(12);

        logoBox.setAlignment(
                Pos.CENTER_LEFT
        );

        logoBox.setPadding(
                new Insets(0, 16, 40, 16)
        );

        Label icon = new Label("🏋");

        icon.setStyle(
                "-fx-background-color: " +
                PRIMARY +
                "; -fx-text-fill: " +
                ON_PRIMARY +
                "; -fx-font-size: 20px;" +
                " -fx-padding: 8;" +
                " -fx-background-radius: 8;"
        );

        icon.setEffect(primaryGlow);

        VBox logoText = new VBox();

        Label title =
                new Label("FitneesFreak");

        title.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label sub =
                new Label("ELITE PERFORMANCE");

        sub.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 10px;" +
                " -fx-letter-spacing: 2px;"
        );

        logoText.getChildren().addAll(
                title,
                sub
        );

        logoBox.getChildren().addAll(
                icon,
                logoText
        );

        // =====================================================
        // NAVIGATION
        // =====================================================

        VBox nav = new VBox(4);

        nav.setPadding(
                new Insets(0, 16, 0, 16)
        );

        nav.getChildren().addAll(

                createNavItem(
                        "📊",
                        "Dashboard",
                        true
                ),

                createNavItem(
                        "🗃",
                        "Membership Packages",
                        false
                ),

                createNavItem(
                        "💪",
                        "Trainers",
                        false
                ),

                createNavItem(
                        "🏢",
                        "Facilities",
                        false
                ),

                createNavItem(
                        "👤",
                        "Membership Requests",
                        false
                ),

                createNavItem(
                        "🏷",
                        "Offers",
                        false
                ),

                createNavItem(
                        "⭐",
                        "Reviews",
                        false
                ),

                createNavItem(
                        "🏆",
                        "Leaderboard",
                        false
                )
        );

        // =====================================================
        // DIVIDER
        // =====================================================

        Region divider = new Region();

        divider.setMinHeight(1);

        divider.setStyle(
                "-fx-background-color: " +
                SURFACE_BORDER +
                ";"
        );

        nav.getChildren().add(
                divider
        );

        // =====================================================
        // SECONDARY NAVIGATION
        // =====================================================

        nav.getChildren().addAll(

                createNavItem(
                        "📈",
                        "Analytics",
                        false
                ),

                createNavItem(
                        "🧠",
                        "AI Insights",
                        false
                )
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane navScroll =
                new ScrollPane(nav);

        navScroll.setFitToWidth(true);

        navScroll.setStyle(
                "-fx-background: " +
                SURFACE +
                "; -fx-background-color: transparent;" +
                " -fx-border-color: transparent;"
        );

        navScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        navScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        VBox.setVgrow(
                navScroll,
                Priority.ALWAYS
        );

        // =====================================================
        // USER PROFILE
        // =====================================================

        VBox bottom =
                new VBox(15);

        bottom.setPadding(
                new Insets(24, 16, 24, 16)
        );

        bottom.setStyle(
                "-fx-border-color: " +
                SURFACE_BORDER +
                " transparent transparent transparent;"
        );

        HBox userBox =
                new HBox(12);

        userBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // -----------------------------------------------------
        // Avatar
        // -----------------------------------------------------

        ImageView avatar;

        try {

            avatar =
                    new ImageView(
                            new Image(
                                    "https://lh3.googleusercontent.com/aida-public/AB6AXuBt4sWAGu-j0VyqlxrytQRJZah3TEzk87FYp9iiivQJMqlaOvDYyOGNqiDFQYm1umpgBLeYUGwb3m7ifijidcg75BIJAQdr6Dr8CERHB5R4UX8AoSne-KPoC0yQX6S5WNJl5Vrfg3fD6to-bIEOz_Nn2CEfbDrucaAdEZNx9Vm8nORGUslBK1rxeBYeo-SGXvVKrJV-3NcOWrnpVxaJKR1I-Fdb3MCO3DT5yxLobD1dYqpWcLCO-B3T",
                                    40,
                                    40,
                                    true,
                                    true
                            )
                    );

        } catch (Exception e) {

            avatar = new ImageView();
        }

        Circle clip =
                new Circle(
                        20,
                        20,
                        20
                );

        avatar.setClip(clip);

        VBox userText =
                new VBox(2);

        Label userName =
                new Label("Alex Sterling");

        userName.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-weight: bold;" +
                " -fx-font-size: 14px;"
        );

        Label userRole =
                new Label("ADMIN");

        userRole.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 10px;"
        );

        userText.getChildren().addAll(
                userName,
                userRole
        );

        userBox.getChildren().addAll(
                avatar,
                userText
        );

        // =====================================================
        // LOGOUT
        // =====================================================

        Button logoutBtn =
                new Button("🚪 LOGOUT");

        logoutBtn.setMaxWidth(
                Double.MAX_VALUE
        );

        String logoutDef =
                "-fx-background-color: rgba(255, 180, 171, 0.05);" +
                " -fx-text-fill: " + ERROR +
                "; -fx-background-radius: 8;" +
                " -fx-padding: 10;" +
                " -fx-cursor: hand;";

        String logoutHov =
                "-fx-background-color: rgba(255, 180, 171, 0.1);" +
                " -fx-text-fill: " + ERROR +
                "; -fx-background-radius: 8;" +
                " -fx-padding: 10;" +
                " -fx-cursor: hand;";

        addHoverEffect(
                logoutBtn,
                logoutDef,
                logoutHov
        );

        logoutBtn.setOnAction(e -> {
            if (logoutCallback != null) {
                logoutCallback.run();
            }
        });

        javafx.scene.layout.VBox.setMargin(logoutBtn, new javafx.geometry.Insets(0, 0, 30, 0));

        bottom.getChildren().addAll(
                userBox,
                logoutBtn
        );

        sidebar.getChildren().addAll(
                logoBox,
                navScroll,
                bottom
        );

        return sidebar;
    }

    // =========================================================
    // NAV ITEM
    // =========================================================

    private HBox createNavItem(
            String icon,
            String title,
            boolean active
    ) {

        HBox box =
                new HBox(12);

        box.setAlignment(
                Pos.CENTER_LEFT
        );

        box.setPadding(
                new Insets(10, 16, 10, 16)
        );

        String normalStyle =
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        String hoverStyle =
                "-fx-background-color: #132A20;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;";

        String activeStyle =
                "-fx-background-color: #163B2A;" +
                "-fx-background-radius: 14;" +
                "-fx-border-color: #45F59A;" +
                "-fx-border-width: 1.2;" +
                "-fx-border-radius: 14;" +
                "-fx-cursor: hand;";

        Label iconLbl =
                new Label(icon);

        Label textLbl =
                new Label(title);

        if (active) {

            box.setStyle(activeStyle);

            iconLbl.setStyle(
                    "-fx-text-fill: #8BFFB8;" +
                    " -fx-font-size: 18px;"
            );

            textLbl.setStyle(
                    "-fx-text-fill: #8BFFB8;" +
                    " -fx-font-weight: bold;" +
                    " -fx-font-size: 14px;"
            );

            activeNavBox = box;
            activeIconLabel = iconLbl;
            activeTextLabel = textLbl;

        } else {

            box.setStyle(
                    normalStyle
            );

            iconLbl.setStyle(
                    "-fx-text-fill: " +
                    ON_SURFACE_VARIANT +
                    "; -fx-font-size: 18px;"
            );

            textLbl.setStyle(
                    "-fx-text-fill: " +
                    ON_SURFACE_VARIANT +
                    "; -fx-font-size: 14px;"
            );
        }

        // =====================================================
        // HOVER
        // =====================================================

        box.setOnMouseEntered(e -> {

            if (box != activeNavBox) {

                box.setStyle(
                        hoverStyle
                );

                iconLbl.setStyle(
                        "-fx-text-fill: #8BFFB8;" +
                        " -fx-font-size: 18px;"
                );

                textLbl.setStyle(
                        "-fx-text-fill: #D8FBE4;" +
                        " -fx-font-size: 14px;"
                );
            }
        });

        box.setOnMouseExited(e -> {

            if (box != activeNavBox) {

                box.setStyle(
                        normalStyle
                );

                iconLbl.setStyle(
                        "-fx-text-fill: " +
                        ON_SURFACE_VARIANT +
                        "; -fx-font-size: 18px;"
                );

                textLbl.setStyle(
                        "-fx-text-fill: " +
                        ON_SURFACE_VARIANT +
                        "; -fx-font-size: 14px;"
                );
            }
        });

        box.getChildren().addAll(
                iconLbl,
                textLbl
        );

        // =====================================================
        // CLICK
        // =====================================================

        box.setOnMousePressed(e -> {

            setActiveNavItem(
                    box,
                    iconLbl,
                    textLbl
            );

            navigate(title);

            e.consume();
        });

        return box;
    }

    // =========================================================
    // SET ACTIVE NAV
    // =========================================================

    private void setActiveNavItem(
            HBox newBox,
            Label newIcon,
            Label newText
    ) {

        if (activeNavBox != null) {

            activeNavBox.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-background-radius: 14;" +
                    "-fx-cursor: hand;"
            );

            if (activeIconLabel != null) {

                activeIconLabel.setStyle(
                        "-fx-text-fill: " +
                        ON_SURFACE_VARIANT +
                        "; -fx-font-size: 18px;"
                );
            }

            if (activeTextLabel != null) {

                activeTextLabel.setStyle(
                        "-fx-text-fill: " +
                        ON_SURFACE_VARIANT +
                        "; -fx-font-size: 14px;"
                );
            }
        }

        newBox.setStyle(
                "-fx-background-color: #163B2A;" +
                "-fx-background-radius: 14;" +
                "-fx-border-color: #45F59A;" +
                "-fx-border-width: 1.2;" +
                "-fx-border-radius: 14;" +
                "-fx-cursor: hand;"
        );

        newIcon.setStyle(
                "-fx-text-fill: #8BFFB8;" +
                "-fx-font-size: 18px;"
        );

        newText.setStyle(
                "-fx-text-fill: #8BFFB8;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;"
        );

        activeNavBox = newBox;
        activeIconLabel = newIcon;
        activeTextLabel = newText;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createHeader() {

        HBox header =
                new HBox();

        header.setMinHeight(80);
        header.setMaxHeight(80);

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setPadding(
                new Insets(0, 32, 0, 36)
        );

        header.setStyle(
                "-fx-background-color: " +
                SURFACE +
                "; -fx-border-color: transparent transparent " +
                SURFACE_BORDER +
                " transparent;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        TextField search =
                new TextField();

        search.setPromptText(
                "🔍 Search data, members, or trainers..."
        );

        search.setPrefWidth(385);
        search.setPrefHeight(38);

        // Search starts inside the header, to the RIGHT of the full-height sidebar.
        HBox.setMargin(
                search,
                new Insets(0, 0, 0, 0)
        );

        String searchDefault =
                "-fx-background-color: #151e16;" +
                " -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-border-radius: 50;" +
                " -fx-background-radius: 50;" +
                " -fx-text-fill: " +
                ON_SURFACE +
                "; -fx-prompt-text-fill: #556655;" +
                " -fx-padding: 8 16;";

        String searchFocus =
                "-fx-background-color: #151e16;" +
                " -fx-border-color: " +
                PRIMARY +
                "; -fx-border-radius: 50;" +
                " -fx-background-radius: 50;" +
                " -fx-text-fill: " +
                ON_SURFACE +
                "; -fx-prompt-text-fill: #556655;" +
                " -fx-padding: 8 16;";

        search.setStyle(
                searchDefault
        );
        HBox.setMargin(search, new Insets(0, 0, 0, 0));

        search.focusedProperty().addListener(
                (obs, oldValue, focused) -> {

                    search.setStyle(
                            focused
                                    ? searchFocus
                                    : searchDefault
                    );
                }
        );

        // =====================================================
        // SPACER
        // =====================================================

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // =====================================================
        // ACTIONS
        // =====================================================

        HBox actions =
                new HBox(20);

        actions.setAlignment(
                Pos.CENTER
        );

        // =====================================================
        // NOTIFICATION
        // =====================================================

        Label notif =
                new Label("🔔");

        notif.setTooltip(
                new javafx.scene.control.Tooltip(
                        "Notifications"
                )
        );

        notif.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 18px;" +
                " -fx-cursor: hand;"
        );

        notif.setOnMouseEntered(e ->
                notif.setStyle(
                        "-fx-text-fill: " +
                        PRIMARY +
                        "; -fx-font-size: 20px;" +
                        " -fx-cursor: hand;"
                )
        );

        notif.setOnMouseExited(e ->
                notif.setStyle(
                        "-fx-text-fill: " +
                        ON_SURFACE_VARIANT +
                        "; -fx-font-size: 18px;" +
                        " -fx-cursor: hand;"
                )
        );

        notif.setOnMouseClicked(e ->
                navigate("Notifications")
        );

        // =====================================================
        // SETTINGS
        // =====================================================

        Label settings =
                new Label("⚙");

        settings.setTooltip(
                new javafx.scene.control.Tooltip(
                        "Settings"
                )
        );

        settings.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 18px;" +
                " -fx-cursor: hand;"
        );

        settings.setOnMouseEntered(e ->
                settings.setStyle(
                        "-fx-text-fill: " +
                        PRIMARY +
                        "; -fx-font-size: 20px;" +
                        " -fx-cursor: hand;"
                )
        );

        settings.setOnMouseExited(e ->
                settings.setStyle(
                        "-fx-text-fill: " +
                        ON_SURFACE_VARIANT +
                        "; -fx-font-size: 18px;" +
                        " -fx-cursor: hand;"
                )
        );

        settings.setOnMouseClicked(e ->
                navigate("Settings")
        );

        // =====================================================
        // DIVIDER
        // =====================================================

        Region div =
                new Region();

        div.setMinWidth(1);
        div.setMaxHeight(24);

        div.setStyle(
                "-fx-background-color: " +
                SURFACE_BORDER +
                ";"
        );

        // =====================================================
        // SYSTEM STATUS
        // =====================================================

        VBox statText =
                new VBox();

        statText.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label s1 =
                new Label(
                        "FitneesFreak Core"
                );

        s1.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 12px;"
        );

        Label s2 =
                new Label(
                        "System Online"
                );

        s2.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                "; -fx-font-size: 10px;"
        );

        statText.getChildren().addAll(
                s1,
                s2
        );

        // =====================================================
        // SHIELD
        // =====================================================

        Label shield =
                new Label("🛡");

        shield.setStyle(
                "-fx-background-color: #2e372e;" +
                " -fx-text-fill: " +
                PRIMARY +
                "; -fx-padding: 6;" +
                " -fx-background-radius: 8;" +
                " -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-border-radius: 8;"
        );

        actions.getChildren().addAll(
                notif,
                settings,
                div,
                statText,
                shield
        );

        header.getChildren().addAll(
                search,
                spacer,
                actions
        );

        return header;
    }

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private ScrollPane createMainContent() {

        VBox content =
                new VBox(32);

        content.setPadding(
                new Insets(32)
        );

        content.setStyle(
                "-fx-background-color: transparent;"
        );

        content.getChildren().add(
                createPageHeader()
        );

        content.getChildren().add(
                createKPIGrid()
        );

        HBox middleSection =
                new HBox(32);

        VBox chartCard =
                createAnalyticsChart();

        HBox.setHgrow(
                chartCard,
                Priority.ALWAYS
        );

        VBox toolkit =
                createToolkit();

        middleSection.getChildren().addAll(
                chartCard,
                toolkit
        );

        content.getChildren().add(
                middleSection
        );

        HBox bottomSection =
                new HBox(32);

        VBox table =
                createRequestsTable();

        HBox.setHgrow(
                table,
                Priority.ALWAYS
        );

        VBox aiPanel =
                createAIPanel();

        bottomSection.getChildren().addAll(
                table,
                aiPanel
        );

        content.getChildren().add(
                bottomSection
        );

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background: " +
                BG_COLOR +
                "; -fx-background-color: transparent;" +
                " -fx-border-color: transparent;"
        );

        scroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        return scroll;
    }

    // =========================================================
    // PAGE HEADER
    // =========================================================

    private HBox createPageHeader() {

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.BOTTOM_LEFT
        );

        VBox titleBox =
                new VBox(4);

        Label title =
                new Label(
                        "Executive Dashboard"
                );

        title.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 32px;" +
                " -fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Welcome back, Alex. Your gym's performance is up 12.4% this month."
                );

        subtitle.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 14px;"
        );

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        HBox btnBox =
                new HBox(12);

        btnBox.setAlignment(
                Pos.BOTTOM_RIGHT
        );

        Button dateBtn =
                new Button(
                        "📅 May 2024"
                );

        String dDef =
                "-fx-background-color: #19221a;" +
                " -fx-text-fill: " +
                ON_SURFACE +
                "; -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-border-radius: 12;" +
                " -fx-background-radius: 12;" +
                " -fx-padding: 12 24;" +
                " -fx-cursor: hand;";

        String dHov =
                "-fx-background-color: #232c24;" +
                " -fx-text-fill: " +
                ON_SURFACE +
                "; -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-border-radius: 12;" +
                " -fx-background-radius: 12;" +
                " -fx-padding: 12 24;" +
                " -fx-cursor: hand;";

        addHoverEffect(
                dateBtn,
                dDef,
                dHov
        );

        Button exportBtn =
                new Button(
                        "📥 EXPORT REPORT"
                );

        String eDef =
                "-fx-background-color: " +
                PRIMARY +
                "; -fx-text-fill: " +
                ON_PRIMARY +
                "; -fx-font-weight: bold;" +
                " -fx-background-radius: 12;" +
                " -fx-padding: 12 24;" +
                " -fx-cursor: hand;";

        String eHov =
                "-fx-background-color: #85ffaa;" +
                " -fx-text-fill: " +
                ON_PRIMARY +
                "; -fx-font-weight: bold;" +
                " -fx-background-radius: 12;" +
                " -fx-padding: 12 24;" +
                " -fx-cursor: hand;";

        addHoverEffect(
                exportBtn,
                eDef,
                eHov
        );

        exportBtn.setEffect(
                primaryGlow
        );

        btnBox.getChildren().addAll(
                dateBtn,
                exportBtn
        );

        header.getChildren().addAll(
                titleBox,
                spacer,
                btnBox
        );

        return header;
    }

    // =========================================================
    // KPI GRID
    // =========================================================

    private GridPane createKPIGrid() {

        GridPane grid =
                new GridPane();

        grid.setHgap(16);
        grid.setVgap(16);

        ColumnConstraints cc1 =
                new ColumnConstraints();

        ColumnConstraints cc2 =
                new ColumnConstraints();

        ColumnConstraints cc3 =
                new ColumnConstraints();

        cc1.setPercentWidth(33.33);
        cc2.setPercentWidth(33.33);
        cc3.setPercentWidth(33.34);

        grid.getColumnConstraints().addAll(
                cc1,
                cc2,
                cc3
        );

        grid.add(
                createGlassCard(
                        "TOTAL MEMBERS",
                        "👥",
                        "2,842",
                        "📈 +4.2%",
                        PRIMARY,
                        true
                ),
                0,
                0
        );

        grid.add(
                createGlassCard(
                        "ACTIVE PLANS",
                        "💳",
                        "1,950",
                        "📈 +2.1%",
                        PRIMARY,
                        true
                ),
                1,
                0
        );

        grid.add(
                createGlassCard(
                        "MRR",
                        "💵",
                        "$128.4k",
                        "📈 +8.7%",
                        PRIMARY,
                        true
                ),
                2,
                0
        );

        grid.add(
                createGlassCard(
                        "PENDING",
                        "⏳",
                        "24",
                        "Review required",
                        ON_SURFACE_VARIANT,
                        false
                ),
                0,
                1
        );

        grid.add(
                createGlassCard(
                        "REVIEWS",
                        "⭐",
                        "4.9/5",
                        "12 new today",
                        ON_SURFACE_VARIANT,
                        false
                ),
                1,
                1
        );

        grid.add(
                createGlassCard(
                        "TRAINERS",
                        "💪",
                        "32",
                        "4 on duty",
                        ON_SURFACE_VARIANT,
                        false
                ),
                2,
                1
        );

        return grid;
    }

    // =========================================================
    // GLASS CARD
    // =========================================================

    private VBox createGlassCard(
            String title,
            String icon,
            String value,
            String subtitle,
            String subColor,
            boolean isTrend
    ) {

        VBox card =
                new VBox();

        card.setPadding(
                new Insets(20)
        );

        card.setSpacing(20);

        setGlassStyle(card);

        HBox top =
                new HBox();

        Label tLbl =
                new Label(title);

        tLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 2px;"
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
                "-fx-text-fill: " +
                (title.equals("PENDING")
                        ? "#ffdec4"
                        : PRIMARY) +
                "; -fx-font-size: 20px;"
        );

        top.getChildren().addAll(
                tLbl,
                sp,
                iLbl
        );

        VBox bot =
                new VBox(4);

        Label vLbl =
                new Label(value);

        vLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label sLbl =
                new Label(subtitle);

        sLbl.setStyle(
                "-fx-text-fill: " +
                subColor +
                "; -fx-font-size: 10px;"
        );

        bot.getChildren().addAll(
                vLbl,
                sLbl
        );

        card.getChildren().addAll(
                top,
                bot
        );

        return card;
    }

    // =========================================================
    // ANALYTICS CHART
    // =========================================================

    private VBox createAnalyticsChart() {

        VBox card =
                new VBox();

        card.setPadding(
                new Insets(32)
        );

        setGlassStyle(card);

        HBox top =
                new HBox();

        VBox text =
                new VBox(4);

        Label title =
                new Label(
                        "Revenue & Growth Analytics"
                );

        title.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label sub =
                new Label(
                        "YEAR-TO-DATE PERFORMANCE"
                );

        sub.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 12px;"
        );

        text.getChildren().addAll(
                title,
                sub
        );

        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        HBox legend =
                new HBox(16);

        legend.setAlignment(
                Pos.CENTER
        );

        HBox l1 =
                new HBox(8);

        l1.setAlignment(
                Pos.CENTER
        );

        Circle c1 =
                new Circle(
                        6,
                        Color.web(PRIMARY)
                );

        Label t1 =
                new Label("Revenue");

        t1.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 12px;"
        );

        l1.getChildren().addAll(
                c1,
                t1
        );

        HBox l2 =
                new HBox(8);

        l2.setAlignment(
                Pos.CENTER
        );

        Circle c2 =
                new Circle(
                        6,
                        Color.web("#c0c6db")
                );

        Label t2 =
                new Label("Memberships");

        t2.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 12px;"
        );

        l2.getChildren().addAll(
                c2,
                t2
        );

        legend.getChildren().addAll(
                l1,
                l2
        );

        top.getChildren().addAll(
                text,
                sp,
                legend
        );

        Region chartArea =
                new Region();

        chartArea.setMinHeight(250);

        VBox.setVgrow(
                chartArea,
                Priority.ALWAYS
        );

        HBox axis =
                new HBox();

        axis.setStyle(
                "-fx-border-color: " +
                SURFACE_BORDER +
                " transparent transparent transparent;" +
                " -fx-padding: 16 0 0 0;"
        );

        String[] months = {
                "JAN",
                "FEB",
                "MAR",
                "APR",
                "MAY",
                "JUN",
                "JUL",
                "AUG",
                "SEP"
        };

        for (String m : months) {

            Label ml =
                    new Label(m);

            ml.setStyle(
                    "-fx-text-fill: rgba(186, 203, 185, 0.4);" +
                    " -fx-font-size: 10px;"
            );

            ml.setMaxWidth(
                    Double.MAX_VALUE
            );

            HBox.setHgrow(
                    ml,
                    Priority.ALWAYS
            );

            ml.setAlignment(
                    Pos.CENTER
            );

            axis.getChildren().add(
                    ml
            );
        }

        card.getChildren().addAll(
                top,
                chartArea,
                axis
        );

        return card;
    }

    // =========================================================
    // MANAGEMENT TOOLKIT
    // =========================================================

    private VBox createToolkit() {

        VBox col =
                new VBox(16);

        col.setMinWidth(300);

        Label title =
                new Label(
                        "MANAGEMENT TOOLKIT"
                );

        title.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 12px;" +
                " -fx-letter-spacing: 2px;" +
                " -fx-padding: 0 8;"
        );

        col.getChildren().add(
                title
        );

        col.getChildren().addAll(

                createToolBtn(
                        "👤",
                        "Add Trainer",
                        "Onboard new staff"
                ),

                createToolBtn(
                        "🏷",
                        "New Membership",
                        "Create a plan"
                ),

                createToolBtn(
                        "📢",
                        "Publish Offer",
                        "Marketing blast"
                ),

                createToolBtn(
                        "🏢",
                        "Add Facility",
                        "Expand equipment"
                )
        );

        return col;
    }

    // =========================================================
    // TOOL BUTTON
    // =========================================================

    private HBox createToolBtn(
            String icon,
            String title,
            String desc
    ) {

        HBox btn =
                new HBox(16);

        btn.setAlignment(
                Pos.CENTER_LEFT
        );

        btn.setPadding(
                new Insets(16)
        );

        setGlassStyle(btn);

        btn.setStyle(
                btn.getStyle() +
                "-fx-cursor: hand;"
        );

        VBox iconBox =
                new VBox();

        iconBox.setAlignment(
                Pos.CENTER
        );

        iconBox.setMinSize(48, 48);
        iconBox.setMaxSize(48, 48);

        iconBox.setStyle(
                "-fx-background-color: rgba(117, 255, 158, 0.1);" +
                " -fx-background-radius: 12;"
        );

        Label iLbl =
                new Label(icon);

        iLbl.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                "; -fx-font-size: 20px;"
        );

        iconBox.getChildren().add(
                iLbl
        );

        VBox text =
                new VBox(2);

        Label tLbl =
                new Label(title);

        tLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-weight: bold;" +
                " -fx-font-size: 16px;"
        );

        Label dLbl =
                new Label(desc);

        dLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 12px;"
        );

        text.getChildren().addAll(
                tLbl,
                dLbl
        );

        btn.setOnMouseEntered(e -> {

            btn.setStyle(
                    "-fx-background-color: " +
                    PRIMARY +
                    "; -fx-background-radius: 24;" +
                    " -fx-border-color: " +
                    PRIMARY +
                    "; -fx-border-radius: 24;" +
                    " -fx-cursor: hand;"
            );

            iconBox.setStyle(
                    "-fx-background-color: rgba(0, 57, 24, 0.2);" +
                    " -fx-background-radius: 12;"
            );

            iLbl.setStyle(
                    "-fx-text-fill: " +
                    ON_PRIMARY +
                    "; -fx-font-size: 20px;"
            );

            tLbl.setStyle(
                    "-fx-text-fill: " +
                    ON_PRIMARY +
                    "; -fx-font-weight: bold;" +
                    " -fx-font-size: 16px;"
            );

            dLbl.setStyle(
                    "-fx-text-fill: rgba(0, 57, 24, 0.7);" +
                    " -fx-font-size: 12px;"
            );
        });

        btn.setOnMouseExited(e -> {

            setGlassStyle(btn);

            btn.setStyle(
                    btn.getStyle() +
                    "-fx-cursor: hand;"
            );

            iconBox.setStyle(
                    "-fx-background-color: rgba(117, 255, 158, 0.1);" +
                    " -fx-background-radius: 12;"
            );

            iLbl.setStyle(
                    "-fx-text-fill: " +
                    PRIMARY +
                    "; -fx-font-size: 20px;"
            );

            tLbl.setStyle(
                    "-fx-text-fill: " +
                    ON_SURFACE +
                    "; -fx-font-weight: bold;" +
                    " -fx-font-size: 16px;"
            );

            dLbl.setStyle(
                    "-fx-text-fill: " +
                    ON_SURFACE_VARIANT +
                    "; -fx-font-size: 12px;"
            );
        });

        btn.getChildren().addAll(
                iconBox,
                text
        );

        return btn;
    }

    // =========================================================
    // REQUEST TABLE
    // =========================================================

    private VBox createRequestsTable() {

        VBox card =
                new VBox();

        card.setPadding(
                new Insets(24)
        );

        setGlassStyle(card);

        HBox top =
                new HBox();

        top.setAlignment(
                Pos.CENTER_LEFT
        );

        Label title =
                new Label(
                        "Membership Requests"
                );

        title.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Region sp =
                new Region();

        HBox.setHgrow(
                sp,
                Priority.ALWAYS
        );

        Label link =
                new Label(
                        "View All"
                );

        link.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                "; -fx-font-size: 12px;" +
                " -fx-cursor: hand;"
        );

        link.setOnMouseClicked(
                e -> navigate(
                        "Membership Requests"
                )
        );

        top.getChildren().addAll(
                title,
                sp,
                link
        );

        HBox header =
                new HBox();

        header.setPadding(
                new Insets(
                        24,
                        0,
                        16,
                        0
                )
        );

        header.setStyle(
                "-fx-border-color: transparent transparent " +
                SURFACE_BORDER +
                " transparent;"
        );

        String thStyle =
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 10px;" +
                " -fx-font-weight: bold;" +
                " -fx-letter-spacing: 2px;";

        Label h1 =
                new Label("APPLICANT");

        h1.setPrefWidth(250);
        h1.setStyle(thStyle);

        Label h2 =
                new Label("PLAN TYPE");

        h2.setPrefWidth(150);
        h2.setStyle(thStyle);

        Label h3 =
                new Label("DATE");

        h3.setPrefWidth(150);
        h3.setStyle(thStyle);

        Label h4 =
                new Label("ACTION");

        h4.setMaxWidth(
                Double.MAX_VALUE
        );

        HBox.setHgrow(
                h4,
                Priority.ALWAYS
        );

        h4.setAlignment(
                Pos.CENTER_RIGHT
        );

        h4.setStyle(thStyle);

        header.getChildren().addAll(
                h1,
                h2,
                h3,
                h4
        );

        VBox rows =
                new VBox();

        rows.getChildren().addAll(

                createTableRow(
                        "JD",
                        "Jordan Davis",
                        "#404758",
                        "#ffffff",
                        "Elite Annual",
                        "2 mins ago"
                ),

                createTableRow(
                        "SM",
                        "Sarah Miller",
                        "rgba(117, 255, 158, 0.2)",
                        PRIMARY,
                        "Pro Monthly",
                        "1 hour ago"
                ),

                createTableRow(
                        "KW",
                        "Kevin Wong",
                        "#ffba79",
                        "#794810",
                        "Basic Pass",
                        "3 hours ago"
                )
        );

        card.getChildren().addAll(
                top,
                header,
                rows
        );

        return card;
    }

    // =========================================================
    // TABLE ROW
    // =========================================================

    private HBox createTableRow(
            String initials,
            String name,
            String bgCol,
            String textCol,
            String plan,
            String date
    ) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(
                        16,
                        0,
                        16,
                        0
                )
        );

        row.setStyle(
                "-fx-border-color: transparent transparent " +
                SURFACE_BORDER +
                " transparent;"
        );

        HBox appBox =
                new HBox(12);

        appBox.setPrefWidth(250);

        appBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Label ava =
                new Label(initials);

        ava.setAlignment(
                Pos.CENTER
        );

        ava.setMinSize(32, 32);

        ava.setStyle(
                "-fx-background-color: " +
                bgCol +
                "; -fx-text-fill: " +
                textCol +
                "; -fx-font-weight: bold;" +
                " -fx-font-size: 10px;" +
                " -fx-background-radius: 50;"
        );

        Label nLbl =
                new Label(name);

        nLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 16px;"
        );

        appBox.getChildren().addAll(
                ava,
                nLbl
        );

        Label pLbl =
                new Label(plan);

        pLbl.setPrefWidth(150);

        pLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 16px;"
        );

        Label dLbl =
                new Label(date);

        dLbl.setPrefWidth(150);

        dLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 16px;"
        );

        HBox actions =
                new HBox(8);

        actions.setMaxWidth(
                Double.MAX_VALUE
        );

        HBox.setHgrow(
                actions,
                Priority.ALWAYS
        );

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label ok =
                new Label("✔");

        ok.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                "; -fx-font-size: 20px;" +
                " -fx-cursor: hand;"
        );

        Label no =
                new Label("✖");

        no.setStyle(
                "-fx-text-fill: rgba(255, 180, 171, 0.6);" +
                " -fx-font-size: 20px;" +
                " -fx-cursor: hand;"
        );

        actions.getChildren().addAll(
                ok,
                no
        );

        row.getChildren().addAll(
                appBox,
                pLbl,
                dLbl,
                actions
        );

        return row;
    }

    // =========================================================
    // AI PANEL
    // =========================================================

    private VBox createAIPanel() {

        VBox card =
                new VBox(24);

        card.setPadding(
                new Insets(24)
        );

        card.setMinWidth(400);

        card.setStyle(
                "-fx-background-color: #020914;" +
                " -fx-background-radius: 24;" +
                " -fx-border-color: rgba(117, 255, 158, 0.2);" +
                " -fx-border-radius: 24;"
        );

        card.setEffect(
                cardShadow
        );

        HBox top =
                new HBox(12);

        top.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox iconBox =
                new VBox();

        iconBox.setMinSize(48, 48);

        iconBox.setAlignment(
                Pos.CENTER
        );

        iconBox.setStyle(
                "-fx-background-color: rgba(117, 255, 158, 0.2);" +
                " -fx-background-radius: 50;"
        );

        Label iLbl =
                new Label("🧠");

        iLbl.setStyle(
                "-fx-text-fill: " +
                PRIMARY +
                "; -fx-font-size: 24px;"
        );

        iconBox.getChildren().add(
                iLbl
        );

        VBox texts =
                new VBox(2);

        Label t1 =
                new Label(
                        "AI Performance Insight"
                );

        t1.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-weight: bold;" +
                " -fx-font-size: 24px;"
        );

        Label t2 =
                new Label(
                        "REAL-TIME OPTIMIZATION"
                );

        t2.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 12px;" +
                " -fx-letter-spacing: 2px;"
        );

        texts.getChildren().addAll(
                t1,
                t2
        );

        top.getChildren().addAll(
                iconBox,
                texts
        );

        VBox insight =
                new VBox();

        insight.setPadding(
                new Insets(16)
        );

        insight.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.05);" +
                " -fx-border-color: rgba(255, 255, 255, 0.05);" +
                " -fx-border-radius: 16;" +
                " -fx-background-radius: 16;"
        );

        Label textIn =
                new Label(
                        "\"Morning peak hours (6 AM - 8 AM) are reaching 95% capacity. Based on current trends, we recommend scheduling an additional HIIT session on Tuesday and Thursday to redistribute load.\""
                );

        textIn.setWrapText(true);

        textIn.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE +
                "; -fx-font-size: 16px;" +
                " -fx-line-spacing: 4px;"
        );

        insight.getChildren().add(
                textIn
        );

        HBox stats =
                new HBox(16);

        stats.getChildren().addAll(

                createAISMiniCard(
                        "CHURN PREDICTION",
                        "-15%",
                        ERROR,
                        "vs Last Month"
                ),

                createAISMiniCard(
                        "STAFF EFFICIENCY",
                        "88%",
                        PRIMARY,
                        "Optimal Range"
                )
        );

        Button actionBtn =
                new Button(
                        "💡 VIEW ALL RECOMMENDATIONS"
                );

        actionBtn.setMaxWidth(
                Double.MAX_VALUE
        );

        String bDef =
                "-fx-background-color: transparent;" +
                " -fx-border-color: " +
                PRIMARY +
                "; -fx-text-fill: " +
                PRIMARY +
                "; -fx-font-weight: bold;" +
                " -fx-background-radius: 12;" +
                " -fx-border-radius: 12;" +
                " -fx-padding: 12;" +
                " -fx-cursor: hand;";

        String bHov =
                "-fx-background-color: rgba(117, 255, 158, 0.1);" +
                " -fx-border-color: " +
                PRIMARY +
                "; -fx-text-fill: " +
                PRIMARY +
                "; -fx-font-weight: bold;" +
                " -fx-background-radius: 12;" +
                " -fx-border-radius: 12;" +
                " -fx-padding: 12;" +
                " -fx-cursor: hand;";

        addHoverEffect(
                actionBtn,
                bDef,
                bHov
        );

        card.getChildren().addAll(
                top,
                insight,
                stats,
                actionBtn
        );

        return card;
    }

    // =========================================================
    // AI MINI CARD
    // =========================================================

    private VBox createAISMiniCard(
            String title,
            String val,
            String valCol,
            String sub
    ) {

        VBox box =
                new VBox(4);

        HBox.setHgrow(
                box,
                Priority.ALWAYS
        );

        box.setPadding(
                new Insets(16)
        );

        box.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.05);" +
                " -fx-border-color: rgba(255, 255, 255, 0.05);" +
                " -fx-border-radius: 16;" +
                " -fx-background-radius: 16;"
        );

        Label tLbl =
                new Label(title);

        tLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 10px;" +
                " -fx-letter-spacing: 2px;"
        );

        Label vLbl =
                new Label(val);

        vLbl.setStyle(
                "-fx-text-fill: " +
                valCol +
                "; -fx-font-size: 24px;" +
                " -fx-font-weight: bold;"
        );

        Label sLbl =
                new Label(sub);

        sLbl.setStyle(
                "-fx-text-fill: " +
                ON_SURFACE_VARIANT +
                "; -fx-font-size: 10px;"
        );

        box.getChildren().addAll(
                tLbl,
                vLbl,
                sLbl
        );

        return box;
    }

    // =========================================================
    // GLASS STYLE
    // =========================================================

    private void setGlassStyle(
            Region region
    ) {

        String base =
                "-fx-background-color: " +
                SURFACE +
                "; -fx-background-radius: 24;" +
                " -fx-border-color: " +
                SURFACE_BORDER +
                "; -fx-border-radius: 24;";

        region.setStyle(base);

        region.setEffect(
                cardShadow
        );

        region.setOnMouseEntered(e -> {

            region.setStyle(
                    "-fx-background-color: rgba(25, 34, 26, 0.8);" +
                    " -fx-background-radius: 24;" +
                    " -fx-border-color: rgba(117, 255, 158, 0.3);" +
                    " -fx-border-radius: 24;"
            );

            DropShadow hoverShadow =
                    new DropShadow(
                            40,
                            Color.web(
                                    PRIMARY,
                                    0.1
                            )
                    );

            hoverShadow.setOffsetY(-10);

            region.setEffect(
                    hoverShadow
            );
        });

        region.setOnMouseExited(e -> {

            region.setStyle(base);

            region.setEffect(
                    cardShadow
            );
        });
    }

    // =========================================================
    // HOVER
    // =========================================================

    private void addHoverEffect(
            Node node,
            String defaultStyle,
            String hoverStyle
    ) {

        node.setStyle(
                defaultStyle
        );

        node.setOnMouseEntered(
                e -> node.setStyle(
                        hoverStyle
                )
        );

        node.setOnMouseExited(
                e -> node.setStyle(
                        defaultStyle
                )
        );
    }

    // =========================================================
    // DASHBOARD CONTENT
    // =========================================================

    private VBox createDashboardContent() {

        VBox mainArea =
                new VBox();

        mainArea.setFillWidth(true);

        dashboardScroll =
                createMainContent();

        VBox.setVgrow(
                dashboardScroll,
                Priority.ALWAYS
        );

        mainArea.getChildren().add(
                dashboardScroll
        );

        return mainArea;
    }

    // =========================================================
    // GET DASHBOARD SCENE
    // =========================================================

    public Scene getDashboardScene() {

        if (DashboardScene == null) {

            sidebar =
                    createSidebar();

            header =
                    createHeader();

            contentArea =
                    new StackPane();

            contentArea.setStyle(
                    "-fx-background-color: " +
                    BG_COLOR +
                    ";"
            );

            dashboardContent =
                    createDashboardContent();

            contentArea.getChildren().add(
                    dashboardContent
            );

            mainAreaShell =
                    new BorderPane();

            // Header is inside the right-side area only.
            mainAreaShell.setTop(
                    header
            );

            mainAreaShell.setCenter(
                    contentArea
            );

            mainAreaShell.setStyle(
                    "-fx-background-color: " +
                    BG_COLOR +
                    "; -fx-font-family: 'Segoe UI', sans-serif;"
            );

            appShell =
                    new BorderPane();

            // Full-height sidebar on the far left.
            appShell.setLeft(
                    sidebar
            );

            appShell.setCenter(
                    mainAreaShell
            );

            appShell.setStyle(
                    "-fx-background-color: " +
                    BG_COLOR +
                    "; -fx-font-family: 'Segoe UI', sans-serif;"
            );

            mainLayout = appShell;

            DashboardScene =
                    new Scene(
                            appShell,
                            1440,
                            900
                    );
        }

        return DashboardScene;
    }

    // =========================================================
    // NAVIGATION
    // =========================================================

    private void navigate(
            String page
    ) {

        if (page == null ||
                page.isBlank()) {

            return;
        }

        currentPage = page;

        // =====================================================
        // DASHBOARD
        // =====================================================

        if (page.equals("Dashboard")) {

            showDashboard();

            return;
        }

        // =====================================================
        // CACHE
        // =====================================================

        Node cachedPage =
                pageCache.get(page);

        if (cachedPage != null) {

            showPage(
                    cachedPage
            );

            updateSidebarForPage(
                    page
            );

            return;
        }

        // =====================================================
        // CREATE PAGE
        // =====================================================

        Node pageRoot = null;

        switch (page) {

            // -------------------------------------------------
            // MEMBERSHIP PACKAGES
            // -------------------------------------------------

            case "Membership Packages":

                MembershipPackages membership =
                        new MembershipPackages();

                pageRoot =
                        membership
                                .getMembershipPackagesScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // TRAINERS
            // -------------------------------------------------

            case "Trainers":

                TrainerMang trainer =
                        new TrainerMang();

                pageRoot =
                        trainer
                                .getTrainerMangScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // FACILITIES
            // -------------------------------------------------

            case "Facilities":

                Facilities facilities =
                        new Facilities();

                pageRoot =
                        facilities
                                .getFacilitiesScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // MEMBERSHIP REQUESTS
            // -------------------------------------------------

            case "Membership Requests":

                MembershipRequests requests =
                        new MembershipRequests();

                pageRoot =
                        requests
                                .getMembershipRequestsScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // OFFERS
            // -------------------------------------------------

            case "Offers":

                Offers offers =
                        new Offers();

                pageRoot =
                        offers
                                .getOffersScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // REVIEWS
            // -------------------------------------------------

            case "Reviews":

                Reviews reviews =
                        new Reviews();

                pageRoot =
                        reviews
                                .getReviewsScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // LEADERBOARD
            // -------------------------------------------------

            case "Leaderboard":

                Leaderboard leaderboard =
                        new Leaderboard();

                pageRoot =
                        leaderboard
                                .getLeaderboardScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // ANALYTICS
            // -------------------------------------------------

            case "Analytics":

                Analytics analytics =
                        new Analytics();

                pageRoot =
                        analytics
                                .getAnalyticsScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // AI INSIGHTS
            // -------------------------------------------------

            case "AI Insights":

                AIInsights ai =
                        new AIInsights();

                pageRoot =
                        ai
                                .getAIAnalyticsScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // NOTIFICATIONS
            // -------------------------------------------------

            case "Notifications":

                Notifications notifications =
                        new Notifications();

                pageRoot =
                        notifications
                                .getNotificationsScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // SETTINGS
            // -------------------------------------------------

            case "Settings":

                Settings settings =
                        new Settings();

                pageRoot =
                        settings
                                .getSettingsScene(
                                        this::backToDashboard
                                )
                                .getRoot();

                break;

            // -------------------------------------------------
            // DEFAULT
            // -------------------------------------------------

            default:

                System.out.println(
                        "Unknown page: " +
                        page
                );

                return;
        }

        // =====================================================
        // CACHE & SHOW
        // =====================================================

        if (pageRoot != null) {

            pageCache.put(
                    page,
                    pageRoot
            );

            showPage(
                    pageRoot
            );

            updateSidebarForPage(
                    page
            );
        }
    }

    // =========================================================
    // SHOW PAGE
    // =========================================================

    private void showPage(
            Node pageRoot
    ) {

        if (pageRoot == null ||
                contentArea == null) {

            return;
        }

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                pageRoot
        );

        if (pageRoot instanceof Region) {

            Region region =
                    (Region) pageRoot;

            region.setMaxWidth(
                    Double.MAX_VALUE
            );

            region.setMaxHeight(
                    Double.MAX_VALUE
            );
        }

        contentArea.requestFocus();
    }

    // =========================================================
    // SHOW DASHBOARD
    // =========================================================

    private void showDashboard() {

        currentPage =
                "Dashboard";

        if (contentArea == null) {
            return;
        }

        contentArea.getChildren().clear();

        if (dashboardContent == null) {

            dashboardContent =
                    createDashboardContent();
        }

        contentArea.getChildren().add(
                dashboardContent
        );

        updateSidebarForPage(
                "Dashboard"
        );
    }

    // =========================================================
    // UPDATE SIDEBAR ACTIVE ITEM
    // =========================================================

    private void updateSidebarForPage(
            String page
    ) {

        if (sidebar == null ||
                sidebar.getChildren().size() < 2) {

            return;
        }

        Node navNode =
                sidebar.getChildren().get(1);

        if (!(navNode instanceof ScrollPane)) {
            return;
        }

        ScrollPane navScroll =
                (ScrollPane) navNode;

        Node navContent =
                navScroll.getContent();

        if (!(navContent instanceof VBox)) {
            return;
        }

        VBox nav =
                (VBox) navContent;

        boolean found = false;

        for (Node node :
                nav.getChildren()) {

            if (!(node instanceof HBox)) {
                continue;
            }

            HBox item =
                    (HBox) node;

            if (item.getChildren().size() < 2) {
                continue;
            }

            Node textNode =
                    item.getChildren().get(1);

            if (!(textNode instanceof Label)) {
                continue;
            }

            Label text =
                    (Label) textNode;

            if (text.getText().equals(page)) {

                Node iconNode =
                        item.getChildren().get(0);

                if (iconNode instanceof Label) {

                    setActiveNavItem(
                            item,
                            (Label) iconNode,
                            text
                    );

                    found = true;
                }

                break;
            }
        }

        /*
         * Notifications and Settings are not
         * sidebar items, so keep previous sidebar
         * selection when those pages are open.
         */

        if (!found &&
                !page.equals("Notifications") &&
                !page.equals("Settings")) {

            activeNavBox = null;
            activeIconLabel = null;
            activeTextLabel = null;
        }
    }

    // =========================================================
    // BACK TO DASHBOARD
    // =========================================================

    public void backToDashboard() {

        showDashboard();
    }

    // =========================================================
    // OPTIONAL PUBLIC NAVIGATION
    // =========================================================

    public void openNotifications() {

        navigate(
                "Notifications"
        );
    }

    public void openSettings() {

        navigate(
                "Settings"
        );
    }

    public void openDashboard() {

        navigate(
                "Dashboard"
        );
    }

//     @Override
//     public void start(Stage primaryStage) {


    
// }
}

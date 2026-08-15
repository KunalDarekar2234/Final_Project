package com.visionx.view;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SplashScreen extends Application {

    public static Stage primaryStage;
    private Scene splashScene;
    @Override
    public void start(Stage primaryStage) {
        SplashScreen.primaryStage = primaryStage;

        /*
         * =========================================
         * FITNESS FREAK LOGO
         * =========================================
         */

        InputStream logoStream =
                getClass().getResourceAsStream(
                        "/assets/images/logo.jpeg"
                );

        ImageView logoView = new ImageView();

        if (logoStream != null) {

            Image logoImage =
                    new Image(logoStream);

            logoView.setImage(logoImage);

            logoView.setFitWidth(300);
            logoView.setFitHeight(300);

            logoView.setPreserveRatio(true);
        }


        /*
         * =========================================
         * WELCOME TEXT
         * =========================================
         */

        Text welcomeText =
                new Text("Welcome to Fitness Freak");

        welcomeText.setStyle(
                "-fx-fill: white;" +
                "-fx-font-size: 38px;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Arial';"
        );


        /*
         * =========================================
         * AI POWERED TEXT
         * =========================================
         */

        Text poweredText =
                new Text("AI POWERED FITNESS ECOSYSTEM");

        poweredText.setStyle(
                "-fx-fill: #00e676;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Arial';"
        );


        /*
         * =========================================
         * WELCOME MESSAGE
         * =========================================
         */

        Text messageText =
                new Text(
                        "Your journey towards a healthier,\n" +
                        "stronger and better lifestyle starts here."
                );

        messageText.setStyle(
                "-fx-fill: #9da3ae;" +
                "-fx-font-size: 16px;" +
                "-fx-font-family: 'Arial';"
        );

        messageText.setTextAlignment(
                javafx.scene.text.TextAlignment.CENTER
        );


        /*
         * =========================================
         * SPLASH CONTENT
         * =========================================
         */

        VBox vbox =
                new VBox(
                        20,
                        logoView,
                        welcomeText,
                        poweredText,
                        messageText
                );

        vbox.setAlignment(
                Pos.CENTER
        );

        vbox.setPrefSize(
                1200,
                800
        );

        vbox.setStyle(
                "-fx-background-color: #0f1014;"
        );


        /*
         * =========================================
         * SCENE
         * =========================================
         */

        Scene scene =
                new Scene(
                        vbox,
                        primaryStage.getWidth(),
                        primaryStage.getHeight()
                );

        primaryStage.setMaximized(true);

        scene.setFill(
                Color.web("#0f1014")
        );


        /*
         * =========================================
         * STAGE
         * =========================================
         */

        primaryStage.setTitle(
                "Fitness Freak"
        );



        primaryStage.setScene(
                scene
        );

        primaryStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> {
            // LoginPage.primaryStage = primaryStage;
            LoginPage loginPage = new LoginPage();
            primaryStage.setScene(loginPage.getLoginScene(null));
        });
        delay.play();

    }
}
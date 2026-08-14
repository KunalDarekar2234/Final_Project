package com.visionx.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class WorkoutExecutionView {

    private int currentExercise = 1;
    private int totalExercises = 10;

    private int remainingSeconds = 45;

    private Timeline timer;

    public Scene getWorkoutExecutionScene(Runnable callback) {

        BorderPane root = new BorderPane();

        root.setStyle(
            "-fx-background-color: #080C14;"
        );

        // ==========================================
        // MAIN CONTAINER
        // ==========================================

        VBox container = new VBox(25);

        container.setMaxWidth(650);
        container.setPadding(new Insets(30));

        container.setStyle(
            "-fx-background-color: #0E1422;" +
            "-fx-background-radius: 25px;" +
            "-fx-border-color: #283247;" +
            "-fx-border-radius: 25px;"
        );

        // ==========================================
        // HEADER
        // ==========================================

        HBox header = new HBox();

        header.setAlignment(Pos.CENTER_LEFT);

        Text liveText = new Text(
            "⌁  LIVE EXECUTION ENGINE"
        );

        liveText.setStyle(
            "-fx-fill: #00ff91;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;"
        );

        Text exerciseNumber =
                new Text("Exercise 1 of 10");

        exerciseNumber.setStyle(
            "-fx-fill: #8a94a8;" +
            "-fx-font-size: 12px;"
        );

        HBox.setMargin(
            exerciseNumber,
            new Insets(0, 0, 0, 250)
        );

        header.getChildren().addAll(
            liveText,
            exerciseNumber
        );

        // ==========================================
        // EXERCISE NAME
        // ==========================================

        Text exerciseName =
                new Text("Dynamic Warm-up");

        exerciseName.setStyle(
            "-fx-fill: white;" +
            "-fx-font-size: 26px;" +
            "-fx-font-weight: bold;"
        );

        Text exerciseDetails =
                new Text(
                    "1 Sets × 5 minutes Reps • Bodyweight"
                );

        exerciseDetails.setStyle(
            "-fx-fill: #00ff91;" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;"
        );

        // ==========================================
        // REST TIMER BOX
        // ==========================================

        VBox timerBox = new VBox(12);

        timerBox.setAlignment(Pos.CENTER);

        timerBox.setPadding(
            new Insets(30)
        );

        timerBox.setStyle(
            "-fx-background-color: #11192B;" +
            "-fx-background-radius: 18px;" +
            "-fx-border-color: #26324A;" +
            "-fx-border-radius: 18px;"
        );

        Text timerTitle =
                new Text("REST INTERVAL COUNTDOWN");

        timerTitle.setStyle(
            "-fx-fill: #8a94a8;" +
            "-fx-font-size: 12px;" +
            "-fx-font-weight: bold;"
        );

        Label timerLabel =
                new Label("00:45");

        timerLabel.setStyle(
            "-fx-text-fill: #00ff91;" +
            "-fx-font-size: 46px;" +
            "-fx-font-weight: bold;"
        );

        // ==========================================
        // TIMER BUTTONS
        // ==========================================

        Button startTimer =
                new Button("▶");

        Button resetTimer =
                new Button("↻");

        String timerButtonStyle =
            "-fx-background-color: #1D2A40;" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 12px;" +
            "-fx-font-size: 18px;" +
            "-fx-min-width: 40px;" +
            "-fx-min-height: 40px;";

        startTimer.setStyle(timerButtonStyle);
        resetTimer.setStyle(timerButtonStyle);

        HBox timerButtons =
                new HBox(
                    12,
                    startTimer,
                    resetTimer
                );

        timerButtons.setAlignment(
            Pos.CENTER
        );

        timerBox.getChildren().addAll(
            timerTitle,
            timerLabel,
            timerButtons
        );

        // ==========================================
        // SET TRACKER
        // ==========================================

        Text setTitle =
                new Text("Track Completed Sets:");

        setTitle.setStyle(
            "-fx-fill: #ffffff;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;"
        );

        HBox setsBox =
                new HBox(10);

        Button[] setButtons =
                new Button[4];

        for (int i = 0; i < 4; i++) {

            final int index = i;

            Button setButton =
                    new Button("○ Set " + (i + 1));

            setButton.setMaxWidth(
                Double.MAX_VALUE
            );

            HBox.setHgrow(
                setButton,
                javafx.scene.layout.Priority.ALWAYS
            );

            setButton.setStyle(
                "-fx-background-color: #11192B;" +
                "-fx-text-fill: #8a94a8;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 12px;"
            );

            setButton.setOnAction(e -> {

                setButton.setText(
                    "✓ Set " + (index + 1)
                );

                setButton.setStyle(
                    "-fx-background-color: #00ff91;" +
                    "-fx-text-fill: #000000;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 12px;"
                );
            });

            setButtons[i] = setButton;

            setsBox.getChildren().add(
                setButton
            );
        }

        // ==========================================
        // NEXT EXERCISE
        // ==========================================

        Button nextExercise =
                new Button("Next Exercise →");

        nextExercise.setMaxWidth(
            Double.MAX_VALUE
        );

        nextExercise.setStyle(
            "-fx-background-color: #00ff91;" +
            "-fx-text-fill: #000000;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 14px;"
        );

        // ==========================================
        // NEXT EXERCISE ACTION
        // ==========================================

        nextExercise.setOnAction(e -> {

            if (currentExercise < totalExercises) {

                currentExercise++;

                exerciseNumber.setText(
                    "Exercise " +
                    currentExercise +
                    " of " +
                    totalExercises
                );

                exerciseName.setText(
                    "Exercise " +
                    currentExercise
                );

                resetTimer();

                for (int i = 0; i < 4; i++) {

                    setButtons[i].setText(
                        "○ Set " + (i + 1)
                    );

                    setButtons[i].setStyle(
                        "-fx-background-color: #11192B;" +
                        "-fx-text-fill: #8a94a8;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-padding: 12px;"
                    );
                }

            } else {

                callback.run();
            }
        });

        // ==========================================
        // TIMER LOGIC
        // ==========================================

        startTimer.setOnAction(e -> {

            if (timer != null) {
                timer.stop();
            }

            timer = new Timeline(
                new KeyFrame(
                    Duration.seconds(1),
                    event -> {

                        if (remainingSeconds > 0) {

                            remainingSeconds--;

                            int minutes =
                                    remainingSeconds / 60;

                            int seconds =
                                    remainingSeconds % 60;

                            timerLabel.setText(
                                String.format(
                                    "%02d:%02d",
                                    minutes,
                                    seconds
                                )
                            );

                        } else {

                            timer.stop();
                        }
                    }
                )
            );

            timer.setCycleCount(
                Timeline.INDEFINITE
            );

            timer.play();
        });

        resetTimer.setOnAction(e -> {

            resetTimer();
            timerLabel.setText("00:45");

        });

        // ==========================================
        // ADD EVERYTHING
        // ==========================================

        container.getChildren().addAll(
            header,
            exerciseName,
            exerciseDetails,
            timerBox,
            setTitle,
            setsBox,
            nextExercise
        );

        root.setCenter(container);

        BorderPane.setAlignment(
            container,
            Pos.CENTER
        );

        return new Scene(
            root,
            1200,
            800
        );
    }

    private void resetTimer() {

        if (timer != null) {
            timer.stop();
        }

        remainingSeconds = 45;
    }
}
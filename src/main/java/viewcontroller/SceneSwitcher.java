package main.java.viewcontroller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Class that functions as a dedicated Scene Switcher of the Javafx Scenes in the program.
// Used by: PrimaryController
// Uses: Delegates such responsibility for code reuse och cleanliness.

public class SceneSwitcher {

    // Parent stage
    private final Stage stage;

    // Constructor
    SceneSwitcher(Stage stage) {
        this.stage = stage;
        stage.setMinWidth(1140);
        stage.setMinHeight(900);
        stage.setMaximized(true);
        //stage.setFullScreen(true);
    }

    // Sets scene to given parent
    public void setScene(Parent parent) {
        boolean wasMax = stage.isMaximized();
        stage.setScene(new Scene(parent));
        stage.setMaximized(wasMax);

    }

    // Sets scene to given url
    public void setScene(String url) {
        Parent p;
        p = load(url);

        if (p != null) {
            setScene(p);
        }
    }

    // Sets scene to given scene
    public void setScene(Scene scene) {
        boolean wasMax = stage.isMaximized();
        stage.setScene(scene);
        stage.setMaximized(wasMax);
    }

    // Loads FXML-files and returns as parent
    private Parent load(String url) {
        try {
            return FXMLLoader.load(getClass().getResource(url));
        } catch (IOException e) {
            System.err.println("Failed to load resource in SceneSwitcher: " + url);
            System.err.println("Error message: " + e.getMessage());
            return null;
        }
    }

    // Method that loads a new scene and transitions to it
    void loadAndTransition(Parent newParent, AnchorPane root, Direction direction) {

        // Getting source scene
        Scene source;
        source = root.getScene();

        // Height of source
        double h = source.getHeight();

        // Creating the KeyValue
        KeyValue kv = null;

        // Interpolator value
        Interpolator interpolator;
        interpolator = Interpolator.EASE_BOTH;

        // Translating the newParent, based on direction
        if (direction == Direction.TOP) { // If top
            newParent.translateYProperty().set(-h);
            kv = new KeyValue(newParent.translateYProperty(), 0, interpolator);
        }
        if (direction == Direction.BOTTOM) { // If bottom
            newParent.translateYProperty().set(h);
            kv = new KeyValue(newParent.translateYProperty(), 0, interpolator);
        }

        // Adding the newParent to source stack pane
        StackPane sp;
        sp = (StackPane) root.getParent();
        sp.getChildren().add(newParent);

        // Creating the KeyFrame object
        KeyFrame kf;
        kf = new KeyFrame(Duration.seconds(0.2), kv);

        // Creating the TimeLine object
        Timeline timeline;
        timeline = new Timeline();
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event -> {
            sp.getChildren().remove(root);
        });

        // Playing the animation
        timeline.play();
    }
}

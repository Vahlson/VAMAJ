package main.java.viewcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Class that functions as a dedicated Scene Switcher of the Javafx Scenes in the program.
// Delegates such responsibility for code reuse och cleanliness.
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
        stage.setScene(new Scene(parent));
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
        stage.setScene(scene);
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
}

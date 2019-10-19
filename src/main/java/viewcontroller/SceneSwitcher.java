package main.java.viewcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Scene switcher class
public class SceneSwitcher {

    // Parent stage
    private final Stage stage;

    // Constructor
    SceneSwitcher(Stage stage) {
        this.stage = stage;
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

    // Loads FXML-files and returns as parent
    private Parent load(String url) {
        try {
            return FXMLLoader.load(getClass().getResource(url));
        } catch (IOException e) {
            System.err.println("Failed to load resource in SceneSwitcher: " + e.getMessage());
            return null;
        }
    }
}

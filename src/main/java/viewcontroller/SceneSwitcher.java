package main.java.viewcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Singleton class
// TODO
// Ask (arcsak) will refactor
public class SceneSwitcher {
    private static SceneSwitcher ourInstance = new SceneSwitcher();

    public static SceneSwitcher getInstance() {
        return ourInstance;
    }

    // Hidden constructor
    private SceneSwitcher() {
    }

    // Parent stage
    private Stage stage;

    // Sets the stage where scenes will be switched
    public void setStage(Stage stage) {
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
            e.printStackTrace();
            return null;
        }
    }
}

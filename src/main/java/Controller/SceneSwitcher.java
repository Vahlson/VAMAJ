package main.java.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Singleton class
public class SceneSwitcher implements Initializable {
    private static SceneSwitcher ourInstance = new SceneSwitcher();

    public static SceneSwitcher getInstance() {
        return ourInstance;
    }

    private SceneSwitcher() {
    }


    // Parent stage
    private Stage stage;

    // List of scenes (FXML-files) in here
    private Parent mainView;


    // Loading all FXML-files
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // mainView = load("main/java/View/resources/fxml/main.fxml");

    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Parent parent) {
        stage.setScene(new Scene(parent));
    }

    public void setScene(String url) {
        Parent p;
        p = load(url);

        if (p != null) {
            setScene(p);
        }
    }

    private Parent load(String url) {
        try {
            return FXMLLoader.load(getClass().getResource(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

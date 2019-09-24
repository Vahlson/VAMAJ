package main.java.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.Controller.SceneSwitcher;

public class Launcher extends Application {

    // JavaFX start method
    @Override
    public void start(Stage stage) throws Exception {

        // Sets the stage in scene switcher class
        SceneSwitcher.getInstance().setStage(stage);

        // Temporary GUI
        Parent p = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/main.fxml"));

        // Creating the scene (temp)
        Scene scene;
        scene = new Scene(p);

        // Creating the stage (temp)
        stage.setScene(scene);
        stage.setTitle("Solar Calculation App");
        stage.show();
    }
}
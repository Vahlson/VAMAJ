package main.java.viewcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {

    // JavaFX start method
    @Override
    public void start(Stage stage) throws Exception {

        // Sets the stage in scene switcher class
        SceneSwitcher.getInstance().setStage(stage);

        // Temporary GUI
        Parent p = FXMLLoader.load(getClass().getResource("/main/java/resources/fxml/mainscene.fxml"));

        // Creating the scene (temp)
        Scene scene;
        scene = new Scene(p);

        // Creating the stage (temp)
        stage.setScene(scene);
        stage.setTitle("Solar Calculation App");
        stage.show();
    }
}

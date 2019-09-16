package main.java;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SolarApp extends Application {

    // JavaFX start method
    @Override
    public void start(Stage stage) throws Exception {

        // Creating the group (temp)
        Group group;
        group = new Group();

        // Creating the scene (temp)
        Scene scene;
        scene = new Scene(group, 500, 500);

        // Creating the stage (temp)
        stage.setScene(scene);
        stage.setTitle("Solar Calculation App");
        stage.show();
    }
}

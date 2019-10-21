package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.views.MainViewController;


//The main class of the program, starts the program and initializes base components.
public class Main extends Application {
    public static void main(String[] args) {

        System.out.println("Launching the application...");

        // Launches the application (JavaFX)
        launch(args);
    }

    // Start method, launches the application and initializes all model components
    @Override
    public void start(Stage stage) {

        // Creating the model facade
        ModelFacade modelFacade;
        modelFacade = new ModelFacade();

        // Creating the primary controller
        new PrimaryController(modelFacade, stage);

        // Initializing an empty stage (window)
        stage.setTitle("Solar Calculation App");
        stage.show();
    }
}

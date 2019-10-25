package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.viewcontroller.PrimaryController;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility:
// Used by:
// Uses:

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: The main class of the program.
// Uses: starts the program and initializes base components.

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

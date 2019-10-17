
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelFacade;
import viewcontroller.PrimaryController;

public class Main extends Application {
    public static void main(String[] args) {

        System.out.println("Launching the application...");

        // Launches the application (JavaFX)
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Creating the model facade
        ModelFacade modelFacade;
        modelFacade = new ModelFacade();

        // Creating the primary controller
        new PrimaryController(modelFacade, stage);

        // Loads the parent FXML-File
        Parent p = FXMLLoader.load(getClass().getResource("/fxml/mainscene.fxml"));

        // Creating the scene (temp)
        Scene scene;
        scene = new Scene(p);

        // Creating the stage (temp)
        stage.setScene(scene);
        stage.setTitle("Solar Calculation App");
        stage.show();
    }
}

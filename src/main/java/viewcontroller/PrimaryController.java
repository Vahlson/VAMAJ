package main.java.viewcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.services.LocationCreator.LocationCreatorAPI;
import main.java.services.ServiceFacade;
import main.java.viewcontroller.views.MainViewController;
import main.java.viewcontroller.views.ResultViewController;

import java.io.IOException;
import java.util.Objects;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Holds the connections between the different view controllers and the model.
// Used by: Every class in the "views" package. Created at the start of the program, in main.
// Uses: To provide communication from the viewcontrollers to the model.

public class PrimaryController {

    // Member variables
    private SceneSwitcher sceneSwitcher;
    private ModelFacade modelFacade;
    private ServiceFacade serviceFacade;

    // Scenes
    private Scene mainView;
    private Scene resultView;

    // Constructor of the PrimaryController, a model facade and stage is passed as parameters upon creation so that
    //they are created and "live" in main instead.
    public PrimaryController(ModelFacade modelFacade, Stage stage) {
        this.modelFacade = modelFacade;
        this.sceneSwitcher = new SceneSwitcher(stage);
        this.serviceFacade = new ServiceFacade();

        // Sets scene to main view when first loading the program
        setScene(new Scene(Objects.requireNonNull(initComponent("/fxml/mainscene.fxml", new MainViewController(this)))));
    }

    //Initializes a component as the primary scene of the window.
    private Parent initComponent(String url, Object controller) {

        // Creating the FXMLLoader and loading the given url
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(url));
        loader.setController(controller);

        // Trying to return parent created from given FXML url
        try {
            Parent parent;
            parent = loader.load();
            return parent;
        } catch (IOException e) {
            System.err.println("Error in initComponent method (PrimaryController): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //Initializes a dynamic component with a controller.
    public void initDynamicComponent(String url, Object controller) {

        // Creating the FXMLLoader and loading the given url
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));
        fxmlLoader.setRoot(controller);
        fxmlLoader.setController(controller);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    // Method that configures text field to only accept numbers
    public void onlyNumbers(TextField tf) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                tf.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    // These are called from the separate view controllers.
    // Sets a location in the model with data gathered from an api and the lat,long from the parameters.
    // The api uses the latitude and longitude.
    public void setLocationFromAPI(double latitude, double longitude) {
        serviceFacade.setLocationCreator(new LocationCreatorAPI());
        serviceFacade.setLocationCreatorCoordinates(latitude, longitude);
        modelFacade.setLocation(serviceFacade.getLocation());
    }


    // Getters
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    public ServiceFacade getServiceFacade() {
        return serviceFacade;
    }

    //Switch scenes to the main view, using the sceneswitcher.
    public void goToMainView(AnchorPane root, Direction d) {

        Parent p;
        p = initComponent("/fxml/mainscene.fxml", new MainViewController(this));

        if (mainView == null) {


            mainView = new Scene(Objects.requireNonNull(p));
        }

        sceneSwitcher.loadAndTransition(p, root, d);

        modelFacade.clearData();
    }

    //Switch scenes to the result view, using the sceneswitcher.
    public void goToResultView(AnchorPane root, Direction d) {

        Parent p;
        p = initComponent("/fxml/resultscene.fxml", new ResultViewController(this));

        if (resultView == null) {
            resultView = new Scene(Objects.requireNonNull(p));
        }

        System.out.println();
        System.out.println(p);
        System.out.println(root);
        System.out.println(d);
        System.out.println();

        sceneSwitcher.loadAndTransition(p, root, d);

        // sceneSwitcher.setScene(resultView);
    }

    // SceneSwitcher delegation
    public void setScene(String url) {
        sceneSwitcher.setScene(url);
    }

    public void setScene(Parent parent) {
        sceneSwitcher.setScene(parent);
    }

    public void setScene(Scene scene) {
        sceneSwitcher.setScene(scene);
    }

    public void loadAndTransition(Parent p, AnchorPane root, Direction direction) {
        sceneSwitcher.loadAndTransition(p, root, direction);
    }
}

package main.java.viewcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.Main;
import main.java.model.ModelFacade;
import main.java.model.contract.Contract;
import main.java.services.ContractCreator.ContractCreatorAPI;
import main.java.services.LocationCreator.LocationCreatorAPI;
import main.java.services.ServiceFacade;
import main.java.viewcontroller.views.MainViewController;
import main.java.viewcontroller.views.ResultViewController;
import org.omg.CORBA.MARSHAL;

import javax.xml.transform.Result;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

// (3.1) Alexander Ask
//The primary controller holds the connections between the different view controllers and the model.
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

        // MAIN_VIEW = new Scene(new MainViewController(this));

        goToMainView();
    }

    private Scene initComponent(String url, Object controller) {

        // Creating the FXMLLoader and loading the given url
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(url));
        loader.setController(controller);

        // Trying to return parent created from given FXML url
        try {
            Parent parent;
            parent = loader.load();
            return new Scene(parent);
        } catch (IOException e) {
            System.err.println("Error in initComponent method (PrimaryController): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
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


    //These are called from the separate view controllers.
    // Setters (for API)
    void setLocationFromAPI(double latitude, double longitude) {
        serviceFacade.setLocationCreator(new LocationCreatorAPI());
        serviceFacade.setLocationCreatorCoordinates(latitude, longitude);
        modelFacade.setLocation(serviceFacade.getLocation());
    }

    void setContractFromAPI() {
        serviceFacade.setContractCreator(new ContractCreatorAPI());
        modelFacade.setContract(serviceFacade.getContract());
    }

    // Getters
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    public void goToMainView() {

        Scene mainView = initComponent("/fxml/mainscene.fxml", new MainViewController(this));
        setScene(mainView);

    }

    public void goToResultView() {
        Scene resultView = initComponent("/fxml/resultscene.fxml", new ResultViewController(this));
        setScene(resultView);
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
}

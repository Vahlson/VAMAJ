package main.java.viewcontroller;

import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.services.ServiceFacade;
import main.java.viewcontroller.SceneSwitcher;

// (3.1) Alexander Ask
public class PrimaryController {

    // Member variables
    private static SceneSwitcher sceneSwitcher;
    private ModelFacade modelFacade;
    private ServiceFacade serviceFacade = new ServiceFacade();

    // Hidden constructor
    public PrimaryController(ModelFacade modelFacade, Stage stage) {
        this.modelFacade = modelFacade;
        sceneSwitcher = new SceneSwitcher(stage);
    }

    // Setters (for API)
    void setLocation(double latitude, double longitude) {
        serviceFacade.setLocationCreatorCoordinates(latitude, longitude);
        modelFacade.setLocation(serviceFacade.getLocation());
    }

    void setContract() {
        modelFacade.setContract(serviceFacade.getContract());
    }

    // Setters
    public void setServiceFacade(ServiceFacade facade) {
        this.serviceFacade = facade;
    }

    public void setModelFacade(ModelFacade facade) {
        this.modelFacade = facade;
    }

    public void setStage(Stage stage) {
    }

    // Getters
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    public SceneSwitcher getSceneSwitcher() {
        return sceneSwitcher;
    }

    public static void setScene(String url) {
        sceneSwitcher.setScene(url);
    }
}

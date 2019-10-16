package main.java.viewcontroller;

import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.services.ServiceFacade;

// (3.1) Alexander Ask
public class PrimaryController {

    // Member variables
    private static SceneSwitcher sceneSwitcher;
    private static ModelFacade modelFacade;
    private ServiceFacade serviceFacade = new ServiceFacade();

    // Hidden constructor
    public PrimaryController(ModelFacade modelFacade, Stage stage) {
        PrimaryController.modelFacade = modelFacade;
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

    // Getters
    public static ModelFacade getModelFacade() {
        return modelFacade;
    }

    public static void setScene(String url) {
        sceneSwitcher.setScene(url);
    }
}

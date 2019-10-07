package main.java.viewcontroller;

import main.java.model.ModelFacade;
import main.java.services.ServiceFacade;
import main.java.viewcontroller.SceneSwitcher;

// (3.1) Alexander Ask
public class PrimaryController {

    private static PrimaryController ourInstance = new PrimaryController();

    public static PrimaryController getInstance() {
        return ourInstance;
    }

    // Hidden constructor
    private PrimaryController() {
    }

    // Member variables
    private SceneSwitcher sceneSwitcher = SceneSwitcher.getInstance();
    private ServiceFacade serviceFacade;
    private ModelFacade modelFacade;

    // Setters (for API)
    void setLocation(double latitude, double longitude) {
        serviceFacade.setLocationCreatorCoordinates(latitude, longitude);
        modelFacade.setLocation(serviceFacade.getLocation());
    }

    void setContract() {
        modelFacade.setContract(serviceFacade.getContract());
    }

    // Getters
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    public SceneSwitcher getSceneSwitcher() {
        return sceneSwitcher;
    }
}

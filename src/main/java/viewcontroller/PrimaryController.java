package viewcontroller;

import javafx.stage.Stage;
import model.ModelFacade;
import services.ServiceFacade;
import viewcontroller.SceneSwitcher;

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
    private ServiceFacade serviceFacade = new ServiceFacade();
    private ModelFacade modelFacade = new ModelFacade();
    private Stage stage;

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
        this.stage = stage;
    }

    // Getters
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    public SceneSwitcher getSceneSwitcher() {
        return sceneSwitcher;
    }
}

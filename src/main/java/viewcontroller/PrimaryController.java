package main.java.viewcontroller;

import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.services.ContractCreator.ContractCreatorAPI;
import main.java.services.LocationCreator.LocationCreatorAPI;
import main.java.services.ServiceFacade;

// (3.1) Alexander Ask
//The primary controller holds the connections between the different view controllers and the model.
public class PrimaryController {

    // Member variables
    private static SceneSwitcher sceneSwitcher;
    private ModelFacade modelFacade;
    private ServiceFacade serviceFacade;

    //Construcor of the PrimaryController, a model facade and stage is passed as parameters upon creation so that
    //they are created and "live" in main instead.
    public PrimaryController(ModelFacade modelFacade, Stage stage) {
        this.modelFacade = modelFacade;
        sceneSwitcher = new SceneSwitcher(stage);
        serviceFacade = new ServiceFacade();

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

    public static void setScene(String url) {
        sceneSwitcher.setScene(url);
    }
}

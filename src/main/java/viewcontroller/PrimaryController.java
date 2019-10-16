package main.java.viewcontroller;

import javafx.stage.Stage;
import main.java.model.ModelFacade;
import main.java.services.ContractCreator.ContractCreatorAPI;
import main.java.services.LocationCreator.LocationCreatorAPI;
import main.java.services.ServiceFacade;
import main.java.viewcontroller.SceneSwitcher;

// (3.1) Alexander Ask
public class PrimaryController {

    // Member variables
    private SceneSwitcher sceneSwitcher;
    private ServiceFacade serviceFacade;
    private ModelFacade modelFacade;
    private Stage stage;

    // Hidden constructor
    public PrimaryController() {
        sceneSwitcher = new SceneSwitcher();
        serviceFacade = new ServiceFacade();
    }



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

    // Setters
    public void setModelFacade(ModelFacade facade) {
        this.modelFacade = facade;
    }

//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }


    // Getters
    ModelFacade getModelFacade() {
        return modelFacade;
    }

    public SceneSwitcher getSceneSwitcher(){
        return this.sceneSwitcher;
    }

}

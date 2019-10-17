package viewcontroller;

import javafx.stage.Stage;
import model.ModelFacade;
import services.ContractCreator.ContractCreatorAPI;
import services.LocationCreator.LocationCreatorAPI;
import services.ServiceFacade;

// (3.1) Alexander Ask
public class PrimaryController {

    // Member variables
    private static SceneSwitcher sceneSwitcher;
    private ModelFacade modelFacade;
    private ServiceFacade serviceFacade;

    // Hidden constructor
    public PrimaryController(ModelFacade modelFacade, Stage stage) {
        this.modelFacade = modelFacade;
        sceneSwitcher = new SceneSwitcher(stage);
        serviceFacade = new ServiceFacade();

    }


    //TODO ADD MORE FUNCTIONS THAT COMMUNICATE WITH THE REST OF THE PROGRAM
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

    // Setters



    // Getters
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    public static void setScene(String url) {
        sceneSwitcher.setScene(url);
    }
}

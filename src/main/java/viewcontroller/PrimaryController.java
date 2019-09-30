package main.java.viewcontroller;

import main.java.model.ModelFacade;
import main.java.model.Property.Location;
import main.java.services.ServiceFacade;

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

    // Setters
    void setLocation() {
        Location l;
        l = serviceFacade.getLocation();

        modelFacade.setLocation(l);
    }

}

package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.java.viewcontroller.PrimaryController;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Controller for a question component that gathers the users location.
// Used by: MainViewController.
// Uses: Gathers information about the users location.

public class FindLocationViewController extends AnchorPane {

    private PrimaryController primaryController;

    @FXML
    private Text cityText;

    @FXML
    private Button findlocationButton;

    @FXML
    private HBox loadingAnimation;

    private boolean dataGathering;
    private boolean dataIsGathered = false;

    public FindLocationViewController(PrimaryController primaryController) {

        this.primaryController = primaryController;

        //Initialize this controller as a javafx node while coupling it with a fxml
        primaryController.initDynamicComponent("/fxml/dynamic/locationfinder.fxml", this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);


        //Shows updates location and shows location in gui
        findlocationButton.setOnMouseClicked(event -> {

            dataGathering = true;
            loadingAnimation.setVisible(true);

            LocationGatheringThread lgt = new LocationGatheringThread();
            lgt.start();


        });


    }

    //Returns true if data is currently being gathered.
    public boolean isGatheringData() {
        return dataGathering;
    }

    //Returns true if all required data has been gathered.
    public boolean isDataGathered() {
        return dataIsGathered;
    }

    //Thread for location gathering.
    public class LocationGatheringThread extends Thread {

        public void run() {
            //Get the city name from API.
            String city;
            city = primaryController.getServiceFacade().getCity();

            //get latitude and longitude from the model
            double latitude = primaryController.getServiceFacade().getLatitude();
            double longitude = primaryController.getServiceFacade().getLongitude();

            //primaryController.getModelFacade().getLocation().setCoordinate(latitude, longitude);
            primaryController.setLocationFromAPI(latitude, longitude);

            //display the result
            cityText.setText(city);
            //Hide loading animation.
            dataIsGathered = true;
            dataGathering = false;
            loadingAnimation.setVisible(false);
        }
    }
}

package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.views.MainViewController;

//Controller for a question component that gathers the users location
public class FindLocationViewController extends AnchorPane {

    private PrimaryController primaryController;

    @FXML
    private Text cityText;

    @FXML
    private Button findlocationButton;

    public FindLocationViewController(PrimaryController primaryController) {

        this.primaryController = primaryController;

        //Initialize this controller as a javafx node while coupling it with a fxml
        primaryController.initDynamicComponent("/fxml/dynamic/locationfinder.fxml",this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);

        //Shows updates location and shows location in gui
        findlocationButton.setOnAction(event -> {
            String city;
            city = primaryController.getServiceFacade().getCity();
            cityText.setText(city);


            double latitude = primaryController.getServiceFacade().getLatitude();
            double longitude = primaryController.getServiceFacade().getLongitude();

            //primaryController.getModelFacade().getLocation().setCoordinate(latitude, longitude);
            primaryController.setLocationFromAPI(latitude,longitude);


        });
    }
}

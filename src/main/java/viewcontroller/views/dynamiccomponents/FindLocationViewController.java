package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.java.viewcontroller.views.MainViewController;

public class FindLocationViewController extends AnchorPane {

    private MainViewController parentController;

    @FXML
    private Text cityText;

    @FXML
    private Button findlocationButton;

    public FindLocationViewController(MainViewController parentController) {

        this.parentController = parentController;

        //Initialize this controller as a javafx node while coupling it with a fxml
        parentController.getPrimaryController().initDynamicComponent("/fxml/dynamic/locationfinder.fxml",this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);

        //Shows updates location and shows location in gui
        findlocationButton.setOnAction(event -> {
            String city;
            city = parentController.getPrimaryController().getServiceFacade().getCity();
            cityText.setText(city);


            double latitude = parentController.getPrimaryController().getServiceFacade().getLatitude();
            double longitude = parentController.getPrimaryController().getServiceFacade().getLongitude();

            parentController.getPrimaryController().getModelFacade().getLocation().setCoordinate(latitude, longitude);

        });
    }
}

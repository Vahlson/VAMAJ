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

        parentController.getPrimaryController().initDynamicComponent("/fxml/dynamic/locationfinder.fxml",this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);

        findlocationButton.setOnAction(event -> {
            String city;
            city = parentController.getPrimaryController().getServiceFacade().getCity();
            cityText.setText(city);

            System.out.println("one");

            double latitude = parentController.getPrimaryController().getServiceFacade().getLatitude();
            double longitude = parentController.getPrimaryController().getServiceFacade().getLongitude();

            System.out.println("two");

            parentController.getPrimaryController().getServiceFacade().getLocation().setCoordinate(latitude, longitude);

            System.out.println("three");
        });
    }
}

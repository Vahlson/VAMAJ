package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.PrimaryController;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Question about available space of the potential solarinstallation.
// Used by: MainViewController.
// Uses: Gathers information about the users available space.

public class SpaceQuestionViewController extends AnchorPane {

    PrimaryController primaryController;

    @FXML
    private TextField availablespace;

    private boolean dataIsGathered = false;

    public SpaceQuestionViewController(PrimaryController primaryController) {

        this.primaryController = primaryController;

        //initialize this controller as a javafx node while coupling it with a fxml.
        primaryController.initDynamicComponent("/fxml/dynamic/spacequestion.fxml", this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);

        //Require that input is of only numbers.
        primaryController.onlyNumbers(availablespace);

        //Set values in model upon losing of focus of text field.
        availablespace.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                double spaceValue;

                if (!availablespace.getText().isEmpty()) {
                    spaceValue = Double.valueOf(availablespace.getText());
                    dataIsGathered = true;
                } else {
                    //default to 0.
                    spaceValue = 0;
                    dataIsGathered = false;
                }
                //Set the available space value in the model.
                primaryController.getModelFacade().getSolarSetup().setAvailableSpace(spaceValue);

            }
        });


    }

    //Returns true if all required data has been gathered.
    public boolean isDataGathered() {
        return dataIsGathered;
    }

}

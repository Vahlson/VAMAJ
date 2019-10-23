package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.views.MainViewController;

//Question about available space of the potential solarinstallation.
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


        primaryController.onlyNumbers(availablespace);


        availablespace.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                double spaceValue;

                if(!availablespace.getText().isEmpty()) {
                    spaceValue = Double.valueOf(availablespace.getText());
                    dataIsGathered = true;
                }else{
                    //default to 0.
                    spaceValue = 0;
                    dataIsGathered = false;
                }

                primaryController.getModelFacade().getSolarSetup().setAvailableSpace(spaceValue);

            }
        });


    }

    public boolean isDataGathered(){
        return dataIsGathered;
    }

}

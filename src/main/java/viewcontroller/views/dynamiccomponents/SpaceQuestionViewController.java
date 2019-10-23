package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;

//Question about available space of the potential solarinstallation.
public class SpaceQuestionViewController extends AnchorPane {

    MainViewController parentController;

    @FXML
    private TextField availablespace;


    public SpaceQuestionViewController(MainViewController parentController) {

        this.parentController = parentController;

        //initialize this controller as a javafx node while coupling it with a fxml.
        parentController.getPrimaryController().initDynamicComponent("/fxml/dynamic/spacequestion.fxml", this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);


        parentController.getPrimaryController().onlyNumbers(availablespace);


        availablespace.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                double spaceValue;

                if(!availablespace.getText().isEmpty()) {
                    spaceValue = Double.valueOf(availablespace.getText());
                }else{
                    //default to 0.
                    spaceValue = 0;
                }

                parentController.getPrimaryController().getModelFacade().getSolarSetup().setAvailableSpace(spaceValue);

            }
        });


    }

}

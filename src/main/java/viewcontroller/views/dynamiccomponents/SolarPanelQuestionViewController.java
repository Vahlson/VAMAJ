package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.PrimaryController;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Question about the wanted type of solar panel.
// Used by: MainViewController.
// Uses: Gathers information about the users solar panel preference.

public class SolarPanelQuestionViewController extends AnchorPane {


    @FXML
    private RadioButton standardRadio;

    @FXML
    private RadioButton premiumRadio;


    PrimaryController primaryController;

    public SolarPanelQuestionViewController(PrimaryController primaryController) {

        this.primaryController = primaryController;

        //initialize this controller as a javafx node while coupling it with a fxml.
        primaryController.initDynamicComponent("/fxml/dynamic/SolarPanelQuestion.fxml", this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);

        //Initialize togglegroup.
        ToggleGroup tg = new ToggleGroup();
        premiumRadio.setToggleGroup(tg);
        standardRadio.setToggleGroup(tg);

        //Handle selection of item in toggleGroup
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (tg.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    if (selected.equals(premiumRadio)) {
                        // Set the solar panel type to premium in the model.
                        // This will mean different values for the solar panels.
                        // which means different values for the calculations

                        primaryController.getModelFacade().setSolarPanelsPremium();


                    } else {
                        // Set the solar panel type to standard in the model.
                        primaryController.getModelFacade().setSolarPanelsStandard();

                    }


                }
            }
        });


    }
}

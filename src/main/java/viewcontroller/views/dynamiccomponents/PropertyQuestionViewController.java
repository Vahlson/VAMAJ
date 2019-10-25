package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.java.model.contract.FixedContract;
import main.java.viewcontroller.PrimaryController;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Question about the users property.
// Used by: MainViewController.
// Uses: Gathers information about the users property.

public class PropertyQuestionViewController extends AnchorPane {
    PrimaryController primaryController;

    @FXML
    private RadioButton consumingRB;

    @FXML
    private RadioButton nonConsumingRB;

    @FXML
    private VBox contractQuestions;

    @FXML
    private TextField consumedElectricity;

    @FXML
    private TextField monthlyCost;

    private double electricity = 0;
    private double cost = 0;
    private boolean dataIsGathered;

    public PropertyQuestionViewController(PrimaryController primaryController) {
        this.primaryController = primaryController;

        //initialize this controller as a javafx node while coupling it with a fxml.
        primaryController.initDynamicComponent("/fxml/dynamic/propertyquestion.fxml", this);

        //Match width to parent.
        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);

        //Initialize togglegroup.
        ToggleGroup tg = new ToggleGroup();
        consumingRB.setToggleGroup(tg);
        nonConsumingRB.setToggleGroup(tg);

        //Require that input is of only numbers.
        primaryController.onlyNumbers(consumedElectricity);
        primaryController.onlyNumbers(monthlyCost);


        //Set values in model upon losing of focus of text field.
        consumedElectricity.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                if (!consumedElectricity.getText().isEmpty()) {
                    electricity = Double.valueOf(consumedElectricity.getText());
                    dataIsGathered = true;
                } else {
                    // If text field is empty
                    //default to 0.
                    electricity = 0;
                    dataIsGathered = false;
                }
                primaryController.getModelFacade().getContract().setConsumedElectricity(electricity);

            }
        });
        monthlyCost.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                if (!monthlyCost.getText().isEmpty()) {
                    cost = Double.valueOf(monthlyCost.getText());
                    dataIsGathered = true;
                } else {
                    //default to 0.
                    cost = 0;
                    dataIsGathered = false;
                }
                primaryController.getModelFacade().getContract().setMonthlyCost(cost);

            }
        });


        //Handle selection of item in toggleGroup
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (tg.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    if (selected.equals(consumingRB)) {
                        // Selection of the consuming property.
                        // Set the users property to consuming and give it a contract with the values set in the input fields
                        dataIsGathered = checkFieldsForData();
                        contractQuestions.setDisable(false);
                        primaryController.getModelFacade().setPropertyConsuming();
                        primaryController.getModelFacade().setContract(new FixedContract(cost, electricity));

                    } else {
                        //Changes the property to nonconsuming which assumes a contract with zero cost and zero consumed electricity.
                        contractQuestions.setDisable(true);
                        primaryController.getModelFacade().setPropertyNonConsuming();
                        dataIsGathered = true;


                    }

                }
            }


        });
    }

    //Returns true if all required data has been gathered.
    public boolean isDataGathered() {
        return dataIsGathered;
    }

    //Checking that all required data has been gathered.
    private boolean checkFieldsForData() {
        return (!monthlyCost.getText().isEmpty()) && (!consumedElectricity.getText().isEmpty());
    }
}

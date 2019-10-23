package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.java.model.contract.FixedContract;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

//Question about the users property.
public class PropertyQuestionViewController extends AnchorPane {
    MainViewController parentController;

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

    public PropertyQuestionViewController(MainViewController parentController){
        this.parentController = parentController;

        //initialize this controller as a javafx node while coupling it with a fxml.
        parentController.getPrimaryController().initDynamicComponent("/fxml/dynamic/propertyquestion.fxml",this);

        //Match width to parent.
        setLeftAnchor(this,0.0);
        setRightAnchor(this,0.0);

        //Initialize togglegroup.
        ToggleGroup tg = new ToggleGroup();
        consumingRB.setToggleGroup(tg);
        nonConsumingRB.setToggleGroup(tg);


        parentController.getPrimaryController().onlyNumbers(consumedElectricity);
        parentController.getPrimaryController().onlyNumbers(monthlyCost);


        //Set values in model upon losing of focus of text field.
        consumedElectricity.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                if(!consumedElectricity.getText().isEmpty()) {
                    electricity = Double.valueOf(consumedElectricity.getText());
                }else{
                    //default to 0.
                    electricity = 0;
                }
                parentController.getPrimaryController().getModelFacade().getContract().setConsumedElectricity(electricity);

            }
        });
        monthlyCost.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                if(!monthlyCost.getText().isEmpty()) {
                    cost = Double.valueOf(monthlyCost.getText());
                }else{
                    //default to 0.
                    cost = 0;
                }
                parentController.getPrimaryController().getModelFacade().getContract().setMonthlyCost(cost);

            }
        });


        //Handle selection of item in toggleGroup
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (tg.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    if (selected.equals(consumingRB)) {
                        //Do something with consuming property.

                        contractQuestions.setDisable(false);
                        parentController.getPrimaryController().getModelFacade().setPropertyConsuming();
                        parentController.getPrimaryController().getModelFacade().setContract(new FixedContract(cost,electricity));


                    } else{
                        //Changes the property to nonconsuming which assumes a contract with zero cost and zero consumed electricity.
                        contractQuestions.setDisable(true);
                        parentController.getPrimaryController().getModelFacade().setPropertyNonConsuming();


                    }

                }
            }


        });
    }
}

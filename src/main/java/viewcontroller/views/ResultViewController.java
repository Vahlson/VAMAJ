package main.java.viewcontroller.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import main.java.model.calculator.DataKey;
import main.java.viewcontroller.PrimaryController;

import java.net.URL;
import java.util.ResourceBundle;

import static main.java.model.calculator.DataKey.*;

// The controller of the result view, the user ends up here upon calculation.
public class ResultViewController extends AnchorPane implements Initializable {

    // Member variables
    private PrimaryController primaryController;

    //  FXML-Components
    @FXML
    AnchorPane resultViewRoot;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextArea textArea3;

    @FXML
    private Button exitButton;

    public ResultViewController(PrimaryController primaryController) {
        this.primaryController = primaryController;

        // textArea1.setText("" + primaryController.getModelFacade().getCalculationResults(DataKey.INSTALLATION_COST));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fillResultView();
        //textArea1.appendText("" + primaryController.getModelFacade().getCalculationResults(DataKey.ANNUAL_ELECTRICITY_PRODUCTION));

    }

    public void fillResultView(){
        primaryController.getModelFacade().runCalculators();

        try {
            textArea1.appendText(INSTALLATION_COST.getDescription() +": "+ primaryController.getModelFacade().getCalculationResult(INSTALLATION_COST) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }
        try {
            textArea1.appendText(GOVERNMENT_SUBVENTION.getDescription() +": "+ primaryController.getModelFacade().getCalculationResult(GOVERNMENT_SUBVENTION) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }
        try {
            textArea1.appendText(SUBVENTED_INSTALLATION_COST.getDescription() +": "+ primaryController.getModelFacade().getCalculationResult(SUBVENTED_INSTALLATION_COST) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }

        try {
            textArea1.appendText(SURPLUS.getDescription() +": "+ primaryController.getModelFacade().getCalculationResult(SURPLUS) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }

        try {
            textArea1.appendText( LEVELIZED_ELECTRICITY_COST.getDescription() +": "+primaryController.getModelFacade().getCalculationResult(LEVELIZED_ELECTRICITY_COST) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }

        try {
            textArea1.appendText( SOLAR_PV_DAILY_ELECTRICITY.getDescription() +": "+primaryController.getModelFacade().getCalculationResult(SOLAR_PV_DAILY_ELECTRICITY) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }

        try {
            textArea1.appendText(YEARS_TO_BREAK_EVEN.getDescription() +": "+ primaryController.getModelFacade().getCalculationResult(YEARS_TO_BREAK_EVEN) + "\n");
        }catch (NullPointerException npe){
            textArea1.appendText(npe.getMessage());
        }



    }


    //Goes back to the main view.
    @FXML
    private void toMainView(ActionEvent event) {

        primaryController.goToMainView();
    }
}



package main.java.viewcontroller.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.PrimaryController;

import java.net.URL;
import java.util.ResourceBundle;

import static main.java.model.calculator.DataKey.*;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: The controller of the result view.
// Used by: The MainController calls the Primary Controller when data has been gathered.
// Uses: The user ends up here upon calculation. Displays calculated data to the user.
public class ResultViewController extends AnchorPane implements Initializable {

    //  FXML-Components
    @FXML
    AnchorPane resultViewRoot;
    // Member variables
    private PrimaryController primaryController;
    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private Button exitButton;

    public ResultViewController(PrimaryController primaryController) {
        this.primaryController = primaryController;

        // textArea1.setText("" + primaryController.getModelFacade().getCalculationResults(DataKey.INSTALLATION_COST));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea1.clear();
        fillResultView();
        //textArea1.appendText("" + primaryController.getModelFacade().getCalculationResults(DataKey.ANNUAL_ELECTRICITY_PRODUCTION));

    }

    public void fillResultView() {
        primaryController.getModelFacade().runCalculators();

        textArea1.appendText(INSTALLATION_COST.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(INSTALLATION_COST)) + " kr\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }

        textArea1.appendText(GOVERNMENT_SUBVENTION.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(GOVERNMENT_SUBVENTION)) + " kr\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }

        textArea1.appendText(SUBVENTED_INSTALLATION_COST.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(SUBVENTED_INSTALLATION_COST)) + " kr\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }

        textArea1.appendText(SURPLUS.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(SURPLUS)) + " kWh\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }

        textArea1.appendText(YEARS_TO_BREAK_EVEN.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(YEARS_TO_BREAK_EVEN)) + " år\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }

        textArea1.appendText(ANNUAL_OPERATION_COST.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(ANNUAL_OPERATION_COST)) + " kr\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }

        textArea1.appendText(ANNUAL_ELECTRICITY_PRODUCTION.getDescription() + "\n");
        try {
            textArea2.appendText(readableFormat(primaryController.getModelFacade().getCalculationResult(ANNUAL_ELECTRICITY_PRODUCTION)) + " kWh\n");
        } catch (NullPointerException npe) {
            textArea2.appendText(npe.getMessage());
        }


    }


    //Goes back to the main view.
    @FXML
    private void toMainView(ActionEvent event) {

        primaryController.goToMainView();

    }

    // Returns the received double as a readable String
    private String readableFormat(double unReadableDouble) {

        int unReadableInt = (int) unReadableDouble;
        String readableString = String.format("%,d", unReadableInt);

        return readableString;
    }
}



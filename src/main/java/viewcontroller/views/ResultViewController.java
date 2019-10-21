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

import static main.java.model.calculator.DataKey.INSTALLATION_COST;

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
        textArea1.appendText("" + primaryController.getModelFacade().getCalculationResult(INSTALLATION_COST));
    }


    //Goes back to the main view.
    @FXML
    private void toMainView(ActionEvent event) {

        primaryController.goToMainView();
    }
}



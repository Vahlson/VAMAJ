package viewcontroller.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import model.calculator.DataKey;
import viewcontroller.PrimaryController;
import viewcontroller.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultViewController extends AnchorPane implements Initializable {

    PrimaryController primaryController;

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

    public ResultViewController( ) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //textArea1.setText("" + primaryController.getModelFacade().getCalculationResults(DataKey.INSTALLATION_COST));
    }

    @FXML
    private void toMainView(ActionEvent event)  {

        PrimaryController.setScene("/fxml/mainscene.fxml");
    }
}



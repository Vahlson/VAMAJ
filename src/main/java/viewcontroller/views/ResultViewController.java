package main.java.viewcontroller.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.SceneSwitcher;

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

    public ResultViewController( PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //textArea1.setText(primaryController.ge);
    }

    @FXML
    private void toMainView(ActionEvent event)  {

        primaryController.getSceneSwitcher().setScene("/fxml/mainscene.fxml");

    }
}



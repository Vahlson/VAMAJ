package main.java.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import main.java.Controller.SceneSwitcher;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class resultView extends AnchorPane implements Initializable {

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

    public resultView( /*A controller to be added here*/) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void toMainView(ActionEvent event) throws IOException {
        // AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/main.fxml"));
        // resultViewRoot.getChildren().setAll(pane);

        SceneSwitcher.getInstance().setScene("/main/java/View/resources/fxml/main.fxml");
    }
}



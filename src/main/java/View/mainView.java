package main.java.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.java.Controller.SceneSwitcher;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainView extends AnchorPane implements Initializable {

    @FXML
    AnchorPane mainViewRoot;
    @FXML
    Button calculateButton;
    @FXML
    BorderPane mainViewPane;
    @FXML
    AnchorPane otherViewPane;  //temporarily  name, to be changed then

    public mainView( /*A controller to be added here*/) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private void test(ActionEvent event) throws IOException {
        // AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/result.fxml"));
        // mainViewRoot.getChildren().setAll(pane);

        Parent p;
        p = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/result.fxml"));
        SceneSwitcher.getInstance().setScene(p);
    }
}

package viewcontroller.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import viewcontroller.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultViewController extends AnchorPane implements Initializable {

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

    public ResultViewController( /*A controller to be added here*/) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void toMainView(ActionEvent event) throws IOException {
        // AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/mainscene.fxml"));
        // resultViewRoot.getChildren().setAll(pane);

        SceneSwitcher.getInstance().setScene("/fxml/mainscene.fxml");
    }
}



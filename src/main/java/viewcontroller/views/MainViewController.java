package main.java.viewcontroller.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.java.viewcontroller.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController extends AnchorPane implements Initializable {
    private int state = 0;
    Parent p;

    @FXML
    AnchorPane questionsAnchor;

    @FXML
    AnchorPane mainViewRoot;
    @FXML
    Button calculateButton;
    @FXML
    BorderPane mainViewPane;
    @FXML
    AnchorPane otherViewPane;  //temporarily  name, to be changed then

    @FXML
    private Button installationButton; // Button that leads to installation screen

    public MainViewController( /*A controller to be added here*/) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Temporary add to get mock functionality
        installationButton.setOnAction(event -> {
            SceneSwitcher.getInstance().setScene("/main/java/resources/fxml/installationscene.fxml");
        });

    }

    @FXML
    private void calculate(ActionEvent event) throws IOException {
        // AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/resultscene.fxml"));
        // mainViewRoot.getChildren().setAll(pane);

        Parent p;
        p = FXMLLoader.load(getClass().getResource("/main/java/resources/fxml/resultscene.fxml"));
        SceneSwitcher.getInstance().setScene(p);
    }
    @FXML
    private void startTest(ActionEvent event) throws IOException {



        p = FXMLLoader.load(getClass().getResource("/main/java/resources/fxml/dynamic/personalquestion.fxml"));

        questionsAnchor.getChildren().add(p);
    }

    //control back button navigation(to be completed and moved to more structured controller or maybe mutual interface)
    @FXML

    public void backNavigation() throws IOException {

        switch (state){
            case 0:
                p = FXMLLoader.load(getClass().getResource("/main/java/resources/fxml/dynamic/personalquestion.fxml"));

                questionsAnchor.getChildren().add(p);
                break;
            case 1:




        }


    }
    //control back button navigation(to be completed and moved to more structured controller or maybe mutual interface)
    @FXML

    public void nextNavigation() throws IOException {

        switch (state) {
            case 0:
                p = FXMLLoader.load(getClass().getResource("/main/java/resources/fxml/dynamic/propertyquestion.fxml"));

                questionsAnchor.getChildren().add(p);
                break;
            case 1:
                break;



        }

    }

}

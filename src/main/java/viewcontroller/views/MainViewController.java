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

    private Parent p;
    private int state;

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
    @FXML
    Button nextButton;
    @FXML
    Button backButton;

    public MainViewController( /*A controller to be added here*/) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nextButton.setDisable(true);
        backButton.setDisable(true);

        // Temporary add to get mock functionality
        installationButton.setOnAction(event -> {
            SceneSwitcher.getInstance().setScene("/fxml/installationscene.fxml");
        });

    }

    @FXML
    private void calculate(ActionEvent event) throws IOException {
        // AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/java/View/resources/fxml/resultscene.fxml"));
        // mainViewRoot.getChildren().setAll(pane);

        Parent p;
        p = FXMLLoader.load(getClass().getResource("/fxml/resultscene.fxml"));
        SceneSwitcher.getInstance().setScene(p);
    }

    @FXML
    private void startTest(ActionEvent event) throws IOException {


        p = FXMLLoader.load(getClass().getResource("/fxml/dynamic/personalquestion.fxml"));

        questionsAnchor.getChildren().add(p);
        nextButton.setDisable(false);
    }


    //controls next button navigation(to be completed and moved to more structured controller or maybe mutual interface)
    @FXML

    public void nextNavigation() throws IOException {
        switch (state)  {
            case 0:

                state = 1;
                p = FXMLLoader.load(getClass().getResource("/fxml/dynamic/propertyquestion.fxml"));

                questionsAnchor.getChildren().add(p);
                backButton.setDisable(false);


                break;
            case 1:
                state = 2;
                p = FXMLLoader.load(getClass().getResource("/fxml/dynamic/SolarPanelQuestion.fxml"));
                questionsAnchor.getChildren().add(p);
                break;


        }

    }

    //controls back button navigation(to be completed and moved to more structured controller or maybe mutual interface)
    @FXML

    public void backNavigation() throws IOException {

        switch (state) {
            case 0:
                break;

            case 1:
                state = 0;
                p = FXMLLoader.load(getClass().getResource("/fxml/dynamic/personalquestion.fxml"));

                questionsAnchor.getChildren().add(p);
                backButton.setDisable(true);

                break;
            case 2:
                state =1;
                p = FXMLLoader.load(getClass().getResource("/fxml/dynamic/propertyquestion.fxml"));

                questionsAnchor.getChildren().add(p);



        }


    }
}

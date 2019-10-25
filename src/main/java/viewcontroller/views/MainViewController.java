package main.java.viewcontroller.views;


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.views.dynamiccomponents.FindLocationViewController;
import main.java.viewcontroller.views.dynamiccomponents.PropertyQuestionViewController;
import main.java.viewcontroller.views.dynamiccomponents.SolarPanelQuestionViewController;
import main.java.viewcontroller.views.dynamiccomponents.SpaceQuestionViewController;

import java.net.URL;
import java.util.ResourceBundle;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: The controller of the main view of the program.
// Used by: Initialized in the primaryController and set as the current stage in the sceneSwitcher.
// Uses: Controls the interaction of the main view and communicates with the model through the primarycontroller.

public class MainViewController extends AnchorPane implements Initializable {
    SolarPanelQuestionViewController solarQ;
    SpaceQuestionViewController spaceQ;
    FindLocationViewController locationQ;
    PropertyQuestionViewController propertyQ;

    private int state = 0;
    private PrimaryController primaryController;

    @FXML
    private ScrollPane questionScrollPane;
    @FXML
    private VBox questionList;
    @FXML
    private Button calculateButton;
    @FXML
    private Button upNavigation;
    @FXML
    private Label questionNumber;
    @FXML
    private Button downNavigation;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private AnchorPane root;


    public MainViewController(PrimaryController controller) {
        this.primaryController = controller;
        System.out.println("in here");

    }

    public PrimaryController getPrimaryController() {
        return primaryController;
    }

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //clearing the list and initializing question indicator.
        questionList.getChildren().clear();
        questionNumber.setText(state + 1 + "/" + questionList.getChildren().size());

        //Adding questions to the list
        solarQ = new SolarPanelQuestionViewController(primaryController);
        spaceQ = new SpaceQuestionViewController(primaryController);
        locationQ = new FindLocationViewController(primaryController);
        propertyQ = new PropertyQuestionViewController(primaryController);

        questionList.getChildren().add(locationQ);
        questionList.getChildren().add(spaceQ);
        questionList.getChildren().add(solarQ);
        questionList.getChildren().add(propertyQ);

        //EVENTS for nodes of the program
        root.setOnKeyPressed(event -> {
            checkIfReadyForCalculation();

        });
        root.setOnMouseClicked(event -> {
            checkIfReadyForCalculation();

        });


        //go to resultpage and show results.
        calculateButton.setOnAction(event -> {
            primaryController.goToResultView();
        });

        //scroll to next question
        upNavigation.setOnAction(event -> {
            if (state > 0) {
                slowScrollToNode(--state);
            }
            questionNumber.setText(state + 1 + "/" + questionList.getChildren().size());

        });

        //scroll to previous question
        downNavigation.setOnAction(event -> {
            if (state < questionList.getChildren().size() - 1) {
                slowScrollToNode(++state);
            }
            questionNumber.setText(state + 1 + "/" + questionList.getChildren().size());

        });

    }


    //Scrolls the scrollbar to specified node. (doesnt work properly)
    private void slowScrollToNode(int node) {

        double scrollPaneHeight = questionList.getHeight();
        double nodeHeight = questionList.getChildren().get(node).getLayoutBounds().getHeight();
        double relativeY = questionList.getChildren().get(node).getBoundsInParent().getMinY() + nodeHeight;

        double scrollProcent = relativeY / scrollPaneHeight;

        System.out.println(scrollProcent);

        slowScrollToPosition(questionScrollPane, scrollProcent);

    }

    // scrolls scrollpane to specified percentage.
    private void slowScrollToPosition(ScrollPane scrollPane, double pos) {

        Animation animation = new Timeline(
                new KeyFrame(Duration.seconds(0.2), new KeyValue(scrollPane.vvalueProperty(), pos, Interpolator.EASE_BOTH)));

        animation.play();
    }

    //Checks each question for input.
    private void checkIfReadyForCalculation() {
        boolean spaceQready = spaceQ.isDataGathered();
        boolean propertyQReady = propertyQ.isDataGathered();

        //Also checks that data isnt currently being gathered from an API.
        boolean locationQReady = (!locationQ.isGatheringData()) && locationQ.isDataGathered();

        if (spaceQready && propertyQReady && locationQReady) {
            calculateButton.setDisable(false);
        } else {
            calculateButton.setDisable(true);
        }
    }

}

package main.java.viewcontroller.views;


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.views.dynamiccomponents.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//The controller of the main view of the program controls the interaction of the main view.
//Input and communication with the model is accessed through the primaryController.
public class MainViewController extends AnchorPane implements Initializable {
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
        questionList.getChildren().add(new FindLocationViewController(this));
        questionList.getChildren().add(new SpaceQuestionViewController(this));
        questionList.getChildren().add(new SolarPanelQuestionViewController(this));


        questionList.getChildren().add(new PropertyQuestionViewController(this));

        //EVENTS for nodes of the program

        //go to resultpage and show results.
        calculateButton.setOnAction(event -> {
            System.out.println("now");
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


}

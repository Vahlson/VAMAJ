package main.java.viewcontroller.views;


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.SceneSwitcher;
import main.java.viewcontroller.views.dynamiccomponents.PersonalQuestionViewController;
import main.java.viewcontroller.views.dynamiccomponents.PropertyQuestionViewController;
import main.java.viewcontroller.views.dynamiccomponents.SolarPanelQuestionViewController;
import main.java.viewcontroller.views.dynamiccomponents.SpaceQuestionViewController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController extends AnchorPane implements Initializable {
    private int state = 0;
    private PrimaryController primaryController;

    @FXML
    private Button calculateButton;
    @FXML
    private Button upNavigation;
    @FXML
    private Button downNavigation;
    @FXML
    private VBox questionList;
    @FXML
    private ScrollPane questionScrollPane;
    @FXML
    private Label questionNumber;
    @FXML
    ProgressBar progressBar;

    @FXML
    private Button installationButton; // Button that leads to installation screen

    public MainViewController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionList.getChildren().clear();
        questionNumber.setText(state + 1 + "/" + questionList.getChildren().size());
        //questionList.getChildren().add(new PersonalQuestionViewController(this));
        //TESTAR
        questionList.getChildren().add(new PersonalQuestionViewController(this));
        questionList.getChildren().add(new PropertyQuestionViewController(this));
        questionList.getChildren().add(new SolarPanelQuestionViewController(this));
        questionList.getChildren().add(new PropertyQuestionViewController(this));
        questionList.getChildren().add(new SpaceQuestionViewController(this));

        // Temporary add to get mock functionality
        installationButton.setOnAction(event -> {
            PrimaryController.setScene("/fxml/installationscene.fxml");
        });

        calculateButton.setOnAction(event -> {
            PrimaryController.setScene("/fxml/resultscene.fxml");
        });

        upNavigation.setOnAction(event -> {
            if (state > 0) {
                slowScrollToNode(--state);

            }

            questionNumber.setText(state + 1 + "/" + questionList.getChildren().size());


        });

        downNavigation.setOnAction(event -> {
            if (state < questionList.getChildren().size() - 1) {
                slowScrollToNode(++state);
            }
            System.out.println(state);


            questionNumber.setText(state + 1 + "/" + questionList.getChildren().size());

        });


    }

    private void slowScrollToNode(int node) {

        double scrollPaneHeight = questionList.getHeight();
        double nodeHeight = questionList.getChildren().get(node).getLayoutBounds().getHeight();
        double relativeY = questionList.getChildren().get(node).getBoundsInParent().getMinY() + nodeHeight;
        System.out.println(relativeY);
        System.out.println("scrollpaneHeight: " + scrollPaneHeight);
        System.out.println(questionList.getChildren().get(node));

        double scrollProcent = relativeY / scrollPaneHeight;

        System.out.println(scrollProcent);

            slowScrollToPosition(questionScrollPane, scrollProcent);

    }


    private void slowScrollToPosition(ScrollPane scrollPane, double pos) {

        Animation animation = new Timeline(
                new KeyFrame(Duration.seconds(0.2), new KeyValue(scrollPane.vvalueProperty(), pos, Interpolator.EASE_BOTH)));

        animation.play();
    }

    public void progressBarController() {


    }

}

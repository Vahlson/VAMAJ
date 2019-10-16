package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

public class SolarPanelQuestionViewController extends AnchorPane {


    MainViewController parentController;


    @FXML
    private ProgressBar progressBar;

    @FXML
    private RadioButton standardRadio;

    @FXML
    private RadioButton premiumRadio;

    @FXML
    private ImageView standardImage;

    @FXML
    private ImageView premiumImage;

    @FXML
    private Label standardName;

    @FXML
    private Label standardCost;

    @FXML
    private Label standardWattage;

    @FXML
    private Label premiumName;

    @FXML
    private Label premiumCost;

    @FXML
    private Label premiumWattage;

    PrimaryController controller;

    public SolarPanelQuestionViewController(MainViewController parentController) {


        this.parentController = parentController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dynamic/SolarPanelQuestion.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        setLeftAnchor(this, 0.0);
        setRightAnchor(this, 0.0);
        ToggleGroup tg = new ToggleGroup();
        premiumRadio.setToggleGroup(tg);
        standardRadio.setToggleGroup(tg);
        premiumImage.setImage(new Image("/icons/images/premium.jpg"));
        standardImage.setImage(new Image("/icons/images/standard.jpg"));


        tg.selectedToggleProperty().addListener(new ChangeListener <Toggle>() {

            @Override
            public void changed(ObservableValue <? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (tg.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    if (selected.equals(premiumRadio)) {

                        System.out.println(1);

                    } else
                        System.out.println(2);
                }
            }
        });


    }
}

package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.model.Calculator.Calculator;
import main.java.model.ModelAggregate;
import main.java.model.ModelFacade;
import main.java.model.SolarSetup.SolarPanel;
import main.java.viewcontroller.PrimaryController;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class SolarPanelQuestionViewController implements Initializable {



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

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        ToggleGroup tg = new ToggleGroup();
        premiumRadio.setToggleGroup(tg);
        standardRadio.setToggleGroup(tg);
        premiumImage.setImage(new Image("/main/resources/icons/images/premium.jpg"));
        standardImage.setImage(new Image("/main/resources/icons/images/standard.jpg"));


        tg.selectedToggleProperty().addListener(new ChangeListener <Toggle>() {

            @Override
            public void changed(ObservableValue <? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (tg.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    if (selected.equals(premiumRadio)){

                    }
                    else
                            System.out.println(2);
                }
            }
        });






    }







}

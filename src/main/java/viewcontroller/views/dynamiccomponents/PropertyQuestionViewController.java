package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PropertyQuestionViewController extends AnchorPane implements Initializable {
    @FXML
    private ProgressBar progressBar;

    @FXML
    private RadioButton consumingRB;

    @FXML
    private RadioButton nonConsumingRB;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup tg = new ToggleGroup();
        consumingRB.setToggleGroup(tg);
        nonConsumingRB.setToggleGroup(tg);


        tg.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {

            if (tg.getSelectedToggle() != null) {
                RadioButton selected = (RadioButton) tg.getSelectedToggle();

                if (selected.equals(consumingRB)){


                }
                else
                    System.out.println(1);
            }
        });
    }
}

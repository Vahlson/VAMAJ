package main.java.viewcontroller.views.dynamiccomponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

//Question about the users property.
public class PropertyQuestionViewController extends AnchorPane {
    MainViewController parentController;

    @FXML
    private RadioButton consumingRB;

    @FXML
    private RadioButton nonConsumingRB;

    public PropertyQuestionViewController(MainViewController parentController){
        this.parentController = parentController;

        //initialize this controller as a javafx node while coupling it with a fxml.
        parentController.getPrimaryController().initDynamicComponent("/fxml/dynamic/propertyquestion.fxml",this);


        //Match width to parent.
        setLeftAnchor(this,0.0);
        setRightAnchor(this,0.0);

        //Initialize togglegroup.
        ToggleGroup tg = new ToggleGroup();
        consumingRB.setToggleGroup(tg);
        nonConsumingRB.setToggleGroup(tg);

        //Handle selection of item in toggleGroup
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (tg.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    if (selected.equals(consumingRB)) {
                        //Do something with consuming property.
                        System.out.println(1);

                    } else{
                        //Do something with standard property.

                        System.out.println(2);
                    }

                }
            }
        });
    }
}

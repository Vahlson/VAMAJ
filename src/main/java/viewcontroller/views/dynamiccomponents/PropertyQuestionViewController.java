package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

public class PropertyQuestionViewController extends AnchorPane {
    MainViewController parentController;

    @FXML
    private RadioButton consumingRB;

    @FXML
    private RadioButton nonConsumingRB;

    public PropertyQuestionViewController(MainViewController parentController){
        this.parentController = parentController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dynamic/propertyquestion.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        setLeftAnchor(this,0.0);
        setRightAnchor(this,0.0);
         /* ToggleGroup group = new ToggleGroup();
        consumingRB.setToggleGroup(group);
        nonConsumingRB.setToggleGroup(group);
*/

    }
}

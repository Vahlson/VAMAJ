package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class PropertyQuestionViewController extends AnchorPane {
    @FXML
    private ProgressBar progressBar;

    @FXML
    private RadioButton consumingRB;

    @FXML
    private RadioButton nonConsumingRB;

    public PropertyQuestionViewController(){

       /* ToggleGroup group = new ToggleGroup();
        consumingRB.setToggleGroup(group);
        nonConsumingRB.setToggleGroup(group);
*/

    }
}

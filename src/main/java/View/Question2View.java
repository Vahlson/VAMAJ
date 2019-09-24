package main.java.View;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class Question2View extends AnchorPane {
    @FXML
    private ProgressBar progressBar;

    @FXML
    private RadioButton consumingRB;

    @FXML
    private RadioButton nonConsumingRB;

    public Question2View(){

       /* ToggleGroup group = new ToggleGroup();
        consumingRB.setToggleGroup(group);
        nonConsumingRB.setToggleGroup(group);
*/

    }
}

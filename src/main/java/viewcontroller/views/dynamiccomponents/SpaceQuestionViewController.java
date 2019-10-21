package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;
import java.io.IOException;

//Question about available space of the potential solarinstallation.
public class SpaceQuestionViewController extends AnchorPane {

    MainViewController parentController;

    @FXML
    private TextField availableSpace;


    public SpaceQuestionViewController(MainViewController parentController) {

        this.parentController = parentController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dynamic/spacequestion.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        //Match width to parent.
        setLeftAnchor(this,0.0);
        setRightAnchor(this,0.0);
    }
}

package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

public class PersonalQuestionViewController extends AnchorPane {
    MainViewController parentController;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField mailField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneField;




    public PersonalQuestionViewController(MainViewController parentController){
        this.parentController = parentController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dynamic/personalquestion.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        setLeftAnchor(this,0.0);
        setRightAnchor(this,0.0);

    }
}

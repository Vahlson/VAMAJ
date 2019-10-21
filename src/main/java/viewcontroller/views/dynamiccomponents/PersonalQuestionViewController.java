package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

//Question about the user.
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

        //Match width to parent.
        setLeftAnchor(this,0.0);
        setRightAnchor(this,0.0);



        //EVENTS for nodes of the program


        firstnameField.textProperty().addListener((observable, oldValue, newValue) -> {
            //Set value in user.
        });
        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            //Set value in user.
        });
        mailField.textProperty().addListener((observable, oldValue, newValue) -> {
            //Set value in user.
        });
        phoneField.textProperty().addListener((observable, oldValue, newValue) -> {
            //Set value in user.
        });

    }
}

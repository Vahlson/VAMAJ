package main.java.viewcontroller.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.java.viewcontroller.PrimaryController;

import java.net.URL;
import java.util.ResourceBundle;

//TODO DELETA DENNA
public class InstallationViewController implements Initializable {

    PrimaryController primaryController;

    // Components in parent FXML-file
    @FXML
    private TextField consumption;

    @FXML
    private TextField cost;

    @FXML
    private Button calculateButton;

    @FXML
    private Button backButton;


    public InstallationViewController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing the text fields
        onlyNumbers(consumption);
        onlyNumbers(cost);

        // Initializing button functionality
        calculateButton.setOnAction(event -> {

            double electricityConsumption = consumption.getText().isEmpty() ? 0 : Double.parseDouble(consumption.getText());
            double electricityCost = cost.getText().isEmpty() ? 0 : Double.parseDouble(cost.getText());

        });

        // Initializing back button functionality
        // backButton.setOnAction(event -> PrimaryController.setScene("/fxml/mainscene.fxml"));
    }

    // Method that configures text field to only accept numbers
    private void onlyNumbers(TextField tf) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                tf.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}

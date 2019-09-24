package main.java.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InstallationCalculator implements Initializable {

    // Components in parent FXML-file
    @FXML
    private TextField solarAreaField;

    @FXML
    private TextField costField;

    @FXML
    private Button calculateButton;

    @FXML
    private Text resultText;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // Initializing the text fields
        onlyNumbers(solarAreaField);
        onlyNumbers(costField);

        // Initializing button functionality
        calculateButton.setOnAction(event -> {

            double area = Double.parseDouble(solarAreaField.getText());
            double cost = Double.parseDouble(costField.getText());

            resultText.setText("Kostnad: " + mockResult(area, cost) + " kr");
        });

        // Initializing back button functionality
        backButton.setOnAction(event -> SceneSwitcher.getInstance().setScene("/main/java/View/resources/fxml/main.fxml"));
    }

    // Just temporary helper method to calculate the costs, in future this will be done in calculator classes
    private double mockResult(double area, double cost) {

        // Simplified calculations for now
        return area * cost;
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

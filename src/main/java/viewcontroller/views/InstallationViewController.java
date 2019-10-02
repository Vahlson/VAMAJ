package main.java.viewcontroller.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.java.viewcontroller.SceneSwitcher;

import java.net.URL;
import java.util.ResourceBundle;

public class InstallationViewController implements Initializable {

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

            double area = solarAreaField.getText().isEmpty() ? 0 : Double.parseDouble(solarAreaField.getText());
            double cost = costField.getText().isEmpty() ? 0 : Double.parseDouble(costField.getText());

            resultText.setText("Kostnad: " + mockResult(area, cost) + " kr");
        });

        // Initializing back button functionality
        backButton.setOnAction(event -> SceneSwitcher.getInstance().setScene("/fxml/mainscene.fxml"));
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

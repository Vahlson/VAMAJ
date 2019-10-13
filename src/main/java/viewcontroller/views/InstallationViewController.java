package viewcontroller.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import viewcontroller.PrimaryController;
import viewcontroller.SceneSwitcher;

import java.net.URL;
import java.util.ResourceBundle;

public class InstallationViewController implements Initializable {

    // Components in parent FXML-file
    @FXML
    private TextField consumption;

    @FXML
    private TextField cost;

    @FXML
    private Button calculateButton;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing the text fields
        onlyNumbers(consumption);
        onlyNumbers(cost);

        // Initializing button functionality
        calculateButton.setOnAction(event -> {

            double electricityConsumption = consumption.getText().isEmpty() ? 0 : Double.parseDouble(consumption.getText());
            double electricityCost = cost.getText().isEmpty() ? 0 : Double.parseDouble(cost.getText());

            PrimaryController.getInstance().getModelFacade().setContractCost((int) electricityCost);
            PrimaryController.getInstance().getModelFacade().setPropertyConsumption(electricityConsumption);
        });

        // Initializing back button functionality
        backButton.setOnAction(event -> SceneSwitcher.getInstance().setScene("/fxml/mainscene.fxml"));
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

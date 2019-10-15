package viewcontroller.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewcontroller.PrimaryController;
import viewcontroller.SceneSwitcher;

import java.net.URL;
import java.util.ResourceBundle;

public class ComparisonViewController implements Initializable {

    // Components in parent FXML-file
    @FXML
    private Label consumption;

    @FXML
    private Label measure_1;

    @FXML
    private Label measure_2;

    @FXML
    private Label address;

    @FXML
    private Label soldagar;

    @FXML
    private Label panel_size;

    @FXML
    private TextField user_enter;

    @FXML
    private Label generate;

    @FXML
    private Label spara;

    @FXML
    private Label ekologisk;

    @FXML
    private Button calculateButton;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing the text fields
        onlyNumbers(user_enter);

        // Initializing button functionality
        calculateButton.setOnAction(event -> {

            //double electricityConsumption = consumption.getText().isEmpty() ? 0 : Double.parseDouble(consumption.getText());
            double electricityCost = user_enter.getText().isEmpty() ? 0 : Double.parseDouble(user_enter.getText());

            PrimaryController.getInstance().getModelFacade().setContractCost((int) electricityCost);
          //  PrimaryController.getInstance().getModelFacade().setPropertyConsumption(electricityConsumption);
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

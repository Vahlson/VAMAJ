package viewcontroller.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewcontroller.PrimaryController;

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
    private Button getInfo;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing the text fields
        onlyNumbers(user_enter);



        //Initiallizing Text field functionality
        user_enter.setOnAction(actionEvent -> {
            int entered_wattage = Integer.parseInt(user_enter.getText());
            int generated_monthly = entered_wattage  * 60;
            generate.setText(""+generated_monthly);
            int montly_cost = entered_wattage * 108;
            spara.setText(""+montly_cost);
            int monthly_co2_emission = entered_wattage * 4;
            ekologisk.setText(""+monthly_co2_emission);
        });

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

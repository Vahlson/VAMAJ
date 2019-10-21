package main.java.viewcontroller.views.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import main.java.viewcontroller.views.MainViewController;

import java.io.IOException;

//TODO IDFK WTF THIS SHIIIIIII IS MANE.
public class InstallationCostResultViewController extends AnchorPane {

    MainViewController parentController;

    @FXML
    private Label installationCostLabel;
    @FXML
    private Label subventedAmountLabel;
    @FXML
    private Label subventedCostLabel;

    
    public InstallationCostResultViewController(MainViewController parentController){
        this.parentController = parentController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dynamic/installationcostresult.fxml"));
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


    // Methods to set label texts
    public void setInstallationCostLabel(double cost){

        installationCostLabel.setText(readableFormat(cost));
    }

    public void setSubventedAmountLabel(double amount){

        subventedAmountLabel.setText(readableFormat(amount));
    }

    public void setSubventedCostLabel(double subventedCost) {

        subventedCostLabel.setText(readableFormat(subventedCost));
    }


    // Returns a double in readable format
    private String readableFormat(double unReadableDouble){

        int unReadableInt = (int) unReadableDouble;
        String readable = String.format("%,d", unReadableInt);

        return readable;
    }
}

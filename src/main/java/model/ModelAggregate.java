package main.java.model;

import main.java.model.calculator.*;
import main.java.model.contract.Contract;
import main.java.model.contract.DynamicContract;
import main.java.model.property.Location;
import main.java.model.property.Property;
import main.java.model.solarsetup.*;
import main.java.model.user.User;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static main.java.model.calculator.DataKey.*;

//(2)Vegard

//The aggregate object of the model, orchestrates the interactions between the calculator and model data.
public class ModelAggregate {

    private User currentUser;
    private List<User> users;
    private Double result; //HashMap containing values with a ENUM as key
    //private CalculatorFacade runner = new CalculatorFacade();
    private HashMap<DataKey, Double> calculationData;

    public ModelAggregate() {
        calculationData = new HashMap<>();
        users = new ArrayList<>();
        currentUser = new User();
        users.add(currentUser);

    }

    private void getDataFromModel(){

        calculationData.put(AVAILABLE_SPACE, getSolarSetup().getSquareMeters());

        SolarPanel solarPanel = getSolarSetup().getASolarPanel();
        if(solarPanel != null) {
            calculationData.put(PANEL_PRICE, solarPanel.getRetailPrice());
            calculationData.put(REQUIRED_PANEL_SPACE, solarPanel.getSize());
        }
    }
    //Calls calculators and sets results to above HashMap
    void runCalculators() {
        getDataFromModel();
        //Set the calculated output values in thehashmap.
        calculationData = CalculatorFacade.calculateAll(calculationData);

    }

    // Getter for results of calculation(s)
    Double getCalculationResult(DataKey key) {
        return Objects.requireNonNull(calculationData.get(key), "Insufficient data for calculations of: " + key.getDescription());
    }

    //Adding data for calculations.
    void addCalculationData(DataKey key, double value){
        calculationData.put(key, value);
    }


    // Getters
    Property getProperty() {
        return currentUser.getActiveProperty();
    }

    Location getLocation() {
        // If there is no object in the model, create it.
        //Goes against command-query separation principle but makes handling of potential null-objects much easier.
        if(getProperty().getLocation() == null){
            Location location = new Location();
            getProperty().setLocation(location);
        }
        return getProperty().getLocation();
    }

    Contract getContract() {
        // If there is no object in the model, create it.
        //Goes against command-query separation principle but makes handling of potential null-objects much easier.
        if(getProperty().getContract() == null){
            Contract contract = new DynamicContract("Generic City",0,0);
            getProperty().setContract(contract);
        }
        return getProperty().getContract();
    }

    SolarSetup getSolarSetup() {
        //If there is no object in the model, create it.
        //Goes against command-query separation principle but makes handling of potential null-objects much easier.
        if(getProperty().getSolarSetup() == null){
            SolarSetup solarSetup = new RoofBasedSolarSetup(0,0,0);
            getProperty().setSolarSetup(solarSetup);
        }
        return getProperty().getSolarSetup();
    }

    //Fills the solarsetup solarpanel list with the amount of solar panels that fit inthe available space.
    // The solar panel typ is
    public void setSolarPanelsStandard(){

        SolarPanel templateSolarPanel = new StandardSolarPanel();
        setSolarPanels(templateSolarPanel);


    }
    public void setSolarPanelsPremium(){

        SolarPanel templateSolarPanel = new PremiumSolarPanel();
        setSolarPanels(templateSolarPanel);

    }

    private void setSolarPanels(SolarPanel templateSolarPanel){
        List<SolarPanel> solarPanels = new ArrayList<>();

        for(int i = 0; i < getNumberOfSolarPanels(templateSolarPanel);i++){
            solarPanels.add(new StandardSolarPanel());

        }

        getSolarSetup().setSolarPanels(solarPanels);
    }

    private int getNumberOfSolarPanels(SolarPanel templateSolarPanel){

        int numberOfSolarPanels = 0;

        if(calculationData.get(AVAILABLE_SPACE) != null) {
            numberOfSolarPanels = (int) Math.floor(calculationData.get(AVAILABLE_SPACE) / templateSolarPanel.getSize());
        }
        return numberOfSolarPanels;
    }


}

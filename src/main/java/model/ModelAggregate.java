package main.java.model;

import main.java.model.calculator.*;
import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.property.Property;
import main.java.model.solarsetup.SolarSetup;
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

    //Calls calculators and sets results to above HashMap
    void runCalculators() {
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
        return getProperty().getLocation();
    }

    Contract getContract() {
        return getProperty().getContract();
    }

    SolarSetup getSolarSetup() {
        return getProperty().getSolarSetup();
    }
}

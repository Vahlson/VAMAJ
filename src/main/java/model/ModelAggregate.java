package main.java.model;

import main.java.model.calculator.*;
import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.property.Property;
import main.java.model.solarsetup.SolarSetup;
import main.java.model.user.User;

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
    private HashMap<DataKey, Double> localData;

    public ModelAggregate() {
        localData = new HashMap<>();
        users = new ArrayList<>();
        currentUser = new User();
        users.add(currentUser);
        runCalculators();
    }

    //Calls calculators and sets results to above HashMap
    void runCalculators() {
        HashMap<DataKey, Double> data = new HashMap<>();

        data.put(INSTALLATION_COST, 1337D);

        localData = CalculatorFacade.calculateAll(data);
    }


    // Getter for results of calculation(s)
    Double getCalculationResult(DataKey key) {
        return Objects.requireNonNull(localData.get(key), "no data for " + key.toString());
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

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
    private HashMap<DataKey, Double> calculationData;
    private HashMap<DataKey, Double> calculations;

    public ModelAggregate() {
        calculationData = new HashMap<>();
        calculations = new HashMap<>();
        users = new ArrayList<>();
        currentUser = new User();
        users.add(currentUser);

    }

    //Calls calculators and sets results to above HashMap
    void runCalculators() {
        //Initialize with dummy values.
        //These represent both the initialized return "variables"/values and the actual calculations that will be performed
        calculations.put(INSTALLATION_COST, 0.0);
        calculations.put(SURPLUS,0.0);
        calculations.put(LEVELIZED_ELECTRICITY_COST,0.0);
        calculations.put(SOLAR_PV_DAILY_ELECTRICITY_OUTPUT,0.0);
        calculations.put(YEARS_TO_BREAK_EVEN,0.0);

        calculationData = CalculatorFacade.calculateAll(calculations);

    }

    // Getter for results of calculation(s)
    Double getCalculationResult(DataKey key) {
        return Objects.requireNonNull(calculationData.get(key), "no data for " + key.toString());
    }

    //Adding data for calculations.
    void addCalculationData(DataKey key, double value){
        calculations.put(key, value);
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

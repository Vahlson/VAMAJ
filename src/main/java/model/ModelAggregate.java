package main.java.model;

import main.java.model.Calculators.*;
import main.java.model.Property.Property;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.SolarSetup.SolarPanel;
import main.java.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

//(2)Vegard

public class ModelAggregate {

    private User currentUser;
    private List<User> users = new ArrayList<>();
    private Property property = new Property();
    private Location location = new Location();
    private Double result; //HashMap containing values with a ENUM as key
    private CalculatorRunner runner = new CalculatorRunner();
    private CalculatorData localData;


    //Calls calculators and sets results to above HashMap
    void runCalculators() {
        CalculatorData data = new CalculatorData();

        data.addValue(DataKey.CONSUMED_ELECTRICITY, 3.0);
        data.addValue(DataKey.PRODUCED_ELECTRICITY, 6.0);
        data.addValue(DataKey.AVAILABLE_SPACE, 3.0);
        data.addValue(DataKey.REQUIRED_PANEL_SPACE, 6.0);
        data.addValue(DataKey.PANEL_PRICE, 3.0);
        data.addValue(DataKey.EXPECTED_LIFESPAN, 3.0);
        data.addValue(DataKey.ANNUAL_OPERATION_COST, 6.0);
        data.addValue(DataKey.ANNUAL_ELECTRICITY_PRODUCTION, 3.0);

        runner.calculateAll(data);
        localData = data;
    }


    //Temporary setter for testing purposes
    public void setProperty(Property property) {
        this.property = property;
    }

    // Getter for results of calculation(s)
    public Double getCalculationResult(DataKey key) {
        return localData.getValue(key);
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public Property getProperty() {
        return property;
    }

    public Contract getContract() {
        return property.getContract();
    }
}

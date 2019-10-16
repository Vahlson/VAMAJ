package main.java.model;

import main.java.model.calculator.*;
import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.property.Property;
import main.java.model.solarsetup.SolarSetup;
import main.java.model.user.User;

import java.util.ArrayList;
import java.util.List;

//(2)Vegard

class ModelAggregate {

    private User currentUser;
    private List<User> users;
    private Double result; //HashMap containing values with a ENUM as key
    private CalculatorRunner runner = new CalculatorRunner();
    private CalculatorData localData;

    ModelAggregate() {
        users = new ArrayList<>();
        currentUser = new User();
        users.add(currentUser);
    }

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


    // Getter for results of calculation(s)
    Double getCalculationResult(DataKey key) {
        return localData.getValue(key);
    }

    // Getters
    private Property getProperty() {
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

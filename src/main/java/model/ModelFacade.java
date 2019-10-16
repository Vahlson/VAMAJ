package main.java.model;

import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.property.Property;
import main.java.model.solarsetup.SolarSetup;

import java.util.HashMap;

public class ModelFacade {

    private ModelAggregate modelAggregate;

    // Constructor
    public ModelFacade() {
        modelAggregate = new ModelAggregate();
    }

    // Setters
    public void setLocation(Location location) {
        modelAggregate.getProperty().setLocation(location);
    }

    public void setContract(Contract contract) {
        modelAggregate.getProperty().setContract(contract);
    }

    public void setSolarSetup(SolarSetup solarSetup) {
        modelAggregate.getProperty().setSolarSetup(solarSetup);
    }

    // TEMPORARY GETTERS FOR TESTING
    public Contract getContract() {
        return modelAggregate.getContract();
    }

    public Property getProperty() {
        return modelAggregate.getProperty();
    }

    public SolarSetup getSolarSetup() {
        return modelAggregate.getProperty().getSolarSetup();
    }


    // Run calculations
    public void runCalculators() {
        modelAggregate.runCalculators();
    }

    // Getter(s)
    public HashMap<String, Object> getCalculationResults() {
        return modelAggregate.getCalculationResults();
    }
}

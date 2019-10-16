package main.java.model;

import main.java.model.Calculator.DataKey;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.Property.Property;
import main.java.model.SolarSetup.SolarSetup;

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
    public Double getCalculationResults(DataKey key) {
        return modelAggregate.getCalculationResult(key);
    }
}

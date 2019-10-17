package model;

import model.calculator.DataKey;
import model.contract.Contract;
import model.property.Location;
import model.solarsetup.SolarSetup;

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

    // Getters
    public Contract getContract() {
        return modelAggregate.getContract();
    }

    public SolarSetup getSolarSetup() {
        return modelAggregate.getSolarSetup();
    }

    public Location getLocation() {
        return modelAggregate.getLocation();
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

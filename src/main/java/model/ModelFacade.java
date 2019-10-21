package main.java.model;

import main.java.model.calculator.DataKey;
import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.solarsetup.SolarSetup;

//The model's face outward towards the rest of the program. Exposes wanted functionality outward.
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

    // Getter for results of calculation(s)
    public Double getCalculationResult(DataKey key) {
        return modelAggregate.getCalculationResult(key);
    }

    //Adding data for calculations.
    public void addCalculationData(DataKey key, double value){
        modelAggregate.addCalculationData(key, value);
    }
}

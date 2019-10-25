package main.java.model;

import main.java.model.calculator.DataKey;
import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.solarsetup.SolarSetup;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: The model's face outward towards the rest of the program.
// Used by: (lives in) Main, PrimaryController.
// Uses: Exposes wanted functionality from the model outward.

public class ModelFacade {

    private ModelAggregate modelAggregate;

    // Constructor
    public ModelFacade() {
        modelAggregate = new ModelAggregate();
    }

    // Getters
    public Contract getContract() {
        return modelAggregate.getContract();
    }

    public void setContract(Contract contract) {
        modelAggregate.getProperty().setContract(contract);
    }

    public SolarSetup getSolarSetup() {
        return modelAggregate.getSolarSetup();
    }

    public void setSolarSetup(SolarSetup solarSetup) {
        modelAggregate.getProperty().setSolarSetup(solarSetup);
    }

    public Location getLocation() {
        return modelAggregate.getLocation();
    }

    // Setters
    public void setLocation(Location location) {
        modelAggregate.getProperty().setLocation(location);
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
    public void addCalculationData(DataKey key, double value) {
        modelAggregate.addCalculationData(key, value);
    }

    public void setSolarPanelsStandard() {

        modelAggregate.setSolarPanelsStandard();
    }

    public void setSolarPanelsPremium() {

        modelAggregate.setSolarPanelsPremium();
    }

    public void setPropertyConsuming() {
        modelAggregate.setPropertyConsuming();
    }

    public void setPropertyNonConsuming() {
        modelAggregate.setPropertyNonConsuming();
    }


}

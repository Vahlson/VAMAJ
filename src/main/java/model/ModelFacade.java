package main.java.model;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.Property.Property;

import java.util.HashMap;

public class ModelFacade {

    private ModelAggregate modelAggregate = new ModelAggregate();

    // Constructor
    public ModelFacade() {

    }

    // Location setters
    public void setLocation(Location location) {
        modelAggregate.getProperty().setLocation(location);
    }

    // Contract setters
    public void setContract(Contract contract) {
        modelAggregate.getProperty().setContract(contract);
    }

    public void setContractCost(int cost) {
        modelAggregate.getProperty().getContract().setCost(cost);
    }

    // Property setters
    public void setPropertyConsumption(double consumption) {
        modelAggregate.getProperty().setConsumption(consumption);
    }

    public void setProperty(Property property) {
        modelAggregate.setProperty(property);
    }

    public void setPropertyLocation(Location location) {
        modelAggregate.getProperty().setLocation(location);
    }

    public void setPropertyLatitude(double latitude) {
        modelAggregate.getProperty().setLatitude(latitude);
    }

    public void setPropertyPanelAngle(int panelAngle) {
        modelAggregate.getProperty().setPanelAngle(panelAngle);
    }

    public void setPropertyOrientation(int orientation) {
        modelAggregate.getProperty().setOrientation(orientation);
    }

    public void setPropertyInstallationSpace(double installationSpace) {
        modelAggregate.getProperty().setInstallationSpace(installationSpace);
    }

    // Run calculations
    public void runCalculators() {
        modelAggregate.runCalculators();
    }

    // Getter(s)
    public ModelAggregate getModelAggregate() {
        return modelAggregate;
    }

    public HashMap<String, Object> getCalculationResults() {
        return modelAggregate.getCalculationResults();
    }

}

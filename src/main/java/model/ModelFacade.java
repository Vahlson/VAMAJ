package main.java.model;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;

public class ModelFacade {

    private ModelAggregate modelAggregate;

    // Constructor
    ModelFacade(){

    }

    // Location setters
    public void setLocation(Location location) {
        modelAggregate.setPropertyLocation(location);
    }

    // Contract setters
    public void setContract(Contract contract) {
        modelAggregate.setContract(contract);
    }

    public void setContractCost(int cost) {
        modelAggregate.setContractCost(cost);
    }

    // Property setters
    public void setPropertyLocation(Location location) {
        modelAggregate.setPropertyLocation(location);
    }

    public void setPropertyLatitude(double latitude) {
        modelAggregate.setPropertyLatitude(latitude);
    }

    public void setPropertyPanelAngle(int panelAngle) {
        modelAggregate.setPropertyPanelAngle(panelAngle);
    }

    public void setPropertyOrientation(int orientation) {
        modelAggregate.setPropertyOrientation(orientation);
    }

    public void setPropertyInstallationSpace(double installationSpace) {
        modelAggregate.setPropertyInstallationSpace(installationSpace);
    }

    // Run calculations
    public void runCalculators() {
        modelAggregate.runCalculators();
    }

    // Getter(s)
    public ModelAggregate getModelAggregate() {
        return modelAggregate;
    }
}

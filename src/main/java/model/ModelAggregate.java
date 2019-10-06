package main.java.model;

import main.java.model.Property.Property;
import main.java.model.Calculator.Calculator;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.user.User;

import java.util.List;

public class ModelAggregate {

    private Calculator calculator;
    private User currentUser;
    private List<User> users;
    private Property property;

    // Setters in property
    public void setPropertyLocation(Location l) {
        property.setLocation(l);
    }

    public void setPropertyLatitude(double latitude) {
        property.setLatitude(latitude);
    }

    public void setPropertyPanelAngle(int panelAngle) {
        property.setPanelAngle(panelAngle);
    }

    public void setPropertyOrientation(int orientation) {
        property.setOrientation(orientation);
    }

    public void setPropertyInstallationSpace(double installationSpace) {
        property.setInstallationSpace(installationSpace);
    }

    // Setters in contract
    public void setContract(Contract c) {
        property.setContract(c);
    }

    public void setContractCost(int cost) {
        property.getContract().setCost(cost);
    }
}

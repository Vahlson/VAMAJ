package main.java.service;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;

public class ServiceFacade {

    private ILocationCreator locationCreator = new MockLocationCreator(); // Initialized to mock class for now
    private IContractCreator contractCreator = new MockContractCreator(); // Initialized to mock class for now

    // Getters
    Contract getContract() {
        return contractCreator.createContract();
    }

    Location getLocation() {
        return locationCreator.createLocation();
    }

    // Setters
    void setLocationCreator(ILocationCreator creator) {
        this.locationCreator = creator;
    }

    void setContractCreator(IContractCreator creator) {
        this.contractCreator = creator;
    }
}

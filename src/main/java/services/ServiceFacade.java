package main.java.services;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
//(3.1) Alex LV och Alex Ask
public class ServiceFacade {

    private ILocationCreator locationCreator = new LocationCreatorAPI(); // Initialized to mock class for now
    private IContractCreator contractCreator = new ContractCreatorAPI(); // Initialized to mock class for now

    // Getters
    public Contract getContract() {
        return contractCreator.createContract();
    }

    public Location getLocation() {
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

package main.java.service;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;

public class ServiceFacade {

    private ILocationCreator locationCreator;
    private IContractCreator contractCreator;

    Contract getContract() {
        return contractCreator.createContract();
    }

    Location getLocation() {
        return locationCreator.createLocation();
    }

}

package main.java.model.property;

import main.java.model.contract.Contract;
import main.java.model.solarsetup.SolarSetup;

public abstract class Property {

    // Member variables
    private SolarSetup solarSetup;
    private Location location;
    private Contract contract;


    // Constructor (empty)
    public Property() {
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public Contract getContract() {
        return contract;
    }

    public SolarSetup getSolarSetup() {
        return solarSetup;
    }


    // Setters
    public void setLocation(Location l) {
        this.location = l;
    }

    public void setContract(Contract c) {
        this.contract = c;
    }

    public void setSolarSetup(SolarSetup solarSetup) {

        this.solarSetup = solarSetup;
    }

}

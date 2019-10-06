package main.java.model;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;

public class ModelFacade {

    private main.java.model.ModelAggregate modelAggregate;

    public void setLocation(Location l) {
        modelAggregate.setLocation(l);
    }

    public void setContract(Contract c) {
        modelAggregate.setContract(c);
    }

}

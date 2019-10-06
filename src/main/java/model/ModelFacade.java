package main.java.model;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.ModelAggregate;

public class ModelFacade {

    private ModelAggregate modelAggregate;

    public void setLocation(Location l) {
        modelAggregate.setPropertyLocation(l);
    }

    public void setContract(Contract c) {
        modelAggregate.setContract(c);
    }

    public ModelAggregate getModelAggregate() {
        return modelAggregate;
    }
}

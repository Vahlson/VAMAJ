package main.java.model.property;

import main.java.model.contract.FixedContract;

public class NonConsumingProperty extends Property {
    public NonConsumingProperty(){
        setContract(new FixedContract(0,0));
    }
}

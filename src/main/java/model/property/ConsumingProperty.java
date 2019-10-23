package main.java.model.property;

import main.java.model.contract.FixedContract;

public class ConsumingProperty extends Property {
    public ConsumingProperty(){
        setContract(new FixedContract(0,0));
    }
}

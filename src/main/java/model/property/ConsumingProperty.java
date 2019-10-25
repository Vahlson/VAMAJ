package main.java.model.property;

import main.java.model.contract.FixedContract;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Implementation of a Property that consumes electricity.
// Used by: ModelAggregate.
// Uses: Defines a property that consumes nothing with a contract that doesn't cost anything.

public class ConsumingProperty extends Property {
    public ConsumingProperty() {
        setContract(new FixedContract(0, 0));
    }
}

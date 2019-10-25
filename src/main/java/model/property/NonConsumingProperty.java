package main.java.model.property;

import main.java.model.contract.FixedContract;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Implementation of a Property that doesn't consume electricity.
// Used by: ModelAggregate.
// Uses: Defines a property that consumes.


public class NonConsumingProperty extends Property {
    public NonConsumingProperty() {
        setContract(new FixedContract(0, 0));
    }
}

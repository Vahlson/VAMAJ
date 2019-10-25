package main.java.model.contract;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Implementaion of a contract that is of the fixed type.
// Used by: ConsumingProperty, NonConsumingProperty, PropertyQuestionViewController.
// Uses: Holds data specific to a fixed contract type.
// (extensibility possibilities) Useful for storing specific properties of a fixed contract, for more specific calculations.
//  Ex: cost calculation for a static value.

public class FixedContract extends Contract {

    public FixedContract(double cost, double consumedElectricity) {
        super( cost, consumedElectricity);
    }

    public double fixedContractBonus() {

        double fixedBonus = 0.8;
        return getMonthlyCost() * fixedBonus;

    }
}

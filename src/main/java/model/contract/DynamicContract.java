package main.java.model.contract;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Implementaion of a contract that is of the dynamic type.
// Used by: ModelAggregate.
// Uses: Holds data specific to a fixed contract type.
// (extensibility possibilities) Useful for storing specific properties of a dynamic contract, for more specific calculations.
//  Ex: cost calculation for a dynamic value.

public class DynamicContract extends Contract {

    public DynamicContract(double cost, double consumedElectricity) {
        super(cost, consumedElectricity);
    }

    public double extraTariffCost() {

        double extraFee = 0.2;
        return getMonthlyCost() * extraFee;

    }
}

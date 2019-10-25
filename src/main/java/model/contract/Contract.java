package main.java.model.contract;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Abstract representation of an electricity provider contract.
// Used by: ModelFacade, ModelAggregate, ServiceFacade, Property. (Yes that's alot...)
// Uses: Holds data common to an electricity contract. Implementations have more specific data.

public abstract class Contract {

    private String contractProvider;
    private double consumedElectricity;
    private double monthlyCost;
    private double sellbackPriceFraction;

    public Contract(double monthlyCost, double consumedElectricity) {
        this.contractProvider = "Generic Contract Provider";
        this.monthlyCost = monthlyCost;
        this.consumedElectricity = consumedElectricity;
        this.sellbackPriceFraction = 0.3;
    }

    // Getters

    public double getSellbackElectrictyPrice() {
        return sellbackPriceFraction * (monthlyCost / consumedElectricity);
    }

    public double getMonthlyCost() {
        return this.monthlyCost;
    }

    public double getConsumedElectricity() {
        return consumedElectricity;
    }


    // Setters
    public void setConsumedElectricity(double consumedElectricity) {
        this.consumedElectricity = consumedElectricity;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }


}

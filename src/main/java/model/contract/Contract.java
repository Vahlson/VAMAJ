package main.java.model.contract;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Abstract representation of an electricity provider contract.
// Used by: ModelFacade, ModelAggregate, ServiceFacade, Property. (Yes that's alot...)
// Uses: Holds data common to an electricity contract. Implementations have more specific data.

public abstract class Contract {

    private String contractProvider;
    private double consumedElectricity;
    private double monthlyCost;

    public Contract(double monthlyCost, double consumedElectricity) {
        this.contractProvider = "Generic Contract Provider";
        this.monthlyCost = monthlyCost;
        this.consumedElectricity = consumedElectricity;
    }

    // Getters
    public String getContractProvider() {
        return this.contractProvider;
    }

    public void setContractProvider(String contractProvider) {
        this.contractProvider = contractProvider;
    }

    public double getMonthlyCost() {

        return this.monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public double getConsumedElectricity() {
        return consumedElectricity;
    }

    // Setters
    public void setConsumedElectricity(double consumedElectricity) {
        this.consumedElectricity = consumedElectricity;
    }


}

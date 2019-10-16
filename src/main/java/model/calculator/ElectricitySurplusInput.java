package main.java.model.calculator;

// (4.1) Jonatan

public class ElectricitySurplusInput {

    private double consumedElectricityPerTimeUnit; // Name to be specified
    private double producedElectricityPerTimeUnit; // Name to be specified

    //Constructor
    public ElectricitySurplusInput(double consumedElectricityPerTimeUnit, double producedElectricityPerTimeUnit) {
        this.consumedElectricityPerTimeUnit = consumedElectricityPerTimeUnit;
        this.producedElectricityPerTimeUnit = producedElectricityPerTimeUnit;
    }

    // Getters
    double getConsumedElectricityPerTimeUnit() {
        return consumedElectricityPerTimeUnit;
    }

    double getProducedElectricityPerTimeUnit() {
        return producedElectricityPerTimeUnit;
    }
}

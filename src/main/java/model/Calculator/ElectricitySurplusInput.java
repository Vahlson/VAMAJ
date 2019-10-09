package main.java.model.Calculator;

// (4.1) Jonatan

public class ElectricitySurplusInput {

    private double timeUnitConsumedElectricity;
    private double timeUnitProducedElectricity;

    //Constructor
    ElectricitySurplusInput(double timeUnitConsumedElectricity, double timeUnitProducedElectricity) {
        this.timeUnitConsumedElectricity = timeUnitConsumedElectricity;
        this.timeUnitProducedElectricity = timeUnitProducedElectricity;
    }

    // Getters
    public double getTimeUnitConsumedElectricity() {
        return timeUnitConsumedElectricity;
    }

    public double getTimeUnitProducedElectricity() {
        return timeUnitProducedElectricity;
    }
}

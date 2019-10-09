package main.java.model.Calculator;

// 4.1 Jonatan

public class ElectricitySurplusInput {

    double consumedElectricity;
    double producedElectricity;

    public ElectricitySurplusInput(double consumedElectricity, double producedElectricity) {
        this.consumedElectricity = consumedElectricity;
        this.producedElectricity = producedElectricity;
    }

    // Getters
    public double getConsumedElectricity() {
        return consumedElectricity;
    }

    public double getProducedElectricity() {
        return producedElectricity;
    }
}

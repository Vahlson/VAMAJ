package main.java.model.Calculator;

//(4.2) Vegard
// Class to contain return values of LevelizedCostOfElectricity calculation

public class LevelizedCostOfElectricityOutput {
    private double lCOE;

    LevelizedCostOfElectricityOutput(double lCOE) {
        this.lCOE = lCOE;
    }

    public double getlCOE() {
        return lCOE;
    }
}

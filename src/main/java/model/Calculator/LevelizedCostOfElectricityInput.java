package main.java.model.Calculator;

public class LevelizedCostOfElectricityInput {
    private int expectedLifetime;
    private double annualElectricityOutput;
    private double annualOperationCost;
    private double installationCost;

    public LevelizedCostOfElectricityInput(int expectedLifetime, double annualElectricityOutput, double annualOperationCost, double installationCost) {
        this.expectedLifetime = expectedLifetime;
        this.annualElectricityOutput = annualElectricityOutput;
        this.annualOperationCost = annualOperationCost;
        this.installationCost = installationCost;
    }

    public LevelizedCostOfElectricityInput(int expectedLifetime, double annualElectricityOutput, double installationCost) {
       this.expectedLifetime = expectedLifetime;
        this.annualElectricityOutput = annualElectricityOutput;
        this.annualOperationCost = 0;
        this.installationCost = installationCost;
    }

    int getExpectedLifetime() {
        return expectedLifetime;
    }

    double getAnnualElectricityOutput() {
        return annualElectricityOutput;
    }

    double getAnnualOperationCost() {
        return annualOperationCost;
    }

    double getInstallationCost() {
        return installationCost;
    }
}

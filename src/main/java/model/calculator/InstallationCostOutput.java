package main.java.model.calculator;

// (3) Jonatan
// Class to contain return values of InstallationCost calculation

public class InstallationCostOutput {

    private double installationCost;
    private double governmentSubvention;
    private double subventedCost;

    InstallationCostOutput(double installationCost, double governmentSubvention, double subventedCost) {
        this.installationCost = installationCost;
        this.governmentSubvention = governmentSubvention;
        this.subventedCost = subventedCost;
    }

    // Getters
    public double getInstallationCost() {
        return installationCost;
    }

    public double getSubventionAmount() {
        return governmentSubvention;
    }

    public double getSubventedCost() {
        return subventedCost;
    }
}

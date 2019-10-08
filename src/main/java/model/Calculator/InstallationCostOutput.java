package main.java.model.Calculator;

public class InstallationCostOutput {

    // Class to contain return values of InstallationCost calculation

    private double installationCost;
    private double governmentSubvention;
    private double subventedCost;

    public InstallationCostOutput(double installationCost, double governmentSubvention, double subventedCost) {
        this.installationCost = installationCost;
        this.governmentSubvention = governmentSubvention;
        this.subventedCost = subventedCost;
    }

    //Getters
    public double getInstallationCost() {
        return installationCost;
    }

    public double getGovernmentSubvention() { return governmentSubvention; }

    public double getSubventedCost() { return subventedCost; }
}

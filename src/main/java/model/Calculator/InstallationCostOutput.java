package main.java.model.Calculator;

public class InstallationCostOutput {

    // Class to contain return values of InstallationCost calculation

    private double installationCost;

    public InstallationCostOutput(double installationCost) {
        this.installationCost = installationCost;
    }

    //Getters
    public double getInstallationCost() {
        return installationCost;
    }
}

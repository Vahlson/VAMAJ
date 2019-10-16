package main.java.model.calculator;

//(4.2) Vegard
//Class to contain input values of LevelizedCostOfElectricity calculation

public class LevelizedCostOfElectricityInput {
    private int expectedLifetime;
    private double annualElectricityOutput;
    private double annualOperationCost = 0; //Default value that can be changed with setter
    private double installationCost;

    public LevelizedCostOfElectricityInput(int expectedLifetime, double annualElectricityOutput, double installationCost) {
       this.expectedLifetime = expectedLifetime;
        this.annualElectricityOutput = annualElectricityOutput;
        this.installationCost = installationCost;
    }

    //Setter for annualOperationCost since it's optional for calculation
    public void setAnnualOperationCost(double annualOperationCost) {
        this.annualOperationCost = annualOperationCost;
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

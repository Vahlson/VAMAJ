package main.java.Model.Calculator;

public class EconomicCalculator {

    private double installationCost = 30000;
    private int installationLifetime = 25;
    private double installationAnnualKwhProduction = 9000;
    private double installationCostPerKwh = 0.5;

    private double annualSavings = 3;
    private double contractKwhCost = 1;

    private int yearsToBreakEven = 3;

    // Constructor (empty)
    EconomicCalculator() {
    }

    public void update(){
        calculateInstallationCostPerKwh();
        calculateYearsToBreakEven();
        calculateAnnualSavings();
    }

    // Getters
    double getAnnualSavings() {
        return annualSavings;
    }
    double getYearsToBreakEven(){
        return yearsToBreakEven;
    }

    // Setters
    void setInstallationCost(double installationCost) {
        this.installationCost = installationCost;
    }
    void setInstallationLifetime(int installationLifetime) {
        this.installationLifetime = installationLifetime;
    }
    void setInstallationAnnualKwhProduction(double installationAnnualKwhProduction) {
        this.installationAnnualKwhProduction = installationAnnualKwhProduction;
    }
    void setContractKwhCost(double contractKwhCost) {
        this.contractKwhCost = contractKwhCost;
    }

    // Calculates Kwh cost based on lifetime and installation cost
    private void calculateInstallationCostPerKwh(){
        double lifeTimeProduction = installationAnnualKwhProduction * installationLifetime;
        installationCostPerKwh = lifeTimeProduction / installationCost;
    }

    // Calculates years to break even on installation cost based on avoided grid electricity payments
    private void calculateYearsToBreakEven(){
        double avoidedEnergyPayments = contractKwhCost * installationAnnualKwhProduction;
        yearsToBreakEven = (int)(installationCost / avoidedEnergyPayments);
    }

    // Calculates annual savings of installation based on calculated per Kwh cost of installation
    private void calculateAnnualSavings(){
        annualSavings = installationAnnualKwhProduction*(contractKwhCost - installationCostPerKwh);
    }


}

package main.java.model.Calculator;

public class EconomicCalculator {

    // TODO: move all input variables to Calculator, call methods directly with values

    private double installationCost = 30000;
    private int installationLifetime = 25;
    private double installationAnnualKwhProduction = 9000;
    private double contractKwhCost = 1;

    private double installationCostPerKwh = 0.5;

    private double annualSavings = 3;
    private int yearsToBreakEven = 3;

    // Constructor (empty)
    EconomicCalculator() {
    }

    // Updates all calculations
    public void update(){
        calculateInstallationCostPerKwh();
        calculateYearsToBreakEven();
        calculateAnnualSavings();
    }

    // Getters
    public double getAnnualSavings() {
        return annualSavings;
    }
    public int getYearsToBreakEven(){
        return yearsToBreakEven;
    }

    // Setters
    public void setInstallationCost(double installationCost) {
        this.installationCost = installationCost;
    }
    public void setInstallationLifetime(int installationLifetime) {
        this.installationLifetime = installationLifetime;
    }
    public void setInstallationAnnualKwhProduction(double installationAnnualKwhProduction) {
        this.installationAnnualKwhProduction = installationAnnualKwhProduction;
    }
    public void setContractKwhCost(double contractKwhCost) {
        this.contractKwhCost = contractKwhCost;
    }

    // Calculates Kwh cost based on lifetime and installation cost
    private void calculateInstallationCostPerKwh(){
        double lifeTimeProduction = installationAnnualKwhProduction * installationLifetime;
        installationCostPerKwh = lifeTimeProduction / installationCost;
    }

    // Calculates years to break even on installation cost based on avoided grid electricity payments
    public void calculateYearsToBreakEven(){
        double avoidedEnergyPayments = contractKwhCost * installationAnnualKwhProduction;
        yearsToBreakEven = (int)(installationCost / avoidedEnergyPayments);
    }

    // Calculates annual savings of installation based on calculated per Kwh cost of installation
    public void calculateAnnualSavings(){
        calculateInstallationCostPerKwh();
        annualSavings = installationAnnualKwhProduction*(contractKwhCost - installationCostPerKwh);
    }


}

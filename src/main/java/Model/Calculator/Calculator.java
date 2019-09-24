package main.java.Model.Calculator;

import main.java.Model.Property.Property;
import main.java.Model.User;

public class Calculator {

    // Member variables
    private EconomicCalculator economicCalculator;
    private EnvironmentalCalculator environmentalCalculator;
    private User user;
    private Property property;

    // Constructor (empty)
    public Calculator() {
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    // Updates all values for calculations and runs the calculators
    public void update(){
        property = user.getActiveProperty();

        economicCalculator.setContractKwhCost(2);
        economicCalculator.setInstallationCost(2000);
        economicCalculator.setInstallationLifetime(30);
        economicCalculator.setInstallationAnnualKwhProduction(1500);

        economicCalculator.update();
    }

    // Returns values from economic calculator
    public double yearsToBreakEven(){
        return economicCalculator.getYearsToBreakEven();
    }
    public double annualSavings() {
        return economicCalculator.getAnnualSavings();
    }
}

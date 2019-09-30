package main.java.model.Calculator;

import main.java.model.Property.Property;
import main.java.model.User;

public class CalculatorMain {

    // Member variables
    private EconomicCalculator economicCalculator;
    private EnvironmentalCalculator environmentalCalculator;
    private User user;
    private Calculator calculator = new Calculator() {
        @Override
        public Object calculate(Object o) {
            return null;
        }
    };
    private Property property;

    // Constructor (empty)
    public CalculatorMain() {
    }

    AnnualSolarElectricityInput sol = new AnnualSolarElectricityInput(23, 3, 22);


    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    // Updates all values for calculations and runs the calculators
    public void update(){
        property = user.getActiveProperty();

        AnnualSolarElectricityInput sol = new AnnualSolarElectricityInput(23, 3, 22);
        AnnualSolarElectricityOutput lol = new AnnualSolarElectricityOutput();
        lol = (AnnualSolarElectricityOutput) calculator.calculate(sol);
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

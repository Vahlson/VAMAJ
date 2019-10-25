package main.java.model.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Calculator implementation.
// Used by: CalculatorFacade.
// Uses: Handles calculations of years until economical ("break even") gain.


final class YearsToBreakEvenCalculator implements Calculator{

    YearsToBreakEvenCalculator() {
    }

    //Returns approximate time to break-even on costs for a electricity generation setup
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input) {
        HashMap<DataKey, Double> data = new HashMap<>(input);

        double installationCost = input.get(INSTALLATION_COST);
        double annualOperationCost = input.get(ANNUAL_OPERATION_COST);
        double annualProduction = input.get(ANNUAL_ELECTRICITY_PRODUCTION);
        double annualPayments = input.get(MONTHLY_ELECTRICITY_PRICE) * 12;
        double annualConsumption = input.get(MONTHLY_ELECTRICITY_CONSUMPTION) * 12;
        double sellPriceOfElectricity = input.get(ELECTRICITY_SELL_PRICE);

        double electricityPricePerKWh = annualPayments / annualConsumption;
        double surplusProduction;
        double savingsPerYear;

        if (annualProduction < annualConsumption){
            savingsPerYear = annualProduction * electricityPricePerKWh - annualOperationCost;
            surplusProduction = 0;
        } else{
            savingsPerYear = annualPayments - annualOperationCost;
            surplusProduction = annualProduction - annualConsumption;
        }
        savingsPerYear = savingsPerYear + sellPriceOfElectricity * surplusProduction;

        double yearsToPayInstallationCost = installationCost / savingsPerYear;

        data.put(YEARS_TO_BREAK_EVEN, yearsToPayInstallationCost);
        return data;
    }

    @Override
    public Set<DataKey> getKeysOfRequiredInput() {
        return new HashSet<>(Arrays.asList(INSTALLATION_COST, ANNUAL_OPERATION_COST, ANNUAL_ELECTRICITY_PRODUCTION, MONTHLY_ELECTRICITY_PRICE, MONTHLY_ELECTRICITY_CONSUMPTION));
    }

    @Override
    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(YEARS_TO_BREAK_EVEN));
    }

    @Override
    public String toString(){
        return "YearsToBreakEvenCalculator";
    }
}

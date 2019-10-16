package main.java.model.Calculators;

//(4.2) Vegard

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.Calculators.DataKey.*;

class LevelizedCostOfElectricityCalculator implements Calculator{

    private final Set<DataKey> requiredInput = new HashSet<>(Arrays.asList(EXPECTED_LIFESPAN, INSTALLATION_COST, ANNUAL_OPERATION_COST, ANNUAL_ELECTRICITY_PRODUCTION));

    LevelizedCostOfElectricityCalculator() {
    }

    //Returns approximate cost of each kWh produced by a electricity generation setup
    @Override
    public void calculate(CalculatorData input) {

        double lifetime             = input.getValue(EXPECTED_LIFESPAN);
        double installationCost     = input.getValue(INSTALLATION_COST);
        double annualOperationCost  = input.getValue(ANNUAL_OPERATION_COST);
        double annualOutput         = input.getValue(ANNUAL_ELECTRICITY_PRODUCTION);

        double lifetimeOutput       = lifetime * annualOutput;
        double totalCost            = installationCost + (lifetime * annualOperationCost);
        double levelizedCost        = lifetimeOutput / totalCost;

        input.addValue(DataKey.LEVELIZED_ELECTRICITY_COST, levelizedCost);
    }

    @Override
    public Set<DataKey> getRequiredInput() {
        return requiredInput;
    }
}

package main.java.model.calculator;

//(4.2) Vegard

public class LevelizedCostOfElectricity implements Calculator<LevelizedCostOfElectricityInput, LevelizedCostOfElectricityOutput>{

    //Returns approximate cost of each kWh produced by a electricity generation setup
    public LevelizedCostOfElectricityOutput calculate(LevelizedCostOfElectricityInput input) {

        final int lifetime = input.getExpectedLifetime();
        final double installationCost = input.getInstallationCost();
        final double annualOperationCost = input.getAnnualOperationCost();
        final double annualOutput = input.getAnnualElectricityOutput();

        final double lifetimeOutput = lifetime * annualOutput;
        final double totalCost = installationCost + (lifetime * annualOperationCost);
        final double levelizedCost = lifetimeOutput / totalCost;

        return new LevelizedCostOfElectricityOutput(levelizedCost);
    }
}

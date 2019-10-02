package main.java.model.Calculator;

public class LevelizedCostOfElectricity implements Calculator<LevelizedCostOfElectricityInput, LevelizedCostOfElectricityOutput>{

    @Override
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

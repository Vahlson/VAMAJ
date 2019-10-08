package main.java.model.Calculator;

    // (3) and (7) Jonatan
    // Class that handles all calculations related to a property's installation cost of solar panels

public class InstallationCost implements Calculator<InstallationCostInput, InstallationCostOutput>{

    // Returns the InstallationCost output consisting of installation cost, subvented amount and subvented installation cost
    @Override
    public InstallationCostOutput calculate(InstallationCostInput input) {

        double installationCost         = installationCost(input.getAvailableSpace(), input.getRequiredPanelSpace(), input.getPanelPrice());
        double governmentSubvention     = subventionAmount(installationCost);
        double subventedInstallationCost= subventedCost(installationCost);

        return new InstallationCostOutput(installationCost, governmentSubvention, subventedInstallationCost);
    }

    // Calculates installationCost based on how many solar panels there's room for in the availableSpace of a property
    private double installationCost(double availableSpace, double requiredPanelSpace, double panelPrice){

        double installationCost = Math.floorDiv((int) availableSpace, (int) requiredPanelSpace) * panelPrice;

        return installationCost;
    }

    // Returns the subvented amount based on installationCost
    private double subventionAmount(double installationCost){
        return installationCost * 0.2;
    }

    // Returns installationCost after subvention
    private double subventedCost(double installationCost){
        return installationCost * 0.8;
    }
}

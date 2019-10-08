package main.java.model.Calculator;

public class InstallationCost implements Calculator<InstallationCostInput, InstallationCostOutput>{

    // Returns the installation cost of solar panels
    @Override
    public InstallationCostOutput calculate(InstallationCostInput input) {

        double availableSpace       = input.getAvailableSpace();
        double requiredPanelSpace   = input.getRequiredSpace();
        double panelPrice           = input.getPanelPrice();

        double installationCost     = installSetupCost(input.getAvailableSpace(), input.getRequiredSpace(), input.getPanelPrice());
        double governmentSubvention = subventionAmount(installationCost);
        double subventedInstallationCost = subventedCost(installationCost);

        return new InstallationCostOutput(installationCost, governmentSubvention, subventedInstallationCost);
    }

    // Calculates installationCost based on how many solar panels fits in availableSpace
    private double installSetupCost(double availableSpace, double requiredPanelSpace, double panelPrice){

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

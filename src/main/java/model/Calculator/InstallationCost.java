package main.java.model.Calculator;

public class InstallationCost implements Calculator<InstallationCostInput, InstallationCostOutput>{

    // Returns the installation cost of solar panels
    @Override
    public InstallationCostOutput calculate(InstallationCostInput input) {

        double availableSpace       = input.getAvailableSpace();
        double requiredPanelSpace   = input.getRequiredSpace();
        double panelPrice           = input.getPanelPrice();

        double installationCost     = availableSpace / requiredPanelSpace * panelPrice;

        return new InstallationCostOutput(installationCost);
    }
}

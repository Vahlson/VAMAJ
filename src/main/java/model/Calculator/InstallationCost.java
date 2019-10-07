package main.java.model.Calculator;

public class InstallationCost implements Calculator<InstallationCostInput, InstallationCostOutput>{

    @Override
    public InstallationCostOutput calculate(InstallationCostInput installationCostInput) {

        double availableSpace = installationCostInput.getAvailableSpace();
        double requiredPanelSpace = installationCostInput.getRequiredSpace();
        double panelPrice = installationCostInput.getPanelPrice();

        double installationCost = availableSpace / requiredPanelSpace * panelPrice;

        return new InstallationCostOutput(installationCost);
    }
}

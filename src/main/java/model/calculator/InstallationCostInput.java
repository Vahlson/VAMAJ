package main.java.model.calculator;

// (3) Jonatan
// Class to contain input values of InstallationCost calculation

public class InstallationCostInput {

    private double availableSpace;
    private double requiredPanelSpace;
    private double panelPrice;

    public InstallationCostInput(double availableSpace, double requiredSpace, double panelPrice) {
        this.availableSpace = availableSpace;
        this.requiredPanelSpace = requiredSpace;
        this.panelPrice = panelPrice;
    }

    // Getters
    double getAvailableSpace() {
        return availableSpace;
    }

    double getRequiredPanelSpace() {
        return requiredPanelSpace;
    }

    double getPanelPrice() {
        return panelPrice;
    }
}

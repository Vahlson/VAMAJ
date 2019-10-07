package main.java.model.Calculator;

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

    //Getters
    public double getAvailableSpace() {
        return availableSpace;
    }

    public double getRequiredSpace() {
        return requiredPanelSpace;
    }

    public double getPanelPrice() {
        return panelPrice;
    }
}

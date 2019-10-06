package main.java.model.Calculator;

public class InstallationCostInput {

    private double availableSpace;
    private double requiredSpace;
    private double panelPrice;

    public InstallationCostInput(double availableSpace, double requiredSpace, double panelPrice) {
        this.availableSpace = availableSpace;
        this.requiredSpace = requiredSpace;
        this.panelPrice = panelPrice;
    }

    //Getters
    public double getAvailableSpace() {
        return availableSpace;
    }

    public double getRequiredSpace() {
        return requiredSpace;
    }

    public double getPanelPrice() {
        return panelPrice;
    }
}

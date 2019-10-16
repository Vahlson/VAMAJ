package main.java.model.calculator;

// (4.1) arcsak
// https://photovoltaic-software.com/principle-ressources/how-calculate-solar-energy-power-pv-systems
public class SolarPanelProductionInput {

    // Member variables
    private double panelArea;               // Total solar panel area (m2)
    private double averageSolarRadiation;   // Solar panel yield/efficiency (%)
    private double panelEfficiency;         // Annual average solar radiation
    private double panelPerformanceRatio;   // Performance ratio, default 0.75

    // Constructor (empty)
    public SolarPanelProductionInput() {

    }

    // Setters
    public void setPanelEfficiency(double efficiency) {
        this.panelEfficiency = efficiency;
    }

    public void setPanelArea(double panelArea) {
        this.panelArea = panelArea;
    }

    public void setAverageSolarRadiation(double averageSolarRadiation) {
        this.averageSolarRadiation = averageSolarRadiation;
    }

    public void setPanelPerformanceRatio(double panelPerformanceRatio) {
        this.panelPerformanceRatio = panelPerformanceRatio;
    }

    // Getters
    double getPanelEfficiency() {
        return panelEfficiency;
    }

    double getPanelArea() {
        return panelArea;
    }

    double getAverageSolarRadiation() {
        return averageSolarRadiation;
    }

    double getPanelPerformanceRatio() {
        return panelPerformanceRatio;
    }
}

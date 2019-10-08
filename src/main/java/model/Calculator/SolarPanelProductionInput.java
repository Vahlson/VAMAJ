package main.java.model.Calculator;

// (4.1) arcsak
// https://photovoltaic-software.com/principle-ressources/how-calculate-solar-energy-power-pv-systems
public class SolarPanelProductionInput {

    // Member variables
    private double area;
    private double averageSolarRadiation;
    private double panelEfficiency;
    private double performanceRatio;

    // Constructor (empty)
    public SolarPanelProductionInput() {

    }

    // Setters
    public void setPanelEfficiency(double efficiency) {
        this.panelEfficiency = efficiency;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setAverageSolarRadiation(double averageSolarRadiation) {
        this.averageSolarRadiation = averageSolarRadiation;
    }

    public void setPerformanceRatio(double performanceRatio) {
        this.performanceRatio = performanceRatio;
    }

    // Getters
    public double getPanelEfficiency() {
        return panelEfficiency;
    }

    public double getArea() {
        return area;
    }

    public double getAverageSolarRadiation() {
        return averageSolarRadiation;
    }

    public double getPerformanceRatio() {
        return performanceRatio;
    }
}

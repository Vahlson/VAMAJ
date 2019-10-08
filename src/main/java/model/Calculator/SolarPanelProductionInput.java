package main.java.model.Calculator;

// (4.1) arcsak
// https://photovoltaic-software.com/principle-ressources/how-calculate-solar-energy-power-pv-systems
public class SolarPanelProductionInput {

    // Member variables
    private double energy;
    private double area;
    private double solarRadiation;
    private double performanceRatio;

    // Constructor (empty)
    public SolarPanelProductionInput() {
        
    }

    // Setters
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setSolarRadiation(double solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public void setPerformanceRatio(double performanceRatio) {
        this.performanceRatio = performanceRatio;
    }

    // Getters
    public double getEnergy() {
        return energy;
    }

    public double getArea() {
        return area;
    }

    public double getSolarRadiation() {
        return solarRadiation;
    }

    public double getPerformanceRatio() {
        return performanceRatio;
    }
}

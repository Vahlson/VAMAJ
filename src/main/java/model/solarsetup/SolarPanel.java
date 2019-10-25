package main.java.model.solarsetup;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Abstract representation of a single solar panel.
// Used by: SolarSetup, ModelAggregate.
// Uses: Holds data common to a solarpanel. Implementations have more specific data.

public abstract class SolarPanel {
    private final double size;
    private final double retailPrice;
    private final double wattage;  // in KW
    private double annualOperationCost;
    private double lifeExpectancy;
    private double efficiency;
    private double performanceRatio;

    public SolarPanel(double size, double retailPrice, double wattage) {
        this.size = size;
        this.retailPrice = retailPrice;
        this.wattage = wattage;
        this.lifeExpectancy = 20;
    }

    //Getters
    public double getSize() {
        return this.size;
    }

    public double getLifeExpectancy() {
        return this.lifeExpectancy;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public double getWattage() {
        return this.wattage;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public double getAnnualOperationCost() {
        return annualOperationCost;
    }

    public double getPerformanceRatio() {
        return performanceRatio;
    }


    //Setters
    public void setAnnualOperationCost(double annualOperationCost) {
        this.annualOperationCost = annualOperationCost;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setPerformanceRatio(double performanceRatio) {
        this.performanceRatio = performanceRatio;
    }
}

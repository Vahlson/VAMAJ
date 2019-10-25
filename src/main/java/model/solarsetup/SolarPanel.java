package main.java.model.solarsetup;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Abstract representation of a single solar panel.
// Used by: SolarSetup, ModelAggregate.
// Uses: Holds data common to a solarpanel. Implementations have more specific data.

public abstract class SolarPanel {
    private final double size;
    private final double retailPrice;
    private final double wattage;  // in KW
    private double productionPerHour;
    private double annualOperationCost;
    private double lifeExpectancy;
    private double efficiency;
    private double performanceRatio;
    private String panelName;
    private String panelManufacturer;


    public SolarPanel(double size, double retailPrice, double wattage) {
        this.size = size;
        this.productionPerHour = 0;
        this.retailPrice = retailPrice;
        this.wattage = wattage;
        this.lifeExpectancy = 20;
        this.panelName = "Generic Panel";
        this.panelManufacturer = "Generic Panel Manufacturer";
    }

    //Getters

    public double getSize() {
        return this.size;
    }


    public double getProductionPerHour() {
        return this.productionPerHour;
    }

    public void setProductionPerHour(double productionPerHour) {
        this.productionPerHour = productionPerHour;
    }

    public double getLifeExpectancy() {
        return this.lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public double getWattage() {
        return this.wattage;
    }

    public String getPanelName() {
        return this.panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public String getPanelManufacturer() {
        return this.panelManufacturer;
    }


//Setter

    public void setPanelManufacturer(String panelManufacturer) {
        this.panelManufacturer = panelManufacturer;
    }

    public double getAnnualOperationCost() {
        return annualOperationCost;
    }

    public void setAnnualOperationCost(double annualOperationCost) {
        this.annualOperationCost = annualOperationCost;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getPerformanceRatio() {
        return performanceRatio;
    }

    public void setPerformanceRatio(double performanceRatio) {
        this.performanceRatio = performanceRatio;
    }
}

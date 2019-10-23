package main.java.model.solarsetup;

//Representation of a singel solar panel.
public abstract class SolarPanel {
    private final double size;
    private double productionPerHour;
    private double annualOperationCost;
    private double lifeExpectancy;
    private final double retailPrice;
    private final double wattage;  // in KW
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


    public double getLifeExpectancy() {
        return this.lifeExpectancy;
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

    public String getPanelManufacturer() {
        return this.panelManufacturer;
    }

    public double getAnnualOperationCost() {
        return annualOperationCost;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public double getPerformanceRatio() {
        return performanceRatio;
    }


//Setter

    public void setPerformanceRatio(double performanceRatio) {
        this.performanceRatio = performanceRatio;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public void setAnnualOperationCost(double annualOperationCost) {
        this.annualOperationCost = annualOperationCost;
    }


    public void setProductionPerHour(double productionPerHour) {
        this.productionPerHour = productionPerHour;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public void setPanelManufacturer(String panelManufacturer) {
        this.panelManufacturer = panelManufacturer;
    }
}

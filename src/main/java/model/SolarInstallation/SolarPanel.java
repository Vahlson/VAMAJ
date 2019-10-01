package main.java.model.SolarInstallation;

public class SolarPanel {
    private double requiredSpace;
    private double productionPerHour;
    private double lifeExpectancy;
    private double retailPrice;
    private double wattage;
    private String panelName;
    private String panelManufacturer;


    public SolarPanel(double requiredSpace, double productionPerHour, double lifeExpectancy, double retailPrice, double wattage, String panelName, String panelManufacturer) {
        this.requiredSpace = requiredSpace;
        this.productionPerHour = productionPerHour;
        this.lifeExpectancy = lifeExpectancy;
        this.retailPrice = retailPrice;
        this.wattage = wattage;
        this.panelName = panelName;
        this.panelManufacturer = panelManufacturer;
    }

    public double getRequiredSpace() {
        return requiredSpace;
    }

    public void setRequiredSpace(double requiredSpace) {
        this.requiredSpace = requiredSpace;
    }

    public double getProductionPerHour() {
        return productionPerHour;
    }

    public void setProductionPerHour(double productionPerHour) {
        this.productionPerHour = productionPerHour;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public String getPanelManufacturer() {
        return panelManufacturer;
    }

    public void setPanelManufacturer(String panelManufacturer) {
        this.panelManufacturer = panelManufacturer;
    }



}

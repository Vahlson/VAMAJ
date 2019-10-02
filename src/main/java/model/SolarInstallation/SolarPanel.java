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



    public double getProductionPerHour() {
        return productionPerHour;
    }



    public double getLifeExpectancy() {
        return lifeExpectancy;
    }


    public double getRetailPrice() {
        return retailPrice;
    }


    public double getWattage() {
        return wattage;
    }


    public String getPanelName() {
        return panelName;
    }

    public String getPanelManufacturer() {
        return panelManufacturer;
    }




}

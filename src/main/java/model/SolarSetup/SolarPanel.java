package model.SolarSetup;

public class SolarPanel {
    private double requiredSpace;
    private double productionPerHour;
    private double lifeExpectancy;
    private double retailPrice;
    private double wattage;
    private String panelName;
    private String panelManufacturer;

    public SolarPanel()
    {


    }

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
        return this.requiredSpace;
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




}

package main.java.model.solarsetup;

//Representation of a singel solar panel.
public class SolarPanel {
    private double size;
    private double productionPerHour;
    private double lifeExpectancy;
    private double retailPrice;
    private double wattage;
    private String panelName;
    private String panelManufacturer;

    public SolarPanel()
    {


    }

    public SolarPanel(double requiredSpace, double retailPrice, double wattage) {
        this.size = requiredSpace;
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


    //Setter

    public void setSize(double size) {
        this.size = size;
    }

    public void setProductionPerHour(double productionPerHour) {
        this.productionPerHour = productionPerHour;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public void setPanelManufacturer(String panelManufacturer) {
        this.panelManufacturer = panelManufacturer;
    }
}

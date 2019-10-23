package main.java.model.solarsetup;

public class PremiumSolarPanel extends SolarPanel {

    public PremiumSolarPanel (){
        super(2,10000,0.3);
        setLifeExpectancy(30);
        setEfficiency(0.25);
        setProductionPerHour(getWattage());
        setAnnualOperationCost(getRetailPrice()*0.015);
        setPerformanceRatio(0.9);
    }

}

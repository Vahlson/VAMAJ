package main.java.model.solarsetup;

public class StandardSolarPanel extends SolarPanel {

    public StandardSolarPanel (){
        super(2,7000,0.25);
        setLifeExpectancy(25);
        setEfficiency(0.2);
        setProductionPerHour(getWattage());
        setAnnualOperationCost(getRetailPrice()*0.01);
        setPerformanceRatio(0.8);
    }
}

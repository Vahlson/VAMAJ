package main.java.model;

import main.java.model.Calculator.AnnualSolarElectricity;
import main.java.model.Calculator.AnnualSolarElectricityInput;
import main.java.model.Calculator.AnnualSolarElectricityOutput;
import main.java.model.Property.Property;
import main.java.model.Calculator.Calculator;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.user.User;

import java.util.List;
import java.util.HashMap;

//(2)Vegard

public class ModelAggregate {

    private Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AnnualCal = new AnnualSolarElectricity();

    private User currentUser;
    private List<User> users;
    private Property property;
    private HashMap<String, Object> calculationResults = new HashMap<>(); //HashMap containing results with a string as key

    //Calls calculators and sets results to above HashMap
    public void runCalculators(){
        double annualElectricityOutput = annualElectricityOutput(AnnualCal, property);
        calculationResults.put("annualElectricity", annualElectricityOutput);
    }

    //Sends values from property as calculation parameters, returns result of the calculation
    private double annualElectricityOutput(Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> calc, Property p){
        double lat = p.getLatitude();
        double area = p.getInstallationSpace();
        double efficiency = 22;

        //Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AnnualCal;
        AnnualSolarElectricityInput in = new AnnualSolarElectricityInput(lat, area, efficiency);
        AnnualSolarElectricityOutput out = calc.calculate(in);
        return out.getAnnualElectricityProduction();
    }

    //Temporary setter for testing purposes
    public void setProperty(Property property) {
        this.property = property;
    }

    // Getter for results of calculation(s)
    public HashMap<String, Object> getCalculationResults() {
        return calculationResults;
    }

    // Setters in property
    void setPropertyLocation(Location l) {
        property.setLocation(l);
    }

    void setPropertyLatitude(double latitude) {
        property.setLatitude(latitude);
    }

    void setPropertyPanelAngle(int panelAngle) {
        property.setPanelAngle(panelAngle);
    }

    void setPropertyOrientation(int orientation) {
        property.setOrientation(orientation);
    }

    void setPropertyInstallationSpace(double installationSpace) {
        property.setInstallationSpace(installationSpace);
    }

    // Setters in contract
    public void setContract(Contract c) {
        property.setContract(c);
    }

    public void setContractCost(int cost) {
        property.getContract().setCost(cost);
    }
}

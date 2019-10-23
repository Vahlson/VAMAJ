package main.java.model;

import main.java.model.calculator.*;
import main.java.model.contract.Contract;
import main.java.model.contract.DynamicContract;
import main.java.model.property.ConsumingProperty;
import main.java.model.property.Location;
import main.java.model.property.NonConsumingProperty;
import main.java.model.property.Property;
import main.java.model.solarsetup.*;
import main.java.model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static main.java.model.calculator.DataKey.*;

//(2)Vegard

//The aggregate object of the model, orchestrates the interactions between the calculator and model data.
public class ModelAggregate {

    private User currentUser;
    private List<User> users;
    private Double result; //HashMap containing values with a ENUM as key
    //private CalculatorFacade runner = new CalculatorFacade();
    private HashMap<DataKey, Double> calculationData;

    public ModelAggregate() {
        calculationData = new HashMap<>();

        users = new ArrayList<>();
        currentUser = new User();
        users.add(currentUser);

    }

    // Gathers data from the model so that it can be used in calculations.
    private void getDataFromModel() {

        //Gather data from the model's Solar Setup.
        SolarSetup solarSetup = getSolarSetup();
        calculationData.put(AVAILABLE_SPACE, solarSetup.getAvailableSpace());
        calculationData.put(INSTALLATION_COST, solarSetup.getInstallationCost());//MÖJLIGEN TA BORT????
        calculationData.put(PRODUCED_ELECTRICITY,solarSetup.getTotalEProductionPerHour());
        calculationData.put(ANNUAL_OPERATION_COST,solarSetup.getAnnualOperationCost());
        calculationData.put(ANNUAL_ELECTRICITY_PRODUCTION,solarSetup.getAnnualElectricityProduction());
        calculationData.put(SOLAR_PANEL_COVERAGE,solarSetup.getSolarPanelCoverage());

        // Get a template panel to gather panel-specific values.
        SolarPanel templatePanel = getSolarSetup().getASolarPanel();
        calculationData.put(PANEL_PRICE, templatePanel.getRetailPrice());
        calculationData.put(PANEL_SIZE, templatePanel.getSize());
        calculationData.put(EXPECTED_LIFESPAN,templatePanel.getLifeExpectancy());
        calculationData.put(SOLAR_PANEL_PERFORMANCE_RATIO,templatePanel.getPerformanceRatio());
        calculationData.put(SOLAR_PANEL_EFFICIENCY,templatePanel.getEfficiency());


        // Get data from det model's contract
        Contract contract = getContract();
        calculationData.put(CONSUMED_ELECTRICITY,contract.getConsumedElectricity());
        calculationData.put(MONTHLY_ELECTRICITY_PRICE,contract.getMonthlyCost());


        // Get data from det model's location
        Location location = getLocation();
        calculationData.put(AVERAGE_SOLAR_RADIATION,location.getSolarInsolation());

    }

    // Calls calculators and sets results to above HashMap
    void runCalculators() {
        getDataFromModel();
        //Set the calculated output values in thehashmap.
        calculationData = CalculatorFacade.calculateAll(calculationData);

    }

    // Getter for results of calculation(s)
    Double getCalculationResult(DataKey key) {
        return Objects.requireNonNull(calculationData.get(key), "Insufficient data for calculations of: " + key.getDescription());
    }

    //Adding data for calculations.
    void addCalculationData(DataKey key, double value) {
        calculationData.put(key, value);
    }


    // Getters
    Property getProperty() {
        return currentUser.getActiveProperty();
    }

    // Lazy instantiation.
    Location getLocation() {
        // If there is no object in the model, create it.
        //Goes against command-query separation principle but makes handling of potential null-objects much easier.
        if (getProperty().getLocation() == null) {
            Location location = new Location();
            getProperty().setLocation(location);
        }
        return getProperty().getLocation();
    }
    // Lazy instantiation.
    Contract getContract() {
        // If there is no object in the model, create it.
        //Goes against command-query separation principle but makes handling of potential null-objects much easier.
        if (getProperty().getContract() == null) {
            Contract contract = new DynamicContract(0, 0);
            getProperty().setContract(contract);
        }
        return getProperty().getContract();
    }
    // Lazy instantiation.
    SolarSetup getSolarSetup() {
        //If there is no object in the model, create it.
        //Goes against command-query separation principle but makes handling of potential null-objects much easier.
        if (getProperty().getSolarSetup() == null) {
            SolarSetup solarSetup = new RoofBasedSolarSetup(0, 0);
            getProperty().setSolarSetup(solarSetup);
        }
        return getProperty().getSolarSetup();
    }


    // The solar panel typ is
    public void setSolarPanelsStandard() {
        getSolarSetup().setSolarPanelsStandard();

    }

    public void setSolarPanelsPremium() {
        getSolarSetup().setSolarPanelsPremium();

    }

    //Setting the users property to another type by copying old values.
    public void setPropertyConsuming(){
        Property newProperty = new ConsumingProperty();
        Property oldProperty = getProperty();

        newProperty.setLocation(oldProperty.getLocation());
        newProperty.setContract(oldProperty.getContract());
        newProperty.setSolarSetup(oldProperty.getSolarSetup());


        currentUser.setProperty(newProperty);

    }
    //Setting the users property to another type by copying old values.
    public void setPropertyNonConsuming(){
        Property newProperty = new NonConsumingProperty();
        Property oldProperty = getProperty();

        newProperty.setLocation(oldProperty.getLocation());
        newProperty.setSolarSetup(oldProperty.getSolarSetup());


        currentUser.setProperty(newProperty);
    }

}

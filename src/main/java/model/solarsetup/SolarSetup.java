package main.java.model.solarsetup;

import java.util.ArrayList;
import java.util.List;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Abstract representation of a single solar setup.
// Used by: ModelFacade, ModelAggregate, PrimaryController, Property. (Yes that's alot...)
// Uses: Holds data common to a solarsetup. Implementations have more specific data. Holds each solarpanel.

//Object that holds the information about a solar setup.
public abstract class SolarSetup {

    // Member variables
    private List<SolarPanel> solarPanels;

    private double installationCost;
    private double availableSpace;
    private int orientation;
    private int angle;


    public SolarSetup() {
        this.solarPanels = new ArrayList<>();
        this.installationCost = 0;
        this.availableSpace = 0;
        this.orientation = 0;
        this.angle = 0;
    }

    //Getters
    public List<SolarPanel> getSolarPanels() {
        return this.solarPanels;
    }

    //Setters
    public void setSolarPanels(List<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }

    //Lazy instantiation, gets a solar panel
    public SolarPanel getASolarPanel() {
        //if there are no solarpanels,
        if (solarPanels.isEmpty()) {
            setSolarPanelsStandard();
        }

        //If solarpanels isnt empty anymore return the first solarPanel.
        if (!solarPanels.isEmpty()) {
            return solarPanels.get(0);
        } else {
            //If solarpanels is still empty (due to availablespace not being set)
            //Default to return a standard solar panel.
            return new StandardSolarPanel();
        }

    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    //Sums up effeciency of solar panels.
    public double getTotalEProductionPerHour() {
        double totalProduction = 0.0;
        for (SolarPanel p : solarPanels) {
            totalProduction += p.getProductionPerHour();
        }
        return totalProduction;
    }

    public double getInstallationCost() {
        return this.installationCost;
    }

    public void setInstallationCost(double installationCost) {
        this.installationCost = installationCost;
    }

    public double getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(double availableSpace) {
        this.availableSpace = availableSpace;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getPanelAngle() {
        return angle;
    }

    // Returns the sum of each solar panel's annualoperationCost.
    public double getAnnualOperationCost() {
        double totalAnnualOperationCost = 0.0;
        for (SolarPanel p : solarPanels) {
            totalAnnualOperationCost += p.getAnnualOperationCost();
        }
        return totalAnnualOperationCost;
    }

    //Returns the sum of each solar panel's productionperhour times hours in a year.
    public double getAnnualElectricityProduction() {
        double annualElectricityProduction = 0.0;
        for (SolarPanel p : solarPanels) {
            annualElectricityProduction += p.getProductionPerHour();
        }
        annualElectricityProduction *= 8766;
        return annualElectricityProduction;
    }

    // Returns the sum of each solar panels area.
    public double getSolarPanelCoverage() {
        double solarPanelCoverage = 0.0;
        for (SolarPanel p : solarPanels) {
            solarPanelCoverage += p.getSize();
        }
        return solarPanelCoverage;
    }

    // The solar panel typ is
    public void setSolarPanelsStandard() {
        SolarPanel templateSolarPanel = new StandardSolarPanel();
        setSolarPanelsFromTemplate(templateSolarPanel);


    }

    public void setSolarPanelsPremium() {
        SolarPanel templateSolarPanel = new PremiumSolarPanel();
        setSolarPanelsFromTemplate(templateSolarPanel);
        System.out.println(getNumberOfSolarPanels(templateSolarPanel));

    }

    //Fills the solarsetup solarpanel list with the amount of solar panels that fit in the available space.
    private void setSolarPanelsFromTemplate(SolarPanel templateSolarPanel) {

        for (int i = 0; i < getNumberOfSolarPanels(templateSolarPanel); i++) {
            solarPanels.add(templateSolarPanel);
        }

        setSolarPanels(solarPanels);
    }

    // Gets the amount of solarPanels that fit in the available space.
    public int getNumberOfSolarPanels(SolarPanel templateSolarPanel) {

        int numberOfSolarPanels = 0;
        numberOfSolarPanels = (int) Math.floor(availableSpace / templateSolarPanel.getSize());

        return numberOfSolarPanels;
    }

}

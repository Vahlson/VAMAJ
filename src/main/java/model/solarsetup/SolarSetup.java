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
    private double availableSpace;
    private double installationCost;

    public SolarSetup() {

        this.solarPanels = new ArrayList<>();
        this.availableSpace = 0;

    }

    //Setters
    public void setSolarPanels(List<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }

    public void setAvailableSpace(double availableSpace) {
        this.availableSpace = availableSpace;
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

    public void setInstallationCost(double installationCost) {
        this.installationCost = installationCost;
    }


    //Getters
    //Sums up efficiency of solar panels.
    public double getTotalWattage() {
        double totalWattage = 0.0;
        for (SolarPanel p : solarPanels) {
            totalWattage += p.getWattage();
        }
        return totalWattage;
    }

    public double getAvailableSpace() {
        return availableSpace;
    }

    // Returns the sum of each solar panel's annualoperationCost.
    public double getAnnualOperationCost() {
        double totalAnnualOperationCost = 0.0;
        for (SolarPanel p : solarPanels) {
            totalAnnualOperationCost += p.getAnnualOperationCost();
        }
        return totalAnnualOperationCost;
    }


    // Returns the sum of each solar panels area.
    public double getSolarPanelCoverage() {
        double solarPanelCoverage = 0.0;
        for (SolarPanel p : solarPanels) {
            solarPanelCoverage += p.getSize();
        }
        return solarPanelCoverage;
    }


    // Gets the amount of solarPanels that fit in the available space.
    public int getNumberOfSolarPanels(SolarPanel templateSolarPanel) {

        int numberOfSolarPanels = 0;
        numberOfSolarPanels = (int) Math.floor(availableSpace / templateSolarPanel.getSize());

        return numberOfSolarPanels;
    }

}

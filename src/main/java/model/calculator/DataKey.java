package main.java.model.calculator;

public enum DataKey {
    SOLAR_PANEL_EFFICIENCY,
    ELECTRICITY_PRODUCTION_CAPACITY("Produktion i KW"),
    MONTHLY_ELECTRICITY_CONSUMPTION,
    SURPLUS("Överskott av energi"),
    INSTALLATION_COST ("Installationskostnad"),
    GOVERNMENT_SUBVENTION ("Statlig subvention"),
    SUBVENTED_INSTALLATION_COST ("Totalkostnad efter subvention"),
    AVAILABLE_SPACE,
    PANEL_SIZE,
    PANEL_PRICE,
    LEVELIZED_ELECTRICITY_COST ("Levelized Electricity Cost"),
    ANNUAL_ELECTRICITY_PRODUCTION("El produktion under ett år : "),
    ANNUAL_OPERATION_COST("Underhållningskostnad per år"),
    EXPECTED_LIFESPAN,
    SOLAR_PANEL_COVERAGE("coverage : "),
    AVERAGE_SOLAR_RADIATION,
    SOLAR_PANEL_PERFORMANCE_RATIO,
    MONTHLY_ELECTRICITY_PRICE,
    YEARS_TO_BREAK_EVEN ("År till vinst");

    private String description = "Value";

    private DataKey(String description) {
        this.description = description;
    }
    private DataKey() {
    }

    public String getDescription() {
        return description;
    }
}

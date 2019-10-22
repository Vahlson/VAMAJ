package main.java.model.calculator;

public enum DataKey {
    SOLAR_PANEL_EFFICIENCY,
    PRODUCED_ELECTRICITY,
    CONSUMED_ELECTRICITY,
    SURPLUS("Electricity Surplus"),
    INSTALLATION_COST ("Installation Cost"),
    GOVERNMENT_SUBVENTION,
    SUBVENTED_INSTALLATION_COST ("Subvented Installation Cost"),
    AVAILABLE_SPACE,
    PANEL_SIZE,
    PANEL_PRICE,
    LEVELIZED_ELECTRICITY_COST,
    ANNUAL_ELECTRICITY_PRODUCTION,
    ANNUAL_OPERATION_COST,
    EXPECTED_LIFESPAN,
    SOLAR_PV_DAILY_ELECTRICITY("Solar PV Daily Electricity"),
    SOLAR_PANEL_COVERAGE,
    AVERAGE_SOLAR_RADIATION,
    SOLAR_PANEL_PERFORMANCE_RATIO,
    MONTHLY_ELECTRICITY_PRICE,
    YEARS_TO_BREAK_EVEN ("Years to break even");

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

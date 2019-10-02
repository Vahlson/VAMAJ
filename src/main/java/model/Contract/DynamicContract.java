package main.java.model.Contract;

public class DynamicContract extends Contract {
    private final double extraFee = 1.2;

    public DynamicContract(String contractProvider, String contractCity, double tariff, double contractDuration) {
        super(contractProvider, contractCity, tariff, contractDuration);
    }

    public double extraTariffCost(){

        return getTariff() * extraFee;

    }
}

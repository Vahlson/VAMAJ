package main.java.model.Contract;

public class DynamicContract extends Contract {
    private final double extraFee = 1.2;

    public DynamicContract(String contractProvider, String contractCity, int cost, double contractDuration) {
        super(contractProvider, contractCity, cost, contractDuration);
    }

    public double extraTariffCost(){

        return getCost() * extraFee;

    }
}

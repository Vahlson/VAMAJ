package model.contract;

public class DynamicContract extends Contract {

    public DynamicContract(String contractProvider, String contractCity, int cost, double contractDuration) {
        super(contractProvider, contractCity, cost, contractDuration);
    }

    public double extraTariffCost() {

        double extraFee = 1.2;
        return getCost() * extraFee;

    }
}

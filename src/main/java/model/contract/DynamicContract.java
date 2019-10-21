package main.java.model.contract;

public class DynamicContract extends Contract {

    public DynamicContract(String contractCity, int cost, double contractDuration) {
        super(contractCity, cost, contractDuration);
    }

    public double extraTariffCost() {

        double extraFee = 1.2;
        return getCost() * extraFee;

    }
}

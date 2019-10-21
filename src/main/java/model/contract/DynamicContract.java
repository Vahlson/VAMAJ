package main.java.model.contract;

// Implementaion of a contract that is of the dynamic type.
public class DynamicContract extends Contract {

    public DynamicContract(String contractCity, int cost, double contractDuration) {
        super(contractCity, cost, contractDuration);
    }

    public double extraTariffCost() {

        double extraFee = 1.2;
        return getCost() * extraFee;

    }
}

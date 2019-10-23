package main.java.model.contract;

// Implementaion of a contract that is of the dynamic type.
public class DynamicContract extends Contract {

    public DynamicContract(int cost, double contractDuration) {
        super(cost, contractDuration);
    }

    public double extraTariffCost() {

        double extraFee = 0.2;
        return getMonthlyCost() * extraFee;

    }
}

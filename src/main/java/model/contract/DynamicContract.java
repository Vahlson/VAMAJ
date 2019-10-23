package main.java.model.contract;

// Implementaion of a contract that is of the dynamic type.
public class DynamicContract extends Contract {

    public DynamicContract(double cost, double consumedElectricity) {
        super(cost, consumedElectricity);
    }

    public double extraTariffCost() {

        double extraFee = 0.2;
        return getMonthlyCost() * extraFee;

    }
}

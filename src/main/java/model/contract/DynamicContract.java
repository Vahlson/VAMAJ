package main.java.model.contract;

public class DynamicContract extends Contract {

    public DynamicContract(String contractProvider, String contractCity, int cost, double contractDuration) {
        super(contractProvider, contractCity, cost, contractDuration);
    }

    @Override
    public Contract setCost(int cost) {
        return new DynamicContract(super.getContractProvider(), super.getContractCity(), cost, super.getContractDuration());
    }

    public double extraTariffCost() {

        double extraFee = 1.2;
        return getCost() * extraFee;

    }
}

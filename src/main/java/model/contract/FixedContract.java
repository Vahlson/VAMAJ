package main.java.model.contract;

public class FixedContract extends Contract {

    public FixedContract(String contractProvider, String contractCity, int cost, double contractDuration) {
        super(contractProvider, contractCity, cost, contractDuration);
    }

    @Override
    public Contract setCost(int cost) {
        return new FixedContract(super.getContractProvider(), super.getContractCity(), cost, super.getContractDuration());
    }

    public double fixedContractBonus() {

        double fixedBonus = 0.8;
        return getCost() * fixedBonus;

    }
}

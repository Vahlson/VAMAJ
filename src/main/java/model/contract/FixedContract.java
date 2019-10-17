package model.contract;

public class FixedContract extends Contract {

    public FixedContract(String contractProvider, String contractCity, int cost, double contractDuration) {
        super(contractProvider, contractCity, cost, contractDuration);
    }

    public double fixedContractBonus() {

        double fixedBonus = 0.8;
        return getCost() * fixedBonus;

    }
}

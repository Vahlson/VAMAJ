package main.java.model.contract;

// Implementaion of a contract that is of the static type.
public class FixedContract extends Contract {

    public FixedContract(String contractCity, int cost, double contractDuration) {
        super(contractCity, cost, contractDuration);
    }

    public double fixedContractBonus() {

        double fixedBonus = 0.8;
        return getCost() * fixedBonus;

    }
}

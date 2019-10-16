package main.java.model.contract;

public class FixedContract extends Contract {

    private final double fixedBonus = 0.8;
    public FixedContract(String contractProvider, String contractCity, int cost, double contractDuration) {
        super(contractProvider, contractCity, cost, contractDuration);
    }
    public double fixedContractBonus(){

        return getCost() * fixedBonus;

    }
}

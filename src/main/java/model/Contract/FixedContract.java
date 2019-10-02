package main.java.model.Contract;

public class FixedContract extends Contract {

    private final double fixedBonus = 0.8;
    public FixedContract(String contractProvider, String contractCity, double tariff, double contractDuration) {
        super(contractProvider, contractCity, tariff, contractDuration);
    }
    public double fixedContractBonus(){

        return getTariff() * fixedBonus;

    }
}

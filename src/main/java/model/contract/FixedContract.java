package main.java.model.contract;

// Implementaion of a contract that is of the static type.
public class FixedContract extends Contract {

    public FixedContract(double cost, double consumedElectricity) {
        super( cost, consumedElectricity);
    }

    public double fixedContractBonus() {

        double fixedBonus = 0.8;
        return getMonthlyCost() * fixedBonus;

    }
}

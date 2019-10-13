package services.ContractCreator;

import model.Contract.Contract;

//(3.1) Alex LV och Alex Ask
//Interface defining a contract creator. Implementations create contracts with data from different places.
public interface IContractCreator {

    Contract createContract();
}

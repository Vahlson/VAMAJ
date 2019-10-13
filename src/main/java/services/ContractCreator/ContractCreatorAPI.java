package services.ContractCreator;

import model.Contract.Contract;

//(3.1) Alex LV och Alex Ask
// Mock class, this will be API/File implementation later on
public class ContractCreatorAPI implements IContractCreator{

    //Creates a contract from data gathered from an api.
    @Override
    public Contract createContract() {

        MockContractAPI api = new MockContractAPI();
        Contract c = new Contract();
        c.setCost(api.getCost());

        return c;
    }
}

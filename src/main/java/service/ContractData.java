package main.java.service;


//(3.1) ALEX LV

import main.java.model.Contract.Contract;

public class ContractData implements Data{
    private int cost;

    public ContractData(){
        getAPIdata();
    }

    public Contract getData(){
        Contract c = new Contract();
        c.setCost(cost);

        return c;
    }

//Communication with the API

    void getAPIdata(){
        cost = 3;
    }
}
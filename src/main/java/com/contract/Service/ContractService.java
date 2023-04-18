package com.contract.Service;

import com.contract.Model.Contract;

import java.util.List;
public interface ContractService {
    List<Contract> getAllContract();
    Contract saveContract(Contract contract);
    Contract getContract(long id);
    Contract updateContract(Contract contract, long id);
    Contract deleteContract(long id);

    List<Contract> search(String term);

}

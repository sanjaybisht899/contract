package com.contract.ServiceImpl;

import com.contract.Exception.ResourceNotFoundException;
import com.contract.Model.Contract;
import com.contract.Repository.ContractRepository;
import com.contract.Service.ContractService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    private ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract getContract(long id) {
        return contractRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contract","Id",id)
        );
    }

    @Override
    public Contract updateContract(Contract contract, long id) {
        Contract current = contractRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Casino","Id",id)

        );
        current.setFirstName(contract.getFirstName());
        current.setLastName(contract.getLastName());
        current.setEmail(contract.getEmail());
        current.setPhoneNumber(contract.getPhoneNumber());
        return contractRepository.save(current);
    }

    @Override
    public Contract deleteContract(long id) {
        Contract current = contractRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Casino", "Id", id)
        );
        contractRepository.delete(current);
        return current;
    }

    @Override
    public List<Contract> search(String term) {
        List<Contract> contacts = contractRepository.findAll();
        List<Contract> matchingContacts = new ArrayList<>();

        for (Contract contact : contacts) {
            if (contact.getFirstName().contains(term) ||
                    contact.getLastName().contains(term) ||
                    contact.getEmail().contains(term)) {
                matchingContacts.add(contact);
            }
        }

        return matchingContacts;

    }


}

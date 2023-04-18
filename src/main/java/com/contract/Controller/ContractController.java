package com.contract.Controller;

import com.contract.Model.Contract;
import com.contract.Service.ContractService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "http://localhost:3000")
public class ContractController {
    private ContractService contractService;

    public ContractController(ContractService contractService) {
        super();
        this.contractService = contractService;
    }

    @ApiOperation(value = "Test if the program is working fine")
    @GetMapping("/test")
    public String Test(){
        return "Program is working fine.";
    }

    @GetMapping
    public List<Contract> getAllContract(){
        return contractService.getAllContract();
    }
    @PostMapping
    public ResponseEntity saveContract(@RequestBody Contract contract){
        return new ResponseEntity<Contract>(contractService.saveContract(contract), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Contract> getContract(@PathVariable long id){
        return new ResponseEntity<Contract>(contractService.getContract(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Contract> updateCasino(@PathVariable long id, @RequestBody Contract contract){
        return new ResponseEntity<Contract>(contractService.updateContract(contract,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Contract> deleteCasino(@PathVariable long id){
        return new ResponseEntity<Contract>(contractService.deleteContract(id),HttpStatus.OK);
    }
    @GetMapping("/search")
    public List<Contract> search(@RequestParam String term){
        return contractService.search(term);
    }

}

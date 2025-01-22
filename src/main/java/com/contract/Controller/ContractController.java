package com.contract.Controller;

import com.contract.Model.Contract;
import com.contract.Service.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "http://localhost:3000")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        super();
        this.contractService = contractService;
    }

    @Operation(summary = "Test if the program is working fine")
    @GetMapping("/test")
    public String test() {
        return "Program is working fine.";
    }

    @Operation(summary = "Get all contracts")
    @GetMapping
    public List<Contract> getAllContract() {
        return contractService.getAllContract();
    }

    @Operation(summary = "Save a new contract")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contract created",
                    content = @Content(schema = @Schema(implementation = Contract.class)))
    })
    @PostMapping
    public ResponseEntity<Contract> saveContract(@RequestBody Contract contract) {
        return new ResponseEntity<>(contractService.saveContract(contract), HttpStatus.CREATED);
    }

    @Operation(summary = "Get a contract by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contract found",
                    content = @Content(schema = @Schema(implementation = Contract.class))),
            @ApiResponse(responseCode = "404", description = "Contract not found")
    })
    @GetMapping("{id}")
    public ResponseEntity<Contract> getContract(@PathVariable long id) {
        return new ResponseEntity<>(contractService.getContract(id), HttpStatus.OK);
    }

    @Operation(summary = "Update an existing contract")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contract updated",
                    content = @Content(schema = @Schema(implementation = Contract.class))),
            @ApiResponse(responseCode = "404", description = "Contract not found")
    })
    @PutMapping("{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable long id, @RequestBody Contract contract) {
        return new ResponseEntity<>(contractService.updateContract(contract, id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a contract by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contract deleted"),
            @ApiResponse(responseCode = "404", description = "Contract not found")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Contract> deleteContract(@PathVariable long id) {
        return new ResponseEntity<>(contractService.deleteContract(id), HttpStatus.OK);
    }

    @Operation(summary = "Search contracts by term")
    @GetMapping("/search")
    public List<Contract> searchContract(@RequestParam String term) {
        return contractService.search(term);
    }
}

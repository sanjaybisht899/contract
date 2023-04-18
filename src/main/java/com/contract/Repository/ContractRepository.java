package com.contract.Repository;

import com.contract.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {

}

package com.contract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Contract"})
public class ContractApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContractApplication.class, args);
        System.out.println("Application Started");
    }
}

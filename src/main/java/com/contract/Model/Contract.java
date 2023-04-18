package com.contract.Model;

import javax.persistence.Entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
}

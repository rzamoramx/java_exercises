package com.ivansoft.java.exercises.designpatterns.cqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BankAccount {
    String accountNumber;
    String owner;
    double balance;
}

package com.ivansoft.java.exercises.designpatterns.cqrs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepositCommand implements Command {
    BankAccount bankAccount;
    double amount;

    @Override
    public void execute() {
        // Deposit money into the bank account
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        System.out.println("Deposit money into the bank account");
    }
}

package com.ivansoft.java.exercises.designpatterns.cqrs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WithdrawCommand implements Command {
    BankAccount bankAccount;
    double amount;

    @Override
    public void execute() {
        // Withdraw money from the bank account
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        System.out.println("Withdraw money from the bank account");
    }
}

package com.ivansoft.java.exercises.designpatterns.cqrs;

import org.junit.jupiter.api.Test;

public class CqrsTest {
    @Test
    void testCqrs() {
        BankAccount bankAccount = new BankAccount("123456789", "Ivan", 1000);

        BankAccountCommand bankAccountCommand = new BankAccountCommand();
        bankAccountCommand.submitCommand(new DepositCommand(bankAccount, 100));
        bankAccountCommand.submitCommand(new WithdrawCommand(bankAccount, 50));

        BankAccountQuery bankAccountQuery = new BankAccountQuery();
        BankAccount retrievedBankAccount = bankAccountQuery.getBalance(bankAccount.getAccountNumber());

        System.out.println(bankAccount.accountNumber);
        System.out.println(bankAccount.owner);
        System.out.println(bankAccount.balance);
    }
}

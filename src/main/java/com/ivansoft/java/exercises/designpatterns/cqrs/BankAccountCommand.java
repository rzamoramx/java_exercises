package com.ivansoft.java.exercises.designpatterns.cqrs;

public class BankAccountCommand implements CommandModel {

    @Override
    public void submitCommand(Command command) {
        if (command instanceof DepositCommand) {
            // Deposit money into the bank account
            // additional code here for this command
            System.out.println("performing additional code here for deposit command");
            command.execute();
        } else if (command instanceof WithdrawCommand) {
            // Withdraw money from the bank account
            // additional code here for this command
            System.out.println("performing additional code here for withdraw command");
            command.execute();
        }
    }
}

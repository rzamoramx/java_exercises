package com.ivansoft.java.exercises.designpatterns.cqrs;

public interface QueryModel {
    BankAccount getBalance(String accountNumber);
}

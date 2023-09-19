package com.ivansoft.java.exercises.designpatterns.cqrs;

import java.util.HashMap;
import java.util.Map;

public class BankAccountQuery implements QueryModel {
    private Map<String, BankAccount> accounts;

    public BankAccountQuery() {
        accounts = new HashMap<>();
    }

    @Override
    public BankAccount getBalance(String accountId) {
        return accounts.get(accountId);
    }
}

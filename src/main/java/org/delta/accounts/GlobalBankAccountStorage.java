package org.delta.accounts;

import jakarta.inject.Singleton;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class GlobalBankAccountStorage {
    public List<BankAccount> bankAccounts = new LinkedList<>();
}

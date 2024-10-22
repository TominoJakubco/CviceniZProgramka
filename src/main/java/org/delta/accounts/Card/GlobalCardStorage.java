package org.delta.accounts.Card;

import jakarta.inject.Singleton;
import org.delta.accounts.BankAccount;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class GlobalCardStorage {
    public Map<String, BankAccount> BankCards = new HashMap<>();
}

package org.delta.accounts;

import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class GlobalCardStorage {
    public Map<String, BankAccount> BankCards = new HashMap<>();
}

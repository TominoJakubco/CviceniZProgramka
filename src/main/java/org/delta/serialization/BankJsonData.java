package org.delta.serialization;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

public class BankJsonData {
    private Owner owner;
    private List<BankAccount> bankAccounts;

    public BankJsonData(Owner owner, List<BankAccount> bankAccounts) {
        this.owner = owner;
        this.bankAccounts = bankAccounts;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}

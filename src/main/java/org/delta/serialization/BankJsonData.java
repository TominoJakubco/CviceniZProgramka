package org.delta.serialization;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

public class BankJsonData {
    private List<Owner> owners;
    private List<BankAccount> bankAccounts;

    public BankJsonData(List<Owner> owners, List<BankAccount> bankAccounts) {
        this.owners = owners;
        this.bankAccounts = bankAccounts;
    }

    public List<Owner> getOwners() {
        return this.owners;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}

package org.delta.serialization;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;

public class BankJsonDataFactory {
    @Inject
    private GlobalBankAccountStorage bankAccountStorage;

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    public BankJsonData createBankJsonData() {
        List<BankAccount> bankAccounts = bankAccountStorage.bankAccounts;
        List<Owner> owners = globalOwnerStorage.owners;

        return new BankJsonData(owners, bankAccounts);
    }
}


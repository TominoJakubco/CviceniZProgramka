package org.delta.serialization;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.persons.Owner;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;

public class BankJsonDataFactory {
    @Inject
    private GlobalBankAccountStorage bankAccountStorage;

    public BankJsonData createBankJsonData(Owner owner) {
        List<BankAccount> bankAccounts = new LinkedList<>();
        for(BankAccount bankAccount : bankAccountStorage.bankAccounts) {
            if(bankAccount.getOwner() == owner)
                bankAccounts.add(bankAccount);
        }
        return new BankJsonData(owner, bankAccounts);
    }
}

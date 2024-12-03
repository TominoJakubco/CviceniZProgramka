package org.delta.serialization;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;
import org.delta.storage.IO;

import java.io.IOException;

public class BankDeserializationService {
    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;


    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    private String fileName = "bank_accounts.json";

    public void runDeserialization() {
        try {
            String s = IO.readFile(fileName);
            Gson gson = new Gson();
            BankJsonData bankJsonData = gson.fromJson(s, BankJsonData.class);

            for(Owner owner : bankJsonData.getOwners()) {
                globalOwnerStorage.owners.add(owner);
            }
            for(BankAccount bankAccount : bankJsonData.getBankAccounts()) {
                globalBankAccountStorage.bankAccounts.add(bankAccount);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        };



    }
}

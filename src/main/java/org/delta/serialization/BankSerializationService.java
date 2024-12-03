package org.delta.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;
import org.delta.storage.FileStorageSystem;
import org.delta.storage.IO;

import java.io.*;

public class BankSerializationService {

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    private String fileName = "bank_accounts.json";

    public void runSerialization(BankJsonData bankJsonData) {
        Gson gson = new Gson();
        //System.out.println(bankJsonData.getBankAccounts().size());
        //System.out.println(bankJsonData.getOwner().getFullName());
        String json = gson.toJson(bankJsonData);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
            System.out.println("JSON saved to file:" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

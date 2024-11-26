package org.delta.serialization;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;

import java.io.FileWriter;
import java.io.IOException;

public class BankSerializationService {
    public void runSerialization(BankJsonData bankJsonData) {
        Gson gson = new Gson();
        //System.out.println(bankJsonData.getBankAccounts().size());
        //System.out.println(bankJsonData.getOwner().getFullName());
        String json = gson.toJson(bankJsonData);

        try (FileWriter writer = new FileWriter("bank_accounts.json")) {
            writer.write(json);
            System.out.println("JSON saved to file: bank_accounts.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

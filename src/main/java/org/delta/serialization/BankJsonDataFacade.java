package org.delta.serialization;

import jakarta.inject.Inject;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;

public class BankJsonDataFacade {
    @Inject
    private BankJsonDataFactory bankJsonDataFactory;

    @Inject
    private BankSerializationService bankSerializationService;

    @Inject
    private BankDeserializationService bankDeserializationService;

    public void createBankJsonDataFromGlobalStorages() {
            bankSerializationService.runSerialization(bankJsonDataFactory.createBankJsonData());
    }

    public void deserializeBankJsonData() {
        bankDeserializationService.runDeserialization();
    }
}


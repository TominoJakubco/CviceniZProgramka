package org.delta.serialization;

import jakarta.inject.Inject;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.GlobalOwnerStorage;
import org.delta.persons.Owner;

public class BankJsonDataFacade {
    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    @Inject
    private BankJsonDataFactory bankJsonDataFactory;

    @Inject
    private BankSerializationService bankSerializationService;

    public void createBankJsonDataFromGlobalStorages() {
        for(Owner owner : globalOwnerStorage.owners) {
            bankSerializationService.runSerialization(bankJsonDataFactory.createBankJsonData(owner));
        }
    }
}

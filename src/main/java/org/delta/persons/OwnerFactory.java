package org.delta.persons;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.accounts.*;
import org.delta.accounts.PersonIDValidator;

@Singleton
public class OwnerFactory {

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    @Inject
    private PersonIDValidator personIDValidator;

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    public Owner createOwner(String firstName, String lastname) {
        String personId = accountNumberGenerator.generateBankAccountNumber();
        if (!this.personIDValidator.isPersonIDValid((personId))) {
            throw new RuntimeException();
        }
        Owner owner = new Owner(firstName, lastname, personId);

        globalOwnerStorage.owners.add(owner);
        return owner;
    }
}

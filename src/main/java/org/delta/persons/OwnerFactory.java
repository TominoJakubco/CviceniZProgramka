package org.delta.persons;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.accounts.AccountNumberGenerator;
import org.delta.accounts.BankAccountNumberGenerator;
import org.delta.accounts.PersonIDValidator;
import org.delta.accounts.PersonIdGenerator;

@Singleton
public class OwnerFactory {

    @Inject
    private PersonIDValidator personIDValidator;

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    public Owner createOwner(String firstName, String lastname) {
        String personId = accountNumberGenerator.generateBankAccountNumber();
        if (!this.personIDValidator.isPersonIDValid((personId))) {
            throw new RuntimeException();
        }

        return new Owner(firstName, lastname, personId);
    }
}

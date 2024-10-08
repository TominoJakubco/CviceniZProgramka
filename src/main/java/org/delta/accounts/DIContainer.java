package org.delta.accounts;

import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonJsonSerializationService;

public class DIContainer {
    BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();
    PersonIdGenerator personIdGenerator = new PersonIdGenerator();
    TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator);
    //DetailPrinter accountDetailPrinter = new DetailPrinter();
    PersonIDValidator personIDValidator = new PersonIDValidator();
    OwnerFactory ownerFactory = new OwnerFactory(personIDValidator);
    BankAccountFactory bankAccountFactory = new BankAccountFactory();
    PersonJsonSerializationService personJsonSerializationService = new PersonJsonSerializationService();

    public BankAccountNumberGenerator getBankAccountNumberGenerator() {
        return bankAccountNumberGenerator;
    }

    public PersonIdGenerator getPersonIdGenerator() {
        return personIdGenerator;
    }

    public TransferFeeCalculator getTransferFeeCalculator() {
        return transferFeeCalculator;
    }

    public PersonIDValidator getPersonIDValidator() {
        return personIDValidator;
    }

    public MoneyTransferService getMoneyTransferService() {
        return moneyTransferService;
    }

    public OwnerFactory getOwnerFactory() {
        return ownerFactory;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public PersonJsonSerializationService getPersonJsonSerializationService() {
        return personJsonSerializationService;
    }
}

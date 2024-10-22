package org.delta;
import jakarta.inject.Inject;
import org.delta.accounts.*;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonJsonSerializationService;
import org.delta.print.AccountDetailPrinter;

public class App {
    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private AccountDetailPrinter accountDetailPrinter;

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private PersonJsonSerializationService personJsonSerializationService;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private AtmService atmService;

    public void run() {
        Calc calc = new Calculator();
        testBank();
    }

    private void testBank() {
        Owner owner = this.ownerFactory.createOwner("Jan", "Navrátil");
        BankAccount bankAccount = this.bankAccountFacade.createBankAccount(500, owner, true, "123");
        BankAccount bankAccount1 = this.bankAccountFacade.createBankAccount(500, owner, true);
        BankAccount bankAccount2 = this.bankAccountFacade.createStudentBankAccount(500, owner, true);

        bankAccountFacade.addBankCard(bankAccount1);

        System.out.println("owner: " + owner.getFullName() );
        System.out.println("account: " + bankAccount.getAccountNumber() + ", balance: " + bankAccount.getBalance());
        System.out.print(this.personJsonSerializationService.serializerOwner(owner));

        moneyTransferService.addMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.addMoneyToBankAccount(bankAccount, 1000);
        moneyTransferService.getMoneyFromBankAccount(bankAccount, 500);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, 100);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, -100);



        atmService.insertMoney(, 20000);
        atmService.withdrawMoney(, 100);

    }
}

package org.delta;
import jakarta.inject.Inject;
import org.delta.accounts.*;
import org.delta.accounts.Card.BankCard;
import org.delta.accounts.Card.BankCardFactory;
import org.delta.accounts.Card.GlobalCardStorage;
import org.delta.accounts.investments.Investment;
import org.delta.accounts.investments.InvestmentService;
import org.delta.accounts.saving.InterestingService;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonJsonSerializationService;
import org.delta.print.AccountDetailPrinter;
import org.delta.serialization.BankJsonDataFacade;
import org.delta.storage.IO;

public class App {
    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private PersonJsonSerializationService personJsonSerializationService;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private AtmService atmService;

    @Inject
    private InterestingService interestingService;

    @Inject
    private InvestmentService investmentService;

    @Inject
    private BankJsonDataFacade bankJsonDataFacade;

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    public void run() {
        //Calc calc = new Calculator();
        if(IO.isFileExists("bank_accounts.json")) {
            bankJsonDataFacade.deserializeBankJsonData();
            System.out.println(globalOwnerStorage.owners.size());
        }
        else
        testBank();
    }

    private void testBank() {
        Owner owner = this.ownerFactory.createOwner("Jan", "Novak");
        Owner owner1 = this.ownerFactory.createOwner("Petr", "Mareš");
        Owner owner2 = this.ownerFactory.createOwner("Pavel", "Setrmajer");
        Owner owner3 = this.ownerFactory.createOwner("Lukáš", "Martin");
        BankAccount bankAccount = this.bankAccountFacade.createBankAccount(500, owner, true, "123");
        BankAccount bankAccount1 = this.bankAccountFacade.createBankAccount(500, owner, true);
        BankAccount bankAccount2 = this.bankAccountFacade.createStudentBankAccount(500, owner, true);
        BankAccount bankAccount3 = this.bankAccountFacade.createSavingBankAccount(2000, owner, true);
        //BankAccount bankAccount4 = this.bankAccountFacade.createInvestmentBankAccount(1000, owner, true);


        BankCard card = bankAccountFacade.addBankCard(bankAccount1);

        System.out.println("owner: " + owner.getFullName() );
        System.out.println("account: " + bankAccount.getAccountNumber() + ", balance: " + bankAccount.getBalance());
        System.out.print(this.personJsonSerializationService.serializerOwner(owner));


        System.out.println("**Money Transfer Test**");
        moneyTransferService.addMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.addMoneyToBankAccount(bankAccount, 1000);
        moneyTransferService.getMoneyFromBankAccount(bankAccount, 500);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, 100);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, -100);
        System.out.println();

        System.out.println("**ATM Service Test**");
        atmService.insertMoney(card, card.getPin(), 20000);
        atmService.withdrawMoney(card, card.getPin(), 100);
        System.out.println(card.getPin());
        atmService.changePin(card, card.getPin(), "1234");
        System.out.println(card.getPin());
        System.out.println();

        System.out.println("**Interest Service Test**");
        interestingService.addInterestToAccounts();
        System.out.println();

        System.out.println("**TermAccount Test**");
//        investmentService.addInvestmentToAccount(bankAccount4, 0, new Investment("Apple", 40));
//        investmentService.addInvestmentToAccount(bankAccount4, 1, new Investment("Microsoft", 40));
//        investmentService.addInvestmentToAccount(bankAccount4, 2, new Investment("Meta", 20));
//        investmentService.addInvestmentToAccount(bankAccount4, 3, new Investment("Tominova Supr Čupr Firma", 10));
        investmentService.addInvestmentProfitToBankAccounts();


        System.out.println("**BankJsonData Test**");
        //bankJsonDataFacade.createBankJsonDataFromGlobalStorages();
        bankJsonDataFacade.deserializeBankJsonData();


    }
}

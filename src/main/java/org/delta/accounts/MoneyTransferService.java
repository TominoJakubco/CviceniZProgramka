package org.delta.accounts;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.print.AccountDetailPrinter;

@Singleton
public class MoneyTransferService {

    @Inject
    private TransferFeeCalculator transferFeeCalculator;

    @Inject
    private AccountDetailPrinter accountDetailPrinter;

    public MoneyTransferService() {
    }

    private static final double ADD_MONEY_FEE = 10;
    private static final double SECOND_LEVEL_FEE_LIMIT = 500;

    public void addMoneyToBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        if(amount > SECOND_LEVEL_FEE_LIMIT) {
            account.setBalance(currentBalance + amount - ADD_MONEY_FEE - amount/100 * 1);
        }
        else
            account.setBalance(currentBalance + amount - ADD_MONEY_FEE);
        this.printTransferDetails(account);
    }

    public void getMoneyFromBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);
        accountDetailPrinter.printDetail(account);
    }

    public void printTransferDetails(BankAccount account){
        accountDetailPrinter.printDetail(account);
    }

    public void sendMoneyToBankAccount(BankAccount reciever, BankAccount sender, double amount) {
        if(amount >= 0) {
            if(amount < sender.getBalance()) {
                sender.setBalance(sender.getBalance() - amount);
                reciever.setBalance((reciever.getBalance() + amount));
                System.out.println("account: " + sender.getAccountNumber() + ", balance: " + sender.getBalance());
            }
            else
            {
                System.out.println("broke ass nigga");
            }

        }
        else {
            System.out.println("Cannot transfer amount of 0 and less");

        }
    }

}

package org.delta.accounts;

public class MoneyTransferService {

    private final TransferFeeCalculator transferFeeCalculator;

    public MoneyTransferService(TransferFeeCalculator transferFeeCalculator /*, DetailPrinter accountDetailPrinter*/) {
        this.transferFeeCalculator = transferFeeCalculator;
        //this.accountDetailPrinter = accountDetailPrinter;
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

    public void getMoneyToBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);

        this.printTransferDetails(account);
    }

    public void printTransferDetails(BankAccount account){
        System.out.println("account: " + account.getAccountNumber() + ", balance: " + account.getBalance());
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

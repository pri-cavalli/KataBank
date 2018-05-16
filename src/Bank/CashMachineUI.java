package Bank;

import Actions.AccountMoneyIO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CashMachineUI {
    private final Scanner scanner;
    private final BankFunctionalityMapper bankFunctionalityMapper;

    public CashMachineUI() {
        this.scanner = new Scanner(System.in);
        this.bankFunctionalityMapper = BankFunctionalityMapper.getInstance();
    }

    public Integer getCommandId() {
        printCommandIdsMenu();

        Integer commandId;
        try {
            commandId = Integer.parseInt(scanner.next());
        }
        catch (Exception e) {
            printError("invalid option number. Try again next time.");
            commandId = getCommandId();
        }

        while (!bankFunctionalityMapper.commandIdIsValid(commandId)){
            printError("this number is not one of the command options. Try again next time.");
            commandId = getCommandId();
        }

        return commandId;
    }

    public BigDecimal getDepositAmount() {
        System.out.print("How much do you want to deposit? ");
        return getAmount();
    }

    public BigDecimal getWithdrawalAmount() {
        System.out.print("How much do you want to withdrawal? ");
        return getAmount();
    }

    private BigDecimal getAmount() {
        while (!scanner.hasNextBigDecimal()) {
            System.out.print("Please, input a valid amount.");
            scanner.next();
        }
        return scanner.nextBigDecimal();
    }

    public void printWelcome() {
        System.out.println("Welcome to Kata Bank!");
    }

    public void printCommandStatus(boolean wasSucceed, BankFunctionalityEnum bankFunctionalityEnum) {
        if (wasSucceed)
            printSucceed(bankFunctionalityEnum.getName());
        else
            printError(bankFunctionalityEnum.getName() + " failed.");
    }

    public void printSucceed(String succeedMessage) {
        System.out.println("Succeed: " + succeedMessage);
    }

    public void printError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void printAccountHistoric(List<AccountMoneyIO> acconuntMoneyIOs) {
        for (AccountMoneyIO acconuntMoneyIO: acconuntMoneyIOs) {
            System.out.println(acconuntMoneyIO.toString());
        }
    }

    public void printAccountBalance(BigDecimal accountBalance) {
        System.out.println("Your account balance is R$" + accountBalance + ".");
    }

    private void printCommandIdsMenu() {
        System.out.println("How can Kata Bank Help you?");
        for (BankFunctionalityEnum bankFunctionalityEnum : bankFunctionalityMapper.listAll()) {
            System.out.println(bankFunctionalityEnum.toString());
        }
        System.out.print("Please, choose the number of what you want to do: ");
    }
}

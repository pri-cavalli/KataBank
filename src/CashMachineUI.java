import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CashMachineUI {
    private Scanner scanner;

    public CashMachineUI() {
        this.scanner = new Scanner(System.in);
    }

    public Integer getCommandId() {
        printGetCommandIdStatement();

        Integer commandId;
        try {
            commandId = Integer.parseInt(scanner.next());
        }
        catch (Exception e) {
            printError("invalid option number. Try again next time.");
            commandId = getCommandId();
        }

        while (!BankFunctionality.commandIdIsValid(commandId)){
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

    public void printCommandStatus(boolean wasSucceed, BankFunctionality bankFunctionality) {
        if (wasSucceed)
            printSucceed(bankFunctionality.getName());
        else
            printError(bankFunctionality.getName() + " failed.");
    }

    public void printSucceed(String succeedMessage) {
        System.out.println("Succeed: " + succeedMessage);
    }

    public void printError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void printHistoric(List<AccountMoneyIO> acconuntMoneyIOs) {
        for (AccountMoneyIO acconuntMoneyIO: acconuntMoneyIOs) {
            System.out.println(acconuntMoneyIO.toString());
        }
    }

    private void printGetCommandIdStatement() {
        System.out.println("How can Kata Bank Help you?");
        for (BankFunctionality bankFunctionality: BankFunctionality.listAll()) {
            System.out.println(bankFunctionality.toString());
        }
        System.out.print("Please, choose the number of what you want to do: ");
    }
}

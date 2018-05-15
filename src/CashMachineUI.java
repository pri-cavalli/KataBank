import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CashMachineUI {
    private Scanner scanner;

    public CashMachineUI() {
        this.scanner = new Scanner(System.in);
    }

    public void printWelcome() {
        System.out.println("Welcome to Kata Bank!");
    }

    public Integer getCommandId(List<BankFunctionality> bankFunctionalities) {
        System.out.println("How can Kata Bank Help you?");
        for (BankFunctionality bankFunctionality: bankFunctionalities) {
            System.out.println(bankFunctionality.toString());
        }
        System.out.print("Please, choose the number of what you want to do: ");
        return Integer.parseInt(scanner.next());
    }

    public BigDecimal getDepositAmount() {
        System.out.print("How much do you want to deposit? ");
        return scanner.nextBigDecimal();
    }

    public BigDecimal getWithdrawalAmount() {
        System.out.print("How much do you want to withdrawal? ");
        return scanner.nextBigDecimal();
    }

    private BigDecimal getBigDecimal() {
        return new BigDecimal(scanner.next().replaceAll(",",""));
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
}

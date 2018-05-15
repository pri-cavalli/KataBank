import java.math.BigDecimal;
import java.util.List;

public class CashMachine {
    private final CashMachineUI cashMachineUI;
    private final Account account;

    public CashMachine() {
        cashMachineUI = new CashMachineUI();
        account = new Account();
    }
    public void start() {
        cashMachineUI.printWelcome();
        waitClientCommand();
    }

    private void waitClientCommand() {
        do {
            Integer commandId = cashMachineUI.getCommandId();
            BankFunctionality command = BankFunctionality.fromInteger(commandId);
            executeCommand(command);
        } while (true);
    }

    private void executeCommand(BankFunctionality command) {
        switch (command) {
            case DEPOSIT:
                executeDeposit();
                break;
            case WITHDRAWAL:
                executeWithdrawal();
                break;
            case DETAILS:
                executeGetDetails();
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void executeDeposit() {
        BigDecimal depositAmount = cashMachineUI.getDepositAmount();
        Deposit deposit = new Deposit(depositAmount);
        if(deposit.isAmountValid()) {
            boolean wasSucceed = deposit.execute(account);
            cashMachineUI.printCommandStatus(wasSucceed, BankFunctionality.DEPOSIT);
        }
        else {
            cashMachineUI.printError("amount invalid.");
        }
    }

    private void executeWithdrawal() {
        BigDecimal withdrawalAmount = cashMachineUI.getWithdrawalAmount();
        Withdrawal withdrawal = new Withdrawal(withdrawalAmount);
        if(withdrawal.isAmountValid()) {
            boolean wasSucceed = withdrawal.execute(account);
            cashMachineUI.printCommandStatus(wasSucceed, BankFunctionality.WITHDRAWAL);
        }
        else {
            cashMachineUI.printError("amount invalid.");
        }
    }

    private void executeGetDetails() {
        cashMachineUI.printHistoric(account.getHistoric());
    }
}

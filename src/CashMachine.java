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
        List<BankFunctionality> allPossibleCommands = BankFunctionality.listAll();
        do {
            Integer commandId = cashMachineUI.getCommandId(allPossibleCommands);
            if (commandIdIsValid(commandId)) {
                BankFunctionality command = BankFunctionality.fromInteger(commandId);
                executeCommand(command);
            }
            else {
                cashMachineUI.printError("this number is not valid.");
            }
        } while (true);
    }

    private boolean commandIdIsValid(Integer commandId) {
        return (commandId <= BankFunctionality.values().length) && (commandId >= 1);
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
        boolean wasSucceed = deposit.execute(account);
        cashMachineUI.printCommandStatus(wasSucceed, BankFunctionality.DEPOSIT);
    }

    private void executeWithdrawal() {
        BigDecimal withdrawalAmount = cashMachineUI.getWithdrawalAmount();
        Withdrawal withdrawal = new Withdrawal(withdrawalAmount);
        boolean wasSucceed = withdrawal.execute(account);
        cashMachineUI.printCommandStatus(wasSucceed, BankFunctionality.WITHDRAWAL);
    }

    private void executeGetDetails() {
        cashMachineUI.printHistoric(account.getHistoric());
    }
}

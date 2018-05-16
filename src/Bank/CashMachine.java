package Bank;

import Actions.AccountMoneyIO;
import Actions.Deposit;
import Actions.Withdrawal;

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
            BankFunctionalityEnum command = BankFunctionalityMapper.getBankFunctionalityEnumById(commandId);
            executeCommand(command);
        } while (true);
    }

    private void executeCommand(BankFunctionalityEnum command) {
        switch (command) {
            case DEPOSIT:
                executeDeposit();
                break;
            case WITHDRAWAL:
                executeWithdrawal();
                break;
            case HISTORIC:
                executeShowAccountHistoric();
                break;
            case BALANCE:
                executeShowAccountBalance();
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
        executeAccountMoneyIO(new Deposit(depositAmount));
    }

    private void executeWithdrawal() {
        BigDecimal withdrawalAmount = cashMachineUI.getWithdrawalAmount();
        executeAccountMoneyIO(new Withdrawal(withdrawalAmount));
    }

    private void executeAccountMoneyIO(AccountMoneyIO accountMoneyIO) {
        if(accountMoneyIO.isAmountValid()) {
            boolean wasSucceed = accountMoneyIO.execute(account);
            cashMachineUI.printCommandStatus(wasSucceed, accountMoneyIO.getBankFunctionalityEnum());
        }
        else {
            cashMachineUI.printError("amount invalid.");
        }

    }

    private void executeShowAccountHistoric() {
        List<AccountMoneyIO> accountHistoric = account.getHistoric();
        cashMachineUI.printAccountHistoric(accountHistoric);
    }

    private void executeShowAccountBalance() {
        BigDecimal accountBalance = account.getBalance();
        cashMachineUI.printAccountBalance(accountBalance);

    }
}

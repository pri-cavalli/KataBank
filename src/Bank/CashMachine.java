package Bank;

import Actions.Deposit;
import Actions.Withdrawal;

import java.math.BigDecimal;

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
//TODO: builder strategy
    private void executeCommand(BankFunctionalityEnum command) {
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
            cashMachineUI.printCommandStatus(wasSucceed, BankFunctionalityEnum.DEPOSIT);
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
            cashMachineUI.printCommandStatus(wasSucceed, BankFunctionalityEnum.WITHDRAWAL);
        }
        else {
            cashMachineUI.printError("amount invalid.");
        }
    }

    private void executeGetDetails() {
        cashMachineUI.printHistoric(account.getHistoric());
    }
}

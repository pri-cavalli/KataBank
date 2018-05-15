import java.math.BigDecimal;

public class Withdrawal extends AccountMoneyIO {
    public Withdrawal(BigDecimal amount) {
        super(amount);
    }

    @Override
    public boolean execute(Account account) {
        return account.withdrawal(this);
    }

    @Override
    public String toString() {
        return "Withdrawal accomplished of R$" + amount + ".";
    }
}

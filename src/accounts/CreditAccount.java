//кредитный счёт

package accounts;

public class CreditAccount extends Account {
    public CreditAccount(String name, long balance) {
        super(name, balance);
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}
import java.util.Objects;

public class BankAccount {

    private String id;
    private double balance; // must be >= 0

    public BankAccount(String some_id, double some_balance) {
        id = some_id;
        if (0 < some_balance) {
            balance = some_balance;
        } else {
            balance = 0;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * deposit funds into the account
     *
     * @param amount being deposited into the account,
     *               if not positive, no change is made
     */
    public void deposit(double amount) {
        if (0 < amount) {
            balance += amount;
        }
    }

    /**
     * withdraw funds from the account
     *
     * @param amount to withdraw,
     *               if not positive and <= balance
     *               no change is made
     */
    public void withdraw(double amount) {
        if (0 < amount && amount <= balance) {
            balance -= amount;
        }
    }
}

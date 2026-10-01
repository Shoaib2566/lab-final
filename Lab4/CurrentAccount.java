public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 2000;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (getBalance() - amount < -OVERDRAFT_LIMIT) {
            System.out.println(getAccountNumber() + ": Withdrawal denied. Overdraft limit of " + OVERDRAFT_LIMIT + " exceeded.");
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println(getAccountNumber() + ": Withdrew " + amount + ", Balance: " + getBalance());
    }
}

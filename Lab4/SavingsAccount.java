public class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (getBalance() < MIN_BALANCE) {
            System.out.println(getAccountNumber() + ": Withdrawal denied. Balance is below " + MIN_BALANCE);
            return;
        }
        if (amount > getBalance()) {
            System.out.println(getAccountNumber() + ": Withdrawal denied. Insufficient funds.");
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println(getAccountNumber() + ": Withdrew " + amount + ", Balance: " + getBalance());
    }
}

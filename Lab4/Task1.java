abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println(accountNumber + ": Deposited " + amount + ", Balance: " + balance);
    }

    public abstract void withdraw(double amount);
}

class SavingsAccount extends BankAccount {
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

class CurrentAccount extends BankAccount {
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

public class Task1 {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA-1001", 1000);
        BankAccount current = new CurrentAccount("CA-2001", 1000);

        savings.deposit(500);
        savings.withdraw(1200);
        savings.withdraw(100);

        current.deposit(500);
        current.withdraw(3000);
        current.withdraw(1000);

        System.out.println("Final Balance of " + savings.getAccountNumber() + ": " + savings.getBalance());
        System.out.println("Final Balance of " + current.getAccountNumber() + ": " + current.getBalance());
    }
}

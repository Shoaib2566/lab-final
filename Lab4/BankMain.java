public class BankMain {
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

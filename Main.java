// File: Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Greg", 1000.0);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: $" + account.getBalance());

        account.deposit(500.0);
        System.out.println("After Deposit: $" + account.getBalance());

        account.withdraw(200.0);
        System.out.println("After Withdrawal: $" + account.getBalance());

        account.withdraw(2000.0); // Should not allow
        System.out.println("After Invalid Withdrawal: $" + account.getBalance());
    }
}

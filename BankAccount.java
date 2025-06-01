// File: BankAccount.java
public class BankAccount {
    // Private data members (Encapsulation)
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter
    public double getBalance() {
        return balance;
    }

    // Public setter with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

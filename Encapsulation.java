import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BankAccount {

private final String accountNumber;
private String accountHolder;
private double balance;
private final List<String> transactionHistory = new ArrayList<>();


public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
if (accountNumber == null || accountNumber.isEmpty()) {
throw new IllegalArgumentException("Account number cannot be empty");
}
this.accountNumber = accountNumber;
setAccountHolder(accountHolder);
deposit(initialBalance);
}

public String getAccountNumber() {
return accountNumber;
}


public String getAccountHolder() {
return accountHolder;
}

public void setAccountHolder(String accountHolder) {
if (accountHolder == null || accountHolder.trim().length() < 3) {
throw new IllegalArgumentException("Account holder name must be at least 3 characters long");
}
this.accountHolder = accountHolder;
transactionHistory.add("Account holder updated to: " + accountHolder);
}


public double getBalance() {
return balance;
}

public void deposit(double amount) {
if (amount <= 0) {
throw new IllegalArgumentException("Deposit must be positive");
}
balance += amount;
transactionHistory.add("Deposited: " + amount);
}

public void withdraw(double amount) {
if (amount <= 0) {
throw new IllegalArgumentException("Withdrawal must be positive");
}
if (amount > balance) {
throw new IllegalArgumentException("Insufficient balance");
}
balance -= amount;
transactionHistory.add("Withdrawn: " + amount);
}


public List<String> getTransactionHistory() {
return Collections.unmodifiableList(transactionHistory);
}
}

public class Encapsulation {
public static void main(String[] args) {

BankAccount acc = new BankAccount("ACC12345", "Aman Sharma", 20000);

acc.deposit(1500);
acc.withdraw(2000);
acc.setAccountHolder("Aman Sharma");

System.out.println("Account Number: " + acc.getAccountNumber());
System.out.println("Holder: " + acc.getAccountHolder());
System.out.println("Balance: " + acc.getBalance());
System.out.println("Transactions: " + acc.getTransactionHistory());
}
}
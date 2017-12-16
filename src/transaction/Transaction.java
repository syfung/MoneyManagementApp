package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class Transaction {
	
	Account fromAccount;
	Account toAccount;
	double amount;
	String message;
	ZonedDateTime createdDateTime;
	ZonedDateTime transactDateTime;
	
	public TransactionType getTransactionType();
	public boolean isExternal();
	public double getAmount();
	public String getName();
	public Account getFromAccount();
	public Account getToAccount();
	public ZonedDateTime getCreatedDateTime();
	public ZonedDateTime getTransactDateTime();
}

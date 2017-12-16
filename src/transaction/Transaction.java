package transaction;

import java.time.ZonedDateTime;

import account.Account;

public interface Transaction {
	public TransactionType getTransactionType();
	public boolean isExternal();
	public double getAmount();
	public String getName();
	public Account getToFromAccount();
	public ZonedDateTime getCreatedDateTime();
	public ZonedDateTime getTransactonDateTime();
}

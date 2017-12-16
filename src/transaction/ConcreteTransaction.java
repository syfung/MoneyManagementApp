package transaction;

import java.time.ZonedDateTime;

import account.Account;
import account.AccountType;

public class ConcreteTransaction implements Transaction {
	String transactionName;
	double amount;
	TransactionType transactionType;
	Account toFromAccount;

	ZonedDateTime createdDateTime;
	ZonedDateTime transactTime;

	/**
	 * @param transactionName
	 * @param amount
	 * @param transactionType
	 * @param toFromAccount
	 * @param createdDateTime
	 * @param transactTime
	 */
	public ConcreteTransaction(String transactionName, double amount, TransactionType transactionType,
			Account toFromAccount, ZonedDateTime createdDateTime, ZonedDateTime transactTime) {
		super();
		this.transactionName = transactionName;
		this.amount = amount;
		this.transactionType = transactionType;
		this.toFromAccount = toFromAccount;
		this.createdDateTime = createdDateTime;
		this.transactTime = transactTime;
	}

	@Override
	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	@Override
	public double getAmount() {
		return this.amount;
	}

	@Override
	public String getName() {
		return this.transactionName;
	}

	@Override
	public Account getToFromAccount() {
		return this.toFromAccount;
	}

	@Override
	public ZonedDateTime getCreatedDateTime() {
		return this.createdDateTime;
	}

	@Override
	public ZonedDateTime getTransactDateTime() {
		return this.transactTime;
	}

	@Override
	public boolean isExternal() {
		if (this.toFromAccount.getAccountType().equals(AccountType.EXTERNAL)) {
			return true;
		}
		return false;
	}

}

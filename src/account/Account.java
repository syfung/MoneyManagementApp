package account;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import transaction.CatchUpTransaction;
import transaction.Transaction;
import transaction.TransactionType;
import transactionhistory.TransactionHistory;

public class Account {
	private String accountName;
	private long accountNum;
	private AccountHolder accountHolder;
	private double balance;
	private AccountType accountType;
	
	private ArrayList<TransactionHistory> transactionHistories;

	/**
	 * @param accountName
	 * @param accountHolder
	 * @param balance
	 */
	public Account(String accountName, AccountHolder accountHolder, double amount) {
		super();
		this.accountName = accountName;
		this.accountHolder = accountHolder;
		this.balance = amount;

		this.transactionHistories = new ArrayList<TransactionHistory>();
		this.accountType = AccountType.CASH;
	}

	/**
	 * @return account name
	 */
	public String getAccountName() {
		return this.accountName;
	}
	
	/**
	 * @return account type
	 */
	public AccountType getAccountType() {
		return this.accountType;
	}

	/**
	 * @return account holder
	 */
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	
	/**
	 * @return balance
	 */
	public double getAccountAmount() {
		return this.balance;
	}
//
//	protected void addTransaction(Transaction t) {
//		this.transactions.add(t);
//		if (t.getTransactionType().equals(TransactionType.DEPOSIT)) {
//			this.updateAmount(this.balance += t.getAmount());
//		} else if (t.getTransactionType().equals(TransactionType.WITHDRAW)) {
//			this.updateAmount(this.balance -= t.getAmount());
//		}
//	}
//
//	protected void catchupAmount(double amount) {
//		if (this.balance != amount) {
//			Transaction t = new CatchUpTransaction(amount - this.balance, ZonedDateTime.now());
//			this.transactions.add(t);
//			this.balance = amount;
//		}
//	}
//
//	protected void setType(AccountType t) {
//		this.accountType = t;
//	}
//
//	protected ArrayList<Transaction> getTransactions() {
//		return this.transactions;
//	}
//
//	private void updateAmount(double amount) {
//		this.balance = amount;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountHolder=" + accountHolder + ", balance=" + balance
				+ ", transactionHistories=" + transactionHistories + ", accountType=" + accountType + "]";
	}
}
